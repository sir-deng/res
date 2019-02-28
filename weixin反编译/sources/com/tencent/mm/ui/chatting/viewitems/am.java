package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.storage.au;

public final class am {

    static class d extends com.tencent.mm.ui.chatting.viewitems.b.a {
        TextView yUZ;

        d() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.b.a dB(View view) {
            super.ds(view);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.yUZ = (TextView) view.findViewById(R.h.bVF);
            this.yRn = view.findViewById(R.h.bTF);
            this.yRo = (ImageView) view.findViewById(R.h.bVd);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            return this;
        }
    }

    public static class b extends a {
        public final /* bridge */ /* synthetic */ boolean aXP() {
            return super.aXP();
        }

        public final boolean ak(int i, boolean z) {
            if (i == -1879048187) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddI);
            view.setTag(new d().dB(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            d dVar = (d) aVar;
            OnLongClickListener s = s(aVar2);
            if (dVar != null) {
                dVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
                dVar.yRn.setOnLongClickListener(s);
                dVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }

    static abstract class a extends b {
        a() {
        }

        protected final boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return false;
        }

        public String a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return aVar.yAM.talker;
        }

        public boolean aXP() {
            return false;
        }
    }

    public static class c extends b {
        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (i == -1879048188) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = layoutInflater.inflate(R.i.deq, null);
            view.setTag(new d().dB(view));
            return view;
        }

        protected final boolean cwl() {
            return false;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            aVar.ljv.setVisibility(0);
            aVar.ljv.setText(n.o(aVar2.getContext(), auVar.field_createTime));
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }
}
