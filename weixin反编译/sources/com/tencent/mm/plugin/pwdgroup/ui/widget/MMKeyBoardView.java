package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMKeyBoardView extends LinearLayout implements OnClickListener, OnLongClickListener {
    private ColorStateList ek;
    private Context mContext;
    private float nDj;
    public a prV;
    private View psA;
    private View psB;
    private View psC;
    private View psD;
    private boolean psE;
    private int psF;
    private int psG;
    private int psH;
    private int psI;
    private int psJ;
    private int psK;
    private int psL;
    private int psM;
    private int psN;
    private Button psn;
    private Button pso;
    private Button psp;
    private Button psq;
    private Button psr;
    private Button pss;
    private Button pst;
    private Button psu;
    private Button psv;
    private Button psw;
    private ImageButton psx;
    private View psy;
    private View psz;

    public interface a {
        void TA();

        void delete();

        void input(String str);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.psE = true;
        this.mContext = context;
        this.psF = getResources().getDimensionPixelSize(R.f.bxH);
        this.psG = getResources().getDimensionPixelSize(R.f.bxI);
        this.nDj = (float) getResources().getDimensionPixelSize(R.f.bxJ);
        this.ek = getResources().getColorStateList(R.e.bsW);
        this.psH = getResources().getColor(R.e.bsV);
        this.psn = new Button(this.mContext);
        this.pso = new Button(this.mContext);
        this.psp = new Button(this.mContext);
        this.psq = new Button(this.mContext);
        this.psr = new Button(this.mContext);
        this.pss = new Button(this.mContext);
        this.pst = new Button(this.mContext);
        this.psu = new Button(this.mContext);
        this.psv = new Button(this.mContext);
        this.psw = new Button(this.mContext);
        this.psx = new ImageButton(this.mContext);
        this.psy = new View(this.mContext);
        this.psy = new View(this.mContext);
        this.psz = new View(this.mContext);
        this.psA = new View(this.mContext);
        this.psB = new View(this.mContext);
        this.psC = new View(this.mContext);
        this.psD = new View(this.mContext);
        this.psn.setBackgroundResource(R.g.bDn);
        this.pso.setBackgroundResource(R.g.bDn);
        this.psp.setBackgroundResource(R.g.bDn);
        this.psq.setBackgroundResource(R.g.bDn);
        this.psr.setBackgroundResource(R.g.bDn);
        this.pss.setBackgroundResource(R.g.bDn);
        this.pst.setBackgroundResource(R.g.bDn);
        this.psu.setBackgroundResource(R.g.bDn);
        this.psv.setBackgroundResource(R.g.bDn);
        this.pss.setBackgroundResource(R.g.bDn);
        this.psw.setBackgroundResource(R.g.bDn);
        this.psx.setBackgroundResource(R.g.bDn);
        this.psx.setImageResource(R.g.bDo);
        this.psn.setText("0");
        this.pso.setText("1");
        this.psp.setText("2");
        this.psq.setText(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        this.psr.setText("4");
        this.pss.setText("5");
        this.pst.setText("6");
        this.psu.setText("7");
        this.psv.setText("8");
        this.psw.setText("9");
        this.psn.setGravity(17);
        this.pso.setGravity(17);
        this.psp.setGravity(17);
        this.psq.setGravity(17);
        this.psr.setGravity(17);
        this.pss.setGravity(17);
        this.pst.setGravity(17);
        this.psu.setGravity(17);
        this.psv.setGravity(17);
        this.psw.setGravity(17);
        this.psn.setTextSize(0, this.nDj);
        this.pso.setTextSize(0, this.nDj);
        this.psp.setTextSize(0, this.nDj);
        this.psq.setTextSize(0, this.nDj);
        this.psr.setTextSize(0, this.nDj);
        this.pss.setTextSize(0, this.nDj);
        this.pst.setTextSize(0, this.nDj);
        this.psu.setTextSize(0, this.nDj);
        this.psv.setTextSize(0, this.nDj);
        this.psw.setTextSize(0, this.nDj);
        this.psn.setTextColor(this.ek);
        this.pso.setTextColor(this.ek);
        this.psp.setTextColor(this.ek);
        this.psq.setTextColor(this.ek);
        this.psr.setTextColor(this.ek);
        this.pss.setTextColor(this.ek);
        this.pst.setTextColor(this.ek);
        this.psu.setTextColor(this.ek);
        this.psv.setTextColor(this.ek);
        this.psw.setTextColor(this.ek);
        this.psn.setOnClickListener(this);
        this.pso.setOnClickListener(this);
        this.psp.setOnClickListener(this);
        this.psq.setOnClickListener(this);
        this.psr.setOnClickListener(this);
        this.pss.setOnClickListener(this);
        this.pst.setOnClickListener(this);
        this.psu.setOnClickListener(this);
        this.psv.setOnClickListener(this);
        this.psw.setOnClickListener(this);
        this.psx.setOnClickListener(this);
        this.psx.setOnLongClickListener(this);
        this.psy.setBackgroundColor(this.psH);
        this.psy.setBackgroundColor(this.psH);
        this.psz.setBackgroundColor(this.psH);
        this.psA.setBackgroundColor(this.psH);
        this.psB.setBackgroundColor(this.psH);
        this.psC.setBackgroundColor(this.psH);
        this.psD.setBackgroundColor(this.psH);
        addView(this.psn);
        addView(this.pso);
        addView(this.psp);
        addView(this.psq);
        addView(this.psr);
        addView(this.pss);
        addView(this.pst);
        addView(this.psu);
        addView(this.psv);
        addView(this.psw);
        addView(this.psx);
        addView(this.psy);
        addView(this.psz);
        addView(this.psA);
        addView(this.psB);
        addView(this.psC);
        addView(this.psD);
        post(new Runnable() {
            public final void run() {
                MMKeyBoardView.this.requestLayout();
            }
        });
    }

    protected void onDraw(Canvas canvas) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.psI = getWidth();
        this.psJ = getHeight();
        int i5 = -this.psG;
        int i6 = (this.psM - this.psG) + 1;
        int i7 = ((this.psM * 2) - this.psG) + 2;
        int i8 = this.psN + 2;
        int i9 = (this.psN * 2) + 3;
        int i10 = (this.psN * 3) + 4;
        this.pso.layout(i5, 1, this.psK + i5, this.psL + 1);
        this.psp.layout(i6, 1, this.psK + i6, this.psL + 1);
        this.psq.layout(i7, 1, this.psK + i7, this.psL + 1);
        this.psr.layout(i5, i8, this.psK + i5, this.psL + i8);
        this.pss.layout(i6, i8, this.psK + i6, this.psL + i8);
        this.pst.layout(i7, i8, this.psK + i7, this.psL + i8);
        this.psu.layout(i5, i9, this.psK + i5, this.psL + i9);
        this.psv.layout(i6, i9, this.psK + i6, this.psL + i9);
        this.psw.layout(i7, i9, this.psK + i7, this.psL + i9);
        this.psn.layout(i6, i10, this.psK + i6, this.psL + i10);
        this.psx.layout(i7, i10, this.psK + i7, this.psL + i10);
        this.psy.layout(0, this.psF + 1, this.psI, (this.psF + 1) + 1);
        this.psz.layout(0, this.psF + i8, this.psI, (i8 + this.psF) + 1);
        this.psA.layout(0, this.psF + i9, this.psI, (i9 + this.psF) + 1);
        this.psB.layout(0, this.psF + i10, this.psI, (this.psF + i10) + 1);
        this.psC.layout(this.psM + 1, this.psF, this.psM + 2, this.psJ);
        this.psD.layout((this.psM * 2) + 2, this.psF, (this.psM * 2) + 3, this.psJ);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.psI = getWidth();
        this.psJ = getHeight();
        if (!(this.psI == 0 || this.psJ == 0)) {
            this.psM = (this.psI - 2) / 3;
            this.psN = ((this.psJ - this.psF) - 4) / 4;
            this.psK = this.psM + (this.psG * 2);
            this.psL = this.psN + (this.psF * 2);
        }
        this.pso.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psp.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psq.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psr.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.pss.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.pst.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psu.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psv.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psw.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psn.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psx.measure(MeasureSpec.makeMeasureSpec(this.psK, 1073741824), MeasureSpec.makeMeasureSpec(this.psL, 1073741824));
        this.psy.measure(MeasureSpec.makeMeasureSpec(this.psI, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.psz.measure(MeasureSpec.makeMeasureSpec(this.psI, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.psA.measure(MeasureSpec.makeMeasureSpec(this.psI, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.psB.measure(MeasureSpec.makeMeasureSpec(this.psI, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.psC.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.psJ, 1073741824));
        this.psD.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.psJ, 1073741824));
    }

    public void onClick(View view) {
        if (!this.psE) {
            x.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
        } else if (view == this.psn) {
            input("0");
        } else if (view == this.pso) {
            input("1");
        } else if (view == this.psp) {
            input("2");
        } else if (view == this.psq) {
            input(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (view == this.psr) {
            input("4");
        } else if (view == this.pss) {
            input("5");
        } else if (view == this.pst) {
            input("6");
        } else if (view == this.psu) {
            input("7");
        } else if (view == this.psv) {
            input("8");
        } else if (view == this.psw) {
            input("9");
        } else if (view == this.psx && this.prV != null && this.psE) {
            this.prV.delete();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.psx && this.prV != null && this.psE) {
            this.prV.TA();
        }
        return false;
    }

    public final void hq(boolean z) {
        this.psE = z;
        this.psn.setEnabled(z);
        this.pso.setEnabled(z);
        this.psp.setEnabled(z);
        this.psq.setEnabled(z);
        this.psr.setEnabled(z);
        this.pss.setEnabled(z);
        this.pst.setEnabled(z);
        this.psu.setEnabled(z);
        this.psv.setEnabled(z);
        this.psw.setEnabled(z);
        this.psx.setEnabled(z);
    }

    private void input(String str) {
        if (this.prV != null && this.psE) {
            this.prV.input(str);
        }
    }
}
