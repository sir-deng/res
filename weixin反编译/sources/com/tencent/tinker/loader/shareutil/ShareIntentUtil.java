package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;

public class ShareIntentUtil {
    public static void a(Intent intent, int i) {
        intent.putExtra("intent_return_code", i);
    }

    public static int ar(Intent intent) {
        return p(intent, "intent_return_code");
    }

    public static void a(Intent intent, long j) {
        intent.putExtra("intent_patch_cost_time", j);
    }

    public static long as(Intent intent) {
        return intent.getLongExtra("intent_patch_cost_time", 0);
    }

    public static Throwable at(Intent intent) {
        Serializable o = o(intent, "intent_patch_exception");
        if (o != null) {
            return (Throwable) o;
        }
        return null;
    }

    public static Throwable au(Intent intent) {
        Serializable o = o(intent, "intent_patch_interpret_exception");
        if (o != null) {
            return (Throwable) o;
        }
        return null;
    }

    public static HashMap<String, String> av(Intent intent) {
        Serializable o = o(intent, "intent_patch_dexes_path");
        if (o != null) {
            return (HashMap) o;
        }
        return null;
    }

    public static HashMap<String, String> aw(Intent intent) {
        Serializable o = o(intent, "intent_patch_libs_path");
        if (o != null) {
            return (HashMap) o;
        }
        return null;
    }

    public static HashMap<String, String> ax(Intent intent) {
        Serializable o = o(intent, "intent_patch_package_config");
        if (o != null) {
            return (HashMap) o;
        }
        return null;
    }

    public static String j(Intent intent, String str) {
        String str2 = null;
        if (intent == null) {
            return str2;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e) {
            new StringBuilder("getStringExtra exception:").append(e.getMessage());
            return str2;
        }
    }

    public static Serializable o(Intent intent, String str) {
        Serializable serializable = null;
        if (intent == null) {
            return serializable;
        }
        try {
            return intent.getSerializableExtra(str);
        } catch (Exception e) {
            new StringBuilder("getSerializableExtra exception:").append(e.getMessage());
            return serializable;
        }
    }

    private static int p(Intent intent, String str) {
        int i = -10000;
        if (intent == null) {
            return i;
        }
        try {
            return intent.getIntExtra(str, -10000);
        } catch (Exception e) {
            new StringBuilder("getIntExtra exception:").append(e.getMessage());
            return i;
        }
    }

    public static boolean q(Intent intent, String str) {
        boolean z = false;
        if (intent == null) {
            return z;
        }
        try {
            return intent.getBooleanExtra(str, false);
        } catch (Exception e) {
            new StringBuilder("getBooleanExtra exception:").append(e.getMessage());
            return z;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Intent r2, java.lang.ClassLoader r3) {
        /*
        r0 = android.content.Intent.class;
        r1 = "mExtras";
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.d(r0, r1);	 Catch:{ Throwable -> 0x001d, all -> 0x0022 }
        r0 = r1.get(r2);	 Catch:{ Throwable -> 0x001d, all -> 0x0022 }
        r0 = (android.os.Bundle) r0;	 Catch:{ Throwable -> 0x001d, all -> 0x0022 }
        if (r0 != 0) goto L_0x0019;
    L_0x0011:
        r0 = new android.os.Bundle;	 Catch:{ Throwable -> 0x001d, all -> 0x0022 }
        r0.<init>();	 Catch:{ Throwable -> 0x001d, all -> 0x0022 }
        r1.set(r2, r0);	 Catch:{ Throwable -> 0x001d, all -> 0x0022 }
    L_0x0019:
        r2.setExtrasClassLoader(r3);
    L_0x001c:
        return;
    L_0x001d:
        r0 = move-exception;
        r2.setExtrasClassLoader(r3);
        goto L_0x001c;
    L_0x0022:
        r0 = move-exception;
        r2.setExtrasClassLoader(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareIntentUtil.a(android.content.Intent, java.lang.ClassLoader):void");
    }
}
