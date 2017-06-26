package ecust.shgas.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wenqing on 2017/6/22.
 */
public class HeatingUserUsage implements Serializable {
    private String cid;
    private String name;
    private String address;
    private String area;
    private Date time;
    private String year;
    private String month;
    private int type;
    private int usage;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "HeatingUserUsage{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", time=" + time +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", type=" + type +
                ", usage=" + usage +
                '}';
    }
}
