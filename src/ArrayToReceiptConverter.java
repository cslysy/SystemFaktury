
public class ArrayToReceiptConverter implements ArrayToTypeConverter<Receipt> {

  @Override
  public Receipt convert(String[] array) {
    int id = Integer.valueOf(array[0]);
    String name = array[1];
    int amount = Integer.valueOf(array[2]);
    return new Receipt(id, name, amount);
  }
}
