layui.use(['table','layer'], function(){
    var table = layui.table;
    var layer = layui.layer;

    //考勤记录主界面
    table.render({
        elem: '#demo'

        ,url: '/attendance' //数据接口
        ,page: true //开启分页
        ,limit:10//默认每一页显示条数
        ,limits:[1,2,3,4,5,10,20,30]//每页条数的选择项，
        ,toolbar:"true"//显示工具栏
        ,title:"信息内容"
        ,cols: [[ //表头
            {field: 'no', title: '选择', type:'checkbox',width:"10%", sort: true, fixed: 'left' ,align:"center"}
            ,{field: 'attendanceId', title: '工号', width:"10%", sort: true, fixed: 'left' ,align:"center"}
            ,{field: 'staffId', title: '员工姓名', width:"20%",align:"center"}
            ,{field: 'attendanceDate', title: '考勤时间', width:"20%", sort: true ,align:"center",templet:'<div>{{ layui.util.toDateString(d.bir, "yyyy-MM-dd") }}</div>'}
            ,{field: 'attendanceType', title: '考勤类型', width:"20%", sort: true,align:"center"}
            ,{field: 'OP', title: '操作', width:"20%", sort: true ,align:"center",toolbar:"#barDemo"}

        ]]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });


//监听行部分
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'detailattendance'){ //查看
            layer.open({
                type: 2,
                anim: 5,
                title:"员工信息",
                shade: true,
                area: ['500px','600px'],
                maxmin: true,
                content: '/forward/kaoqingguanli/detailattendance',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    layer.setTop(layero); //重点2
                }
            });




        } else if(layEvent === 'addattendance'){ //增加
            layer.open({
                type: 2,
                anim: 5,
                title:"员工",
                shade: true,
                area: ['500px','600px'],
                maxmin: true,
                content: '/forward/kaoqingguanli/addattendance',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    layer.setTop(layero); //重点2
                }
            });


        } else if(layEvent === 'del'){ //删除
            alert('删除')
            layer.confirm('真的删除行么', function(index){

          });
        } else if(layEvent === 'unpdate'){ //修改
            layer.open({
                type: 2,
                anim: 5,
                title:"员工",
                shade: true,
                area: ['500px','600px'],
                maxmin: true,
                content: '/forward/kaoqingguanli/unpdate',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    layer.setTop(layero); //重点2
                }
            });

        }
    });

});//layui结束标记



