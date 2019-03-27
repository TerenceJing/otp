<template>
  <div id="home">    
    <body>      
      <div class="body-top">
        <img  src="@/assets/img/logo.png"/>
        <div> 
          <input v-model="keywords"/>  
          <button class="btn" @click="searchOnClick">搜索</button> 
        </div>       
      </div>
      <div class="body-center">
        <div class="body-center-top">
          <button  @click="jump2Home">首页</button>
          <button  @click="jump2Home">服装</button>
          <button  @click="jump2Home">鞋包配饰</button>
          <button  @click="jump2Home">居家旅行</button>
          <button  @click="jump2Home">电器餐厨</button>
          <button  @click="jump2Home">洗护用品</button>
          <button  @click="jump2Home">饮食酒奶</button>
          <button  @click="jump2Home">母婴幼儿</button> 
          <button  @click="jump2Home">还有其他</button>
        </div>
        <router-view/>
      </div>
      
    </body>
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      keywords: ""
    };
  },
  methods: {
    searchOnClick: function() {
      this.$router.push({
        path: "/home/good-list",
        query: {
          keywords: this.keywords
        }
      });
      //调到搜索列表，并搜索数据
    },
    jump2Home: function() {
      this.$router.push({ path: "/" });
      this.view = true;
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
body {
  margin-top: @header-height+10;
  .body-top {
    vertical-align: 100%;
    @logo-height: 100px;
    img {
      width: @logo-height+30px;
      height: @logo-height;
      margin-left: 15%;
    }
    div {
      // border: 1px solid @body-color;
      width: 300px;
      display: inline;
      float: right;
      margin-right: 25%;
      margin-top: -30px + @logo-height;
      input {
        border: none;
        outline: none;
        border-bottom: 1px solid rgb(148, 148, 148);
        width: 200px;
        height: 20px;
      }
      .btn {
        outline: none;
        border: none;
        background: none;
        color: @body-color;
        font-size: 15px;
        padding-bottom: 0px;
      }
      .btn:hover {
        color: #000000;
      }
    }
  }
  //中间默认框
  .body-center {
    margin-top: 1.5%;
    margin-left: 13%;
    margin-right: 20%;
    .body-center-top {
      button {
        //无色按钮
        outline: none;
        border: none;
        background: none;
        color: @two-level-color;
        font-size: 15px;
        font-weight: bold;
        padding-bottom: 0px;
      }
      button:hover {
        color: rgb(83, 51, 24);
      }
    }
  }
}
</style>

