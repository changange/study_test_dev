package cakes.mock.model;

/**
 * Author：耿常安
 * Date：2021-04-03-17:13
 * Description：<描述>
 */
public class MockEntity {
    private String value;
    private Integer weight;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MockEntity{" +
                "value='" + value + '\'' +
                ", weight=" + weight +
                '}';
    }
}
