package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;

public final class l {

    public static class c extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 16777265) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.deb);
            view.setTag(new a().dy(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            a aVar3 = (a) aVar;
            this.yyH = aVar2;
            aVar2.yEx.aT(auVar);
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null && I.type == 1) {
                aVar3.yTq.W(i.a(aVar3.yTq.getContext(), I.title, (int) aVar3.yTq.gu.getTextSize(), 1));
                aVar3.yTq.setClickable(true);
                f aZ = g.aZ(I.appId, true);
                String str3 = (aZ == null || aZ.field_appName == null || aZ.field_appName.trim().length() <= 0) ? I.appName : aZ.field_appName;
                if (I.appId == null || I.appId.length() <= 0 || !g.cz(str3)) {
                    aVar3.mDG.setVisibility(8);
                } else {
                    aVar3.mDG.setText(aVar2.getString(R.l.dTm, g.a(aVar2.getContext(), aZ, str3)));
                    aVar3.mDG.setVisibility(0);
                    b.a(aVar2, aVar3.mDG, I.appId);
                    b.a(aVar2, aVar3.mDG, I.appId);
                }
                if (auVar.field_status == 2 || auVar.field_status == 5) {
                    aVar3.pyj.setVisibility(8);
                } else {
                    aVar3.pyj.setVisibility(0);
                }
                a(i, (com.tencent.mm.ui.chatting.viewitems.b.a) aVar3, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
            }
            aVar3.yTq.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                aVar3.yTq.setOnLongClickListener(s(aVar2));
                if (I != null && I.type != 1) {
                    aVar3.yTq.setOnTouchListener(aVar2.yAM.yBC);
                }
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
            if (d.Pu("favorite")) {
                contextMenu.add(i, 116, 0, this.yyH.getString(R.l.eAq));
            }
            if (!auVar.cjK() && ((auVar.field_status == 2 || auVar.gkH == 1) && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            switch (menuItem.getItemId()) {
                case 100:
                    bb.aL(auVar.field_msgId);
                    as.Hm();
                    com.tencent.mm.y.c.Fe().b(new e(auVar.field_talker, auVar.field_msgSvrId));
                    break;
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) aVar.getContext().getSystemService("clipboard");
                    Object dn = aVar.dn(com.tencent.mm.x.g.a.fV(auVar.field_content).title, auVar.field_isSend);
                    clipboardManager.setText(dn);
                    int i = com.tencent.mm.plugin.secinforeport.a.a.qlf;
                    com.tencent.mm.plugin.secinforeport.a.a.d(1, auVar.field_msgSvrId, bi.We(dn));
                    break;
                case 111:
                    Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", auVar.field_content);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }

    public static class b extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 16777265) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddw);
            view.setTag(new a().dy(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            this.yyH = aVar2;
            aVar2.yEx.aT(auVar);
            a aVar3 = (a) aVar;
            String str2 = auVar.field_content;
            if (aVar2.yAR) {
                int indexOf = auVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    str2 = auVar.field_content.substring(indexOf + 1);
                }
            }
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null && I.type == 1) {
                f aZ = g.aZ(I.appId, true);
                String str3 = (aZ == null || aZ.field_appName == null || aZ.field_appName.trim().length() <= 0) ? I.appName : aZ.field_appName;
                if (I.appId == null || I.appId.length() <= 0 || !g.cz(str3)) {
                    aVar3.mDG.setVisibility(8);
                } else {
                    aVar3.mDG.setText(aVar2.getString(R.l.dTm, g.a(aVar2.getContext(), aZ, str3)));
                    aVar3.mDG.setVisibility(0);
                    b.a(aVar2, aVar3.mDG, I.appId);
                    b.a(aVar2, aVar3.mDG, I.appId);
                }
                if (I.gkB == null || I.gkB.length() <= 0) {
                    aVar3.yRL.setVisibility(8);
                } else {
                    b(aVar2, aVar3.yRL, (Object) ar.aae(I.gkB));
                    aVar3.yRL.setVisibility(0);
                }
                aVar3.yTq.setClickable(true);
                aVar3.yTq.W(i.a(aVar3.yTq.getContext(), I.title, (int) aVar3.yTq.gu.getTextSize(), 1));
            }
            aVar3.yTq.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                aVar3.yTq.setOnLongClickListener(s(aVar2));
                if (I != null && I.type != 1) {
                    aVar3.yTq.setOnTouchListener(aVar2.yAM.yBC);
                }
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
            if (d.Pu("favorite")) {
                contextMenu.add(i, 116, 0, this.yyH.getString(R.l.eAq));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            switch (menuItem.getItemId()) {
                case 100:
                    bb.aL(auVar.field_msgId);
                    as.Hm();
                    com.tencent.mm.y.c.Fe().b(new e(auVar.field_talker, auVar.field_msgSvrId));
                    break;
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) aVar.getContext().getSystemService("clipboard");
                    Object dn = aVar.dn(com.tencent.mm.x.g.a.fV(aVar.dn(auVar.field_content, auVar.field_isSend)).title, auVar.field_isSend);
                    clipboardManager.setText(dn);
                    int i = com.tencent.mm.plugin.secinforeport.a.a.qlf;
                    com.tencent.mm.plugin.secinforeport.a.a.d(1, auVar.field_msgSvrId, bi.We(dn));
                    break;
                case 111:
                    Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", aVar.dn(auVar.field_content, auVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }

    static final class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        protected TextView mDG;
        protected ProgressBar pyj;
        protected TextView yRL;
        protected ImageView yRo;
        protected MMNeatTextView yTq;

        a() {
        }

        public final a dy(View view) {
            super.ds(view);
            this.yTq = (MMNeatTextView) view.findViewById(R.h.bTJ);
            this.pyj = (ProgressBar) view.findViewById(R.h.cUg);
            this.yRo = (ImageView) view.findViewById(R.h.bVd);
            this.mDG = (TextView) view.findViewById(R.h.bTn);
            this.yRL = (TextView) view.findViewById(R.h.bTb);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            return this;
        }
    }
}
