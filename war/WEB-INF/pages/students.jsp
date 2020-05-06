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
<p align="center">
    <a href="/webapp/find_by_group">Поиск по группе</a>
    <a href="/webapp/find_by_course_and_flow">Поиск по курсу и потоку</a>
</p>
</p>
<h2><p align="center">Все студенты</p></h2>
<table align="center">
    <tr>
        <th>ФИО</th>
        <th>Курс</th>
        <th>Группа</th>
        <th>Поток</th>
    </tr>
    <c:forEach var="student" items="${StudentList}">
        <tr>
            <td>${student.fullName}</td>
            <td>${student.yearOfStudy}</td>
            <td>${student.sGroupByGroupId.groupNumber}</td>
            <td>${student.flowByFlowId.flowNumber}</td>
            <td><a href="/webapp/timetable/student/${student.studentId}">Расписание</a></td>
            <td><a href="/webapp/edit_student/${student.studentId}">Изменить</a></td>
            <td><a href="/webapp/delete_student/${student.studentId}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/webapp/add_student">Добавить студента</a></p>
<p><%= new java.util.Date() %></p>
</body>
</html>
