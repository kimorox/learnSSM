<%--
  Created by IntelliJ IDEA.
  User: kimoro
  Date: 2021/1/30
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script>
        //页面加载，绑定单击时间
        $(function () {
            $("#btn").click(function () {
                // alert("hello");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"哈哈","password":"123456","age":18}',
                    dataType:"json",
                    type:"post",
                    success:function (data){
                        //data:服务器端响应的json数据，进行解析
                        alert(data);
                    }
                })
            });
        });
    </script>
</head>
<body>
<button id="btn">发送ajax请求</button>
</body>
</html>
