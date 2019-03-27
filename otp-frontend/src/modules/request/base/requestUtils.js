
import $ from 'jquery'
function POST(url, param,success, error) {
  debugger
  $.ajax({
          type : 'POST',
          url :url,
          data : JSON.stringify(param),
          dataType : 'json',
          contentType : 'application/json',
          success: function (result) {
            if (result.code==="0") {
              success(result)
            } else {
              //无常规错误，根绝data数据做具体的业务判断显示 
              error(result);
            }
          },
          error: function(result) {
            //网络请求错误       
            error("网络请求错误");
          }
      });
};

function GET(url, success, error) {
  $.ajax({
    type: 'GET',
    url: url,
    dataType: "json",
    success: function (result) {
      if (result.code==="0") {
        success(result)
      } else {
        //无常规错误，根绝data数据做具体的业务判断显示 
        error(result);
      }
    },
    error: function(result) {
      //网络请求错误       
      error("网络请求错误");
    }
  });
};




export{
  POST,
  GET
}

