package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.tf;
import com.tencent.mm.f.a.tg;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.Date;
import java.util.LinkedList;

public final class g extends b {
    int jXj = -1;

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ikM;
        ImageView jIs;

        public b(View view) {
            super(view);
            this.jIs = (ImageView) view.findViewById(R.h.cgK);
            this.ikL.setSingleLine(false);
            this.ikL.setMaxLines(2);
            this.ikM = (TextView) view.findViewById(R.h.cgz);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.e.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean yPQ = true;

        AnonymousClass1(boolean z) {
        }

        public final void run() {
            Object linkedList = new LinkedList();
            as.Hm();
            Cursor bI = c.Fh().bI(g.this.jXh, g.this.jXj);
            if (bI == null) {
                x.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
                return;
            }
            q hG;
            if (s.eX(g.this.jXh)) {
                as.Hm();
                hG = c.Fo().hG(g.this.jXh);
            } else {
                hG = null;
            }
            long j = 0;
            while (bI.moveToNext()) {
                try {
                    long b;
                    cg auVar = new au();
                    auVar.b(bI);
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
                        if (g.lY(bi.Wo(I.her)) || g.lY(auVar.getType())) {
                            Object obj;
                            String g = b.g(auVar, s.eX(g.this.jXh));
                            ag Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(g);
                            String str2 = "";
                            if (hG != null) {
                                str2 = hG.gw(g);
                            }
                            a aVar;
                            if (g.lY(auVar.getType())) {
                                aVar = new a(auVar.field_createTime, auVar.getType(), I.hdP, auVar.field_msgId, Xv.field_username, Xv.AW(), Xv.field_conRemark, str2);
                                com.tencent.mm.sdk.b.b tgVar = new tg();
                                tgVar.fMA.fFn = I.hdR;
                                com.tencent.mm.sdk.b.a.xmy.m(tgVar);
                                boolean z = auVar.field_isSend == 1 ? tgVar.fMB.fMC : !tgVar.fMB.fMC;
                                if (tgVar.fMB.status == -2) {
                                    z = false;
                                }
                                if (z) {
                                    int i;
                                    int i2 = tgVar.fMB.status;
                                    if (i2 <= 0) {
                                        i2 = I.hdO;
                                    }
                                    aVar.fqG = g.this.mContext.getResources().getString(R.l.eQA, new Object[]{aVar.fqG});
                                    switch (i2) {
                                        case 1:
                                        case 7:
                                            i = -352966;
                                            break;
                                        case 3:
                                            i = -470621;
                                            break;
                                        case 4:
                                            i = -470621;
                                            break;
                                        case 5:
                                            i = -470621;
                                            break;
                                        case 6:
                                            i = -470621;
                                            break;
                                        default:
                                            i = -352966;
                                            break;
                                    }
                                    aVar.yQB = i;
                                    aVar.desc = g.a(g.this, g.this.mContext, auVar, I, z, i2);
                                    Context context = g.this.mContext;
                                    if (I != null && context != null) {
                                        switch (i2) {
                                            case 1:
                                            case 7:
                                                i = R.k.dxq;
                                                break;
                                            case 3:
                                                i = R.k.dxr;
                                                break;
                                            case 4:
                                                i = R.k.dxs;
                                                break;
                                            case 5:
                                                i = R.k.dxr;
                                                break;
                                            case 6:
                                                i = R.k.dxp;
                                                break;
                                            default:
                                                i = R.k.dxq;
                                                break;
                                        }
                                    }
                                    i = R.k.dxq;
                                    aVar.iconRes = i;
                                    obj = aVar;
                                } else {
                                    x.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! pass this msg:%s", Long.valueOf(auVar.field_msgId));
                                }
                            } else {
                                aVar = new a(auVar.field_createTime, auVar.getType(), I.hem, auVar.field_msgId, Xv.field_username, Xv.AW(), Xv.field_conRemark, str2);
                                aVar.yQA = bi.Wo(I.her);
                                a obj2;
                                if (aVar.yQA == bi.Wo("1001")) {
                                    aVar.fqG = g.this.mContext.getResources().getString(R.l.eQy, new Object[]{aVar.fqG});
                                    aVar.desc = f.b(I, auVar.field_isSend == 1);
                                    aVar.yQB = f.d(I, auVar.field_isSend == 1);
                                    aVar.iconRes = f.a(I, auVar.field_isSend == 1);
                                    obj2 = aVar;
                                } else {
                                    com.tencent.mm.sdk.b.b tfVar = new tf();
                                    tfVar.fMv.fMx = I.hes;
                                    com.tencent.mm.sdk.b.a.xmy.m(tfVar);
                                    aVar.fqG = g.this.mContext.getResources().getString(R.l.eQz, new Object[]{aVar.fqG});
                                    aVar.desc = f.a(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1, I);
                                    int identifier = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.x.c) I.r(com.tencent.mm.x.c.class)).hcG, "drawable", ad.getPackageName());
                                    aVar.iconRes = f.r(tfVar.fMw.fMy, tfVar.fMw.fMz, auVar.field_isSend == 1);
                                    if (aVar.iconRes <= 0) {
                                        aVar.iconRes = identifier;
                                    }
                                    obj2 = aVar;
                                }
                            }
                            b = com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(auVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                            }
                            linkedList.add(obj2);
                            j = b;
                        }
                    }
                    b = j;
                    j = b;
                } finally {
                    bI.close();
                }
            }
            g.this.jXe.addAll(linkedList);
            g.this.yPX = g.this.jXe;
            linkedList.clear();
            ah.y(new Runnable() {
                public final void run() {
                    if (g.this.yPU != null) {
                        g.this.yPU.z(AnonymousClass1.this.yPQ, g.this.jXe.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String desc;
        public int iconRes;
        public int yQA;
        public int yQB = 0;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean ZM(String str) {
            if (str == null) {
                return false;
            }
            boolean ZM = super.ZM(str);
            if (ZM) {
                return ZM;
            }
            return this.title.contains(str);
        }

        public final int getType() {
            return this.type;
        }
    }

    static /* synthetic */ String a(g gVar, Context context, au auVar, com.tencent.mm.x.g.a aVar, boolean z, int i) {
        if (aVar == null || context == null) {
            return "";
        }
        switch (i) {
            case 1:
            case 7:
                as.Hm();
                com.tencent.mm.k.a Xu = c.Ff().Xu(auVar.field_talker);
                String AX = Xu != null ? Xu.AX() : auVar.field_talker;
                if (!z) {
                    return gVar.mContext.getString(R.l.dRy);
                }
                if (!bi.oN(aVar.heY)) {
                    return aVar.heY;
                }
                if (auVar.field_isSend != 1) {
                    return gVar.mContext.getString(R.l.dRD);
                }
                return gVar.mContext.getString(R.l.dRC, new Object[]{AX});
            case 3:
                if (z) {
                    return bi.oN(aVar.heY) ? ad.getContext().getString(R.l.dRx) : ad.getContext().getString(R.l.dRx) + "-" + aVar.heY;
                } else {
                    return ad.getContext().getString(R.l.dRy);
                }
            case 4:
                if (z) {
                    return bi.oN(aVar.heY) ? ad.getContext().getString(R.l.dRF) : ad.getContext().getString(R.l.dRF) + "-" + aVar.heY;
                } else {
                    return ad.getContext().getString(R.l.dRE);
                }
            case 5:
                if (z) {
                    return bi.oN(aVar.heY) ? ad.getContext().getString(R.l.dRA) : ad.getContext().getString(R.l.dRA) + "-" + aVar.heY;
                } else {
                    return ad.getContext().getString(R.l.dRB);
                }
            case 6:
                return context.getResources().getString(R.l.dRz);
            default:
                return aVar.description;
        }
    }

    public g(Context context) {
        super(context);
    }

    public final int getType() {
        return 5;
    }

    public static boolean lY(int i) {
        return bi.Wo("1001") == i || bi.Wo("1002") == i || 419430449 == i;
    }

    public final void cvf() {
        this.yPU.cvj();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dt().F(new AnonymousClass1(true));
    }

    public final String Xf() {
        return this.mContext.getString(R.l.eIO);
    }

    public final String cvi() {
        return this.mContext.getString(R.l.eIO);
    }

    public final e cvg() {
        return new e() {
            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                Context context = g.this.mContext;
                String str = g.this.jXh;
                long j = bVar.frh;
                if (str == null) {
                    x.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
                    return;
                }
                as.Hm();
                x.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(c.Fh().dI(j).field_msgId));
                if (s.eX(str)) {
                    as.Hm();
                    if (c.Fo().hG(str) == null) {
                        x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                        com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eEI), context.getString(R.l.cSb), null);
                        return;
                    }
                }
                as.Hm();
                ag Xv = c.Ff().Xv(str);
                if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                    if (Xv == null) {
                        x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                    } else {
                        x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                    }
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eEI), context.getString(R.l.cSb), null);
                    return;
                }
                com.tencent.mm.plugin.chatroom.a.ihN.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j), context);
            }

            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
            }
        };
    }

    public final t l(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dih, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FW(i);
        if (bi.oN(aVar2.desc)) {
            bVar.ikM.setVisibility(8);
        } else {
            bVar.ikM.setVisibility(0);
            bVar.ikM.setText(bi.aD(aVar2.desc, ""));
        }
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 6);
        bVar.jIs.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        bVar.jIs.setImageResource(aVar2.iconRes);
        bVar.jIs.setBackgroundColor(aVar2.yQB);
    }
}
