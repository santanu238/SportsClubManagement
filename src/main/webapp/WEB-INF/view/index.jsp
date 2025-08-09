<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
  body {
    background-image: url('../image/ford.jpg.jpg'); 
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    backdrop-filter: blur(2px); 
  }
</style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

  <div class="card shadow p-4" style="width: 22rem;">
    <h4 class="text-center text-primary mb-4">Login</h4>
    <form method="post" action="./userLogin">
      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" placeholder="Enter username " name="uname">
      </div>
      
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="pass">
      </div>

      <div class="mb-3">
        <label class="form-label me-3">Login as:</label>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="type" id="userRadio" value="2" checked>
          <label class="form-check-label" for="userRadio">User</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="type" id="adminRadio" value="1">
          <label class="form-check-label" for="adminRadio">Admin</label>
        </div>
      </div>

      <div class="d-flex justify-content-between">
        <button type="submit" class="btn btn-success">Submit</button>
        <button type="reset" class="btn btn-danger">Reset</button>
      </div>
    </form>
  </div>

  <!-- Bootstrap JS Bundle -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>