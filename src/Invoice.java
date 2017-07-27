
public class Invoice {

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

    public int getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public int getKwota() {
        return kwota;
    }

    public int getNip() { return nip;}

    @Override
    public String toString() {
        return "\n" + "Invoice{" +
                "id=" + id + "\n"+
                "tytul='" + tytul + '\'' + "\n" +
                "kwota=" + kwota + "\n" +
                "nip=" + nip +
                '}' + "\n";
    }
}
