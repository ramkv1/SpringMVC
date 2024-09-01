<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color: red;text-align: center">Employee Report page</h1>

<c:choose>
	<c:when test="${!empty jsInfo }">
		<table border="1" bgcolor="cyan" align="center">
		
			<tr>
				<th>JsId</th>
				<th>JsName</th>
				<th>JsAddress</th>
				<th>Resume</th>
				<th>Photo</th>
			</tr>
			<c:forEach var="js" items="${jsInfo}">
				<tr>
					<td>${js.jsId }</td>
					<td>${js.jsName }</td>
					<td>${js.jsAddrs }</td>
					<td><a href="download?id=${js.jsId }&type=resume">Download Resume</a></td>
					<td><a href="download?id=${js.jsId }&type=photo">Download Photo</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center"> Record Not Found</h1>
	</c:otherwise>
</c:choose>
