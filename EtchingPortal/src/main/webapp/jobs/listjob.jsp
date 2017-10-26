<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal</title>
    </head>
    <body>
    <header><h1>Welcome to JobPortal!</h1></header>
        <div class="content">
            <nav>
                <s:if test="#session.role=='candidate'">
                    menu of candidates<br>
                   welcome<strong><s:property value="#session.userName"/></strong>
                    <ul>
                        <li><s:a href="../index.jsp">return to index</s:a></li>
                        <li><s:url id="viewURL" action="viewProfile" namespace="/profiles">
                                <s:param name="id" value="%{#session.id}"></s:param>
                            </s:url>
                            <s:a href="%{viewURL}">View Profile</s:a></li>
                        <li><s:url id="viewURL" action="viewCandidate" namespace="/candidates">
                                <s:param name="id" value="%{#session.id}"></s:param>
                            </s:url>
                            <s:a href="%{viewURL}">view candidate</s:a></li>
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
                    Welcome <strong><s:property value="#session.userName"/></strong>
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
                <h1><s:property value="flashMessage"/></h1>
                <h1>List Jobs</h1>
                <s:iterator value="listJob" status="jobStatus">
                    <table class="list">
                        <tr>
                            <th>Name of the job</th>
                            <td><s:url id="viewURL" action="viewJob">
                                    <s:param name="id" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{viewURL}"><s:property value="title" /></s:a>
                                </td>
                            </tr>
                            <tr>
                                <th>Business</th>
                                <td><s:url id="viewURL" action="viewCompany" namespace="/companies">
                                    <s:param name="id" value="%{companyId}"></s:param>
                                </s:url>
                                <s:a href="%{viewURL}"><s:property value="companyName" /></s:a></td>
                            </tr>
                            <tr>
                                <th>Description</th>
                                <td><s:property value="description" /></td>
                        </tr>
                        <tr>
                            <th>Created</th>
                            <td><s:date name="created" format="dd/MM/yyyy"/></td>
                        </tr>
                        <s:if test="#session.role=='company'">
                            <tr>
                                <th>Actions</th>
                                <td>
                                    <s:url id="editURL" action="editJob">
                                        <s:param name="id" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{editURL}">Edit</s:a>
                                    <s:url id="deleteURL" action="deleteJob">
                                        <s:param name="id" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{deleteURL}">Remove</s:a>
                                    </td>
                                </tr>
                        </s:if>
                    </table>
                </s:iterator>
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

