<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServletEditarEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />

	<form action="${linkServletEditarEmpresa}" method="post">
	<input type="hidden" name="id" value="${empresa.id}"/>
	<input type="hidden" name="acao" value="AlteraEmpresa"/>
		<label>Nome:</label><input type="text" name="nome" value="${empresa.nome}"/>
		<label>Data Abertura:</label><input type="date" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="yyyy-MM-dd"/>"/>
		<button type="submit">Editar</button>	
	</form>
</body>
</html>