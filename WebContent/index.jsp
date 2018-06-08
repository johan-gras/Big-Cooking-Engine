<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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

<body>

	<c:import url="navBar.jsp"></c:import>
	<br>

	<!-- Trigger the modal with a button -->
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
		data-target="#myModal">une recette</button>

	<!-- Barre de recherche -->
	<form action="ServletSearch" name="search" method="post">
		<input type="text" id="searchBar" name="searchWord"
			placeholder="mot clé"> <input type="submit" value="Chercher">
	</form>
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">${recette.title}</h4>
				</div>
				<div class="modal-body">
					<hr>
					<b>Temps : </b>${recette.timeTotal }, <b>Catégorie: </b>${recette.categorie },
					<b>Level: </b>${recette.level }, <b>Nombre de personne: </b>${recette.nbOfPerson },
					<b>Temps de cuisson: </b>${recette.timeCooking },
					<hr>
					<br>
					<p>
						<b>Les ingrédients :</b>
					</p>
					<ul>
						<li>ingrédient 1</li>
						<li>ingréient 2</li>
						<li>ingrédient 3</li>
						<li>ingrédient 4</li>
					</ul>

					<br>
					<p>
						<b>Les étapes :</b>
					</p>
					<ul>
						<li>étapes 1</li>
						<li>étapes 2</li>
						<li>étapes 3</li>
						<li>étapes 4</li>
					</ul>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>



</body>

</html>


<a href="/BCD-EGINE/LogOut">Deconnexion</a>
