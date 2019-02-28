package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;

public class FreeWifiSuccUI extends MMActivity implements e {
    private String fGh;
    private String fwG;
    private CheckBox lbH;
    private String mKP;
    private TextView mNV;
    private int mOc;
    private String mOd;
    private View mOi;
    private TextView mOj;
    private View mOk;
    private TextView mOl;
    private View mOm;
    private Button mOn;
    private int mOo;
    private boolean mOp = false;
    private boolean mOq = false;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        freeWifiSuccUI.aNt();
        WifiInfo aMl = d.aMl();
        a aLL = k.aLL();
        if (aMl != null) {
            String macAddress = aMl.getMacAddress();
            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                macAddress = m.aLQ();
            }
            aLL.ssid = m.Bg(aMl.getSSID());
            aLL.bssid = aMl.getBSSID();
            aLL.fqv = macAddress;
        }
        aLL.fqu = m.H(freeWifiSuccUI.getIntent());
        aLL.mIh = freeWifiSuccUI.fGh;
        aLL.mIi = m.D(freeWifiSuccUI.getIntent());
        aLL.mIj = m.F(freeWifiSuccUI.getIntent());
        aLL.mIk = b.BackpageFinished.mIW;
        aLL.mIl = b.BackpageFinished.name;
        aLL.fDM = m.G(freeWifiSuccUI.getIntent());
        aLL.mIm = freeWifiSuccUI.fwG;
        aLL.aLN().aLM();
        if (freeWifiSuccUI.mOc == 1 && !bi.oN(freeWifiSuccUI.mOd)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.mOd).buildUpon().appendQueryParameter("lang", w.d(freeWifiSuccUI.getSharedPreferences(ad.cgf(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bl.d.b(freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        } else if (freeWifiSuccUI.mOc != 0 && freeWifiSuccUI.mOc == 3 && !bi.oN(freeWifiSuccUI.mOd)) {
            ((com.tencent.mm.plugin.appbrand.n.e) g.h(com.tencent.mm.plugin.appbrand.n.e.class)).b(freeWifiSuccUI, freeWifiSuccUI.mOd, 1078, null);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to wxa after connect wifi success, url is : %s", freeWifiSuccUI.mOd);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fGh = getIntent().getStringExtra("free_wifi_appid");
        this.mKP = getIntent().getStringExtra("free_wifi_app_nickname");
        this.fwG = getIntent().getStringExtra("free_wifi_app_username");
        this.mOc = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mOd = getIntent().getStringExtra("free_wifi_finish_url");
        this.mOo = getIntent().getIntExtra(c.xMN, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.fGh, this.mKP, this.fwG, Integer.valueOf(this.mOc), this.mOd, this.signature);
        WifiInfo aMl = d.aMl();
        a aLL = k.aLL();
        String macAddress = aMl.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = m.aLQ();
        }
        if (aMl != null) {
            aLL.ssid = m.Bg(aMl.getSSID());
            aLL.bssid = aMl.getBSSID();
            aLL.fqv = macAddress;
        }
        aLL.fqu = getIntent().getStringExtra("free_wifi_ap_key");
        aLL.mIh = this.fGh;
        aLL.mIi = m.D(getIntent());
        aLL.mIj = m.F(getIntent());
        aLL.mIk = b.GetBackPage.mIW;
        aLL.mIl = b.GetBackPage.name;
        aLL.fDM = m.G(getIntent());
        aLL.mIm = this.fwG;
        aLL.aLN().aLM();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    public void finish() {
        super.finish();
        aNt();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        as.CN().b(1703, (e) this);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.diM;
    }

    protected final void initView() {
        setMMTitle(R.l.ekp);
        mc(false);
        this.mOi = findViewById(R.h.cjO);
        this.mOj = (TextView) findViewById(R.h.cjP);
        this.lbH = (CheckBox) findViewById(R.h.cjM);
        this.mOk = findViewById(R.h.cjJ);
        this.mOl = (TextView) findViewById(R.h.cjK);
        this.mOm = findViewById(R.h.cjQ);
        this.mNV = (TextView) findViewById(R.h.cjL);
        this.mOn = (Button) findViewById(R.h.bXc);
        this.mOn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FreeWifiSuccUI.this.finish();
                FreeWifiSuccUI.a(FreeWifiSuccUI.this);
            }
        });
        if (bi.oN(this.fGh) || bi.oN(this.fwG) || bi.oN(this.mKP)) {
            this.mOi.setVisibility(8);
            this.mOk.setVisibility(8);
            this.mOm.setVisibility(8);
        } else if (s.gI(this.fwG) && s.gH(this.fwG)) {
            l.b(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.mOi.setVisibility(8);
            this.mOk.setVisibility(8);
            this.mOm.setVisibility(0);
            this.mNV.setText(this.mKP);
            this.mOm.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!bi.oN(FreeWifiSuccUI.this.fwG)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", FreeWifiSuccUI.this.fwG);
                        com.tencent.mm.bl.d.b(FreeWifiSuccUI.this, "profile", ".ui.ContactInfoUI", intent);
                    }
                }
            });
        } else {
            l.b(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.mOm.setVisibility(8);
            this.mOi.setVisibility(0);
            if (bi.oN(this.signature)) {
                this.mOk.setVisibility(8);
                findViewById(R.h.cjN).setBackgroundColor(getResources().getColor(R.e.white));
            } else {
                this.mOk.setVisibility(0);
                this.mOl.setText(this.signature);
            }
            this.mOj.setText(getString(R.l.ekb, new Object[]{this.mKP}));
            if (this.mOo == 1) {
                this.lbH.setChecked(true);
                this.mOp = true;
            } else {
                this.lbH.setChecked(false);
                this.mOp = false;
            }
            this.lbH.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        FreeWifiSuccUI.this.mOp = true;
                    } else {
                        FreeWifiSuccUI.this.mOp = false;
                    }
                }
            });
        }
        if (m.G(getIntent()) == 10) {
            final String str = q.gHK.gIg;
            if (!m.Bf(str) && !m.Bf(q.aI(this.mController.xRr))) {
                Button button = (Button) findViewById(R.h.cjR);
                button.setText(String.format(getString(R.l.eko), new Object[]{q.aI(this.mController.xRr)}));
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        com.tencent.mm.bl.d.b(FreeWifiSuccUI.this, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                button.setVisibility(0);
            }
        }
    }

    private void aNt() {
        if (!this.mOq) {
            this.mOq = true;
            if (!(!this.mOp || bi.oN(this.fGh) || (s.gI(this.fwG) && s.gH(this.fwG)))) {
                as.CN().a(1703, (e) this);
                as.CN().a(new i(this.fGh, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.D(getIntent())), 0);
            }
            l.c(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.mOp);
        }
    }
}
