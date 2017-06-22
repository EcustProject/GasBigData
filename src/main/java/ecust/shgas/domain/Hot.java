package ecust.shgas.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by wenqing on 2017/6/20.
 */
public class Hot implements Serializable {
    private String serial_number;
    private Timestamp create_time;
    private String fy_xingshi;
    private String fy_neirong;

    public Hot() {
        super();
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getFy_xingshi() {
        return fy_xingshi;
    }

    public void setFy_xingshi(String fy_xingshi) {
        this.fy_xingshi = fy_xingshi;
    }

    public String getFy_neirong() {
        return fy_neirong;
    }

    public void setFy_neirong(String fy_neirong) {
        this.fy_neirong = fy_neirong;
    }

    @Override
    public String toString() {
        return "HotXX{" +
                "serial_number='" + serial_number + '\'' +
                ", create_time=" + create_time +
                ", fy_xingshi='" + fy_xingshi + '\'' +
                ", fy_neirong='" + fy_neirong + '\'' +
                '}';
    }
}