<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value='/CSS/style.css' />" >

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<title>Inscription</title>
<Style>
#success_message {
	display: none;
}
</Style>
<!-- Latest compiled and minified JavaScript -->
<script language="JavaScript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#inscription_form").validate({
			rules : {
				first_name : {
					required : true
				}
			},
			messages : {
				first_name : "Veuillez fornir votre nom",
			}
		});
	});
</script>

</head>
<body>
	<div class="container">

		<form class="well form-horizontal" action="CreatUser" method="post"
			id="inscription_form">
			<fieldset>

				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>Inscription</b>
						</h2>
					</center>
				</legend>
				<br>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Nom</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="first_name"
								placeholder="First Name" class="form-control" type="text"
								aria-required="true" aria-invalid="false"> <label
								id="first_name-error" class="error" for="Nom"></label>
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Prénom</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="last_name"
								placeholder="Prénom" class="form-control" type="text">
						</div>
					</div>
				</div>
				

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Nom d'Utilisateur</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="user_name"
								placeholder="Username" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Mot de passe</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="user_password" placeholder="Mot de passe"
								class="form-control" type="password">
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Confirmation du mot
						de passe</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="confirm_password"
								placeholder="Confirmation du mot de passe" class="form-control"
								type="password">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								placeholder="E-Mail Address" class="form-control" type="text">
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Votre Poid</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								name="poid" placeholder="Poid" class="form-control"
								type="text">
						</div>
					</div>
				</div>

				<!-- Select Basic -->

				<!-- Success message -->
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<br>
						<button type="submit" class="btn btn-warning">
							<span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	</div>

	<!-- /.container -->
</body>

</html>



