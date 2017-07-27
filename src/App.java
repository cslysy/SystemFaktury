import java.util.List;

public class App {

    public static void main(String[] args) {

        DataStorage fileDataStorage = new FileDataStorage("C:\\remove-me\\jimi-database");
        //DataStorage inMemoryDataStorage = new InMemoryDataStorage();

        JimiSystem jimiSystem = new JimiSystem(fileDataStorage);
        jimiSystem.save(new Invoice(1, "test", 124));

        List<Invoice> faktury = jimiSystem.getAllInvoices();

        System.out.println("faktury = " + faktury);
    }
}
