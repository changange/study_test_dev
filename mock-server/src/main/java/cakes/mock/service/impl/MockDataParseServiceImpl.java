package cakes.mock.service.impl;

import cakes.mock.model.MockConfig;
import cakes.mock.model.MockContext;
import cakes.mock.service.MockDataParseService;
import cn.hutool.core.io.IoUtil;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author：耿常安
 * Date：2021-04-06-8:30
 * Description：<描述>
 */
@Service
public class MockDataParseServiceImpl implements MockDataParseService {
    @Override
    public void parse(MockContext context) {
        MockConfig mockConfig = context.getTargetMockConfig();

        if (!Strings.isNullOrEmpty(mockConfig.getMockData())) {
            context.setTargetMockData(mockConfig.getMockData());
        }

        //走到这里，说明getMockData为 空
        if (!Strings.isNullOrEmpty(mockConfig.getMockPath())) {
            try {
                context.setTargetMockData(IoUtil.read(new FileInputStream(new File(mockConfig.getMockPath())),"UTF-8"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
