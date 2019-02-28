package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ak;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.kh;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.f.a.qo;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import java.util.ArrayList;
import java.util.List;

public final class t implements e {
    final Context context;
    int fqW;
    int fqX;
    public int kzv = 0;
    c myb = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mt mtVar = (mt) bVar;
            if (t.this.rzn == null || t.this.ryF == null) {
                x.e("MicroMsg.GalleryTitleManager", "not in recoging");
            } else if (mtVar == null || !(mtVar instanceof mt)) {
                x.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
            } else if (mtVar.fFy.filePath.equals(t.this.ryF)) {
                x.i("MicroMsg.GalleryTitleManager", "recog result: " + mtVar.fFy.result);
                if (!bi.oN(mtVar.fFy.result)) {
                    t.this.ryI = mtVar.fFy.result;
                    t.this.fqW = mtVar.fFy.fqW;
                    t.this.fqX = mtVar.fFy.fqX;
                    if (!(t.this.ryI == null || t.this.rzn == null)) {
                        t.this.ryJ = true;
                    }
                    t.this.a(t.this.rzo, t.this.qEj, t.this.rzp, false, 0);
                }
                t.this.ryF = null;
            } else {
                x.e("MicroMsg.GalleryTitleManager", "not same filepath");
            }
            return false;
        }
    };
    m qEj;
    String ryF;
    String ryI;
    boolean ryJ = false;
    c ryL = new c<kh>() {
        {
            this.xmG = kh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kh khVar = (kh) bVar;
            if (khVar == null || !(khVar instanceof kh)) {
                x.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                x.i("MicroMsg.GalleryTitleManager", "notify Event: %d", Integer.valueOf(khVar.fCx.fCv));
                if (!(khVar.fCx.activity == ((Activity) t.this.context) && khVar.fCx.fpo.equals(t.this.ryI))) {
                    x.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            return false;
        }
    };
    SnsCmdList rzl = new SnsCmdList();
    private final a rzm;
    g rzn = null;
    boolean rzo;
    are rzp;
    private final String rzq;
    public r tipDialog = null;
    String uT;

    /* renamed from: com.tencent.mm.plugin.sns.ui.t$9 */
    class AnonymousClass9 implements OnCancelListener {
        final /* synthetic */ q rzy;

        AnonymousClass9(q qVar) {
            this.rzy = qVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.c(this.rzy);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.t$8 */
    class AnonymousClass8 implements OnCancelListener {
        final /* synthetic */ q rzx;

        AnonymousClass8(q qVar) {
            this.rzx = qVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            if (t.this.kzv != 0) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.c(this.rzx);
                t.this.kzv = 0;
            }
        }
    }

    public interface a {
        void asq();

        void bAa();

        void ck(String str, int i);

        void cl(String str, int i);

        void ew(String str, String str2);
    }

    static /* synthetic */ void Mv(String str) {
        b qoVar = new qo();
        qoVar.fIT.fvG = 3;
        qoVar.fIT.fvn = str;
        com.tencent.mm.sdk.b.a.xmy.m(qoVar);
    }

    static /* synthetic */ void Mw(String str) {
        b qoVar = new qo();
        qoVar.fIT.fvG = 1;
        qoVar.fIT.fIW = 2;
        qoVar.fIT.fvn = str;
        com.tencent.mm.sdk.b.a.xmy.m(qoVar);
    }

    static /* synthetic */ void a(t tVar, Bundle bundle) {
        x.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        b caVar = new ca();
        caVar.fqV.activity = (Activity) tVar.context;
        caVar.fqV.fpo = tVar.ryI;
        caVar.fqV.fqW = tVar.fqW;
        caVar.fqV.fqX = tVar.fqX;
        caVar.fqV.frc = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(caVar);
    }

    static /* synthetic */ void a(t tVar, m mVar, are are) {
        cg cgVar;
        if (mVar == null) {
            x.i("MicroMsg.GalleryTitleManager", "error beacause info null");
        } else if (mVar.field_type == 1) {
            cgVar = new cg();
            com.tencent.mm.plugin.sns.i.a.a(cgVar, mVar, are.nMq);
            cgVar.frk.activity = (Activity) tVar.context;
            cgVar.frk.frr = 15;
            com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        } else if (mVar == null) {
        } else {
            if (mVar.xD(32)) {
                cgVar = new cg();
                com.tencent.mm.plugin.sns.i.a.a(cgVar, mVar);
                cgVar.frk.activity = (Activity) tVar.context;
                cgVar.frk.frr = 16;
                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                return;
            }
            String bza = mVar.bza();
            b qoVar = new qo();
            qoVar.fIT.fvG = 2;
            qoVar.fIT.fIU = 16;
            qoVar.fIT.fIV = false;
            qoVar.fIT.fvn = bza;
            com.tencent.mm.sdk.b.a.xmy.m(qoVar);
        }
    }

    static /* synthetic */ void a(t tVar, m mVar, are are, int i) {
        if (mVar == null) {
            x.e("MicroMsg.GalleryTitleManager", "error beacause info null");
            return;
        }
        Intent intent = new Intent();
        if (mVar.field_type == 1) {
            intent.putExtra("sns_send_data_ui_image_path", FlipView.f(am.r(ae.getAccSnsPath(), are.nMq) + i.l(are), tVar.context));
            intent.putExtra("sns_send_data_ui_image_position", i);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", mVar.bza());
        d.a(tVar.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
    }

    public final void xJ(int i) {
        if (i != 0) {
            this.rzl.wL(i);
        }
    }

    public t(Context context, a aVar) {
        this.context = context;
        this.rzm = aVar;
        this.rzq = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
    }

    public final void bzZ() {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rzl);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
    }

    public final void a(boolean z, final m mVar, final are are, boolean z2, final int i) {
        b diVar;
        this.rzo = z;
        this.qEj = mVar;
        this.rzp = are;
        this.uT = are.nMq;
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        if (!z) {
            mVar.byF();
            arrayList.add(this.context.getString(j.eQm));
            arrayList2.add(Integer.valueOf(3));
            if (d.Pu("favorite")) {
                arrayList.add(this.context.getString(j.eAq));
                arrayList2.add(Integer.valueOf(6));
            }
            if (mVar.field_type == 15 || mVar.field_type == 5) {
                arrayList.add(this.context.getString(j.eHu));
                arrayList2.add(Integer.valueOf(2));
            } else if (mVar.field_type == 1) {
                arrayList.add(this.context.getString(j.eHr));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.qSd));
                arrayList2.add(Integer.valueOf(2));
            }
            diVar = new di();
            diVar.fsL.fsC = mVar.bza();
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            if (diVar.fsM.fsk) {
                arrayList.add(this.context.getString(j.qPx));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.ryI != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.aF(this.fqW, this.ryI) ? this.context.getString(j.eCE) : this.context.getString(j.eCD));
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.rzn == null || !this.ryJ) {
                    this.rzn = new g(this.context, g.zCt, false);
                } else {
                    this.ryJ = false;
                }
                this.rzn.rQF = new p.c() {
                    public final void a(n nVar) {
                        nVar.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                nVar.f(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                };
                this.rzn.rQG = new p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        int itemId = menuItem.getItemId();
                        x.d("MicroMsg.GalleryTitleManager", "showAlert " + itemId);
                        switch (itemId) {
                            case 2:
                                if (mVar != null && mVar.byF().wYj != null) {
                                    if (mVar.field_type != 15) {
                                        k.h(am.r(ae.getAccSnsPath(), are.nMq) + i.l(are), t.this.context);
                                        return;
                                    } else {
                                        t.Mv(mVar.bza());
                                        return;
                                    }
                                }
                                return;
                            case 3:
                                if (mVar != null && mVar.byF().wYj != null) {
                                    if (mVar.byF().wYj.wfg == 1) {
                                        t.this.Mu(am.r(ae.getAccSnsPath(), are.nMq) + i.l(are));
                                        return;
                                    }
                                    t.Mw(mVar.bza());
                                    return;
                                }
                                return;
                            case 4:
                                t tVar = t.this;
                                long j = mVar.field_snsId;
                                m eS = ae.bwf().eS(j);
                                if (j != 0 && eS != null) {
                                    Intent intent = new Intent();
                                    intent.putExtra("k_username", eS.field_userName);
                                    intent.putExtra("k_expose_msg_id", j);
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                    d.b(tVar.context, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                                return;
                            case 6:
                                if (mVar != null && mVar.byF().wYj != null) {
                                    t.a(t.this, mVar, are);
                                    return;
                                }
                                return;
                            case 7:
                                Bundle bundle = new Bundle();
                                bundle.putString("stat_msg_id", "sns_" + i.er(mVar.field_snsId));
                                bundle.putString("stat_send_msg_user", mVar.field_userName);
                                bundle.putInt("stat_scene", 3);
                                t.a(t.this, bundle);
                                return;
                            case 8:
                                t.a(t.this, mVar, are, i);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.rzn.bUX();
            }
        } else if (mVar != null) {
            if (mVar.field_localPrivate > 0) {
                if (!bi.oN(ae.bvL()) && ae.bvL().equals(mVar.field_userName)) {
                    arrayList.add(this.context.getString(j.qSi));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(j.eQm));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(j.qSj));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(j.eQm));
                arrayList2.add(Integer.valueOf(3));
            }
            if (d.Pu("favorite")) {
                arrayList.add(this.context.getString(j.eAq));
                arrayList2.add(Integer.valueOf(6));
            }
            if (mVar.field_type == 15 || mVar.field_type == 5) {
                arrayList.add(this.context.getString(j.eHu));
                arrayList2.add(Integer.valueOf(2));
            } else if (mVar.field_type == 1) {
                arrayList.add(this.context.getString(j.eHr));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.qSd));
                arrayList2.add(Integer.valueOf(2));
            }
            diVar = new di();
            diVar.fsL.fsC = mVar.bza();
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            if (diVar.fsM.fsk) {
                arrayList.add(this.context.getString(j.qPx));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.ryI != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.aF(this.fqW, this.ryI) ? this.context.getString(j.eCE) : this.context.getString(j.eCD));
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.rzn == null || !this.ryJ) {
                this.rzn = new g(this.context, g.zCt, false);
            } else {
                this.ryJ = false;
            }
            this.rzn.rQF = new p.c() {
                public final void a(n nVar) {
                    nVar.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            nVar.f(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                            i = i2 + 1;
                        } else {
                            nVar.f(-1, t.this.context.getString(j.qQv));
                            return;
                        }
                    }
                }
            };
            this.rzn.rQG = new p.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    x.d("MicroMsg.GalleryTitleManager", "showAlertWithDel " + itemId);
                    t tVar;
                    com.tencent.mm.ad.k qVar;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (mVar.byF().wYj.wfh.size() > 1) {
                                h.a(t.this.context, t.this.context.getString(j.qRT), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        t.this.A(mVar);
                                    }
                                }, null);
                                return;
                            } else {
                                h.a(t.this.context, t.this.context.getString(j.qRR), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        t.this.A(mVar);
                                    }
                                }, null);
                                return;
                            }
                        case 1:
                            tVar = t.this;
                            m mVar = mVar;
                            if (mVar.bzb() || mVar.bzc()) {
                                ae.bwf().xH(mVar.ruM);
                                return;
                            }
                            qVar = new q(mVar.field_snsId, 2);
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dp().gRu.a(qVar, 0);
                            context = tVar.context;
                            tVar.context.getString(j.dGZ);
                            tVar.tipDialog = h.a(context, tVar.context.getString(j.qSg), true, new AnonymousClass8(qVar));
                            return;
                        case 2:
                            if (mVar != null && mVar.byF().wYj != null) {
                                if (mVar.field_type != 15) {
                                    k.h(am.r(ae.getAccSnsPath(), are.nMq) + i.l(are), t.this.context);
                                    return;
                                } else {
                                    t.Mv(mVar.bza());
                                    return;
                                }
                            }
                            return;
                        case 3:
                            if (mVar != null && mVar.byF().wYj != null) {
                                if (mVar.byF().wYj.wfg == 1) {
                                    t.this.Mu(am.r(ae.getAccSnsPath(), are.nMq) + i.l(are));
                                    return;
                                }
                                t.Mw(mVar.bza());
                                return;
                            }
                            return;
                        case 5:
                            tVar = t.this;
                            qVar = new q(mVar.field_snsId, 3);
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dp().gRu.a(qVar, 0);
                            context = tVar.context;
                            tVar.context.getString(j.dGZ);
                            tVar.tipDialog = h.a(context, tVar.context.getString(j.qSg), true, new AnonymousClass9(qVar));
                            return;
                        case 6:
                            if (mVar != null && mVar.byF().wYj != null) {
                                t.a(t.this, mVar, are);
                                return;
                            }
                            return;
                        case 7:
                            Bundle bundle = new Bundle();
                            bundle.putString("stat_msg_id", "sns_" + i.er(mVar.field_snsId));
                            bundle.putString("stat_send_msg_user", mVar.field_userName);
                            bundle.putInt("stat_scene", 3);
                            t.a(t.this, bundle);
                            return;
                        case 8:
                            t.a(t.this, mVar, are, i);
                            return;
                        default:
                            return;
                    }
                }
            };
            this.rzn.zCF = new com.tencent.mm.ui.widget.g.a() {
                public final void onDismiss() {
                    b akVar = new ak();
                    akVar.fpp.filePath = t.this.ryF;
                    com.tencent.mm.sdk.b.a.xmy.m(akVar);
                    t.this.rzn = null;
                    t.this.ryF = null;
                    t.this.qEj = null;
                    t.this.uT = null;
                    t.this.ryI = null;
                    t tVar = t.this;
                    t.this.fqX = 0;
                    tVar.fqW = 0;
                }
            };
            this.rzn.bUX();
        } else {
            return;
        }
        if (true == z2) {
            com.tencent.mm.kernel.g.Dr();
            if (com.tencent.mm.kernel.g.Dp().gRu.Ks() != 0) {
                diVar = new mr();
                String str = am.r(ae.getAccSnsPath(), this.uT) + i.l(are);
                diVar.fFv.filePath = str;
                this.ryF = str;
                com.tencent.mm.sdk.b.a.xmy.m(diVar);
            }
        }
    }

    protected final void A(m mVar) {
        if (mVar.bzb() || mVar.bzc()) {
            ae.bwf().xH(mVar.ruM);
            this.rzl.wL(mVar.ruM);
            return;
        }
        ae.bwe().eE(mVar.field_snsId);
        final com.tencent.mm.ad.k qVar = new q(mVar.field_snsId, 1);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(qVar, 0);
        Context context = this.context;
        this.context.getString(j.dGZ);
        this.tipDialog = h.a(context, this.context.getString(j.qQw), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (t.this.kzv != 0) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.c(qVar);
                    t.this.kzv = 0;
                }
            }
        });
    }

    protected final void Mu(String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.c.a.ihN.l(intent, this.context);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (i == 0 && i2 == 0 && kVar != null) {
            x.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            q qVar = (q) kVar;
            switch (qVar.type) {
                case -1:
                    this.rzm.ck("", qVar.type);
                    return;
                case 1:
                    this.rzl.wL(qVar.qXb);
                    this.rzm.ck(u.ag("sns_table_", (long) qVar.qXb), qVar.type);
                    return;
                case 2:
                    this.rzl.wM(qVar.qXb);
                    this.rzm.ck("", qVar.type);
                    return;
                case 3:
                    this.rzl.wM(qVar.qXb);
                    this.rzm.ck(u.ag("sns_table_", (long) qVar.qXb), qVar.type);
                    return;
                default:
                    return;
            }
        }
    }
}
