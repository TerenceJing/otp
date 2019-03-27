<template>
<div id="user">  
  <header id=top>
  </header>
  <body id="body-left">
    <label id="photo-container">我的头像</label>       
    <label id="userID">用户ID</label>
    <label >账号</label>
    <label >昵称</label>
    <label >性别</label>
    <label >手机号</label>
    <label >出生日期</label>
  </body>
   <body id="body-right">
     <div v-if="!updateFlag">
        <img v-if="this.user.imageData!=null" :src=this.user.imageData />
        <img v-if="this.user.imageData===null||this.user.imageData===''" src="@img/userPG.jpg"/>
        <div>
          <button @click="updateEventOnClick">编辑</button> 
        </div>
        <i class="anchor"></i> 
        <label id="userID">{{user.id}}</label>
        <br>
        <label >{{user.userName}}</label>
        <br>
        <label >{{user.nickname}}</label>
        <br>
        <label v-if="user.sex===1" >男</label>
        <label v-if="user.sex===0" >女</label>
        <label v-if="user.sex!==0&&user.sex!==1" >未知</label>
        <br>
        <label >{{user.phone}}</label>
        <br>
        <label >1993-05-15</label>
        <br>
      </div>
      <div id="update-container" v-if="updateFlag">        
       <input type="file" @change="Preview($event)" accept="static/image/user/*" ref="showinput">

        <label id="userID">{{user.id}}</label>        
        <label id="user-label">{{user.userName}}</label>        
        <input type="text" v-model="user.nickname"/>
       <br>
        <select v-model="user.sex" name="sexDic" id="sexDic" class="input-container">
          <option v-for="item in sexDic" :value="item.key" :key="item.value">{{item.value}}</option> 
        </select>
        <label id="phone-label">绑定手机号</label>        
        <input type="text" v-model="user.birthday"/>
        <br>
      </div>
  </body>
  <footer v-if="updateFlag">
    <button  @click="updateOnClick">保 存</button> 
    <button  @click="cancelOnClick">取 消</button> 
  </footer>
</div>
</template>
<script>
import { POST } from "@request/base/requestUtils.js";
import { userUrls } from "@request/base/urlDef.js";
import { sexDic } from "@request/base/baseInfo.js";

export default {
  name: "user",
  data() {
    return {
      user: this.global.userInfo,
      updateFlag: false,
      sexDic: sexDic,
      imgObj: "",
      img: null
    };
  },
  methods: {
    updateEventOnClick: function() {
      this.updateFlag = true;
    },
    updateOnClick: function() {
      this.updateFlag = false;
      this.user.operate = "update";
       POST(
        userUrls.registerUrl,
        this.user,
        function(result) {
          if(result.code==="0"){
            this.global.userInfo=this.user;
           alert("修改成功");
           
          } else {
            alert("操作失败");
          }
        }.bind(this),
        function(result) {
          if (result.code != null) {
            alert(result.msg );
          } else {
            alert(result);
          }
        }
      );
    },
    cancelOnClick: function() {
      this.updateFlag = false;
      this.$router.push({
        path: "/uhome/user-info"
      });
    },
    Preview(ev) {
      const file = ev.target.files[0];
      this.imgObj = ev.target.files[0];
      let obj = new FileReader();
      obj.readAsDataURL(file);
      obj.onload = () => {
        this.picReduce(obj.result);
      };
    },
    // 图片压缩
    picReduce(picObj) {
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
        this.user.imageData = base64;
      }.bind(this);
    }
  }
};
</script>


<style lang="less" scoped>
@base-color: rgb(0, 0, 0);
@two-level-color: rgb(51, 51, 51);
@three-level-color: rgb(102, 102, 102);
@div-background-color: rgb(244, 244, 244);
@border-color: rgb(234, 234, 234);
@mouse-hover-color: rgb(180, 160, 120);

#user {
  // border: 1px solid red;

  #top {
    height: 20px;
  }
  #body-left {
    border: none;
    height: 500px;
    #photo-container {
      margin-top: 35px;
    }
    #userID {
      margin-top: 50px;
      margin-bottom: 0px;
    }
    label {
      // border: 1px solid rgb(8, 4, 4);
      margin-top: 40px;
      display: block;
      font-size: 14px;
      color: @two-level-color;
      font-weight: 8;
    }
  }
  #body-right {
    // border: 1px solid rgb(8, 4, 4);
    height: 500px;
    div {
      img {
        // border: 1px solid rgb(8, 4, 4);
        width: 80px;
        height: 80px;
        float: left;
      }
      div {
        display: inline-block;
        height: 80px;
        margin-top: 0;
        // border: 1px solid rgb(8, 4, 4);
        button {
          //无色按钮
          border: none;
          background: none;
          outline: none;
          text-align: left;
          color: @three-level-color;
          font-size: 15px;
          margin: 30px 100px;
        }
        button:hover {
          color: @mouse-hover-color;
        }
      }

      #userID {
        margin-top: 23px;
        margin-bottom: 0px;
      }
      label {
        // border: 1px solid rgb(8, 4, 4);
        height: 20px;
        margin-top: 19px;
        margin-left: 10px;
        display: block;
        font-size: 14px;
        color: @two-level-color;
        font-weight: 8;
      }
    }
    #update-container {
      // border: 1px solid rgb(8, 4, 4);
      #userID {
        // border: 1px solid rgb(8, 4, 4);
        margin: 40px 10px;
      }
      #user-label {
        margin: 40px 10px 0;
      }
      input {
        width: 170px;
        height: 20px;
        margin: 35px 10px 0;
      }
      select {
        margin: 35px 10px 0;
        width: 174px;
        height: 25px;
      }
      #phone-label {
        margin: 35px 10px 0;
      }
    }
  }
  footer {
    // border: 1px solid rgb(8, 4, 4);
    // width:250px;
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
</style>