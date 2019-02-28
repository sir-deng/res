package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;

public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private int yiU;
    private int[] yiV;
    public EditText yiY;
    public EditText yiZ;
    private String yja;
    private String yjb;
    private final int yjc;
    private a yjd;

    public interface a {
    }

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.yiU = -1;
        this.yja = "";
        this.yjb = "";
        this.yjc = 13;
        this.yjd = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faw, i, 0);
        this.yiU = obtainStyledAttributes.getResourceId(m.haM, -1);
        obtainStyledAttributes.recycle();
        v.fw(context).inflate(h.gZi, this);
        this.mContext = context;
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.yiY = (EditText) findViewById(g.bZd);
        this.yiZ = (EditText) findViewById(g.gXE);
        if (this.yiY == null || this.yiZ == null) {
            x.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", this.yiY, this.yiZ);
        } else if (this.yiU != -1) {
            this.yiZ.setHint(this.yiU);
        }
        if (this.yiY != null && this.yiZ != null) {
            if (this.yiY.hasFocus() || this.yiZ.hasFocus()) {
                mr(true);
            } else {
                mr(false);
            }
            OnFocusChangeListener anonymousClass1 = new OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    if (view == MMFormMobileInputView.this.yiY || view == MMFormMobileInputView.this.yiZ) {
                        MMFormMobileInputView.this.mr(z);
                    }
                }
            };
            this.yiY.setOnFocusChangeListener(anonymousClass1);
            this.yiZ.setOnFocusChangeListener(anonymousClass1);
            this.yiZ.addTextChangedListener(new c(this.yiZ, null, 20));
            this.yiZ.addTextChangedListener(new TextWatcher() {
                private ap nMS = new ap();

                public final void afterTextChanged(Editable editable) {
                    int selectionEnd = MMFormMobileInputView.this.yiZ.getSelectionEnd();
                    String obj = MMFormMobileInputView.this.yiZ.getText().toString();
                    String substring = MMFormMobileInputView.this.yiZ.getText().toString().substring(0, selectionEnd);
                    if (obj != null && !obj.equals(MMFormMobileInputView.this.yja)) {
                        String obj2 = MMFormMobileInputView.this.yiY.getText().toString();
                        MMFormMobileInputView.this.yja = ap.formatNumber(obj2.replace("+", ""), obj);
                        MMFormMobileInputView.this.yjb = ap.formatNumber(obj2.replace("+", ""), substring);
                        if (!obj.equals(MMFormMobileInputView.this.yja)) {
                            MMFormMobileInputView.this.yiZ.setText(MMFormMobileInputView.this.yja);
                            int length = MMFormMobileInputView.this.yiZ.getText().toString().length();
                            if (substring != null) {
                                try {
                                    MMFormMobileInputView.this.yjb = ap.formatNumber(obj2.replace("+", ""), substring);
                                    if (obj.length() > 13 && selectionEnd <= length) {
                                        MMFormMobileInputView.this.yiZ.setSelection(substring.toString().length());
                                        return;
                                    } else if (selectionEnd > length || MMFormMobileInputView.this.yjb.toString().length() > length) {
                                        MMFormMobileInputView.this.yiZ.setSelection(length - Math.abs(obj.length() - selectionEnd));
                                        return;
                                    } else {
                                        MMFormMobileInputView.this.yiZ.setSelection(MMFormMobileInputView.this.yjb.toString().length());
                                        return;
                                    }
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.MMFormMobileInputView", e, "", new Object[0]);
                                    return;
                                }
                            }
                            MMFormMobileInputView.this.yiZ.setSelection(0);
                        }
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.yiY.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    String obj = MMFormMobileInputView.this.yiY.getText().toString();
                    if (bi.oN(obj)) {
                        MMFormMobileInputView.this.yiY.setText("+");
                        MMFormMobileInputView.this.yiY.setSelection(MMFormMobileInputView.this.yiY.getText().toString().length());
                    } else if (!obj.contains("+")) {
                        MMFormMobileInputView.this.yiY.setText("+" + obj);
                        MMFormMobileInputView.this.yiY.setSelection(MMFormMobileInputView.this.yiY.getText().toString().length());
                    } else if (obj.length() > 1) {
                        obj = obj.substring(1);
                        if (obj.length() > 4) {
                            MMFormMobileInputView.this.yiY.setText(obj.substring(0, 4));
                        }
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
    }

    public final void mr(boolean z) {
        dl(this.yiY);
        if (z) {
            this.yiY.setBackgroundResource(f.bDg);
        } else {
            this.yiY.setBackgroundResource(f.bDh);
        }
        dm(this.yiY);
        dl(this.yiZ);
        if (z) {
            this.yiZ.setBackgroundResource(f.bDg);
        } else {
            this.yiZ.setBackgroundResource(f.bDh);
        }
        dm(this.yiZ);
    }

    private void dl(View view) {
        this.yiV = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
    }

    private void dm(View view) {
        if (this.yiV != null) {
            view.setPadding(this.yiV[0], this.yiV[1], this.yiV[2], this.yiV[3]);
        }
    }

    public final String getCountryCode() {
        if (this.yiY != null) {
            return this.yiY.getText().toString().trim();
        }
        return "";
    }
}
