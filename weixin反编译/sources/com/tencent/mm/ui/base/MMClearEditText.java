package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.f;

public class MMClearEditText extends EditText {
    public String khu = "";
    private OnFocusChangeListener pJU = null;
    public OnTouchListener swC = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            MMClearEditText mMClearEditText = MMClearEditText.this;
            if (mMClearEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - MMClearEditText.this.vqV.getIntrinsicWidth()))) {
                mMClearEditText.setText("");
                MMClearEditText.this.caT();
            }
            return false;
        }
    };
    int uar = 0;
    public boolean vqU = false;
    final Drawable vqV = getResources().getDrawable(f.bDp);
    private boolean yiq = false;

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cpK();
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cpK();
    }

    private void cpK() {
        this.vqV.setBounds(0, 0, this.vqV.getIntrinsicWidth(), this.vqV.getIntrinsicHeight());
        x.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vqV.getIntrinsicWidth()), Integer.valueOf(this.vqV.getIntrinsicHeight()));
        caR();
        setHeight(this.vqV.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.bvM) * 5));
        setOnTouchListener(this.swC);
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MMClearEditText.this.caR();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (MMClearEditText.this.pJU != null) {
                    MMClearEditText.this.pJU.onFocusChange(view, z);
                }
                MMClearEditText.this.caR();
            }
        });
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.uar = 0;
            String obj = getText().toString();
            try {
                SK(obj);
            } catch (IndexOutOfBoundsException e) {
                x.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.uar));
                if (this.uar < 3) {
                    this.uar++;
                    SK(" " + obj);
                } else {
                    x.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void SK(String str) {
        int selectionStart = getSelectionStart();
        setText(b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pJU = onFocusChangeListener;
    }

    private void caR() {
        if (getText().toString().equals("") || !isFocused()) {
            caT();
        } else if (!this.yiq) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vqV, getCompoundDrawables()[3]);
        }
    }

    private void caT() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            if (!this.vqU) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
