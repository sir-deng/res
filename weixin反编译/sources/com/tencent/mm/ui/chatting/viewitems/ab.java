package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;

public final class ab {

    public static class a extends com.tencent.mm.ui.chatting.viewitems.af.a {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean ak(int i, boolean z) {
            if (z || (i != 55 && i != 57)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddR);
            view.setTag(new c().dB(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            c cVar = (c) aVar;
            com.tencent.mm.ag.a.a kB = com.tencent.mm.ag.a.a.kB(auVar.field_content);
            String str2 = kB.fAJ;
            a((com.tencent.mm.ui.chatting.viewitems.b.a) cVar, aVar2, auVar, str2);
            a((com.tencent.mm.ui.chatting.viewitems.b.a) cVar, aVar2, str2, auVar);
            i.a(cVar.yUZ.getContext(), com.tencent.mm.ag.a.a(kB), (int) cVar.yUZ.getTextSize(), null, "");
            cVar.yUZ.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            cVar.yUZ.setOnLongClickListener(s(aVar2));
        }

        protected final boolean cwl() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            if (auVar.ckf()) {
                int i = ((ar) view.getTag()).position;
                if (auVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dST));
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
                }
            }
            return true;
        }
    }

    public static class b extends com.tencent.mm.ui.chatting.viewitems.af.b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean ak(int i, boolean z) {
            if (z && (i == 55 || i == 57)) {
                return true;
            }
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            aVar = (e) aVar;
            com.tencent.mm.ag.a.a kB = com.tencent.mm.ag.a.a.kB(auVar.field_content);
            if (auVar.field_status >= 2) {
                aVar.pyj.setVisibility(8);
            } else {
                aVar.pyj.setVisibility(0);
            }
            i.a(aVar.yWi.getContext(), com.tencent.mm.ag.a.a(kB), (int) aVar.yWi.gu.getTextSize(), null, "");
            aVar.yWi.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            aVar.yWi.setOnLongClickListener(s(aVar2));
            a(i, aVar, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            if (auVar.ckf()) {
                int i = ((ar) view.getTag()).position;
                if (auVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dST));
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
                }
            }
            return true;
        }
    }

    static class c extends com.tencent.mm.ui.chatting.viewitems.b.a {
        TextView mDG;
        TextView yUZ;

        c() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.b.a dB(View view) {
            super.ds(view);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.yUZ = (TextView) view.findViewById(R.h.bTJ);
            this.mDG = (TextView) view.findViewById(R.h.bUS);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            return this;
        }
    }
}
