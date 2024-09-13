import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerImpl extends UnicastRemoteObject implements Logger {
    public LoggerImpl() throws RemoteException {
        super();
    }

    @Override
    public RequestLog getRequestLog(ZonedDateTime requestTime) throws RemoteException {
        try {
            ZonedDateTime now = ZonedDateTime.now();

            Thread.sleep(2000);
            System.out.println("Thread - " + Thread.currentThread().threadId() + " " + now.toLocalDateTime());

            return new RequestLog(
                    RemoteServer.getClientHost(),
                    now.format(
                            DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy")
                    ),
                    // nano - 10^-9 & milli - 10^-3. nano to milli = nano / 10^6
                    // below operation is performed to take 2 digits after the decimal point
                    // round((nano / 10^6) * 100) / 100  =  round(nano / 10^4) / 100
                    Math.round(Duration.between(requestTime, now).getNano() / 10000.0) / 100.0
            );
        } catch (Exception e) {
            System.out.println("Remote object error: " + e.getMessage());
        }
        return null;
    }
}