package ecust.shgas.domain;

/**
 * Created by dengcunbin on 17/9/29.
 */
public class Problem {

    private String repairType; //报修类别

    private Integer numbers; //报修数量

    private String district; //区名

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "repairType='" + repairType + '\'' +
                ", numbers=" + numbers +
                ", district='" + district + '\'' +
                '}';
    }
}
