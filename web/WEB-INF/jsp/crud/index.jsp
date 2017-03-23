<%@ taglib prefix="asset" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="data"%>  
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <asset:url value="/asset/bootstrap.css" var="css"/>
        <link rel="stylesheet" href="${css}"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body style="">
        <div class="container">
            <div class="jumbotron">
                <h1>Simple Java Spring</h1> 
                <p>Lagi coba coba bikin web pake framework JAVA Spring ternyata seru juga ..</p> 
            </div>
            <a href="tambahdata" class="btn btn-info" role="button">Tambah Mahasiswa</a>
            <data:choose>
                <data:when test="${f:length(isi) >0}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nim</th>
                                <th>Nama</th>
                                <th>Alamat</th>
                                <th>Action</th>

                            </tr>
                        </thead>
                        <tbody>
                            <data:forEach var="d" items="${isi}">
                                <tr>
                                    <td form:>${d.nim}</td>
                                    <td>${d.nama}</td>
                                    <td>${d.alamat}</td>
                                    <td style="margin-left: 100px   ">
                                        <a href="edit/${d.nim}" class="btn btn-warning" role="button">Edit</a>
                                        <a href="hapus/${d.nim}" class="btn btn-danger"
                                           role="button">Hapus</a>
                                    </td>
                                </tr>
                            <div ></div>
                        </data:forEach>

                        </tbody>
                    </table>
                </data:when>
                <data:when test="${f:length(isi) ==0}">
                    <p>Belum ada data</p>
                </data:when>
            </data:choose>

        </div>
    </body>
</html>
