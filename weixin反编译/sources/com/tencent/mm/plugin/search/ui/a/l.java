package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.friend.InviteFriendUI;

public final class l extends b {
    public b qkE;
    public boolean qkF;
    private a qkG = new a();

    public class a extends b.b {
        public a() {
            super();
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            l lVar = (l) bVar;
            if (lVar.qkE != null) {
                Intent intent;
                if (lVar.qkE.status == 1 || lVar.qkE.status == 2) {
                    x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                    intent = new Intent();
                    intent.putExtra("Contact_User", l.this.qkE.getUsername());
                    intent.putExtra("Contact_Nick", l.this.qkE.NC());
                    intent.putExtra("Contact_Mobile_MD5", l.this.qkE.Nx());
                    intent.putExtra("Contact_Alias", l.this.qkE.hxj);
                    intent.putExtra("Contact_Sex", l.this.qkE.hxe);
                    intent.putExtra("Contact_Signature", l.this.qkE.hxh);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(l.this.qkE.hxn, l.this.qkE.hxf, l.this.qkE.hxg));
                    intent.putExtra("Contact_Scene", 13);
                    intent.putExtra("Contact_ShowUserName", false);
                    if (l.this.qkF) {
                        intent.putExtra("add_more_friend_search_scene", 1);
                    }
                    com.tencent.mm.plugin.c.a.ihN.d(intent, context);
                } else if (l.this.qkE.status == 0) {
                    x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                    intent = new Intent(context, InviteFriendUI.class);
                    intent.putExtra("friend_type", 1);
                    intent.putExtra("friend_user_name", l.this.qkE.getUsername());
                    intent.putExtra("friend_num", l.this.qkE.NF());
                    intent.putExtra("friend_nick", l.this.qkE.Nz());
                    intent.putExtra("friend_weixin_nick", l.this.qkE.NC());
                    intent.putExtra("friend_scene", 13);
                    context.startActivity(intent);
                } else {
                    x.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                }
            }
            return true;
        }
    }

    public l(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r10, com.tencent.mm.plugin.fts.d.a.b.a r11, java.lang.Object... r12) {
        /*
        r9 = this;
        r0 = 0;
        r2 = 0;
        r1 = 1;
        r3 = r9.iZi;
        r3 = r3.mRd;
        r9.username = r3;
        com.tencent.mm.y.as.Hm();
        r3 = com.tencent.mm.y.c.Ff();
        r4 = r9.username;
        r3 = r3.Xv(r4);
        r9.jQP = r3;
        r3 = com.tencent.mm.modelfriend.af.OJ();
        r4 = r9.iZi;
        r4 = r4.mRQ;
        r3 = r3.be(r4);
        r9.qkE = r3;
        r3 = r9.qkE;
        r8 = r3.Nz();
        r3 = r9.iZi;
        r3 = r3.mRc;
        switch(r3) {
            case 5: goto L_0x00d3;
            case 6: goto L_0x00d1;
            case 7: goto L_0x00ab;
            case 8: goto L_0x0033;
            case 9: goto L_0x0033;
            case 10: goto L_0x0033;
            case 11: goto L_0x0033;
            case 12: goto L_0x00ce;
            case 13: goto L_0x00cc;
            case 14: goto L_0x0085;
            case 15: goto L_0x0033;
            case 16: goto L_0x0098;
            default: goto L_0x0033;
        };
    L_0x0033:
        r3 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r0;
        r7 = r0;
        r0 = r2;
    L_0x0039:
        if (r5 == 0) goto L_0x00bf;
    L_0x003b:
        r5 = com.tencent.mm.R.f.bvL;
        r5 = com.tencent.mm.bu.a.aa(r10, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.i.c(r10, r8, r5);
        r9.kNg = r5;
        r5 = r9.kNg;
        r8 = r9.mRM;
        r5 = com.tencent.mm.plugin.fts.d.b.a.a(r5, r8, r3, r0);
        r5 = com.tencent.mm.plugin.fts.d.f.a(r5);
        r5 = r5.mVW;
        r9.kNg = r5;
    L_0x0057:
        if (r4 == 0) goto L_0x0084;
    L_0x0059:
        r4 = com.tencent.mm.R.f.bvL;
        r4 = com.tencent.mm.bu.a.aa(r10, r4);
        r4 = com.tencent.mm.pluginsdk.ui.d.i.c(r10, r6, r4);
        r9.kNh = r4;
        r4 = r9.kNh;
        r5 = r9.mRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r4, r5, r3, r0);
        r0 = com.tencent.mm.plugin.fts.d.f.a(r0);
        r0 = r0.mVW;
        r9.kNh = r0;
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r7;
        r2 = r9.kNh;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r9.kNh = r0;
    L_0x0084:
        return;
    L_0x0085:
        r0 = r1;
    L_0x0086:
        r3 = r1;
    L_0x0087:
        r4 = r9.qkE;
        r4 = r4.NF();
        r5 = com.tencent.mm.R.l.eIW;
        r5 = r10.getString(r5);
        r6 = r4;
        r7 = r5;
        r4 = r2;
        r5 = r1;
        goto L_0x0039;
    L_0x0098:
        r0 = r9.qkE;
        r0 = r0.NF();
        r3 = com.tencent.mm.R.l.eIW;
        r3 = r10.getString(r3);
        r4 = r1;
        r5 = r2;
        r6 = r0;
        r7 = r3;
        r0 = r2;
        r3 = r2;
        goto L_0x0039;
    L_0x00ab:
        r0 = r1;
    L_0x00ac:
        r3 = r1;
    L_0x00ad:
        r4 = r9.qkE;
        r4 = r4.NC();
        r5 = com.tencent.mm.R.l.eJb;
        r5 = r10.getString(r5);
        r6 = r4;
        r7 = r5;
        r4 = r1;
        r5 = r2;
        goto L_0x0039;
    L_0x00bf:
        r5 = com.tencent.mm.R.f.bvL;
        r5 = com.tencent.mm.bu.a.aa(r10, r5);
        r5 = com.tencent.mm.pluginsdk.ui.d.i.c(r10, r8, r5);
        r9.kNg = r5;
        goto L_0x0057;
    L_0x00cc:
        r0 = r2;
        goto L_0x0086;
    L_0x00ce:
        r0 = r2;
        r3 = r2;
        goto L_0x0087;
    L_0x00d1:
        r0 = r2;
        goto L_0x00ac;
    L_0x00d3:
        r0 = r2;
        r3 = r2;
        goto L_0x00ad;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.l.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.b$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkG;
    }
}
