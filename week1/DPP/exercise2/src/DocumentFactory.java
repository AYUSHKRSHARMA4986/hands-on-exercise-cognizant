public abstract class DocumentFactory {
    // The Factory Method itself
    public abstract Document createDocument();

    // A helper method demonstrating how the factory can use the objects it creates
    public void processNewDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}