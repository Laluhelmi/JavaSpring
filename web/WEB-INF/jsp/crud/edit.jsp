<%-- 
    Document   : tambah
    Created on : Feb 27, 2017, 11:43:23 PM
    Author     : L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="asset" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
        <script>
            function load(){
       // document.getElementById("nim").disabled = true;
        
            }
        </script>
        <asset:url value="/asset/iseng.css" var="css"/>
        <link rel="stylesheet" href="${css}"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="load()">
        <div class="container">  
            <form:form id="contact" action="/Learning/edit/${id}" method="post">
                <h3>Colorlib Contact Form</h3>
                <c:forEach items="${error}" var="e">
                    <h4>${e.getDefaultMessage()}</h4>
                </c:forEach>
                <fieldset>
                    <form:input path="nim" placeholder="Nim ...."type="text"
                                id="nim" readonly="${true}"
                        />
                </fieldset>
                <fieldset>
                    <form:input path="nama" placeholder="Nama ...."
                                />
                </fieldset>
                <fieldset>
                    <form:textarea path="alamat" placeholder="alamat"/>
                </fieldset>
                <fieldset>
                    <button name="submit" type="submit" id="contact-submit" 
                            data-submit="...Sending">Submit</button>
                </fieldset>
            </form:form>>
        </div>
    </body>
</html>
