package test.jmedina.prueba1_jmedina;

public class Producto {
    private String producto;
    private String codigo;
    private String descripcion;
    private String ubicacion;
    private String fechaCompra;
    private int stock;
    private float costo;
    private float venta;


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getVenta() {
        return venta;
    }

    public void setVenta(float venta) {
        this.venta = venta;
    }

    public Producto() {
    }

    public Producto(String producto, String codigo, String descripcion, String ubicacion, String fechaCompra, int stock, float costo, float venta) {
        this.producto = producto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fechaCompra = fechaCompra;
        this.stock = stock;
        this.costo = costo;
        this.venta = venta;
    }
}
