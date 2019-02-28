package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.qk;
import com.tencent.mm.f.a.ql;
import com.tencent.mm.f.a.qm;
import com.tencent.mm.f.a.rp;
import com.tencent.mm.f.a.rr;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao {
    private static c rdA = new c<rr>() {
        {
            this.xmG = rr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 1;
            rr rrVar = (rr) bVar;
            if (rrVar instanceof rr) {
                String str = rrVar.fKq.id;
                int i2 = rrVar.fKq.type;
                a cg = ao.cg(str, i2);
                if (cg != null) {
                    String str2 = rrVar.fKq.fKr;
                    cg.rdC = str2;
                    cg.fIQ = rrVar.fKq.fIQ;
                    String str3 = "MicroMsg.SnsTranslateManager";
                    String str4 = "finish translate, id:%s, type: %d, success: %b";
                    Object[] objArr = new Object[3];
                    objArr[0] = cg.id;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Boolean.valueOf(!bi.oN(str2));
                    x.i(str3, str4, objArr);
                    switch (i2) {
                        case 2:
                            break;
                        case 3:
                            i = 2;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    if (i != -1) {
                        ao.d(str, i, cg.rdC, cg.fIQ);
                        ao.rdz.remove(cg);
                    }
                }
            }
            return false;
        }
    };
    private static HashMap<String, b> rdy = new HashMap();
    private static LinkedList<a> rdz = new LinkedList();

    private static class a {
        String fIQ;
        String id;
        String rdB;
        String rdC;
        int type;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            if (this.id.equals(aVar.id) && this.type == aVar.type) {
                return true;
            }
            return false;
        }
    }

    public static class b {
        public int fXe;
        public boolean hjU;
        public boolean hmT;
        public String hrN;
        public String id;
        public boolean rdD;
        public boolean rdE;
        public String result;
    }

    static /* synthetic */ a cg(String str, int i) {
        Iterator it = rdz.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == i && !bi.oN(str) && !bi.oN(aVar.id) && str.equals(aVar.id)) {
                return aVar;
            }
        }
        return null;
    }

    public static void init() {
        com.tencent.mm.sdk.b.a.xmy.b(rdA);
    }

    public static void WT() {
        com.tencent.mm.sdk.b.a.xmy.c(rdA);
    }

    private static boolean uB() {
        if (!d.Pu("translate")) {
            return false;
        }
        String value = g.Af().getValue("TranslateSnsOff");
        if (bi.oN(value)) {
            return true;
        }
        if (bi.Wo(value) == 0) {
            return true;
        }
        return false;
    }

    public static void a(Menu menu, boolean z) {
        if (!uB()) {
            return;
        }
        if (z) {
            menu.add(0, 14, 0, j.qSC);
        } else {
            menu.add(0, 15, 0, j.qSC);
        }
    }

    public static void b(Menu menu, boolean z) {
        if (!uB()) {
            return;
        }
        if (z) {
            menu.add(0, 16, 0, j.qSE);
        } else {
            menu.add(0, 17, 0, j.qSE);
        }
    }

    public static void o(m mVar) {
        if (mVar != null) {
            String byG = mVar.byG();
            x.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", byG);
            if (mVar.field_snsId == 0) {
                x.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                rdy.remove(byG);
                d(byG, 1, null, null);
                return;
            }
            if (rdy.containsKey(byG)) {
                b bVar = (b) rdy.get(byG);
                if (!bVar.hjU || bVar.hmT) {
                    rdy.remove(byG);
                } else {
                    x.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", byG);
                    d(bVar.id, 1, bVar.result, bVar.hrN);
                    return;
                }
            }
            if (mVar.byF() != null) {
                String str = mVar.byF().wYg;
                com.tencent.mm.sdk.b.b rpVar = new rp();
                rpVar.fKk.id = byG;
                rpVar.fKk.fKl = str;
                rpVar.fKk.type = 2;
                com.tencent.mm.sdk.b.a.xmy.m(rpVar);
                cc(mVar.byG(), 1);
                a aVar = new a();
                aVar.id = byG;
                aVar.rdB = str;
                aVar.type = 2;
                rdz.add(aVar);
            }
        }
    }

    public static void a(b bVar) {
        if ((bVar.fXe & 2) != 0) {
            bVar.rdD = false;
        } else if ((bVar.fXe & 4) != 0) {
            bVar.rdE = false;
        }
        rdy.put(bVar.id, bVar);
    }

    private static void b(b bVar) {
        if ((bVar.fXe & 2) != 0) {
            bVar.rdD = true;
        } else if ((bVar.fXe & 4) != 0) {
            bVar.rdE = true;
        }
        rdy.put(bVar.id, bVar);
    }

    public static void p(m mVar) {
        if (mVar != null) {
            String byG = mVar.byG();
            b(KW(byG));
            com.tencent.mm.sdk.b.b qmVar = new qm();
            qmVar.fIS.type = 1;
            qmVar.fIS.id = byG;
            com.tencent.mm.sdk.b.a.xmy.m(qmVar);
            x.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", byG);
        }
    }

    public static void a(com.tencent.mm.plugin.sns.ui.m mVar) {
        if (mVar != null && mVar.raa != null) {
            long j;
            String str = mVar.noL;
            StringBuilder stringBuilder = new StringBuilder();
            if (mVar.raa.wUn != 0) {
                j = (long) mVar.raa.wUn;
            } else {
                j = mVar.raa.wUq;
            }
            String ei = ei(mVar.ryh, stringBuilder.append(j).toString());
            if (rdy.containsKey(ei)) {
                b bVar = (b) rdy.get(ei);
                if (!bVar.hjU || bi.oN(bVar.result)) {
                    rdy.remove(ei);
                } else {
                    x.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", ei);
                    d(bVar.id, 2, bVar.result, bVar.hrN);
                    return;
                }
            }
            com.tencent.mm.sdk.b.b rpVar = new rp();
            rpVar.fKk.id = ei;
            rpVar.fKk.fKl = str;
            rpVar.fKk.type = 3;
            com.tencent.mm.sdk.b.a.xmy.m(rpVar);
            cc(ei, 2);
            a aVar = new a();
            aVar.id = ei;
            aVar.rdB = str;
            aVar.type = 3;
            rdz.add(aVar);
            x.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", aVar.id);
        }
    }

    public static void b(com.tencent.mm.plugin.sns.ui.m mVar) {
        if (mVar != null) {
            String ei = ei(mVar.ryh, (mVar.raa.wUn != 0 ? (long) mVar.raa.wUn : mVar.raa.wUq));
            b(KW(ei));
            com.tencent.mm.sdk.b.b qmVar = new qm();
            qmVar.fIS.type = 2;
            qmVar.fIS.id = ei;
            com.tencent.mm.sdk.b.a.xmy.m(qmVar);
            x.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", ei);
        }
    }

    private static void cc(String str, int i) {
        if (!rdy.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.hrN = null;
            bVar.result = null;
            bVar.hjU = false;
            bVar.hmT = false;
            bVar.rdE = true;
            bVar.rdD = true;
            rdy.put(str, bVar);
        }
        com.tencent.mm.sdk.b.b qlVar = new ql();
        qlVar.fIR.type = i;
        qlVar.fIR.id = str;
        com.tencent.mm.sdk.b.a.xmy.m(qlVar);
    }

    private static void d(String str, int i, String str2, String str3) {
        if (rdy.containsKey(str)) {
            b bVar = (b) rdy.get(str);
            bVar.hrN = str3;
            bVar.result = str2;
            bVar.hjU = true;
            bVar.hmT = bi.oN(str2);
            rdy.put(str, bVar);
        }
        if (bi.oN(str2)) {
            Toast.makeText(ad.getContext(), j.qSD, 1).show();
        }
        com.tencent.mm.sdk.b.b qkVar = new qk();
        qkVar.fIP.type = i;
        qkVar.fIP.id = str;
        qkVar.fIP.result = str2;
        qkVar.fIP.fIQ = str3;
        com.tencent.mm.sdk.b.a.xmy.m(qkVar);
    }

    public static String ei(String str, String str2) {
        return str + ";" + str2;
    }

    public static HashMap<String, b> bwI() {
        return rdy;
    }

    public static void cd(String str, int i) {
        if (rdy.containsKey(str)) {
            b bVar = (b) rdy.get(str);
            bVar.fXe |= i;
            rdy.put(str, bVar);
        }
    }

    public static void ce(String str, int i) {
        if (rdy.containsKey(str)) {
            b bVar = (b) rdy.get(str);
            bVar.fXe &= i ^ -1;
            if (i != 2 && i == 4) {
                bVar.rdE = true;
            }
            rdy.put(str, bVar);
        }
    }

    public static boolean cf(String str, int i) {
        if (!rdy.containsKey(str)) {
            return false;
        }
        if ((((b) rdy.get(str)).fXe & i) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.fXe & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b KW(String str) {
        if (rdy.containsKey(str)) {
            return (b) rdy.get(str);
        }
        return null;
    }
}
