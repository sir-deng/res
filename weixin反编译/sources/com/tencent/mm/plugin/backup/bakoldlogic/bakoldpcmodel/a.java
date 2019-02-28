package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b;

public final class a extends d {
    private static a kvZ;
    private e kwa;
    private c kwb;
    private b kwc;

    public static a aqS() {
        if (kvZ == null) {
            com.tencent.mm.plugin.backup.a.a aVar = new a();
            kvZ = aVar;
            com.tencent.mm.plugin.backup.a.a.a(aVar);
        }
        return kvZ;
    }

    public final void aoN() {
        kvZ = null;
    }

    public final void j(Object... objArr) {
        Context context = (Context) objArr[0];
        aqS().aqV().aqW();
        b.clear();
        context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    }

    public final e aqT() {
        if (this.kwa == null) {
            this.kwa = new e();
        }
        return this.kwa;
    }

    public final c aqU() {
        if (this.kwb == null) {
            this.kwb = new c();
        }
        return this.kwb;
    }

    public final b aqV() {
        if (this.kwc == null) {
            this.kwc = new b();
        }
        return this.kwc;
    }

    public final void aoT() {
    }

    public final void aoU() {
    }
}
