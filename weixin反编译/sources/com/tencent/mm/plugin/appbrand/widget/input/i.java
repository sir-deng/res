package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.util.Map;

public class i implements e {
    private static final i kda = new i() {
        public final void anj() {
        }

        public final void ank() {
        }

        public final void onDestroy() {
        }

        public final String toString() {
            return super.toString() + "|DUMMY";
        }
    };
    private static final android.support.v4.e.a<p, i> kdf = new android.support.v4.e.a();
    private final p jjI;
    public final Map<a, i> kcZ;
    private final int kdb;
    private final int kdc;
    private int kdd;
    private boolean kde;
    private final Runnable kdg;
    private final Runnable kdh;

    public interface a {
        void anm();

        void ann();
    }

    /* synthetic */ i(byte b) {
        this();
    }

    static /* synthetic */ View b(i iVar) {
        return !iVar.jjI.isRunning() ? null : iVar.jjI.afc();
    }

    static /* synthetic */ void c(i iVar) {
        if (iVar.kcZ.size() > 0) {
            for (a ann : (a[]) iVar.kcZ.keySet().toArray(new a[iVar.kcZ.size()])) {
                ann.ann();
            }
        }
    }

    static /* synthetic */ int e(i iVar) {
        int i = iVar.kdd + 1;
        iVar.kdd = i;
        return i;
    }

    static /* synthetic */ int h(i iVar) {
        Display defaultDisplay = ((WindowManager) iVar.jjI.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    static /* synthetic */ void j(i iVar) {
        if (iVar.kcZ.size() > 0) {
            for (a anm : (a[]) iVar.kcZ.keySet().toArray(new a[iVar.kcZ.size()])) {
                anm.anm();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.kcZ.remove(aVar);
        }
    }

    private i() {
        this.kcZ = new android.support.v4.e.a();
        this.kdc = 5;
        this.kdd = 0;
        this.kde = false;
        this.kdg = new Runnable() {
            public final void run() {
                if (i.this.jjI.isRunning()) {
                    View b = i.b(i.this);
                    if (b != null) {
                        b.scrollTo(0, 0);
                        i.c(i.this);
                    }
                }
            }
        };
        this.kdh = new Runnable() {
            public final void run() {
                x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
                final y q = m.q(i.this.jjI);
                if (q != null && i.this.jjI.isRunning() && q.getInputPanel() != null && q.getWidget() != null) {
                    View widget = q.getWidget();
                    View inputPanel = q.getInputPanel();
                    if (!j.bK(widget) && q.adjustPositionOnFocused()) {
                        if (inputPanel.getHeight() <= inputPanel.getMinimumHeight()) {
                            x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(i.this.kdd));
                            if (i.e(i.this) < 5) {
                                i.this.dx(false);
                                return;
                            }
                            return;
                        }
                        i.this.kdd = 0;
                        x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", Integer.valueOf(inputPanel.getHeight()));
                        final int height = inputPanel.getHeight();
                        ah.y(new Runnable() {
                            public final void run() {
                                q.kB(height);
                            }
                        });
                        int[] iArr = new int[2];
                        widget.getLocationOnScreen(iArr);
                        int i = iArr[1];
                        x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", Integer.valueOf(widget.getHeight()), Integer.valueOf(i), Boolean.valueOf(z.ak(widget)));
                        if (i <= i.h(i.this)) {
                            int i2;
                            int height2 = widget.getHeight() + i;
                            inputPanel.getLocationOnScreen(iArr);
                            int i3 = iArr[1];
                            if (!((z) widget).anr() || widget.getLayout() == null) {
                                i2 = height2;
                                height = i;
                            } else {
                                height = i + ((z) widget).mw(widget.getLayout().getLineForOffset(widget.getSelectionStart()));
                                int mw = i + ((z) widget).mw(widget.getLayout().getLineForOffset(widget.getSelectionStart()) + 1);
                                i2 = height - i >= widget.getHeight() ? height2 - widget.getLineHeight() : height;
                                if (mw - i >= widget.getHeight()) {
                                    height = i2;
                                    i2 = height2;
                                } else {
                                    height = i2;
                                    i2 = mw;
                                }
                            }
                            i2 += q.getInputPanelMarginBottom();
                            if (i3 < i2) {
                                height = Math.max(0, Math.min(i2 - i3, height - i.this.kdb));
                                t tVar = i.this.jjI.jJw;
                                if (tVar != null) {
                                    View view = tVar.getView();
                                    if (view != null && widget != null) {
                                        if (((z) widget).anv() || !((z) widget).anr()) {
                                            mm(anl() + height);
                                            return;
                                        }
                                        i2 = tVar.getHeight();
                                        i = view.getScrollY();
                                        height2 = f.ma(tVar.getContentHeight());
                                        widget.getHeight();
                                        widget.getTop();
                                        i2 = Math.max(0, Math.min((height2 - i) - i2, height));
                                        view.scrollBy(view.getScrollX(), i2);
                                        mm((height - i2) + anl());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            private int anl() {
                View b = i.b(i.this);
                if (b != null) {
                    return b.getScrollY();
                }
                return 0;
            }

            private void mm(int i) {
                x.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", Integer.valueOf(i));
                View b = i.b(i.this);
                if (b != null) {
                    b.scrollTo(0, i);
                    i.j(i.this);
                }
            }
        };
        this.jjI = null;
        this.kdb = 0;
    }

    private i(p pVar) {
        int i = 0;
        this.kcZ = new android.support.v4.e.a();
        this.kdc = 5;
        this.kdd = 0;
        this.kde = false;
        this.kdg = /* anonymous class already generated */;
        this.kdh = /* anonymous class already generated */;
        this.jjI = pVar;
        this.jjI.a((e) this);
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(pVar.mContext, 10);
        if (VERSION.SDK_INT >= 21) {
            i = j.alt();
        }
        this.kdb = i + fromDPToPix;
    }

    public static i a(Reference<p> reference) {
        return l(reference == null ? null : (p) reference.get());
    }

    public static i l(p pVar) {
        if (pVar == null || !pVar.isRunning()) {
            x.j("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page " + pVar, new Object[0]);
            return kda;
        }
        i iVar = (i) kdf.get(pVar);
        if (iVar != null) {
            return iVar;
        }
        iVar = new i(pVar);
        kdf.put(pVar, iVar);
        return iVar;
    }

    private void dx(boolean z) {
        if (z) {
            this.kdd = 0;
            this.kde = false;
        }
        if (!this.jjI.isRunning() || this.kde) {
            return;
        }
        if (this.kdd == 0) {
            x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", Boolean.valueOf(z.ak(this.jjI.getContentView())));
            this.jjI.getContentView().post(this.kdh);
            return;
        }
        x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", Boolean.valueOf(z.ak(this.jjI.getContentView())));
        this.jjI.getContentView().postOnAnimation(this.kdh);
    }

    public void anj() {
        dx(true);
    }

    public void ank() {
        if (this.jjI.isRunning()) {
            this.kde = true;
            this.jjI.getContentView().post(this.kdg);
        }
    }

    public void onDestroy() {
        this.jjI.b((e) this);
        kdf.remove(this.jjI);
    }
}
