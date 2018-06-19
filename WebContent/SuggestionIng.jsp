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
<title>Liste des recettes recommendées pour vous !</title>
</head>

<body style="color: white;">


	<br>
	<c:import url="navBar.jsp"></c:import>
	<div class="container d-flex justify-content-center">
		<div class="row">

			<div class="col d-block mx-auto" style="width: 50%;">

				<h1 class="d-flex justify-content-center">Notez l'ingrédient</h1>

				<div class="card bg-light mb-3" style="max-width: 30rem;">
					<div class="card-header">
						<h2 class="d-flex justify-content-center" style="color: black;">${ingred.name}</h2>
					</div>
					<div class="card-body">
						<img src=${ingred.photo } width="100px" height="100px"
							class="d-block mx-auto" /> <br>
						<div class="boutons btn-group d-block mx-auto" role="group"
							aria-label="Basic example" style="position: center">
							<a type="button" class="btn btn-secondary"
								href=ServeltRateIngred?param=0>0</a> <a type="button"
								class="btn btn-secondary" href=ServeltRateIngred?param=1>1</a> <a
								type="button" class="btn btn-secondary"
								href=ServeltRateIngred?param=2>2</a> <a type="button"
								class="btn btn-secondary" href=ServeltRateIngred?param=3>3</a> <a
								type="button" class="btn btn-secondary"
								href=ServeltRateIngred?param=4>4</a> <a type="button"
								class="btn btn-secondary" href=ServeltRateIngred?param=5>5</a> <a
								type="button" class="btn btn-secondary"
								href=ServeltRateIngred?param=6>6</a> <a type="button"
								class="btn btn-secondary" href=ServeltRateIngred?param=7>7</a> <a
								type="button" class="btn btn-secondary"
								href=ServeltRateIngred?param=8>8</a> <a type="button"
								class="btn btn-secondary" href=ServeltRateIngred?param=9>9</a> <a
								type="button" class="btn btn-secondary"
								href=ServeltRateIngred?param=10>10</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>