package gaoyang;

public class HttpTest {
    public static void main(String[] args) {
        Http http = new Http();
        String url1 = "https://ingateway-test.19ego.cn/gaoyang/mfbizcore/ant/1.0/couponBill?biz_content="
                + "{\"trade_id\":\"";
        String url2 = "\",\"trade_time\":\"20180927191130\",\"user_id\":\"2088502773943190\","
                + "\"ext_msg\":\"jiayou\",\"merchant_id\":\"888888888001\",\"trade_type\":\"JF\"}";
        int x = 101905;
        for (int i = 0; i < 100; i++) {
            x = x + 1;
            String url = url1 + x + url2;
            http.httpURLConectionGET(url);
//      try {
//        Thread.sleep(7000);
//      } catch (InterruptedException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
        }
    }
}
