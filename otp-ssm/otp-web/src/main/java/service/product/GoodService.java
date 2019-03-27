package service.product;

import controller.dto.base.ResponseDTO;
import dao.product.entity.GoodCategoryDTO;
import dao.product.dao.GoodDao;
import dao.product.entity.GoodDetailDTO;
import errorcode.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: jingtiancai
 * @date: 2018/11/11 15:32
 * @desc:
 */
@Service
public class GoodService {
    @Autowired
    private GoodDao goodDao;

    /**
     * 添加商品分类
     */
    public  ResponseDTO addGoodCategory(GoodCategoryDTO goodCategoryDTO) {
        try{
            goodCategoryDTO.setCreateTime(new Date());
            if (1 != goodDao.addGoodCategory(goodCategoryDTO.getCategoryName())) {
                return ResponseDTO.fail(ErrorCode.GOOD_CATEGORY_ADD_FAILED.ec());
            }
            return ResponseDTO.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.GOOD_CATEGORY_ADD_FAILED.ec().append(e.getCause().getMessage()));
        }
    }

    /**
     * 获取商品分类
     */
    public  ResponseDTO getGoodCategories() {
        try{
            List<GoodCategoryDTO> resultList=goodDao.getGoodCategories();
            return ResponseDTO.success(resultList);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.GOOD_CATEGORY_QUERY_FAILED.ec());
        }
    }
    /**
     * 添加商品
     */
    public ResponseDTO addGood(GoodDetailDTO goodDetailDTO){
        try{
            if (1 != goodDao.addGood(goodDetailDTO)) {
                return ResponseDTO.fail(ErrorCode.GOOD_DETAIL_ADD_FAILED.ec());
            }
            return ResponseDTO.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.GOOD_DETAIL_ADD_FAILED.ec().append(e.getCause().getMessage()));
        }
    }

    /**
     * 获取商品详情列表
     */
    public  ResponseDTO getGoods() {
        try{
            List<GoodDetailDTO> resultList=goodDao.getGoods();
            return ResponseDTO.success(resultList);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.GOOD_QUERY_FAILED.ec());
        }
    }
    /**
     * 根据关键词获取商品
     */
    public  ResponseDTO getGoodsByKeyWords(String keyWords) {
        try{
            List<GoodDetailDTO> resultList=goodDao.getGoodsByKeyWords( keyWords);
            return ResponseDTO.success(resultList);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.fail(ErrorCode.GOOD_QUERY_FAILED.ec());
        }
    }

}
