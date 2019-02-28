package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.s;
import com.tencent.smtt.sdk.WebView;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    protected int mpk = 0;
    private long nzf = 0;
    private com.tencent.mm.ui.c.a xPI;
    protected a xPJ;
    protected a xPK;
    protected a xPL;
    protected a xPM;
    private int xPN = 0;
    private int xPO;
    private int xPP;
    private int xPQ;
    private int xPR = 0;
    private int xPS;
    private int xPT;
    private int xPU;
    private int xPV;
    private int xPW;
    private int xPX;
    private int xPY = -1;
    private int xPZ = 0;
    protected OnClickListener xQa = new OnClickListener() {
        private final long rNL = 300;

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUIBottomTabView.this.xPY == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUIBottomTabView.this.nzf <= 300) {
                x.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUIBottomTabView.this.xQb.removeMessages(0);
                com.tencent.mm.sdk.b.a.xmy.m(new jh());
                LauncherUIBottomTabView.this.nzf = System.currentTimeMillis();
                LauncherUIBottomTabView.this.xPY = intValue;
                return;
            }
            if (LauncherUIBottomTabView.this.xPI != null) {
                if (intValue == 0 && LauncherUIBottomTabView.this.xPY == 0) {
                    x.v("MicroMsg.LauncherUITabView", "do double click check");
                    LauncherUIBottomTabView.this.xQb.sendEmptyMessageDelayed(0, 300);
                } else {
                    x.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                    LauncherUIBottomTabView.this.nzf = System.currentTimeMillis();
                    LauncherUIBottomTabView.this.xPY = intValue;
                    LauncherUIBottomTabView.this.xPI.po(intValue);
                    return;
                }
            }
            LauncherUIBottomTabView.this.nzf = System.currentTimeMillis();
            LauncherUIBottomTabView.this.xPY = intValue;
            x.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
        }
    };
    private ag xQb = new ag() {
        public final void handleMessage(Message message) {
            x.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUIBottomTabView.this.xPI.po(0);
        }
    };
    private int xQc = 0;
    private int xQd = 0;
    private int xQe = 0;
    private boolean xQf = false;
    private int xQg = 0;
    private boolean xQh = false;

    protected class a {
        View xQj;
        TabIconView xQk;
        TextView xQl;
        TextView xQm;
        ImageView xQn;

        protected a() {
        }
    }

    public LauncherUIBottomTabView(Context context) {
        super(context);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.xPI = aVar;
    }

    private a Ef(int i) {
        a aVar = new a();
        if (com.tencent.mm.bu.a.ez(getContext())) {
            aVar.xQj = b.Ef().a((Activity) getContext(), "R.layout.mm_bottom_tabitem_large", R.i.dnx);
        } else {
            aVar.xQj = b.Ef().a((Activity) getContext(), "R.layout.mm_bottom_tabitem", R.i.dnw);
        }
        aVar.xQk = (TabIconView) aVar.xQj.findViewById(R.h.coQ);
        aVar.xQl = (TextView) aVar.xQj.findViewById(R.h.coS);
        aVar.xQm = (TextView) aVar.xQj.findViewById(R.h.cTU);
        aVar.xQm.setBackgroundResource(s.ge(getContext()));
        aVar.xQn = (ImageView) aVar.xQj.findViewById(R.h.ccv);
        aVar.xQj.setTag(Integer.valueOf(i));
        aVar.xQj.setOnClickListener(this.xQa);
        aVar.xQl.setTextSize(0, ((float) com.tencent.mm.bu.a.ab(getContext(), R.f.bvX)) * com.tencent.mm.bu.a.ex(getContext()));
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.xPZ = (int) (((float) com.tencent.mm.bu.a.ab(getContext(), R.f.buI)) * com.tencent.mm.bu.a.ex(getContext()));
        a Ef = Ef(0);
        Ef.xQj.setId(-16777215);
        Ef.xQl.setText(R.l.euO);
        Ef.xQl.setTextColor(getResources().getColor(R.e.bto));
        Ef.xQk.g(R.k.dzu, R.k.dzv, R.k.dzw, com.tencent.mm.bu.a.ez(getContext()));
        Ef.xQm.setVisibility(4);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.xPZ);
        layoutParams.weight = 1.0f;
        linearLayout.addView(Ef.xQj, layoutParams);
        this.xPJ = Ef;
        Ef = Ef(1);
        Ef.xQj.setId(-16777214);
        Ef.xQl.setText(R.l.euo);
        Ef.xQl.setTextColor(getResources().getColor(R.e.btp));
        Ef.xQk.g(R.k.dzr, R.k.dzs, R.k.dzt, com.tencent.mm.bu.a.ez(getContext()));
        Ef.xQm.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.xPZ);
        layoutParams.weight = 1.0f;
        linearLayout.addView(Ef.xQj, layoutParams);
        this.xPL = Ef;
        Ef = Ef(2);
        Ef.xQj.setId(-16777213);
        Ef.xQl.setText(R.l.eum);
        Ef.xQl.setTextColor(getResources().getColor(R.e.btp));
        Ef.xQk.g(R.k.dzx, R.k.dzy, R.k.dzz, com.tencent.mm.bu.a.ez(getContext()));
        Ef.xQm.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.xPZ);
        layoutParams.weight = 1.0f;
        linearLayout.addView(Ef.xQj, layoutParams);
        this.xPK = Ef;
        Ef = Ef(3);
        Ef.xQj.setId(-16777212);
        Ef.xQl.setText(R.l.euM);
        Ef.xQl.setTextColor(getResources().getColor(R.e.btp));
        Ef.xQk.g(R.k.dzA, R.k.dzB, R.k.dzC, com.tencent.mm.bu.a.ez(getContext()));
        Ef.xQm.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.xPZ);
        layoutParams.weight = 1.0f;
        linearLayout.addView(Ef.xQj, layoutParams);
        this.xPM = Ef;
        this.xPN = getResources().getColor(R.e.bto);
        this.xPO = (this.xPN & 16711680) >> 16;
        this.xPP = (this.xPN & 65280) >> 8;
        this.xPQ = this.xPN & 255;
        this.xPR = getResources().getColor(R.e.btp);
        this.xPS = (this.xPR & 16711680) >> 16;
        this.xPT = (this.xPR & 65280) >> 8;
        this.xPU = this.xPR & 255;
        this.xPV = this.xPO - this.xPS;
        this.xPW = this.xPP - this.xPT;
        this.xPX = this.xPQ - this.xPU;
    }

    public final void Ea(int i) {
        x.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.xQc = i;
        if (i <= 0) {
            this.xPJ.xQm.setText("");
            this.xPJ.xQm.setVisibility(4);
        } else if (i > 99) {
            this.xPJ.xQm.setText(getContext().getString(R.l.eSf));
            this.xPJ.xQm.setVisibility(0);
            this.xPJ.xQn.setVisibility(4);
        } else {
            this.xPJ.xQm.setText(String.valueOf(i));
            this.xPJ.xQm.setVisibility(0);
            this.xPJ.xQn.setVisibility(4);
        }
    }

    public final void cmv() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.xPJ;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r1.xPL;
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r0 = r1.xPK;
        if (r0 != 0) goto L_0x000c;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUIBottomTabView.cmv():void");
    }

    public final void Eb(int i) {
        this.xQd = i;
        if (i <= 0) {
            this.xPL.xQm.setText("");
            this.xPL.xQm.setVisibility(4);
        } else if (i > 99) {
            this.xPL.xQm.setText(getContext().getString(R.l.eSf));
            this.xPL.xQm.setVisibility(0);
            this.xPL.xQn.setVisibility(4);
        } else {
            this.xPL.xQm.setText(String.valueOf(i));
            this.xPL.xQm.setVisibility(0);
            this.xPL.xQn.setVisibility(4);
        }
    }

    public final void Ec(int i) {
        this.xQe = i;
        if (i <= 0) {
            this.xPK.xQm.setText("");
            this.xPK.xQm.setVisibility(4);
        } else if (i > 99) {
            this.xPK.xQm.setText(getContext().getString(R.l.eSf));
            this.xPK.xQm.setVisibility(0);
            this.xPK.xQn.setVisibility(4);
        } else {
            this.xPK.xQm.setText(String.valueOf(i));
            this.xPK.xQm.setVisibility(0);
            this.xPK.xQn.setVisibility(4);
        }
    }

    public final void lT(boolean z) {
        int i = 4;
        this.xQf = z;
        this.xPK.xQm.setVisibility(4);
        ImageView imageView = this.xPK.xQn;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void Ed(int i) {
        this.xQg = i;
        if (i <= 0) {
            this.xPM.xQm.setText("");
            this.xPM.xQm.setVisibility(4);
        } else if (i > 99) {
            this.xPM.xQm.setText(getContext().getString(R.l.eSf));
            this.xPM.xQm.setVisibility(0);
            this.xPM.xQn.setVisibility(4);
        } else {
            this.xPM.xQm.setText(String.valueOf(i));
            this.xPM.xQm.setVisibility(0);
            this.xPM.xQn.setVisibility(4);
        }
    }

    public final void lU(boolean z) {
        int i = 4;
        this.xQh = z;
        this.xPM.xQm.setVisibility(4);
        ImageView imageView = this.xPM.xQn;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void h(int i, float f) {
        int i2 = (int) (255.0f * f);
        int i3 = 255 - i2;
        int i4 = (((((int) ((((float) this.xPV) * f) + ((float) this.xPS))) << 16) + (((int) ((((float) this.xPW) * f) + ((float) this.xPT))) << 8)) + ((int) ((((float) this.xPX) * f) + ((float) this.xPU)))) + WebView.NIGHT_MODE_COLOR;
        int i5 = (((((int) ((((float) this.xPV) * (1.0f - f)) + ((float) this.xPS))) << 16) + (((int) ((((float) this.xPW) * (1.0f - f)) + ((float) this.xPT))) << 8)) + ((int) ((((float) this.xPX) * (1.0f - f)) + ((float) this.xPU)))) + WebView.NIGHT_MODE_COLOR;
        switch (i) {
            case 0:
                this.xPJ.xQk.Ew(i3);
                this.xPL.xQk.Ew(i2);
                this.xPJ.xQl.setTextColor(i5);
                this.xPL.xQl.setTextColor(i4);
                return;
            case 1:
                this.xPL.xQk.Ew(i3);
                this.xPK.xQk.Ew(i2);
                this.xPL.xQl.setTextColor(i5);
                this.xPK.xQl.setTextColor(i4);
                return;
            case 2:
                this.xPK.xQk.Ew(i3);
                this.xPM.xQk.Ew(i2);
                this.xPK.xQl.setTextColor(i5);
                this.xPM.xQl.setTextColor(i4);
                return;
            default:
                return;
        }
    }

    public final int cmC() {
        return this.mpk;
    }

    public final void pn(int i) {
        this.mpk = i;
        switch (i) {
            case 0:
                this.xPJ.xQk.Ew(255);
                this.xPK.xQk.Ew(0);
                this.xPL.xQk.Ew(0);
                this.xPM.xQk.Ew(0);
                this.xPJ.xQl.setTextColor(this.xPN);
                this.xPK.xQl.setTextColor(this.xPR);
                this.xPL.xQl.setTextColor(this.xPR);
                this.xPM.xQl.setTextColor(this.xPR);
                break;
            case 1:
                this.xPJ.xQk.Ew(0);
                this.xPK.xQk.Ew(0);
                this.xPL.xQk.Ew(255);
                this.xPM.xQk.Ew(0);
                this.xPJ.xQl.setTextColor(this.xPR);
                this.xPK.xQl.setTextColor(this.xPR);
                this.xPL.xQl.setTextColor(this.xPN);
                this.xPM.xQl.setTextColor(this.xPR);
                break;
            case 2:
                this.xPJ.xQk.Ew(0);
                this.xPK.xQk.Ew(255);
                this.xPL.xQk.Ew(0);
                this.xPM.xQk.Ew(0);
                this.xPJ.xQl.setTextColor(this.xPR);
                this.xPK.xQl.setTextColor(this.xPN);
                this.xPL.xQl.setTextColor(this.xPR);
                this.xPM.xQl.setTextColor(this.xPR);
                break;
            case 3:
                this.xPJ.xQk.Ew(0);
                this.xPK.xQk.Ew(0);
                this.xPL.xQk.Ew(0);
                this.xPM.xQk.Ew(255);
                this.xPJ.xQl.setTextColor(this.xPR);
                this.xPK.xQl.setTextColor(this.xPR);
                this.xPL.xQl.setTextColor(this.xPR);
                this.xPM.xQl.setTextColor(this.xPN);
                break;
        }
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
