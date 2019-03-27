<template>
<div>
  <header>
      <label id="header-left">好生活！&nbsp;&nbsp;好气质！</label>
      <span id="header-right">
        <button type="button" @click="jump2Home">首页</button>
        <span class="left-line"></span>
        
        <button v-if=this.global.userShow type="button" @click="jump2SUerInfo">{{this.global.userInfo.userName}}</button>

        <button v-if=!this.global.userShow type="button" @click="jump2Login">登录</button>
        <button v-if=!this.global.userShow @click="jump2Register">注册</button>
        <!-- <button type="button" @click="jump2Login">小王</button> -->
        <span class="left-line"></span>
        <button >购物车</button>
        <span class="left-line"></span>
        <button >我的订单</button>
        <span class="left-line"></span>
        <button >客户服务</button>
        <span class="left-line"></span>
        <button >手机App</button>
      </span>
      </header>
      <div class="body">
        <router-view/>
      </div>

    


    <div class="footer">
      <button @click="jump2Admin">管理员登录</button>      
      <hr width=80% style="border:0.5px dashed rgb(83,83,83)">
      <div class="footer-bottom">        
        <button>关于我们</button>
        <span/>
        <button>帮助中心</button>
        <span/>
        <button>客户服务</button>
        <span/>
        <button>售后服务</button>
        <span/>
        <button>开放平台</button>
        <span/>
        <button>友情链接</button>
        <div>
          王洋 版权所有@2018-2023
          &nbsp;
          经营许可证：wy163010085696209
          &nbsp;
          单用途商业预付卡备案证：330100AACCJ024
          &nbsp;
          地址：浙江省杭州市临安区杭州电子科技大学信息工程学院
        </div>
      </div>      
    </div>
    </div>
    
  <!-- </div> -->
</template>

<script>

export default {
  name: "app",

  mounted: function() {
    if (this.$route.query.userInfo != null) {
      this.global.userInfo=this.$route.query.userInfo;
      this.global.userShow=true;
      this.$router.push({ path: "/" });
    }
  },
  data() {
    return {
      userInfo: this.global.userInfo,
      userShow: this.global.userShow
    };
  },
  methods: {
    jump2Home: function() {
      this.$router.push({ path: "/" });
    },
    jump2Login: function() {
      this.view = false;
      this.$router.push({ path: "/login" });
    },
    jump2Register: function() {
      // this.$router.push({path:'/register'});
      this.$router.push({
        path: "/register"
      });
    },
    jump2SUerInfo: function() {
      this.$router.push({
        path: "/uhome/person-info",
      });
    },
    jump2Admin:function(){
      this.$router.push({
        path: "/admin",
      });
    }
  }
};
</script>

<style lang="less" scoped>
@header-height: 34px;
@front-color: rgb(204, 204, 204);
@background-color: rgb(51, 51, 51);
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
}
header {
  background-color: @background-color;
  height: @header-height;
  line-height: @header-height;
  position: fixed;
  width: 100%;
  top: 0px;
  left: 0px;
  color: @front-color;
  font-size: 12px;
  #header-left {
    margin-left: 15%;
    width: 100px;
  }
  #header-right {
    display: inline-block;
    float: right;
    height: @header-height;
    margin-right: 20%;
    // border: 2px chocolate solid;
  }
  button {
    outline: none;
    background: none;
    border: none;
    color: @front-color;
  }
  button:hover {
    color: white;
  }
  .left-line {
    border-left: 1px solid rgb(148, 148, 148);
  }
}

.body {
}

@footer-height: 80px;
@footer-color: rgb(158, 157, 157);
.footer {
  background-color: @background-color;
  height: @footer-height;
  width: 100%;
  position: fixed;
  bottom: 0;
  left: 0;
  color: @footer-color;
  font-size: 12px;
  text-align: center;
  // border: 2px chocolate solid;
  button {
    outline: none;
    background: none;
    border: none;
    color: @footer-color;
    margin-top: 5px;
    text-align: center;
    width: 80px;
  }
  button:hover {
    color: white;
  }
  .footer-bottom {
    span {
      border-left: 1px solid rgb(148, 148, 148);
    }
  }
}
</style>

