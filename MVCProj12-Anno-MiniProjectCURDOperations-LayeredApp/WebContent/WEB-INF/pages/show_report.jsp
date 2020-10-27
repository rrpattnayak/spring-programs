  
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<h1 class="text-primary text-center"> Employees Info Report </h1>
<head>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
</head>
<div class="container">
<c:choose >
    <c:when test="${empsInfo ne null && !empty empsInfo }">
        <table class="table table-bordered  table-secondary">
             <tr class="bg-primary">
               <th style="text-align:center">EmpNo </th>
               <th style="text-align:center">EmpName </th>
               <th style="text-align:center">Desg </th>
               <th style="text-align:center">Salary </th>
               <th style="text-align:center">GrorssSalary </th>
               <th style="text-align:center">NetSalary </th>
               <th style="text-align:center">DeptNo </th>
               <th style="text-align:center">Operations </th>
              </tr>
              <c:forEach  var="dto"  items="${empsInfo}">
                   <tr class="table-danger" >
                      <td><b><h5 style="text-align:center">${dto.empNo} </h5></b> </td>
                      <td><b><h5 style="text-align:center">${dto.ename}  </h5></b></td>
                      <td><b><h5 style="text-align:center">${dto.job}  </h5></b></td>
                      <td><b><h5 style="text-align:center">${dto.sal}  </h5></b></td>
                      <td><b><h5 style="text-align:center">${dto.grossSalary}  </h5></b></td>
                      <td><b><h5 style="text-align:center">${dto.netSalary}  </h5></b></td>
                      <td><b><h5 style="text-align:center">${dto.deptNo}    </h5></b></td>
                      
                      <td>
                          <a href="editEmp.htm?empNo=${dto.empNo}"><img src="images/edit.png" width="70" height="70"/></a>
                          <a href="deleteEmp.htm?eno=${dto.empNo}"  onclick="confirm('are you sure you want to delete this record ')"><img src="images/delete.png" width="70" height="70"/></a>
                      </td>
                   </tr>
              </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
         <h1 >Records not found</h1>
    </c:otherwise>
</c:choose>
<br><br>
<c:if test="${resultMsg ne null && !empty resultMsg}">
   <marquee direction="right"><h1 class="text-primary font-weight-bold">${resultMsg}</h1> </marquee>
   </c:if>
<br><br>
<h2><a href="saveEmp.htm"><img src="images/save.jpg" width="100" height="100"/></a> 
    &nbsp; &nbsp;<a href="welcome.htm"><img src="images/home.png" width="100" height="100"/></a>
    &nbsp; &nbsp;<a  href="JavaScript:doPrint()"><img src="images/print.jpg" width="100" height="100"></a>
</h2> 
</div>
  <script language="JavaScript">
      function doPrint(){
    	  frames.focus();
    	  frames.print();
      }
 </script>
  
