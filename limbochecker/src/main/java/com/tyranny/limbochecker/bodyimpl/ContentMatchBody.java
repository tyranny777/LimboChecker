package com.tyranny.limbochecker.bodyimpl;


import android.content.Context;
import com.tyranny.limbochecker.definition.IContentChecker;

/**
 * Created by Tyranny on 2018/3/1 16:32.
 *
 * @version 1.0.0
 */

public class ContentMatchBody implements IContentChecker.MatchBody {

    private String name;
    private String content;
    private Context context;

    public ContentMatchBody(Context context,String name, String content) {
        this.name = name;
        this.content = content;
        this.context = context;
    }


    @Override
    public CharSequence getName() {
        return name;
    }

    @Override
    public CharSequence getContent() {
        return content;
    }

    @Override
    public Context getCx() {
        return context;
    }
}
