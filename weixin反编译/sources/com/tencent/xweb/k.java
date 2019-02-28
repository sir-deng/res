package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.h;
import com.tencent.xweb.g.a;
import org.xwalk.core.XWalkEnvironment;

public final class k {
    private static k Azq = null;
    public Context Azr;
    c Azs = c.WV_KIND_NONE;
    public boolean Azt = false;
    public boolean Azu = false;
    public boolean Azv = false;
    public a Azw = a.RT_TYPE_AUTO;
    public boolean Azx = false;
    String Azy = "";

    public static void iS(Context context) {
        boolean z = false;
        if (Azq == null) {
            k kVar = new k();
            Azq = kVar;
            kVar.Azr = context;
            XWalkEnvironment.init(context);
            Azq.Azu = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
            String string = context.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
            try {
                Azq.Azw = a.valueOf(string);
            } catch (Exception e) {
            }
            Azq.Azt = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
            string = XWalkEnvironment.getTestDownLoadUrl(context);
            k kVar2 = Azq;
            if (!(string == null || string.isEmpty())) {
                z = true;
            }
            kVar2.Azx = z;
        }
    }

    public static k cJh() {
        return Azq;
    }

    public final c acY(String str) {
        if (this.Azy.equals(str)) {
            return this.Azs;
        }
        if (str == null || str.isEmpty() || this.Azr == null) {
            return c.WV_KIND_NONE;
        }
        this.Azy = str;
        SharedPreferences sharedPreferences = this.Azr.getSharedPreferences("wcwebview", 0);
        if (sharedPreferences == null) {
            return c.WV_KIND_NONE;
        }
        String string = sharedPreferences.getString("HardCodeWebView" + str, "");
        if (string == null || string.isEmpty() || string.equals(c.WV_KIND_NONE.toString())) {
            string = sharedPreferences.getString("ABTestWebView" + str, "");
        }
        if (string == null || string.isEmpty()) {
            this.Azs = c.WV_KIND_NONE;
        } else {
            try {
                this.Azs = c.valueOf(string);
            } catch (Exception e) {
                this.Azs = c.WV_KIND_NONE;
            }
        }
        return this.Azs;
    }

    public final void a(String str, c cVar) {
        if (this.Azr != null && str != null && !str.isEmpty()) {
            this.Azy = str;
            this.Azs = cVar;
            this.Azr.getSharedPreferences("wcwebview", 0).edit().putString("HardCodeWebView" + str, cVar.toString()).commit();
        }
    }

    public final void oi(boolean z) {
        if (z != this.Azt) {
            this.Azt = z;
            XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", z).commit();
        }
    }

    public final void oj(boolean z) {
        if (z != this.Azv) {
            this.Azv = z;
            this.Azr.getSharedPreferences("wcwebview", 0).edit().putBoolean("m_bShowAbstract", this.Azv).commit();
        }
    }

    public final void a(a aVar) {
        if (this.Azw != aVar) {
            this.Azw = aVar;
            this.Azr.getSharedPreferences("wcwebview", 0).edit().putString("V8type", aVar.toString()).commit();
        }
    }

    public final void ok(boolean z) {
        if (z != this.Azx) {
            this.Azx = z;
            Editor edit;
            if (this.Azx) {
                XWalkEnvironment.setTestDownLoadUrl(this.Azr, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
                edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
                edit.putLong("nLastFetchConfigTime", 0);
                edit.commit();
                h.a(c.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
                return;
            }
            XWalkEnvironment.setTestDownLoadUrl(this.Azr, "");
            edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            h.a(c.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
        }
    }
}
