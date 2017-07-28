
public class ArrayToInvoiceConverter implements ArrayToTypeConverter<Invoice> {

  @Override
  public Invoice convert(String[] array) {
    int id = Integer.valueOf(array[0]);
    String name = array[1];
    int amount = Integer.valueOf(array[2]);
    int nip = Integer.valueOf(array[3]);
    return new Invoice(id, name, amount, nip);
  }
}
