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
<div align="center"><h2>Customer Form</h2>
</div>
<div align="center">
  <form:form action="saveCustomer" method="post" modelAttribute="customer">
    <table>
       <form:hidden path="id"/>
      <tr>
        <td>Customer Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><form:input path="email" /></td>
      </tr>
      <tr>
          <td>Cell:</td>
          <td><form:input path="telephone" /></td>
      </tr>
      <tr>
        <td>Street:</td>
        <td><form:input path="address.street" /></td>
      </tr>
      <tr>
        <td>City:</td>
        <td><form:input path="address.city" /></td>
      </tr>
      <tr>
        <td>State:</td>
        <td><form:input path="address.state" /></td>
      </tr>
      <tr>
        <td>Pin:</td>
        <td><form:input path="address.pin" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Register" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>


