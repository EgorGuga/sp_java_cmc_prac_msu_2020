<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Аудитории</title>
</head>
<body>
<h2><p align="center">Информация об аудиториях</p></h2>
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
        <th>Номер</th>
        <th>Вместимость</th>
    </tr>
    <c:forEach var="lecture_hall" items="${LectureHallList}">
        <tr>
            <td>${lecture_hall.number}</td>
            <td>${lecture_hall.capacity}</td>
            <td><a href="/webapp/timetable/lecture_hall/${lecture_hall.lectureHallId}">Расписание</a></td>
            <td><a href="/webapp/edit_lecture_hall/${lecture_hall.lectureHallId}">Изменить</a></td>
            <td><a href="/webapp/delete_lecture_hall/${lecture_hall.lectureHallId}">Удалить</a></td>

        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/webapp/add_lecture_hall">Добавить аудиторию</a></p>
<p><%= new java.util.Date() %></p>
</body>
</html>
