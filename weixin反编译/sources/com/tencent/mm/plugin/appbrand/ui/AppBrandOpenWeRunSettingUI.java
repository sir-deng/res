package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.b;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public class AppBrandOpenWeRunSettingUI extends MMActivity implements e {
    private ImageView ikl;
    private TextView ikn;
    private TextView ikq;
    private TextView jQN;
    private TextView jQO;
    private x jQP = null;
    r jQQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(j.iCF));
        this.ikl = (ImageView) findViewById(g.iyv);
        this.jQN = (TextView) findViewById(g.iyw);
        this.ikq = (TextView) findViewById(g.iyy);
        this.ikn = (TextView) findViewById(g.iyz);
        this.jQO = (TextView) findViewById(g.iyx);
        this.jQO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                d.qq(13);
                e eVar = AppBrandOpenWeRunSettingUI.this;
                eVar.getString(j.dGZ);
                eVar.jQQ = h.a((Context) eVar, ((a) com.tencent.mm.kernel.g.h(a.class)).bL(eVar), true, null);
                eVar.jQQ.show();
                com.tencent.mm.kernel.g.Dp().gRu.a(30, eVar);
                List linkedList = new LinkedList();
                linkedList.add("gh_43f2581f6fd6");
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(1));
                com.tencent.mm.kernel.g.Dp().gRu.a(new o(1, linkedList, linkedList2, "", ""), 0);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandOpenWeRunSettingUI.this.finish();
                return true;
            }
        });
        String oM = bi.oM(getIntent().getStringExtra("OpenWeRunSettingName"));
        this.jQP = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv("gh_43f2581f6fd6");
        if (this.jQP == null || ((int) this.jQP.gKO) == 0) {
            getString(j.dGZ);
            this.jQQ = h.a((Context) this, getString(j.dHn), true, null);
            this.jQQ.show();
            ak.a.hhv.a("gh_43f2581f6fd6", "", new b.a() {
                public final void v(String str, boolean z) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", Boolean.valueOf(z), str);
                    AppBrandOpenWeRunSettingUI.this.jQP = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv("gh_43f2581f6fd6");
                    AppBrandOpenWeRunSettingUI.this.alq();
                    AppBrandOpenWeRunSettingUI.this.jQQ.dismiss();
                }
            });
        }
        this.ikn.setText(getString(j.iCG, new Object[]{oM}));
        alq();
    }

    protected final int getLayoutId() {
        return q.h.izx;
    }

    private void alq() {
        com.tencent.mm.pluginsdk.ui.a.b.a(this.ikl, this.jQP.field_username);
        this.jQN.setText(this.jQP.AX());
        if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
            this.ikq.setTextColor(com.tencent.mm.ui.tools.r.gc(this.mController.xRr));
            this.ikq.setText(((a) com.tencent.mm.kernel.g.h(a.class)).bN(this));
            this.ikq.setCompoundDrawablesWithIntrinsicBounds(f.bGy, 0, 0, 0);
            this.jQO.setText(((a) com.tencent.mm.kernel.g.h(a.class)).bN(this));
            this.jQO.setClickable(false);
            return;
        }
        this.ikq.setTextColor(com.tencent.mm.ui.tools.r.gd(this.mController.xRr));
        this.ikq.setText(((a) com.tencent.mm.kernel.g.h(a.class)).bO(this));
        this.ikq.setCompoundDrawablesWithIntrinsicBounds(f.bGx, 0, 0, 0);
        this.jQO.setText(((a) com.tencent.mm.kernel.g.h(a.class)).bM(this));
        this.jQO.setClickable(true);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            com.tencent.mm.kernel.g.Dp().gRu.b(30, (e) this);
            if (i == 0 && i2 == 0) {
                String bZf = ((o) kVar).bZf();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", bZf);
                this.jQP = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv("gh_43f2581f6fd6");
                ag agVar = this.jQP;
                if (agVar == null || bi.oN(bZf)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + bZf + ", contact = " + agVar);
                } else {
                    com.tencent.mm.af.d dVar;
                    if (s.gG(agVar.field_username)) {
                        String oM = bi.oM(agVar.field_username);
                        com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(oM);
                        if (jV != null) {
                            jV.field_username = bZf;
                        }
                        y.Ml().jO(oM);
                        agVar.di(oM);
                        dVar = jV;
                    } else {
                        dVar = null;
                    }
                    agVar.setUsername(bZf);
                    if (((int) agVar.gKO) == 0) {
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().T(agVar);
                    }
                    if (((int) agVar.gKO) <= 0) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        s.p(agVar);
                        ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(agVar.field_username);
                        if (dVar != null) {
                            y.Ml().d(dVar);
                        } else {
                            dVar = com.tencent.mm.af.f.jV(Xv.field_username);
                            if (dVar == null || dVar.Le()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                ak.a.hhv.Q(Xv.field_username, "");
                                com.tencent.mm.ac.b.ja(Xv.field_username);
                            } else if (Xv.ciQ()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", Integer.valueOf(Xv.fXr));
                                ak.a.hhv.Q(Xv.field_username, "");
                                com.tencent.mm.ac.b.ja(Xv.field_username);
                            }
                        }
                    }
                }
                y.Ml().e(y.Ml().jN(this.jQP.field_username));
                com.tencent.mm.kernel.g.Dq().Db().set(327825, Boolean.valueOf(true));
                setResult(-1);
                ah.h(new Runnable() {
                    public final void run() {
                        AppBrandOpenWeRunSettingUI.this.finish();
                    }
                }, 1500);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !bi.oN(str)) {
                    Toast.makeText(ad.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.jQQ != null) {
                this.jQQ.dismiss();
            }
            alq();
        }
    }
}
