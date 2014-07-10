<!DOCTYPE html>
<html lang="es">
<head>
  <title>
  Ventas
  </title>
<link rel="stylesheet" type="text/css" href="static/css/estilo.css">
<script type="text/javascript" src="static/js/vendor/jquery.js"></script>
<script type="text/javascript" src="static/ajax/funcionesUtils.js" ></script>
<script type="text/javascript" charset="utf-8" src="static/ui/minified/jquery-ui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="static/ui/jquery.ui.core.js"></script>
<script type="text/javascript" charset="utf-8" src="static/ui/jquery.ui.autocomplete.js"></script>

<script type="text/javascript" charset="utf-8">
            $(document).ready( function () {
                $('#tablaLp2').dataTable( {
                          "bJQueryUI": true,
                          "sPaginationType": "full_numbers"
                  } );
               
        
            //inicio
            $("#textBuscar").autocomplete({
            source: function( request, response ) {
            $.ajax({
            url: "ventas/aut?&q="+$("#textBuscar").val(),
            dataType: "json",
            data: {term: request.term},
            success: function(data) {
                    response($.map(data, function(item) {
                    return {
                        label: item.label,
                        id: item.id,
                        valor: item.valor,
                        direccion:item.direccion,
                        dni:item.dni,
                        ruc:item.ruc,
                        email:item.email,
                        telef:item.telef
                        };
                        }));
                    }                                          
            });
            },
            minLength: 2,                                
            select: function(event, ui) {                                        
                $('#textNombre').val(ui.item.valor);
                $('#textCodigo').val(ui.item.id);  
                $('#formBusar').submit();
            }
            });
        
                  
                  
                  
            } );
    </script>
      <script type="text/javascript">
        function saludo(){
            var  dato=$("#codigo").val();
            alert(dato);
        }
    </script>
    </head>
    <body>
    
    <div style="width: 50%; height: 30px; border-radius: 5px" 
     class="ui-widget-header">
    <form id="formBusar" action="ventas/aut">
    Nombre/codigo: 
    <input type="text" id="textBuscar" name="textBuscar" />    
    <input type="hidden" id="textCodigo" name="textCodigo" />
    <input type="hidden" name="opc" id="opc" value="7"/>
    <input type="button" id="btnBuscar" name="btnBuscar" onclick="" value="Buscar" />
    
    </form>
    <br/>
</div>
    </body>
    
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
			<form  >
			<div align="right">
                 <label  for='fecha'>Fecha:</label>
                   <input type='date' id='fecha' placeholder='ingrese fecha' required>
                </div>
                <br>
                <br>
                <div align="left">
                  <label for='sr'>Sr.(a):</label> <input type='text' id='sr' placeholder='Ingrese nombre' required><input type="submit" value="Buscar" style="width: 74px; ">

                  <label for='RUC'>RUC</label>
                   <input type="number" id='RUC'placeholder='Ingrese RUC'required>

                  <label for='dni'>DNI:</label>
                   <input type="number" id='dni' placeholder='Ingrese DNI' required>

                  <label for='direccion'>Direccion:</label>
                   <input type='text' id='direccion' placeholder='Ingrese direccion' required>
    	
        			<br>
        			<br>
        			<br>           
                  <label for='articulo'>Producto:</label>
                   <input type='text' id='articulo' placeholder='busque Producto' required> <input type='submit' value='buscar' id='btnSubmit'>

                   
                  <label for='cant'>Cant:</label>
                   <input type="number" id='numerodebol'placeholder='Cant'>
                   </div>
                   </form>
                   <p>
                    <table class ="tabla-cebra">
             
                    <tr>
                    <td colspan="5" class="estilo9">
<!--                     <div align="center" class="estilo11"> -->
                      
                        <td>codigo</td>
                        <td>descripcion</td>
                        <td>precio</td>
                        <td>cantidad</td>
                        <td>importe</td>

                        <tr>

                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

<!--  						</td> -->
<!--  						</tr> -->
<!-- 					</div> -->
                      </table>
                      

                   
                  

                   <label for='subtotal'>Subtotal:</label>
                   <input type='text' id='subtotal' >

                   <label for='igv'>IGV:</label>
                   <input type="number" id='igv' >

                   

                   <label for='total'>Total:</label>
                   <input type="number" id='total'>

                   
                   
                   	<p>
						<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
						type="button" value="Cancelar" onclick="upeu.cargarUrl('ventas/');">
						<c:if test="${not empty venta.id}">
						<input type="hidden" name="id" value="${venta.id}">
						</c:if>
					</p>
                   
           
<%-- <form action="${urlSubmit}" method="POST" id="formulario"> --%>
<!-- 	<h1>Registro de Venta</h1> -->
<!-- 	<p> -->
<%-- 		<input type="text" value="${venta.fecha}" name="fecha" --%>
<!-- 			placeholder="Fecha" autofocus="autofocus" required> -->
<!-- 	</p> -->
<!-- 	<p> -->
<%-- 		<input type="text" value="${venta.detalle}" name="detalle" --%>
<!-- 			placeholder="Detalle" required> -->
<!-- 	</p> -->
<!-- 	<p> -->
<%-- 		<input type="text" value="${venta.cantidad}" name="cantidad" --%>
<!-- 			placeholder="Cantidad" required> -->
<!-- 	</p> -->
<!-- 	<p> -->
<!-- 		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input -->
<!-- 			type="button" value="Cancelar" onclick="upeu.cargarUrl('ventas/');"> -->
<%-- 		<c:if test="${not empty venta.id}"> --%>
<%-- 			<input type="hidden" name="id" value="${venta.id}"> --%>
<%-- 		</c:if> --%>
<!-- 	</p> -->


<!-- </form> -->



<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>