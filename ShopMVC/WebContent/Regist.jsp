<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->    
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
    
	<script type="text/javascript" src="js/lrscroll.js"></script>
    
    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>
    
	<script type="text/javascript" src="js/lrscroll_1.js"></script>
    <style type="text/css">
    .tips{
			height:15px;
			position: relative;
			width:90%;
			margin-left: auto;
			margin-right: auto;
			color:red;
			font-size: 0.7em;
			background-color: #FFEBEB;
			border:1px solid #FBDBD6;
		}
    </style>
<title>购物街</title>
<script type="text/javascript">
		var cu=0;
		var pd=0;
		var rpd=0;
		var eml=0;
		var count=0;
		var ph=0;
		function checkUsername(){
			var reg=/^[a-zA-Z_][a-zA-Z0-9_]{6,16}$/;
			var usertext=document.getElementById("user");
			var username = document.getElementById("user").value;
			var message="";
			if(username==""){
				usertext.style.backgroundColor = "white";
				cu=0;
			}else if(reg.test(username)){
				usertext.style.backgroundColor = "#66CCCC";
				cu=1;
			}else{
				usertext.style.backgroundColor = "#FF9999";
				cu=0;
			}
		
		}
		function checkpassword(){
			var reg=/^[a-zA-Z0-9]{6,20}$/;
			var psd=document.getElementById("pwd");
			var password = document.getElementById("pwd").value;
			if(password==""){
				psd.style.backgroundColor = "white";
				pd=0;
			}else if(reg.test(password)){
				psd.style.backgroundColor = "#66CCCC";
				pd=1;
				if(count>0){
					checkrepassword()
				}
			}else{
				psd.style.backgroundColor = "#FF9999";
				pd=0;
			}
			
		
		}
		function checkrepassword(){
			count++;
			var rpsd=document.getElementById("rpwd");
			var repassword=document.getElementById("rpwd").value;
			var password = document.getElementById("pwd").value;
			if(repassword==""){
				rpsd.style.backgroundColor = "white";
				rpd=0;
			}
			if(password==repassword){
				rpsd.style.backgroundColor = "#66CCCC";
				rpd=1;
			}else{
				rpsd.style.backgroundColor = "#FF9999";
				rpd=0;
			}
			
		
		}
		function checkemail(){
			var reg=/^[a-zA-Z0-9_]([\.]*[a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)+$/;
			var emt=document.getElementById("email");
			var emtext=emt.value;
			var password = document.getElementById("pwd").value;
			if(emtext==""){
				emt.style.backgroundColor = "white";
				eml=0;
			}else if(reg.test(emtext)){
				emt.style.backgroundColor = "#66CCCC";
				eml=1;
			}else{
				emt.style.backgroundColor = "#FF9999";
				eml=0;
			}
			
		
		}
		function checkphone(){
			var reg=/^[0-9]{11}$/;
			var phe=document.getElementById("phone");
			var num=phe.value;
			if(num==""){
				phe.style.backgroundColor = "white";
				ph=0;
			}else if(reg.test(num)){
				phe.style.backgroundColor = "#66CCCC";
				ph=1;
			}else{
				phe.style.backgroundColor = "#FF9999";
				ph=0;
			}
			
		
		}
		function canregist(){
			if(cu==1 && pd==1 && rpd==1 && eml==1 && ph==1){
				var agree=document.getElementsByName("isAgree");
				if(agree[0].checked){
					$("#registform").submit();
				}else{
					alert("请勾选阅读用户协议！");
				}
			}else{
				alert("请确认信息全部填写正确！");
			}
			
		
		}
		
			
		
		
		

	</script>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
        <span class="fr">
        	<span class="fl">你好，请<a href="Login.jsp">登录</a>&nbsp; <a href="#" style="color:#ff4e00;">免费注册</a>&nbsp; </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<!--End Header End--> 
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="Index.html"><img src="images/logo.png" /></a></div>
    </div>
	<div class="regist">
    	<div class="log_img"><img src="images/l_img.png" width="611" height="425" /></div>
		<div class="reg_c">
        	<form id="registform" action="regist.do" method="post">
            <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="95">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">注册</span>
                    <span class="fr">已有商城账号，<a href="Login.html" style="color:#ff4e00;">我要登录</a></span>
                </td>
              </tr>
               <tr height="30">
               <%if(request.getAttribute("result")!=null){String tips=(String)request.getAttribute("result");%>
               <span class="tips"><%=tips%></span><% }%>
				</tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                <td><input name="loginName" type="text" id="user" value="" class="l_user" onblur="checkUsername()" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                <td><input name="password" type="password" id="pwd" value="" class="l_pwd" onblur="checkpassword()" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                <td><input name="repassword" type="password" id="rpwd" value="" class="l_pwd" onblur="checkrepassword()" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                <td><input name="email" type="text" id="email" value="" class="l_email" onblur="checkemail()" /></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                <td><input name="mobile" id="phone" type="text" value="" class="l_tel" onblur="checkphone()" /></td>
              </tr>
              <tr height="50">
                <td align="right">邀请人会员名 &nbsp;</td>
                <td><input type="text" value="" class="l_mem" /></td>
              </tr>
              <tr height="50">
                <td align="right">邀请人ID号 &nbsp;</td>
                <td><input type="text" value="" class="l_num" /></td>
              </tr>
              <tr height="50">
                <td align="right"> <font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>
                <td>
                    <input type="text" value="" class="l_ipt" />
                    <a href="#" style="font-size:12px; font-family:'宋体';">换一张</a>
                </td>
              </tr>
              <tr>
              	<td>&nbsp;</td>
                <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" name="isAgree" value="true" /></label><label class="r_txt">我已阅读并接受《用户协议》</label>
                    </span>
                </td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="button" value="立即注册" class="log_btn" onclick="canregist()" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<div class="btmbg">
		<div class="btm">
        	备案/许可证编号：京ICP备070360号   Copyright © 2016-2019 购物街 All Rights Reserved. 复制必究 , Technical Support: ICT Group <br />
            <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
        </div>   	
</div>
<!--End Footer End -->    

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
