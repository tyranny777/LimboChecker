package com.tyranny.limbochecker.definition;


import com.tyranny.limbochecker.bodyimpl.LimboMatchBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyranny on 2018/3/23 11:33.
 *
 * @version 1.0.0
 */

public class ContentUtil {
    private static final String REGEX_ENG_ZH = "[^a-zA-Z\u4E00-\u9FA5]";
    public static final String REGEX_ALL = "[^a-zA-Z0-9\u4E00-\u9FA5]";
    public static final String REGEX_ZH = "[^\u4E00-\u9FA5]";
    public static final String REGEX_INTEGER = "[0-9]*";
    public static final String REGEX_ENGLISH = "[a-zA-Z]*";
    public static final String REGEX_CHINESE = "[\u4e00-\u9fa5]*";

    public static String xBody(LimboMatchBody body, int checkType) {
        String bodyS = body.getContent().toString().trim();
        bodyS = bodyS.replaceAll(" ", "");
        bodyS = bodyS.replaceAll("-", "");
        bodyS = bodyS.replaceAll("\n", "");
        bodyS = bodyS.replaceAll("\r", "");
        bodyS = bodyS.replaceAll("\t", "");
        return bodyS;
    }

    private static String getString(String bodyS, int type) {
        for (String s : bodyS.split("")) {
            if (checkInput(s) != type) {
                bodyS = bodyS.replace(s, "");
            }
        }
        return bodyS;
    }

    private static int checkInput(String txt) {
        Pattern p = Pattern.compile(REGEX_INTEGER);
        Matcher m = p.matcher(txt);
        if (m.matches()) {
            return ILimboChecker.InputSouceType.CHECK_INPUT_INT;
        }
        p = Pattern.compile(REGEX_ENGLISH);
        m = p.matcher(txt);
        if (m.matches()) {
            return ILimboChecker.InputSouceType.CHECK_INPUT_ENG;
        }
        p = Pattern.compile(REGEX_CHINESE);
        m = p.matcher(txt);
        if (m.matches()) {
            return ILimboChecker.InputSouceType.CHECK_INPUT_STR;
        }

        return ILimboChecker.InputSouceType.CHECK_INPUT_OTHER;
    }
}
