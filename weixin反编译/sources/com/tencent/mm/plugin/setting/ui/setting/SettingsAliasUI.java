package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.setting.modelsimple.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

public class SettingsAliasUI extends MMActivity implements e {
    private String ggL;
    private ImageView ikK;
    private ProgressDialog inI = null;
    private TextView kHt;
    private EditText qoY;
    private c qoZ;
    private e qod = null;
    private boolean qpa = false;
    private TextView qpb;
    private TextView qpc;

    static /* synthetic */ void e(SettingsAliasUI settingsAliasUI) {
        if (settingsAliasUI.ggL.equals(q.FY())) {
            h.h(settingsAliasUI.mController.xRr, R.l.evM, R.l.evK);
        } else if (bi.Wa(settingsAliasUI.ggL)) {
            Context context = settingsAliasUI.mController.xRr;
            settingsAliasUI.getString(R.l.evK);
            settingsAliasUI.inI = h.a(context, settingsAliasUI.getString(R.l.evJ), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (SettingsAliasUI.this.qoZ != null) {
                        as.CN().c(SettingsAliasUI.this.qoZ);
                    }
                }
            });
            if (settingsAliasUI.qoZ != null) {
                as.CN().c(settingsAliasUI.qoZ);
            }
            settingsAliasUI.qoZ = new c(settingsAliasUI.ggL);
            as.CN().a(settingsAliasUI.qoZ, 0);
        } else {
            h.h(settingsAliasUI.mController.xRr, R.l.eSW, R.l.eDk);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qpa = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        initView();
        as.CN().a(177, (e) this);
    }

    protected final int getLayoutId() {
        return R.i.dsh;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        if (this.qoZ != null) {
            as.CN().c(this.qoZ);
        }
        as.CN().b(177, (e) this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.evK);
        this.ikK = (ImageView) findViewById(R.h.bLM);
        this.kHt = (TextView) findViewById(R.h.cAs);
        this.qpb = (TextView) findViewById(R.h.cUx);
        this.qpc = (TextView) findViewById(R.h.cxh);
        this.qoY = (EditText) findViewById(R.h.cHC);
        String FY = q.FY();
        if (!x.Xi(FY)) {
            this.qoY.setText(q.FY());
            this.qpb.setText(getString(R.l.dDU, new Object[]{FY}));
        }
        this.qoY.setSelection(this.qoY.getText().length());
        this.qoY.setFocusable(true);
        this.qoY.setFocusableInTouchMode(true);
        this.qoY.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SettingsAliasUI settingsAliasUI = SettingsAliasUI.this;
                a aVar = new a();
                if (charSequence.length() < 6 || charSequence.length() > 20) {
                    aVar.foE = settingsAliasUI.getString(R.l.eSW);
                    aVar.fsS = false;
                } else if (bi.o(charSequence.charAt(0))) {
                    int length = charSequence.length() - 1;
                    while (length > 0) {
                        char charAt = charSequence.charAt(length);
                        if (bi.o(charAt) || charAt == '-' || charAt == '_' || bi.p(charAt)) {
                            length--;
                        } else if (Character.isSpace(charAt)) {
                            aVar.foE = settingsAliasUI.getString(R.l.eST);
                            aVar.fsS = false;
                        } else if (bi.n(charAt)) {
                            aVar.foE = settingsAliasUI.getString(R.l.eSS);
                            aVar.fsS = false;
                        } else {
                            aVar.foE = settingsAliasUI.getString(R.l.eSW);
                            aVar.fsS = false;
                        }
                    }
                    aVar.foE = settingsAliasUI.getString(R.l.evN);
                    aVar.fsS = true;
                } else {
                    aVar.foE = settingsAliasUI.getString(R.l.eSU);
                    aVar.fsS = false;
                }
                if (aVar.fsS) {
                    SettingsAliasUI.this.enableOptionMenu(true);
                    SettingsAliasUI.this.qpc.setTextColor(SettingsAliasUI.this.getResources().getColorStateList(R.e.bsO));
                } else {
                    SettingsAliasUI.this.enableOptionMenu(false);
                    SettingsAliasUI.this.qpc.setTextColor(SettingsAliasUI.this.getResources().getColorStateList(R.e.btP));
                }
                SettingsAliasUI.this.qpc.setText(aVar.foE);
                SettingsAliasUI.this.qpb.setText(SettingsAliasUI.this.getString(R.l.dDU, new Object[]{charSequence}));
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.kHt.setText(i.b(this, bi.oM(q.Ga()), this.kHt.getTextSize()));
        b.a(this.ikK, FY);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAliasUI.this.aWY();
                SettingsAliasUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAliasUI.this.ggL = SettingsAliasUI.this.qoY.getText().toString().trim();
                if (q.FY().equalsIgnoreCase(SettingsAliasUI.this.ggL)) {
                    SettingsAliasUI.this.aWY();
                    SettingsAliasUI.this.finish();
                } else {
                    h.a(SettingsAliasUI.this.mController.xRr, SettingsAliasUI.this.getString(R.l.evL, new Object[]{SettingsAliasUI.this.ggL}), SettingsAliasUI.this.getString(R.l.dUt), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SettingsAliasUI.e(SettingsAliasUI.this);
                        }
                    }, null);
                }
                return true;
            }
        }, p.b.xSe);
        enableOptionMenu(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.ad.k r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        if (r6 != 0) goto L_0x0042;
    L_0x0004:
        if (r7 != 0) goto L_0x0042;
    L_0x0006:
        r2 = r5.qpa;
        if (r2 == 0) goto L_0x0014;
    L_0x000a:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 10358; // 0x2876 float:1.4515E-41 double:5.1175E-320;
        r4 = "1";
        r2.k(r3, r4);
    L_0x0014:
        r5.aWY();
        com.tencent.mm.y.as.Hm();
        r2 = com.tencent.mm.y.c.Db();
        r3 = 42;
        r4 = r5.ggL;
        r2.set(r3, r4);
        r2 = com.tencent.mm.y.as.CN();
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = new com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI$5;
        r4.<init>();
        r5.qod = r4;
        r2.a(r3, r4);
        r2 = new com.tencent.mm.modelsimple.x;
        r2.<init>(r0);
        r0 = com.tencent.mm.y.as.CN();
        r0.a(r2, r1);
    L_0x0041:
        return;
    L_0x0042:
        r2 = r5.inI;
        if (r2 == 0) goto L_0x004e;
    L_0x0046:
        r2 = r5.inI;
        r2.dismiss();
        r2 = 0;
        r5.inI = r2;
    L_0x004e:
        r2 = com.tencent.mm.plugin.setting.a.ihO;
        r3 = r5.mController;
        r3 = r3.xRr;
        r2 = r2.a(r3, r6, r7, r8);
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        if (r0 == 0) goto L_0x0041;
    L_0x005c:
        goto L_0x0041;
    L_0x005d:
        switch(r6) {
            case 4: goto L_0x0062;
            default: goto L_0x0060;
        };
    L_0x0060:
        r0 = r1;
        goto L_0x005a;
    L_0x0062:
        r2 = -7;
        if (r7 == r2) goto L_0x0069;
    L_0x0065:
        r2 = -10;
        if (r7 != r2) goto L_0x0060;
    L_0x0069:
        r1 = r5.mController;
        r1 = r1.xRr;
        r2 = com.tencent.mm.R.l.eDi;
        r3 = com.tencent.mm.R.l.evO;
        com.tencent.mm.ui.base.h.h(r1, r2, r3);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}
