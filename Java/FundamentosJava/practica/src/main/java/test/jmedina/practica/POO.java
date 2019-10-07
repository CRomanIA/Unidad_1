package test.jmedina.practica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POO {
    public static void main(String[] args){
        // Instanciar un objeto a partir de una clase
        Casa miCasa = new Casa("Independencia", 'd', (short)34, 2000000,
                1420070400000l, 3.5f, 320.123165421645,
                false);

        System.out.println(miCasa);


        Casa maryCasa = new Casa("Reforma", (short)543, 3500000, true);
        Casa claudiaCasa = new Casa ("Roma", (short)12, 1200000, false);

        System.out.println(maryCasa);

        Main.nuevoTema("Listas");

        // Uso de listas para el objeto Casa
        List<Casa> casaList = new ArrayList<>();
        casaList.add(miCasa);
        casaList.add(maryCasa);
        casaList.add(claudiaCasa);

        for (Casa currentCasa : casaList){
            System.out.println(currentCasa);
        }

        // Diccionario
        Main.nuevoTema("Diccionarios");

        Map<String, Casa> casaMap = new HashMap<>();

        casaMap.put("alain", miCasa);
        casaMap.put("mary", maryCasa);
        casaMap.put("claudia", claudiaCasa);

        System.out.println(casaMap.get("alain"));


        Main.nuevoTema("Herencia");
        Departamento deptoPlaya = new Departamento ("Malecón", 'B', (short)101,
                2600000, 1325376000000l, 6.3f,
                180.4523165498, true, (short)5);

        System.out.println(deptoPlaya);


        Main.nuevoTema("Polimorfismo");
        venderPropiedad(miCasa);
        venderPropiedad(deptoPlaya);
        Casa deptoCiudad = new Departamento("Principal", 'F', (short)913,
                1950000, 1325376000000L, 4.35f,
                145.654, false, (short)02);
        venderPropiedad(deptoCiudad);

        // Aunque los Objetos Casa y Departamento son diferentes, Casa es padre de Departamento
        // por lo que se produce el polimorfismo al realizar una "VENTA" de Propiedad
        // ya sea por el contexto CASA o DEPARTAMENTO, ya que utilizan las mismas variables, y
        // en este caso, el criterio para saber si está en venta o no es el atributo HIPOTECADO

        Casa casaNueva = new Casa();

        casaNueva.setCalle("Cortes");
        casaNueva.setHipotecada(true);
        casaNueva.setImpuesto(2.1f);

        venderPropiedad(casaNueva);

        Main.nuevoTema("Equals & HashCode");
        Casa miCasa2 = new Casa("Independencia", 'd', (short)34, 2000000,
                1420070400000l, 3.5f, 320.123165421645,
                false);
        System.out.println(miCasa.equals(miCasa2));


        Casa miCasa3 = new Casa();
        System.out.println(casaMap.containsValue(miCasa3));





    }//Cierre Main

    private static void venderPropiedad(Casa casa) {
        if (casa.isHipotecada()){
            System.out.println("Imposible vender!");
        } else{
            System.out.println("En venta.");
        }
    }


}// Cierre Clase
