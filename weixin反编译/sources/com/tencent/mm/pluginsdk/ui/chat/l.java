package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.f.a.qx;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class l implements OnClickListener {
    private Context context;

    public static class a {
        public String appId;
        public String fFG;
        public String fGc;
        public long fGj;
        public String ffM;
        public int scene;
        public int vyl;
        public String vym;
    }

    public static class b {
        public String appId;
        public String fFG;
    }

    public l(Context context) {
        this.context = context;
    }

    public final void onClick(View view) {
        boolean z = true;
        Object tag = view.getTag();
        com.tencent.mm.sdk.b.b qxVar;
        if (tag instanceof b) {
            String f;
            b bVar = (b) tag;
            if (bVar == null || view == null) {
                x.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx7fa037cc7dfabad5".equals(bVar.appId)) {
                    d.qq(33);
                    as.Hm();
                    if (com.tencent.mm.k.a.ga(c.Ff().Xv("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        com.tencent.mm.bl.d.a(this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        com.tencent.mm.bl.d.b(this.context, "profile", ".ui.ContactInfoUI", intent);
                    }
                } else if ("wx485a97c844086dc9".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    com.tencent.mm.bl.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(bVar.appId)) {
                    if (!com.tencent.mm.aq.b.PY()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(com.tencent.mm.o.a.aV(this.context) || com.tencent.mm.at.a.Qq())) {
                            com.tencent.mm.bl.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(bVar.appId)) {
                    if (!com.tencent.mm.aq.b.PY()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(com.tencent.mm.o.a.aV(this.context) || com.tencent.mm.at.a.Qq())) {
                            com.tencent.mm.bl.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(bVar.appId)) {
                    if (!com.tencent.mm.aq.b.PY()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(com.tencent.mm.o.a.aV(this.context) || com.tencent.mm.at.a.Qq())) {
                            com.tencent.mm.bl.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    com.tencent.mm.bl.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    f = p.f(this.context, bVar.appId, bVar.fFG);
                    qxVar = new qx();
                    qxVar.fJA.fJB = f;
                    qxVar.fJA.context = this.context;
                    com.tencent.mm.sdk.b.a.xmy.m(qxVar);
                }
            }
            z = false;
            if (!z) {
                f = p.f(this.context, bVar.appId, bVar.fFG);
                qxVar = new qx();
                qxVar.fJA.fJB = f;
                qxVar.fJA.context = this.context;
                com.tencent.mm.sdk.b.a.xmy.m(qxVar);
            }
        } else if (tag instanceof a) {
            a aVar = (a) tag;
            qxVar = new gn();
            qxVar.fxx.actionCode = 2;
            qxVar.fxx.scene = aVar.scene;
            qxVar.fxx.extMsg = "chatting_src=" + aVar.scene;
            qxVar.fxx.appId = aVar.appId;
            qxVar.fxx.context = this.context;
            com.tencent.mm.sdk.b.a.xmy.m(qxVar);
            qxVar = new nj();
            qxVar.fGg.context = this.context;
            qxVar.fGg.scene = aVar.scene;
            qxVar.fGg.fGh = aVar.appId;
            qxVar.fGg.packageName = aVar.ffM;
            qxVar.fGg.msgType = aVar.vyl;
            qxVar.fGg.fAJ = aVar.fGc;
            qxVar.fGg.fGi = 5;
            qxVar.fGg.mediaTagName = aVar.vym;
            qxVar.fGg.fGj = aVar.fGj;
            qxVar.fGg.fGk = "";
            com.tencent.mm.sdk.b.a.xmy.m(qxVar);
        }
    }
}
