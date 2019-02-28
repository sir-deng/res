package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.br;
import com.tencent.mm.y.q;
import com.tencent.wcdb.database.SQLiteDatabase;

public class LoginUI extends MMActivity implements e {
    private TextWatcher XD = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            LoginUI.a(LoginUI.this);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String fJB = "";
    private String fsK = null;
    private ProgressDialog inI = null;
    private g jRi;
    private String pXJ;
    private String pXN;
    private String qmX;
    private int sceneType = 0;
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
            x.i("MicroMsg.LoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", izVar.fAw.content, izVar.fAw.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.fAw.content);
            intent.putExtra("key_disaster_url", izVar.fAw.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
            return true;
        }
    };
    protected Button xXb;
    protected Button xXc;
    private View xXd;
    protected Button xXe;
    private f xXf = new f();
    private String xXh;
    private String xXi;
    private ResizeLayout xXm;
    private a xXp;
    private MMClearEditText xYe;
    private MMClearEditText xYf;
    private MMFormInputView xYg;
    private MMFormInputView xYh;
    private Button xYi;
    private Button xYj;
    protected View xYk;
    private boolean xYl;
    private MMKeyboardUperView xYm;
    private boolean xYn = false;

    static /* synthetic */ void a(LoginUI loginUI) {
        if (bi.oN(loginUI.xYe.getText().toString()) || bi.oN(loginUI.xYf.getText().toString())) {
            loginUI.xYi.setEnabled(false);
        } else {
            loginUI.xYi.setEnabled(true);
        }
    }

    static /* synthetic */ void m(LoginUI loginUI) {
        com.tencent.mm.kernel.g.Dr().fO("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        com.tencent.mm.plugin.c.a.ihN.s(intent, loginUI);
    }

    protected final int getLayoutId() {
        return R.i.dmR;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = "";
        if (d.vHo) {
            str = getString(R.l.app_name) + getString(R.l.dDO);
        }
        this.sceneType = getIntent().getIntExtra("login_type", 0);
        setMMTitle(str);
        com.tencent.mm.plugin.c.a.ihO.uq();
        this.pXN = com.tencent.mm.plugin.c.b.Xw();
        initView();
        this.xXp = new a();
        this.xYl = getIntent().getBooleanExtra("from_switch_account", false);
        this.qmX = ar.hhz.H("login_weixin_username", "");
        if (getIntent().getIntArrayExtra("kv_report_login_method_data") != null) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14262, Integer.valueOf(r0[0]), Integer.valueOf(r0[1]), Integer.valueOf(r0[2]), Integer.valueOf(r0[3]), Integer.valueOf(r0[4]));
        }
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xmy.b(this.xWw);
        super.onResume();
        if (this.sceneType == 0) {
            com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",L100_100_logout," + as.fJ("L100_100_logout") + ",1");
            com.tencent.mm.plugin.c.b.oY("L100_100_logout");
        } else if (this.sceneType == 1) {
            com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",L400_100_login," + as.fJ("L400_100_login") + ",1");
            com.tencent.mm.plugin.c.b.oY("L400_100_login");
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xmy.c(this.xWw);
        if (this.sceneType == 0) {
            com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",L100_100_logout," + as.fJ("L100_100_logout") + ",2");
        } else if (this.sceneType == 1) {
            com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",L400_100_login," + as.fJ("L400_100_login") + ",2");
        }
    }

    public void onDestroy() {
        if (this.xXp != null) {
            this.xXp.close();
        }
        as.CN().b(701, (e) this);
        super.onDestroy();
    }

    protected final void initView() {
        this.xYg = (MMFormInputView) findViewById(R.h.cum);
        this.xYh = (MMFormInputView) findViewById(R.h.cuv);
        this.xYe = (MMClearEditText) this.xYg.pwv;
        this.xYe.setFocusableInTouchMode(false);
        this.xYe.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                LoginUI.this.xYe.setFocusableInTouchMode(true);
                return LoginUI.this.xYe.swC.onTouch(view, motionEvent);
            }
        });
        this.xYf = (MMClearEditText) this.xYh.pwv;
        this.xYf.setFocusableInTouchMode(false);
        this.xYf.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                LoginUI.this.xYf.setFocusableInTouchMode(true);
                LoginUI.this.xYe.setFocusableInTouchMode(false);
                return LoginUI.this.xYf.swC.onTouch(view, motionEvent);
            }
        });
        com.tencent.mm.ui.tools.a.c.d(this.xYf).Hg(16).a(null);
        this.xYi = (Button) findViewById(R.h.cuo);
        this.xYi.setEnabled(false);
        this.xYj = (Button) findViewById(R.h.cup);
        this.xYk = findViewById(R.h.cun);
        this.xYk.setVisibility(0);
        this.xXb = (Button) findViewById(R.h.cus);
        this.xXd = findViewById(R.h.cjh);
        this.xXc = (Button) findViewById(R.h.cut);
        this.xXe = (Button) findViewById(R.h.cuu);
        this.xXm = (ResizeLayout) findViewById(R.h.cHS);
        this.xYm = (MMKeyboardUperView) findViewById(R.h.scrollView);
        this.xXm.yaY = new ResizeLayout.a() {
            public final void coG() {
                LoginUI.this.xYm.post(new Runnable() {
                    public final void run() {
                        LoginUI.this.xYm.fullScroll(130);
                    }
                });
            }
        };
        this.xYm.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                LoginUI.this.aWY();
                return false;
            }
        });
        boolean PW = com.tencent.mm.aq.b.PW();
        View findViewById = findViewById(R.h.chz);
        findViewById.setVisibility(!PW ? 8 : 0);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LoginUI.this.startActivity(new Intent(LoginUI.this, FacebookLoginUI.class));
            }
        });
        this.xXb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LoginUI.bp(LoginUI.this, LoginUI.this.getString(R.l.etK) + w.cfV());
            }
        });
        this.xXc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LoginUI.bp(LoginUI.this, LoginUI.this.getString(R.l.ekr, new Object[]{w.cfV()}));
            }
        });
        this.jRi = new g(this, g.zCt, false);
        this.jRi.rQF = new p.c() {
            public final void a(n nVar) {
                if (nVar.cqg()) {
                    nVar.eT(5001, R.l.eXR);
                    nVar.eT(5002, R.l.eXO);
                }
            }
        };
        this.jRi.zCF = new g.a() {
            public final void onDismiss() {
                LoginUI.this.jRi.bxR();
            }
        };
        this.jRi.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 5001:
                        LoginUI.bp(LoginUI.this, LoginUI.this.getString(R.l.eXS) + w.cfV());
                        return;
                    case 5002:
                        LoginUI.bp(LoginUI.this, LoginUI.this.getString(R.l.eXP) + w.cfV());
                        return;
                    default:
                        return;
                }
            }
        };
        if (w.cfS()) {
            this.xXe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LoginUI.bp(LoginUI.this, LoginUI.this.getString(R.l.eXS) + w.cfV());
                }
            });
        } else {
            this.xXd.setVisibility(8);
            this.xXe.setText(R.l.etE);
            this.xXe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LoginUI.this.jRi.bUX();
                }
            });
        }
        setMMTitle("");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.btq));
        getSupportActionBar().getCustomView().findViewById(R.h.divider).setVisibility(8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LoginUI.this.goBack();
                return true;
            }
        }, R.k.dvg);
        this.xYi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LoginUI.this.afV();
            }
        });
        this.xYj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(LoginUI.this, MobileInputUI.class);
                int[] iArr = new int[5];
                iArr[0] = 2;
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("kv_report_login_method_data", iArr);
                intent.putExtra("from_switch_account", LoginUI.this.xYl);
                LoginUI.this.startActivity(intent);
                LoginUI.this.finish();
            }
        });
        this.pXJ = getIntent().getStringExtra("auth_ticket");
        if (!bi.oN(this.pXJ)) {
            this.xYe.setText(bi.oM(f.coH()));
            this.xYf.setText(bi.oM(f.coI()));
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    LoginUI.this.afV();
                }
            }, 500);
        }
        this.xYe.addTextChangedListener(this.XD);
        this.xYf.addTextChangedListener(this.XD);
        this.xYf.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                LoginUI.this.afV();
                return true;
            }
        });
        this.xYf.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                LoginUI.this.afV();
                return true;
            }
        });
        if (f.xmV) {
            com.tencent.mm.plugin.c.a.ihO.e(this);
        }
        CharSequence stringExtra = getIntent().getStringExtra("login_username");
        this.xYn = getIntent().getBooleanExtra("from_deep_link", false);
        if (!bi.oN(stringExtra)) {
            this.xYe.setText(stringExtra);
        }
    }

    private static void bp(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
        com.tencent.mm.bl.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        aWY();
        com.tencent.mm.plugin.c.b.oZ(this.pXN);
        com.tencent.mm.pluginsdk.model.app.p.bZz();
        finish();
    }

    private boolean o(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.ihO.a(this.mController.xRr, i, i2, str)) {
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    as.CN().a(701, (e) this);
                    if (this.xSF == null) {
                        this.xSF = SecurityImage.a.a(this, R.l.eEv, this.xXf.xXY, this.xXf.xXX, this.xXf.xXV, this.xXf.xXW, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (LoginUI.this.xSF == null) {
                                    x.e("MicroMsg.LoginUI", "secimg is null!");
                                    return;
                                }
                                x.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.this.xXf.xXV + " img len" + LoginUI.this.xXf.xXX.length + " " + com.tencent.mm.compatible.util.g.zo());
                                final k vVar = new v(LoginUI.this.xXf.hPj, LoginUI.this.xXf.xXT, LoginUI.this.xXf.xXY, LoginUI.this.xSF.cpt(), LoginUI.this.xSF.xXV, LoginUI.this.xSF.xXW, 2, "", false, false);
                                as.CN().a(vVar, 0);
                                LoginUI loginUI = LoginUI.this;
                                Context context = LoginUI.this;
                                LoginUI.this.getString(R.l.dGZ);
                                loginUI.inI = h.a(context, LoginUI.this.getString(R.l.etS), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        as.CN().c(vVar);
                                        as.CN().b(701, LoginUI.this);
                                    }
                                });
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                LoginUI.this.xSF = null;
                            }
                        }, this.xXf);
                    } else {
                        x.d("MicroMsg.LoginUI", "imgSid:" + this.xXf.xXV + " img len" + this.xXf.xXX.length + " " + com.tencent.mm.compatible.util.g.zo());
                        this.xSF.a(this.xXf.xXY, this.xXf.xXX, this.xXf.xXV, this.xXf.xXW);
                    }
                    return true;
                case -205:
                    x.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bi.Wz(this.pXJ), this.xXi);
                    f.a(this.xXf);
                    com.tencent.mm.plugin.c.b.oZ("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.pXJ);
                    intent.putExtra("binded_mobile", this.xXh);
                    intent.putExtra("close_safe_device_style", this.xXi);
                    intent.putExtra("from_source", 1);
                    com.tencent.mm.plugin.c.a.ihN.g((Context) this, intent);
                    return true;
                case -140:
                    if (!bi.oN(this.fJB)) {
                        m.j(this, str, this.fJB);
                    }
                    return true;
                case -100:
                    as.hold();
                    h.a(this.mController.xRr, TextUtils.isEmpty(as.Cp()) ? com.tencent.mm.bu.a.ac(this.mController.xRr, R.l.euH) : as.Cp(), this.mController.xRr.getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LoginUI.m(LoginUI.this);
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            LoginUI.m(LoginUI.this);
                        }
                    });
                    return true;
                case -75:
                    m.bE(this.mController.xRr);
                    return true;
                case -72:
                    h.h(this.mController.xRr, R.l.eEo, R.l.dGZ);
                    return true;
                case -9:
                    h.h(this, R.l.etI, R.l.etJ);
                    return true;
                case -4:
                case -3:
                    h.h(this, R.l.ecw, R.l.etJ);
                    return true;
                case -1:
                    if (as.CN().Ks() != 5) {
                        return false;
                    }
                    h.h(this, R.l.exT, R.l.exS);
                    return true;
            }
        }
        return this.xXp.a(this, new o(i, i2, str));
    }

    public final void a(int i, int i2, String str, final k kVar) {
        x.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (kVar.getType() == 701) {
            boolean z;
            as.CN().b(701, (e) this);
            this.fJB = ((v) kVar).Sf();
            this.xXf.xXV = ((v) kVar).Ov();
            this.xXf.xXX = ((v) kVar).Ou();
            this.xXf.xXW = ((v) kVar).Sh();
            this.xXf.xXY = ((v) kVar).Sg();
            this.xXf.hPj = ((v) kVar).hPj;
            if (i2 == -205) {
                this.pXJ = ((v) kVar).Od();
                this.xXh = ((v) kVar).Si();
                this.xXi = ((v) kVar).Sl();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                as.CN().a(new be(new be.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            com.tencent.mm.network.c KD = eVar.KD();
                            byte[] bArr = new byte[0];
                            as.Hm();
                            KD.v(bArr, com.tencent.mm.y.c.Cn());
                        }
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                as.unhold();
                m.oJ(this.xXf.hPj);
                String H = ar.hhz.H("login_weixin_username", "");
                com.tencent.mm.modelsimple.d.bq(this);
                if (this.xYl) {
                    br.hju.V(this.qmX, H);
                    br.hju.c(q.FY(), q.GH());
                    com.tencent.mm.plugin.report.service.g.pWK.h(14978, Integer.valueOf(1), Integer.valueOf(9));
                }
                m.a(this, new Runnable() {
                    public final void run() {
                        x.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
                        Intent at = com.tencent.mm.plugin.c.a.ihN.at(LoginUI.this);
                        at.addFlags(67108864);
                        at.putExtra("kstyle_show_bind_mobile_afterauth", ((v) kVar).Sj());
                        at.putExtra("kstyle_bind_wording", ((v) kVar).Sk());
                        at.putExtra("kstyle_bind_recommend_show", ((v) kVar).Sm());
                        LoginUI.this.startActivity(at);
                        LoginUI.this.finish();
                    }
                }, false, 2);
                com.tencent.mm.plugin.c.b.pa(as.CI() + "," + getClass().getName() + ",R200_900_phone," + as.fJ("R200_900_phone") + ",4");
                if (this.xYn) {
                    H = ad.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                    com.tencent.mm.plugin.report.service.g.pWK.h(11930, H, Integer.valueOf(4));
                }
            } else if (i2 == -106) {
                m.c(this, str, 32644);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else if (i2 == -30) {
                if (!d.vHo || d.vHq) {
                    com.tencent.mm.plugin.c.b.pa(as.CI() + "," + getClass().getName() + ",R400_100_login," + as.fJ("R400_100_login") + ",1");
                    h.a((Context) this, getString(R.l.etV), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.c.b.oZ("R400_100_login");
                            Intent intent = new Intent();
                            intent.putExtra("regsetinfo_binduin", LoginUI.this.xXf.hPj);
                            intent.putExtra("regsetinfo_pwd", LoginUI.this.xXf.xXT);
                            intent.putExtra("regsetinfo_ismobile", 0);
                            intent.putExtra("regsetinfo_ticket", LoginUI.this.fsK);
                            intent.putExtra("regsetinfo_NextControl", ((v) kVar).Oi());
                            intent.setClass(LoginUI.this, RegSetInfoUI.class);
                            LoginUI.this.mController.xRr.startActivity(intent);
                            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + LoginUI.this.getClass().getName() + ",R400_100_login," + as.fJ("R400_100_login") + ",2");
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.c.b.pa(as.CI() + "," + LoginUI.this.getClass().getName() + ",R400_100_login," + as.fJ("R400_100_login") + ",2");
                        }
                    });
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.fJB);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                com.tencent.mm.plugin.c.a.ihN.j(intent, this);
            } else if (!o(i, i2, str)) {
                if (i2 == -5) {
                    Toast.makeText(this, getString(R.l.etT), 0).show();
                    return;
                }
                if (kVar.getType() == 701) {
                    com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                    if (eC != null && eC.a(this, null, null)) {
                        return;
                    }
                }
                Toast.makeText(this, getString(R.l.eiB, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
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
            as.CN().a(701, (e) this);
            final k vVar = new v(this.xXf.hPj, this.xXf.xXT, this.pXJ, 2);
            as.CN().a(vVar, 0);
            getString(R.l.dGZ);
            this.inI = h.a((Context) this, getString(R.l.etS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(vVar);
                    as.CN().b(701, LoginUI.this);
                }
            });
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bpQ);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i2 != -1) {
            return;
        }
        if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginUI";
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
                this.xXf.xXT = stringExtra;
                afV();
            }
        } else if (i == 32644) {
            if (intent != null && intent.hasExtra("VoiceLoginAuthPwd")) {
                this.xXf.xXT = intent.getStringExtra("VoiceLoginAuthPwd");
            }
            afV();
        }
    }
}
