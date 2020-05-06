<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Преподаватели</title>
</head>
<body>
<h2><p align="center">Информация о преподавателях</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<table align="center">
    <tr>
        <th>ФИО</th>
    </tr>
    <c:forEach var="professor" items="${ProfessorList}">
        <tr>
            <td>${professor.fullName}</td>
            <td><a href="/webapp/timetable/professor/${professor.professorId}">Расписание</a></td>
            <td><a href="/webapp/professor_courses/${professor.professorId}">Курсы</a></td>
            <td><a href="/webapp/edit_professor/${professor.professorId}">Изменить</a></td>
            <td><a href="/webapp/delete_professor/${professor.professorId}">Удалить</a></td>

        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/webapp/add_professor">Добавить преподавателя</a></p>
<p><%= new java.util.Date() %></p>
</body>
</html>
