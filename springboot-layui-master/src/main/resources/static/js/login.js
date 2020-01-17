/**
 * 登录
 */
$(function(){
     layui.use(['form' ,'layer'], function() {
         var form = layui.form;
         var layer = layui.layer;
         form.on("submit(login)",function () {
             login();
             return false;
         });
         var path=window.location.href;
         if(path.indexOf("kickout")>0){
             layer.alert("您的账号已在别处登录；若不是您本人操作，请立即修改密码！",function(){
                 window.location.href="/login";
             });
         }
     })
 })

function login(){
    var username=$("#username").val();
    var password=$("#password").val();
    var rememberMe = $("#rememberMe").val();
    $.post("/user/login",$("#useLogin").serialize(),function(data){
        if(data.code == 1){
            window.location.href=data.url;
        }else{
            layer.alert(data.message,function(){
                layer.closeAll();//关闭所有弹框
            });
        }
    });
}

function verify() {
    var username=$("#username").val();
    var password=$("#password").val();
    if ("" == value){
        return '用户名不能为空';
    }
    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
        return '用户名不能有特殊字符';
    }
    if(/(^\_)|(\__)|(\_+$)/.test(value)){
        return '用户名首尾不能出现下划线\'_\'';
    }
    if(/^\d+\d+\d$/.test(value)){
        return '用户名不能全为数字';
    }

    password: [
        /^[\S]{6,12}$/
        ,'密码必须6到12位，且不能出现空格'
    ]
}

