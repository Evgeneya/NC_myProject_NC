<%@ page import="java.util.ArrayList" %>
<%@ page import="myProject.entities.PositionEntity" %>
<%@ page import="myProject.entities.EmployeeEntity" %>

<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/employee.css">
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
  <form action="/findEmployee">
    <h2>Поиск сотрудников</h2>
    <h3>Критерии поиска:</h3>
    <input name="res" value="true" type="hidden">
    <p>ФИО: <input type="text" size="30px" name="name" value="<%=(request.getAttribute("name")==null)?"":request.getAttribute("name")%>"></p>
    <p>Должность: <select name="position">
                  <option></option>
                  <%ArrayList<PositionEntity> listPos = (ArrayList<PositionEntity>) request.getAttribute("listPos");
                    for (int i = 0; i < listPos.size(); i++) {
                      if ((request.getAttribute("position") != null) && request.getAttribute("position").equals(listPos.get(i).getName())){%>
                        <option selected><%=listPos.get(i).getName()%></option>
                      <%}else%>
                        <option><%=listPos.get(i).getName()%></option>
                    <%}%>
                  </select>
    </p>
    <p>Опыт работы:   от <input type="text" size="3px" name="exp1" value="<%=(request.getAttribute("exp1")==null)?"":request.getAttribute("exp1")%>">  до <input type="text" size="3px" name="exp2" value="<%=(request.getAttribute("exp2")==null)?"":request.getAttribute("exp2")%>"></p>
    <p>Заработная плата:   от <input type="text" size="7px" name="sal1" value="<%=(request.getAttribute("sal1")==null)?"":request.getAttribute("sal1")%>">  до <input type="text" size="7px" name="sal2" value="<%=(request.getAttribute("sal2")==null)?"":request.getAttribute("sal2")%>"></p>
    <button id="findEmpButton" type="submit"><b>Найти</b></button>
  </form>
<c:if test="${res}">
<table id="resultFindTable">
  <caption>Результаты поиска:</caption>
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
    <th class="notResizeCol">Изменение</th>
    <th class="notResizeCol">Удаление</th>
  </tr>
  <c:forEach items="${listEmp}" var="emp">
  <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.position.name}</td>
    <td>${emp.email}</td>
    <td>${emp.phone}</td>
    <td>${emp.age}</td>
    <td>${emp.status}</td>
    <td>${emp.experience}</td>
    <td>${emp.salary}</td>
    <td>
      <a href="/new_updateEmployee?new=false&id=${emp.id}">
        <button id="updateButton${emp.id}" class="updateButton" onmouseover="selectButton('updateButton${emp.id}')" onmouseout="unselectButton('updateButton${emp.id}')" >
          <img src="../../image/update.png" width="25px" height="25px">
        </button>
      </a>
    </td>
    <td>
      <button id="deleteButton${emp.id}" class="deleteButton" onmouseover="selectButton('deleteButton${emp.id}')" onmouseout="unselectButton('deleteButton${emp.id}')" onclick="deleteEmp(${emp.id})">
        <img src="../../image/delete.png" width="25px" height="25px">
      </button>
    </td>
  </tr>
  </c:forEach>
</table>
</c:if>
</body>
</html>
