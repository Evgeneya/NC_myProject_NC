<%@ page import="java.util.ArrayList" %>
<%@ page import="myProject.entities.ProjectEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/project.css">
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
    <li><a href="/new_updateEmployee?new=true&res=false">Новый сотрудник</a></li>
    <li><a href="/findEmployee?res=false">Поиск сотрудников</a></li>
  </ul>
</div>
<div id="submenu_2" style="display:none;" onmouseout="hideMenu('2')">
  <ul>
    <li><a href="/listPosition">Список должностей</a></li>
    <li><a href="/new_updatePosition?new=true&res=false">Новая должность</a></li>
    <li><a href="/findPosition?res=false">Поиск по должностям</a></li>
  </ul>
</div>
<div id="submenu_3" style="display:none;" onmouseout="hideMenu('3')">
  <ul>
    <li><a href="/listProject">Список проектов</a></li>
    <li><a href="/new_updateProject?new=true&res=false">Новый проект</a></li>
    <li><a href="/findProject?res=false">Поиск по проектам</a></li>
  </ul>
</div>
<div id="submenu_4" style="display:none;" onmouseout="hideMenu('4')">
  <ul>
    <li><a href="/listEmployment">Полный список</a></li>
    <li><a href="/new_updateEmployment?new=true&res=false">Назначить сотрудника на проект</a></li>
    <li><a href="/findEmployment?res=false">Поиск по занятости</a></li>
  </ul>
</div>
<div id="submenu_5" style="display:none;" onmouseout="hideMenu('5')">
  <ul>
    <li><a href="/listCustomer">Список заказчиков</a></li>
    <li><a href="/new_updateCustomer?new=true&res=false">Новый заказчик</a></li>
    <li><a href="/findCustomer?res=false">Поиск заказчиков</a></li>
  </ul>
</div>
<div id="submenu_6" style="display:none;" onmouseout="hideMenu('6')">
  <ul>
    <li><a href="/listResources_plan">Список ресурсных планов</a></li>
    <li><a href="/new_updateResources_plan?new=true&res=false">Новый ресурсный план</a></li>
    <li><a href="/findResources_plan?res=false">Поиск по ресурсным планам</a></li>
  </ul>
</div>
  <table>
    <caption>Список проектов</caption>
    <tr>
      <th>id</th>
      <th>Название</th>
      <th>Заказчик</th>
      <th>Дата начала</th>
      <th>Дата окончания</th>
      <th class="notResizeCol">Изменение</th>
      <th class="notResizeCol">Удаление</th>
      <th class="notResizeCol">Автоподбор</th>
    </tr>
    <% ArrayList<ProjectEntity> listPro = (ArrayList<ProjectEntity>) request.getAttribute("listPro");
      for (int i=0; i < listPro.size(); i++){%>
      <tr>
        <td><%=listPro.get(i).getId()%></td>
        <td><%=listPro.get(i).getName()%></td>
        <td><%=listPro.get(i).getCustomer().getName()%></td>
        <td><%=listPro.get(i).getBeg_date()%></td>
        <td><%=listPro.get(i).getEnd_date()%></td>
        <td>
          <a href="/new_updateProject?new=false&id=<%=listPro.get(i).getId()%>">
            <button id="updateButton<%=listPro.get(i).getId()%>" class="updateButton" onmouseover="selectButton('updateButton<%=listPro.get(i).getId()%>')" onmouseout="unselectButton('updateButton<%=listPro.get(i).getId()%>')" >
              <img src="../../image/update.png" width="25px" height="25px">
            </button>
          </a>
        </td>
        <td>
            <button id="deleteButton<%=listPro.get(i).getId()%>" class="deleteButton" onmouseover="selectButton('deleteButton<%=listPro.get(i).getId()%>')" onmouseout="unselectButton('deleteButton<%=listPro.get(i).getId()%>')" onclick="deletePro(<%=listPro.get(i).getId()%>)">
              <img src="../../image/delete.png" width="25px" height="25px">
            </button>
        </td>
        <td>
          <a href="/autoProject?id=<%=listPro.get(i).getId()%>">
            <button id="autoButton<%=listPro.get(i).getId()%>" class="autoButton" onmouseover="selectButton('autoButton<%=listPro.get(i).getId()%>')" onmouseout="unselectButton('autoButton<%=listPro.get(i).getId()%>')" >
              <img src="../../image/auto.png" width="25px" height="25px">
            </button>
          </a>
        </td>
      </tr>
    <%}%>
  </table>
</body>
</html>
