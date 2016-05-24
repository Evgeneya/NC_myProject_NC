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
        button.style.borderColor = 'red';
    }
}
function unselectButton(id){
    var button = document.getElementById(id);
    button.style.borderColor = 'white';
}
