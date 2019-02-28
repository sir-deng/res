package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private MMWebView jAa;
    List<a> jKP;
    public int jKQ = -1;
    public float[] jKR;
    View jKS;
    public int jKU = -1;
    public ag mHandler;
    public com.tencent.mm.plugin.webview.fts.c.a txX;
    com.tencent.mm.plugin.webview.fts.c.b.b txY;

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$1 */
    class AnonymousClass1 extends bd<Boolean> {
        final /* synthetic */ int aar;
        final /* synthetic */ int jKW = 0;
        final /* synthetic */ float[] jKX;
        final /* synthetic */ int jkz;
        final /* synthetic */ View zS;

        public AnonymousClass1(Boolean bool, View view, int i, int i2, float[] fArr, int i3) {
            this.zS = view;
            this.jkz = i;
            this.jKX = fArr;
            this.aar = i3;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(b.this.a(this.zS, this.jkz, this.jKW, this.jKX, this.aar));
        }
    }

    private static class a {
        int id;
        public WeakReference<View> jLe;
        int jLf;
        int z;

        public a(View view, int i, int i2, int i3) {
            this.jLe = new WeakReference(view);
            this.id = i;
            this.jLf = i2;
            this.z = i3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$5 */
    class AnonymousClass5 extends bd<Boolean> {
        final /* synthetic */ int jkz;

        public AnonymousClass5(Boolean bool, int i) {
            this.jkz = i;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(b.this.lK(this.jkz));
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$3 */
    class AnonymousClass3 extends bd<Boolean> {
        final /* synthetic */ int aar;
        final /* synthetic */ float[] jKX;
        final /* synthetic */ int jkz;

        public AnonymousClass3(Boolean bool, int i, float[] fArr, int i2) {
            this.jkz = i;
            this.jKX = fArr;
            this.aar = i2;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(b.this.a(this.jkz, this.jKX, this.aar));
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$2 */
    class AnonymousClass2 extends bd<Boolean> {
        final /* synthetic */ int jkz;

        public AnonymousClass2(Boolean bool, int i) {
            this.jkz = i;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            boolean z;
            b bVar = b.this;
            int i = this.jkz;
            a Ay = bVar.Ay(i);
            if (Ay != null) {
                bVar.lK(i);
                bVar.a(Ay);
                ViewGroup lB = bVar.lB(Ay.jLf);
                if (lB != null) {
                    bVar.jKP.remove(Ay);
                    lB.removeView((View) Ay.jLe.get());
                    z = true;
                    return Boolean.valueOf(z);
                }
            }
            z = false;
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$4 */
    class AnonymousClass4 extends bd<Boolean> {
        final /* synthetic */ int jkz;
        final /* synthetic */ com.tencent.mm.plugin.webview.fts.c.a tya;
        final /* synthetic */ boolean tyb;

        public AnonymousClass4(Boolean bool, int i, com.tencent.mm.plugin.webview.fts.c.a aVar, boolean z) {
            this.jkz = i;
            this.tya = aVar;
            this.tyb = z;
            super(1000, bool);
        }

        protected final /* synthetic */ Object run() {
            boolean z;
            b bVar = b.this;
            int i = this.jkz;
            com.tencent.mm.plugin.webview.fts.c.a aVar = this.tya;
            boolean z2 = this.tyb;
            if (i == bVar.jKQ) {
                z = false;
            } else {
                a Ay = bVar.Ay(i);
                if (Ay == null || Ay.jLe == null) {
                    z = false;
                } else {
                    View view = (View) Ay.jLe.get();
                    if (view == null) {
                        z = false;
                    } else {
                        a aVar2;
                        bVar.jKU = i;
                        ViewGroup lB = bVar.lB(Ay.jLf);
                        a Ay2 = bVar.Ay(Ay.jLf);
                        if (Ay2 != null) {
                            ViewGroup lB2 = bVar.lB(Ay2.jLf);
                            if (lB2 != null) {
                                View view2 = (View) Ay.jLe.get();
                                if (view2 != null) {
                                    LayoutParams layoutParams = view2.getLayoutParams();
                                    layoutParams.width = -1;
                                    layoutParams.height = -1;
                                    view2.setLayoutParams(layoutParams);
                                }
                                bVar.jKU = Ay2.id;
                                lB = lB2;
                                aVar2 = Ay2;
                                if (lB != null) {
                                    view = (View) aVar2.jLe.get();
                                    lB.addView(bVar.jKS, lB.indexOfChild(view));
                                    lB.removeView(view);
                                }
                                bVar.jKR = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) aVar2.z};
                                bVar.txY.j(view, z2);
                                bVar.jKQ = i;
                                bVar.txX = aVar;
                                z = true;
                            }
                        }
                        aVar2 = Ay;
                        if (lB != null) {
                            view = (View) aVar2.jLe.get();
                            lB.addView(bVar.jKS, lB.indexOfChild(view));
                            lB.removeView(view);
                        }
                        bVar.jKR = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) aVar2.z};
                        bVar.txY.j(view, z2);
                        bVar.jKQ = i;
                        bVar.txX = aVar;
                        z = true;
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public b(MMWebView mMWebView, com.tencent.mm.plugin.webview.fts.c.b.b bVar) {
        this.jAa = mMWebView;
        this.mHandler = new ag(Looper.getMainLooper());
        this.jKP = new LinkedList();
        this.jKS = new View(mMWebView.getContext());
        this.txY = bVar;
    }

    final boolean a(View view, int i, int i2, float[] fArr, int i3) {
        int i4 = 0;
        if (view == null || fArr == null || fArr.length < 5) {
            return false;
        }
        ViewGroup lB = lB(i2);
        if (lB == null || lG(i) != null) {
            return false;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        int i5 = (int) fArr[4];
        LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
        int bP = bP(i2, i5);
        if (bP < 0) {
            bP = 0;
        }
        if (bP > lB.getChildCount()) {
            bP = lB.getChildCount();
        }
        if (i3 != Integer.MAX_VALUE && i3 >= 0) {
            if (i3 != 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        lB.addView(view, bP, layoutParams);
        view.setX(f);
        view.setY(f2);
        c(view, i, i2, i5);
        return true;
    }

    final ViewGroup lB(int i) {
        if (i == 0) {
            ViewGroup topView = this.jAa.getTopView();
            if (topView instanceof AbsoluteLayout) {
                return topView;
            }
            return null;
        }
        a Ay = Ay(i);
        if (Ay == null) {
            return null;
        }
        View view = (View) Ay.jLe.get();
        return view instanceof ViewGroup ? (ViewGroup) view : null;
    }

    public final boolean a(int i, float[] fArr, int i2) {
        if (lI(i)) {
            return true;
        }
        a Ay = Ay(i);
        if (Ay == null) {
            return false;
        }
        View view = (View) Ay.jLe.get();
        ViewGroup lB = lB(Ay.jLf);
        if (lB == null) {
            return false;
        }
        if (i2 >= 0 && i2 != Integer.MAX_VALUE) {
            view.setVisibility(i2 == 0 ? 0 : 8);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        this.jKP.remove(Ay);
        if (Ay.z != i3) {
            lB.removeView(view);
            if (a(view, i, Ay.jLf, fArr, i2)) {
                return true;
            }
            a(Ay);
            return false;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (f3 != Float.MAX_VALUE) {
            layoutParams.width = (int) f3;
        }
        if (f4 != Float.MAX_VALUE) {
            layoutParams.height = (int) f4;
        }
        if (f != Float.MAX_VALUE) {
            view.setX(f);
        }
        if (f2 != Float.MAX_VALUE) {
            view.setY(f2);
        }
        view.requestLayout();
        c(view, i, Ay.jLf, i3);
        int indexOfChild = lB.indexOfChild(this.jKS);
        if (lB.indexOfChild(view) == -1 && indexOfChild != -1) {
            lB.addView(view, indexOfChild);
            lB.removeView(this.jKS);
        }
        return true;
    }

    final void a(a aVar) {
        this.jKP.removeAll(b(aVar));
    }

    private List<a> b(a aVar) {
        List<a> linkedList = new LinkedList();
        for (a aVar2 : this.jKP) {
            if (aVar2.jLf == aVar.id) {
                linkedList.addAll(b(aVar2));
            }
        }
        linkedList.add(aVar);
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
            a aVar = (a) it.next();
            if (i == aVar.jLf && i2 >= aVar.z) {
                i4++;
            }
            i3 = i4;
        }
    }

    public final a Ay(int i) {
        for (a aVar : this.jKP) {
            if (aVar.id == i) {
                return aVar;
            }
        }
        return null;
    }

    public final View lG(int i) {
        a Ay = Ay(i);
        return Ay == null ? null : (View) Ay.jLe.get();
    }

    private void c(View view, int i, int i2, int i3) {
        this.jKP.add(new a(view, i, i2, i3));
    }

    public final boolean lI(int i) {
        return this.jKU == i || this.jKQ == i;
    }

    final boolean lK(int i) {
        if (i != this.jKQ || Ay(i) == null) {
            return false;
        }
        this.txY.bRk();
        return true;
    }
}
