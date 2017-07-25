import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStorage implements DataStorage {

    private List<Invoice> invoices = new ArrayList<>();

    @Override
    public void save(Invoice invoice){
        invoices.add(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices(){
        return invoices;
    }
}
