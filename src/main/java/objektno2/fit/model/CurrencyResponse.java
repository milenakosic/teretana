package objektno2.fit.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CurrencyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currencyResponse_seq")
    @SequenceGenerator(name = "currencyResponse_seq", sequenceName = "currencyResponse_seq", allocationSize = 1)
    private Long id;

    private double value;
    private double convertedValue;

    private String from;
    private String to;
    private double rate;
    private String date;
    private String source;

    public CurrencyResponse(){
    }

    public CurrencyResponse(Long id, double value, double convertedValue, String from, String to, double rate, String date, String source) {
        this.id = id;
        this.value = value;
        this.convertedValue = convertedValue;
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.date = date;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyResponse that = (CurrencyResponse) o;
        return Double.compare(value, that.value) == 0 && Double.compare(convertedValue, that.convertedValue) == 0 && Double.compare(rate, that.rate) == 0 && Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(date, that.date) && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, convertedValue, from, to, rate, date, source);
    }


    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "id=" + id +
                ", value=" + value +
                ", convertedValue=" + convertedValue +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
