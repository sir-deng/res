package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.y.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsUserUI extends MMActivity implements com.tencent.mm.plugin.sns.b.h.a {
    private String jPV;
    private c jil = new c<jt>() {
        {
            this.xmG = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jt jtVar = (jt) bVar;
            if (jtVar instanceof jt) {
                switch (jtVar.fBu.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        SnsUserUI.this.rRZ.notifyDataSetChanged();
                        break;
                }
            }
            return false;
        }
    };
    private boolean rNY = false;
    private OnMenuItemClickListener rOI = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            SnsUserUI.this.finish();
            return true;
        }
    };
    private String rOd;
    private boolean rOe;
    private int rOf;
    private at rRZ;
    private bb rSa;
    private com.tencent.mm.plugin.sns.model.al.a rSb;
    private com.tencent.mm.plugin.sns.ui.bb.a rSc;
    private Runnable rSd = new Runnable() {
        public final void run() {
            SnsUserUI.this.rRZ.bCb();
            SnsUserUI.this.rRZ.bAd();
        }
    };
    private boolean rzo;

    class a extends f {
        private ba rON = null;

        a() {
        }

        public void dJ(int i, int i2) {
            x.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(SnsUserUI.this.rzo));
            if (SnsUserUI.this.rzo && i2 == -1) {
                this.rON = new ba(SnsUserUI.this);
                this.rON.rQF = new p.c() {
                    public final void a(n nVar) {
                        nVar.f(0, SnsUserUI.this.getString(j.dFh));
                        nVar.f(1, SnsUserUI.this.getString(j.dFl));
                    }
                };
                this.rON.d(0, SnsUserUI.this.mController.xRr.getString(j.qPw));
                this.rON.rQG = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                g.pWK.h(13822, Integer.valueOf(1), Integer.valueOf(2));
                                SnsUserUI.this.bCR();
                                return;
                            case 1:
                                g.pWK.h(13822, Integer.valueOf(2), Integer.valueOf(2));
                                SnsUserUI.this.rSa.yi(1);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.rON.bCH();
                return;
            }
            Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
            intent.putExtra("sns_gallery_userName", SnsUserUI.this.jPV);
            intent.putExtra("sns_gallery_is_self", SnsUserUI.this.rzo);
            intent.putExtra("sns_gallery_localId", i);
            intent.putExtra("sns_source", SnsUserUI.this.rOf);
            intent.putExtra("sns_gallery_st_time", SnsUserUI.this.rRZ.rLf);
            intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.rRZ.rLg);
            if (SnsUserUI.this.rRZ != null) {
                intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.rRZ.mgB);
                SnsUserUI.this.rSb.h(SnsUserUI.this.jPV, SnsUserUI.this.rRZ.dI(i, i2));
                intent.putExtra("sns_gallery_position", SnsUserUI.this.rRZ.rLj);
            }
            SnsUserUI.this.startActivityForResult(intent, 8);
        }

        public final void dK(int i, int i2) {
            m xG = ae.bwf().xG(i);
            if (xG != null) {
                if (xG.field_type == 15) {
                    Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
                    intent.putExtra("sns_gallery_userName", SnsUserUI.this.jPV);
                    intent.putExtra("sns_gallery_is_self", SnsUserUI.this.rzo);
                    intent.putExtra("sns_gallery_localId", i);
                    intent.putExtra("sns_source", SnsUserUI.this.rOf);
                    intent.putExtra("sns_gallery_st_time", SnsUserUI.this.rRZ.rLf);
                    intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.rRZ.rLg);
                    if (SnsUserUI.this.rRZ != null) {
                        intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.rRZ.mgB);
                        SnsUserUI.this.rSb.h(SnsUserUI.this.jPV, SnsUserUI.this.rRZ.dI(i, i2));
                        intent.putExtra("sns_gallery_position", SnsUserUI.this.rRZ.rLj);
                    }
                    SnsUserUI.this.startActivityForResult(intent, 8);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", xG.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", u.ag("sns_table_", (long) i));
                SnsUserUI.this.startActivityForResult(intent2, 12);
            }
        }

        public final void yb(int i) {
            m xG = ae.bwf().xG(i);
            if (xG != null) {
                Intent intent = new Intent();
                intent.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", xG.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", u.ag("sns_table_", (long) i));
                SnsUserUI.this.startActivityForResult(intent, 12);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (this.mController != null) {
            this.mController.ae(2, false);
        }
        super.onCreate(bundle);
        if (com.tencent.mm.kernel.g.Do().CF()) {
            ag Xv;
            this.rSb = ae.bvV();
            this.rOf = getIntent().getIntExtra("sns_source", 0);
            this.jPV = getIntent().getStringExtra("sns_userName");
            if (this.jPV == null) {
                this.jPV = "";
            }
            com.tencent.mm.kernel.g.Dr();
            this.rOe = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xr(this.jPV);
            this.rOd = q.FY();
            this.rzo = this.rOd.equals(this.jPV);
            ar bvT = ae.bvT();
            String aD = bi.aD(getIntent().getStringExtra("sns_signature"), "");
            String aD2 = bi.aD(getIntent().getStringExtra("sns_nickName"), "");
            if (this.jPV == null || this.jPV.equals("")) {
                Xv = bvT.Xv(this.rOd);
            } else {
                Xv = bvT.Xv(this.jPV);
            }
            if (Xv != null && ((int) Xv.gKO) > 0) {
                aD = Xv.signature;
                aD2 = Xv.AW();
                x.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", Xv.field_username, Integer.valueOf((int) Xv.gKO), aD2);
            }
            this.rSa = new bb(this);
            this.rSa.a(this.rOd, this.jPV, aD2, aD, this.rOe, this.rzo, this.rOf);
            bb bbVar = this.rSa;
            com.tencent.mm.plugin.sns.ui.bb.a anonymousClass4 = new com.tencent.mm.plugin.sns.ui.bb.a() {
                public final void bCt() {
                    if (SnsUserUI.this.rSb == null) {
                        SnsUserUI.this.rSb = ae.bvV();
                    }
                    com.tencent.mm.plugin.sns.model.al.a b = SnsUserUI.this.rSb;
                    String c = SnsUserUI.this.jPV;
                    SnsUserUI.this.rOe;
                    b.b(2, c, SnsUserUI.this.rzo, SnsUserUI.this.rOf);
                    ae.aOA().postDelayed(SnsUserUI.this.rSd, 3000);
                }

                public final ListView bCu() {
                    return (ListView) SnsUserUI.this.findViewById(f.qLj);
                }

                public final MMPullDownView bCv() {
                    return (MMPullDownView) SnsUserUI.this.findViewById(f.qLq);
                }

                public final int getType() {
                    return 2;
                }

                public final void a(int i, List<Integer> list, List<Integer> list2) {
                    at a;
                    if (!(i == -1 || SnsUserUI.this.rRZ == null)) {
                        a = SnsUserUI.this.rRZ;
                        if (a.rLd != null) {
                            au auVar = a.rLd;
                            m xG = ae.bwf().xG(i);
                            if (!(xG == null || xG.byF().wYj == null || auVar.list.size() <= 0)) {
                                auVar.list.add(1, xG);
                                auVar.bCd();
                                auVar.bCe();
                            }
                        }
                    }
                    if (SnsUserUI.this.rRZ != null && list != null && list2 != null) {
                        a = SnsUserUI.this.rRZ;
                        if (a.rLd != null && list != null && list2 != null && list.size() + list2.size() != 0) {
                            int i2;
                            m mVar;
                            au auVar2 = a.rLd;
                            if (!(list == null || list.size() == 0)) {
                                x.d("MicroMsg.SnsSelfHelper", "remove Items");
                                for (Integer intValue : list) {
                                    int intValue2 = intValue.intValue();
                                    int size = auVar2.list.size();
                                    for (i2 = 1; i2 < size; i2++) {
                                        mVar = (m) auVar2.list.get(i2);
                                        if (mVar != null && mVar.ruM == intValue2) {
                                            auVar2.list.remove(i2);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!(list2 == null || list2.size() == 0)) {
                                x.d("MicroMsg.SnsSelfHelper", "change Items");
                                LinkedList linkedList = new LinkedList();
                                i2 = 1;
                                while (i2 < auVar2.list.size()) {
                                    mVar = (m) auVar2.list.get(i2);
                                    if (mVar != null) {
                                        for (Integer intValue3 : list2) {
                                            int intValue4 = intValue3.intValue();
                                            if (mVar.ruM == intValue4) {
                                                x.d("MicroMsg.SnsSelfHelper", "update list localId " + intValue4);
                                                auVar2.list.remove(i2);
                                                linkedList.add(ae.bwf().xG(intValue4));
                                                i2--;
                                                break;
                                            }
                                        }
                                    }
                                    i2++;
                                }
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    auVar2.list.add((m) it.next());
                                }
                            }
                            auVar2.bCd();
                            auVar2.bCe();
                        }
                    }
                }

                public final boolean bCw() {
                    return false;
                }

                public final void bCx() {
                    com.tencent.mm.plugin.sns.model.al.a b = SnsUserUI.this.rSb;
                    String c = SnsUserUI.this.jPV;
                    SnsUserUI.this.rOe;
                    b.a(2, c, SnsUserUI.this.rzo, SnsUserUI.this.rOf);
                }

                public final void bCy() {
                }

                public final void ye(int i) {
                }

                public final void M(int i, boolean z) {
                    Object obj = null;
                    if (SnsUserUI.this.rRZ != null) {
                        at a = SnsUserUI.this.rRZ;
                        if (a.rLd != null) {
                            au auVar = a.rLd;
                            m xG = ae.bwf().xG(i);
                            if (xG != null && xG.byF().wYj != null && auVar.list.size() > 0) {
                                for (int i2 = 0; i2 < auVar.list.size(); i2++) {
                                    if (((m) auVar.list.get(i2)).bza() == xG.bza()) {
                                        obj = 1;
                                        auVar.list.remove(i2);
                                        break;
                                    }
                                }
                                if (obj != null) {
                                    auVar.list.add(xG);
                                    auVar.bCd();
                                    auVar.bCe();
                                }
                            }
                        }
                    }
                }

                public final void iQ(boolean z) {
                }
            };
            this.rSc = anonymousClass4;
            bbVar.rRm = anonymousClass4;
            this.rSa.onCreate();
            if (getIntent().getExtras() != null) {
                getIntent().getExtras().setClassLoader(getClass().getClassLoader());
            }
            initView();
            com.tencent.mm.sdk.b.a.xmy.b(this.jil);
            return;
        }
        finish();
    }

    public void onDestroy() {
        this.rNY = true;
        com.tencent.mm.sdk.b.a.xmy.c(this.jil);
        com.tencent.mm.modelsns.b q = com.tencent.mm.modelsns.b.q(getIntent());
        if (q != null) {
            q.update();
            q.SE();
        }
        if (!(this.rSa == null || this.rSa.tipDialog == null)) {
            this.rSa.tipDialog.dismiss();
            this.rSa.tipDialog = null;
        }
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Do().CF() && this.rSb != null) {
            this.rSb.a(this, this.rSc.getType());
        }
        if (this.rSa != null) {
            this.rSa.onDestroy();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return i.g.qNP;
    }

    public void onResume() {
        if (this.rRZ != null) {
            this.rRZ.notifyDataSetChanged();
        }
        cnL();
        setRequestedOrientation(-1);
        if (this.rzo) {
            this.mController.addIconOptionMenu(0, getString(j.qRG), i.i.qOz, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(SnsUserUI.this, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    SnsUserUI.this.startActivityForResult(intent, 8);
                    return true;
                }
            });
        } else {
            enableOptionMenu(false);
        }
        setBackBtn(this.rOI, e.byz);
        if (this.rzo) {
            setMMTitle(j.qRS);
        } else {
            CharSequence AX;
            x.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", this.jPV, this.rSa.title);
            com.tencent.mm.k.a Xv = ae.bvT().Xv(this.jPV);
            if (Xv != null) {
                x.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                AX = Xv.AX();
            } else {
                x.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", this.rSa.title);
                AX = this.rSa.title;
            }
            setMMTitle(com.tencent.mm.plugin.sns.data.i.A(AX));
        }
        bb.onResume();
        super.onResume();
    }

    public void onPause() {
        bb.onPause();
        super.onPause();
    }

    protected final void initView() {
        this.rRZ = new at(this, new a() {
            public final void dJ(int i, int i2) {
                super.dJ(i, i2);
            }
        }, this.jPV, new at.c() {
        });
        this.rSa.nQn.setAdapter(this.rRZ);
        this.rSa.nQn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.rSa.nQn.postDelayed(new Runnable() {
            public final void run() {
                if (SnsUserUI.this.rNY) {
                    x.w("MicroMsg.SnsUserUI", "too fast that it finish");
                    return;
                }
                SnsUserUI.this.rSb.a(SnsUserUI.this.rSc.getType(), SnsUserUI.this.jPV, SnsUserUI.this);
                if (SnsUserUI.this.rSc.getType() == 1 && SnsUserUI.this.rSc.bCw()) {
                    ae.bvV().y(ae.bwm().rdk, -1);
                }
                if (!SnsUserUI.this.rSc.bCw()) {
                    com.tencent.mm.plugin.sns.model.al.a b = SnsUserUI.this.rSb;
                    int type = SnsUserUI.this.rSc.getType();
                    String c = SnsUserUI.this.jPV;
                    SnsUserUI.this.rOe;
                    b.a(type, c, SnsUserUI.this.rzo, SnsUserUI.this.rOf);
                }
            }
        }, 500);
        setBackBtn(this.rOI, e.byz);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        if (this.rRZ != null) {
            this.rRZ.rCC = str;
            if (str.compareTo(this.rRZ.mgB) < 0) {
                x.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", str, this.rRZ.mgB, Boolean.valueOf(z));
                this.rRZ.bCb();
            } else {
                x.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", str, this.rRZ.mgB, Boolean.valueOf(z));
            }
            this.rRZ.bAd();
        }
        if (!z4 || this.rOd.equals(this.jPV)) {
            if (this.rOd.equals(this.jPV) && j != 0) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
                this.rRZ.eX(j);
            }
            this.rSa.rRk = z2;
            if (z2) {
                this.rSa.iJ(false);
            } else if (z) {
                this.rSb.b(this.rSc.getType(), this.jPV, this.rzo, this.rOf);
            }
        } else {
            this.rSa.rRk = true;
            this.rSa.xN(i);
        }
        if (z3) {
            this.rSa.rhb.bBD();
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
        ae.aOA().removeCallbacks(this.rSd);
        if (this.rRZ != null) {
            this.rRZ.rLc = z2;
            this.rRZ.rCC = str;
            if (str.compareTo(this.rRZ.mgB) < 0) {
                x.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", str, this.rRZ.mgB);
                this.rRZ.bCb();
            } else {
                x.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", str, this.rRZ.mgB);
            }
            this.rRZ.bAd();
        }
        if (!z3 || this.rOd.equals(this.jPV)) {
            if (this.rOd.equals(this.jPV) && j != 0) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j));
                this.rRZ.eX(j);
            }
            this.rSa.rRk = z;
            if (z) {
                this.rSa.iJ(z2);
                return;
            }
            return;
        }
        this.rSa.rRk = true;
        this.rSa.xN(i);
    }

    private void bCR() {
        if (!com.tencent.mm.o.a.aU(this)) {
            x.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")), bi.chl(), this);
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                x.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bi.chl(), this);
                if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    k.x(this.mController.xRr, new Intent());
                }
            }
        }
    }

    public void onBackPressed() {
        finish();
    }

    public boolean supportNavigationSwipeBack() {
        return super.supportNavigationSwipeBack();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsUserUI", "on activity result, %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (5985 == i && i2 == -1) {
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.rSa.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsUserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    bCR();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? j.ezZ : j.eAd;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(j.eAg), getString(j.esG), getString(j.dEy), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SnsUserUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
