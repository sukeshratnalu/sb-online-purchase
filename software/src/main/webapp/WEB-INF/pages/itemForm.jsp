<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<style>
  table {
    font-family: arial, sans-serif;
  }

  td, th {
    text-align: left;
    padding: 8px;
  }
</style>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title> Online-purchase </title>
</head>
<body>
<div align="center"><h1>Item Form</h1>
</div>
<div align="center">
  <form:form action="saveItem" method="post" modelAttribute="item">
    <table>
       <form:hidden path="id"/>
      <tr>
        <td>Item Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Price:</td>
        <td><form:input path="price" /></td>
      </tr>
      <tr>
        <td>Quantity:</td>
        <td><form:input path="count" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Save" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
