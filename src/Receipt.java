/**
 * Created by ardgh on 27.07.2017.
 */
public class Receipt {

    private int id;
    private String tytul;
    private int kwota;

    public Receipt(int id, String tytul, int kwota) {
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
        return "\n" + "Receipt{" +
                "id=" + id + "\n" +
                "tytul='" + tytul + '\'' + "\n" +
                "kwota=" + kwota +
                '}' + "\n";
    }
}
