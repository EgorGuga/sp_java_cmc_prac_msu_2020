<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Курсы</title>
</head>
<h2><p align="center">Изменение данных курса</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <c:url value="/webapp/edit_course" var="var"/>
    <form:form method="post" action="${var}" modelAttribute="course">
        <table border="0">
            <form:input type="hidden" path="courseId"/>
            <tr>
                <td>Название:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Курс:</td>
                <td><form:input path="yearOfStudy"/></td>
            </tr>
            <tr>
                <td>Покрытие:</td>
                <td>
                    <form:select path = "coverage">
                        <form:option value = "Группа" label = "Группа"/>
                        <form:option value = "Поток" label = "Поток"/>
                        <form:option value = "Спец. курс" label = "Спец. курс"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Интенсивность:</td>
                <td><form:input path="intensity"></form:input></td>
            </tr>
            <tr>
                <td>Год:</td>
                <td><form:input path="year"></form:input></td>
            </tr>
            <td>Активен:</td>
            <td>
                <form:radiobutton path = "active" value = "${1}" label = "Да"/>
                <form:radiobutton path = "active" value = "${0}" label = "Нет"/>
            </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Изменить данные курса"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>