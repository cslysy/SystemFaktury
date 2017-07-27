import java.util.List;


public interface DataStorage {

    void saveInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();

    void saveReceipt(Receipt receipt);

    List<Receipt> getAllReceipts();
}
