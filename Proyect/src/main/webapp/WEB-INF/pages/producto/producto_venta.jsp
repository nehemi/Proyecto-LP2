<%@include file="/common/taglibs.jsp"%>
<h1>Ventas de ${producto.codigo}</h1>
<c:choose>
	<c:when test="${not empty producto.ventas}">
		<table class="tabla-cebra">
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('productos');">[Atras]</a>&nbsp;&nbsp;&nbsp;<a
					href="#"
					onclick="upeu.cargarUrl('productos/venta/editar?id=${producto.id}')">Editar
						Ventas</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Fecha</th>
				<th>Detalle</th>
				<th>Cantidad</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${producto.ventas}" var="c" varStatus="cs">
				<tr>
					<td>${cs.count}</td>
					<td>${c.fecha}</td>
					<td>${c.detalle}</td>
					<td>${c.cantidad}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('productos/venta/eliminar?id_producto=${producto.id}&id_venta=${c.id}')">[Elim]</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('productos/venta/nuevo')">+
				Nuevo</a>
		</p>
		<div class="aviso">No se encontraron productos</div>
	</c:otherwise>
</c:choose>