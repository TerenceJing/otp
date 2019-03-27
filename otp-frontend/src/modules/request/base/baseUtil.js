

//1:图片处理方法
function transPic2Base64(picData,callback=function(result){
    return result;

}) {
    const file = picData.target.files[0];
    let obj = new FileReader();
    obj.readAsDataURL(file);
    callback(obj.result);
};


export {
    transPic2Base64,
}

