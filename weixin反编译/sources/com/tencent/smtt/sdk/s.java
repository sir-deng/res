package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;

final class s {
    public boolean AgQ;
    public boolean AgR;
    private Map<String, String> AgS;

    public s() {
        this.AgQ = false;
        this.AgR = false;
        this.AgS = null;
        this.AgS = new HashMap();
    }

    public final synchronized void ax(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.AgS.put(str, String.valueOf(j));
        }
    }

    public final synchronized void b(String str, byte b) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            if (b == (byte) 1) {
                str2 = "_begin";
            } else if (b == (byte) 2) {
                str2 = "_end";
            }
            this.AgS.put(str + str2, String.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized boolean bh(int i, String str) {
        boolean z = true;
        synchronized (this) {
            af cFZ = af.cFZ();
            if (!cFZ.cGa()) {
                z = false;
            } else if ((this.AgR && this.AgQ) || System.currentTimeMillis() % 10 == 0) {
                this.AgR = true;
                this.AgQ = true;
                this.AgS.put("is_first_init_tbs", String.valueOf(this.AgR));
                this.AgS.put("is_first_init_x5", String.valueOf(this.AgQ));
                this.AgS.put("x5_webview_id", Integer.toString(i));
                this.AgS.put("current_url", str);
                if (QbSdk.Afs != null && QbSdk.Afs.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
                    this.AgS.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, QbSdk.Afs.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID));
                }
                cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[]{Integer.TYPE, Map.class}, Integer.valueOf(i), this.AgS);
            }
        }
        return z;
    }
}
