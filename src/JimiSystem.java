import java.util.List;

public class JimiSystem {

    private DataStorage dataStorage;

    public JimiSystem(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void save(Invoice invoice){
        dataStorage.save(invoice);
    }

    public List<Invoice> getAllInvoices(){
        return dataStorage.getAllInvoices();
    }
}
