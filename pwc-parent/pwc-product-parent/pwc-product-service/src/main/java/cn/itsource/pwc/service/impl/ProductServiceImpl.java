package cn.itsource.pwc.service.impl;

import cn.itsource.pwc.domain.Product;
import cn.itsource.pwc.mapper.ProductMapper;
import cn.itsource.pwc.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author derrick
 * @since 2019-07-30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
