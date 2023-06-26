<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Alunos</title>
</head>
<body>

<!-- 	Explicar o que é scriplets e dizer que não é uma boa ideia -->

<!-- 	mostrar depois o JSTL -->
	<ul>
		<c:forEach var="aluno" items="${alunos}">
			<li>${aluno.id} - ${aluno}</li>
		</c:forEach>
	</ul>


</body>
</html>