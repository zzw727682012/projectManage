
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
                ,{field:'projectBudgetAmount', title:'预算总经费',align:'center'}
                ,{field:'projectAccountAmount', title: '到账总经费',align:'center'}
                ,{field:'projectManagerName', title: '项目主导人',align:'center'}
                ,{field:'projectResearchersName', title: '项目参研人',align:'center'}
                ,{field:'createTime', title:'创建时间',align:'center'}
                ,{field:'expirationTime', title: '截止日期',align:'center'}
                ,{field:'finish', title: '是否完成',align:'center'}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
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
    //文件上传
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;
        //指定允许上传的文件类型
        upload.render({
            elem: '#uploadProjectAccessory'
            ,url: 'uploadProjectAccessory'
            ,accept: 'file' //普通文件
            ,done: function(res){
                if (res.code == 1) {
                    layer.alert((res.msg) + " 注意：上传后需要提交");

                    $("#projectAccessory").val(res.path);
                } else {
                    layer.alert(res.msg);
                }
            }
        });
    });
    //搜索框
    layui.use(['form','laydate'], function(){p
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
    });
});

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
    var projectManagerName = null;
    var pid = null;
    if(data==null || data==""){
        $("#id").val("");
        $("#download").attr("href","/project/downloadProjectAccessory?projectId="+"");
    }else{
        console.log(data)
        $("#id").val(data.id);
        $("#projectName").val(data.projectName);
/*        $("#projectType").val(data.projectType);
        $("#projectSource").val(data.projectSource);*/
        $("#projectCode").val(data.projectCode);
        $("#projectBudgetAmount").val(data.projectBudgetAmount);
        $("#projectAccountAmount").val(data.projectAccountAmount);
        $("#projectAccessory").val(data.projectAccessory);
        $("#expirationTime").val(data.expirationTime);
        $("#finish").val(data.finish);

        projectManagerName = data.projectManagerName;
        pid = data.projectResearchers;
        $("#download").attr("href","/project/downloadProjectAccessory?projectId="+data.id);
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

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanProject(){
    $("#projectName").val("");
    $("#projectCode").val("");
    $('#projectBudgetAmount').val("");
    $("#projectAccountAmount").val("");
    $("#projectAccessory").val("");
    $("#projectManagerName").html("");
    $("#projectResearchers").val("");
    $("#finish").val("");
}

