package cakes.mock.model;

/**
 * Author：耿常安
 * Date：2021-04-06-8:16
 * Description：<描述>
 */
public class TimeEntity {
    private Integer value;
    private String unit;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "TimeEntity{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
