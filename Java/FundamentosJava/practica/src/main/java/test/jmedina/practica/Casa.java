package test.jmedina.practica;

public class Casa {

    // Definición de Atributos de la clase CASA
    private String calle;
    private char seccion;
    private short numero;
    private int precio;
    private long fechaConstruccion;
    private float impuesto;
    private double metrosCubicos;
    private boolean hipotecada;


    // Sección para encapsulación de atributos


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public long getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(long fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public double getMetrosCubicos() {
        return metrosCubicos;
    }

    public void setMetrosCubicos(double metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    // Constructores (Presionar ALT + INSERT) antes de la última llave de la clase para generar
    // el constructor con tódos o algunos de los métodos
    //Constructor de objeto CASA
    public Casa(String calle, char seccion, short numero, int precio, long fechaConstruccion,
                float impuesto, double metrosCubicos, boolean hipotecada) {
        this.calle = calle;
        this.seccion = seccion;
        this.numero = numero;
        this.precio = precio;
        this.fechaConstruccion = fechaConstruccion;
        this.impuesto = impuesto;
        this.metrosCubicos = metrosCubicos;
        this.hipotecada = hipotecada;
    }
    //Constructor vacío de objeto casa
    public Casa() {
    }

    //COnstructor de Casa con algunos parametros
    public Casa(String calle, short numero, int precio, boolean hipotecada) {
        this.calle = calle;
        this.numero = numero;
        this.precio = precio;
        this.hipotecada = hipotecada;
    }


    // Al generar varios tipos de constructores de CASA, se produce lo comunmente conocido como
    // la sobrecarga de métodos

    //Este método a continuación es para realizar impresión del objeto, (ALT + INSERT) en la
    //opción ToString()

    @Override
    public String toString() {
        return "Casa{" +
                "calle='" + calle + '\'' +
                ", seccion=" + seccion +
                ", numero=" + numero +
                ", precio=" + precio +
                ", fechaConstruccion=" + fechaConstruccion +
                ", impuesto=" + impuesto +
                ", metrosCubicos=" + metrosCubicos +
                ", hipotecada=" + hipotecada +
                '}';
    }

    // Sección donde se implementa Equals y Hashcode (ALT + INSERT)
    // Sirve para identificar la igualdad entre 2 objetos
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casa casa = (Casa) o;

        if (seccion != casa.seccion) return false;
        if (numero != casa.numero) return false;
        if (precio != casa.precio) return false;
        if (fechaConstruccion != casa.fechaConstruccion) return false;
        if (Float.compare(casa.impuesto, impuesto) != 0) return false;
        if (Double.compare(casa.metrosCubicos, metrosCubicos) != 0) return false;
        if (hipotecada != casa.hipotecada) return false;
        return calle != null ? calle.equals(casa.calle) : casa.calle == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = calle != null ? calle.hashCode() : 0;
        result = 31 * result + (int) seccion;
        result = 31 * result + (int) numero;
        result = 31 * result + precio;
        result = 31 * result + (int) (fechaConstruccion ^ (fechaConstruccion >>> 32));
        result = 31 * result + (impuesto != +0.0f ? Float.floatToIntBits(impuesto) : 0);
        temp = Double.doubleToLongBits(metrosCubicos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (hipotecada ? 1 : 0);
        return result;
    }
} // Cierre Class
