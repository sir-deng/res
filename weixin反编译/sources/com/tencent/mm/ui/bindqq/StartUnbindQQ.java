package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ae.b;
import com.tencent.mm.f.a.af;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class StartUnbindQQ extends MMWizardActivity implements e {
    private i qoD;
    private String qpV = null;
    private r tipDialog;
    private View yvv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(253, (e) this);
        this.qpV = getIntent().getStringExtra("notice");
    }

    public void onDestroy() {
        as.CN().b(253, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dtb;
    }

    protected final void initView() {
        setMMTitle(R.l.eRV);
        this.yvv = findViewById(R.h.cMk);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                StartUnbindQQ.this.finish();
                return true;
            }
        });
        this.yvv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (StartUnbindQQ.this.qoD == null) {
                    StartUnbindQQ.this.qoD = h.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(R.l.eKQ), null, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            as.CN().a(new b(""), 0);
                            StartUnbindQQ startUnbindQQ = StartUnbindQQ.this;
                            Context context = StartUnbindQQ.this;
                            StartUnbindQQ.this.getString(R.l.dGZ);
                            startUnbindQQ.tipDialog = h.a(context, StartUnbindQQ.this.getString(R.l.eKR), true, null);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    StartUnbindQQ.this.qoD.show();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (kVar.getType() == 253) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                as.Hm();
                int a = bi.a((Integer) c.Db().get(9, null), 0);
                x.d("MicroMsg.StartUnbindQQ", "iBindUin " + a);
                if (a != 0) {
                    as.Hm();
                    c.Fn().jO(new o(a) + "@qqim");
                }
                as.Hm();
                Object obj = c.Db().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    as.Hm();
                    c.Db().set(102407, null);
                }
                try {
                    a.xmy.m(new af());
                    as.Hm();
                    String str2 = new o(bi.a((Integer) c.Db().get(9, null), 0)) + "@qqim";
                    as.Hm();
                    c.Fn().jO(str2);
                    as.Hm();
                    c.Ff().XB(str2);
                    n.JW().jq(str2);
                    String str3 = q.FY() + "@qqim";
                    n.JW().jq(str3);
                    n.JF();
                    d.y(str2, false);
                    n.JF();
                    d.y(str2, true);
                    n.JF();
                    d.y(str3, false);
                    n.JF();
                    d.y(str3, true);
                    ac OM = com.tencent.mm.modelfriend.af.OM();
                    x.d("MicroMsg.QQGroupStorage", "delete all");
                    if (OM.hiZ.delete("qqgroup", null, null) > 0) {
                        OM.doNotify();
                    }
                    com.tencent.mm.plugin.c.a.ihO.un();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.StartUnbindQQ", e, "", new Object[0]);
                }
                as.Hm();
                c.Db().set(9, Integer.valueOf(0));
                com.tencent.mm.sdk.b.b scVar = new sc();
                scVar.fKF.fKG = false;
                scVar.fKF.fKH = true;
                a.xmy.m(scVar);
                if (bi.oN(this.qpV)) {
                    En(1);
                } else {
                    h.a((Context) this, this.qpV, "", getString(R.l.dCa), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            StartUnbindQQ.this.En(1);
                        }
                    });
                }
            }
            com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
            if (eC != null) {
                eC.a(this, null, null);
            }
        }
    }
}
