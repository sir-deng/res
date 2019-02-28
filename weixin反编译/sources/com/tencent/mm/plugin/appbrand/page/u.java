package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.n;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class u {
    c jJF;
    private ViewGroup jKO;
    List<b> jKP;
    int jKQ = -1;
    float[] jKR;
    View jKS;
    y jKT;
    int jKU = -1;
    ag mHandler;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$4 */
    class AnonymousClass4 extends bd<Boolean> {
        AnonymousClass4(Boolean bool) {
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return ajW();
        }

        private Boolean ajW() {
            try {
                u uVar = u.this;
                LinkedList linkedList = new LinkedList();
                for (b bVar : uVar.jKP) {
                    linkedList.add(Integer.valueOf(bVar.id));
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    uVar.lD(((Integer) it.next()).intValue());
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error " + e);
            }
            return Boolean.valueOf(false);
        }
    }

    private static final class a implements com.tencent.mm.plugin.appbrand.page.z.a {
        float jLc;
        float jLd;
        View view;
        float x;
        float y;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void bQ(int i, int i2) {
            this.jLc = (float) i;
            this.jLd = (float) i2;
            this.view.setX(this.x + ((float) i));
            this.view.setY(this.y + ((float) i2));
        }
    }

    private static class b {
        int id;
        WeakReference<View> jLe;
        public int jLf;
        boolean jLg;
        a jLh;
        int z;

        public b(View view, int i, int i2, int i3, boolean z) {
            this.jLe = new WeakReference(view);
            this.id = i;
            this.jLf = i2;
            this.z = i3;
            this.jLg = z;
        }
    }

    public u(ViewGroup viewGroup) {
        this.jKO = viewGroup;
        this.mHandler = new ag(Looper.getMainLooper());
        this.jKP = new LinkedList();
        this.jKS = new View(viewGroup.getContext());
    }

    public final void a(c cVar) {
        this.jJF = cVar;
        this.jJF.a(new x() {
            public final void agJ() {
                u uVar = u.this;
                b lE = uVar.lE(uVar.jKU);
                float[] fArr = uVar.jKR;
                if (!(lE == null || lE.jLe == null || fArr == null)) {
                    View view = (View) lE.jLe.get();
                    if (view != null) {
                        if (uVar.jKU != uVar.jKQ) {
                            b lE2 = uVar.lE(uVar.jKQ);
                            if (!(lE2 == null || lE2.jLe == null)) {
                                View view2 = (View) lE2.jLe.get();
                                if (view2 != null) {
                                    uVar.b(uVar.jKQ, fArr, view2.getVisibility(), Boolean.valueOf(lE.jLg));
                                }
                            }
                        }
                        int i = uVar.jKU;
                        uVar.jKQ = -1;
                        uVar.jKU = -1;
                        uVar.b(i, fArr, view.getVisibility(), Boolean.valueOf(lE.jLg));
                    }
                }
                if (u.this.jKT != null) {
                    u.this.jKT.agJ();
                    u.this.jKT = null;
                }
            }
        });
    }

    public final boolean a(View view, int i, int i2, float[] fArr, int i3, boolean z) {
        final View view2 = view;
        final int i4 = i;
        final int i5 = i2;
        final float[] fArr2 = fArr;
        final int i6 = i3;
        final boolean z2 = z;
        bd anonymousClass2 = new bd<Boolean>(Boolean.valueOf(false)) {
            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(u.this.b(view2, i4, i5, fArr2, i6, z2));
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass2.b(null)).booleanValue();
        }
        return ((Boolean) anonymousClass2.b(this.mHandler)).booleanValue();
    }

    final boolean b(View view, int i, int i2, float[] fArr, int i3, boolean z) {
        if (view == null || fArr == null || fArr.length < 5) {
            return false;
        }
        ViewGroup lB = lB(i2);
        if (lB == null) {
            return false;
        }
        if (lG(i) != null) {
            return false;
        }
        int i4;
        float f;
        float f2;
        float f3 = fArr[0];
        float f4 = fArr[1];
        int i5 = (int) fArr[4];
        LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
        int bP = bP(i2, i5);
        if (bP < 0) {
            i4 = 0;
        } else {
            i4 = bP;
        }
        if (lB instanceof n) {
            bP = ((n) lB).agy();
        } else {
            bP = lB.getChildCount();
        }
        if (i4 > bP) {
            i4 = bP;
        }
        if (i3 >= 0) {
            view.setVisibility(i3 == 0 ? 0 : 4);
        }
        lB.addView(view, i4, layoutParams);
        b bVar = new b(view, i, i2, i5, z);
        this.jKP.add(bVar);
        if (i2 == 0 && (lB instanceof z) && z) {
            Object aVar = new a();
            aVar.view = view;
            aVar.x = f3;
            aVar.y = f4;
            aVar.jLc = (float) this.jKO.getScrollX();
            aVar.jLd = (float) this.jKO.getScrollY();
            float f5 = f3 + aVar.jLc;
            f = aVar.jLd + f4;
            ((z) lB).a(aVar);
            bVar.jLh = aVar;
            f2 = f;
            f = f5;
        } else {
            f2 = f4;
            f = f3;
        }
        view.setX(f);
        view.setY(f2);
        return true;
    }

    final ViewGroup lB(int i) {
        if (i == 0) {
            return this.jKO;
        }
        b lE = lE(i);
        if (lE == null) {
            return null;
        }
        View view = (View) lE.jLe.get();
        return ((view instanceof o) && (view instanceof ViewGroup)) ? (ViewGroup) view : null;
    }

    public final boolean lC(final int i) {
        bd anonymousClass3 = new bd<Boolean>(Boolean.valueOf(false)) {
            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(u.this.lD(i));
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass3.b(null)).booleanValue();
        }
        return ((Boolean) anonymousClass3.b(this.mHandler)).booleanValue();
    }

    final boolean lD(int i) {
        b lE = lE(i);
        if (lE == null) {
            return false;
        }
        lK(i);
        a(lE);
        ViewGroup lB = lB(lE.jLf);
        if (lB == null) {
            return false;
        }
        this.jKP.remove(lE);
        lB.removeView((View) lE.jLe.get());
        if (lE.jLf == 0 && (lB instanceof z) && lE.jLg) {
            ((z) lB).b(lE.jLh);
        }
        return true;
    }

    public final boolean a(int i, float[] fArr, int i2, Boolean bool) {
        final int i3 = i;
        final float[] fArr2 = fArr;
        final int i4 = i2;
        final Boolean bool2 = bool;
        bd anonymousClass5 = new bd<Boolean>(Boolean.valueOf(false)) {
            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(u.this.b(i3, fArr2, i4, bool2));
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass5.b(null)).booleanValue();
        }
        return ((Boolean) anonymousClass5.b(this.mHandler)).booleanValue();
    }

    final boolean b(int i, float[] fArr, int i2, Boolean bool) {
        if (lI(i)) {
            return true;
        }
        b lE = lE(i);
        if (lE == null) {
            return false;
        }
        View view = (View) lE.jLe.get();
        ViewGroup lB = lB(lE.jLf);
        if (lB == null) {
            return false;
        }
        if (i2 >= 0) {
            view.setVisibility(i2 == 0 ? 0 : 4);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        boolean booleanValue = bool != null ? bool.booleanValue() : lE.jLg;
        if (lE.z != i3) {
            this.jKP.remove(lE);
            lB.removeView(view);
            if (b(view, i, lE.jLf, fArr, i2, booleanValue)) {
                return true;
            }
            a(lE);
            return false;
        }
        a aVar;
        float f5;
        float f6;
        LayoutParams layoutParams;
        com.tencent.mm.plugin.appbrand.page.z.a aVar2 = lE.jLh;
        if (lE.jLf == 0 && (lB instanceof z) && booleanValue != lE.jLg) {
            if (booleanValue) {
                if (aVar2 == null) {
                    aVar = new a();
                    aVar.view = view;
                    lE.jLh = aVar;
                    aVar2 = aVar;
                }
                ((z) lB).a(aVar2);
                aVar = aVar2;
                if (aVar == null) {
                    aVar.x = f;
                    aVar.y = f2;
                    aVar.jLc = (float) this.jKO.getScrollX();
                    aVar.jLd = (float) this.jKO.getScrollY();
                    f5 = aVar.jLc + f;
                    f6 = aVar.jLd + f2;
                } else {
                    f6 = f2;
                    f5 = f;
                }
                layoutParams = view.getLayoutParams();
                layoutParams.width = (int) f3;
                layoutParams.height = (int) f4;
                view.setX(f5);
                view.setY(f6);
                view.requestLayout();
                i3 = lB.indexOfChild(this.jKS);
                if (lB.indexOfChild(view) == -1 && i3 != -1) {
                    lB.addView(view, i3);
                    lB.removeView(this.jKS);
                }
                return true;
            }
            ((z) lB).b(lE.jLh);
        }
        com.tencent.mm.plugin.appbrand.page.z.a aVar3 = aVar2;
        if (aVar == null) {
            f6 = f2;
            f5 = f;
        } else {
            aVar.x = f;
            aVar.y = f2;
            aVar.jLc = (float) this.jKO.getScrollX();
            aVar.jLd = (float) this.jKO.getScrollY();
            f5 = aVar.jLc + f;
            f6 = aVar.jLd + f2;
        }
        layoutParams = view.getLayoutParams();
        layoutParams.width = (int) f3;
        layoutParams.height = (int) f4;
        view.setX(f5);
        view.setY(f6);
        view.requestLayout();
        i3 = lB.indexOfChild(this.jKS);
        lB.addView(view, i3);
        lB.removeView(this.jKS);
        return true;
    }

    private void a(b bVar) {
        this.jKP.removeAll(b(bVar));
    }

    private List<b> b(b bVar) {
        List<b> linkedList = new LinkedList();
        for (b bVar2 : this.jKP) {
            if (bVar2.jLf == bVar.id) {
                linkedList.addAll(b(bVar2));
            }
        }
        linkedList.add(bVar);
        return linkedList;
    }

    private int bP(int i, int i2) {
        int i3 = 0;
        Iterator it = this.jKP.iterator();
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return i4;
            }
            b bVar = (b) it.next();
            if (i == bVar.jLf && i2 >= bVar.z) {
                i4++;
            }
            i3 = i4;
        }
    }

    public final b lE(int i) {
        for (b bVar : this.jKP) {
            if (bVar.id == i) {
                return bVar;
            }
        }
        return null;
    }

    public final boolean lF(int i) {
        return lE(i) != null;
    }

    public final View lG(int i) {
        b lE = lE(i);
        return lE == null ? null : (View) lE.jLe.get();
    }

    public final com.tencent.mm.y.u.b lH(int i) {
        return com.tencent.mm.y.u.GQ().hB(hashCode() + "#" + i);
    }

    public final com.tencent.mm.y.u.b z(int i, boolean z) {
        return com.tencent.mm.y.u.GQ().t(hashCode() + "#" + i, z);
    }

    public final boolean lI(int i) {
        return this.jKU == i || this.jKQ == i;
    }

    public final boolean a(int i, y yVar, int i2) {
        final int i3 = i;
        final y yVar2 = yVar;
        final int i4 = i2;
        bd anonymousClass6 = new bd<Boolean>(Boolean.valueOf(false)) {
            protected final /* synthetic */ Object run() {
                boolean z;
                u uVar = u.this;
                int i = i3;
                y yVar = yVar2;
                int i2 = i4;
                if (i == uVar.jKQ) {
                    z = false;
                } else {
                    b lE = uVar.lE(i);
                    if (lE == null || lE.jLe == null) {
                        z = false;
                    } else {
                        View view = (View) lE.jLe.get();
                        if (view == null) {
                            z = false;
                        } else {
                            b bVar;
                            uVar.jKU = i;
                            ViewGroup lB = uVar.lB(lE.jLf);
                            if ((lB instanceof AppBrandNativeContainerView) && ((AppBrandNativeContainerView) lB).jms) {
                                b lE2 = uVar.lE(lE.jLf);
                                if (lE2 != null) {
                                    ViewGroup lB2 = uVar.lB(lE2.jLf);
                                    if (lB2 != null) {
                                        View view2 = (View) lE.jLe.get();
                                        if (view2 != null) {
                                            LayoutParams layoutParams = view2.getLayoutParams();
                                            layoutParams.width = -1;
                                            layoutParams.height = -1;
                                            view2.setLayoutParams(layoutParams);
                                        }
                                        uVar.jKU = lE2.id;
                                        lB = lB2;
                                        bVar = lE2;
                                        if (lB != null) {
                                            view = (View) bVar.jLe.get();
                                            lB.addView(uVar.jKS, lB.indexOfChild(view));
                                            lB.removeView(view);
                                        }
                                        uVar.jKR = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) bVar.z};
                                        uVar.jJF.r(view, i2);
                                        uVar.jKQ = i;
                                        uVar.jKT = yVar;
                                        z = true;
                                    }
                                }
                            }
                            bVar = lE;
                            if (lB != null) {
                                view = (View) bVar.jLe.get();
                                lB.addView(uVar.jKS, lB.indexOfChild(view));
                                lB.removeView(view);
                            }
                            uVar.jKR = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) bVar.z};
                            uVar.jJF.r(view, i2);
                            uVar.jKQ = i;
                            uVar.jKT = yVar;
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass6.b(null)).booleanValue();
        }
        return ((Boolean) anonymousClass6.b(this.mHandler)).booleanValue();
    }

    public final boolean lJ(final int i) {
        bd anonymousClass7 = new bd<Boolean>(Boolean.valueOf(false)) {
            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(u.this.lK(i));
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass7.b(null)).booleanValue();
        }
        return ((Boolean) anonymousClass7.b(this.mHandler)).booleanValue();
    }

    final boolean lK(int i) {
        if (i != this.jKQ || lE(i) == null) {
            return false;
        }
        this.jJF.ajq();
        return true;
    }
}
