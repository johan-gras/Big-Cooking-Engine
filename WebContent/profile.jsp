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

<body style = "color: white">
	<br>
	<br>
	<c:import url="navBar.jsp"></c:import>


	<div class="container-fluid">

		<div class="row">

			<div class="col-md-4">

				<img src="http://via.placeholder.com/350x250" />

				<h2>Utilisateur nom</h2>

				<a class="btn btn-primary" href="ServletRecomendationRecipe"
					role="button">Ma selection de recettes</a>

			</div>

			<div class="col-md-8">

				<b>Infos presonnelles</b>
				<ul>
					<li><b>Nom: </b>John</li>
					<li><b>Prénom: </b>Kenny</li>
					<li><b>Date de Naissance: </b>18/11/1988</li>
				</ul>

			</div>
		</div>

	</div>
	<!-- Les ingrédients TOP3 -->
	<div class ="top3">
	
	</div>

</body>

</html>
