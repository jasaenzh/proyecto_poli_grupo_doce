public class Salesman {
    private String name; // Nombre del vendedor
    private String surname; // Apellido del vendedor

    // Constructor de la clase Salesman
    public Salesman(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Método toString para convertir el objeto Salesman en una cadena de texto
    @Override
    public String toString() {
        // Devuelve una representación en cadena del vendedor en el formato requerido
        return "TipoDocumento;NúmeroDocumento;" + name + ";" + surname;
    }

    // Método para convertir el objeto Salesman a formato CSV
    public String toCsv() {
        // Devuelve una representación en formato CSV del vendedor
        return name + "," + surname;
    }
}