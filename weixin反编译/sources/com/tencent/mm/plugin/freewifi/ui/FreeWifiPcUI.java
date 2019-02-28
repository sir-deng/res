package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String fsK;
    private Button kxK;
    private String mKP;
    private Button mMZ;
    private TextView mNV;
    private int mNW;
    private r mNX = null;
    private String mNf;

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiPcUI.this.goBack();
                return true;
            }
        });
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.mNW = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.fsK = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.mKP = getIntent().getStringExtra("free_wifi_app_nickname");
        this.mNf = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mNV = (TextView) findViewById(R.h.cjE);
        this.kxK = (Button) findViewById(R.h.cjF);
        this.mNV.setText("由" + this.mKP + "提供");
        this.kxK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FreeWifiPcUI.this.kxK.setClickable(false);
                final al alVar = new al(new a() {
                    public final boolean uG() {
                        FreeWifiPcUI.this.mNX = h.a(FreeWifiPcUI.this.mController.xRr, FreeWifiPcUI.this.getString(R.l.dUx), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        return true;
                    }
                }, false);
                alVar.K(2000, 2000);
                k.a aLL = k.aLL();
                aLL.mIg = String.valueOf(FreeWifiPcUI.this.mNW);
                aLL.mIh = FreeWifiPcUI.this.appId;
                aLL.mIi = FreeWifiPcUI.this.fsK;
                aLL.mIk = b.SetPcLoginUserInfo.mIW;
                aLL.mIl = b.SetPcLoginUserInfo.name;
                aLL.aLN().aLM();
                x.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", m.D(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.E(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.mNW), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.fsK);
                new l(FreeWifiPcUI.this.appId, FreeWifiPcUI.this.mNW, FreeWifiPcUI.this.fsK).b(new e() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                        alVar.TN();
                        if (i == 0 && i2 == 0) {
                            FreeWifiPcUI.this.finish();
                        } else if (!m.cE(i, i2) || m.Bf(str)) {
                            FreeWifiPcUI.a(FreeWifiPcUI.this, FreeWifiPcUI.this.getString(R.l.ejT), FreeWifiPcUI.this.getString(R.l.ejU));
                        } else {
                            FreeWifiPcUI.a(FreeWifiPcUI.this, str + "(" + m.a(m.F(FreeWifiPcUI.this.getIntent()), b.SetPcLoginUserInfoReturn, i2) + ")", "");
                        }
                        k.a aLL = k.aLL();
                        aLL.mIg = String.valueOf(FreeWifiPcUI.this.mNW);
                        aLL.mIh = FreeWifiPcUI.this.appId;
                        aLL.mIi = FreeWifiPcUI.this.fsK;
                        aLL.mIk = b.SetPcLoginUserInfoReturn.mIW;
                        aLL.mIl = b.SetPcLoginUserInfoReturn.name;
                        aLL.result = i2;
                        aLL.aLN().aLM();
                        x.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", m.D(FreeWifiPcUI.this.getIntent()), Integer.valueOf(m.E(FreeWifiPcUI.this.getIntent())), Integer.valueOf(FreeWifiPcUI.this.mNW), FreeWifiPcUI.this.appId, FreeWifiPcUI.this.fsK);
                    }
                });
            }
        });
        this.mMZ = (Button) findViewById(R.h.cjG);
        this.mMZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiPcUI.this.mNf);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(FreeWifiPcUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        g.ihN.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.diJ;
    }
}
