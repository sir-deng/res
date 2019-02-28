package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bw.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MMPhoneNumberEditText extends EditText {
    public String khu = "";
    private OnFocusChangeListener pJU = null;
    int uar = 0;
    public boolean vqU = false;
    public Drawable vqV;
    a vqW;
    public boolean vqX;
    private boolean vqY = false;

    public interface a {
        void caU();

        void caV();

        void f(MMPhoneNumberEditText mMPhoneNumberEditText);

        void g(MMPhoneNumberEditText mMPhoneNumberEditText);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.vqV = getResources().getDrawable(R.g.bDp);
        this.vqV.setBounds(0, 0, this.vqV.getIntrinsicWidth(), this.vqV.getIntrinsicHeight());
        x.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vqV.getIntrinsicWidth()), Integer.valueOf(this.vqV.getIntrinsicHeight()));
        caR();
        setHeight(this.vqV.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.f.bvM) * 5));
        clearFocus();
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMPhoneNumberEditText mMPhoneNumberEditText = MMPhoneNumberEditText.this;
                if (mMPhoneNumberEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - MMPhoneNumberEditText.this.vqV.getIntrinsicWidth()))) {
                    if (mMPhoneNumberEditText.isFocused()) {
                        mMPhoneNumberEditText.setText("");
                        mMPhoneNumberEditText.caT();
                    } else if (MMPhoneNumberEditText.this.vqW != null) {
                        MMPhoneNumberEditText.this.vqW.f(mMPhoneNumberEditText);
                    }
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MMPhoneNumberEditText.this.caR();
                if (!charSequence.toString().equals("") || MMPhoneNumberEditText.this.vqY) {
                    if (charSequence.toString().equals("") || !MMPhoneNumberEditText.this.vqY) {
                        if (MMPhoneNumberEditText.this.vqW != null && MMPhoneNumberEditText.this.isFocused()) {
                            MMPhoneNumberEditText.this.vqW.caV();
                        }
                    } else if (MMPhoneNumberEditText.this.vqW != null && MMPhoneNumberEditText.this.isFocused()) {
                        MMPhoneNumberEditText.this.vqW.caU();
                    }
                } else if (MMPhoneNumberEditText.this.vqW != null && MMPhoneNumberEditText.this.isFocused()) {
                    MMPhoneNumberEditText.this.vqW.g(MMPhoneNumberEditText.this);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (bi.oN(charSequence.toString())) {
                    MMPhoneNumberEditText.this.vqY = true;
                } else {
                    MMPhoneNumberEditText.this.vqY = false;
                }
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (MMPhoneNumberEditText.this.pJU != null) {
                    MMPhoneNumberEditText.this.pJU.onFocusChange(view, z);
                }
                MMPhoneNumberEditText.this.caR();
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
        setText(g.chT().a(getContext(), str, getTextSize()));
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
        if (getText().toString().equals("")) {
            caT();
        } else {
            caS();
        }
    }

    final void caS() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vqV, getCompoundDrawables()[3]);
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
