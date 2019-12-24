package com.zjy.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 本类用于实现MD5加密
 */
public class MD5Util {

    /**
     * 本方法用于实现加密
     * @param str
     * @return
     */
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    /**
     * 定义一个用于加密的串
     */
    public static final String salt = "1a2b3c4d";

    /**
     * 传入需要 加密的用户的输入的密码，然后截取加密串的部分，和用户输入的密码进行拼接，拼接后进行md5加密，然后在服务端使用
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 将在服务端使用的已经进行过加密的用户密码，再次拼接加密串，然后放入数据库中
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass, String salt){
        String str = ""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 整合服务端加密方法和数据库加密方法，直接将用户输入的密码，进行加密，然后放入数据库中
     * @param inputPass
     * @param salt
     * @return
     */
    public static String inputPassToDBPass(String inputPass, String salt){
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, salt);
        return dbPass;
    }

    /**
     * 输入 的密码123456，进行两次md5加密后，放入数据库中的应该是  b7797cce01b4b131b433b6acf4add449
     * 加密串salt是1a2b3c4d
      */
//    public static void main(String[] args) {
//        String str = inputPassToDBPass("123456", "1a2b3c4d");
//        System.out.println(str);
//    }
}
