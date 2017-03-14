
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
	<c:import url="/frontend/views/usuario/header.jsp"/>
	
	<!-- AQUI VAI O CONTENT -->
	<div class="content">
		<table>
			<th>
				<td>Ra</td>
				<td>Nome</td>
				<td>Email</td>
				<td>Tipo</td>
				<td>Permissao</td>
			</th>
			<%-- <c:forEach ">
			<tr>
				<td>${usuario.ra}</td>
			</tr>
			</c:forEach> --%>
		</table>
	</div>
	
	
</body>
</html>