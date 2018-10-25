package com.tyranny.limbochecker.conimpl;

import android.text.TextUtils;
import com.tyranny.limbochecker.definition.ILimboChecker;
import com.tyranny.limbochecker.util.RunUIToastUtils;

/**
 * Created by Tyranny on 2018/3/2 16:49.
 *
 * @version 1.0.0
 */

public class ValidatePhoneCondition extends BaseCondition {
    private int length = 11;
    private boolean isShow = true;

    public ValidatePhoneCondition(int length, boolean isShow) {
        this.length = length;
        this.isShow = isShow;
    }

    public ValidatePhoneCondition() {
        this.length = 11;
    }

    @Override
    public boolean match(ILimboChecker.MatchBody matchBody) {
        CharSequence content = matchBody.getContent();
        content = content.toString().replaceAll(" ", "");
        content = content.toString().replaceAll("-", "");
        content = content.toString().replaceAll("\n", "");
        content = content.toString().replaceAll("\r", "");
        content = content.toString().replaceAll("\t", "");
        return !TextUtils.isEmpty(content) && content.length() >= length
                && validatePhoneNumber(content.toString());
    }

    @Override
    public void showTips(ILimboChecker.MatchBody matchBody) {
        if (isShow) {
            RunUIToastUtils.setToast(matchBody.getCx(), "请输入正确格式手机号码");
        }
    }

    @Override
    public String getToast(ILimboChecker.MatchBody matchBody) {
        return "请输入正确格式手机号码";
    }


    public static boolean validatePhoneNumber(String mobiles) {
        String telRegex = "^((1[3-9][0-9]))\\d{8}$";
        boolean matches = mobiles.matches(telRegex);
        return !TextUtils.isEmpty(mobiles) && matches;
    }
}
