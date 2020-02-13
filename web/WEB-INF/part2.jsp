<%-- 
    Document   : part2
    Created on : Feb 12, 2020, 11:22:23 PM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 2</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <h2>${returnedPhrase}</h2>
        <form method="POST"/>
            Name: <input type="text" name="name"/>
            <br/>
            Age: <input type="text" name="age"/>
            <br/>
            <input type="submit" value="Add"/>
        <form/>
        <br/>
        <br/>
        Average age: <fmt:formatNumber type="number" minFractionDigits="1" maxFractionDigits="1" value="${averageAge}" />
    </body>
</html>
