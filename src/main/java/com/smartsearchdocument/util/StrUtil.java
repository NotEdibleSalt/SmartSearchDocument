package com.smartsearchdocument.util;


/**
 * 字符串工具类
 */
public class StrUtil {

    private StrUtil() {}

    public static boolean isBlank(CharSequence str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; ++i) {
                if (!isBlankChar(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == 65279 || c == 8234 || c == 0 || c == 12644 || c == 10240 || c == 6158;
    }


    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    public static boolean hasBlank(CharSequence... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        } else {
            for (CharSequence str : strs) {
                if (isBlank(str)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isAllBlank(CharSequence... strs) {
        if (CollUtil.isEmpty(strs)) {
            return true;
        } else {
            for (CharSequence str : strs) {
                if (isNotBlank(str)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }


    public static boolean hasEmpty(CharSequence... strs) {
        if (CollUtil.isEmpty(strs)) {
            return true;
        } else {

            for (CharSequence str : strs) {
                if (isEmpty(str)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isAllEmpty(CharSequence... strs) {
        if (CollUtil.isEmpty(strs)) {
            return true;
        } else {
            for (CharSequence str : strs) {
                if (isNotEmpty(str)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAllNotEmpty(CharSequence... args) {
        return !hasEmpty(args);
    }

    public static boolean isAllNotBlank(CharSequence... args) {
        return !hasBlank(args);
    }


}
