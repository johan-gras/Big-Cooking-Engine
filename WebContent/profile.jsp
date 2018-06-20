<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>


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
<style>
</style>

<body>
	<br>
	<c:import url="navBar.jsp"></c:import>


	<div class="container-fluid">

		<div class="col d-block mx-auto"
			style="background-color: white; width: 50%;">

			<b>Informations personnelles</b>
			<ul>
				<li><b>Nom: </b>${nameUser}</li>
				<li><b>Mail: </b>${mail}</li>
				<li><b>Poids </b>${poids}</li>
			</ul>

		</div>
	</div>

	<div class="col">

		<a class="btn btn-primary btn-lg btn-block d-block mx-auto"
			href="ServletRecomendationRecipe" role="button" style="width: 50%;">Recommander
			3 recettes</a>

	</div>

</body>

</html>
