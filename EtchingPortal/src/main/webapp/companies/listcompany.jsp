<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>JobPortal</title>
    </head>
    <body>
                <s:a href="../index.jsp">Return to index</s:a>
        <h1><s:property value="flashMessage"/></h1>
        <h1>List Companies</h1>
        <table>
            <tr>
                <th>Company name</th>
                <th>CIF</th>
                <th>Created</th>
                <th>Modified</th>
                <th>view</th>
                <th>Edit</th>
                <th>delete</th>
            </tr>
            <s:iterator value="listCompany" status="companyStatus">
                <tr>
                    <td><s:property value="name" /></td>
                    <td><s:property value="cif" /></td>
                    <td><s:date name="created" format="dd/MM/yyyy"/></td>
                    <td><s:date name="modified" format="dd/MM/yyyy"/></td>
                    <td>
                        <s:url id="viewURL" action="viewCompany">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{viewURL}">View</s:a>
                        </td>
                        <td>
                        <s:url id="editURL" action="editCompany">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{editURL}">Edit</s:a>
                        </td>
                        <td>
                        <s:url id="deleteURL" action="deleteCompany">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{deleteURL}">delete</s:a>
                        </td>
                    </tr>
            </s:iterator>
        </table>
    </body>
</html>
