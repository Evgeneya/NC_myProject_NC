<%@ page import="java.util.ArrayList" %>
<%@ page import="myProject.entities.CustomerEntity" %>

<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/customer.css">
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
    <li><a href="/findPosition?res=false">Поиск по должностям</a></li>
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
<%String res = (String) request.getAttribute("res");%>
<form action="/findCustomer">
  <h2>Поиск заказчика</h2>
  <h3>Критерий поиска:</h3>
  <input name="res" value="true" type="hidden">
  <p>ФИО: <input type="text" size="30px" name="name" value="<%=(request.getAttribute("name")==null)?"":request.getAttribute("name")%>"></p>
  <button id="findCustButton" type="submit"><b>Найти</b></button>
</form>
<%if (res.equals("true")){%>
<table id="resultFindTable">
  <caption>Результат поиска</caption>
  <tr>
    <th>id</th>
    <th>ФИО</th>
    <th>Телефон</th>
    <th class="notResizeCol">Изменение</th>
    <th class="notResizeCol">Удаление</th>
  </tr>
  <% ArrayList<CustomerEntity> listCust = (ArrayList<CustomerEntity>) request.getAttribute("listCust");
    for (int i=0; i < listCust.size(); i++){%>
  <tr>
    <td><%=listCust.get(i).getId()%></td>
    <td><%=listCust.get(i).getName()%></td>
    <td><%=listCust.get(i).getPhone()%></td>
    <td>
      <a href="/new_updateCustomer?new=false&id=<%=listCust.get(i).getId()%>">
        <button id="updateButton<%=listCust.get(i).getId()%>" class="updateButton" onmouseover="selectButton('updateButton<%=listCust.get(i).getId()%>')" onmouseout="unselectButton('updateButton<%=listCust.get(i).getId()%>')" >
          <img src="../../image/update.png" width="25px" height="25px">
        </button>
      </a>
    </td>
    <td>
      <button id="deleteButton<%=listCust.get(i).getId()%>" class="deleteButton" onmouseover="selectButton('deleteButton<%=listCust.get(i).getId()%>')" onmouseout="unselectButton('deleteButton<%=listCust.get(i).getId()%>')" onclick="deleteCust(<%=listCust.get(i).getId()%>)">
        <img src="../../image/delete.png" width="25px" height="25px">
      </button>
    </td>
  </tr>
  <%}%>
</table>
<%}%>
</body>
</html>
