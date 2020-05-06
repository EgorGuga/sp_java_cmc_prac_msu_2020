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
<h2><p align="center">Поиск по курсу и потоку</p></h2>
<form:form method="post" modelAttribute="courseAndFlow">
    <table align="center" border="0">
        <tr>
            <td>Курс:</td>
            <td>
                <form:select path = "Course">
                    <form:option value = "${1}" label = "1"/>
                    <form:option value = "${2}" label = "2"/>
                    <form:option value = "${3}" label = "3"/>
                    <form:option value = "${4}" label = "4"/>
                    <form:option value = "${5}" label = "5"/>
                    <form:option value = "${6}" label = "6"/>
                    <form:option value = "${7}" label = "7"/>
                    <form:option value = "${8}" label = "8"/>
                    <form:option value = "${9}" label = "9"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Поток:</td>
            <td>
                <form:select path = "Flow">
                    <form:option value = "${1}" label = "1"/>
                    <form:option value = "${2}" label = "2"/>
                    <form:option value = "${3}" label = "3"/>
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
