package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.wcdb.FileUtils;

public class BindMContactUI extends MMWizardActivity {
    private String countryCode = null;
    private String fBa;
    private int fromScene = 0;
    private String hGi = null;
    private boolean ksj = false;
    private LinearLayout xYI;
    private TextView xYJ;
    private String xYM = null;
    private EditText ybR;
    private TextView ybS;
    private i ybT;
    private CheckBox ybX;
    private boolean yci = false;
    private boolean yck = false;
    private boolean yun = false;
    private TextView yux;
    private LinearLayout yuy;
    private boolean yuz = false;

    static /* synthetic */ void b(BindMContactUI bindMContactUI, final String str) {
        if (bindMContactUI.ybT == null) {
            int i = b.zmQ;
            if (bindMContactUI.yuz) {
                i = b.zmR;
            }
            bindMContactUI.ybT = new i(i, bindMContactUI, new a() {
                public final void EA(int i) {
                    Intent intent;
                    if (i == 1) {
                        if (BindMContactUI.this.yci) {
                            x.i("MicroMsg.BindMContactUI", "to startMySafedeviceListUI");
                            if (!q.Gg()) {
                                com.tencent.mm.sdk.b.b scVar = new sc();
                                scVar.fKF.fKG = true;
                                scVar.fKF.fKH = true;
                                com.tencent.mm.sdk.b.a.xmy.m(scVar);
                            }
                            BindMContactUI.this.En(1);
                            intent = new Intent();
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.c.a.ihN.e(BindMContactUI.this, intent);
                        } else if (BindMContactUI.this.yuz) {
                            x.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for change mobile");
                            h.bu(BindMContactUI.this, BindMContactUI.this.getString(R.l.eGK));
                            MMWizardActivity.A(BindMContactUI.this, new Intent(BindMContactUI.this, BindMContactStatusUI.class));
                        } else if (BindMContactUI.this.fromScene == 5) {
                            x.i("MicroMsg.BindMContactUI", "to finish  finishWizard for get phone number");
                            BindMContactUI.this.En(-1);
                        } else {
                            if (BindMContactUI.this.ksj) {
                                if (BindMContactUI.this.yun) {
                                    g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                                } else {
                                    g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                                }
                            }
                            x.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for contact sync or other");
                            MMWizardActivity.A(BindMContactUI.this, new Intent(BindMContactUI.this, BindMContactStatusUI.class));
                        }
                    } else if (i == 2) {
                        x.i("MicroMsg.BindMContactUI", "reg next to BindMContactVerifyUI for bind mobile");
                        intent = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("is_bind_for_safe_device", BindMContactUI.this.yci);
                        intent.putExtra("is_bind_for_contact_sync", BindMContactUI.this.yun);
                        intent.putExtra("is_bind_for_change_mobile", BindMContactUI.this.yuz);
                        intent.putExtra("KEnterFromBanner", BindMContactUI.this.ksj);
                        if (BindMContactUI.this.ybX != null) {
                            intent.putExtra("BIND_FIND_ME_BY_MOBILE", BindMContactUI.this.ybX.isChecked());
                        }
                        intent.putExtra("BIND_FOR_QQ_REG", BindMContactUI.this.yck);
                        intent.putExtra("bind_scene", BindMContactUI.this.fromScene);
                        MMWizardActivity.A(BindMContactUI.this, intent);
                    }
                }
            });
            bindMContactUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactUI.ybT);
        }
        i iVar = bindMContactUI.ybT;
        boolean z = (bindMContactUI.yci || bindMContactUI.yun) ? false : true;
        iVar.zmM = z;
        bindMContactUI.ybT.aax(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dLv);
        this.hGi = bi.aD(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bi.aD(getIntent().getStringExtra("couttry_code"), "");
        this.xYM = bi.aD(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ybT != null) {
            getContentResolver().unregisterContentObserver(this.ybT);
            this.ybT.recycle();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        cro();
        return true;
    }

    private void cro() {
        if (this.yci || this.yun) {
            xTb.clear();
            En(1);
            return;
        }
        h.a((Context) this, this.yuz ? R.l.dLi : R.l.dLh, this.yuz ? R.l.dLk : R.l.dLj, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                BindMContactUI.this.En(1);
            }
        }, null);
    }

    protected final void initView() {
        this.yci = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.yun = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.yck = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.yuz = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.ksj = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        x.i("MicroMsg.BindMContactUI", "bindScene:%d", Integer.valueOf(this.fromScene));
        this.ybR = (EditText) findViewById(R.h.bNt);
        this.xYI = (LinearLayout) findViewById(R.h.bZf);
        this.xYJ = (TextView) findViewById(R.h.bZh);
        this.ybS = (TextView) findViewById(R.h.bZd);
        this.ybX = (CheckBox) findViewById(R.h.bNq);
        this.yuy = (LinearLayout) findViewById(R.h.bNr);
        this.yux = (TextView) findViewById(R.h.cMb);
        if (this.yuz) {
            as.Hm();
            String str = (String) c.Db().get(6, null);
            if (!bi.oN(str)) {
                String DK;
                if (str.startsWith("+")) {
                    DK = ap.DK(str);
                    String str2 = DK;
                    DK = str.substring(DK.length() + 1);
                    str = str2;
                } else {
                    DK = str;
                    str = "86";
                }
                ap apVar = new ap();
                str = ap.formatNumber(str, DK);
                this.yux.setText(getString(R.l.dKW, new Object[]{str}));
            }
        }
        if (!(this.hGi == null || this.hGi.equals(""))) {
            this.xYJ.setText(this.hGi);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.ybS.setText("+" + this.countryCode);
        }
        if (this.xYM == null || this.xYM.equals("")) {
            as.Dt().a(new ah.a() {
                String lhE;

                public final boolean JI() {
                    if (bi.oN((BindMContactUI.this.ybR.getText()).trim())) {
                        if (bi.oN(this.lhE)) {
                            BindMContactUI.this.ybR.setText("");
                        } else {
                            BindMContactUI.this.ybR.setText(this.lhE);
                            BindMContactUI.this.ybR.setSelection(this.lhE.length());
                        }
                    }
                    return true;
                }

                public final boolean JH() {
                    this.lhE = com.tencent.mm.modelsimple.c.z(BindMContactUI.this, BindMContactUI.this.countryCode);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView";
                }
            });
        } else {
            this.ybR.setText(this.xYM);
            this.ybR.setSelection(this.xYM.length());
        }
        if (com.tencent.mm.aq.b.PZ()) {
            this.yuy.setVisibility(4);
            this.ybX.setChecked(true);
        }
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindMContactUI.this.fBa = BindMContactUI.this.ybS.getText().toString().trim() + bi.DS(BindMContactUI.this.ybR.getText().toString());
                if (!com.tencent.mm.pluginsdk.a.RG(BindMContactUI.this.fBa) || bi.DS(BindMContactUI.this.ybR.getText().toString()).length() <= 0) {
                    h.h(BindMContactUI.this, R.l.dLr, R.l.dGZ);
                } else {
                    x.i("MicroMsg.BindMContactUI", "do next, send sms to self");
                    BindMContactUI.b(BindMContactUI.this, BindMContactUI.this.fBa);
                }
                return true;
            }
        });
        this.ybR.requestFocus();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindMContactUI.this.cro();
                return true;
            }
        });
        this.xYI.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMContactUI.this.hGi);
                intent.putExtra("couttry_code", BindMContactUI.this.countryCode);
                com.tencent.mm.plugin.c.a.ihN.b(intent, BindMContactUI.this);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.hGi = bi.aD(intent.getStringExtra("country_name"), "");
                this.countryCode = bi.aD(intent.getStringExtra("couttry_code"), "");
                if (!this.hGi.equals("")) {
                    this.xYJ.setText(this.hGi);
                }
                if (!this.countryCode.equals("")) {
                    this.ybS.setText("+" + this.countryCode);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dbl;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.ybT != null) {
                    this.ybT.cpg();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
