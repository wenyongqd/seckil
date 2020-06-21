package com.codemaster.seckil.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "springboot";

    //对应第一次前端加盐
    public static String inputToForm(String inputpass) {
        String str = inputpass + salt;
        return md5(str);
    }
    //对应第二次加盐
    public static String formToDB(String formPass, String dbSalt) {
        String str = dbSalt + formPass;
        return md5(str);
    }

    public static String inputToDb(String inputPass, String dbSalt) {
        String formPass = inputToForm(inputPass);
        String dbPass = formToDB(formPass, dbSalt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputToDb("123456","Alex"));
    }

}
