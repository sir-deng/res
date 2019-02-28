package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i ruB = new i();
    private Map<Long, String> mJj = new HashMap();
    private d ruC = ae.bwg();
    public x ruD = ae.bwh();
    public Map<String, String> ruE = new HashMap();

    static /* synthetic */ void a(i iVar) {
        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "clearing old canvasInfo cache");
        Cursor Tq = iVar.ruC.Tq();
        if (Tq != null) {
            c cVar;
            long currentTimeMillis = System.currentTimeMillis() - 777600000;
            while (Tq.moveToNext()) {
                cVar = new com.tencent.mm.plugin.sns.storage.c();
                cVar.b(Tq);
                if (cVar.field_createTime < currentTimeMillis) {
                    com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "ad canvas eliminate %d " + cVar.field_canvasId);
                    iVar.ruC.a(cVar, new String[0]);
                }
            }
            Tq.close();
            Tq = iVar.ruD.Tq();
            if (Tq != null) {
                currentTimeMillis = System.currentTimeMillis() - 777600000;
                while (Tq.moveToNext()) {
                    cVar = new w();
                    cVar.b(Tq);
                    if (cVar.field_createTime < currentTimeMillis) {
                        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "ux canvas eliminate %d " + cVar.field_canvasId);
                        iVar.ruD.a(cVar, new String[0]);
                    }
                }
                Tq.close();
            }
        }
    }

    public static i byA() {
        return ruB;
    }

    private i() {
        HandlerThread WL = e.WL("OpenCanvasMgr");
        WL.start();
        new ag(WL.getLooper()).postDelayed(new Runnable() {
            public final void run() {
                i.a(i.this);
            }
        }, 5000);
    }

    public final String h(long j, int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "open pageId %d, preLoad %d", Long.valueOf(j), Integer.valueOf(i));
        if (j <= 0) {
            return "";
        }
        String str = "";
        if (i2 != 1) {
            if (this.mJj.containsKey(Long.valueOf(j))) {
                str = (String) this.mJj.get(Long.valueOf(j));
            } else {
                c cVar = new com.tencent.mm.plugin.sns.storage.c();
                cVar.field_canvasId = j;
                this.ruC.b(cVar, new String[0]);
                if (TextUtils.isEmpty(cVar.field_canvasXml)) {
                    str = "";
                } else {
                    this.mJj.put(Long.valueOf(j), cVar.field_canvasXml);
                    str = cVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str)) {
            return str;
        }
        final com.tencent.mm.plugin.sns.storage.c cVar2 = new com.tencent.mm.plugin.sns.storage.c();
        cVar2.field_canvasId = j;
        a aVar = new a();
        aVar.hnT = new xx();
        aVar.hnU = new xy();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        aVar.hnS = 1286;
        b Kf = aVar.Kf();
        ((xx) Kf.hnQ.hnY).wpl = j;
        final long j2 = j;
        final int i3 = i;
        u.a(Kf, new u.a() {
            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    xy xyVar = (xy) bVar.hnR.hnY;
                    com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(j2), xyVar.wpm);
                    if (!TextUtils.isEmpty(xyVar.wpm)) {
                        i.this.mJj.put(Long.valueOf(j2), xyVar.wpm);
                        cVar2.field_canvasXml = xyVar.wpm;
                        i.this.ruC.a(cVar2);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
        return "";
    }

    public final void o(long j, String str) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            this.mJj.put(Long.valueOf(j), str);
            com.tencent.mm.plugin.sns.storage.c cVar = new com.tencent.mm.plugin.sns.storage.c();
            cVar.field_canvasId = j;
            cVar.field_canvasXml = str;
            this.ruC.a(cVar);
        }
    }

    public final String m(final String str, String str2, final int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", str, str2, Integer.valueOf(i));
        if (bi.oN(str)) {
            return "";
        }
        String str3 = "";
        if (i2 != 1) {
            Object obj;
            if (bi.oN(str2)) {
                str3 = str;
            } else {
                obj = str + str2;
            }
            if (this.ruE.containsKey(obj)) {
                str3 = (String) this.ruE.get(obj);
            } else {
                c wVar = new w();
                wVar.field_canvasId = str;
                wVar.field_canvasExt = str2;
                this.ruD.b(wVar, "canvasId", "canvasExt");
                if (TextUtils.isEmpty(wVar.field_canvasXml)) {
                    str3 = "";
                } else {
                    this.ruE.put(obj, wVar.field_canvasXml);
                    str3 = wVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str3)) {
            return str3;
        }
        final w wVar2 = new w();
        wVar2.field_canvasId = str;
        a aVar = new a();
        aVar.hnT = new aec();
        aVar.hnU = new aed();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        aVar.hnS = 1890;
        b Kf = aVar.Kf();
        aec aec = (aec) Kf.hnQ.hnY;
        aec.wtp = str;
        aec.wtq = str2;
        u.a(Kf, new u.a() {
            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    Object cec = ((aed) bVar.hnR.hnY).wtr.cec();
                    com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", str, cec);
                    if (!TextUtils.isEmpty(cec)) {
                        i.this.ruE.put(str, cec);
                        wVar2.field_canvasXml = cec;
                        i.this.ruD.a(wVar2);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", str, Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
        return "";
    }
}
