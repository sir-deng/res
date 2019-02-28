package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.b.aa;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.g;
import com.tencent.mm.y.bb;

public final class j {

    public static class b extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != -1879048186) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddu);
            view.setTag(new a().dw(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            String substring;
            String str2;
            String str3;
            Object[] objArr;
            com.tencent.mm.x.g.a aVar3;
            a aVar4 = (a) aVar;
            this.yyH = aVar2;
            g fq = an.bZF().fq(auVar.field_msgId);
            String str4 = auVar.field_content;
            if (aVar2.yAR) {
                int indexOf = auVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    substring = auVar.field_content.substring(indexOf + 1);
                    if (fq != null || substring == null) {
                        str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
                        str3 = "amessage:%b, %s, %s";
                        objArr = new Object[4];
                        objArr[0] = Boolean.valueOf(fq != null);
                        objArr[1] = substring;
                        objArr[2] = Long.valueOf(auVar.field_msgId);
                        objArr[3] = str;
                        x.e(str2, str3, objArr);
                        aVar3 = null;
                    } else {
                        aVar3 = com.tencent.mm.x.g.a.I(substring, auVar.field_reserved);
                    }
                    if (aVar3 != null) {
                        aVar4.yTi.setText(aVar3.title);
                        aVar4.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
                        aVar4.yRn.setOnClickListener(t(aVar2));
                        if (this.vGb) {
                            aVar4.yRn.setOnLongClickListener(s(aVar2));
                            aVar4.yRn.setOnTouchListener(aVar2.yAM.yBC);
                        }
                    }
                    if (com.tencent.mm.pluginsdk.q.a.vje == null && com.tencent.mm.pluginsdk.q.a.vje.Ei(aVar2.csn())) {
                        aVar4.yTi.setTextColor(aVar2.thisActivity().getResources().getColor(R.e.btv));
                        aVar4.yRn.setClickable(true);
                        aVar4.yRn.setEnabled(true);
                        return;
                    }
                    aVar4.yTi.setTextColor(-8750470);
                    aVar4.yRn.setClickable(false);
                    aVar4.yRn.setEnabled(false);
                }
            }
            substring = str4;
            if (fq != null) {
            }
            str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
            str3 = "amessage:%b, %s, %s";
            objArr = new Object[4];
            if (fq != null) {
            }
            objArr[0] = Boolean.valueOf(fq != null);
            objArr[1] = substring;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            x.e(str2, str3, objArr);
            aVar3 = null;
            if (aVar3 != null) {
                aVar4.yTi.setText(aVar3.title);
                aVar4.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
                aVar4.yRn.setOnClickListener(t(aVar2));
                if (this.vGb) {
                    aVar4.yRn.setOnLongClickListener(s(aVar2));
                    aVar4.yRn.setOnTouchListener(aVar2.yAM.yBC);
                }
            }
            if (com.tencent.mm.pluginsdk.q.a.vje == null) {
            }
            aVar4.yTi.setTextColor(-8750470);
            aVar4.yRn.setClickable(false);
            aVar4.yRn.setEnabled(false);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            l.Sm(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, false);
            if (d.Pu("favorite") && (aZ == null || !aZ.YI())) {
                switch (fV.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 20:
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                        break;
                }
            }
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
                        bb.aL(auVar.field_msgId);
                        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                        if (aZ != null && aZ.YI()) {
                            b.a(aVar, aVar2, auVar, aZ);
                            break;
                        }
                    }
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
            aa aaVar = aVar.yEu;
            aVar.csn();
            aaVar.bn("fromMessage", true);
            return true;
        }
    }

    public static class c extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == -1879048186) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddZ);
            view.setTag(new a().dw(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            a aVar3 = (a) aVar;
            this.yyH = aVar2;
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null) {
                aVar3.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
                aVar3.yRn.setOnClickListener(t(aVar2));
                if (this.vGb) {
                    aVar3.yRn.setOnLongClickListener(s(aVar2));
                    aVar3.yRn.setOnTouchListener(aVar2.yAM.yBC);
                }
                aVar3.yTi.setText(I.title);
            }
            if (com.tencent.mm.pluginsdk.q.a.vje == null || !com.tencent.mm.pluginsdk.q.a.vje.Ei(aVar2.csn())) {
                aVar3.yTi.setTextColor(-8750470);
                aVar3.yRn.setClickable(false);
                aVar3.yRn.setEnabled(false);
                return;
            }
            aVar3.yTi.setTextColor(aVar2.thisActivity().getResources().getColor(R.e.btv));
            aVar3.yRn.setClickable(true);
            aVar3.yRn.setEnabled(true);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            l.Sm(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, false);
            if (d.Pu("favorite") && (aZ == null || !aZ.YI())) {
                switch (fV.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 20:
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                        break;
                }
            }
            if (!auVar.cjK() && auVar.aNL() && ((auVar.field_status == 2 || auVar.gkH == 1) && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker))) {
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
                    String str = auVar.field_content;
                    com.tencent.mm.x.g.a aVar2 = null;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                    }
                    if (aVar2 != null) {
                        l.fr(auVar.field_msgId);
                        bb.aL(auVar.field_msgId);
                        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                        if (aZ != null && aZ.YI()) {
                            b.a(aVar, aVar2, auVar, aZ);
                            break;
                        }
                    }
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
            aa aaVar = aVar.yEu;
            aVar.csn();
            aaVar.bn("fromMessage", true);
            return true;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        protected TextView yTi;

        a() {
        }

        public final a dw(View view) {
            super.ds(view);
            this.yTi = (TextView) view.findViewById(R.h.cue);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            return this;
        }
    }
}
