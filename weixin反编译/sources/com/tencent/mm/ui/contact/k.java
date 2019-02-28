package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.be.b;
import com.tencent.mm.be.c;
import com.tencent.mm.be.f;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.fo;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

public final class k extends RelativeLayout {
    public static Boolean zbr = Boolean.valueOf(true);
    private Context context = null;
    private boolean isVisible = true;
    private View mcj = null;
    private View zbs = null;
    private final al zbt = new al(new a() {
        public final boolean uG() {
            x.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            k.cwK();
            k.this.init();
            return false;
        }
    }, true);
    j.a zbu = new j.a() {
        public final void a(String str, l lVar) {
            x.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!k.this.zbt.cgx()) {
                k.this.zbt.TN();
            }
            al b = k.this.zbt;
            long j = k.this.zbv ? 500 : 1000;
            b.K(j, j);
        }
    };
    boolean zbv = false;

    public k(Context context) {
        super(context);
        this.context = context;
        com.tencent.mm.be.l.TE().c(this.zbu);
        cwK();
        init();
    }

    private void init() {
        c TE = com.tencent.mm.be.l.TE();
        x.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", Integer.valueOf(4));
        List arrayList = new ArrayList();
        Cursor a = TE.gLA.a(new StringBuilder("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4").toString(), null, 2);
        while (a.moveToNext()) {
            b bVar = new b();
            bVar.b(a);
            if (!bi.oN(bVar.field_talker)) {
                arrayList.add(bVar);
            }
        }
        a.close();
        int size = arrayList.size();
        x.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            if (this.context == null) {
                x.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            } else {
                this.mcj = View.inflate(this.context, R.i.diu, this);
                this.zbs = this.mcj.findViewById(R.h.ciD);
                LayoutParams layoutParams = this.zbs.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bu.a.ab(this.context, R.f.buB)) * com.tencent.mm.bu.a.ey(this.context));
                this.zbs.setLayoutParams(layoutParams);
                this.mcj.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
                        d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                MaskLayout maskLayout = (MaskLayout) this.mcj.findViewById(R.h.cip);
                n.JF();
                ((ImageView) maskLayout.view).setImageBitmap(com.tencent.mm.ac.d.ji("fmessage"));
            }
        } else if (size == 1) {
            b bVar2 = (b) arrayList.get(0);
            if (this.context == null) {
                x.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            } else {
                CharSequence string;
                if (com.tencent.mm.bu.a.ez(this.context)) {
                    this.mcj = View.inflate(this.context, R.i.dix, this);
                } else {
                    this.mcj = View.inflate(this.context, R.i.diw, this);
                }
                ((TextView) this.mcj.findViewById(R.h.ciI)).setText(i.a(this.context, bVar2.field_displayName));
                TextView textView = (TextView) this.mcj.findViewById(R.h.ciH);
                f na = com.tencent.mm.be.l.TD().na(bVar2.field_talker);
                Context context = this.context;
                int i = na.field_type;
                int i2 = bVar2.field_addScene;
                String str = na.field_msgContent;
                x.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(!na.Tv()));
                if (i == 0) {
                    if (str != null) {
                        au.a XY = au.a.XY(str);
                        switch (XY.scene) {
                            case 4:
                                string = context.getString(R.l.dRc);
                                break;
                            case 10:
                            case 11:
                                com.tencent.mm.sdk.b.b foVar = new fo();
                                foVar.fvM.fvJ = XY.xHI;
                                foVar.fvM.fvK = XY.xHJ;
                                com.tencent.mm.sdk.b.a.xmy.m(foVar);
                                string = context.getString(R.l.dRf, new Object[]{bi.aD(foVar.fvN.fvO, "")});
                                break;
                            case 31:
                                string = context.getString(R.l.dRo);
                                break;
                            case 32:
                                string = context.getString(R.l.dRi);
                                break;
                            case 58:
                            case 59:
                            case 60:
                                string = context.getString(R.l.dRd);
                                break;
                            default:
                                string = context.getString(R.l.dRh);
                                break;
                        }
                    }
                    x.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
                    string = null;
                } else if (r2) {
                    Object string2 = str;
                } else {
                    au.d Yb = au.d.Yb(str);
                    string2 = (Yb.content == null || Yb.content.trim().equals("")) ? context.getString(R.l.eit) : Yb.content;
                }
                if (t.oN(string2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(string2);
                }
                this.zbs = this.mcj.findViewById(R.h.ciu);
                this.mcj.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(143618, Integer.valueOf(0));
                        d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) ((MaskLayout) this.mcj.findViewById(R.h.cip)).view, bVar2.field_talker);
            }
        } else if (this.context == null) {
            x.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        } else {
            this.mcj = View.inflate(this.context, R.i.div, this);
            int size2 = arrayList.size();
            x.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size2));
            MaskLayout maskLayout2 = (MaskLayout) this.mcj.findViewById(R.h.cip);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(0)).field_talker);
            maskLayout2.setVisibility(0);
            maskLayout2 = (MaskLayout) this.mcj.findViewById(R.h.ciq);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(1)).field_talker);
            maskLayout2.setVisibility(0);
            if (size2 > 2) {
                maskLayout2 = (MaskLayout) this.mcj.findViewById(R.h.cir);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(2)).field_talker);
                maskLayout2.setVisibility(0);
            }
            if (size2 > 3) {
                maskLayout2 = (MaskLayout) this.mcj.findViewById(R.h.cis);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(3)).field_talker);
                maskLayout2.setVisibility(0);
            }
            this.zbs = this.mcj.findViewById(R.h.ciu);
            this.zbs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(143618, Integer.valueOf(0));
                    d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                }
            });
        }
        View findViewById = this.mcj.findViewById(R.h.ciu);
        if (findViewById != null) {
            findViewById.setVisibility(this.isVisible ? 0 : 8);
        }
        this.zbs.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (k.this.context instanceof MMActivity) {
                    ((MMActivity) k.this.context).aWY();
                }
                return false;
            }
        });
        int Ts = com.tencent.mm.be.l.TE().Ts();
        x.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(Ts));
        TextView textView2 = (TextView) this.mcj.findViewById(R.h.ciB);
        textView2.setBackgroundResource(s.ge(this.context));
        if (Ts <= 0) {
            textView2.setVisibility(8);
            zbr = Boolean.valueOf(false);
            return;
        }
        textView2.setVisibility(0);
        zbr = Boolean.valueOf(true);
        if (Ts > 99) {
            textView2.setText(getContext().getString(R.l.eSf));
        } else {
            textView2.setText(String.valueOf(Ts));
        }
    }

    private static void cwK() {
        int Ts = com.tencent.mm.be.l.TE().Ts();
        x.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(Ts));
        if (Ts > 0) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(143618, Integer.valueOf(Ts));
        }
    }

    public static void cwL() {
        as.Hm();
        if (com.tencent.mm.y.c.Fa()) {
            as.Hm();
            if (com.tencent.mm.y.c.Db().getInt(143618, 0) > 0) {
                aj.S("fmessage", 2);
            }
        }
        as.Hm();
        com.tencent.mm.y.c.Db().set(143618, Integer.valueOf(0));
    }
}
