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
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import java.util.Map;

public final class e {

    static class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        public TextView ySL;

        a() {
        }

        public final a du(View view) {
            super.ds(view);
            this.ljv = (TextView) this.nav.findViewById(R.h.bVh);
            this.mXO = (CheckBox) this.nav.findViewById(R.h.bTE);
            this.kbO = this.nav.findViewById(R.h.bUE);
            this.qng = (TextView) this.nav.findViewById(R.h.bVm);
            this.ySL = (TextView) this.nav.findViewById(R.h.bKX);
            return this;
        }
    }

    public static class c extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 469762097) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddW);
            view.setTag(new a().du(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            this.yyH = aVar2;
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            a aVar3 = (a) aVar;
            if (I != null) {
                aVar3.ySL.setText(auVar.field_isSend == 1 ? I.hen : I.heo);
            }
            aVar.yRn.setOnClickListener(t(aVar2));
            aVar.yRn.setOnLongClickListener(s(aVar2));
            aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            aVar.yRn.setTag(new ar(auVar, this.yyH.yxU, i, null, (byte) 0));
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            contextMenu.add(((ar) view.getTag()).position, 100, 0, this.yyH.getString(R.l.dRS));
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            switch (menuItem.getItemId()) {
                case 100:
                    bb.aL(auVar.field_msgId);
                    return true;
                default:
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            String str = auVar.field_content;
            if (str != null) {
                com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
                if (!(I == null || bi.oN(I.hes))) {
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", I.hes);
                    intent.putExtra("key_image_id", I.hev);
                    intent.putExtra("key_image_aes_key", I.hew);
                    intent.putExtra("key_image_length", I.hex);
                    intent.putExtra("key_username", aVar.csn());
                    d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                }
            }
            return true;
        }
    }

    public static class b extends b {
        private final int ySM = 1;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 469762097) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddr);
            view.setTag(new a().du(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            this.yyH = aVar2;
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            a aVar3 = (a) aVar;
            if (I != null) {
                aVar3.ySL.setText(auVar.field_isSend == 1 ? I.hen : I.heo);
            }
            aVar.yRn.setOnClickListener(t(aVar2));
            aVar.yRn.setOnLongClickListener(s(aVar2));
            aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            aVar.yRn.setTag(new ar(auVar, this.yyH.yxU, i, null, (byte) 0));
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            contextMenu.add(((ar) view.getTag()).position, 100, 0, this.yyH.getString(R.l.dRS));
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            switch (menuItem.getItemId()) {
                case 100:
                    bb.aL(auVar.field_msgId);
                    return true;
                default:
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            String str = auVar.field_content;
            if (str != null) {
                com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
                if (!bi.oN(I.hes)) {
                    Intent intent;
                    if (I.het == 1) {
                        x.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick hasplay, skip");
                        intent = new Intent();
                        intent.putExtra("key_native_url", I.hes);
                        intent.putExtra("key_username", aVar.csn());
                        intent.putExtra("key_image_id", I.hev);
                        intent.putExtra("key_image_aes_key", I.hew);
                        intent.putExtra("key_image_length", I.hex);
                        d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    } else {
                        x.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                        intent = new Intent();
                        intent.putExtra("key_native_url", I.hes);
                        intent.putExtra("key_username", aVar.csn());
                        intent.putExtra("key_image_id", I.hev);
                        intent.putExtra("key_image_aes_key", I.hew);
                        intent.putExtra("key_image_length", I.hex);
                        d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                        I.het = 1;
                        auVar.setContent(com.tencent.mm.x.g.a.a(I, null, null));
                        if (auVar != null && auVar.aNJ()) {
                            try {
                                str = auVar.field_content;
                                int indexOf = str.indexOf("<msg>");
                                if (indexOf > 0 && indexOf < str.length()) {
                                    str = str.substring(indexOf).trim();
                                }
                                Map y = bj.y(str, "msg");
                                if (y != null && y.size() > 0) {
                                    auVar.dW(ay.at(y));
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e.getMessage());
                            }
                        }
                        as.Hm();
                        com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
                    }
                }
            }
            return true;
        }
    }
}
