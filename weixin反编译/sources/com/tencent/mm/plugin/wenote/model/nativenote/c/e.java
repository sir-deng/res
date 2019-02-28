package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.c.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements a {
    public static boolean mHasInit = false;
    public static volatile e ubm = null;
    public ag mHandler = null;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public int[] ubA = null;
    public int[] ubB = null;
    public PopupWindow ubC = null;
    public PopupWindow ubD = null;
    public PopupWindow ubE = null;
    public PopupWindow ubF = null;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a ubG = null;
    public d ubH = null;
    public b ubI = null;
    public al ubJ = null;
    public al ubK = null;
    public TextView ubL = null;
    public TextView ubM = null;
    public TextView ubN = null;
    public TextView ubO = null;
    public TextView ubP = null;
    public TextView ubQ = null;
    public TextView ubR = null;
    public TextView ubS = null;
    public boolean ubn = true;
    public int ubo = 0;
    public int ubp = 0;
    public int ubq = 14;
    public int ubr = 0;
    public int ubs = 0;
    public int ubt = 0;
    public int ubu = 0;
    public int ubv = 0;
    public int ubw = 0;
    public int ubx = 0;
    public int[] uby = null;
    public int[] ubz = null;

    static /* synthetic */ boolean a(e eVar, ArrayList arrayList, String str) {
        int bXR = eVar.bXR();
        if (bXR == 0) {
            return false;
        }
        int i;
        b bVar;
        StringBuilder stringBuilder = new StringBuilder(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            i = 0;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (bVar != null) {
                    if (bVar.getType() != 1) {
                        i++;
                    } else {
                        stringBuilder.append(((h) bVar).content);
                    }
                }
            }
        } else {
            i = 0;
        }
        int RA = c.RA(stringBuilder.toString());
        if (bXR == 2 || bXR == 3) {
            int i2 = eVar.ubH.hna;
            while (true) {
                bXR = i2;
                if (bXR > eVar.ubH.endPos) {
                    break;
                }
                bVar = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXR);
                if (bVar != null) {
                    if (bVar.getType() == 1) {
                        i2 = (bXR == eVar.ubH.hna && bXR == eVar.ubH.endPos) ? c.c(((h) bVar).content, eVar.ubH.startOffset, eVar.ubH.ubl, false) + 0 : bXR == eVar.ubH.hna ? c.c(((h) bVar).content, eVar.ubH.startOffset, -1, true) + 0 : bXR == eVar.ubH.endPos ? c.c(((h) bVar).content, 0, eVar.ubH.ubl, false) + 0 : c.RA(((h) bVar).content) + 0;
                        int i3 = i;
                        i = RA - i2;
                        i2 = i3;
                    } else if (bVar.getType() != 1) {
                        i2 = i - 1;
                        i = RA;
                    }
                    bXR++;
                    RA = i;
                }
                i2 = i;
                i = RA;
                bXR++;
                RA = i;
            }
        }
        return com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().et(RA, i);
    }

    static /* synthetic */ boolean l(e eVar) {
        if (eVar.bXR() == 3) {
            int i = eVar.ubH.hna;
            while (true) {
                int i2 = i;
                if (i2 > eVar.ubH.endPos) {
                    break;
                }
                b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(i2);
                if (BL != null && BL.getType() == 4 && ((k) BL).tYf.booleanValue()) {
                    return true;
                }
                i = i2 + 1;
            }
        }
        return false;
    }

    private e() {
        mHasInit = false;
    }

    public static e bXS() {
        if (ubm == null) {
            synchronized (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.class) {
                if (ubm == null) {
                    ubm = new e();
                }
            }
        }
        return ubm;
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.ubn;
    }

    private RecyclerView byq() {
        if (this.ubG != null) {
            return this.ubG.bWV();
        }
        return null;
    }

    private int bXT() {
        if (this.ubG != null) {
            return this.ubG.bWS() + this.ubG.bWT();
        }
        return 0;
    }

    public final int bXR() {
        if (!mHasInit) {
            return 0;
        }
        if (this.ubH == null) {
            this.ubH = new d();
        }
        return this.ubH.bXR();
    }

    public final d bXU() {
        if (!mHasInit) {
            return new d();
        }
        if (this.ubH == null) {
            this.ubH = new d();
        }
        return new d(this.ubH.hna, this.ubH.startOffset, this.ubH.endPos, this.ubH.ubl);
    }

    public final boolean t(int i, int i2, int i3, int i4) {
        if (!mHasInit) {
            return false;
        }
        boolean z;
        if (this.ubH == null) {
            this.ubH = new d(i, i2, i3, i4);
            z = true;
        } else if (this.ubH.hna == i && this.ubH.startOffset == i2 && this.ubH.endPos == i3 && this.ubH.ubl == i4) {
            z = false;
        } else {
            this.ubH.set(i, i2, i3, i4);
            z = true;
        }
        if (z) {
            x.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.ubH.hna), Integer.valueOf(this.ubH.startOffset), Integer.valueOf(this.ubH.endPos), Integer.valueOf(this.ubH.ubl));
        }
        return z;
    }

    public final int BN(int i) {
        if (!mHasInit || this.ubH == null || bXR() == 0 || i < this.ubH.hna || i > this.ubH.endPos) {
            return 0;
        }
        if (i == this.ubH.hna && i == this.ubH.endPos) {
            return 1;
        }
        if (i > this.ubH.hna && i < this.ubH.endPos) {
            return 2;
        }
        if (i == this.ubH.hna && i < this.ubH.endPos) {
            return 4;
        }
        if (i <= this.ubH.hna || i != this.ubH.endPos) {
            return 0;
        }
        return 3;
    }

    private void ac(int i, int i2, int i3) {
        if (mHasInit) {
            switch (i) {
                case 2:
                    if (this.ubz != null && this.ubz.length == 2) {
                        this.ubz[0] = i2;
                        this.ubz[1] = i3;
                        return;
                    }
                    return;
                case 3:
                    if (this.ubA != null && this.ubA.length == 2) {
                        this.ubA[0] = i2;
                        this.ubA[1] = i3;
                        return;
                    }
                    return;
                case 4:
                    if (this.ubB != null && this.ubB.length == 2) {
                        this.ubB[0] = i2;
                        this.ubB[1] = i3;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean m(int[] iArr) {
        return (!mHasInit || iArr == null || iArr.length != 2 || iArr[0] == -1 || iArr[1] == -1) ? false : true;
    }

    private void bXV() {
        if (this.ubG != null) {
            this.ubG.bWR();
        }
    }

    public final void bXW() {
        if (mHasInit) {
            t(-1, -1, -1, -1);
            g(true, 0);
            bYa();
            bXY();
        }
    }

    public final void N(boolean z, boolean z2) {
        if (mHasInit) {
            bYa();
            bXY();
            g(true, 50);
            kU(z);
            h(z2, 50);
        }
    }

    public final void g(final boolean z, long j) {
        if (mHasInit && this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    RecyclerView a = e.this.byq();
                    if (a != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < a.getChildCount()) {
                                View childAt = a.getChildAt(i2);
                                c cW = f.cW(childAt);
                                if (cW != null) {
                                    if (cW.ubi != null) {
                                        if (z) {
                                            cW.ubi.postInvalidate();
                                        }
                                    } else if (!(cW.ubj == null || cW.ubk == null)) {
                                        e.this.a((LinearLayout) childAt.findViewById(R.h.cCb), (LinearLayout) childAt.findViewById(R.h.cCf), (LinearLayout) childAt.findViewById(R.h.cCd), cW.ubj.uah);
                                    }
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }, j);
        }
    }

    public final void a(View view, View view2, View view3, int i) {
        if (mHasInit && view != null && view2 != null && view3 != null && this.ubH != null) {
            switch (BN(i)) {
                case 0:
                    view.setVisibility(8);
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
                case 1:
                    if (this.ubH.startOffset == this.ubH.ubl) {
                        view.setVisibility(8);
                    } else {
                        view.setVisibility(0);
                    }
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
                case 2:
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(0);
                    return;
                case 3:
                    if (this.ubH.ubl != 0) {
                        view.setVisibility(0);
                        view2.setVisibility(0);
                        view3.setVisibility(4);
                        return;
                    }
                    break;
                case 4:
                    if (this.ubH.startOffset == 0) {
                        view.setVisibility(0);
                        view2.setVisibility(4);
                        view3.setVisibility(0);
                        return;
                    }
                    view.setVisibility(8);
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
            }
            view.setVisibility(8);
            view2.setVisibility(4);
            view3.setVisibility(4);
        }
    }

    public final boolean bXX() {
        return this.ubF != null && this.ubF.isShowing();
    }

    public final void bXY() {
        if (this.ubF != null) {
            this.ubF.dismiss();
        }
    }

    public final void h(final boolean z, long j) {
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                e.this.kT(z);
            }
        }, 50);
    }

    public final void kT(boolean z) {
        if (mHasInit && this.ubF != null) {
            RecyclerView byq = byq();
            int bXR = bXR();
            if (byq == null || bXR == 0 || ((bXR == 1 && !z) || (this.ubI != null && this.ubI.getType() == 1))) {
                bXY();
                return;
            }
            b BL;
            boolean z2;
            boolean k;
            View view;
            int bXm;
            int bXn;
            b BL2;
            boolean k2;
            View view2;
            boolean k3;
            View view3;
            boolean k4;
            View view4;
            boolean k5;
            View view5;
            int bYd;
            int i;
            int i2;
            int height;
            int height2;
            int height3;
            RecyclerView.h hVar;
            LinearLayoutManager linearLayoutManager;
            int fa;
            int i3;
            boolean k6 = k(this.ubL, false);
            boolean k7 = k(this.ubM, false);
            View view6 = this.ubN;
            if (bXR() == 1) {
                BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(this.ubH.hna);
                if (!(BL == null || (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().size() <= 1 && BL.getType() == 1 && bi.oN(((h) BL).content)))) {
                    z2 = true;
                    k = k(view6, z2);
                    view = this.ubO;
                    bXm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXm();
                    bXn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXn();
                    BL2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXm);
                    BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXn);
                    if (BL2 != null || BL == null) {
                        z2 = false;
                    } else {
                        if (this.ubH != null && this.ubH.hna == bXm && this.ubH.startOffset == 0 && this.ubH.endPos == bXn) {
                            if (BL.getType() == 1) {
                                Spanned Rs = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(((h) BL).content);
                                if (Rs == null) {
                                    z2 = false;
                                } else if (this.ubH.ubl == Rs.length()) {
                                    z2 = false;
                                }
                            } else if (BL.getType() != 1 && this.ubH.ubl == 1) {
                                z2 = false;
                            }
                        }
                        z2 = true;
                    }
                    k2 = k(view, z2);
                    view2 = this.ubP;
                    if (this.ubn) {
                        z2 = false;
                    } else {
                        bXR = bXR();
                        z2 = (bXR != 0 || bXR == 1) ? false : this.ubG != null ? !this.ubG.bWU() : true;
                    }
                    k3 = k(view2, z2);
                    view3 = this.ubQ;
                    bXR = bXR();
                    z2 = this.ubn && (bXR == 2 || bXR == 3);
                    k4 = k(view3, z2);
                    view4 = this.ubR;
                    bXR = bXR();
                    z2 = bXR != 2 || bXR == 3;
                    k5 = k(view4, z2);
                    view5 = this.ubS;
                    z2 = (this.ubn || bXR() == 0) ? false : f.dV(ad.getContext()) != 1;
                    z2 = k6 || k7 || k || k2 || k3 || k4 || k5 || k(view5, z2);
                    if (z2) {
                        bXY();
                    }
                    bXn = C(byq);
                    bYd = bYd();
                    if (this.ubF != null || this.ubF.getContentView() == null) {
                        bXR = 0;
                        i = 0;
                    } else {
                        this.ubF.getContentView().measure(0, 0);
                        i = (this.ubr * 2) + this.ubF.getContentView().getMeasuredHeight();
                        bXR = this.ubF.getContentView().getMeasuredWidth() + (this.ubr * 2);
                    }
                    bXm = i != 0 ? this.ubt : i;
                    if (bXR != 0) {
                        i = this.ubu;
                    } else {
                        i = bXR;
                    }
                    if (this.ubC == null && this.ubC.isShowing() && m(this.ubz)) {
                        i2 = this.ubz[1] - bXm;
                        height = (this.ubz[1] + this.ubC.getHeight()) - this.ubv;
                        if (i2 >= bXn && i2 <= bYd) {
                            bXR = this.ubz[0];
                            height = i2;
                        } else if (height < bXn || height > bYd) {
                            bXR = -1000;
                            height = -1;
                        } else {
                            bXR = this.ubz[0];
                        }
                    } else {
                        if (this.ubD != null && this.ubD.isShowing() && m(this.ubA)) {
                            i2 = this.ubA[1] - bXm;
                            height2 = (this.ubA[1] + this.ubD.getHeight()) - this.ubv;
                            if (i2 < bXn && i2 <= bYd) {
                                bXR = this.ubA[0];
                                height2 = this.ubB[1] - bXm;
                                height3 = (this.ubB[1] + this.ubE.getHeight()) - this.ubv;
                                if (i2 != -1) {
                                    bXR = this.ubB[0];
                                    height = height3;
                                } else {
                                    if (height2 < bXn) {
                                    }
                                    bXR = this.ubB[0];
                                    height = height3;
                                }
                            } else if (height2 >= bXn && height2 <= bYd) {
                                bXR = this.ubA[0];
                                i2 = height2;
                                if (this.ubE != null && this.ubE.isShowing() && m(this.ubB)) {
                                    height2 = this.ubB[1] - bXm;
                                    height3 = (this.ubB[1] + this.ubE.getHeight()) - this.ubv;
                                    if (i2 != -1) {
                                        if (height2 < bXn && height2 <= bYd) {
                                            bXR = this.ubB[0];
                                            height = height2;
                                        } else if (height3 >= bXn && height3 <= bYd) {
                                            bXR = this.ubB[0];
                                            height = height3;
                                        }
                                    } else if (i2 + bXm > this.ubB[1] && height3 >= bXn && height3 <= bYd) {
                                        bXR = this.ubB[0];
                                        height = height3;
                                    }
                                }
                                height = i2;
                            }
                        }
                        bXR = -1000;
                        i2 = -1;
                        height2 = this.ubB[1] - bXm;
                        height3 = (this.ubB[1] + this.ubE.getHeight()) - this.ubv;
                        if (i2 != -1) {
                            if (height2 < bXn) {
                            }
                            bXR = this.ubB[0];
                            height = height3;
                        } else {
                            bXR = this.ubB[0];
                            height = height3;
                        }
                    }
                    if (height == -1) {
                        hVar = byq.TV;
                        if (hVar != null && (hVar instanceof LinearLayoutManager)) {
                            linearLayoutManager = (LinearLayoutManager) hVar;
                            fa = linearLayoutManager.fa();
                            bXR = linearLayoutManager.fb();
                            if (this.ubH.hna <= fa && this.ubH.endPos >= bXR) {
                                height = 300;
                                bXR = -1000;
                            }
                        }
                        bXR = -1000;
                    }
                    if (height == -1) {
                        bXY();
                        return;
                    }
                    fa = this.mScreenWidth / 3;
                    i3 = (this.mScreenWidth * 2) / 3;
                    if (bXR != -1000 || (bXR >= fa && bXR <= i3)) {
                        d(byq, (this.mScreenWidth - i) / 2, height);
                        return;
                    } else if (bXR < fa) {
                        d(byq, this.ubs, height);
                        return;
                    } else {
                        d(byq, (this.mScreenWidth - i) - this.ubs, height);
                        return;
                    }
                }
            }
            z2 = false;
            k = k(view6, z2);
            view = this.ubO;
            bXm = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXm();
            bXn = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXn();
            BL2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXm);
            BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXn);
            if (BL2 != null) {
            }
            z2 = false;
            k2 = k(view, z2);
            view2 = this.ubP;
            if (this.ubn) {
                bXR = bXR();
                if (bXR != 0) {
                }
            } else {
                z2 = false;
            }
            k3 = k(view2, z2);
            view3 = this.ubQ;
            bXR = bXR();
            if (!this.ubn) {
            }
            k4 = k(view3, z2);
            view4 = this.ubR;
            bXR = bXR();
            if (bXR != 2) {
            }
            k5 = k(view4, z2);
            view5 = this.ubS;
            if (this.ubn) {
            }
            if (!k6) {
            }
            if (z2) {
                bXn = C(byq);
                bYd = bYd();
                if (this.ubF != null) {
                }
                bXR = 0;
                i = 0;
                if (i != 0) {
                }
                if (bXR != 0) {
                    i = bXR;
                } else {
                    i = this.ubu;
                }
                if (this.ubC == null) {
                }
                i2 = this.ubA[1] - bXm;
                height2 = (this.ubA[1] + this.ubD.getHeight()) - this.ubv;
                if (i2 < bXn) {
                }
                bXR = this.ubA[0];
                i2 = height2;
                height2 = this.ubB[1] - bXm;
                height3 = (this.ubB[1] + this.ubE.getHeight()) - this.ubv;
                if (i2 != -1) {
                    bXR = this.ubB[0];
                    height = height3;
                    if (height == -1) {
                        hVar = byq.TV;
                        linearLayoutManager = (LinearLayoutManager) hVar;
                        fa = linearLayoutManager.fa();
                        bXR = linearLayoutManager.fb();
                        height = 300;
                        bXR = -1000;
                    }
                    if (height == -1) {
                        fa = this.mScreenWidth / 3;
                        i3 = (this.mScreenWidth * 2) / 3;
                        if (bXR != -1000) {
                        }
                        d(byq, (this.mScreenWidth - i) / 2, height);
                        return;
                    }
                    bXY();
                    return;
                }
                if (height2 < bXn) {
                }
                bXR = this.ubB[0];
                height = height3;
                if (height == -1) {
                    hVar = byq.TV;
                    linearLayoutManager = (LinearLayoutManager) hVar;
                    fa = linearLayoutManager.fa();
                    bXR = linearLayoutManager.fb();
                    height = 300;
                    bXR = -1000;
                }
                if (height == -1) {
                    bXY();
                    return;
                }
                fa = this.mScreenWidth / 3;
                i3 = (this.mScreenWidth * 2) / 3;
                if (bXR != -1000) {
                }
                d(byq, (this.mScreenWidth - i) / 2, height);
                return;
            }
            bXY();
        }
    }

    public final boolean bXZ() {
        return this.ubC != null && this.ubC.isShowing();
    }

    public final void bYa() {
        if (mHasInit) {
            BO(2);
            BO(3);
            BO(4);
        }
    }

    private boolean BO(int i) {
        boolean z = true;
        if (this.ubI != null && this.ubI.kZv == i && this.ubI.getType() == 1) {
            return false;
        }
        if (i == 2 && this.ubC != null) {
            this.ubC.dismiss();
            ac(2, -1, -1);
        } else if (i == 3 && this.ubD != null) {
            this.ubD.dismiss();
            ac(3, -1, -1);
        } else if (i != 4 || this.ubE == null) {
            z = false;
        } else {
            this.ubE.dismiss();
            ac(4, -1, -1);
        }
        return z;
    }

    public final void kU(boolean z) {
        if (mHasInit) {
            RecyclerView byq = byq();
            int bXR = bXR();
            if (byq == null || bXR == 0 || (bXR == 1 && !z)) {
                bYa();
                return;
            }
            View g = f.g(byq, this.ubH.hna);
            View g2 = f.g(byq, this.ubH.endPos);
            if (bXR == 1) {
                BO(3);
                BO(4);
                a(2, byq, g, this.ubH.startOffset);
                return;
            }
            BO(2);
            a(3, byq, g, this.ubH.startOffset);
            a(4, byq, g2, this.ubH.ubl);
        }
    }

    private void a(int i, RecyclerView recyclerView, View view, int i2) {
        if (mHasInit && recyclerView != null) {
            c cW = f.cW(view);
            if (cW == null) {
                BO(i);
                return;
            }
            WXRTEditText wXRTEditText;
            if (cW.ubi != null) {
                wXRTEditText = cW.ubi;
            } else {
                if (!(cW.ubj == null || cW.ubk == null)) {
                    if (i2 == 0) {
                        i2 = 0;
                        wXRTEditText = cW.ubj;
                    } else if (i2 == 1) {
                        i2 = 0;
                        wXRTEditText = cW.ubk;
                    }
                }
                wXRTEditText = null;
            }
            if (wXRTEditText == null) {
                BO(i);
                return;
            }
            Editable text = wXRTEditText.getText();
            if (text == null || i2 < 0 || i2 > text.length()) {
                BO(i);
                return;
            }
            Layout layout = wXRTEditText.getLayout();
            if (layout == null) {
                BO(i);
                return;
            }
            boolean a;
            float primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) wXRTEditText.getPaddingLeft());
            float lineTop = (float) (layout.getLineTop(layout.getLineForOffset(i2)) + wXRTEditText.getPaddingTop());
            if (wXRTEditText.tZU != 0) {
                lineTop = (lineTop + ((float) wXRTEditText.getHeight())) - ((float) this.ubo);
                if (i == 3) {
                    primaryHorizontal += (float) this.ubx;
                } else if (i == 4) {
                    primaryHorizontal -= (float) this.ubx;
                }
            }
            int[] iArr = new int[2];
            wXRTEditText.getLocationOnScreen(iArr);
            switch (i) {
                case 2:
                    a = a(2, recyclerView, this.ubC, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.ubw)), (int) (((float) iArr[1]) + lineTop));
                    break;
                case 3:
                    a = a(3, recyclerView, this.ubD, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.ubD.getWidth())), (int) (((float) iArr[1]) + lineTop));
                    break;
                case 4:
                    a = a(4, recyclerView, this.ubE, (int) (primaryHorizontal + ((float) iArr[0])), (int) (((float) iArr[1]) + lineTop));
                    break;
                default:
                    a = false;
                    break;
            }
            if (!a) {
                BO(i);
            }
        }
    }

    private boolean a(int i, RecyclerView recyclerView, PopupWindow popupWindow, int i2, int i3) {
        if (!mHasInit || recyclerView == null || popupWindow == null || i3 < C(recyclerView) || i3 > this.mScreenHeight - bXT()) {
            return false;
        }
        if (popupWindow.isShowing()) {
            popupWindow.update(i2, i3, -1, -1, false);
            ac(i, i2, i3);
        } else {
            popupWindow.showAtLocation(recyclerView, 0, i2, i3);
            ac(i, i2, i3);
        }
        if (i == 2) {
            if (this.ubK == null) {
                this.ubK = new al(new al.a() {
                    public final boolean uG() {
                        if (e.this.bXR() == 1 && e.this.BO(2)) {
                            e.this.bXY();
                        }
                        return true;
                    }
                }, false);
            } else {
                this.ubK.TN();
            }
            this.ubK.K(3000, 0);
        }
        return true;
    }

    private boolean d(RecyclerView recyclerView, int i, int i2) {
        if (!mHasInit || recyclerView == null || this.ubF == null || i2 < C(recyclerView) || i2 > this.mScreenHeight - bXT()) {
            return false;
        }
        if (this.ubF.isShowing()) {
            this.ubF.update(i, i2, -1, -1, false);
        } else {
            this.ubF.showAtLocation(recyclerView, 0, i, i2);
        }
        return true;
    }

    public final void a(int i, MotionEvent motionEvent) {
        if (mHasInit && this.mHandler != null) {
            if (this.ubI == null || this.ubI.getType() != 1 || this.ubI.kZv == i) {
                switch (motionEvent.getAction()) {
                    case 0:
                        bYb();
                        if (!bXX()) {
                            kT(true);
                        }
                        this.ubI.a(i, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                        return;
                    case 1:
                    case 3:
                        bYb();
                        this.mHandler.postDelayed(new Runnable() {
                            public final void run() {
                                e.this.kU(true);
                                e.this.kT(true);
                            }
                        }, 200);
                        return;
                    case 2:
                        if (this.ubI != null && this.ubI.getType() == 1) {
                            this.ubI.uba = motionEvent.getRawX();
                            this.ubI.ubb = motionEvent.getRawY();
                            kV(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void kV(boolean z) {
        if (mHasInit && this.ubC != null && this.ubD != null && this.ubE != null && this.ubH != null) {
            RecyclerView byq = byq();
            if (byq != null && this.ubI != null && this.ubI.getType() == 1) {
                int i = this.ubI.kZv;
                if (i == 2 || i == 3 || i == 4) {
                    int i2;
                    boolean z2;
                    float f = this.ubI.uba - this.ubI.iTW;
                    float f2 = ((float) (this.ubo / 2)) + (this.ubI.ubb - this.ubI.iTX);
                    if (i == 2) {
                        f += (float) (this.ubC.getWidth() / 2);
                    } else if (i == 3) {
                        f += (float) this.ubD.getWidth();
                    }
                    byq.getLocationOnScreen(this.uby);
                    View j = byq.j(f - ((float) this.uby[0]), f2 - ((float) this.uby[1]));
                    c cW = f.cW(j);
                    WXRTEditText wXRTEditText = null;
                    if (cW == null) {
                        i2 = 2;
                    } else if (cW.ubi != null) {
                        wXRTEditText = cW.ubi;
                        int[] iArr = new int[2];
                        wXRTEditText.getLocationOnScreen(iArr);
                        i2 = ad(i, wXRTEditText.uah, wXRTEditText.getOffsetForPosition(f - ((float) iArr[0]), f2 - ((float) iArr[1])));
                    } else if (cW.ubj == null || cW.ubk == null) {
                        i2 = 0;
                    } else {
                        WXRTEditText wXRTEditText2;
                        int ad;
                        if (i == 3) {
                            wXRTEditText2 = cW.ubj;
                            ad = ad(i, wXRTEditText2.uah, 0);
                            if (ad == 2 || ad == 3) {
                                a(i, byq, this.ubD, (int) (this.ubI.uba - this.ubI.iTW), (int) (this.ubI.ubb - this.ubI.iTX));
                                i2 = ad;
                                wXRTEditText = wXRTEditText2;
                            }
                        } else if (i == 4) {
                            wXRTEditText2 = cW.ubk;
                            ad = ad(i, wXRTEditText2.uah, 1);
                            if (ad == 2 || ad == 3) {
                                a(i, byq, this.ubE, (int) (this.ubI.uba - this.ubI.iTW), (int) (this.ubI.ubb - this.ubI.iTX));
                                i2 = ad;
                                wXRTEditText = wXRTEditText2;
                            }
                        } else {
                            int[] iArr2 = new int[2];
                            j.getLocationOnScreen(iArr2);
                            if (f <= ((float) (iArr2[0] + (j.getWidth() / 2)))) {
                                wXRTEditText2 = cW.ubj;
                                ad = ad(i, wXRTEditText2.uah, 0);
                            } else {
                                wXRTEditText2 = cW.ubk;
                                ad = ad(i, wXRTEditText2.uah, 1);
                            }
                            if (ad == 2 || ad == 3) {
                                a(i, byq, this.ubC, (int) (this.ubI.uba - this.ubI.iTW), (int) (this.ubI.ubb - this.ubI.iTX));
                            }
                        }
                        i2 = ad;
                        wXRTEditText = wXRTEditText2;
                    }
                    switch (i2) {
                        case 1:
                            z2 = false;
                            break;
                        case 2:
                            z2 = true;
                            break;
                        case 3:
                            Editable text = wXRTEditText.getText();
                            int bXR = bXR();
                            if (this.ubn && text != null && bXR == 1) {
                                if (!wXRTEditText.hasFocus()) {
                                    wXRTEditText.requestFocus();
                                }
                                if (wXRTEditText.tZU == 1 || wXRTEditText.tZU == 2) {
                                    wXRTEditText.uak = true;
                                    wXRTEditText.setSelection(0);
                                    wXRTEditText.uak = false;
                                } else if (this.ubH.startOffset <= text.length()) {
                                    wXRTEditText.uak = true;
                                    wXRTEditText.setSelection(this.ubH.startOffset);
                                    wXRTEditText.uak = false;
                                }
                            } else if (this.ubn && text != null && bXR == 2 && wXRTEditText.hasFocus()) {
                                if (wXRTEditText.tZU == 1 || wXRTEditText.tZU == 2) {
                                    wXRTEditText.uak = true;
                                    wXRTEditText.setSelection(0);
                                    wXRTEditText.uak = false;
                                } else if (this.ubH.startOffset <= text.length() && this.ubH.ubl <= text.length()) {
                                    wXRTEditText.uak = true;
                                    wXRTEditText.setSelection(this.ubH.startOffset, this.ubH.ubl);
                                    wXRTEditText.uak = false;
                                }
                            }
                            if (bXR == 3 || bXR == 0) {
                                bXV();
                            }
                            bXY();
                            g(true, 0);
                            if (i == 4) {
                                i2 = this.ubH.ubl;
                            } else {
                                i2 = this.ubH.startOffset;
                            }
                            a(i, byq, j, i2);
                            z2 = true;
                            break;
                        default:
                            return;
                    }
                    if (!z2) {
                        bYc();
                    } else if (!z) {
                    } else {
                        if (this.ubI.ubb >= ((float) C(byq)) && this.ubI.ubb <= ((float) bYd())) {
                            return;
                        }
                        if (this.ubJ == null || this.ubJ.cgx()) {
                            bYc();
                            this.ubJ.K(100, 100);
                        }
                    }
                }
            }
        }
    }

    private int ad(int i, int i2, int i3) {
        if (!mHasInit) {
            return 0;
        }
        boolean t;
        switch (i) {
            case 2:
                t = t(i2, i3, i2, i3);
                break;
            case 3:
                if (this.ubH != null && i2 <= this.ubH.endPos && (i2 != this.ubH.endPos || i3 < this.ubH.ubl)) {
                    t = t(i2, i3, this.ubH.endPos, this.ubH.ubl);
                    break;
                }
                return 1;
                break;
            case 4:
                if (this.ubH != null && i2 >= this.ubH.hna && (i2 != this.ubH.hna || i3 > this.ubH.startOffset)) {
                    t = t(this.ubH.hna, this.ubH.startOffset, i2, i3);
                    break;
                }
                return 1;
            default:
                return 0;
        }
        if (t) {
            return 3;
        }
        return 2;
    }

    private void bYb() {
        if (this.ubI == null) {
            this.ubI = new b();
        } else {
            this.ubI.reset();
        }
    }

    private void bYc() {
        if (this.ubJ == null) {
            this.ubJ = new al(new al.a() {
                public final boolean uG() {
                    boolean z;
                    x.d("NoteSelectManager", "onTimerExpired: ");
                    RecyclerView a = e.this.byq();
                    boolean z2 = e.this.ubI != null && e.this.ubI.ubb < ((float) e.this.C(a));
                    if (e.this.ubI == null || e.this.ubI.ubb <= ((float) e.this.bYd())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (e.mHasInit && a != null && e.this.ubI != null && e.this.ubI.getType() == 1 && (z2 || z)) {
                        if (z2 && a.canScrollVertically(-1)) {
                            if (e.this.ubI.kZv == 3) {
                                e.this.bXV();
                            }
                            e.this.kV(false);
                            e.this.bYa();
                            e.this.bXY();
                            a.smoothScrollBy(0, -300);
                        } else if (z && a.canScrollVertically(1)) {
                            e.this.kV(false);
                            e.this.bYa();
                            e.this.bXY();
                            a.smoothScrollBy(0, 300);
                        }
                    } else if (e.this.ubJ != null) {
                        e.this.ubJ.TN();
                    }
                    return true;
                }
            }, true);
        } else {
            this.ubJ.TN();
        }
    }

    private int C(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 150;
        }
        recyclerView.getLocationOnScreen(this.uby);
        if (m(this.uby)) {
            return this.uby[1];
        }
        return 150;
    }

    private int bYd() {
        int i = 0;
        if (this.ubG != null) {
            i = this.ubG.bWS();
        }
        if (i == 0 && this.ubG != null) {
            i = this.ubG.bWT();
        }
        if (i == 0) {
            i = 150;
        }
        return this.mScreenHeight - i;
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            textView.setTextSize(1, (float) i);
        }
    }

    private void bYe() {
        if (this.ubG != null) {
            this.ubG.bWQ();
        }
    }

    public final void bYf() {
        x.i("NoteSelectManager", "deleteSelectedData");
        if (mHasInit) {
            bXY();
            int bXR = bXR();
            if (bXR == 2) {
                a(true, null, "");
                return;
            } else if (bXR == 3) {
                b(true, null, "");
                return;
            } else {
                x.e("NoteSelectManager", "deleteSelectedData: not in select");
                bYe();
                return;
            }
        }
        x.e("NoteSelectManager", "deleteSelectedData: not init");
    }

    private SpannableStringBuilder a(boolean z, ArrayList<b> arrayList, String str) {
        int i = 2;
        d bXU = bXU();
        bXW();
        int bXR = bXU.bXR();
        if (bXR == 1 || bXR == 2) {
            b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(bXU.hna);
            if (BL == null) {
                x.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                return null;
            }
            SpannableStringBuilder spannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (BL.getType() != 1) {
                if (bXR == 1 && z) {
                    ArrayList arrayList2;
                    if (bXU.startOffset == 0) {
                        i = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = arrayList;
                    } else if (bi.oN(str)) {
                        return spannableStringBuilder2;
                    } else {
                        arrayList2 = new ArrayList();
                        h hVar = new h();
                        hVar.content = str;
                        hVar.tXR = false;
                        hVar.tXT = -1;
                        arrayList2.add(hVar);
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(arrayList2, i, bXU.hna, bXU.startOffset, bXU.ubl);
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().eu(bXU.hna - 1, (arrayList2.size() + bXU.hna) + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = a((h) BL, bXU.startOffset, bXU.ubl, false, z, str, true);
                if (this.ubG != null) {
                    this.ubG.BE(bXU.hna);
                }
                if (z) {
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXl();
                }
            } else {
                spannableStringBuilder = a((h) BL, bXU.startOffset, bXU.ubl, false, false, "", true);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a((ArrayList) arrayList, 0, bXU.hna, bXU.startOffset, bXU.ubl);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().eu(bXU.hna, (bXU.hna + arrayList.size()) + 1);
            }
            return spannableStringBuilder;
        }
        x.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        return null;
    }

    private ArrayList<b> b(boolean z, ArrayList<b> arrayList, String str) {
        d bXU = bXU();
        bXW();
        List arrayList2 = new ArrayList();
        if (bXU.bXR() != 3) {
            x.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            return null;
        }
        int i;
        int i2 = bXU.hna;
        int i3 = bXU.endPos;
        while (true) {
            int i4 = i3;
            i = i2;
            if (i4 < bXU.hna) {
                break;
            }
            b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(i4);
            if (BL != null) {
                h hVar;
                Object a;
                h hVar2;
                if (i4 == bXU.endPos && BL.getType() == 1) {
                    hVar = (h) BL;
                    a = a(hVar, 0, bXU.ubl, false, z, "", false);
                    if (!bi.N(a)) {
                        hVar2 = new h();
                        hVar2.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                        hVar2.tXT = -1;
                        hVar2.tXR = false;
                        arrayList2.add(hVar2);
                    }
                    if (z && bi.oN(hVar.content)) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().W(i4, true);
                    }
                } else if (i4 == bXU.hna && BL.getType() == 1) {
                    hVar = (h) BL;
                    a = a(hVar, bXU.startOffset, 0, true, z, "", false);
                    if (!bi.N(a)) {
                        hVar2 = new h();
                        hVar2.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                        hVar2.tXT = -1;
                        hVar2.tXR = false;
                        arrayList2.add(hVar2);
                    }
                    if (z && bi.oN(hVar.content)) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().W(i4, true);
                    } else {
                        i++;
                    }
                } else {
                    arrayList2.add(c.c(BL));
                    if (z) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().W(i4, true);
                    }
                }
            }
            i2 = i;
            i3 = i4 - 1;
        }
        if (z) {
            i2 = i - 1;
            i3 = i + 1;
            if (arrayList == null || arrayList.size() <= 0) {
                b hVar3 = new h();
                if (str == null) {
                    str = "";
                }
                hVar3.content = str;
                hVar3.tXR = false;
                hVar3.tXT = -1;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(i, hVar3);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(i, (ArrayList) arrayList);
                i3 = arrayList.size() + i;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().eu(i2, i3);
        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    private static SpannableStringBuilder a(h hVar, int i, int i2, boolean z, boolean z2, String str, boolean z3) {
        SpannableStringBuilder spannableStringBuilder = null;
        if (hVar == null) {
            x.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
        } else {
            Spanned Rs = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(hVar.content);
            if (Rs == null) {
                x.e("NoteSelectManager", "processTextDataItem: spannedText is null");
            } else {
                int length;
                if (z) {
                    length = Rs.length();
                } else {
                    length = i2;
                }
                if (str == null) {
                    str = "";
                }
                if (i < 0 || i > Rs.length() || length < 0 || length > Rs.length() || i > length) {
                    x.e("NoteSelectManager", "processTextDataItem: incorrect offset");
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) Rs.subSequence(0, i);
                    spannableStringBuilder = (SpannableStringBuilder) Rs.subSequence(i, length);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) Rs.subSequence(length, Rs.length());
                    if (z2) {
                        length = spannableStringBuilder2.length();
                        if (!bi.oN(str)) {
                            Spanned Rs2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Rs(str);
                            if (Rs2 != null) {
                                length += Rs2.length();
                            }
                        }
                        hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannableStringBuilder2) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannableStringBuilder3);
                    }
                    if (z3) {
                        hVar.tXR = true;
                        hVar.tXT = length;
                    } else {
                        hVar.tXR = false;
                        hVar.tXT = -1;
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    private static boolean k(View view, boolean z) {
        if (view == null) {
            return false;
        }
        if (z) {
            view.setVisibility(0);
            return true;
        }
        view.setVisibility(8);
        return false;
    }
}
