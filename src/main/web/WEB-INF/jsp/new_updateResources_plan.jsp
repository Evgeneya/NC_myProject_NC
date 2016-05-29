<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="myProject.entities.*" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/resources_plan.css">
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
<%if (request.getAttribute("new").equals("true")){
String res = (String) request.getAttribute("res");%>
<form action="/new_updateResources_plan">
  <h2>Новый ресурсный план</h2>
  <input name="new" value="true" type="hidden">
  <input name="res" value="true" type="hidden">
  <div class="divNewPlanText">
    <p>Проект:</p>
    <p>Должность:</p>
    <p>Кол-во часов</p>
  </div>
  <div class="divNewPlanData">
    <p>
      <select name="project">
        <%List<ProjectEntity> listPro = (List<ProjectEntity>) request.getAttribute("listPro");
          for (int i = 0; i < listPro.size(); i++) {%>
        <option><%=listPro.get(i).getName()%></option>
        <%}%>
      </select>
    </p>
    <p>
      <select name="position">
        <%List<PositionEntity> listPos = (List<PositionEntity>) request.getAttribute("listPos");
          for (int i = 0; i < listPos.size(); i++) {%>
            <option><%=listPos.get(i).getName()%></option>
        <%}%>
      </select>
    </p>
    <p>
      <select name="hour">
        <%for (int i = 1; i <= 100; i++){%>
            <option><%=i%></option>
        <%}%>
      </select>
    </p>
  </div>
  <button class="newPlanButton" type="submit"><b>Добавить</b></button>
</form>
<%if (res.equals("true")){%>
<table id="resultNewTable">
  <caption>Новый ресурсный план успешно добавлен</caption>
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
<%}%>
<%}
else {%>
<%ArrayList<Resources_planEntity> listRes = (ArrayList<Resources_planEntity>) request.getAttribute("listRes");%>
<form action="/resultResources_plan">
  <h2>Изменить сведения в ресурсном плане</h2>
  <input name="del" value="false" type="hidden">
  <input name="id" value="<%=listRes.get(0).getId()%>" type="hidden">
  <div class="divNewPlanText">
    <p>Проект:</p>
    <p>Должность:</p>
    <p>Кол-во часов</p>
  </div>
  <div class="divNewPlanData">
    <p>
      <select name="project">
        <%List<ProjectEntity> listPro = (List<ProjectEntity>) request.getAttribute("listPro");
          for (int i = 0; i < listPro.size(); i++) {
            if ((request.getAttribute("project") != null) && request.getAttribute("project").equals(listPro.get(i).getName())){%>
              <option selected><%=listPro.get(i).getName()%></option>
            <%}else {%>
              <option><%=listPro.get(i).getName()%></option>
            <%}
          }%>
      </select>
    </p>
    <p>
      <select name="position">
        <%List<PositionEntity> listPos = (List<PositionEntity>) request.getAttribute("listPos");
          for (int i = 0; i < listPos.size(); i++) {
            if ((request.getAttribute("position") != null) && request.getAttribute("position").equals(listPos.get(i).getName())){%>
              <option selected><%=listPos.get(i).getName()%></option>
            <%}else {%>
              <option><%=listPos.get(i).getName()%></option>
            <%}
          }%>
      </select>
    </p>
    <p>
      <select name="hour">
        <%for (int i = 1; i <= 100; i++){
          if (request.getAttribute("hour")!=null && request.getAttribute("hour") != "" && Integer.parseInt((String) request.getAttribute("hour"))==i){%>
        <option selected><%=i%></option>
        <%} else{%>
        <option><%=i%></option>
        <%}
        }%>
      </select>
    </p>
  </div>
  <button class="newPlanButton" type="submit"><b>Изменить</b></button>
</form>
<%}%>
</body>
</html>
