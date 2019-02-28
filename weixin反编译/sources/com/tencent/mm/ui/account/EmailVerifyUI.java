package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditText;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.Iterator;

public class EmailVerifyUI extends MMActivity implements e {
    private ProgressDialog inI = null;
    private String pXN;
    private TextView xWf;
    private TextView xWg;
    private MMAutoSwitchEditTextView xWh;
    private Button xWi;
    private Button xWj;
    private String xWk;
    private String xWl;
    private String xWm;
    private String xWn;
    private boolean xWo = false;

    static /* synthetic */ void a(EmailVerifyUI emailVerifyUI, String str) {
        if (emailVerifyUI.xWo) {
            x.i("MicroMsg.EmailVerifyUI", "is verifying, wait a minute");
            return;
        }
        emailVerifyUI.xWo = true;
        final k uVar = new u(emailVerifyUI.xWk, emailVerifyUI.xWm, str);
        as.CN().a(uVar, 0);
        emailVerifyUI.getString(R.l.dGZ);
        emailVerifyUI.inI = h.a((Context) emailVerifyUI, emailVerifyUI.getString(R.l.eDC), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(uVar);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.pXN = b.Xw();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(481, (e) this);
        b.b(true, as.CI() + "," + getClass().getName() + ",R500_200," + as.fJ("R500_200") + ",1");
        b.oY("R500_200");
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(481, (e) this);
        b.b(false, as.CI() + "," + getClass().getName() + ",R500_200," + as.fJ("R500_200") + ",2");
    }

    protected final int getLayoutId() {
        return R.i.dtB;
    }

    protected final void initView() {
        setMMTitle(R.l.eDE);
        this.xWf = (TextView) findViewById(R.h.cUG);
        this.xWf.setText(Html.fromHtml(getString(R.l.eDr)));
        this.xWg = (TextView) findViewById(R.h.cdm);
        this.xWk = getIntent().getStringExtra("email_address");
        if (bi.oN(this.xWk)) {
            x.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.xWg.setText(this.xWk);
        }
        this.xWm = getIntent().getStringExtra("password");
        this.xWl = getIntent().getStringExtra("email_login_page");
        x.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", this.xWk, this.xWl);
        this.xWh = (MMAutoSwitchEditTextView) findViewById(R.h.bLA);
        this.xWh.yin = new a() {
            public final void Za(String str) {
                EmailVerifyUI.this.enableOptionMenu(true);
                EmailVerifyUI.a(EmailVerifyUI.this, str);
            }
        };
        this.xWh.yio = new MMAutoSwitchEditTextView.b() {
            public final void coy() {
                EmailVerifyUI.this.enableOptionMenu(false);
            }
        };
        this.xWj = (Button) findViewById(R.h.cFz);
        this.xWj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.pa(as.CI() + "," + getClass().getName() + ",R500_250," + as.fJ("R500_250") + ",3");
                h.a(EmailVerifyUI.this, R.l.eDv, R.l.eDp, R.l.dGf, R.l.dEy, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final k uVar = new u(EmailVerifyUI.this.xWk, EmailVerifyUI.this.xWm);
                        as.CN().a(uVar, 0);
                        EmailVerifyUI emailVerifyUI = EmailVerifyUI.this;
                        Context context = EmailVerifyUI.this;
                        EmailVerifyUI.this.getString(R.l.dGZ);
                        emailVerifyUI.inI = h.a(context, EmailVerifyUI.this.getString(R.l.eDD), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(uVar);
                            }
                        });
                    }
                }, null);
            }
        });
        this.xWi = (Button) findViewById(R.h.cBN);
        if (bi.oN(this.xWl) || bi.oN(this.xWk)) {
            this.xWi.setVisibility(8);
        } else {
            this.xWi.setVisibility(0);
            this.xWi.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    bi.F(EmailVerifyUI.this, EmailVerifyUI.this.xWl);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmailVerifyUI.this.goBack();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmailVerifyUI emailVerifyUI = EmailVerifyUI.this;
                String str = "";
                Iterator it = EmailVerifyUI.this.xWh.yil.iterator();
                while (it.hasNext()) {
                    String str2;
                    MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                    if (bi.oN(mMAutoSwitchEditText.getText().toString().trim())) {
                        str2 = str;
                    } else {
                        str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                    }
                    str = str2;
                }
                emailVerifyUI.xWn = str;
                if (bi.oN(EmailVerifyUI.this.xWn) || EmailVerifyUI.this.xWn.length() != 12) {
                    EmailVerifyUI.this.enableOptionMenu(false);
                } else {
                    EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.this.xWn);
                }
                return true;
            }
        });
        enableOptionMenu(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.oZ(this.pXN);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.xWo = false;
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (kVar.getType() != 481) {
            x.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", Integer.valueOf(kVar.getType()));
            return;
        }
        int i3 = ((p.a) ((u) kVar).hoZ.Kh()).vIo.vQC;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!com.tencent.mm.plugin.c.a.ihO.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, R.l.eDn, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        h.a((Context) this, R.l.eDo, R.l.eDp, null);
                        i4 = 1;
                        break;
                    case -32:
                        h.a((Context) this, R.l.eDq, R.l.eDp, null);
                        b.pa(as.CI() + "," + getClass().getName() + ",R500_260," + as.fJ("R500_260") + ",3");
                        i4 = 1;
                        break;
                    default:
                        boolean i42 = false;
                        break;
                }
            }
            i42 = 1;
            if (i42 != 0) {
                return;
            }
            if (i3 == 2) {
                Toast.makeText(this, getString(R.l.eDF, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i3 == 1) {
                Toast.makeText(this, getString(R.l.eDw, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (i3 == 2) {
            b.oZ("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((p.b) ((u) kVar).hoZ.Hv()).vIp.wgO);
            intent.putExtra("regsetinfo_user", this.xWk);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((u) kVar).Om());
            intent.putExtra("regsetinfo_pwd", this.xWm);
            intent.putExtra("regsetinfo_bind_email", this.xWk);
            startActivity(intent);
        } else if (i3 == 1) {
            b.pa(as.CI() + "," + getClass().getName() + ",R22_resend_email_code_alert," + as.fJ("R22_resend_email_code_alert") + ",3");
            h.bu(this, getString(R.l.eDx));
        } else {
            x.e("MicroMsg.EmailVerifyUI", "err opcode");
        }
    }
}
