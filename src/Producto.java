public class Producto {
    private String idProducto; // se crean los items con la clase private, String por lo que es cadena de caracteres
    private String nombrePlanta;
    private String especie;
    private double precio; // Double por lo que es numeros con decimales
    private int cantidadDisponible; // int por que serian enteros

    // se crea un constructor para inicializar los valores de los atributos en este caso todo lo de producto

    // Constructor
    public Producto(String idProducto, String nombrePlanta, String especie, double precio, int cantidadDisponible) {
        this.idProducto = idProducto;
        this.nombrePlanta = nombrePlanta;
        this.especie = especie;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    // colocamos un getter y setters para poder modificar los valores y verificar que sean correctos ej: un valor negativo
    // Getters y Setters
                                        //para producto
    public String getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
                                //para plantas
    public String getNombrePlanta() {
        return nombrePlanta;
    }
    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }
                                //para especie
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
                                //para el precio
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
                            //para cantidad disponible
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override   // se utiliza para sobreescribir
    public String toString() {
        return idProducto + ", " + nombrePlanta + ", " + especie + ", " + precio + ", " + cantidadDisponible;
    }
}
