public class Product implements Comparable<Product> {
    private int productId; // Identificador único del producto
    private String productName; // Nombre del producto
    private double price; // Precio del producto

    // Constructor de la clase Product
    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Método para obtener el precio del producto
    public double getPrice() {
        return price;
    }

    // Método toString para convertir el objeto Product en una cadena de texto
    @Override
    public String toString() {
        // Devuelve una representación en cadena del producto en el formato requerido
        return "IDProducto" + productId + ";" + productName + ";" + price;
    }

    // Método para convertir el objeto Product a formato CSV
    public String toCsv() {
        // Devuelve una representación en formato CSV del producto
        return productId + "," + productName + "," + price;
    }

    // Método para comparar dos productos por su precio
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
}