package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public final class ak extends b {
    private e hRg;
    private a yWZ;
    private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

    class a extends d {
        public a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            as.Hm();
            if (c.isSDCardAvailable()) {
                this.yyH.yAM.yBy.a(arVar.position, arVar.fFE);
            } else {
                u.fJ(this.yyH.getContext());
            }
        }
    }

    public final boolean aXP() {
        return false;
    }

    public final boolean ak(int i, boolean z) {
        if (i == -1879048191) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dep);
        view.setTag(new ay().dI(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, final int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, final au auVar, String str) {
        ay ayVar = (ay) aVar;
        this.yyH = aVar2;
        g fq = an.bZF().fq(auVar.field_msgId);
        String str2 = auVar.field_content;
        com.tencent.mm.x.g.a aVar3 = null;
        if (!(fq == null || str2 == null)) {
            aVar3 = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
        }
        if (aVar3 != null) {
            ayVar.ikM.setText(aVar3.description);
        }
        x.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + auVar.field_content);
        com.tencent.mm.plugin.subapp.c.e MO = com.tencent.mm.plugin.subapp.c.e.MO(str2);
        if (MO != null && MO.scv != null && MO.scv.length() > 0 && MO.scw > 0 && this.hRg == null && aVar3 != null && bi.oN(auVar.field_imgPath)) {
            str2 = k.nw(q.FY());
            String aJ = h.aJ(str2, false);
            auVar.dV(str2);
            as.Hm();
            c.Fh().a(auVar.field_msgId, auVar);
            long j = auVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = MO.scv;
            int i3 = MO.scw;
            int i4 = aVar3.type;
            String str5 = aVar3.hda;
            final String a = l.a(aJ, j, i2, str3, str4, i3, i4, aVar3.hcQ);
            if (a != null) {
                n CN = as.CN();
                e anonymousClass1 = new e() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                        x.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (com.tencent.mm.y.ak.a.hhy != null) {
                            z = com.tencent.mm.y.ak.a.hhy.aK(auVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((ab) kVar).getMediaId().equals(a)) {
                            ak.this.yyH.yAM.yBy.a(i, auVar);
                        }
                        as.CN().b(221, ak.this.hRg);
                        ak.this.hRg = null;
                    }
                };
                this.hRg = anonymousClass1;
                CN.a(221, anonymousClass1);
                com.tencent.mm.ad.k abVar = new ab(a);
                abVar.bZA();
                as.CN().a(abVar, 0);
            }
        }
        ayVar.ikM.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
        TextView textView = ayVar.ikM;
        if (this.yWZ == null) {
            this.yWZ = new a(this.yyH);
        }
        textView.setOnClickListener(this.yWZ);
        as.Hm();
        if (c.isSDCardAvailable()) {
            ayVar.ikM.setOnLongClickListener(s(aVar2));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        if (!this.yyH.ctJ()) {
            contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                com.tencent.mm.x.g.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.x.g.a.fV(str);
                }
                if (aVar2 != null) {
                    l.fr(auVar.field_msgId);
                }
                bb.aL(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        return true;
    }
}
