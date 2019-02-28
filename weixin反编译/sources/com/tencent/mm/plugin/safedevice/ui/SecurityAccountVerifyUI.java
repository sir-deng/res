package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class SecurityAccountVerifyUI extends MMWizardActivity implements e {
    private String fBa;
    private al fia;
    private String fyO;
    private String fyQ;
    private ProgressDialog inI = null;
    private String pXJ;
    private Button pXM;
    private String pXN;
    private EditText pXR;
    private TextView pXS;
    private TextView pXT;
    private Button pXU;
    private boolean pXV = false;

    protected final int getLayoutId() {
        return R.i.drI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pXN = b.Xw();
        initView();
    }

    protected void onResume() {
        as.CN().a((int) c.CTRL_INDEX, (e) this);
        as.CN().a(132, (e) this);
        super.onResume();
        if (!this.pXV) {
            b.b(true, as.CI() + "," + getClass().getName() + ",L600_200," + as.fJ("L600_200") + ",1");
            b.oY("L600_200");
        }
    }

    protected void onPause() {
        as.CN().b((int) c.CTRL_INDEX, (e) this);
        as.CN().b(132, (e) this);
        super.onPause();
        if (!this.pXV) {
            b.b(false, as.CI() + "," + getClass().getName() + ",L600_200," + as.fJ("L600_200") + ",2");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fia.TN();
    }

    protected final void initView() {
        this.fBa = getIntent().getStringExtra("binded_mobile");
        this.pXJ = getIntent().getStringExtra("auth_ticket");
        this.pXV = getIntent().getBooleanExtra("re_open_verify", false);
        this.pXR = (EditText) findViewById(R.h.bNB);
        this.pXS = (TextView) findViewById(R.h.cwP);
        this.pXT = (TextView) findViewById(R.h.cHR);
        this.pXU = (Button) findViewById(R.h.cHQ);
        this.pXR.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = (editable == null || bi.oN(editable.toString())) ? false : true;
                SecurityAccountVerifyUI.this.enableOptionMenu(z);
            }
        });
        this.pXS.setText(bi.Ww(this.fBa));
        this.pXT.setTag(Integer.valueOf(60));
        this.fia = new al(new a() {
            public final boolean uG() {
                int intValue = ((Integer) SecurityAccountVerifyUI.this.pXT.getTag()).intValue();
                if (intValue <= 1) {
                    SecurityAccountVerifyUI.this.pXU.setVisibility(0);
                    SecurityAccountVerifyUI.this.pXT.setVisibility(8);
                    return false;
                }
                SecurityAccountVerifyUI.this.pXT.setTag(Integer.valueOf(intValue - 1));
                SecurityAccountVerifyUI.this.pXT.setText(SecurityAccountVerifyUI.this.getString(R.l.eHi, new Object[]{Integer.valueOf(intValue)}));
                if (SecurityAccountVerifyUI.this.pXT.getVisibility() != 0) {
                    SecurityAccountVerifyUI.this.pXT.setVisibility(0);
                }
                return true;
            }
        }, true);
        this.pXU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
                SecurityAccountVerifyUI.this.pXU.setVisibility(8);
                SecurityAccountVerifyUI.this.pXT.setTag(Integer.valueOf(60));
                SecurityAccountVerifyUI.this.fia.TN();
                SecurityAccountVerifyUI.this.fia.K(1000, 1000);
                final k sVar = new s(SecurityAccountVerifyUI.this.fBa, 10, "", 0, "", SecurityAccountVerifyUI.this.pXJ);
                as.CN().a(sVar, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                Context context = SecurityAccountVerifyUI.this.mController.xRr;
                SecurityAccountVerifyUI.this.getString(R.l.dGZ);
                securityAccountVerifyUI.inI = h.a(context, SecurityAccountVerifyUI.this.getString(R.l.eHk), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(sVar);
                    }
                });
            }
        });
        if (!this.pXV) {
            this.pXM = (Button) findViewById(R.h.bWl);
            this.pXM.setVisibility(0);
            this.pXM.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    b.pa(as.CI() + "," + getClass().getName() + ",L600_300," + as.fJ("L600_300") + ",1");
                    String d = w.d(SecurityAccountVerifyUI.this.getSharedPreferences(ad.cgf(), 0));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", SecurityAccountVerifyUI.this.getString(R.l.eHh));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    com.tencent.mm.plugin.c.a.ihN.j(intent, SecurityAccountVerifyUI.this);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SecurityAccountVerifyUI.this.bpd();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = SecurityAccountVerifyUI.this.pXR.getText().toString().trim();
                if (bi.oN(trim)) {
                    h.h(SecurityAccountVerifyUI.this, R.l.dLR, R.l.dGZ);
                } else {
                    k tVar;
                    SecurityAccountVerifyUI.this.aWY();
                    SecurityAccountVerifyUI.this.fyO = com.tencent.mm.plugin.safedevice.a.e.dr(SecurityAccountVerifyUI.this);
                    SecurityAccountVerifyUI.this.fyQ = com.tencent.mm.plugin.safedevice.a.e.boY();
                    if (SecurityAccountVerifyUI.this.pXV) {
                        tVar = new t(SecurityAccountVerifyUI.this.fBa, 11, trim, "", SecurityAccountVerifyUI.this.fyO, SecurityAccountVerifyUI.this.fyQ);
                    } else {
                        tVar = new s(SecurityAccountVerifyUI.this.fBa, trim, "", SecurityAccountVerifyUI.this.pXJ, SecurityAccountVerifyUI.this.fyO, SecurityAccountVerifyUI.this.fyQ);
                    }
                    as.CN().a(tVar, 0);
                    SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                    Context context = SecurityAccountVerifyUI.this;
                    SecurityAccountVerifyUI.this.getString(R.l.dGZ);
                    securityAccountVerifyUI.inI = h.a(context, SecurityAccountVerifyUI.this.getString(R.l.dLI), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(tVar);
                        }
                    });
                }
                return true;
            }
        });
        enableOptionMenu(false);
        setMMTitle(R.l.eHe);
        this.fia.K(1000, 1000);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bpd();
        return true;
    }

    private void bpd() {
        cancel();
        En(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
            this.inI = null;
        }
        Intent intent;
        switch (kVar.getType()) {
            case 132:
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.safedevice.a.e.x(true, true);
                    intent = new Intent(this, MySafeDeviceListUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    finish();
                    return;
                } else if (!o(i, i2, str)) {
                    Toast.makeText(this, getString(R.l.eHl, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            case c.CTRL_INDEX /*145*/:
                s sVar = (s) kVar;
                if (sVar.IY() == 10) {
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        return;
                    }
                    x.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (!o(i, i2, str)) {
                        Toast.makeText(this.mController.xRr, getString(R.l.eHj, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                } else if (sVar.IY() != 11) {
                    x.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", Integer.valueOf(sVar.IY()), Integer.valueOf(i), Integer.valueOf(i2));
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.pXJ = sVar.Od();
                    x.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.pXJ);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    intent2.putExtra("binded_mobile", this.fBa);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.pXJ);
                            com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                            finish();
                            return;
                        case 3:
                            intent2.addFlags(67108864);
                            intent2.putExtra("auth_ticket", this.pXJ);
                            Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            intent = (Intent) xTb.get(stringExtra);
                            xTb.clear();
                            if (intent != null) {
                                com.tencent.mm.plugin.safedevice.a.a(this, intent2, intent);
                            } else {
                                com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                            }
                            finish();
                            return;
                        default:
                            En(1);
                            return;
                    }
                } else {
                    x.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (!o(i, i2, str)) {
                        Toast.makeText(this.mController.xRr, getString(R.l.eHl, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private boolean o(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.ihO.a(this.mController.xRr, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -74:
                h.a(this.mController.xRr, R.l.dLa, R.l.dGZ, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.mController.xRr, R.l.dFa, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mController.xRr, R.l.dLd, 0).show();
                return true;
            case -34:
                Toast.makeText(this, R.l.dLe, 0).show();
                return true;
            case -33:
                h.a(this.mController.xRr, R.l.dLL, R.l.bNC, null);
                return true;
            case -32:
                h.a(this.mController.xRr, R.l.dLM, R.l.bNC, null);
                return true;
            default:
                return false;
        }
    }
}
