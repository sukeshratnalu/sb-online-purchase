<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<style>
  table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 80%;
  }

  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #dddddd;
  }
</style>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Customer List</title>
</head>
<body>
    <div align="center">
          <h1>My Order List</h1>
          <table border="1">
   
              <th>Order ID</th>
              <th>Price</th>
              <th>Action</th>
              <c:forEach var="order" items="${customerOrder}">
                  <tr>
   
                      <td>${order.name}</td>
                      <td>${order.price}</td>
         
                      <td><a style="color: green;" href="orderItems?id=${order.id}">Order Items</a> &nbsp;&nbsp;
                               <%--<a  style="color: red;" href="deleteOrder?id=${order.id}">Delete</a>--%></td>
   
                  </tr>
              </c:forEach>
          </table>
      </div>
</body>
</html>
