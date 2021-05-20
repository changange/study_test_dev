package cakes.auto.driver;

import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.launcher.PostDiscoveryFilter;

/**
 * Author：耿常安
 * Date：2021-03-30-8:50
 * Description：<描述>
 */
public class CaseGroupFilter implements PostDiscoveryFilter {

    private DriverContext driverContext;

    public CaseGroupFilter(DriverContext driverContext){
        this.driverContext = driverContext;
    }

    @Override
    public FilterResult apply(TestDescriptor testDescriptor) {
        return null;
    }
}
