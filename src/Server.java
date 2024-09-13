import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            Logger logger = new LoggerImpl();
            registry.bind("logger", logger);
            System.out.println("RMI Server started");
        } catch (Exception e) {
            System.out.println("Server side error: " + e.getMessage());
        }
    }
}