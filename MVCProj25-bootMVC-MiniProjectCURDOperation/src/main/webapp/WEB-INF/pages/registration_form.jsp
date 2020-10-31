<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<head>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
   
</head>
<div class="container">
<h1 class="text-primary text-center"> Employees Registration page </h1>

<frm:form  modelAttribute="empFrm">
   <table class="table table-responsive " bgcolor="cyan" >
      <tr>
        <td>Employee name :: </td>
        <td> <frm:input path="ename"/> <frm:errors  cssClass="text-danger" path="ename"/> </td>
      </tr>
      <tr>
        <td>Employee desg :: </td>
        <td> <frm:input path="job"/> <frm:errors   cssClass="text-danger" path="job"/> </td>
      </tr>
      <tr>
        <td>Employee salary :: </td>
        <td> <frm:input path="sal"/> <frm:errors  cssClass="text-danger" path="sal"/> </td>
      </tr>
      <tr>
        <td>Employee deptno :: </td>
        <td>  <frm:select path="deptNo">
                    <frm:options items="${deptsInfo}"/>
             </frm:select> 
             </td>  
      </tr>
      <tr>
        <td  > <input type="submit"  value="register"> </td> 
      </tr>
   </table>
    
</frm:form>
 </div>