package ecust.shgas.domain;
import java.io.Serializable;

/**
 * Created by huchao on 2017/4/12.
 */
public class User implements Serializable{
    private  Integer id;//id
    private  String loginname;//登录名
    private String password;//密码
    private String phone;//电话
    private String address;//地址

    public User(String password, String loginname) {
        this.password = password;
        this.loginname = loginname;
    }

    public User(Integer id, String address, String phone, String password, String loginname) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.loginname = loginname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
