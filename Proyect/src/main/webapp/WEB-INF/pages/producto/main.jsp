<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<c:url value="productos/showp" var="urlSubmit">
		</c:url>

		<table class="tabla-cebra">
			<caption>Lista de Productos</caption>

			<tr>
				<td colspan="5">
				
					<form action="${urlSubmit}" method="get" id="formulario">
					   Buscar: <input type="text" value="${p.descripcion}" name="prod"
					placeholder="Nombre" autofocus="autofocus" required style="width: 300px; "><input type="submit" value="Buscar">
									</form></td>
			</tr>
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
				<th>Total</th>
				<th> <th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.codigo}</td>
					<td>${p.descripcion}</td>
					<td>S/. ${p.precio}</td>
					<td>${p.stock}</td>
					<td>S/. ${(p.stock*p.precio)}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('productos/${p.id_producto}')">[Edit]</a>
						&nbsp;&nbsp; 
					</td>
					<td><a href="#" onclick="upeu.cargarUrl('productos/del/${p.id_producto}')">[Eliminar]</a></td>
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