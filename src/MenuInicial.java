import java.util.Scanner;

public class MenuInicial {
    public static void main(String[] args) {

        //vamos a crear el inventario del vivero
       Inventario inventario = new Inventario();
       inventario.cargarProductos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú principal
        do {
            // Mostrar opciones del menú
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Buscar por categoría");
            System.out.println("5. Generar reporte");
            System.out.println("6. Cantidad de productos por categoría");
            System.out.println("7. Producto más caro");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            // Acciones según la opción seleccionada
            if (opcion == 1) {
                System.out.println("Agregue aqui su nuevo producto.");
                // Llama al método correspondiente
            } else if (opcion == 2) {
                System.out.println("Actualice sus productos.");
                // Llama al método correspondiente
            } else if (opcion == 3) {
                System.out.println("Eliminar productos.");
                // Llama al método correspondiente
            } else if (opcion == 4) {
                System.out.println("Seleccione Especie.");
                // Llama al método correspondiente
            } else if (opcion == 5) {
                System.out.println("Generando reporte...");
                inventario.generarReporte();
            } else if (opcion == 6) {
                System.out.println("Cantida de productos poe especie");
                // Llama al método correspondiente
            } else if (opcion == 7) {
                System.out.println("Buscando el producto más caro...");
                inventario.productoMasCaro();
            } else if (opcion == 8) {
                System.out.println("¡Hasta luego!");
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}


