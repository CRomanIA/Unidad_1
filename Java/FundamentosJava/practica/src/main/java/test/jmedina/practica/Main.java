package test.jmedina.practica;

public class Main {

    // La siguiente línea es parte de una clase de java Principal que invoca ejecuciones, para poder ser utilizada.
    // public ==> se refiere a que puede ser llamado desde cualquier otra clase del proyecto
    // private ==> Solo se puede llamar a este método desde otros metodos de la misma clase
    // protected ==> Solo es posible invocar este método desde la misma clase, en este caso nuestro MAIN y quienes heradan de la clase main
    // Si no está descrito o definido en un método el nivel de protección, significa que por defecto asume que puede ser invocado por los objetos del package
    public static void main (String[] args) {

        // Tipos de Variables

        nuevoTema("Variables y Constantes");
        // Final es una palabra reservada de Java que se utiliza para declarar una CONSTANTE
        // short ==> es un tipo entero con un máximo de 32767, es decir un entero corto
        final short enteroCorto = 120;
        // int ==> tipo entero normal
        int entero = 1234546;
        // long ==> Entero largo
        // para el caso del entero largo, se debe agregar al final del valor el caracter 'l' para que lo reconozca
        long enteroLargo;
        // float ==> tipo decimal corto, ejemplo notas de una asignatura
        // para el caso de los float, al final del valor se debe agregar el caracter 'f' para que lo reconozca
        float decimalCorto = 24.45f;
        //double ==> tipo decimal largo, se utiliza generalmente para obtener cálculos más precisos
        double decimalLargo = 23.353534543;
        // char ==> se utiliza para un caracter específico
        char caracter = 'a';
        // boolean ==> para verdadero o falso
        boolean esValido = true;

        enteroLargo = 500l;

        System.out.println(enteroCorto);
        System.out.println(entero);
        System.out.println(enteroLargo);
        System.out.println(decimalCorto);
        System.out.println(decimalLargo);
        System.out.println(caracter);
        System.out.println(esValido);

        // Repaso de Arreglos, como se obtiene cada valor del arreglo en forma directa

        nuevoTema("Arreglos");
        String[] nombres = new String[]{"Roman", "Zuñiga", "Medina"};

        System.out.println();
        System.out.println("Nombres:");
        System.out.println(nombres[0]);
        System.out.println(nombres[1]);
        System.out.println(nombres[2]);


        // Ciclos y condiciones
        /*System.out.println();
        System.out.println("Ciclos y Dondiciones:");*/
        nuevoTema("Ciclos y Dondiciones:");

        //Uso de IF para evaluar condiciones
        if (enteroLargo > 1000){
            System.out.println("Es mayor");
        } else if (enteroLargo == 500){
            System.out.println("Es igual");
        }else {
            System.out.println("No es mayor");
        }

        // Operador terniario
        /*System.out.println();
        System.out.println("Operador Terniario");*/
        nuevoTema("Operador Terniario");
        System.out.println(enteroLargo > 1000? "Es mayor " : "No es mayor");


        // Ciclo FOR y FOREACH
        /*System.out.println();
        System.out.println("Ciclo FOR y FOREACH");*/
        nuevoTema("Ciclo FOR y FOREACH");

        // Recorrer e imprimir Posición de un Arreglo con ciclo FOR
        /*System.out.println("Ciclo FOR para recorrer la posición de un arreglo ");*/
        nuevoTema("Ciclo FOR para recorrer la posición de un arreglo");

        for (int i = 0; i<3; i++){
            System.out.println("Posición: " + i);
        }

        System.out.println();

        // Recorrer e imprimir el arreglo de tipo String definido anteriormente en un ciclo FOREACH
        /*System.out.println("Ciclo FOREACH para recorrer la posición de un arreglo, tipo String");*/
        nuevoTema("Ciclo FOREACH para recorrer la posición de un arreglo, tipo String");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // Estructura SWITCH
        /*System.out.println();
        System.out.println("Estructura SWITCH");*/

        nuevoTema("Estructura SWITCH");

        // En primera instancia Math.random() entrega valores de tipo double, por lo que fué necesario realizar un 'cast' para transformar su resultado a un tipo entero
        // para realizar la conversión cast del resultado del Math.random(), se encierra en paréntesis y antes del parentesis, va el tipo de dato al cual se realizará el cast, que en este caso es '(int)'
        int index = (int)(Math.random() * 5);
        System.out.println("El valor de Index: " + index);

        String nombreAleatorio = index < 2? nombres[index] : "Anonimo";
        switch (nombreAleatorio){
            case "Medina":
                System.out.println("Este si soy yo");
                break;
            case "Roman":
            case "Zuñiga":
                System.out.println("Es: " + nombreAleatorio);
                break;
            default:
                System.out.println("Esta persona no existe en el índice");
        }



    } // Fin MAIN

    // Metodos
    public static void nuevoTema(String title){

        System.out.println("\n=============>" + title + ":");
    }

}
