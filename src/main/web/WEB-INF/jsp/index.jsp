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
  </body>
</html>
