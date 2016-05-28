<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 08.05.2016
  Time: 22:14
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
      <li><a href="/newEmployment">Назначить сотрудника на проект</a></li>
      <li><a href="/findEmployment">Поиск по занятости</a></li>
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
      <li><a href="/newResources_plan">Новый ресурсный план</a></li>
      <li><a href="/findResources_plan">Поиск по ресурсным планам</a></li>
    </ul>
  </div>
  </body>
</html>
