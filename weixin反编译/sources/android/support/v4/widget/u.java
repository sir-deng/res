package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class u {
    private static final Interpolator yC = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int EV;
    float[] EW;
    float[] EX;
    float[] EY;
    float[] EZ;
    private int[] Fa;
    private int[] Fb;
    private int[] Fc;
    private int Fd;
    private float Fe;
    float Ff;
    int Fg;
    int Fh;
    private final a Fi;
    View Fj;
    private boolean Fk;
    private final ViewGroup Fl;
    private final Runnable Fm = new Runnable() {
        public final void run() {
            u.this.ax(0);
        }
    };
    private VelocityTracker ft;
    private int fu = -1;
    private q iK;
    public int iN;

    public static abstract class a {
        public abstract boolean b(View view, int i);

        public void t(int i) {
        }

        public void a(View view, int i, int i2) {
        }

        public void f(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void cv() {
        }

        public void q(int i, int i2) {
        }

        public int s(View view) {
            return 0;
        }

        public int N() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }
    }

    public static u a(ViewGroup viewGroup, a aVar) {
        return new u(viewGroup.getContext(), viewGroup, aVar);
    }

    public static u a(ViewGroup viewGroup, float f, a aVar) {
        u a = a(viewGroup, aVar);
        a.iN = (int) (((float) a.iN) * (1.0f / f));
        return a;
    }

    private u(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Fl = viewGroup;
            this.Fi = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.Fg = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iN = viewConfiguration.getScaledTouchSlop();
            this.Fe = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.Ff = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iK = q.a(context, yC);
        }
    }

    public final void n(View view, int i) {
        if (view.getParent() != this.Fl) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fl + ")");
        }
        this.Fj = view;
        this.fu = i;
        this.Fi.f(view, i);
        ax(1);
    }

    public final void cancel() {
        this.fu = -1;
        if (this.EW != null) {
            Arrays.fill(this.EW, 0.0f);
            Arrays.fill(this.EX, 0.0f);
            Arrays.fill(this.EY, 0.0f);
            Arrays.fill(this.EZ, 0.0f);
            Arrays.fill(this.Fa, 0);
            Arrays.fill(this.Fb, 0);
            Arrays.fill(this.Fc, 0);
            this.Fd = 0;
        }
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    public final void abort() {
        cancel();
        if (this.EV == 2) {
            this.iK.getCurrX();
            this.iK.getCurrY();
            this.iK.abortAnimation();
            this.Fi.a(this.Fj, this.iK.getCurrX(), this.iK.getCurrY());
        }
        ax(0);
    }

    public final boolean e(View view, int i, int i2) {
        this.Fj = view;
        this.fu = -1;
        boolean f = f(i, i2, 0, 0);
        if (!(f || this.EV != 0 || this.Fj == null)) {
            this.Fj = null;
        }
        return f;
    }

    public final boolean t(int i, int i2) {
        if (this.Fk) {
            return f(i, i2, (int) y.a(this.ft, this.fu), (int) y.b(this.ft, this.fu));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean f(int i, int i2, int i3, int i4) {
        int left = this.Fj.getLeft();
        int top = this.Fj.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iK.abortAnimation();
            ax(0);
            return false;
        }
        View view = this.Fj;
        int k = k(i3, (int) this.Ff, (int) this.Fe);
        int k2 = k(i4, (int) this.Ff, (int) this.Fe);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(k);
        int abs4 = Math.abs(k2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.iK.startScroll(left, top, i5, i6, (int) (((k2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) j(i6, k2, this.Fi.N()))) + ((k != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) j(i5, k, this.Fi.s(view))))));
        ax(2);
        return true;
    }

    private int j(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.Fl.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int k(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float f(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final boolean cM() {
        if (this.EV == 2) {
            boolean computeScrollOffset = this.iK.computeScrollOffset();
            int currX = this.iK.getCurrX();
            int currY = this.iK.getCurrY();
            int left = currX - this.Fj.getLeft();
            int top = currY - this.Fj.getTop();
            if (left != 0) {
                z.k(this.Fj, left);
            }
            if (top != 0) {
                z.j(this.Fj, top);
            }
            if (!(left == 0 && top == 0)) {
                this.Fi.a(this.Fj, currX, currY);
            }
            if (computeScrollOffset && currX == this.iK.getFinalX() && currY == this.iK.getFinalY()) {
                this.iK.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.Fl.post(this.Fm);
            }
        }
        if (this.EV == 2) {
            return true;
        }
        return false;
    }

    private void i(float f, float f2) {
        this.Fk = true;
        this.Fi.a(this.Fj, f, f2);
        this.Fk = false;
        if (this.EV == 1) {
            ax(0);
        }
    }

    private void av(int i) {
        if (this.EW != null) {
            this.EW[i] = 0.0f;
            this.EX[i] = 0.0f;
            this.EY[i] = 0.0f;
            this.EZ[i] = 0.0f;
            this.Fa[i] = 0;
            this.Fb[i] = 0;
            this.Fc[i] = 0;
            this.Fd &= (1 << i) ^ -1;
        }
    }

    private void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.EW == null || this.EW.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.EW != null) {
                System.arraycopy(this.EW, 0, obj, 0, this.EW.length);
                System.arraycopy(this.EX, 0, obj2, 0, this.EX.length);
                System.arraycopy(this.EY, 0, obj3, 0, this.EY.length);
                System.arraycopy(this.EZ, 0, obj4, 0, this.EZ.length);
                System.arraycopy(this.Fa, 0, obj5, 0, this.Fa.length);
                System.arraycopy(this.Fb, 0, obj6, 0, this.Fb.length);
                System.arraycopy(this.Fc, 0, obj7, 0, this.Fc.length);
            }
            this.EW = obj;
            this.EX = obj2;
            this.EY = obj3;
            this.EZ = obj4;
            this.Fa = obj5;
            this.Fb = obj6;
            this.Fc = obj7;
        }
        float[] fArr = this.EW;
        this.EY[i] = f;
        fArr[i] = f;
        fArr = this.EX;
        this.EZ[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.Fa;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.Fl.getLeft() + this.Fg) {
            i2 = 1;
        }
        if (i4 < this.Fl.getTop() + this.Fg) {
            i2 |= 4;
        }
        if (i3 > this.Fl.getRight() - this.Fg) {
            i2 |= 2;
        }
        if (i4 > this.Fl.getBottom() - this.Fg) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.Fd |= 1 << i;
    }

    private void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.EY[c] = d;
            this.EZ[c] = e;
        }
    }

    public final boolean aw(int i) {
        return (this.Fd & (1 << i)) != 0;
    }

    final void ax(int i) {
        this.Fl.removeCallbacks(this.Fm);
        if (this.EV != i) {
            this.EV = i;
            this.Fi.t(i);
            if (this.EV == 0) {
                this.Fj = null;
            }
        }
    }

    private boolean o(View view, int i) {
        if (view == this.Fj && this.fu == i) {
            return true;
        }
        if (view == null || !this.Fi.b(view, i)) {
            return false;
        }
        this.fu = i;
        n(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.o.d(r14);
        r1 = android.support.v4.view.o.e(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.cancel();
    L_0x000d:
        r2 = r13.ft;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.ft = r2;
    L_0x0017:
        r2 = r13.ft;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x011f;
            case 2: goto L_0x008c;
            case 3: goto L_0x011f;
            case 4: goto L_0x001f;
            case 5: goto L_0x0057;
            case 6: goto L_0x0116;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.EV;
        r1 = 1;
        if (r0 != r1) goto L_0x0124;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.o.c(r14, r2);
        r13.a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.u(r0, r1);
        r1 = r13.Fj;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.EV;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.o(r0, r2);
    L_0x0048:
        r0 = r13.Fa;
        r0 = r0[r2];
        r1 = r13.Fh;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0051:
        r0 = r13.Fi;
        r0.cv();
        goto L_0x001f;
    L_0x0057:
        r0 = android.support.v4.view.o.c(r14, r1);
        r2 = android.support.v4.view.o.d(r14, r1);
        r1 = android.support.v4.view.o.e(r14, r1);
        r13.a(r2, r1, r0);
        r3 = r13.EV;
        if (r3 != 0) goto L_0x0079;
    L_0x006a:
        r1 = r13.Fa;
        r0 = r1[r0];
        r1 = r13.Fh;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0073:
        r0 = r13.Fi;
        r0.cv();
        goto L_0x001f;
    L_0x0079:
        r3 = r13.EV;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x007e:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.u(r2, r1);
        r2 = r13.Fj;
        if (r1 != r2) goto L_0x001f;
    L_0x0088:
        r13.o(r1, r0);
        goto L_0x001f;
    L_0x008c:
        r0 = r13.EW;
        if (r0 == 0) goto L_0x001f;
    L_0x0090:
        r0 = r13.EX;
        if (r0 == 0) goto L_0x001f;
    L_0x0094:
        r2 = android.support.v4.view.o.f(r14);
        r0 = 0;
        r1 = r0;
    L_0x009a:
        if (r1 >= r2) goto L_0x0111;
    L_0x009c:
        r3 = android.support.v4.view.o.c(r14, r1);
        r0 = r13.ay(r3);
        if (r0 == 0) goto L_0x010b;
    L_0x00a6:
        r0 = android.support.v4.view.o.d(r14, r1);
        r4 = android.support.v4.view.o.e(r14, r1);
        r5 = r13.EW;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.EX;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.u(r0, r4);
        if (r4 == 0) goto L_0x010f;
    L_0x00c2:
        r0 = r13.b(r4, r5, r6);
        if (r0 == 0) goto L_0x010f;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x00fb;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.Fi;
        r8 = r9.d(r4, r8);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.Fi;
        r10 = r11.c(r4, r10);
        r11 = r13.Fi;
        r11 = r11.s(r4);
        r12 = r13.Fi;
        r12 = r12.N();
        if (r11 == 0) goto L_0x00f5;
    L_0x00f1:
        if (r11 <= 0) goto L_0x00fb;
    L_0x00f3:
        if (r8 != r7) goto L_0x00fb;
    L_0x00f5:
        if (r12 == 0) goto L_0x0111;
    L_0x00f7:
        if (r12 <= 0) goto L_0x00fb;
    L_0x00f9:
        if (r10 == r9) goto L_0x0111;
    L_0x00fb:
        r13.b(r5, r6, r3);
        r5 = r13.EV;
        r6 = 1;
        if (r5 == r6) goto L_0x0111;
    L_0x0103:
        if (r0 == 0) goto L_0x010b;
    L_0x0105:
        r0 = r13.o(r4, r3);
        if (r0 != 0) goto L_0x0111;
    L_0x010b:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x009a;
    L_0x010f:
        r0 = 0;
        goto L_0x00c9;
    L_0x0111:
        r13.i(r14);
        goto L_0x001f;
    L_0x0116:
        r0 = android.support.v4.view.o.c(r14, r1);
        r13.av(r0);
        goto L_0x001f;
    L_0x011f:
        r13.cancel();
        goto L_0x001f;
    L_0x0124:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.u.j(android.view.MotionEvent):boolean");
    }

    public final void k(MotionEvent motionEvent) {
        int i = 0;
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        if (d == 0) {
            cancel();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        float x;
        float y;
        View u;
        int left;
        switch (d) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = o.c(motionEvent, 0);
                u = u((int) x, (int) y);
                a(x, y, i);
                o(u, i);
                if ((this.Fa[i] & this.Fh) != 0) {
                    this.Fi.cv();
                    return;
                }
                return;
            case 1:
                if (this.EV == 1) {
                    cN();
                }
                cancel();
                return;
            case 2:
                int f;
                if (this.EV != 1) {
                    f = o.f(motionEvent);
                    while (i < f) {
                        d = o.c(motionEvent, i);
                        if (ay(d)) {
                            float d2 = o.d(motionEvent, i);
                            float e2 = o.e(motionEvent, i);
                            float f2 = d2 - this.EW[d];
                            float f3 = e2 - this.EX[d];
                            b(f2, f3, d);
                            if (this.EV != 1) {
                                u = u((int) d2, (int) e2);
                                if (b(u, f2, f3) && o(u, d)) {
                                }
                            }
                            i(motionEvent);
                            return;
                        }
                        i++;
                    }
                    i(motionEvent);
                    return;
                } else if (ay(this.fu)) {
                    i = o.b(motionEvent, this.fu);
                    x = o.d(motionEvent, i);
                    d = (int) (x - this.EY[this.fu]);
                    e = (int) (o.e(motionEvent, i) - this.EZ[this.fu]);
                    f = this.Fj.getLeft() + d;
                    i = this.Fj.getTop() + e;
                    left = this.Fj.getLeft();
                    int top = this.Fj.getTop();
                    if (d != 0) {
                        f = this.Fi.d(this.Fj, f);
                        z.k(this.Fj, f - left);
                    }
                    if (e != 0) {
                        i = this.Fi.c(this.Fj, i);
                        z.j(this.Fj, i - top);
                    }
                    if (!(d == 0 && e == 0)) {
                        this.Fi.a(this.Fj, f, i);
                    }
                    i(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.EV == 1) {
                    i(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = o.c(motionEvent, e);
                x = o.d(motionEvent, e);
                y = o.e(motionEvent, e);
                a(x, y, i);
                if (this.EV == 0) {
                    o(u((int) x, (int) y), i);
                    if ((this.Fa[i] & this.Fh) != 0) {
                        this.Fi.cv();
                        return;
                    }
                    return;
                }
                if (f(this.Fj, (int) x, (int) y)) {
                    o(this.Fj, i);
                    return;
                }
                return;
            case 6:
                d = o.c(motionEvent, e);
                if (this.EV == 1 && d == this.fu) {
                    e = o.f(motionEvent);
                    while (i < e) {
                        left = o.c(motionEvent, i);
                        if (left != this.fu) {
                            if (u((int) o.d(motionEvent, i), (int) o.e(motionEvent, i)) == this.Fj && o(this.Fj, left)) {
                                i = this.fu;
                                if (i == -1) {
                                    cN();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        cN();
                    }
                }
                av(d);
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.Fb;
            iArr[i] = iArr[i] | i2;
            this.Fi.q(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.Fa[i] & i2) != i2 || (this.Fh & i2) == 0 || (this.Fc[i] & i2) == i2 || (this.Fb[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.iN) || abs2 > ((float) this.iN)) && (this.Fb[i] & i2) == 0 && abs > ((float) this.iN)) {
            return true;
        }
        return false;
    }

    private boolean b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.Fi.s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Fi.N() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.iN * this.iN))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.iN)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.iN)) {
            return false;
        } else {
            return true;
        }
    }

    private void cN() {
        this.ft.computeCurrentVelocity(1000, this.Fe);
        i(f(y.a(this.ft, this.fu), this.Ff, this.Fe), f(y.b(this.ft, this.fu), this.Ff, this.Fe));
    }

    public static boolean f(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View u(int i, int i2) {
        for (int childCount = this.Fl.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Fl.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean ay(int i) {
        if (aw(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
