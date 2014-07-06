<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<table class="tabla-cebra">
			<caption>Lista de Ventas</caption>
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('ventas/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Fecha</th>
				<th>Detalle</th>
				<th>Cantidad</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.fecha}</td>
					<td>${p.detalle}</td>
					<td>${p.cantidad}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('ventas/${p.id}')">[Edit]</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('ventas/nuevo')">+ Nuevo</a>
		</p>
		<div class="aviso">No se encontraron ventas</div>
	</c:otherwise>
</c:choose>