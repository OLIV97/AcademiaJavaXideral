<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista personal</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista entrada salida persona</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Personal"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Hora entrada</th>
					<th>Hora salida</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPersonal" items="${allpersonal}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/personal/showFormForUpdate">
						<c:param name="personalId" value="${tempPersonal.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/personal/delete">
						<c:param name="personalId" value="${tempPersonal.id}" />
					</c:url>					
					
					<c:url var="checkLinkentrada" value="/personal/checkEntradaSalida">
						<c:param name="personalId" value="${tempPersonal.id}" />
						<c:param name="tipo" value="ENTRADA" />
					</c:url>
					<c:url var="checkLinksalida" value="/personal/checkEntradaSalida">
						<c:param name="personalId" value="${tempPersonal.id}" />
						<c:param name="tipo" value="SALIDA" />
					</c:url>
					<tr>
						<td> ${tempPersonal.nombres} </td>
						<td> ${tempPersonal.apellidos} </td>
						<td> ${tempPersonal.horaentrada} </td>
						<td> ${tempPersonal.horasalida} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Desea eliminar a ${tempPersonal.nombres}?'))) return false">Eliminar</a>
							 |
							 <a href="${checkLinkentrada}">Checar entrada</a>
							  |
							 <a href="${checkLinksalida}">Checar salida</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









