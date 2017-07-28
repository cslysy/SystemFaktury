import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStorage implements DataStorage {

    private List<Invoice> invoices = new ArrayList<>();
    private List<Receipt> receipts = new ArrayList<>();

    //Invoices
    @Override
    public void saveInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    //Receipts
    @Override
    public void saveReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receipts;
    }
}
