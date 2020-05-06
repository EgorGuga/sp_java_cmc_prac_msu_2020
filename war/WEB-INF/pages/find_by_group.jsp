<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студенты</title>
</head>
<body>
<h2><p align="center">Информация о студентах</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<h2><p align="center">Поиск по группам</p></h2>
<form:form method="post" modelAttribute="group">
    <table align="center" border="0">
        <tr>
            <td>Группа:</td>
            <td>
                <form:select path = "groupId">
                    <c:forEach var="group" items="${SGroupList}">
                        <form:option value = "${group.groupId}" label= "${group.groupNumber}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Вывести список студентов"/></td>
        </tr>
    </table>
</form:form>
<p><%= new java.util.Date() %></p>
</body>
</html>
