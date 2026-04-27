package objektno2.fit.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class TimeApi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeapi_seq")
    @SequenceGenerator(name = "timeapi_seq", sequenceName = "timeapi_seq", allocationSize = 1)
    private Long id;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int milliSeconds;
    private Date dateTime;
    private String date;
    private String time;
    private String timeZone;
    private String dayOfWeek;
    private boolean dstActive;

    public TimeApi() {
    }

    public TimeApi(int year, int month, int day, int hour, int minute, int second, int milliSeconds, Date dateTime, String date, String time, String timeZone, String dayOfWeek, boolean dstActive, Long id) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.milliSeconds = milliSeconds;
        this.dateTime = dateTime;
        this.date = date;
        this.time = time;
        this.timeZone = timeZone;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMilliSeconds() {
        return milliSeconds;
    }

    public void setMilliSeconds(int milliSeconds) {
        this.milliSeconds = milliSeconds;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TimeApi timeApi = (TimeApi) o;
        return year == timeApi.year && month == timeApi.month && day == timeApi.day && hour == timeApi.hour && minute == timeApi.minute && second == timeApi.second && milliSeconds == timeApi.milliSeconds && dstActive == timeApi.dstActive && Objects.equals(id, timeApi.id) && Objects.equals(dateTime, timeApi.dateTime) && Objects.equals(date, timeApi.date) && Objects.equals(time, timeApi.time) && Objects.equals(timeZone, timeApi.timeZone) && Objects.equals(dayOfWeek, timeApi.dayOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, day, hour, minute, second, milliSeconds, dateTime, date, time, timeZone, dayOfWeek, dstActive);
    }

    @Override
    public String toString() {
        return "TimeApi{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                ", milliSeconds=" + milliSeconds +
                ", dateTime=" + dateTime +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dstActive=" + dstActive +
                '}';
    }

}
