import java.util.List;

public class JimiSystem {

    private DataStorage dataStorage;

    public JimiSystem(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void saveInvoice(Invoice invoice) {
        dataStorage.saveInvoice(invoice);
    }

    public void saveReceipt(Receipt receipt) {
        dataStorage.saveReceipt(receipt);
    }

    public List<Invoice> getAllInvoices() {
        return dataStorage.getAllInvoices();
    }

    public List<Receipt> getAllReceipts() {
        return dataStorage.getAllReceipts();
    }
}
