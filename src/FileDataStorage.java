import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FileDataStorage implements DataStorage {

    private static final String DATABASE_FILE_NAME = "myDatabase.txt";

    private final String databaseDir;

    public FileDataStorage(String databaseDir) {
        this.databaseDir = databaseDir;
    }

    @Override
    public void save(Invoice invoice) {
        try {
            String result = invoice.getId() + "," + invoice.getTytul() + "," + invoice.getKwota();
            String path = databaseDir + File.separator + DATABASE_FILE_NAME;
            Files.write(Paths.get(path), result.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAllInvoices() {
        //Wczytaj wszystkie lini z pliku
        //dla kazdej lini
        //wykonaj parsowanie rodzielajac dane po przecinkach i przypisujac je do zmiennych
        //na podstawie zmiennych id, nazwa, kwota stworzyc obiekt faktura
        //dodac obiek faktura do listy
        int readId;
        String readTitle;
        int readValue;
        List lista = new ArrayList();


        String path = databaseDir + File.separator + DATABASE_FILE_NAME;
        Charset charset = Charset.forName("ISO-8859-1");
        File file = new File(path);
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringTokenizer token;
        while(reader.hasNextLine()){
            token = new StringTokenizer(reader.nextLine(),",");
            readId = (int) token.nextElement();
            readTitle = (String) token.nextElement();
            readValue = (int) token.nextElement();
            lista.add(new Invoice(readId,readTitle,readValue));
            }
        return lista;
        }

    }



