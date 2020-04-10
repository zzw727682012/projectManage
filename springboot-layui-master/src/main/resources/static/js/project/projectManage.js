
var pageCurr;
var form;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#projectList',
            url:'/project/getProjectList',
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
                ,{field:'projectName', title:'项目名称',align:'center'}
                ,{field:'projectSource', title: '项目来源',align:'center'}
                ,{field:'projectBudgetAmount', title:'预算总经费',align:'center'}
                ,{field:'projectAccountAmount', title: '到账总经费',align:'center'}
                ,{field:'projectManagerName', title: '项目主导人',align:'center'}
                ,{field:'projectResearchersName', title: '项目参研人',align:'center'}
                ,{field:'nodeCount', title: '项目节点数',align:'center'}
                ,{field:'startTime', title:'开始时间',align:'center'}
                ,{field:'expirationTime', title: '截止日期',align:'center'}
                ,{field:'finish', title: '是否完成',align:'center'}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);
                //得到当前页码
                console.log(curr);
                $("[data-field='finish']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("是")
                    }else if($(this).text()=='0'){
                        $(this).text("否")
                    }
                });
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(projectTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                //删除
                delProject(data,data.id,data.projectName);
            } else if(obj.event === 'edit'){
                //编辑
                openProject(data,"编辑");
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

    //文件上传
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;
        //指定允许上传的文件类型
        uploadInst = upload.render({
            elem: '#upload'
            ,url: 'uploadFile'
            ,accept: 'file' //普通文件

            ,done: function(res){

            }
        });
    });
});

function uploadFile(type) {
    //重载该实例，支持重载全部基础参数
    uploadInst.reload({
        data: {type: type}
        ,done: function(res){
            if (res.code == "200") {
                console.log(res);
                layer.alert(res.message  + " 请注意提交！");
                if (type == "uploadTechnicalReport") {
                    $("#technicalReport").val(res.obj);
                } else if (type == "uploadFinalReport") {
                    $("#finalReport").val(res.obj);
                } else if (type == "uploadProjectReport") {
                    $("#projectReport").val(res.obj);
                }
            } else {
                layer.alert(res.message);
            }
        }
        ,error: function(){
            layer.alert("请求异常");
        }
    });
    $("#upload").click();
}
//提交表单
function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#projectForm").serialize(),
        url: "/project/addProject",
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


function addProject(){
    openProject(null,"新增项目");
}
function openProject(data,title){
    var form = layui.form ,layer = layui.layer
        ,laydate = layui.laydate;
    //日期
    laydate.render({
        elem: '#expirationTime'
    });
    laydate.render({
        elem: '#startTime'
    });
    var projectManagerName = null;
    var pid = null;
    if(data==null || data==""){
        $("#id").val("");
        $("#download1").attr("href","/project/downloadFile?id="+""+ "&type=" + "");
        $("#download2").attr("href","/project/downloadFile?id="+""+"&type=" + "");
        $("#download3").attr("href","/project/downloadFile?id="+""+"&type=" + "");
    }else{
        console.log(data)
        $("#id").val(data.id);
        $("#projectName").val(data.projectName);
        $("#projectSource").val(data.projectSource);
        $("#projectBudgetAmount").val(data.projectBudgetAmount);
        $("#projectAccountAmount").val(data.projectAccountAmount);
        $("#startTime").val(data.startTime);
        $("#expirationTime").val(data.expirationTime);
        $("#finish").val(data.finish);
        $("#technicalReport").val(data.technicalReport);
        $("#finalReport").val(data.finalReport);
        projectManagerName = data.projectManagerName;
        pid = data.projectResearchers;
        $("#download1").attr("href","/project/downloadFile?id="+data.id+"&type=" + "technicalReport");
        $("#download2").attr("href","/project/downloadFile?id="+data.id+"&type=" + "finalReport");
        $("#download3").attr("href","/project/downloadFile?id="+data.id+"&type=" + "projectReport");
    }
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);
    $.ajax({
        url:'/project/getProjectUsers',
        dataType:'json',
        async: true,
        success:function(data){
            $.each(data,function(index,item){
                if(projectManagerName == null){
                    var option = new Option(item.userName,item.id);
                }else {
                    var option = new Option(item.userName,item.id);
                    // // 如果是之前的parentId则设置选中
                    if(item.userName == projectManagerName) {
                        option.setAttribute("selected",'true');
                    }
                }
                $('#projectManagerName').append(option);//往下拉菜单里添加元素
                form.render('select'); //这个很重要
            })
        }
    });

    formSelects.data('projectResearchers', 'server', {
        url: '/project/getProjectUsers',
        keyName: 'userName',
        keyVal: 'id',
        success: function(id, url, searchVal, result){      //使用远程方式的success回调
            console.log(pid)
            console.log(id)
            console.log(url)
            console.log(searchVal)
            if(pid != null){
                var assistAuditArry =pid.split(",");
                formSelects.value('projectResearchers', assistAuditArry);
            }
            console.log(result);    //返回的结果
        },
        error: function(id, url, searchVal, err){           //使用远程方式的error回调
                                                            //同上
            console.log(err);   //err对象
        },
    });

    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['550px'],
        content:$('#addProject'),
        end:function(){
            cleanProject();
        }
    });
}

function delProject(obj, id, name) {

    layer.confirm('您确定要删除' + name + '项目吗？', {
        btn: ['确认', '返回'] //按钮
    }, function () {
        $.post("/project/delProject", {"id": id}, function (data) {
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

function load(obj) {
    //重新加载table
    if ($(".layui-laypage-btn")[0] == null) {
        tableIns.reload({
            where: obj.field
            , page: {
                curr: 1 //从当前页码开始
            }
        })
    } else {
        $(".layui-laypage-btn")[0].click();
    }
}


function cleanProject(){
    $("#projectName").val("");
    $("#projectSource").val("");
    $('#projectBudgetAmount').val("");
    $("#projectAccountAmount").val("");
    $("#finalReport").val("");
    $("#technicalReport").val("");
    $("#projectReport").val("");
    $("#projectManagerName").html("");
    $("#projectResearchers").val("");
    $("#startTime").val("");
    $("#expirationTime").val("");
    $("#finish").val("");
}

