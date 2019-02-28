package com.tencent.mm.plugin.game.gamewebview.e;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c {
    e jAn;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> ngt = new ArrayList();
    long ngu;

    private class a implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return s.eL(str, "weixin://jump/");
        }

        public final boolean Cz(String str) {
            if (c.this.jAn == null || !c.this.jAn.bTg().cen()) {
                x.e("MicroMsg.UrlHandler", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", str);
            } else {
                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                commonLogicTask.type = 1;
                Bundle bundle = new Bundle();
                bundle.putBoolean("permission_allow", c.this.jAn.bTf().go(7));
                bundle.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
                commonLogicTask.mym = bundle;
                GameWebViewMainProcessService.a(commonLogicTask);
            }
            return true;
        }
    }

    private class b implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return s.eL(str, "weixin://");
        }

        public final boolean Cz(String str) {
            if (!d.ai(str, c.this.ngu)) {
                return false;
            }
            try {
                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                if ("weixin://dl/posts".equals(str)) {
                    commonLogicTask.type = 3;
                    GameWebViewMainProcessService.a(commonLogicTask);
                    return true;
                } else if ("weixin://dl/moments".equals(str)) {
                    commonLogicTask.type = 4;
                    GameWebViewMainProcessService.a(commonLogicTask);
                    return true;
                } else if ("weixin://dl/scan".equals(str)) {
                    com.tencent.mm.bl.d.a(ad.getContext(), "scanner", ".ui.SingleTopScanUI", new Intent(), false);
                    return true;
                } else {
                    d.RM(str);
                    return true;
                }
            } catch (Exception e) {
                x.e("MicroMsg.UrlHandler", "kv report fail, ex = %s", e.getMessage());
                return true;
            }
        }
    }

    public c(com.tencent.mm.plugin.game.gamewebview.ui.d dVar) {
        this.jAn = dVar.neF;
        this.ngu = dVar.neG;
        this.ngt.add(new a());
        this.ngt.add(new b());
    }

    public final boolean Cy(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.ngt) {
            if (bVar.Cy(str)) {
                bVar.Cz(str);
                return true;
            }
        }
        return false;
    }
}
