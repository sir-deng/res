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
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.m;

public class MMFormInputView extends LinearLayout {
    private TextView ikL;
    private int layout;
    private Context mContext;
    public EditText pwv;
    private int vju;
    private int yiU;
    private int[] yiV;
    public OnFocusChangeListener yiW;

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        if (mMFormInputView.yiV != null) {
            mMFormInputView.setPadding(mMFormInputView.yiV[0], mMFormInputView.yiV[1], mMFormInputView.yiV[2], mMFormInputView.yiV[3]);
        }
    }

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.vju = -1;
        this.yiU = -1;
        this.layout = -1;
        this.yiW = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faw, i, 0);
        this.yiU = obtainStyledAttributes.getResourceId(m.haM, -1);
        this.vju = obtainStyledAttributes.getResourceId(m.haL, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.haK, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.ikL = (TextView) findViewById(g.title);
        this.pwv = (EditText) findViewById(g.cdl);
        if (this.ikL == null || this.pwv == null) {
            x.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.ikL, this.pwv);
        } else {
            if (this.vju != -1) {
                this.ikL.setText(this.vju);
            }
            if (this.yiU != -1) {
                this.pwv.setHint(this.yiU);
            }
        }
        if (this.pwv != null) {
            this.pwv.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    if (view == MMFormInputView.this.pwv) {
                        MMFormInputView.this.yiV = new int[]{MMFormInputView.this.getPaddingLeft(), MMFormInputView.this.getPaddingTop(), MMFormInputView.this.getPaddingRight(), MMFormInputView.this.getPaddingBottom()};
                        if (z) {
                            MMFormInputView.this.setBackgroundResource(f.bDg);
                        } else {
                            MMFormInputView.this.setBackgroundResource(f.bDh);
                        }
                        MMFormInputView.c(MMFormInputView.this);
                    }
                    if (MMFormInputView.this.yiW != null) {
                        MMFormInputView.this.yiW.onFocusChange(view, z);
                    }
                }
            });
        }
    }

    public final void setText(String str) {
        if (this.pwv != null) {
            this.pwv.setText(str);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void setInputType(int i) {
        if (this.pwv != null) {
            this.pwv.setInputType(i);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher == null || this.pwv == null) {
            x.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.pwv);
            return;
        }
        this.pwv.addTextChangedListener(textWatcher);
    }

    public final Editable getText() {
        if (this.pwv != null) {
            return this.pwv.getText();
        }
        x.e("MicroMsg.MMFormInputView", "contentET is null!");
        return null;
    }
}
