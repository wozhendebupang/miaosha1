package gaoyang;
public class AA {
    public static void main(String[] args) {
        String phoneNum = "17822212942";
        System.out.println("主账户库下标：" + Long.valueOf(phoneNum) % 32);
        System.out.println("主账户表下标main_account_" + Long.valueOf(phoneNum) % 128);
        System.out.println("主账户流水表下标main_account_balance" + Long.valueOf(phoneNum) % 1024);
    }
}
