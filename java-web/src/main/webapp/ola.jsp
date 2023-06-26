<%@page import="modelo.Aluno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olá JSP</title>
</head>
<body>

	Olá mundo JSP
	
	<%="oi" %>
	
	<%out.println("isso sairá na tela");
	
	
		Aluno a = new Aluno();
		a.setNome("rafa");
		out.println("nome é "+ a.getNome());
	%>
	
	<%System.out.println("isso sairá no servidores"); %>

</body>
</html>