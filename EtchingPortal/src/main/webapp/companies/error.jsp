<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal - Companies Error</title>
    </head>
    <body>
        <header><h1>you are welcome a JobPortal!</h1></header>
        <div class="content">
            <nav>
                <s:if test="#session.role=='company'">
                  business menu<br>
                    you are welcome <strong><s:property value="#session.userName"/></strong>
                    <ul>
                        <li><s:a href="../index.jsp">Return to index</s:a></li>
                        <li><s:url id="viewURL" action="viewCompany" namespace="/companies">
                                <s:param name="id" value="%{#session.id}"></s:param>
                            </s:url><s:a href="%{viewURL}">View company</s:a></li>
                        <li><a href="<s:url action='addJob' namespace="/jobs"/>">Add job</a></li>
                        <li><s:url id="viewURL" action="jobs/listJob">
                                <s:param name="id" value="%{#session.id}"></s:param>
                            </s:url>
                            <s:a href="%{viewURL}">See published work</s:a></li>
                        <li><a href="<s:url action='LogOutAction' namespace="/"/>">Sign off</a></li>
                    </ul>

                </s:if>
                <s:else>
                    <s:a href="../index.jsp">Return to index</s:a>
                </s:else>
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
