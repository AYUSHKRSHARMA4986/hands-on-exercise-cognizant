public class ExcelDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Excel spreadsheet..."); }

    @Override
    public void save() { System.out.println("Calculating formulas and saving Excel spreadsheet..."); }

    @Override
    public void close() { System.out.println("Closing Excel spreadsheet...\n"); }
}