/**
 * Created by 1 on 08.05.2016.
 */
function showMenu(id)
{
    var sub_menu = document.getElementById('submenu_' + id).style;
        sub_menu.display = 'block';
}

function hideMenu(id){
    var sub_menu = document.getElementById('submenu_' + id).style;
    var px=window.event.pageX;
    var py=window.event.pageY;
    if ((px >= 200 && px <=405) && (py >= (80+(id-1)*37) && py <= (80+(id-1)*37)+105))
        return;
    else sub_menu.display = 'none';
}

function selectButton(id){
    var button = document.getElementById(id);
    if (id.toString().substr(0, 12)== "updateButton"){
        button.style.borderColor = 'greenyellow';
    }
    else{
        if (id.toString().substr(0, 12)== "deleteButton"){
            button.style.borderColor = 'red';
        }
        else
            button.style.borderColor = 'green';
    }
}
function unselectButton(id){
    var button = document.getElementById(id);
    button.style.borderColor = 'white';
}

function deleteEmp(id){
    var x=confirm("Все записи в таблице занятости с этим сотрудником будут также удалены.\nВы действительно хотите удалить сотрудника?");
    if (x==true){
        document.location.href = "/resultEmployee?del=true&id=" + id;
    }
    else return;
}
function deletePos(id){
    var x=confirm("Все сотрудники, занимающие эту должность будут также удалены.\nВы действительно хотите удалить должность?");
    if (x==true){
        document.location.href = "/resultPosition?del=true&id=" + id;
    }
    else return;
}
function deleteCust(id){
    var x=confirm("Все проекты данного заказчика будут также удалены.\nВы действительно хотите удалить заказчика?");
    if (x==true){
        document.location.href = "/resultCustomer?del=true&id=" + id;
    }
    else return;

}
function deletePro (id) {
    var x=confirm("Вы действительно хотите удалить проект?");
    if (x==true){
        document.location.href = "/resultProject?del=true&id=" + id;
    }
    else return;
}

function deleteEmpl(id) {
    var x=confirm("Вы действительно хотите удалить запись о занятости?");
    if (x==true){
        document.location.href = "/resultEmployment?del=true&id=" + id;
    }
    else return;
}

function deletePlan(id) {
    var x=confirm("Вы действительно хотите удалить запись ресурсного плана?");
    if (x==true){
        document.location.href = "/resultResources_plan?del=true&id=" + id;
    }
    else return;
}
