
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
    <head>
        <title>Ini Form</title>
    </head>
    <body>
        <p>${error}</p>
       <form:form method="post" action="formlogin">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="nama" placeholder="dcdc" /></td>  
         </tr>    
         <tr>    
          <td>Nim :</td>    
          <td><form:input path="nim" /></td>  
         </tr>     
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
    </body>
</html>
      