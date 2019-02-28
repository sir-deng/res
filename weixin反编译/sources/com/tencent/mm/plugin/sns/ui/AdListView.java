package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.b;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public class AdListView extends ListView {
    b rwa;
    f rwb;
    e rwc;
    private boolean rwd = true;
    private HashSet<String> rwe = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void layoutChildren() {
        super.layoutChildren();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void detachViewFromParent(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.fsC;
        }
        if (r.ign) {
            x.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
    }

    protected void detachViewFromParent(int i) {
        if (r.ign) {
            x.d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
    }

    protected void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.fsC;
            d.rjE.Lz(cVar.rUN.nMq);
            d.rjE.en(cVar.rUN.nMq, cVar.rUN.wYi == null ? "" : cVar.rUN.wYi.nMq);
            if (this.rwa != null && cVar.qWK) {
                this.rwa.a(cVar.position, cVar.fsC, cVar.iWv, cVar.ngR, view, cVar.rTG, cVar.qWL, cVar.qUf, cVar.kZv, 1);
            }
            if (!this.rwe.contains(cVar.fAR) && ((cVar.qWK && cVar.rUN.wYj.wfg == 15) || cVar.rUN.wYj.wfg == 18)) {
                boolean z = false;
                if (cVar.rUN.wYj.wfg == 15 && (cVar.rUI.qBQ instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.rUI.qBQ).qAD.btu();
                }
                j.a(ae.bwf().LQ(cVar.fAR), false, z);
                this.rwe.add(cVar.fAR);
            }
            if (this.rwb != null) {
                this.rwb.a(cVar.fsC, cVar.rUN);
            }
            if (this.rwc != null) {
                this.rwc.a(cVar.position, cVar.fsC, cVar.rTG, cVar.iWv, cVar.rUN, cVar.qWK, cVar.qWL);
            }
            str = str2;
        }
        if (r.ign) {
            x.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewAdded(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.fsC;
            d.rjE.Lz(cVar.rUN.nMq);
            d.rjE.en(cVar.rUN.nMq, cVar.rUN.wYi == null ? "" : cVar.rUN.wYi.nMq);
            if (this.rwa != null && cVar.qWK) {
                this.rwa.a(cVar.position, cVar.fsC, cVar.iWv, cVar.ngR, view, cVar.rTG, cVar.qWL, cVar.qUf, cVar.kZv, 1);
            }
            if (!this.rwe.contains(cVar.fAR) && ((cVar.qWK && cVar.rUN.wYj.wfg == 15) || cVar.rUN.wYj.wfg == 18)) {
                boolean z = false;
                if (cVar.rUN.wYj.wfg == 15 && (cVar.rUI.qBQ instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.rUI.qBQ).qAD.btu();
                }
                j.a(ae.bwf().LQ(cVar.fAR), false, z);
                this.rwe.add(cVar.fAR);
            }
            if (this.rwb != null) {
                this.rwb.a(cVar.fsC, cVar.rUN);
            }
            if (this.rwc != null) {
                this.rwc.a(cVar.position, cVar.fsC, cVar.rTG, cVar.iWv, cVar.rUN, cVar.qWK, cVar.qWL);
            }
            str = str2;
        }
        if (r.ign) {
            x.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewRemoved(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.fsC;
            if (this.rwa != null && cVar.qWK) {
                this.rwa.t(cVar.position, cVar.fsC, cVar.iWv);
            }
            if (this.rwb != null) {
                this.rwb.KD(cVar.fsC);
            }
            if (this.rwc != null) {
                this.rwc.a(cVar.position, cVar.fsC, cVar.rTG, cVar.iWv, cVar.rUN, cVar.qWK);
            }
            if (cVar.rUN.wYj.wfg == 3) {
                m LQ = ae.bwf().LQ(cVar.fAR);
                int bzm = LQ == null ? 0 : LQ.bzm();
                a aVar = a.Sns;
                String str3 = cVar.rUN.rzD;
                String er = i.er(cVar.rTG);
                if (!bi.oN(str3)) {
                    byte[] bArr = new byte[0];
                    try {
                        bArr = Base64.decode(str3, 0);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, null, new Object[0]);
                    }
                    bnd bnd = new bnd();
                    try {
                        bnd.aH(bArr);
                        if (bnd.wXc == null) {
                            str = str2;
                        } else {
                            x.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", Integer.valueOf(aVar.value), str3, bnd.wXc.wXf, bnd.wXc.wXg);
                            ((com.tencent.mm.plugin.sns.b.c) g.h(com.tencent.mm.plugin.sns.b.c.class)).a(13235, bzm, aVar.value, bnd.wXc.wXf, bnd.wXc.wXg, er);
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (r.ign) {
            x.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    public void removeViewInLayout(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.fsC;
        }
        if (r.ign) {
            x.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
    }

    public void removeView(View view) {
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.fsC;
        }
        if (r.ign) {
            x.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    protected void detachViewsFromParent(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof c)) {
                c cVar = (c) childAt.getTag();
                if (this.rwa != null && cVar.qWK) {
                    this.rwa.t(cVar.position, cVar.fsC, cVar.iWv);
                }
                if (this.rwb != null) {
                    this.rwb.KD(cVar.fsC);
                }
                if (this.rwc != null) {
                    this.rwc.a(cVar.position, cVar.fsC, cVar.rTG, cVar.iWv, cVar.rUN, cVar.qWK);
                }
                str = cVar.position + " " + cVar.fsC;
            }
            if (r.ign) {
                x.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
    }
}
