package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;

public class RegByQQAuthUI extends MMActivity implements e {
    private String fEw;
    private String fsK;
    private String hPj;
    private ProgressDialog inI = null;
    private String xXT;
    private EditText yaj = null;
    private int yak;

    protected final int getLayoutId() {
        return R.i.dqR;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        as.CN().a(126, (e) this);
    }

    public void onPause() {
        super.onPause();
        as.CN().b(126, (e) this);
    }

    protected final void initView() {
        this.yak = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.xXT = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.hPj = getIntent().getStringExtra("RegByQQ_Account");
        this.fsK = getIntent().getStringExtra("RegByQQ_Ticket");
        this.fEw = getIntent().getStringExtra("RegByQQ_Nick");
        x.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.yak + "  pass:" + this.xXT + "  ticket:" + this.fsK);
        this.yaj = (EditText) findViewById(R.h.cAn);
        if (!(this.fEw == null || this.fEw.equals(""))) {
            this.yaj.setText(this.fEw);
        }
        setMMTitle(R.l.eEs);
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByQQAuthUI.this.fEw = RegByQQAuthUI.this.yaj.getText().toString().trim();
                if (RegByQQAuthUI.this.fEw.equals("")) {
                    h.h(RegByQQAuthUI.this, R.l.eSV, R.l.dEY);
                } else {
                    final k yVar = new y("", RegByQQAuthUI.this.xXT, RegByQQAuthUI.this.fEw, RegByQQAuthUI.this.yak, "", "", RegByQQAuthUI.this.fsK, 2);
                    as.CN().a(yVar, 0);
                    RegByQQAuthUI regByQQAuthUI = RegByQQAuthUI.this;
                    Context context = RegByQQAuthUI.this;
                    RegByQQAuthUI.this.getString(R.l.dGZ);
                    regByQQAuthUI.inI = h.a(context, RegByQQAuthUI.this.getString(R.l.eEu), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(yVar);
                        }
                    });
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByQQAuthUI.this.aWY();
                RegByQQAuthUI.this.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (!bi.bF(this)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 126:
                    as.unhold();
                    ar.hhz.S("login_user_name", this.hPj);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent at = a.ihN.at(this);
                    at.addFlags(67108864);
                    at.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, at);
                    return;
                default:
                    return;
            }
        }
        boolean z;
        if (kVar.getType() == 126) {
            com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
            if (eC != null) {
                eC.a(this, null, null);
                return;
            }
        }
        if (a.ihO.a(this.mController.xRr, i, i2, str)) {
            z = true;
        } else {
            if (i == 4) {
                switch (i2) {
                    case -75:
                        h.h(this.mController.xRr, R.l.dDR, R.l.dGZ);
                        z = true;
                        break;
                    case -72:
                        h.h(this.mController.xRr, R.l.eEo, R.l.dGZ);
                        z = true;
                        break;
                    case -12:
                        h.h(this, R.l.eEr, R.l.eEq);
                        z = true;
                        break;
                    case -11:
                        h.h(this, R.l.eEp, R.l.eEq);
                        z = true;
                        break;
                    case -4:
                        h.h(this, R.l.dEW, R.l.eEq);
                        z = true;
                        break;
                    case -1:
                        if (as.CN().Ks() == 5) {
                            h.h(this, R.l.exT, R.l.exS);
                            z = true;
                            break;
                        }
                    case -3:
                        h.h(this, R.l.dEX, R.l.eEq);
                        z = true;
                        break;
                }
            }
            z = false;
        }
        if (!z) {
            Toast.makeText(this, getString(R.l.ejm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
