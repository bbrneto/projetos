<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>
	<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="usuario.nome" class="form-control" value="${usuario.nome}">
		<alura:validationMessage name="usuario.nome"/>
		
		<label for="email">Email:</label>
		<input id="email" type="text" name="usuario.email" class="form-control" value="${usuario.email}">
		<alura:validationMessage name="usuario.email"/>
		
		<label for="login">Login:</label>
		<input id="login" type="text" name="usuario.login" class="form-control" value="${usuario.login}">
		<alura:validationMessage name="usuario.login"/>
				
		<label for="senha">Senha:</label>
		<input id="senha" type="password" name="usuario.senha" class="form-control">
		<alura:validationMessage name="usuario.senha"/>
		
		<input type="submit" value="Cadastrar" class="btn">
	</form>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
