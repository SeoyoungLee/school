<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<table>
	<tr>
		<td><h3>과목</h3></td>
		<td><h3>점수</h3></td>
	</tr>
	<tr>
		<td><h3>java</h3></td>
		<td>${grade.java}</td>
	</tr>
	<tr>
		<td><h3>sql</h3></td>
		<td>${grade.sql}</td>
	</tr>
	<tr>
		<td><h3>jsp</h3></td>
		<td>${grade.jsp}</td>
	</tr>
	<tr>
		<td><h3>spring</h3></td>
		<td>${grade.spring}</td>
	</tr>
</table>

<jsp:include page="../global/footer.jsp"></jsp:include>