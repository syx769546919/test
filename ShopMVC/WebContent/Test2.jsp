<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("input").click(function(){
			$.ajax({
				url:"getdata.do",
				dataType:"json",
				type:"post",
				data:{
					name:"lisi"
				},
				success:function(data){
					
					$("div").text(data.id+","+data.userName+","+data.phone+","+data.pwd)
				}
				
			});
		});
	});

</script>
</head>
<body>
	<h2>aaaa</h2>
	<h1><div></div></h1>
	<input type="button" value="ajax">
</body>
</html>