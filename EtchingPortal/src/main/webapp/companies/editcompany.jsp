<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal - Edit company</title>
    </head>
    <body>
    <header><h1>Welcome to JobPortal!</h1></header>
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
                    <li><s:url id="viewURL" action="listJob" namespace="/jobs">
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
            <h1>Edit Company</h1>
            <s:form action="editCompany" class="com.EtchingPortal.web.CompanyAction">
                <s:textfield value="%{model.id}" name="id" type="hidden"/>
                <s:textfield name="passWord" type="password" label="password" />
                <s:textfield name="passWordConf" type="password" label="Repeat password" />
                <s:textfield value="%{model.email}" name="email" label="Email" />
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
