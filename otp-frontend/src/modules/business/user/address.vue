<template>
<div id="address">  
  <header id=top>
    收获地址的增删改查
  </header>
  
</div>
</template>
<script>
export default {
  name: "address",
  data() {
    return {
      user: {
        id: "12138",
        userName: "LiMing",
        nickname: "林深时见小鹿",
        sex: 1,
        birthday: "1993-03-15",
        phone: "18867959468",
        redPackage: 0.56,
        coupon: 3,
        cord: 23,
        presentNumber: 4
      },
      
    };
  },
  methods: {
    updateEventOnClick: function() {
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

#address {}
  
</style>