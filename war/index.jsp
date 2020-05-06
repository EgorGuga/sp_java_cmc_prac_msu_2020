<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Главная страница</title>
  </head>
  <body>
    <h2><p align="center">Это главная страница</p></h2>
    <p align="center">
      <a href="/webapp">Главная страница</a>&emsp;
      <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
      <a href="/webapp/students">Информация о студентах</a>&emsp;
      <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
      <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
      <a href="/webapp/courses">Информация о курсах</a>&emsp;
    </p>
    <p><%= new java.util.Date() %></p>
  </body>
</html>
