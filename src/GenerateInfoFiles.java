import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (FileWriter writer = new FileWriter(name + "_" + id + ".txt")) {
            Random random = new Random();
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = random.nextInt(1000) + 1;
                int quantity = random.nextInt(10) + 1;
                writer.write("IDProducto" + productId + ";" + quantity + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createProductsFile(int productsCount) {
        try (FileWriter writer = new FileWriter("products.txt")) {
            Random random = new Random();
            for (int i = 0; i < productsCount; i++) {
                Product product = new Product(i + 1, generateRandomProductName(), random.nextDouble() * 100);
                writer.write(product.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) {
        try (FileWriter writer = new FileWriter("salesmen.txt")) {
            for (int i = 0; i < salesmanCount; i++) {
                Salesman salesman = new Salesman(generateRandomNames(), generateRandomSurnames());
                writer.write(salesman.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomNames() {
        return "NombreAleatorio";
    }

    private static String generateRandomSurnames() {
        return "ApellidoAleatorio";
    }

    private static String generateRandomProductName() {
        return "Product" + (new Random().nextInt(1000) + 1);
    }

    public static void main(String[] args) {
        createSalesMenFile(10, "Vendedor1", 123456789);
        createProductsFile(20);
        createSalesManInfoFile(5);
        System.out.println("Archivos generados exitosamente.");
    }
}
