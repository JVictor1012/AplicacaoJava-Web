
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD de Produtos</title>
</head>
<body>

	<%@ page import="com.crudprodutos.dao.ProdutoDao, com.crudprodutos.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1>Listagem de Produtos</h1>
	
	<%
	List<Produto> list = ProdutoDao.getAllProdutos();
	request.setAttribute("list", list);
	%>
	
	<table >
	<tr>
		<th>Código</th>
		<th>Descricao</th>
	</tr>
	
	<c:forEach items="${list}" var="produto">
	
	<tr>
		<td>${produto.getCodigo() }</td>
		<td>${produto.getDescricao() }</td>
		
	</tr>
	</c:forEach>
	</table>
</body>
</html>