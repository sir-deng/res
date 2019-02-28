package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import java.util.Map;

final class aa {
    private Context Aij = null;
    private Context Aik = null;
    private String Ail = null;
    private String[] Aim = null;
    DexLoader Ain = null;
    private String Aio = "TbsDexOpt";
    private String Aip = null;

    public aa(Context context, Context context2, String str, String str2, String[] strArr, String str3, s sVar) {
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && x.cFJ() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        Object invokeStaticMethod;
        int i;
        this.Aij = context.getApplicationContext();
        this.Aik = context2;
        this.Ail = str;
        this.Aim = strArr;
        this.Aio = str2;
        if (sVar != null) {
            sVar.b("load_tbs_dex", (byte) 1);
        }
        this.Ain = new DexLoader(str3, this.Aij, this.Aim, str2, QbSdk.Afs);
        if (sVar != null) {
            sVar.b("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.Ail);
        if ("com.nd.android.pandahome2".equals(this.Aij.getApplicationInfo().packageName)) {
            this.Ain.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.Aij);
        }
        if (QbSdk.Afs != null) {
            this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.Afs);
        }
        if (sVar != null) {
            sVar.b("init_tbs", (byte) 1);
        }
        this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, context, c.bjM, c.Aju, c.Ajv, c.bpq);
        if (this.Aik != null || x.cFJ() == null) {
            invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.Aik, this.Ain, this.Ail, this.Aio, "3.6.0.1140", Integer.valueOf(43603), QbSdk.cEK());
        } else {
            invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.Aik, this.Ain, this.Ail, this.Aio, "3.6.0.1140", Integer.valueOf(43603), QbSdk.cEK(), x.cFJ());
        }
        if (invokeStaticMethod == null) {
            this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, "3.6.0.1140");
            this.Ain.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43603));
            invokeStaticMethod = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.Aik, this.Ain, this.Ail, this.Aio);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            m.cEY().a(this.Aij, 328, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.Aip = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.Aip = (String) invokeStaticMethod2;
            }
        } else {
            this.Aip = null;
        }
        if (sVar != null) {
            sVar.b("init_tbs", (byte) 2);
        }
        if (i < 0) {
            throw new Exception("TbsWizard init error: " + i + "; msg: " + this.Aip);
        }
        TbsLog.i("TbsWizard", "construction end...");
    }
}
