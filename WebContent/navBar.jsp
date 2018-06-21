<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar fixed-top navbar-light"
	style="background-color: #e3f2fd;">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<p>Connecté: <b>${username}</b></p>
	
	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand" href="index.jsp">Page d'accueil</a>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link"
				href="profile.jsp" style="color: green;">Profile <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="ServletRecomendationRecipe" style="color: green;">Mes recommendations</a></li>
				<li class="nav-item active"><a class="nav-link"
				href="ServeltRateIngred" style="color: green;">Ajouter des Ingrédients préférés</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="ServletRatedIng" style="color: green;">Mes Ingrédients
					favoris <span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item active"><a class="nav-link"
				href="ServletFrigo" style="color: green;">Contenu du frigo
					virtuel <span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item active"><a class="nav-link"
				href="LogOut" style="color: red;">Déconnexion <span class="sr-only">(current)</span>
			</a></li>
			
			

		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Chercher une recette</button>
		</form>
	</div>
</nav>
<br>
<br>