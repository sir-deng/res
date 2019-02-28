package com.tencent.mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.contact.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.share.c;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Set;

final class a {
    private static final SparseIntArray jLO = new SparseIntArray() {
        public final int get(int i) {
            return super.get(i, j.iCh);
        }
    };
    private static final Set<String> jLP = new HashSet();

    static {
        jLO.put(e.NAME.hashCode(), j.iCd);
        jLO.put(JsApiStartPlayVoice.NAME.hashCode(), j.iCe);
        jLO.put(JsApiOperateMusicPlayer.NAME.hashCode(), j.iCe);
        jLO.put(c.NAME.hashCode(), j.iCf);
        jLO.put(com.tencent.mm.plugin.appbrand.menu.h.a.NAME.hashCode(), j.iCf);
        jLO.put(d.NAME.hashCode(), j.iCf);
        jLO.put("shareTimeline".hashCode(), j.iCf);
        jLO.put(com.tencent.mm.plugin.appbrand.menu.i.a.NAME.hashCode(), j.iCf);
        jLO.put("launchMiniProgram".hashCode(), j.iCc);
        jLP.add(e.NAME);
        jLP.add(JsApiStartPlayVoice.NAME);
        jLP.add(JsApiOperateMusicPlayer.NAME);
        jLP.add(c.NAME);
        jLP.add(com.tencent.mm.plugin.appbrand.menu.h.a.NAME);
        jLP.add(d.NAME);
        jLP.add("shareTimeline");
        jLP.add(com.tencent.mm.plugin.appbrand.menu.i.a.NAME);
        jLP.add("launchMiniProgram");
        jLP.add(JsApiMakeVoIPCall.NAME);
        jLP.add(o.NAME);
        jLP.add(b.NAME);
        jLP.add(am.NAME);
        jLP.add(ap.NAME);
    }

    static void a(final com.tencent.mm.plugin.appbrand.e eVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        if (eVar != null && bVar != null && jLP.contains(bVar.getName())) {
            String string = ad.getResources().getString(jLO.get(bVar.getName().hashCode()));
            string = ad.getResources().getString(j.iCg, new Object[]{string});
            com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new Runnable() {
                public final void run() {
                    n nVar = eVar.isX;
                    if (nVar != null) {
                        l ajy = nVar.ajy();
                        if (ajy != null) {
                            p aeO = ajy.aeO();
                            if (aeO != null) {
                                com.tencent.mm.plugin.appbrand.widget.f.b bVar = aeO.jJH;
                                String str = string;
                                if (bVar.kkK.afc() != null && bVar.kkK.mContext != null) {
                                    if (bVar.kkL == null) {
                                        bVar.kkL = new com.tencent.mm.plugin.appbrand.widget.f.a(bVar.kkK.mContext);
                                        bVar.kkL.a(bVar.kkK.afc());
                                    }
                                    bVar.kkK.afc().bringChildToFront(bVar.kkL.getView());
                                    bVar.kkL.vN(str);
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
