package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class u extends LinearLayout implements a {
    private static final int jdI = com.tencent.mm.plugin.appbrand.q.g.iwJ;
    private static final b ket = new f();
    private MMActivity fnF;
    private final Runnable keg = new Runnable() {
        public final void run() {
            if (u.this.kel != null && z.ak(u.this.kel)) {
                if (u.this.kel.anz()) {
                    x.d("MicroMsg.AppBrandSmileyPanelWrapper", "postMeasure inLayout, skip");
                    u.this.post(this);
                    return;
                }
                u.b(u.this);
            }
        }
    };
    d keh;
    c kei;
    private boolean kej = false;
    public e kek;
    private AppBrandSmileyPanel kel;
    private View kem;
    private ImageButton ken;
    private boolean keo;
    private View kep;
    private boolean keq;
    public EditText ker;
    private int kes = 0;
    private int state = 2;

    public interface a {
        void cH(boolean z);
    }

    public interface d {
        boolean vD(String str);
    }

    interface b {
        void c(u uVar, int i);

        void k(u uVar);

        void l(u uVar);

        void m(u uVar);

        void n(u uVar);
    }

    public interface c {
        void dw(boolean z);
    }

    private static final class f implements b {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        public final void k(u uVar) {
            if (uVar.isShown()) {
                uVar.kel.setVisibility(0);
            }
            uVar.kel.aoe();
        }

        public final void l(u uVar) {
            if (j.bK(uVar)) {
                uVar.mt(8);
                uVar.anC();
                return;
            }
            if (uVar.isShown()) {
                uVar.kel.setVisibility(0);
            }
            if (uVar.keo) {
                AppBrandSmileyPanelBase a = uVar.kel;
                if (a.Iv != null) {
                    a.Iv.setVisibility(0);
                    return;
                }
                return;
            }
            uVar.kel.aoe();
        }

        public final void c(u uVar, int i) {
            if (j.bK(uVar)) {
                uVar.mt(8);
            } else if (uVar.kel != null && i > 0) {
                uVar.mq(i);
            }
        }

        public final void m(u uVar) {
            uVar.fnF.showVKB();
            uVar.hideSmileyPanel();
        }

        public final void n(u uVar) {
            uVar.fnF.aWY();
            uVar.anD();
            uVar.mp(com.tencent.mm.compatible.util.j.aQ(uVar.fnF));
        }
    }

    public interface e {
        void ki(int i);
    }

    private static final class g extends FrameLayout implements a {
        private boolean kex = false;

        public g(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(h.iAb, this);
        }

        public final void cH(boolean z) {
            Object obj = z != this.kex ? 1 : null;
            this.kex = z;
            if (obj == null) {
                return;
            }
            if (VERSION.SDK_INT < 18 || !isInLayout()) {
                requestLayout();
            }
        }

        protected final void onMeasure(int i, int i2) {
            if (this.kex || !isShown()) {
                i = MeasureSpec.makeMeasureSpec(0, 1073741824);
                i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    static /* synthetic */ void b(u uVar) {
        x.v("MicroMsg.AppBrandSmileyPanelWrapper", "[scrollUp] forceMeasurePanel enter");
        uVar.kel.requestLayout();
    }

    public static u bY(View view) {
        return (u) view.getRootView().findViewById(jdI);
    }

    public static u bZ(View view) {
        l bS = l.bS(view);
        if (bS.kdr == null || !(bS.kdr instanceof s)) {
            bS.kdr = new s();
        }
        u bY = bY(view);
        if (bY != null) {
            return bY;
        }
        View uVar = new u(view.getContext());
        bS.bT(uVar);
        return uVar;
    }

    public final void mp(int i) {
        ket.c(this, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.v("MicroMsg.AppBrandSmileyPanelWrapper", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", Integer.valueOf(getMeasuredHeight()));
    }

    public final void dA(boolean z) {
        x.d("MicroMsg.AppBrandSmileyPanelWrapper", "onKeyboardStateChanged, kbShown = %b", Boolean.valueOf(z));
        if (z) {
            mt(0);
            hideSmileyPanel();
        } else if (!isShown()) {
        } else {
            if (this.keo && 1 == this.state) {
                anD();
            } else {
                hide();
            }
        }
    }

    private void mq(int i) {
        Object obj;
        AppBrandSmileyPanel appBrandSmileyPanel = this.kel;
        if (i <= 0 || appBrandSmileyPanel.kef == i) {
            obj = null;
        } else {
            appBrandSmileyPanel.kef = i;
            obj = 1;
        }
        if (obj != null) {
            this.keg.run();
        }
    }

    public int getMinimumHeight() {
        return getVisibility() == 0 ? com.tencent.mm.bu.a.fromDPToPix(getContext(), 48) : 0;
    }

    protected final void dw(boolean z) {
        if (!this.kej && this.kei != null) {
            this.kej = true;
            this.kei.dw(z);
            this.kej = false;
        }
    }

    public u(Context context) {
        super(context);
        this.fnF = (MMActivity) context;
        super.setId(jdI);
        setOrientation(1);
        View afp = afp();
        this.kem = afp;
        addView(afp);
        this.kel = new AppBrandSmileyPanel(getContext());
        this.kel.setVisibility(8);
        this.kel.setBackgroundColor(0);
        AppBrandSmileyPanelBase appBrandSmileyPanelBase = this.kel;
        appBrandSmileyPanelBase.kgK = new com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase.a() {
            public final void append(String str) {
                if (u.this.keh != null) {
                    u.this.keh.vD(str);
                }
            }

            public final void anG() {
                if (u.this.keh != null) {
                    u.this.keh.vD("[DELETE_EMOTION]");
                }
            }
        };
        appBrandSmileyPanelBase.kgy.kgR = appBrandSmileyPanelBase.kgK;
        addView(this.kel);
        afl();
    }

    public void setId(int i) {
    }

    public final void mr(int i) {
        super.setId(i);
    }

    public <T extends View & a> T afp() {
        T gVar = new g(getContext());
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, ad.getResources().getDrawable(i.dBn));
        stateListDrawable.addState(new int[0], ad.getResources().getDrawable(i.dBm));
        this.ken = (ImageButton) gVar.findViewById(com.tencent.mm.plugin.appbrand.q.g.iyR);
        this.ken.setSelected(false);
        this.ken.setImageDrawable(stateListDrawable);
        this.ken.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (view.isSelected()) {
                    u.ket.m(u.this);
                    view.setSelected(false);
                    return;
                }
                u.ket.n(u.this);
                view.setSelected(true);
            }
        });
        this.kep = gVar.findViewById(com.tencent.mm.plugin.appbrand.q.g.iyQ);
        this.kep.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                u.this.dw(true);
            }
        });
        return gVar;
    }

    private void anA() {
        ((s) l.bS(this).kdr).kea = this;
    }

    private void anB() {
        ((s) l.bS(this).kdr).kea = null;
    }

    private void ms(final int i) {
        final boolean z = this.kej;
        post(new Runnable() {
            public final void run() {
                int d = u.this.state;
                if (u.this.isShown()) {
                    u.this.state = i;
                } else {
                    u.this.state = 2;
                }
                if (u.this.kek != null && d != u.this.state && !z) {
                    u.this.kek.ki(u.this.state);
                }
            }
        });
    }

    private void anC() {
        hideSmileyPanel();
        if (this.ker != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.ker.getContext().getSystemService("input_method");
            if (!inputMethodManager.showSoftInput(this.ker, 1)) {
                inputMethodManager.showSoftInput(this.ker, 2);
                return;
            }
            return;
        }
        this.fnF.showVKB();
    }

    private void anD() {
        ket.l(this);
        if (this.ken != null) {
            this.ken.setSelected(true);
        }
        ms(1);
    }

    private void hideSmileyPanel() {
        ket.k(this);
        if (this.ken != null) {
            this.ken.setSelected(false);
        }
        ms(0);
    }

    public void afl() {
        boolean z = false;
        if (this.kem != null) {
            a aVar = (a) this.kem;
            if (((!this.keo ? 1 : 0) & (!this.keq ? 1 : 0)) != 0 || j.bK(this)) {
                z = true;
            }
            aVar.cH(z);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        x.d("MicroMsg.AppBrandSmileyPanelWrapper", "smileyPanelWrapper, onMeasure");
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        anA();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mt(8);
        if (this.fnF != null) {
            if (this.ker != null) {
                this.fnF.df(this.ker);
            } else {
                this.fnF.aWY();
            }
        }
        AppBrandSmileyPanelBase appBrandSmileyPanelBase = this.kel;
        com.tencent.mm.plugin.appbrand.widget.input.panel.c cVar = appBrandSmileyPanelBase.kgy;
        cVar.kgQ = null;
        cVar.kgx = null;
        if (appBrandSmileyPanelBase.Iv != null) {
            ((ViewGroup) appBrandSmileyPanelBase.Iv.getParent()).removeView(appBrandSmileyPanelBase.Iv);
            ((ViewGroup) appBrandSmileyPanelBase.Iv).removeAllViews();
            appBrandSmileyPanelBase.Iv = null;
        }
        appBrandSmileyPanelBase.kgL = null;
        if (this.ken != null) {
            this.ken.setOnClickListener(null);
        }
        this.keh = null;
        removeAllViews();
        this.fnF = null;
        anB();
    }

    public void setVisibility(int i) {
        if (i == 8) {
            if (getVisibility() != i) {
                dw(false);
            }
            hide();
        } else if (i == 0) {
            show();
        } else {
            mt(i);
        }
    }

    final void mt(int i) {
        if (i == 0 && j.bK(this)) {
            i = 8;
        }
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 0) {
                anA();
            } else {
                anB();
            }
        }
    }

    public final void anE() {
        int i = 0;
        this.keo = false;
        if (this.ken != null) {
            ImageButton imageButton = this.ken;
            if (!this.keo) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
        afl();
    }

    public final void dB(boolean z) {
        this.keq = z;
        if (this.kep != null) {
            this.kep.setVisibility(this.keq ? 0 : 4);
        }
        afl();
    }

    public EditText afo() {
        return this.ker;
    }

    public final void b(EditText editText) {
        if (editText == this.ker) {
            this.ker = null;
        }
    }

    public void afm() {
        anE();
        dB(this.keq);
        afl();
    }

    public void show() {
        anC();
        afm();
        if (!isShown()) {
            mt(0);
        }
        mq(com.tencent.mm.compatible.util.j.aQ(getContext()));
    }

    public final void hide() {
        if (isShown()) {
            mt(8);
            if (!(this.fnF == null || this.fnF.mController.hideVKB())) {
                af.cd(this).hideSoftInputFromWindow(getWindowToken(), 0);
            }
            hideSmileyPanel();
        }
    }
}
