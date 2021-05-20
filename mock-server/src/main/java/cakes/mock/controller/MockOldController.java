package cakes.mock.controller;

/**
 * Author：耿常安
 * Date：2021-04-02-23:19
 * Description： 请求相同的接口，不同的人要求返回的结果不一样（匹配）
 *
 * 以create_account接口为例，参数有accountId
 * AccountId=123, 返回成功
 * AccountId=456, 返回失败
 * AccountId=123, accountName=张三 返回处理中
 *
 * ip=123.23.21.321 返回成功
 * ip=123.23.21.534 返回失败
 */

//@RestController
public class MockOldController {

    //private static final Logger LOGGER = LoggerFactory.getLogger(MockOldController.class);
    //
    //@Autowired
    //private LoadMockConfigService loadMockConfigService;
    //
    //
    ////拿到请求的一些信息
    //@Autowired
    //private HttpServletRequest servletRequest;
    //
    //@Autowired
    //private ParameterResolveService resolveService;
    //
    //@Autowired
    //private SelectStrategyService selectStrategyService;
    //
    //@Autowired
    //private DynamicStralegyService dynamicStralegyService;
    //
    //@Autowired
    //private MockDataParseService mockDataParseService;
    //
    //@Autowired
    //private thinkingTimeService thinkingTimeService;
    //
    //@Autowired
    //private HookParamsService hookParamsService;
    //
    //@Autowired
    //private CallbackService callbackService;
    //
    //@RequestMapping("/**")  //  /**匹配所有的URL
    //public String doMock(){
    //
    //    /**
    //     * 基于参数的匹配
    //     *         //1、需要拿到那些参数
    //     *         //2、计算该由谁来返回。计算策略。权重模型来计算
    //     *         //3、处理数据，（解析文件，返回数据）
    //     */
    //    try {
    //        //1、拿到参数，参数解析
    //        MockParameter mockParameter = resolveService.resolve(this.servletRequest);
    //
    //        //2、加载MOckconfig
    //        List<MockConfig> mockConfigs = loadMockConfigService.loadMockConfig(mockParameter.getMockPath());
    //
    //        //3、计算谁返回，mock数据策略选择
    //        //return strategyService.selectMock(mockParameter);
    //        MockConfig mockConfig = selectStrategyService.selectMock(mockParameter,mockConfigs);
    //
    //        //4、解析mock数据
    //        String mockData = mockDataParseService.parse(mockConfig);
    //
    //        //5、mock数据动态处理（时间戳）
    //        String dynamicData = dynamicStralegyService.handleMock(mockData);
    //
    //        //6、hook处理
    //        String result = hookParamsService.hook(dynamicData, mockParameter);
    //
    //        //7、callback
    //        callbackService.callback(mockConfig);
    //
    //        //8、响应时间处理
    //        thinkingTimeService.thinking(mockConfig);
    //
    //        return result;
    //    }catch (Exception e){
    //        LOGGER.error("do mock uri={}",servletRequest.getRequestURL(),e);
    //        return "mock failed";
    //    }
    //}
    //
    ////web里边的，每一个网页左上角都有个小图标，网页会自己请求这个，没有配这个会有时候报控制正
    //@RequestMapping("/favicon.ico")
    //public String icon(){
    //
    //    return  "https://www.baidu.com/favicon.ico";
    //}
}
