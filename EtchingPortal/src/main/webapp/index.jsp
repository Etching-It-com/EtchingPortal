<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<html>
    <head>
        <title>JobPortal</title>
        <sj:head jqueryui="true"/>
        <s:head/>

        <script type="text/javascript">

            $(document).ready(function() {
                $("#pruebaAJAX").click(function() {
                    $(this).animate({margin: '+=10px'});
                });
            });

        </script>
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>welcome to JobPortal!</h1></header>
    <div class="content">
    <nav>
        <s:if test="#session.role=='candidate'">
            candidate menu<br>
            welcome <strong><s:property value="#session.userName"/></strong>
            <ul>
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
            Welcome <strong><s:property value="#session.userName"/></strong>
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
            <span>welcome to JobPortal</span>
            <br>
            <span>In order to qualify for <strong>Work offers</strong> you will have to <a href="<s:url action='addCandidate' namespace="/candidates"/>">Sign Up Candidate</a></span>
        </s:else>
    </nav>
    <main>
        <h1><s:property value="flashMessage"/></h1>
        <s:if test="#session.role=='company'">
            <s:form action="searchProfile" namespace="/search">
                <s:textfield id="searchForm" name="searchField" label="Search profiles"/>
                <s:submit value="search"/>
            </s:form>
        </s:if>
        <s:elseif test="#session.role=='candidate'">
            <div class="search">
            <s:form action="searchJob" namespace="/search">
                <s:textfield id="searchForm" name="searchField" label="Search offers" javascriptTooltip="Write here" required="true"></s:textfield>
                <s:submit value="search" />
            </s:form>
            <a href="<s:url action='avancedSearchJob' namespace="/search"/>">Advanced search</a>
            </div>
        </s:elseif>
        <s:else>
            <div class="loggin">
                
Login User
                <a href="<s:url action='addCandidate' namespace="/candidates"/>">Register Candidate</a>
                <s:form id="login"  action="LogInActionCandidate" namespace="/" class="com.EtchingPortal.actions.LoginAction" method="POST">
                    <s:textfield name="userName"  label="Username" required="true"/>
                    <s:password id="candidatePassWord" name="candidatePassWord" type="password" label="Password" required="true"/>
                    <s:submit value="Enter"/>
                </s:form>
            </div>
            <div class="loggin">
                Enter company
                <a href="<s:url action='addCompany' namespace="/companies"/>">Register Company</a>
                <s:form action="LogInActionCompany" namespace="/" class="com.EtchingPortal.actions.LoginAction" method="POST">                
                    <s:textfield name="cif" label="C.I.F. Empresa" required="true"/>
                    <s:textfield name="companyPassWord" type="password" label="password"  required="true"/>
                    <s:submit value="Enter"/>
                </s:form>
            </div>
            <div class="search">
            <s:form action="searchJob" namespace="/search">
                <s:textfield id="searchForm" name="searchField" label="Search offers" javascriptTooltip="Escribe aquí" required="true"></s:textfield>
                <s:submit value="Search" />
            </s:form>
            <a href="<s:url action='avancedSearchJob' namespace="/search"/>">Advanced search</a>
            </div>
        </s:else>
        <s:div id="pruebaAJAX" name="pruebaAJAX">This is an AJAX test, push me to test</s:div>
        <s:action name="listJob" namespace="/jobs" var="listJob" />
        <span class="info">
We have on our website (<s:property value="%{#listJob.listJob.size}"/>) 
published works</span>
        <h1>
Latest work published</h1>
        <s:iterator value="#listJob.listJob" status="jobStatus">
            <table class="list">
                <tr>
                    <th>
                        <s:url id="viewURL" action="viewJob" namespace="/jobs">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}"><s:property value="title" /></s:a>
                        </th>
                    </tr>
                    <tr>

                        <td><s:url id="viewURL" action="viewCompany" namespace="/companies">
                            <s:param name="id" value="%{companyId}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}" title="See more jobs in the company %{companyName}">View company <s:property value="companyName" /></s:a></td>
                    </tr>
                    <tr>
                        <td><s:date name="created" format="dd/MM/yyyy"/></td>
                </tr>
                <tr>
                    <td>
                       Training <s:property value="training"/> | 
                        Experience <s:property value="experience"/> | 
                        Languages <s:property value="languages"/>
                    </td>
                </tr>
                <s:if test="#session.role=='company'">
                    <tr>
                        <td>
                            <s:if test="#session.id==%{companyId}">
                                <s:url id="editURL" action="editJob" namespace="/jobs">
                                    <s:param name="id" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{editURL}">Edit</s:a>
                                <s:url id="deleteURL" action="deleteJob" namespace="/jobs">
                                    <s:param name="id" value="%{id}"></s:param>
                                </s:url>
                                <s:a href="%{deleteURL}">Remove</s:a>
                            </s:if>
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