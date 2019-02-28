package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;

public final class ac extends b {
    private ad yVX = new ad();
    private aa yVY = new aa();
    private ae yVZ = new ae();

    final class b extends com.tencent.mm.ui.chatting.viewitems.b.a {
        View nav;
        TextView yUZ;

        b() {
        }
    }

    interface a {
        void b(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar);
    }

    public final boolean aXP() {
        return false;
    }

    public final boolean ak(int i, boolean z) {
        if (i == 10000 || i == 10002 || i == 570425393 || i == 64) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.ddS, null);
        b bVar = new b();
        bVar.nav = view;
        bVar.ljv = (TextView) view.findViewById(R.h.bVh);
        bVar.yUZ = (TextView) view.findViewById(R.h.bTJ);
        view.setTag(bVar);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        a aVar3;
        if (auVar.getType() == 10002) {
            aVar3 = this.yVY;
        } else if (auVar.getType() == 570425393) {
            aVar3 = this.yVZ;
        } else {
            aVar3 = this.yVX;
        }
        aVar3.b(aVar, i, aVar2, auVar);
    }

    protected final boolean cwl() {
        return false;
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
