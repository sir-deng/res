package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.v.a.f;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable vqV = getResources().getDrawable(f.bDp);
    public a yhZ;

    private class a implements TextWatcher {
        private String yib;

        public a(String str) {
            this.yib = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().endsWith(this.yib)) {
                MMAutoCompleteTextView.this.showDropDown();
            }
        }
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vqV.setBounds(0, 0, this.vqV.getIntrinsicWidth(), this.vqV.getIntrinsicHeight());
        caR();
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMAutoCompleteTextView mMAutoCompleteTextView = MMAutoCompleteTextView.this;
                if (mMAutoCompleteTextView.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - MMAutoCompleteTextView.this.vqV.getIntrinsicWidth()))) {
                    mMAutoCompleteTextView.setText("");
                    MMAutoCompleteTextView.this.caT();
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MMAutoCompleteTextView.this.caR();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                MMAutoCompleteTextView.this.caR();
            }
        });
    }

    private void caR() {
        if (getText().toString().equals("") || !isFocused()) {
            caT();
        } else {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vqV, getCompoundDrawables()[3]);
        }
    }

    private void caT() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }
}
