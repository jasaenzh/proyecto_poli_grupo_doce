import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GenerateInfoFiles {

    // Método para crear un archivo de ventas de un vendedor con datos aleatorios en
    // formato CSV
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (FileWriter writer = new FileWriter(name + "_" + id + ".csv")) {
            Random random = new Random();
            // Generar datos de ventas aleatorios
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = random.nextInt(1000) + 1; // ID de producto aleatorio
                int quantity = random.nextInt(10) + 1; // Cantidad de productos vendidos
                writer.write("IDProducto" + productId + "," + quantity + "\n");
            }
        } catch (IOException e) {
            // Manejar posibles errores de escritura en el archivo
            e.printStackTrace();
        }
    }

    // Método para crear un archivo de productos con datos aleatorios en formato CSV
    public static void createProductsFile(int productsCount) {
        try (FileWriter writer = new FileWriter("products.csv")) {
            List<Product> products = new ArrayList<>(); // Lista para almacenar productos

            Random random = new Random();
            // Generar datos de productos aleatorios y almacenarlos en la lista
            for (int i = 0; i < productsCount; i++) {
                Product product = new Product(i + 1, generateRandomProductName(), random.nextDouble() * 100);
                products.add(product);
            }

            // Ordenar la lista de productos por su precio
            Collections.sort(products, Comparator.comparingDouble(Product::getPrice));

            // Escribir los datos ordenados del producto en el archivo
            for (Product product : products) {
                writer.write(product.toCsv() + "\n");
            }
        } catch (IOException e) {
            // Manejar posibles errores de escritura en el archivo
            e.printStackTrace();
        }
    }

    // Método para crear un archivo de información de vendedores con datos
    // aleatorios en formato CSV
    public static void createSalesManInfoFile(int salesmanCount) {
        try (FileWriter writer = new FileWriter("salesmen.csv")) {
            // Generar datos de vendedores aleatorios
            for (int i = 0; i < salesmanCount; i++) {
                Salesman salesman = new Salesman(generateRandomNames(), generateRandomSurnames());
                // Escribir los datos del vendedor en el archivo
                writer.write(salesman.toCsv() + "\n");
            }
        } catch (IOException e) {
            // Manejar posibles errores de escritura en el archivo
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

    // Método auxiliar para generar nombres aleatorios de productos
    private static String generateRandomProductName() {
        return "Product" + (new Random().nextInt(1000) + 1);
    }

    // Método principal para probar la generación de archivos
    public static void main(String[] args) {
        // Generar archivos de prueba
        createSalesMenFile(10, "Vendedor1", 123456789);
        createProductsFile(20);
        createSalesManInfoFile(5);
        System.out.println("Archivos generados exitosamente.");
    }
}