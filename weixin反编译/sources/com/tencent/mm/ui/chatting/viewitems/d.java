package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.tf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;

public final class d {

    static class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        public int maxSize = 0;
        public TextView ySA;
        public TextView ySB;
        public TextView ySC;
        public int ySD = 0;
        public int ySl = 0;
        public ImageView ySz;

        a() {
        }

        public final a dt(View view) {
            super.ds(view);
            this.ljv = (TextView) this.nav.findViewById(R.h.bVh);
            this.mXO = (CheckBox) this.nav.findViewById(R.h.bTE);
            this.kbO = this.nav.findViewById(R.h.bUE);
            this.qng = (TextView) this.nav.findViewById(R.h.bVm);
            this.ySz = (ImageView) this.nav.findViewById(R.h.bKW);
            this.ySA = (TextView) this.nav.findViewById(R.h.bKY);
            this.ySB = (TextView) this.nav.findViewById(R.h.bKV);
            this.ySC = (TextView) this.nav.findViewById(R.h.bKZ);
            this.yRn = (LinearLayout) this.nav.findViewById(R.h.bTF);
            this.ySl = b.fQ(ad.getContext());
            this.ySD = com.tencent.mm.bu.a.aa(ad.getContext(), R.f.buz);
            this.maxSize = (int) (((float) com.tencent.mm.bu.a.ab(ad.getContext(), R.f.buz)) * 1.45f);
            return this;
        }
    }

    public static class b extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 436207665) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddq);
            view.setTag(new a().dt(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            this.yyH = aVar2;
            a aVar3 = (a) aVar;
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null) {
                TextView textView;
                CharSequence charSequence;
                int i2;
                int a;
                boolean equals = "1001".equals(I.her);
                com.tencent.mm.sdk.b.b tfVar = new tf();
                if (!(bi.oN(I.hes) || equals)) {
                    tfVar.fMv.fMx = I.hes;
                    com.tencent.mm.sdk.b.a.xmy.m(tfVar);
                }
                com.tencent.mm.ui.chatting.viewitems.b.a.O(aVar3.yRn, aVar3.ySl);
                if ("1001".equals(I.her)) {
                    aVar3.yRn.setBackgroundResource(f.c(I, auVar.field_isSend == 1));
                    aVar3.ySA.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    aVar3.yRn.setBackgroundResource(f.q(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1));
                    aVar3.ySA.setTypeface(Typeface.defaultFromStyle(0));
                    aVar3.ySD = aVar3.ySD > aVar3.maxSize ? aVar3.maxSize : aVar3.ySD;
                }
                aVar3.yRn.setPadding(aVar2.getContext().getResources().getDimensionPixelSize(R.f.bwJ), 0, aVar2.getContext().getResources().getDimensionPixelSize(R.f.bvT), 0);
                CharSequence charSequence2 = auVar.field_isSend == 1 ? I.hem : I.hel;
                if (bi.oN(charSequence2)) {
                    charSequence2 = I.description;
                    aVar3.ySA.setSingleLine(false);
                    aVar3.ySA.setMaxLines(3);
                } else {
                    aVar3.ySA.setSingleLine(true);
                }
                aVar3.ySA.setText(i.c(aVar2.getContext(), charSequence2, aVar3.ySD));
                aVar3.ySA.setTextSize(0, (float) aVar3.ySD);
                if (equals) {
                    textView = aVar3.ySB;
                    charSequence2 = i.b(aVar2.getContext(), f.b(I, auVar.field_isSend == 1), aVar3.ySB.getTextSize());
                } else if (bi.oN(I.hes)) {
                    textView = aVar3.ySB;
                    charSequence2 = auVar.field_isSend == 1 ? I.hen : I.heo;
                } else {
                    textView = aVar3.ySB;
                    charSequence2 = f.a(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1, I);
                }
                textView.setText(charSequence2);
                String str3 = I.hep;
                if (bi.oN(str3)) {
                    charSequence = I.title;
                } else {
                    Object charSequence3 = str3;
                }
                com.tencent.mm.x.c cVar = (com.tencent.mm.x.c) I.r(com.tencent.mm.x.c.class);
                aVar3.ySC.setText(charSequence3);
                if (bi.oN(cVar.hcG)) {
                    i2 = 0;
                } else {
                    o.PG().a("", aVar3.ySz);
                    i2 = aVar2.getResources().getIdentifier(cVar.hcG, "drawable", ad.getPackageName());
                }
                x.v("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                    x.v("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
                    aVar3.ySz.setImageResource(i2);
                }
                if ("1001".equals(I.her)) {
                    a = f.a(I, auVar.field_isSend == 1);
                } else {
                    a = f.r(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1);
                }
                if (a > 0) {
                    x.v("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
                    aVar3.ySz.setImageResource(a);
                } else if (i2 <= 0) {
                    x.v("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localResId");
                    str3 = I.hek;
                    if (bi.oN(str3)) {
                        str3 = I.thumburl;
                    }
                    aVar3.ySz.setImageBitmap(null);
                    if (!bi.oN(str3)) {
                        com.tencent.mm.ap.a.a.c.a aVar4 = new com.tencent.mm.ap.a.a.c.a();
                        as.Hm();
                        aVar4.hFo = com.tencent.mm.y.c.Fq();
                        aVar4.hFl = true;
                        aVar4.hFI = true;
                        o.PG().a(str3, aVar3.ySz, aVar4.PQ());
                    }
                }
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
            com.tencent.mm.x.g.a I;
            String str = auVar.field_content;
            if (str != null) {
                I = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null) {
                String str2 = bi.oN(I.hej) ? I.url : I.hej;
                x.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", Boolean.valueOf(bi.oN(str2)), Boolean.valueOf(bi.oN(I.heA)));
                Intent intent;
                Intent intent2;
                if (bi.oN(I.hes)) {
                    if (!bi.oN(I.heA)) {
                        x.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", I.heA, Integer.valueOf(I.heB), I.fAJ);
                        intent = new Intent();
                        intent.putExtra("bill_no", I.heA);
                        intent.putExtra("launcher_user_name", I.fAJ);
                        intent.putExtra("enter_scene", 1);
                        intent.putExtra("chatroom", aVar.csn());
                        com.tencent.mm.bl.d.b(aVar.getContext(), "aa", ".ui.PaylistAAUI", intent);
                        if (f.e(I).vJT == 2) {
                            g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(2));
                        } else {
                            g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(3));
                        }
                    } else if (!bi.oN(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                } else if (I.hes.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                    intent = new Intent();
                    intent.putExtra("key_way", 1);
                    intent.putExtra("key_native_url", I.hes);
                    intent.putExtra("key_username", aVar.csn());
                    intent.putExtra("key_static_from_scene", 100002);
                    com.tencent.mm.bl.d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                } else if (I.hes.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    int i;
                    Intent intent3 = new Intent();
                    String str3 = "key_way";
                    if (aVar.yAR) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    intent3.putExtra(str3, i);
                    intent3.putExtra("key_native_url", I.hes);
                    intent3.putExtra("key_username", aVar.csn());
                    com.tencent.mm.bl.d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyReceiveUI", intent3);
                } else {
                    x.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + I.hes + ", go webview:" + str2);
                    if (!bi.oN(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            return true;
        }
    }

    public static class c extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 436207665) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddV);
            view.setTag(new a().dt(view));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            this.yyH = aVar2;
            a aVar3 = (a) aVar;
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null) {
                TextView textView;
                int i2;
                int a;
                boolean equals = "1001".equals(I.her);
                com.tencent.mm.sdk.b.b tfVar = new tf();
                if (!(bi.oN(I.hes) || equals)) {
                    tfVar.fMv.fMx = I.hes;
                    com.tencent.mm.sdk.b.a.xmy.m(tfVar);
                }
                com.tencent.mm.ui.chatting.viewitems.b.a.O(aVar3.yRn, aVar3.ySl);
                if ("1001".equals(I.her)) {
                    aVar3.yRn.setBackgroundResource(f.c(I, auVar.field_isSend == 1));
                    aVar3.ySA.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    aVar3.yRn.setBackgroundResource(f.q(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1));
                    aVar3.ySA.setTypeface(Typeface.defaultFromStyle(0));
                    aVar3.ySD = aVar3.ySD > aVar3.maxSize ? aVar3.maxSize : aVar3.ySD;
                }
                aVar3.yRn.setPadding(aVar2.getContext().getResources().getDimensionPixelSize(R.f.bvC), 0, com.tencent.mm.bu.a.fromDPToPix(aVar2.getContext(), 13), 0);
                CharSequence charSequence = auVar.field_isSend == 1 ? I.hem : I.hel;
                if (bi.oN(charSequence)) {
                    charSequence = I.description;
                    aVar3.ySA.setSingleLine(false);
                    aVar3.ySA.setMaxLines(3);
                } else {
                    aVar3.ySA.setSingleLine(true);
                }
                aVar3.ySA.setText(i.c(aVar2.getContext(), charSequence, aVar3.ySD));
                aVar3.ySA.setTextSize(0, (float) aVar3.ySD);
                if (equals) {
                    textView = aVar3.ySB;
                    charSequence = i.b(aVar2.getContext(), f.b(I, auVar.field_isSend == 1), aVar3.ySB.getTextSize());
                } else if (bi.oN(I.hes)) {
                    textView = aVar3.ySB;
                    charSequence = auVar.field_isSend == 1 ? I.hen : I.heo;
                } else {
                    textView = aVar3.ySB;
                    charSequence = f.a(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1, I);
                }
                textView.setText(charSequence);
                charSequence = I.hep;
                if (bi.oN(charSequence)) {
                    charSequence = I.title;
                }
                aVar3.ySC.setText(charSequence);
                com.tencent.mm.x.c cVar = (com.tencent.mm.x.c) I.r(com.tencent.mm.x.c.class);
                if (bi.oN(cVar.hcG)) {
                    i2 = 0;
                } else {
                    o.PG().a("", aVar3.ySz);
                    i2 = aVar2.getResources().getIdentifier(cVar.hcG, "drawable", ad.getPackageName());
                }
                x.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", Integer.valueOf(i2));
                if (i2 > 0) {
                    x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
                    aVar3.ySz.setImageResource(i2);
                }
                if ("1001".equals(I.her)) {
                    a = f.a(I, auVar.field_isSend == 1);
                } else {
                    a = f.r(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1);
                }
                if (a > 0) {
                    x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
                    aVar3.ySz.setImageResource(a);
                } else if (i2 <= 0) {
                    x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
                    String str3 = I.hek;
                    if (bi.oN(str3)) {
                        str3 = I.thumburl;
                    }
                    aVar3.ySz.setImageBitmap(null);
                    if (!bi.oN(str3)) {
                        com.tencent.mm.ap.a.a.c.a aVar4 = new com.tencent.mm.ap.a.a.c.a();
                        as.Hm();
                        aVar4.hFo = com.tencent.mm.y.c.Fq();
                        aVar4.hFl = true;
                        aVar4.hFI = true;
                        o.PG().a(str3, aVar3.ySz, aVar4.PQ());
                    }
                }
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
                case 103:
                    String str = auVar.field_content;
                    com.tencent.mm.x.g.a aVar2 = null;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
                    }
                    if (aVar2 != null) {
                        final String str2 = auVar.field_talker;
                        final String str3 = aVar2.hel;
                        final String str4 = aVar2.hem;
                        final String str5 = aVar2.hen;
                        final String str6 = aVar2.heo;
                        final String str7 = aVar2.hej;
                        final String str8 = aVar2.heq;
                        final String str9 = aVar2.her;
                        Context context = aVar.getContext();
                        String string = aVar.getString(R.l.dSS);
                        String string2 = aVar.getString(R.l.dGE);
                        String string3 = aVar.getString(R.l.dST);
                        String string4 = aVar.getString(R.l.dEy);
                        final com.tencent.mm.ui.chatting.ChattingUI.a aVar3 = aVar;
                        AnonymousClass1 anonymousClass1 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("key_scene", 1);
                                intent.putExtra("key_receiver", str2);
                                intent.putExtra("key_receivertitle", str3);
                                intent.putExtra("key_sendertitle", str4);
                                intent.putExtra("key_sender_des", str5);
                                intent.putExtra("key_receiver_des", str6);
                                intent.putExtra("key_url", str7);
                                intent.putExtra("key_templateid", str8);
                                intent.putExtra("key_sceneid", str9);
                                com.tencent.mm.bl.d.b(aVar3.thisActivity(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
                            }
                        };
                        h.a(context, string, string2, string3, string4, (OnClickListener) anonymousClass1, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a I;
            String str = auVar.field_content;
            if (str != null) {
                I = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I != null) {
                String str2 = bi.oN(I.hej) ? I.url : I.hej;
                x.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", Boolean.valueOf(bi.oN(str2)), Boolean.valueOf(bi.oN(I.heA)));
                Intent intent;
                Intent intent2;
                if (bi.oN(I.hes)) {
                    if (!bi.oN(I.heA)) {
                        x.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", I.heA, Integer.valueOf(I.heB), I.fAJ);
                        intent = new Intent();
                        intent.putExtra("bill_no", I.heA);
                        intent.putExtra("launcher_user_name", I.fAJ);
                        intent.putExtra("enter_scene", 1);
                        intent.putExtra("chatroom", aVar.csn());
                        com.tencent.mm.bl.d.b(aVar.getContext(), "aa", ".ui.PaylistAAUI", intent);
                        g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(1));
                    } else if (!(bi.oN(str2) || bi.oN(str2))) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                } else if (I.hes.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                    intent = new Intent();
                    intent.putExtra("key_way", 1);
                    intent.putExtra("key_native_url", I.hes);
                    intent.putExtra("key_username", aVar.csn());
                    intent.putExtra("key_static_from_scene", 100002);
                    com.tencent.mm.bl.d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                } else if (I.hes.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    int i;
                    Intent intent3 = new Intent();
                    String str3 = "key_way";
                    if (aVar.yAR) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    intent3.putExtra(str3, i);
                    intent3.putExtra("key_native_url", I.hes);
                    intent3.putExtra("key_username", aVar.csn());
                    com.tencent.mm.bl.d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyReceiveUI", intent3);
                } else {
                    x.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + I.hes + ", go webview:" + str2);
                    if (!bi.oN(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                }
            }
            return true;
        }
    }
}
