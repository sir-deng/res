package com.tencent.mm.ui.account.bind;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.wcdb.FileUtils;

public class BindMobileUI extends MMWizardActivity {
    private String countryCode = null;
    private String fBa;
    private String hGi = null;
    private TextView jtn;
    private LinearLayout xYI;
    private TextView xYJ;
    private String xYM = null;
    private BindWordingContent ybL;
    private int ybM;
    private EditText ybR;
    private TextView ybS;
    private i ybT;
    private Button ybU;
    private TextView ybV;
    private TextView ybW;
    private CheckBox ybX;
    private CheckBox ybY;
    private LinearLayout ybZ;
    private ImageView yca;
    private boolean ycb;

    static /* synthetic */ void a(BindMobileUI bindMobileUI, final String str) {
        if (bindMobileUI.ybT == null) {
            bindMobileUI.ybT = new i(b.zmQ, bindMobileUI, new a() {
                public final void EA(int i) {
                    boolean z = true;
                    if (i == 1) {
                        if (BindMobileUI.this.ycb) {
                            Context context = BindMobileUI.this;
                            boolean z2 = !BindMobileUI.this.ybX.isChecked();
                            if (BindMobileUI.this.ybY.isChecked()) {
                                z = false;
                            }
                            BindMobileStatusUI.c(context, z2, z);
                            BindMobileUI.this.exit(-1);
                            return;
                        }
                        Intent intent = new Intent(BindMobileUI.this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", BindMobileUI.this.ybL);
                        intent.putExtra("kstyle_bind_recommend_show", BindMobileUI.this.ybM);
                        intent.putExtra("Kfind_friend_by_mobile_flag", BindMobileUI.this.ybX.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", BindMobileUI.this.ybY.isChecked());
                        MMWizardActivity.A(BindMobileUI.this, intent);
                    } else if (i == 2) {
                        BindMobileUI.d(BindMobileUI.this, str);
                    }
                }
            });
            bindMobileUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMobileUI.ybT);
        }
        bindMobileUI.ybT.aax(str);
        if (bindMobileUI.ycb) {
            bindMobileUI.ybT.zmM = false;
        }
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, final String str) {
        String string = bindMobileUI.mController.xRr.getString(R.l.dLP);
        h.a(bindMobileUI.mController.xRr, String.format("%s\n%s", new Object[]{bindMobileUI.mController.xRr.getString(R.l.dLQ), str}), string, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                BindMobileUI.a(BindMobileUI.this, str);
            }
        }, null);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.ybL);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.ybM);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.ybX.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.ybY.isChecked());
        intent.putExtra("is_bind_for_chatroom_upgrade", bindMobileUI.ycb);
        MMWizardActivity.A(bindMobileUI, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dLt);
        this.hGi = bi.aD(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bi.aD(getIntent().getStringExtra("couttry_code"), "");
        this.xYM = bi.aD(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.ybL = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.ybM = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.ycb = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
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
        En(1);
        return true;
    }

    protected final void initView() {
        this.ybR = (EditText) findViewById(R.h.bNt);
        this.xYI = (LinearLayout) findViewById(R.h.bZf);
        this.xYJ = (TextView) findViewById(R.h.bZh);
        this.ybS = (TextView) findViewById(R.h.bZd);
        this.jtn = (TextView) findViewById(R.h.bNx);
        this.ybU = (Button) findViewById(R.h.bNf);
        this.ybV = (TextView) findViewById(R.h.bNu);
        this.jtn.setText(getString(R.l.dLs));
        this.ybW = (TextView) findViewById(R.h.bNg);
        this.ybZ = (LinearLayout) findViewById(R.h.bNw);
        this.ybY = (CheckBox) findViewById(R.h.bNp);
        this.ybX = (CheckBox) findViewById(R.h.bNo);
        this.yca = (ImageView) findViewById(R.h.bNs);
        if (this.ybL != null) {
            if (this.ybL.title != null && this.ybL.title.length() > 0) {
                this.jtn.setText(this.ybL.title);
            }
            if (this.ybL.content != null && this.ybL.content.length() > 0) {
                this.ybW.setText(this.ybL.content);
            }
            switch (this.ybL.hOj.intValue()) {
                case 0:
                    this.yca.setImageResource(R.g.bzo);
                    break;
                case 1:
                    this.yca.setImageResource(R.g.bzr);
                    break;
                case 2:
                    this.yca.setImageResource(R.g.bzp);
                    break;
            }
        }
        switch (this.ybM) {
            case 0:
                this.ybZ.setVisibility(0);
                this.ybY.setVisibility(0);
                this.ybW.setVisibility(8);
                break;
            case 1:
                this.ybZ.setVisibility(8);
                this.ybY.setVisibility(8);
                this.ybW.setVisibility(0);
                break;
        }
        if (bi.oN(this.hGi) && bi.oN(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bi.oN(simCountryIso)) {
                x.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.aq.b.a h = com.tencent.mm.aq.b.h(this, simCountryIso, getString(R.l.bZd));
                if (h == null) {
                    x.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                } else {
                    this.hGi = h.hGi;
                    this.countryCode = h.hGh;
                }
            }
        }
        if (!(this.hGi == null || this.hGi.equals(""))) {
            this.xYJ.setText(this.hGi);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.ybS.setText("+" + this.countryCode);
        }
        if (!(this.xYM == null || this.xYM.equals(""))) {
            this.ybR.setText(this.xYM);
        }
        this.ybU.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (BindMobileUI.this.ybR.getText().toString() == null || BindMobileUI.this.ybR.getText().toString().length() == 0) {
                    Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(R.l.dLd), 0).show();
                    return;
                }
                BindMobileUI.this.fBa = BindMobileUI.this.ybS.getText().toString().trim() + bi.DS(BindMobileUI.this.ybR.getText().toString());
                BindMobileUI.c(BindMobileUI.this, BindMobileUI.this.fBa);
            }
        });
        this.ybV.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BindMobileUI.this.En(1);
            }
        });
        if (this.ycb) {
            setMMTitle(R.l.dKS);
            this.yca.setVisibility(8);
            this.jtn.setText(R.l.dLl);
            this.ybZ.setVisibility(8);
            this.ybY.setVisibility(8);
            this.ybY.setChecked(false);
            this.ybX.setVisibility(0);
            this.ybX.setChecked(false);
            this.ybW.setVisibility(8);
            this.ybW.setText(getString(R.l.dKT));
            this.ybV.setVisibility(8);
            this.ybU.setText(R.l.dKS);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BindMobileUI.this.En(1);
                    return true;
                }
            });
        }
        this.xYI.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.hGi);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                com.tencent.mm.plugin.c.a.ihN.b(intent, BindMobileUI.this);
            }
        });
        this.xYI.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.hGi);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                com.tencent.mm.plugin.c.a.ihN.b(intent, BindMobileUI.this);
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
        return R.i.dbf;
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
