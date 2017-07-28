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

  @Override
  public void saveInvoice(Invoice invoice) {
    try {
      String result =
          invoice.getId() + "," + invoice.getTytul() + "," + invoice.getKwota() + "," + invoice
              .getNip() + "\n";
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
    String databaseFilePath = databaseDir + File.separator + INVOICES_DATABASE_FILE_NAME;
    return convertDatabaseFileToListOfObjects(databaseFilePath, new ArrayToInvoiceConverter());
  }

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
    String databaseFilePath = databaseDir + File.separator + RECEIPTS_DATABASE_FILE_NAME;
    return convertDatabaseFileToListOfObjects(databaseFilePath, new ArrayToReceiptConverter());
  }

  private <T> List<T> convertDatabaseFileToListOfObjects(String databaseFilePath, ArrayToTypeConverter<T> arrayToTypeConverter) {
    List<T> resultList = new ArrayList<T>();
    try {
      File file = new File(databaseFilePath);
      Scanner reader = new Scanner(file);
      while (reader.hasNextLine()) {
        String[] arrayOfStrings = reader.nextLine().split(",");
        T result = arrayToTypeConverter.convert(arrayOfStrings);
        resultList.add(result);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return resultList;
  }
}

