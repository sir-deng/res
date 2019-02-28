package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g;
import com.tencent.mm.y.bb;

public final class w extends b {

    final class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        protected ImageView hxJ;
        protected TextView yVr;

        a() {
        }

        public final a dE(View view) {
            super.ds(view);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.hxJ = (ImageView) view.findViewById(R.h.cEr);
            this.yVr = (TextView) view.findViewById(R.h.cSa);
            return this;
        }
    }

    public final boolean aXP() {
        return false;
    }

    public final boolean ak(int i, boolean z) {
        if (i == -1879048176) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddN);
        view.setTag(new a().dE(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        com.tencent.mm.x.g.a aVar3;
        a aVar4 = (a) aVar;
        g fq = an.bZF().fq(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (fq == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsgPush";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fq == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            x.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
        }
        ar arVar = new ar(auVar, aVar2.yxU, i, null, (byte) 0);
        if (aVar3 != null && (aVar3.showType == 3 || aVar3.hdG == 3)) {
            aVar4.hxJ.setImageResource(R.g.bCS);
            aVar4.yVr.setText(aVar3.hdL);
        }
        aVar.yRn.setOnLongClickListener(s(aVar2));
        aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
        aVar.yRn.setTag(arVar);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRS));
        return false;
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
        return false;
    }
}
