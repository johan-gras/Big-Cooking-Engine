<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Compiled and minified CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
            <!-- Compiled and minified JavaScript -->
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.jss"></script>
            <link rel="stylesheet" type="text/css" href="CSS/style_log.css">
            <title>Liste des recettes recommendées pour vous !</title>
        </head>

        <body>
            <nav class="navbar navbar-expand-sm bg-light">
                <!-- Links -->
                <ul class="navbar-nav">

                    <li class="nav-item"><a class="nav-link" href="index.jsp"></a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="profile.jsp">Mon
				profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="SuggestionIng.jsp">Suggestion
				d'ingrédients</a></li>
                    <li class="nav-item"><a class="nav-link" href="RecommendedRcipe.jsp">Mes recommendations</a></li>
                </ul>
            </nav>
            <c:forEach items="${rec}" var="recipe">

                <div class="container">

                    <p>Catégorie : ${recipe.categorie}</p>
                    <div class="card" style="width: 400px">
                        <img class="card-img-top" src="img/g-gif-update.php.gif" alt="Card image" style="width: 100%">
                        <div class="card-body">
                            <h4 class="card-title">${recipe.title}</h4>
                            <p class="card-text">Budget: <b>${recipe.budget}</b> Temps de préparation: <b>${recipe.timePrepa}</b></p>
                            <p class="card-text">Note: <b>${recipe.rating}</b> </p>
                            <a href="#" class="btn btn-primary">See Profile</a>
                        </div>
                    </div>
                </div>

            </c:forEach>

            <br>

        </body>

        </html>
