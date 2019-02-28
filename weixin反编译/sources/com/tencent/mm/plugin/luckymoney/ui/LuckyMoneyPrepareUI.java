package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.pi;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private Dialog ion = null;
    private al jcp = null;
    private int kKY;
    private Button lMM = null;
    private TextView lrX = null;
    private TextView lsa;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private Button ofq = null;
    private c ohp;
    private LuckyMoneyNumInputView okU = null;
    private LuckyMoneyMoneyInputView okV = null;
    private LuckyMoneyTextInputView okW = null;
    protected View okX;
    private View okY;
    private View okZ;
    private ViewGroup ola;
    private TextView olb;
    private a olc = new a();
    private int old;
    private String ole;
    private int olf;
    private boolean olg;
    private String olh;
    private int oli;
    private String omj;
    private MMScrollView ooZ;
    private int opa = 1;
    private String opb = e.abi("CNY");
    private String opc = null;
    private RealnameGuideHelper opd;
    private String ope;
    private boolean opf = false;
    private com.tencent.mm.sdk.b.c<pi> opg = new com.tencent.mm.sdk.b.c<pi>() {
        {
            this.xmG = pi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final com.tencent.mm.plugin.wallet_core.model.a aVar = ((pi) bVar).fIa.fIb;
            if (aVar != null && aVar.bLz()) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
                LuckyMoneyPrepareUI.this.opf = true;
                h.a(LuckyMoneyPrepareUI.this.mController.xRr, aVar.fzT, "", aVar.ojc, aVar.ojb, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", aVar.loA);
                        e.l(LuckyMoneyPrepareUI.this.mController.xRr, aVar.loA, false);
                        LuckyMoneyPrepareUI.this.opf = false;
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LuckyMoneyPrepareUI.this.opf = false;
                    }
                });
            }
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$19 */
    class AnonymousClass19 implements OnFocusChangeListener {
        final /* synthetic */ boolean ile = false;
        final /* synthetic */ EditText ilg;
        final /* synthetic */ int ili;

        AnonymousClass19(boolean z, int i, EditText editText) {
            this.ili = i;
            this.ilg = editText;
        }

        public final void onFocusChange(final View view, boolean z) {
            if (!view.isFocused() || this.ile) {
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        LuckyMoneyPrepareUI.this.Xj();
                        ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(AnonymousClass19.this.ilg, 0);
                    }
                }, 200);
                return;
            }
            ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    if (!LuckyMoneyPrepareUI.this.okX.isShown() && view.isShown()) {
                        LuckyMoneyPrepareUI.this.okX.setVisibility(0);
                    }
                    LuckyMoneyPrepareUI.this.mKeyboard.setXMode(AnonymousClass19.this.ili);
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                    ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }, 300);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$21 */
    class AnonymousClass21 implements View.OnClickListener {
        final /* synthetic */ boolean ile = false;
        final /* synthetic */ EditText ilg;
        final /* synthetic */ View ilh;
        final /* synthetic */ int ili;

        AnonymousClass21(boolean z, EditText editText, View view, int i) {
            this.ilg = editText;
            this.ilh = view;
            this.ili = i;
        }

        public final void onClick(View view) {
            if (!LuckyMoneyPrepareUI.this.okX.isShown() || this.ile) {
                if (!LuckyMoneyPrepareUI.this.okX.isShown() && !this.ile) {
                    ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            LuckyMoneyPrepareUI.this.okX.setVisibility(0);
                            AnonymousClass21.this.ilh.requestFocus();
                            if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(AnonymousClass21.this.ilg);
                            }
                            LuckyMoneyPrepareUI.this.mKeyboard.setXMode(AnonymousClass21.this.ili);
                        }
                    }, 200);
                } else if (this.ile) {
                    LuckyMoneyPrepareUI.this.okX.setVisibility(8);
                    ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(this.ilg, 0);
                }
            } else if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.ilg);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$20 */
    class AnonymousClass20 implements View.OnClickListener {
        final /* synthetic */ boolean ile = false;
        final /* synthetic */ EditText ilg;
        final /* synthetic */ int ili;

        AnonymousClass20(boolean z, int i, EditText editText) {
            this.ili = i;
            this.ilg = editText;
        }

        public final void onClick(View view) {
            if (!LuckyMoneyPrepareUI.this.okX.isShown() && !this.ile) {
                LuckyMoneyPrepareUI.this.okX.setVisibility(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(this.ili);
            } else if (this.ile) {
                LuckyMoneyPrepareUI.this.okX.setVisibility(8);
                ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(this.ilg, 0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.old = getIntent().getIntExtra("key_way", 3);
        this.kKY = getIntent().getIntExtra("key_from", 0);
        this.olg = this.kKY == 1;
        this.oli = getIntent().getIntExtra("pay_channel", -1);
        b(new w("v1.0", (byte) 0), true);
        com.tencent.mm.plugin.luckymoney.a.a.aXv();
        this.ohp = com.tencent.mm.plugin.luckymoney.a.a.aXw().aXH();
        x.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.old + "mChannel:" + this.oli);
        x.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.olg + ", config " + this.ohp);
        initView();
        com.tencent.mm.sdk.b.a.xmy.a(this.opg);
        g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXX()), Integer.valueOf(1));
    }

    protected void onResume() {
        super.onResume();
        jl(1970);
    }

    protected void onStop() {
        super.onStop();
        jm(1970);
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LuckyMoneyPrepareUI.this.finish();
                return true;
            }
        });
        this.okY = findViewById(f.uvE);
        this.okZ = findViewById(f.uvH);
        this.lMM = (Button) findViewById(f.uvG);
        this.okW = (LuckyMoneyTextInputView) findViewById(f.uwi);
        this.okW.EI(getString(i.uQq));
        this.ofq = (Button) findViewById(f.uvx);
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uDo);
        this.okX = findViewById(f.uDn);
        this.lsa = (TextView) findViewById(f.uvw);
        this.okU = (LuckyMoneyNumInputView) findViewById(f.uvt);
        this.okV = (LuckyMoneyMoneyInputView) findViewById(f.utc);
        this.lrX = (TextView) findViewById(f.uvI);
        this.ola = (ViewGroup) findViewById(f.uvD);
        this.ooZ = (MMScrollView) findViewById(f.uwc);
        this.olb = (TextView) findViewById(f.uvB);
        if (this.mType == 1) {
            setMMTitle(i.uQK);
            this.okV.setTitle(getString(i.uRB));
            this.okV.gy(true);
        } else {
            setMMTitle(i.uQX);
            this.okV.setTitle(getString(i.uRC));
            this.okV.gy(false);
        }
        this.okV.onE = this;
        LuckyMoneyMoneyInputView luckyMoneyMoneyInputView = this.okV;
        luckyMoneyMoneyInputView.onB.setHint(getString(i.uQU));
        this.okU.onE = this;
        LuckyMoneyNumInputView luckyMoneyNumInputView = this.okU;
        luckyMoneyNumInputView.ooL.setHint(getString(i.uQZ));
        this.okW.onE = this;
        final EditText editText = (EditText) this.okV.findViewById(f.uua);
        final EditText editText2 = (EditText) this.okU.findViewById(f.uua);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.xRr.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                editText.setContentDescription(editable.toString());
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                editText2.setContentDescription(editable.toString());
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okV, 2);
                LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okU, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.okX.setVisibility(0);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.okV.findViewById(f.utd);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okV, 2);
                    LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okU, 0);
                    LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    LuckyMoneyPrepareUI.this.okX.setVisibility(0);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.xRr.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okV, 2);
                LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okU, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.okX.setVisibility(0);
            }
        });
        ((MMEditText) this.okW.findViewById(f.uwd)).setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okV, 2);
                LuckyMoneyPrepareUI.this.z(LuckyMoneyPrepareUI.this.okU, 0);
            }
        });
        if (this.ohp != null) {
            if (this.mType == 1) {
                this.okV.onF = this.ohp.ohg;
            } else {
                this.okV.onF = this.ohp.ohj;
            }
            this.okV.onG = this.ohp.ohl;
            if (this.ohp.loD != 1) {
                do(this.ohp.oho, this.ohp.ohn);
            }
        }
        if (!this.olg || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.okU.EG("");
        } else {
            this.okU.EG("1");
        }
        this.okU.sA(this.ohp.ohf);
        this.okU.ooP = 1;
        x.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.okU.aYu());
        this.okV.aYo();
        if (this.olg || this.kKY == 2) {
            setMMTitle(i.uRz);
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (this.olg && intExtra == 0) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.okU.setVisibility(8);
            } else {
                String string = getString(i.uQA);
                String string2 = getString(i.uQL);
                String string3 = getString(i.uQw);
                String string4 = getString(i.uQM);
                if (this.olg && intExtra > 0) {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", Integer.valueOf(intExtra));
                    String string5 = getString(i.uQO);
                    string = getString(i.uQN);
                    TextView textView2 = (TextView) findViewById(f.uvC);
                    textView2.setText(getString(i.uQY, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                    textView2.setVisibility(0);
                    string3 = string;
                    string = string5;
                } else if (this.kKY == 2) {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                    this.okW.setVisibility(8);
                }
                final com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                final CharSequence spannableString = new SpannableString(string + string2);
                spannableString.setSpan(gVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                final com.tencent.mm.plugin.wallet_core.ui.g gVar2 = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString2.setSpan(gVar2, string3.length(), string3.length() + string4.length(), 33);
                gVar.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                    public final void onClick(View view) {
                        int aYu = LuckyMoneyPrepareUI.this.okU.aYu();
                        double aYn = LuckyMoneyPrepareUI.this.okV.aYn();
                        LuckyMoneyPrepareUI.this.mType = 0;
                        LuckyMoneyPrepareUI.this.okV.mType = LuckyMoneyPrepareUI.this.mType;
                        LuckyMoneyPrepareUI.this.okV.gy(false);
                        LuckyMoneyPrepareUI.this.okV.setTitle(LuckyMoneyPrepareUI.this.getString(i.uRC));
                        if (aYn > 0.0d && aYu > 0) {
                            LuckyMoneyPrepareUI.this.okV.EF(e.t(aYn / ((double) aYu)));
                        }
                        LuckyMoneyPrepareUI.this.okV.onF = LuckyMoneyPrepareUI.this.ohp.ohj;
                        LuckyMoneyPrepareUI.this.lsa.setText(spannableString2);
                        g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(3));
                    }
                };
                gVar2.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                    public final void onClick(View view) {
                        int aYu = LuckyMoneyPrepareUI.this.okU.aYu();
                        double aYn = LuckyMoneyPrepareUI.this.okV.aYn();
                        LuckyMoneyPrepareUI.this.mType = 1;
                        LuckyMoneyPrepareUI.this.okV.mType = LuckyMoneyPrepareUI.this.mType;
                        LuckyMoneyPrepareUI.this.okV.onF = LuckyMoneyPrepareUI.this.ohp.ohg;
                        LuckyMoneyPrepareUI.this.okV.setTitle(LuckyMoneyPrepareUI.this.getString(i.uRB));
                        LuckyMoneyPrepareUI.this.okV.gy(true);
                        if (aYn > 0.0d && aYu > 0) {
                            LuckyMoneyPrepareUI.this.okV.EF(e.t(aYn * ((double) aYu)));
                        }
                        LuckyMoneyPrepareUI.this.lsa.setText(spannableString);
                        g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(2));
                    }
                };
                this.lsa.setMovementMethod(LinkMovementMethod.getInstance());
                if (a.xVN.cov()) {
                    this.lsa.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (!a.xVN.cov()) {
                                return;
                            }
                            if (LuckyMoneyPrepareUI.this.lsa.getText().toString().equals(spannableString.toString())) {
                                gVar.onClick(view);
                            } else {
                                gVar2.onClick(view);
                            }
                        }
                    });
                }
                this.lsa.setText(spannableString);
                this.lsa.setVisibility(0);
            }
        } else if (this.mType == 1) {
            this.lsa.setText(this.ohp.ohh);
            this.lsa.setVisibility(0);
        } else if (this.mType == 0) {
            this.lsa.setText(this.ohp.ohi);
            this.lsa.setVisibility(0);
        }
        this.ofq.setOnClickListener(new r() {
            public final void azE() {
                g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(4));
                if (LuckyMoneyPrepareUI.this.okV.aYm() != 0) {
                    u.makeText(LuckyMoneyPrepareUI.this.mController.xRr, i.uWd, 0).show();
                    return;
                }
                long v;
                int aYu = LuckyMoneyPrepareUI.this.okU.aYu();
                double aYn = LuckyMoneyPrepareUI.this.okV.aYn();
                long j = 0;
                if (LuckyMoneyPrepareUI.this.mType == 1) {
                    v = e.v(aYn);
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(356354, Integer.valueOf(aYu));
                } else {
                    v = e.v(((double) aYu) * aYn);
                    j = e.v(aYn);
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(356353, Integer.valueOf(aYu));
                }
                String input = LuckyMoneyPrepareUI.this.okW.getInput();
                if (bi.oN(input)) {
                    input = bi.oN(LuckyMoneyPrepareUI.this.opc) ? LuckyMoneyPrepareUI.this.getString(i.uQq) : LuckyMoneyPrepareUI.this.opc;
                }
                if (LuckyMoneyPrepareUI.this.kKY == 2) {
                    LuckyMoneyPrepareUI.this.b(new com.tencent.mm.plugin.luckymoney.f2f.a.c(aYu, (int) v, LuckyMoneyPrepareUI.this.mType, (int) j), false);
                } else {
                    String stringExtra = LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
                    if (LuckyMoneyPrepareUI.this.opa == 1) {
                        k adVar;
                        x.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB");
                        if (!LuckyMoneyPrepareUI.this.olg || bi.oN(stringExtra)) {
                            adVar = new ad(aYu, v, j, LuckyMoneyPrepareUI.this.mType, input, n.aXM(), null, null, q.FY(), q.Ga(), LuckyMoneyPrepareUI.this.old);
                        } else {
                            adVar = new ad(aYu, v, j, LuckyMoneyPrepareUI.this.mType, input, n.aXM(), stringExtra, n.gv(stringExtra), q.FY(), q.Ga(), LuckyMoneyPrepareUI.this.old);
                        }
                        LuckyMoneyPrepareUI.this.b(adVar, false);
                    } else {
                        k xVar;
                        x.i("MicroMsg.LuckyMoneyPrepareUI", "currency=" + LuckyMoneyPrepareUI.this.opa);
                        LuckyMoneyPrepareUI.this.jl(1645);
                        if (!LuckyMoneyPrepareUI.this.olg || bi.oN(stringExtra)) {
                            xVar = new com.tencent.mm.plugin.luckymoney.b.x(aYu, v, j, LuckyMoneyPrepareUI.this.mType, input, null, n.aXM(), q.FY(), LuckyMoneyPrepareUI.this.opa);
                        } else {
                            xVar = new com.tencent.mm.plugin.luckymoney.b.x(aYu, v, j, LuckyMoneyPrepareUI.this.mType, input, stringExtra, n.aXM(), q.FY(), LuckyMoneyPrepareUI.this.opa);
                        }
                        LuckyMoneyPrepareUI.this.b(xVar, false);
                    }
                }
                if (LuckyMoneyPrepareUI.this.ion != null) {
                    LuckyMoneyPrepareUI.this.ion.show();
                } else {
                    LuckyMoneyPrepareUI.this.ion = com.tencent.mm.wallet_core.ui.g.a(LuckyMoneyPrepareUI.this.mController.xRr, true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            if (LuckyMoneyPrepareUI.this.ion != null && LuckyMoneyPrepareUI.this.ion.isShowing()) {
                                LuckyMoneyPrepareUI.this.ion.dismiss();
                            }
                            if (LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                                x.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                                LuckyMoneyPrepareUI.this.finish();
                            }
                            LuckyMoneyPrepareUI.this.olU.aXI();
                        }
                    });
                }
            }
        });
        this.olc.a(this.okU);
        this.olc.a(this.okV);
        this.olc.a(this.okW);
        this.olc.g((TextView) findViewById(f.uvz));
        this.jcp = new al(new al.a() {
            public final boolean uG() {
                double d;
                if (LuckyMoneyPrepareUI.this.okV.aYm() == 3 || LuckyMoneyPrepareUI.this.okU.aYm() == 3) {
                    d = 0.0d;
                } else {
                    int aYu = LuckyMoneyPrepareUI.this.okU.aYu();
                    d = LuckyMoneyPrepareUI.this.okV.aYn();
                    if (LuckyMoneyPrepareUI.this.mType == 0) {
                        d *= (double) aYu;
                    }
                }
                if (d == 0.0d || d > LuckyMoneyPrepareUI.this.ohp.ohg || LuckyMoneyPrepareUI.this.olc.aYl()) {
                    LuckyMoneyPrepareUI.this.ofq.setClickable(false);
                    LuckyMoneyPrepareUI.this.ofq.setEnabled(false);
                } else {
                    LuckyMoneyPrepareUI.this.ofq.setClickable(true);
                    LuckyMoneyPrepareUI.this.ofq.setEnabled(true);
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + LuckyMoneyPrepareUI.this.olc.aYl());
                LuckyMoneyPrepareUI.this.jcp.cgx();
                return false;
            }
        }, false);
        if (this.ooZ != null) {
            this.ooZ.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        LuckyMoneyPrepareUI.this.Xj();
                        LuckyMoneyPrepareUI.this.aWY();
                    }
                    return false;
                }
            });
        }
        this.okV.mType = this.mType;
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.ujz, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (LuckyMoneyPrepareUI.this.opa == 1) {
                    e.l(LuckyMoneyPrepareUI.this.mController.xRr, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                } else {
                    e.l(LuckyMoneyPrepareUI.this.mController.xRr, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                }
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        this.olc.clear();
        this.jcp.cgx();
        if (this.ion != null && this.ion.isShowing()) {
            this.ion.dismiss();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.opg);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uJf;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.okY.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.okY.setVisibility(8);
        aYe();
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + kVar.getType());
        PayInfo payInfo;
        if (kVar instanceof ad) {
            if (this.ion != null && this.ion.isShowing()) {
                this.ion.dismiss();
            }
            if (this.opf) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                return true;
            } else if (i == 0 && i2 == 0) {
                ad adVar = (ad) kVar;
                this.olf = adVar.lon;
                this.ole = adVar.oeH;
                this.olh = adVar.oiY;
                this.omj = adVar.oeH;
                this.ope = adVar.oje;
                payInfo = new PayInfo();
                payInfo.fvC = adVar.oiX;
                payInfo.fDQ = 37;
                payInfo.fDM = this.oli;
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 1);
                return true;
            } else if (i2 == 401) {
                this.ofq.setEnabled(false);
                this.ofq.setClickable(false);
                this.jcp.K(5000, 5000);
                h.bu(this, str);
                return true;
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = getString(i.vdG);
                }
                h.a((Context) this, str, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return true;
            }
        }
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.ag) {
            if (i == 0 && i2 == 0) {
                if (this.olg) {
                    com.tencent.mm.ui.snackbar.a.h(this, getString(i.epo));
                    ah.h(new Runnable() {
                        public final void run() {
                            LuckyMoneyPrepareUI.this.finish();
                        }
                    }, 1800);
                } else {
                    aYf();
                    this.okZ.setVisibility(0);
                    this.okZ.postDelayed(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyPrepareUI.this.mController.xRr, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            LuckyMoneyPrepareUI.this.mController.xRr.startActivity(intent);
                            LuckyMoneyPrepareUI.this.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX) {
                h.a(this.mController.xRr, str, "", getString(i.uRr), getString(i.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(LuckyMoneyPrepareUI.this.mController.xRr, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        LuckyMoneyPrepareUI.this.startActivity(intent);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof w) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (i == 0 && i2 == 0) {
                final w wVar = (w) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.aXv();
                this.ohp = com.tencent.mm.plugin.luckymoney.a.a.aXw().aXH();
                x.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.ohp);
                if (this.mType == 1) {
                    this.okV.onF = this.ohp.ohg;
                } else {
                    this.okV.onF = this.ohp.ohj;
                }
                this.okV.onG = this.ohp.ohl;
                this.okU.sA(this.ohp.ohf);
                this.opb = wVar.ohn;
                this.opa = wVar.loD;
                this.opc = wVar.oht;
                if (!(bi.oN(this.opc) || this.okW == null)) {
                    ah.y(new Runnable() {
                        public final void run() {
                            LuckyMoneyPrepareUI.this.okW.EI(LuckyMoneyPrepareUI.this.opc);
                        }
                    });
                }
                if (wVar.oiK && this.olg) {
                    TextView textView = (TextView) findViewById(f.uvA);
                    textView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(9));
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyPrepareUI.this.mController.xRr, LuckyMoneyCanShareListUI.class);
                            LuckyMoneyPrepareUI.this.startActivity(intent);
                        }
                    });
                    g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXX()), Integer.valueOf(8));
                    textView.setVisibility(0);
                }
                if (bi.oN(wVar.loF)) {
                    this.olb.setVisibility(8);
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + wVar.loF);
                    this.olb.setText(wVar.loF);
                    if (!bi.oN(wVar.oiM)) {
                        this.olb.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                e.l(LuckyMoneyPrepareUI.this.mController.xRr, wVar.oiM, false);
                            }
                        });
                    }
                    this.olb.setVisibility(0);
                }
                g.c cVar = new g.c();
                if (wVar.oiO == null || bi.oN(wVar.oiO.content)) {
                    cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO);
                } else {
                    cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhY);
                }
                g.a(this, this.ola, wVar.oiO, cVar);
                do(wVar.oho, wVar.ohn);
                b(0.0d, this.opb);
            }
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.x) {
            jm(1645);
            if (this.ion != null && this.ion.isShowing()) {
                this.ion.hide();
            }
            if (i == 0 && i2 == 0) {
                String str2 = ((com.tencent.mm.plugin.luckymoney.b.x) kVar).loR;
                if (bi.oN(str2)) {
                    x.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.c) {
            if (i == 0 && i2 == 0) {
                if (this.ion != null) {
                    this.ion.dismiss();
                }
                this.omj = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).oeH;
                this.ope = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).oeT;
                payInfo = new PayInfo();
                payInfo.fvC = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).fvC;
                payInfo.fDQ = 37;
                t.j(37, payInfo.fvC, i2);
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 4);
            } else {
                t.j(37, "", i2);
                if (!bi.oN(str)) {
                    h.b(this, str, getString(i.uQo), true);
                }
                this.ion.dismiss();
            }
            return true;
        }
        return false;
    }

    private void do(String str, String str2) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=" + str);
        TextView textView = (TextView) findViewById(f.utd);
        if (bi.oN(str)) {
            textView.setText(getString(i.utd));
        } else {
            textView.setText(str);
        }
        if (bi.oN(str2)) {
            b(0.0d, e.abi("CNY"));
        } else {
            b(0.0d, str2);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.opd = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i2 == -1) {
                    g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXX()), Integer.valueOf(5));
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (!this.olg || bi.oN(stringExtra)) {
                        aYf();
                        View findViewById = findViewById(f.uvF);
                        this.okY.setVisibility(0);
                        n.a(findViewById, null);
                        this.lMM.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(6));
                                n.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.mType, LuckyMoneyPrepareUI.this.olf, true);
                                LuckyMoneyPrepareUI.this.okY.postDelayed(new Runnable() {
                                    public final void run() {
                                        LuckyMoneyPrepareUI.this.okY.setVisibility(8);
                                        LuckyMoneyPrepareUI.this.aYe();
                                    }
                                }, 100);
                            }
                        });
                        ((ImageView) findViewById(f.uvy)).setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                LuckyMoneyPrepareUI.this.okY.setVisibility(8);
                                LuckyMoneyPrepareUI.this.aYe();
                            }
                        });
                    } else {
                        h.bu(this, getString(i.epo));
                        Map y = bj.y(this.olh, "msg");
                        if (y == null) {
                            x.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                            finish();
                            return;
                        }
                        str = (String) y.get(".msg.appmsg.wcpayinfo.paymsgid");
                        if (com.tencent.mm.plugin.luckymoney.a.a.aXv().aXy().Ez(str)) {
                            x.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                            if (!n.B(this.olh, stringExtra, 1)) {
                                x.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                com.tencent.mm.plugin.luckymoney.a.a.aXv().aXy().EA(str);
                            }
                        } else {
                            x.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                        }
                        finish();
                    }
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    EH(str);
                    break;
                }
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.mController.xRr, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXX()), Integer.valueOf(7), str);
                if (!bi.oN(str)) {
                    l(new com.tencent.mm.plugin.luckymoney.b.ag(str.replaceAll(",", "|"), this.ole, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        x.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = bi.getInt(bundleExtra.getString("payState", "2"), 0);
                    x.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
                }
                break;
            case 4:
                if (i2 == -1) {
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    EH(str);
                }
                finish();
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uDo);
        this.okX = findViewById(f.uDn);
        View findViewById = findViewById(f.ivH);
        EditText editText = (EditText) view.findViewById(f.uua);
        if (this.mKeyboard != null && editText != null && this.okX != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new AnonymousClass19(false, i, editText));
            editText.setOnClickListener(new AnonymousClass20(false, i, editText));
            TextView textView = (TextView) view.findViewById(f.utd);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass21(false, editText, view, i));
            }
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    LuckyMoneyPrepareUI.this.Xj();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.okX == null || !this.okX.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.okX.setVisibility(8);
        return true;
    }

    protected final void Xj() {
        if (this.okX != null && this.okX.isShown()) {
            this.okX.setVisibility(8);
        }
    }

    public final void aXW() {
        double d;
        double d2;
        com.tencent.mm.plugin.luckymoney.a.a.aXv();
        this.ohp = com.tencent.mm.plugin.luckymoney.a.a.aXw().aXH();
        if (this.okV.aYm() == 3 || this.okU.aYm() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int aYu = this.okU.aYu();
            d2 = this.okV.aYn();
            if (this.mType == 0) {
                d2 *= (double) aYu;
                d = this.okV.aYn();
            } else {
                d = aYu > 0 ? this.okV.aYn() / ((double) aYu) : 0.0d;
            }
        }
        if (this.olc.aYk()) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
            this.ofq.setClickable(false);
            this.ofq.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.ohp.ohg && this.ohp.ohg > 0.0d) {
                this.olc.sC(getString(i.uRA, new Object[]{Math.round(this.ohp.ohg), bi.aD(this.ohp.oho, "")}));
                z = true;
            } else if (d > 0.0d) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount " + d);
                if (this.mType == 0) {
                    if (d > this.ohp.ohj && this.ohp.ohj > 0.0d) {
                        this.olc.sC(getString(i.uRg, new Object[]{Math.round(this.ohp.ohj), bi.aD(this.ohp.oho, "")}));
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.ohp.ohk && this.ohp.ohk > 0.0d) {
                        this.olc.sC(getString(i.uRg, new Object[]{Math.round(this.ohp.ohk), bi.aD(this.ohp.oho, "")}));
                        this.okU.onError();
                        this.okV.onError();
                        z = true;
                    }
                    z = false;
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.mType == 0) {
                        if (d < this.ohp.ohl) {
                            this.olc.sC(getString(i.uRh, new Object[]{e.t(this.ohp.ohl), bi.aD(this.ohp.oho, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.olc.sC(getString(i.uRh, new Object[]{"0.01", bi.aD(this.ohp.oho, "")}));
                        this.okU.onError();
                        this.okV.onError();
                        z = true;
                    }
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.ofq.setClickable(false);
                this.ofq.setEnabled(false);
            } else {
                this.ofq.setClickable(true);
                this.ofq.setEnabled(true);
            }
        }
        b(d2, this.opb);
    }

    private void b(double d, String str) {
        if (bi.oN(str)) {
            this.lrX.setText(e.u(d));
        } else {
            this.lrX.setText(str + e.t(d));
        }
    }

    private int aXX() {
        if (!this.olg) {
            return 3;
        }
        if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            return 2;
        }
        return 1;
    }

    public void finish() {
        if (this.opd != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.opd);
            d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
    }

    private void EH(String str) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
        b(new com.tencent.mm.plugin.luckymoney.b.u(this.omj, str, this.ope), false);
    }
}
