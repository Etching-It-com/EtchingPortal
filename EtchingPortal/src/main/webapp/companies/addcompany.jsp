<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<head>
    <s:head/>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <title>JobPortal - Add company</title>
</head>
<body>
<header><h1>you are welcome a JobPortal!</h1></header>
<div class="content">
    <nav>
        <s:if test="#session.role=='candidate'">
            menu of candidates<br>
            you are welcome <strong><s:property value="#session.userName"/></strong>
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

        </s:elseif>
        <s:else>
            <s:a href="../index.jsp">Return to index</s:a>
        </s:else>
    </nav>
    <main>
        <h1>Register company</h1>
        <s:form action="addCompany" class="com.EtchingPortal.companies.AddCompany">
            <s:textfield name="name" label="Company name" />
            <s:textfield name="cif" label="CIF" />
            <s:textfield name="email" label="Email" />
            <s:textfield name="passWord" type="password" label="Password" />
            <s:textfield name="passWordConf" type="password" label="Repeat password" />
            <s:submit value="save" />
        </s:form>
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
