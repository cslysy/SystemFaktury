import java.util.List;


public interface DataStorage {

    void save(Invoice invoice);

    List<Invoice> getAllInvoices();
}
