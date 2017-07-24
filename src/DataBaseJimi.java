import java.util.List;

public class DataBaseJimi {

    private DataStorage dataStorage = new FileDataStorage("C:\\remove-me\\jimi-database");

    public void save(Invoice invoice){
        dataStorage.save(invoice);
    }

    public List<Invoice> getAllInvoices(){
        return dataStorage.getAllInvoices();
    }
}
