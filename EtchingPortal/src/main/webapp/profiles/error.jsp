

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal - Companies Error</title>
    </head>
    <body>
        <header><h1>Welcome a JobPortal!</h1></header>
        <div class="content">
            <nav>
                <s:a href="../index.jsp">Return to index</s:a>
                </nav>
                <main>
                    <h1><s:property value="flashMessage"/></h1>
            </main>
        </div>
           <footer>
        
All rights reserved (CC)
        <br>
        
Contact the administrator
        <br>
       Web map
    </footer>
    </body>
</html>
