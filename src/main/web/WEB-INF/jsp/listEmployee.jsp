<%@ page import="java.util.ArrayList" %>
<%@ page import="myProject.entities.EmployeeEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="../../css/base.css">
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
<div id="submenu_1" style="display:none;" onmouseout="hideMenu('1')">
  <ul>
    <li><a href="/listEmployee">Список cотрудников</a></li>
    <li><a href="/newEmployee">Новый сотрудник</a></li>
    <li><a href="/findEmployee">Поиск сотрудников</a></li>
  </ul>
</div>
<div id="submenu_2" style="display:none;" onmouseout="hideMenu('2')">
  <ul>
    <li>Список должностей</li>
    <li>Новая должность</li>
    <li>Поиск по должностям</li>
  </ul>
</div>
<div id="submenu_3" style="display:none;" onmouseout="hideMenu('3')">
  <ul>
    <li>Список проектов</li>
    <li>Новый проект</li>
    <li>Поиск по проектам</li>
  </ul>
</div>
<div id="submenu_4" style="display:none;" onmouseout="hideMenu('4')">
  <ul>
    <li>Список</li>
    <li>Новый </li>
    <li>Поиск </li>
  </ul>
</div>
<div id="submenu_5" style="display:none;" onmouseout="hideMenu('5')">
  <ul>
    <li>Список заказчиков</li>
    <li>Новый заказчик</li>
    <li>Поиск заказчиков</li>
  </ul>
</div>
<div id="submenu_6" style="display:none;" onmouseout="hideMenu('6')">
  <ul>
    <li>Список ресурсных планов</li>
    <li>Новый ресурсный план</li>
    <li>Поиск по ресурсным планам</li>
  </ul>
</div>
  <table>
    <caption>Список сотрудников компании</caption>
    <tr>
      <th>id</th>
      <th>ФИО</th>
      <th>Должность</th>
      <th>Email</th>
      <th>Телефон</th>
      <th>Возраст</th>
      <th>Семейное положение</th>
      <th>Опыт работы</th>
      <th>Заработная плата</th>
      <th>Изменение</th>
      <th>Удаление</th>
    </tr>
    <% ArrayList<EmployeeEntity> listEmp = (ArrayList<EmployeeEntity>) request.getAttribute("listEmp");
      for (int i=0; i < listEmp.size(); i++){%>
      <tr>
        <td><%=listEmp.get(i).getId()%></td>
        <td><%=listEmp.get(i).getName()%></td>
        <td><%=listEmp.get(i).getPosition().getName()%></td>
        <td><%=listEmp.get(i).getEmail()%></td>
        <td><%=listEmp.get(i).getPhone()%></td>
        <td><%=listEmp.get(i).getAge()%></td>
        <td><%=listEmp.get(i).getStatus()%></td>
        <td><%=listEmp.get(i).getExperience()%></td>
        <td><%=listEmp.get(i).getSalary()%></td>
        <td>
          <a href="/updateEmployee&id=<%=listEmp.get(i).getId()%>">
            <button id="updateButton<%=listEmp.get(i).getId()%>" class="updateButton" onmouseover="selectButton('updateButton<%=listEmp.get(i).getId()%>')" onmouseout="unselectButton('updateButton<%=listEmp.get(i).getId()%>')">
              <img src="../../image/update.png" width="25px" height="25px">
            </button>
          </a>
        </td>
        <td>
          <a href="/deleteEmployee&id=<%=listEmp.get(i).getId()%>">
            <button id="deleteButton<%=listEmp.get(i).getId()%>" class="deleteButton" onmouseover="selectButton('deleteButton<%=listEmp.get(i).getId()%>')" onmouseout="unselectButton('deleteButton<%=listEmp.get(i).getId()%>')">
              <img src="../../image/delete.png" width="25px" height="25px">
            </button>
          </a>
        </td>
      </tr>
    <%}%>
  </table>
</body>
</html>
