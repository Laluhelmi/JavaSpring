<%@ taglib prefix="asset" uri="http://www.springframework.org/tags"%>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <asset:url value="/asset/bootstrap.css" var="css"/>
        <link rel="stylesheet" href="${css}"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <div class="container">
  <div class="jumbotron">
    <h1>Bootstrap Tutorial</h1> 
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing
    responsive, mobile-first projects on the web.</p> 
  </div>
</div>
    </body>
</html>
