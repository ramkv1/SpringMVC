<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page isELIgnored="false"%>

<c:choose>
	<c:when test="${!empty empList }">
		<h1 style="color: red;text-align: center"> Employee Report </h1>
		<table border="1" align="center" bgcolor="cyan">
			<tr style="color: red"><th>empno</th><th> emp name</th><th> job</th><th> salary</th></tr>
			<c:forEach var="emp" items="${empList}">
				<tr style="color: blue">
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.sal}</td>
				<%-- <td>${emp.deptno }</td> --%>
				<td><a href="emp_edit?no=${emp.empno }"><img src="images/edit.jpg" width="30px" height="30px"></a>
						<a href="emp_delete?no=${emp.empno }" onclick="return confirm('Do You want to delete the employee')">
				<img src="images/Delete.jpg" width="30px" height="30px"></a></td>
				</tr>
				</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	<h1 style="color: red;text-align: center">Employee Details Are Not Found</h1>
</c:otherwise>
</c:choose>

	<center>
		<h1 style="color: red;text-align: center">${resultMsg}</h1>
	</center>
	<center>
		<a href="emp_add"><img src="images/add.png" width="40px" height="50px"> Add Employee</a>
		<a href="./"><img src="images/home.png" width="40px" height="50px">Home</a>
		<!-- <a href="emp_edit">show_Employee</a> -->
		<%-- <a href="emp_delete?no=${emp.empno }"
	onclick="return confirm('Do You want to delete the employee')">
				<img src="images/Delete.jpg" width="30px" height="30px">Delete</a> --%>
	</center>
	
	
	
	
	