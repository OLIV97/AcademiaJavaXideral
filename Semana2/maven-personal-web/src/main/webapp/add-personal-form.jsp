<!DOCTYPE html>
<html>

<head>
	<title>lista de asistencia</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-personal-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add asistencia</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Personal</h3>
		
		<form action="PersonalControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombres:</label></td>
						<td><input type="text" name="nombres" /></td>
					</tr>

					<tr>
						<td><label>Apellidos:</label></td>
						<td><input type="text" name="apellidos" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PersonalControllerServlet">Regresar a la lista</a>
		</p>
	</div>
</body>

</html>











