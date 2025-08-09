<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/f27920fb8e.js" crossorigin="anonymous"></script>
	
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>


<style>
.sidebar {
	height: 97vh;
}

a {
	text-decoration: none;
}
</style>
<body>

	<div class="row">
		<div class=" col-md-2 sidebar">
			<ul class="list-group p-4">
				<a href="./adminDashboard"><li
					class="list-group-item list-group-item-primary">Dashboard</li></a>
				<a href="./addClub"><li
					class="list-group-item list-group-item-danger">Add Club</li></a>
				<a href="./addSports"><li
					class="list-group-item list-group-item-warning">Add Sports</li></a>
			</ul>

		</div>
		<div class=" col-md-10">
			
			<c:if test="${clubObj eq 'yes'}">
				<div class="container">
					<div class="h2">Add Club </div>
					<hr>
					<div class="bg-light p-2">
						<form method="post" action="./saveClub">
							<div class="row">
								<div class="col-md-4">
									<label>Name of Club</label> 
									<input type="text" class="form-control" name="clubName">
								</div>

								<div class="mt-2 text-center">
									<button type="submit" class="btn btn-success">Save</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				
				<div class="container mt-2">
			<div class="h2">Club List</div>
				<table class="table table-bordered table-striped ">
					<thead class="bg-dark text-light">
						<tr>
							<th>SlNo</th>
							<th>Club Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cList}" var="cl" varStatus="counter">
							<tr>
								<td>${counter.count}</td>	
								<td>${cl.clubName}</td>	
								<td><a href="./deleteClub?cId=${cl.clubId}">remove</a></td>					
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
			</c:if>
			
			
			
			
			<c:if test="${SportsObj eq 'yes' }">
			
				<div class="container">
					<div class="h2">Add Sports </div>
					<hr>
					<div class="bg-light p-2">
						<form method="post" action="./saveSports">
							<div class="row">
							<div class="col-md-4">
									<label>Name of Club</label> 
									<select class="form-control" name="cId">
										<option value="-1"> -- select --</option>
										<c:forEach items="${clList}" var="cl">
											<option value="${cl.clubId}">${cl.clubName}</option>
										</c:forEach>
										
									</select>
								</div>
								<div class="col-md-4">
									<label>Name of Sport</label> 
									<input type="text" class="form-control" name="sportsName">
								</div>
								<div class="col-md-4">
									<label>Fees</label> 
									<input type="number" class="form-control" name="fees">
								</div>
								<div class="mt-2 text-center">
									<button type="submit" class="btn btn-success">Save</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				
				<div class="container mt-2">
			<div class="h2">Sports List</div>
				<table class="table table-bordered table-striped ">
					<thead class="bg-dark text-light">
						<tr>
							<th>SlNo</th>
							<th>Sports Name</th>
							<th>Fees (In Rs.)</th>
							<th>Club Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sList}" var="sl" varStatus="counter">
							<tr>
								<td>${counter.count}</td>	
								<td>${sl.sportsName}</td>
								<td>Rs. ${sl.fees}</td>
								<td>${sl.clubMaster.clubName}</td>	
								<td><a href="./deleteSports?sId=${sl.sportsId}">remove</a></td>					
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
				
			</c:if>
			
			
		</div>
	</div>
</body>
</html>