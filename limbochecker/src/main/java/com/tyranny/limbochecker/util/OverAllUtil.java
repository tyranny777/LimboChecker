package com.tyranny.limbochecker.util;

import android.content.Context;
import com.tyranny.limbochecker.bodyimpl.ContentMatchBody;
import com.tyranny.limbochecker.checkimpl.ContentChecker;
import com.tyranny.limbochecker.conimpl.BaseCondition;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tyranny on 2018/9/10 11:06.
 *
 * @version 1.0.0
 */
public class OverAllUtil {

    public static boolean checkAll(Context context, LinkedHashMap<Object, LinkedHashMap<BaseCondition, ContentMatchBody>> mapHashMap) {
        for (Map.Entry<Object, LinkedHashMap<BaseCondition, ContentMatchBody>> mapEntry : mapHashMap.entrySet()) {
            for (Map.Entry<BaseCondition, ContentMatchBody> entry : mapEntry.getValue().entrySet()) {
                ContentChecker checker = ContentChecker.get(entry.getValue());
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
