<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
	<title><tiles:insertAttribute name="title"/></title>
</head>
<table border="0" width="100%" height="100%">
	<tr bgcolor="yellow" height="30%">
		<td colspan="3"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr bgcolor="cyan" height="60%">
		<td width="30%"><tiles:insertAttribute name="menu"/> </td>
		<td width="40%"><tiles:insertAttribute name="body"/> </td>
		<td width="30%"><tiles:insertAttribute name="adds"/> </td>
		<td></td>
	</tr>
	<tr bgcolor="pink" height="10%">
		<td colspan="3"><tiles:insertAttribute name="footer"/></td>
	</tr>
	</table>