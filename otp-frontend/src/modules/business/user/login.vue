<template>
<div id="login" >
  <body id="container">
    <label>用户名</label> 
     <input style="margin-left:30px" v-model="user.userName" class="input-container" type="text"  required="required" />     
     <br /> 
     <label>密码</label> 
     <input style="margin-left:46px" v-model="user.password" class="input-container" type="password" required="required" />      
     <br /> 
     <button class="button-container" style="margin-left:80px" @click="loginOnClick">登录</button> 
     <button class="button-container" @click="jump2Home">取消</button> 
  </body>
  <!-- <d-confirm v-bind:confirmModalOptions="confirmOptions" ref="myConfirm"></d-confirm> -->
</div>
</template>


<script>
import { GET } from "@request/base/requestUtils.js";
import { userUrls } from "@request/base/urlDef.js";

export default {
  name: "login",
  // components:{
  //   Dialog
  // },
  data() {
    return {
      user: {
        userName: "",
        password: ""
      },
      msg: "login.app"
    };
  },
  methods: {
    loginOnClick: function() {
      var data = {
        userName: this.user.userName,
        password: this.user.password
      };
      GET(
        userUrls.userDetailUrl + "/" + data.userName,
        function(result) {
          var user = result.data;
          if (user.password === data.password) {
            this.$router.push({
              path: "/otp",
              query: {
                userInfo: result.data
              }
            });
          } else {
            alert("密码错误");
          }
        }.bind(this),
        function(result) {
          if (result.code != null) {
            alert(result.msg + ".请检查用户信息");
          } else {
            alert(result);
          }
        }
      );
    },
    jump2Home: function() {
      this.$router.push({ path: "/home" });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less" >
#login {
  background: url("/img/login.png");
  body {
    width: 400px;
    margin: 20% 50%;
    .input-container {
      width: 250px;
      height: 28px;
      border: solid 1px rgb(102, 101, 101);
      margin-bottom: 20px;
    }
    .button-container {
      border: none;
      height: 28px;
      margin: 15px 55px 0 10px;
      width: 90px;
      background-color: rgb(73, 72, 72);
      color: aliceblue;
      font-size: 16px;
      border-radius: 4px;
    }
  }
}
</style>
