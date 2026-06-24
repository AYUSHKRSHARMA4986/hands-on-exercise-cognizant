public class MainExercise2 {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern Testing ---\n");

        // 1. Create a Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document myWordDoc = wordFactory.createDocument();
        System.out.println("Client explicitly managing the document lifecycle:");
        myWordDoc.open();
        myWordDoc.save();
        myWordDoc.close();

        // 2. Create a PDF Document using the Factory's built-in processing
        System.out.println("Client using the Factory's built-in processing method:");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.processNewDocument();

        // 3. Create an Excel Document
        System.out.println("Creating an Excel document:");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processNewDocument();
    }
}