<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">

function login() {
	alert($('#form1').serialize());
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "us/log" ,//url
        data: $('#form1').serialize(),
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}





function SendShort() {
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "shortmessage/AddShotr",//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}




function Mohu(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectDayHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function SelectHm(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function SelectExcel(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}


function SelectExcelDay(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function GroupName(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "con/UpdateGroup" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}


function login() {
	alert($('#form1').serialize());
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "us/log" ,//url
        data: $('#form1').serialize(),
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function GroupFz() {
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "grou/SelectGroup" ,//url
        data:{
        	page:1
        },
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}


function SelectExcelInput(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "exce/InputStema" ,//url
        data:{
        	files:"E:\\rr11.xls"
        },
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function TONUmber(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "shortmessage/test" ,//url
        data:{
        	files:"E:\\rr11.xls"
        },
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}






</script>
</head>
<body>
<center>
<form id="form1" action="exce/ExcelMoth" method="post">
 <p>用户名：<input name="username" type="text" id="txtUserName" tabindex="1" size="16" value=""  /></p>
 <p>密　码：<input name="password" type="password" id="TextBox2" tabindex="2" size="16" value=""/></p>
 <p><input type="button" value="登录" onclick="login()"><input type="reset" value="重置"></p>
 <p><input type="button" value="模糊查询日消费" onclick="Mohu()"></p>
  <p><input type="button" value="模糊查询" onclick="SelectHm()"></p>
  <p><input type="button" value="导入" onclick="SelectExcelInput()"></p>
  <p><input type="button" value="修改分组" onclick="GroupName()"></p>
  <p><input type="button" value="分组查询" onclick="GroupFz()"></p>
 
    <p><input type="submit" value="导出excel月记录"></p>
</form>

<form action="exce/ExcelDay">
<p><input type="submit" value="导出excel日记录"></p>
</form>

<form action="exce/ToExcelGroup">
<p><input type="submit" value="通讯录模板"></p>
</form>

<form action="shortmessage/test">
<p><input type="submit" value="导出手机号"></p>
</form>


<form action="exce/NumberExcel">
<p><input type="submit" value="联系方式导出"></p>
</form>



<form action="exce/export">
<p><input type="submit" value="消费流水导出"></p>
</form>

<form method="post"  enctype="multipart/form-data" id="form1" action="exce/InputExcels">  
        <table>  
         <tr>  
            <td>上传文件: </td>  
            <td> <input id="upfile" type="file" name="upfile" accept=".xls,.xlsx" /></td>  
            <td><input  type="submit" value="提交"/></td>  
         </tr>  
        </table>    
    </form>
    <form action="exce/TophoneNumber">
<p><input type="submit" value="下行报告"></p>
</form>
    
</center>	
</body>
</html>