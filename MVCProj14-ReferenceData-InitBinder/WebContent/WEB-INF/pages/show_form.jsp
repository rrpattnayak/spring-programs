<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
    
    <h1 style="color:red;text-align:center">Home Page</h1>
    
    <frm:form modelAttribute="perFrm">
    	<p style="color:red"></p>
    	<table align="center" bgcolor="cyan" border="0">
    		<tr>
        		<td>Person name  </td>
        		<td><frm:input path="name"/> </td>
     		</tr>
     		<tr>
        		<td>Person addrs  </td>
        		<td><frm:input path="address"/> </td>
     		</tr>
     		<tr>
        		<td>Person mobileNo  </td>
        		<td><frm:input path="mobileNo"/> </td>
     		</tr>
    		<tr>
    			<td>Person gender</td>
    			<td>
    				<frm:radiobuttons path="gender" items="${genderList}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>hobbies </td>
        		<td>
        			<frm:checkboxes path="hobbies"  items="${hobbiesList}" />
        		</td>
     		</tr>
     		<tr>
        		<td>Qualification  </td>
        		<td>
          			<frm:select path="qlfy">
               			<frm:options items="${qlfyList}"/>
           			</frm:select>
         		</td>
     		</tr>
     		<tr>
     			<td>Favroite color</td>
     			<td>
     				<frm:select path="colors" multiple="multiple">
     					<frm:options items="${colorsList}"/>
     				</frm:select>
     			</td>
     		</tr>
     		<tr>
     			<td>DOB (DD-MM-YYYY)</td>
     			<td>
     				<frm:input type="Date" path="dob"/>
     			</td>
     		</tr>
     		<tr>
     			<td>DOJ (DD-MM-YYYY)</td>
     			<td>
     				<frm:input type="Date" path="doj"/>
     			</td>
     		</tr>
     		<tr>
     			<td>Salary Range</td>
     			<td>
     				<frm:input type="range" min="10000" max="100000" path="salary"/>
     			</td>
     		</tr>
     		<tr>
     			<td colspn="2"><input type="submit" value="register"></td>
     		</tr>
    	</table> 	
    </frm:form>
        