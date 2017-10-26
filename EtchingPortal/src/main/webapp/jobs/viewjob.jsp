<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal - View</title>
    </head>
    <body>
    <header><h1>Welcome to JobPortal!</h1></header>
    <div class="content">
        <nav><s:if test="#session.role=='candidate'">
                menu of candidates<br>
                Welcome <strong><s:property value="#session.userName"/></strong>
                <ul>
                    <li><s:a href="../index.jsp">Return to index</s:a></li>
                    <li><s:url id="viewURL" action="viewProfile" namespace="/profiles">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View Profile</s:a></li>
                    <li><s:url id="viewURL" action="viewCandidate" namespace="/candidates">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View Candidate</s:a></li>
                    <li><s:url id="viewURL" action="listCandidateInscription" namespace="/inscriptions">
                            <s:param name="id" value="%{#session.id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View applications</s:a></li>
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
              Welcome <strong><s:property value="#session.userName"/></strong>
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

            </s:elseif>
            <s:else>
                <s:a href="../index.jsp">Return to index</s:a>
            </s:else>
        </nav>
        <main>
            <h1><s:property value="flashMessage"/></h1>
            <h1>View Job</h1>
            <table>
                <s:push value="model">
                    <tr>
                        <th>Title</th>
                        <td><s:property value="title" /></td>
                    </tr>
                    <tr>
                        <th>Location</th>
                        <td><s:property value="location" /></td>
                    </tr>
                    <tr>
                        <th>Category</th>
                        <td><s:property value="category" /></td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td><s:property value="description" /></td>
                    </tr>
                    <tr>
                        <th>Training</th>
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
                </s:push>
            </table>
            <s:if test="#session.role=='candidate'">
                <s:if test="isInscribed==false">
                    <s:form action="addInscription" namespace="/inscriptions" class="com.EtchingPortal.web.InscriptionAction" method="POST">
                        <s:textfield value="%{#session.id}" name="candidateId" type="hidden"/>
                        <s:textfield value="%{#session.userName}" name="candidateName" type="hidden"/>
                        <s:textfield value="%{model.id}" name="jobId" type="hidden"/>
                        <s:textfield value="%{model.title}" name="jobTitle" type="hidden"/>
                        <s:submit value="Inscribirme" />
                    </s:form>
                </s:if>
                <s:else>
                    <p>You are already registered in this job offer</p>
                </s:else>
            </s:if>
            <s:elseif test="%{#session.role=='company'}">
                <s:set name="companyId" value="%{model.companyId}"/>
                <s:if test="%{#companyId==#session.id}">
                    <s:action name="listJobInscription" namespace="/inscriptions" var="listInscription" />
                    <s:if test="%{#listInscription.listInscription.size==0}"><h1>There are no candidates registered for this offer</h1></s:if>
                    <s:else>
                        <h1>Registered applicants</h1>
                        <table>
                            <tr>
                                <th>Candidate Name</th>
                                <th>Registered the day</th>
                                <th>Actions</th>
                                <th>Application Status</th>
                            </tr>
                            <s:iterator value="#listInscription.listInscription" status="inscriptionStatus">
                                <tr>                   
                                    <td>
                                        <s:url id="viewURL" action="viewProfile" namespace="/profiles">
                                            <s:param name="id" value="%{candidateId}"></s:param>
                                        </s:url>
                                        <s:a href="%{viewURL}" title="Ver candidato %{candidateName}"><s:property value="%{candidateName}"/></s:a>
                                        </td>
                                        <td><s:date name="created" format="dd/MM/yyyy"/></td>
                                    <td>
                                        <s:form action="updateInscription" namespace="/inscriptions">
                                            <s:textfield value="DISCARDED" name="status" type="hidden"/>
                                            <s:textfield value="%{id}" name="id" type="hidden"/>
                                            <s:submit value="discard"/>
                                        </s:form>
                                        <s:form action="updateInscription" namespace="/inscriptions">
                                            <s:textfield value="SELECTED" name="status" type="hidden"/>
                                            <s:textfield value="%{id}" name="id" type="hidden"/>
                                            <s:submit value="select"/>
                                        </s:form>
                                    </td>
                                    <td>
                                        <s:property value="%{status}"/>
                                    </td>
                                </tr>

                            </s:iterator>
                        </table>
                    </s:else>
                </s:if>
            </s:elseif>
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
