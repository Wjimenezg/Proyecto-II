package matrizortogonal;

/*Requisitos necesarios para ejecutar el proyecto
1) Java Development Kit (JDK)
2) Conocimientos Básicos de Java
3) Consola de Comandos o Terminal
4) Sistema Operativo Compatible, minimo Windows 7, Mac 10.10, Linux reciente
5) minimo 512MB de memoria RAM
6) minimo Procesador Core i3
7) minimo 500MB de espacio en el disco duro
*/

public class MatrizDinamica {
    Nodo inicio; // primer nodo de la matriz dinamica
    
    public MatrizDinamica() {
        inicio=null; // inicializacion del primer nodo como nulo
}
    
    public void insertarVehiculo(Vehiculo vehiculo, int fila, int columna){
        Nodo nuevoNodo=new Nodo(vehiculo); // creacion de nodo con el vehiculo ingresado
        if(inicio==null){ // si el primer nodo es null
            inicio=nuevoNodo; //el nuevo nodo se convierte en el inicio
            return;
        }
        Nodo filaActual = inicio; //nodo de la fila actual
        Nodo columnaActual = inicio; // nodo de la columna actual
        
        for (int contador = 0; contador < fila; contador++) { // recorrera las filas
        if (filaActual.apuntadorAbajo == null) {
            filaActual.apuntadorAbajo = new Nodo(null); // creara un nuevo nodo si no existe uno en la fila siguiente
        }
        filaActual = filaActual.apuntadorAbajo;
    }
        for (int contador = 0; contador < columna; contador++) { // recorrera las columnas
        if (columnaActual.apuntadorDerecha == null) {
            columnaActual.apuntadorDerecha = new Nodo(null); // creara un nuevo nodo si no existe uno en la columna siguiente
        }
        columnaActual = columnaActual.apuntadorDerecha;
    }
        
        // agregfara el nuevo nodo en la posición deseada
        nuevoNodo.apuntadorIzquierda = columnaActual.apuntadorIzquierda;
        nuevoNodo.apuntadorDerecha = columnaActual;
        nuevoNodo.apuntadorArriba = filaActual.apuntadorArriba;
        nuevoNodo.apuntadorAbajo = filaActual;
        
        // actualizara los enlaces de los nodos vecinos
    if (columnaActual.apuntadorIzquierda != null) {
        columnaActual.apuntadorIzquierda.apuntadorDerecha = nuevoNodo;
    }
    if (filaActual.apuntadorArriba != null) {
        filaActual.apuntadorArriba.apuntadorAbajo = nuevoNodo;
    }
    if (columnaActual.apuntadorAbajo != null) {
        columnaActual.apuntadorAbajo.apuntadorArriba = nuevoNodo;
    }
    if (filaActual.apuntadorDerecha != null) {
        filaActual.apuntadorDerecha.apuntadorIzquierda = nuevoNodo;
    }
    }
    
    // metodo para buscar un vehiculo por placa
public Vehiculo buscarVehiculoPorPlaca(String placa) {
    Nodo nodoActual = inicio;
    while (nodoActual != null) { //recorrera la matriz mientras el nodo actual este vacio o null
        Nodo nodoColumna = nodoActual; 
        while (nodoColumna != null) { // mientas el nodo columna no este vacio
            if (nodoColumna.vehiculo != null && nodoColumna.vehiculo.placa.equalsIgnoreCase(placa)) { //verifica si el vehiculo en este nodo tiene la placa ingresada
                return nodoColumna.vehiculo; // Se encontró el vehiculo con la placa ingresada
            }
            nodoColumna = nodoColumna.apuntadorDerecha; // se mueve a la siguiente columna
        }
        nodoActual = nodoActual.apuntadorAbajo; // Moverse a la siguiente fila
    }
    return null; // No se encontro ningun vehiculo con la placa deseada
}

// metodo para buscar un vehiculo por propietario
public Vehiculo buscarVehiculoPorPropietario(String propietario) {
    Nodo nodoActual = inicio;
    while (nodoActual != null) { // mientras el nodoa ctual tenga datos
        Nodo nodoColumna = nodoActual;
        while (nodoColumna != null) { //mientras el nodo de la columna tenga datos
            if (nodoColumna.vehiculo != null && nodoColumna.vehiculo.propietario.equalsIgnoreCase(propietario)) { // verificara si el vehiculo en este nodo tiene el propietario ingresado
            return nodoColumna.vehiculo; // Se encontró el vehiculo con el propietario ingresado
            }
            nodoColumna = nodoColumna.apuntadorDerecha; // se movera a la siguiente columna
        }
        nodoActual = nodoActual.apuntadorAbajo; // se movera a la siguiente fila
    }
    return null; // No se encontró ningún vehículo con el propietario deseado
}

// metodo para eliminar un vehiculo por placa
public void eliminarVehiculoPorPlaca(String placa) {
    Nodo nodoActual = inicio;

    while (nodoActual != null) { //mientras el nodo de la columna tenga datos
        Nodo nodoColumna = nodoActual;
        while (nodoColumna != null) { // mientras el nodo de la columna tenga datos            
            if (nodoColumna.vehiculo != null && nodoColumna.vehiculo.placa.equalsIgnoreCase(placa)) { // Verificara si el vehiculo en este nodo tiene la placa ingresada
                nodoColumna.vehiculo = null; // eliminara el vehiculo estableciendo el nodo asociado a null o sin datos
                return; // Se elimino el vehiculo con la placa ingresada
            }
            nodoColumna = nodoColumna.apuntadorDerecha; // se movera a la siguiente columna
        }
        nodoActual = nodoActual.apuntadorAbajo; // se movera a la siguiente fila
    }
}

// metodo para eliminar un vehiculo por propietario
public void eliminarVehiculoPorPropietario(String propietario) {
    Nodo nodoActual = inicio;
    while (nodoActual != null) { //mientras el nodo de la columna tenga datos
        Nodo nodoColumna = nodoActual;
        while (nodoColumna != null) { // mientras el nodo de la columna tenga datos            
            if (nodoColumna.vehiculo != null && nodoColumna.vehiculo.propietario.equalsIgnoreCase(propietario)) { // verificara si el vehiculo en este nodo tiene el propietario ingresado
                nodoColumna.vehiculo = null; // eliminara el vehiculo estableciendo el nodo asociado a null o sin datos
                return; // Se elimino el vehiculo con el propietario ingresado
            }
            nodoColumna = nodoColumna.apuntadorDerecha; // se movera a la siguiente columna
        }
        nodoActual = nodoActual.apuntadorAbajo; // se movera a la siguiente fila
    }
}
}
