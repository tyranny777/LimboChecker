package com.tyranny.limbochecker.util;

import android.content.Context;
import com.tyranny.limbochecker.bodyimpl.LimboMatchBody;
import com.tyranny.limbochecker.checkimpl.LimboChecker;
import com.tyranny.limbochecker.conimpl.BaseCondition;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tyranny on 2018/9/10 11:06.
 *
 * @version 1.0.0
 */
public class OverAllUtil {

    public static boolean checkAll(Context context, LinkedHashMap<Object, LinkedHashMap<BaseCondition, LimboMatchBody>> mapHashMap) {
        for (Map.Entry<Object, LinkedHashMap<BaseCondition, LimboMatchBody>> mapEntry : mapHashMap.entrySet()) {
            for (Map.Entry<BaseCondition, LimboMatchBody> entry : mapEntry.getValue().entrySet()) {
                LimboChecker checker = LimboChecker.get(entry.getValue());
                boolean checkResult = checker.addCondition(entry.getKey()).getCheckResult();
                String toast = entry.getKey().getToast(entry.getValue());
                RunUIToastUtils.setToast(context, toast);
                if (!checkResult) {
                    return false;
                }
            }
        }
        return true;
    }
}
