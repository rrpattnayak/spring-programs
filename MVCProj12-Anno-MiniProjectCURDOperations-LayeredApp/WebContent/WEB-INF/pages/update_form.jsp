
  <%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<head>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
</head>
<div class="container">
<h1 class="text-primary text-center"> Employees Editing page </h1>
<frm:form  action="editEmp.htm"  modelAttribute="employee">
   <table class="table table-responsive " bgcolor="pink" >
   <tr>
        <td>Employee id:: </td>
        <td> <frm:input path="empNo" readonly="true" />  </td>
      </tr>
      <tr>
        <td>Employee name :: </td>
        <td> <frm:input path="ename"/> <frm:errors  path="ename"  cssClass="text-danger"/> </td>
      </tr>
      <tr>
        <td>Employee desg :: </td>
        <td> <frm:input path="job"/> <frm:errors  path="job"  cssClass="text-danger"/> </td>
      </tr>
      <tr>
        <td>Employee salary :: </td>
        <td> <frm:input path="sal"/>  <frm:errors  path="sal"  cssClass="text-danger"/> </td>
      </tr>
      <tr>
        <td>Employee deptno :: </td>
        <td>  <frm:select path="deptNo">
                    <frm:options items="${deptsInfo}"/>
             </frm:select> 
             </td>  
      </tr>
      <tr>
        <td > <input type="submit"  value="update Employee"> </td>
      </tr>
      
   </table>
</frm:form>
 </div>
