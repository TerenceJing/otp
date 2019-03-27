<template>
<div id="uhome">
  <section id="top" >
    <button @click="jump2home">首页</button>
     > 
     <label class="navigateLabel">{{navigateLabel}}</label>
  </section>
  <section id="body-left">
    <label>账号管理</label>
    <button @click="personOnClick">{{userMenu[0]}}</button>
    <br>
    <button @click="userOnClick">{{userMenu[1]}}</button>
    <br>
    <button @click="addressOnClick">{{userMenu[2]}}</button>
    <br>
    <button @click="safeOnClick">{{userMenu[3]}}</button>
    <br>
    <button @click="collectOnClick">{{userMenu[4]}}</button>
    <br>
    <label>交易管理</label>
    <button @click="orderOnClick">{{trideMenu[0]}}</button>
    <br>
    <button @click="redPacketOnClick">{{trideMenu[1]}}</button>
    <br>
    <button @click="couponOnClick">{{trideMenu[2]}}</button>
    <br>
    <button @click="presentOnClick">{{trideMenu[3]}}</button>
    <br>
    <label>服务中心</label>
    <button @click="serviceOnClick">{{serviceMenu[0]}}</button>
    <br>
    <button @click="priviceOnClick">{{serviceMenu[1]}}</button>
    <br>
    <button @click="helpOnClick">{{serviceMenu[2]}}</button>
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
      userMenu: ["个人中心", "账号信息", "地址管理", "账号安全", "我的收藏"],
      trideMenu: ["订单管理", "我的红包", "优惠券", "礼品卡"],
      serviceMenu: ["售后记录", "价格保护", "帮助中心"],
      navigateLabel: "个人中心",

      userInfo:""
    };
  },
  methods: {
    jump2home: function() {
      this.$router.push({
        path: "/home"
      });
    },
    personOnClick: function() {
      debugger;
      this.navigateLabel = this.userMenu[0];
      this.$router.push({
        path: "/uhome/person-info"
      });
    },
    userOnClick: function() {
      this.navigateLabel = this.userMenu[1];
      this.$router.push({
        path: "/uhome/user-info"
      });
    },
    addressOnClick: function() {
      this.navigateLabel = this.userMenu[2];
      this.$router.push({
        path: "/uhome/address-info"
      });
    },
    safeOnClick: function() {
      this.navigateLabel = this.userMenu[3];
      this.$router.push({
        path: "/uhome/safe-info"
      });
    },
    collectOnClick: function() {
      this.navigateLabel = this.userMenu[4];
    },
    orderOnClick: function() {
      this.navigateLabel = this.trideMenu[0];
    },
    redPacketOnClick: function() {
      this.navigateLabel = this.trideMenu[1];
    },
    couponOnClick: function() {
      this.navigateLabel = this.trideMenu[2];
    },
    presentOnClick: function() {
      this.navigateLabel = this.trideMenu[3];
    },
    serviceOnClick: function() {
      this.navigateLabel = this.serviceMenu[0];
    },
    priviceOnClick: function() {
      this.navigateLabel = this.serviceMenu[1];
    },
    helpOnClick: function() {
      this.navigateLabel = this.serviceMenu[2];
    }
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