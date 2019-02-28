package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mm.bl.d;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.plugin.search.ui.a.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;

public final class p extends b {
    private a qkQ = new a();

    public class a extends b {
        public a() {
            super();
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            p pVar = (p) bVar;
            com.tencent.mm.plugin.fts.d.a.b.b.a(p.this.mRM.mRl, pVar.iZi);
            d.a(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", pVar.username).putExtra("finish_direct", true));
            return true;
        }
    }

    public p(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.d.a.b.a r14, java.lang.Object... r15) {
        /*
        r12 = this;
        r2 = 0;
        r7 = 0;
        r6 = 1;
        r0 = r12.iZi;
        r0 = r0.mRd;
        r12.username = r0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Ff();
        r1 = r12.username;
        r0 = r0.Xv(r1);
        r12.jQP = r0;
        r0 = r12.username;
        r4 = com.tencent.mm.y.r.gw(r0);
        r0 = r12.iZi;
        r0 = r0.mRc;
        switch(r0) {
            case 1: goto L_0x01fd;
            case 2: goto L_0x01fa;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00c0;
            case 5: goto L_0x0204;
            case 6: goto L_0x0201;
            case 7: goto L_0x00ac;
            case 11: goto L_0x0147;
            case 15: goto L_0x00d2;
            case 16: goto L_0x00f0;
            case 17: goto L_0x0135;
            case 18: goto L_0x0123;
            case 51: goto L_0x01b7;
            default: goto L_0x0025;
        };
    L_0x0025:
        r3 = r7;
        r8 = r7;
        r0 = r7;
        r9 = r2;
        r10 = r2;
        r2 = r7;
    L_0x002b:
        if (r0 == 0) goto L_0x01e1;
    L_0x002d:
        r0 = com.tencent.mm.R.f.bvL;
        r0 = com.tencent.mm.bu.a.aa(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.i.d(r13, r4, r0);
        r12.kNg = r0;
        r0 = r12.kNg;
        r1 = r12.mRM;
        r4 = com.tencent.mm.plugin.fts.d.f.a.mUz;
        r4 = (float) r4;
        r5 = com.tencent.mm.plugin.fts.d.d.b.mUt;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r12.kNg = r0;
    L_0x004f:
        if (r8 == 0) goto L_0x0082;
    L_0x0051:
        r0 = com.tencent.mm.R.f.bvL;
        r0 = com.tencent.mm.bu.a.aa(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.i.d(r13, r9, r0);
        r12.kNh = r0;
        r0 = r12.kNh;
        r1 = r12.mRM;
        r4 = com.tencent.mm.plugin.fts.d.f.a.mUz;
        r4 = (float) r4;
        r5 = com.tencent.mm.plugin.fts.d.d.b.mUv;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r12.kNh = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r7] = r10;
        r1 = r12.kNh;
        r0[r6] = r1;
        r0 = android.text.TextUtils.concat(r0);
        r12.kNh = r0;
    L_0x0082:
        r0 = r12.jQP;
        r0 = r0.field_username;
        r0 = com.tencent.mm.storage.x.Xg(r0);
        if (r0 == 0) goto L_0x01f0;
    L_0x008c:
        r0 = com.tencent.mm.openim.a.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.openim.a.b) r0;
        r1 = r12.jQP;
        r1 = r1.field_openImAppid;
        r2 = r12.jQP;
        r2 = r2.field_descWordingId;
        r0 = r0.aB(r1, r2);
        r12.qjG = r0;
    L_0x00a2:
        return;
    L_0x00a3:
        r0 = r6;
    L_0x00a4:
        r1 = r6;
    L_0x00a5:
        r3 = r0;
        r8 = r7;
        r9 = r2;
        r10 = r2;
        r2 = r1;
        r0 = r6;
        goto L_0x002b;
    L_0x00ac:
        r0 = r6;
    L_0x00ad:
        r1 = r6;
    L_0x00ae:
        r2 = r12.jQP;
        r2 = r2.field_nickname;
        r3 = com.tencent.mm.R.l.eIX;
        r3 = r13.getString(r3);
        r8 = r6;
        r9 = r2;
        r10 = r3;
        r2 = r1;
        r3 = r0;
        r0 = r7;
        goto L_0x002b;
    L_0x00c0:
        r0 = r12.jQP;
        r0 = r0.fXt;
        r1 = com.tencent.mm.R.l.eIU;
        r2 = r13.getString(r1);
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x00d2:
        r0 = r12.jQP;
        r0 = r0.vU();
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x00e2;
    L_0x00de:
        r0 = r12.jQP;
        r0 = r0.field_username;
    L_0x00e2:
        r1 = com.tencent.mm.R.l.eJa;
        r2 = r13.getString(r1);
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x00f0:
        r0 = r12.iZi;
        r1 = r0.content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r0 != 0) goto L_0x01f7;
    L_0x00fa:
        r0 = "​";
        r3 = r1.split(r0);
        r5 = r3.length;
        r2 = r7;
    L_0x0103:
        if (r2 >= r5) goto L_0x01f7;
    L_0x0105:
        r0 = r3[r2];
        r8 = r12.mRM;
        r8 = r8.mRl;
        r8 = r0.startsWith(r8);
        if (r8 == 0) goto L_0x011f;
    L_0x0111:
        r1 = com.tencent.mm.R.l.eIW;
        r2 = r13.getString(r1);
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x011f:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0103;
    L_0x0123:
        r0 = r12.iZi;
        r0 = r0.content;
        r1 = com.tencent.mm.R.l.eIY;
        r2 = r13.getString(r1);
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x0135:
        r0 = r12.iZi;
        r0 = r0.content;
        r1 = com.tencent.mm.R.l.eIT;
        r2 = r13.getString(r1);
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x0147:
        r0 = com.tencent.mm.plugin.fts.a.m.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.fts.a.m) r0;
        r0 = r0.getFTSMainDB();
        r1 = r12.jQP;
        r1 = r1.field_contactLabelIds;
        r2 = r0.BE(r1);
        r3 = new java.lang.StringBuffer;
        r3.<init>();
        r0 = r12.mRM;
        r5 = r0.mRn;
        r8 = r5.length;
        r1 = r7;
    L_0x0166:
        if (r1 >= r8) goto L_0x0192;
    L_0x0168:
        r9 = r5[r1];
        r10 = r2.iterator();
    L_0x016e:
        r0 = r10.hasNext();
        if (r0 == 0) goto L_0x018e;
    L_0x0174:
        r0 = r10.next();
        r0 = (java.lang.String) r0;
        r11 = com.tencent.mm.plugin.fts.a.d.BI(r0);
        r11 = r11.contains(r9);
        if (r11 == 0) goto L_0x016e;
    L_0x0184:
        r3.append(r0);
        r0 = ",";
        r3.append(r0);
        goto L_0x016e;
    L_0x018e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0166;
    L_0x0192:
        r3.trimToSize();
        r0 = r3.length();
        if (r0 != 0) goto L_0x01ac;
    L_0x019b:
        r0 = "";
    L_0x019e:
        r1 = com.tencent.mm.R.l.eIZ;
        r2 = r13.getString(r1);
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x01ac:
        r0 = r3.length();
        r0 = r0 + -1;
        r0 = r3.substring(r7, r0);
        goto L_0x019e;
    L_0x01b7:
        r0 = r12.jQP;
        r1 = r12.K(r0);
        r0 = r1.second;
        r0 = (java.lang.String) r0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r1.first;
        r1 = (java.lang.String) r1;
        r1 = r2.append(r1);
        r2 = "：";
        r1 = r1.append(r2);
        r2 = r1.toString();
        r3 = r7;
        r8 = r6;
        r9 = r0;
        r10 = r2;
        r2 = r7;
        r0 = r7;
        goto L_0x002b;
    L_0x01e1:
        r0 = com.tencent.mm.R.f.bvL;
        r0 = com.tencent.mm.bu.a.aa(r13, r0);
        r0 = (float) r0;
        r0 = com.tencent.mm.pluginsdk.ui.d.i.d(r13, r4, r0);
        r12.kNg = r0;
        goto L_0x004f;
    L_0x01f0:
        r0 = "";
        r12.qjG = r0;
        goto L_0x00a2;
    L_0x01f7:
        r0 = r1;
        goto L_0x0111;
    L_0x01fa:
        r0 = r7;
        goto L_0x00a4;
    L_0x01fd:
        r0 = r7;
        r1 = r7;
        goto L_0x00a5;
    L_0x0201:
        r0 = r7;
        goto L_0x00ad;
    L_0x0204:
        r0 = r7;
        r1 = r7;
        goto L_0x00ae;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.p.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.b$a, java.lang.Object[]):void");
    }

    private Pair<String, String> K(x xVar) {
        c cVar = new c();
        cVar.oz(xVar.fXE);
        for (int i = 0; i < cVar.idy.size(); i++) {
            com.tencent.mm.openim.a.c.a aVar = (com.tencent.mm.openim.a.c.a) cVar.idy.get(i);
            for (c.b oA : aVar.idz) {
                String oA2 = oA.oA(xVar.field_openImAppid);
                if (!bi.oN(oA2)) {
                    for (CharSequence contains : this.mRM.mRn) {
                        if (oA2.contains(contains)) {
                            return new Pair(aVar.title, oA2);
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkQ;
    }

    public final String adI() {
        if (this.jQP == null || !x.Xg(this.jQP.field_username)) {
            return "";
        }
        return "openim:" + this.jQP.field_openImAppid;
    }
}
