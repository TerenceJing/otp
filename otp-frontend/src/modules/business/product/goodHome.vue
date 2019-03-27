<template>
  <div id="goodList">    
    <body>
      <img src="@img/first.gif" alt="">
    </body>
  </div>
</template>

<script>
export default {
  name: "goodList",
  data() {
    return {};
  },
  methods: {}
};
</script>

<style lang="less" scoped>
@header-height: 40px;
@front-color: rgb(204, 204, 204);
@background-color: rgb(51, 51, 51);
@body-color: rgb(86, 91, 110);
@two-level-color: rgb(97, 85, 85);
body {
  border-top: 1px dashed @body-color;
  padding-top: 10px;
  img{
    width: 990px;
    height: 410px;
  }
}
</style>

