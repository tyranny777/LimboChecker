package com.tyranny.limbochecker.definition;

import android.content.Context;

import java.util.List;

/**
 * Created by Tyranny on 2018/3/1 16:27.
 *
 * @version 1.0.0
 */

public interface IContentChecker {
    interface Condition {
        boolean match(MatchBody matchBody);

        void showTips(MatchBody matchBody);

        String getToast(MatchBody matchBody);
    }

    interface MatchBody {
        CharSequence getName();

        CharSequence getContent();

        Context getCx();
    }

    boolean check(MatchBody matchBody, List<Condition> conditionList);

    interface LengthType {
        int PHONE = 1;
        int INPUT_CONTENT = 2;
        int CERT_CODE = 3;
    }

    interface InputBodyType{
        int PHONE = 1;
        int NAME = 2;
        int CODE = 3;
        int CONTENT = 4;
    }

    interface InputSouceType{
        int CHECK_INPUT_STR = 3;
        int CHECK_INPUT_INT = 1;
        int CHECK_INPUT_ENG = 2;
        int CHECK_INPUT_OTHER = 999;
    }
}
