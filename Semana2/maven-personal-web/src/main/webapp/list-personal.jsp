<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Lista de asistencia</title>

<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista de asistencia.</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Student -->

			<input type="button" value="Add Personal"
				onclick="window.location.href='add-personal-form.jsp'; return false;"
				class="add-student-button" />

			<table>

				<tr>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Hora entrada</th>
					<th>Hora salida</th>
					<th>Acciones</th>
				</tr>

				<c:forEach var="tempPersonal" items="${PERSONAL_LIST}">

					<!-- set up a link for each student -->
					<c:url var="tempLink" value="PersonalControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="personalId" value="${tempPersonal.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="PersonalControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="personalId" value="${tempPersonal.id}" />
					</c:url>

					<c:url var="checkentradaLink" value="PersonalControllerServlet">
						<c:param name="command" value="ENTRADA" />
						<c:param name="personalId" value="${tempPersonal.id}" />
					</c:url>
					<c:url var="checksalidaLink" value="PersonalControllerServlet">
						<c:param name="command" value="SALIDA" />
						<c:param name="personalId" value="${tempPersonal.id}" />
					</c:url>
					<tr>
						<td>${tempPersonal.nombres}</td>
						<td>${tempPersonal.apellidos}</td>
						<td>${tempPersonal.horaentrada}</td>
						<td>${tempPersonal.horasalida}</td>
						<td><a href="${tempLink}">Actualizar</a> | <a
							href="${deleteLink}"
							onclick="if (!(confirm('Estas seguro de borrar al personal ${tempPersonal.nombres}?'))) return false">
								Eliminar</a> | <a href="${checkentradaLink}">Checar Entrada</a> | <a
							href="${checksalidaLink}">Checar Salida</a></td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
</body>


</html>








