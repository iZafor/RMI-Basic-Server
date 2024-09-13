import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.ZonedDateTime;

public interface Logger extends Remote {
    RequestLog getRequestLog(ZonedDateTime requestTime) throws RemoteException;
}