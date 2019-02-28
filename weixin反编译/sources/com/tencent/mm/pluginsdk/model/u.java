package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.v.a;

public abstract class u {
    public abstract boolean RV(String str);

    public abstract String Wp();

    public abstract String bYX();

    public abstract a bYY();

    public abstract boolean ed(Context context);

    public boolean w(Context context, Intent intent) {
        return false;
    }

    public String a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
