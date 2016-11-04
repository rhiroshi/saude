<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>Sistema de Busca sem Refresh</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
		<script type="text/javascript" src="javascriptpersonalizado.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container theme-showcase" role="main">
			<div class="page-header">
				<h1>Pesquisar Cursos</h1>
				<form method="POST" id="form-pesquisa" action="">
					<div class="form-group">
						<input type="text" name="pesquisa" class="form-control" id="pesquisa" placeholder="O que você está procurando?">
					</div>
				</form>
				
				
			</div>
			<div class="row">
				<div class="col-md-6">
					<ol class="resultado">
				
					</ol>
				</div>
			</div>
			
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>