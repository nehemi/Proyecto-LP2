<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<table class="tabla-cebra">
			<caption>Lista de Productos</caption>
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('productos/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Codigo</th>
				<th>Descripcion</th>
				<th>Precio</th>
				<th>Stock</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.codigo}</td>
					<td>${p.descripcion}</td>
					<td>${p.precio}</td>
					<td>${p.stock}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('productos/${p.id}')">[Edit]</a>
						&nbsp;&nbsp; 
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('productos/nuevo')">+ Nuevo</a>
		</p>
		<div class="aviso">No se encontraron productos</div>
	</c:otherwise>
</c:choose>