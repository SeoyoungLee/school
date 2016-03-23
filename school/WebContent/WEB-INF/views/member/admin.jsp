<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>

<table>
<tr>
	<td>아이디</td>
	<td>JAVA</td>
	<td>SQL</td>
	<td>JSP</td>
	<td>SPRING</td>
	<td>이름</td>
	<td>비밀번호</td>
	<td>주소</td>
	<td>생년월일</td>
	</tr>
</table>

<c:forEach var="info" items="${list}">
<tr>
	<td>${list}</td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>

</c:forEach>
