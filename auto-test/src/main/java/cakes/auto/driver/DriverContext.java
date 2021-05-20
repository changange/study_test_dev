package cakes.auto.driver;

import cakes.auto.AutoDriver;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-03-25-22:35
 * Description：<描述>
 */
public class DriverContext {
    private String byPackage;
    private String byClass;
    private String[] byClasses;

    private List<Level> byLevel;

    private List<String> byGroup;

    public static DriverContext createContext(){
        return new DriverContext();
    }

    public static DriverContext createContext(AutoDriver driver){
        DriverContext context = new DriverContext();
        context.setaClass(driver.byClass());
        context.setByPackage(driver.byPackage());
        context.setByClasses(driver.byClasses());
        context.setByLevel(Lists.newArrayList(driver.byLevel()));
        context.setByGroup(Lists.newArrayList(driver.byGroup()));
        return context;
    }

    public String getByPackage() {
        return byPackage;
    }

    public void setByPackage(String byPackage) {
        this.byPackage = byPackage;
    }

    public String getbyClass() {
        return byClass;
    }

    public void setaClass(String byClass) {
        this.byClass = byClass;
    }

    public String[] getByClasses() {
        return byClasses;
    }

    public void setByClasses(String[] byClasses) {
        this.byClasses = byClasses;
    }

    public String getByClass() {
        return byClass;
    }

    public void setByClass(String byClass) {
        this.byClass = byClass;
    }

    public List<Level> getByLevel() {
        return byLevel;
    }

    public void setByLevel(List<Level> byLevel) {
        this.byLevel = byLevel;
    }

    public List<String> getByGroup() {
        return byGroup;
    }

    public void setByGroup(List<String> byGroup) {
        this.byGroup = byGroup;
    }
}
