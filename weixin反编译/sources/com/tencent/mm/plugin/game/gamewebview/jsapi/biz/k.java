package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.graphics.Color;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_BYTE = 189;
    public static final String NAME = "clearBounceBackground";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiClearBounceBackground", "invoke");
        if (dVar.new != null) {
            dVar.mHandler.post(new Runnable() {
                public final void run() {
                    d.this.new.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            String str = (String) obj;
                            x.d("MicroMsg.GameWebPageView", "get background color s = %s", str);
                            if (!bi.oN(str)) {
                                int color = d.this.nef.getResources().getColor(R.e.bui);
                                String[] split;
                                if (d.nfi.matcher(str).matches()) {
                                    split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                    if (split.length == 4) {
                                        try {
                                            color = Color.argb(bi.getInt(bi.oM(split[3]).trim(), 0), bi.getInt(bi.oM(split[0]).trim(), 0), bi.getInt(bi.oM(split[1]).trim(), 0), bi.getInt(bi.oM(split[2]).trim(), 0));
                                        } catch (Exception e) {
                                            x.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", str, e);
                                            return;
                                        }
                                    }
                                    return;
                                } else if (d.nfj.matcher(str).matches()) {
                                    split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                    if (split.length == 3) {
                                        try {
                                            color = Color.argb(255, bi.getInt(bi.oM(split[0]).trim(), 0), bi.getInt(bi.oM(split[1]).trim(), 0), bi.getInt(bi.oM(split[2]).trim(), 0));
                                        } catch (Exception e2) {
                                            x.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", str, e2);
                                            return;
                                        }
                                    }
                                    return;
                                } else {
                                    x.d("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, can not match", str);
                                }
                                d.this.neu.AX(color);
                                d.this.neu.bTi();
                            }
                        }
                    });
                }
            });
        }
        dVar.E(i, a.e("clearBounceBackground:ok", null));
    }
}
