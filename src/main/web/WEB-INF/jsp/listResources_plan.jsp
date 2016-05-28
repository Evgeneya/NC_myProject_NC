<%@ page import="java.util.ArrayList" %>
<%@ page import="myProject.entities.CustomerEntity" %>
<%@ page import="myProject.entities.EmploymentEntity" %>
<%@ page import="myProject.entities.Resources_planEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/employment.css">
<script src="../../js/js.js"></script>
<html>
<head>
  <title>My Project</title>
</head>
<body>
<div id="header">
  <h1>My Project</h1>
</div>
<div id="menu">
  <ul>
    <li id="menu_1" onmouseover="showMenu('1')" onmouseout="hideMenu('1')">Сотрудники</li>
    <li id="menu_2" onmouseover="showMenu('2')" onmouseout="hideMenu('2')">Должности</li>
    <li id="menu_3" onmouseover="showMenu('3')" onmouseout="hideMenu('3')">Проекты</li>
    <li id="menu_4" onmouseover="showMenu('4')" onmouseout="hideMenu('4')">Распределение проектов</li>
    <li id="menu_5" onmouseover="showMenu('5')" onmouseout="hideMenu('5')">Заказчики</li>
    <li id="menu_6" onmouseover="showMenu('6')" onmouseout="hideMenu('6')">Ресурсные планы</li>
  </ul>
</div>
</div>
<div id="submenu_1" style="display:none;" onmouseout="hideMenu('1')">
  <ul>
    <li><a href="/listEmployee">Список cотрудников</a></li>
    <li><a href="/newEmployee">Новый сотрудник</a></li>
    <li><a href="/findEmployee">Поиск сотрудников</a></li>
  </ul>
</div>
<div id="submenu_2" style="display:none;" onmouseout="hideMenu('2')">
  <ul>
    <li><a href="/listPosition">Список должностей</a></li>
    <li><a href="/newPosition">Новая должность</a></li>
    <li><a href="/findPosition">Поиск по должностям</a></li>
  </ul>
</div>
<div id="submenu_3" style="display:none;" onmouseout="hideMenu('3')">
  <ul>
    <li><a href="/listProject">Список проектов</a></li>
    <li><a href="/newProject">Новый проект</a></li>
    <li><a href="/findProject">Поиск по проектам</a></li>
  </ul>
</div>
<div id="submenu_4" style="display:none;" onmouseout="hideMenu('4')">
  <ul>
    <li><a href="/listEmployment">Полный список</a></li>
    <li><a href="/newEmployment">Назначить сотрудника на проект</a></li>
    <li><a href="/findEmployment">Поиск по занятости</a></li>
  </ul>
</div>
<div id="submenu_5" style="display:none;" onmouseout="hideMenu('5')">
  <ul>
    <li><a href="/listCustomer">Список заказчиков</a></li>
    <li><a href="/newCustomer">Новый заказчик</a></li>
    <li><a href="/findCustomer">Поиск заказчиков</a></li>
  </ul>
</div>
<div id="submenu_6" style="display:none;" onmouseout="hideMenu('6')">
  <ul>
    <li><a href="/listResources_plan">Список ресурсных планов</a></li>
    <li><a href="/newResources_plan">Новый ресурсный план</a></li>
    <li><a href="/findResources_plan">Поиск по ресурсным планам</a></li>
  </ul>
</div>
  <table>
    <caption>Список ресурсных планов</caption>
    <tr>
      <th>id</th>
      <th>Название проекта</th>
      <th>Должность</th>
      <th>Кол-во часов</th>
      <th class="notResizeCol">Изменение</th>
      <th class="notResizeCol">Удаление</th>
    </tr>
    <% ArrayList<Resources_planEntity> listRes = (ArrayList<Resources_planEntity>) request.getAttribute("listRes");
      for (int i=0; i < listRes.size(); i++){%>
      <tr>
        <td><%=listRes.get(i).getId()%></td>
        <td><%=listRes.get(i).getProject().getName()%></td>
        <td><%=listRes.get(i).getPosition().getName()%></td>
        <td><%=listRes.get(i).getHour()%></td>
        <td>
          <a href="/new_updateResources_plan?new=false&id=<%=listRes.get(i).getId()%>">
            <button id="updateButton<%=listRes.get(i).getId()%>" class="updateButton" onmouseover="selectButton('updateButton<%=listRes.get(i).getId()%>')" onmouseout="unselectButton('updateButton<%=listRes.get(i).getId()%>')" >
              <img src="../../image/update.png" width="25px" height="25px">
            </button>
          </a>
        </td>
        <td>
            <button id="deleteButton<%=listRes.get(i).getId()%>" class="deleteButton" onmouseover="selectButton('deleteButton<%=listRes.get(i).getId()%>')" onmouseout="unselectButton('deleteButton<%=listRes.get(i).getId()%>')" onclick="deletePlan(<%=listRes.get(i).getId()%>)">
              <img src="../../image/delete.png" width="25px" height="25px">
            </button>
        </td>
      </tr>
    <%}%>
  </table>
</body>
</html>
