window.onload=()=>{


}

function borrar(idtask){
    var baseUrl = window.location.protocol + "//" + window.location.host + "/tareasweb/api?idtask="+idtask;

    fetch(baseUrl, {
        method: 'GET', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
        headers: {
            'Content-Type': 'application/json', // Puedes ajustar el tipo de contenido según tu necesidad
        },
        // Puedes agregar otros parámetros como body si estás enviando datos
    })
        .then(response => response.json()) // Procesamos la respuesta como JSON
        .then(data => {
            location.reload();
            console.log(data); // Aquí puedes hacer lo que quieras con los datos
        })
        .catch(error => {
            console.error('Error:', error); // Manejamos los errores
        });

}