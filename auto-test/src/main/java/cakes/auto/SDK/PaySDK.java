package cakes.auto.SDK;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.base.Strings;

import java.lang.reflect.Type;

/**
 * Author：耿常安
 * Date：2021-04-01-21:56
 * Description： Http
 *
 * 接口测试脚本
 * 一版本我们就是接口自动化测试  ....有点托大了，要把这些讲的说说才算是点
 */
public class PaySDK {

    //第一版，最简单的
    public static RetMsg<PayData> prepay(PayInfo payInfo){

        String prepayUrl = "";

        String retData = HttpUtil.post(prepayUrl, JSONUtil.toJsonPrettyStr(payInfo));
        if(Strings.isNullOrEmpty(retData)){
            return RetMsg.empty();
        }

        RetMsg<PayData> retMsg   = JSONUtil.toBean(retData, new cn.hutool.core.lang.TypeReference<RetMsg<PayData>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        }, false);
        return retMsg;
    }


    //第二版,加业务语义：RequireSuccess  要求是成功的
    public static RetMsg<PayData> prepayRequireSuccess(PayInfo payInfo){
        String prepayUrl = "";

        String retData = HttpUtil.post(prepayUrl, JSONUtil.toJsonPrettyStr(payInfo));
        if(Strings.isNullOrEmpty(retData)){
            //LOGGER.error("prepay url={},params={} response is null",prepayUrl,payInfo);
            //alarm.        //报警
            throw new SdkException("prepay response should not be null or empty");
        }

        RetMsg<PayData> retMsg   = JSONUtil.toBean(retData, new TypeReference<RetMsg<PayData>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        }, false);

        if (retMsg.getRetNo()!=1000){   //1000是成功
            //LOGGER.error("prepay url={},params={} response is null",prepayUrl,payInfo);
            //alarm.        //报警
            throw new SdkException("prepay response faile");
        }

        return retMsg;
    }

    //第2.1版
    public static PayData prepayRequireSuccessForResp(PayInfo payInfo){
        RetMsg<PayData> retMsg = prepayRequireSuccess(payInfo);

        return retMsg.getData();
    }


    //第三版,带有业务处理的，比如登录 鉴权
    public static RetMsg<PayData> prepayRequireSuccessWithLogin(PayInfo payInfo,LoginInfo loginInfo) {
        RetMsg<LoginResponse> loginRetMsg = LoginSdk.login(loginInfo);
        LoginResponse loginResponse = loginRetMsg.getData();
        payInfo.setToken(loginResponse.getToken());
        return prepayRequireSuccess(payInfo);
    }


    //场景级别的一次分装，将刚才实现的prepay接口能力复制到submit，confirm，然后用三种单接口封装的能力
    public static RetMsg<PayData> pay(PayInfo payInfo,LoginInfo loginInfo){
        //1、prepay

        //2、submit

        //3、confirm

        return null;
    }
}
