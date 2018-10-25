package com.tyranny.limbochecker.conimpl;

import android.text.TextUtils;
import com.tyranny.limbochecker.R;
import com.tyranny.limbochecker.definition.IContentChecker;
import com.tyranny.limbochecker.util.RunUIToastUtils;

/**
 * Created by Tyranny on 2018/3/1 16:45.
 *
 * @version 1.0.0
 */

public class NonNullCondition extends BaseCondition {
    private boolean isShow = true;

    public NonNullCondition(boolean isShow) {
        this.isShow = isShow;
    }

    public NonNullCondition() {
    }

    @Override
    public boolean match(IContentChecker.MatchBody matchBody) {
        return !TextUtils.isEmpty(matchBody.getContent());
    }

    @Override
    public void showTips(IContentChecker.MatchBody matchBody) {
        if (isShow) {
            RunUIToastUtils.setToast(matchBody.getCx(), String.format("%s%s",
                    matchBody.getName(), matchBody.getCx().getString(R.string.str_not_null)));
        }
    }

    @Override
    public String getToast(IContentChecker.MatchBody matchBody) {
        return String.format("%s%s", matchBody.getName(), matchBody.getCx().getString(R.string.str_not_null));
    }
}
