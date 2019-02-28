package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.d;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private ImageView jTd;
    private Button lmo;
    private TextView pOJ;
    private Button sMS;
    private LinearLayout sMT;
    private TextView sMU;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1654);
        jl(1568);
        jl(1669);
        initView();
        g.pWK.h(13731, Integer.valueOf(1));
    }

    public final void initView() {
        setMMTitle(i.vaB);
        this.jTd = (ImageView) findViewById(f.unV);
        this.pOJ = (TextView) findViewById(f.unY);
        this.sMS = (Button) findViewById(f.urC);
        this.lmo = (Button) findViewById(f.upF);
        this.sMT = (LinearLayout) findViewById(f.urE);
        this.sMU = (TextView) findViewById(f.urF);
        this.sMS.setOnClickListener(new d() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(WalletDigitalCertUI.this, WalletIdCardCheckUI.class);
                WalletDigitalCertUI.this.startActivityForResult(intent, 1);
            }
        });
        this.lmo.setOnClickListener(new d() {
            public final void onClick(View view) {
                r.cCq();
                WalletDigitalCertUI.this.l(new e(r.cCp()));
                g.pWK.h(13731, Integer.valueOf(10));
            }
        });
        setBackBtn(new s() {
            public final void bKQ() {
                WalletDigitalCertUI.this.finish();
            }
        });
        bLi();
    }

    private void bLi() {
        x.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.sMT.removeAllViews();
        if (r.cCq().cCr()) {
            this.sMS.setVisibility(8);
            this.lmo.setVisibility(0);
            this.pOJ.setText(i.vaI);
            this.jTd.setImageResource(a.e.ukq);
        } else {
            this.sMS.setVisibility(0);
            this.lmo.setVisibility(8);
            this.pOJ.setText(i.vaD);
            this.jTd.setImageResource(a.e.ukr);
        }
        Vector vector = r.cCq().zQX;
        if (vector.size() == 0) {
            this.sMT.setVisibility(8);
            this.sMU.setVisibility(8);
            return;
        }
        this.sMT.setVisibility(0);
        this.sMU.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (qVar.zQR <= 0) {
                View inflate = View.inflate(this, a.g.uLm, null);
                TextView textView = (TextView) inflate.findViewById(f.unW);
                TextView textView2 = (TextView) inflate.findViewById(f.upG);
                ((TextView) inflate.findViewById(f.unZ)).setText(qVar.xeK);
                textView.setText(qVar.zQQ);
                textView2.setTag(qVar);
                textView2.setOnClickListener(new d() {
                    public final void onClick(View view) {
                        if (view.getTag() instanceof q) {
                            final q qVar = (q) view.getTag();
                            h.a(WalletDigitalCertUI.this, WalletDigitalCertUI.this.getString(i.vaC, new Object[]{qVar.xeK}), "", WalletDigitalCertUI.this.getString(i.dEH), WalletDigitalCertUI.this.getString(i.dEy), true, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.i("MicroMsg.WalletDigitalCertUI", "del crt %s", qVar.wYd);
                                    WalletDigitalCertUI.this.l(new e(qVar.wYd));
                                }
                            }, null);
                        }
                    }
                });
                this.sMT.addView(inflate);
            }
        }
        if (this.sMT.getChildCount() == 0) {
            this.sMU.setVisibility(8);
        } else {
            this.sMU.setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1654);
        jm(1568);
        jm(1669);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d)) {
            if (kVar instanceof e) {
                if (i2 == 0) {
                    g.pWK.h(13731, Integer.valueOf(11));
                    r.cCq().abg(((e) kVar).zQu);
                } else {
                    g.pWK.h(13731, Integer.valueOf(12));
                }
            }
            return false;
        }
        bLi();
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            String string;
            boolean aKD = ((l) com.tencent.mm.kernel.g.h(l.class)).aKD();
            SharedPreferences cgg = ad.cgg();
            if (cgg != null) {
                String string2 = cgg.getString("cpu_id", null);
                string = cgg.getString("uid", null);
                str = string2;
            } else {
                string = null;
            }
            x.i("MicroMsg.WalletDigitalCertUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(aKD));
            b(new com.tencent.mm.plugin.wallet.pwd.a.d(aKD, str, string), false);
        }
    }

    protected final int getLayoutId() {
        return a.g.uLu;
    }
}
