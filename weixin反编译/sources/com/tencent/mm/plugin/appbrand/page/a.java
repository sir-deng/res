package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.page.p.AnonymousClass17;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class a {
    private static final a jHK = new a() {
        public final int a(int i, a aVar) {
            return 0;
        }

        public final void ls(int i) {
        }
    };
    private static final HashMap<e, a> jHL = new HashMap();
    private final e iua;
    private int jHM;
    private int jHN;
    private a jHO;

    public enum a {
        NORMAL,
        LBS,
        VOICE,
        VIDEO,
        LOADING
    }

    /* synthetic */ a(e eVar, byte b) {
        this(null);
    }

    static void c(p pVar) {
        if (pVar != null) {
            a q = q(pVar.iuk);
            x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "applyToUpcomingPage, textId: %d, status: %s", Integer.valueOf(q.jHN), q.jHO);
            pVar.km(q.jHN);
            pVar.jJr.b(q.jHO);
        }
    }

    public static a q(e eVar) {
        if (eVar == null) {
            return jHK;
        }
        a aVar = (a) jHL.get(eVar);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(eVar);
        jHL.put(eVar, aVar);
        return aVar;
    }

    private a(final e eVar) {
        this.jHM = 0;
        this.jHO = a.NORMAL;
        this.iua = eVar;
        if (eVar != null) {
            c.a(eVar.mAppId, new b() {
                public final void onDestroy() {
                    a.jHL.remove(eVar);
                }
            });
        }
    }

    public final int a(a aVar) {
        int i = 0;
        switch (aVar) {
            case LBS:
                i = j.iCj;
                break;
            case VOICE:
                i = j.iCk;
                break;
        }
        return a(i, aVar);
    }

    public int a(int i, a aVar) {
        try {
            x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "blinkSubTitle, status: %s", aVar);
            this.iua.isX.ajy().aeO().km(i);
            this.iua.isX.ajy().aeO().jJr.b(aVar);
            this.jHN = i;
            this.jHO = aVar;
            int i2 = this.jHM + 1;
            this.jHM = i2;
            return i2;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void ls(int i) {
        x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "dismissBlink, seq: %d, currentSeq: %d, status: %s", Integer.valueOf(i), Integer.valueOf(this.jHM), this.jHO);
        if (i == this.jHM) {
            try {
                this.iua.isX.ajy().aeO().km(0);
                p.runOnUiThread(new AnonymousClass17(a.NORMAL));
            } catch (NullPointerException e) {
            }
            this.jHN = 0;
            this.jHO = a.NORMAL;
        }
    }
}
