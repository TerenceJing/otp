var baseUrl="http://127.0.0.1:8080/otp";
var userBaseUrl=baseUrl+"/user";//用户基础url
var userUrls={  
  checkUserNameUrl:userBaseUrl+"/name",//检查用户名是否重复，GET,添加url参数{name}
  // loginUrl:userBaseUrl+"/name",
  registerUrl:userBaseUrl+"/addOrUpdateUser",//添加、修改会员,POST,
  userDetailUrl:userBaseUrl,//根据会员id查询会员详情,GET,添加陆参
  
  userListUrl:userBaseUrl,//GET 未实现
  //添加收获地址
};
var productBaseUrl=baseUrl+"/good";
var productUrls={
  getCategoriesUrl:productBaseUrl+"/categories",  //GET方法
  saveCategoryUrl:productBaseUrl+"/category",  //POST方法
  getProductsUrl:productBaseUrl+"/",  //GET方法
  saveProductUrl:productBaseUrl+"/",  //POST方法
}
export{
  userUrls,
  productUrls
}