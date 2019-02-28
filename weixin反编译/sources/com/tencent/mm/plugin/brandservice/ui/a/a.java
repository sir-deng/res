package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.r;

public final class a extends com.tencent.mm.plugin.fts.d.a.b {
    public j iZi;
    public String iconUrl;
    public x jQP;
    public CharSequence kNg;
    public CharSequence kNh;
    private b kNi = new b();
    a kNj = new a();
    public String username;

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diR, viewGroup, false);
            a aVar = a.this.kNj;
            aVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar.ikL = (TextView) inflate.findViewById(R.h.cSB);
            aVar.ikM = (TextView) inflate.findViewById(R.h.caU);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) bVar;
            a aVar3 = (a) aVar;
            cm(aVar3.contentView);
            e.a(context, aVar3.ikK, aVar2.iconUrl, null, R.g.bAa);
            e.a(aVar2.kNg, aVar3.ikL);
            e.a(aVar2.kNh, aVar3.ikM);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            a aVar = (a) bVar;
            com.tencent.mm.plugin.fts.d.a.b.b.a(a.this.mRM.mRl, aVar.iZi);
            Intent intent;
            if (f.ka(aVar.username)) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", aVar.username);
                intent.putExtra("enterprise_biz_display_name", r.gw(aVar.username));
                intent.putExtra("enterprise_from_scene", 3);
                d.a(context, ".ui.conversation.EnterpriseConversationUI", intent);
            } else if (f.eG(aVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", aVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.kb(aVar.username)) {
                com.tencent.mm.af.d jV = f.jV(aVar.username);
                String Lo = jV == null ? null : jV.Lo();
                if (Lo == null) {
                    Lo = "";
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", Lo);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", aVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                intent = new Intent();
                intent.putExtra("Chat_User", aVar.username);
                intent.putExtra("finish_direct", true);
                d.a(context, ".ui.chatting.ChattingUI", intent);
            }
            com.tencent.mm.bb.d.lW(aVar.username);
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView ikK;
        public TextView ikL;
        public TextView ikM;

        public a() {
            super();
        }
    }

    public a(int i) {
        super(4, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r12, com.tencent.mm.plugin.fts.d.a.b.a r13, java.lang.Object... r14) {
        /*
        r11 = this;
        r6 = 0;
        r10 = 2;
        r2 = 0;
        r3 = 1;
        r0 = r11.iZi;
        r0 = r0.mRd;
        r11.username = r0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Ff();
        r1 = r11.username;
        r0 = r0.Xv(r1);
        r11.jQP = r0;
        r0 = r11.username;
        r1 = com.tencent.mm.af.f.jV(r0);
        if (r1 != 0) goto L_0x0091;
    L_0x0021:
        r0 = "";
    L_0x0024:
        r11.iconUrl = r0;
        r0 = r11.username;
        r9 = com.tencent.mm.y.r.gw(r0);
        if (r1 == 0) goto L_0x0034;
    L_0x002e:
        r0 = r1.Lq();
        if (r0 == 0) goto L_0x0094;
    L_0x0034:
        r1 = r3;
    L_0x0035:
        r0 = r11.iZi;
        r0 = r0.mRc;
        switch(r0) {
            case 1: goto L_0x013b;
            case 2: goto L_0x0138;
            case 3: goto L_0x0096;
            case 15: goto L_0x009d;
            case 19: goto L_0x0142;
            case 20: goto L_0x013f;
            case 21: goto L_0x00ba;
            default: goto L_0x003c;
        };
    L_0x003c:
        r0 = r2;
        r4 = r2;
        r5 = r2;
        r7 = r6;
        r8 = r6;
        r6 = r2;
    L_0x0042:
        if (r6 == 0) goto L_0x0129;
    L_0x0044:
        r6 = com.tencent.mm.R.f.bvL;
        r6 = com.tencent.mm.bu.a.aa(r12, r6);
        r6 = (float) r6;
        r6 = com.tencent.mm.pluginsdk.ui.d.i.d(r12, r9, r6);
        r11.kNg = r6;
        r6 = r11.kNg;
        r9 = r11.mRM;
        r6 = com.tencent.mm.plugin.fts.d.b.a.a(r6, r9, r4, r0);
        r6 = com.tencent.mm.plugin.fts.d.f.a(r6);
        r6 = r6.mVW;
        r11.kNg = r6;
    L_0x0061:
        if (r5 == 0) goto L_0x0090;
    L_0x0063:
        if (r1 == 0) goto L_0x0090;
    L_0x0065:
        r1 = com.tencent.mm.R.f.bvL;
        r1 = com.tencent.mm.bu.a.aa(r12, r1);
        r1 = (float) r1;
        r1 = com.tencent.mm.pluginsdk.ui.d.i.d(r12, r8, r1);
        r11.kNh = r1;
        r1 = r11.kNh;
        r5 = r11.mRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r1, r5, r4, r0);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r11.kNh = r0;
        r0 = new java.lang.CharSequence[r10];
        r0[r2] = r7;
        r1 = r11.kNh;
        r0[r3] = r1;
        r0 = android.text.TextUtils.concat(r0);
        r11.kNh = r0;
    L_0x0090:
        return;
    L_0x0091:
        r0 = r1.field_brandIconURL;
        goto L_0x0024;
    L_0x0094:
        r1 = r2;
        goto L_0x0035;
    L_0x0096:
        r0 = r3;
    L_0x0097:
        r4 = r3;
    L_0x0098:
        r5 = r2;
        r7 = r6;
        r8 = r6;
        r6 = r3;
        goto L_0x0042;
    L_0x009d:
        r0 = r11.jQP;
        r0 = r0.vU();
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r4 == 0) goto L_0x00ad;
    L_0x00a9:
        r0 = r11.jQP;
        r0 = r0.field_username;
    L_0x00ad:
        r4 = com.tencent.mm.R.l.eJa;
        r4 = r12.getString(r4);
        r5 = r3;
        r6 = r2;
        r7 = r4;
        r8 = r0;
        r0 = r2;
        r4 = r2;
        goto L_0x0042;
    L_0x00ba:
        r0 = r3;
    L_0x00bb:
        r4 = r0;
        r5 = r3;
    L_0x00bd:
        r0 = com.tencent.mm.api.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.api.h) r0;
        r7 = r11.username;
        r0 = r0.cd(r7);
        r7 = r0.iterator();
    L_0x00cf:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x00fc;
    L_0x00d5:
        r0 = r7.next();
        r0 = (java.lang.String) r0;
        r8 = com.tencent.mm.R.f.bvL;
        r8 = com.tencent.mm.bu.a.aa(r12, r8);
        r8 = (float) r8;
        r0 = com.tencent.mm.pluginsdk.ui.d.i.d(r12, r0, r8);
        r11.kNh = r0;
        r0 = r11.kNh;
        r8 = r11.mRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r8, r5, r4);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r8 = r0.bjW;
        if (r8 != 0) goto L_0x00cf;
    L_0x00f8:
        r0 = r0.mVW;
        r11.kNh = r0;
    L_0x00fc:
        r0 = new java.lang.CharSequence[r10];
        r7 = r11.kNh;
        r0[r2] = r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = com.tencent.mm.R.l.eIH;
        r8 = r12.getString(r8);
        r7 = r7.append(r8);
        r7 = r7.append(r9);
        r7 = r7.toString();
        r0[r3] = r7;
        r0 = android.text.TextUtils.concat(r0);
        r11.kNh = r0;
        r0 = r4;
        r7 = r6;
        r8 = r6;
        r6 = r2;
        r4 = r5;
        r5 = r2;
        goto L_0x0042;
    L_0x0129:
        r6 = com.tencent.mm.R.f.bvL;
        r6 = com.tencent.mm.bu.a.aa(r12, r6);
        r6 = (float) r6;
        r6 = com.tencent.mm.pluginsdk.ui.d.i.d(r12, r9, r6);
        r11.kNg = r6;
        goto L_0x0061;
    L_0x0138:
        r0 = r2;
        goto L_0x0097;
    L_0x013b:
        r0 = r2;
        r4 = r2;
        goto L_0x0098;
    L_0x013f:
        r0 = r2;
        goto L_0x00bb;
    L_0x0142:
        r4 = r2;
        r5 = r2;
        goto L_0x00bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.a.a.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.b$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.kNi;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.kNj;
    }

    public final int adJ() {
        return this.iZi.mRZ;
    }
}
