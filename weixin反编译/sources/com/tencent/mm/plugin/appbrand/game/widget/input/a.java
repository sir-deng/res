package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.s;
import com.tencent.mm.plugin.appbrand.widget.input.u;

public final class a extends u {
    private static final int jdI = g.iwc;
    private a jdJ;
    private WAGamePanelInputEditText jdK;
    public OnClickListener jdL;

    private static final class a extends FrameLayout implements com.tencent.mm.plugin.appbrand.widget.input.u.a {
        private View jdN;

        public final View afq() {
            if (this.jdN == null) {
                this.jdN = findViewById(g.iyj);
            }
            return this.jdN;
        }

        public a(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(h.izm, this, true);
            ((Button) findViewById(g.iyj)).setText(j.iEg);
        }

        public final void cH(boolean z) {
            setVisibility(z ? 8 : 0);
        }
    }

    public final /* bridge */ /* synthetic */ EditText afo() {
        return (WAGamePanelInputEditText) super.afo();
    }

    protected final /* synthetic */ View afp() {
        View aVar = new a(getContext());
        this.jdK = (WAGamePanelInputEditText) aVar.findViewById(g.iyk);
        aVar.afq().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.jdL != null) {
                    a.this.jdL.onClick(view);
                }
            }
        });
        this.ker = this.jdK;
        this.jdJ = aVar;
        return aVar;
    }

    private a(Context context) {
        super(context);
        mr(jdI);
    }

    public static a bF(View view) {
        return (a) view.getRootView().findViewById(jdI);
    }

    public static a bG(View view) {
        l bS = l.bS(view);
        if (bS.kdr == null || !(bS.kdr instanceof s)) {
            bS.kdr = new s();
        }
        a bF = bF(view);
        if (bF != null) {
            return bF;
        }
        View aVar = new a(view.getContext());
        bS.bT(aVar);
        return aVar;
    }

    protected final void afl() {
        this.jdJ.cH(false);
    }

    protected final void afm() {
        int i;
        int i2 = 0;
        if ((this.jdK.getInputType() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        View afq = this.jdJ.afq();
        if (i == 0) {
            i2 = 8;
        }
        afq.setVisibility(i2);
    }

    public final WAGamePanelInputEditText afn() {
        return (WAGamePanelInputEditText) super.afo();
    }

    public final void show() {
        this.ker = this.jdK;
        this.jdK.requestFocus();
        super.show();
    }
}
