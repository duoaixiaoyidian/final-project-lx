<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
    .a1 {
        margin-top: 5px;
    }
</style>
<script type="text/javascript">
    $(function () {
        var toolbar1 = [
            {
                text: "专辑详情",
                iconCls: " icon-bullet_arrow_down",
                handler: function () {
                    var row = $("#tt1").datagrid("getSelected");
                    if (row != null) {
                        $("#fom0").form("load", row);
                        $("#corverImg").prop("src", "${pageContext.request.contextPath}/img/1.gif")
                        $("#dd1").dialog({
                            width: 300,
                            height: 400,
                            title: '详情',
                            iconCls: 'icon-award_star_add',
                            // href: "${pageContext.request.contextPath}/album/showOne?id=" + row.id,

                        })
                    } else {
                        alert("请选择行");
                    }
                }


            },
            {
                text: "添加专辑",
                iconCls: "icon-border_inner",
                handler: function () {
                    $("#dd2").dialog({
                        width: 400,
                        height: 500,
                        title: "新专辑",
                        iconCls: "icon-award_star_add",
                        buttons: [
                            {
                                text: "取消",
                                iconCls: "icon-bullet_cross",
                                handler: function () {
                                    $("#dd2").dialog("close")
                                }
                            },
                            {
                                text: "提交",
                                iconCls: "icon-tick",
                                handler: function () {
                                    $("#fom1").submit();
                                }
                            },

                        ]
                    });
                    //初始化表单
                    $("#fom1").form({
                        url: '${pageContext.request.contextPath}/album/add',
                        onSubmit: function () {
                            return true;
                        },
                        success: function () {
                            //关闭dialog
                            $("#dd2").dialog("close");
                            //刷新datagrid
                            $("#tt1").datagrid("load");
                        }
                    })
                }

            },
            {
                text: "添加章节",
                iconCls: "icon-border_draw",
                handler: function () {
                    $("#dd3").dialog({
                        width: 400,
                        height: 500,
                        title: "新章节",
                        iconCls: "icon-award_star_add",
                        buttons: [
                            {
                                text: "取消",
                                iconCls: "icon-bullet_cross",
                                handler: function () {
                                    $("#dd3").dialog("close")
                                }
                            },
                            {
                                text: "提交",
                                iconCls: "icon-tick",
                                handler: function () {
                                    $("#fom2").submit();

                                }
                            },

                        ]
                    });
                    //初始化表单
                    $("#fom2").form({
                        url: '${pageContext.request.contextPath}/chapter/add',
                        onSubmit: function () {
                            return true;
                        },
                        success: function () {
                            //关闭dialog
                            $("#dd3").dialog("close");
                            //刷新datagrid
                            $("#tt1").datagrid("load");
                        }
                    })
                }

            },
            {
                text: "下载音频",
                iconCls: "icon-disk_download",
                handler: function () {
                    var row = $("#tt1").treegrid("getSelected");
                    if (row != null) {
                        if (row.author == null) {
                            location.href = "${pageContext.request.contextPath}/chapter/down?audioPath=" + row.audioPath + "&name=" + row.title
                        } else {
                            alert("请选中专辑");
                        }
                    } else {
                        alert("请选中行");
                    }

                }

            },
        ]


        $("#tt1").treegrid({
            onDblClickRow: function (row) {
                $("#audio_dd").dialog("open")
                $("#audio").prop("src", "${pageContext.request.contextPath}/audio/" + row.audioPath)
            },
            url: "${pageContext.request.contextPath}/album/showAll",
            method: "post",
            idField: "id",
            treeField: "title",
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'duration', title: '时长', width: 60},
                {field: 'size', title: '大小', width: 80},
                {field: 'audioPath', title: '音频路径', width: 80,},
                {field: 'album_id', title: '专辑ID', width: 80},
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar1,

        })
    })
</script>


<table id="tt1"></table>
<div id="dd1">
    <form id="fom0">
        title:<input type="text" id="title" name="title"/><br/>
        count:<input type="text" id="count" name="count"/><br/>
        author:<input type="text" id="author" name="author"/><br/>
        brief:<textarea rows="7" cols="1" name="brief" style="width:220px;"/><br/>
        corverImg:<img src="" id="corverImg"><br/>
    </form>
</div>
<div id="dd2">
    <form id="fom1">
        <div class="a1">
            id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                name="id" class="easyui-textbox" data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">title:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                name="title" class="easyui-textbox" data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">count:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="count"
                                                                                                 class="easyui-textbox"
                                                                                                 data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">corverImg:&nbsp;&nbsp;&nbsp;<input name="corverImg" class="easyui-textbox"
                                                           data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1"> score:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="score"
                                                                                                  class="easyui-textbox"
                                                                                                  data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1"> author:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="author"
                                                                                             class="easyui-textbox"
                                                                                             data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1"> broadCast:&nbsp;&nbsp;<input name="broadCast" class="easyui-textbox"
                                                      data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1"> brief:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                name="brief" class="easyui-textbox" data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">publishDate:<input name="publishDate" class="easyui-datebox"
                                           data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">createDate:&nbsp;&nbsp;<input name="createDate" class="easyui-datebox"
                                                      data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">status:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="status"
                                                                                                  class="easyui-textbox"
                                                                                                  data-options="required:true,width:200,height:30"/>
        </div>
    </form>
    <div id="audio_dd" class="easyui-dialog" title="My Dialog"
         style="width:400px;height:200px;text-align: center;background: #ffb042"
         data-options="iconCls:'icon-next_green',resizable:true,modal:true,closed:true">
        <audio src="" id="audio" controls="controls" autoplay="autoplay">

        </audio>
    </div>
</div>

<div id="dd3">
    <form id="fom2" enctype="multipart/form-data" method="post">

        <div class="a1">title:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="title"
                                                                                                       class="easyui-textbox"
                                                                                                       data-options="required:true,width:200,height:30"/>
            <br/></div>

        <div class="a1">Path:<input name="path" class="easyui-filebox"
                                    data-options="required:true,width:200,height:30,"/>
            <br/></div>
        <div class="a1">album_id:&nbsp;<input name="album_id" class="easyui-textbox"
                                              data-options="required:true,width:200,height:30"/>
            <br/></div>
    </form>

</div>
</html>