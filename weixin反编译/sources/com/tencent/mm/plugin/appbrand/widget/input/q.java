package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

final class q extends p {
    public q(Context context) {
        super(context);
        super.setKeyListener(new NumberKeyListener() {
            protected final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', 'X', 'x'};
            }

            public final int getInputType() {
                return (q.this.keB ? 16 : 0) | 2;
            }
        });
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (inputFilterArr == null) {
            inputFilterArr = new InputFilter[0];
        }
        InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
        while (i < inputFilterArr.length) {
            inputFilterArr2[i] = inputFilterArr[i];
            i++;
        }
        inputFilterArr2[i] = new AllCaps();
        super.setFilters(inputFilterArr2);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public final void dz(boolean z) {
        anM();
        int inputType = getInputType() | 2;
        if (z) {
            inputType |= 16;
        } else {
            inputType &= -17;
        }
        setInputType(inputType);
        super.dz(z);
        anN();
    }

    public final View getInputPanel() {
        return t.bW(this);
    }

    public final void ant() {
        t.bW(this).setInputEditText(this);
        b.c(this);
    }
}
