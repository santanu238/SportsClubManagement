<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/f27920fb8e.js" crossorigin="anonymous"></script>
	
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	
<body>
<div class="container">
<div class="h2 bg-primary text-light text-center p-2 mt-2">Sports club registration</div>
<form method="post" action="./registerUser" enctype="multipart/form-data">
	<div class="row">
		<div class="col-md-2"></div>
		
		<div class="col-md-4">
		<label>Select club</label>
		<select class="form-control" id="clubInp" onchange="getSports()">
			<option value="-1">--- select ---</option>
			<c:forEach items="${clubList }" var="cl">
				<option value="${cl.clubId }">${cl.clubName}</option>
			</c:forEach>	
		</select>
		</div>
		<div class="col-md-4">
		<label>Select Sports</label>
		<select class="form-control" id="sportsInp">
			<option value="-1">--- select ---</option>
				
		</select>
		</div>
		<div class="col-md-2"></div>
		<div class="col-md-4">
		<label>Applicant Name</label>
		<input type="text" name="uname" class="form-control">
		</div>
		<div class="col-md-4">
		<label>Email</label>
		<input type="text" name="email" class="form-control">
		</div>
		<div class="col-md-4">
		<label>Mobile No.</label>
		<input type="number" name="phone" class="form-control">
		</div>
		<div class="col-md-4">
		<label>DOB</label>
		<input type="date" name="dob" class="form-control">
		</div>
		<div class="col-md-4 mt-3 text-center">
		<label class="px-2">Gender</label><br>
		<input type="radio" name="gender" value="m">Male<input type="radio" name="gender" value="f">Female
		</div>
		<div class="col-md-4">
		<label >Upload Photo</label>
		<input type="file" name="photo" class="form-control">
		</div>
	</div>
	<div class="text-center mt-5">
	<button class="btn btn-success" type="submit">Register</button>
	<button class="btn btn-warning" type="reset">Reset</button>
	</div>
</form>
</div>
<script>
	function getSports(){
		let club=$("#clubInp").val();
		$.ajax({
			url:'./getSportsByClub',
			type: 'post',
			data: "cId="+club,
			success: function(response){
				$("#sportsInp").empty();
				$("#sportsInp").append(response);
			},error: function (res){
				alert("error");
			}
		});
	}

</script>

</body>
</html>