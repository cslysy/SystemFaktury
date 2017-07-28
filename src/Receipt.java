public class Receipt implements SaleDocument {

    private int id;
    private String tytul;
    private int kwota;

    public Receipt(int id, String tytul, int kwota) {
        this.id = id;
        this.tytul = tytul;
        this.kwota = kwota;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTytul() {
        return tytul;
    }

    @Override
    public int getKwota() {
        return kwota;
    }

    @Override
    public String toString() {
        return "\n" + "Receipt{" +
                "id=" + id + "\n" +
                "tytul='" + tytul + '\'' + "\n" +
                "kwota=" + kwota +
                '}' + "\n";
    }
}
