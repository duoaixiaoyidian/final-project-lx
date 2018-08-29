<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<style type="text/css">
    .a1 {
        margin-top: 20px;
    }
</style>
<script type="text/javascript">

    $(function () {

        var toolbar = [{
            iconCls: 'icon-basket_add',
            text: "添加",
            handler: function () {
                $("#dd").dialog({
                    width: 300,
                    height: 400,
                    title: '添加banner',
                    iconCls: 'icon-award_star_add',
                    buttons: [{
                        text: '提交',
                        iconCls: 'icon-tick',
                        handler: function () {
                            $("#fom").submit();
                        }
                    }

                    ]
                });
                //初始化表单
                $("#fom").form({
                    url: '${path}/banner/add',
                    onSubmit: function () {
                        return true;
                    },
                    success: function () {
                        //关闭dialog
                        $("#dd").dialog("close");
                        //刷新datagrid
                        $("#dg").datagrid("load");
                    }
                })
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-control_remove_blue',
            handler: function () {
                var row = $("#dg").edatagrid("getSelected");
                if (row) {
                    var id = row.id;
                    $.ajax({
                        type: "post",
                        url: "${pageContext.request.contextPath}/banner/delete",
                        data: "id=" + id,
                        dataType: "text",
                        success: function () {
                            $("#dg").datagrid("load");
                        }
                    });
                } else {
                    alert("请先选中行")
                }
            },

        }, '-', {
            text: "修改",
            iconCls: 'icon-bullet_edit',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {

                    var index = $("#dg").edatagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }


            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-script_save',
            handler: function () {
                //保存编辑行并发送到服务器
                $("#dg").edatagrid("saveRow")
            }
        }]


        $('#dg').edatagrid({
            url: '${path}/banner/all',
            updateUrl: "${path}/banner/update",
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [3, 6, 9, 12],
            pageNumber: 1,
            pageSize: 3,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>createDate: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '<p>imgPath: ' + rowData.imgPath + '</p>' +
                    '<p>Description: ' + rowData.description + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            columns: [[
                {field: 'id', title: 'ID', width: 100},
                {field: 'title', title: '名称', width: 100},
                {field: 'imgPath', title: '路径', width: 100,},
                {field: 'description', title: '描述', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: 'text',
                        options: {
                            required: true,
                        }
                    }
                },
                {field: 'createDate', title: '上传日期', width: 100},
            ]],
            toolbar: toolbar,

        });


    })


</script>

<table id="dg"></table>

<div id="dd" style="display: none">
    <form id="fom">
        <div class="a1">
            id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="id" name="id"
                                                                                               class="easyui-textbox"
                                                                                               data-options="required:true,width:200,height:30"/>
        </div>
        <div class="a1">
            title:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="title"
                                                                                                  name="title"
                                                                                                  class="easyui-textbox"
                                                                                                  data-options="required:true,width:200,height:30"/>
        </div>
        <div class="a1">
            imgPath:&nbsp;&nbsp;&nbsp;&nbsp; <input id="imgPath" name="imgPath" class="easyui-textbox"
                                                    data-options="width:200,height:30"/>
        </div>
        <div class="a1">
            description: <input id="description" name="description" class="easyui-textbox"
                                data-options="required:true,width:200,height:30"/>
        </div>
        <div class="a1">
            status: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="status" name="status" class="easyui-textbox"
                                                                      data-options="required:true,width:200,height:30"/>
        </div>
        <%-- <div class="a1">
             createDate:  <input id="createDate" name="createDate" class="easyui-datetimebox" data-options="width:200,height:30"/>
         </div>--%>

    </form>
</div>
</html>