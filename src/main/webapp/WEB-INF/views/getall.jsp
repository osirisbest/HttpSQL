<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>
	Список всех книг  
</h1>

<table>

<tr><th>ID</th>
	<th>Название</th>
	<th>Автор</th>
	<th>Цена</th>
	<th>Редактировать</th>
	<th>Удалить</th>
</tr>

<c:forEach var="book" items="${list}">
<tr><td>${book.id}</td>
	<td>${book.title}</td>
	<td>${book.author}</td>
	<td>${book.price}</td>
	<td><a href="edit/${book.id}">редактировать ${book.id}</a></td>
	<td><a href="del/${book.id}">удалить ${book.id}</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>