
var pageCurr;
var form;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#projectUserList',
            url:'/project/getProjectUserList',
            method: 'post', //默认：get请求
            cellMinWidth: 80,
            page: true,
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：pageNum
                limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            },
            response:{
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'list' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type:'numbers'}
                ,{field:'userName', title:'姓名',align:'center'}
                ,{field:'userSex', title:'性别',align:'center'}
                ,{field:'userBirthday', title: '出生日期',align:'center'}
                ,{field:'userPoliticsStatus', title: '政治面貌',align:'center'}
                ,{field:'userJoinTime', title:'入党(团)日期',align:'center'}
                ,{field:'userGraduateInstitutions', title: '毕业院校',align:'center'}
                ,{field:'userOrganization', title:'工作单位',align:'center'}
                ,{field:'userTeachingOffice', title: '教研室',align:'center'}
                ,{field:'userHomeAddress', title: '家庭住址',align:'center'}
                ,{field:'createTime', title:'创建时间',align:'center'}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);
                //得到当前页码
                console.log(curr);
                //得到数据总量
                console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(projectUserTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                //编辑
                openProjectUser(data,"编辑");
            }  if(obj.event === 'del'){
                delProjectUser(data,data.id,data.userName);
            }
        });

        //监听提交
        form.on('submit(projectSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            tableIns.reload({
                where: data.field
                , page: {
                    curr: 1 //从当前页码开始
                }
            })
            return false;
        });
    });
});

//提交表单
function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#projectForm").serialize(),
        url: "/project/addProjectUser",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}
function addProjectUser() {
    openProjectUser(null, "新增人员");
}

function openProjectUser(data,title){
    var form = layui.form ,layer = layui.layer
    ,laydate = layui.laydate;
    //日期
    laydate.render({
        elem: '#userJoinTime'
    });
    laydate.render({
        elem: '#userBirthday'
    });

    if(data==null || data==""){
        $("#id").val("");
    }else{
        console.log(data);
        $("#id").val(data.id);
        $("#userName").val(data.userName);
        $("#userSex").val(data.userSex);
        $("#userBirthday").val(data.userBirthday);
        $("#userPoliticsStatus").val(data.userPoliticsStatus);
        $("#userJoinTime").val(data.userJoinTime);
        $("#userGraduateInstitutions").val(data.userGraduateInstitutions);
        $("#userOrganization").val(data.userOrganization);
        $("#userTeachingOffice").val(data.userTeachingOffice);
        $("#userHomeAddress").val(data.userHomeAddress);

    }

    layui.use(["jquery", "upload", "form", "layer", "element"], function () {
        var $ = layui.$,
            element = layui.element,
            layer = layui.layer,
            upload = layui.upload,
            form = layui.form;
        //拖拽上传
        var uploadInst = upload.render({
            elem: '#headImg'
            , url: '/project/uploadPhoto'
            , size: 500
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
                //打印后台传回的地址: 把地址放入一个隐藏的input中, 和表单一起提交到后台, 此处略..
                console.log(res.data.src);
                //window.parent.uploadHeadImage(res.data.src);
                var demoText = $('#demoText');
                $("#userPhoto").val(res.data.src);
                demoText.html('<span style="color: #21ff3d;">上传成功!!!</span>');
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        element.init();
    });
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);

    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['650px'],
        content:$('#addProjectUser'),
        end:function(){
            cleanProject();
        }
    });
}

function delProjectUser(obj, id, name) {

    layer.confirm('您确定要删除' + name + '人员信息吗？', {
        btn: ['确认', '返回'] //按钮
    }, function () {
        $.post("/project/delProjectUser", {"id": id}, function (data) {
            if (data.code == 1) {
                layer.alert(data.msg, function () {
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        });
    }, function () {
        layer.closeAll();
    });
}

function load(obj){
    //重新加载table
    $(".layui-laypage-btn")[0].click();
}

function cleanProject(){
    $("#userName").val("");
    $("#userSex").val("");
    $("#userBirthday").val("");
    $("#userPoliticsStatus").val("");
    $("#userJoinTime").val("");
    $("#userGraduateInstitutions").val("");
    $("#userOrganization").val("");
    $("#userTeachingOffice").val("");
    $("#userHomeAddress").val("");
}

