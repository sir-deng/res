package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern hMq = Pattern.compile(";");
    public j iZi;
    public CharSequence ikG;
    public CharSequence ikH;
    public String username;
    public CharSequence zeh;
    private b zei = new b();
    a zej = new a();

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bu.a.ez(context)) {
                inflate = LayoutInflater.from(context).inflate(f.qlz, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(f.qly, viewGroup, false);
            }
            a aVar = c.this.zej;
            aVar.ikK = (ImageView) inflate.findViewById(e.bLM);
            aVar.ikL = (TextView) inflate.findViewById(e.cSB);
            aVar.ikL.setMaxWidth(com.tencent.mm.bu.a.fromDPToPix(context, 200));
            aVar.ikM = (TextView) inflate.findViewById(e.caU);
            aVar.mVG = (TextView) inflate.findViewById(e.cSc);
            aVar.contentView = inflate.findViewById(e.cKY);
            aVar.ikN = (CheckBox) inflate.findViewById(e.cKP);
            if (c.this.kLA) {
                aVar.contentView.setBackgroundResource(d.bBz);
            }
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.ikK.setImageResource(d.bBC);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ikK, cVar.username);
            }
            com.tencent.mm.plugin.fts.d.e.a(cVar.ikG, aVar3.ikL);
            com.tencent.mm.plugin.fts.d.e.a(cVar.ikH, aVar3.ikM);
            com.tencent.mm.plugin.fts.d.e.a(cVar.zeh, aVar3.mVG);
            if (c.this.zbR) {
                if (z) {
                    aVar3.ikN.setChecked(true);
                    aVar3.ikN.setEnabled(false);
                } else {
                    aVar3.ikN.setChecked(z2);
                    aVar3.ikN.setEnabled(true);
                }
                aVar3.ikN.setVisibility(0);
                return;
            }
            aVar3.ikN.setVisibility(8);
        }

        public final boolean Xb() {
            if (c.this.iZi != null) {
                ((m) g.k(m.class)).updateTopHitsRank(c.this.fEe, c.this.iZi, 1);
            }
            return false;
        }
    }

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View contentView;
        public ImageView ikK;
        public TextView ikL;
        public TextView ikM;
        public CheckBox ikN;
        public TextView mVG;

        public a() {
            super();
        }
    }

    public c(int i) {
        super(3, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bH(android.content.Context r12) {
        /*
        r11 = this;
        r10 = 2;
        r3 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r11.iZi;
        if (r0 == 0) goto L_0x005b;
    L_0x0008:
        r0 = r11.jQP;
        if (r0 != 0) goto L_0x0168;
    L_0x000c:
        com.tencent.mm.kernel.g.Dr();
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r4 = r11.iZi;
        r4 = r4.mRd;
        r0 = r0.Xq(r4);
        r11.jQP = r0;
        r0 = r11.jQP;
        if (r0 != 0) goto L_0x0168;
    L_0x0029:
        com.tencent.mm.kernel.g.Dr();
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Ff();
        r4 = r11.iZi;
        r4 = r4.mRd;
        r0 = r0.Xu(r4);
        r11.jQP = r0;
        r0 = r1;
    L_0x0043:
        r4 = r11.jQP;
        if (r4 != 0) goto L_0x005d;
    L_0x0047:
        r0 = "MicroMsg.ChatroomDataItem";
        r3 = "filling dataItem Occur Error Contact is null, position=%d";
        r1 = new java.lang.Object[r1];
        r4 = r11.position;
        r4 = java.lang.Integer.valueOf(r4);
        r1[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r1);
    L_0x005a:
        return;
    L_0x005b:
        r0 = r2;
        goto L_0x0043;
    L_0x005d:
        r4 = r11.jQP;
        r4 = r4.field_username;
        r11.username = r4;
        if (r0 == 0) goto L_0x012e;
    L_0x0065:
        r4 = r11.iZi;
        r5 = r11.jQP;
        r6 = r12.getResources();
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r7 = r5.field_username;
        r7 = r0.a(r5, r7);
        r0 = r4.mRc;
        switch(r0) {
            case 1: goto L_0x0165;
            case 2: goto L_0x00a4;
            case 3: goto L_0x00a3;
            case 5: goto L_0x0165;
            case 6: goto L_0x00a4;
            case 7: goto L_0x00a3;
            case 38: goto L_0x00ab;
            default: goto L_0x0080;
        };
    L_0x0080:
        r0 = r2;
        r1 = r2;
    L_0x0082:
        if (r1 == 0) goto L_0x0120;
    L_0x0084:
        r1 = com.tencent.mm.plugin.selectcontact.a.c.bvt;
        r1 = com.tencent.mm.bu.a.aa(r12, r1);
        r1 = com.tencent.mm.pluginsdk.ui.d.i.c(r12, r7, r1);
        r11.ikG = r1;
        r1 = r11.ikG;
        r4 = r11.mRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r1, r4, r0, r2);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r11.ikG = r0;
    L_0x00a0:
        r11.ikH = r3;
        goto L_0x005a;
    L_0x00a3:
        r2 = r1;
    L_0x00a4:
        r0 = r1;
    L_0x00a5:
        r4 = com.tencent.mm.plugin.selectcontact.a.h.eIX;
        r6.getString(r4);
        goto L_0x0082;
    L_0x00ab:
        r0 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        com.tencent.mm.kernel.g.Dr();
        r8 = com.tencent.mm.kernel.g.Dq();
        r8 = r8.gRU;
        r9 = new java.lang.String[r1];
        r5 = r5.field_username;
        r9[r2] = r5;
        r0 = r8.a(r0, r9, r10);
        r5 = r0.moveToFirst();
        if (r5 == 0) goto L_0x011b;
    L_0x00c7:
        r5 = r0.getString(r2);
        r0.close();
        if (r5 != 0) goto L_0x0114;
    L_0x00d0:
        r0 = r3;
    L_0x00d1:
        if (r0 == 0) goto L_0x00f0;
    L_0x00d3:
        r5 = r0.length;
        if (r5 <= 0) goto L_0x00f0;
    L_0x00d6:
        r5 = new java.lang.StringBuilder;
        r8 = "(";
        r5.<init>(r8);
        r8 = r0.length;
        r5 = r5.append(r8);
        r8 = ")";
        r5 = r5.append(r8);
        r5 = r5.toString();
        r11.zeh = r5;
    L_0x00f0:
        if (r0 == 0) goto L_0x0080;
    L_0x00f2:
        r5 = r4.mRX;
        if (r5 == 0) goto L_0x0080;
    L_0x00f6:
        r3 = r4.mRX;
        r4 = r11.mRM;
        r5 = com.tencent.mm.plugin.fts.d.d.b.mUv;
        r0 = com.tencent.mm.plugin.fts.d.e.a(r12, r3, r0, r4, r5);
        r3 = com.tencent.mm.plugin.selectcontact.a.h.eIV;
        r3 = r6.getString(r3);
        r4 = new java.lang.CharSequence[r10];
        r4[r2] = r3;
        r4[r1] = r0;
        r3 = android.text.TextUtils.concat(r4);
        r0 = r2;
        r1 = r2;
        goto L_0x0082;
    L_0x0114:
        r0 = hMq;
        r0 = r0.split(r5);
        goto L_0x00d1;
    L_0x011b:
        r0.close();
        r0 = r3;
        goto L_0x00d1;
    L_0x0120:
        r0 = com.tencent.mm.plugin.selectcontact.a.c.bvt;
        r0 = com.tencent.mm.bu.a.aa(r12, r0);
        r0 = com.tencent.mm.pluginsdk.ui.d.i.c(r12, r7, r0);
        r11.ikG = r0;
        goto L_0x00a0;
    L_0x012e:
        r0 = com.tencent.mm.plugin.messenger.a.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.a.b) r0;
        r1 = r11.jQP;
        r2 = r11.jQP;
        r2 = r2.field_username;
        r0 = r0.a(r1, r2);
        r11.ikG = r0;
        r0 = r11.iZi;
        if (r0 == 0) goto L_0x005a;
    L_0x0146:
        r0 = new java.lang.StringBuilder;
        r1 = "(";
        r0.<init>(r1);
        r1 = r11.iZi;
        r2 = r1.mRQ;
        r0 = r0.append(r2);
        r1 = ")";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.zeh = r0;
        goto L_0x005a;
    L_0x0165:
        r0 = r2;
        goto L_0x00a5;
    L_0x0168:
        r0 = r1;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.c.bH(android.content.Context):void");
    }

    public final com.tencent.mm.ui.contact.a.a.b WZ() {
        return this.zei;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Xa() {
        return this.zej;
    }

    public final boolean aOg() {
        return this.iZi.mSa;
    }
}
