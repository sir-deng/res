package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements a, b {
    protected int cPf;
    protected String fGh;
    protected int fei;
    protected String fqu;
    private int ftb = 1;
    protected String fwG;
    private final c hEY;
    protected String mKN;
    protected String mKP;
    private TextView mMI;
    private ImageView mMV;
    private TextView mMW;
    private TextView mMX;
    private Button mMY;
    private Button mMZ;
    protected String mMe;
    protected FreeWifiNetworkReceiver mMf;
    protected boolean mMg = false;
    private al mMi = new al(new al.a() {
        public final boolean uG() {
            if (!bi.oN(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.ftb = FreeWifiStateUI.this.aNa();
                x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.this.ftb));
                FreeWifiStateUI.this.mMj.TN();
                k.a aLL = k.aLL();
                aLL.ssid = FreeWifiStateUI.this.ssid;
                aLL.fqu = FreeWifiStateUI.this.fqu;
                aLL.mIi = m.D(FreeWifiStateUI.this.getIntent());
                aLL.mIj = m.F(FreeWifiStateUI.this.getIntent());
                aLL.mIk = k.b.AddNetwork.mIW;
                aLL.mIl = k.b.AddNetwork.name;
                aLL.result = -16;
                aLL.fDM = m.G(FreeWifiStateUI.this.getIntent());
                aLL.mIh = FreeWifiStateUI.this.fGh;
                aLL.mIm = FreeWifiStateUI.this.fwG;
                aLL.aLN().aLM();
                if (FreeWifiStateUI.this.ftb != 2) {
                    FreeWifiStateUI.this.aNe();
                    FreeWifiStateUI.this.aNc();
                    d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
                }
            }
            return false;
        }
    }, false);
    private al mMj = new al(new al.a() {
        public final boolean uG() {
            if (!d.Bo(FreeWifiStateUI.this.ssid)) {
                return true;
            }
            FreeWifiStateUI.this.a(State.CONNECTED);
            FreeWifiStateUI.this.mMj.TN();
            return false;
        }
    }, true);
    private j.a mMk;
    private r mNX = null;
    protected String mNc;
    protected String mNd;
    protected String mNe;
    protected String mNf;
    protected int mOc;
    protected String mOd;
    protected String mOe;
    protected String signature;
    protected String ssid;

    public abstract void a(State state);

    protected abstract void aMZ();

    protected abstract int aNa();

    protected abstract void afV();

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.hFj = true;
        aVar.hFk = true;
        aVar.hFA = R.g.bCk;
        aVar.hFJ = true;
        aVar.hFK = 0.0f;
        this.hEY = aVar.PQ();
        this.mMk = new j.a() {
            private int mOg = -999999999;

            public final void a(String str, l lVar) {
                FreeWifiStateUI.this.ftb = FreeWifiStateUI.this.aNa();
                if (this.mOg != FreeWifiStateUI.this.ftb) {
                    this.mOg = FreeWifiStateUI.this.ftb;
                    FreeWifiStateUI.this.pB(FreeWifiStateUI.this.ftb);
                }
            }
        };
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.mMf == null) {
            freeWifiStateUI.aNf();
        }
        freeWifiStateUI.mMf.mKe = freeWifiStateUI;
        d.aMh();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r9);
        r0 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r0 = r0.getStringExtra(r3);
        r8.fqu = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_ssid";
        r0 = r0.getStringExtra(r3);
        r8.ssid = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_mid";
        r0 = r0.getStringExtra(r3);
        r8.mMe = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_url";
        r0 = r0.getStringExtra(r3);
        r8.mKN = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_source";
        r0 = r0.getIntExtra(r3, r1);
        r8.cPf = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_channel_id";
        r0 = r0.getIntExtra(r3, r2);
        r8.fei = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_appid";
        r0 = r0.getStringExtra(r3);
        r8.fGh = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_head_img_url";
        r0 = r0.getStringExtra(r3);
        r8.mNc = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_msg";
        r0 = r0.getStringExtra(r3);
        r8.mNd = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_sub_title";
        r0 = r0.getStringExtra(r3);
        r8.mNe = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_privacy_url";
        r0 = r0.getStringExtra(r3);
        r8.mNf = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_app_nickname";
        r0 = r0.getStringExtra(r3);
        r8.mKP = r0;
        r0 = r8.cPf;
        switch(r0) {
            case 1: goto L_0x011b;
            case 2: goto L_0x00e3;
            case 3: goto L_0x011b;
            case 4: goto L_0x011b;
            case 5: goto L_0x011b;
            case 6: goto L_0x011b;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0179;
    L_0x00b0:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x00b9:
        r8.initView();
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r1 = r8.mMk;
        r0.c(r1);
        r0 = com.tencent.mm.plugin.freewifi.model.d.aMm();
        r1 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r1 = r1.getStringExtra(r3);
        r3 = r8.getIntent();
        r4 = "free_wifi_protocol_type";
        r2 = r3.getIntExtra(r4, r2);
        com.tencent.mm.plugin.freewifi.l.r(r0, r1, r2);
        return;
    L_0x00e3:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r0 = r0.aMX();
        if (r0 == 0) goto L_0x0111;
    L_0x00ed:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.mMe = r3;
        r0 = r0.field_url;
        r8.mKN = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.mMe;
        r4[r1] = r5;
        r5 = r8.mKN;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x00a8;
    L_0x0111:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x00a8;
    L_0x011b:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x012d;
    L_0x0123:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x00b9;
    L_0x012d:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r3 = r8.ssid;
        r0 = r0.Bw(r3);
        if (r0 != 0) goto L_0x0196;
    L_0x0139:
        r0 = new com.tencent.mm.plugin.freewifi.g.c;
        r0.<init>();
        r3 = r8.ssid;
        r3 = com.tencent.mm.sdk.platformtools.ac.VF(r3);
        r0.field_ssidmd5 = r3;
        r3 = r8.ssid;
        r0.field_ssid = r3;
        r3 = r0;
        r0 = r1;
    L_0x014c:
        r4 = r8.mKN;
        r3.field_url = r4;
        r4 = r8.mMe;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        r3.field_connectState = r1;
        if (r0 == 0) goto L_0x016e;
    L_0x0165:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r0.b(r3);
        goto L_0x00a8;
    L_0x016e:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r4 = new java.lang.String[r2];
        r0.c(r3, r4);
        goto L_0x00a8;
    L_0x0179:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.mMe;
        r4[r1] = r5;
        r1 = r8.cPf;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x00b9;
    L_0x0196:
        r3 = r0;
        r0 = r2;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiStateUI.this.goBack();
                return true;
            }
        });
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(R.h.cUs).setVisibility(0);
        }
        this.mMV = (ImageView) findViewById(R.h.cjj);
        this.mMW = (TextView) findViewById(R.h.cjV);
        this.mMX = (TextView) findViewById(R.h.cjI);
        this.mMI = (TextView) findViewById(R.h.cjq);
        this.mMY = (Button) findViewById(R.h.bXb);
        this.mMY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.s(d.aMm(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                if (FreeWifiStateUI.this.aNa() == 2) {
                    FreeWifiStateUI.this.finish();
                    return;
                }
                d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
                FreeWifiStateUI.this.mMg = false;
                FreeWifiStateUI.this.aNg();
            }
        });
        this.mMZ = (Button) findViewById(R.h.cUt);
        this.mMZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiStateUI.this.mNf);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bl.d.b(FreeWifiStateUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (bi.oN(this.ssid)) {
            this.mMX.setText(getString(R.l.ekn));
            this.mMY.setVisibility(4);
        }
    }

    protected final void aNc() {
        if (this.mMf != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
            this.mMf.mKe = null;
        }
    }

    protected final void aNd() {
        if (this.mMf == null) {
            aNf();
        }
        this.mMf.mKf = this;
    }

    protected final void aNe() {
        if (this.mMf != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
            this.mMf.mKf = null;
        }
    }

    private void aNf() {
        this.mMf = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.mMf, intentFilter);
    }

    protected final void aNg() {
        if (d.isWifiEnabled()) {
            this.ftb = aNa();
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.ftb));
            if (this.ftb != 2) {
                if (m.F(getIntent()) == 4) {
                    this.mMi.K(30000, 30000);
                } else {
                    this.mMi.K(60000, 60000);
                }
                this.mMj.K(1000, 1000);
                if (d.Bo(this.ssid)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mMg));
                    if (this.mMg) {
                        x.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                        return;
                    }
                    this.mMi.K(60000, 60000);
                    this.mMj.K(1000, 1000);
                    afV();
                    this.mMg = true;
                    return;
                }
                com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiStateUI.this.ssid);
                        FreeWifiStateUI.this.aMZ();
                    }
                });
                return;
            }
            d.a(this.ssid, this.ftb, getIntent());
            return;
        }
        this.mMi.K(60000, 60000);
        this.mMj.K(1000, 1000);
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable() {
            public final void run() {
                FreeWifiStateUI.d(FreeWifiStateUI.this);
            }
        });
    }

    protected final void pB(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mMi.TN();
                this.mMj.TN();
                this.mMI.setVisibility(0);
                this.mMY.setText(R.l.ekl);
                return;
            case -1:
                return;
            case 1:
                this.mMI.setVisibility(4);
                this.mMY.setText(R.l.dUx);
                this.mNX = h.a(this.mController.xRr, getString(R.l.dUx), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
                    }
                });
                return;
            case 2:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mMi.TN();
                this.mMj.TN();
                this.mMY.setText(R.l.dUu);
                this.mMY.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.fGh);
                intent.putExtra("free_wifi_app_nickname", this.mKP);
                intent.putExtra("free_wifi_app_username", this.fwG);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.mOc);
                intent.putExtra("free_wifi_finish_url", this.mOd);
                if (bi.oN(this.mOe)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.mOe);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                d.xd();
                return;
            case 3:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mMi.TN();
                this.mMj.TN();
                this.mMI.setVisibility(0);
                this.mMY.setText(R.l.ekl);
                return;
            case 4:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mMi.TN();
                this.mMj.TN();
                this.mMg = false;
                this.mMI.setVisibility(4);
                this.mMY.setText(R.l.dUA);
                if (!(m.G(getIntent()) != 10 || m.Bf(q.gHK.gIg) || m.Bf(q.aI(this.mController.xRr)))) {
                    this.mMY.setText(String.format(getString(R.l.ejL), new Object[]{q.aI(this.mController.xRr)}));
                }
                if (this.cPf == 3) {
                    this.mMX.setText(getString(R.l.evp, new Object[]{this.ssid}));
                } else if (bi.oN(this.mNe)) {
                    this.mMX.setText(getString(R.l.dUw));
                } else {
                    this.mMX.setText(this.mNe);
                }
                if (!bi.oN(this.fGh)) {
                    if (!bi.oN(this.mNd)) {
                        this.mMW.setText(this.mNd);
                    }
                    if (!bi.oN(this.mNc)) {
                        o.PG().a(this.mNc, this.mMV, this.hEY);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mMI.setVisibility(4);
                this.mMY.setText(R.l.dUA);
                if (this.cPf == 3) {
                    this.mMX.setText(getString(R.l.evp, new Object[]{this.ssid}));
                } else if (bi.oN(this.mNe)) {
                    this.mMX.setText(getString(R.l.dUw));
                } else {
                    this.mMX.setText(this.mNe);
                }
                if (!bi.oN(this.fGh)) {
                    if (!bi.oN(this.mNd)) {
                        this.mMW.setText(this.mNd);
                    }
                    if (!bi.oN(this.mNc)) {
                        o.PG().a(this.mNc, this.mMV, this.hEY);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.diE;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.aMv().j(this.mMk);
        aNc();
        aNe();
        if (this.mMf != null) {
            unregisterReceiver(this.mMf);
        }
        this.mMi.TN();
        this.mMj.TN();
        com.tencent.mm.plugin.freewifi.model.j.aMy().release();
    }

    public final void qp(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", Integer.valueOf(i));
        switch (i) {
            case 3:
                aNc();
                aNg();
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.freewifi.l.t(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ihN.i(new Intent(), this);
        finish();
    }
}
