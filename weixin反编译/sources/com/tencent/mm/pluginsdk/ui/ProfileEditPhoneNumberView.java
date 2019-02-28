package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a {
    public String vrq;
    public String vrr;
    public String[] vrs;
    private LinearLayout vrt;
    private boolean vru = false;
    public a vrv;

    public interface a {
        void asP();

        void cbc();
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bkr() {
        return R.i.dpP;
    }

    public final void init() {
        this.vrt = (LinearLayout) findViewById(R.h.cuT);
    }

    public void clearFocus() {
        for (int i = 1; i < this.vrt.getChildCount(); i++) {
            this.vrt.getChildAt(i).clearFocus();
        }
    }

    public final boolean M(x xVar) {
        this.lLc = xVar;
        return true;
    }

    public final boolean bks() {
        int i;
        int i2;
        if (bi.oN(this.vrq)) {
            i = 0;
            i2 = 0;
        } else {
            bc(this.vrq, true);
            i = 1;
            i2 = 1;
        }
        if (!bi.oN(this.vrr)) {
            this.vrs = this.vrr.split(",");
            while (i2 < this.vrs.length + i) {
                bc(this.vrs[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            bc(null, false);
            this.vru = false;
        } else {
            this.vru = true;
        }
        return false;
    }

    public final ArrayList<String> cba() {
        int childCount = this.vrt.getChildCount();
        if (childCount == 1) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.vrt.getChildAt(i)).getText().toString();
            if (!bi.oN(obj)) {
                arrayList.add(obj);
            }
        }
        if (!bi.oN(this.vrq)) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    private void cbb() {
        if (this.vrv != null) {
            this.vrv.asP();
        }
    }

    public final void f(final MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (mMPhoneNumberEditText.vqX) {
            h.a(getContext(), R.l.epu, 0, R.l.ept, R.l.eps, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ProfileEditPhoneNumberView.this.vrq = "";
                    ProfileEditPhoneNumberView.this.vrv.cbc();
                    ProfileEditPhoneNumberView.this.h(mMPhoneNumberEditText);
                    if (!ProfileEditPhoneNumberView.this.vru) {
                        ProfileEditPhoneNumberView.this.bc(null, false);
                    }
                }
            }, null);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.vru) {
            bc(null, false);
            this.vru = false;
        }
        cbb();
    }

    public final void caV() {
        cbb();
    }

    public final void caU() {
        if (this.vrt.getChildCount() - 1 < 5) {
            bc(null, false);
        } else {
            this.vru = true;
        }
        cbb();
    }

    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (this.vrt.getChildCount() - 1 != 1) {
            h(mMPhoneNumberEditText);
            if (this.vru) {
                bc(null, false);
            }
            this.vru = false;
            cbb();
        }
    }

    private void bc(String str, boolean z) {
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(R.i.dpO, null);
        mMPhoneNumberEditText.setHint(ad.getResources().getString(R.l.dCH));
        if (z) {
            mMPhoneNumberEditText.vqX = true;
            mMPhoneNumberEditText.vqV = mMPhoneNumberEditText.getResources().getDrawable(R.k.dza);
            mMPhoneNumberEditText.vqV.setBounds(0, 0, mMPhoneNumberEditText.vqV.getIntrinsicWidth(), mMPhoneNumberEditText.vqV.getIntrinsicHeight());
            mMPhoneNumberEditText.setFocusable(false);
            mMPhoneNumberEditText.caS();
        }
        mMPhoneNumberEditText.vqW = this;
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, com.tencent.mm.bu.a.fromDPToPix(getContext(), 12), 0, 0);
        this.vrt.addView(mMPhoneNumberEditText, layoutParams);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.vrt.removeView(mMPhoneNumberEditText);
        this.vrt.getChildAt(this.vrt.getChildCount() - 1).requestFocus();
    }
}
