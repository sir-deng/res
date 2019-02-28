package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private WebView tCV;
    private Map<String, a> tEf;
    private JsapiPermissionWrapper tEg;
    private GeneralControlWrapper tEh;
    private final JsapiPermissionWrapper tEi = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper tEj = GeneralControlWrapper.vHw;
    private int[] tEk;
    private int[] tEl;

    private static class a {
        public JsapiPermissionWrapper tEm;
        public GeneralControlWrapper tEn;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.tEm = jsapiPermissionWrapper;
            this.tEn = generalControlWrapper;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.tEm);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.tEn);
            return stringBuilder.toString();
        }
    }

    public e(Activity activity, WebView webView) {
        int i;
        this.tEg = (JsapiPermissionWrapper) activity.getIntent().getParcelableExtra("hardcode_jspermission");
        if (r.ifI == null || r.ifI.length() == 0) {
            x.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = bi.getInt(r.ifI, 0);
                if (i < 0) {
                    x.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.tEg = new JsapiPermissionWrapper(i);
                    x.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.tEg);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.tEg = null;
            }
        }
        this.tEh = (GeneralControlWrapper) activity.getIntent().getParcelableExtra("hardcode_general_ctrl");
        if (r.ifJ == null || r.ifJ.length() == 0) {
            x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(bi.getInt(r.ifJ, 0)));
                xm xmVar = new xm();
                xmVar.woy = i;
                this.tEh = new GeneralControlWrapper(xmVar);
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", e2.getMessage());
                this.tEh = null;
            }
            x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.tEh);
        }
        x.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.tEg + ", hardcodeGenCtrl = " + this.tEh);
        this.tCV = webView;
        this.tEf = new HashMap();
        this.tEk = activity.getIntent().getIntArrayExtra("jsapi_blacklist");
        this.tEl = activity.getIntent().getIntArrayExtra("jsapi_whitelist");
        if (!(this.tEk == null || this.tEk.length <= 0 || this.tEg == null)) {
            x.i("MicroMsg.WebViewPermission", "albie: setBlacklist jsapi(%s).", this.tEk);
            this.tEg.n(this.tEk);
        }
        if (this.tEl != null && this.tEl.length > 0 && this.tEg != null) {
            x.i("MicroMsg.WebViewPermission", "albie: setWhitelist jsapi(%s).", this.tEl);
            this.tEg.o(this.tEl);
        }
    }

    public final void b(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (bi.oN(str)) {
            x.e("MicroMsg.WebViewPermission", "update fail, url is null");
            return;
        }
        String Cv = Cv(str);
        if (jsapiPermissionWrapper == null) {
            jsapiPermissionWrapper = this.tEi;
        }
        if (generalControlWrapper == null) {
            generalControlWrapper = this.tEj;
        }
        if (this.tEk != null && this.tEk.length > 0) {
            x.i("MicroMsg.WebViewPermission", "albie: update setBlacklist jsapi(%s).", this.tEk);
            jsapiPermissionWrapper.n(this.tEk);
        }
        if (this.tEl != null && this.tEl.length > 0) {
            x.i("MicroMsg.WebViewPermission", "albie: update setWhitelist jsapi(%s).", this.tEl);
            jsapiPermissionWrapper.o(this.tEl);
        }
        x.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + Cv);
        this.tEf.put(Cv, new a(jsapiPermissionWrapper, generalControlWrapper));
    }

    public final boolean has(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.WebViewPermission", "has fail, url is null");
            return false;
        }
        a aVar = (a) this.tEf.get(Cv(str));
        return (aVar == null || aVar.tEm == this.tEi || aVar.tEn == this.tEj) ? false : true;
    }

    public final JsapiPermissionWrapper bTf() {
        if (this.tEg != null) {
            x.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.tEg);
            return this.tEg;
        }
        return PN(this.tCV == null ? null : this.tCV.getUrl());
    }

    public final JsapiPermissionWrapper PN(String str) {
        if (this.tEg != null) {
            x.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.tEg);
            return this.tEg;
        } else if (bi.oN(str)) {
            x.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = " + str);
            return this.tEi;
        } else {
            String Cv = Cv(str);
            if (this.tEf == null) {
                x.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                return this.tEi;
            }
            a aVar = (a) this.tEf.get(Cv);
            return aVar == null ? this.tEi : aVar.tEm;
        }
    }

    public final GeneralControlWrapper bTg() {
        Object obj = null;
        if (this.tEh != null) {
            x.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.tEh);
            return this.tEh;
        }
        String url;
        if (this.tCV != null) {
            url = this.tCV.getUrl();
            if (!bi.oN(url)) {
                String Cv = Cv(url);
                a aVar = (a) this.tEf.get(Cv);
                String str = "MicroMsg.WebViewPermission";
                StringBuilder stringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
                if (aVar != null) {
                    obj = aVar.tEn;
                }
                x.i(str, stringBuilder.append(obj).append(", url = ").append(Cv).toString());
                return aVar == null ? this.tEj : aVar.tEn;
            }
        } else {
            url = null;
        }
        x.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = " + url);
        return this.tEj;
    }

    public final void detach() {
        x.i("MicroMsg.WebViewPermission", "detach");
        this.tEf.clear();
        this.tEf = null;
        this.tCV = null;
    }

    private static String Cv(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
