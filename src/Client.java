import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.ZonedDateTime;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Registry registry = LocateRegistry.getRegistry("localhost", 5000);
                    Logger logger = (Logger) registry.lookup("logger");
                    System.out.println(logger.getRequestLog(ZonedDateTime.now()) + "\n");
                }catch (Exception e) {
                    System.out.println("Client side error: " + e.getMessage());
                }
            }).start();
        }
    }
}