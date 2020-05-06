<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание</title>
</head>
<body>
<h2><p align="center">Расписание</p></h2>
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
<h2><p align="center"><c:out value="${message}" /></p></h2>
<table align="center">
    <tr>
        <th>Предмет</th>
        <th>Вид</th>
        <th>Профессор</th>
        <th>Аудитория</th>
        <th>День недели</th>
        <th>Время начала</th>
        <th>Время конца</th>
    </tr>
    <c:forEach var="clazz" items="${ClazzList}">
        <tr>
            <td>${clazz.courseByCourseId.name}</td>
            <td>${clazz.courseByCourseId.coverage}</td>
            <td>${clazz.professorByProfessorId.fullName}</td>
            <td>${clazz.lectureHallByLectureHallId.number}</td>
            <td>${clazz.dayOfTheWeek}</td>
            <td>${clazz.startTime}</td>
            <td>${clazz.endTime}</td>
            <td><a href="/webapp/edit_clazz/${clazz.classId}">Изменить</a></td>
            <td><a href="/webapp/delete_clazz/${clazz.classId}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${type == 1}">
    <p align="center"><a href="/webapp/timetable/student/${studentId}/apply_clazz">Добавить индивидуальное занятие</a></p>
</c:if>
<c:if test="${type == 2}">
    <p align="center"><a href="/webapp/timetable/group/${groupId}/apply_clazz">Добавить групповое занятие</a></p>
</c:if>
<c:if test="${type == 3}">
    <p align="center"><a href="/webapp/timetable/course/${course}/flow/${flow}/apply_clazz">Добавить поточное занятие</a></p>
</c:if>

<p><%= new java.util.Date() %></p>
</body>
</html>
