package cn.itsource.pwc.service.impl;

import cn.itsource.pwc.domain.ProductType;
import cn.itsource.pwc.mapper.ProductTypeMapper;
import cn.itsource.pwc.service.IProductTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author derrick
 * @since 2019-07-30
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Override
    public List<ProductType> loadTypeTree() {
        //return recursive(0L);
        return cercle();
    }

    //先查詢到所有的商品類型，準備一個list裝最大的那個分類，準備map裝所有的類型，key-》id，value-》類型對象
    //第一個循環就是把所有的商品類型都裝到map中去，id和類型一一對應，第二個循環，先找一級菜單，然後把他裝到list
    //裡面去，如果不是一級菜單，先找到這個商品類型的pid，再在map中根據pid找到這個商品類型,然後再找到這個商品類型的
    //子級,然後再把這個商品類型加進去
    private List<ProductType> cercle() {
        List<ProductType> productTypes = baseMapper.selectList(null);
        List<ProductType> list = new ArrayList<>();
        Map<Long,ProductType> map = new HashMap<>();
        for (ProductType type : productTypes) {
            map.put(type.getId(),type);
        }
        for (ProductType productType : productTypes) {
            if(productType.getId()==0){
                list.add(productType);
            }else {

                ProductType pc = map.get(productType.getPid());
                pc.getChildren().add(productType);
            }
        }
        return list;
    }

    //遞歸方式，性能很低，要发送多次sql
    private List<ProductType> recursive(Long id) {
        List<ProductType> parents = baseMapper.selectList(new QueryWrapper<ProductType>().eq("pid",id));
        for (ProductType parent : parents) {
            List<ProductType> children = recursive(parent.getId());
            if(!children.isEmpty()){
                parent.setChildren(children);
            }
        }
        return parents;
    }
}
