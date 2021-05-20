package cakes.auto.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-03-28-22:10
 * Description：<描述>
 */
public class MapperUtils {
    public static <T> T mapToObject(Object map, Class<T> type){
        if(!(map instanceof Map)){
            throw new IllegalStateException("map type illegal.");
        }

        //强转，将Object转成Map对象，，这里就是原始的Map数据，注意 Map<String,Object> -》Object 有可能还是一个Map
        Map<String,Object> realMap = (Map<String,Object>) map;

        //Modifier 类提供了 static 方法和常量，对类和成员访问修饰符进行解码
        //getModifiers()：返回此类或接口以整数编码的 Java 语言修饰符
        //getDeclaredFields()：返回类对象表示的类或接口声明的所有字段的字段对象数组。这包括公共、受保护、默认（包）访问和专用字段，但不包括继承的字段。
        List<Field> fields = Arrays.stream(type.getDeclaredFields())
                .filter(field -> Modifier.isPrivate(field.getModifiers()))   //字段是private的
                .filter(field -> !Modifier.isFinal(field.getModifiers()))
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                //值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查
                .peek(field -> field.setAccessible(true))
                .collect(Collectors.toList());

        try {
            //Class.forName("")返回的是类
            // Class.forName("").newInstance()返回的是object
            T instance = type.newInstance();
            for (Field field:fields){
                //处理类型转化的问题，目前的问题是，从yml解析出来的数据看都是string，INteger，但是转到对象时会存在 String->Integer  Integer->String
                Object fieldValue = realMap.get(field.getName());   //yml文件里边的值

                if (Objects.isNull(fieldValue)){    //如果fieldValue是null，跳过
                    continue;
                }

                //循环递归
                if (simple_type_mapping.contains(field.getType().getName())){
                    field.set(instance,getFieldValueByType(fieldValue, field.getType()));
                } else{
                    field.set(instance,mapToObject(fieldValue, field.getType()));
                }

            }
            return instance;
         } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    //递归判断数据，是不是map还套着一个map
    private static final List<String> simple_type_mapping = Lists.newArrayList(
            "java.lang.Integer",
            "java.lang.String",
            "java.lang.Long",
            "java.lang.Boolean"
    );

    private static Object getFieldValueByType(Object fieldValue, Class<?> fileType){
        switch (fileType.getName()) {
            case "java.lang.Integer":
                return Integer.valueOf(fieldValue.toString());
            case "java.lang.String":
                return fieldValue.toString();
            case "java.lang.Long":
                return Long.valueOf(fieldValue.toString());
            case "java.lang.Boolean":
                return Boolean.valueOf(fieldValue.toString());
            default:
                throw new IllegalStateException("type havenot support");
        }
    }

    //setOrderId -> orderId
    private static String getPropertyName(String setMethodName){
        String bufName = StringUtils.substringAfterLast(setMethodName, "set");  //orderId
        //首字母大写转小写
        return bufName.substring(0,1).toLowerCase() + bufName.substring(1);
    }

    public static void main(String[] args) {
        String name = getPropertyName("setOrderdd");
        System.out.println(name);
    }
}
