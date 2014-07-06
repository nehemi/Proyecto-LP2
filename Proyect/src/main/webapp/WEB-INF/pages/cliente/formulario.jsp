<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty cliente.id}">
		<c:url value="clientes/${cliente.id}" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="clientes/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>
<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Cliente</h1>
	<p>
		<input type="text" value="${cliente.nombre}" name="nombre"
			placeholder="Nombre" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${cliente.apePat}" name="apePat"
			placeholder="Paterno" required>
	</p>
	<p>
		<input type="text" value="${cliente.apeMat}" name="apeMat"
			placeholder="Materno" required>
	</p>
	<p>
		<input type="text" value="${cliente.dni}" name="dni"
			placeholder="Dni" required>
	</p>
	<p>
		<input type="text" value="${cliente.ruc}" name="ruc"
			placeholder="Ruc" required>
	</p>
	<p>
		<input type="text" value="${cliente.email}" name="email"
			placeholder="Email" required>
	</p>
	<p>
		<input type="text" value="${cliente.direccion}" name="direccion"
			placeholder="Direccion" required>
	</p>
	<p>
		<input type="text" value="${cliente.telefono}" name="telefono"
			placeholder="Telefono" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('clientes/');">
		<c:if test="${not empty cliente.id}">
			<input type="hidden" name="id" value="${cliente.id}">
		</c:if>
	</p>
</form>
<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>