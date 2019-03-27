<template>
<div id="userSafe" >  
  <body id=safe v-if="show===1">    
    <div id="top">
      <label for="userName">您当前的账号</label>      
      <label id="userName" style="margin-left:10%">{{this.global.userInfo.userName}}</label>
    </div>
    <div id="content-container">
      <label for="content">登陆密码</label>
      <label id="content">建议您定期更换密码，设置安全性高的密码可以使帐号更安全</label>
      <button @click="updatePassword">修改</button>
    </div>
    <div id="content-container">
      <label for="content">绑定手机</label>
      <label id="content">绑定手机后，您可享受丰富的手机服务以及重要信息更改时的身份验证</label>
      <button>绑定</button>
    </div>
    <div id="content-container">
      <label for="content">支付密码</label>
      <label id="content">支付密码启用后，将作为您帐号资产使用时的身份证明</label>
      <button>设置</button>
    </div>
    <div id="bottom">
      <label >安全服务提示</label>
      <li>确认您登录的是（王洋）在线商城网址//xxx，注意防范进入钓鱼网站，不要轻信各种即时通讯工具发送的商品或支付链接，谨防网购诈骗</li>
      <li>建议您安装杀毒软件，并定期更新操作系统等软件补丁，确保帐号及交易安全</li>
    </div>    
  </body>
  <body id="update-password" v-if="show===2">
     <label>旧密码</label> 
     <input style="margin-left:46px" v-model="historyPassword" class="input-container" type="password" required="required" /> 
     <label class="requireType-container">*</label>
     <br>
     <label>新密码</label> 
     <input style="margin-left:46px" v-model="newPassword" class="input-container" type="password" required="required" /> 
     <label class="requireType-container">*</label> 
     <br /> 
     <label style="display:inline-block">确认密码</label> 
     <input v-model="reNewPassword" class="input-container-re" type="password"  required="required" /> 
     <label class="requireType-container">*</label>
     <div>
      <button  @click="updateOnClick" class="save-btn">保 存</button> 
      <button  @click="cancelOnClick">取 消</button> 
     </div>
  </body>
  
</div>
</template>
<script>
import { POST } from "@request/base/requestUtils.js";
import { userUrls } from "@request/base/urlDef.js";
export default {
  name: "userSafe",
  data() {
    return {
      show: 1,
      historyPassword:null,
      newPassword:null,
      reNewPassword:null,
      user:{
        id:"",
        userName:"",
        password:"",

        operate:null

      }
    };
  },
  methods: {
    updatePassword: function() {
      this.show=2;
    },
    updateOnClick:function(){
      if(this.historyPassword!==this.global.userInfo.password){
        alert("用户密码错误！");
        return;
      }
      if(this.newPassword===null||this.newPassword===""){
        alert("请填写新密码");
        return;
      }
      if(this.reNewPassword===null||this.reNewPassword===""){
        alert("请确认新密码");
        return;
      }
      if(this.newPassword!=this.reNewPassword){
        alert("新密码不同，请确认！");
        return;
      }
      this.user.id=this.global.userInfo.id;
      this.user.userName=this.global.userInfo.userName;
      this.user.password=this.newPassword;
      this.user.operate="update";
      //修改密码
      POST(
        userUrls.registerUrl,
        this.user,
        function(result) {
          if(result.code==="0"){
            this.global.userInfo=this.user;
           alert("密码修改成功");
           
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
    cancelOnClick:function(){
      this.password=null;
      this.newPassword=null;
      this.reNewPassword=null;
      this.show=1;
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

#safe {
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
    border-bottom: 1px dashed @border-color;
    width: 80%;
    margin: 5% 3%;
    padding: 1% 1%;
    color: @two-level-color;
    label {
      display: inline-block;
      width: 100px;
    }
    #content {
      display: inline-block;
      color: @three-level-color;
      margin-left: 10%;
      width: 400px;
      margin-left: 8%;
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
  #bottom {
    border-top: 1px solid @border-color;
    background-color: @div-background-color;
    height: 130px;
    label {
      // border:1px solid @border-color;
      display: inline-block;
      margin: 2% 3%;
      font-weight: bold;
    }
    li {
      color: @three-level-color;
      margin: 3px 3%;
    }
  }
}
#update-password {
  border: 1px solid @border-color;
  padding: 10% 5% 9%;

  .input-container {
    width: 250px;
    height: 28px;
    border: solid 1px rgb(102, 101, 101);
    margin-bottom: 20px;
  }
  .input-container-re {
    width: 250px;
    height: 28px;
    border: solid 1px rgb(102, 101, 101);
    margin-bottom: 20px;
    margin-left: 30px;
  }
  .requireType-container {
    color: red;
  }
  div {
    // border: 1px solid @border-color;
    margin-top: 4%;
    button {
      border: none;
      height: 28px;
      margin-left: 20px;
      width: 90px;
      background-color: rgb(73, 72, 72);
      color: aliceblue;
      font-size: 16px;
    }
    .save-btn{
      margin-left: 10.5%;
    }
    
  }
}
</style>