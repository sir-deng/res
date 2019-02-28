package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.e;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public final class a extends g implements i {
    private d UJ = null;
    RecyclerView Va;
    final List<View> aaB = new ArrayList();
    private final float[] aaC = new float[2];
    t aaD = null;
    float aaE;
    float aaF;
    float aaG;
    float aaH;
    float aaI;
    float aaJ;
    float aaK;
    float aaL;
    a aaM;
    int aaN = 0;
    int aaO;
    List<c> aaP = new ArrayList();
    private int aaQ;
    final Runnable aaR = new Runnable() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r14 = this;
            r12 = -9223372036854775808;
            r6 = 0;
            r8 = 0;
            r0 = android.support.v7.widget.a.a.this;
            r0 = r0.aaD;
            if (r0 == 0) goto L_0x00dd;
        L_0x000a:
            r9 = android.support.v7.widget.a.a.this;
            r0 = r9.aaD;
            if (r0 == 0) goto L_0x0134;
        L_0x0010:
            r10 = java.lang.System.currentTimeMillis();
            r0 = r9.aaY;
            r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1));
            if (r0 != 0) goto L_0x00de;
        L_0x001a:
            r4 = 0;
        L_0x001c:
            r0 = r9.Va;
            r0 = r0.TV;
            r1 = r9.gO;
            if (r1 != 0) goto L_0x002b;
        L_0x0024:
            r1 = new android.graphics.Rect;
            r1.<init>();
            r9.gO = r1;
        L_0x002b:
            r1 = r9.aaD;
            r1 = r1.VU;
            r2 = r9.gO;
            r0.a(r1, r2);
            r1 = r0.eR();
            if (r1 == 0) goto L_0x0109;
        L_0x003a:
            r1 = r9.aaK;
            r2 = r9.aaI;
            r1 = r1 + r2;
            r1 = (int) r1;
            r2 = r9.gO;
            r2 = r2.left;
            r2 = r1 - r2;
            r3 = r9.Va;
            r3 = r3.getPaddingLeft();
            r3 = r2 - r3;
            r2 = r9.aaI;
            r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r2 >= 0) goto L_0x00e4;
        L_0x0054:
            if (r3 >= 0) goto L_0x00e4;
        L_0x0056:
            r0 = r0.eS();
            if (r0 == 0) goto L_0x0131;
        L_0x005c:
            r0 = r9.aaL;
            r1 = r9.aaJ;
            r0 = r0 + r1;
            r0 = (int) r0;
            r1 = r9.gO;
            r1 = r1.top;
            r1 = r0 - r1;
            r2 = r9.Va;
            r2 = r2.getPaddingTop();
            r7 = r1 - r2;
            r1 = r9.aaJ;
            r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
            if (r1 >= 0) goto L_0x010c;
        L_0x0076:
            if (r7 >= 0) goto L_0x010c;
        L_0x0078:
            if (r3 == 0) goto L_0x013a;
        L_0x007a:
            r0 = r9.aaM;
            r1 = r9.Va;
            r2 = r9.aaD;
            r2 = r2.VU;
            r2 = r2.getWidth();
            r8 = r9.Va;
            r8.getWidth();
            r3 = r0.a(r1, r2, r3, r4);
            r8 = r3;
        L_0x0090:
            if (r7 == 0) goto L_0x0137;
        L_0x0092:
            r0 = r9.aaM;
            r1 = r9.Va;
            r2 = r9.aaD;
            r2 = r2.VU;
            r2 = r2.getHeight();
            r3 = r9.Va;
            r3.getHeight();
            r3 = r7;
            r0 = r0.a(r1, r2, r3, r4);
        L_0x00a8:
            if (r8 != 0) goto L_0x00ac;
        L_0x00aa:
            if (r0 == 0) goto L_0x0134;
        L_0x00ac:
            r2 = r9.aaY;
            r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
            if (r1 != 0) goto L_0x00b4;
        L_0x00b2:
            r9.aaY = r10;
        L_0x00b4:
            r1 = r9.Va;
            r1.scrollBy(r8, r0);
            r6 = 1;
        L_0x00ba:
            if (r6 == 0) goto L_0x00dd;
        L_0x00bc:
            r0 = android.support.v7.widget.a.a.this;
            r0 = r0.aaD;
            if (r0 == 0) goto L_0x00cb;
        L_0x00c2:
            r0 = android.support.v7.widget.a.a.this;
            r1 = android.support.v7.widget.a.a.this;
            r1 = r1.aaD;
            android.support.v7.widget.a.a.a(r0, r1);
        L_0x00cb:
            r0 = android.support.v7.widget.a.a.this;
            r0 = r0.Va;
            r1 = android.support.v7.widget.a.a.this;
            r1 = r1.aaR;
            r0.removeCallbacks(r1);
            r0 = android.support.v7.widget.a.a.this;
            r0 = r0.Va;
            android.support.v4.view.z.a(r0, r14);
        L_0x00dd:
            return;
        L_0x00de:
            r0 = r9.aaY;
            r4 = r10 - r0;
            goto L_0x001c;
        L_0x00e4:
            r2 = r9.aaI;
            r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r2 <= 0) goto L_0x0109;
        L_0x00ea:
            r2 = r9.aaD;
            r2 = r2.VU;
            r2 = r2.getWidth();
            r1 = r1 + r2;
            r2 = r9.gO;
            r2 = r2.right;
            r1 = r1 + r2;
            r2 = r9.Va;
            r2 = r2.getWidth();
            r3 = r9.Va;
            r3 = r3.getPaddingRight();
            r2 = r2 - r3;
            r3 = r1 - r2;
            if (r3 > 0) goto L_0x0056;
        L_0x0109:
            r3 = r6;
            goto L_0x0056;
        L_0x010c:
            r1 = r9.aaJ;
            r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
            if (r1 <= 0) goto L_0x0131;
        L_0x0112:
            r1 = r9.aaD;
            r1 = r1.VU;
            r1 = r1.getHeight();
            r0 = r0 + r1;
            r1 = r9.gO;
            r1 = r1.bottom;
            r0 = r0 + r1;
            r1 = r9.Va;
            r1 = r1.getHeight();
            r2 = r9.Va;
            r2 = r2.getPaddingBottom();
            r1 = r1 - r2;
            r7 = r0 - r1;
            if (r7 > 0) goto L_0x0078;
        L_0x0131:
            r7 = r6;
            goto L_0x0078;
        L_0x0134:
            r9.aaY = r12;
            goto L_0x00ba;
        L_0x0137:
            r0 = r7;
            goto L_0x00a8;
        L_0x013a:
            r8 = r3;
            goto L_0x0090;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.1.run():void");
        }
    };
    private List<t> aaS;
    private List<Integer> aaT;
    View aaU = null;
    int aaV = -1;
    e aaW;
    private final j aaX = new j() {
        public final boolean n(MotionEvent motionEvent) {
            a.this.aaW.onTouchEvent(motionEvent);
            int d = o.d(motionEvent);
            if (d == 0) {
                a.this.fu = o.c(motionEvent, 0);
                a.this.aaE = motionEvent.getX();
                a.this.aaF = motionEvent.getY();
                a aVar = a.this;
                if (aVar.ft != null) {
                    aVar.ft.recycle();
                }
                aVar.ft = VelocityTracker.obtain();
                if (a.this.aaD == null) {
                    c cVar;
                    a aVar2 = a.this;
                    if (!aVar2.aaP.isEmpty()) {
                        View p = aVar2.p(motionEvent);
                        for (int size = aVar2.aaP.size() - 1; size >= 0; size--) {
                            cVar = (c) aVar2.aaP.get(size);
                            if (cVar.Vh.VU == p) {
                                break;
                            }
                        }
                    }
                    cVar = null;
                    if (cVar != null) {
                        a aVar3 = a.this;
                        aVar3.aaE -= cVar.abo;
                        aVar3 = a.this;
                        aVar3.aaF -= cVar.abp;
                        a.this.a(cVar.Vh, true);
                        if (a.this.aaB.remove(cVar.Vh.VU)) {
                            a.this.aaM.c(a.this.Va, cVar.Vh);
                        }
                        a.this.d(cVar.Vh, cVar.aaN);
                        a.a(a.this, motionEvent, a.this.aaO, 0);
                    }
                }
            } else if (d == 3 || d == 1) {
                a.this.fu = -1;
                a.this.d(null, 0);
            } else if (a.this.fu != -1) {
                int b = o.b(motionEvent, a.this.fu);
                if (b >= 0) {
                    a.a(a.this, d, motionEvent, b);
                }
            }
            if (a.this.ft != null) {
                a.this.ft.addMovement(motionEvent);
            }
            if (a.this.aaD != null) {
                return true;
            }
            return false;
        }

        public final void o(MotionEvent motionEvent) {
            int i = 0;
            a.this.aaW.onTouchEvent(motionEvent);
            if (a.this.ft != null) {
                a.this.ft.addMovement(motionEvent);
            }
            if (a.this.fu != -1) {
                int d = o.d(motionEvent);
                int b = o.b(motionEvent, a.this.fu);
                if (b >= 0) {
                    a.a(a.this, d, motionEvent, b);
                }
                t tVar = a.this.aaD;
                if (tVar != null) {
                    switch (d) {
                        case 1:
                            break;
                        case 2:
                            if (b >= 0) {
                                a.a(a.this, motionEvent, a.this.aaO, b);
                                a.a(a.this, tVar);
                                a.this.Va.removeCallbacks(a.this.aaR);
                                a.this.aaR.run();
                                a.this.Va.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (a.this.ft != null) {
                                a.this.ft.clear();
                                break;
                            }
                            break;
                        case 6:
                            d = o.e(motionEvent);
                            if (o.c(motionEvent, d) == a.this.fu) {
                                if (d == 0) {
                                    i = 1;
                                }
                                a.this.fu = o.c(motionEvent, i);
                                a.a(a.this, motionEvent, a.this.aaO, d);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    a.this.d(null, 0);
                    a.this.fu = -1;
                }
            }
        }

        public final void U(boolean z) {
            if (z) {
                a.this.d(null, 0);
            }
        }
    };
    long aaY;
    VelocityTracker ft;
    int fu = -1;
    Rect gO;

    public static abstract class a {
        private static final b abd;
        private static final Interpolator abe = new Interpolator() {
            public final float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        };
        private static final Interpolator abf = new Interpolator() {
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        };
        private int abg = -1;

        public abstract boolean a(t tVar, t tVar2);

        public abstract int hh();

        public abstract void ho();

        static /* synthetic */ void a(a aVar, Canvas canvas, RecyclerView recyclerView, t tVar, List list, int i, float f, float f2) {
            int i2;
            c cVar;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                cVar = (c) list.get(i2);
                int save = canvas.save();
                a(canvas, recyclerView, cVar.Vh, cVar.abo, cVar.abp, cVar.aaN);
                canvas.restoreToCount(save);
            }
            if (tVar != null) {
                i2 = canvas.save();
                a(canvas, recyclerView, tVar, f, f2, i);
                canvas.restoreToCount(i2);
            }
            Object obj = null;
            int i3 = size - 1;
            while (i3 >= 0) {
                Object obj2;
                cVar = (c) list.get(i3);
                if (!cVar.oP || cVar.abn) {
                    obj2 = !cVar.oP ? 1 : obj;
                } else {
                    list.remove(i3);
                    obj2 = obj;
                }
                i3--;
                obj = obj2;
            }
            if (obj != null) {
                recyclerView.invalidate();
            }
        }

        static /* synthetic */ boolean a(a aVar, RecyclerView recyclerView, t tVar) {
            return (aVar.B(recyclerView) & 16711680) != 0;
        }

        static /* synthetic */ void b(a aVar, Canvas canvas, RecyclerView recyclerView, t tVar, List list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                c cVar = (c) list.get(i2);
                if (cVar.abh == cVar.abj) {
                    cVar.abo = z.Q(cVar.Vh.VU);
                } else {
                    cVar.abo = cVar.abh + (cVar.oN * (cVar.abj - cVar.abh));
                }
                if (cVar.abi == cVar.abk) {
                    cVar.abp = z.R(cVar.Vh.VU);
                } else {
                    cVar.abp = cVar.abi + (cVar.oN * (cVar.abk - cVar.abi));
                }
                int save = canvas.save();
                aVar.a(canvas, recyclerView, cVar.Vh, cVar.abo, cVar.abp, cVar.aaN, false);
                canvas.restoreToCount(save);
            }
            if (tVar != null) {
                i2 = canvas.save();
                aVar.a(canvas, recyclerView, tVar, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
        }

        static {
            if (VERSION.SDK_INT >= 21) {
                abd = new c();
            } else if (VERSION.SDK_INT >= 11) {
                abd = new b();
            } else {
                abd = new a();
            }
        }

        public static int al(int i, int i2) {
            int i3 = i & 789516;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 << 2);
            }
            return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
        }

        public static int am(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 >> 2);
            }
            return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
        }

        final int B(RecyclerView recyclerView) {
            return am(3342387, z.I(recyclerView));
        }

        public static boolean hi() {
            return true;
        }

        public boolean hj() {
            return true;
        }

        public boolean hk() {
            return true;
        }

        public static int hl() {
            return 0;
        }

        public static float hm() {
            return 0.5f;
        }

        public float hn() {
            return 0.5f;
        }

        public static float I(float f) {
            return f;
        }

        public static float J(float f) {
            return f;
        }

        public static t a(t tVar, List<t> list, int i, int i2) {
            int width = i + tVar.VU.getWidth();
            int height = i2 + tVar.VU.getHeight();
            t tVar2 = null;
            int i3 = -1;
            int left = i - tVar.VU.getLeft();
            int top = i2 - tVar.VU.getTop();
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5;
                t tVar3;
                int i6;
                t tVar4;
                int i7;
                t tVar5 = (t) list.get(i4);
                if (left > 0) {
                    int right = tVar5.VU.getRight() - width;
                    if (right < 0 && tVar5.VU.getRight() > tVar.VU.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            i5 = right;
                            tVar3 = tVar5;
                            if (left < 0) {
                                i3 = tVar5.VU.getLeft() - i;
                                if (i3 > 0 && tVar5.VU.getLeft() < tVar.VU.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        tVar3 = tVar5;
                                        if (top < 0) {
                                            i5 = tVar5.VU.getTop() - i2;
                                            if (i5 > 0 && tVar5.VU.getTop() < tVar.VU.getTop()) {
                                                i5 = Math.abs(i5);
                                                if (i5 > i3) {
                                                    tVar3 = tVar5;
                                                    if (top > 0) {
                                                        i3 = tVar5.VU.getBottom() - height;
                                                        if (i3 < 0 && tVar5.VU.getBottom() > tVar.VU.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > i5) {
                                                                i6 = i3;
                                                                tVar4 = tVar5;
                                                                i7 = i6;
                                                                i4++;
                                                                tVar2 = tVar4;
                                                                i3 = i7;
                                                            }
                                                        }
                                                    }
                                                    i7 = i5;
                                                    tVar4 = tVar3;
                                                    i4++;
                                                    tVar2 = tVar4;
                                                    i3 = i7;
                                                }
                                            }
                                        }
                                        i5 = i3;
                                        if (top > 0) {
                                            i3 = tVar5.VU.getBottom() - height;
                                            i3 = Math.abs(i3);
                                            if (i3 > i5) {
                                                i6 = i3;
                                                tVar4 = tVar5;
                                                i7 = i6;
                                                i4++;
                                                tVar2 = tVar4;
                                                i3 = i7;
                                            }
                                        }
                                        i7 = i5;
                                        tVar4 = tVar3;
                                        i4++;
                                        tVar2 = tVar4;
                                        i3 = i7;
                                    }
                                }
                            }
                            i3 = i5;
                            if (top < 0) {
                                i5 = tVar5.VU.getTop() - i2;
                                i5 = Math.abs(i5);
                                if (i5 > i3) {
                                    tVar3 = tVar5;
                                    if (top > 0) {
                                        i3 = tVar5.VU.getBottom() - height;
                                        i3 = Math.abs(i3);
                                        if (i3 > i5) {
                                            i6 = i3;
                                            tVar4 = tVar5;
                                            i7 = i6;
                                            i4++;
                                            tVar2 = tVar4;
                                            i3 = i7;
                                        }
                                    }
                                    i7 = i5;
                                    tVar4 = tVar3;
                                    i4++;
                                    tVar2 = tVar4;
                                    i3 = i7;
                                }
                            }
                            i5 = i3;
                            if (top > 0) {
                                i3 = tVar5.VU.getBottom() - height;
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    i6 = i3;
                                    tVar4 = tVar5;
                                    i7 = i6;
                                    i4++;
                                    tVar2 = tVar4;
                                    i3 = i7;
                                }
                            }
                            i7 = i5;
                            tVar4 = tVar3;
                            i4++;
                            tVar2 = tVar4;
                            i3 = i7;
                        }
                    }
                }
                tVar3 = tVar2;
                i5 = i3;
                if (left < 0) {
                    i3 = tVar5.VU.getLeft() - i;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        tVar3 = tVar5;
                        if (top < 0) {
                            i5 = tVar5.VU.getTop() - i2;
                            i5 = Math.abs(i5);
                            if (i5 > i3) {
                                tVar3 = tVar5;
                                if (top > 0) {
                                    i3 = tVar5.VU.getBottom() - height;
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        i6 = i3;
                                        tVar4 = tVar5;
                                        i7 = i6;
                                        i4++;
                                        tVar2 = tVar4;
                                        i3 = i7;
                                    }
                                }
                                i7 = i5;
                                tVar4 = tVar3;
                                i4++;
                                tVar2 = tVar4;
                                i3 = i7;
                            }
                        }
                        i5 = i3;
                        if (top > 0) {
                            i3 = tVar5.VU.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                tVar4 = tVar5;
                                i7 = i6;
                                i4++;
                                tVar2 = tVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        tVar4 = tVar3;
                        i4++;
                        tVar2 = tVar4;
                        i3 = i7;
                    }
                }
                i3 = i5;
                if (top < 0) {
                    i5 = tVar5.VU.getTop() - i2;
                    i5 = Math.abs(i5);
                    if (i5 > i3) {
                        tVar3 = tVar5;
                        if (top > 0) {
                            i3 = tVar5.VU.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                tVar4 = tVar5;
                                i7 = i6;
                                i4++;
                                tVar2 = tVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        tVar4 = tVar3;
                        i4++;
                        tVar2 = tVar4;
                        i3 = i7;
                    }
                }
                i5 = i3;
                if (top > 0) {
                    i3 = tVar5.VU.getBottom() - height;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        i6 = i3;
                        tVar4 = tVar5;
                        i7 = i6;
                        i4++;
                        tVar2 = tVar4;
                        i3 = i7;
                    }
                }
                i7 = i5;
                tVar4 = tVar3;
                i4++;
                tVar2 = tVar4;
                i3 = i7;
            }
            return tVar2;
        }

        public void e(t tVar, int i) {
            if (tVar != null) {
                abd.bz(tVar.VU);
            }
        }

        public void c(RecyclerView recyclerView, t tVar) {
            abd.by(tVar.VU);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, t tVar, float f, float f2, int i, boolean z) {
            abd.a(canvas, recyclerView, tVar.VU, f, f2, i, z);
        }

        private static void a(Canvas canvas, RecyclerView recyclerView, t tVar, float f, float f2, int i) {
            abd.a(canvas, recyclerView, tVar.VU, f, f2, i);
        }

        public static long f(RecyclerView recyclerView, int i) {
            RecyclerView.e eVar = recyclerView.Ur;
            return eVar == null ? i == 8 ? 200 : 250 : i == 8 ? eVar.UX : eVar.UW;
        }

        public final int a(RecyclerView recyclerView, int i, int i2, long j) {
            float f = 1.0f;
            if (this.abg == -1) {
                this.abg = recyclerView.getResources().getDimensionPixelSize(android.support.v7.d.a.a.Jo);
            }
            int signum = (int) (((float) (this.abg * ((int) Math.signum((float) i2)))) * abf.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (abe.getInterpolation(f) * ((float) signum));
            if (interpolation != 0) {
                return interpolation;
            }
            if (i2 > 0) {
                return 1;
            }
            return -1;
        }
    }

    private class b extends SimpleOnGestureListener {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            View p = a.this.p(motionEvent);
            if (p != null) {
                t aP = a.this.Va.aP(p);
                if (aP != null && a.a(a.this.aaM, a.this.Va, aP) && o.c(motionEvent, 0) == a.this.fu) {
                    int b = o.b(motionEvent, a.this.fu);
                    float d = o.d(motionEvent, b);
                    float e = o.e(motionEvent, b);
                    a.this.aaE = d;
                    a.this.aaF = e;
                    a aVar = a.this;
                    a.this.aaJ = 0.0f;
                    aVar.aaI = 0.0f;
                    a.this.aaM.hj();
                    a.this.d(aP, 2);
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.a.a$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int aba;
        final /* synthetic */ c abc;

        AnonymousClass4(c cVar, int i) {
            this.abc = cVar;
            this.aba = i;
        }

        public final void run() {
            if (a.this.Va != null && a.this.Va.isAttachedToWindow() && !this.abc.abq && this.abc.Vh.gf() != -1) {
                RecyclerView.e eVar = a.this.Va.Ur;
                if (eVar == null || !eVar.a(null)) {
                    Object obj;
                    a aVar = a.this;
                    int size = aVar.aaP.size();
                    for (int i = 0; i < size; i++) {
                        if (!((c) aVar.aaP.get(i)).oP) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        a.this.aaM.ho();
                        return;
                    }
                }
                a.this.Va.post(this);
            }
        }
    }

    private class c implements android.support.v4.a.b {
        final t Vh;
        final int aaN;
        final float abh;
        final float abi;
        final float abj;
        final float abk;
        final android.support.v4.a.g abl;
        final int abm;
        public boolean abn;
        float abo;
        float abp;
        boolean abq = false;
        float oN;
        boolean oP = false;

        public c(t tVar, int i, int i2, float f, float f2, float f3, float f4) {
            this.aaN = i2;
            this.abm = i;
            this.Vh = tVar;
            this.abh = f;
            this.abi = f2;
            this.abj = f3;
            this.abk = f4;
            this.abl = android.support.v4.a.a.aM();
            this.abl.a(new android.support.v4.a.d(a.this) {
                public final void b(android.support.v4.a.g gVar) {
                    c.this.oN = gVar.getAnimatedFraction();
                }
            });
            this.abl.w(tVar.VU);
            this.abl.a((android.support.v4.a.b) this);
            this.oN = 0.0f;
        }

        public void a(android.support.v4.a.g gVar) {
            if (!this.oP) {
                this.Vh.V(true);
            }
            this.oP = true;
        }

        public final void aN() {
            this.oN = 1.0f;
        }
    }

    static /* synthetic */ void a(a aVar, t tVar) {
        if (!aVar.Va.isLayoutRequested() && aVar.aaN == 2) {
            float hn = aVar.aaM.hn();
            int i = (int) (aVar.aaK + aVar.aaI);
            int i2 = (int) (aVar.aaL + aVar.aaJ);
            if (((float) Math.abs(i2 - tVar.VU.getTop())) >= ((float) tVar.VU.getHeight()) * hn || ((float) Math.abs(i - tVar.VU.getLeft())) >= hn * ((float) tVar.VU.getWidth())) {
                if (aVar.aaS == null) {
                    aVar.aaS = new ArrayList();
                    aVar.aaT = new ArrayList();
                } else {
                    aVar.aaS.clear();
                    aVar.aaT.clear();
                }
                a.hl();
                int round = Math.round(aVar.aaK + aVar.aaI) + 0;
                int round2 = Math.round(aVar.aaL + aVar.aaJ) + 0;
                int width = (tVar.VU.getWidth() + round) + 0;
                int height = (tVar.VU.getHeight() + round2) + 0;
                int i3 = (round + width) / 2;
                int i4 = (round2 + height) / 2;
                h hVar = aVar.Va.TV;
                int childCount = hVar.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = hVar.getChildAt(i5);
                    if (childAt != tVar.VU && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        t aP = aVar.Va.aP(childAt);
                        a.hi();
                        int abs = Math.abs(i3 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i4 - ((childAt.getBottom() + childAt.getTop()) / 2));
                        int i6 = (abs * abs) + (abs2 * abs2);
                        int size = aVar.aaS.size();
                        abs2 = 0;
                        int i7 = 0;
                        while (true) {
                            abs = abs2;
                            if (abs >= size || i6 <= ((Integer) aVar.aaT.get(abs)).intValue()) {
                                aVar.aaS.add(i7, aP);
                                aVar.aaT.add(i7, Integer.valueOf(i6));
                            } else {
                                i7++;
                                abs2 = abs + 1;
                            }
                        }
                        aVar.aaS.add(i7, aP);
                        aVar.aaT.add(i7, Integer.valueOf(i6));
                    }
                }
                List list = aVar.aaS;
                if (list.size() != 0) {
                    t a = a.a(tVar, list, i, i2);
                    if (a == null) {
                        aVar.aaS.clear();
                        aVar.aaT.clear();
                        return;
                    }
                    a.gf();
                    tVar.gf();
                    aVar.aaM.a(tVar, a);
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, MotionEvent motionEvent, int i, int i2) {
        float d = o.d(motionEvent, i2);
        float e = o.e(motionEvent, i2);
        aVar.aaI = d - aVar.aaE;
        aVar.aaJ = e - aVar.aaF;
        if ((i & 4) == 0) {
            aVar.aaI = Math.max(0.0f, aVar.aaI);
        }
        if ((i & 8) == 0) {
            aVar.aaI = Math.min(0.0f, aVar.aaI);
        }
        if ((i & 1) == 0) {
            aVar.aaJ = Math.max(0.0f, aVar.aaJ);
        }
        if ((i & 2) == 0) {
            aVar.aaJ = Math.min(0.0f, aVar.aaJ);
        }
    }

    static /* synthetic */ boolean a(a aVar, int i, MotionEvent motionEvent, int i2) {
        t tVar = null;
        if (aVar.aaD != null || i != 2 || aVar.aaN == 2 || !aVar.aaM.hk() || aVar.Va.yi == 1) {
            return false;
        }
        float d;
        float e;
        h hVar = aVar.Va.TV;
        if (aVar.fu != -1) {
            int b = o.b(motionEvent, aVar.fu);
            d = o.d(motionEvent, b) - aVar.aaE;
            e = o.e(motionEvent, b) - aVar.aaF;
            d = Math.abs(d);
            e = Math.abs(e);
            if ((d >= ((float) aVar.aaQ) || e >= ((float) aVar.aaQ)) && ((d <= e || !hVar.eR()) && (e <= d || !hVar.eS()))) {
                View p = aVar.p(motionEvent);
                if (p != null) {
                    tVar = aVar.Va.aP(p);
                }
            }
        }
        if (tVar == null) {
            return false;
        }
        int B = (aVar.aaM.B(aVar.Va) & 65280) >> 8;
        if (B == 0) {
            return false;
        }
        e = o.d(motionEvent, i2);
        e -= aVar.aaE;
        d = o.e(motionEvent, i2) - aVar.aaF;
        float abs = Math.abs(e);
        float abs2 = Math.abs(d);
        if (abs < ((float) aVar.aaQ) && abs2 < ((float) aVar.aaQ)) {
            return false;
        }
        if (abs > abs2) {
            if (e < 0.0f && (B & 4) == 0) {
                return false;
            }
            if (e > 0.0f && (B & 8) == 0) {
                return false;
            }
        } else if (d < 0.0f && (B & 1) == 0) {
            return false;
        } else {
            if (d > 0.0f && (B & 2) == 0) {
                return false;
            }
        }
        aVar.aaJ = 0.0f;
        aVar.aaI = 0.0f;
        aVar.fu = o.c(motionEvent, 0);
        aVar.d(tVar, 1);
        return true;
    }

    public a(a aVar) {
        this.aaM = aVar;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public final void A(RecyclerView recyclerView) {
        if (this.Va != recyclerView) {
            RecyclerView recyclerView2;
            if (this.Va != null) {
                View view = this.Va;
                if (view.TV != null) {
                    view.TV.w("Cannot remove item decoration during a scroll  or layout");
                }
                view.TX.remove(this);
                if (view.TX.isEmpty()) {
                    view.setWillNotDraw(z.B(view) == 2);
                }
                view.fJ();
                view.requestLayout();
                recyclerView2 = this.Va;
                j jVar = this.aaX;
                recyclerView2.TY.remove(jVar);
                if (recyclerView2.TZ == jVar) {
                    recyclerView2.TZ = null;
                }
                recyclerView2 = this.Va;
                if (recyclerView2.Uk != null) {
                    recyclerView2.Uk.remove(this);
                }
                for (int size = this.aaP.size() - 1; size >= 0; size--) {
                    this.aaM.c(this.Va, ((c) this.aaP.get(0)).Vh);
                }
                this.aaP.clear();
                this.aaU = null;
                this.aaV = -1;
                hg();
            }
            this.Va = recyclerView;
            if (this.Va != null) {
                Resources resources = recyclerView.getResources();
                this.aaG = resources.getDimension(android.support.v7.d.a.a.Jq);
                this.aaH = resources.getDimension(android.support.v7.d.a.a.Jp);
                this.aaQ = ViewConfiguration.get(this.Va.getContext()).getScaledTouchSlop();
                this.Va.a((g) this);
                this.Va.TY.add(this.aaX);
                recyclerView2 = this.Va;
                if (recyclerView2.Uk == null) {
                    recyclerView2.Uk = new ArrayList();
                }
                recyclerView2.Uk.add(this);
                if (this.aaW == null) {
                    this.aaW = new e(this.Va.getContext(), new b());
                }
            }
        }
    }

    private void c(float[] fArr) {
        if ((this.aaO & 12) != 0) {
            fArr[0] = (this.aaK + this.aaI) - ((float) this.aaD.VU.getLeft());
        } else {
            fArr[0] = z.Q(this.aaD.VU);
        }
        if ((this.aaO & 3) != 0) {
            fArr[1] = (this.aaL + this.aaJ) - ((float) this.aaD.VU.getTop());
        } else {
            fArr[1] = z.R(this.aaD.VU);
        }
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2 = 0.0f;
        if (this.aaD != null) {
            c(this.aaC);
            f = this.aaC[0];
            f2 = this.aaC[1];
        } else {
            f = 0.0f;
        }
        a.a(this.aaM, canvas, recyclerView, this.aaD, this.aaP, this.aaN, f, f2);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        float f;
        float f2 = 0.0f;
        this.aaV = -1;
        if (this.aaD != null) {
            c(this.aaC);
            f = this.aaC[0];
            f2 = this.aaC[1];
        } else {
            f = 0.0f;
        }
        a.b(this.aaM, canvas, recyclerView, this.aaD, this.aaP, this.aaN, f, f2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void d(android.support.v7.widget.RecyclerView.t r13, int r14) {
        /*
        r12 = this;
        r0 = r12.aaD;
        if (r13 != r0) goto L_0x0009;
    L_0x0004:
        r0 = r12.aaN;
        if (r14 != r0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = -9223372036854775808;
        r12.aaY = r0;
        r4 = r12.aaN;
        r0 = 1;
        r12.a(r13, r0);
        r12.aaN = r14;
        r0 = 2;
        if (r14 != r0) goto L_0x0034;
    L_0x0018:
        r0 = r13.VU;
        r12.aaU = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0034;
    L_0x0022:
        r0 = r12.UJ;
        if (r0 != 0) goto L_0x002d;
    L_0x0026:
        r0 = new android.support.v7.widget.a.a$5;
        r0.<init>();
        r12.UJ = r0;
    L_0x002d:
        r0 = r12.Va;
        r1 = r12.UJ;
        r0.a(r1);
    L_0x0034:
        r0 = 1;
        r1 = r14 * 8;
        r1 = r1 + 8;
        r0 = r0 << r1;
        r11 = r0 + -1;
        r0 = 0;
        r1 = r12.aaD;
        if (r1 == 0) goto L_0x00d1;
    L_0x0041:
        r2 = r12.aaD;
        r1 = r2.VU;
        r1 = r1.getParent();
        if (r1 == 0) goto L_0x017d;
    L_0x004b:
        r0 = 2;
        if (r4 == r0) goto L_0x0132;
    L_0x004e:
        r0 = r12.aaN;
        r1 = 2;
        if (r0 == r1) goto L_0x0132;
    L_0x0053:
        r0 = r12.aaM;
        r0 = r0.hh();
        r1 = r12.Va;
        r1 = android.support.v4.view.z.I(r1);
        r0 = android.support.v7.widget.a.a.a.am(r0, r1);
        r1 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r0 = r0 & r1;
        r0 = r0 >> 8;
        if (r0 == 0) goto L_0x0132;
    L_0x006b:
        r1 = r12.aaI;
        r1 = java.lang.Math.abs(r1);
        r3 = r12.aaJ;
        r3 = java.lang.Math.abs(r3);
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0135;
    L_0x007b:
        r9 = r12.bQ(r0);
        if (r9 <= 0) goto L_0x012c;
    L_0x0081:
        r0 = r9 & 0;
        if (r0 != 0) goto L_0x008f;
    L_0x0085:
        r0 = r12.Va;
        r0 = android.support.v4.view.z.I(r0);
        r9 = android.support.v7.widget.a.a.a.al(r9, r0);
    L_0x008f:
        r12.hg();
        switch(r9) {
            case 1: goto L_0x0163;
            case 2: goto L_0x0163;
            case 4: goto L_0x0151;
            case 8: goto L_0x0151;
            case 16: goto L_0x0151;
            case 32: goto L_0x0151;
            default: goto L_0x0095;
        };
    L_0x0095:
        r7 = 0;
        r8 = 0;
    L_0x0097:
        r0 = 2;
        if (r4 != r0) goto L_0x0175;
    L_0x009a:
        r3 = 8;
    L_0x009c:
        r0 = r12.aaC;
        r12.c(r0);
        r0 = r12.aaC;
        r1 = 0;
        r5 = r0[r1];
        r0 = r12.aaC;
        r1 = 1;
        r6 = r0[r1];
        r0 = new android.support.v7.widget.a.a$3;
        r1 = r12;
        r10 = r2;
        r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r1 = r12.Va;
        r2 = android.support.v7.widget.a.a.a.f(r1, r3);
        r1 = r0.abl;
        r1.setDuration(r2);
        r1 = r12.aaP;
        r1.add(r0);
        r1 = r0.Vh;
        r2 = 0;
        r1.V(r2);
        r0 = r0.abl;
        r0.start();
        r0 = 1;
    L_0x00ce:
        r1 = 0;
        r12.aaD = r1;
    L_0x00d1:
        r1 = r0;
        if (r13 == 0) goto L_0x0103;
    L_0x00d4:
        r0 = r12.aaM;
        r2 = r12.Va;
        r0 = r0.B(r2);
        r0 = r0 & r11;
        r2 = r12.aaN;
        r2 = r2 * 8;
        r0 = r0 >> r2;
        r12.aaO = r0;
        r0 = r13.VU;
        r0 = r0.getLeft();
        r0 = (float) r0;
        r12.aaK = r0;
        r0 = r13.VU;
        r0 = r0.getTop();
        r0 = (float) r0;
        r12.aaL = r0;
        r12.aaD = r13;
        r0 = 2;
        if (r14 != r0) goto L_0x0103;
    L_0x00fb:
        r0 = r12.aaD;
        r0 = r0.VU;
        r2 = 0;
        r0.performHapticFeedback(r2);
    L_0x0103:
        r0 = r12.Va;
        r2 = r0.getParent();
        if (r2 == 0) goto L_0x0113;
    L_0x010b:
        r0 = r12.aaD;
        if (r0 == 0) goto L_0x018b;
    L_0x010f:
        r0 = 1;
    L_0x0110:
        r2.requestDisallowInterceptTouchEvent(r0);
    L_0x0113:
        if (r1 != 0) goto L_0x011c;
    L_0x0115:
        r0 = r12.Va;
        r0 = r0.TV;
        r1 = 1;
        r0.Vc = r1;
    L_0x011c:
        r0 = r12.aaM;
        r1 = r12.aaD;
        r2 = r12.aaN;
        r0.e(r1, r2);
        r0 = r12.Va;
        r0.invalidate();
        goto L_0x0008;
    L_0x012c:
        r9 = r12.bR(r0);
        if (r9 > 0) goto L_0x008f;
    L_0x0132:
        r9 = 0;
        goto L_0x008f;
    L_0x0135:
        r9 = r12.bR(r0);
        if (r9 > 0) goto L_0x008f;
    L_0x013b:
        r9 = r12.bQ(r0);
        if (r9 <= 0) goto L_0x0132;
    L_0x0141:
        r0 = r9 & 0;
        if (r0 != 0) goto L_0x008f;
    L_0x0145:
        r0 = r12.Va;
        r0 = android.support.v4.view.z.I(r0);
        r9 = android.support.v7.widget.a.a.a.al(r9, r0);
        goto L_0x008f;
    L_0x0151:
        r8 = 0;
        r0 = r12.aaI;
        r0 = java.lang.Math.signum(r0);
        r1 = r12.Va;
        r1 = r1.getWidth();
        r1 = (float) r1;
        r7 = r0 * r1;
        goto L_0x0097;
    L_0x0163:
        r7 = 0;
        r0 = r12.aaJ;
        r0 = java.lang.Math.signum(r0);
        r1 = r12.Va;
        r1 = r1.getHeight();
        r1 = (float) r1;
        r8 = r0 * r1;
        goto L_0x0097;
    L_0x0175:
        if (r9 <= 0) goto L_0x017a;
    L_0x0177:
        r3 = 2;
        goto L_0x009c;
    L_0x017a:
        r3 = 4;
        goto L_0x009c;
    L_0x017d:
        r1 = r2.VU;
        r12.bx(r1);
        r1 = r12.aaM;
        r3 = r12.Va;
        r1.c(r3, r2);
        goto L_0x00ce;
    L_0x018b:
        r0 = 0;
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.d(android.support.v7.widget.RecyclerView$t, int):void");
    }

    public final void bl(View view) {
        bx(view);
        t aP = this.Va.aP(view);
        if (aP != null) {
            if (this.aaD == null || aP != this.aaD) {
                a(aP, false);
                if (this.aaB.remove(aP.VU)) {
                    this.aaM.c(this.Va, aP);
                    return;
                }
                return;
            }
            d(null, 0);
        }
    }

    final int a(t tVar, boolean z) {
        for (int size = this.aaP.size() - 1; size >= 0; size--) {
            c cVar = (c) this.aaP.get(size);
            if (cVar.Vh == tVar) {
                cVar.abq |= z;
                if (!cVar.oP) {
                    cVar.abl.cancel();
                }
                this.aaP.remove(size);
                return cVar.abm;
            }
        }
        return 0;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.setEmpty();
    }

    private void hg() {
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    final View p(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.aaD != null) {
            View view = this.aaD.VU;
            if (a(view, x, y, this.aaK + this.aaI, this.aaL + this.aaJ)) {
                return view;
            }
        }
        for (int size = this.aaP.size() - 1; size >= 0; size--) {
            c cVar = (c) this.aaP.get(size);
            View view2 = cVar.Vh.VU;
            if (a(view2, x, y, cVar.abo, cVar.abp)) {
                return view2;
            }
        }
        return this.Va.j(x, y);
    }

    private int bQ(int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.aaI > 0.0f ? 8 : 4;
            if (this.ft != null && this.fu >= 0) {
                this.ft.computeCurrentVelocity(1000, a.J(this.aaH));
                float a = y.a(this.ft, this.fu);
                float b = y.b(this.ft, this.fu);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= a.I(this.aaG) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            float width = ((float) this.Va.getWidth()) * a.hm();
            if ((i & i3) != 0 && Math.abs(this.aaI) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int bR(int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.aaJ > 0.0f ? 2 : 1;
            if (this.ft != null && this.fu >= 0) {
                this.ft.computeCurrentVelocity(1000, a.J(this.aaH));
                float a = y.a(this.ft, this.fu);
                float b = y.b(this.ft, this.fu);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= a.I(this.aaG) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            float height = ((float) this.Va.getHeight()) * a.hm();
            if ((i & i3) != 0 && Math.abs(this.aaJ) > height) {
                return i3;
            }
        }
        return 0;
    }

    final void bx(View view) {
        if (view == this.aaU) {
            this.aaU = null;
            if (this.UJ != null) {
                this.Va.a(null);
            }
        }
    }
}
