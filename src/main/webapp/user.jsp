<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<script type="text/javascript">

    $(function () {
        $("#btn").click(function (data) {
            var titles = $("#customer_tree").combotree("getText");
            var params = $("#customer_tree").combotree("getValues");
            var a = "";
            $.each(params, function (index, param) {
                if (params.length - 1 == index) {
                    a += param;
                } else {
                    a += param + ",";
                }
            })
            $("#customer_form").form("submit", {
                url: "${pageContext.request.contextPath}/user/customerExport",
                queryParams: {
                    titles: titles,
                    params: a
                }
            })
        })

        var toolbar = [
            {
                text: "修改",
                iconCls: "icon-bullet_edit",
                handler: function () {
                    /*
                     *使当前选中行可编辑模式
                     * */
                    var row = $("#user_datagrid").edatagrid("getSelected");
                    if (row != null) {

                        var index = $("#user_datagrid").edatagrid("getRowIndex", row)
                        //当前行可编辑
                        $("#user_datagrid").edatagrid("editRow", index)

                    } else {
                        alert("请先选中行")
                    }


                }
            },
            {
                text: "下载模板",
                iconCls: "icon-arrow_down",
                iconAlign: "right",
                handler: function () {
                    var row = $("#user_datagrid").datagrid("getSelected");
                    location.href = "${pageContext.request.contextPath}/user/down?excelPath=" + "/user.xls" + "&name=user"

                }

            }, {
                text: "自定義",
                iconCls: "icon-flower_daisy",
                iconAlign: "right",
                handler: function () {
                    $("#customer_dd").dialog("open")

                },


            },
        ]

        $("#user_datagrid").datagrid({
            url: '${pageContext.request.contextPath}/user/showAll',
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [2, 4, 9, 12],
            pageSize: 2,
            rownumbers: true,
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'photoImg', title: '头像', width: 100},
                {field: 'name', title: '名称', width: 100},
                {field: 'dharmaName', title: '法名', width: 100},
                {field: 'sex', title: '性别', width: 100},
                {field: 'province', title: '省份', width: 100},
                {field: 'city', title: '城市', width: 100},
                {field: 'sign', title: '签名', width: 100},
                {field: 'phoneNum', title: '电话', width: 100},
                {field: 'password', title: '密码', width: 100},
                {field: 'salt', title: '私盐', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: 'text',
                        options: {
                            required: true,
                        }
                    }
                },
                {field: 'registDate', title: '注册日期', width: 100},
                {field: 'guru_id', title: '上师ID', width: 100},
            ]],
            toolbar: toolbar,

        })


    })


</script>
<table id="user_datagrid"></table>
<div id="customer_dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <select id="customer_tree" class="easyui-combotree" style="width:200px;"
            data-options="checkbox:true,multiple:true,onlyLeafCheck:true,required:true,
            data:[{
    'id':'custome',
    'checked':false,
    'text': '请选择',
    'children': [
      {
        'id':'id',
        'text': '编号',
        'checked': true
      },
      { 'id':'name',
        'text': '名字',
        'checked': true
      },
      { 'id':'dharmaName',
        'text': '法名',
        'checked': true
      },
       {
        'id':'photoImg',
        'text': '頭像',
        'checked': true
      },
      { 'id':'sex',
        'text': '性別',
        'checked': true
      },
      { 'id':'province',
        'text': '省份',
        'checked': true
      },
       {
        'id':'city',
        'text': '城市',
        'checked': true
      },
      { 'id':'name',
        'text': '名字',
        'checked': true
      },
      { 'id':'sign',
        'text': '簽名',
        'checked': true
      },
       {
        'id':'phoneNum',
        'text': '電話',
        'checked': true
      },
      { 'id':'password',
        'text': '密碼',
        'checked': true
      },
      { 'id':'salt',
        'text': '私鹽',
        'checked': true
      },
       {
        'id':'status',
        'text': '狀態',
        'checked': true
      },
      { 'id':'registDate',
        'text': '註冊日期',
        'checked': true
      },
      { 'id':'guru_id',
        'text': '上師ID',
        'checked': true
      },
    ]
  }
]"></select>
    <form action="" method="post" id="customer_form">
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-flower_daisy'">提交</a>
    </form>

</div>
</html>