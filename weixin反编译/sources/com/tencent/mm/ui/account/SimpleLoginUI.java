package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;

public class SimpleLoginUI extends MMWizardActivity implements e {
    private TextWatcher XD = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            SimpleLoginUI.a(SimpleLoginUI.this);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String fJB = "";
    private ProgressDialog inI = null;
    private String pXJ;
    private SecurityImage xSF = null;
    private c xWw = new c<iz>() {
        {
            this.xmG = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.fAw == null) {
                return false;
            }
            x.i("MicroMsg.SimpleLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", izVar.fAw.content, izVar.fAw.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.fAw.content);
            intent.putExtra("key_disaster_url", izVar.fAw.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
            return true;
        }
    };
    private f xXf = new f();
    private String xXh;
    private String xXi;
    private ResizeLayout xXm;
    private MMClearEditText xYe;
    private MMClearEditText xYf;
    private MMFormInputView xYg;
    private MMFormInputView xYh;
    private Button xYi;
    private MMKeyboardUperView xYm;

    static /* synthetic */ void a(SimpleLoginUI simpleLoginUI) {
        if (bi.oN(simpleLoginUI.xYe.getText().toString()) || bi.oN(simpleLoginUI.xYf.getText().toString())) {
            simpleLoginUI.xYi.setEnabled(false);
        } else {
            simpleLoginUI.xYi.setEnabled(true);
        }
    }

