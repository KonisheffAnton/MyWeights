
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Outfit</title>
</head>
<body>
<h2>Exercise List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
<tr><th>Name</th><th>Weight</th><th></th></tr>
<c:forEach var="exercise" items="${exercises}">
 <tr><td>${exercise.name}</td>
    <td>${exercise.weight}</td>
    <td>
    <a href='<c:url value="/edit?id=${exercise.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="id" value="${exercise.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>