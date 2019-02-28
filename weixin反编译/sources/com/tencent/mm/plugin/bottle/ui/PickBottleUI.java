package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.m;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.k;

public class PickBottleUI extends FrameLayout implements OnClickListener, OnTouchListener {
    float density;
    ag handler = new ag();
    private boolean hasInit = false;
    float iTW;
    float iTX;
    SprayLayout kIO;
    PickedBottleImageView kIP;
    ImageView kIQ;
    private b kIR;
    Runnable kIS = new Runnable() {
        public final void run() {
            PickBottleUI.this.kIR = new b();
            PickBottleUI.this.kIR.a(new a() {
                public final void ci(int i, int i2) {
                    if (PickBottleUI.this.kIO != null && PickBottleUI.this.kIP != null) {
                        PickBottleUI.this.kIO.stop();
                        if (i2 == -2002) {
                            PickBottleUI.this.kIR = null;
                            PickBottleUI.this.kIt.nE(0);
                            PickBottleUI.this.kIt.nD(R.l.dMN);
                        }
                        if (PickBottleUI.this.kIR == null) {
                            return;
                        }
                        if (i == 0 && i2 == 0 && PickBottleUI.this.kIR.kGr != -10001) {
                            if (19990 == PickBottleUI.this.kIR.kGr) {
                                m.d(PickBottleUI.this.kIR.kGC, PickBottleUI.this.kIR.iconUrl, R.g.bEl);
                            }
                            PickBottleUI.this.kIP.kID = PickBottleUI.this.kIR.kGw;
                            PickBottleUI.this.kIP.kGC = PickBottleUI.this.kIR.kGC;
                            PickBottleUI.this.kIP.iconUrl = PickBottleUI.this.kIR.iconUrl;
                            PickBottleUI.this.kIP.density = PickBottleUI.this.density;
                            PickBottleUI.this.kIP.show(PickBottleUI.this.kIR.kGr);
                            PickBottleUI.this.kIQ.setVisibility(0);
                            PickBottleUI.this.kIR = null;
                            return;
                        }
                        PickBottleUI.this.kIP.kID = null;
                        PickBottleUI.this.kIP.show(-10001);
                        PickBottleUI.this.handler.postDelayed(PickBottleUI.this.kIT, 2000);
                    }
                }
            });
        }
    };
    Runnable kIT = new Runnable() {
        public final void run() {
            if (PickBottleUI.this.kIP != null && PickBottleUI.this.kIP.isShown()) {
                PickBottleUI.this.kIt.nE(0);
            }
        }
    };
    BottleBeachUI kIt;

    public PickBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIt = (BottleBeachUI) context;
    }

    public PickBottleUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIt = (BottleBeachUI) context;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    public final void initView() {
        if (!this.hasInit) {
            this.kIP = (PickedBottleImageView) findViewById(R.h.bOx);
            this.kIO = (SprayLayout) this.kIt.findViewById(R.h.bOA);
            this.kIQ = (ImageView) this.kIt.findViewById(R.h.bOc);
            this.kIP.setOnClickListener(this);
            if (!bi.chd()) {
                setBackgroundResource(R.g.bzR);
            }
            setOnClickListener(this);
            setOnTouchListener(this);
            this.hasInit = true;
        }
    }

    public void setVisibility(int i) {
        this.kIO.setVisibility(i);
        this.kIP.setVisibility(8);
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.bOx == view.getId()) {
            if (this.kIP.kID != null) {
                as.Hm();
                c.Fk().XH(this.kIP.kID);
                as.Hm();
                ae XF = c.Fk().XF("floatbottle");
                if (!(XF == null || bi.oN(XF.field_username))) {
                    XF.eP(k.FU());
                    as.Hm();
                    c.Fk().a(XF, XF.field_username);
                }
            }
            this.kIt.onClick(view);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.iTW = motionEvent.getX();
            this.iTX = motionEvent.getY();
        } else if (action == 1) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            action = getHeight();
            int width = getWidth();
            action = (action * 550) / 800;
            int i = (width - ((width * 120) / 480)) / 2;
            width -= i;
            if (y > ((float) action)) {
                z = true;
            } else if (x < ((float) i) - ((((float) i) * y) / ((float) action))) {
                z = true;
            } else {
                z = x > ((((float) i) * y) / ((float) action)) + ((float) width);
            }
            if (z) {
                if (!this.kIP.isShown()) {
                    if (this.kIR != null) {
                        e eVar = this.kIR;
                        as.CN().b(155, eVar);
                        as.CN().b(156, eVar);
                        as.CN().c(eVar.kGD);
                        this.kIR = null;
                    }
                    this.handler.removeCallbacks(this.kIS);
                    this.handler.removeCallbacks(this.kIT);
                    this.kIt.nE(0);
                } else if (this.kIP.kID == null) {
                    this.kIt.nE(0);
                }
            } else if (t(x, y) && t(this.iTW, this.iTX)) {
                if (this.kIP.kID != null) {
                    as.Hm();
                    c.Fk().XH(this.kIP.kID);
                    as.Hm();
                    ae XF = c.Fk().XF("floatbottle");
                    if (!(XF == null || bi.oN(XF.field_username))) {
                        XF.eP(k.FU());
                        as.Hm();
                        c.Fk().a(XF, XF.field_username);
                    }
                }
                this.kIt.onClick(this.kIP);
            }
        }
        return true;
    }

    private boolean t(float f, float f2) {
        int height = getHeight();
        int width = getWidth();
        int i = (width * 180) / 480;
        int i2 = (height * 75) / 800;
        float f3 = f - ((float) ((width * 240) / 480));
        float f4 = f2 - ((float) ((height * 495) / 800));
        if (((f4 * f4) / ((float) (i2 * i2))) + ((f3 * f3) / ((float) (i * i))) <= 1.0f) {
            return true;
        }
        return false;
    }
}
