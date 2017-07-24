
public class Invoice {

    private int id;
    private String tytul;
    private int kwota;

    public Invoice(int id, String tytul, int kwota) {
        this.id = id;
        this.tytul = tytul;
        this.kwota = kwota;
    }

    public int getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public int getKwota() {
        return kwota;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", kwota=" + kwota +
                '}';
    }
}
