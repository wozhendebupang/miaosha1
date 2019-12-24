package gaoyang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {
    public  static String GET_URL;
    //    public static final String POST_URL = "http://112.4.27.9/mall-back/if_user/store_list";
    // 妙兜测试接口
    public static final String POST_URL = "http://121.40.204.191:8180/mdserver/service/installLock";

    /**
     * 接口调用 GET
     */
    public void httpURLConectionGET(String GET_URL) {
        this.GET_URL = GET_URL;
        try {
            URL url = new URL(GET_URL);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }


            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
    }
}
