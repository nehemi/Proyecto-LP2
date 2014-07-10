<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<c:url value="clientes/show" var="urlSubmit">
		</c:url>

		<table class="tabla-cebra">
			<caption>Lista de Clientes</caption>

			<tr>
				<td colspan="5">
				
					<form action="${urlSubmit}" method="get" id="formulario">
					   Buscar: <input type="text" value="${p.nombre}" name="nombre"
					placeholder="Nombre" autofocus="autofocus" required style="width: 300px; "><input type="submit" value="Buscar">
									</form></td>
			</tr>
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('clientes/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Paterno</th>
				<th>Materno</th>
				<th>Dni</th>
				<th>Ruc</th>
				<th>Email</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.nombre}</td>
					<td>${p.apePat}</td>
					<td>${p.apeMat}</td>
					<td>${p.dni}</td>
					<td>${p.ruc}</td>
					<td>${p.email}</td>
					<td>${p.direccion}</td>
					<td>${p.telefono}</td>
					<td><a href="#" onclick="upeu.cargarUrl('clientes/${p.id}')">[Edit]</a></td>
					<td><a href="#"
						onclick="upeu.cargarUrl('clientes/del/${p.id}')">[Eliminar]</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>

	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('clientes/nuevo')">+ Nuevo</a>
		</p>
		<div class="aviso">No se encontraron clientes</div>

	</c:otherwise>
</c:choose>
<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>