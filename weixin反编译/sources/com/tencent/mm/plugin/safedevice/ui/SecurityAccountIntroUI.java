package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements e {
    private String fBa;
    private ProgressDialog inI = null;
    private String jumpUrl;
    private String pXJ;
    private String pXK;
    private boolean pXL = false;
    private Button pXM;
    private String pXN;

    protected final int getLayoutId() {
        return R.i.drG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pXJ = getIntent().getStringExtra("auth_ticket");
        this.fBa = getIntent().getStringExtra("binded_mobile");
        this.pXL = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        x.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", bi.Wz(this.pXJ), stringExtra);
        if (!bi.oN(stringExtra)) {
            Map y = bj.y(stringExtra, "wording");
            if (y != null) {
                this.pXK = (String) y.get(".wording.title");
                this.jumpUrl = (String) y.get(".wording.url");
                x.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", this.pXK, this.jumpUrl);
            }
        }
        this.pXN = b.Xw();
        initView();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a((int) c.CTRL_INDEX, (e) this);
        as.CN().a(132, (e) this);
        if (!this.pXL) {
            b.b(true, as.CI() + "," + getClass().getName() + ",L600_100," + as.fJ("L600_100") + ",1");
            b.oY("L600_100");
        }
    }

    protected void onPause() {
        super.onPause();
        as.CN().b((int) c.CTRL_INDEX, (e) this);
        as.CN().b(132, (e) this);
        if (!this.pXL) {
            b.b(false, as.CI() + "," + getClass().getName() + ",L600_100," + as.fJ("L600_100") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bpd();
        return true;
    }

    protected final void initView() {
        setMMTitle(R.l.eHm);
        findViewById(R.h.cBT).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                k tVar;
                if (SecurityAccountIntroUI.this.pXL) {
                    tVar = new t(SecurityAccountIntroUI.this.fBa, 10, "", 0, "");
                } else {
                    tVar = new s(SecurityAccountIntroUI.this.fBa, 10, "", 0, "", SecurityAccountIntroUI.this.pXJ);
                }
                as.CN().a(tVar, 0);
                SecurityAccountIntroUI securityAccountIntroUI = SecurityAccountIntroUI.this;
                Context context = SecurityAccountIntroUI.this;
                SecurityAccountIntroUI.this.getString(R.l.dGZ);
                securityAccountIntroUI.inI = h.a(context, SecurityAccountIntroUI.this.getString(R.l.eHk), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(tVar);
                    }
                });
            }
        });
        if (!this.pXL) {
            this.pXM = (Button) findViewById(R.h.bWl);
            if (!bi.oN(this.pXK)) {
                this.pXM.setText(this.pXK);
            }
            this.pXM.setVisibility(0);
            this.pXM.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String d = w.d(SecurityAccountIntroUI.this.getSharedPreferences(ad.cgf(), 0));
                    Intent intent = new Intent();
                    if (bi.oN(SecurityAccountIntroUI.this.jumpUrl)) {
                        intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
                    } else {
                        intent.putExtra("rawUrl", SecurityAccountIntroUI.this.jumpUrl);
                    }
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", SecurityAccountIntroUI.this.getString(R.l.eHh));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    a.ihN.j(intent, SecurityAccountIntroUI.this);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SecurityAccountIntroUI.this.bpd();
                return true;
            }
        });
    }

    private void bpd() {
        b.oZ(this.pXN);
        cancel();
        En(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.pXL) {
                str2 = ((he) ((t) kVar).gLB.hnR.hnY).vQc;
            } else {
                str2 = ((s) kVar).Od();
            }
            x.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.pXJ + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.fBa);
            intent.putExtra("re_open_verify", this.pXL);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            MMWizardActivity.A(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
                return;
            }
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                h.a((Context) this, R.l.dLa, R.l.dGZ, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, R.l.dFa, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, R.l.dLd, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, R.l.dLe, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0 && !a.ihO.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.eHj, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
