package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.hp;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class BindMContactVerifyUI extends MMWizardActivity implements e {
    private String fBa;
    private int fromScene = 0;
    private SharedPreferences hbz;
    private boolean ksj = false;
    private int status;
    private r tipDialog = null;
    private TextView ycX;
    private EditText yce;
    private Button ych;
    private boolean yci = false;
    private boolean yck = false;
    private boolean yuB = false;
    private boolean yun = false;
    private boolean yuz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(132, (e) this);
        setMMTitle(R.l.dLy);
        this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = q.Gc();
        initView();
    }

    public void onDestroy() {
        as.CN().b(132, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dbo;
    }

    protected final void initView() {
        as.Hm();
        this.fBa = (String) c.Db().get(4097, null);
        this.yce = (EditText) findViewById(R.h.bNB);
        this.yci = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.yun = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.yck = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.yuB = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
        this.yuz = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.ksj = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(R.h.bNy);
        if (this.fBa == null || this.fBa.equals("")) {
            as.Hm();
            this.fBa = (String) c.Db().get(6, null);
        }
        this.yce.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return bi.O(charSequence);
            }
        }});
        this.ych = (Button) findViewById(R.h.bND);
        this.ycX = (TextView) findViewById(R.h.bNz);
        boolean z = this.yuB;
        if (z) {
            this.status &= -513;
        } else {
            this.status |= WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        this.hbz.edit().putBoolean("settings_find_me_by_mobile", z).commit();
        x.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
        this.ycX.setText(getString(R.l.dLp, new Object[]{this.fBa}));
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String trim = BindMContactVerifyUI.this.yce.getText().toString().trim();
                if (trim.equals("")) {
                    h.h(BindMContactVerifyUI.this, R.l.dLR, R.l.dGZ);
                    return;
                }
                BindMContactVerifyUI.this.aWY();
                b hpVar = new hp();
                hpVar.fyM.context = BindMContactVerifyUI.this;
                a.xmy.m(hpVar);
                String str = hpVar.fyN.fyO;
                hpVar = new hq();
                a.xmy.m(hpVar);
                String str2 = hpVar.fyP.fyQ;
                int i = 2;
                if (BindMContactVerifyUI.this.yuz) {
                    i = 19;
                }
                final k tVar = new t(BindMContactVerifyUI.this.fBa, i, trim, "", str, str2);
                as.CN().a(tVar, 0);
                BindMContactVerifyUI bindMContactVerifyUI = BindMContactVerifyUI.this;
                Context context = BindMContactVerifyUI.this;
                BindMContactVerifyUI.this.getString(R.l.dGZ);
                bindMContactVerifyUI.tipDialog = h.a(context, BindMContactVerifyUI.this.getString(R.l.dLI), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(tVar);
                    }
                });
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindMContactVerifyUI.this.En(1);
                return true;
            }
        });
        this.ych.setVisibility(com.tencent.mm.aq.b.lJ(this.fBa) ? 0 : 8);
        this.ych.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMContactVerifyUI.this.aWY();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMContactVerifyUI.this.fBa);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.c.a.ihN.f(BindMContactVerifyUI.this, intent);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        En(1);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((t) kVar).IY() == 2 || ((t) kVar).IY() == 19) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            boolean z;
            if (i != 0 || i2 != 0) {
                com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                if (eC != null) {
                    eC.a(this, null, null);
                    return;
                }
                if (!com.tencent.mm.plugin.c.a.ihO.a((Context) this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            eC = com.tencent.mm.g.a.eC(str);
                            if (eC != null) {
                                eC.a(this, null, null);
                            }
                            z = true;
                            break;
                        case -43:
                            Toast.makeText(this, R.l.dLb, 0).show();
                            z = true;
                            break;
                        case -41:
                            Toast.makeText(this, R.l.dLd, 0).show();
                            z = true;
                            break;
                        case -36:
                            Toast.makeText(this, R.l.dLg, 0).show();
                            z = true;
                            break;
                        case -35:
                            Toast.makeText(this, R.l.dLc, 0).show();
                            z = true;
                            break;
                        case -34:
                            Toast.makeText(this, R.l.dLe, 0).show();
                            z = true;
                            break;
                        case -33:
                            h.a((Context) this, R.l.dLL, R.l.bNC, null);
                            z = true;
                            break;
                        case -32:
                            h.a((Context) this, R.l.dLM, R.l.bNC, null);
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                z = true;
                if (!z) {
                    Toast.makeText(this, getString(R.l.dLK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((t) kVar).IY() != 2 && ((t) kVar).IY() != 19) {
            } else {
                if (this.fromScene == 5) {
                    x.i("MicroMsg.BindMContactVerifyUI", "onScene end, finish wizard from app brand reg phone");
                    En(-1);
                } else if (this.yci) {
                    if (!q.Gg()) {
                        b scVar = new sc();
                        scVar.fKF.fKG = true;
                        scVar.fKF.fKH = true;
                        a.xmy.m(scVar);
                    }
                    En(1);
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.c.a.ihN.e((Context) this, intent);
                } else if (this.yck) {
                    En(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else {
                    int i3;
                    z = (this.status & WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
                    as.Hm();
                    c.Db().set(7, Integer.valueOf(this.status));
                    com.tencent.mm.bp.a wuVar = new wu();
                    wuVar.wnP = 8;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    wuVar.wnQ = i3;
                    as.Hm();
                    c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wuVar));
                    com.tencent.mm.plugin.c.a.ihO.un();
                    if (!this.yun) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.Ns();
                    }
                    if (this.yuz) {
                        h.bu(this, getString(R.l.dKU));
                    }
                    if (this.ksj) {
                        if (this.yun) {
                            g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                        } else {
                            g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                        }
                    }
                    MMWizardActivity.A(this, new Intent(this, BindMContactStatusUI.class));
                }
            }
        }
    }
}
