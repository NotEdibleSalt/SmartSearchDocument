package com.smartsearchdocument.util;

import com.antherd.smcrypto.sm3.Sm3;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * sm3工具类
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SM3Util {

    public static String sign(String data) {

        return Sm3.sm3(data);
    }

    public static boolean check(String data, String sign) {

        String sm3 = Sm3.sm3(data);

        return sm3.equals(sign);
    }

}
