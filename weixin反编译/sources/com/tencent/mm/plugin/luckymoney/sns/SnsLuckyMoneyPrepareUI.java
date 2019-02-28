package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    protected Dialog ion = null;
    private al jcp = null;
    private ScrollView jmE;
    protected Button lMM = null;
    protected TextView lrX = null;
    private TextView lsa;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    protected Button ofq = null;
    private c ohp;
    protected LuckyMoneyNumInputView okU = null;
    protected LuckyMoneyMoneyInputView okV = null;
    protected LuckyMoneyTextInputView okW = null;
    protected View okX;
    private View okY;
    private View okZ;
    private ViewGroup ola;
    private TextView olb;
    private com.tencent.mm.plugin.luckymoney.ui.a olc = new com.tencent.mm.plugin.luckymoney.ui.a();
    private int old;
    private String ole;
    private int olf;
    private boolean olg;
    private String olh;
    private int oli;
    private com.tencent.mm.wallet_core.ui.a olj;

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$13 */
    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ boolean ile = false;
        final /* synthetic */ EditText ilg;
        final /* synthetic */ int ili;

        AnonymousClass13(boolean z, int i, EditText editText) {
            this.ili = i;
            this.ilg = editText;
        }

        public final void onClick(View view) {
            if (!SnsLuckyMoneyPrepareUI.this.okX.isShown() && !this.ile) {
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(this.ili);
            } else if (this.ile) {
                SnsLuckyMoneyPrepareUI.this.Xj();
                ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(this.ilg, 0);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$10 */
    class AnonymousClass10 implements OnFocusChangeListener {
        final /* synthetic */ boolean ile = false;
        final /* synthetic */ EditText ilg;
        final /* synthetic */ int ili;

        AnonymousClass10(boolean z, int i, EditText editText) {
            this.ili = i;
            this.ilg = editText;
        }

        public final void onFocusChange(final View view, boolean z) {
            if (!view.isFocused() || this.ile) {
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        SnsLuckyMoneyPrepareUI.this.Xj();
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(AnonymousClass10.this.ilg, 0);
                    }
                }, 200);
                return;
            }
            ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    if (!SnsLuckyMoneyPrepareUI.this.okX.isShown() && view.isShown()) {
                        SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                    }
                    SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(AnonymousClass10.this.ili);
                    SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                    ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }, 300);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$12 */
    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ boolean ile = false;
        final /* synthetic */ EditText ilg;
        final /* synthetic */ int ili;

        AnonymousClass12(boolean z, int i, EditText editText) {
            this.ili = i;
            this.ilg = editText;
        }

        public final void onClick(View view) {
            if (!SnsLuckyMoneyPrepareUI.this.okX.isShown() && !this.ile) {
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(this.ili);
            } else if (this.ile) {
                SnsLuckyMoneyPrepareUI.this.Xj();
                ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(this.ilg, 0);
            }
        }
    }

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        if (snsLuckyMoneyPrepareUI.okX != null && !snsLuckyMoneyPrepareUI.okX.isShown()) {
            snsLuckyMoneyPrepareUI.okX.setVisibility(0);
            snsLuckyMoneyPrepareUI.olj.hE(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.old = getIntent().getIntExtra("key_way", 3);
        this.olg = getIntent().getIntExtra("key_from", 0) == 1;
        this.oli = getIntent().getIntExtra("pay_channel", -1);
        b(new w("v1.0", (byte) 0), false);
        com.tencent.mm.plugin.luckymoney.a.a.aXv();
        this.ohp = com.tencent.mm.plugin.luckymoney.a.a.aXw().aXH();
        x.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.olg + ", config " + this.ohp);
        initView();
        g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXX()), Integer.valueOf(1));
    }

    protected final void initView() {
        r(getResources().getDrawable(e.uji));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsLuckyMoneyPrepareUI.this.finish();
                return true;
            }
        });
        this.okY = findViewById(com.tencent.mm.plugin.wxpay.a.f.uvE);
        this.okZ = findViewById(com.tencent.mm.plugin.wxpay.a.f.uvH);
        this.lMM = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvG);
        this.okW = (LuckyMoneyTextInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uwi);
        this.okW.EI(getString(i.uQq));
        this.ofq = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvx);
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.uDo);
        this.okX = findViewById(com.tencent.mm.plugin.wxpay.a.f.uDn);
        this.lsa = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvw);
        this.okU = (LuckyMoneyNumInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvt);
        this.okV = (LuckyMoneyMoneyInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.utc);
        this.lrX = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvI);
        this.ola = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvD);
        this.jmE = (ScrollView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uwc);
        this.olb = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvB);
        if (this.mType == 1) {
            this.okV.setTitle(getString(i.uRB));
            this.okV.gy(true);
        } else {
            this.okV.setTitle(getString(i.uRC));
            this.okV.gy(false);
        }
        this.okV.onE = this;
        this.okU.onE = this;
        this.okW.onE = this;
        final EditText editText = (EditText) this.okV.findViewById(com.tencent.mm.plugin.wxpay.a.f.uua);
        final EditText editText2 = (EditText) this.okU.findViewById(com.tencent.mm.plugin.wxpay.a.f.uua);
        com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.xRr.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.z(SnsLuckyMoneyPrepareUI.this.okV, 2);
                SnsLuckyMoneyPrepareUI.this.z(SnsLuckyMoneyPrepareUI.this.okU, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            }
        });
        TextView textView = (TextView) this.okV.findViewById(com.tencent.mm.plugin.wxpay.a.f.utd);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    SnsLuckyMoneyPrepareUI.this.z(SnsLuckyMoneyPrepareUI.this.okV, 2);
                    SnsLuckyMoneyPrepareUI.this.z(SnsLuckyMoneyPrepareUI.this.okU, 0);
                    SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                }
            });
        }
        com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.xRr.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.z(SnsLuckyMoneyPrepareUI.this.okV, 2);
                SnsLuckyMoneyPrepareUI.this.z(SnsLuckyMoneyPrepareUI.this.okU, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            }
        });
        if (this.ohp != null) {
            if (this.mType == 1) {
                this.okV.onF = this.ohp.ohg;
            } else {
                this.okV.onF = this.ohp.ohj;
            }
            this.okV.onG = this.ohp.ohl;
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
        if (this.olg) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(i.uQO);
                String string2 = getString(i.uQL);
                String string3 = getString(i.uQN);
                String string4 = getString(i.uQM);
                final CharSequence spannableString = new SpannableString(string + string2);
                com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString.setSpan(gVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.g gVar2 = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                spannableString2.setSpan(gVar2, string3.length(), string3.length() + string4.length(), 33);
                gVar.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                    public final void onClick(View view) {
                        int aYu = SnsLuckyMoneyPrepareUI.this.okU.aYu();
                        double aYn = SnsLuckyMoneyPrepareUI.this.okV.aYn();
                        SnsLuckyMoneyPrepareUI.this.mType = 0;
                        SnsLuckyMoneyPrepareUI.this.okV.mType = SnsLuckyMoneyPrepareUI.this.mType;
                        SnsLuckyMoneyPrepareUI.this.okV.gy(false);
                        SnsLuckyMoneyPrepareUI.this.okV.setTitle(SnsLuckyMoneyPrepareUI.this.getString(i.uRC));
                        if (aYn > 0.0d && aYu > 0) {
                            SnsLuckyMoneyPrepareUI.this.okV.EF(com.tencent.mm.wallet_core.ui.e.t(aYn / ((double) aYu)));
                        }
                        SnsLuckyMoneyPrepareUI.this.okV.onF = SnsLuckyMoneyPrepareUI.this.ohp.ohj;
                        SnsLuckyMoneyPrepareUI.this.lsa.setText(spannableString2);
                        g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(3));
                    }
                };
                gVar2.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                    public final void onClick(View view) {
                        int aYu = SnsLuckyMoneyPrepareUI.this.okU.aYu();
                        double aYn = SnsLuckyMoneyPrepareUI.this.okV.aYn();
                        SnsLuckyMoneyPrepareUI.this.mType = 1;
                        SnsLuckyMoneyPrepareUI.this.okV.mType = SnsLuckyMoneyPrepareUI.this.mType;
                        SnsLuckyMoneyPrepareUI.this.okV.setTitle(SnsLuckyMoneyPrepareUI.this.getString(i.uRB));
                        SnsLuckyMoneyPrepareUI.this.okV.gy(true);
                        if (aYn > 0.0d && aYu > 0) {
                            SnsLuckyMoneyPrepareUI.this.okV.EF(com.tencent.mm.wallet_core.ui.e.t(aYn * ((double) aYu)));
                        }
                        SnsLuckyMoneyPrepareUI.this.okV.onF = SnsLuckyMoneyPrepareUI.this.ohp.ohg;
                        SnsLuckyMoneyPrepareUI.this.lsa.setText(spannableString);
                        g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(2));
                    }
                };
                this.lsa.setMovementMethod(LinkMovementMethod.getInstance());
                this.lsa.setText(spannableString);
                this.lsa.setVisibility(0);
            } else {
                this.okU.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.lsa.setText(this.ohp.ohh);
            this.lsa.setVisibility(0);
        } else if (this.mType == 0) {
            this.lsa.setText(this.ohp.ohi);
            this.lsa.setVisibility(0);
        }
        this.ofq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(4));
                if (SnsLuckyMoneyPrepareUI.this.okV.aYm() != 0) {
                    u.makeText(SnsLuckyMoneyPrepareUI.this.mController.xRr, i.uWd, 0).show();
                    return;
                }
                long v;
                k adVar;
                int aYu = SnsLuckyMoneyPrepareUI.this.okU.aYu();
                double aYn = SnsLuckyMoneyPrepareUI.this.okV.aYn();
                long j = 0;
                if (SnsLuckyMoneyPrepareUI.this.mType == 1) {
                    v = com.tencent.mm.wallet_core.ui.e.v(aYn);
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(356354, Integer.valueOf(aYu));
                } else {
                    v = com.tencent.mm.wallet_core.ui.e.v(((double) aYu) * aYn);
                    j = com.tencent.mm.wallet_core.ui.e.v(aYn);
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(356353, Integer.valueOf(aYu));
                }
                String input = SnsLuckyMoneyPrepareUI.this.okW.getInput();
                if (bi.oN(input)) {
                    input = SnsLuckyMoneyPrepareUI.this.getString(i.uQq);
                }
                String stringExtra = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
                if (!SnsLuckyMoneyPrepareUI.this.olg || bi.oN(stringExtra)) {
                    adVar = new ad(aYu, v, j, SnsLuckyMoneyPrepareUI.this.mType, input, n.aXM(), null, null, q.FY(), q.Ga(), SnsLuckyMoneyPrepareUI.this.old);
                } else {
                    adVar = new ad(aYu, v, j, SnsLuckyMoneyPrepareUI.this.mType, input, n.aXM(), stringExtra, n.gv(stringExtra), q.FY(), q.Ga(), SnsLuckyMoneyPrepareUI.this.old);
                }
                SnsLuckyMoneyPrepareUI.this.b(adVar, false);
                if (SnsLuckyMoneyPrepareUI.this.ion != null) {
                    SnsLuckyMoneyPrepareUI.this.ion.show();
                    return;
                }
                SnsLuckyMoneyPrepareUI.this.ion = com.tencent.mm.wallet_core.ui.g.a(SnsLuckyMoneyPrepareUI.this.mController.xRr, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (SnsLuckyMoneyPrepareUI.this.ion != null && SnsLuckyMoneyPrepareUI.this.ion.isShowing()) {
                            SnsLuckyMoneyPrepareUI.this.ion.hide();
                        }
                        if (SnsLuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || SnsLuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                            x.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                            SnsLuckyMoneyPrepareUI.this.finish();
                        }
                        SnsLuckyMoneyPrepareUI.this.olU.aXI();
                    }
                });
            }
        });
        this.lrX.setText(com.tencent.mm.wallet_core.ui.e.u(0.0d));
        this.olc.a(this.okU);
        this.olc.a(this.okV);
        this.olc.a(this.okW);
        this.olc.g((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvz));
        if (this.olg && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvC);
            textView2.setText(getString(i.uQY, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.jcp = new al(new al.a() {
            public final boolean uG() {
                double d;
                if (SnsLuckyMoneyPrepareUI.this.okV.aYm() == 3 || SnsLuckyMoneyPrepareUI.this.okU.aYm() == 3) {
                    d = 0.0d;
                } else {
                    int aYu = SnsLuckyMoneyPrepareUI.this.okU.aYu();
                    d = SnsLuckyMoneyPrepareUI.this.okV.aYn();
                    if (SnsLuckyMoneyPrepareUI.this.mType == 0) {
                        d *= (double) aYu;
                    }
                }
                if (d == 0.0d || d > SnsLuckyMoneyPrepareUI.this.ohp.ohg || SnsLuckyMoneyPrepareUI.this.olc.aYl()) {
                    SnsLuckyMoneyPrepareUI.this.ofq.setClickable(false);
                    SnsLuckyMoneyPrepareUI.this.ofq.setEnabled(false);
                } else {
                    SnsLuckyMoneyPrepareUI.this.ofq.setClickable(true);
                    SnsLuckyMoneyPrepareUI.this.ofq.setEnabled(true);
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + SnsLuckyMoneyPrepareUI.this.olc.aYl());
                SnsLuckyMoneyPrepareUI.this.jcp.cgx();
                return false;
            }
        }, false);
        if (this.jmE != null) {
            this.jmE.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        SnsLuckyMoneyPrepareUI.this.Xj();
                        SnsLuckyMoneyPrepareUI.this.aWY();
                    }
                    return false;
                }
            });
        }
        this.okV.mType = this.mType;
        if (this.olg && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.okV.requestFocus();
        } else {
            this.okU.requestFocus();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.olc.clear();
        this.jcp.cgx();
        if (this.ion != null && this.ion.isShowing()) {
            this.ion.dismiss();
        }
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
        if (kVar instanceof ad) {
            if (this.ion != null && this.ion.isShowing()) {
                this.ion.hide();
            }
            if (i == 0 && i2 == 0) {
                ad adVar = (ad) kVar;
                this.olf = adVar.lon;
                this.ole = adVar.oeH;
                this.olh = adVar.oiY;
                PayInfo payInfo = new PayInfo();
                payInfo.fvC = adVar.oiX;
                payInfo.fDQ = 37;
                payInfo.fDM = this.oli;
                h.a((Context) this, payInfo, 1);
                return true;
            } else if (i2 == 401) {
                this.ofq.setEnabled(false);
                this.ofq.setClickable(false);
                this.jcp.K(5000, 5000);
                com.tencent.mm.ui.base.h.bu(this, str);
                return true;
            } else {
                com.tencent.mm.ui.base.h.bu(this, str);
                return true;
            }
        }
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.ag) {
            if (i == 0 && i2 == 0) {
                if (this.olg) {
                    com.tencent.mm.ui.base.h.bu(this, getString(i.epo));
                    finish();
                } else {
                    aYf();
                    this.okZ.postDelayed(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.xRr, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            SnsLuckyMoneyPrepareUI.this.mController.xRr.startActivity(intent);
                            SnsLuckyMoneyPrepareUI.this.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX) {
                com.tencent.mm.ui.base.h.a(this.mController.xRr, str, "", getString(i.uRr), getString(i.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.xRr, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        SnsLuckyMoneyPrepareUI.this.startActivity(intent);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof w) {
            if (i == 0 && i2 == 0) {
                final w wVar = (w) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.aXv();
                this.ohp = com.tencent.mm.plugin.luckymoney.a.a.aXw().aXH();
                x.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.ohp);
                if (this.mType == 1) {
                    this.okV.onF = this.ohp.ohg;
                } else {
                    this.okV.onF = this.ohp.ohj;
                }
                this.okV.onG = this.ohp.ohl;
                this.okU.sA(this.ohp.ohf);
                if (wVar.oiK && this.olg) {
                    TextView textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvA);
                    textView.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(9));
                            Intent intent = new Intent();
                            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.xRr, LuckyMoneyCanShareListUI.class);
                            SnsLuckyMoneyPrepareUI.this.startActivity(intent);
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
                        this.olb.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                com.tencent.mm.wallet_core.ui.e.l(SnsLuckyMoneyPrepareUI.this.mController.xRr, wVar.oiM, false);
                            }
                        });
                    }
                    this.olb.setVisibility(0);
                }
                com.tencent.mm.plugin.luckymoney.ui.g.c cVar = new com.tencent.mm.plugin.luckymoney.ui.g.c();
                cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhY);
                com.tencent.mm.plugin.luckymoney.ui.g.a(this, this.ola, wVar.oiO, cVar);
            }
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aXX()), Integer.valueOf(5));
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.olg && !bi.oN(stringExtra)) {
                        com.tencent.mm.ui.base.h.bu(this, getString(i.epo));
                        Map y = bj.y(this.olh, "msg");
                        if (y != null) {
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
                            break;
                        }
                        x.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        return;
                    }
                    aYf();
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            SnsLuckyMoneyPrepareUI.this.okY.setVisibility(0);
                            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(800);
                            scaleAnimation.setStartOffset(200);
                            scaleAnimation.setInterpolator(new BounceInterpolator());
                            SnsLuckyMoneyPrepareUI.this.findViewById(com.tencent.mm.plugin.wxpay.a.f.uvF).startAnimation(scaleAnimation);
                        }
                    }, 200);
                    this.lMM.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            g.pWK.h(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.aXX()), Integer.valueOf(6));
                            n.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.this.mType, SnsLuckyMoneyPrepareUI.this.olf, false);
                            SnsLuckyMoneyPrepareUI.this.okY.postDelayed(new Runnable() {
                                public final void run() {
                                    SnsLuckyMoneyPrepareUI.this.okY.setVisibility(8);
                                    SnsLuckyMoneyPrepareUI.this.aYe();
                                }
                            }, 100);
                        }
                    });
                    ((ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvy)).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            SnsLuckyMoneyPrepareUI.this.okY.setVisibility(8);
                            SnsLuckyMoneyPrepareUI.this.aYe();
                        }
                    });
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
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.uDo);
        this.okX = findViewById(com.tencent.mm.plugin.wxpay.a.f.uDn);
        View findViewById = findViewById(com.tencent.mm.plugin.wxpay.a.f.ivH);
        EditText editText = (EditText) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uua);
        if (this.mKeyboard != null && editText != null && this.okX != null) {
            com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new AnonymousClass10(false, i, editText));
            editText.setOnClickListener(new AnonymousClass12(false, i, editText));
            TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.utd);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass13(false, i, editText));
            }
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SnsLuckyMoneyPrepareUI.this.Xj();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.okX == null || !this.okX.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        Xj();
        return true;
    }

    protected final void Xj() {
        if (this.okX != null && this.okX.isShown()) {
            this.okX.setVisibility(8);
            this.olj.hE(false);
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
                boolean z2;
                if (this.mType == 0) {
                    if (d > this.ohp.ohj && this.ohp.ohj > 0.0d) {
                        this.olc.sC(getString(i.uRg, new Object[]{Math.round(this.ohp.ohj), bi.aD(this.ohp.oho, "")}));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (d > this.ohp.ohk && this.ohp.ohk > 0.0d) {
                        this.olc.sC(getString(i.uRg, new Object[]{Math.round(this.ohp.ohk), bi.aD(this.ohp.oho, "")}));
                        this.okU.onError();
                        this.okV.onError();
                        z2 = true;
                    }
                    z2 = false;
                }
                if (!z2) {
                    if (this.mType == 0) {
                        if (d < this.ohp.ohl) {
                            this.olc.sC(getString(i.uRh, new Object[]{com.tencent.mm.wallet_core.ui.e.t(this.ohp.ohl), bi.aD(this.ohp.oho, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.olc.sC(getString(i.uRh, new Object[]{"0.01", bi.aD(this.ohp.oho, "")}));
                        this.okU.onError();
                        this.okV.onError();
                        z = true;
                    }
                }
                z = z2;
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
        this.lrX.setText(com.tencent.mm.wallet_core.ui.e.u(d2));
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
}
