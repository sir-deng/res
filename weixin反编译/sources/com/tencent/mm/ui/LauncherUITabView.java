package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class LauncherUITabView extends RelativeLayout implements c {
    protected int mpk = 0;
    private long nzf = 0;
    private Matrix okt = new Matrix();
    private com.tencent.mm.ui.c.a xPI;
    private int xPY = -1;
    protected OnClickListener xQa = new OnClickListener() {
        private final long rNL = 300;

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUITabView.this.xPY == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUITabView.this.nzf <= 300) {
                x.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUITabView.this.xQb.removeMessages(0);
                com.tencent.mm.sdk.b.a.xmy.m(new jh());
                LauncherUITabView.this.nzf = System.currentTimeMillis();
                LauncherUITabView.this.xPY = intValue;
                return;
            }
            if (LauncherUITabView.this.xPI != null) {
                if (intValue == 0 && LauncherUITabView.this.xPY == 0) {
                    LauncherUITabView.this.xQb.sendEmptyMessageDelayed(0, 300);
                } else {
                    LauncherUITabView.this.nzf = System.currentTimeMillis();
                    LauncherUITabView.this.xPY = intValue;
                    LauncherUITabView.this.xPI.po(intValue);
                    return;
                }
            }
            LauncherUITabView.this.nzf = System.currentTimeMillis();
            LauncherUITabView.this.xPY = intValue;
            x.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
        }
    };
    private ag xQb = new ag() {
        public final void handleMessage(Message message) {
            x.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUITabView.this.xPI.po(0);
        }
    };
    private int xQc = 0;
    private int xQd = 0;
    private int xQe = 0;
    private boolean xQf = false;
    private int xQg = 0;
    private boolean xQh = false;
    private int xQq;
    private Bitmap xQr;
    private ImageView xQs;
    protected a xQt;
    protected a xQu;
    protected a xQv;
    protected a xQw;

    protected class a {
        MMTabView xQy;

        protected a() {
        }
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.xPI = aVar;
    }

    private a Eg(int i) {
        a aVar = new a();
        aVar.xQy = new MMTabView(getContext(), i);
        aVar.xQy.setTag(Integer.valueOf(i));
        aVar.xQy.setOnClickListener(this.xQa);
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.e.white);
        linearLayout.setId(2307141);
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.xQs = new ImageView(getContext());
        this.xQs.setImageMatrix(this.okt);
        this.xQs.setScaleType(ScaleType.MATRIX);
        this.xQs.setId(2307142);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.xQs, layoutParams);
        a Eg = Eg(0);
        Eg.xQy.setText(R.l.eun);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byh));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(Eg.xQy, layoutParams2);
        this.xQt = Eg;
        Eg = Eg(1);
        Eg.xQy.setText(R.l.euo);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byh));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(Eg.xQy, layoutParams2);
        this.xQu = Eg;
        Eg = Eg(2);
        Eg.xQy.setText(R.l.eum);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byh));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(Eg.xQy, layoutParams2);
        this.xQv = Eg;
        Eg = Eg(3);
        Eg.xQy.setText(R.l.euM);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byh));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(Eg.xQy, layoutParams2);
        this.xQw = Eg;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.d("MicroMsg.LauncherUITabView", "on layout, width %d", Integer.valueOf(i3 - i));
        this.xQq = (i3 - i) / 4;
        int i5 = this.xQq;
        if (this.xQr == null || this.xQr.getWidth() != i5) {
            String str = "MicroMsg.LauncherUITabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.xQr == null ? -1 : this.xQr.getWidth());
            objArr[1] = Integer.valueOf(i5);
            x.w(str, str2, objArr);
            this.xQr = Bitmap.createBitmap(i5, com.tencent.mm.bu.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.xQr).drawColor(getResources().getColor(R.e.buj));
            h(this.mpk, 0.0f);
            this.xQs.setImageBitmap(this.xQr);
        }
        pn(this.mpk);
    }

    public final void Ea(int i) {
        x.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.xQc = i;
        if (i <= 0) {
            this.xQt.xQy.YV(null);
        } else if (i > 99) {
            this.xQt.xQy.YV(getContext().getString(R.l.eSf));
        } else {
            this.xQt.xQy.YV(String.valueOf(i));
        }
    }

    public final void cmv() {
        if (this.xQt != null && this.xQu != null && this.xQv != null && this.xQw != null) {
            this.xQt.xQy.cnS();
            this.xQu.xQy.cnS();
            this.xQv.xQy.cnS();
            this.xQw.xQy.cnS();
        }
    }

    public final void Eb(int i) {
        this.xQd = i;
        if (i <= 0) {
            this.xQu.xQy.YV(null);
        } else if (i > 99) {
            this.xQu.xQy.YV(getContext().getString(R.l.eSf));
        } else {
            this.xQu.xQy.YV(String.valueOf(i));
        }
    }

    public final void Ec(int i) {
        this.xQe = i;
        if (i <= 0) {
            this.xQv.xQy.YV(null);
        } else if (i > 99) {
            this.xQv.xQy.YV(getContext().getString(R.l.eSf));
        } else {
            this.xQv.xQy.YV(String.valueOf(i));
        }
    }

    public final void Ed(int i) {
        this.xQg = i;
        if (i <= 0) {
            this.xQw.xQy.YV(null);
        } else if (i > 99) {
            this.xQw.xQy.YV(getContext().getString(R.l.eSf));
        } else {
            this.xQw.xQy.YV(String.valueOf(i));
        }
    }

    public final void lT(boolean z) {
        this.xQf = z;
        this.xQv.xQy.me(z);
    }

    public final void lU(boolean z) {
        this.xQh = z;
        this.xQw.xQy.me(z);
    }

    public final void h(int i, float f) {
        this.okt.setTranslate(((float) this.xQq) * (((float) i) + f), 0.0f);
        this.xQs.setImageMatrix(this.okt);
    }

    public final int cmC() {
        return this.mpk;
    }

    public final void pn(int i) {
        this.mpk = i;
        this.xQt.xQy.setTextColor(i == 0 ? getResources().getColorStateList(R.e.buj) : getResources().getColorStateList(R.e.bsX));
        this.xQu.xQy.setTextColor(i == 1 ? getResources().getColorStateList(R.e.buj) : getResources().getColorStateList(R.e.bsX));
        this.xQv.xQy.setTextColor(i == 2 ? getResources().getColorStateList(R.e.buj) : getResources().getColorStateList(R.e.bsX));
        this.xQw.xQy.setTextColor(i == 3 ? getResources().getColorStateList(R.e.buj) : getResources().getColorStateList(R.e.bsX));
        this.nzf = System.currentTimeMillis();
        this.xPY = this.mpk;
    }

    public final int cmw() {
        return this.xQc;
    }

    public final int cmx() {
        return this.xQd;
    }

    public final int cmy() {
        return this.xQe;
    }

    public final int cmz() {
        return this.xQg;
    }

    public final boolean cmA() {
        return this.xQf;
    }

    public final boolean cmB() {
        return this.xQh;
    }
}
