import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class FileDataStorage implements DataStorage {

    private static final String INVOICES_DATABASE_FILE_NAME = "invoicesDatabase.txt";

    private static final String RECEIPTS_DATABASE_FILE_NAME = "receiptsDatabase.txt";

    private final String databaseDir;

    public FileDataStorage(String databaseDir) {
        this.databaseDir = databaseDir;
    }

    //INVOICES
    @Override
    public void saveInvoice(Invoice invoice) {
        try {
            String result = invoice.getId() + "," + invoice.getTytul() + "," + invoice.getKwota() + "," + invoice.getNip() + "\n";
            Path path = Paths.get(databaseDir + File.separator + INVOICES_DATABASE_FILE_NAME);
            if (!path.toFile().exists()) {
                path.toFile().createNewFile();
            }
            Files.write(path, result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        //Wczytaj wszystkie lini z pliku
        //dla kazdej lini
        //wykonaj parsowanie rodzielajac dane po przecinkach i przypisujac je do zmiennych
        //na podstawie zmiennych id, nazwa, kwota stworzyc obiekt faktura
        //dodac obiek faktura do listy

        String databaseFilePath = databaseDir + File.separator + INVOICES_DATABASE_FILE_NAME;

        //Some new comment
        //return getAllInvoicesOldJava(databaseFilePath);
        return getAllInvoicesNewJava(databaseFilePath);
    }

//    private List<Invoice> getAllInvoicesOldJava(String databaseFilePath) {
//        int readId;
//        String readTitle;
//        int readValue;
//        int readNip;
//        List<Invoice> lista = new ArrayList<>();
//
//        File file = new File(databaseFilePath);
//        Scanner reader = null;
//        try {
//            reader = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        StringTokenizer token;
//        if (reader != null) {
//            while (reader.hasNextLine()) {
//                token = new StringTokenizer(reader.nextLine(), ",");
//                readId = Integer.valueOf(String.valueOf(token.nextElement()));
//                readTitle = String.valueOf(token.nextElement());
//                readValue = Integer.valueOf(String.valueOf(token.nextElement()));
//                readNip = Integer.valueOf(String.valueOf(token.nextElement()));
//                lista.add(new Invoice(readId, readTitle, readValue, readNip));
//            }
//        }
//        return lista;
//    }


    private List<Invoice> getAllInvoicesNewJava(String databaseFilePath) {
        List<Invoice> result = null;
        try {
            result = Files.lines(Paths.get(databaseFilePath))
                    .map(line -> line.split(","))
                    .map(this::convertArrayToInvoice)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Invoice convertArrayToInvoice(String[] splitedLine) {
        int id = Integer.valueOf(splitedLine[0]);
        String name = splitedLine[1];
        int amount = Integer.valueOf(splitedLine[2]);
        int nip = Integer.valueOf(splitedLine[3]);
        return new Invoice(id, name, amount, nip);
    }

    //RECEIPTS

    @Override
    public void saveReceipt(Receipt receipt) {
        try {
            String result = receipt.getId() + "," + receipt.getTytul() + "," + receipt.getKwota() + "\n";
            Path path = Paths.get(databaseDir + File.separator + RECEIPTS_DATABASE_FILE_NAME);
            if (!path.toFile().exists()) {
                path.toFile().createNewFile();
            }
            Files.write(path, result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Receipt> getAllReceipts() {
        //Wczytaj wszystkie lini z pliku
        //dla kazdej lini
        //wykonaj parsowanie rodzielajac dane po przecinkach i przypisujac je do zmiennych
        //na podstawie zmiennych id, nazwa, kwota stworzyc obiekt paragon
        //dodac obiek faktura do listy

        String databaseFilePath = databaseDir + File.separator + RECEIPTS_DATABASE_FILE_NAME;

        //Some new comment
        return getAllReceiptsNewJava(databaseFilePath);

    }

    private List<Receipt> getAllReceiptsNewJava(String databaseFilePath) {
        List<Receipt> result = null;
        try {
            result = Files.lines(Paths.get(databaseFilePath))
                    .map(line -> line.split(","))
                    .map(this::convertArrayToReceipt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Receipt convertArrayToReceipt(String[] splitedLine) {
        int id = Integer.valueOf(splitedLine[0]);
        String name = splitedLine[1];
        int amount = Integer.valueOf(splitedLine[2]);
        return new Receipt(id, name, amount);

    }

}