    protected final int getLayoutId() {
        return R.i.dmR;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", 4);
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        setMMTitle(R.l.app_name);
        if (a.ihO != null) {
            a.ihO.uq();
        }
        initView();
        as.CN().a(701, (e) this);
        x.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.WRITE_EXTERNAL_STORAGE")));
        if (com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            x.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.READ_PHONE_STATE")));
            if (com.tencent.mm.pluginsdk.g.a.f(this, "android.permission.READ_PHONE_STATE")) {
                z = true;
            }
        }
        if (!z) {
            new Intent().addFlags(67108864);
            a.ihN.s(new Intent(), this);
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xmy.b(this.xWw);
        super.onResume();
    }

    public void onDestroy() {
        as.CN().b(701, (e) this);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.pXJ = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.pXJ = extras.getString("auth_ticket");
        }
        if (!bi.oN(this.pXJ)) {
            this.xYe.setText(bi.oM(f.coH()));
            this.xYf.setText(bi.oM(f.coI()));
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    SimpleLoginUI.this.afV();
                }
            }, 500);
        }
    }

    protected final void initView() {
        this.xYg = (MMFormInputView) findViewById(R.h.cum);
        this.xYh = (MMFormInputView) findViewById(R.h.cuv);
        this.xYe = (MMClearEditText) this.xYg.pwv;
        this.xYe.setFocusableInTouchMode(false);
        this.xYe.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SimpleLoginUI.this.xYe.setFocusableInTouchMode(true);
                return SimpleLoginUI.this.xYe.swC.onTouch(view, motionEvent);
            }
        });
        this.xYf = (MMClearEditText) this.xYh.pwv;
        this.xYf.setFocusableInTouchMode(false);
        this.xYf.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SimpleLoginUI.this.xYf.setFocusableInTouchMode(true);
                SimpleLoginUI.this.xYe.setFocusableInTouchMode(false);
                return SimpleLoginUI.this.xYf.swC.onTouch(view, motionEvent);
            }
        });
        com.tencent.mm.ui.tools.a.c.d(this.xYf).Hg(16).a(null);
        this.xYi = (Button) findViewById(R.h.cuo);
        this.xYi.setEnabled(false);
        this.xYe.addTextChangedListener(this.XD);
        this.xYf.addTextChangedListener(this.XD);
        this.xYf.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                SimpleLoginUI.this.afV();
                return true;
            }
        });
        this.xYf.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                SimpleLoginUI.this.afV();
                return true;
            }
        });
        this.xXm = (ResizeLayout) findViewById(R.h.cHS);
        this.xYm = (MMKeyboardUperView) findViewById(R.h.scrollView);
        this.xXm.yaY = new ResizeLayout.a() {
            public final void coG() {
                SimpleLoginUI.this.xYm.post(new Runnable() {
                    public final void run() {
                        SimpleLoginUI.this.xYm.fullScroll(130);
                    }
                });
            }
        };
        this.xYm.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SimpleLoginUI.this.aWY();
                return false;
            }
        });
        findViewById(R.h.cup).setVisibility(8);
        View findViewById = findViewById(R.h.chz);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        setMMTitle(R.l.cuz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SimpleLoginUI.this.bpd();
                return true;
            }
        });
        this.pXJ = getIntent().getStringExtra("auth_ticket");
        if (!bi.oN(this.pXJ)) {
            this.xYe.setText(bi.oM(f.coH()));
            this.xYf.setText(bi.oM(f.coI()));
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    SimpleLoginUI.this.afV();
                }
            }, 500);
        }
        if (f.xmV) {
            a.ihO.e(this);
        }
        this.xYi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SimpleLoginUI.this.afV();
            }
        });
    }

    private void bpd() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        En(1);
        if (booleanExtra) {
            exit(1);
        }
    }

    private void afV() {
        this.xXf.hPj = this.xYe.getText().toString().trim();
        this.xXf.xXT = this.xYf.getText().toString();
        if (this.xXf.hPj.equals("")) {
            h.h(this, R.l.eTf, R.l.etJ);
        } else if (this.xXf.xXT.equals("")) {
            h.h(this, R.l.eTc, R.l.etJ);
        } else {
            aWY();
            final k vVar = new v(this.xXf.hPj, this.xXf.xXT, this.pXJ, 0);
            as.CN().a(vVar, 0);
            getString(R.l.dGZ);
            this.inI = h.a((Context) this, getString(R.l.etS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(vVar);
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bpd();
        return true;
    }

    protected void onPause() {
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        super.onPause();
        com.tencent.mm.sdk.b.a.xmy.c(this.xWw);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.ad.k r14) {
        /*
        r10 = this;
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "onSceneEnd: errType = ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " errCode = ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " errMsg = ";
        r1 = r1.append(r2);
        r1 = r1.append(r13);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "Scene Type ";
        r1.<init>(r2);
        r2 = r14.getType();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r10.inI;
        if (r0 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r10.inI;
        r0.dismiss();
        r0 = 0;
        r10.inI = r0;
    L_0x0052:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sf();
        r10.fJB = r0;
        r1 = 0;
        r0 = r14.getType();
        r2 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r0 != r2) goto L_0x02e1;
    L_0x0064:
        r2 = r10.xXf;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sg();
        r2.xXY = r0;
        r2 = r10.xXf;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Ov();
        r2.xXV = r0;
        r2 = r10.xXf;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Ou();
        r2.xXX = r0;
        r2 = r10.xXf;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sh();
        r2.xXW = r0;
        r0 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        if (r12 != r0) goto L_0x00af;
    L_0x0094:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Od();
        r10.pXJ = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Si();
        r10.xXh = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sl();
        r10.xXi = r0;
    L_0x00af:
        r0 = 4;
        if (r11 != r0) goto L_0x02e1;
    L_0x00b2:
        r0 = -16;
        if (r12 == r0) goto L_0x00ba;
    L_0x00b6:
        r0 = -17;
        if (r12 != r0) goto L_0x02e1;
    L_0x00ba:
        r0 = 1;
        r1 = com.tencent.mm.y.as.CN();
        r2 = new com.tencent.mm.y.be;
        r3 = new com.tencent.mm.ui.account.SimpleLoginUI$10;
        r3.<init>();
        r2.<init>(r3);
        r3 = 0;
        r1.a(r2, r3);
    L_0x00cd:
        if (r0 != 0) goto L_0x00d3;
    L_0x00cf:
        if (r11 != 0) goto L_0x0153;
    L_0x00d1:
        if (r12 != 0) goto L_0x0153;
    L_0x00d3:
        com.tencent.mm.y.as.unhold();
        com.tencent.mm.modelsimple.d.bq(r10);
        r0 = r10.xXf;
        r0 = r0.hPj;
        com.tencent.mm.platformtools.m.oJ(r0);
        r0 = r10.mController;
        r0 = r0.xRr;
        r1 = new com.tencent.mm.ui.account.SimpleLoginUI$11;
        r1.<init>();
        r2 = new com.tencent.mm.plugin.accountsync.a.b;
        r2.<init>(r0, r1);
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r0 = r0.a(r2);
        r2.frW = r0;
        r0 = r2.frW;
        if (r0 != 0) goto L_0x0104;
    L_0x00fa:
        r0 = r2.imX;
        if (r0 == 0) goto L_0x0103;
    L_0x00fe:
        r0 = r2.imX;
        r0.Xx();
    L_0x0103:
        return;
    L_0x0104:
        r0 = r2.frW;
        r0 = r0.getType();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        if (r0 != r1) goto L_0x013f;
    L_0x010e:
        r0 = com.tencent.mm.y.as.CN();
        r1 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r0.a(r1, r2);
    L_0x0117:
        r0 = com.tencent.mm.y.as.CN();
        r1 = r2.frW;
        r3 = 0;
        r0.a(r1, r3);
        r0 = r2.context;
        r1 = r2.context;
        r3 = com.tencent.mm.R.l.dGZ;
        r1.getString(r3);
        r1 = r2.context;
        r3 = com.tencent.mm.R.l.dFJ;
        r1 = r1.getString(r3);
        r3 = 1;
        r4 = new com.tencent.mm.plugin.accountsync.a.b$1;
        r4.<init>();
        r0 = com.tencent.mm.ui.base.h.a(r0, r1, r3, r4);
        r2.tipDialog = r0;
        goto L_0x0103;
    L_0x013f:
        r0 = r2.frW;
        r0 = r0.getType();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        if (r0 != r1) goto L_0x0117;
    L_0x0149:
        r0 = com.tencent.mm.y.as.CN();
        r1 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r0.a(r1, r2);
        goto L_0x0117;
    L_0x0153:
        r0 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
        if (r12 != r0) goto L_0x0161;
    L_0x0157:
        r14 = (com.tencent.mm.modelsimple.v) r14;
        r0 = com.tencent.mm.pluginsdk.a.a.a(r14);
        com.tencent.mm.platformtools.m.a(r10, r0, r12);
        goto L_0x0103;
    L_0x0161:
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r1 = r10.mController;
        r1 = r1.xRr;
        r0 = r0.a(r1, r11, r12, r13);
        if (r0 == 0) goto L_0x019f;
    L_0x016d:
        r0 = 1;
    L_0x016e:
        if (r0 != 0) goto L_0x0103;
    L_0x0170:
        r0 = com.tencent.mm.g.a.eC(r13);
        if (r0 == 0) goto L_0x017e;
    L_0x0176:
        r1 = 0;
        r2 = 0;
        r0 = r0.a(r10, r1, r2);
        if (r0 != 0) goto L_0x0103;
    L_0x017e:
        r0 = com.tencent.mm.R.l.eiB;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r11);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r12);
        r1[r2] = r3;
        r0 = r10.getString(r0, r1);
        r1 = 0;
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
        goto L_0x0103;
    L_0x019f:
        r0 = 4;
        if (r11 != r0) goto L_0x01a5;
    L_0x01a2:
        switch(r12) {
            case -311: goto L_0x01e3;
            case -310: goto L_0x01e3;
            case -205: goto L_0x027f;
            case -140: goto L_0x02ca;
            case -106: goto L_0x02da;
            case -100: goto L_0x0262;
            case -75: goto L_0x01da;
            case -72: goto L_0x01cd;
            case -30: goto L_0x01bb;
            case -9: goto L_0x01c4;
            case -6: goto L_0x01e3;
            case -4: goto L_0x01bb;
            case -3: goto L_0x01bb;
            case -1: goto L_0x01a7;
            default: goto L_0x01a5;
        };
    L_0x01a5:
        r0 = 0;
        goto L_0x016e;
    L_0x01a7:
        r0 = com.tencent.mm.y.as.CN();
        r0 = r0.Ks();
        r1 = 5;
        if (r0 != r1) goto L_0x01bb;
    L_0x01b2:
        r0 = com.tencent.mm.R.l.exT;
        r1 = com.tencent.mm.R.l.exS;
        com.tencent.mm.ui.base.h.h(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01bb:
        r0 = com.tencent.mm.R.l.ecw;
        r1 = com.tencent.mm.R.l.etJ;
        com.tencent.mm.ui.base.h.h(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01c4:
        r0 = com.tencent.mm.R.l.etI;
        r1 = com.tencent.mm.R.l.etJ;
        com.tencent.mm.ui.base.h.h(r10, r0, r1);
        r0 = 1;
        goto L_0x016e;
    L_0x01cd:
        r0 = r10.mController;
        r0 = r0.xRr;
        r1 = com.tencent.mm.R.l.eEo;
        r2 = com.tencent.mm.R.l.dGZ;
        com.tencent.mm.ui.base.h.h(r0, r1, r2);
        r0 = 1;
        goto L_0x016e;
    L_0x01da:
        r0 = r10.mController;
        r0 = r0.xRr;
        com.tencent.mm.platformtools.m.bE(r0);
        r0 = 1;
        goto L_0x016e;
    L_0x01e3:
        r0 = r10.xSF;
        if (r0 != 0) goto L_0x0213;
    L_0x01e7:
        r0 = r10.mController;
        r0 = r0.xRr;
        r1 = com.tencent.mm.R.l.eEv;
        r2 = r10.xXf;
        r2 = r2.xXY;
        r3 = r10.xXf;
        r3 = r3.xXX;
        r4 = r10.xXf;
        r4 = r4.xXV;
        r5 = r10.xXf;
        r5 = r5.xXW;
        r6 = new com.tencent.mm.ui.account.SimpleLoginUI$6;
        r6.<init>();
        r7 = 0;
        r8 = new com.tencent.mm.ui.account.SimpleLoginUI$7;
        r8.<init>();
        r9 = r10.xXf;
        r0 = com.tencent.mm.ui.applet.SecurityImage.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r10.xSF = r0;
    L_0x0210:
        r0 = 1;
        goto L_0x016e;
    L_0x0213:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r10.xXf;
        r2 = r2.xXV;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r10.xXf;
        r2 = r2.xXX;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.zo();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r10.xSF;
        r1 = r10.xXf;
        r1 = r1.xXY;
        r2 = r10.xXf;
        r2 = r2.xXX;
        r3 = r10.xXf;
        r3 = r3.xXV;
        r4 = r10.xXf;
        r4 = r4.xXW;
        r0.a(r1, r2, r3, r4);
        goto L_0x0210;
    L_0x0262:
        com.tencent.mm.y.as.hold();
        r0 = com.tencent.mm.y.as.Cp();
        r1 = com.tencent.mm.R.l.dGZ;
        r1 = r10.getString(r1);
        r2 = new com.tencent.mm.ui.account.SimpleLoginUI$8;
        r2.<init>();
        r3 = new com.tencent.mm.ui.account.SimpleLoginUI$9;
        r3.<init>();
        com.tencent.mm.ui.base.h.a(r10, r0, r1, r2, r3);
        r0 = 1;
        goto L_0x016e;
    L_0x027f:
        r0 = "MicroMsg.SimpleLoginUI";
        r1 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.pXJ;
        r4 = com.tencent.mm.sdk.platformtools.bi.Wz(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r10.xXi;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r10.xXf;
        com.tencent.mm.ui.account.f.a(r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "auth_ticket";
        r2 = r10.pXJ;
        r0.putExtra(r1, r2);
        r1 = "binded_mobile";
        r2 = r10.xXh;
        r0.putExtra(r1, r2);
        r1 = "close_safe_device_style";
        r2 = r10.xXi;
        r0.putExtra(r1, r2);
        r1 = "from_source";
        r2 = 3;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.plugin.c.a.ihN;
        r1.g(r10, r0);
        r0 = 1;
        goto L_0x016e;
    L_0x02ca:
        r0 = r10.fJB;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x02d7;
    L_0x02d2:
        r0 = r10.fJB;
        com.tencent.mm.platformtools.m.j(r10, r13, r0);
    L_0x02d7:
        r0 = 1;
        goto L_0x016e;
    L_0x02da:
        r0 = 0;
        com.tencent.mm.platformtools.m.c(r10, r13, r0);
        r0 = 1;
        goto L_0x016e;
    L_0x02e1:
        r0 = r1;
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.SimpleLoginUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bi.oN(stringExtra));
            if (!bi.oN(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.d(str2, str3, objArr2);
            if (intExtra == -217) {
                afV();
            }
        }
    }
}
