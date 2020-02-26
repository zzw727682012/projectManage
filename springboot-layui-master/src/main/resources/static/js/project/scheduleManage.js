
var pageCurr;
var form;
var projectData;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#projectNodeList',
            url:'/project/getProjectPlanList',
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
                ,{field:'projectCode', title:'项目编号',align:'center'}
                ,{field:'projectNodeName', title: '项目结点名称',align:'center'}
                ,{field:'createTime', title:'创建时间',align:'center'}
                ,{field:'expirationTime', title: '截止日期',align:'center'}
                ,{field:'projectNodeFinish', title: '是否完成',align:'center'}
                ,{field:'projectPerformance', title: '完成情况',align:'center'}
                ,{field:'projectNodeDelayReason', title: '未完成原因',align:'center'}

                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
               $("[data-field='projectNodeFinish']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("是")
                    }else if($(this).text()=='2'){
                        $(this).text("否")
                    }
                });
                $("[data-field='projectPerformance']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("优良")
                    }else if($(this).text()=='2'){
                        $(this).text("及格")
                    }else if($(this).text()=='3'){
                        $(this).text("不及格")
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
            if(obj.event === 'edit'){
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
    openProject(null,"新增项目结点");
}
function openProject(data,title){
    var form = layui.form ,layer = layui.layer
    ,laydate = layui.laydate;
    //日期
    laydate.render({
        elem: '#expirationTime'
    });
    var projectName = null;
    if(data==null || data==""){
        $("#id").val("");
    }else{
        console.log(data);
        $("#id").val(data.id);
        $("#projectNodeFinish").val(data.projectNodeFinish);
        $("#projectPerformance").val(data.projectPerformance);
        $("#projectNodeDelayReason").val(data.projectNodeDelayReason);
        $("#expirationTime").val(data.expirationTime);

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
        content:$('#addProject'),
        end:function(){
            cleanProject();
        }
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
    $("#projectName").html("");
    $("#projectCode").val("");
    $("#projectNodeFinish").val("");
    $("#projectNodeDelayReason").val("");
    $("#projectPerformance").val("");
    $("#expirationTime").val("");
}

