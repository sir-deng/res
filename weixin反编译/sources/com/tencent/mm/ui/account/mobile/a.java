package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;

public final class a {
    private String fJB;
    private String hPj = "";
    private String username = "";
    boolean xYn = false;
    private String ycp = "";
    private a ycq;

    public interface a {
        void b(ProgressDialog progressDialog);
    }

    public a(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.hPj = str3;
        this.ycp = str2;
        this.ycq = aVar;
    }

    public final void j(MMActivity mMActivity) {
        final k vVar = new v(this.username, this.ycp, 0, "", "", "", 0, "", false, true);
        as.CN().a(vVar, 0);
        a aVar = this.ycq;
        mMActivity.getString(R.l.dGZ);
        aVar.b(h.a((Context) mMActivity, mMActivity.getString(R.l.etS), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(vVar);
            }
        }));
    }

    public final void a(final MMActivity mMActivity, int i, int i2, String str, k kVar) {
        int i3;
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            as.CN().a(new be(new com.tencent.mm.y.be.a() {
                public final void a(e eVar) {
                    if (eVar != null) {
                        c KD = eVar.KD();
                        byte[] bArr = new byte[0];
                        as.Hm();
                        KD.v(bArr, com.tencent.mm.y.c.Cn());
                    }
                }
            }), 0);
            i3 = 1;
        } else {
            boolean i32 = false;
        }
        if (kVar instanceof v) {
            this.fJB = ((v) kVar).Sf();
        }
        if (i32 != 0 || (i == 0 && i2 == 0)) {
            as.unhold();
            d.bq(mMActivity);
            m.oJ(this.hPj);
            m.a(mMActivity, new Runnable() {
                public final void run() {
                    Intent at = com.tencent.mm.plugin.c.a.ihN.at(mMActivity);
                    at.addFlags(67108864);
                    mMActivity.startActivity(at);
                    mMActivity.finish();
                }
            }, false, 2);
            if (this.xYn) {
                String string = ad.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                g.pWK.h(11930, string, Integer.valueOf(4));
            }
        } else if (i2 == -106) {
            m.c(mMActivity, str, 0);
        } else if (i2 == -217) {
            m.a(mMActivity, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
        } else {
            int i4;
            if (com.tencent.mm.plugin.c.a.ihO.a((Context) mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!bi.oN(this.fJB)) {
                                m.j(mMActivity, str, this.fJB);
                            }
                            i4 = 1;
                            break;
                        case -100:
                            as.hold();
                            h.a((Context) mMActivity, TextUtils.isEmpty(as.Cp()) ? com.tencent.mm.bu.a.ac(mMActivity, R.l.euH) : as.Cp(), mMActivity.getString(R.l.dGZ), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            i4 = 1;
                            break;
                        case -75:
                            h.h(mMActivity, R.l.dDQ, R.l.dGZ);
                            i4 = 1;
                            break;
                        case -72:
                            h.h(mMActivity, R.l.eEo, R.l.dGZ);
                            i4 = 1;
                            break;
                        case -9:
                            h.h(mMActivity, R.l.etI, R.l.etJ);
                            i4 = 1;
                            break;
                        case -1:
                            if (as.CN().Ks() == 5) {
                                h.h(mMActivity, R.l.exT, R.l.exS);
                                i4 = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            h.h(mMActivity, R.l.ecw, R.l.etJ);
                            i4 = 1;
                            break;
                    }
                }
                boolean i42 = false;
            }
            if (i42 == 0) {
                Toast.makeText(mMActivity, mMActivity.getString(R.l.eiB, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
