package com.smartsearchdocument.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SM3UtilTest {

    @Test
    void sign() {
    }

    @Test
    void check() {

        String sign = "d58d588d86ab07286e3662186cc154435df4274501e1979c74569a6ff4a6cad4";
        String data = "{\"username\":\"admin\",\"password\":\"12345678\"}";

        System.out.println(SM3Util.check(data, sign));
    }
}