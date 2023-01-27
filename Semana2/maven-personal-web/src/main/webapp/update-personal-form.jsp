<!DOCTYPE html>
<html>

<head>
	<title>lista de asistencia</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Actualizar personal</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Datos a cambiar:</h3>
		
		<form action="PersonalControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="personalId" value="${THE_PERSONAL.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombres:</label></td>
						<td><input type="text" name="nombres" 
								   value="${THE_PERSONAL.nombres}" /></td>
					</tr>

					<tr>
						<td><label>Apellidos:</label></td>
						<td><input type="text" name="apellidos" 
								   value="${THE_PERSONAL.apellidos}" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PersonalControllerServlet">Regresar a la lista asistencia</a>
		</p>
	</div>
</body>

</html>











