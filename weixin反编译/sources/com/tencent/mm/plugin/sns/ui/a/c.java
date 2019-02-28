package com.tencent.mm.plugin.sns.ui.a;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.au.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.an;

public final class c extends a {
    public final void d(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar.rTR != null) {
            cVar.rTR.setLayoutResource(g.qND);
            cVar.rUB = (ViewStub) cVar.nav.findViewById(f.qIt);
            if (!(cVar.rUC || cVar.rUB == null)) {
                cVar.rUD = cVar.rUB.inflate();
                cVar.rUC = true;
            }
        } else {
            cVar.rUD = cVar.nav.findViewById(f.qIV);
            cVar.rUC = true;
        }
        cVar.rLx = cVar.rUD;
        cVar.rLx.findViewById(f.state).setOnTouchListener(this.rfY.ryR);
        cVar.rTU = (TagImageView) cVar.rLx.findViewById(f.qIs);
        cVar.rxm = (ImageView) cVar.rLx.findViewById(f.state);
        cVar.rTV = (TextView) cVar.rLx.findViewById(f.qJm);
        cVar.ikn = (TextView) cVar.rLx.findViewById(f.qLQ);
        cVar.ikn.setTextColor(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btS));
        cVar.ikn.setMaxLines(1);
        i.b(cVar.rTU, this.mActivity);
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, int i, ay ayVar, bpb bpb, int i2, av avVar) {
        String str = ayVar.ryG;
        if (bpb.wYj.wfh.isEmpty()) {
            cVar.rLx.setVisibility(8);
            return;
        }
        Object obj;
        CharSequence charSequence;
        cVar.rTU.position = i;
        cVar.rLx.setVisibility(0);
        are are = (are) bpb.wYj.wfh.get(0);
        com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
        View view = cVar.rTU;
        int i3 = com.tencent.mm.plugin.sns.i.i.dvy;
        int hashCode = this.mActivity.hashCode();
        an cjD = an.cjD();
        cjD.time = bpb.pgR;
        bwc.b(are, view, i3, hashCode, cjD);
        cVar.rxm.setPressed(false);
        String str2 = bpb.nMq;
        if (b.Qx()) {
            ati Qz = b.Qz();
            if (Qz != null && b.d(Qz) && str2.equals(Qz.wdd)) {
                obj = 1;
                if (obj == null) {
                    cVar.rxm.setImageResource(e.bDS);
                } else {
                    cVar.rxm.setImageResource(e.bDT);
                }
                cVar.rTU.setTag(new r(bpb, str));
                cVar.rTU.setOnClickListener(avVar.rFR.rSE);
                cVar.rLx.setTag(new r(bpb, str));
                avVar.kMf.c(cVar.rLx, avVar.rfs.rVH, avVar.rfs.rVs);
                cVar.rLx.setOnClickListener(avVar.rFR.rLk);
                charSequence = are.nkL;
                if (bi.oN(charSequence)) {
                    cVar.rTV.setVisibility(0);
                    cVar.rTV.setText(charSequence);
                } else {
                    cVar.rTV.setVisibility(4);
                }
                charSequence = are.fpg;
                if (bi.oN(charSequence)) {
                    cVar.ikn.setVisibility(0);
                    cVar.ikn.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                }
                cVar.ikn.setVisibility(8);
                return;
            }
        }
        obj = null;
        if (obj == null) {
            cVar.rxm.setImageResource(e.bDT);
        } else {
            cVar.rxm.setImageResource(e.bDS);
        }
        cVar.rTU.setTag(new r(bpb, str));
        cVar.rTU.setOnClickListener(avVar.rFR.rSE);
        cVar.rLx.setTag(new r(bpb, str));
        avVar.kMf.c(cVar.rLx, avVar.rfs.rVH, avVar.rfs.rVs);
        cVar.rLx.setOnClickListener(avVar.rFR.rLk);
        charSequence = are.nkL;
        if (bi.oN(charSequence)) {
            cVar.rTV.setVisibility(4);
        } else {
            cVar.rTV.setVisibility(0);
            cVar.rTV.setText(charSequence);
        }
        charSequence = are.fpg;
        if (bi.oN(charSequence)) {
            cVar.ikn.setVisibility(8);
            return;
        }
        cVar.ikn.setVisibility(0);
        cVar.ikn.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
    }
}
