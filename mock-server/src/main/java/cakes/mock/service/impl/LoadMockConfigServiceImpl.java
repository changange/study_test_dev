package cakes.mock.service.impl;

import cakes.mock.model.MockConfig;
import cakes.mock.model.MockContext;
import cakes.mock.service.LoadMockConfigService;
import cakes.mock.util.YmlUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-04-03-18:05
 * Description：<描述>
 */

@Service
public class LoadMockConfigServiceImpl implements LoadMockConfigService {

    private static final String BESE_PATH="E:\\mock-03\\";

    @Override
    public void loadMockConfig(MockContext context) {

        String mockPath = BESE_PATH + context.getMockParameter().getMockPath();
        System.out.println("--加载yml文件--："+mockPath);
        File mockFilePath = new File(mockPath);

        //文件夹是否存在，必须是文件夹
        //return Arrays.stream(Objects.requireNonNull(mockFilePath.listFiles()))
        //        .filter(file -> file.getName().endsWith(".yml"))
        //        .map(file -> {
        //            return YmlUtils.parseMockConfig(file);
        //        }).collect(Collectors.toList());

        //拿到yml文件，解析里边的数据
        List<MockConfig> configs = Arrays.stream(Objects.requireNonNull(mockFilePath.listFiles()))
                .filter(file -> file.getName().endsWith(".yml"))
                .map(YmlUtils::parseMockConfig).collect(Collectors.toList());

        context.setLocalMockConfigs(configs);
    }
}
