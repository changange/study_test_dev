package cakes.auto.driver;

/**
 * Author：耿常安
 * Date：2021-03-27-10:00
 * Description： 异常栈处理
 */
public class TestDemo {
    public static void main(String[] args) {
        try {
            test();
        }catch (Exception e){
            //e.printStackTrace();

            StringBuilder builder = new StringBuilder();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element:stackTrace){
                builder.append(element.getClassName())
                        .append("，")
                        .append(element.getMethodName())
                        .append("，")
                        .append(element.getFileName()); //哪个文件的异常
            }
            builder.append("\n");
            System.out.println("TestDemo.main=" + builder);
        }
    }

    private static void test() {
        int a= 1/0;
    }
}
