<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Candidature</title>
<link href="" rel="stylesheet">
<style>
body {
  background-image: url('image.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
div.container{
			vertical-align: middle;
			
			max-width: 650px;
			align-items: center;
			justify-content: center;
			margin-top: 250px;
			margin-right: 100px;}
	div.form{
			vertical-align: middle;
			
			max-width: 650px;
			align-items: center;		
</style>
</head>
<body>
	<%// final String admis = (String) request.getAttribute("admis"); 
//out.println(admis);
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
		
			      <center><h2 class="animation a1">Bienvenue </h2></center>
			      <center><h4
			      class="animation a2">Cette application permet la vérification de
						l'admission a l'uit</h4></center>
    

			
	</nav>

	
	<div class="form">

		<form name="form" action="Verification" method="post" style="text-align: center;">
			<div class="form-group">
				<label for="cin">  CIN : </label> <input type="text"
					class="form-control" id="exampleInputEmail1" name="cin">
			</div><br>
			
			<div class="form-group">
				<label for="exampleInputEmail1">N_d'etudiant: </label> <input
					type="text" class="form-control" id="exampleInputEmail1" name="num">
			</div><br>
			
			<button type="submit" class="btn btn-primary">Verifier</button>
		</form>
		
	</div>
	</p>



	<script src="static/js/bootstrap.bundle.min.js"></script>
</body>
</html>