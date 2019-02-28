package com.tencent.mm.ui.account.bind;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.hp;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.modelsimple.BindWordingContent;
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
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI extends MMWizardActivity implements e {
    private Timer bnp;
    private String fBa;
    private r tipDialog = null;
    private BindWordingContent ybL;
    private int ybM;
    private boolean ybN;
    private boolean ybO;
    private boolean ycb = false;
    private EditText yce;
    private TextView ycf;
    private TextView ycg;
    private Button ych;
    private boolean yci = false;
    private boolean ycj = false;
    private boolean yck = false;
    private Integer ycl = Integer.valueOf(15);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(132, (e) this);
        setMMTitle(R.l.dLy);
        this.ybL = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.ybM = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.ybN = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.ybO = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.ycb = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
    }

    public void onDestroy() {
        as.CN().b(132, (e) this);
        super.onDestroy();
    }

    protected void onStop() {
        cpi();
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.dbo;
    }

    protected final void initView() {
        as.Hm();
        this.fBa = (String) c.Db().get(4097, null);
        this.yce = (EditText) findViewById(R.h.bNB);
        this.ycf = (TextView) findViewById(R.h.bNA);
        this.ycg = (TextView) findViewById(R.h.bNv);
        this.yci = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ycj = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.yck = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        Button button = (Button) findViewById(R.h.bNy);
        if (this.fBa == null || this.fBa.equals("")) {
            as.Hm();
            this.fBa = (String) c.Db().get(6, null);
        }
        if (this.fBa != null && this.fBa.length() > 0) {
            this.ycf.setVisibility(0);
            this.ycf.setText(this.fBa);
        }
        this.yce.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return bi.O(charSequence);
            }
        }});
        this.ych = (Button) findViewById(R.h.bND);
        button.setVisibility(8);
        this.ycg.setText(getResources().getQuantityString(R.j.duN, this.ycl.intValue(), new Object[]{this.ycl}));
        if (this.bnp == null) {
            this.bnp = new Timer();
            TimerTask anonymousClass5 = new TimerTask() {
                public final void run() {
                    if (BindMobileVerifyUI.this.ycg != null) {
                        BindMobileVerifyUI.this.ycg.post(new Runnable() {
                            public final void run() {
                                BindMobileVerifyUI.this.ycl;
                                BindMobileVerifyUI.this.ycl = Integer.valueOf(BindMobileVerifyUI.this.ycl.intValue() - 1);
                                if (BindMobileVerifyUI.this.ycl.intValue() > 0) {
                                    BindMobileVerifyUI.this.ycg.setText(BindMobileVerifyUI.this.getResources().getQuantityString(R.j.duN, BindMobileVerifyUI.this.ycl.intValue(), new Object[]{BindMobileVerifyUI.this.ycl}));
                                    return;
                                }
                                BindMobileVerifyUI.this.ycg.setText(BindMobileVerifyUI.this.getResources().getQuantityString(R.j.duN, 0, new Object[]{Integer.valueOf(0)}));
                                BindMobileVerifyUI.this.cpi();
                            }
                        });
                    }
                }
            };
            if (this.bnp != null) {
                this.bnp.schedule(anonymousClass5, 1000, 1000);
            }
        }
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = BindMobileVerifyUI.this.yce.getText().toString().trim();
                if (trim.equals("")) {
                    h.h(BindMobileVerifyUI.this, R.l.dLR, R.l.dGZ);
                } else {
                    BindMobileVerifyUI.this.aWY();
                    b hpVar = new hp();
                    hpVar.fyM.context = BindMobileVerifyUI.this;
                    a.xmy.m(hpVar);
                    String str = hpVar.fyN.fyO;
                    hpVar = new hq();
                    a.xmy.m(hpVar);
                    final k tVar = new t(BindMobileVerifyUI.this.fBa, 2, trim, "", str, hpVar.fyP.fyQ);
                    as.CN().a(tVar, 0);
                    BindMobileVerifyUI bindMobileVerifyUI = BindMobileVerifyUI.this;
                    Context context = BindMobileVerifyUI.this;
                    BindMobileVerifyUI.this.getString(R.l.dGZ);
                    bindMobileVerifyUI.tipDialog = h.a(context, BindMobileVerifyUI.this.getString(R.l.dLI), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(tVar);
                        }
                    });
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindMobileVerifyUI.this.finish();
                return true;
            }
        });
        this.ych.setVisibility(com.tencent.mm.aq.b.lJ(this.fBa) ? 0 : 8);
        this.ych.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMobileVerifyUI.this.aWY();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMobileVerifyUI.this.fBa);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.c.a.ihN.f(BindMobileVerifyUI.this, intent);
            }
        });
    }

    private void cpi() {
        if (this.bnp != null) {
            this.bnp.cancel();
            this.bnp = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        x.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((t) kVar).IY() == 2) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            boolean z2;
            if (i != 0 || i2 != 0) {
                if (!com.tencent.mm.plugin.c.a.ihO.a((Context) this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                            if (eC != null) {
                                eC.a(this, null, null);
                            }
                            z2 = true;
                            break;
                        case -43:
                            Toast.makeText(this, R.l.dLb, 0).show();
                            z2 = true;
                            break;
                        case -41:
                            Toast.makeText(this, R.l.dLd, 0).show();
                            z2 = true;
                            break;
                        case -36:
                            Toast.makeText(this, R.l.dLg, 0).show();
                            z2 = true;
                            break;
                        case -35:
                            Toast.makeText(this, R.l.dLc, 0).show();
                            z2 = true;
                            break;
                        case -34:
                            Toast.makeText(this, R.l.dLe, 0).show();
                            z2 = true;
                            break;
                        case -33:
                            h.a((Context) this, R.l.dLL, R.l.bNC, null);
                            z2 = true;
                            break;
                        case -32:
                            h.a((Context) this, R.l.dLM, R.l.bNC, null);
                            z2 = true;
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                }
                z2 = true;
                if (!z2) {
                    Toast.makeText(this, getString(R.l.dLK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((t) kVar).IY() != 2) {
            } else {
                Intent intent;
                if (this.yci) {
                    if (!q.Gg()) {
                        b scVar = new sc();
                        scVar.fKF.fKG = true;
                        scVar.fKF.fKH = true;
                        a.xmy.m(scVar);
                    }
                    En(1);
                    intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.c.a.ihN.e((Context) this, intent);
                } else if (this.yck) {
                    En(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else if (this.ycb) {
                    if (this.ybN) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (this.ybO) {
                        z = false;
                    }
                    BindMobileStatusUI.c(this, z2, z);
                    exit(-1);
                } else {
                    if (!this.ycj) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.Ns();
                    }
                    intent = new Intent(this, BindMobileStatusUI.class);
                    intent.putExtra("kstyle_bind_wording", this.ybL);
                    intent.putExtra("kstyle_bind_recommend_show", this.ybM);
                    intent.putExtra("Kfind_friend_by_mobile_flag", this.ybN);
                    intent.putExtra("Krecom_friends_by_mobile_flag", this.ybO);
                    MMWizardActivity.A(this, intent);
                }
            }
        }
    }
}
