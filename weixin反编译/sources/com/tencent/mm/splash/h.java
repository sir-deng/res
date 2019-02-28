package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.mm.blink.a;
import java.lang.reflect.Field;

final class h extends Instrumentation {
    public Instrumentation xuz;

    public h(Instrumentation instrumentation) {
        this.xuz = instrumentation;
        cis();
    }

    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        a.ef(str);
        Activity newActivity;
        if (!e.cid() || e.cik().getCanonicalName().equals(str)) {
            newActivity = super.newActivity(classLoader, str, intent);
            if (!g.cir()) {
                return newActivity;
            }
            e.a("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
            intent.putExtra("splash-hack-activity-recreate", true);
            return newActivity;
        }
        newActivity = new f();
        newActivity.xul = str;
        e.a("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", str);
        e.xtQ.add(newActivity);
        return newActivity;
    }

    private void cis() {
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields[i].set(this, declaredFields[i].get(this.xuz));
        }
    }
}
