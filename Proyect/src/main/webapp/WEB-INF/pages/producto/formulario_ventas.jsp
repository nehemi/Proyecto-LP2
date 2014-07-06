<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty ventas}">
		<form action="productos/producto/editar" method="post" id="formulario">
			<table class="tabla-cebra">
				<caption>Selecciona las Ventas</caption>
				<c:forEach items="${ventas}" var="c" varStatus="cs">
					<tr>
						<td><input name="id_venta" type="checkbox" ${c.checked}
							value="${c.id}"></td>
						<td>${c.fecha}</td>
						<td>${c.detalle}</td>
						<td>${c.cantidad}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><input type="hidden" name="id_producto"
						value="${id_producto}"> <input type="submit" value="Guardar">
					</td>
				</tr>
			</table>
		</form>
		<script>
			upeu.enviarFormulario({
				id : 'formulario',
				target : 'contenido'
			});
		</script>
	</c:when>
	<c:otherwise>
		<div class="aviso">No se encontraron cursos</div>
	</c:otherwise>
</c:choose>