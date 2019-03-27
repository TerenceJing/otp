<template>
  <div id="goodList">    
    <body class="body-center-search">
          <div class="search-description">
            <div class="search-description-type">
              <label>分类：</label>
              <label v-for="(item) in typeList" v-bind:key="item" class="search-text"><label>{{item}}&nbsp;&nbsp;</label></label>
            </div>            
            <div class="search-description-type">
                价格：&nbsp;<input class="price-input"/> - <input class="price-input"/>￥
            </div>
          </div>
          <div v-for="(item) in productList" v-bind:key="item">
            <section class="product-container" v-bind:goodId=item.id >
              <img class="product-image" :src="item.imageUrl"
              @click="jump2GoodDetail(item)"
              />
              <label class="product-goodName">{{item.goodName}}</label><br/>
              <label class="product-goodPrice">￥{{item.currentPrice}}</label>
              <br/>
              <button class="product-goodCart" @click="addProduct2Cart(item)" >加入购物车</button>
              <button class="product-favorte">收藏</button>
           </section> 
           </div>   
    </body>
  </div>
</template>

<script>
import { GET } from "@request/base/requestUtils.js";
import { productUrls } from "@request/base/urlDef.js";

export default {
  name: "goodList",
  created: function() {},
  mounted: function() {
    //1:接受参数
    this.keywords = this.$route.query.keywords;
    //2：利用参数获取商品
    if(this.keywords===null||this.keywords===""){
      GET(
      productUrls.getProductsUrl,
      function(result) {
        this.productList = result.data;
      }.bind(this),
      function(result) {
        if (result.code != null) {
          alert(result.msg);
        } else {
          alert(result);
        }
      }
    );

    }
    //3：获取产品类型列表
    for (var i = 0; i < this.productList.length; i++) {
      var flag = false;
      for (var j = 0; j < this.typeList.length; j++) {
        if (this.typeList[j] == this.productList[i].type)
          //如果要求数据类型也一致，这里可使用恒等号===
          flag = true;
      }
      if (flag == false) {
        this.typeList.push(this.productList[i].type);
      }
    }
  },
  data() {
    return {
      keywords: "",
      goodId: 1,
      typeList: [],
      productList: [
        
      ]
    };
  },
  methods: {
    jump2GoodDetail: function(item) {
      debugger;
      this.$router.push({
        path: "/home/good-detail",
        query: {
          product: item
        }
      });
    },
    addProduct2Cart: function(item) {
      //1:判断是否登陆，没有登陆则跳到登陆页面
      if (this.global.userInfo.id === "" || this.global.userInfo.id === null) {
        this.$router.push("/login");
      }
      //2:否则加入购入车
      //TODO
    }
  }
};
</script>

<style lang="less" scoped>
@header-height: 40px;
@front-color: rgb(204, 204, 204);
@background-color: rgb(51, 51, 51);
@body-color: rgb(86, 91, 110);
@two-level-color: rgb(97, 85, 85);

//中间搜索框
.body-center-search {
  // position: absolute;
  // width:1250px;
  margin: 15px 0 100px;
  // border: 1px solid rgb(148, 148, 148);
  .search-description {
    font-size: 15px;
    color: rgb(119, 114, 119);
    .search-description-type {
      height: 30px;
      margin-top: 10px;
      vertical-align: 30px;
      border-bottom: 1px dashed rgb(156, 151, 151);
      .search-text {
        color: rgb(41, 39, 41);
      }
      .price-input {
        width: 50px;
      }
    }
  }
  .product-container {
    // border: 1px solid rgb(158, 51, 51);
    margin: 10px 20px;
    float: left;
    // display:block;
    width: 200px;
    height: 300px;
    text-align: center;
    .product-image {
      // border: 1px solid rgb(26, 13, 13);
      width: 200px;
      height: 200px;
    }
    .product-goodName {
      font-weight: bold;
      font-size: 12px;
      // border: 1px solid rgb(26, 13, 13);
    }
    .product-goodPrice {
      font-size: 20px;
      color: red;
      // border: 1px solid rgb(26, 13, 13);
    }
    .product-goodCart {
      border: none;
      height: 25px;
      width: 80px;
      background-color: rgb(180, 160, 120);
      color: white;
      font-size: 13px;
      border-radius: 3px; //圆角程度
      margin-left: 20%;
    }
    .product-favorte {
      outline: none;
      border: none;
      background: none;
      color: rgb(143, 53, 53);
      font-size: 11px;
      // border: 1px solid rgb(26, 13, 13);
    }
    .product-favorte:hover {
      color: rgb(48, 7, 7);
    }
  }
}
</style>

