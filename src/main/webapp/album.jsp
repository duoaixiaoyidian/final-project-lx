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
                        $("#dd1").dialog({
                            width: 500,
                            height: 600,
                            title: '详情',
                            iconCls: 'icon-award_star_add',
                            href: "${pageContext.request.contextPath}/album/showOne?id=" + row.id,

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
                            },

                        ]
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
                            },

                        ]
                    })
                }

            },
            {
                text: "下载音频",
                iconCls: "icon-disk_download",

            },
        ]


        $("#tt1").treegrid({
            url: "${pageContext.request.contextPath}/album/showAll",
            method: "post",
            idField: "id",
            treeField: "title",
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'duration', title: '时长', width: 60},
                {field: 'size', title: '大小', width: 80},
                {field: 'audioPath', title: '音频路径', width: 80},
                {field: 'album_id', title: '专辑ID', width: 80},
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar1,

        })
    })
</script>


<table id="tt1"></table>
<div id="dd1"></div>
<div id="dd2">
    <form>
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
</div>

<div id="dd3">
    <form>
        <div class="a1">
            uuid:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="uuid" class="easyui-textbox"
                                                                              data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">title:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="title"
                                                                                                       class="easyui-textbox"
                                                                                                       data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1"> duration:&nbsp;&nbsp;&nbsp;<input name="duration" class="easyui-textbox"
                                                           data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">size:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="size"
                                                                                                class="easyui-textbox"
                                                                                                data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">audioPath:<input name="audioPath" class="easyui-textbox"
                                         data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">album_id:&nbsp;<input name="album_id" class="easyui-textbox"
                                              data-options="required:true,width:200,height:30"/>
            <br/></div>
        <div class="a1">status:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="status" class="easyui-textbox"
                                                                          data-options="required:true,width:200,height:30"/>
        </div>
    </form>
</div>
</html>