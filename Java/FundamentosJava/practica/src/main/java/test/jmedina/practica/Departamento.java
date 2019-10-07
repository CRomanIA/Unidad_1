package test.jmedina.practica;

public class Departamento extends Casa {

    // Atributo Diferenciador entre una casa y un departamento
    private short numeroInterno;

    // Encapsulación de ATributos


    public short getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(short numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    // Constructor para Departamento con la "Herencia" de sus atributos y Métodos.
    // Al crear el constructor,  primero consulta por los constructores de la clase padre
    // que en el caso de la clase casa eran 3, luego de seleccionar el que contenía todos
    // los atributos, muestra la selección de los atributos propios de la clase departamento
    // En este nuevo contructor, se utiliza la palabra reservada "SUPER" que corresponde al uso
    // de los atributos de la clase padre
    public Departamento(String calle, char seccion, short numero, int precio,
                        long fechaConstruccion, float impuesto, double metrosCubicos,
                        boolean hipotecada, short numeroInterno) {
        super(calle, seccion, numero, precio, fechaConstruccion, impuesto, metrosCubicos,
                hipotecada);
        this.numeroInterno = numeroInterno;


    }


}
