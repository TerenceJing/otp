<template>
<div id="category" >  
  <body id=category>    
    <div id="top">
      <label for="userName">当前活动</label>      
      <label id="userName" style="margin-left:10%">商品分类管理</label>
    </div>
    <div id="content-container">
      <label >类别ID</label>
      <label >类别名称</label>
      <label >添加时间</label>
      <button @click="addCategoryOnClick">{{categoryOperate}}</button>
    </div>
    <div id="content-container" v-for="(item,index) in categoryList" v-bind:key="item.id" >
      <label style="color:rgb(102, 102, 102)">{{index+1}}</label>
      <label style="color:rgb(102, 102, 102)">{{item.categoryName}}</label>
      <label style="color:rgb(102, 102, 102); width:150px">{{item.createTime}}</label>
    </div>
    <div v-if="show" id="content-container" >
        <label>下一个</label>
      <input type="text" style="width:120px" v-model="category.categoryName"/>
      <button @click="saveCategoryOnClick">保存</button>
    </div>
      
  </body>
  
</div>
</template>
<script>
import { GET } from "@request/base/requestUtils.js";
import { POST } from "@request/base/requestUtils.js";
import { productUrls } from "@request/base/urlDef.js";
export default {
  name: "category",
  created: function() {
    GET(
      productUrls.getCategoriesUrl,
      function(result) {
        this.categoryList = result.data;
      }.bind(this),
      function(result) {
        if (result.code != null) {
          alert(result.msg);
        } else {
          alert(result);
        }
      }
    );
  },
  data() {
    return {
      show: false,
      categoryOperate:"添加分类",
      categoryList: [],
      category: {
        categoryName: null
      }
    };
  },
  methods: {
    addCategoryOnClick: function() {
        if(this.show === true){
            this.show=false;
            this.categoryOperate="添加分类";
        }else{
            this.show=true;
            this.categoryOperate="不再添加";
        }
      
    },
    saveCategoryOnClick: function() {
      if (
        this.category.categoryName === null ||
        this.category.categoryName === ""
      ) {
        alert("请输入商品分类名称！");
        return;
      }
      POST(
        productUrls.saveCategoryUrl,
        this.category,
        function(result) {
          alert("分类添加成功");  
          this.$router.push({
              path:"/admin"
            });
            this.show = false;      
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
  }
};
</script>

<style lang="less" scoped>
@base-color: rgb(0, 0, 0);
@two-level-color: rgb(51, 51, 51);
@three-level-color: rgb(102, 102, 102);
@div-background-color: rgb(245, 245, 245);
@border-color: rgb(234, 234, 234);
@mouse-hover-color: rgb(180, 160, 120);
@btn-text-blue: rgb(100, 150, 200);

#category {
  border: 1px solid @border-color;
  font-size: 14px;
  #top {
    border-bottom: 1px solid @border-color;
    width: 80%;
    margin: 5% 3%;
    padding: 1% 1%;
    color: @two-level-color;
  }
  #content-container {
    //    border:1px solid @border-color;
    border-bottom: 1px dashed @border-color;
    width: 80%;
    margin-left: 3%;
    padding: 1% 1%;
    color: @base-color;
    label {
      display: inline-block;
      width: 130px;
    }

    button {
      float: right;
      color: @btn-text-blue;
      border: none;
      background: none;
    }
    button:hover {
      text-decoration: underline;
    }
  }
}
</style>