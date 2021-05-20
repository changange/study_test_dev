package cakes.mock.service.impl;

import cakes.mock.model.MockConfig;
import cakes.mock.model.MockContext;
import cakes.mock.model.MockEntity;
import cakes.mock.service.SelectStrategyService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-03-10:07
 * Description： 通过哪种方式计算
 */
@Service
public class SelectStrategyServiceImpl implements SelectStrategyService {

    @Override
    public void selectMock(MockContext context) {

        //加载本地的mock配置，里面存的就是匹配的url+mock data

        MockConfig targetMockConfig = null;
        Integer maxWeight= 0;

        //开始基于权重计算
        for (MockConfig mockConfig:context.getLocalMockConfigs()){
            //从mockConfig拿到匹配的参数 （权重和那个值）
            Map<String, MockEntity> mappingParams = mockConfig.getMappingParams();

            Integer weightSum = 0;

            //基于权重计算返回哪个mock数据
            for(Map.Entry<String,MockEntity> entry: mappingParams.entrySet()){
                /**
                 * 去处理一个匹配参数对与我们mock请求的参数是否匹配
                 *accountId:
                 *     value: "1234"
                 *     weight: 1
                 */
                String key = entry.getKey();    //accountId
                MockEntity mockEntity = entry.getValue();   //value: "1234"   weight: 1

                //判断请求的参数与我们的mappingParam是否一致，即真实请求中
                //真实请求  accountId=“1234”  accountName=“gcas"
                /////////////////处理参数匹配逻辑
                if (context.getMockParameter().contationsParameterEntry(key, mockEntity.getValue())) {
                    Integer weight = mockEntity.getWeight();
                    weightSum +=weight;
                }

                ////////////////这里可以处理IP的匹配逻辑
                //要在MockConfig 加一个mappingHost，如果命中，就让权重—++  weightSum +=weight;

                ////////////////这里处理请求头的匹配逻辑
                //要在MockConfig 加一个mappingHeader， 如果命中，就让权重—++  weightSum +=weight;
            }
            //判断权重，就是循环对比，取最大的
            if (weightSum>maxWeight){
                //这里原来只有mockdata则直接返回即可，但是加了mockpath的指定，就需要处理
                //targetMockData = mockConfig.getMockData();

                //targetMockConfig = choseData(mockConfig);
                targetMockConfig = mockConfig;
                maxWeight = weightSum;
            }
        }

        /**
         * 处理时间戳
         */

        context.setTargetMockConfig(targetMockConfig);
    }

}
