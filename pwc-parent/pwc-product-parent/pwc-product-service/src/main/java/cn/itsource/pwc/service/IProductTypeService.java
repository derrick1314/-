package cn.itsource.pwc.service;

import cn.itsource.pwc.domain.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author derrick
 * @since 2019-07-30
 */
public interface IProductTypeService extends IService<ProductType> {

    //商品類型的樹形菜單
    List<ProductType> loadTypeTree();
}
