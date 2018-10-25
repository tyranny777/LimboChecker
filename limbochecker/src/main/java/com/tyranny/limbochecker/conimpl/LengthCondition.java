package com.tyranny.limbochecker.conimpl;

import android.text.TextUtils;
import com.tyranny.limbochecker.definition.ILimboChecker;
import com.tyranny.limbochecker.util.RunUIToastUtils;

/**
 * Created by Tyranny on 2018/3/1 16:51.
 *
 * @version 1.0.0
 */

public class LengthCondition extends BaseCondition {
    private int length;
    private int lengthType = ILimboChecker.LengthType.PHONE;
    private boolean isShow = true;

    public LengthCondition(int length) {
        this.length = length;
    }

    public LengthCondition(int length, int lengthType) {
        this.length = length;
        this.lengthType = lengthType;
    }

    public LengthCondition(int length, int lengthType, boolean isShow) {
        this.length = length;
        this.lengthType = lengthType;
        this.isShow = isShow;
    }

    @Override
    public boolean match(ILimboChecker.MatchBody matchBody) {
        return !TextUtils.isEmpty(matchBody.getContent()) && matchBody.getContent().length() >= length;
    }

    @Override
    public void showTips(ILimboChecker.MatchBody matchBody) {
        switch (lengthType) {
            case ILimboChecker.LengthType.PHONE:
                if (isShow) {
                    RunUIToastUtils.setToast(matchBody.getCx(),matchBody.getName() + "长度不能少于" + length + "位");
                }
                break;
            case ILimboChecker.LengthType.INPUT_CONTENT:
                if (isShow) {
                    RunUIToastUtils.setToast(matchBody.getCx(),matchBody.getName() + "不能少于" + length + "个字");
                }
                break;
            case ILimboChecker.LengthType.CERT_CODE:
                if (isShow) {
                    RunUIToastUtils.setToast(matchBody.getCx(),matchBody.getName() + "长度不能少于" + length + "位");
                }
                break;
        }
    }

    @Override
    public String getToast(ILimboChecker.MatchBody matchBody) {
        switch (lengthType) {
            case ILimboChecker.LengthType.PHONE:
                return matchBody.getName() + "长度不能少于" + length + "位";

            case ILimboChecker.LengthType.INPUT_CONTENT:
                return matchBody.getName() + "不能少于" + length + "个字";

            case ILimboChecker.LengthType.CERT_CODE:
                return matchBody.getName() + "长度不能少于" + length + "位";

        }
        return "位数不足";
    }
}
