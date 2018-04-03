
<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
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
            <h1>Customer List</h1>
            <h3>
                <a href="newCustomer">New Customer</a>
            </h3>

            <table border="1">
     
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Cell</th>
                <th>Action</th>
     
                <c:forEach var="customer" items="${listCustomer}">
                    <tr>
     
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>Street: ${customer.address!=null?customer.address.street:''},
                            City: ${customer.address!=null?customer.address.city:''}</td>
                        <td>${customer.telephone}</td>
                        <td><a href="editCustomer?id=${customer.id}">Edit</a>
                                 <a href="deleteCustomer?id=${customer.id}">Delete</a></td>
     
                    </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>

