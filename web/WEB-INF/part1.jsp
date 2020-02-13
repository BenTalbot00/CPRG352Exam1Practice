<%-- 
    Document   : phrase
    Created on : Feb 12, 2020, 10:58:13 PM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 1</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <form method="POST"/>
        Enter a motivational phrase:<input type="text" name="phrase"/>
        <br/>
        <input type="submit" value="Set phrase"/>
        <form/>
        <br/>
        <h2>${returnedPhrase}</h2>
        <a href="Part2">Part 2</a>
    </body>
</html>
