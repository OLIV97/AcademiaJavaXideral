<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Personal</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-personal-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Lista entrada salida personal</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar personal</h3>
	
		<form:form action="savePersonal" modelAttribute="personal" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombres:</label></td>
						<td><form:input path="nombres" /></td>
					</tr>
				
					<tr>
						<td><label>Apellidos:</label></td>
						<td><form:input path="apellidos" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/personal/list">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>










