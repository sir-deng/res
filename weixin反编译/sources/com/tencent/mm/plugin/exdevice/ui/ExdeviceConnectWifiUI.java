package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher XD;
    private String lEi = "";
    private View lYS;
    private TextView lYT;
    private View lYU;
    private EditText lYV;
    private View lYW;
    private r lYX;
    private WifiInfo lYY;
    private com.tencent.mm.plugin.exdevice.d.a lYZ;
    private String lZa;
    private boolean lZb;
    private boolean lZc;
    private boolean lZd;
    private int lZe;
    private byte[] lZf;
    private int lZg;
    private int lZh;
    private int lZi;
    private String lZj = "";
    private int lZk;
    private long lZl;
    boolean lZm = false;
    private com.tencent.mm.plugin.exdevice.d.b lZn;
    private int lZo;
    private n lZp;
    private com.tencent.mm.plugin.exdevice.model.j.a lZq;
    private MulticastLock lZr;
    private Runnable lZs = new Runnable() {
        public final void run() {
            if (bi.oN(ExdeviceConnectWifiUI.this.getPassword())) {
                ExdeviceConnectWifiUI.this.lYV.setText(ExdeviceConnectWifiUI.this.lYZ.lTQ);
                Spannable text = ExdeviceConnectWifiUI.this.lYV.getText();
                if (text != null) {
                    Selection.setSelection(text, text.length());
                    return;
                }
                return;
            }
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
        }
    };

    private static class a {
        public static String ad(int i, String str) {
            if (bi.oN(str)) {
                return null;
            }
            return i + "@" + str.hashCode();
        }
    }

    public enum b {
        ;

        public static int[] aFC() {
            return (int[]) lZI.clone();
        }

        static {
            lZD = 1;
            lZE = 2;
            lZF = 3;
            lZG = 4;
            lZH = 5;
            lZI = new int[]{lZD, lZE, lZF, lZG, lZH};
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI$7 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] lZz = new int[b.aFC().length];

        static {
            try {
                lZz[b.lZD - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lZz[b.lZF - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lZz[b.lZE - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lZz[b.lZH - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                lZz[b.lZG - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static /* synthetic */ void a(ExdeviceConnectWifiUI exdeviceConnectWifiUI, final WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "WifiInfo is null.");
            return;
        }
        exdeviceConnectWifiUI.lZm = true;
        exdeviceConnectWifiUI.lZl = System.currentTimeMillis();
        exdeviceConnectWifiUI.pz(3);
        final String password = exdeviceConnectWifiUI.getPassword();
        String ssid = wifiInfo.getSSID();
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "SSID = %s", ssid);
        if (bi.oN(ssid)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Error parameter: aSSID is null or nil");
            ssid = "";
        } else {
            ssid = ssid.replaceAll("\"", "");
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", ssid);
        if (bi.oN(ssid)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.mController.xRr, "SSID is invalid", 0).show();
            return;
        }
        exdeviceConnectWifiUI.pA(b.lZF);
        as.Dt().F(new Runnable() {
            public final void run() {
                ExdeviceConnectWifiUI.this.lZr.acquire();
                int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(password, ssid, ExdeviceConnectWifiUI.this.lZf, 60000, ExdeviceConnectWifiUI.this.lZg, ExdeviceConnectWifiUI.this.lZh);
                x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s, ssid by system = %s, bssid by system = %s", Integer.valueOf(startAirKissWithInter), ssid, wifiInfo.getSSID(), wifiInfo.getBSSID());
            }
        });
    }

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        if (exdeviceConnectWifiUI.lYY == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null.");
            return;
        }
        String ssid = exdeviceConnectWifiUI.lYY.getSSID();
        String oM = bi.oM(exdeviceConnectWifiUI.getPassword());
        if (bi.oN(ssid)) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            return;
        }
        if (bi.oN(exdeviceConnectWifiUI.lYZ.lTP) || (ssid.equals(exdeviceConnectWifiUI.lYZ.lTP) && !oM.equals(exdeviceConnectWifiUI.lYZ.lTQ))) {
            com.tencent.mm.plugin.exdevice.d.a ac = exdeviceConnectWifiUI.ac(exdeviceConnectWifiUI.lZe, ssid);
            if (ac == null) {
                ac = new com.tencent.mm.plugin.exdevice.d.a();
                ac.lTP = ssid;
                ac.lTO = exdeviceConnectWifiUI.lZe;
                exdeviceConnectWifiUI.lZn.lTR.add(ac);
            }
            ac.lTQ = com.tencent.mm.plugin.base.model.b.bP(oM, a.ad(exdeviceConnectWifiUI.lZe, ssid));
        } else if (!exdeviceConnectWifiUI.lZb) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        ssid = stringBuilder.append(c.FJ()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.lZn.toByteArray();
            e.b(ssid, toByteArray, toByteArray.length);
        } catch (Throwable e) {
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        x.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", ssid);
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.eN(true);
        if (exdeviceConnectWifiUI.lZr.isHeld()) {
            exdeviceConnectWifiUI.lZr.release();
        }
    }

    protected final int getLayoutId() {
        return R.i.dgO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lZp = new com.tencent.mm.network.n.a() {
            public final void eq(int i) {
                ah.y(new Runnable() {
                    public final void run() {
                        if (ExdeviceConnectWifiUI.this.lZo != b.lZG) {
                            ExdeviceConnectWifiUI.this.eN(true);
                        }
                    }
                });
            }
        };
        this.lZo = b.lZD;
        if (as.Hp()) {
            this.lZn = new com.tencent.mm.plugin.exdevice.d.b();
            this.lYZ = new com.tencent.mm.plugin.exdevice.d.a();
            as.Hm();
            this.lZe = c.Cn();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.lZg = getIntent().getIntExtra("procInterval", 0);
            this.lZh = getIntent().getIntExtra("dataInterval", 0);
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.lZg + " Data interval:" + this.lZh);
            if (!bi.oN(stringExtra)) {
                this.lZf = Base64.decode(stringExtra, 0);
                this.lZk = 1;
            }
            this.lZm = false;
            this.lZi = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.lZi == 2) {
                this.lZj = getIntent().getStringExtra("device_brand_name");
                this.lEi = getIntent().getStringExtra("device_category_id");
            }
            this.lZq = new com.tencent.mm.plugin.exdevice.model.j.a() {
                public final void e(int i, Object... objArr) {
                    if (i == 0 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer)) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        int intValue2 = ((Integer) objArr[1]).intValue();
                        if (ExdeviceConnectWifiUI.this.lZr.isHeld()) {
                            ExdeviceConnectWifiUI.this.lZr.release();
                        }
                        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", Integer.valueOf(intValue), Integer.valueOf(intValue2));
                        if (intValue == 0 && intValue2 == 0) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    ExdeviceConnectWifiUI.this.pA(b.lZG);
                                }
                            });
                        } else {
                            ExdeviceConnectWifiUI.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    ExdeviceConnectWifiUI.this.lYX.dismiss();
                                    h.a(ExdeviceConnectWifiUI.this.mController.xRr, ExdeviceConnectWifiUI.this.mController.xRr.getString(R.l.ecA), "", ExdeviceConnectWifiUI.this.mController.xRr.getString(R.l.ecZ), "", false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            ExdeviceConnectWifiUI.this.pA(b.lZH);
                                        }
                                    }, null).show();
                                }
                            });
                        }
                    }
                }
            };
            j.aEI().a(0, this.lZq);
            initView();
            as.Dt().F(new Runnable() {
                public final void run() {
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        as.Hm();
                        byte[] e = e.e(stringBuilder.append(c.FJ()).append("exdevice_wifi_infos").toString(), 0, Integer.MAX_VALUE);
                        if (e != null) {
                            ExdeviceConnectWifiUI.this.lZn.aH(e);
                            ExdeviceConnectWifiUI.this.aFB();
                        }
                    } catch (Throwable e2) {
                        x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2.getMessage());
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2, "", new Object[0]);
                    }
                    ah.h(new Runnable() {
                        public final void run() {
                            ExdeviceConnectWifiUI.this.showVKB();
                        }
                    }, 500);
                }
            });
            pz(1);
            this.lZr = ((WifiManager) getSystemService("wifi")).createMulticastLock("localWifi");
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        eN(false);
        as.a(this.lZp);
        if (this.lZc) {
            aFB();
            this.lZc = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.lZm) {
            pz(2);
        }
        j.aEI().b(0, this.lZq);
    }

    protected void onStop() {
        super.onStop();
        as.b(this.lZp);
    }

    protected final void initView() {
        setMMTitle(R.l.dgO);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!ExdeviceConnectWifiUI.this.lZd) {
                    boolean z;
                    Intent intent = new Intent();
                    String str = "is_wifi_connected";
                    if (ExdeviceConnectWifiUI.this.lZo != b.lZE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    intent.putExtra(str, z);
                    ExdeviceConnectWifiUI.this.setResult(0, intent);
                    ExdeviceConnectWifiUI.this.finish();
                }
                return false;
            }
        });
        this.lYS = findViewById(R.h.cLM);
        this.lYT = (TextView) findViewById(R.h.cyF);
        this.lYU = findViewById(R.h.bJY);
        this.lYV = (EditText) findViewById(R.h.cCt);
        this.lYW = findViewById(R.h.bXd);
        this.XD = new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() > 31) {
                    ExdeviceConnectWifiUI.this.lYU.setVisibility(0);
                    ExdeviceConnectWifiUI.this.lYW.setEnabled(false);
                    return;
                }
                ExdeviceConnectWifiUI.this.lYU.setVisibility(8);
                ExdeviceConnectWifiUI.this.lYW.setEnabled(true);
            }
        };
        this.lYS.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                ExdeviceConnectWifiUI.this.lYV.clearFocus();
                ExdeviceConnectWifiUI.this.aWY();
                return false;
            }
        });
        this.lYW.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
                ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this, ExdeviceConnectWifiUI.this.lYY);
            }
        });
        this.lYV.setTransformationMethod(new PasswordTransformationMethod());
        this.lYV.addTextChangedListener(this.XD);
        this.lYV.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
                ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this, ExdeviceConnectWifiUI.this.lYY);
                return true;
            }
        });
        this.lYV.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this, ExdeviceConnectWifiUI.this.lYY);
                return true;
            }
        });
        this.lYV.requestFocus();
    }

    private void pz(int i) {
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.lZl;
        }
        g.pWK.h(13503, Integer.valueOf(i), Integer.valueOf(this.lZi), Long.valueOf(j), this.lZj, this.lEi, Integer.valueOf(this.lZk));
    }

    private com.tencent.mm.plugin.exdevice.d.a ac(int i, String str) {
        if (bi.oN(str) || this.lZn == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.lZn.lTR.size()) {
                return null;
            }
            com.tencent.mm.plugin.exdevice.d.a aVar = (com.tencent.mm.plugin.exdevice.d.a) this.lZn.lTR.get(i3);
            if (aVar == null) {
                i2 = i3 - 1;
                this.lZn.lTR.remove(i3);
                this.lZb = true;
                i3 = i2;
            } else if (aVar.lTO == i && str.equals(aVar.lTP)) {
                return aVar;
            }
            i2 = i3 + 1;
        }
    }

    private void aFB() {
        if (this.lYY == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null, delay to fill.");
            this.lZc = true;
            return;
        }
        this.lYZ.lTQ = "";
        this.lYZ.lTP = "";
        com.tencent.mm.plugin.exdevice.d.a ac = ac(this.lZe, this.lYY.getSSID());
        if (ac == null) {
            return;
        }
        if (bi.oN(ac.lTQ)) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.lZn.lTR.remove(ac);
            this.lZb = true;
            return;
        }
        this.lYZ.lTQ = com.tencent.mm.plugin.base.model.b.bP(ac.lTQ, a.ad(this.lZe, ac.lTP));
        this.lYZ.lTP = ac.lTP;
        ah.y(this.lZs);
    }

    private String getPassword() {
        return this.lYV.getText() != null ? this.lYV.getText().toString() : null;
    }

    private void eN(boolean z) {
        this.lYY = ao.getWifiInfo(this);
        int i = z ? b.lZD : this.lZo;
        if (this.lYY == null) {
            i = b.lZE;
        } else {
            String ssid = this.lYY.getSSID();
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", ssid);
            if (bi.oN(ssid)) {
                this.lYT.setText("");
            } else {
                this.lYT.setText(ssid.replaceAll("\"", ""));
            }
            if (!(bi.oN(ssid) || ssid.equals(this.lZa))) {
                this.lZa = ssid;
            }
        }
        pA(i);
    }

    public final synchronized void pA(int i) {
        if (i == 0) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
        } else {
            this.lZo = i;
            switch (AnonymousClass7.lZz[i - 1]) {
                case 1:
                    b(true, false, false);
                    break;
                case 2:
                    b(true, true, false);
                    break;
                case 3:
                    b(false, false, false);
                    break;
                case 4:
                    pz(5);
                    this.lZd = true;
                    setResult(1);
                    break;
                case 5:
                    pz(4);
                    b(true, false, true);
                    this.lZd = true;
                    setResult(-1);
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            ExdeviceConnectWifiUI.q(ExdeviceConnectWifiUI.this);
                        }
                    });
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        d.b(this.mController.xRr, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (i != b.lZD) {
                this.lYV.clearFocus();
                aWY();
            }
        }
    }

    private void b(boolean z, boolean z2, boolean z3) {
        this.lYS.setVisibility(z ? 0 : 8);
        if (z2) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    ExdeviceConnectWifiUI exdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
                    Context context = ExdeviceConnectWifiUI.this.mController.xRr;
                    ExdeviceConnectWifiUI.this.getString(R.l.dGZ);
                    exdeviceConnectWifiUI.lYX = h.a(context, ExdeviceConnectWifiUI.this.getString(R.l.edX), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
                            if (ExdeviceConnectWifiUI.this.lZo != b.lZG) {
                                ExdeviceConnectWifiUI.r(ExdeviceConnectWifiUI.this);
                            }
                        }
                    });
                }
            });
        } else {
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (ExdeviceConnectWifiUI.this.lYX != null && ExdeviceConnectWifiUI.this.lYX.isShowing()) {
                        ExdeviceConnectWifiUI.this.lYX.dismiss();
                    }
                }
            });
            if (this.lZr.isHeld()) {
                this.lZr.release();
            }
        }
        if (z3) {
            Toast.makeText(this.mController.xRr, R.l.edd, 0).show();
        }
    }
}
