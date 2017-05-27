<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<fmt:setLocale value="pt_BR" />
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 10%">ID</td>
			<td style="width: 30%">NOME</td>
			<td style="width: 10%">PREÇO</td>
			<td style="width: 10%">CATEGORIA</td>
			<td style="width: 20%">INGREDIENTES</td>
			<td style="width: 20%">AÇÃO</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pizzas}" var="pizza">
			<tr data-id="${pizza.id}">
				<td>${pizza.id}</td>
				<td>${pizza.nome}</td>
				<td><fmt:formatNumber value="${pizza.preco}" type="currency" /></td>
				<td>${pizza.categoria}</td>
				<td><c:forEach items="${pizza.ingredientes}" var="ingrediente">
					${ingrediente.nome}</br>
					</c:forEach></td>
				<td>
					<button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Deletar</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Pizzas cadastradas: <span id="quantidade-pizzas">${pizzas.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-pizza">Nova Pizza</button>
			</td>
		</tr>
	</tfoot>
</table>