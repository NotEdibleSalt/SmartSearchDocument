package com.smartsearchdocument.util;


import org.junit.jupiter.api.Test;

class SM4UtilTest {

    @Test
    void encrypt() {

        String data = "aaa";
        String encrypt = SM4Util.encrypt(data);

        System.out.println(encrypt);
    }

    @Test
    void decrypt() {

        String data = "24ed201a2f546db952593db1b93c5e06";
        String decrypt = SM4Util.decrypt(data);
        System.out.println(decrypt);
        assert  "aaa".equals(decrypt);
    }
}