# App-Web-O.-Servicios
<?php
header("Content-Type","application/json");
$httpMethod = $_SERVER["REQUEST_METHOD"];
switch($httpMethod){
    case "GET":
        //do something
        if($_GET["accion"]=="personal"){
            try{
                $conexion = new PDO("mysql:host=localhost;dbname=utez","root","");
                //echo json_encode($personal);
            }catch(PDOException $e){
                echo $e->getMessage();
            }
            if(isset($_GET['id'])){
                $pstm = $conexion->prepare("SELECT * FROM personal WHERE id = :n");
                $pstm->bindParam(':n',$_GET['id']);
                $pstm->execute();
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
                if ($rs != null) {
                    echo json_encode($rs[0], JSON_PRETTY_PRINT);
                } else {
                    echo "No se encontraron coincidencias";
                }
            } else {
                $pstm = $conexion->prepare('SELECT p.*,po.puesto,po.descripcion 
                FROM personal p INNER JOIN puesto po ON p.puesto = po.id');
                $pstm->execute();
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
                echo json_encode($rs, JSON_PRETTY_PRINT);
            }
            
        }

        if($_GET["accion"]=="puesto"){
            try{
                $client = new PDO("mysql:host=localhost;dbname=utez","root","");
                //echo json_encode($personal);
            }catch(PDOException $e){
                echo $e->getMessage();
            }
            $pstm = $client->prepare('SELECT * FROM puesto');
            $pstm->execute();
            $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
            echo json_encode($rs, JSON_PRETTY_PRINT);
        }
        break;
    case "POST":
        //do something
        if($_GET['accion']=='personal'){
            $jsonData = json_decode(file_get_contents("php://input"));
            try{
                $conn = new PDO("mysql:host=localhost;dbname=utez","root","");
            }catch(PDOException $e){
                echo $e->getMessage();
            }

            $query = $conn->prepare('INSERT INTO personal(nombre,apellidoP,apellidoM,sueldo,puesto,fechaNac)
            VALUES (:nombre,:apellidoP,:apellidoM,:sueldo,:puesto,:fechaNac)');
            $query->bindParam(":nombre",$jsonData->nombre);
            $query->bindParam(":apellidoP",$jsonData->apellidoP);
            $query->bindParam(":apellidoM",$jsonData->apellidoM);
            $query->bindParam(":sueldo",$jsonData->sueldo);
            $query->bindParam(":puesto",$jsonData->puesto);
            $query->bindParam(":fechaNac",$jsonData->fechaNac);
            $result = $query -> execute();
            if($result){
                $_POST["error"] = false;
                $_POST["message"] = "Personal registrado correctamente.";
                $_POST["status"] = 200;
            }else{
                $_POST["error"] = true;
                $_POST["message"] = "Error al registrar";
                $_POST["status"] = 400;
            }
        }
        break;
    case "PUT":
        //do something
        if($_GET['accion']=='personal'){
            $jsonData = json_decode(file_get_contents("php://input"));
            try{
                $conn = new PDO("mysql:host=localhost;dbname=utez","root","");
            }catch(PDOException $e){
                echo $e->getMessage();
            }
            $query = $con -> prepare('UPDATE personal SET nombre = :b, apellidoP = :c, apellidoM = :d, sueldo = :e,
            puesto = :f, fechaNac = :g WHERE id = :a');
            $query->bindParam(":a", $id, PDO::PARAM_INT);
            $query->bindParam(":b", $nombre, PDO::PARAM_STR);
            $query->bindParam(":c", $apellidoP, PDO::PARAM_STR);
            $query->bindParam(":d", $apellidoM, PDO::PARAM_STR);
            $query->bindParam(":e", $sueldo, PDO::PARAM_INT);
            $query->bindParam(":f", $puesto, PDO::PARAM_INT);
            $query->bindParam(":g", $fechaNac, PDO::PARAM_STR);
            $result -> $query -> execute();
            if($result){
                echo "Personal registrado correctamente",$result;
            }else{
                echo "Error al registrar. Code $result";
            }
        }
        break;
    case "DELETE":
        //do something
        if($_GET['accion']=='personal'){
            $id = $_GET['id'];
            try{
                $conn = new PDO("mysql:host=localhost;dbname=utez","root","");
            }catch(PDOException $e){
                echo $e->getMessage();
            }
            $query = "DELETE FROM personal WHERE id=:id";
            $pstm = $conn -> prepare($query);
            $pstm->bindParam(":id", $id);
            $rs = $pstm->execute();
            if($rs){
                echo "Personal eliminado correctamente";
            }else{
                echo "ERROR al eliminar a este persona. Code $rs";
            }
        }
        break;
    default:
        //do something
        break
        
        ;
        
        //---------------------
        
        <script>
        const URL = `http://localhost/practica/`
        const getPersonal = () => {
            document.getElementById('registerPerson').classList.remove("was-validated");
            return fetch(URL+'personal').then((response)=> response.json())
            .then((data)=>{
                const tbody = document.getElementById("content");
                let content = ``;
                data.map((person, index)=>{
                    content += `
                    <tr>
                        <td>${index +1}</td>
                        <td>${person.nombre + " "+ person.apellidoP + " "+ 
                        (person.apellidoM ? person.apellidoM : " ")}</td>
                        <td>${person.fechaNac}</td>
                        <td>${person.sueldo}</td>
                        <td>${person.puesto}</td>
                        <td></td>
                    </tr>
                    `;
                })//for
                tbody.innerHTML = content;
            })
            .catch((error)=>{
                console.log(error);
            })
        }
        window.addEventListener("DOMContentLoaded",()=>{
            getPersonal();
        });
        const getPosition = async () =>{
                try {
                const response =  await fetch(`${URL}puesto`);
                    const data = await response.json();
                    const select = document.getElementById("puesto");
                    let content = `<option value="" selected>Seleccionar...</option>`
                    data.map((puesto)=>{
                        content += `<option value="${puesto.id}">
                            ${puesto.descripcion}</option>`
                    })
                    select.innerHTML = content;
                } catch (error) {
                    console.log(error);
                }
            }
        const registerPerson = async (event,form) =>{
            event.preventDefault();
            event.stopPropagation();
            form.classList.add('was-validated');
            if(!form.checkValidity()){
                alert("Llena todos los campos obligatotios.");
                return;
            }
            try {
                const nombre = document.getElementById("nombre").value;
                const apellidoP = document.getElementById("apellidoP").value;
                const apellidoM = document.getElementById("apellidoM").value;
                const fechaNac = document.getElementById("fechaNac").value;
                const sueldo = document.getElementById("sueldo").value;
                const puesto = document.getElementById("puesto").value;
                const person = {
                    nombre,
                    apellidoP,
                    apellidoM,
                    fechaNac,
                    sueldo,
                    puesto,
                };
                const response = await fetch(`${URL}personal`,{method: 'POST', body: JSON.stringify(person)});
                const data = await response.json();
                alert(data.message);
                const modal = bootstrap.Modal.getInstance(
                    document.getElementById('registerPerson')
                );
                modal.hide();
                form.reset();
                getPersonal();
            } catch (error) {
                console.log(error);
            }
        }
    </script>
    ///---------------------------------
    
    RewriteEngine On
RewriteRule ^([a-zA-Z_-]*)$ index.php?accion=$1
RewriteRule ^([a-zA-Z_-]*)/([0-9]+) index.php?accion=$1&id=$2 [L,QSA]
}
?>
