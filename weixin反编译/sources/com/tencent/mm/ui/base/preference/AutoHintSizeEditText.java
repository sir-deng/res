package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.e;

public class AutoHintSizeEditText extends EditText {
    private float yqs;
    private Paint yqt;
    private String yqu = "";
    private int yqv = Integer.MIN_VALUE;
    private float yqw;

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.yqs = getTextSize();
        this.yqw = this.yqs;
        this.yqt = new Paint(getPaint());
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AutoHintSizeEditText.this.a(editable, AutoHintSizeEditText.this.getHint(), (AutoHintSizeEditText.this.getWidth() - AutoHintSizeEditText.this.getPaddingLeft()) - AutoHintSizeEditText.this.getPaddingRight());
            }
        });
    }

    private void a(Editable editable, CharSequence charSequence, int i) {
        if (editable == null || bi.oN(editable.toString())) {
            if (charSequence != null && !bi.oN(charSequence.toString())) {
                String charSequence2 = charSequence.toString();
                if (!this.yqu.equals(charSequence2) || this.yqv != i) {
                    this.yqu = charSequence2;
                    this.yqv = i;
                    if (getPaint().measureText(charSequence2) > ((float) i)) {
                        int dimensionPixelSize = getResources().getDimensionPixelSize(e.bvX);
                        int fromDPToPix = a.fromDPToPix(getContext(), 1);
                        for (int i2 = ((int) this.yqs) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                            this.yqt.setTextSize((float) i2);
                            if (this.yqt.measureText(charSequence2) < ((float) i)) {
                                x.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", Integer.valueOf(i2));
                                this.yqw = (float) i2;
                                setTextSize(0, (float) i2);
                                return;
                            }
                        }
                    }
                } else if (getTextSize() != this.yqw) {
                    x.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", Float.valueOf(this.yqw));
                    setTextSize(0, this.yqw);
                }
            } else if (getTextSize() != this.yqs) {
                x.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", Float.valueOf(this.yqs));
                setTextSize(0, this.yqs);
            }
        } else if (getTextSize() != this.yqs) {
            x.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", Float.valueOf(this.yqs));
            setTextSize(0, this.yqs);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", Boolean.valueOf(z));
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
    }
}
