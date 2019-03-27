<template>
  <div id="goodDetail">
    <hr/>
      <body>
          <section class="detail-left">
              <img class="product-image" :src=product.imageUrl @click="jump2GoodDetail(product.id)"/>
          </section>
          <section class="detail-right">
              <div class="product-goodName">{{product.goodName}}</div>              
              <div class="product-goodDescription">{{product.goodDesc}}</div>    
              <div class="detail-body">                  
                  <div class="product-goodPrice">
                      <label>价格</label>
                      ￥{{product.currentPrice}}
                      <del class="product-historyPrice">{{product.historyPrice}}</del>
                    </div>
                  <div class="product-goodQuan"><label>领券</label></div>
                  <div class="product-goodScore"><label>积分</label><label>购买最高得{{product.currentPrice}}积分</label></div>
                  <div class="product-goodNum"><label>库存</label>{{product.goodNum}}件</div>
                  <div class="product-saledNum"><label>已售</label>{{product.saledNum}}件</div>
                  <div class="product-saledNum"><label>发至</label><input v-model="address" /></div>
              </div>          
              
             
              <button class="product-goodCart" onClick="addProduct2Cart">加入购物车</button>
              <button class="product-favorte">收藏</button>
          </section>
          
              
      </body>
      <!-- {{product}}     -->
      
  </div>
</template>

<script>
export default {
  name: "goodDetail",
  mounted: function() {
    this.product = this.$route.query.product;
  },
  data() {
    return {
      productId: "",
      product: "",

      address:""
    };
  },
  methods: {
    jump2Home: function() {
      this.$router.push({ path: "/" });
      this.view = true;
    }
  }
};
</script>

<style lang="less" scoped>
@header-height: 40px;
@two-level-color: rgb(51, 51, 51);
@front-color: rgb(179, 175, 175);
@background-color: rgb(51, 51, 51);
@body-color: rgb(86, 91, 110);
@detail-background-color: rgb(237, 238, 220);
body {
//   border: 1px solid rgb(146, 28, 28);
  position: absolute;

  .detail-left {
    // border: 1px solid rgb(148, 148, 148);

    float: left;
    height: 400px;
    width: 400px;
    .product-image {
      // border: 1px solid rgb(148, 148, 148);
      height: 400px;
      width: 400px;
    }
  }
  .detail-right {
    // border: 1px solid rgb(124, 26, 95);
    float: left;
    padding-left: 30px;
    height: 500px;
    width: 500px;
    .product-goodName {
      font-size: 20px;
      font-weight: bold;
      color: @two-level-color;
    }
    .product-goodDescription {
      margin-top: 8px;
      font-size: 15px;
      color: @front-color;
    }
    .detail-body {
      margin: 20px 0 10px;
      width:450px;
      padding: 20px 15px 20px;
      background-color: @detail-background-color;
      div{
          margin: 8px 0 8px;
      }
      label {
        font-size: 13px;
        color: @front-color;
        margin-right: 20px;
      }
      .product-goodPrice {
        font-size: 25px;
        color: rgba(223, 11, 11, 0.87);
        .product-historyPrice {
          font-size: 13px;
          color: @front-color;
          margin-right: 20px;
        }
      }
    }
    .product-goodCart {
      border: none;
      height: 35px;
      width: 115px;
      background-color: rgb(180, 160, 120);
      color: white;
      font-size: 15px;
      border-radius: 3px; //圆角程度
      margin:20px;
    }
    .product-favorte {
      outline: none;
      border: none;
      background: none;
      color: rgb(143, 53, 53);
      font-size: 13px;
    }
    .product-favorte:hover {
      color: rgb(48, 7, 7);
    }
  }
}
</style>

