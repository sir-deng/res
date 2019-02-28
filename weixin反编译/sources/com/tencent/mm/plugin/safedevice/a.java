package com.tencent.mm.plugin.safedevice;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;

public final class a implements p {
    public static n ihN;
    private static m ihO;

    public final void a(n nVar) {
        ihN = nVar;
    }

    public final void a(m mVar) {
        ihO = mVar;
    }

    public static void a(Context context, Intent intent, Intent intent2) {
        ihN.a(context, intent, intent2);
    }
}
