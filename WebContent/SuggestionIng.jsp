<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<!-- Compiled and minified JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.jss"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-bar-rating/1.2.2/jquery.barrating.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="CSS/style_log.css">
<title>Page de suggestion</title>
</head>

<body>
	<br>
	<c:import url="navBar.jsp"></c:import>
	<h1>Notez l'ingrédient</h1>
	<h2>${ingred.name}</h2>
	<img src=${ingred.photo} width="100px" height="100px"/>

	<div class="btn-group d-block mx-auto" role="group"
		aria-label="Basic example">
		<a type="button" class="btn btn-secondary" href=ServeltRateIngred?param=0>0</a>
		<a type="button" class="btn btn-secondary" href=ServeltRateIngred?param=1>1</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=2>2</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=3>3</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=4>4</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=5>5</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=6>6</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=7>7</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=8>8</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=9>9</a> <a type="button"
			class="btn btn-secondary" href=ServeltRateIngred?param=10>10</a>
	</div>

</body>
</html>