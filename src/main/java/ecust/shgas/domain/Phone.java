package ecust.shgas.domain;

import java.io.Serializable;

/**
 * Created by huchao on 2017/6/9.
 */
public class Phone implements Serializable {
    private Integer id;
    private String haoma;
    private Integer jb_cishu;
    private String bj_leixing;

    public Phone() {

    }
    public Phone(String haoma, Integer id) {
        this.haoma = haoma;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHaoma() {
        return haoma;
    }

    public void setHaoma(String haoma) {
        this.haoma = haoma;
    }

    public Integer getJb_cishu() {
        return jb_cishu;
    }

    public void setJb_cishu(Integer jb_cishu) {
        this.jb_cishu = jb_cishu;
    }

    public String getBj_leixing() {
        return bj_leixing;
    }

    public void setBj_leixing(String bj_leixing) {
        this.bj_leixing = bj_leixing;
    }
}
