 <template> 
   <div id="register">
    <div id="register-container"> 
     <label>用户名</label> 
     <input style="margin-left:30px" v-model="user.userName" class="input-container" type="text" placeholder="edit me(一旦生效，不可更改)" required="required" /> 
     <label class="requireType-container">*</label> 
     <br /> 
     <label>密码</label> 
     <input style="margin-left:46px" v-model="user.password" class="input-container" type="password" required="required" /> 
     <label class="requireType-container">*</label> 
     <br /> 
     <label>确认密码</label> 
     <input style="margin-left:14px" v-model="rePassword" class="input-container" type="password" required="required" /> 
     <label class="requireType-container">*</label> 
     <br /> 
     <label>性别</label> 
     <select style="margin-left:46px;height:33px;" v-model="user.sex" name="sexDic" id="sexDic" class="input-container"> <option v-for="item in sexDic" :value="item.key" :key="item.value">{{item.value}}</option> </select> 
     <br /> 
     <label>出生日期</label> 
     <input style="margin-left:14px" v-model="user.birthday" class="input-container" type="text" />
     <br /> 
     <br />
     <input  class="radio-container" type="checkBox" name="service" :checked="state" @click="checkboxOnclick">我已仔细阅读并接受<label style="color:rgb(60,10,510);text-decoration: underline;">商城用户服务条款</label>
     <br />
     <button v-if="!state" :disabled="!state" class="button-container-disabled" style="margin-left:80px">注册</button>
     <button v-if="state" class="button-container" style="margin-left:80px" @click="registerOnClick">注册</button> 
     <button class="button-container" @click="reset">重置</button> 
    </div> 
   </div> 
  </template>



<script>
import { POST } from "@request/base/requestUtils.js";
import { userUrls } from "@request/base/urlDef.js";
import { sexDic } from "@request/base/baseInfo.js";

export default {
  name: "register",

  data() {
    return {
      user: {
        userName: "",
        password: "",
        nickname: "",
        sex: "",
        birthday: "",
        imageData: ""
      },
      rePassword: "",
      state: false,

      registerStyle: {
        border: "none",
        height: "28px",
        width: "90px",
        margin: "15px 55px 0 10px",
        backgroundColor: "rgb(56,56,56)",
        color: "aliceblue",
        fontSize: "16px"
      },

      sexDic: sexDic,
      msg: "this is a msg"
    };
  },

  methods: {
    onfcus: function() {
      value = "";
    },

    onblur: function() {
      this.user.userName = "一旦生效，不可更改";
    },
    checkboxOnclick: function() {
      if (this.state === true) {
        this.state = false;
      } else {
        this.state = true;
      }
      //TODO
    },

    reset: function() {
      this.user.userName = "";
      this.user.password = "";
      this.rePassword = "";
      this.user.nickname = "";
      this.user.sex = "";
      this.user.birthday = "";
      this.user.imageData = "";
    },
    registerOnClick: function() {
      if (this.user.userName === null || this.user.userName === "") {
        alert("用户名不能为空！");
        return;
      }
      if (this.user.password === null || this.user.password === "") {
        alert("密码不能为空！");
        return;
      }
      if (this.rePassword === null || this.rePassword === "") {
        alert("请确认用户密码！");
        return;
      }
      if (this.rePassword != this.user.password) {
        alert("用户密码不一致");
        return;
      }
      debugger;
      //添加用户信息
      POST(
        userUrls.registerUrl,
        this.user,
        function(result) {
          if (result.code === "0") {
            this.global.userInfo = this.user;
            alert("注册成功");
            //跳转到登陆页面
            this.$router.push({
              path: "/login"
            });
          } else {
            alert("操作失败");
          }
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
#register {
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  background: url(/img/login.png);
}
#register-container {
  margin: 8% 15%;
  font-size: 16px;
}

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
}
.button-container-disabled {
  border: none;
  height: 28px;
  margin: 15px 55px 0 10px;
  width: 90px;
  background-color: rgb(197, 194, 194);
  color: aliceblue;
  font-size: 16px;
}

.requireType-container {
  color: red;
}
.radio-container {
  margin-left: 85px;
}
</style>


