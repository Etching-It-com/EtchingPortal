<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal - Edit Profile</title>
    </head>
    <body>
    <header><h1>welcome to JobPortal!</h1></header>
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
                    <li><s:url id="viewURL" action="listCandidateInscription" namespace="/inscriptions">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View applications</s:a></li>
                    <li><a href="<s:url action='LogOutAction' namespace="/"/>">Sign off</a></li>
                </ul>
            </s:if>
        </nav>
        <main>
            <h1><s:property value="flashMessage"/></h1>
            <h1>Edit profile</h1>
            <s:form action="editProfile" class="com.EtchingPortal.web.ProfileAction">
                <s:textfield value="%{model.id}" name="id" type="hidden"/>
                <s:textfield name="name" value="%{model.name}" label="First name" />
                <s:textfield name="surName" value="%{model.surName}" label="Surname" />
                <s:textarea cols="40" rows="20" name="curriculum" value="%{model.curriculum}" label="Currículum" />
                <s:select list="listCategory" name="category" multiple="true" value="%{model.category}" label="Category" />
                <s:select list="listLocation" name="location" multiple="true" value="%{model.location}" label="location" />
                <s:select list="listTraining" name="training" value="%{model.training}" label="training" />
                <s:select list="listExperience" name="experience" value="%{model.experience}" label="Experience" />
                <s:checkboxlist list="listLanguages" name="languages" value="%{model.languages}" label="languages" />
                <s:submit value="submit" />
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
