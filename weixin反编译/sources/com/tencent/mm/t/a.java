package com.tencent.mm.t;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.t.b.d;

public final class a {

    public interface a {
        void Cb();

        void fs(String str);
    }

    public static void a(d dVar, String str, final a aVar) {
        if (bi.oN(str)) {
            aVar.fs("");
            return;
        }
        dVar.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Integer.valueOf(11111)}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (aVar != null) {
                        aVar.fs(str);
                    }
                } else if (aVar != null) {
                    aVar.Cb();
                }
            }
        });
    }
}
