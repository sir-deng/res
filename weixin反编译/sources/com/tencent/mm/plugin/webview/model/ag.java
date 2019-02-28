package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.m;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ag {
    private int tyV = -1;
    public ArrayList<String> tyW = new ArrayList();
    public ArrayList<String> tyX = new ArrayList();
    public List<Integer> tyY = new ArrayList();
    public final Map<String, Boolean> tyZ = new HashMap();
    public final Set<String> tza = new HashSet();
    public String tzb = null;

    public final m a(String str, boolean z, d dVar) {
        if (bi.oN(str)) {
            x.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (str.startsWith("weixin://bridge.js")) {
            return b(dVar);
        } else {
            if (str.startsWith("weixin://resourceid/")) {
                x.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
                try {
                    return new m("image/*", ProtocolPackage.ServerEncoding, ai.OY(dVar.cB(str, 1)));
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", e.getMessage());
                    return null;
                }
            }
            if (z) {
                int intValue;
                if (!bi.oN(str) && p.vf(str)) {
                    String toLowerCase = str.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains("::1") || toLowerCase.contains(s.cdD())) {
                        if (this.tyY != null && this.tyY.size() > 0) {
                            for (Integer intValue2 : this.tyY) {
                                intValue = intValue2.intValue();
                                if (!toLowerCase.contains("localhost:" + intValue)) {
                                    if (toLowerCase.contains("127.0.0.1:" + intValue)) {
                                    }
                                }
                                x.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", toLowerCase, Integer.valueOf(intValue));
                            }
                        }
                        x.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", toLowerCase);
                        intValue = 1;
                    }
                    intValue = 0;
                    break;
                }
                intValue = 0;
                if (intValue != 0) {
                    x.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", str);
                    return new m("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                }
            }
            if (!b(str, dVar)) {
                return null;
            }
            x.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", str);
            return new m("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
        }
    }

    private boolean b(String str, d dVar) {
        Iterator it;
        if (this.tyV == -1) {
            try {
                Bundle e = dVar.e(31, null);
                if (e != null) {
                    this.tyV = e.getInt("webview_ad_intercept_control_flag");
                    this.tyW = e.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.tyX = e.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("white domain list :\n");
                    it = this.tyW.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    stringBuilder.append("black list domain list : \n");
                    it = this.tyX.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    x.i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", e2.getMessage());
                this.tyV = 0;
            }
        }
        if (this.tyV == 0) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        x.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", host, this.tyZ.get(host));
        if (bi.oN(host)) {
            return false;
        }
        if (this.tyZ.containsKey(host)) {
            return ((Boolean) this.tyZ.get(host)).booleanValue();
        }
        if (this.tyW != null && this.tyW.size() > 0) {
            it = this.tyW.iterator();
            while (it.hasNext()) {
                if (host.contains((String) it.next())) {
                    this.tyZ.put(host, Boolean.valueOf(false));
                    x.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                    return false;
                }
            }
        }
        if (this.tyX != null && this.tyX.size() > 0) {
            it = this.tyX.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!bi.oN(str2) && host.contains(str2)) {
                    if (this.tyV == 1) {
                        this.tyZ.put(host, Boolean.valueOf(true));
                        x.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", str2, str);
                        return true;
                    } else if (this.tyV == 2) {
                        x.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", str2, str);
                        this.tza.add(host);
                        this.tyZ.put(host, Boolean.valueOf(false));
                        return false;
                    }
                }
            }
        }
        this.tyZ.put(host, Boolean.valueOf(false));
        return false;
    }

    private m b(d dVar) {
        try {
            if (dVar.e(98, null) == null) {
                return null;
            }
            try {
                String convertStreamToString = bi.convertStreamToString(ad.getContext().getAssets().open("jsapi/wxjs.js"));
                if (!TextUtils.isEmpty(this.tzb)) {
                    convertStreamToString = convertStreamToString.replace("__wx._getDgtVerifyRandomStr()", this.tzb).replace("__wx._isDgtVerifyEnabled()", "true");
                }
                m mVar = new m("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(convertStreamToString.getBytes("UTF-8")));
                Map hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
                hashMap.put("Pragma", "no-cache");
                hashMap.put("Expires", "0");
                mVar.mResponseHeaders = hashMap;
                return mVar;
            } catch (Exception e) {
                x.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", e);
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
