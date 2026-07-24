public class MyService {
    private ExternalApi api;

    // Constructor injection
    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}