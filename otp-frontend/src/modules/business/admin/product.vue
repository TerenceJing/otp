<template>
  <div id="product">    
    <body id=product>
      <div id="top">
        <label for="userName">当前活动</label>
        <label id="userName" style="margin-left:10%">商品管理</label>
        <button @click="operateOnClick">{{operate}}</button></div>
      <div v-if="!show" id="content-container" v-for="(item) in productList" v-bind:key="item.id">
        <img :src=item.imageUrl />
        <label id="label-name">{{item.goodName}}</label>
        <label id="label-type">{{item.typeName}}</label>
        <label id="label-currentPrice">
          <del id="label-historyPrice">￥{{item.historyPrice}}</del>
          <br/>￥{{item.currentPrice}}</label>
        <label id="label-saled">
          <label id="label-priced">已售:{{item.saledNum}}</label>
          <br/>评价:{{item.evaluateNum}}</label>
        <label id="label-time">{{item.createTime}}</label></div>
      <div v-if="show" id="save-container">
        <div>
          <div id="image-container"> 
            <!-- click='javascript:$("#uploadImage").click();' -->
            <img src="@img/addPicture.jpg" class="addImage" @click='addImageOnClick'/>
            <input type="file" id="uploadImage" @change="Preview($event)"/>            
            <img v-if="imageUrl[0]!=null&&imageUrl[0]!=''" :src=this.imageUrl[0] />
            <img v-if="imageUrl[1]!=null&&imageUrl[1]!=''" :src=this.imageUrl[1] />
            <img v-if="imageUrl[2]!=null&&imageUrl[2]!=''" :src=this.imageUrl[2] />
            <img v-if="imageUrl[3]!=null&&imageUrl[3]!=''" :src=this.imageUrl[3] />
            <img v-if="imageUrl[4]!=null&&imageUrl[4]!=''" :src=this.imageUrl[4] />          
          </div>
          <div id="content-container">
            <label >商品名称</label>
            <input id="content" v-model="productDetail.goodName" />
          </div>
          <div id="content-container">
            <label >描述信息</label>
            <input id="content" v-model="productDetail.goodDesc" />
          </div>         
          <div id="content-container">
            <label >商品类别</label>
            <select v-model="productDetail.type" name="sexDic" id="content" style="height:25px;width:205px" >
              <option v-for="item in productList" :value="item.categoryName" :key="item.id">{{item.categoryName}}</option> 
            </select>
          </div>
          <div id="content-container">
            <label >灰色价格</label>
            <input id="content" v-model="productDetail.historyPrice" />
          </div>
          <div id="content-container">
            <label >现售价格</label>
            <input id="content" v-model="productDetail.currentPrice" />
          </div>
          <div id="content-container">
            <label >商品库存</label>
            <input id="content" v-model="productDetail.goodNum" />
          </div>
        </div>
        <footer>
          <button @click="saveOnClick">保 存</button>
          <button @click="cancelOnClick">取 消</button>
        </footer>
      </div>
    </body>
  </div>
</template>

