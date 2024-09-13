import java.io.Serializable;

public class RequestLog implements Serializable {
    private final String ip;
    private final String time;
    private final double latency;

    public RequestLog(String ip, String time, double latency) {
        this.ip = ip;
        this.time = time;
        this.latency = latency;
    }

    @Override
    public String toString() {
        return "IP: " + ip
                + "\n" + time
                + "\nPing: " + latency +"ms";
    }
}