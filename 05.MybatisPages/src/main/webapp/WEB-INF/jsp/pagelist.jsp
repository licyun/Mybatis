<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>mybatis分页</title>
</head>
<style>
tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

td {
	border-left: 1px solid #dddddd;
}
</style>
<body>
    <div style="width: 600px; margin: auto;">用户：${user.username}&nbsp;联系方式：${user.mobile}<br/></div>
	<table style="width: 60%; border: 1px solid #dddddd;" border="1"
		align="center">
		<tr>
			<th>编号</th>
			<th>订单号</th>
			<th>金额</th>
		</tr>

		<c:forEach items="${orders}" var="order">
			<tr>
				<td align="center">${order.order_id}</td>
				<td align="center">${order.order_no}</td>
				<td align="center">${order.money}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
			<!-- currentPage是当前页 -->
			<a href="${pageContext.request.contextPath}/user/orderpages?page=${currentPage==1?currentPage:currentPage- 1}">上一页</a>  &nbsp;
			<a href="${pageContext.request.contextPath}/user/orderpages?page=${currentPage+ 1}">下一页</a>
				</td>
		</tr>
	</table>
</body>
</html>
