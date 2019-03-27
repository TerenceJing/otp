<template>
<div id="person">
  <section id="top">
    <div id="left">
      <img v-if="this.global.userInfo.imageData===null||this.global.userInfo.imageData===''" 
      src="@img/userPG.jpg"
      />
      <img v-if="this.global.userInfo.imageData!=null&&this.global.userInfo.imageData!=''" 
      :src=this.global.userInfo.imageData
      @click="jump2userOnClick"
      />
      <br>
      <button @click="jump2userOnClick">{{userInfo.userName}}</button>
    </div>
    <div id="right">
      <button >我的红包：{{user.redPackage}} ￥</button>      
      <button >我的优惠券：{{user.coupon}} 个</button>
      <br>
      <button >我的积分：{{user.cord}} 分</button>
      <br>
      <button >我的礼品卡：{{user.presentNumber}} 张</button>
      <br>
    </div>
  </section>
  <section id="bottom">
    <header>
      订单
      <button>更多订单 >> </button>
    </header>
    <body>
      
    </body>

  </section>

</div>
</template>
<script>
export default {
  name: "person",
  data() {
    return {
      userInfo: this.global.userInfo,
      user: {
        userName: "LiMing",
        redPackage: 560000,
        coupon: 3,
        cord: 23,
        presentNumber: 4
      }
    };
  },
  methods: {
    jump2userOnClick: function() {
      this.$router.push({ path: "/uhome/user-info" });
    }
  }
};
</script>


<style lang="less" scoped>
@two-level-color: rgb(51, 51, 51);
@three-level-color: rgb(102, 102, 102);
@div-background-color: rgb(244, 244, 244);
@border-color: rgb(234, 234, 234);
@mouse-hover-color: rgb(180, 160, 120);

#person {
  // border: 1px solid red;
  #top {
    border: 1px solid @border-color;
    height: 200px;
    #left {
      float: left;
      margin: 10px 20px;
      border-right: 1px dashed @border-color;
      width: 200px;
      height: 180px;
      img {
        width: 160px;
        height: 150px;
      }
      .userName-container {
        margin-left: 30%;
        color: @three-level-color;
      }
      button {
        //无色按钮
        border: none;
        background: none;
        outline: none;
        text-align: left;
        color: @three-level-color;
        font-size: 15px;
        padding-left: 0px;
        margin: 10px 50px;
      }
      button:hover {
        color: @mouse-hover-color;
      }
    }
    #right {
      margin: 20px 20px;
      button {
        //无色按钮
        border: none;
        background: none;
        outline: none;
        width: 190px;
        text-align: left;
        color: @three-level-color;
        font-size: 15px;
        padding-left: 0px;
        margin: 15px 10px;
      }
      button:hover {
        color: @mouse-hover-color;
      }
    }
  }

  #bottom {
    border: 1px solid @border-color;
    height: 485px;
    margin: 30px 0;
    header {
      //  border: 1px solid @border-color;
      height: 50px;
      background-color: @div-background-color;
      line-height: 50px;
      button {
        //无色按钮
        float: right;
        border: none;
        background: none;
        outline: none;
        text-align: left;
        color: @three-level-color;
        font-size: 12px;
        margin: 25px 10px;
      }
      button:hover {
        color: @mouse-hover-color;
      }
    }
  }
}
</style>