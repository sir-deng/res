package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String ffG;
    private String fsb;
    private String lQd;
    private final int lZJ = 90000;
    private ExdeviceConnectedRouterStateView lZK;
    private TextView lZL;
    private TextView lZM;
    private b<a> lZN = new b<a>() {
        public final /* synthetic */ void b(final int i, final int i2, String str, k kVar) {
            try {
                x.d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (ExdeviceConnectedRouterActivateStateUI.this.isFinishing()) {
                    x.i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
                } else {
                    ExdeviceConnectedRouterActivateStateUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (i2 == 0 && (i == 0 || i == 4)) {
                                ExdeviceConnectedRouterActivateStateUI.this.pB(2);
                            } else if (i != 4) {
                                ExdeviceConnectedRouterActivateStateUI.this.pB(4);
                            } else if (i2 == 90000) {
                                ExdeviceConnectedRouterActivateStateUI.this.pB(3);
                            } else {
                                ExdeviceConnectedRouterActivateStateUI.this.pB(5);
                            }
                        }
                    });
                }
            } catch (Exception e) {
                x.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
            }
        }
    };
    private String ssid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        setMMTitle(R.l.edl);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceConnectedRouterActivateStateUI.this.aFD();
                return true;
            }
        });
        this.lZK = (ExdeviceConnectedRouterStateView) findViewById(R.h.cfa);
        this.lZL = (TextView) findViewById(R.h.ceZ);
        this.lZM = (TextView) findViewById(R.h.cfb);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.ffG = parse.getQueryParameter("deviceid");
            this.fsb = parse.getQueryParameter("devicetype");
            this.lQd = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (bi.oN(this.ffG) || bi.oN(this.fsb) || bi.oN(this.lQd) || bi.oN(this.appId)) {
                x.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", parse.toString());
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            x.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", parse.toString(), this.ffG, this.fsb, this.lQd, this.ssid);
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            x.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        pB(1);
        as.CN().a(new a(this.ffG, this.fsb, this.lQd, this.appId, this.lZN), 0);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void pB(int i) {
        this.lZK.setOnClickListener(null);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                this.lZK.setImageResource(R.k.dyo);
                this.lZK.setState(1);
                this.lZL.setText(R.l.edf);
                return;
            case 2:
                this.lZK.setImageResource(R.k.dyp);
                this.lZK.setState(2);
                this.lZL.setText(getString(R.l.edj, new Object[]{this.ssid}));
                addTextOptionMenu(0, getString(R.l.ede), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        ExdeviceConnectedRouterActivateStateUI.this.aFD();
                        return true;
                    }
                });
                return;
            case 3:
                this.lZK.setImageResource(R.k.dyn);
                this.lZK.setState(3);
                this.lZK.lZQ = 2;
                this.lZL.setText(R.l.edg);
                this.lZM.setText(getString(R.l.edh, new Object[]{this.ssid}));
                return;
            case 4:
                this.lZK.setImageResource(R.k.dyn);
                this.lZK.setState(3);
                this.lZK.lZQ = 2;
                this.lZL.setText(R.l.edg);
                this.lZM.setText(getString(R.l.edi));
                return;
            case 5:
                this.lZK.setImageResource(R.k.dyn);
                this.lZK.setState(3);
                this.lZK.lZQ = 2;
                this.lZL.setText(R.l.edg);
                this.lZM.setText(getString(R.l.edk));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dgP;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aFD();
        return true;
    }

    private void aFD() {
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        d.a((Context) this, "com.tencent.mm.ui.LauncherUI", intent);
    }
}
