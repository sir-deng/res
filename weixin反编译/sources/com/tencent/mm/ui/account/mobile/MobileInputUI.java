package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.ui.account.MMKeyboardUperView;
import com.tencent.mm.ui.account.ResizeLayout;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import com.tencent.wcdb.database.SQLiteDatabase;

public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected String hGi = null;
    protected int hhQ;
    private g jRi;
    protected EditText lYV;
    protected int[] ofG = new int[5];
    protected String pXN;
    protected String pny = null;
    protected TextView sej;
    private c xWw = new c<iz>() {
        {
            this.xmG = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.fAw == null) {
                return false;
            }
            x.i("MicroMsg.MobileInputUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", izVar.fAw.content, izVar.fAw.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.fAw.content);
            intent.putExtra("key_disaster_url", izVar.fAw.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
            return true;
        }
    };
    protected r xXM;
    protected Button xXb;
    protected Button xXc;
    private View xXd;
    protected Button xXe;
    private ResizeLayout xXm;
    protected CheckBox xYB;
    protected LinearLayout xYI;
    protected TextView xYJ;
    protected String xYM = null;
    protected boolean xYN = true;
    protected TextView xYR;
    protected Button xYS;
    protected Button xYT;
    protected MMFormInputView xYh;
    protected boolean xYl;
    private MMKeyboardUperView xYm;
    protected boolean xYn = false;
    protected MMFormInputView ycD;
    protected EditText ycE;
    protected MMFormVerifyCodeInputView ycF;
    protected View ycG;
    protected TextView ycH;
    protected TextView ycI;
    protected Button ycJ;
    protected String ycK = null;
    private int ycL = 0;
    private b ycM;
    protected boolean ycN;

    protected enum a {
        ;

        public static int[] cpn() {
            return (int[]) ycS.clone();
        }

        static {
            ycQ = 1;
            ycR = 2;
            ycS = new int[]{ycQ, ycR};
        }
    }

    public interface b {
        void EB(int i);

        void a(MobileInputUI mobileInputUI);

        void start();

        void stop();
    }

    static /* synthetic */ boolean a(MobileInputUI mobileInputUI, String str) {
        return str != null && str.length() > 0 && mobileInputUI.xYN && (!mobileInputUI.cpl() || mobileInputUI.xYB.isChecked());
    }

    static /* synthetic */ boolean f(MobileInputUI mobileInputUI) {
        if (mobileInputUI.ycL != -1) {
            if (mobileInputUI.cpl() && !mobileInputUI.xYB.isChecked()) {
                return false;
            }
            mobileInputUI.cpm();
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dos;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ycL = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.hhQ = getIntent().getIntExtra("mobile_auth_type", 0);
        this.ycN = getIntent().getBooleanExtra("can_finish", false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MobileInputUI.this.goBack();
                return true;
            }
        }, R.k.dvZ);
        switch (this.ycL) {
            case -1:
                this.ycM = new e();
                break;
            case 1:
                if (!bi.oN(getIntent().getStringExtra("auth_ticket"))) {
                    this.ycM = new e();
                    break;
                }
                int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                if (intArrayExtra != null) {
                    this.ofG = intArrayExtra;
                }
                this.ycM = new c();
                setBackBtn(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        MobileInputUI.this.goBack();
                        return true;
                    }
                }, R.k.dvg);
                overridePendingTransition(R.a.bpQ, R.a.bpQ);
                break;
            case 2:
                this.ycM = new d();
                break;
            case 3:
                this.ycM = new b();
                break;
            case 4:
                this.ycM = new d();
                break;
            default:
                x.e("MicroMsg.MobileInputUI", "wrong purpose %s", Integer.valueOf(this.ycL));
                finish();
                return;
        }
        this.countryCode = ap.VR(bi.aD(getIntent().getStringExtra("input_country_code"), ""));
        this.hGi = bi.aD(getIntent().getStringExtra("country_name"), "");
        this.xYM = bi.aD(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.ycK = ap.VS(this.countryCode);
        this.pny = bi.aD(getIntent().getStringExtra("input_mobile_number"), "");
        this.pXN = com.tencent.mm.plugin.c.b.Xw();
        initView();
        this.xYn = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(!this.xYn || bi.oN(this.ycK) || bi.oN(this.pny))) {
            this.ycD.setText(this.pny);
        }
        this.ycM.a(this);
        this.xYl = getIntent().getBooleanExtra("from_switch_account", false);
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xmy.b(this.xWw);
        super.onResume();
        this.ycM.start();
        showVKB();
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xmy.c(this.xWw);
        this.ycM.stop();
    }

    public void finish() {
        super.finish();
        if (this.ycL == 1) {
            overridePendingTransition(R.a.bpQ, R.a.bpQ);
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(14262, Integer.valueOf(this.ofG[0]), Integer.valueOf(this.ofG[1]), Integer.valueOf(this.ofG[2]), Integer.valueOf(this.ofG[3]), Integer.valueOf(this.ofG[4]));
    }

    public void onDestroy() {
        this.ycF.reset();
        super.onDestroy();
    }

    private boolean cpl() {
        return this.ycL == 2;
    }

    protected final void initView() {
        this.xYh = (MMFormInputView) findViewById(R.h.cLT);
        this.lYV = this.xYh.pwv;
        com.tencent.mm.ui.tools.a.c.d(this.lYV).Hg(16).a(null);
        this.ycD = (MMFormInputView) findViewById(R.h.cwO);
        this.ycD.setInputType(3);
        this.ycE = this.ycD.pwv;
        this.ycF = (MMFormVerifyCodeInputView) findViewById(R.h.cOX);
        this.ycF.cpO();
        this.xYI = (LinearLayout) findViewById(R.h.bZf);
        this.xYJ = (TextView) findViewById(R.h.bZh);
        this.ycG = findViewById(R.h.cHo);
        this.xYB = (CheckBox) findViewById(R.h.bJE);
        this.xYR = (TextView) findViewById(R.h.bJF);
        this.xYS = (Button) findViewById(R.h.bJD);
        this.xYT = (Button) findViewById(R.h.cAl);
        this.ycH = (TextView) findViewById(R.h.cHE);
        this.ycI = (TextView) findViewById(R.h.cuz);
        this.sej = (TextView) findViewById(R.h.cwN);
        this.ycJ = (Button) findViewById(R.h.cup);
        this.xXb = (Button) findViewById(R.h.cus);
        this.xXc = (Button) findViewById(R.h.cut);
        this.xXd = findViewById(R.h.cjh);
        this.xXe = (Button) findViewById(R.h.cuu);
        this.xXm = (ResizeLayout) findViewById(R.h.cHS);
        this.xYm = (MMKeyboardUperView) findViewById(R.h.scrollView);
        this.xYI.setVisibility(8);
        this.xYh.setVisibility(8);
        this.ycF.setVisibility(8);
        this.ycD.setVisibility(8);
        this.ycH.setVisibility(8);
        this.ycI.setVisibility(8);
        this.xYT.setVisibility(8);
        this.ycG.setVisibility(8);
        this.ycJ.setVisibility(8);
        this.xYB.setVisibility(8);
        this.xYB.setChecked(true);
        this.xXm.yaY = new com.tencent.mm.ui.account.ResizeLayout.a() {
            public final void coG() {
                MobileInputUI.this.xYm.post(new Runnable() {
                    public final void run() {
                        MobileInputUI.this.xYm.fullScroll(130);
                    }
                });
            }
        };
        this.xYm.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MobileInputUI.this.aWY();
                return false;
            }
        });
        this.xXb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MobileInputUI.bp(MobileInputUI.this, MobileInputUI.this.getString(R.l.etK) + w.cfV());
            }
        });
        this.xXc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MobileInputUI.bp(MobileInputUI.this, MobileInputUI.this.getString(R.l.ekr, new Object[]{w.cfV()}));
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
        this.jRi.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 5001:
                        MobileInputUI.bp(MobileInputUI.this, MobileInputUI.this.getString(R.l.eXS) + w.cfV());
                        return;
                    case 5002:
                        MobileInputUI.bp(MobileInputUI.this, MobileInputUI.this.getString(R.l.eXP) + w.cfV());
                        return;
                    default:
                        return;
                }
            }
        };
        this.jRi.zCF = new com.tencent.mm.ui.widget.g.a() {
            public final void onDismiss() {
                MobileInputUI.this.jRi.bxR();
            }
        };
        if (w.cfS()) {
            this.xXe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    MobileInputUI.bp(MobileInputUI.this, MobileInputUI.this.getString(R.l.eXS) + w.cfV());
                }
            });
        } else {
            this.xXd.setVisibility(8);
            this.xXe.setText(R.l.etE);
            this.xXe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    MobileInputUI.this.jRi.bUX();
                }
            });
        }
        this.ycE.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                if (MobileInputUI.a(MobileInputUI.this, MobileInputUI.this.ycD.getText().toString())) {
                    MobileInputUI.this.xYT.setEnabled(true);
                } else {
                    MobileInputUI.this.xYT.setEnabled(false);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.ycE.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 5) {
                    return MobileInputUI.f(MobileInputUI.this);
                }
                return false;
            }
        });
        this.ycE.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 == i && keyEvent.getAction() == 0) {
                    return MobileInputUI.f(MobileInputUI.this);
                }
                return false;
            }
        });
        this.xYT.setEnabled(false);
        this.xYT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MobileInputUI.this.cpm();
            }
        });
        if (bi.oN(this.hGi) || bi.oN(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bi.oN(simCountryIso)) {
                x.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.aq.b.a h = com.tencent.mm.aq.b.h(this, simCountryIso, getString(R.l.bZd));
                if (h == null) {
                    x.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                } else {
                    this.countryCode = ap.VR(h.hGh);
                    this.hGi = h.hGi;
                }
            }
        }
        if (bi.oN(this.hGi) || bi.oN(this.countryCode)) {
            this.hGi = getString(R.l.dXV);
            this.countryCode = ap.VR(getString(R.l.dXU));
        }
        coN();
        if (bi.oN(this.xYM)) {
            this.ycE.setText(this.xYM);
        }
        this.xYI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", MobileInputUI.this.hGi);
                intent.putExtra("couttry_code", MobileInputUI.this.countryCode);
                com.tencent.mm.plugin.c.a.ihN.b(intent, MobileInputUI.this);
            }
        });
        setMMTitle("");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.btq));
        getSupportActionBar().getCustomView().findViewById(R.h.divider).setVisibility(8);
    }

    private void cpm() {
        aWY();
        this.ycM.EB(a.ycR);
    }

    private void goBack() {
        if (this.ycN) {
            aWY();
            Intent at = com.tencent.mm.plugin.c.a.ihN.at(this);
            at.addFlags(67108864);
            at.putExtra("can_finish", true);
            startActivity(at);
            finish();
            com.tencent.mm.ui.base.b.fH(this);
            return;
        }
        this.ycM.EB(a.ycQ);
        com.tencent.mm.plugin.c.b.oZ(this.pXN);
        aWY();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void coN() {
        if (bi.oN(this.hGi) || bi.oN(this.countryCode)) {
            this.xYJ.setText(getString(R.l.evu));
        } else {
            this.xYJ.setText(ap.fx(this.hGi, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32047) {
            if (i2 == -1) {
                if (this.ycM instanceof d) {
                    ((d) this.ycM).ycx = 0;
                } else if (this.ycM instanceof e) {
                    ((e) this.ycM).ycx = 0;
                }
                this.ycM.EB(a.ycR);
            } else if (this.ycM instanceof d) {
                ((d) this.ycM).ycx = 1;
            } else if (this.ycM instanceof e) {
                ((e) this.ycM).ycx = 1;
            }
        } else if (i == 32046) {
            if (i2 == -1) {
                if (this.ycM instanceof d) {
                    ((d) this.ycM).ycx = 2;
                }
                if (this.ycM instanceof e) {
                    ((e) this.ycM).ycx = 2;
                }
                this.ycM.EB(a.ycR);
            }
        } else if (i != 32045) {
            switch (i2) {
                case -1:
                    if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                        String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                        int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                        String str = "MicroMsg.MobileInputUI";
                        String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(bi.oN(stringExtra));
                        objArr[1] = Integer.valueOf(bi.oN(stringExtra) ? 0 : stringExtra.length());
                        objArr[2] = Integer.valueOf(intExtra);
                        x.d(str, str2, objArr);
                        if (intExtra == -217) {
                            cpm();
                            return;
                        }
                        return;
                    }
                    return;
                case 100:
                    this.hGi = bi.aD(intent.getStringExtra("country_name"), "");
                    this.countryCode = bi.aD(intent.getStringExtra("couttry_code"), "");
                    coN();
                    return;
                default:
                    return;
            }
        } else if (i2 == -1 && (this.ycM instanceof e)) {
            if (intent.hasExtra("VoiceLoginAuthPwd")) {
                ((e) this.ycM).mHK = intent.getStringExtra("VoiceLoginAuthPwd");
            }
            this.ycM.EB(a.ycR);
        }
    }

    public void setRequestedOrientation(int i) {
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
}
