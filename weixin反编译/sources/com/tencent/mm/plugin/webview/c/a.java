package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.lx;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Map;

public final class a implements e {
    a trI = new a();
    private c trJ = new c<lx>() {
        {
            this.xmG = lx.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            lx lxVar = (lx) bVar;
            if (!(lxVar instanceof lx)) {
                return false;
            }
            a.this.trI.a(lxVar.fEd.type, lxVar.fEd.fEe, lxVar.fEd.fEf, lxVar.fEd.fEg, lxVar.fEd.fEh);
            return true;
        }
    };

    private class a {
        boolean bgH;
        boolean ftC;
        private b trL;
        private String trM;
        private long trN;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void a(int i, String str, String str2, int i2, long j) {
            String str3;
            if (bi.oN(str)) {
                String str4 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str5 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2.toString();
                }
                objArr[2] = str3;
                x.i(str4, str5, objArr);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            str3 = g.s(stringBuffer.toString().getBytes());
            if (!bi.oN(this.trM) && this.trM.equals(str3) && System.currentTimeMillis() - this.trN <= 8000 && bi.oN(str2)) {
                if (this.ftC) {
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", str);
                    h.Bw(i2).a(this.trL.bPQ().wRO, true, n.b(this.trL.bPQ().wru), this.trL.bPQ().wrx);
                    return;
                } else if (this.bgH) {
                    if (this.trL != null) {
                        this.trL.trO = i2;
                    }
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    return;
                } else {
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", str, str3, Integer.valueOf(i2));
            if (this.trL != null) {
                as.CN().c(this.trL);
            }
            this.trM = str3;
            this.trN = System.currentTimeMillis();
            this.bgH = true;
            this.ftC = false;
            as.CN().a(234, a.this);
            this.trL = new b(i, str, str2.getBytes(), i2, j);
            as.CN().a(this.trL, 0);
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.xmy.b(this.trJ);
    }

    public final boolean V(Map<String, Object> map) {
        x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", map.toString());
        String r = r(map, "keyword");
        String r2 = r(map, "nextPageBuffer");
        int s = s(map, Columns.TYPE);
        int s2 = s(map, "webview_instance_id");
        String r3 = r(map, "searchID");
        this.trI.a(s, r, r2, s2, bi.oN(r3) ? 0 : Long.valueOf(r3).longValue());
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            as.CN().b(234, (e) this);
            this.trI.bgH = false;
            b bVar = (b) kVar;
            if (i == 0 && i2 == 0) {
                this.trI.ftC = true;
            } else {
                this.trI.ftC = false;
                h.Bw(bVar.trO).a("{}", bVar.trP, "", 0);
            }
            h.Bw(bVar.trO).a(bVar.bPQ().wRO, bVar.trP, n.b(bVar.bPQ().wru), bVar.bPQ().wrx);
        }
    }

    public static String r(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static int s(Map<String, Object> map, String str) {
        String r = r(map, str);
        if (bi.oN(r)) {
            return 0;
        }
        return Integer.valueOf(r).intValue();
    }
}
