
public class Invoice implements SaleDocument {

    private int id;
    private String tytul;
    private int kwota;
    private int nip;

    public Invoice(int id, String tytul, int kwota, int nip) {
        this.id = id;
        this.tytul = tytul;
        this.kwota = kwota;
        this.nip = nip;
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

    public int getNip() {
        return nip;
    }

    @Override
    public String toString() {
        return "\n" + "Invoice{" +
                "id=" + id + "\n" +
                "tytul='" + tytul + '\'' + "\n" +
                "kwota=" + kwota + "\n" +
                "nip=" + nip +
                '}' + "\n";
    }
}
