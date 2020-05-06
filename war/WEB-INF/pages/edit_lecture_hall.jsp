<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Аудитории</title>
</head>
<h2><p align="center">Изменение данных аудитории</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <c:url value="/webapp/edit_lecture_hall" var="var"/>
    <form:form method="post" action="${var}" modelAttribute="lecture_hall">
        <table border="0">
            <form:input type="hidden" path="lectureHallId"/>
            <tr>
                <td>Номер:</td>
                <td><form:input path="number"/></td>
            </tr>
                <td>Вместимость:</td>
                <td><form:input path="capacity"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Изменить данные аудитории"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>