package com.tencent.mm.plugin.appbrand.r;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.net.MalformedURLException;
import java.net.URL;

public final class h {

    public interface a {
        void fs(String str);

        void pH(String str);
    }

    public static void a(b bVar, String str, final a aVar) {
        if (bi.oN(str)) {
            aVar.fs("isNullOrNil script");
            return;
        }
        bVar.evaluateJavascript(str + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (aVar != null) {
                        aVar.fs(str);
                    }
                } else if (aVar != null) {
                    aVar.pH(str);
                }
            }
        });
    }

    public static void a(b bVar, String str, String str2, final a aVar) {
        if (bi.oN(str2)) {
            aVar.fs("isNullOrNil script");
            return;
        }
        String str3 = str2 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)});
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(q.rH(str));
                }
            } catch (MalformedURLException e) {
                return;
            }
        }
        bVar.a(url, str3, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (aVar != null) {
                        aVar.fs(str);
                    }
                } else if (aVar != null) {
                    aVar.pH(str);
                }
            }
        });
    }
}
