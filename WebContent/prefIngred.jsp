<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/CSS/style.css' />">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>
	<c:import url="navBar.jsp"></c:import>
	<br>
	<h2 class="d-flex justify-content-center" style="background-color: white;"><b>Evaluation des ingrédients </b></h2>
	<div class="container">
		<div class="row d-flex justify-content-center">
			<c:forEach items="${ing}" var="r">
				<div class="card d-flex justify-content-center" style="width: 18rem; margin: 20px;">
					<img class="card-img-top" src="${r.photo}" alt="image Ingredient" style="width: 100px; height: 100px">
					<div class="card-body">
						<h5 class="card-title"><b>${r.name}</b></h5>
						<h6>Note : <b>${r.score}</b></h6>
					</div>
				</div>
				<br>
			</c:forEach>
			<br>
		</div>
	</div>

</body>
</html>