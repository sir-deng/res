package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class ContactSearchUI extends MMActivity implements e {
    private ProgressDialog inI = null;
    private EditText sez;

    protected final int getLayoutId() {
        return R.i.dfe;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        as.CN().a(106, (e) this);
        super.onResume();
    }

    protected void onPause() {
        as.CN().b(106, (e) this);
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(R.l.dXA);
        this.sez = (EditText) findViewById(R.h.bYt);
        this.sez.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                ContactSearchUI.this.enableOptionMenu(editable.length() > 0);
            }
        });
        this.sez.setImeOptions(3);
        this.sez.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || bi.oN(ContactSearchUI.this.sez.getText().toString().trim()))) {
                    ContactSearchUI.this.bES();
                }
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.l.dFv), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactSearchUI.this.bES();
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactSearchUI.this.aWY();
                ContactSearchUI.this.finish();
                return true;
            }
        });
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.sez.setText(getIntent().getStringExtra("userName"));
            bES();
        }
    }

    private void bES() {
        String trim = this.sez.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.h(this.mController.xRr, R.l.eTa, R.l.dGZ);
            return;
        }
        x.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        final k acVar = new ac(trim, 1);
        as.CN().a(acVar, 0);
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.inI = h.a(context, getString(R.l.dDr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(acVar);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (!b.ihO.b(this.mController.xRr, i, i2, str)) {
            if (i == 4 && i2 == -4) {
                h.h(this.mController.xRr, R.l.dDo, R.l.dGZ);
            } else if (i == 0 && i2 == 0) {
                bfr Sv = ((ac) kVar).Sv();
                if (Sv.wrp > 0) {
                    Intent intent = new Intent();
                    intent.setClass(this, ContactSearchResultUI.class);
                    try {
                        intent.putExtra("result", Sv.toByteArray());
                        startActivity(intent);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                        return;
                    }
                }
                String a = n.a(Sv.wfM);
                Intent intent2 = new Intent();
                ((j) g.h(j.class)).a(intent2, Sv, MS(this.sez.getText().toString().trim()));
                if (bi.oM(a).length() > 0) {
                    if ((Sv.wCq & 8) > 0) {
                        com.tencent.mm.plugin.report.service.g.pWK.k(10298, a + "," + MS(this.sez.getText().toString().trim()));
                    }
                    d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                }
            } else {
                Toast.makeText(this, getString(R.l.ejs), 0).show();
                x.w("MicroMsg.ContactSearchUI", getString(R.l.ejr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }
    }

    private static int MS(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 3;
        r1 = com.tencent.mm.sdk.platformtools.bi.VY(r2);
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        r0 = 1;
    L_0x0008:
        return r0;
    L_0x0009:
        r1 = com.tencent.mm.sdk.platformtools.bi.VZ(r2);
        if (r1 == 0) goto L_0x0011;
    L_0x000f:
        r0 = 2;
        goto L_0x0008;
    L_0x0011:
        r1 = com.tencent.mm.sdk.platformtools.bi.Wa(r2);
        if (r1 == 0) goto L_0x0008;
    L_0x0017:
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.MS(java.lang.String):int");
    }
}
