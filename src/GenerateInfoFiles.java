import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    // Método para generar archivos de ventas de un vendedor aleatorios
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (FileWriter writer = new FileWriter(name + "_" + id + ".txt")) {
            Random random = new Random();
            // Ajusta el rango de IDs de productos
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = random.nextInt(1000) + 1;
                // Como ejemplo.. una cantidad máxima de 10 productos vendidos
                int quantity = random.nextInt(10) + 1;
                writer.write("IDProducto" + productId + ";" + quantity + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para generar un archivo con información aleatoria de productos
    public static void createProductsFile(int productsCount) {
        try (FileWriter writer = new FileWriter("products.txt")) {
            Random random = new Random();
            for (int i = 0; i < productsCount; i++) {
                int productId = i + 1;
                String productName = "Product" + productId;
                double price = random.nextDouble() * 100; // Precio aleatorio entre 0 y 100
                writer.write("IDProducto" + productId + ";" + productName + ";" + price + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para generar un archivo con información de vendedores pseudoaleatoria
    public static void createSalesManInfoFile(int salesmanCount) {
        try (FileWriter writer = new FileWriter("salesmen.txt")) {
            for (int i = 0; i < salesmanCount; i++) {
                // Método para generar nombres aleatorios
                String names = generateRandomNames();

                // Método para generar apellidos aleatorios
                String surnames = generateRandomSurnames();
                writer.write("TipoDocumento;NúmeroDocumento;" + names + ";" + surnames + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para generar nombres aleatorios
    private static String generateRandomNames() {
        return "NombreAleatorio";
    }

    // Método auxiliar para generar apellidos aleatorios
    private static String generateRandomSurnames() {
        return "ApellidoAleatorio";
    }

    // Método main para probar la generación de archivos
    public static void main(String[] args) {
        // Generar archivos de prueba
        createSalesMenFile(10, "Vendedor1", 123456789);
        createProductsFile(20);
        createSalesManInfoFile(5);
        System.out.println("Archivos generados exitosamente.");
    }
}
