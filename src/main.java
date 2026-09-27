import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CalculadoraPrecios {
    public double calcularTotal(double precio, int cantidad) {
        return precio * cantidad;
    }

    public double calcularTotal(double precio, int cantidad, double descuentoPorcentaje) {
        double subtotal = precio * cantidad;
        return subtotal - (subtotal * (descuentoPorcentaje / 100));
    }
}

class Inventario {
    private List<String> productos = new ArrayList<>();

    public void agregarProducto(String producto) {
        productos.add(producto);
        System.out.println("-> Producto registrado: " + producto);
    }

    public void mostrarInventario() {
        System.out.println("\n--- LISTA DE PRODUCTOS (Coleccion ArrayList) ---");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraPrecios calculadora = new CalculadoraPrecios();
        Inventario inventario = new Inventario();

        System.out.println("=== SISTEMA DE GESTION - PRACTICA INTEGRADORA ===");

        int cantidad = -1;
        while (true) {
            try {
                System.out.print("Ingrese la cantidad de unidades (numero entero positivo): ");
                cantidad = Integer.parseInt(scanner.nextLine());
                
                if (cantidad < 0) {
                    throw new IllegalArgumentException("La cantidad no puede ser un numero negativo.");
                }
                break; 
            } catch (NumberFormatException e) {
                System.out.println("[Error] Debe ingresar un valor numerico entero valido.");
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

        double precioUnitario = 45.50;
        System.out.println("Precio unitario base: $" + precioUnitario);

        double totalNormal = calculadora.calcularTotal(precioUnitario, cantidad);
        double totalConDescuento = calculadora.calcularTotal(precioUnitario, cantidad, 15.0); 

        System.out.println("\n--- RESULTADOS DE SOBRECARGA ---");
        System.out.println("Total sin descuento: $" + totalNormal);
        System.out.println("Total con 15% de descuento aplicado: $" + totalConDescuento);

        System.out.println("\n--- GESTION DE INVENTARIO ---");
        inventario.agregarProducto("Laptop Core i5");
        inventario.agregarProducto("Mouse Inalambrico");
        inventario.agregarProducto("Teclado Mecanico");
        
        inventario.mostrarInventario();
        
        System.out.println("\n¡Ejecucion finalizada con exito en NetBeans!");
    }
}