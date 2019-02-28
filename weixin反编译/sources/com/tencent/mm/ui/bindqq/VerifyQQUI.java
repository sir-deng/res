package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.hp;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;

public class VerifyQQUI extends MMWizardActivity implements e {
    private String fyO;
    private String fyQ;
    private byte[] hmC = null;
    private String sVs = "";
    private r tipDialog = null;
    private SecurityImage xSF = null;
    private String yvA = "";
    private String yvB;
    private long yvz = 0;

    class a extends b {
        a() {
        }

        public final void cox() {
            as.CN().a(new com.tencent.mm.ae.a(VerifyQQUI.this.yvz, VerifyQQUI.this.sVs, VerifyQQUI.this.yvA, "", VerifyQQUI.this.yvB, 2, true), 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, (e) this);
    }

    public void onDestroy() {
        super.onDestroy();
        as.CN().b((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, (e) this);
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dbs;
    }

    public final boolean alr() {
        aWY();
        finish();
        return true;
    }

    protected final void initView() {
        com.tencent.mm.sdk.b.b hpVar = new hp();
        hpVar.fyM.context = this;
        com.tencent.mm.sdk.b.a.xmy.m(hpVar);
        this.fyO = hpVar.fyN.fyO;
        hpVar = new hq();
        com.tencent.mm.sdk.b.a.xmy.m(hpVar);
        this.fyQ = hpVar.fyP.fyQ;
        setMMTitle(R.l.dMn);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VerifyQQUI.this.aWY();
                VerifyQQUI.this.En(1);
                return true;
            }
        });
        final EditText editText = (EditText) findViewById(R.h.bNH);
        final EditText editText2 = (EditText) findViewById(R.h.bNG);
        addTextOptionMenu(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = editText.getText().toString().trim();
                VerifyQQUI.this.sVs = editText2.getText().toString().trim();
                try {
                    VerifyQQUI.this.yvz = Long.parseLong(trim);
                    if (VerifyQQUI.this.yvz < 10000) {
                        h.h(VerifyQQUI.this.mController.xRr, R.l.dMj, R.l.dMh);
                    } else if (VerifyQQUI.this.sVs.equals("")) {
                        h.h(VerifyQQUI.this.mController.xRr, R.l.dMi, R.l.dMh);
                    } else {
                        VerifyQQUI.this.aWY();
                        final k aVar = new com.tencent.mm.ae.a(VerifyQQUI.this.yvz, VerifyQQUI.this.sVs, "", "", "", VerifyQQUI.this.fyO, VerifyQQUI.this.fyQ, false);
                        as.CN().a(aVar, 0);
                        VerifyQQUI verifyQQUI = VerifyQQUI.this;
                        Context context = VerifyQQUI.this.mController.xRr;
                        VerifyQQUI.this.getString(R.l.dMl);
                        verifyQQUI.tipDialog = h.a(context, VerifyQQUI.this.getString(R.l.dMc), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(aVar);
                            }
                        });
                    }
                } catch (Exception e) {
                    h.h(VerifyQQUI.this.mController.xRr, R.l.dMj, R.l.dMh);
                }
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        byte[] a;
        x.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.ae.a aVar = (com.tencent.mm.ae.a) kVar;
        byte[] aQ = as.Cx().aQ(aVar.hpJ);
        x.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", Integer.valueOf(bi.i(aQ, new byte[0]).length), Long.valueOf(aVar.hpJ));
        if (bi.by(aQ)) {
            a = n.a(((hg) aVar.gLB.hnR.hnY).vNQ);
        } else {
            a = aQ;
        }
        this.hmC = a;
        this.yvA = ((hg) ((com.tencent.mm.ae.a) kVar).gLB.hnR.hnY).vTt;
        if (this.hmC != null) {
            x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.yvA + " img len" + this.hmC.length + " " + g.zo());
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.c.a.ihO.un();
            h.a(this.mController.xRr, R.l.dMk, R.l.dMl, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    VerifyQQUI.this.En(1);
                }
            });
            return;
        }
        Object obj;
        if (i == 4) {
            com.tencent.mm.g.a eC;
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.yvA + " img len" + this.hmC.length + " " + g.zo());
                    if (!as.Hp()) {
                        obj = 1;
                        break;
                    }
                    if (this.xSF == null) {
                        this.xSF = com.tencent.mm.ui.applet.SecurityImage.a.a(this.mController.xRr, R.l.eEv, 0, this.hmC, this.yvA, this.yvB, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final k aVar = new com.tencent.mm.ae.a(VerifyQQUI.this.yvz, VerifyQQUI.this.sVs, VerifyQQUI.this.xSF.xXV, VerifyQQUI.this.xSF.cpt(), VerifyQQUI.this.xSF.xXW, VerifyQQUI.this.fyO, VerifyQQUI.this.fyQ, true);
                                as.CN().a(aVar, 0);
                                VerifyQQUI verifyQQUI = VerifyQQUI.this;
                                Context context = VerifyQQUI.this.mController.xRr;
                                VerifyQQUI.this.getString(R.l.dMl);
                                verifyQQUI.tipDialog = h.a(context, VerifyQQUI.this.getString(R.l.dMc), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        as.CN().c(aVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                VerifyQQUI.this.xSF = null;
                            }
                        }, new a());
                    } else {
                        x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.yvA + " img len" + this.hmC.length + " " + g.zo());
                        this.xSF.a(0, this.hmC, this.yvA, this.yvB);
                    }
                    obj = 1;
                    break;
                case -72:
                    h.h(this.mController.xRr, R.l.dMg, R.l.dGZ);
                    obj = 1;
                    break;
                case -34:
                    h.h(this.mController.xRr, R.l.dMf, R.l.dGZ);
                    obj = 1;
                    break;
                case -12:
                    h.h(this.mController.xRr, R.l.dMd, R.l.dMh);
                    obj = 1;
                    break;
                case -5:
                    h.h(this.mController.xRr, R.l.dMe, R.l.dGZ);
                    obj = 1;
                    break;
                case -4:
                case -3:
                    eC = com.tencent.mm.g.a.eC(str);
                    if (eC == null) {
                        h.h(this.mController.xRr, R.l.dMm, R.l.dMh);
                        obj = 1;
                        break;
                    }
                    eC.a(this, null, null);
                    obj = 1;
                    break;
                default:
                    eC = com.tencent.mm.g.a.eC(str);
                    if (eC != null) {
                        eC.a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj == null) {
            Toast.makeText(this, getString(R.l.eiB, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
