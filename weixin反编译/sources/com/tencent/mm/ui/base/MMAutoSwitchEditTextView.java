package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int lzS = 100;
    private Context mContext;
    private int mScreenWidth;
    private int nVQ;
    private int pPa;
    private int yij;
    private String yik;
    public ArrayList<MMAutoSwitchEditText> yil = new ArrayList();
    private c yim = new c();
    public a yin;
    public b yio;

    public interface b {
        void coy();
    }

    public interface a {
        void Za(String str);
    }

    private class c implements com.tencent.mm.ui.base.MMAutoSwitchEditText.b, com.tencent.mm.ui.base.MMAutoSwitchEditText.c, d {
        private c() {
        }

        /* synthetic */ c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView, byte b) {
            this();
        }

        public final void EY(int i) {
            MMAutoSwitchEditText mMAutoSwitchEditText;
            String str = "";
            Iterator it = MMAutoSwitchEditTextView.this.yil.iterator();
            while (it.hasNext()) {
                String str2;
                mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (bi.oN(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (bi.oN(str) || str.length() != MMAutoSwitchEditTextView.this.yij * MMAutoSwitchEditTextView.this.nVQ) {
                if (MMAutoSwitchEditTextView.this.yio != null) {
                    MMAutoSwitchEditTextView.this.yio.coy();
                }
                if (MMAutoSwitchEditTextView.this.yil != null && i < MMAutoSwitchEditTextView.this.yil.size() - 1) {
                    mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.yil.get(i + 1);
                    if (mMAutoSwitchEditText != null) {
                        mMAutoSwitchEditText.requestFocus();
                    }
                }
            } else if (MMAutoSwitchEditTextView.this.yin != null) {
                MMAutoSwitchEditTextView.this.yin.Za(str);
            }
        }

        public final void EX(int i) {
            if (MMAutoSwitchEditTextView.this.yil != null && i < MMAutoSwitchEditTextView.this.yil.size() && i != 0) {
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.yil.get(i - 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
        }

        public final void cpI() {
            String str = "";
            Iterator it = MMAutoSwitchEditTextView.this.yil.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (bi.oN(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (MMAutoSwitchEditTextView.this.yio != null) {
                MMAutoSwitchEditTextView.this.yio.coy();
            }
        }
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.eZM);
        this.yij = obtainStyledAttributes.getInteger(m.haC, 3);
        this.nVQ = obtainStyledAttributes.getInteger(m.haD, 4);
        this.pPa = obtainStyledAttributes.getInteger(m.haE, 2);
        int resourceId = obtainStyledAttributes.getResourceId(m.haF, 0);
        if (resourceId != 0) {
            this.yik = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.lzS = ((this.mScreenWidth - 80) - ((this.yij - 1) * 20)) / this.yij;
        }
        setPadding(com.tencent.mm.bu.a.fromDPToPix(context, 20), 0, com.tencent.mm.bu.a.fromDPToPix(context, 20), 0);
        cpJ();
    }

    private void cpJ() {
        for (int i = 0; i < this.yij; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, h.gYL, null);
            mMAutoSwitchEditText.setInputType(this.pPa);
            if (this.yik != null && this.yik.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.yik));
            }
            mMAutoSwitchEditText.yie.mIndex = i;
            mMAutoSwitchEditText.yie.yii = this.nVQ;
            mMAutoSwitchEditText.yie.yif = this.yim;
            mMAutoSwitchEditText.yie.yig = this.yim;
            mMAutoSwitchEditText.yie.yih = this.yim;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lzS, -2);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.yil.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
    }
}
