<%@ page import="java.util.ArrayList" %>
<%@ page import="myProject.entities.EmployeeEntity" %>
<%@ page import="myProject.entities.PositionEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2016
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="../css/base.css">
<link rel="stylesheet" type="text/css" href="../css/employee.css">
<script src="../js/js.js"></script>
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
<%ArrayList<EmployeeEntity> listEmp = (ArrayList<EmployeeEntity>) request.getAttribute("listEmp");%>
<form action="/resultUpdateEmployee">
  <input visible="false" name="id" value="<%=listEmp.get(0).getId()%>">
  <h2>Новый сотрудник</h2>
  <div id="divNewEmpText">
    <p>ФИО:</p>
    <p>Должность:</p>
    <p>Опыт работы:</p>
    <p>Заработная плата:</p>
    <p>Email:</p>
    <p>Телефон:</p>
    <p>Возраст:</p>
    <p>Семейное положение:</p>
  </div>
  <div id="divNewEmpData">
    <p><input type="text" size="30px" name="name" value="<%=listEmp.get(0).getName()%>"></p>
    <p><select name="position">
      <%ArrayList<PositionEntity> listPos = (ArrayList<PositionEntity>) request.getAttribute("listPos");
        for (int i = 0; i < listPos.size(); i++) {
          if (listEmp.get(0).getPosition().getId() == listPos.get(i).getId()){%>
              <option selected><%=listPos.get(i).getName()%></option>
          <%}
          else %>
              <option><%=listPos.get(i).getName()%></option>
      <%}%>
    </select>
    </p>
    <p><input type="text" size="3px" name="exp" value="<%=listEmp.get(0).getExperience()%>"></p>
    <p><input type="text" size="7px" name="sal" value="<%=listEmp.get(0).getSalary()%>"></p>
    <%String email[] = listEmp.get(0).getEmail().split("@");%>
    <p><input type="text" size="10px" name="email1" value="<%=email[0]%>">@<select name="email2">
      <%if (email[1].equals("mail.ru")){%>
          <option selected>mail.ru</option>
      <%}
      else%>
          <option>mail.ru</option>
      <%if (email[1].equals("gmail.com")){%>
      <option selected>gmail.com</option>
      <%}
      else%>
      <option>gmail.com</option>
      <%if (email[1].equals("yandex.ru")){%>
      <option selected>yandex.ru</option>
      <%}
      else%>
      <option>yandex.ru</option>
    </select>
    </p>
    <p><input type="text" size="7px" name="phone" value="<%=listEmp.get(0).getPhone()%>"></p>
    <p><select name="age">
      <%for (int i=18; i <=65; i++){%>
        <%if (listEmp.get(0).getAge() == i){%>
            <option selected><%=i%></option>
        <%}
        else%>
            <option><%=i%></option>
      <%}%>
    </select>
    </p>
    <p><select name="status">
      <%if (listEmp.get(0).getStatus().equals("Single")){%>
          <option selected>Single</option>
      <%}
      else%>
          <option>Single</option>
      <%if (listEmp.get(0).getStatus().equals("Married")){%>
          <option selected>Married</option>
      <%}
      else%>
          <option>Married</option>
    </select>
    </p>
  </div>
  <button id="newEmpButton" type="submit"><b>Изменить</b></button>
</form>
</body>
</html>
