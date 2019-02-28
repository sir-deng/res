package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.by.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class an implements aa {
    private static k<aa, Bundle> yGI = new k<aa, Bundle>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((aa) obj).ag((Bundle) obj2);
        }
    };
    private Context context;
    private final Map<String, Req> yGL = new HashMap();

    public an(Context context) {
        this.context = context;
    }

    public static void ah(Bundle bundle) {
        yGI.cb(bundle);
        yGI.doNotify();
    }

    public final void ag(Bundle bundle) {
        x.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid"));
        Resp resp = new Resp(bundle);
        x.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + resp.errCode + ", type = " + resp.getType());
        if (((Req) this.yGL.get(resp.transaction)) == null) {
            x.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + resp.transaction);
        } else {
            this.yGL.remove(resp.transaction);
        }
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        x.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", str, str3);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        a.post(new Runnable() {
            public final void run() {
                final Req c = g.c(an.this.context, wXMediaMessage2, str4);
                g.a(an.this.context, str5, str6, c, 0, new g.a() {
                    public final void cI(boolean z) {
                        if (z) {
                            an.this.yGL.put(c.transaction, c);
                        }
                    }
                }, null);
            }
        });
    }
}
