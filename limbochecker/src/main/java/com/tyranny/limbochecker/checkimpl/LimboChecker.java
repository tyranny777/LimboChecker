package com.tyranny.limbochecker.checkimpl;

import android.support.annotation.NonNull;
import com.tyranny.limbochecker.definition.ILimboChecker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyranny on 2018/3/1 16:35.
 *
 * @version 1.0.0
 */

public class LimboChecker implements ILimboChecker {
    private MatchBody body;
    private List<Condition> conditionList;

    private LimboChecker(MatchBody body) {
        this.body = body;
    }

    public static LimboChecker get(MatchBody matchBody) {
        return new LimboChecker(matchBody);
    }


    public LimboChecker addCondition(Condition condition) {
        if (conditionList == null) {
            conditionList = new ArrayList<>();
        }
        conditionList.add(condition);

        return this;
    }

    public LimboChecker addConditionList(ArrayList<Condition> conditions) {
        if (conditionList == null) {
            conditionList = new ArrayList<>();
        }
        conditionList.addAll(conditions);

        return this;
    }


    public boolean getCheckResult() {
        if (this.body == null || this.conditionList == null) {
            throw new NullPointerException("检查内容和条件不能为空");
        }
        return check(this.body, this.conditionList);
    }


    @Override
    public boolean check(@NonNull MatchBody body, @NonNull List<Condition> conditions) {

        for (Condition c : conditions) {
            if (!c.match(body)) {
                c.showTips(body);
                c.getToast(body);
                return false;
            }
        }
        return true;
    }

    public static Machine getCheckMachine(){
        return new Machine();
    }

    public static class Machine {

        private List<LimboChecker> checkerList;

        private Machine() {
            checkerList = new ArrayList<>();
        }

        public Machine putChecker(LimboChecker checker) {
            checkerList.add(checker);
            return this;
        }

        public boolean checkAll() {
            for (LimboChecker c : checkerList) {
                if (!c.getCheckResult()) {
                    return false;
                }
            }
            return true;
        }
    }

}
