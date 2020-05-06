<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Аудитории</title>
</head>
<body>
<h2><p align="center">Добавление аудитории</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <form:form method="post" modelAttribute="lectureHall">
        <table border="0">
            <tr>
                <td>Номер:</td>
                <td><form:input path="number"/></td>
            </tr>
            <tr>
                <td>Вместимость:</td>
                <td><form:input path="capacity"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Добавить аудиторию"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>
