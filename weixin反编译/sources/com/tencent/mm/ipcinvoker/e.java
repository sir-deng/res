package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import com.tencent.mm.loader.stub.d;
import junit.framework.Assert;

public final class e {
    public static Context gOj;
    private static String gOk;

    public static Context getContext() {
        Assert.assertNotNull("IPCInvoker not initialize.", gOj);
        return gOj;
    }

    public static boolean fj(String str) {
        return str != null && str.equals(BB());
    }

    public static String BB() {
        if (gOk == null || gOk.length() == 0) {
            gOk = d.r(gOj, Process.myPid());
        }
        return gOk;
    }
}
