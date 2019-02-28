package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    public String jhM;
    private String kav;
    public String nVO;
    public String nVP;
    public int nVQ;
    private int nVR;
    public boolean nVS;
    public MMEditText nVT;
    private ImageView nVU;
    public TextView nVV;
    private int nVW;
    public a nVX;

    public interface a {
        void Eb(String str);

        void gm(boolean z);
    }

    class b implements InputFilter {
        public final char[] nVZ = new char[]{10, ',', ';', 12289, 65292, 65307};

        b() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            x.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4));
            int i5 = i;
            while (i5 < i2) {
                char[] cArr = new char[(i2 - i)];
                TextUtils.getChars(charSequence, i, i2, cArr, 0);
                for (char c : this.nVZ) {
                    if (cArr[i5] == ' ' && i3 == 0 && i5 == 0) {
                        return "";
                    }
                    if (cArr[i5] == c) {
                        InputClearablePreference.this.go(true);
                        return "";
                    }
                }
                i5++;
            }
            return null;
        }
    }

    static /* synthetic */ void a(InputClearablePreference inputClearablePreference, boolean z) {
        if (inputClearablePreference.nVU == null) {
            return;
        }
        if (z) {
            inputClearablePreference.nVU.setVisibility(0);
        } else {
            inputClearablePreference.nVU.setVisibility(8);
        }
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        this.kav = str;
        if (this.nVT != null && !bi.oN(str)) {
            this.nVT.setText(i.c(this.mContext, this.kav, this.nVW));
            Ed(this.kav);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.nVW = com.tencent.mm.bu.a.aa(this.mContext, R.f.bvt);
        this.nVT = (MMEditText) view.findViewById(R.h.cdl);
        this.nVU = (ImageView) view.findViewById(R.h.caM);
        this.nVV = (TextView) view.findViewById(R.h.ceN);
        if (this.nVT != null) {
            if (this.nVR > 0) {
                this.nVT.setFilters(new InputFilter[]{new LengthFilter(this.nVR), new b()});
            } else {
                this.nVT.setFilters(new InputFilter[]{new b()});
            }
        }
        this.nVT.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    x.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", charSequence.toString());
                    if (InputClearablePreference.this.nVX != null) {
                        InputClearablePreference.this.nVX.Eb(charSequence.toString());
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                if (editable != null) {
                    String obj = editable.toString();
                    InputClearablePreference.this.Ed(obj);
                    InputClearablePreference inputClearablePreference = InputClearablePreference.this;
                    if (!bi.oN(obj)) {
                        z = true;
                    }
                    InputClearablePreference.a(inputClearablePreference, z);
                    InputClearablePreference.this.kav = obj;
                    return;
                }
                InputClearablePreference.a(InputClearablePreference.this, false);
            }
        });
        x.d("MicroMsg.Label.InputClearablePreference", "mText %s", this.kav);
        setText(this.kav);
        if (!bi.oN(this.kav)) {
            this.nVT.setSelection(this.kav.length());
        }
        if (this.nVS) {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    if (InputClearablePreference.this.nVT != null) {
                        InputMethodManager inputMethodManager = (InputMethodManager) InputClearablePreference.this.nVT.getContext().getSystemService("input_method");
                        InputClearablePreference.this.nVT.requestFocus();
                        inputMethodManager.showSoftInput(InputClearablePreference.this.nVT, 0);
                        InputClearablePreference.this.nVT.setCursorVisible(false);
                        InputClearablePreference.this.nVT.setCursorVisible(true);
                    }
                }
            }, 0);
        }
        this.nVT.setHint(this.nVO);
        this.nVU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (InputClearablePreference.this.nVT != null) {
                    InputClearablePreference.this.nVT.setText("");
                    InputClearablePreference.this.kav = "";
                }
            }
        });
        if (this.nVV != null) {
            this.nVV.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (InputClearablePreference.this.nVT != null) {
                        InputClearablePreference.this.nVT.clearFocus();
                    }
                    return false;
                }
            });
        }
    }

    private void Ed(String str) {
        boolean z = true;
        if (!bi.oN(str)) {
            int aaF = h.aaF(str);
            boolean z2 = aaF > this.nVQ;
            int be = h.be(this.nVQ, "");
            int bf = h.bf(this.nVQ, str);
            if (this.nVV != null) {
                if (z2) {
                    this.nVV.setText(String.format(this.jhM, new Object[]{Integer.valueOf(be), Integer.valueOf(bf)}));
                    this.nVV.setVisibility(0);
                } else {
                    this.nVV.setVisibility(8);
                }
            }
            if (this.nVX != null) {
                a aVar = this.nVX;
                if (aaF > this.nVQ) {
                    z = false;
                }
                aVar.gm(z);
            }
        }
    }

    public final void go(boolean z) {
        if (this.nVV == null) {
            return;
        }
        if (z) {
            this.nVV.setText(this.nVP);
            this.nVV.setVisibility(0);
            return;
        }
        this.nVV.setVisibility(8);
    }
}
