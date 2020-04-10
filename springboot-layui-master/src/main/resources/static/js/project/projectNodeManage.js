
var pageCurr;
var form;
var projectData;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#projectNodeList',
            url:'/project/getProjectNodeList',
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
                ,{field:'projectNodeName', title: '项目结点名称',align:'center'}
                ,{field:'createTime', title:'创建时间',align:'center'}
                ,{field:'expirationTime', title: '截止日期',align:'center'}
                ,{field:'projectNodeFinish', title: '节点是否完成',align:'center'}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);
                //得到当前页码
                console.log(curr);
               $("[data-field='projectNodeFinish']").children().each(function(){
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
        table.on('tool(projectNodeTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                //删除
                delProjectNode(data,data.id,data.projectNodeName);
            } else if(obj.event === 'edit'){
                //编辑
                openProjectNode(data,"编辑");
            }
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
                layer.alert(res.message + " 请注意提交！");
                $("#nodeAttachment").val(res.obj);
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
        data: $("#projectNodeForm").serialize(),
        url: "/project/addProjectNode",
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

function addProjectNode(){
    openProjectNode(null,"新增项目结点");
}
function openProjectNode(data,title){
    var form = layui.form ,layer = layui.layer;
    //日期
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#nodeExpirationTime' //指定元素
        });
    });

    var projectName = null;
    if(data==null || data==""){
        $("#id").val("");
        $("#download").attr("href","/project/downloadFile?id="+""+ "&type=" + "");
    }else{
        console.log(data);
        $("#id").val(data.id);
        $("#projectNodeFinish").val(data.projectNodeFinish);
        $("#projectNodeName").val(data.projectNodeName);
        $("#nodeAttachment").val(data.nodeAttachment);
        $("#nodeExpirationTime").val(data.expirationTime);
        $("#download").attr("href","/project/downloadFile?id="+data.id+ "&type=" + "nodeAttachment");
        projectName = data.projectName;
    }
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);

    $.ajax({
        url:'/project/getProjects',
        dataType:'json',
        async: true,
        success:function(data){
            console.log(data);
            $.each(data,function(index,item){
                if(projectName == null){
                    var option = new Option(item.projectName,item.projectName);
                }else {
                    var option = new Option(item.projectName,item.projectName);
                    // // 如果是之前的parentId则设置选中
                    if(item.projectName == projectName) {
                        option.setAttribute("selected",'true');
                    }
                }
                $('#projectName').append(option);//往下拉菜单里添加元素
                form.render('select'); //这个很重要
                projectData = data;
            })
        }
    });

    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['550px'],
        content:$('#addProjectNode'),
        end:function(){
            cleanProject();
        }
    });
}
function delProjectNode(obj, id, name) {

    layer.confirm('您确定要删除' + name + '项目节点吗？', {
        btn: ['确认', '返回'] //按钮
    }, function () {
        $.post("/project/delProjectNode", {"id": id}, function (data) {
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
    $("#projectName").html("");
    $("#projectNodeFinish").val("");
    $("#projectNodeName").val("");
    $("#nodeAttachment").val("");
    $("#nodeExpirationTime").val("");
}

