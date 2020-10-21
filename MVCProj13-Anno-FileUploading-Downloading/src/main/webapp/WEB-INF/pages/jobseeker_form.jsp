<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:red;text-align:center">File Uploading Form</h1>

<frm:form modelAttribute="jsFrm" enctype="multipart/form-data">
	<table style="width:500px; border: 1px solid black" align="center" bgcolor="cyan">
		<tr>
			<td>job seeker name</td>
			<td><frm:input path="jsName"/></td>
		</tr>
		<tr>
			<td>job seeker address</td>
			<td><frm:input path="jsAddrs"/></td>
		</tr>
		<tr>
			<td>job seeker age</td>
			<td><frm:input path="jsAge"/></td>
		</tr>
		<tr>
			<td>job seeker resume</td>
			<td><input type="file" name="resume"/></td>
		</tr>
		<tr>
			<td>job seeker photo</td>
			<td><input type="file" name="photo"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="upload"></td>
			<td><input type="reset" value="canel"></td>
	</table>
</frm:form> 