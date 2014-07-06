<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty venta.id}">
		<c:url value="ventas/${venta.id}" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="ventas/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>
<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Venta</h1>
	<p>
		<input type="text" value="${venta.fecha}" name="fecha"
			placeholder="Fecha" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${venta.detalle}" name="detalle"
			placeholder="Detalle" required>
	</p>
	<p>
		<input type="text" value="${venta.cantidad}" name="cantidad"
			placeholder="Cantidad" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('ventas');">
		<c:if test="${not empty venta.id}">
			<input type="hidden" name="id" value="${venta.id}">
		</c:if>
	</p>


</form>
<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>