package com.tyranny.limbochecker.util;

import android.content.Context;
import com.tyranny.limbochecker.bodyimpl.ContentMatchBody;
import com.tyranny.limbochecker.checkimpl.ContentChecker;
import com.tyranny.limbochecker.conimpl.BaseCondition;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tyranny on 2018/9/10 11:06.
 * <p>
 * <p>
 * <p>
 * <p>
 * NonNullCondition noNull = new NonNullCondition(false);
 * ContentMatchBody name = new ContentMatchBody("name",
 * editText1.getText().toString().trim());
 * <p>
 * ContentMatchBody IDcard = new ContentMatchBody("idcard",
 * editText2.getText().toString().trim());
 * <p>
 * LinkedHashMap<TextInputLayout, LinkedHashMap<BaseCondition, ContentMatchBody>> mapHashMap = new LinkedHashMap<>();
 * <p>
 * LinkedHashMap<BaseCondition, ContentMatchBody> map3 = new LinkedHashMap<>();
 * map3.put(noNull, name);
 * <p>
 * LinkedHashMap<BaseCondition, ContentMatchBody> map2 = new LinkedHashMap<>();
 * map2.put(noNull, IDcard);
 * <p>
 * mapHashMap.put(editText1, map3);
 * mapHashMap.put(editText2, map2);
 * <p>
 * OverAllUtil.checkAll(mapHashMap);
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
