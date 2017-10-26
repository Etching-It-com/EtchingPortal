<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal</title>
        <s:head />
    </head>
    <body>
    <header><h1>welcome to JobPortal!</h1></header>
    <div class="content">
        <nav>
            <s:if test="#session.role=='candidate'">
                menu of candidates<br>
                welcome <strong><s:property value="#session.userName"/></strong>
                <ul>
                    <li><s:url id="viewURL" action="viewProfile" namespace="/profiles">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View profile</s:a></li>
                    <li><s:url id="viewURL" action="viewCandidate" namespace="/candidates">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">view candidate</s:a></li>
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
                welcome <strong><s:property value="#session.userName"/></strong>
                <ul>
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

            </s:elseif>
            <s:else>
                <s:a href="../index.jsp">return to index</s:a>
            </s:else>
        </nav>
        <main>
            <h1>Advanced search</h1>
            <s:form action="avancedSearchJob" namespace="/search">
                <s:textfield name="searchField" label="Search offers"/>
                <s:select list="listTraining" name="training" label="training"/>
                <s:select list="listExperience" name="experience" label="Experience"/>
                <s:checkboxlist list="listLanguages" name="languages" label="languages" />
                <s:submit value="search"/>
            </s:form>
            <h1><s:property value="flashMessage"/></h1>
            <s:iterator value="listJob" status="jobStatus">
                <table class="list">
                    <tr>
                        <th>First name</th>
                        <td><s:url id="viewURL" action="viewJob" namespace="/jobs">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{viewURL}">
                                <s:property value="title" />
                            </s:a>
                        </td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>
                            <s:property value="description" />
                        </td>
                    </tr>
                    <tr>
                        <th>
                            training
                        </th>
                        <td>
                            <s:property value="training" />
                        </td>
                    </tr>
                    <tr>
                        <th>Experience</th>
                        <td><s:property value="experience" /></td>
                    </tr>
                    <tr>
                        <th>languages</th>
                        <td><s:property value="languages" /></td>
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
