//importamos las clases de java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();  // declara el atributo productos que s una lista de la clase Producto
    private final String archivoInventario = "Vivero.txt"; //declaro Archivo inventario

    // Cargar productos desde archivo
    public void cargarProductos() {  //declaramos el metodo cargar productos y carga desde el archivo
        try (BufferedReader leer = new BufferedReader(new FileReader(archivoInventario))) { // con el try manejamos excepciones el buffer leer me lee el archivo
            String linea; // almacena cada linea del archivo
            while ((linea = leer.readLine()) != null) { //lee el archivo con bucle y al final sale con null
                String[] datos = linea.split(", "); // aseguramos que el formato del archivo sea separado por comas y espacio
                Producto producto = new Producto(
                        datos[0], //ID
                        datos[1], // Nombre
                        datos[2], // Categoria
                        Double.parseDouble(datos[3]), // Precio y se cambia a dooble
                        Integer.parseInt(datos[4])); // Cantidad y se cambia a Int
                productos.add(producto); //Agrega producto
            }
        } catch (IOException e) { // para las excepciones  tipo IOExeption
            System.out.println("Error al cargar productos." );
        }
    }

    // Guardar productos en archivo
    private void guardarProductos() { // declaramos guardar producto
        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(archivoInventario))) { // para escribir n el archivo
            for (Producto p : productos) { //asigna p a a cada iteracion
                String linea = p.getIdProducto() + ", " + p.getNombrePlanta() + ", " + p.getEspecie() + ", " + p.getPrecio() + ", " + p.getCantidadDisponible();
                escribe.write(linea); // convierte a exto
                escribe.newLine(); // inserta un salto de linea
            }
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    // Agregar producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarProductos();
    }

    // Actualizar producto
    public void actualizarProducto(String id, Producto nuevoProducto) {
        for (Producto producto : productos) { // Recorremos la lista de productos
            if (producto.getIdProducto().equals(id)) { // Si el ID coincide
                productos.set(productos.indexOf(producto), nuevoProducto); // Reemplazamos el producto
                guardarProductos(); // Guardamos los cambios en el archivo
                return; // Terminamos el método
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Eliminar producto
    public void eliminarProducto(String id) {
        productos.removeIf(p -> p.getIdProducto().equals(id));
        guardarProductos();
    }

    // Método para buscar productos por categoría
    public void buscarPorCategoria(String categoria) {
        for (Producto producto : productos) { // Recorremos la lista de productos
            if (producto.getEspecie().equalsIgnoreCase(categoria)) { // Si la categoría coincide
                System.out.println(producto); // Mostramos el producto
            }
        }
    }

    /// Método para encontrar el producto más caro
    public void productoMasCaro() {
        if (productos.isEmpty()) { // Verificamos si la lista está vacía
            System.out.println("No hay productos en el inventario.");
            return;
        }

        Producto masCaro = productos.get(0); // Suponemos que el primero es el más caro

        for (Producto producto : productos) { // Recorremos la lista
            if (producto.getPrecio() > masCaro.getPrecio()) { // Si encontramos uno más caro
                masCaro = producto; // Actualizamos el más caro
            }
        }

        System.out.println("El producto más caro es: " + masCaro); // Mostramos el resultado
    }

    // Cantidad de productos por categoría
    public void cantidadPorCategoria(String categoria) {
        long count = productos.stream()
                .filter(p -> p.getEspecie().equalsIgnoreCase(categoria))
                .count();
        System.out.println("Cantidad de productos en categoría '" + categoria + "': " + count);
    }

    // Método para generar un reporte del inventario
    public void generarReporte() {
        try {
            // Abrimos el archivo para escribir
            BufferedWriter escribir = new BufferedWriter(new FileWriter("reporte_vivero.txt"));

            double valorTotal = 0; // Inicializamos el valor total del inventario

            for (Producto producto : productos) { // Recorremos la lista de productos
                double valorProducto = producto.getPrecio() * producto.getCantidadDisponible(); // Calculamos el valor del producto
                valorTotal += valorProducto; // Sumamos el valor al total
                escribir.write(producto.toString()); // Escribimos el producto en el archivo
                escribir.newLine(); // Pasamos a la siguiente línea
            }

            escribir.write("Valor total del inventario: " + valorTotal); // Escribimos el valor total
            escribir.newLine(); // Añadimos una nueva línea por orden
            escribir.close(); // Cerramos el archivo

        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el reporte."); // Mensaje en caso de error
        }
    }
}
