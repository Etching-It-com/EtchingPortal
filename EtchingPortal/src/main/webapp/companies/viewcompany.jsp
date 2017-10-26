<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal - View Company</title>
    </head>
    <body>
    <header><h1>you are welcome a JobPortal!</h1></header>
    <div class="content">
        <nav>
            <s:if test="#session.role=='candidate'">
               menu of candidates<br>
                you are welcome <strong><s:property value="#session.userName"/></strong>
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
                    <li><s:a href="../index.jsp">Return to index</s:a></li>
                    <li><a href="<s:url action='listCandidate' namespace="/candidates"/>">List Candidates</a></li>
                    <li><a href="<s:url action='listCompany' namespace="/companies"/>">List companies</a></li>
                </ul>
            </s:elseif>
            <s:elseif test="#session.role=='company'">
                business menu<br>
                you are welcome <strong><s:property value="#session.userName"/></strong>
                <ul>
                    <li><s:a href="../index.jsp">return to index</s:a></li>
                    <li><s:url id="viewURL" action="viewCompany" namespace="/companies">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url><s:a href="%{viewURL}">view company</s:a></li>
                    <li><a href="<s:url action='addJob' namespace="/jobs"/>">Add job</a></li>
                    <li><s:url id="viewURL" action="listJob" namespace="/jobs">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">See published work</s:a></li>
                    <li><a href="<s:url action='LogOutAction' namespace="/"/>">See published work</a></li>
                </ul>

            </s:elseif>
            <s:else>
                <s:a href="../index.jsp">return to index</s:a>
            </s:else>
        </nav>
        <main>
            <h1><s:property value="flashMessage"/></h1>
            <h1>View Company</h1>
            <s:push value="model">
                <table>
                    <tr>
                        <th>First name</th>                        
                        <th>Email</th>                       
                            <s:if test="#session.role=='company'">
                                <s:if test="#session.id==id">
                                <th>CIF</th>
                                <th>Modified</th>
                                <th>Actions</th>                            
                                <th>Last access</th></s:if>
                            </s:if>
                    </tr>
                    <tr>
                        <td><s:property value="name" /></td>
                        <td><s:property value="email" /></td>
                        <s:if test="#session.role=='company'">
                            <s:if test="#session.id==id">
                                <td><s:property value="cif" /></td>
                                <td><s:date name="modified" format="dd/MM/yyyy"/></td>
                                <td>
                                    <s:url id="editURL" action="editCompany">
                                        <s:param name="id" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{editURL}">Edit</s:a>
                                    <s:url id="deleteURL" action="deleteCompany">
                                        <s:param name="id" value="%{id}"></s:param>
                                    </s:url>
                                    <s:a href="%{deleteURL}">Remove</s:a>
                                    </td>
                                    <td>
                                    <s:date name="lastLogin" format="dd/MM/yyyy ' a las ' hh:mm:ss"/>
                                </td>
                            </s:if>
                        </s:if>

                    </tr>
                </table>
            </s:push>
            <h1>Published works</h1>
            <s:action name="listJob" namespace="/jobs" var="listJob" />
            <s:iterator value="#listJob.listJob" status="jobStatus">
                <table class="list">
                    <tr>
                        <th>Job</th>
                        <td><s:url id="viewURL" action="viewJob" namespace="/jobs">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{viewURL}"><s:property value="title" /></s:a></td>
                        </tr>
                        <tr>
                            <th>Created</th>
                            <td><s:date name="created" format="dd/MM/yyyy"/></td>
                    </tr>
                    <tr>
                        <th>Requirements</th>
                        <td>
                            Training <s:property value="training"/> | 
                            Experience <s:property value="experience"/> | 
                           Languages <s:property value="languages"/>
                        </td>
                    </tr>
                    <s:if test="#session.role=='company'">
                        <tr>
                            <th>Actions</th>
                            <td>
                                <s:url id="editURL" action="editJob" namespace="/jobs">
                                    <s:param name="id" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{editURL}">Edit</s:a>
                                <s:url id="deleteURL" action="deleteJob" namespace="/jobs">
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

