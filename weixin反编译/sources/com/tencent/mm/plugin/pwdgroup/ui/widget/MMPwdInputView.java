package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMPwdInputView extends LinearLayout {
    public StringBuilder lke;
    public int msL;
    private boolean psP;
    private ImageView psQ;
    private ImageView psR;
    private ImageView psS;
    private ImageView psT;
    public a psU;
    private int psV;

    public interface a {
        void h(boolean z, String str);
    }

    public enum b {
        ;

        static {
            psW = 1;
            psX = 2;
            psY = new int[]{psW, psX};
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lke = new StringBuilder();
        this.psP = false;
        this.psV = b.psX;
        View inflate = inflate(getContext(), R.i.dpX, null);
        this.psQ = (ImageView) inflate.findViewById(R.h.cif);
        this.psR = (ImageView) inflate.findViewById(R.h.second);
        this.psS = (ImageView) inflate.findViewById(R.h.cQU);
        this.psT = (ImageView) inflate.findViewById(R.h.cjg);
        this.psQ.setImageResource(R.g.bzk);
        this.psR.setImageResource(R.g.bzk);
        this.psS.setImageResource(R.g.bzk);
        this.psT.setImageResource(R.g.bzk);
        addView(inflate);
    }

    public final void bkB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 4) {
                String str;
                if (this.msL > i2) {
                    str = this.lke.toString().charAt(i2);
                } else {
                    str = "";
                }
                switch (i2) {
                    case 0:
                        n(this.psQ, str);
                        break;
                    case 1:
                        n(this.psR, str);
                        break;
                    case 2:
                        n(this.psS, str);
                        break;
                    case 3:
                        n(this.psT, str);
                        break;
                    default:
                        break;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static void n(ImageView imageView, String str) {
        if (imageView != null) {
            if (str.equals("0")) {
                imageView.setImageResource(R.g.bza);
            } else if (str.equals("1")) {
                imageView.setImageResource(R.g.bzb);
            } else if (str.equals("2")) {
                imageView.setImageResource(R.g.bzc);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                imageView.setImageResource(R.g.bzd);
            } else if (str.equals("4")) {
                imageView.setImageResource(R.g.bze);
            } else if (str.equals("5")) {
                imageView.setImageResource(R.g.bzf);
            } else if (str.equals("6")) {
                imageView.setImageResource(R.g.bzg);
            } else if (str.equals("7")) {
                imageView.setImageResource(R.g.bzh);
            } else if (str.equals("8")) {
                imageView.setImageResource(R.g.bzi);
            } else if (str.equals("9")) {
                imageView.setImageResource(R.g.bzj);
            } else {
                imageView.setImageResource(R.g.bzk);
            }
        }
    }

    public final void bkC() {
        if (this.lke != null) {
            this.msL = this.lke.length();
        } else {
            this.msL = 0;
        }
        if (this.msL >= 4) {
            this.psP = true;
        } else {
            this.psP = false;
        }
        if (this.psU != null) {
            this.psU.h(this.psP, this.lke.toString());
        }
    }

    public final void TA() {
        if (this.msL > 0) {
            this.lke.delete(0, this.msL);
        }
        bkC();
        bkB();
    }

    public final void input(String str) {
        if (!TextUtils.isEmpty(str) && !this.psP) {
            this.lke.append(str);
            bkC();
            bkB();
        }
    }
}
