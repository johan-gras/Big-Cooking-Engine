<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="witdth-device-width, initial-scale=1">

    <title>Profil utilisateur</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.jss"></script>
    <link rel="stylesheet" type="text/css" href="CSS/style_log.css">
</head>
<style>


</style>

<body>
<nav class="navbar navbar-expand-sm bg-light">
  <!-- Links -->
  <ul class="navbar-nav">
    
    <li class="nav-item">
      <a class="nav-link" href="index.jsp">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="profile.jsp">Mon profile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="SuggestionIng.jsp">Suggestion d'ingrédients</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="RecommendedRcipe.jsp">Mes recommendations</a>
    </li>
  </ul>
</nav>


    <div class="container-fluid">

        <div class="row">

            <div class="col-md-4">

                <img src="http://via.placeholder.com/350x250" />

                <h2> Utilisateur nom</h2>

                <a class="btn btn-primary" href="ServletRecomendationRecipe" role="button">Ma selection de recettes</a>

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

</body>

</html>
