package objektno2.fit.model;

import java.util.Objects;

public class Ip {
    private String ip;

    public Ip() {
    }

    public Ip(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ip ip1 = (Ip) o;
        return Objects.equals(ip, ip1.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ip);
    }

    @Override
    public String toString() {
        return "Ip{" +
                "ip='" + ip + '\'' +
                '}';
    }

}
