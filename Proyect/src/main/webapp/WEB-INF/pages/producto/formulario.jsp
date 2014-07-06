<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty producto.id}">
		<c:url value="productos/${producto.id}" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="productos/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>
<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Producto</h1>
	<p>
		<input type="text" value="${producto.codigo}" name="codigo"
			placeholder="Codigo" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${producto.descripcion}" name="descripcion"
			placeholder="Descripcion" required>
	</p>
	<p>
		<input type="text" value="${producto.precio}" name="precio"
			placeholder="Precio" required>
	</p>
	<p>
		<input type="text" value="${producto.stock}" name="stock"
			placeholder="Stock" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('productos/');">
		<c:if test="${not empty producto.id}">
			<input type="hidden" name="id" value="${producto.id}">
		</c:if>
	</p>
</form>
<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>