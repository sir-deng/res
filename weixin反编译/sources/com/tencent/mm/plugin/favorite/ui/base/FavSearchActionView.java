package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    private ImageButton mAR;
    public List<String> mAS = new LinkedList();
    public List<String> mAT = new LinkedList();
    public a mAU;
    public List<Integer> mAc = new LinkedList();
    public FavTagPanel mzl;

    public interface a {
        void XB();

        void a(List<Integer> list, List<String> list2, List<String> list3, boolean z);

        void b(List<Integer> list, List<String> list2, List<String> list3);
    }

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mAR = (ImageButton) findViewById(R.h.cJA);
        this.mzl = (FavTagPanel) findViewById(R.h.chl);
        if (this.mzl != null) {
            MMTagPanel mMTagPanel = this.mzl;
            int color = getResources().getColor(R.e.white);
            if (mMTagPanel.ymt != null) {
                mMTagPanel.ymt.setTextColor(color);
            }
            this.mzl.ymk = 0;
            this.mzl.ymm = 0;
            this.mzl.nPX = 0;
            this.mzl.nPY = R.e.buj;
            this.mzl.mAn = 0;
            this.mzl.mAm = R.e.white;
            this.mzl.Zs(getResources().getString(R.l.dGK));
            this.mzl.mz(true);
            this.mzl.ymh = false;
            this.mzl.ymi = true;
            mMTagPanel = this.mzl;
            com.tencent.mm.ui.base.MMTagPanel.a anonymousClass1 = new com.tencent.mm.plugin.favorite.ui.base.FavTagPanel.a() {
                public final void zo(String str) {
                    x.d("MicroMsg.FavSearchActionView", "unselected tag %s", str);
                    FavSearchActionView.this.mzl.removeTag(str);
                    zq(str);
                }

                public final void zp(String str) {
                }

                public final void zq(String str) {
                    FavSearchActionView.this.AV(FavSearchActionView.this.mzl.cqq());
                    FavSearchActionView.this.mAS.remove(str);
                    FavSearchActionView.this.aKh();
                    if (FavSearchActionView.this.mAU != null) {
                        FavSearchActionView.this.mAU.a(FavSearchActionView.this.mAc, FavSearchActionView.this.mAT, FavSearchActionView.this.mAS, true);
                    }
                }

                public final void zr(String str) {
                    FavSearchActionView.this.AV(FavSearchActionView.this.mzl.cqq());
                    FavSearchActionView.this.aKh();
                    if (FavSearchActionView.this.mAU != null) {
                        FavSearchActionView.this.mAU.b(FavSearchActionView.this.mAc, FavSearchActionView.this.mAT, FavSearchActionView.this.mAS);
                    }
                }

                public final void zs(String str) {
                    FavSearchActionView.this.AV(str);
                    FavSearchActionView.this.mAU.a(FavSearchActionView.this.mAc, FavSearchActionView.this.mAT, FavSearchActionView.this.mAS, false);
                }

                public final void aEg() {
                    if (FavSearchActionView.this.mAU != null) {
                        FavSearchActionView.this.mAU.XB();
                    }
                }

                public final void AW(String str) {
                    FavSearchActionView.this.AV(FavSearchActionView.this.mzl.cqq());
                    FavSearchActionView.this.mAc.remove(j.W(FavSearchActionView.this.getContext(), str));
                    FavSearchActionView.this.aKh();
                    if (FavSearchActionView.this.mAU != null) {
                        FavSearchActionView.this.mAU.a(FavSearchActionView.this.mAc, FavSearchActionView.this.mAT, FavSearchActionView.this.mAS, true);
                    }
                }

                public final void AX(String str) {
                    x.d("MicroMsg.FavSearchActionView", "unselected type %s", str);
                    FavSearchActionView.this.mzl.AY(str);
                    AW(str);
                }

                public final void j(boolean z, int i) {
                }
            };
            mMTagPanel.mBa = anonymousClass1;
            mMTagPanel.ymq = anonymousClass1;
        }
        if (this.mAR != null) {
            this.mAR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (FavSearchActionView.this.mAU != null) {
                        d dVar;
                        FavTagPanel a = FavSearchActionView.this.mzl;
                        Iterator it = a.mAZ.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            a.removeView(dVar.ymI);
                            a.a(dVar);
                        }
                        a.mAZ.clear();
                        a.cqx();
                        MMTagPanel a2 = FavSearchActionView.this.mzl;
                        it = a2.wml.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            a2.removeView(dVar.ymI);
                            a2.a(dVar);
                        }
                        a2.wml.clear();
                        a2.cqx();
                        FavSearchActionView.this.mzl.cqr();
                        FavSearchActionView.this.mAc.clear();
                        FavSearchActionView.this.mAT.clear();
                        FavSearchActionView.this.mAS.clear();
                        FavSearchActionView.this.mAU.a(FavSearchActionView.this.mAc, FavSearchActionView.this.mAT, FavSearchActionView.this.mAS, true);
                        FavSearchActionView.this.aKh();
                    }
                }
            });
        }
    }

    public final void AV(String str) {
        this.mAT.clear();
        for (String str2 : bi.aD(str, "").split(" ")) {
            if (!bi.oN(str2)) {
                this.mAT.add(str2);
            }
        }
    }

    public final void aKh() {
        if (this.mAc.isEmpty() && this.mAS.isEmpty()) {
            this.mzl.Zs(getResources().getString(R.l.dGK));
        } else {
            this.mzl.Zs("");
        }
    }
}
