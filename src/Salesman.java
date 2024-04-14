public class Salesman {
    private String name;
    private String surname;

    public Salesman(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "TipoDocumento;NúmeroDocumento;" + name + ";" + surname;
    }
}
