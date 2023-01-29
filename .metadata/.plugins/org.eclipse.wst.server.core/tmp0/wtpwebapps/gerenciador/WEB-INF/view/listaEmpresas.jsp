<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@
page import = "java.util.List,br.com.alura.gerenciador.modelo.Empresa"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp" />
	
	Usuario Logado: ${usuarioLogado.login}
	
	<c:if test="${not empty empresa}">
		<h1>Cadastrando nova empresa ${empresa}</h1>
	</c:if>
	
	<br>
	
	<h1>Lista de Empresas</h1>

		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a> 
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a> 
				</li>
				<br>
				
			</c:forEach>
		</ul>
	
</body>
</html>