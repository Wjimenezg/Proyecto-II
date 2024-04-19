package matrizortogonal;
  
public class Nodo {
    Vehiculo vehiculo; // vehiculo que se almacenara en el nodo
    Nodo apuntadorArriba; // nodo de arriba
    Nodo apuntadorAbajo; // nodo de abajo
    Nodo apuntadorIzquierda; // nodo de la izquierda
    Nodo apuntadorDerecha; // nodo de la derecha
    
    public Nodo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo; // ingresa el vehiculo al nodo
        //iniciara todos los apuntadores como nulo
        this.apuntadorArriba = null;
        this.apuntadorAbajo = null; 
        this.apuntadorIzquierda = null;
        this.apuntadorDerecha = null;
    }
}
