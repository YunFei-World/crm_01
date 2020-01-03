function getCampus (staff_id) {
    return new Promise(function (resolve, reject) {
        var xml = new XMLHttpRequest();
        xml.onreadystatechange = function () {
            if (xml.readyState==4 && xml.status==200){
                resolve(xml.responseText)
            }else{
                reject();
            }
        }
        xml.open("GET","staff/findAllCampusById?staff_id="+staff_id,false);
        xml.send(null);
    })
}
export {getCampus};