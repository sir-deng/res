package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.y.as;

public final class z {

    static class b extends com.tencent.mm.ui.chatting.viewitems.b.a {
        ImageView ySW;
        TextView yUZ;
        TextView yVA;

        b() {
        }
    }

    public static class a extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (i == 35) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = layoutInflater.inflate(R.i.ddD, null);
            b bVar = new b();
            bVar.ljv = (TextView) view.findViewById(R.h.bVh);
            bVar.qng = (TextView) view.findViewById(R.h.bVm);
            bVar.ySW = (ImageView) view.findViewById(R.h.bUD);
            bVar.yVA = (TextView) view.findViewById(R.h.bVj);
            bVar.yUZ = (TextView) view.findViewById(R.h.bTJ);
            bVar.yRn = view.findViewById(R.h.bTF);
            view.setTag(bVar);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            b bVar = (b) aVar;
            as.Hm();
            c Fo = com.tencent.mm.y.c.Fh().Fo(auVar.field_content);
            bVar.yVA.setText(Fo.title);
            bVar.yUZ.setText(Fo.content);
            b.a((com.tencent.mm.ui.chatting.viewitems.b.a) bVar, Fo.hOy);
            bVar.ySW.setVisibility(Fo.mAz ? 0 : 8);
            bVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            bVar.yRn.setOnClickListener(t(aVar2));
            bVar.yRn.setOnLongClickListener(s(aVar2));
            bVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
        }

        protected final boolean cwl() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            as.Hm();
            c Fo = com.tencent.mm.y.c.Fh().Fo(arVar.fFE.field_content);
            if (t.oM(Fo.ptN).length() > 0) {
                d.b(aVar.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", arVar.fFE.field_msgId));
            } else if (t.oM(Fo.xHU).length() > 0) {
                d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(Fo.xHU)));
            }
            return true;
        }
    }
}
