<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Преподаватели</title>
</head>
<h2><p align="center">Изменение данных преподавателя</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <c:url value="/webapp/edit_professor" var="var"/>
    <form:form method="post" action="${var}" modelAttribute="professor">
        <table border="0">
            <tr>
                <form:input type="hidden" path="professorId"/>
                <td>ФИО:</td>
                <td><form:input path="fullName"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Изменить данные преподавателя"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>