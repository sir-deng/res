package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.an;

public final class d extends a {
    public final void d(c cVar) {
        if (cVar.rTR == null || cVar.rTR.getParent() == null) {
            cVar.rUD = cVar.nav.findViewById(f.qIV);
            cVar.rUC = true;
        } else {
            cVar.rTR.setLayoutResource(g.qND);
            if (!cVar.rUC) {
                cVar.rUD = cVar.rTR.inflate();
                cVar.rUC = true;
            }
        }
        cVar.rLx = cVar.rUD;
        cVar.rTU = (TagImageView) cVar.rLx.findViewById(f.qIs);
        cVar.rxm = (ImageView) cVar.rLx.findViewById(f.state);
        cVar.rTV = (TextView) cVar.rLx.findViewById(f.qJm);
        cVar.ikn = (TextView) cVar.rLx.findViewById(f.qLQ);
        cVar.ikn.setTextColor(this.mActivity.getResources().getColor(i.c.black));
        com.tencent.mm.plugin.sns.data.i.b(cVar.rTU, this.mActivity);
    }

    public final void a(c cVar, int i, ay ayVar, bpb bpb, int i2, av avVar) {
        Object obj;
        Object obj2;
        String MH;
        CharSequence charSequence;
        CharSequence charSequence2;
        cVar.rTU.position = i;
        String str = ayVar.ryG;
        m mVar = ayVar.qEj;
        Object obj3 = null;
        if (ayVar.rxi) {
            if (mVar.byB().rll == 2) {
                obj3 = 1;
                cVar.rLx.setTag(cVar);
                cVar.rLx.setOnClickListener(avVar.rfs.rWa);
            }
            obj = null;
            obj2 = obj3;
        } else {
            if (bpb.wYj.wfg == 9) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSy);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 10) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSA);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 17) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSB);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 22) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSC);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 23) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSD);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 14) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSz);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 12) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSH);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 13) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rFR.rSI);
                    obj = null;
                    obj2 = null;
                } else {
                    cVar.rLx.setOnClickListener(null);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 15) {
                if (bpb.wYj.wfh.size() > 0) {
                    cVar.rLx.setTag(new r(bpb, str));
                    cVar.rLx.setOnClickListener(avVar.rfs.rVQ);
                    obj = null;
                    obj2 = null;
                }
            } else if (bpb.wYj.wfg == 26) {
                cVar.rLx.setTag(new r(bpb, str));
                cVar.rLx.setOnClickListener(avVar.rFR.rSJ);
                obj = null;
                obj2 = null;
            } else {
                cVar.rLx.setTag(new r(bpb, str));
                cVar.rLx.setOnClickListener(avVar.rFR.rLk);
                if ((bpb.hcR & 1) > 0) {
                    int obj4 = 1;
                    obj2 = null;
                }
            }
            obj4 = null;
            obj2 = null;
        }
        if (obj2 != null) {
            avVar.kMf.c(cVar.rLx, avVar.rfs.rVK, avVar.rfs.rVs);
        } else {
            avVar.kMf.c(cVar.rLx, avVar.rfs.rVH, avVar.rfs.rVs);
        }
        obj3 = bpb.wYj.wfg == 9 ? 1 : (a.bwF() & 1) <= 0 ? 1 : null;
        if (obj3 != null) {
            MH = av.MH(bpb.wYj.nlE);
        } else {
            MH = "";
        }
        if (bpb.wYj.wfg == 9 || bpb.wYj.wfg == 14 || bpb.wYj.wfg == 12 || bpb.wYj.wfg == 13 || obj2 != null) {
            charSequence = bpb.wYj.nkL;
        } else {
            Object charSequence3 = MH;
        }
        MH = bpb.wYj.fpg;
        if (MH == null || MH.length() <= 40) {
            Object charSequence22 = MH;
        } else {
            charSequence22 = MH.substring(0, 40) + "...";
        }
        cVar.rxm.setVisibility(8);
        if (!bpb.wYj.wfh.isEmpty()) {
            cVar.rTU.setVisibility(0);
            are are = (are) bpb.wYj.wfh.get(0);
            com.tencent.mm.plugin.sns.model.g bwc;
            View view;
            int i3;
            int hashCode;
            an cjD;
            if (bpb.wYj.wfg == 15) {
                cVar.rxm.setImageResource(e.bDT);
                cVar.rxm.setVisibility(0);
                bwc = ae.bwc();
                view = cVar.rTU;
                i3 = i.i.dvL;
                hashCode = this.mActivity.hashCode();
                cjD = an.cjD();
                cjD.time = bpb.pgR;
                bwc.b(are, view, i3, hashCode, cjD);
            } else if (bpb.wYj.wfg == 5) {
                charSequence22 = are.fpg;
                cVar.rxm.setImageResource(e.bHh);
                cVar.rxm.setVisibility(0);
                bwc = ae.bwc();
                view = cVar.rTU;
                i3 = i.i.dvL;
                hashCode = this.mActivity.hashCode();
                cjD = an.cjD();
                cjD.time = bpb.pgR;
                bwc.b(are, view, i3, hashCode, cjD);
            } else if (bpb.wYj.wfg == 18) {
                cVar.rxm.setVisibility(0);
                cVar.rxm.setImageResource(e.bHh);
                cVar.rTU.setVisibility(0);
                bwc = ae.bwc();
                view = cVar.rTU;
                i3 = i.i.dvL;
                hashCode = this.mActivity.hashCode();
                cjD = an.cjD();
                cjD.time = bpb.pgR;
                bwc.b(are, view, i3, hashCode, cjD);
            } else {
                if (!(bpb.reA == null || bi.oN(bpb.reA.ttO))) {
                    cVar.rxm.setImageResource(e.bHh);
                    cVar.rxm.setVisibility(0);
                }
                bwc = ae.bwc();
                view = cVar.rTU;
                i3 = this.mActivity.hashCode();
                an cjD2 = an.cjD();
                cjD2.time = bpb.pgR;
                bwc.b(are, view, i3, cjD2);
            }
        } else if (bpb.wYj.wfg == 18) {
            cVar.rxm.setVisibility(0);
            cVar.rxm.setImageResource(e.bHh);
            cVar.rTU.setVisibility(0);
            ae.bwc().a(cVar.rTU, -1, i.i.dvL, this.mActivity.hashCode());
        } else if (bpb.wYj.wfg == 26) {
            cVar.rTU.setVisibility(0);
            ae.bwc().a(cVar.rTU, -1, i.i.qOS, this.mActivity.hashCode());
        } else {
            cVar.rTU.setVisibility(0);
            ae.bwc().a(cVar.rTU, -1, i.i.dvO, this.mActivity.hashCode());
        }
        if (bpb.wYj.wfg == 15) {
            charSequence3 = "";
            charSequence22 = this.mActivity.getString(j.qQQ);
        }
        if (bi.oN(charSequence3)) {
            cVar.rTV.setVisibility(8);
        } else {
            cVar.rTV.setVisibility(0);
            cVar.rTV.setText(charSequence3);
        }
        if (!bi.oN(charSequence22)) {
            if (cVar.rTV.getVisibility() == 8) {
                if (cVar.rTW != 2) {
                    cVar.ikn.setMaxLines(2);
                }
                cVar.rTW = 2;
            } else {
                if (cVar.rTW != 1) {
                    cVar.ikn.setMaxLines(1);
                }
                cVar.rTW = 1;
            }
            cVar.ikn.setVisibility(0);
            if (obj4 != null) {
                cVar.ikn.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence22, this.mActivity, cVar.ikn));
            } else {
                cVar.ikn.setText(charSequence22);
            }
        } else if (i2 == 1) {
            cVar.ikn.setText(av.MH(bpb.wYj.nlE));
            cVar.ikn.setVisibility(0);
        } else {
            cVar.ikn.setVisibility(8);
        }
    }
}
