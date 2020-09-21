<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:green;text-align=center"><u>Result Page</u></h1>
    
    <%-- <h2 style="color:red;text-align=center">${scl}</h2> --%>
    <c:forEach var="country" items="${scl}">
    	<h2 style="color:red;text-align=center"><c:out value="${country}"/></h2><p>
    </c:forEach>
    <h2><a href="welcome.htm">home</a></h2>
