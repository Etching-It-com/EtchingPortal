<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <title>JobPortal - View</title>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
    </head>
    <body>
    <header><h1>Welcome to JobPortal!</h1></header>
    <div class="content">
        <nav><s:if test="#session.role=='candidate'">
                menu of candidates<br>
               you are welcome<strong><s:property value="#session.userName"/></strong>
                <ul>
                    <li><s:a href="../index.jsp">Return to index</s:a></li>
                    <li><s:url id="viewURL" action="viewProfile" namespace="/profiles">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View profile</s:a></li>
                    <li><s:url id="viewURL" action="viewCandidate" namespace="/candidates">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View candidate</s:a></li>
                    <li><s:url id="viewURL" action="listCandidateInscription" namespace="/inscriptions">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View applications</s:a></li>
                    <li><a href="<s:url action='LogOutAction' namespace="/"/>">Sign off</a></li>
                </ul>
            </s:if>
            <s:elseif test="#session.role=='admin'">
                <ul>
                    <li><a href="<s:url action='listCandidate' namespace="/candidates"/>">List Candidates</a></li>
                    <li><a href="<s:url action='listCompany' namespace="/companies"/>">List companies</a></li>
                </ul>
            </s:elseif>
            <s:elseif test="#session.role=='company'">
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
                    <li><a href="<s:url action='LogOutAction'/>">LogOut</a></li>
                </ul>

            </s:elseif>
            <s:else>
                <s:a href="../index.jsp">Return to index</s:a>
            </s:else>
        </nav>
        <main>
            <h1><s:property value="flashMessage"/></h1>
            <h1>View Candidate</h1>
            <table>
                <tr>
                    <th>UserName</th>
                    <th>Email</th>
                    <th>Created</th>
                    <th>Modified</th>
                    <th>Last access</th>
                    <th>Actions</th>
                </tr>
                <tr><s:push value="model">
                        <td><s:property value="userName" /></td>
                        <td><s:property value="email" /></td>
                        <td><s:date name="created" format="dd/MM/yyyy"/></td>
                        <td><s:date name="modified" format="dd/MM/yyyy"/></td>
                        <td><s:date name="lastLogin" format="dd/MM/yyyy/ 'a las' hh:mm:ss a"/></td>
                        <td>
                            <s:url id="editURL" action="editCandidate">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{editURL}">Edit</s:a>
                            <s:url id="deleteURL" action="deleteCandidate">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}">delete</s:a>
                            </td>
                    </s:push>
                </tr>
            </table>
            <h1>My applications(Inscriptions)</h1>
            <s:action name="listCandidateInscription" namespace="/inscriptions" var="listInscription" />
            <s:iterator value="#listInscription.listInscription" status="inscriptionStatus">
                <table class="list">
                    <tr>
                        <th><s:url id="viewURL" action="viewJob" namespace="/jobs">
                                <s:param name="id" value="%{jobId}"></s:param>
                            </s:url>
                            <s:a href="%{viewURL}"><s:property value="jobTitle"/></s:a></th>
                        <tr>
                            <td><s:date name="created" format="dd/MM/yyyy"/></td>
                    </tr>
                    <tr>
                        <td><s:property value="status"/></td>
                    </tr>
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
