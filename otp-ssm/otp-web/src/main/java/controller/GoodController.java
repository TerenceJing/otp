package controller;

import controller.dto.base.ResponseDTO;
import dao.product.entity.GoodCategoryDTO;
import dao.product.entity.GoodDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.product.GoodService;

import java.util.List;

/**
 * @desc: 商品业务控制类
 */
@Controller
@RequestMapping(ApiPathDef.GOOD)
public class GoodController {
    @Autowired
    private GoodService goodService;

    /**
     * 添加商品类别
     */
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO addGoodCategory(@RequestBody GoodCategoryDTO goodCategoryDTO) {

        return goodService.addGoodCategory(goodCategoryDTO);
    }
    /**
     * 获取商品类别
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public @ResponseBody  ResponseDTO getGoodCategories() {
        return goodService.getGoodCategories();
    }

    /**
     * 添加商品
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO addGood(@RequestBody GoodDetailDTO goodDetailDTO) {

        return goodService.addGood(goodDetailDTO);
    }
    /**
     * 获取商品类别
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody  ResponseDTO<List<GoodDetailDTO>> getGoods() {
        return goodService.getGoods();
    }

    /**
     * 根据关键词搜索商品
     */
    @RequestMapping(value = "/{keyWords}", method = RequestMethod.GET)
    public @ResponseBody  ResponseDTO<List<GoodDetailDTO>> getGoodsByKeyWords(@PathVariable("keyWords") String keyWords) {
        return goodService.getGoodsByKeyWords(keyWords);
    }

}
