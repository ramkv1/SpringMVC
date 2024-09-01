<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1 style="color: red;text-align: center"><spring:message code="customer.form.title"/></h1>

<frm:form modelAttribute="cust">

	<table border="0" align="center" bgcolor="cyan">
	<tr>
		<td><spring:message code="customer.form.name"/></td>
		<td><frm:input path="cname"/></td>
	</tr>
	<tr>
		<td><spring:message code="customer.form.billAmt"/></td>
		<td><frm:input path="BillAmount"/></td>
	</tr><tr>
		<td><spring:message code="customer.form.addrs"/></td>
		<td><frm:input path="caddrs"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value='<spring:message code="customer.form.submit"/>'></td>
	</tr>
	</table>
</frm:form>

<br><br><br>
<hr>
<a href="?lang=fr_FR">French</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<a href="?lang=de_DE">German</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<a href="?lang=hi_IN">Hindi</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<a href="?lang=zh_CN">Chinese</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<a href="?lang=en_US">English</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
