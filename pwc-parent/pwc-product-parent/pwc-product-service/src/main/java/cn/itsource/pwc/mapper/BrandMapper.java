package cn.itsource.pwc.mapper;

import cn.itsource.pwc.domain.Brand;
import cn.itsource.pwc.query.BrandQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author derrick
 * @since 2019-07-30
 */
public interface BrandMapper extends BaseMapper<Brand> {
    //分页条件查询
    IPage<Brand> queryPage(Page page, @Param("query")BrandQuery query);
}
