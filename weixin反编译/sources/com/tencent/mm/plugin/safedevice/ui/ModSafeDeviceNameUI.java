package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.safedevice.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.as;

public class ModSafeDeviceNameUI extends MMActivity implements e {
    private String fsb;
    private long hXs;
    private ProgressDialog inI = null;
    private String lfP;
    private EditText pXl;
    private String pXm;
    private String pXn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        as.CN().a(361, (e) this);
        super.onResume();
    }

    protected void onPause() {
        as.CN().b(361, (e) this);
        super.onPause();
    }

    protected final void initView() {
        this.pXm = getIntent().getStringExtra("safe_device_name");
        this.pXn = getIntent().getStringExtra("safe_device_uid");
        this.fsb = getIntent().getStringExtra("safe_device_type");
        setMMTitle(a.ac(this, R.l.eHc));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModSafeDeviceNameUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModSafeDeviceNameUI.this.lfP = ModSafeDeviceNameUI.this.pXl.getText().toString();
                if (!bi.oN(ModSafeDeviceNameUI.this.lfP)) {
                    ModSafeDeviceNameUI.this.aWY();
                    final k bVar = new b(ModSafeDeviceNameUI.this.pXn, ModSafeDeviceNameUI.this.lfP, ModSafeDeviceNameUI.this.fsb);
                    as.CN().a(bVar, 0);
                    ModSafeDeviceNameUI.this.inI = h.a(ModSafeDeviceNameUI.this, a.ac(ModSafeDeviceNameUI.this, R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(bVar);
                        }
                    });
                }
                return true;
            }
        });
        MMEditText.b anonymousClass3 = new MMEditText.b() {
            public final void bpb() {
                if (ModSafeDeviceNameUI.this.pXl.getText().toString().trim().length() > 0) {
                    ModSafeDeviceNameUI.this.enableOptionMenu(true);
                } else {
                    ModSafeDeviceNameUI.this.enableOptionMenu(false);
                }
            }
        };
        this.pXl = (EditText) findViewById(R.h.cxd);
        TextWatcher cVar = new c(this.pXl, null, 32);
        cVar.zCV = anonymousClass3;
        this.pXl.addTextChangedListener(cVar);
        if (bi.oN(this.pXm)) {
            enableOptionMenu(false);
        } else {
            this.pXl.setText(this.pXm);
        }
    }

    protected final int getLayoutId() {
        return R.i.cxd;
    }

    public final void a(int r5, int r6, java.lang.String r7, com.tencent.mm.ad.k r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.inI;
        if (r0 == 0) goto L_0x0014;
    L_0x0004:
        r0 = r4.inI;
        r0 = r0.isShowing();
        if (r0 == 0) goto L_0x0014;
    L_0x000c:
        r0 = r4.inI;
        r0.dismiss();
        r0 = 0;
        r4.inI = r0;
    L_0x0014:
        if (r5 != 0) goto L_0x0050;
    L_0x0016:
        if (r6 != 0) goto L_0x0050;
    L_0x0018:
        r0 = new com.tencent.mm.plugin.safedevice.a.c;
        r0.<init>();
        r1 = r4.fsb;
        r0.field_devicetype = r1;
        r1 = r4.lfP;
        r0.field_name = r1;
        r1 = r4.pXn;
        r0.field_uid = r1;
        r2 = r4.hXs;
        r0.field_createtime = r2;
        r1 = com.tencent.mm.plugin.safedevice.a.f.bpa();
        r2 = 0;
        r2 = new java.lang.String[r2];
        r1.c(r0, r2);
        r0 = com.tencent.mm.R.l.eHg;
        r0 = com.tencent.mm.bu.a.ac(r4, r0);
        com.tencent.mm.ui.base.h.bu(r4, r0);
        r0 = new com.tencent.mm.sdk.platformtools.ag;
        r0.<init>();
        r1 = new com.tencent.mm.plugin.safedevice.ui.ModSafeDeviceNameUI$4;
        r1.<init>();
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.postDelayed(r1, r2);
    L_0x004f:
        return;
    L_0x0050:
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r0 = r0.a(r4, r5, r6, r7);
        if (r0 == 0) goto L_0x004f;
    L_0x0058:
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.safedevice.ui.ModSafeDeviceNameUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}
