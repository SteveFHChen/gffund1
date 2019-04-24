package com.ycnet.dbank.util.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 用于提供用户密码生成匹配
 * User: guozp
 * Date: 14-4-3
 * Time: 下午1:43
 */
public class EncryptUtil {

    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
