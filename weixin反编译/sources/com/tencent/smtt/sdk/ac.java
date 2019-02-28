package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

final class ac {
    protected DexLoader Ain = null;

    public ac(DexLoader dexLoader) {
        this.Ain = dexLoader;
    }

    public final void a(Object obj, Activity activity, int i) {
        Object obj2 = obj;
        this.Ain.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    public final boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod = this.Ain.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        return invokeMethod instanceof Boolean ? ((Boolean) invokeMethod).booleanValue() : false;
    }

    public final Object hy(Context context) {
        return this.Ain.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.Ain.getClassLoader());
    }
}
