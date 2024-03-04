window.onload=()=>{


}

function borrar(idtask){
    var baseUrl = window.location.protocol + "//" + window.location.host + "/tareasweb/api?idtask="+idtask;

    fetch(baseUrl, {
        method: 'GET', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
        headers: {
            'Content-Type': 'application/json', // Puedes ajustar el tipo de contenido según tu necesidad
            //'Content-Type':'text',
        },
        // Puedes agregar otros parámetros como body si estás enviando datos
    })
        .then(response => response.json()) // Procesamos la respuesta como JSON
        .then(data => {
            let tbody="";
            //bucle for recorriendo data -> for of
            for (const task of data) {
                tbody+=`<tr><td>${task.idtask}</td><td>${task.title}</td>
                    <td>${task.description}</td>
                    <td>${task.create_time}</td>
                    <td>${task.deadline}</td>
                            <td>
                                <i class="fa-solid fa-pen-to-square"></i>
                                <i onClick="borrar(${task.idtask})" class="fa-solid fa-trash"></i>
                            </td></tr>`;
            }
            document.getElementById("tableTask").innerHTML=tbody;
            console.log(data); // Aquí puedes hacer lo que quieras con los datos




        })
        .catch(error => {
            console.error('Error:', error); // Manejamos los errores
        });

}