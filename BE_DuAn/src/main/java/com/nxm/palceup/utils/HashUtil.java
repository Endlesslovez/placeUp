package com.nxm.palceup.utils;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class HashUtil {
    public static String hash(String plain) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(plain, salt);
    }

    //plain: chuoi ng dung nhap
    // hashed:  chuoi ky tu ma hoa luu trong db
    public static boolean verify(String plain, String hashed) {
        return BCrypt.checkpw(plain, hashed);
        //kiem tra hai chuỗi này có khớp với nhau k
    }
}
