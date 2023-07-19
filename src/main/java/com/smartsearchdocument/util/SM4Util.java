package com.smartsearchdocument.util;

import com.antherd.smcrypto.sm4.Sm4;
import com.antherd.smcrypto.sm4.Sm4Options;

/**
 * sm4工具类
 */
public class SM4Util {

    private static final String key = "6k2w45t7v9sb3dgff2dcbay84w5g36kn";
    private SM4Util() {}


    public static String encrypt(String data) {

        return Sm4.encrypt(data, key);

    }

    public static String decrypt(String data) {

        return Sm4.decrypt(data, key);
    }


}
