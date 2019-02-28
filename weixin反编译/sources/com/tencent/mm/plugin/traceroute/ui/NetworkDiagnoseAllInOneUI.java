package com.tencent.mm.plugin.traceroute.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.kd;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;

public class NetworkDiagnoseAllInOneUI extends MMActivity implements OnClickListener {
    private ImageView fwa;
    private a gAn;
    private al ind;
    private Button kxK;
    private c odA;
    private boolean slA;
    private int slp;
    private TextView slq;
    private TextView slr;
    private TextView sls;
    private TextView slt;
    private r slu;
    private int slv;
    private String slw;
    private com.tencent.mm.sdk.b.c<kd> slx;
    private boolean sly;
    private boolean slz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.a.bqo, R.a.bpQ);
        setMMTitle("");
        getSupportActionBar().hide();
        Intent intent = getIntent();
        this.slp = intent.getIntExtra("diagnose_state", 0);
        this.slv = intent.getIntExtra("diagnose_percent", 1);
        this.slw = intent.getStringExtra("diagnose_kvInfo");
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", Integer.valueOf(this.slp), Integer.valueOf(this.slv), this.slw);
        if (this.slp == 0) {
            this.slp = 1;
            x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
            as.CN().a(new be(new be.a() {
                public final void a(e eVar) {
                    if (eVar != null) {
                        try {
                            eVar.KG();
                        } catch (Exception e) {
                        }
                    }
                }
            }), 0);
        }
        this.kxK = (Button) findViewById(R.h.cbB);
        this.slq = (TextView) findViewById(R.h.cbz);
        this.slr = (TextView) findViewById(R.h.cby);
        this.fwa = (ImageView) findViewById(R.h.cbD);
        this.sls = (TextView) findViewById(R.h.cbE);
        this.slt = (TextView) findViewById(R.h.cbA);
        this.slq.setOnClickListener(this);
        this.kxK.setOnClickListener(this);
        this.slr.setOnClickListener(this);
        bjk();
        this.slx = new com.tencent.mm.sdk.b.c<kd>() {
            {
                this.xmG = kd.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                int i;
                boolean z = true;
                kd kdVar = (kd) bVar;
                x.v("MicroMsg.NetworkDiagnoseAllInOneUI", "diagnose callback, stage:%d, status:%d", Integer.valueOf(kdVar.fCm.fCn), Integer.valueOf(kdVar.fCm.status));
                NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI;
                if (kdVar.fCm.fCn == 0) {
                    NetworkDiagnoseAllInOneUI.this.slv = 33;
                    networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (kdVar.fCm.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.sly = z;
                } else if (kdVar.fCm.fCn == 1) {
                    NetworkDiagnoseAllInOneUI.this.slv = 66;
                    networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (kdVar.fCm.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.slz = z;
                } else if (kdVar.fCm.fCn == 2) {
                    networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (kdVar.fCm.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.slA = z;
                }
                int a = NetworkDiagnoseAllInOneUI.this.slp;
                if (kdVar.fCm.fCo) {
                    NetworkDiagnoseAllInOneUI.this.slv = 100;
                    ah.y(new Runnable() {
                        public final void run() {
                            NetworkDiagnoseAllInOneUI.this.bjk();
                        }
                    });
                    NetworkDiagnoseAllInOneUI.this.slw = kdVar.fCm.fCp;
                    if (NetworkDiagnoseAllInOneUI.this.sly) {
                        a = 2;
                        i = 1000;
                    } else if (NetworkDiagnoseAllInOneUI.this.slz) {
                        a = 4;
                        i = 1000;
                    } else if (NetworkDiagnoseAllInOneUI.this.slA) {
                        a = 5;
                        i = 1000;
                    } else {
                        a = 3;
                        i = 1000;
                    }
                } else {
                    i = 0;
                }
                ah.h(new Runnable() {
                    public final void run() {
                        NetworkDiagnoseAllInOneUI.this.slp = a;
                        NetworkDiagnoseAllInOneUI.this.bjk();
                    }
                }, (long) i);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(this.slx);
        this.gAn = new a() {
            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                String str;
                x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", Boolean.valueOf(z));
                NetworkDiagnoseAllInOneUI.this.odA.c(NetworkDiagnoseAllInOneUI.this.gAn);
                ah.y(new Runnable() {
                    public final void run() {
                        NetworkDiagnoseAllInOneUI.this.kxK.setEnabled(true);
                        if (NetworkDiagnoseAllInOneUI.this.slu != null && NetworkDiagnoseAllInOneUI.this.slu.isShowing()) {
                            NetworkDiagnoseAllInOneUI.this.slu.dismiss();
                        }
                        NetworkDiagnoseAllInOneUI.this.slp = 6;
                        NetworkDiagnoseAllInOneUI.this.bjk();
                    }
                });
                NetworkDiagnoseAllInOneUI.this.slw;
                if (z) {
                    str = (String.valueOf(f2) + "-" + String.valueOf(f)) + "," + NetworkDiagnoseAllInOneUI.this.slw;
                } else {
                    x.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
                    str = "," + NetworkDiagnoseAllInOneUI.this.slw;
                }
                g.pWK.k(14533, str);
                return false;
            }
        };
        this.ind = new al(new al.a() {
            public final boolean uG() {
                NetworkDiagnoseAllInOneUI.this.slv = NetworkDiagnoseAllInOneUI.this.slv + 1;
                x.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", Integer.valueOf(NetworkDiagnoseAllInOneUI.this.slv));
                if (NetworkDiagnoseAllInOneUI.this.slv > 99) {
                    return false;
                }
                if (NetworkDiagnoseAllInOneUI.this.slp == 1) {
                    NetworkDiagnoseAllInOneUI.this.sls.setText(NetworkDiagnoseAllInOneUI.this.getString(R.l.dYR, new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.this.slv)}));
                }
                return true;
            }
        }, true);
        if (this.slp == 0 || this.slp == 1) {
            this.ind.K(1000, 1000);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    protected final int getLayoutId() {
        return R.i.doY;
    }

    private void bjk() {
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", Integer.valueOf(this.slp));
        switch (this.slp) {
            case 0:
            case 1:
                this.fwa.setImageResource(R.k.dzG);
                this.sls.setText(getString(R.l.dYR, new Object[]{Integer.valueOf(this.slv)}));
                this.slt.setText(R.l.dYM);
                this.kxK.setVisibility(4);
                this.slr.setVisibility(4);
                return;
            case 2:
                this.fwa.setImageResource(R.k.dzG);
                this.sls.setText(R.l.dYV);
                this.slt.setText(R.l.dYP);
                this.kxK.setVisibility(0);
                this.slr.setVisibility(4);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("title", R.l.exR);
                intent.putExtra("rawUrl", getString(R.l.exO));
                intent.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                jf(false);
                finish();
                return;
            case 4:
                this.fwa.setImageResource(R.k.dzE);
                this.sls.setText(R.l.dYU);
                this.slt.setText(R.l.dYN);
                this.kxK.setVisibility(0);
                this.kxK.setText(R.l.dYK);
                this.slr.setVisibility(0);
                return;
            case 5:
                this.fwa.setImageResource(R.k.dzE);
                this.sls.setText(R.l.dYS);
                this.slt.setText(R.l.dYN);
                this.kxK.setVisibility(0);
                this.kxK.setText(R.l.dYK);
                this.slr.setVisibility(0);
                return;
            case 6:
                this.fwa.setImageResource(R.k.dzF);
                this.sls.setText(R.l.dYT);
                this.slt.setText(R.l.dYO);
                this.kxK.setVisibility(0);
                this.kxK.setText(R.l.dYJ);
                this.slr.setVisibility(4);
                return;
            default:
                return;
        }
    }

    private void jf(boolean z) {
        if (!bi.oN(this.slw)) {
            x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", Boolean.valueOf(z));
            if (!z) {
                g.pWK.k(14533, "," + this.slw);
            } else if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", "")) {
                getString(R.l.dGZ);
                this.slu = h.a((Context) this, getString(R.l.dYW), true, null);
                this.kxK.setEnabled(false);
                if (this.odA == null) {
                    this.odA = c.OV();
                }
                this.odA.a(this.gAn, true);
            }
            this.slw = null;
        }
    }

    public void onClick(View view) {
        if ((this.slp == 5 || this.slp == 4) && view == this.kxK) {
            jf(true);
            return;
        }
        jf(false);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.slx);
        if (this.odA != null) {
            this.odA.c(this.gAn);
            this.odA = null;
        }
        if (this.ind != null) {
            this.ind.TN();
            this.ind = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case org.xwalk.core.R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                if (iArr[0] == 0) {
                    jf(true);
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.eAa), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            NetworkDiagnoseAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
