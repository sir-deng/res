package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;
import junit.framework.Assert;

public final class WalletFormView extends LinearLayout implements OnFocusChangeListener {
    public TextView jOY;
    public TextView pJP;
    public WalletIconImageView pJR;
    public TextView pJS;
    private OnFocusChangeListener pJU;
    private OnClickListener pJV;
    private int pJY;
    private String pJZ;
    private int pKa;
    private String pKb;
    private int pKc;
    private int pKd;
    private int pKe;
    private String pKf;
    private int pKg;
    private String pKh;
    private int pKi;
    private int pKj;
    private String pKk;
    public int pKl;
    private int pKm;
    private int pKn;
    private boolean pKo;
    private boolean pKp;
    private boolean pKq;
    private int pKr;
    private int pKs;
    private int pKt;
    public TenpaySecureEditText zSS;
    public a zST;
    public com.tencent.mm.wallet_core.ui.formview.a.a zSU;
    public b zSV;
    private int zSW;
    public int zSX;
    private int zSY;
    @Deprecated
    private int zSZ;
    private int zTa;

    public interface a {
        void hB(boolean z);
    }

    public WalletFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.jOY = null;
        this.pJP = null;
        this.zSS = null;
        this.pJR = null;
        this.pJS = null;
        this.zST = null;
        this.pJU = null;
        this.pJV = null;
        this.zSU = null;
        this.zSV = null;
        this.pJY = -1;
        this.zSW = this.pJY;
        this.zSX = 100;
        this.pJZ = "";
        this.pKa = 0;
        this.pKb = "";
        this.pKc = 8;
        this.pKd = -1;
        this.pKe = 4;
        this.pKf = "";
        this.pKg = 8;
        this.pKh = "";
        this.pKi = 19;
        this.pKj = c.btv;
        this.pKk = "";
        this.zSY = 0;
        this.pKl = Integer.MAX_VALUE;
        this.pKm = 1;
        this.pKn = e.bDK;
        this.pKo = true;
        this.pKp = false;
        this.pKq = true;
        this.pKr = 1;
        this.pKs = 5;
        this.pKt = c.uhi;
        this.zSZ = 0;
        this.zTa = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.vgo, i, 0);
        this.pJY = obtainStyledAttributes.getResourceId(k.vgs, this.pJY);
        int resourceId = obtainStyledAttributes.getResourceId(k.vgu, 0);
        if (resourceId != 0) {
            this.pJZ = context.getString(resourceId);
        }
        this.pKd = obtainStyledAttributes.getResourceId(k.vgv, this.pKd);
        resourceId = obtainStyledAttributes.getResourceId(k.vgw, 0);
        if (resourceId != 0) {
            this.pKf = context.getString(resourceId);
        }
        this.pKe = obtainStyledAttributes.getInteger(k.vgx, this.pKe);
        this.pKa = obtainStyledAttributes.getInteger(k.vgy, this.pKa);
        this.pKg = obtainStyledAttributes.getInteger(k.vgz, this.pKg);
        this.pKc = obtainStyledAttributes.getInteger(k.vgA, this.pKc);
        resourceId = obtainStyledAttributes.getResourceId(k.vgB, 0);
        if (resourceId != 0) {
            this.pKb = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.vgC, 0);
        if (resourceId != 0) {
            this.pKh = context.getString(resourceId);
        }
        this.pKi = obtainStyledAttributes.getInteger(k.vgD, this.pKi);
        this.pKj = obtainStyledAttributes.getColor(k.vgE, this.pKj);
        resourceId = obtainStyledAttributes.getResourceId(k.vgF, 0);
        if (resourceId != 0) {
            this.pKk = context.getString(resourceId);
        }
        this.zSY = obtainStyledAttributes.getInt(k.vgG, this.zSY);
        this.pKl = obtainStyledAttributes.getInteger(k.vgH, this.pKl);
        this.pKm = obtainStyledAttributes.getInteger(k.vgI, this.pKm);
        this.pKn = obtainStyledAttributes.getResourceId(k.vgJ, this.pKn);
        this.pKo = obtainStyledAttributes.getBoolean(k.vgK, this.pKo);
        this.pKp = obtainStyledAttributes.getBoolean(k.vgL, this.pKp);
        this.pKq = obtainStyledAttributes.getBoolean(k.vgK, this.pKq);
        this.pKr = obtainStyledAttributes.getInteger(k.vgp, this.pKr);
        this.pKs = obtainStyledAttributes.getInteger(k.vgq, this.pKs);
        this.zSX = obtainStyledAttributes.getInteger(k.vgN, this.zSX);
        this.pKt = obtainStyledAttributes.getInteger(k.vgM, this.pKt);
        this.zSW = obtainStyledAttributes.getResourceId(k.vgt, this.zSW);
        this.zSZ = obtainStyledAttributes.getInteger(k.vgO, 0);
        this.zTa = obtainStyledAttributes.getInteger(k.vgr, -1);
        if (this.zSZ == 1 && this.zTa == -1) {
            this.zTa = 4;
        }
        obtainStyledAttributes.recycle();
        if (this.pJY > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        if (bi.oN(this.pJZ) || this.pJZ.length() <= 6) {
            inflate(context, this.pJY, this);
        } else {
            inflate(context, this.zSW, this);
        }
        this.jOY = (TextView) findViewById(f.uGK);
        this.pJP = (TextView) findViewById(f.uGv);
        this.zSS = (TenpaySecureEditText) findViewById(f.uFa);
        this.pJR = (WalletIconImageView) findViewById(f.uFw);
        this.pJS = (TextView) findViewById(f.uGJ);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void yb(String str) {
        this.pJZ = str;
        cDe();
    }

    public final void abs(String str) {
        if (this.zSS == null) {
            return;
        }
        if (this.zSV == null || !this.zSV.d(this, str)) {
            this.zSS.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
    }

    public final String cDc() {
        String oM = bi.oM(this.zSS.getText().toString());
        if (this.zSV != null && this.zSV.bnn()) {
            oM = this.zSV.e(this, oM);
        }
        return ac.VF(oM);
    }

    public final void setImeOptions(int i) {
        if (this.zSS != null) {
            this.zSS.setImeOptions(i);
        }
    }

    public final void setInputType(int i) {
        if (this.zSS != null) {
            this.zSS.setInputType(i);
        }
    }

    public final void setText(String str) {
        if (this.zSS == null) {
            return;
        }
        if (this.zSV == null || !this.zSV.c(this, str)) {
            this.zSS.setText(str);
            this.zSS.setSelection(getInputLength());
        }
    }

    @SuppressLint({"ResourceType"})
    public final void HZ(int i) {
        this.pKj = i;
        if (this.zSS != null) {
            this.zSS.setTextColor(getResources().getColor(this.pKj));
        }
    }

    public final void Ia(int i) {
        if (this.zSS != null) {
            this.zSS.setTextColor(i);
        }
    }

    private void bno() {
        if (this.pJR != null && !bi.oN(getText()) && this.zSS != null && this.zSS.isEnabled() && this.zSS.isClickable() && this.zSS.isFocusable() && this.zSS.isFocused()) {
            this.pJR.n(new OnClickListener() {
                public final void onClick(View view) {
                    WalletFormView.this.bnq();
                }
            });
        } else if (this.pJR != null) {
            this.pJR.cdF();
        } else {
            x.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    public final boolean cDd() {
        return this.zSS != null ? this.zSS.isFocusable() : false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        cDe();
        if (this.pJP != null) {
            this.pJP.setText(this.pKb);
            this.pJP.setVisibility(this.pKc);
        }
        if (this.pJR != null) {
            this.pJR.setImageResource(this.pKd);
            this.pJR.setVisibility(this.pKe);
        }
        if (this.pJS != null) {
            this.pJS.setText(this.pKf);
            this.pJS.setVisibility(this.pKg);
        }
        Context context = getContext();
        if (this.zSS != null) {
            if (this.zTa >= 0) {
                this.zSS.setTypeface(Typeface.createFromAsset(context.getAssets(), com.tencent.mm.wallet_core.ui.e.HV(this.zTa)));
            }
            this.zSS.setHint(this.pKh);
            this.zSS.setGravity(this.pKi);
            this.zSS.setTextColor(this.pKj);
            setText(this.pKk);
            b.a(this.zSS, this.zSY);
            this.zSS.setBackgroundResource(this.pKn);
            this.zSS.setEnabled(this.pKo);
            this.zSS.setFocusable(this.pKq);
            this.zSS.setClickable(this.pKp);
            this.zSS.setHintTextColor(this.pKt);
            setImeOptions(this.pKs);
            setInputType(this.pKr);
            this.zSS.addTextChangedListener(new TextWatcher() {
                private boolean pKv = false;

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    boolean XX = WalletFormView.this.XX();
                    if (!(WalletFormView.this.zST == null || XX == this.pKv)) {
                        WalletFormView.this.zST.hB(XX);
                        this.pKv = WalletFormView.this.XX();
                    }
                    WalletFormView.this.bno();
                }
            });
            this.zSS.setOnFocusChangeListener(this);
        }
        bno();
        if (this.zSS != null) {
            if (this.pKr == 2) {
                this.zSS.setKeyListener(new NumberKeyListener() {
                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.pKr == 4) {
                this.zSS.setKeyListener(new NumberKeyListener() {
                    public final int getInputType() {
                        return 1;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.pKr == FileUtils.S_IWUSR) {
                this.zSS.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.zSS.setKeyListener(new NumberKeyListener() {
                    public final int getInputType() {
                        return 18;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.zSS.setRawInputType(18);
            } else if (this.pKr == 3) {
                this.zSS.setKeyListener(new NumberKeyListener() {
                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    }
                });
            } else {
                this.zSS.setInputType(this.pKr);
            }
            if (this.pKl != -1) {
                this.zSS.setFilters(new InputFilter[]{new LengthFilter(this.pKl)});
            }
        }
        if (this.zSU != null) {
            this.zSU.bKc();
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.zSS != null) {
            this.zSS.setHint(charSequence);
        }
    }

    public final void nS(boolean z) {
        if (this.zSS != null) {
            this.zSS.setEnabled(z);
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.zSS.setOnEditorActionListener(onEditorActionListener);
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zSU != null && this.zSU.a(this, motionEvent)) {
            return true;
        }
        if (this.zSS != null && a(this.zSS, motionEvent) && !this.zSS.isClickable()) {
            x.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!a(this.pJR, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            x.d("MicroMsg.WalletFormView", "hy: click on info iv");
            bno();
            this.pJR.performClick();
            return true;
        }
    }

    final boolean a(View view, MotionEvent motionEvent) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect;
        if (view != null) {
            rect = new Rect();
            view.getHitRect(rect);
            if (view == this.pJR) {
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
            }
        } else {
            rect = null;
        }
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return false;
    }

    private void cDe() {
        if (this.jOY != null) {
            this.jOY.setText(this.pJZ);
            this.jOY.setVisibility(this.pKa);
        }
    }

    public final void setSelection(int i) {
        if (this.zSS != null) {
            this.zSS.setSelection(i);
        }
    }

    public final String getText() {
        if (this.zSS != null) {
            String a = com.tencent.mm.wallet_core.ui.formview.c.a.a(this.zSX, this.zSS);
            if (this.zSV == null || !this.zSV.bnn()) {
                return a;
            }
            return this.zSV.e(this, a);
        }
        x.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final KeyListener getKeyListener() {
        if (this.zSS != null) {
            return this.zSS.getKeyListener();
        }
        x.w("MicroMsg.WalletFormView", "hy: no content et");
        return null;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void q(OnClickListener onClickListener) {
        this.pJV = onClickListener;
        if (this.pJR != null) {
            this.pJR.setOnClickListener(this.pJV);
        }
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pJU = onFocusChangeListener;
    }

    public final void a(TextWatcher textWatcher) {
        if (this.zSS != null) {
            this.zSS.addTextChangedListener(textWatcher);
        }
    }

    public final void setKeyListener(KeyListener keyListener) {
        if (this.zSS != null) {
            this.zSS.setKeyListener(keyListener);
        }
    }

    public final boolean XX() {
        if (this.zSS != null) {
            int inputLength = this.zSS.getInputLength();
            if (inputLength > this.pKl || inputLength < this.pKm) {
                return false;
            }
            if (this.zSV != null) {
                return this.zSV.h(this);
            }
            return true;
        }
        x.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        return true;
    }

    public final void bnq() {
        if (this.zSS != null) {
            this.zSS.ClearInput();
        }
    }

    public final void bnp() {
        if (this.zSS != null) {
            this.zSS.clearFocus();
        }
    }

    public final boolean dQ(View view) {
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            return true;
        } else if (bi.oN(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.jOY == null) {
                return false;
            }
            this.jOY.setEnabled(true);
            return false;
        } else if (XX()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.jOY != null) {
                this.jOY.setEnabled(true);
            }
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.jOY == null) {
                return false;
            }
            this.jOY.setEnabled(false);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.zSS != null) {
            this.zSS.setFilters(inputFilterArr);
        }
    }

    private int getInputLength() {
        return this.zSS != null ? this.zSS.getInputLength() : 0;
    }

    public final void cDf() {
        if (this.zSS != null) {
            this.zSS.setFocusable(true);
            this.zSS.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.zSS, 0);
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.pJU != null) {
            this.pJU.onFocusChange(this, z);
        }
        if (this.zST != null) {
            this.zST.hB(XX());
        }
        if (XX()) {
            if (this.jOY != null) {
                this.jOY.setEnabled(true);
            }
        } else if (this.jOY != null) {
            this.jOY.setEnabled(false);
        }
        bno();
    }
}
