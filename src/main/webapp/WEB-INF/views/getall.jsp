<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<script type="text/javascript">
	//alert("Hi!");
</script>
<h1>
	Список всех книг  
</h1>

<form:form modelAttribute="book" action="save" method="POST">

<form:input path="title" style="width:1000"/>
<form:input path="author"/>
<form:input path="price"/>
<input type="submit" name="Записать" VALUE="Записать книгу в базу данных">
</form:form>

<table width="100%" border="1" align="center" cellpadding="4" cellspacing="0">

<tr><th>ID</th>
	<th>Название/Ссылка</th>
	<th>Автор/Тема ресурса</th>
	<th>Цена</th>
	<th>Редактировать</th>
	<th>Удалить</th>
</tr>

<c:forEach var="book" items="${list}">
<tr><td>${book.id}</td>
	<td><a href="${book.title}">${book.title}</a></td>
	<td>${book.author}</td>
	<td>${book.price}</td>
	<td><a href="edit/${book.id}">редактировать ${book.id}</a></td>
	<td><a href="del/${book.id}">удалить ${book.id}</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>
