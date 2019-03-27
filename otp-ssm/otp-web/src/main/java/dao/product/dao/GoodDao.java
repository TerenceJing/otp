package dao.product.dao;

import dao.product.entity.GoodCategoryDTO;
import dao.product.entity.GoodDetailDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodDao {
    /**
     * 添加商品分类
     */
    int addGoodCategory(@Param("categoryName") String categoryName);

    /**
     * 获取商品分类
     * @return
     */
    List<GoodCategoryDTO> getGoodCategories();

    /**
     * 添加商品
     */
    int addGood(GoodDetailDTO goodDetailDTO);

    /**
     * 获取商品分类
     */
    List<GoodDetailDTO> getGoods();

    /**
     * 通过关键词查询商品
     * @param keyWords
     * @return
     */
    List<GoodDetailDTO> getGoodsByKeyWords(@Param("keyWords") String keyWords);
}
