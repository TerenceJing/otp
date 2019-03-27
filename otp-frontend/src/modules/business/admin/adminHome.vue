<template>
<div id="uhome">
  <section id="top" >
    <button @click="jump2home">商城首页</button>
     > 
     <label class="navigateLabel">{{navigateLabel}}</label>
  </section>
  <section id="body-left">
    <label>商品管理</label>
    <button @click="categoryOnClick">{{productMenu[0]}}</button>
    <br>
    <button @click="productOnClick">{{productMenu[1]}}</button>
    <br>
    <label>交易管理</label>
    <button @click="orderOnClick">{{trideMenu[0]}}</button>
    <br>
    <button @click="orderStatisticsOnClick">{{trideMenu[1]}}</button>
    <br>
    <label>会员中心</label>
    <button @click="userOnClick">{{userMenu[0]}}</button>
    <br>
    <button @click="userStatisticsOnClick">{{userMenu[1]}}</button>
    <br>
  </section>
  <section id="body-right">
    <router-view>    </router-view>
  </section>
  
</div>
</template>

<script>
import "@style/base.less";

export default {
  name: "uhome",
  mounted: function() {
    debugger;
    if (this.$route.query.userInfo != null) {
      this.userInfo = this.$route.query.userInfo;
    }
  },

  data() {
    return {
      productMenu: ["商品分类", "商品信息"],
      trideMenu: ["订单管理", "交易统计"],
      userMenu: ["会员管理", "会员统计", ],
      navigateLabel: "商品分类",
      productList:null,
      userList:null,
    };
  },
  methods: {
    jump2home: function() {
      this.$router.push({
        path: "/home"
      });
    },
    categoryOnClick: function() {
      this.navigateLabel = this.productMenu[0];
      this.$router.push({
        path: "/admin/category"
      });
    },
    productOnClick: function() {
      this.navigateLabel = this.productMenu[1];
      this.$router.push({
        path: "/admin/product"
      });
    },

    orderOnClick: function() {
      this.navigateLabel = this.trideMenu[0];
    },
    orderStatisticsOnClick: function() {
      this.navigateLabel = this.trideMenu[1];
    },
    userOnClick: function() {
      this.navigateLabel = this.userMenu[0];
    },
    userStatisticsOnClick: function() {
      this.navigateLabel = this.userMenu[1];
    },
  }
};
</script>


<style scope lang="less">
@header-height: 34px;
@body-left-width: 110px;
@two-level-color: rgb(51, 51, 51);
@three-level-color: rgb(102, 102, 102);
@mouse-hover-color: rgb(180, 160, 120);
#uhome {
  // position: absolute;
  margin-top: @header-height+30px;
  margin-left: 15%;
  margin-right: 20%;
  // border: 1px solid rgb(234, 234, 234);
  height: 100%;
  #top {
    // border: 1px solid rgb(234, 234, 234);
    font-size: 14px;
    button {
      //无色按钮
      border: none;
      background: none;
      color: @two-level-color;
      font-size: 15px;
      padding-bottom: 0px;
    }
    button:hover {
      color: @mouse-hover-color;
    }
    .navigateLabel {
      color: rgb(153, 153, 153);
    }
  }
  #body-left {
    float: left;
    margin-top: 15px;
    width: @body-left-width;
    border: 1px solid rgb(234, 234, 234);
    @content-width: 80px;
    padding-left: 35px;
    height: 720px;
    label {
      // border: 1px solid rgb(234, 234, 234);
      display: block;
      margin-top: 30px;
      width: @content-width;
      color: @two-level-color;
      font-size: 16px;
      font-weight: bold;
      text-align: left;
    }
    button {
      // border: 1px solid rgb(234, 234, 234);
      border: none;
      width: @content-width;
      background-color: rgb(255, 255, 255);
      color: @three-level-color;
      margin: 10px 0 5px 0;
      padding-left: 0;
      text-align: left;
      font-size: 14px;
      outline: none;
    }
    button:hover {
      color: @mouse-hover-color;
      border: none;
    }
    button:click {
      border: none;
    }
  }
  #body-right {
    // border: 1px solid red;
    margin-top: 15px;
    margin-left: 60px + @body-left-width;
    height: 720px;
  }
}
</style>