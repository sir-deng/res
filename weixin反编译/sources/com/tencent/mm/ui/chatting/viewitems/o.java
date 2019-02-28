package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.Map;

public final class o {

    static class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        TextView kHt;
        ImageView yRZ;
        public int ySl;
        ImageView yUg;
        TextView yUh;
        TextView yUi;

        a() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.b.a q(View view, boolean z) {
            super.ds(view);
            this.yUg = (ImageView) view.findViewById(R.h.bTx);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.yUh = (TextView) view.findViewById(R.h.bVl);
            this.yUi = (TextView) view.findViewById(R.h.bVn);
            this.kHt = (TextView) view.findViewById(R.h.bUJ);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.yRn = view.findViewById(R.h.bTF);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            if (!z) {
                this.yRo = (ImageView) view.findViewById(R.h.bVd);
                this.yRZ = (ImageView) view.findViewById(R.h.bVf);
                this.pyj = (ProgressBar) view.findViewById(R.h.cUg);
            }
            this.ySl = b.fQ(ad.getContext());
            return this;
        }
    }

    public static class b extends b {
        private String yUj;
        private String yUk;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || (i != 42 && i != 66)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddy);
            view.setTag(new a().q(view, true));
            return view;
        }

        protected final boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return aVar.yxU;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            String hT;
            byte b;
            CharSequence charSequence;
            this.yyH = aVar2;
            a aVar3 = (a) aVar;
            if (aVar2.yxU) {
                hT = bb.hT(auVar.field_content);
            } else {
                hT = auVar.field_content;
            }
            as.Hm();
            com.tencent.mm.storage.au.a Fq = com.tencent.mm.y.c.Fh().Fq(hT);
            if (Fq.sfb == null || Fq.sfb.length() <= 0) {
                x.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.yUj = Fq.sfb;
            this.yUk = "";
            if (!t.oN(hT)) {
                Map y = bj.y(hT, "msg");
                if (y.containsKey(".msg.$wechatid")) {
                    this.yUk = (String) y.get(".msg.$wechatid");
                }
            }
            com.tencent.mm.ac.b.I(this.yUj, Fq.xHH);
            com.tencent.mm.ui.chatting.viewitems.b.a.O(aVar3.yRn, aVar3.ySl);
            if (s.gN(Fq.tth)) {
                aVar3.yUh.setText(R.l.dQN);
                aVar3.yUi.setVisibility(8);
                if (d.fN(16)) {
                    aVar3.yUg.setBackground(null);
                } else {
                    aVar3.yUg.setBackgroundDrawable(null);
                }
                b.r(aVar3.yUg, this.yUj);
            } else {
                aVar3.yUh.setText(R.l.dSz);
                aVar3.yUg.setBackgroundResource(R.g.bBC);
                b.q(aVar3.yUg, this.yUj);
            }
            String str2 = this.yUk;
            if (t.oN(str2) || com.tencent.mm.storage.x.Xi(str2) || s.gG(str2)) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            boolean gN = s.gN(Fq.tth);
            if (b != (byte) 0 || gN) {
                charSequence = "";
            } else {
                Object charSequence2 = str2;
            }
            if (t.oN(charSequence2)) {
                aVar3.yUi.setVisibility(8);
            } else {
                aVar3.yUi.setVisibility(0);
                aVar3.yUi.setText(charSequence2);
            }
            aVar3.kHt.setText(i.c(aVar2.getContext(), Fq.fqG, (int) aVar3.kHt.getTextSize()));
            o.a(aVar2, this.yUj, Fq, aVar3);
            aVar3.yRn.setTag(new ar(auVar, aVar2.yxU, i, str, (byte) 0));
            aVar3.yRn.setOnClickListener(t(aVar2));
            aVar3.yRn.setOnLongClickListener(s(aVar2));
            aVar3.yRn.setOnTouchListener(aVar2.yAM.yBC);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            as.Hm();
            com.tencent.mm.storage.au.a Fq = com.tencent.mm.y.c.Fh().Fq(auVar.field_content);
            if (Fq.sfb == null || Fq.sfb.length() <= 0) {
                x.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
            }
            this.yUj = Fq.sfb;
            if (s.gN(Fq.tth)) {
                contextMenu.add(i, 118, 0, view.getContext().getString(R.l.eEP));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            switch (menuItem.getItemId()) {
                case 118:
                    Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", aVar.dn(auVar.field_content, auVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 8);
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            o.a(aVar, arVar.userName, auVar.field_content, arVar.yxU, auVar.field_isSend == 0);
            return true;
        }
    }

    public static class c extends b {
        private String yUj;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && (i == 42 || i == 66)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ded);
            view.setTag(new a().q(view, false));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            String str2;
            Object obj;
            String str3;
            boolean gN;
            this.yyH = aVar2;
            aVar = (a) aVar;
            as.Hm();
            com.tencent.mm.storage.au.a Fq = com.tencent.mm.y.c.Fh().Fq(auVar.field_content);
            if (Fq.sfb == null || Fq.sfb.length() <= 0) {
                x.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.yUj = Fq.sfb;
            x.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", Boolean.valueOf(s.gI(this.yUj)), this.yUj);
            com.tencent.mm.ui.chatting.viewitems.b.a.O(aVar.yRn, aVar.ySl);
            if (s.gN(Fq.tth)) {
                aVar.yUh.setText(R.l.dQN);
                aVar.yUi.setVisibility(8);
                if (d.fN(16)) {
                    aVar.yUg.setBackground(null);
                } else {
                    aVar.yUg.setBackgroundDrawable(null);
                }
                b.r(aVar.yUg, this.yUj);
            } else {
                aVar.yUh.setText(R.l.dSz);
                aVar.yUg.setBackgroundResource(R.g.bBC);
                b.q(aVar.yUg, this.yUj);
            }
            aVar.kHt.setText(i.b(aVar2.getContext(), Fq.fqG, aVar.kHt.getTextSize()));
            Object obj2 = null;
            CharSequence charSequence = Fq.ggL;
            if (!t.oN(this.yUj)) {
                as.Hm();
                ag Xv = com.tencent.mm.y.c.Ff().Xv(this.yUj);
                if (Xv != null && com.tencent.mm.k.a.ga(Xv.field_type)) {
                    com.tencent.mm.storage.x.ciM();
                    if (obj2 == null && t.oN(charSequence)) {
                        str2 = this.yUj;
                        obj = (t.oN(str2) || com.tencent.mm.storage.x.Xi(str2) || s.gG(str2)) ? 1 : null;
                        str3 = str2;
                        obj2 = obj;
                        charSequence = str3;
                    }
                    gN = s.gN(Fq.tth);
                    if (obj2 != null || gN) {
                        charSequence = "";
                    }
                    if (t.oN(charSequence)) {
                        aVar.yUi.setVisibility(0);
                        aVar.yUi.setText(charSequence);
                    } else {
                        aVar.yUi.setVisibility(8);
                    }
                    o.a(aVar2, this.yUj, Fq, aVar);
                    aVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
                    aVar.yRn.setOnClickListener(t(aVar2));
                    aVar.yRn.setOnLongClickListener(s(aVar2));
                    aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
                    if (b.cwm()) {
                        if (aVar.pyj != null) {
                            aVar.pyj.setVisibility(8);
                        }
                        if (auVar.field_status == 2 || !b.a(aVar2.yAM, auVar.field_msgId)) {
                            if (aVar.yRZ != null) {
                                aVar.yRZ.setVisibility(8);
                            }
                        } else if (aVar.yRZ != null) {
                            aVar.yRZ.setVisibility(0);
                        }
                    } else if (aVar.pyj != null) {
                        aVar.pyj.setVisibility(0);
                        if (auVar.field_status >= 2) {
                            aVar.pyj.setVisibility(8);
                        }
                    }
                    a(i, aVar, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
                }
            }
            obj2 = 1;
            str2 = this.yUj;
            if (!t.oN(str2)) {
            }
            str3 = str2;
            obj2 = obj;
            charSequence = str3;
            gN = s.gN(Fq.tth);
            charSequence = "";
            if (t.oN(charSequence)) {
                aVar.yUi.setVisibility(8);
            } else {
                aVar.yUi.setVisibility(0);
                aVar.yUi.setText(charSequence);
            }
            o.a(aVar2, this.yUj, Fq, aVar);
            aVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            aVar.yRn.setOnClickListener(t(aVar2));
            aVar.yRn.setOnLongClickListener(s(aVar2));
            aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            if (b.cwm()) {
                if (aVar.pyj != null) {
                    aVar.pyj.setVisibility(8);
                }
                if (auVar.field_status == 2) {
                }
                if (aVar.yRZ != null) {
                    aVar.yRZ.setVisibility(8);
                }
            } else if (aVar.pyj != null) {
                aVar.pyj.setVisibility(0);
                if (auVar.field_status >= 2) {
                    aVar.pyj.setVisibility(8);
                }
            }
            a(i, aVar, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            as.Hm();
            com.tencent.mm.storage.au.a Fq = com.tencent.mm.y.c.Fh().Fq(auVar.field_content);
            if (Fq.sfb == null || Fq.sfb.length() <= 0) {
                x.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
            }
            this.yUj = Fq.sfb;
            if (s.gN(Fq.tth)) {
                contextMenu.add(i, 118, 0, view.getContext().getString(R.l.eEP));
            }
            if (!auVar.cjK() && ((auVar.field_status == 2 || auVar.gkH == 1) && auVar.cjU() && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            switch (menuItem.getItemId()) {
                case 118:
                    Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", aVar.dn(auVar.field_content, auVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 8);
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            o.a(aVar, arVar.userName, auVar.field_content, arVar.yxU, auVar.field_isSend == 0);
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, String str, com.tencent.mm.storage.au.a aVar2, a aVar3) {
        if (com.tencent.mm.storage.x.Xg(str)) {
            CharSequence h = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).h(aVar2.xHM, "openim_card_type_name", com.tencent.mm.openim.a.b.a.idv);
            if (TextUtils.isEmpty(h)) {
                aVar3.yUh.setText(R.l.dSz);
            } else {
                aVar3.yUh.setText(h);
            }
            aVar3.yUg.setBackgroundResource(R.g.bBC);
            b.q(aVar3.yUg, str);
            String str2 = aVar2.xHO;
            String str3 = aVar2.xHN;
            if (t.oN(str2)) {
                Object obj = str3;
            } else {
                h = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).a(aVar.getContext(), str2, str3, aVar3.yUi.getTextSize());
            }
            if (TextUtils.isEmpty(h)) {
                aVar3.yUi.setVisibility(8);
                return;
            }
            aVar3.yUi.setVisibility(0);
            aVar3.yUi.setText(h);
        }
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, String str, String str2, boolean z, boolean z2) {
        if (z && z2) {
            str2 = bb.hT(str2);
        }
        as.Hm();
        com.tencent.mm.storage.au.a Fq = com.tencent.mm.y.c.Fh().Fq(str2);
        if (Fq != null) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", Fq.sfb);
            intent.putExtra("Contact_Alias", Fq.ggL);
            intent.putExtra("Contact_Nick", Fq.fqG);
            intent.putExtra("Contact_QuanPin", Fq.hyG);
            intent.putExtra("Contact_PyInitial", Fq.hyF);
            intent.putExtra("Contact_Uin", Fq.ppA);
            intent.putExtra("Contact_Mobile_MD5", Fq.xHI);
            intent.putExtra("Contact_full_Mobile_MD5", Fq.xHJ);
            intent.putExtra("Contact_QQNick", Fq.ckv());
            intent.putExtra("User_From_Fmessage", false);
            intent.putExtra("Contact_Scene", Fq.scene);
            intent.putExtra("Contact_FMessageCard", true);
            intent.putExtra("Contact_RemarkName", Fq.hyK);
            intent.putExtra("Contact_VUser_Info_Flag", Fq.tth);
            intent.putExtra("Contact_VUser_Info", Fq.fXp);
            intent.putExtra("Contact_BrandIconURL", Fq.pnr);
            intent.putExtra("Contact_Province", Fq.getProvince());
            intent.putExtra("Contact_City", Fq.getCity());
            intent.putExtra("Contact_Sex", Fq.fXa);
            intent.putExtra("Contact_Signature", Fq.signature);
            intent.putExtra("Contact_ShowUserName", true);
            intent.putExtra("Contact_KSnsIFlag", 0);
            intent.putExtra("Contact_Source_FMessage", 17);
            intent.putExtra("source_from_user_name", str);
            intent.putExtra("source_from_nick_name", r.gv(str));
            intent.putExtra(com.tencent.mm.ui.e.a.xML, Fq.vzN);
            intent.putExtra("key_add_contact_openim_appid", Fq.xHM);
            intent.putExtra("key_add_contact_custom_detail", Fq.xHP);
            if ((Fq.tth & 8) > 0) {
                if (!t.oN(str)) {
                    as.Hm();
                    if (com.tencent.mm.y.c.Ff().Xv(str).ciN()) {
                        intent.putExtra("Contact_Scene", 41);
                        com.tencent.mm.plugin.report.service.g.pWK.k(10298, Fq.sfb + ",41");
                    }
                }
                intent.putExtra("Contact_Scene", 17);
                com.tencent.mm.plugin.report.service.g.pWK.k(10298, Fq.sfb + ",17");
            }
            if (com.tencent.mm.storage.x.Xg(Fq.sfb) && Fq.scene == 0) {
                intent.putExtra("Contact_Scene", 17);
            }
            com.tencent.mm.bl.d.b(aVar.getContext(), "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.bm.a.CV(Fq.scene);
        }
    }
}
