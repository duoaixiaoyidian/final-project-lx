<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    pageContext.setAttribute("path", path);
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="echarts.min.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '用户状态',
            subtext: "纯属虚构"
        },
        tooltip: {},
        legend: {
            data: ['持明法洲APP活跃用户']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [
            {
                name: '持明法洲APP活跃用户',
                type: 'bar',
                data: []
            },


        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    $.ajax({
        url: "${pageContext.request.contextPath}/user/bar",
        type: "post",
        dataType: "JSON",
        traditional: true,
        data: {day: [7, 14, 21, 31]},
        success: function (data) {
            myChart.setOption({
                xAxis: {
                    data: data.xAxis,
                },
                series: [{
                    name: '持明法洲APP活跃用户',
                    type: 'line',
                    data: data.men
                }]

            })
        }
    })


</script>
</body>
</html>
