<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal</title>
    </head>
    <body>
    <header><h1>you are welcome a JobPortal!</h1></header>
    <div class="content">
        <nav>
            <s:if test="#session.role=='candidate'">
                menu of candidates<br>
                welcome <strong><s:property value="#session.userName"/></strong>
                <ul>
                    <li><s:a href="../index.jsp">return to index</s:a></li>
                    <li><s:url id="viewURL" action="viewProfile" namespace="/profiles">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View profile</s:a></li>
                    <li><s:url id="viewURL" action="viewCandidate" namespace="/candidates">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View candidate</s:a></li>
                    <li><a href="<s:url action='LogOutAction' namespace="/"/>">Sign off</a></li>
                </ul>
            </s:if>
            <s:elseif test="#session.role=='admin'">
                <ul>
                    <li><s:a href="../index.jsp">return to index</s:a></li>
                    <li><a href="<s:url action='listCandidate' namespace="/candidates"/>">List Candidates</a></li>
                    <li><a href="<s:url action='listCompany' namespace="/companies"/>">List companies</a></li>
                </ul>
            </s:elseif>
            <s:elseif test="#session.role=='company'">
                business menu<br>
               welcome<strong><s:property value="#session.userName"/></strong>
                <ul>
                    <li><s:a href="../index.jsp">return to index</s:a></li>
                    <li><s:url id="viewURL" action="viewCompany" namespace="/companies">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url><s:a href="%{viewURL}">View company</s:a></li>
                    <li><a href="<s:url action='addJob' namespace="/jobs"/>">Add job</a></li>
                    <li><s:url id="viewURL" action="listJob" namespace="/jobs">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">See published work</s:a></li>
                    <li><a href="<s:url action='LogOutAction' namespace="/"/>">Sign off</a></li>
                </ul>

            </s:elseif>
            <s:else>
                <s:a href="index.jsp">return to index</s:a>
            </s:else>
        </nav>
        <main>
            <h1>Search</h1>
            <h1><s:property value="flashMessage"/></h1>
            <s:if test="#session.role=='company'">

                <s:iterator value="listProfile" status="profileStatus">
                    <table class="list">
                        <tr>
                            <th>First name</th>
                            <td><s:url id="viewURL" action="viewProfile" namespace="/profiles">
                                    <s:param name="id" value="%{id}"></s:param>
                                </s:url><s:a href="%{viewURL}"><s:property value="%{name}"/></s:a>
                                </td>
                            </tr>
                            <tr>
                                <th>Curriculum</th>
                                <td><s:property value="curriculum" /></td>
                        </tr>
                        <tr>
                            <th>Categories</th>
                            <td><s:property value="category" /></td>
                        </tr>
                        <tr>
                            <th>location</th>
                            <td><s:property value="location" /></td>
                        </tr>
                        <tr>
                            <th>training</th>
                            <td><s:property value="training" /></td>
                        </tr>
                        <tr>
                            <th>Experience</th>
                            <td><s:property value="experience" /></td>
                        </tr>
                        <tr>
                            <th>Languages</th>
                            <td><s:property value="languages" /></td>
                        </tr>
                    </table>
                </s:iterator>
            </s:if>
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
