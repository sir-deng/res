package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.bb;

public final class g {

    public static class b extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || (i != 452984881 && i != 520093745)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddz);
            view.setTag(new a().r(view, true));
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
            if (!(aVar3 == null || I == null)) {
                aVar3.a(aVar2.getContext(), I, auVar.field_imgPath, this.vGb);
            }
            ar arVar = new ar(auVar, aVar2.yxU, i, null, (byte) 0);
            if (aVar.yRn != null) {
                aVar.yRn.setTag(arVar);
                aVar.yRn.setOnClickListener(t(aVar2));
                if (this.vGb) {
                    aVar.yRn.setOnLongClickListener(s(aVar2));
                    aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
                }
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            String str = auVar.field_content;
            if (str == null) {
                return true;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(str, auVar.field_isSend));
            if (fV == null) {
                return true;
            }
            switch (fV.type) {
                case 16:
                    if (fV.hdW == 5 || fV.hdW == 6 || fV.hdW == 2) {
                        if (fV.hdW != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                        return false;
                    }
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                    return false;
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a aVar2;
            String str;
            switch (menuItem.getItemId()) {
                case 100:
                    String str2 = auVar.field_content;
                    aVar2 = null;
                    if (str2 != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str2);
                    }
                    if (aVar2 != null) {
                        l.fr(auVar.field_msgId);
                    }
                    bb.aL(auVar.field_msgId);
                    break;
                case 103:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 16:
                                    com.tencent.mm.sdk.b.b hzVar = new hz();
                                    hzVar.fzm.fzn = aVar2.fzn;
                                    hzVar.fzm.fqB = auVar.field_msgId;
                                    hzVar.fzm.fzo = auVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xmy.m(hzVar);
                                    break;
                            }
                        }
                    }
                    break;
                case 111:
                    str = aVar.dn(auVar.field_content, auVar.field_isSend);
                    Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", str);
                    aVar2 = com.tencent.mm.x.g.a.fV(str);
                    if (aVar2 == null || 16 != aVar2.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            String str = auVar.field_content;
            if (str == null) {
                return false;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
            if (fV == null) {
                return false;
            }
            switch (fV.type) {
                case 16:
                    if (bi.oN(fV.fzn)) {
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", fV.fzn);
                    intent.putExtra("key_from_scene", fV.hdW);
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    return true;
                case 34:
                    h b = h.b(fV);
                    if (1 < b.ver) {
                        String str2;
                        int i;
                        String A = p.A(fV.hcL, "message");
                        PackageInfo packageInfo = b.getPackageInfo(aVar.getContext(), fV.appId);
                        if (packageInfo == null) {
                            str2 = null;
                        } else {
                            str2 = packageInfo.versionName;
                        }
                        if (packageInfo == null) {
                            i = 0;
                        } else {
                            i = packageInfo.versionCode;
                        }
                        a(aVar, A, A, str2, i, fV.appId, true, auVar.field_msgId, auVar.field_msgSvrId, auVar);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", a(aVar, auVar));
                        intent2.putExtra("key_biz_uin", b.hdY);
                        intent2.putExtra("key_order_id", b.hdZ);
                        if (!(auVar.field_talker == null || auVar.field_talker.equals("") || !auVar.field_talker.endsWith("@chatroom"))) {
                            intent2.putExtra("key_chatroom_name", auVar.field_talker);
                        }
                        d.b(aVar.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    public static class c extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && (i == 452984881 || i == 520093745)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.dee);
            view.setTag(new a().r(view, false));
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
            if (!(aVar3 == null || I == null)) {
                aVar3.a(aVar2.getContext(), I, auVar.field_imgPath, this.vGb);
            }
            aVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, null, (byte) 0));
            aVar.yRn.setOnClickListener(t(aVar2));
            if (this.vGb) {
                aVar.yRn.setOnLongClickListener(s(aVar2));
                aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            String str = auVar.field_content;
            if (str == null) {
                return true;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(str, auVar.field_isSend));
            if (fV == null) {
                return true;
            }
            switch (fV.type) {
                case 16:
                    if (fV.hdW == 5 || fV.hdW == 6 || fV.hdW == 2) {
                        if (fV.hdW != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                        return false;
                    }
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                    return false;
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a aVar2;
            String str;
            switch (menuItem.getItemId()) {
                case 100:
                    String str2 = auVar.field_content;
                    aVar2 = null;
                    if (str2 != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str2);
                    }
                    if (aVar2 != null) {
                        l.fr(auVar.field_msgId);
                    }
                    bb.aL(auVar.field_msgId);
                    break;
                case 103:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 16:
                                    com.tencent.mm.sdk.b.b hzVar = new hz();
                                    hzVar.fzm.fzn = aVar2.fzn;
                                    hzVar.fzm.fqB = auVar.field_msgId;
                                    hzVar.fzm.fzo = auVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xmy.m(hzVar);
                                    break;
                            }
                        }
                    }
                    break;
                case 111:
                    str = aVar.dn(auVar.field_content, auVar.field_isSend);
                    Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", str);
                    aVar2 = com.tencent.mm.x.g.a.fV(str);
                    if (aVar2 == null || 16 != aVar2.type) {
                        intent.putExtra("Retr_Msg_Type", 2);
                    } else {
                        intent.putExtra("Retr_Msg_Type", 14);
                    }
                    intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            String str = auVar.field_content;
            if (str == null) {
                return false;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
            if (fV == null) {
                return false;
            }
            switch (fV.type) {
                case 16:
                    if (bi.oN(fV.fzn)) {
                        return false;
                    }
                    Intent intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", fV.fzn);
                    intent.putExtra("key_from_scene", fV.hdW);
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    return true;
                case 34:
                    h b = h.b(fV);
                    if (1 < b.ver) {
                        String str2;
                        int i;
                        String A = p.A(fV.hcL, "message");
                        PackageInfo packageInfo = b.getPackageInfo(aVar.getContext(), fV.appId);
                        if (packageInfo == null) {
                            str2 = null;
                        } else {
                            str2 = packageInfo.versionName;
                        }
                        if (packageInfo == null) {
                            i = 0;
                        } else {
                            i = packageInfo.versionCode;
                        }
                        a(aVar, A, A, str2, i, fV.appId, true, auVar.field_msgId, auVar.field_msgSvrId, auVar);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_from_user_name", a(aVar, auVar));
                        intent2.putExtra("key_biz_uin", b.hdY);
                        intent2.putExtra("key_order_id", b.hdZ);
                        if (!(auVar.field_talker == null || auVar.field_talker.equals("") || !auVar.field_talker.endsWith("@chatroom"))) {
                            intent2.putExtra("key_chatroom_name", auVar.field_talker);
                        }
                        d.b(aVar.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        public static final int ySS = (((int) com.tencent.mm.bu.a.getDensity(MMApplicationLike.applicationLike.getApplication())) * 64);
        public TextView ikL;
        public TextView ikM;
        public MMImageView yRA;
        public TextView ySP;
        public View ySQ;
        public boolean ySR;
        public int ySl = 0;

        a() {
        }

        public final a r(View view, boolean z) {
            super.ds(view);
            this.ySR = z;
            this.ljv = (TextView) this.nav.findViewById(R.h.bVh);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = this.nav.findViewById(R.h.bUE);
            this.qng = (TextView) this.nav.findViewById(R.h.bVm);
            this.yRA = (MMImageView) this.nav.findViewById(R.h.bLd);
            this.ikL = (TextView) this.nav.findViewById(R.h.bLe);
            this.ikM = (TextView) this.nav.findViewById(R.h.bLc);
            this.ySP = (TextView) this.nav.findViewById(R.h.bLa);
            this.ySQ = this.nav.findViewById(R.h.bLb);
            this.ySl = b.fQ(ad.getContext());
            return this;
        }

        public final void a(final Context context, com.tencent.mm.x.g.a aVar, String str, boolean z) {
            com.tencent.mm.ui.chatting.viewitems.b.a.O(this.yRn, this.ySl);
            com.tencent.mm.ap.a.a PG;
            String B;
            ImageView imageView;
            com.tencent.mm.ap.a.a.c.a aVar2;
            switch (aVar.type) {
                case 16:
                    this.ikL.setText(aVar.description);
                    this.ikM.setText(aVar.hdV);
                    this.yRA.setVisibility(0);
                    if (z) {
                        PG = o.PG();
                        B = o.PC().B(str, true);
                        imageView = this.yRA;
                        aVar2 = new com.tencent.mm.ap.a.a.c.a();
                        aVar2.hFq = 1;
                        aVar2 = aVar2.bc(ySS, ySS);
                        aVar2.hFA = R.k.dvO;
                        aVar2.hFJ = true;
                        PG.a(B, imageView, aVar2.PQ());
                        return;
                    }
                    this.yRA.setImageResource(R.g.bEi);
                    return;
                case 34:
                    if (aVar.title == null || aVar.title.length() <= 0) {
                        this.ikL.setVisibility(8);
                    } else {
                        this.ikL.setVisibility(0);
                        this.ikL.setText(aVar.title);
                        if (bi.oN(aVar.hee)) {
                            this.ikL.setTextColor(context.getResources().getColor(R.e.black));
                        } else {
                            this.ikL.setTextColor(bi.bc(aVar.hee, context.getResources().getColor(R.e.black)));
                        }
                    }
                    this.ikM.setMaxLines(2);
                    this.ikM.setVisibility(0);
                    this.ikM.setText(aVar.description);
                    if (bi.oN(aVar.hef)) {
                        this.ikM.setTextColor(context.getResources().getColor(R.e.bsF));
                    } else {
                        this.ikM.setTextColor(bi.bc(aVar.hef, context.getResources().getColor(R.e.bsF)));
                    }
                    if (bi.oN(aVar.hea)) {
                        this.ySP.setText(R.l.dRG);
                    } else {
                        this.ySP.setText(aVar.hea);
                    }
                    if (z) {
                        final Bitmap a = o.PC().a(str, com.tencent.mm.bu.a.getDensity(context), false);
                        if (!(a == null || a.isRecycled())) {
                            this.yRA.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, false, (float) (a.getWidth() / 2)));
                        }
                        if (bi.oN(aVar.hed)) {
                            this.ySQ.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                private boolean ySs = false;

                                public final boolean onPreDraw() {
                                    if (this.ySs) {
                                        a.this.ySQ.getViewTreeObserver().removeOnPreDrawListener(this);
                                    } else {
                                        a.this.ySQ.getViewTreeObserver().removeOnPreDrawListener(this);
                                        this.ySs = true;
                                        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(context, 24);
                                        Bitmap bitmap = a;
                                        if (bitmap == null || bitmap.isRecycled()) {
                                            bitmap = com.tencent.mm.sdk.platformtools.d.ah(context.getResources().getColor(R.e.brQ), fromDPToPix, fromDPToPix);
                                        }
                                        int height = bitmap.getHeight();
                                        if (fromDPToPix <= height) {
                                            height = fromDPToPix;
                                        }
                                        Bitmap c = com.tencent.mm.sdk.platformtools.d.c(com.tencent.mm.sdk.platformtools.d.T(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                        height = a.this.ySQ.getHeight();
                                        int width = a.this.ySQ.getWidth();
                                        if (height == 0) {
                                            height = com.tencent.mm.bu.a.aa(context, R.f.bwT);
                                        }
                                        if (width == 0) {
                                            width = com.tencent.mm.bu.a.aa(context, R.f.bwU);
                                        }
                                        if (a.this.ySR) {
                                            bitmap = com.tencent.mm.sdk.platformtools.d.a(c, R.g.bAE, width, height);
                                        } else {
                                            bitmap = com.tencent.mm.sdk.platformtools.d.a(c, R.g.bAQ, width, height);
                                        }
                                        a.this.ySQ.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        PG = o.PG();
                        B = aVar.hed;
                        imageView = new ImageView(context);
                        aVar2 = new com.tencent.mm.ap.a.a.c.a();
                        aVar2.hFl = true;
                        PG.a(B, imageView, aVar2.PQ(), new com.tencent.mm.ap.a.c.g() {
                            public final void lF(String str) {
                            }

                            public final Bitmap a(String str, com.tencent.mm.ap.a.d.b bVar) {
                                return null;
                            }

                            public final void a(String str, View view, com.tencent.mm.ap.a.d.b bVar) {
                                if (bVar.bitmap != null) {
                                    final Bitmap bitmap = bVar.bitmap;
                                    a.this.ySQ.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                        public final boolean onPreDraw() {
                                            Bitmap a;
                                            a.this.ySQ.getViewTreeObserver().removeOnPreDrawListener(this);
                                            int height = a.this.ySQ.getHeight();
                                            int width = a.this.ySQ.getWidth();
                                            if (height == 0) {
                                                height = com.tencent.mm.bu.a.aa(context, R.f.bwT);
                                            }
                                            if (width == 0) {
                                                width = com.tencent.mm.bu.a.aa(context, R.f.bwU);
                                            }
                                            if (a.this.ySR) {
                                                a = com.tencent.mm.sdk.platformtools.d.a(bitmap, R.g.bAE, width, height);
                                            } else {
                                                a = com.tencent.mm.sdk.platformtools.d.a(bitmap, R.g.bAQ, width, height);
                                            }
                                            a.this.ySQ.setBackgroundDrawable(new BitmapDrawable(a));
                                            return true;
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    this.yRA.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.g.bEi));
                    return;
                default:
                    this.ikL.setText(aVar.description);
                    this.ikM.setText(aVar.hdV);
                    this.yRA.setVisibility(0);
                    if (z) {
                        PG = o.PG();
                        B = o.PC().B(str, true);
                        imageView = this.yRA;
                        aVar2 = new com.tencent.mm.ap.a.a.c.a();
                        aVar2.hFq = 1;
                        aVar2 = aVar2.bc(ySS, ySS);
                        aVar2.hFA = R.k.dvO;
                        aVar2.hFJ = true;
                        PG.a(B, imageView, aVar2.PQ());
                        return;
                    }
                    this.yRA.setImageResource(R.g.bEi);
                    return;
            }
        }
    }
}
