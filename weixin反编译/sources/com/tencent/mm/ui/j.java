package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bb;
import com.tencent.mm.f.a.ia;
import com.tencent.mm.f.a.ia.a;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.y.as;

public final class j {
    int fqe = 0;
    ProgressDialog inI;
    private View qoA;
    private TextView qoB;
    EditText qoC;
    i qoD;
    boolean qoE;
    MMFragmentActivity xOh;
    b xOi;
    a xOj = null;
    e xOk;
    boolean xOl = false;
    c xOm = new c<ia>() {
        {
            this.xmG = ia.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ia iaVar = (ia) bVar;
            if (iaVar == null || iaVar.fzp == null || iaVar.fzp.fzq == null) {
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event is illegal event[%s]", iaVar);
            } else {
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event launcherUI isResumeStatus[%b], tid[%d]", Boolean.valueOf(j.this.xOi.cnp()), Long.valueOf(Thread.currentThread().getId()));
                if (j.this.xOi.cnp()) {
                    j.this.xOj = null;
                    j.this.a(iaVar.fzp);
                } else {
                    j.this.xOj = iaVar.fzp;
                }
            }
            return false;
        }
    };
    c<bb> xOn = new c<bb>() {
        {
            this.xmG = bb.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            bb bbVar = (bb) bVar;
            j.this.fqe = bbVar.fqd.fqe;
            return false;
        }
    };

