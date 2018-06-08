<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>Liste des recettes recommendées pour vous !</title>
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-light"> <!-- Links -->
	<ul class="navbar-nav">

		<li class="nav-item"><a class="nav-link" href="index.jsp"></a></li>
		<li class="nav-item"><a class="nav-link" href="profile.jsp">Mon
				profile</a></li>
		<li class="nav-item"><a class="nav-link" href="SuggestionIng.jsp">Suggestion
				d'ingrédients</a></li>
		<li class="nav-item"><a class="nav-link"
			href="RecommendedRcipe.jsp">Mes recommendations</a></li>
	</ul>
	</nav>
	<c:forEach items="${rec}" var="recipe">

		<div id="${recipe.idRecipe}" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">${recette.title}</h4>
					</div>
					<div class="modal-body">
						<br>
						<p>
							<b>Les ingrédients :</b>
						</p>
						<ul>
							<c:forEach items="${recipe.ingredients }" var="ing">
								<li>${ing.name}</li>
							</c:forEach>
						</ul>

						<br>
						<p>
							<b>Les étapes :</b>
						</p>
						<ul>
							<c:forEach items="${recipe.steps }" var="step">
								<li><b>${step.numberStep}</b>${step.descStep}</li>
							</c:forEach>
						</ul>
						<br>
						<p>
							<b>Les Ustensils :</b>
						</p>
						<ul>
							<c:forEach items="${recipe.utensils }" var="utensil">
								<li>${utensil.nameUtensil}</li>
							</c:forEach>
						</ul>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<div class="container">

			<p>Catégorie : ${recipe.categorie}</p>
			<div class="card" style="width: 400px">
				<img class="card-img-top" src="img/g-gif-update.php.gif"
					alt="Card image" style="width: 100%">
				<div class="card-body">
					<h4 class="card-title">${recipe.title}</h4>
					<p class="card-text">
						Budget: <b>${recipe.budget}</b> Temps de préparation: <b>${recipe.timePrepa}</b>
					</p>
					<p class="card-text">
						Note: <b>${recipe.rating}</b>
					</p>
					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#${recipe.idRecipe}">une recette</button>
				</div>
			</div>
		</div>
		<c:forEach items="${recipe.ingredients }" var="ing">

		</c:forEach>

	</c:forEach>

	<br>

</body>

</html>