<script>
import { GET } from "@request/base/requestUtils.js";
import { POST } from "@request/base/requestUtils.js";
import { productUrls } from "@request/base/urlDef.js";
import { transPic2Base64 } from "@request/base/baseUtil.js";
export default {
  name: "product",
  created: function() {
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
    for (product in this.productList) {
      for (category in this.categoryList) {
        if (product.type === category.id) {
          productName = category.categoryName;
        }
      }
    }
    debugger
  },
  data() {
    return {
      show: false,
      operate: "添加商品",
      categoryList: [],
      productList: [],
      productDetail: {
        id: "",
        goodName: "",
        type: 1,
        typeName: "",
        historyPrice: "",
        currentPrice: "",
        goodNum: "",
        goodDesc: "",
        createTime: "",
        saledNum: "",
        evaluateNum: "",
        imageUrl: "", //base64照片
        imageUrl2: "",
        imageUrl3: "",
        imageUrl4: "",
        imageUrl5: ""
      },
      imageIndex: 0,
      imageUrl: []
    };
  },
  methods: {
    operateOnClick: function() {
      if (this.show === true) {
        this.show = false;
        this.operate = "添加商品";
      } else {
        this.show = true;
        this.operate = "查看商品列表";
      }
    },

    Preview(picData) {
      const file = picData.target.files[0];
      let obj = new FileReader();
      obj.readAsDataURL(file);
      obj.onload = () => {
        this.picReduce(obj.result, base64 => {
          this.imageUrl.push(base64);
          debugger;
        });
      };
    },
    // 图片压缩
    picReduce(picObj, callback) {
      let img = new Image();
      img.src = picObj;
      img.onload = function() {
        const w = img.width;
        const h = img.height;
        const scale = w / h;
        const max_w = w > 1080 ? 1080 : w;
        const max_h = h * max_w / w;
        let canvas = document.createElement("canvas");
        let ctx = canvas.getContext("2d");
        canvas.width = max_w;
        canvas.height = max_h;
        ctx.drawImage(img, 0, 0, max_w, max_h);
        var base64 = canvas.toDataURL("static/image/user/jpeg", 0.7);
        callback(base64);
      };
    },
    addImageOnClick: function() {
      document.getElementById("uploadImage").click();
    },
    saveOnClick: function() {
      if (
        this.productDetail.goodName === null ||
        this.productDetail.goodName === ""
      ) {
        alert("商品名称必填！");
        return;
      }
      if(this.imageUrl[0]!=null){
        this.productDetail.imageUrl=this.imageUrl[0];
      }
      if(this.imageUrl[1]!=null){
        this.productDetail.imageUrl2=this.imageUrl[1];
      }
      if(this.imageUrl[2]!=null){
        this.productDetail.imageUrl3=this.imageUrl[2];
      }
      if(this.imageUrl[3]!=null){
        this.productDetail.imageUrl4=this.imageUrl[3];
      }
      if(this.imageUrl[4]!=null){
        this.productDetail.imageUrl5=this.imageUrl[4];
      }
      
      if (
        this.productDetail.imageUrl === null ||
        this.productDetail.imageUrl === ""
      ) {
        alert("必传商品主图！");
        return;
      }
      if (
        this.productDetail.type === null ||
        this.productDetail.type === ""
      ) {
        alert("必选商品类别");
        return;
      }
      POST(
        productUrls.saveProductUrl,
        this.productDetail,
        function(result) {
          alert("商品添加成功");
          this.$router.push({
            path: "/admin/product"
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
    },

    cancelOnClick: function() {
      this.imageUrl=[];
      this.productDetail.imageUrl=null;
      this.productDetail.imageUrl2=null;
      this.productDetail.imageUrl3=null;
      this.productDetail.imageUrl4=null;
      this.productDetail.imageUrl5=null;
      this.productDetail.goodName=null;
      this.productDetail.historyPrice=null;
      this.productDetail.currentPrice=null;
      this.productDetail.goodDesc=null;
      this.productDetail.goodNum=null;
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

#product {
  border: 1px solid @border-color;
  font-size: 14px;
  #top {
    border-bottom: 1px solid @border-color;
    width: 80%;
    margin: 5% 3%;
    padding: 1% 1%;
    color: @two-level-color;
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
  #content-container {
    // border: 1px solid @border-color;
    border-bottom: 1px dashed @border-color;
    width: 80%;
    height: 82px;
    margin-left: 3%;
    padding: 1% 1% 1%;
    color: @three-level-color;
    // position: relative;
    // line-height: 80px;
    img {
      height: 80px;
      width: 80px;
    }
    label {
      display: inline-block;
    }
    #label-name {
      // border:1px solid @border-color;
      margin: 1% 0 10%;
      display: inline-block;
      width: 130px;
    }
    #label-type {
      display: inline-block;
    }

    #label-currentPrice {
      // border:1px solid @border-color;
      height: 90px;
      display: inline-block;
      color: red;
      width: 40px;
      vertical-align: middle;
      display: inline-block;
      #label-historyPrice {
        color: @three-level-color;
      }
    }
    #label-saled {
      // border:1px solid @border-color;
      height: 90px;
      display: inline-block;
      width: 80px;
      vertical-align: middle;
      display: inline-block;
      #label-priced {
        display: inline-block;
      }
    }
    #label-time {
      height: 70px;
      display: inline-block;
      width: 180px;
      vertical-align: middle;
      display: inline-block;
      #label-priced {
        display: inline-block;
      }
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

  #save-container {
    // border: 1px solid rgb(8, 4, 4);
    margin: 0 2%;
    #image-container {
      height: 80px;
      width: 80%;
      .addImage {
        border: none;
        cursor: pointer;
        float: left;
      }
      // border: 1px solid rgb(236, 96, 96);
      input {
        width: 10px;
        cursor: pointer;
        display: block;
        text-indent: -9999px;
        float: left;
      }
      img {
        border: 1px dashed rgb(172, 144, 144);
        width: 80px;
        height: 80px;
        margin-left: 1%;
        vertical-align: middle;
      }
    }
    #content-container {
      // border: 1.5px dashed rgb(143, 137, 137);
      border-bottom: 1px dashed @border-color;
      width: 80%;
      height:20px;
      margin: 1% 1%;
      color: @two-level-color;
      label {
        display: inline-block;
        width: 70px;
      }
      #content {
        display: inline-block;
        color: @three-level-color;
        margin-left: 6%;
        width: 200px;
      }      
    }
    footer {
    // border: 1px solid rgb(8, 4, 4);
    margin-bottom: 20px;
    button {
      border: none;
      height: 28px;
      width: 90px;
      background-color: rgb(73, 72, 72);
      color: aliceblue;
      font-size: 14px;
      border-radius: 4px;
      margin-left: 40px;
    }
  }
  }
}
</style>