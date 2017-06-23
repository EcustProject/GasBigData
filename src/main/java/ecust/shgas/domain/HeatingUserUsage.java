package ecust.shgas.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wenqing on 2017/6/22.
 */
public class HeatingUserUsage implements Serializable {
    private String heating_cid;
    private String heating_name;
    private String heating_address;
    private String  heating_area;
    private Date heating_time;
    private String heating_year;
    private String heating_month;
    private int  heating_type;
    private int  heating_usage;

    public String getHeating_cid() {
        return heating_cid;
    }

    public void setHeating_cid(String heating_cid) {
        this.heating_cid = heating_cid;
    }

    public String getHeating_name() {
        return heating_name;
    }

    public void setHeating_name(String heating_name) {
        this.heating_name = heating_name;
    }

    public String getHeating_address() {
        return heating_address;
    }

    public void setHeating_address(String heating_address) {
        this.heating_address = heating_address;
    }

    public String getHeating_area() {
        return heating_area;
    }

    public void setHeating_area(String heating_area) {
        this.heating_area = heating_area;
    }

    public Date getHeating_time() {
        return heating_time;
    }

    public void setHeating_time(Date heating_time) {
        this.heating_time = heating_time;
    }

    public String getHeating_year() {
        return heating_year;
    }

    public void setHeating_year(String heating_year) {
        this.heating_year = heating_year;
    }

    public String getHeating_month() {
        return heating_month;
    }

    public void setHeating_month(String heating_month) {
        this.heating_month = heating_month;
    }

    public int getHeating_type() {
        return heating_type;
    }

    public void setHeating_type(int heating_type) {
        this.heating_type = heating_type;
    }

    public int getHeating_usage() {
        return heating_usage;
    }

    public void setHeating_usage(int heating_usage) {
        this.heating_usage = heating_usage;
    }

    @Override
    public String toString() {
        return "HeatingUserUsage{" +
                "heating_cid='" + heating_cid + '\'' +
                ", heating_name='" + heating_name + '\'' +
                ", heating_address='" + heating_address + '\'' +
                ", heating_area='" + heating_area + '\'' +
                ", heating_time=" + heating_time +
                ", heating_year='" + heating_year + '\'' +
                ", heating_month='" + heating_month + '\'' +
                ", heating_type=" + heating_type +
                ", heating_usage=" + heating_usage +
                '}';
    }
}
