package cn.itsource.pwc.service;

import cn.itsource.basic.util.PageList;
import cn.itsource.pwc.domain.Brand;
import cn.itsource.pwc.query.BrandQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author derrick
 * @since 2019-07-30
 */
public interface IBrandService extends IService<Brand> {
    //分页查询
    PageList<Brand> queryPage(BrandQuery query);
}
