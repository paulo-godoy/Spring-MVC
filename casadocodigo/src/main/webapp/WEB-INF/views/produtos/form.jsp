<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livraria Virtual</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
	<form:form action= "${s:mvcUrl('PC#grava').build()}" method="post" commandName="produto">
		<div class="form-group">
			<label for="formGroupExampleInput">Titulo</label>
			 <input type="text" name="titulo" class="form-control" id="formGroupExampleInput" placeholder="Digite um titulo" required>
			 <form:errors path="titulo" />
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput2">Descrição</label>
			<textarea rows="10" cols="20" name="descricao" class="form-control" id="formGroupExampleInput2"
				placeholder="Digite sua descrição aqui!" required ></textarea>
				<form:errors path="descricao" />
				
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput3">Paginas</label>
			<input type="text" name="paginas" class="form-control" id="formGroupExampleInput3" placeholder="" required>
			<form:errors path="paginas" />
		</div>
		
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <div class="form-group">
				<label for="formGroupExampleInput5">${tipoPreco}</label> 
				<input type="text" name="precos[${status.index}].valor" class="form-control" value="" id="formGroupExampleInput5" >
				<input type="hidden" name="precos[${status.index}].tipo" class="form-control" value="${tipoPreco}" id="formGroupExampleInput5" >
			</div>
        </div>
    </c:forEach>
		<button class="btn btn-primary" type="submit">Cadastrar</button>
	</form:form>
</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>