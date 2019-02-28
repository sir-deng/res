package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.x;

public abstract class h extends a {
    public static float ueN = Resources.getSystem().getDisplayMetrics().density;
    public static int ueO = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int ueP = ((int) ((40.0f * ueN) + 0.5f));
    public ImageView fwa;
    public OnClickListener nvF = new OnClickListener() {
        public final void onClick(View view) {
            if (h.this.ucQ.bXL() != null) {
                x.e("Micromsg.NoteOtherItemHolder", "click item , now is editing, quit it");
                return;
            }
            if (h.this.ucQ.uaN == 2) {
                h.this.ucQ.uaA.bYw().bWX();
                h.this.ucQ.bXO();
            }
            int gf = ((t) view.getTag()).gf();
            kp kpVar = new kp();
            if (c.bXc().BL(gf) == null) {
                x.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", Integer.valueOf(gf), Integer.valueOf(c.bXc().size()));
            } else if (com.tencent.mm.plugin.wenote.model.c.bWA().tWL == null) {
                x.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
            } else {
                x.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", Integer.valueOf(c.bXc().BL(gf).getType()));
                kpVar.fCH.fCJ = ((n) c.bXc().BL(gf)).tYn;
                kpVar.fCH.context = view.getContext();
                kpVar.fCH.type = 1;
                com.tencent.mm.plugin.wenote.model.c.bWA().tWL.b(kpVar);
            }
        }
    };
    public LinearLayout ueA;
    public TextView ueB;
    public TextView ueC;
    public ImageView ueD;
    public View ueE;
    public LinearLayout ueF;
    public LinearLayout ueG;
    public LinearLayout ueH;
    public LinearLayout ueI;
    public LinearLayout ueJ;
    public LinearLayout ueK;
    public LinearLayout ueL;
    public LinearLayout ueM;
    public WXRTEditText uey;
    public WXRTEditText uez;

    public h(View view, k kVar) {
        super(view, kVar);
        this.fwa = (ImageView) view.findViewById(R.h.cdi);
        this.ueE = view.findViewById(R.h.cUN);
        this.ueA = (LinearLayout) view.findViewById(R.h.cAQ);
        this.ueF = (LinearLayout) view.findViewById(R.h.cBj);
        this.ueB = (TextView) view.findViewById(R.h.cAR);
        this.ueC = (TextView) view.findViewById(R.h.cAO);
        this.ueD = (ImageView) view.findViewById(R.h.cAP);
        this.ueB.setTextSize(16.0f);
        this.ueC.setTextSize(12.0f);
        this.ueG = (LinearLayout) view.findViewById(R.h.cBh);
        this.ueG.setVisibility(8);
        this.ueI = (LinearLayout) view.findViewById(R.h.cBc);
        this.ueI.setVisibility(8);
        this.ueJ = (LinearLayout) view.findViewById(R.h.cAN);
        this.ueJ.setVisibility(8);
        this.ueK = (LinearLayout) view.findViewById(R.h.cCb);
        this.ueK.setBackgroundColor(1347529272);
        this.ueK.setVisibility(8);
        this.ueK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.bXS().bXW();
            }
        });
        this.ueL = (LinearLayout) view.findViewById(R.h.cCf);
        this.ueL.setBackgroundColor(1347529272);
        this.ueL.setVisibility(4);
        this.ueM = (LinearLayout) view.findViewById(R.h.cCd);
        this.ueM.setBackgroundColor(1347529272);
        this.ueM.setVisibility(4);
        this.ueH = (LinearLayout) view.findViewById(R.h.cdk);
        LayoutParams layoutParams = (LayoutParams) this.ueH.getLayoutParams();
        layoutParams.width = ueO - ueP;
        layoutParams.height = -2;
        this.ueH.setLayoutParams(layoutParams);
        this.uez = (WXRTEditText) view.findViewById(R.h.bPa);
        this.uey = (WXRTEditText) view.findViewById(R.h.bPc);
        ((LinearLayout) view.findViewById(R.h.bPb)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.this.uez.bXy();
                h.this.uez.requestFocus();
            }
        });
        ((LinearLayout) view.findViewById(R.h.bPd)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.this.uey.bXy();
                h.this.uey.requestFocus();
            }
        });
        this.uez.tZU = 2;
        this.uey.tZU = 1;
        this.uey.tZW = this;
        this.uez.tZW = this;
        if (!(kVar.uaN == 2 && this.ucQ.uaO)) {
            this.uez.setKeyListener(null);
            this.uez.setEnabled(false);
            this.uez.setFocusable(false);
            this.uey.setKeyListener(null);
            this.uey.setEnabled(false);
            this.uey.setFocusable(false);
        }
        this.ucQ.o(this.uey);
        this.ucQ.o(this.uez);
    }

    public void a(b bVar, int i, int i2) {
        x.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + ge());
        this.uey.uah = i;
        this.uez.uah = i;
        if (e.isEnabled()) {
            e.bXS().a(this.ueK, this.ueL, this.ueM, i);
        }
        bVar.tXU = this.uey;
        bVar.tXV = this.uez;
        bVar.tXW = null;
        if (!bVar.tXR) {
            if (this.uey.hasFocus()) {
                this.uey.clearFocus();
            }
            if (this.uez.hasFocus()) {
                this.uez.clearFocus();
            }
        } else if (bVar.tXX) {
            this.uey.requestFocus();
        } else {
            this.uez.requestFocus();
        }
        if (this.ueA.getVisibility() != 0) {
            return;
        }
        if (bVar.tXY) {
            this.ueA.setBackgroundResource(R.g.bHY);
        } else {
            this.ueA.setBackgroundResource(R.g.bHX);
        }
    }
}
