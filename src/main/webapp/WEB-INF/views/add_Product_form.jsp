<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<%@ include file="./Base.jsp" %>
<body>
<div class="container">
    <h2>Add Product</h2>
    <form action="handle_product" method="post">
      <div class="form-group">
        <label for="productName">Product Name</label>
        <input type="text" class="form-control" id="productName" placeholder="Enter product name" name="name">
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <textarea class="form-control" id="description"  name="description" rows="3" placeholder="Enter product description"></textarea>
      </div>
      <div class="form-group">
        <label for="price">Price</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="Enter product price">
      </div>
      <button type="submit" class="btn btn-primary">Add</button>
      <a href="${pageContext.request.contextPath }/" class="btn btn-secondary">Back</a>
    </form>
  </div>

</body>
</html>