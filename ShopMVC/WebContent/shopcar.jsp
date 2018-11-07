<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<style type="text/css">
	div{
		margin-left: auto;
		margin-right: auto;
		text-align: center;
	}
	table{
		margin:auto;
		font-weight: bold;
	}
	img {
			height:100px;
		}
	tr{
		height:100px;
		
	}
	td{
		width:150px;
		border-bottom:1px dashed #cccccc;
	}
	.count{
		width:64px;
		
		}
	.count div{
		margin-bottom:0;
		border-bottom:1px solid #A5A5A5;
		border-top:1px solid #A5A5A5;
		width:20px;
		height:20px;
	}
	td div{
		display:inline-block;
	}
	.count inpute{
		margin-bottom:0;
		display:inline-block;
		width:20px;
	}
</style>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#allcheck").click(function(){
			$("table input:checkbox").prop('checked',$(this).is(':checked')?true:false);
		});
		$("input[type=checkbox]:gt(0)").click(function(){
			var checkedCount = $("input[type=checkbox]:gt(0):checked").length;
			var trCount = $("tr:gt(0)").length;
			var flag = false;
			if(checkedCount==trCount){
				flag = true;
			}
			$("input[type=checkbox]:first").prop("checked",flag);
		});
		$("table").on("click","input[value=删除]",function(){
			var goodsId=$(this).parent().parent().attr("id");
			$.ajax({
				url:"OperateCart",
				type: "post",
				data:{
					"goodsId": goodsId,
					"operate": "remove"
				},
				dataType: "json",
				success:function(data){	
					$("#sumprize").text(data.amount);
				}
			});
			$(this).parent().parent().remove();
		});
		
		
		/* $("table tr").each(function(trindex,tritem){
			if(trindex>0){
			var count=$(tritem).find("td:eq(2)").children().find("div").text();
			var prize=$(tritem).find("td:eq(3)").children().val();
			var sum=count*prize;
			alert(prize);
			$(tritem).find("td:eq(5)").children().text(sum);
			}
		  });
 */
	}); 
	
	function removeall() {
		var removetr=new Array();
		$("table tr").each(function(trindex,tritem){
			if(trindex>0){
			var checkbox=$(tritem).find("td:eq(0)").children();
			if($(checkbox).is(':checked')){
			var goodsId=$(tritem).attr("id");
				$.ajax({
					url:"OperateCart",
					type: "post",
					data:{
						"goodsId": goodsId,
						"operate": "remove"
					},
					dataType: "json",
					success:function(data){	
						$("#sumprize").text(data.amount);
					}
				});
				$(this).remove();
			}
			}
		  });
		

	}
	function addcount(obj){
		var count=$(obj).prev().text();
		var goodsId=$(obj).parent().parent().parent().attr("id");
		count++;
		$.ajax({
				url:"OperateCart",
				type: "post",
				data:{
					"goodsId": goodsId,
					"operate": "add"
				},
				dataType: "json",
				success:function(data){
					$("#sumprize").text(data.amount.toFixed(2));
				}
			});
		
		
		$(obj).prev().text(count);
		var prize=$(obj).parent().parent().next().children().text();
		var sum=count*prize;
		$(obj).parent().parent().next().next().next().children().text(sum.toFixed(2));
	}
	function removecount(obj){
		var count=$(obj).next().text();
		var goodsId=$(obj).parent().parent().parent().attr("id");
		if(count>1){
		count--;
		$.ajax({
			url:"OperateCart",
			type: "post",
			data:{
				"goodsId": goodsId,
				"operate": "reduce"
			},
			dataType: "json",
			success:function(data){
				$("#sumprize").text(data.amount.toFixed(2));
			}
		});	
		$(obj).next().text(count);
		var prize=$(obj).parent().parent().next().children().text();
		var sum=count*prize;
		$(obj).parent().parent().next().next().next().children().text(sum.toFixed(2));
		}
		
	}
	function ifallcheck(obj) {
		if($(obj).not(':checked')){
			$("#allcheck").prop("checked",false);
		}
	}

</script>
</head>
<body>
<div>
	<table>
	
	
	
		<tr>
			<td><input type="checkbox" id="allcheck">全选</td>
			<td>商品图片</td>
			<td>数量</td>
			<td>单价</td>
			<td>商品名称</td>
			<td>小计</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${cartInfo.cartList}" var="sc">
			<tr id="${sc.goods.id}">
			<td><input type="checkbox" onclick="ifallcheck(this)"></td>
			<td><img src="${sc.goods.picture}"></td>
			<td><div class="count"><input type="button" value="-" onclick="removecount(this)"><div>${sc.qty}</div><input type="button" value="+" onclick="addcount(this)"></div></td>
			<td>$<div><fmt:formatNumber value="${sc.goods.prize}" pattern="###0.00"></fmt:formatNumber></div></td>
			<td>${sc.goods.name}</td>
			<td>$<div><fmt:formatNumber value="${sc.goods.prize*sc.qty}" pattern="###0.00"></fmt:formatNumber></div></td>
			<td><input type="button" value="删除" ></td>
			</tr>
		</c:forEach>
		
	</table>
	<input type="button" value="全删" onclick="removeall()">
	<input type="button" value="增加一行">
	总计：$<span id="sumprize"><fmt:formatNumber value="${cartInfo.amount}" pattern="#,##0.00"></fmt:formatNumber></span>
</div>
</body>
</html>