    static /* synthetic */ void a(j jVar, int i, int i2, int i3, String str) {
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        g.pWK.h(13191, Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(false));
        Intent intent;
        switch (i2) {
            case 2:
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                d.b(jVar.xOh, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 3:
                if (jVar.qoE) {
                    jVar.hS(true);
                    return;
                }
                jVar.cnj();
                as.CN().a(255, jVar.xOk);
                final k xVar = new com.tencent.mm.modelsimple.x(1);
                as.CN().a(xVar, 0);
                Context context = jVar.xOh;
                jVar.getString(R.l.dGZ);
                jVar.inI = h.a(context, jVar.getString(R.l.eLT), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(xVar);
                    }
                });
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(jVar.xOh, BindMContactUI.class);
                intent2.putExtra("is_bind_for_change_mobile", true);
                String simCountryIso = ((TelephonyManager) jVar.xOh.getSystemService("phone")).getSimCountryIso();
                if (!t.oN(simCountryIso)) {
                    com.tencent.mm.aq.b.a h = com.tencent.mm.aq.b.h(jVar.xOh, simCountryIso, jVar.getString(R.l.bZd));
                    if (h != null) {
                        intent2.putExtra("country_name", h.hGi);
                        intent2.putExtra("couttry_code", h.hGh);
                    }
                }
                MMWizardActivity.A(jVar.xOh, intent2);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!com.tencent.mm.o.a.aV(jVar.xOh) && !com.tencent.mm.at.a.Qq()) {
                    d.b(jVar.xOh, "scanner", ".ui.BaseScanUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public j(MMFragmentActivity mMFragmentActivity, b bVar) {
        this.xOh = mMFragmentActivity;
        this.xOi = bVar;
    }

    final boolean a(a aVar) {
        if (aVar == null || aVar.fzq == null || aVar.fzq.vJE == null || aVar.fzq.vJE.size() == 0) {
            return false;
        }
        final int i = aVar.fzq.id;
        String str = aVar.fzq.title;
        String str2 = aVar.fzq.fpV;
        int i2 = aVar.type;
        int size = aVar.fzq.vJE.size();
        if (i2 == 0) {
            if (size == 1) {
                final com.tencent.mm.protocal.b.a.a aVar2 = (com.tencent.mm.protocal.b.a.a) aVar.fzq.vJE.get(0);
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.vJC, aVar2.vJD);
                h.a(this.xOh, str2, str, aVar2.vJC, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.a(j.this, i, aVar2.actionType, aVar2.id, aVar2.vJD);
                        dialogInterface.dismiss();
                    }
                });
            } else {
                final com.tencent.mm.protocal.b.a.a aVar3 = (com.tencent.mm.protocal.b.a.a) aVar.fzq.vJE.get(1);
                final com.tencent.mm.protocal.b.a.a aVar4 = (com.tencent.mm.protocal.b.a.a) aVar.fzq.vJE.get(0);
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", str, str2, Integer.valueOf(aVar3.id), Integer.valueOf(aVar3.actionType), aVar3.vJC, aVar3.vJD, Integer.valueOf(aVar4.id), Integer.valueOf(aVar4.actionType), aVar4.vJC, aVar4.vJD);
                h.a(this.xOh, str2, str, aVar3.vJC, aVar4.vJC, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.a(j.this, i, aVar3.actionType, aVar3.id, aVar3.vJD);
                        dialogInterface.dismiss();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.a(j.this, i, aVar4.actionType, aVar4.id, aVar4.vJD);
                        dialogInterface.dismiss();
                    }
                });
            }
        } else if (i2 == 1) {
            String str3 = str2;
            String str4 = str;
            boolean z = false;
            h.a(this.xOh, str3, str4, ((com.tencent.mm.protocal.b.a.a) aVar.fzq.vJE.get(0)).vJC, ((com.tencent.mm.protocal.b.a.a) aVar.fzq.vJE.get(1)).vJC, z, aVar.fzr, aVar.fzs);
        }
        return true;
    }

    final e cnj() {
        if (this.xOk == null) {
            this.xOk = new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                    if (j.this.inI != null) {
                        j.this.inI.dismiss();
                        j.this.inI = null;
                    }
                    if (kVar.getType() == 255) {
                        as.CN().b(255, j.this.xOk);
                        if (i == 0 && i2 == 0) {
                            j.this.hS(true);
                        } else if (!t.a.a(j.this.xOh, i, i2, str, 4)) {
                            j.this.hS(false);
                        }
                    } else if (kVar.getType() != 384) {
                    } else {
                        if (i == 0 && i2 == 0) {
                            as.Hm();
                            com.tencent.mm.y.c.Db().set(77830, ((al) kVar).Oc());
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", j.this.getString(R.l.eMi));
                            d.b(j.this.xOh, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                            return;
                        }
                        j.this.qoE = true;
                        h.a(j.this.xOh, R.l.eMw, R.l.dGZ, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                j.this.cnk();
                            }
                        });
                    }
                }
            };
        }
        return this.xOk;
    }

    final void hS(boolean z) {
        x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword " + z);
        if (z) {
            cnk();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", getString(R.l.eMi));
        d.b(this.xOh, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
    }

    final void cnk() {
        if (this.qoD != null) {
            this.qoD.show();
            return;
        }
        if (this.qoA == null) {
            this.qoA = View.inflate(this.xOh, R.i.drZ, null);
            this.qoB = (TextView) this.qoA.findViewById(R.h.cLI);
            this.qoB.setText(getString(R.l.eLL));
            this.qoC = (EditText) this.qoA.findViewById(R.h.cLH);
            this.qoC.setInputType(129);
        }
        this.qoD = h.a(this.xOh, null, this.qoA, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                String obj = j.this.qoC.getText().toString();
                j.this.qoC.setText("");
                j.this.qoC.clearFocus();
                t.a(j.this.xOh, j.this.qoC);
                if (obj == null || obj.equals("")) {
                    h.a(j.this.xOh, R.l.eTc, R.l.dGZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                j.this.cnj();
                as.CN().a(384, j.this.xOk);
                final k alVar = new al(obj, "", "", "");
                as.CN().a(alVar, 0);
                j jVar = j.this;
                Context context = j.this.xOh;
                j.this.getString(R.l.dGZ);
                jVar.inI = h.a(context, j.this.getString(R.l.eLT), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().b(384, j.this.xOk);
                        j.this.xOk = null;
                        as.CN().c(alVar);
                    }
                });
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                j.this.qoC.setText("");
                j.this.qoD.dismiss();
            }
        });
    }

    final String getString(int i) {
        return this.xOh.getString(i);
    }
}
