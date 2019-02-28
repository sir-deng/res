package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class c {

    public interface b {
        void cleanup();
    }

    public interface c {
        MMWebView aie();

        void aif();

        void aig();

        String[] aij();

        String getAppId();

        void runOnUiThread(Runnable runnable);

        void tv(String str);

        void tw(String str);

        void u(JSONObject jSONObject);
    }

    public interface a extends com.tencent.mm.kernel.c.a {
        b a(c cVar);
    }
}
