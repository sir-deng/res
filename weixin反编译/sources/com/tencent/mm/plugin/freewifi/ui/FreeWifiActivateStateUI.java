package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements a, b {
    protected int cPf;
    protected int fei;
    private int ftb = 1;
    protected String mKN;
    private FreeWifiStateView mLZ;
    private TextView mMa;
    private TextView mMb;
    private Button mMc;
    protected Button mMd;
    protected String mMe;
    protected FreeWifiNetworkReceiver mMf;
    protected boolean mMg = false;
    private boolean mMh = false;
    private al mMi = new al(new al.a() {
        public final boolean uG() {
            if (!bi.oN(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.ftb = FreeWifiActivateStateUI.this.aNa();
                x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.this.ftb));
                FreeWifiActivateStateUI.this.mMj.TN();
                if (FreeWifiActivateStateUI.this.ftb != 2) {
                    FreeWifiActivateStateUI.this.aNe();
                    FreeWifiActivateStateUI.this.aNc();
                    d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
                }
            }
            return false;
        }
    }, false);
    private al mMj = new al(new al.a() {
        public final boolean uG() {
            if (!d.Bo(FreeWifiActivateStateUI.this.ssid)) {
                return true;
            }
            FreeWifiActivateStateUI.this.a(State.CONNECTED);
            FreeWifiActivateStateUI.this.mMj.TN();
            return false;
        }
    }, true);
    private j.a mMk = new j.a() {
        public final void a(String str, l lVar) {
            FreeWifiActivateStateUI.this.ftb = FreeWifiActivateStateUI.this.aNa();
            FreeWifiActivateStateUI.this.pB(FreeWifiActivateStateUI.this.ftb);
        }
    };
    protected String ssid;

    protected abstract void aMZ();

    protected abstract int aNa();

    protected abstract void afV();

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.mMf == null) {
            freeWifiActivateStateUI.aNf();
        }
        freeWifiActivateStateUI.mMf.mKe = freeWifiActivateStateUI;
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
        r0 = r8.cPf;
        switch(r0) {
            case 1: goto L_0x00a3;
            case 2: goto L_0x006b;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00a3;
            case 5: goto L_0x00a3;
            default: goto L_0x004d;
        };
    L_0x004d:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0101;
    L_0x0055:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x005e:
        r8.initView();
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r1 = r8.mMk;
        r0.c(r1);
        return;
    L_0x006b:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r0 = r0.aMX();
        if (r0 == 0) goto L_0x0099;
    L_0x0075:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.mMe = r3;
        r0 = r0.field_url;
        r8.mKN = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.mMe;
        r4[r1] = r5;
        r5 = r8.mKN;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x004d;
    L_0x0099:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x004d;
    L_0x00a3:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x00b5;
    L_0x00ab:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x005e;
    L_0x00b5:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r3 = r8.ssid;
        r0 = r0.Bw(r3);
        if (r0 != 0) goto L_0x011e;
    L_0x00c1:
        r0 = new com.tencent.mm.plugin.freewifi.g.c;
        r0.<init>();
        r3 = r8.ssid;
        r3 = com.tencent.mm.sdk.platformtools.ac.VF(r3);
        r0.field_ssidmd5 = r3;
        r3 = r8.ssid;
        r0.field_ssid = r3;
        r0.field_connectState = r1;
        r3 = r0;
        r0 = r1;
    L_0x00d6:
        r4 = r8.mKN;
        r3.field_url = r4;
        r4 = r8.mMe;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        if (r0 == 0) goto L_0x00f6;
    L_0x00ed:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r0.b(r3);
        goto L_0x004d;
    L_0x00f6:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aMv();
        r4 = new java.lang.String[r2];
        r0.c(r3, r4);
        goto L_0x004d;
    L_0x0101:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r2 = r8.mMe;
        r4[r1] = r2;
        r1 = r8.cPf;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x005e;
    L_0x011e:
        r3 = r0;
        r0 = r2;
        goto L_0x00d6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!bi.oN(this.ssid)) {
            aNg();
        }
    }

    protected void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiActivateStateUI.this.goBack();
                return true;
            }
        });
        this.mLZ = (FreeWifiStateView) findViewById(R.h.cjl);
        this.mMa = (TextView) findViewById(R.h.cjm);
        this.mMb = (TextView) findViewById(R.h.cjn);
        if (this.cPf == 3) {
            this.mMb.setText(getString(R.l.evp, new Object[]{this.ssid}));
        } else {
            this.mMb.setText(getString(R.l.dUy, new Object[]{this.ssid}));
        }
        this.mMc = (Button) findViewById(R.h.cFy);
        this.mMc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (FreeWifiActivateStateUI.this.aNa() == 2) {
                    FreeWifiActivateStateUI.this.finish();
                    return;
                }
                d.a(FreeWifiActivateStateUI.this.ssid, 1, FreeWifiActivateStateUI.this.getIntent());
                FreeWifiActivateStateUI.this.mMg = false;
                FreeWifiActivateStateUI.this.aNg();
            }
        });
        this.mMd = (Button) findViewById(R.h.coB);
        this.mMd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String string = FreeWifiActivateStateUI.this.getString(R.l.ejZ);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bl.d.b(FreeWifiActivateStateUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final void aNc() {
        if (this.mMf != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
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
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.ftb));
            if (this.ftb != 2) {
                this.mMi.K(60000, 60000);
                this.mMj.K(1000, 1000);
                if (d.Bo(this.ssid)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mMg));
                    if (this.mMg) {
                        x.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
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
                        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiActivateStateUI.this.ssid);
                        FreeWifiActivateStateUI.this.aMZ();
                    }
                });
                return;
            }
            pB(this.ftb);
            return;
        }
        this.mMi.K(60000, 60000);
        this.mMj.K(1000, 1000);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable() {
            public final void run() {
                FreeWifiActivateStateUI.d(FreeWifiActivateStateUI.this);
            }
        });
    }

    protected final void pB(int i) {
        this.mLZ.setOnClickListener(null);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                this.mMi.TN();
                this.mMj.TN();
                this.mLZ.setImageResource(R.g.bCr);
                this.mLZ.setState(3);
                this.mMa.setText(R.l.ekc);
                this.mMa.setVisibility(0);
                this.mMb.setText(R.l.ekd);
                this.mMb.setVisibility(0);
                break;
            case 1:
                this.mLZ.setImageResource(R.g.bCs);
                this.mLZ.setState(1);
                this.mMa.setText(R.l.dUv);
                break;
            case 2:
                this.mLZ.setImageResource(R.g.bCq);
                this.mLZ.setState(2);
                this.mMa.setText(R.l.dUu);
                this.mMc.setVisibility(0);
                this.mMc.setText(R.l.ejI);
                this.mMi.TN();
                this.mMj.TN();
                if (this.cPf == 1 || this.cPf == 5 || this.cPf == 4) {
                    this.mMc.setVisibility(4);
                    final c Bw = com.tencent.mm.plugin.freewifi.model.j.aMv().Bw(this.ssid);
                    if (!(Bw == null || bi.oN(Bw.field_showUrl) || this.mMh)) {
                        this.mMh = true;
                        ah.h(new Runnable() {
                            public final void run() {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", Bw.field_showUrl + "&lang=" + w.d(FreeWifiActivateStateUI.this.getSharedPreferences(ad.cgf(), 0)));
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("stastic_scene", 7);
                                com.tencent.mm.bl.d.b(FreeWifiActivateStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", intent.getStringExtra("rawUrl"));
                                FreeWifiActivateStateUI.this.finish();
                            }
                        }, 1000);
                    }
                }
                d.xd();
                return;
            case 3:
                this.mLZ.setImageResource(R.g.bCs);
                this.mLZ.setState(3);
                this.mLZ.lZQ = 2;
                this.mMa.setText(R.l.dUz);
                this.mMc.setVisibility(0);
                this.mMc.setText(R.l.ekl);
                this.mMi.TN();
                this.mMj.TN();
                return;
            default:
                this.mLZ.setImageResource(R.g.bCs);
                this.mMa.setText(R.l.dUv);
                if (this.cPf != 3) {
                    this.mMb.setText(getString(R.l.dUy, new Object[]{this.ssid}));
                    break;
                }
                this.mMb.setText(getString(R.l.evp, new Object[]{this.ssid}));
                break;
        }
        this.mMc.setVisibility(8);
    }

    protected final int getLayoutId() {
        return R.i.diL;
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
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", Integer.valueOf(i));
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
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            g.ihN.i(new Intent(), this);
        }
    }
}
