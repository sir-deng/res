package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements android.support.v4.view.p, w {
    private static final int[] TI = new int[]{16843830};
    private static final boolean TJ;
    static final boolean TK;
    private static final Class<?>[] TL = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final Interpolator UO = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private final int[] Do;
    private final int[] Dp;
    private final o TM;
    final m TN;
    private SavedState TO;
    e TP;
    s TQ;
    final as TR;
    private boolean TS;
    private final Runnable TT;
    private a TU;
    public h TV;
    private n TW;
    public final ArrayList<g> TX;
    public final ArrayList<j> TY;
    public j TZ;
    private final s UA;
    final q UB;
    public k UC;
    public List<k> UD;
    boolean UE;
    boolean UF;
    private b UG;
    private boolean UH;
    private ac UI;
    private d UJ;
    private final int[] UK;
    private android.support.v4.view.q UL;
    private final int[] UM;
    private Runnable UN;
    private final b UP;
    private boolean Ua;
    public boolean Ub;
    boolean Uc;
    private int Ud;
    private boolean Ue;
    public boolean Uf;
    private boolean Ug;
    private int Uh;
    private boolean Ui;
    private final boolean Uj;
    public List<i> Uk;
    boolean Ul;
    private int Um;
    android.support.v4.widget.i Un;
    android.support.v4.widget.i Uo;
    android.support.v4.widget.i Up;
    android.support.v4.widget.i Uq;
    public e Ur;
    private int Us;
    private int Ut;
    private int Uu;
    private int Uv;
    private int Uw;
    private final int Ux;
    private final int Uy;
    private float Uz;
    private final Rect ey;
    private VelocityTracker ft;
    private int iN;
    private final AccessibilityManager ju;
    public int yi;

    public static abstract class t {
        private static final List<Object> Wb = Collections.EMPTY_LIST;
        public final View VU;
        int VV = -1;
        public long VW = -1;
        public int VX = -1;
        int VY = -1;
        t VZ = null;
        t Wa = null;
        List<Object> Wc = null;
        List<Object> Wd = null;
        private int We = 0;
        private m Wf = null;
        private boolean Wg = false;
        private int Wh = 0;
        RecyclerView Wi;
        int mPosition = -1;
        private int ur;

        static /* synthetic */ void q(t tVar) {
            tVar.Wh = z.F(tVar.VU);
            z.i(tVar.VU, 4);
        }

        static /* synthetic */ void r(t tVar) {
            z.i(tVar.VU, tVar.Wh);
            tVar.Wh = 0;
        }

        static /* synthetic */ boolean s(t tVar) {
            return (tVar.ur & 16) == 0 && z.D(tVar.VU);
        }

        static /* synthetic */ boolean w(t tVar) {
            return (tVar.ur & 16) != 0;
        }

        public t(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.VU = view;
        }

        final void i(int i, boolean z) {
            if (this.VV == -1) {
                this.VV = this.mPosition;
            }
            if (this.VY == -1) {
                this.VY = this.mPosition;
            }
            if (z) {
                this.VY += i;
            }
            this.mPosition += i;
            if (this.VU.getLayoutParams() != null) {
                ((LayoutParams) this.VU.getLayoutParams()).Vi = true;
            }
        }

        final void gb() {
            this.VV = -1;
            this.VY = -1;
        }

        final boolean gd() {
            return (this.ur & FileUtils.S_IWUSR) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.VY == -1 ? this.mPosition : this.VY;
        }

        public final int ge() {
            return this.VY == -1 ? this.mPosition : this.VY;
        }

        public final int gf() {
            if (this.Wi == null) {
                return -1;
            }
            return this.Wi.h(this);
        }

        final boolean gg() {
            return this.Wf != null;
        }

        final void gh() {
            this.Wf.p(this);
        }

        final boolean gi() {
            return (this.ur & 32) != 0;
        }

        final void gj() {
            this.ur &= -33;
        }

        final void gk() {
            this.ur &= -257;
        }

        final void a(m mVar, boolean z) {
            this.Wf = mVar;
            this.Wg = z;
        }

        final boolean gl() {
            return (this.ur & 4) != 0;
        }

        final boolean gm() {
            return (this.ur & 2) != 0;
        }

        final boolean isBound() {
            return (this.ur & 1) != 0;
        }

        final boolean isRemoved() {
            return (this.ur & 8) != 0;
        }

        final boolean bv(int i) {
            return (this.ur & i) != 0;
        }

        final boolean gn() {
            return (this.ur & 256) != 0;
        }

        final void setFlags(int i, int i2) {
            this.ur = (this.ur & (i2 ^ -1)) | (i & i2);
        }

        final void addFlags(int i) {
            this.ur |= i;
        }

        final void S(Object obj) {
            if (obj == null) {
                addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } else if ((this.ur & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                if (this.Wc == null) {
                    this.Wc = new ArrayList();
                    this.Wd = Collections.unmodifiableList(this.Wc);
                }
                this.Wc.add(obj);
            }
        }

        final void go() {
            if (this.Wc != null) {
                this.Wc.clear();
            }
            this.ur &= -1025;
        }

        final List<Object> gp() {
            if ((this.ur & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                return Wb;
            }
            if (this.Wc == null || this.Wc.size() == 0) {
                return Wb;
            }
            return this.Wd;
        }

        final void gq() {
            this.ur = 0;
            this.mPosition = -1;
            this.VV = -1;
            this.VW = -1;
            this.VY = -1;
            this.We = 0;
            this.VZ = null;
            this.Wa = null;
            go();
            this.Wh = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.VW + ", oldPos=" + this.VV + ", pLpos:" + this.VY);
            if (gg()) {
                stringBuilder.append(" scrap ").append(this.Wg ? "[changeScrap]" : "[attachedScrap]");
            }
            if (gl()) {
                stringBuilder.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder.append(" unbound");
            }
            if (gm()) {
                stringBuilder.append(" update");
            }
            if (isRemoved()) {
                stringBuilder.append(" removed");
            }
            if (gd()) {
                stringBuilder.append(" ignored");
            }
            if (gn()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!gr()) {
                stringBuilder.append(" not recyclable(" + this.We + ")");
            }
            Object obj = ((this.ur & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 || gl()) ? 1 : null;
            if (obj != null) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.VU.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void V(boolean z) {
            this.We = z ? this.We - 1 : this.We + 1;
            if (this.We < 0) {
                this.We = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && this.We == 1) {
                this.ur |= 16;
            } else if (z && this.We == 0) {
                this.ur &= -17;
            }
        }

        public final boolean gr() {
            return (this.ur & 16) == 0 && !z.D(this.VU);
        }

        final boolean gs() {
            return (this.ur & 2) != 0;
        }
    }

    public static class l {
        SparseArray<ArrayList<t>> Vk = new SparseArray();
        SparseIntArray Vl = new SparseIntArray();
        int Vm = 0;
    }

    public static abstract class p {
        h TG;
        RecyclerView Va;
        public int Vv = -1;
        boolean Vw;
        boolean Vx;
        View Vy;
        private final a Vz = new a();

        public static class a {
            private int VA;
            private int VB;
            int VC;
            private boolean VD;
            private int VE;
            private int mDuration;
            private Interpolator mInterpolator;

            static /* synthetic */ void a(a aVar, RecyclerView recyclerView) {
                if (aVar.VC >= 0) {
                    int i = aVar.VC;
                    aVar.VC = -1;
                    RecyclerView.d(recyclerView, i);
                    aVar.VD = false;
                } else if (!aVar.VD) {
                    aVar.VE = 0;
                } else if (aVar.mInterpolator != null && aVar.mDuration <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (aVar.mDuration <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    if (aVar.mInterpolator != null) {
                        recyclerView.UA.b(aVar.VA, aVar.VB, aVar.mDuration, aVar.mInterpolator);
                    } else if (aVar.mDuration == Integer.MIN_VALUE) {
                        recyclerView.UA.smoothScrollBy(aVar.VA, aVar.VB);
                    } else {
                        recyclerView.UA.o(aVar.VA, aVar.VB, aVar.mDuration);
                    }
                    aVar.VE++;
                    aVar.VD = false;
                }
            }

            public a() {
                this(0, 0);
            }

            private a(int i, int i2) {
                this.VC = -1;
                this.VD = false;
                this.VE = 0;
                this.VA = 0;
                this.VB = 0;
                this.mDuration = Integer.MIN_VALUE;
                this.mInterpolator = null;
            }

            public final void a(int i, int i2, int i3, Interpolator interpolator) {
                this.VA = i;
                this.VB = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.VD = true;
            }
        }

        protected abstract void a(int i, int i2, a aVar);

        protected abstract void a(View view, a aVar);

        protected abstract void onStop();

        static /* synthetic */ void a(p pVar, int i, int i2) {
            boolean z = false;
            RecyclerView recyclerView = pVar.Va;
            if (!pVar.Vx || pVar.Vv == -1 || recyclerView == null) {
                pVar.stop();
            }
            pVar.Vw = false;
            if (pVar.Vy != null) {
                if (RecyclerView.ba(pVar.Vy) == pVar.Vv) {
                    View view = pVar.Vy;
                    q qVar = recyclerView.UB;
                    pVar.a(view, pVar.Vz);
                    a.a(pVar.Vz, recyclerView);
                    pVar.stop();
                } else {
                    pVar.Vy = null;
                }
            }
            if (pVar.Vx) {
                q qVar2 = recyclerView.UB;
                pVar.a(i, i2, pVar.Vz);
                if (pVar.Vz.VC >= 0) {
                    z = true;
                }
                a.a(pVar.Vz, recyclerView);
                if (!z) {
                    return;
                }
                if (pVar.Vx) {
                    pVar.Vw = true;
                    recyclerView.UA.ga();
                    return;
                }
                pVar.stop();
            }
        }

        protected final void stop() {
            if (this.Vx) {
                onStop();
                this.Va.UB.Vv = -1;
                this.Vy = null;
                this.Vv = -1;
                this.Vw = false;
                this.Vx = false;
                h.a(this.TG, this);
                this.TG = null;
                this.Va = null;
            }
        }
    }

    public static class q {
        int VF = 1;
        private SparseArray<Object> VG;
        int VH = 0;
        int VI = 0;
        int VJ = 0;
        boolean VK = false;
        boolean VL = false;
        boolean VM = false;
        boolean VN = false;
        boolean VO = false;
        boolean VP = false;
        int Vv = -1;

        final void bu(int i) {
            if ((this.VF & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.VF));
            }
        }

        public final int getItemCount() {
            return this.VL ? this.VI - this.VJ : this.VH;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.Vv + ", mData=" + this.VG + ", mItemCount=" + this.VH + ", mPreviousLayoutItemCount=" + this.VI + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.VJ + ", mStructureChanged=" + this.VK + ", mInPreLayout=" + this.VL + ", mRunSimpleAnimations=" + this.VM + ", mRunPredictiveAnimations=" + this.VN + '}';
        }
    }

    public static abstract class r {
        public abstract View fZ();
    }

    private class s implements Runnable {
        int VQ;
        int VR;
        private boolean VS = false;
        private boolean VT = false;
        android.support.v4.widget.q iK;
        private Interpolator mInterpolator = RecyclerView.UO;

        public s() {
            this.iK = android.support.v4.widget.q.a(RecyclerView.this.getContext(), RecyclerView.UO);
        }

        public final void run() {
            if (RecyclerView.this.TV == null) {
                stop();
                return;
            }
            this.VT = false;
            this.VS = true;
            RecyclerView.this.fo();
            android.support.v4.widget.q qVar = this.iK;
            p pVar = RecyclerView.this.TV.Vb;
            if (qVar.computeScrollOffset()) {
                int itemCount;
                int i;
                int currVelocity;
                int i2;
                View view;
                Object obj;
                Object obj2;
                int currX = qVar.getCurrX();
                int currY = qVar.getCurrY();
                int i3 = currX - this.VQ;
                int i4 = currY - this.VR;
                int i5 = 0;
                int i6 = 0;
                this.VQ = currX;
                this.VR = currY;
                int i7 = 0;
                int i8 = 0;
                if (RecyclerView.this.TU != null) {
                    RecyclerView.this.fp();
                    RecyclerView.this.fz();
                    android.support.v4.os.e.beginSection("RV Scroll");
                    if (i3 != 0) {
                        i5 = RecyclerView.this.TV.a(i3, RecyclerView.this.TN, RecyclerView.this.UB);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = RecyclerView.this.TV.b(i4, RecyclerView.this.TN, RecyclerView.this.UB);
                        i8 = i4 - i6;
                    }
                    android.support.v4.os.e.endSection();
                    RecyclerView.this.fM();
                    RecyclerView.this.fA();
                    RecyclerView.this.S(false);
                    if (!(pVar == null || pVar.Vw || !pVar.Vx)) {
                        itemCount = RecyclerView.this.UB.getItemCount();
                        if (itemCount == 0) {
                            pVar.stop();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                            if (!RecyclerView.this.TX.isEmpty()) {
                                RecyclerView.this.invalidate();
                            }
                            if (z.B(RecyclerView.this) != 2) {
                                RecyclerView.this.R(i3, i4);
                            }
                            if (!(i6 == 0 && i8 == 0)) {
                                currVelocity = (int) qVar.getCurrVelocity();
                                if (i6 == currX) {
                                    itemCount = i6 >= 0 ? -currVelocity : i6 <= 0 ? currVelocity : 0;
                                    i2 = itemCount;
                                } else {
                                    i2 = 0;
                                }
                                if (i8 != currY) {
                                    currVelocity = 0;
                                } else if (i8 < 0) {
                                    currVelocity = -currVelocity;
                                } else if (i8 <= 0) {
                                    currVelocity = 0;
                                }
                                if (z.B(RecyclerView.this) != 2) {
                                    view = RecyclerView.this;
                                    if (i2 < 0) {
                                        view.fs();
                                        view.Un.ap(-i2);
                                    } else if (i2 > 0) {
                                        view.ft();
                                        view.Up.ap(i2);
                                    }
                                    if (currVelocity < 0) {
                                        view.fu();
                                        view.Uo.ap(-currVelocity);
                                    } else if (currVelocity > 0) {
                                        view.fv();
                                        view.Uq.ap(currVelocity);
                                    }
                                    if (!(i2 == 0 && currVelocity == 0)) {
                                        z.E(view);
                                    }
                                }
                                if ((i2 != 0 || i6 == currX || qVar.getFinalX() == 0) && (currVelocity != 0 || i8 == currY || qVar.getFinalY() == 0)) {
                                    qVar.abortAnimation();
                                }
                            }
                            if (!(i5 == 0 && i7 == 0)) {
                                RecyclerView.this.T(i5, i7);
                            }
                            if (!RecyclerView.this.awakenScrollBars()) {
                                RecyclerView.this.invalidate();
                            }
                            obj = (i4 == 0 && RecyclerView.this.TV.eS() && i7 == i4) ? 1 : null;
                            obj2 = (i3 == 0 && RecyclerView.this.TV.eR() && i5 == i3) ? 1 : null;
                            obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                            if (!qVar.isFinished() || obj2 == null) {
                                RecyclerView.this.ag(0);
                            } else {
                                ga();
                            }
                        } else {
                            if (pVar.Vv >= itemCount) {
                                pVar.Vv = itemCount - 1;
                            }
                            p.a(pVar, i3 - i7, i4 - i8);
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (RecyclerView.this.TX.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (z.B(RecyclerView.this) != 2) {
                    RecyclerView.this.R(i3, i4);
                }
                currVelocity = (int) qVar.getCurrVelocity();
                if (i6 == currX) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = itemCount;
                }
                if (i8 != currY) {
                    currVelocity = 0;
                } else if (i8 < 0) {
                    currVelocity = -currVelocity;
                } else if (i8 <= 0) {
                    currVelocity = 0;
                }
                if (z.B(RecyclerView.this) != 2) {
                    view = RecyclerView.this;
                    if (i2 < 0) {
                        view.fs();
                        view.Un.ap(-i2);
                    } else if (i2 > 0) {
                        view.ft();
                        view.Up.ap(i2);
                    }
                    if (currVelocity < 0) {
                        view.fu();
                        view.Uo.ap(-currVelocity);
                    } else if (currVelocity > 0) {
                        view.fv();
                        view.Uq.ap(currVelocity);
                    }
                    z.E(view);
                }
                qVar.abortAnimation();
                RecyclerView.this.T(i5, i7);
                if (RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (qVar.isFinished()) {
                }
                RecyclerView.this.ag(0);
            }
            if (pVar != null) {
                if (pVar.Vw) {
                    p.a(pVar, 0, 0);
                }
                if (!this.VT) {
                    pVar.stop();
                }
            }
            this.VS = false;
            if (this.VT) {
                ga();
            }
        }

        final void ga() {
            if (this.VS) {
                this.VT = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            z.a(RecyclerView.this, (Runnable) this);
        }

        public final void smoothScrollBy(int i, int i2) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i3 = width / 2;
            float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            o(i, i2, Math.min(round, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN));
        }

        public final void o(int i, int i2, int i3) {
            b(i, i2, i3, RecyclerView.UO);
        }

        public final void b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.iK = android.support.v4.widget.q.a(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.ag(2);
            this.VR = 0;
            this.VQ = 0;
            this.iK.startScroll(0, 0, i, i2, i3);
            ga();
        }

        public final void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.iK.abortAnimation();
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        final Rect RC = new Rect();
        t Vh;
        boolean Vi = true;
        boolean Vj = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static abstract class a<VH extends t> {
        public final b UR = new b();
        public boolean US = false;

        public abstract VH a(ViewGroup viewGroup, int i);

        public abstract void a(VH vh, int i);

        public abstract int getItemCount();

        public void a(VH vh, int i, List<Object> list) {
            a((t) vh, i);
        }

        public final VH d(ViewGroup viewGroup, int i) {
            android.support.v4.os.e.beginSection("RV CreateView");
            VH a = a(viewGroup, i);
            a.VX = i;
            android.support.v4.os.e.endSection();
            return a;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final void fQ() {
            if (this.UR.fR()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.US = true;
        }

        public long getItemId(int i) {
            return -1;
        }

        public void a(VH vh) {
        }

        public final void a(c cVar) {
            this.UR.registerObserver(cVar);
        }

        public final void b(c cVar) {
            this.UR.unregisterObserver(cVar);
        }

        public final void bj(int i) {
            this.UR.U(i, 1);
        }

        public final void b(int i, Object obj) {
            this.UR.b(i, 1, obj);
        }

        public final void U(int i, int i2) {
            this.UR.U(i, i2);
        }

        public final void b(int i, int i2, Object obj) {
            this.UR.b(i, i2, obj);
        }

        public final void bk(int i) {
            this.UR.W(i, 1);
        }

        public final void V(int i, int i2) {
            this.UR.V(i, i2);
        }

        public final void W(int i, int i2) {
            this.UR.W(i, i2);
        }

        public final void bl(int i) {
            this.UR.X(i, 1);
        }

        public final void X(int i, int i2) {
            this.UR.X(i, i2);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public final boolean fR() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void U(int i, int i2) {
            b(i, i2, null);
        }

        public final void b(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2, obj);
            }
        }

        public final void W(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).Z(i, i2);
            }
        }

        public final void X(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).aa(i, i2);
            }
        }

        public final void V(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).ab(i, i2);
            }
        }
    }

    public static abstract class c {
        public void onChanged() {
        }

        public void Y(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            Y(i, i2);
        }

        public void Z(int i, int i2) {
        }

        public void aa(int i, int i2) {
        }

        public void ab(int i, int i2) {
        }
    }

    public static abstract class e {
        b UT = null;
        private ArrayList<a> UU = new ArrayList();
        public long UV = 120;
        public long UW = 120;
        public long UX = 250;
        public long UY = 250;

        interface b {
            void l(t tVar);
        }

        public interface a {
            void fT();
        }

        public static class c {
            public int UZ;
            public int bottom;
            public int left;
            public int right;
            public int top;

            public c b(t tVar, int i) {
                View view = tVar.VU;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public abstract boolean a(t tVar, t tVar2, c cVar, c cVar2);

        public abstract void d(t tVar);

        public abstract boolean d(t tVar, c cVar, c cVar2);

        public abstract boolean e(t tVar, c cVar, c cVar2);

        public abstract void eJ();

        public abstract void eL();

        public abstract boolean f(t tVar, c cVar, c cVar2);

        public abstract boolean isRunning();

        public c a(q qVar, t tVar, int i, List<Object> list) {
            return new c().b(tVar, 0);
        }

        static int j(t tVar) {
            int x = tVar.ur & 14;
            if (tVar.gl()) {
                return 4;
            }
            if ((x & 4) != 0) {
                return x;
            }
            int i = tVar.VV;
            int gf = tVar.gf();
            if (i == -1 || gf == -1 || i == gf) {
                return x;
            }
            return x | 2048;
        }

        public final void k(t tVar) {
            l(tVar);
            if (this.UT != null) {
                this.UT.l(tVar);
            }
        }

        public void l(t tVar) {
        }

        public final boolean a(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (isRunning) {
                    this.UU.add(aVar);
                } else {
                    aVar.fT();
                }
            }
            return isRunning;
        }

        public boolean m(t tVar) {
            return true;
        }

        public boolean a(t tVar, List<Object> list) {
            return m(tVar);
        }

        public final void fS() {
            int size = this.UU.size();
            for (int i = 0; i < size; i++) {
                ((a) this.UU.get(i)).fT();
            }
            this.UU.clear();
        }
    }

    public static abstract class g {
        public void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
            ((LayoutParams) view.getLayoutParams()).Vh.ge();
            rect.set(0, 0, 0, 0);
        }
    }

    public interface n {
    }

    public interface d {
        int ac(int i, int i2);
    }

    public interface i {
        void bl(View view);
    }

    public interface j {
        void U(boolean z);

        boolean n(MotionEvent motionEvent);

        void o(MotionEvent motionEvent);
    }

    public static abstract class k {
        public void e(RecyclerView recyclerView, int i) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable Vu;

        SavedState(Parcel parcel) {
            super(parcel);
            this.Vu = parcel.readParcelable(h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.Vu, 0);
        }
    }

    private class f implements b {
        private f() {
        }

        /* synthetic */ f(RecyclerView recyclerView, byte b) {
            this();
        }

        public final void l(t tVar) {
            tVar.V(true);
            if (tVar.VZ != null && tVar.Wa == null) {
                tVar.VZ = null;
            }
            tVar.Wa = null;
            if (!t.w(tVar) && !RecyclerView.c(RecyclerView.this, tVar.VU) && tVar.gn()) {
                RecyclerView.this.removeDetachedView(tVar.VU, false);
            }
        }
    }

    public static abstract class h {
        s TQ;
        RecyclerView Va;
        p Vb;
        public boolean Vc = false;
        boolean Vd = false;
        boolean Ve = true;
        int Vf;
        int Vg;
        boolean hq = false;
        int mHeight;
        int mWidth;

        public abstract LayoutParams eN();

        static /* synthetic */ void a(h hVar, p pVar) {
            if (hVar.Vb == pVar) {
                hVar.Vb = null;
            }
        }

        final void y(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.Va = null;
                this.TQ = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.Va = recyclerView;
                this.TQ = recyclerView.TQ;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.Vf = 1073741824;
            this.Vg = 1073741824;
        }

        final void ad(int i, int i2) {
            this.mWidth = MeasureSpec.getSize(i);
            this.Vf = MeasureSpec.getMode(i);
            if (this.Vf == 0 && !RecyclerView.TK) {
                this.mWidth = 0;
            }
            this.mHeight = MeasureSpec.getSize(i2);
            this.Vg = MeasureSpec.getMode(i2);
            if (this.Vg == 0 && !RecyclerView.TK) {
                this.mHeight = 0;
            }
        }

        final void ae(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.Va.S(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int bh = bh(childAt) - layoutParams.leftMargin;
                int bj = layoutParams.rightMargin + bj(childAt);
                int bi = bi(childAt) - layoutParams.topMargin;
                int bk = layoutParams.bottomMargin + bk(childAt);
                if (bh >= i7) {
                    bh = i7;
                }
                if (bj <= i6) {
                    bj = i6;
                }
                if (bi >= i3) {
                    bi = i3;
                }
                if (bk <= i4) {
                    bk = i4;
                }
                i5++;
                i6 = bj;
                i3 = bi;
                i7 = bh;
                i4 = bk;
            }
            this.Va.ey.set(i7, i3, i6, i4);
            a(this.Va.ey, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            setMeasuredDimension(m(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), z.S(this.Va)), m(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), z.T(this.Va)));
        }

        public final void requestLayout() {
            if (this.Va != null) {
                this.Va.requestLayout();
            }
        }

        public static int m(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void w(String str) {
            if (this.Va != null) {
                this.Va.w(str);
            }
        }

        public boolean eQ() {
            return false;
        }

        final void b(RecyclerView recyclerView, m mVar) {
            this.hq = false;
            a(recyclerView, mVar);
        }

        public final boolean removeCallbacks(Runnable runnable) {
            if (this.Va != null) {
                return this.Va.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, m mVar) {
        }

        public void c(m mVar, q qVar) {
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams e(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int a(int i, m mVar, q qVar) {
            return 0;
        }

        public int b(int i, m mVar, q qVar) {
            return 0;
        }

        public boolean eR() {
            return false;
        }

        public boolean eS() {
            return false;
        }

        public void be(int i) {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public final void a(p pVar) {
            if (!(this.Vb == null || pVar == this.Vb || !this.Vb.Vx)) {
                this.Vb.stop();
            }
            this.Vb = pVar;
            p pVar2 = this.Vb;
            pVar2.Va = this.Va;
            pVar2.TG = this;
            if (pVar2.Vv == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            pVar2.Va.UB.Vv = pVar2.Vv;
            pVar2.Vx = true;
            pVar2.Vw = true;
            pVar2.Vy = pVar2.Va.TV.bc(pVar2.Vv);
            pVar2.Va.UA.ga();
        }

        public final boolean fU() {
            return this.Vb != null && this.Vb.Vx;
        }

        void c(View view, int i, boolean z) {
            t aY = RecyclerView.aY(view);
            if (z || aY.isRemoved()) {
                this.Va.TR.D(aY);
            } else {
                this.Va.TR.E(aY);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aY.gi() || aY.gg()) {
                if (aY.gg()) {
                    aY.gh();
                } else {
                    aY.gj();
                }
                this.TQ.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.Va) {
                int indexOfChild = this.TQ.indexOfChild(view);
                if (i == -1) {
                    i = this.TQ.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.Va.indexOfChild(view));
                } else if (indexOfChild != i) {
                    h hVar = this.Va.TV;
                    View childAt = hVar.getChildAt(indexOfChild);
                    if (childAt == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + indexOfChild);
                    }
                    hVar.bm(indexOfChild);
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    t aY2 = RecyclerView.aY(childAt);
                    if (aY2.isRemoved()) {
                        hVar.Va.TR.D(aY2);
                    } else {
                        hVar.Va.TR.E(aY2);
                    }
                    hVar.TQ.a(childAt, i, layoutParams2, aY2.isRemoved());
                }
            } else {
                this.TQ.a(view, i, false);
                layoutParams.Vi = true;
                if (this.Vb != null && this.Vb.Vx) {
                    p pVar = this.Vb;
                    if (RecyclerView.ba(view) == pVar.Vv) {
                        pVar.Vy = view;
                    }
                }
            }
            if (layoutParams.Vj) {
                aY.VU.invalidate();
                layoutParams.Vj = false;
            }
        }

        private void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                s sVar = this.TQ;
                int aT = sVar.aT(i);
                View childAt = sVar.QB.getChildAt(aT);
                if (childAt != null) {
                    if (sVar.QC.aV(aT)) {
                        sVar.aN(childAt);
                    }
                    sVar.QB.removeViewAt(aT);
                }
            }
        }

        public static int bd(View view) {
            return ((LayoutParams) view.getLayoutParams()).Vh.ge();
        }

        public final View be(View view) {
            if (this.Va == null) {
                return null;
            }
            View view2;
            ViewParent viewParent = this.Va;
            ViewParent parent = view.getParent();
            View view3 = view;
            while (parent != null && parent != viewParent && (parent instanceof View)) {
                view2 = (View) parent;
                view3 = view2;
                parent = view2.getParent();
            }
            if (parent == viewParent) {
                view2 = view3;
            } else {
                view2 = null;
            }
            if (view2 == null) {
                return null;
            }
            if (this.TQ.aO(view2)) {
                return null;
            }
            return view2;
        }

        public View bc(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                t aY = RecyclerView.aY(childAt);
                if (aY != null && aY.ge() == i && !aY.gd() && (this.Va.UB.VL || !aY.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        private void bm(int i) {
            getChildAt(i);
            this.TQ.detachViewFromParent(i);
        }

        public final void a(View view, m mVar) {
            s sVar = this.TQ;
            int indexOfChild = sVar.QB.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (sVar.QC.aV(indexOfChild)) {
                    sVar.aN(view);
                }
                sVar.QB.removeViewAt(indexOfChild);
            }
            mVar.bm(view);
        }

        public final void a(int i, m mVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            mVar.bm(childAt);
        }

        public final int getChildCount() {
            return this.TQ != null ? this.TQ.getChildCount() : 0;
        }

        public final View getChildAt(int i) {
            return this.TQ != null ? this.TQ.getChildAt(i) : null;
        }

        public final int getPaddingLeft() {
            return this.Va != null ? this.Va.getPaddingLeft() : 0;
        }

        public final int getPaddingTop() {
            return this.Va != null ? this.Va.getPaddingTop() : 0;
        }

        public final int getPaddingRight() {
            return this.Va != null ? this.Va.getPaddingRight() : 0;
        }

        public final int getPaddingBottom() {
            return this.Va != null ? this.Va.getPaddingBottom() : 0;
        }

        public void bn(int i) {
            if (this.Va != null) {
                RecyclerView recyclerView = this.Va;
                int childCount = recyclerView.TQ.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.TQ.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void bo(int i) {
            if (this.Va != null) {
                RecyclerView recyclerView = this.Va;
                int childCount = recyclerView.TQ.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.TQ.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        public final void b(m mVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                t aY = RecyclerView.aY(childAt);
                if (!aY.gd()) {
                    if (!aY.gl() || aY.isRemoved() || this.Va.TU.US) {
                        bm(childCount);
                        mVar.bo(childAt);
                        this.Va.TR.E(aY);
                    } else {
                        removeViewAt(childCount);
                        mVar.n(aY);
                    }
                }
            }
        }

        final void c(m mVar) {
            int size = mVar.Vn.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((t) mVar.Vn.get(i)).VU;
                t aY = RecyclerView.aY(view);
                if (!aY.gd()) {
                    aY.V(false);
                    if (aY.gn()) {
                        this.Va.removeDetachedView(view, false);
                    }
                    if (this.Va.Ur != null) {
                        this.Va.Ur.d(aY);
                    }
                    aY.V(true);
                    mVar.bn(view);
                }
            }
            mVar.Vn.clear();
            if (mVar.Vo != null) {
                mVar.Vo.clear();
            }
            if (size > 0) {
                this.Va.invalidate();
            }
        }

        final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.Ve && n(view.getWidth(), i, layoutParams.width) && n(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        static boolean n(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size >= i) {
                        return true;
                    }
                    return false;
                case 0:
                    return true;
                case 1073741824:
                    if (size == i) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        public static int b(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = i2;
                            break;
                        default:
                            max = 0;
                            break;
                    }
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static int bf(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).RC;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public static int bg(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).RC;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public static void g(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).RC;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public static int bh(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).RC.left;
        }

        public static int bi(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).RC.top;
        }

        public static int bj(View view) {
            return ((LayoutParams) view.getLayoutParams()).RC.right + view.getRight();
        }

        public static int bk(View view) {
            return ((LayoutParams) view.getLayoutParams()).RC.bottom + view.getBottom();
        }

        public final void a(View view, Rect rect) {
            if (this.Va == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.Va.bb(view));
            }
        }

        public View a(View view, int i, m mVar, q qVar) {
            return null;
        }

        public void eM() {
        }

        public void C(int i, int i2) {
        }

        public void D(int i, int i2) {
        }

        public void E(int i, int i2) {
        }

        public void F(int i, int i2) {
        }

        public int d(q qVar) {
            return 0;
        }

        public int b(q qVar) {
            return 0;
        }

        public int f(q qVar) {
            return 0;
        }

        public int e(q qVar) {
            return 0;
        }

        public int c(q qVar) {
            return 0;
        }

        public int g(q qVar) {
            return 0;
        }

        public final void af(int i, int i2) {
            this.Va.S(i, i2);
        }

        public final void setMeasuredDimension(int i, int i2) {
            this.Va.setMeasuredDimension(i, i2);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        final void fV() {
            if (this.Vb != null) {
                this.Vb.stop();
            }
        }

        public void bp(int i) {
        }

        public final void d(m mVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.aY(getChildAt(childCount)).gd()) {
                    a(childCount, mVar);
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            m mVar = this.Va.TN;
            q qVar = this.Va.UB;
            android.support.v4.view.a.f a = android.support.v4.view.a.a.a(accessibilityEvent);
            if (this.Va != null) {
                if (!(z.h(this.Va, 1) || z.h(this.Va, -1) || z.g(this.Va, -1) || z.g(this.Va, 1))) {
                    z = false;
                }
                a.setScrollable(z);
                if (this.Va.TU != null) {
                    a.setItemCount(this.Va.TU.getItemCount());
                }
            }
        }

        final void b(View view, android.support.v4.view.a.b bVar) {
            t aY = RecyclerView.aY(view);
            if (aY != null && !aY.isRemoved() && !this.TQ.aO(aY.VU)) {
                a(this.Va.TN, this.Va.UB, view, bVar);
            }
        }

        public void a(m mVar, q qVar, View view, android.support.v4.view.a.b bVar) {
            int bd;
            int bd2 = eS() ? bd(view) : 0;
            if (eR()) {
                bd = bd(view);
            } else {
                bd = 0;
            }
            bVar.l(android.support.v4.view.a.b.l.a(bd2, 1, bd, 1, false));
        }

        public int a(m mVar, q qVar) {
            if (this.Va == null || this.Va.TU == null || !eS()) {
                return 1;
            }
            return this.Va.TU.getItemCount();
        }

        public int b(m mVar, q qVar) {
            if (this.Va == null || this.Va.TU == null || !eR()) {
                return 1;
            }
            return this.Va.TU.getItemCount();
        }

        final void z(RecyclerView recyclerView) {
            ad(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean eX() {
            return false;
        }
    }

    public final class m {
        final ArrayList<t> Vn = new ArrayList();
        ArrayList<t> Vo = null;
        final ArrayList<t> Vp = new ArrayList();
        final List<t> Vq = Collections.unmodifiableList(this.Vn);
        private int Vr = 2;
        private l Vs;
        private r Vt;

        public final void clear() {
            this.Vn.clear();
            fW();
        }

        public final int bq(int i) {
            if (i >= 0 && i < RecyclerView.this.UB.getItemCount()) {
                return !RecyclerView.this.UB.VL ? i : RecyclerView.this.TP.aP(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.UB.getItemCount());
            }
        }

        public final View br(int i) {
            boolean z = true;
            if (i < 0 || i >= RecyclerView.this.UB.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.UB.getItemCount());
            }
            t bt;
            boolean z2;
            t tVar;
            boolean z3;
            boolean z4;
            t d;
            LayoutParams layoutParams;
            if (RecyclerView.this.UB.VL) {
                bt = bt(i);
                t tVar2 = bt;
                z2 = bt != null;
                tVar = tVar2;
            } else {
                tVar = null;
                z2 = false;
            }
            if (tVar == null) {
                tVar = h(i, false);
                if (tVar != null) {
                    if (tVar.isRemoved()) {
                        z3 = RecyclerView.this.UB.VL;
                    } else if (tVar.mPosition < 0 || tVar.mPosition >= RecyclerView.this.TU.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + tVar);
                    } else {
                        z3 = (RecyclerView.this.UB.VL || RecyclerView.this.TU.getItemViewType(tVar.mPosition) == tVar.VX) ? !RecyclerView.this.TU.US || tVar.VW == RecyclerView.this.TU.getItemId(tVar.mPosition) : false;
                    }
                    if (z3) {
                        z2 = true;
                    } else {
                        tVar.addFlags(4);
                        if (tVar.gg()) {
                            RecyclerView.this.removeDetachedView(tVar.VU, false);
                            tVar.gh();
                        } else if (tVar.gi()) {
                            tVar.gj();
                        }
                        n(tVar);
                        tVar = null;
                    }
                }
            }
            if (tVar == null) {
                int aP = RecyclerView.this.TP.aP(i);
                if (aP < 0 || aP >= RecyclerView.this.TU.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + aP + ").state:" + RecyclerView.this.UB.getItemCount());
                }
                View fZ;
                ArrayList arrayList;
                int itemViewType = RecyclerView.this.TU.getItemViewType(aP);
                if (RecyclerView.this.TU.US) {
                    tVar = a(RecyclerView.this.TU.getItemId(aP), itemViewType, false);
                    if (tVar != null) {
                        tVar.mPosition = aP;
                        z3 = true;
                        if (tVar == null && this.Vt != null) {
                            fZ = this.Vt.fZ();
                            if (fZ != null) {
                                tVar = RecyclerView.this.aP(fZ);
                                if (tVar == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (tVar.gd()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (tVar == null) {
                            arrayList = (ArrayList) fX().Vk.get(itemViewType);
                            if (arrayList != null || arrayList.isEmpty()) {
                                bt = null;
                            } else {
                                int size = arrayList.size() - 1;
                                bt = (t) arrayList.get(size);
                                arrayList.remove(size);
                            }
                            if (bt != null) {
                                bt.gq();
                                if (RecyclerView.TJ && (bt.VU instanceof ViewGroup)) {
                                    c((ViewGroup) bt.VU, false);
                                }
                            }
                            tVar = bt;
                        }
                        if (tVar != null) {
                            z4 = z3;
                            d = RecyclerView.this.TU.d(RecyclerView.this, itemViewType);
                        } else {
                            z4 = z3;
                            d = tVar;
                        }
                    }
                }
                z3 = z2;
                fZ = this.Vt.fZ();
                if (fZ != null) {
                    tVar = RecyclerView.this.aP(fZ);
                    if (tVar == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    } else if (tVar.gd()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (tVar == null) {
                    arrayList = (ArrayList) fX().Vk.get(itemViewType);
                    if (arrayList != null) {
                    }
                    bt = null;
                    if (bt != null) {
                        bt.gq();
                        c((ViewGroup) bt.VU, false);
                    }
                    tVar = bt;
                }
                if (tVar != null) {
                    z4 = z3;
                    d = tVar;
                } else {
                    z4 = z3;
                    d = RecyclerView.this.TU.d(RecyclerView.this, itemViewType);
                }
            } else {
                d = tVar;
                z4 = z2;
            }
            if (z4 && !RecyclerView.this.UB.VL && d.bv(8192)) {
                d.setFlags(0, 8192);
                if (RecyclerView.this.UB.VM) {
                    RecyclerView.this.a(d, RecyclerView.this.Ur.a(RecyclerView.this.UB, d, e.j(d) | Downloads.RECV_BUFFER_SIZE, d.gp()));
                }
            }
            if (RecyclerView.this.UB.VL && d.isBound()) {
                d.VY = i;
                z2 = false;
            } else if (!d.isBound() || d.gm() || d.gl()) {
                int aP2 = RecyclerView.this.TP.aP(i);
                d.Wi = RecyclerView.this;
                a h = RecyclerView.this.TU;
                d.mPosition = aP2;
                if (h.US) {
                    d.VW = h.getItemId(aP2);
                }
                d.setFlags(1, 519);
                android.support.v4.os.e.beginSection("RV OnBindView");
                h.a(d, aP2, d.gp());
                d.go();
                android.support.v4.os.e.endSection();
                View view = d.VU;
                if (RecyclerView.this.fB()) {
                    if (z.F(view) == 0) {
                        z.i(view, 1);
                    }
                    if (!z.C(view)) {
                        z.a(view, RecyclerView.this.UI.Wj);
                    }
                }
                if (RecyclerView.this.UB.VL) {
                    d.VY = i;
                }
                z2 = true;
            } else {
                z2 = false;
            }
            android.view.ViewGroup.LayoutParams layoutParams2 = d.VU.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                d.VU.setLayoutParams(layoutParams);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                d.VU.setLayoutParams(layoutParams);
            }
            layoutParams.Vh = d;
            if (!(z4 && r1)) {
                z = false;
            }
            layoutParams.Vj = z;
            return d.VU;
        }

        private void c(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public final void bm(View view) {
            t aY = RecyclerView.aY(view);
            if (aY.gn()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (aY.gg()) {
                aY.gh();
            } else if (aY.gi()) {
                aY.gj();
            }
            n(aY);
        }

        final void fW() {
            for (int size = this.Vp.size() - 1; size >= 0; size--) {
                bs(size);
            }
            this.Vp.clear();
        }

        final void bs(int i) {
            o((t) this.Vp.get(i));
            this.Vp.remove(i);
        }

        final void n(t tVar) {
            boolean z = true;
            int i = 0;
            if (tVar.gg() || tVar.VU.getParent() != null) {
                StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(tVar.gg()).append(" isAttached:");
                if (tVar.VU.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (tVar.gn()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + tVar);
            } else if (tVar.gd()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                boolean s = t.s(tVar);
                if (RecyclerView.this.TU != null && s) {
                    RecyclerView.this.TU;
                }
                if (tVar.gr()) {
                    boolean z2;
                    if (!tVar.bv(14)) {
                        int size = this.Vp.size();
                        if (size == this.Vr && size > 0) {
                            bs(0);
                        }
                        if (size < this.Vr) {
                            this.Vp.add(tVar);
                            z2 = true;
                            if (z2) {
                                o(tVar);
                                i = 1;
                                z = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        o(tVar);
                        i = 1;
                        z = z2;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.TR.F(tVar);
                if (!z && i == 0 && s) {
                    tVar.Wi = null;
                }
            }
        }

        private void o(t tVar) {
            z.a(tVar.VU, null);
            if (RecyclerView.this.TW != null) {
                RecyclerView.this.TW;
            }
            if (RecyclerView.this.TU != null) {
                RecyclerView.this.TU.a(tVar);
            }
            if (RecyclerView.this.UB != null) {
                RecyclerView.this.TR.F(tVar);
            }
            tVar.Wi = null;
            l fX = fX();
            int i = tVar.VX;
            ArrayList arrayList = (ArrayList) fX.Vk.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                fX.Vk.put(i, arrayList);
                if (fX.Vl.indexOfKey(i) < 0) {
                    fX.Vl.put(i, 5);
                }
            }
            if (fX.Vl.get(i) > arrayList.size()) {
                tVar.gq();
                arrayList.add(tVar);
            }
        }

        final void bn(View view) {
            t aY = RecyclerView.aY(view);
            aY.Wf = null;
            aY.Wg = false;
            aY.gj();
            n(aY);
        }

        final void bo(View view) {
            t aY = RecyclerView.aY(view);
            if (!aY.bv(12) && aY.gs() && !RecyclerView.a(RecyclerView.this, aY)) {
                if (this.Vo == null) {
                    this.Vo = new ArrayList();
                }
                aY.a(this, true);
                this.Vo.add(aY);
            } else if (!aY.gl() || aY.isRemoved() || RecyclerView.this.TU.US) {
                aY.a(this, false);
                this.Vn.add(aY);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        final void p(t tVar) {
            if (tVar.Wg) {
                this.Vo.remove(tVar);
            } else {
                this.Vn.remove(tVar);
            }
            tVar.Wf = null;
            tVar.Wg = false;
            tVar.gj();
        }

        private t bt(int i) {
            int i2 = 0;
            if (this.Vo != null) {
                int size = this.Vo.size();
                if (size != 0) {
                    t tVar;
                    int i3 = 0;
                    while (i3 < size) {
                        tVar = (t) this.Vo.get(i3);
                        if (tVar.gi() || tVar.ge() != i) {
                            i3++;
                        } else {
                            tVar.addFlags(32);
                            return tVar;
                        }
                    }
                    if (RecyclerView.this.TU.US) {
                        int w = RecyclerView.this.TP.w(i, 0);
                        if (w > 0 && w < RecyclerView.this.TU.getItemCount()) {
                            long itemId = RecyclerView.this.TU.getItemId(w);
                            while (i2 < size) {
                                tVar = (t) this.Vo.get(i2);
                                if (tVar.gi() || tVar.VW != itemId) {
                                    i2++;
                                } else {
                                    tVar.addFlags(32);
                                    return tVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private t h(int i, boolean z) {
            t tVar;
            View view;
            int i2 = 0;
            int size = this.Vn.size();
            int i3 = 0;
            while (i3 < size) {
                tVar = (t) this.Vn.get(i3);
                if (tVar.gi() || tVar.ge() != i || tVar.gl() || (!RecyclerView.this.UB.VL && tVar.isRemoved())) {
                    i3++;
                } else {
                    tVar.addFlags(32);
                    return tVar;
                }
            }
            s sVar = RecyclerView.this.TQ;
            int size2 = sVar.QD.size();
            for (i3 = 0; i3 < size2; i3++) {
                View view2 = (View) sVar.QD.get(i3);
                t aP = sVar.QB.aP(view2);
                if (aP.ge() == i && !aP.gl() && !aP.isRemoved()) {
                    view = view2;
                    break;
                }
            }
            view = null;
            if (view != null) {
                tVar = RecyclerView.aY(view);
                s sVar2 = RecyclerView.this.TQ;
                i2 = sVar2.QB.indexOfChild(view);
                if (i2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                } else if (sVar2.QC.get(i2)) {
                    sVar2.QC.clear(i2);
                    sVar2.aN(view);
                    int indexOfChild = RecyclerView.this.TQ.indexOfChild(view);
                    if (indexOfChild == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + tVar);
                    }
                    RecyclerView.this.TQ.detachViewFromParent(indexOfChild);
                    bo(view);
                    tVar.addFlags(8224);
                    return tVar;
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                }
            }
            i3 = this.Vp.size();
            while (i2 < i3) {
                tVar = (t) this.Vp.get(i2);
                if (tVar.gl() || tVar.ge() != i) {
                    i2++;
                } else {
                    this.Vp.remove(i2);
                    return tVar;
                }
            }
            return null;
        }

        private t a(long j, int i, boolean z) {
            int size;
            t tVar;
            for (size = this.Vn.size() - 1; size >= 0; size--) {
                tVar = (t) this.Vn.get(size);
                if (tVar.VW == j && !tVar.gi()) {
                    if (i == tVar.VX) {
                        tVar.addFlags(32);
                        if (!tVar.isRemoved() || RecyclerView.this.UB.VL) {
                            return tVar;
                        }
                        tVar.setFlags(2, 14);
                        return tVar;
                    }
                    this.Vn.remove(size);
                    RecyclerView.this.removeDetachedView(tVar.VU, false);
                    bn(tVar.VU);
                }
            }
            for (size = this.Vp.size() - 1; size >= 0; size--) {
                tVar = (t) this.Vp.get(size);
                if (tVar.VW == j) {
                    if (i == tVar.VX) {
                        this.Vp.remove(size);
                        return tVar;
                    }
                    bs(size);
                }
            }
            return null;
        }

        final l fX() {
            if (this.Vs == null) {
                this.Vs = new l();
            }
            return this.Vs;
        }
    }

    private class o extends c {
        private o() {
        }

        /* synthetic */ o(RecyclerView recyclerView, byte b) {
            this();
        }

        public final void onChanged() {
            RecyclerView.this.w(null);
            boolean z = RecyclerView.this.TU.US;
            RecyclerView.this.UB.VK = true;
            RecyclerView.n(RecyclerView.this);
            if (!RecyclerView.this.TP.eu()) {
                RecyclerView.this.requestLayout();
            }
        }

        public final void c(int i, int i2, Object obj) {
            Object obj2 = 1;
            RecyclerView.this.w(null);
            e eVar = RecyclerView.this.TP;
            eVar.OS.add(eVar.a(4, i, i2, obj));
            eVar.OY |= 4;
            if (eVar.OS.size() != 1) {
                obj2 = null;
            }
            if (obj2 != null) {
                fY();
            }
        }

        public final void Z(int i, int i2) {
            int i3 = 1;
            RecyclerView.this.w(null);
            e eVar = RecyclerView.this.TP;
            eVar.OS.add(eVar.a(1, i, i2, null));
            eVar.OY |= 1;
            if (eVar.OS.size() != 1) {
                i3 = 0;
            }
            if (i3 != 0) {
                fY();
            }
        }

        public final void aa(int i, int i2) {
            Object obj = 1;
            RecyclerView.this.w(null);
            e eVar = RecyclerView.this.TP;
            eVar.OS.add(eVar.a(2, i, i2, null));
            eVar.OY |= 2;
            if (eVar.OS.size() != 1) {
                obj = null;
            }
            if (obj != null) {
                fY();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ab(int r6, int r7) {
            /*
            r5 = this;
            r4 = 0;
            r0 = 1;
            r1 = android.support.v7.widget.RecyclerView.this;
            r1.w(r4);
            r1 = android.support.v7.widget.RecyclerView.this;
            r1 = r1.TP;
            if (r6 == r7) goto L_0x002c;
        L_0x000d:
            r2 = r1.OS;
            r3 = 8;
            r3 = r1.a(r3, r6, r7, r4);
            r2.add(r3);
            r2 = r1.OY;
            r2 = r2 | 8;
            r1.OY = r2;
            r1 = r1.OS;
            r1 = r1.size();
            if (r1 != r0) goto L_0x002c;
        L_0x0026:
            if (r0 == 0) goto L_0x002b;
        L_0x0028:
            r5.fY();
        L_0x002b:
            return;
        L_0x002c:
            r0 = 0;
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.o.ab(int, int):void");
        }

        private void fY() {
            if (RecyclerView.this.Uj && RecyclerView.this.Ub && RecyclerView.this.Ua) {
                z.a(RecyclerView.this, RecyclerView.this.TT);
                return;
            }
            RecyclerView.this.Ui = true;
            RecyclerView.this.requestLayout();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        recyclerView.f(tVar);
        tVar.V(false);
        if (recyclerView.Ur.d(tVar, cVar, cVar2)) {
            recyclerView.fD();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        aY(view);
        if (recyclerView.Uk != null) {
            for (int size = recyclerView.Uk.size() - 1; size >= 0; size--) {
                recyclerView.Uk.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, t tVar) {
        return recyclerView.Ur == null || recyclerView.Ur.a(tVar, tVar.gp());
    }

    static /* synthetic */ void b(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        tVar.V(false);
        if (recyclerView.Ur.e(tVar, cVar, cVar2)) {
            recyclerView.fD();
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.fp();
        s sVar = recyclerView.TQ;
        int indexOfChild = sVar.QB.indexOfChild(view);
        if (indexOfChild == -1) {
            sVar.aN(view);
            z = true;
        } else if (sVar.QC.get(indexOfChild)) {
            sVar.QC.aV(indexOfChild);
            sVar.aN(view);
            sVar.QB.removeViewAt(indexOfChild);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            t aY = aY(view);
            recyclerView.TN.p(aY);
            recyclerView.TN.n(aY);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.S(z2);
        return z;
    }

    static /* synthetic */ void d(RecyclerView recyclerView, int i) {
        if (recyclerView.TV != null) {
            recyclerView.TV.be(i);
            recyclerView.awakenScrollBars();
        }
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.Ul) {
            int i;
            recyclerView.Ul = true;
            int eG = recyclerView.TQ.eG();
            for (i = 0; i < eG; i++) {
                t aY = aY(recyclerView.TQ.aU(i));
                if (!(aY == null || aY.gd())) {
                    aY.addFlags(WXMediaMessage.TITLE_LENGTH_LIMIT);
                }
            }
            m mVar = recyclerView.TN;
            int size = mVar.Vp.size();
            for (i = 0; i < size; i++) {
                t tVar = (t) mVar.Vp.get(i);
                if (tVar != null) {
                    tVar.addFlags(WXMediaMessage.TITLE_LENGTH_LIMIT);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        TJ = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        TK = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.TM = new o();
        this.TN = new m();
        this.TR = new as();
        this.TT = new Runnable() {
            public final void run() {
                if (RecyclerView.this.Uc && !RecyclerView.this.isLayoutRequested()) {
                    if (RecyclerView.this.Uf) {
                        RecyclerView.this.Ue = true;
                    } else {
                        RecyclerView.this.fo();
                    }
                }
            }
        };
        this.ey = new Rect();
        this.TX = new ArrayList();
        this.TY = new ArrayList();
        this.Ud = 0;
        this.Ul = false;
        this.Um = 0;
        this.Ur = new v();
        this.yi = 0;
        this.Us = -1;
        this.Uz = Float.MIN_VALUE;
        this.UA = new s();
        this.UB = new q();
        this.UE = false;
        this.UF = false;
        this.UG = new f();
        this.UH = false;
        this.UK = new int[2];
        this.Do = new int[2];
        this.Dp = new int[2];
        this.UM = new int[2];
        this.UN = new Runnable() {
            public final void run() {
                if (RecyclerView.this.Ur != null) {
                    RecyclerView.this.Ur.eJ();
                }
                RecyclerView.this.UH = false;
            }
        };
        this.UP = new b() {
            public final void a(t tVar, c cVar, c cVar2) {
                RecyclerView.this.TN.p(tVar);
                RecyclerView.a(RecyclerView.this, tVar, cVar, cVar2);
            }

            public final void b(t tVar, c cVar, c cVar2) {
                RecyclerView.b(RecyclerView.this, tVar, cVar, cVar2);
            }

            public final void c(t tVar, c cVar, c cVar2) {
                tVar.V(false);
                if (RecyclerView.this.Ul) {
                    if (RecyclerView.this.Ur.a(tVar, tVar, cVar, cVar2)) {
                        RecyclerView.this.fD();
                    }
                } else if (RecyclerView.this.Ur.f(tVar, cVar, cVar2)) {
                    RecyclerView.this.fD();
                }
            }

            public final void i(t tVar) {
                RecyclerView.this.TV.a(tVar.VU, RecyclerView.this.TN);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.Uj = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iN = viewConfiguration.getScaledTouchSlop();
        this.Ux = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Uy = viewConfiguration.getScaledMaximumFlingVelocity();
        if (z.B(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.Ur.UT = this.UG;
        this.TP = new e(new a() {
            public final t aQ(int i) {
                t aY;
                RecyclerView recyclerView = RecyclerView.this;
                int eG = recyclerView.TQ.eG();
                for (int i2 = 0; i2 < eG; i2++) {
                    aY = RecyclerView.aY(recyclerView.TQ.aU(i2));
                    if (aY != null && !aY.isRemoved() && aY.mPosition == i) {
                        break;
                    }
                }
                aY = null;
                if (aY == null || RecyclerView.this.TQ.aO(aY.VU)) {
                    return null;
                }
                return aY;
            }

            public final void x(int i, int i2) {
                RecyclerView.this.c(i, i2, true);
                RecyclerView.this.UE = true;
                q qVar = RecyclerView.this.UB;
                qVar.VJ += i2;
            }

            public final void y(int i, int i2) {
                RecyclerView.this.c(i, i2, false);
                RecyclerView.this.UE = true;
            }

            public final void a(int i, int i2, Object obj) {
                int i3;
                RecyclerView recyclerView = RecyclerView.this;
                int eG = recyclerView.TQ.eG();
                int i4 = i + i2;
                for (i3 = 0; i3 < eG; i3++) {
                    View aU = recyclerView.TQ.aU(i3);
                    t aY = RecyclerView.aY(aU);
                    if (aY != null && !aY.gd() && aY.mPosition >= i && aY.mPosition < i4) {
                        aY.addFlags(2);
                        aY.S(obj);
                        ((LayoutParams) aU.getLayoutParams()).Vi = true;
                    }
                }
                m mVar = recyclerView.TN;
                eG = i + i2;
                for (i3 = mVar.Vp.size() - 1; i3 >= 0; i3--) {
                    t tVar = (t) mVar.Vp.get(i3);
                    if (tVar != null) {
                        i4 = tVar.ge();
                        if (i4 >= i && i4 < eG) {
                            tVar.addFlags(2);
                            mVar.bs(i3);
                        }
                    }
                }
                RecyclerView.this.UF = true;
            }

            public final void d(b bVar) {
                f(bVar);
            }

            private void f(b bVar) {
                switch (bVar.pK) {
                    case 1:
                        RecyclerView.this.TV.C(bVar.OZ, bVar.Pb);
                        return;
                    case 2:
                        RecyclerView.this.TV.D(bVar.OZ, bVar.Pb);
                        return;
                    case 4:
                        RecyclerView.this.TV.E(bVar.OZ, bVar.Pb);
                        return;
                    case 8:
                        RecyclerView.this.TV.F(bVar.OZ, bVar.Pb);
                        return;
                    default:
                        return;
                }
            }

            public final void e(b bVar) {
                f(bVar);
            }

            public final void z(int i, int i2) {
                int i3;
                RecyclerView recyclerView = RecyclerView.this;
                int eG = recyclerView.TQ.eG();
                for (i3 = 0; i3 < eG; i3++) {
                    t aY = RecyclerView.aY(recyclerView.TQ.aU(i3));
                    if (!(aY == null || aY.gd() || aY.mPosition < i)) {
                        aY.i(i2, false);
                        recyclerView.UB.VK = true;
                    }
                }
                m mVar = recyclerView.TN;
                int size = mVar.Vp.size();
                for (i3 = 0; i3 < size; i3++) {
                    t tVar = (t) mVar.Vp.get(i3);
                    if (tVar != null && tVar.mPosition >= i) {
                        tVar.i(i2, true);
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.UE = true;
            }

            public final void A(int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7 = -1;
                RecyclerView recyclerView = RecyclerView.this;
                int eG = recyclerView.TQ.eG();
                if (i < i2) {
                    i3 = -1;
                    i4 = i2;
                    i5 = i;
                } else {
                    i3 = 1;
                    i4 = i;
                    i5 = i2;
                }
                for (i6 = 0; i6 < eG; i6++) {
                    t aY = RecyclerView.aY(recyclerView.TQ.aU(i6));
                    if (aY != null && aY.mPosition >= i5 && aY.mPosition <= i4) {
                        if (aY.mPosition == i) {
                            aY.i(i2 - i, false);
                        } else {
                            aY.i(i3, false);
                        }
                        recyclerView.UB.VK = true;
                    }
                }
                m mVar = recyclerView.TN;
                if (i < i2) {
                    i4 = i2;
                    i5 = i;
                } else {
                    i7 = 1;
                    i4 = i;
                    i5 = i2;
                }
                int size = mVar.Vp.size();
                for (i6 = 0; i6 < size; i6++) {
                    t tVar = (t) mVar.Vp.get(i6);
                    if (tVar != null && tVar.mPosition >= r4 && tVar.mPosition <= r3) {
                        if (tVar.mPosition == i) {
                            tVar.i(i2 - i, false);
                        } else {
                            tVar.i(i7, false);
                        }
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.UE = true;
            }
        });
        this.TQ = new s(new b() {
            public final int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public final void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.a(RecyclerView.this, view);
            }

            public final int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public final void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.bc(childAt);
                }
                RecyclerView.this.removeViewAt(i);
            }

            public final View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public final void removeAllViews() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    RecyclerView.this.bc(getChildAt(i));
                }
                RecyclerView.this.removeAllViews();
            }

            public final t aP(View view) {
                return RecyclerView.aY(view);
            }

            public final void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
                t aY = RecyclerView.aY(view);
                if (aY != null) {
                    if (aY.gn() || aY.gd()) {
                        aY.gk();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + aY);
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public final void detachViewFromParent(int i) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    t aY = RecyclerView.aY(childAt);
                    if (aY != null) {
                        if (!aY.gn() || aY.gd()) {
                            aY.addFlags(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + aY);
                        }
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public final void aQ(View view) {
                t aY = RecyclerView.aY(view);
                if (aY != null) {
                    t.q(aY);
                }
            }

            public final void aR(View view) {
                t aY = RecyclerView.aY(view);
                if (aY != null) {
                    t.r(aY);
                }
            }
        });
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        this.ju = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.UI = new ac(this);
        z.a((View) this, this.UI);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.c.da, i, 0);
            String string = obtainStyledAttributes.getString(android.support.v7.d.a.c.Js);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    string = trim.charAt(0) == '.' ? context.getPackageName() + trim : trim.contains(".") ? trim : RecyclerView.class.getPackage().getName() + '.' + trim;
                    try {
                        Object[] objArr;
                        Constructor constructor;
                        Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(string).asSubclass(h.class);
                        try {
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                            constructor = asSubclass.getConstructor(TL);
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        a((h) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string, e32222);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TI, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public void setClipToPadding(boolean z) {
        if (z != this.TS) {
            fw();
        }
        this.TS = z;
        super.setClipToPadding(z);
        if (this.Uc) {
            requestLayout();
        }
    }

    public void a(a aVar) {
        T(false);
        if (this.TU != null) {
            this.TU.b(this.TM);
        }
        if (this.Ur != null) {
            this.Ur.eL();
        }
        if (this.TV != null) {
            this.TV.d(this.TN);
            this.TV.c(this.TN);
        }
        this.TN.clear();
        this.TP.reset();
        a aVar2 = this.TU;
        this.TU = aVar;
        if (aVar != null) {
            aVar.a(this.TM);
        }
        m mVar = this.TN;
        a aVar3 = this.TU;
        mVar.clear();
        l fX = mVar.fX();
        if (aVar2 != null) {
            fX.Vm--;
        }
        if (fX.Vm == 0) {
            fX.Vk.clear();
        }
        if (aVar3 != null) {
            fX.Vm++;
        }
        this.UB.VK = true;
        fL();
        requestLayout();
    }

    public a fn() {
        return this.TU;
    }

    public int getBaseline() {
        if (this.TV != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void a(h hVar) {
        if (hVar != this.TV) {
            fq();
            if (this.TV != null) {
                if (this.Ua) {
                    this.TV.b(this, this.TN);
                }
                this.TV.y(null);
            }
            this.TN.clear();
            s sVar = this.TQ;
            a aVar = sVar.QC;
            while (true) {
                aVar.QE = 0;
                if (aVar.QF == null) {
                    break;
                }
                aVar = aVar.QF;
            }
            for (int size = sVar.QD.size() - 1; size >= 0; size--) {
                sVar.QB.aR((View) sVar.QD.get(size));
                sVar.QD.remove(size);
            }
            sVar.QB.removeAllViews();
            this.TV = hVar;
            if (hVar != null) {
                if (hVar.Va != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.Va);
                }
                this.TV.y(this);
                if (this.Ua) {
                    this.TV.hq = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.TO != null) {
            savedState.Vu = this.TO.Vu;
        } else if (this.TV != null) {
            savedState.Vu = this.TV.onSaveInstanceState();
        } else {
            savedState.Vu = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.TO = (SavedState) parcelable;
            super.onRestoreInstanceState(this.TO.getSuperState());
            if (this.TV != null && this.TO.Vu != null) {
                this.TV.onRestoreInstanceState(this.TO.Vu);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void f(t tVar) {
        View view = tVar.VU;
        boolean z = view.getParent() == this;
        this.TN.p(aP(view));
        if (tVar.gn()) {
            this.TQ.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            s sVar = this.TQ;
            int indexOfChild = sVar.QB.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            sVar.QC.set(indexOfChild);
            sVar.aM(view);
        } else {
            this.TQ.a(view, -1, true);
        }
    }

    private void ag(int i) {
        if (i != this.yi) {
            this.yi = i;
            if (i != 2) {
                fr();
            }
            if (this.TV != null) {
                this.TV.bp(i);
            }
            if (this.UC != null) {
                this.UC.e(this, i);
            }
            if (this.UD != null) {
                for (int size = this.UD.size() - 1; size >= 0; size--) {
                    ((k) this.UD.get(size)).e(this, i);
                }
            }
        }
    }

    public final void a(g gVar) {
        if (this.TV != null) {
            this.TV.w("Cannot add item decoration during a scroll  or layout");
        }
        if (this.TX.isEmpty()) {
            setWillNotDraw(false);
        }
        this.TX.add(gVar);
        fJ();
        requestLayout();
    }

    public final void a(d dVar) {
        if (dVar != this.UJ) {
            this.UJ = dVar;
            setChildrenDrawingOrderEnabled(this.UJ != null);
        }
    }

    public final void a(k kVar) {
        if (this.UD == null) {
            this.UD = new ArrayList();
        }
        this.UD.add(kVar);
    }

    public void be(int i) {
        if (!this.Uf) {
            fq();
            if (this.TV != null) {
                this.TV.be(i);
                awakenScrollBars();
            }
        }
    }

    public final void smoothScrollToPosition(int i) {
        if (!this.Uf && this.TV != null) {
            this.TV.a(this, i);
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.TV != null && !this.Uf) {
            boolean eR = this.TV.eR();
            boolean eS = this.TV.eS();
            if (eR || eS) {
                if (!eR) {
                    i = 0;
                }
                if (!eS) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void fo() {
        boolean z = false;
        if (!this.Uc) {
            return;
        }
        if (this.Ul) {
            android.support.v4.os.e.beginSection("RV FullInvalidate");
            fG();
            android.support.v4.os.e.endSection();
        } else if (!this.TP.eu()) {
        } else {
            if (this.TP.aO(4) && !this.TP.aO(11)) {
                android.support.v4.os.e.beginSection("RV PartialInvalidate");
                fp();
                this.TP.es();
                if (!this.Ue) {
                    int childCount = this.TQ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        t aY = aY(this.TQ.getChildAt(i));
                        if (aY != null && !aY.gd() && aY.gs()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        fG();
                    } else {
                        this.TP.et();
                    }
                }
                S(true);
                android.support.v4.os.e.endSection();
            } else if (this.TP.eu()) {
                android.support.v4.os.e.beginSection("RV FullInvalidate");
                fG();
                android.support.v4.os.e.endSection();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        fo();
        if (this.TU != null) {
            fp();
            fz();
            android.support.v4.os.e.beginSection("RV Scroll");
            if (i != 0) {
                i5 = this.TV.a(i, this.TN, this.UB);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.TV.b(i2, this.TN, this.UB);
                i4 = i2 - i6;
            }
            android.support.v4.os.e.endSection();
            fM();
            fA();
            S(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.TX.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.Do)) {
            this.Uv -= this.Do[0];
            this.Uw -= this.Do[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.Do[0], (float) this.Do[1]);
            }
            int[] iArr = this.UM;
            iArr[0] = iArr[0] + this.Do[0];
            iArr = this.UM;
            iArr[1] = iArr[1] + this.Do[1];
        } else if (z.B(this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    fs();
                    if (this.Un.h((-f) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    ft();
                    if (this.Up.h(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    fu();
                    if (this.Uo.h((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    fv();
                    if (this.Uq.h(f2 / ((float) getHeight()), 1.0f - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    z.E(this);
                }
            }
            R(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            T(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.TV != null && this.TV.eR()) {
            return this.TV.b(this.UB);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.TV != null && this.TV.eR()) {
            return this.TV.d(this.UB);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.TV != null && this.TV.eR()) {
            return this.TV.f(this.UB);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.TV != null && this.TV.eS()) {
            return this.TV.c(this.UB);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.TV != null && this.TV.eS()) {
            return this.TV.e(this.UB);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.TV != null && this.TV.eS()) {
            return this.TV.g(this.UB);
        }
        return 0;
    }

    final void fp() {
        this.Ud++;
        if (this.Ud == 1 && !this.Uf) {
            this.Ue = false;
        }
    }

    final void S(boolean z) {
        if (this.Ud <= 0) {
            this.Ud = 1;
        }
        if (!z) {
            this.Ue = false;
        }
        if (this.Ud == 1) {
            if (!(!z || !this.Ue || this.Uf || this.TV == null || this.TU == null)) {
                fG();
            }
            if (!this.Uf) {
                this.Ue = false;
            }
        }
        this.Ud--;
    }

    public final void T(boolean z) {
        if (z != this.Uf) {
            w("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.Uf = true;
                this.Ug = true;
                fq();
                return;
            }
            this.Uf = false;
            if (!(!this.Ue || this.TV == null || this.TU == null)) {
                requestLayout();
            }
            this.Ue = false;
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        int i3 = 0;
        if (this.TV != null && !this.Uf) {
            if (!this.TV.eR()) {
                i = 0;
            }
            if (this.TV.eS()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.UA.smoothScrollBy(i, i3);
            }
        }
    }

    public boolean Q(int i, int i2) {
        if (this.TV == null || this.Uf) {
            return false;
        }
        boolean eR = this.TV.eR();
        boolean eS = this.TV.eS();
        if (!eR || Math.abs(i) < this.Ux) {
            i = 0;
        }
        if (!eS || Math.abs(i2) < this.Ux) {
            i2 = 0;
        }
        if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
            return false;
        }
        eR = eR || eS;
        dispatchNestedFling((float) i, (float) i2, eR);
        if (!eR) {
            return false;
        }
        int max = Math.max(-this.Uy, Math.min(i, this.Uy));
        int max2 = Math.max(-this.Uy, Math.min(i2, this.Uy));
        s sVar = this.UA;
        sVar.UQ.ag(2);
        sVar.VR = 0;
        sVar.VQ = 0;
        sVar.iK.b(0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        sVar.ga();
        return true;
    }

    private void fq() {
        ag(0);
        fr();
    }

    private void fr() {
        this.UA.stop();
        if (this.TV != null) {
            this.TV.fV();
        }
    }

    private void R(int i, int i2) {
        int i3 = 0;
        if (!(this.Un == null || this.Un.isFinished() || i <= 0)) {
            i3 = this.Un.cw();
        }
        if (!(this.Up == null || this.Up.isFinished() || i >= 0)) {
            i3 |= this.Up.cw();
        }
        if (!(this.Uo == null || this.Uo.isFinished() || i2 <= 0)) {
            i3 |= this.Uo.cw();
        }
        if (!(this.Uq == null || this.Uq.isFinished() || i2 >= 0)) {
            i3 |= this.Uq.cw();
        }
        if (i3 != 0) {
            z.E(this);
        }
    }

    final void fs() {
        if (this.Un == null) {
            this.Un = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Un.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Un.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void ft() {
        if (this.Up == null) {
            this.Up = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Up.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Up.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fu() {
        if (this.Uo == null) {
            this.Uo = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Uo.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Uo.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void fv() {
        if (this.Uq == null) {
            this.Uq = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Uq.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Uq.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void fw() {
        this.Uq = null;
        this.Uo = null;
        this.Up = null;
        this.Un = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.TU == null || this.TV == null || fC() || this.Uf)) {
            fp();
            findNextFocus = this.TV.a(view, i, this.TN, this.UB);
            S(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    public void requestChildFocus(View view, View view2) {
        int i = (this.TV.fU() || fC()) ? 1 : 0;
        if (i == 0 && view2 != null) {
            this.ey.set(0, 0, view2.getWidth(), view2.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.Vi) {
                    Rect rect = layoutParams2.RC;
                    Rect rect2 = this.ey;
                    rect2.left -= rect.left;
                    rect2 = this.ey;
                    rect2.right += rect.right;
                    rect2 = this.ey;
                    rect2.top -= rect.top;
                    rect2 = this.ey;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.ey);
            offsetRectIntoDescendantCoords(view, this.ey);
            requestChildRectangleOnScreen(view, this.ey, !this.Uc);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        h hVar = this.TV;
        int paddingLeft = hVar.getPaddingLeft();
        int paddingTop = hVar.getPaddingTop();
        int paddingRight = hVar.mWidth - hVar.getPaddingRight();
        int paddingBottom = hVar.mHeight - hVar.getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - paddingLeft);
        int min2 = Math.min(0, top - paddingTop);
        int max = Math.max(0, width - paddingRight);
        paddingBottom = Math.max(0, height - paddingBottom);
        if (z.I(hVar.Va) == 1) {
            if (max == 0) {
                max = Math.max(min, width - paddingRight);
            }
            min = max;
        } else {
            min = min != 0 ? min : Math.min(left - paddingLeft, max);
        }
        max = min2 != 0 ? min2 : Math.min(top - paddingTop, paddingBottom);
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            scrollBy(min, max);
        } else {
            smoothScrollBy(min, max);
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Um = 0;
        this.Ua = true;
        this.Uc = false;
        if (this.TV != null) {
            this.TV.hq = true;
        }
        this.UH = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Ur != null) {
            this.Ur.eL();
        }
        this.Uc = false;
        fq();
        this.Ua = false;
        if (this.TV != null) {
            this.TV.b(this, this.TN);
        }
        removeCallbacks(this.UN);
        a.hf();
    }

    public boolean isAttachedToWindow() {
        return this.Ua;
    }

    final void w(String str) {
        if (!fC()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.Uf) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.TZ = null;
        }
        int size = this.TY.size();
        for (i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.TY.get(i2);
            if (jVar.n(motionEvent) && action != 3) {
                this.TZ = jVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            fy();
            return true;
        } else if (this.TV == null) {
            return false;
        } else {
            z = this.TV.eR();
            boolean eS = this.TV.eS();
            if (this.ft == null) {
                this.ft = VelocityTracker.obtain();
            }
            this.ft.addMovement(motionEvent);
            action = android.support.v4.view.o.d(motionEvent);
            size = android.support.v4.view.o.e(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.Ug) {
                        this.Ug = false;
                    }
                    this.Us = android.support.v4.view.o.c(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.Uv = i;
                    this.Ut = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.Uw = i;
                    this.Uu = i;
                    if (this.yi == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        ag(1);
                    }
                    int[] iArr = this.UM;
                    this.UM[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (eS) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.ft.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = android.support.v4.view.o.b(motionEvent, this.Us);
                    if (action >= 0) {
                        size = (int) (android.support.v4.view.o.d(motionEvent, action) + 0.5f);
                        action = (int) (android.support.v4.view.o.e(motionEvent, action) + 0.5f);
                        if (this.yi != 1) {
                            size -= this.Ut;
                            action -= this.Uu;
                            if (!z || Math.abs(size) <= this.iN) {
                                z = false;
                            } else {
                                this.Uv = ((size < 0 ? -1 : 1) * this.iN) + this.Ut;
                                z = true;
                            }
                            if (eS && Math.abs(action) > this.iN) {
                                i3 = this.Uu;
                                i2 = this.iN;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.Uw = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                ag(1);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.Us).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fy();
                    break;
                case 5:
                    this.Us = android.support.v4.view.o.c(motionEvent, size);
                    i3 = (int) (android.support.v4.view.o.d(motionEvent, size) + 0.5f);
                    this.Uv = i3;
                    this.Ut = i3;
                    i3 = (int) (android.support.v4.view.o.e(motionEvent, size) + 0.5f);
                    this.Uw = i3;
                    this.Uu = i3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (this.yi != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.TY.size();
        for (int i = 0; i < size; i++) {
            ((j) this.TY.get(i)).U(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Uf || this.Ug) {
            return false;
        }
        boolean z2;
        boolean eR;
        boolean eS;
        MotionEvent obtain;
        int e;
        int[] iArr;
        float f;
        float f2;
        int d;
        int e2;
        int i;
        int[] iArr2;
        boolean z3;
        int action = motionEvent.getAction();
        if (this.TZ != null) {
            if (action == 0) {
                this.TZ = null;
            } else {
                this.TZ.o(motionEvent);
                if (action == 3 || action == 1) {
                    this.TZ = null;
                }
                z2 = true;
                if (z2) {
                    fy();
                    return true;
                } else if (this.TV != null) {
                    return false;
                } else {
                    eR = this.TV.eR();
                    eS = this.TV.eS();
                    if (this.ft == null) {
                        this.ft = VelocityTracker.obtain();
                    }
                    obtain = MotionEvent.obtain(motionEvent);
                    action = android.support.v4.view.o.d(motionEvent);
                    e = android.support.v4.view.o.e(motionEvent);
                    if (action == 0) {
                        iArr = this.UM;
                        this.UM[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.UM[0], (float) this.UM[1]);
                    switch (action) {
                        case 0:
                            this.Us = android.support.v4.view.o.c(motionEvent, 0);
                            action = (int) (motionEvent.getX() + 0.5f);
                            this.Uv = action;
                            this.Ut = action;
                            action = (int) (motionEvent.getY() + 0.5f);
                            this.Uw = action;
                            this.Uu = action;
                            if (eR) {
                                action = 0;
                            } else {
                                action = 1;
                            }
                            if (eS) {
                                action |= 2;
                            }
                            startNestedScroll(action);
                            break;
                        case 1:
                            this.ft.addMovement(obtain);
                            this.ft.computeCurrentVelocity(1000, (float) this.Uy);
                            f = eR ? -y.a(this.ft, this.Us) : 0.0f;
                            if (eS) {
                                f2 = 0.0f;
                            } else {
                                f2 = -y.b(this.ft, this.Us);
                            }
                            if ((f == 0.0f && f2 == 0.0f) || !Q((int) f, (int) f2)) {
                                ag(0);
                            }
                            fx();
                            z = true;
                            break;
                        case 2:
                            action = android.support.v4.view.o.b(motionEvent, this.Us);
                            if (action < 0) {
                                d = (int) (android.support.v4.view.o.d(motionEvent, action) + 0.5f);
                                e2 = (int) (android.support.v4.view.o.e(motionEvent, action) + 0.5f);
                                i = this.Uv - d;
                                action = this.Uw - e2;
                                if (dispatchNestedPreScroll(i, action, this.Dp, this.Do)) {
                                    i -= this.Dp[0];
                                    action -= this.Dp[1];
                                    obtain.offsetLocation((float) this.Do[0], (float) this.Do[1]);
                                    iArr2 = this.UM;
                                    iArr2[0] = iArr2[0] + this.Do[0];
                                    iArr2 = this.UM;
                                    iArr2[1] = iArr2[1] + this.Do[1];
                                }
                                if (this.yi != 1) {
                                    if (eR || Math.abs(i) <= this.iN) {
                                        z3 = false;
                                    } else {
                                        if (i > 0) {
                                            i -= this.iN;
                                        } else {
                                            i += this.iN;
                                        }
                                        z3 = true;
                                    }
                                    if (eS && Math.abs(action) > this.iN) {
                                        if (action <= 0) {
                                            action -= this.iN;
                                        } else {
                                            action += this.iN;
                                        }
                                        z3 = true;
                                    }
                                    if (z3) {
                                        ag(1);
                                    }
                                }
                                if (this.yi == 1) {
                                    this.Uv = d - this.Do[0];
                                    this.Uw = e2 - this.Do[1];
                                    if (!eR) {
                                        i = 0;
                                    }
                                    if (!eS) {
                                        action = 0;
                                    }
                                    if (a(i, action, obtain)) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                        break;
                                    }
                                }
                            }
                            new StringBuilder("Error processing scroll; pointer index for id ").append(this.Us).append(" not found. Did any MotionEvents get skipped?");
                            return false;
                            break;
                        case 3:
                            fy();
                            break;
                        case 5:
                            this.Us = android.support.v4.view.o.c(motionEvent, e);
                            action = (int) (android.support.v4.view.o.d(motionEvent, e) + 0.5f);
                            this.Uv = action;
                            this.Ut = action;
                            action = (int) (android.support.v4.view.o.e(motionEvent, e) + 0.5f);
                            this.Uw = action;
                            this.Uu = action;
                            break;
                        case 6:
                            m(motionEvent);
                            break;
                    }
                    if (!z) {
                        this.ft.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        if (action != 0) {
            int size = this.TY.size();
            for (e = 0; e < size; e++) {
                j jVar = (j) this.TY.get(e);
                if (jVar.n(motionEvent)) {
                    this.TZ = jVar;
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            fy();
            return true;
        } else if (this.TV != null) {
            return false;
        } else {
            eR = this.TV.eR();
            eS = this.TV.eS();
            if (this.ft == null) {
                this.ft = VelocityTracker.obtain();
            }
            obtain = MotionEvent.obtain(motionEvent);
            action = android.support.v4.view.o.d(motionEvent);
            e = android.support.v4.view.o.e(motionEvent);
            if (action == 0) {
                iArr = this.UM;
                this.UM[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.UM[0], (float) this.UM[1]);
            switch (action) {
                case 0:
                    this.Us = android.support.v4.view.o.c(motionEvent, 0);
                    action = (int) (motionEvent.getX() + 0.5f);
                    this.Uv = action;
                    this.Ut = action;
                    action = (int) (motionEvent.getY() + 0.5f);
                    this.Uw = action;
                    this.Uu = action;
                    if (eR) {
                        action = 0;
                    } else {
                        action = 1;
                    }
                    if (eS) {
                        action |= 2;
                    }
                    startNestedScroll(action);
                    break;
                case 1:
                    this.ft.addMovement(obtain);
                    this.ft.computeCurrentVelocity(1000, (float) this.Uy);
                    if (eR) {
                    }
                    if (eS) {
                        f2 = 0.0f;
                    } else {
                        f2 = -y.b(this.ft, this.Us);
                    }
                    ag(0);
                    fx();
                    z = true;
                    break;
                case 2:
                    action = android.support.v4.view.o.b(motionEvent, this.Us);
                    if (action < 0) {
                        d = (int) (android.support.v4.view.o.d(motionEvent, action) + 0.5f);
                        e2 = (int) (android.support.v4.view.o.e(motionEvent, action) + 0.5f);
                        i = this.Uv - d;
                        action = this.Uw - e2;
                        if (dispatchNestedPreScroll(i, action, this.Dp, this.Do)) {
                            i -= this.Dp[0];
                            action -= this.Dp[1];
                            obtain.offsetLocation((float) this.Do[0], (float) this.Do[1]);
                            iArr2 = this.UM;
                            iArr2[0] = iArr2[0] + this.Do[0];
                            iArr2 = this.UM;
                            iArr2[1] = iArr2[1] + this.Do[1];
                        }
                        if (this.yi != 1) {
                            if (eR) {
                                break;
                            }
                            z3 = false;
                            if (action <= 0) {
                                action += this.iN;
                            } else {
                                action -= this.iN;
                            }
                            z3 = true;
                            if (z3) {
                                ag(1);
                            }
                            break;
                        }
                        if (this.yi == 1) {
                            this.Uv = d - this.Do[0];
                            this.Uw = e2 - this.Do[1];
                            if (eR) {
                                i = 0;
                            }
                            if (eS) {
                                action = 0;
                            }
                            if (a(i, action, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.Us).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fy();
                    break;
                case 5:
                    this.Us = android.support.v4.view.o.c(motionEvent, e);
                    action = (int) (android.support.v4.view.o.d(motionEvent, e) + 0.5f);
                    this.Uv = action;
                    this.Ut = action;
                    action = (int) (android.support.v4.view.o.e(motionEvent, e) + 0.5f);
                    this.Uw = action;
                    this.Uu = action;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (z) {
                this.ft.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void fx() {
        if (this.ft != null) {
            this.ft.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.Un != null) {
            i = this.Un.cw();
        }
        if (this.Uo != null) {
            i |= this.Uo.cw();
        }
        if (this.Up != null) {
            i |= this.Up.cw();
        }
        if (this.Uq != null) {
            i |= this.Uq.cw();
        }
        if (i != 0) {
            z.E(this);
        }
    }

    private void fy() {
        fx();
        ag(0);
    }

    private void m(MotionEvent motionEvent) {
        int e = android.support.v4.view.o.e(motionEvent);
        if (android.support.v4.view.o.c(motionEvent, e) == this.Us) {
            e = e == 0 ? 1 : 0;
            this.Us = android.support.v4.view.o.c(motionEvent, e);
            int d = (int) (android.support.v4.view.o.d(motionEvent, e) + 0.5f);
            this.Uv = d;
            this.Ut = d;
            e = (int) (android.support.v4.view.o.e(motionEvent, e) + 0.5f);
            this.Uw = e;
            this.Uu = e;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (!(this.TV == null || this.Uf || (android.support.v4.view.o.g(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f2;
            float f3;
            if (this.TV.eS()) {
                f2 = -android.support.v4.view.o.f(motionEvent, 9);
            } else {
                f2 = 0.0f;
            }
            if (this.TV.eR()) {
                f3 = android.support.v4.view.o.f(motionEvent, 10);
            } else {
                f3 = 0.0f;
            }
            if (!(f2 == 0.0f && f3 == 0.0f)) {
                if (this.Uz == Float.MIN_VALUE) {
                    TypedValue typedValue = new TypedValue();
                    if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                        this.Uz = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
                    }
                    a((int) (f3 * f), (int) (f2 * f), motionEvent);
                }
                f = this.Uz;
                a((int) (f3 * f), (int) (f2 * f), motionEvent);
            }
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.TV == null) {
            S(i, i2);
        } else if (this.TV.Vd) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.TV.af(i, i2);
            if (!z && this.TU != null) {
                if (this.UB.VF == 1) {
                    fH();
                }
                this.TV.ad(i, i2);
                this.UB.VP = true;
                fI();
                this.TV.ae(i, i2);
                if (this.TV.eX()) {
                    this.TV.ad(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.UB.VP = true;
                    fI();
                    this.TV.ae(i, i2);
                }
            }
        } else if (this.Ub) {
            this.TV.af(i, i2);
        } else {
            if (this.Ui) {
                fp();
                fF();
                if (this.UB.VN) {
                    this.UB.VL = true;
                } else {
                    this.TP.ev();
                    this.UB.VL = false;
                }
                this.Ui = false;
                S(false);
            }
            if (this.TU != null) {
                this.UB.VH = this.TU.getItemCount();
            } else {
                this.UB.VH = 0;
            }
            fp();
            this.TV.af(i, i2);
            S(false);
            this.UB.VL = false;
        }
    }

    final void S(int i, int i2) {
        setMeasuredDimension(h.m(i, getPaddingLeft() + getPaddingRight(), z.S(this)), h.m(i2, getPaddingTop() + getPaddingBottom(), z.T(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            fw();
        }
    }

    public final void a(e eVar) {
        if (this.Ur != null) {
            this.Ur.eL();
            this.Ur.UT = null;
        }
        this.Ur = eVar;
        if (this.Ur != null) {
            this.Ur.UT = this.UG;
        }
    }

    private void fz() {
        this.Um++;
    }

    private void fA() {
        this.Um--;
        if (this.Um <= 0) {
            this.Um = 0;
            int i = this.Uh;
            this.Uh = 0;
            if (i != 0 && fB()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                android.support.v4.view.a.a.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean fB() {
        return this.ju != null && this.ju.isEnabled();
    }

    private boolean fC() {
        return this.Um > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (fC()) {
            int b;
            if (accessibilityEvent != null) {
                b = android.support.v4.view.a.a.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.Uh = i | this.Uh;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    private void fD() {
        if (!this.UH && this.Ua) {
            z.a((View) this, this.UN);
            this.UH = true;
        }
    }

    private boolean fE() {
        return this.Ur != null && this.TV.eQ();
    }

    private void fF() {
        boolean z;
        boolean z2 = true;
        if (this.Ul) {
            this.TP.reset();
            fL();
            this.TV.eM();
        }
        if (fE()) {
            this.TP.es();
        } else {
            this.TP.ev();
        }
        boolean z3;
        if (this.UE || this.UF) {
            z3 = true;
        } else {
            z3 = false;
        }
        q qVar = this.UB;
        if (!this.Uc || this.Ur == null || (!(this.Ul || z3 || this.TV.Vc) || (this.Ul && !this.TU.US))) {
            z = false;
        } else {
            z = true;
        }
        qVar.VM = z;
        q qVar2 = this.UB;
        if (!(this.UB.VM && z3 && !this.Ul && fE())) {
            z2 = false;
        }
        qVar2.VN = z2;
    }

    private void fG() {
        if (this.TU != null && this.TV != null) {
            boolean z;
            int z2;
            int i;
            this.UB.VP = false;
            if (this.UB.VF == 1) {
                fH();
                this.TV.z(this);
                fI();
            } else {
                e eVar = this.TP;
                if (eVar.OT.isEmpty() || eVar.OS.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = 1;
                }
                if (z2 == 0 && this.TV.mWidth == getWidth() && this.TV.mHeight == getHeight()) {
                    this.TV.z(this);
                } else {
                    this.TV.z(this);
                    fI();
                }
            }
            this.UB.bu(4);
            fp();
            fz();
            this.UB.VF = 1;
            if (this.UB.VM) {
                for (int childCount = this.TQ.getChildCount() - 1; childCount >= 0; childCount--) {
                    t aY = aY(this.TQ.getChildAt(childCount));
                    if (!aY.gd()) {
                        long g = g(aY);
                        c b = new c().b(aY, 0);
                        t tVar = (t) this.TR.aat.get(g);
                        if (!(tVar == null || tVar.gd())) {
                            boolean C = this.TR.C(tVar);
                            boolean C2 = this.TR.C(aY);
                            if (!(C && tVar == aY)) {
                                c c = this.TR.c(tVar, 4);
                                this.TR.c(aY, b);
                                b = this.TR.c(aY, 8);
                                if (c == null) {
                                    int childCount2 = this.TQ.getChildCount();
                                    i = 0;
                                    while (i < childCount2) {
                                        t aY2 = aY(this.TQ.getChildAt(i));
                                        if (aY2 == aY || g(aY2) != g) {
                                            i++;
                                        } else if (this.TU == null || !this.TU.US) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        }
                                    }
                                    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(tVar).append(" cannot be found but it is necessary for ").append(aY);
                                } else {
                                    tVar.V(false);
                                    if (C) {
                                        f(tVar);
                                    }
                                    if (tVar != aY) {
                                        if (C2) {
                                            f(aY);
                                        }
                                        tVar.VZ = aY;
                                        f(tVar);
                                        this.TN.p(tVar);
                                        aY.V(false);
                                        aY.Wa = tVar;
                                    }
                                    if (this.Ur.a(tVar, aY, c, b)) {
                                        fD();
                                    }
                                }
                            }
                        }
                        this.TR.c(aY, b);
                    }
                }
                this.TR.a(this.UP);
            }
            this.TV.c(this.TN);
            this.UB.VI = this.UB.VH;
            this.Ul = false;
            this.UB.VM = false;
            this.UB.VN = false;
            this.TV.Vc = false;
            if (this.TN.Vo != null) {
                this.TN.Vo.clear();
            }
            fA();
            S(false);
            this.TR.clear();
            z2 = this.UK[0];
            i = this.UK[1];
            if (this.TQ.getChildCount() == 0) {
                z2 = (z2 == 0 && i == 0) ? false : true;
            } else {
                d(this.UK);
                z2 = (this.UK[0] == z2 && this.UK[1] == i) ? false : true;
            }
            if (z2) {
                T(0, 0);
            }
        }
    }

    private void fH() {
        int childCount;
        int i;
        t aY;
        this.UB.bu(1);
        this.UB.VP = false;
        fp();
        this.TR.clear();
        fz();
        fF();
        q qVar = this.UB;
        boolean z = this.UB.VM && this.UF;
        qVar.VO = z;
        this.UF = false;
        this.UE = false;
        this.UB.VL = this.UB.VN;
        this.UB.VH = this.TU.getItemCount();
        d(this.UK);
        if (this.UB.VM) {
            childCount = this.TQ.getChildCount();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.TQ.getChildAt(i));
                if (!aY.gd() && (!aY.gl() || this.TU.US)) {
                    this.TR.b(aY, this.Ur.a(this.UB, aY, e.j(aY), aY.gp()));
                    if (!(!this.UB.VO || !aY.gs() || aY.isRemoved() || aY.gd() || aY.gl())) {
                        this.TR.a(g(aY), aY);
                    }
                }
            }
        }
        if (this.UB.VN) {
            childCount = this.TQ.eG();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.TQ.aU(i));
                if (!aY.gd() && aY.VV == -1) {
                    aY.VV = aY.mPosition;
                }
            }
            z = this.UB.VK;
            this.UB.VK = false;
            this.TV.c(this.TN, this.UB);
            this.UB.VK = z;
            for (childCount = 0; childCount < this.TQ.getChildCount(); childCount++) {
                aY = aY(this.TQ.getChildAt(childCount));
                if (!aY.gd()) {
                    a aVar = (a) this.TR.aas.get(aY);
                    if (aVar == null || (aVar.flags & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        i = e.j(aY);
                        boolean bv = aY.bv(8192);
                        if (!bv) {
                            i |= Downloads.RECV_BUFFER_SIZE;
                        }
                        c a = this.Ur.a(this.UB, aY, i, aY.gp());
                        if (bv) {
                            a(aY, a);
                        } else {
                            as asVar = this.TR;
                            aVar = (a) asVar.aas.get(aY);
                            if (aVar == null) {
                                aVar = a.he();
                                asVar.aas.put(aY, aVar);
                            }
                            aVar.flags |= 2;
                            aVar.aau = a;
                        }
                    }
                }
            }
            fK();
        } else {
            fK();
        }
        fA();
        S(false);
        this.UB.VF = 2;
    }

    private void fI() {
        boolean z;
        fp();
        fz();
        this.UB.bu(6);
        this.TP.ev();
        this.UB.VH = this.TU.getItemCount();
        this.UB.VJ = 0;
        this.UB.VL = false;
        this.TV.c(this.TN, this.UB);
        this.UB.VK = false;
        this.TO = null;
        q qVar = this.UB;
        if (!this.UB.VM || this.Ur == null) {
            z = false;
        } else {
            z = true;
        }
        qVar.VM = z;
        this.UB.VF = 4;
        fA();
        S(false);
    }

    private void a(t tVar, c cVar) {
        tVar.setFlags(0, 8192);
        if (this.UB.VO && tVar.gs() && !tVar.isRemoved() && !tVar.gd()) {
            this.TR.a(g(tVar), tVar);
        }
        this.TR.b(tVar, cVar);
    }

    private void d(int[] iArr) {
        int childCount = this.TQ.getChildCount();
        if (childCount == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            int ge;
            t aY = aY(this.TQ.getChildAt(i3));
            if (!aY.gd()) {
                ge = aY.ge();
                if (ge < i) {
                    i = ge;
                }
                if (ge > i2) {
                    i3++;
                    i = i;
                    i2 = ge;
                }
            }
            ge = i2;
            i3++;
            i = i;
            i2 = ge;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    protected void removeDetachedView(View view, boolean z) {
        t aY = aY(view);
        if (aY != null) {
            if (aY.gn()) {
                aY.gk();
            } else if (!aY.gd()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + aY);
            }
        }
        bc(view);
        super.removeDetachedView(view, z);
    }

    private long g(t tVar) {
        return this.TU.US ? tVar.VW : (long) tVar.mPosition;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.os.e.beginSection("RV OnLayout");
        fG();
        android.support.v4.os.e.endSection();
        this.Uc = true;
    }

    public void requestLayout() {
        if (this.Ud != 0 || this.Uf) {
            this.Ue = true;
        } else {
            super.requestLayout();
        }
    }

    public final void fJ() {
        int i = 0;
        int eG = this.TQ.eG();
        for (int i2 = 0; i2 < eG; i2++) {
            ((LayoutParams) this.TQ.aU(i2).getLayoutParams()).Vi = true;
        }
        m mVar = this.TN;
        eG = mVar.Vp.size();
        while (i < eG) {
            LayoutParams layoutParams = (LayoutParams) ((t) mVar.Vp.get(i)).VU.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.Vi = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.TX.size();
        for (i = 0; i < size; i++) {
            ((g) this.TX.get(i)).a(canvas, this);
        }
        if (this.Un == null || this.Un.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.TS ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.Un == null || !this.Un.draw(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.Uo == null || this.Uo.isFinished())) {
            size = canvas.save();
            if (this.TS) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.Uo == null || !this.Uo.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Up == null || this.Up.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            if (this.TS) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.Up == null || !this.Up.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Uq == null || this.Uq.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.TS) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.Uq != null && this.Uq.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.Ur == null || this.TX.size() <= 0 || !this.Ur.isRunning()) {
            i3 = i2;
        }
        if (i3 != 0) {
            z.E(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.TX.size();
        for (int i = 0; i < size; i++) {
            ((g) this.TX.get(i)).a(canvas, this, this.UB);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.TV.a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.TV != null) {
            return this.TV.eN();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.TV != null) {
            return this.TV.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.TV != null) {
            return this.TV.e(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void fK() {
        int i = 0;
        int eG = this.TQ.eG();
        for (int i2 = 0; i2 < eG; i2++) {
            t aY = aY(this.TQ.aU(i2));
            if (!aY.gd()) {
                aY.gb();
            }
        }
        m mVar = this.TN;
        int size = mVar.Vp.size();
        for (eG = 0; eG < size; eG++) {
            ((t) mVar.Vp.get(eG)).gb();
        }
        size = mVar.Vn.size();
        for (eG = 0; eG < size; eG++) {
            ((t) mVar.Vn.get(eG)).gb();
        }
        if (mVar.Vo != null) {
            eG = mVar.Vo.size();
            while (i < eG) {
                ((t) mVar.Vo.get(i)).gb();
                i++;
            }
        }
    }

    final void c(int i, int i2, boolean z) {
        int i3 = i + i2;
        int eG = this.TQ.eG();
        for (int i4 = 0; i4 < eG; i4++) {
            t aY = aY(this.TQ.aU(i4));
            if (!(aY == null || aY.gd())) {
                if (aY.mPosition >= i3) {
                    aY.i(-i2, z);
                    this.UB.VK = true;
                } else if (aY.mPosition >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    aY.addFlags(8);
                    aY.i(i6, z);
                    aY.mPosition = i5;
                    this.UB.VK = true;
                }
            }
        }
        m mVar = this.TN;
        int i7 = i + i2;
        for (i3 = mVar.Vp.size() - 1; i3 >= 0; i3--) {
            t tVar = (t) mVar.Vp.get(i3);
            if (tVar != null) {
                if (tVar.mPosition >= i7) {
                    tVar.i(-i2, z);
                } else if (tVar.mPosition >= i) {
                    tVar.addFlags(8);
                    mVar.bs(i3);
                }
            }
        }
        requestLayout();
    }

    private void fL() {
        int i;
        int eG = this.TQ.eG();
        for (i = 0; i < eG; i++) {
            t aY = aY(this.TQ.aU(i));
            if (!(aY == null || aY.gd())) {
                aY.addFlags(6);
            }
        }
        fJ();
        m mVar = this.TN;
        if (mVar.UQ.TU == null || !mVar.UQ.TU.US) {
            mVar.fW();
            return;
        }
        int size = mVar.Vp.size();
        for (i = 0; i < size; i++) {
            t tVar = (t) mVar.Vp.get(i);
            if (tVar != null) {
                tVar.addFlags(6);
                tVar.S(null);
            }
        }
    }

    public final t aP(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return aY(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static t aY(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).Vh;
    }

    public static int aZ(View view) {
        t aY = aY(view);
        return aY != null ? aY.gf() : -1;
    }

    public static int ba(View view) {
        t aY = aY(view);
        return aY != null ? aY.ge() : -1;
    }

    public final t bi(int i) {
        if (this.Ul) {
            return null;
        }
        int eG = this.TQ.eG();
        for (int i2 = 0; i2 < eG; i2++) {
            t aY = aY(this.TQ.aU(i2));
            if (aY != null && !aY.isRemoved() && h(aY) == i) {
                return aY;
            }
        }
        return null;
    }

    public final View j(float f, float f2) {
        for (int childCount = this.TQ.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.TQ.getChildAt(childCount);
            float Q = z.Q(childAt);
            float R = z.R(childAt);
            if (f >= ((float) childAt.getLeft()) + Q && f <= Q + ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) + R && f2 <= ((float) childAt.getBottom()) + R) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect bb(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.Vi) {
            return layoutParams.RC;
        }
        Rect rect = layoutParams.RC;
        rect.set(0, 0, 0, 0);
        int size = this.TX.size();
        for (int i = 0; i < size; i++) {
            this.ey.set(0, 0, 0, 0);
            ((g) this.TX.get(i)).a(this.ey, view, this, this.UB);
            rect.left += this.ey.left;
            rect.top += this.ey.top;
            rect.right += this.ey.right;
            rect.bottom += this.ey.bottom;
        }
        layoutParams.Vi = false;
        return rect;
    }

    final void T(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.UC != null) {
            this.UC.c(this, i, i2);
        }
        if (this.UD != null) {
            for (scrollY = this.UD.size() - 1; scrollY >= 0; scrollY--) {
                ((k) this.UD.get(scrollY)).c(this, i, i2);
            }
        }
    }

    private void fM() {
        int childCount = this.TQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.TQ.getChildAt(i);
            t aP = aP(childAt);
            if (!(aP == null || aP.Wa == null)) {
                View view = aP.Wa.VU;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void bc(View view) {
        aY(view);
        if (this.Uk != null) {
            for (int size = this.Uk.size() - 1; size >= 0; size--) {
                ((i) this.Uk.get(size)).bl(view);
            }
        }
    }

    private int h(t tVar) {
        if (tVar.bv(524) || !tVar.isBound()) {
            return -1;
        }
        e eVar = this.TP;
        int i = tVar.mPosition;
        int size = eVar.OS.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) eVar.OS.get(i2);
            switch (bVar.pK) {
                case 1:
                    if (bVar.OZ > i) {
                        break;
                    }
                    i += bVar.Pb;
                    break;
                case 2:
                    if (bVar.OZ <= i) {
                        if (bVar.OZ + bVar.Pb <= i) {
                            i -= bVar.Pb;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.OZ != i) {
                        if (bVar.OZ < i) {
                            i--;
                        }
                        if (bVar.Pb > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = bVar.Pb;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        fN().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return fN().xx;
    }

    public boolean startNestedScroll(int i) {
        return fN().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        fN().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return fN().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return fN().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return fN().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return fN().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return fN().dispatchNestedPreFling(f, f2);
    }

    public int getChildDrawingOrder(int i, int i2) {
        if (this.UJ == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.UJ.ac(i, i2);
    }

    private android.support.v4.view.q fN() {
        if (this.UL == null) {
            this.UL = new android.support.v4.view.q(this);
        }
        return this.UL;
    }
}
