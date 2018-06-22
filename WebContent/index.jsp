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

	<div class="container">
		<div class="row">
			<div class="col">

				<div class="alrty alert-primary" role="alert">
					<h3>Recette frigo</h3>
				</div>
				<c:forEach items="${rfrigo}" var="recipe">

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
										<c:forEach items="${recipe.ingredients}" var="ing">
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
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

					<div class="container">

						<p>Catégorie : ${recipe.categorie}</p>
						<div class="card" style="width: 400px">

							<div class="card-body">
								<h4 class="card-title">${recipe.title}</h4>
								<p class="card-text">
									Budget: <b>${recipe.budget}</b> Temps de préparation: <b>${recipe.timePrepa}</b>
								</p>
								<p class="card-text">
									Note: <b>${recipe.rating}</b>
								</p>
								<button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" data-target="#${recipe.idRecipe}">Détails</button>
								<div class="dropdown">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">Noter</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=0">0</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=1">1</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=2">2</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=3">3</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=4">4</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=5">5</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=6">6</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=7">7</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=8">8</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=9">9</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=10">10</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col">
			<div class="row">
				<div class="alrty alert-primary" role="alert">
					<h3>Recommendations Par Goûts</h3>
				</div>
				<c:forEach items="${ringred}" var="recipe">

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
										<c:forEach items="${recipe.ingredients}" var="ing">
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
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

					<div class="container">

						<p>Catégorie : ${recipe.categorie}</p>
						<div class="card" style="width: 400px">

							<div class="card-body">
								<h4 class="card-title">${recipe.title}</h4>
								<p class="card-text">
									Budget: <b>${recipe.budget}</b> Temps de préparation: <b>${recipe.timePrepa}</b>
								</p>
								<p class="card-text">
									Note: <b>${recipe.rating}</b>
								</p>
								<button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" data-target="#${recipe.idRecipe}">Détails</button>
								<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">Noter</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=0">0</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=1">1</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=2">2</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=3">3</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=4">4</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=5">5</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=6">6</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=7">7</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=8">8</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=9">9</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=10">10</a>
									</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>


		<div class="col">
			<div class="alrty alert-primary" role="alert">
				<h3>Recette par cluster</h3>
			</div>
			<c:forEach items="${rcluster}" var="recipe">

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
									<c:forEach items="${recipe.ingredients}" var="ing">
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
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<div class="container">
					<p>Catégorie : ${recipe.categorie}</p>
					<div class="card" style="width: 400px">

						<div class="card-body">
							<h4 class="card-title">${recipe.title}</h4>
							<p class="card-text">
								Budget: <b>${recipe.budget}</b> Temps de préparation: <b>${recipe.timePrepa}</b>
							</p>
							<p class="card-text">
								Note: <b>${recipe.rating}</b>
							</p>
							<button type="button" class="btn btn-info btn-lg"
								data-toggle="modal" data-target="#${recipe.idRecipe}">Détails</button>
							<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">Noter</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=0">0</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=1">1</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=2">2</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=3">3</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=4">4</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=5">5</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=6">6</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=7">7</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=8">8</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=9">9</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=10">10</a>
									</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<div class="col">
			<br> <br>
			<div class="alrty alert-primary" role="alert">
				<h3>Recette par similarité entres utilisateurs</h3>
			</div>
			<c:forEach items="${ruser}" var="recipe">

				<div id="r${recipe.idRecipe}" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<div class="modal-body">NOTE</div>
					</div>
				</div>
				<!-- Modal content-->
				<div class="modal-content">
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
										<c:forEach items="${recipe.ingredients}" var="ing">
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
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

					<div class="container">
						<p>Catégorie : ${recipe.categorie}</p>
						<div class="card" style="width: 400px">

							<div class="card-body">
								<h4 class="card-title">${recipe.title}</h4>
								<p class="card-text">
									Budget: <b>${recipe.budget}</b> Temps de préparation: <b>${recipe.timePrepa}</b>
								</p>
								<p class="card-text">
									Note: <b>${recipe.rating}</b>
								</p>
								<button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" data-target="#${recipe.idRecipe}">Détails</button>
								<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">Noter</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=0">0</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=1">1</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=2">2</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=3">3</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=4">4</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=5">5</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=6">6</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=7">7</a> <a class="dropdown-item"
											href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=8">8</a> <a class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=9">9</a> <a
											class="dropdown-item" href="ServletNoteRecipe?idRecipe=${recipe.idRecipe}&note=10">10</a>
									</div>

							</div>
						</div>
					</div>
				</div>

			</c:forEach>

		</div>

	</div>



	</div>


</body>

</html>



