package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout extends FrameLayout {
    private float BO;
    public View Iv;
    private Rect gO;
    public boolean mEnable;
    private boolean mInLayout;
    public boolean zBF;
    public boolean zFA;
    public boolean zFB;
    private boolean zFC;
    public a zFD;
    private float zFs;
    private int zFt;
    private int zFu;
    public com.tencent.mm.ui.mogic.a zFv;
    private float zFw;
    public Drawable zFx;
    private boolean zFy;
    private boolean zFz;

    public interface a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    private class b extends com.tencent.mm.ui.mogic.a.a implements com.tencent.mm.ui.base.b.a {
        int zFE;
        int zFF;
        int zFG;

        private b() {
            this.zFE = 0;
            this.zFF = 0;
            this.zFG = 0;
        }

        /* synthetic */ b(SwipeBackLayout swipeBackLayout, byte b) {
            this();
        }

        public final boolean GY(int i) {
            boolean z;
            com.tencent.mm.ui.mogic.a a = SwipeBackLayout.this.zFv;
            if ((a.Fd & (1 << i)) != 0) {
                z = true;
            } else {
                z = false;
            }
            return z && (a.Fa[i] & 1) != 0;
        }

        public final int cyj() {
            return 1;
        }

        public final void ff(int i, int i2) {
            if (SwipeBackLayout.this.zFA) {
                SwipeBackLayout.this.zFw = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.Iv.getWidth() + SwipeBackLayout.this.zFx.getIntrinsicWidth())));
                SwipeBackLayout.this.zFt = i;
                SwipeBackLayout.this.zFu = i2;
                SwipeBackLayout.this.invalidate();
                if (Float.compare(SwipeBackLayout.this.zFw, 1.0f) >= 0 && !SwipeBackLayout.this.zFB) {
                    SwipeBackLayout.this.zFB = true;
                    ah.y(new Runnable() {
                        public final void run() {
                            if (SwipeBackLayout.this.zFD != null) {
                                SwipeBackLayout.this.zFD.onSwipeBack();
                                x.d("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                            }
                            SwipeBackLayout.this.zBF = false;
                        }
                    });
                } else if (Float.compare(SwipeBackLayout.this.zFw, 0.01f) <= 0) {
                    SwipeBackLayout.this.zBF = false;
                }
                if (SwipeBackLayout.this.zFv.EV == 1) {
                    l.aI(SwipeBackLayout.this.zFw);
                }
            }
        }

        public final void a(View view, float f, float f2) {
            int width = view.getWidth();
            this.zFF = 0;
            this.zFG = 0;
            width = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.zFw > SwipeBackLayout.this.zFs)) ? (width + SwipeBackLayout.this.zFx.getIntrinsicWidth()) + 10 : 0;
            this.zFF = width;
            x.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.zFF), Integer.valueOf(this.zFG), Boolean.valueOf(SwipeBackLayout.this.zFA));
            SwipeBackLayout.this.zBF = true;
            if (SwipeBackLayout.this.zFA) {
                com.tencent.mm.ui.mogic.a a = SwipeBackLayout.this.zFv;
                int i = this.zFF;
                int i2 = this.zFG;
                if (a.Fk) {
                    a.f(i, i2, (int) y.a(a.ft, a.fu), (int) y.b(a.ft, a.fu));
                    SwipeBackLayout.this.invalidate();
                    return;
                }
                throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            }
            SwipeBackLayout.this.zFC = true;
        }

        public final int d(View view, int i) {
            if (SwipeBackLayout.this.zFA) {
                int max = Math.max(this.zFE, i);
                this.zFE = 0;
                return Math.min(view.getWidth(), Math.max(max, 0));
            }
            this.zFE = Math.max(this.zFE, i);
            return 0;
        }

        public final void t(int i) {
            x.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(SwipeBackLayout.this.zFz), Boolean.valueOf(SwipeBackLayout.this.zFC));
            if (1 == i) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if (SwipeBackLayout.this.getContext() instanceof Activity) {
                    ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(d.transparent);
                }
                if (SwipeBackLayout.this.zFD != null) {
                    SwipeBackLayout.this.zFD.onDrag();
                }
                SwipeBackLayout.this.zFB = false;
                if (SwipeBackLayout.this.zFA) {
                    l.aI(0.0f);
                }
            }
            if (i == 0 && !SwipeBackLayout.this.zFC) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (SwipeBackLayout.this.zFD != null) {
                    SwipeBackLayout.this.zFD.onCancel();
                }
                l.aI(1.0f);
            }
            if (1 == i && SwipeBackLayout.this.zFy && (SwipeBackLayout.this.getContext() instanceof Activity) && !SwipeBackLayout.this.zFA && !SwipeBackLayout.this.zFz) {
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                SwipeBackLayout.this.zFz = true;
                Activity activity = (Activity) SwipeBackLayout.this.getContext();
                if (com.tencent.mm.compatible.util.d.fO(16)) {
                    x.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
                } else {
                    try {
                        Object newProxyInstance;
                        Class[] declaredClasses = Activity.class.getDeclaredClasses();
                        int length = declaredClasses.length;
                        int i2 = 0;
                        Class cls = null;
                        while (i2 < length) {
                            Class cls2 = declaredClasses[i2];
                            if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                                cls2 = cls;
                            }
                            i2++;
                            cls = cls2;
                        }
                        if (this != null) {
                            InvocationHandler bVar = new b();
                            bVar.yfn = new WeakReference(this);
                            newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
                        } else {
                            newProxyInstance = null;
                        }
                        Method declaredMethod;
                        if (com.tencent.mm.compatible.util.d.fO(21)) {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                        } else {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
                    }
                }
            }
            if (2 == i) {
                boolean z;
                x.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.zFF));
                if (this.zFF > 0) {
                    z = true;
                } else {
                    z = false;
                }
                l.B(z, this.zFF);
            }
        }

        public final void ml(final boolean z) {
            ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(b.this.zFF));
                    SwipeBackLayout.this.zFz = z;
                    if (!z) {
                        SwipeBackLayout.this.zBF = false;
                    } else if (b.this.zFF > 0) {
                        l.aI(0.0f);
                    } else {
                        l.aI(1.0f);
                    }
                    SwipeBackLayout.this.nL(z);
                    if (z && SwipeBackLayout.this.zFC) {
                        if (b.this.zFF == 0) {
                            j.a(SwipeBackLayout.this.Iv, 200, 0.0f, new com.tencent.mm.ui.tools.j.a() {
                                public final void onAnimationEnd() {
                                    SwipeBackLayout.this.zBF = false;
                                }

                                public final void cyG() {
                                    onAnimationEnd();
                                }
                            });
                        } else {
                            j.a(SwipeBackLayout.this.Iv, 200, (float) b.this.zFF, new com.tencent.mm.ui.tools.j.a() {
                                public final void onAnimationEnd() {
                                    SwipeBackLayout.this.zFB = true;
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            if (SwipeBackLayout.this.zFD != null) {
                                                SwipeBackLayout.this.zFD.onSwipeBack();
                                                x.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            l.aI(1.0f);
                                            SwipeBackLayout.this.zBF = false;
                                        }
                                    });
                                }

                                public final void cyG() {
                                    onAnimationEnd();
                                }
                            });
                            l.B(true, b.this.zFF);
                        }
                    }
                    SwipeBackLayout.this.zFC = false;
                }
            });
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zFs = 0.3f;
        this.mEnable = true;
        this.gO = new Rect();
        this.zFy = true;
        this.zFz = false;
        this.zFA = false;
        this.zFB = false;
        this.zBF = false;
        this.zFC = false;
        this.zFD = null;
        this.zFx = getResources().getDrawable(f.gWJ);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
    }

    public final void init() {
        this.zFv = com.tencent.mm.ui.mogic.a.a(this, new b());
        this.zFv.Fh = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.zFv.Ff = f2;
        this.zFv.Fe = f;
        this.zFt = 0;
        this.zFu = 0;
    }

    public final void nL(boolean z) {
        x.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.zFA = z;
    }

    public final void nM(boolean z) {
        this.zFy = z;
        if (this.zFy) {
            this.zFz = false;
        }
    }

    public final boolean czU() {
        czV();
        return this.zBF;
    }

    public void onFinishInflate() {
        this.Iv = this;
    }

    public final boolean czV() {
        if (!this.zBF) {
            return false;
        }
        if (Float.compare((float) this.Iv.getLeft(), 0.01f) > 0) {
            return true;
        }
        this.zBF = false;
        return false;
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r7 = 2;
        r3 = -1;
        r0 = 1;
        r1 = 0;
        r2 = r11.mEnable;
        if (r2 != 0) goto L_0x000d;
    L_0x0008:
        r0 = super.dispatchTouchEvent(r12);
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = r11.czV();
        if (r2 == 0) goto L_0x0018;
    L_0x0013:
        r0 = super.dispatchTouchEvent(r12);
        goto L_0x000c;
    L_0x0018:
        r2 = r11.zFv;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r0) goto L_0x01db;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x001e:
        r4 = r11.zFv;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = android.support.v4.view.o.d(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = android.support.v4.view.o.e(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != 0) goto L_0x002d;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x002a:
        r4.cancel();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x002d:
        r6 = r4.ft;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r6 != 0) goto L_0x0037;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0031:
        r6 = android.view.VelocityTracker.obtain();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.ft = r6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0037:
        r6 = r4.ft;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6.addMovement(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        switch(r2) {
            case 0: goto L_0x0040;
            case 1: goto L_0x01c1;
            case 2: goto L_0x00c8;
            case 3: goto L_0x01cd;
            case 4: goto L_0x003f;
            case 5: goto L_0x0063;
            case 6: goto L_0x017d;
            default: goto L_0x003f;
        };	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x003f:
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0040:
        r2 = r12.getX();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = r12.getY();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = 0;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = (int) r2;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = (int) r3;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r4.u(r6, r7);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.a(r2, r3, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.o(r6, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r4.Fa;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2[r5];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r1 = r4.Fh;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r1 = r1 & r2;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r1 == 0) goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0062:
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0063:
        r3 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = android.support.v4.view.o.d(r12, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = android.support.v4.view.o.e(r12, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.a(r2, r5, r3);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r4.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r6 != 0) goto L_0x008f;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0076:
        r2 = (int) r2;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = (int) r5;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r4.u(r2, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.o(r2, r3);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;
    L_0x0080:
        r0 = move-exception;
        r2 = "MicroMsg.SwipeBackLayout";
        r3 = "got an NullPointerException";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x008f:
        r2 = (int) r2;
        r5 = (int) r5;
        r6 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r6 == 0) goto L_0x00c6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0095:
        r7 = r6.getLeft();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 < r7) goto L_0x00c6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x009b:
        r7 = r6.getRight();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 >= r7) goto L_0x00c6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x00a1:
        r2 = r6.getTop();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 < r2) goto L_0x00c6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x00a7:
        r2 = r6.getBottom();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 >= r2) goto L_0x00c6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x00ad:
        r2 = r0;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x00ae:
        if (r2 == 0) goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x00b0:
        r2 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.o(r2, r3);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;
    L_0x00b7:
        r0 = move-exception;
        r2 = "MicroMsg.SwipeBackLayout";
        r3 = "got an IllegalArgumentException";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x00c6:
        r2 = r1;
        goto L_0x00ae;
    L_0x00c8:
        r2 = r4.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r0) goto L_0x013d;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x00cc:
        r2 = r4.fu;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = android.support.v4.view.o.b(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = r4.EY;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r4.fu;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = r5[r6];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = r3 - r5;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = (int) r3;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = r4.EZ;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r4.fu;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = r3[r6];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2 - r3;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = (int) r2;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2.getLeft();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = r2 + r5;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2.getTop();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2 + r6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = r7.getLeft();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r8.getTop();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 == 0) goto L_0x0116;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0107:
        r9 = r4.zow;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r10 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = r9.d(r10, r3);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = r3 - r7;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9.offsetLeftAndRight(r7);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0116:
        if (r6 == 0) goto L_0x0120;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0118:
        r2 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = 0 - r8;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2.offsetTopAndBottom(r7);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0120:
        if (r5 != 0) goto L_0x0124;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0122:
        if (r6 == 0) goto L_0x0129;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0124:
        r5 = r4.zow;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5.ff(r3, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0129:
        r4.i(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;
    L_0x012e:
        r0 = move-exception;
        r2 = "MicroMsg.SwipeBackLayout";
        r3 = "got an ArrayIndexOutOfBoundsException";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x013d:
        r3 = android.support.v4.view.o.f(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0142:
        if (r2 >= r3) goto L_0x0178;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0144:
        r5 = android.support.v4.view.o.c(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r4.EW;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r8[r5];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r6 - r8;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r4.EX;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r9[r5];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r7 - r9;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.b(r8, r9, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r4.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r9 == r0) goto L_0x0178;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0163:
        r6 = (int) r6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = (int) r7;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r4.u(r6, r7);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = r4.l(r6, r8);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r7 == 0) goto L_0x0175;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x016f:
        r5 = r4.o(r6, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 != 0) goto L_0x0178;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0175:
        r2 = r2 + 1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x0142;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0178:
        r4.i(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x017d:
        r5 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r4.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r0) goto L_0x01b9;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0185:
        r2 = r4.fu;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 != r2) goto L_0x01b9;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0189:
        r6 = android.support.v4.view.o.f(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x018e:
        if (r2 >= r6) goto L_0x02b4;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0190:
        r7 = android.support.v4.view.o.c(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r4.fu;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r7 == r8) goto L_0x01be;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0198:
        r8 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = (int) r8;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = (int) r9;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r4.u(r8, r9);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r8 != r9) goto L_0x01be;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01aa:
        r8 = r4.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = r4.o(r8, r7);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r7 == 0) goto L_0x01be;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01b2:
        r2 = r4.fu;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01b4:
        if (r2 != r3) goto L_0x01b9;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01b6:
        r4.cN();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01b9:
        r4.av(r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01be:
        r2 = r2 + 1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x018e;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01c1:
        r2 = r4.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r0) goto L_0x01c8;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01c5:
        r4.cN();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01c8:
        r4.cancel();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01cd:
        r2 = r4.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r0) goto L_0x01d6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01d1:
        r2 = 0;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3 = 0;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4.i(r2, r3);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01d6:
        r4.cancel();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01db:
        r3 = r11.zFv;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = android.support.v4.view.o.d(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = android.support.v4.view.o.e(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != 0) goto L_0x01ea;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01e7:
        r3.cancel();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01ea:
        r5 = r3.ft;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 != 0) goto L_0x01f4;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01ee:
        r5 = android.view.VelocityTracker.obtain();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3.ft = r5;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01f4:
        r5 = r3.ft;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5.addMovement(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        switch(r2) {
            case 0: goto L_0x020c;
            case 1: goto L_0x02a7;
            case 2: goto L_0x025c;
            case 3: goto L_0x02a7;
            case 4: goto L_0x01fc;
            case 5: goto L_0x0237;
            case 6: goto L_0x029e;
            default: goto L_0x01fc;
        };	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x01fc:
        r2 = r3.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r0) goto L_0x02ac;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0200:
        r2 = r0;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0201:
        if (r2 == 0) goto L_0x02af;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0203:
        r2 = 3;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r12.setAction(r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        super.dispatchTouchEvent(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x020c:
        r2 = r12.getX();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = r12.getY();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = 0;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = android.support.v4.view.o.c(r12, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3.a(r2, r4, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = (int) r2;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = (int) r4;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r3.u(r2, r4);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = r3.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 != r4) goto L_0x022d;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0226:
        r4 = r3.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r4 != r7) goto L_0x022d;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x022a:
        r3.o(r2, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x022d:
        r2 = r3.Fa;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2[r5];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = r3.Fh;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r2 & r4;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r2 == 0) goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0236:
        goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0237:
        r2 = android.support.v4.view.o.c(r12, r4);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = android.support.v4.view.o.d(r12, r4);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = android.support.v4.view.o.e(r12, r4);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3.a(r5, r4, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r3.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r6 == 0) goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x024a:
        r6 = r3.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r6 != r7) goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x024e:
        r5 = (int) r5;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = (int) r4;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r4 = r3.u(r5, r4);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r5 = r3.Fj;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r4 != r5) goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0258:
        r3.o(r4, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x025c:
        r4 = android.support.v4.view.o.f(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r2 = r1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0261:
        if (r2 >= r4) goto L_0x0299;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0263:
        r5 = android.support.v4.view.o.c(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = android.support.v4.view.o.d(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = android.support.v4.view.o.e(r12, r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r3.EW;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r8[r5];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r8 = r6 - r8;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r3.EX;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r9[r5];	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r7 - r9;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3.b(r8, r9, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r9 = r3.EV;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r9 == r0) goto L_0x0299;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0282:
        r6 = (int) r6;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r7 = (int) r7;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r6 = r3.u(r6, r7);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r6 == 0) goto L_0x0296;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x028a:
        r7 = r3.l(r6, r8);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r7 == 0) goto L_0x0296;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0290:
        r5 = r3.o(r6, r5);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        if (r5 != 0) goto L_0x0299;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0296:
        r2 = r2 + 1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x0261;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x0299:
        r3.i(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x029e:
        r2 = android.support.v4.view.o.c(r12, r4);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        r3.av(r2);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x02a7:
        r3.cancel();	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x01fc;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x02ac:
        r2 = r1;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x0201;	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
    L_0x02af:
        super.dispatchTouchEvent(r12);	 Catch:{ NullPointerException -> 0x0080, IllegalArgumentException -> 0x00b7, ArrayIndexOutOfBoundsException -> 0x012e }
        goto L_0x000c;
    L_0x02b4:
        r2 = r3;
        goto L_0x01b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.SwipeBackLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        if (this.Iv != null) {
            this.Iv.layout(this.zFt, this.zFu, this.zFt + this.Iv.getMeasuredWidth(), this.zFu + this.Iv.getMeasuredHeight());
        }
        this.mInLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj = view == this.Iv ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.BO, 0.0f) <= 0 || obj == null || this.zFv.EV == 0)) {
            Rect rect = this.gO;
            view.getHitRect(rect);
            this.zFx.setBounds(rect.left - this.zFx.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.zFx.setAlpha((int) (this.BO * 255.0f));
            this.zFx.draw(canvas);
        }
        return drawChild;
    }

    public void computeScroll() {
        this.BO = Math.max(0.0f, 1.0f - this.zFw);
        com.tencent.mm.ui.mogic.a aVar = this.zFv;
        if (aVar.EV == 2) {
            boolean computeScrollOffset = aVar.iK.computeScrollOffset();
            int currX = aVar.iK.getCurrX();
            int currY = aVar.iK.getCurrY();
            int left = currX - aVar.Fj.getLeft();
            int top = currY - aVar.Fj.getTop();
            if (left != 0) {
                aVar.Fj.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.Fj.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.zow.ff(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.iK.getFinalX() && currY == aVar.iK.getFinalY()) {
                aVar.iK.abortAnimation();
                computeScrollOffset = aVar.iK.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.Fl.post(aVar.Fm);
            }
        }
        if ((aVar.EV == 2 ? 1 : null) != null) {
            z.E(this);
        }
    }
}
