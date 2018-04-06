<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<style>
  .item-div{
    border: 1px solid;
    border-radius: 4px;
    margin-left: 20px;
    margin-bottom: 10px;
    padding-bottom: 7px;
  }
  .item-list{
    padding-left: 164px!important;
  }
</style>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<h1 align="center">My Order Items</h1>
<form action="saveOrder" method="post">
  <div class="container container-fluid item-list">
    <div class="row" align="center">
      <c:forEach var="item" items="${orderItems}">
        <div class="col-md-3 item-div">
          <div align="center" style="background-color: antiquewhite;width: 80px; height: 80px; margin: 10px">
            IMG
          </div>
          <h6 align="center">${item.name}</h6>
          <h6 align="center">Rs.${item.price}</h6>
          <h6 align="center">
             <a style="color: red"  href="removerOrderedItem?itemId=${item.id}&orderId=${orderId}&customerId=${customerId}">Remove Item</a>
          </h6>
        </div>  
      </c:forEach>
    </div>
  </div>
</form>
</body>
</html>
