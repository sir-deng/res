package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView extends WrappingGridView {
    private int fu = -1;
    private List<Long> idList = new ArrayList();
    boolean maC = false;
    private BitmapDrawable rWE;
    private Rect rWF;
    private Rect rWG;
    private Rect rWH;
    private int rWI = 0;
    private int rWJ = 0;
    private int rWK = -1;
    private int rWL = -1;
    private int rWM = -1;
    private int rWN = -1;
    private int rWO;
    private long rWP = -1;
    private boolean rWQ = false;
    private boolean rWR;
    private int rWS = 0;
    private boolean rWT = false;
    private List<ObjectAnimator> rWU = new LinkedList();
    boolean rWV;
    boolean rWW;
    boolean rWX = true;
    private boolean rWY = true;
    private OnScrollListener rWZ;
    f rXa;
    e rXb;
    private OnItemClickListener rXc;
    private OnItemClickListener rXd = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!DynamicGridView.this.maC && DynamicGridView.this.isEnabled() && DynamicGridView.this.rXc != null) {
                DynamicGridView.this.rXc.onItemClick(adapterView, view, i, j);
            }
        }
    };
    private boolean rXe;
    private Stack<a> rXf;
    private a rXg;
    private View rXh;
    d rXi = new d();
    int rXj = -1;
    float rXk;
    float rXl;
    private float rXm;
    private float rXn;
    private OnScrollListener rXo = new OnScrollListener() {
        private int lgr;
        private int rXq = -1;
        private int rXr = -1;
        private int rXs;
        private int rXt;

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.rXs = i;
            this.rXt = i2;
            this.rXq = this.rXq == -1 ? this.rXs : this.rXq;
            this.rXr = this.rXr == -1 ? this.rXt : this.rXr;
            if (!(this.rXs == this.rXq || !DynamicGridView.this.rWQ || DynamicGridView.this.rWP == -1)) {
                DynamicGridView.this.eZ(DynamicGridView.this.rWP);
                DynamicGridView.this.bDl();
            }
            if (!(this.rXs + this.rXt == this.rXq + this.rXr || !DynamicGridView.this.rWQ || DynamicGridView.this.rWP == -1)) {
                DynamicGridView.this.eZ(DynamicGridView.this.rWP);
                DynamicGridView.this.bDl();
            }
            this.rXq = this.rXs;
            this.rXr = this.rXt;
            if (DynamicGridView.bDi() && DynamicGridView.this.rWX) {
                for (int i4 = 0; i4 < i2; i4++) {
                    View childAt = DynamicGridView.this.getChildAt(i4);
                    if (childAt != null) {
                        if (DynamicGridView.this.rWP != -1 && Boolean.TRUE != childAt.getTag(com.tencent.mm.plugin.sns.i.f.qIa)) {
                            if (i4 % 2 == 0) {
                                DynamicGridView.this.cO(childAt);
                            } else {
                                DynamicGridView.this.cP(childAt);
                            }
                            childAt.setTag(com.tencent.mm.plugin.sns.i.f.qIa, Boolean.valueOf(true));
                        } else if (DynamicGridView.this.rWP == -1 && childAt.getRotation() != 0.0f) {
                            childAt.setRotation(0.0f);
                            childAt.setTag(com.tencent.mm.plugin.sns.i.f.qIa, Boolean.valueOf(false));
                        }
                    }
                }
            }
            if (DynamicGridView.this.rWZ != null) {
                DynamicGridView.this.rWZ.onScroll(absListView, i, i2, i3);
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            this.lgr = i;
            DynamicGridView.this.yi = i;
            if (this.rXt > 0 && this.lgr == 0) {
                if (DynamicGridView.this.rWQ && DynamicGridView.this.rWR) {
                    DynamicGridView.this.bDg();
                } else if (DynamicGridView.this.rWT) {
                    DynamicGridView.this.bDh();
                }
            }
            if (DynamicGridView.this.rWZ != null) {
                DynamicGridView.this.rWZ.onScrollStateChanged(absListView, i);
            }
        }
    };
    private int yi = 0;

    private static class a {
        List<Pair<Integer, Integer>> rXv = new Stack();

        a() {
        }

        public final void dN(int i, int i2) {
            this.rXv.add(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public interface f {
        void bDd();
    }

    private interface h {
        void dO(int i, int i2);
    }

    private class c implements h {
        int Be;
        int Bf;

        private class a implements OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int Vv;
            private final int rXx;

            a(int i, int i2) {
                this.rXx = i;
                this.Vv = i2;
            }

            public final boolean onPreDraw() {
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.rWI = DynamicGridView.this.rWI + c.this.Bf;
                DynamicGridView.this.rWJ = DynamicGridView.this.rWJ + c.this.Be;
                DynamicGridView.a(DynamicGridView.this, this.rXx, this.Vv);
                new StringBuilder("id ").append(DynamicGridView.this.fa(DynamicGridView.this.rWP));
                if (!(DynamicGridView.this.rXh == null || DynamicGridView.this.rXh == null)) {
                    if ($assertionsDisabled || DynamicGridView.this.rXh != null) {
                        DynamicGridView.this.rXh.setVisibility(0);
                        DynamicGridView.this.rXh = DynamicGridView.this.fb(DynamicGridView.this.rWP);
                        if (DynamicGridView.this.rXh != null) {
                            if ($assertionsDisabled || DynamicGridView.this.rXh != null) {
                                DynamicGridView.this.rXh.setVisibility(4);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                    throw new AssertionError();
                }
                return true;
            }
        }

        public c(int i, int i2) {
            this.Be = i;
            this.Bf = i2;
        }

        public final void dO(int i, int i2) {
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(i, i2));
        }
    }

    private class b implements h {
        static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
        private int Be;
        private int Bf;

        private class a implements OnPreDrawListener {
            private final int Vv;
            private final View rXw;
            private final int rXx;

            a(View view, int i, int i2) {
                this.rXw = view;
                this.rXx = i;
                this.Vv = i2;
            }

            public final boolean onPreDraw() {
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.rWI = DynamicGridView.this.rWI + b.this.Bf;
                DynamicGridView.this.rWJ = DynamicGridView.this.rWJ + b.this.Be;
                DynamicGridView.a(DynamicGridView.this, this.rXx, this.Vv);
                this.rXw.setVisibility(0);
                if (DynamicGridView.this.rXh != null) {
                    DynamicGridView.this.rXh.setVisibility(4);
                }
                return true;
            }
        }

        public b(int i, int i2) {
            this.Be = i;
            this.Bf = i2;
        }

        public final void dO(int i, int i2) {
            if ($assertionsDisabled || DynamicGridView.this.rXh != null) {
                DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.this.rXh, i, i2));
                DynamicGridView.this.rXh = DynamicGridView.this.fb(DynamicGridView.this.rWP);
                return;
            }
            throw new AssertionError();
        }
    }

    private class d extends Handler {
        private d() {
        }

        /* synthetic */ d(DynamicGridView dynamicGridView, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    DynamicGridView dynamicGridView = DynamicGridView.this;
                    View childAt = dynamicGridView.getChildAt(dynamicGridView.rXj);
                    new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.rXj).append(",lastTouchX ").append(dynamicGridView.rXk).append(",lastTouchY ").append(dynamicGridView.rXl);
                    if (!dynamicGridView.rWV && !dynamicGridView.rWW && f.c(childAt, dynamicGridView.rXk, dynamicGridView.rXl)) {
                        dynamicGridView.yn(dynamicGridView.rXj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public interface e {
        void bDc();

        void j(Rect rect);

        boolean k(Rect rect);

        void yl(int i);

        void ym(int i);
    }

    private class g implements h {
        private int Be;
        private int Bf;

        public g(int i, int i2) {
            this.Be = i;
            this.Bf = i2;
        }

        public final void dO(int i, int i2) {
            DynamicGridView.this.rWI = DynamicGridView.this.rWI + this.Bf;
            DynamicGridView.this.rWJ = DynamicGridView.this.rWJ + this.Be;
        }
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, int i, int i2) {
        Object obj = i2 > i ? 1 : null;
        Collection linkedList = new LinkedList();
        int min;
        View fb;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                fb = dynamicGridView.fb(dynamicGridView.yp(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(fb, (float) ((-fb.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) fb.getHeight()));
                } else {
                    linkedList.add(d(fb, (float) fb.getWidth(), 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                fb = dynamicGridView.fb(dynamicGridView.yp(min));
                if ((dynamicGridView.getColumnCount() + min) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(fb, (float) (fb.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-fb.getHeight())));
                } else {
                    linkedList.add(d(fb, (float) (-fb.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                DynamicGridView.this.rWW = true;
                DynamicGridView.b(DynamicGridView.this);
            }

            public final void onAnimationEnd(Animator animator) {
                DynamicGridView.this.rWW = false;
                DynamicGridView.b(DynamicGridView.this);
            }
        });
        animatorSet.start();
    }

    static /* synthetic */ void b(DynamicGridView dynamicGridView) {
        boolean z = (dynamicGridView.rWV || dynamicGridView.rWW) ? false : true;
        dynamicGridView.setEnabled(z);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rWZ = onScrollListener;
    }

    public final void yn(int i) {
        if (this.rWY) {
            requestDisallowInterceptTouchEvent(true);
            if (bDi() && this.rWX) {
                bDe();
            }
            if (i != -1) {
                this.maC = yo(i);
                if (this.maC) {
                    this.rWQ = true;
                }
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.rXc = onItemClickListener;
        super.setOnItemClickListener(this.rXd);
    }

    @TargetApi(11)
    private void bDe() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(com.tencent.mm.plugin.sns.i.f.qIa))) {
                if (i % 2 == 0) {
                    cO(childAt);
                } else {
                    cP(childAt);
                }
                childAt.setTag(com.tencent.mm.plugin.sns.i.f.qIa, Boolean.valueOf(true));
            }
        }
    }

    @TargetApi(11)
    final void iU(boolean z) {
        for (Animator cancel : this.rWU) {
            cancel.cancel();
        }
        this.rWU.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                if (z) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(com.tencent.mm.plugin.sns.i.f.qIa, Boolean.valueOf(false));
            }
        }
    }

    private void init(Context context) {
        super.setOnScrollListener(this.rXo);
        this.rWS = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.rWO = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.qEN);
    }

    @TargetApi(11)
    private void cO(View view) {
        ObjectAnimator cQ = cQ(view);
        cQ.setFloatValues(new float[]{-2.0f, 2.0f});
        cQ.start();
        this.rWU.add(cQ);
    }

    @TargetApi(11)
    private void cP(View view) {
        ObjectAnimator cQ = cQ(view);
        cQ.setFloatValues(new float[]{2.0f, -2.0f});
        cQ.start();
        this.rWU.add(cQ);
    }

    @TargetApi(11)
    private ObjectAnimator cQ(final View view) {
        if (!bDj()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                view.setLayerType(0, null);
            }
        });
        return objectAnimator;
    }

    private void dM(int i, int i2) {
        ((d) getAdapter()).dL(i, i2);
    }

    private int getColumnCount() {
        return ((d) getAdapter()).getColumnCount();
    }

    private void eZ(long j) {
        this.idList.clear();
        int fa = fa(j);
        int firstVisiblePosition = getFirstVisiblePosition();
        while (true) {
            int i = firstVisiblePosition;
            if (i <= getLastVisiblePosition()) {
                if (fa != i && ((d) getAdapter()).yk(i)) {
                    this.idList.add(Long.valueOf(yp(i)));
                }
                firstVisiblePosition = i + 1;
            } else {
                return;
            }
        }
    }

    public final int fa(long j) {
        View fb = fb(j);
        if (fb == null) {
            return -1;
        }
        return getPositionForView(fb);
    }

    public final View fb(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.fu);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.rXk = motionEvent.getX();
                this.rXl = motionEvent.getY();
                this.rXj = f.a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.rXj);
                if (!this.rWV && this.rXj >= 0) {
                    d dVar = this.rXi;
                    dVar.removeMessages(1);
                    dVar.sendEmptyMessageDelayed(1, 300);
                }
                this.rWM = -1;
                this.rWN = -1;
                this.rWK = (int) motionEvent.getX();
                this.rWL = (int) motionEvent.getY();
                this.fu = motionEvent.getPointerId(0);
                if (this.maC && isEnabled()) {
                    layoutChildren();
                    yo(pointToPosition(this.rWK, this.rWL));
                    break;
                } else if (!isEnabled()) {
                    return false;
                }
                break;
            case 1:
                bDh();
                if (this.rXe && this.rXg != null) {
                    a aVar = this.rXg;
                    Collections.reverse(aVar.rXv);
                    if (!aVar.rXv.isEmpty()) {
                        this.rXf.push(this.rXg);
                        this.rXg = new a();
                        break;
                    }
                }
                break;
            case 2:
                this.rXk = motionEvent.getX();
                this.rXl = motionEvent.getY();
                if (this.rWQ && this.fu != -1) {
                    if (this.rWN == -1 && this.rWM == -1) {
                        this.rWM = (int) motionEvent.getY(findPointerIndex);
                        this.rWN = (int) motionEvent.getX(findPointerIndex);
                        this.rWK = this.rWN;
                        this.rWL = this.rWM;
                        break;
                    }
                    this.rXm = motionEvent.getRawX();
                    this.rXn = motionEvent.getRawY();
                    this.rWM = (int) motionEvent.getY(findPointerIndex);
                    this.rWN = (int) motionEvent.getX(findPointerIndex);
                    int i = this.rWN - this.rWK;
                    this.rWF.offsetTo((i + this.rWH.left) + this.rWJ, ((this.rWM - this.rWL) + this.rWH.top) + this.rWI);
                    if (this.rWE != null) {
                        this.rWE.setBounds(this.rWF);
                    }
                    invalidate();
                    bDl();
                    this.rWR = false;
                    bDg();
                    if (this.rXb == null) {
                        return false;
                    }
                    Rect rect = new Rect(this.rWF);
                    rect.offset(0, this.rWF.height() >>> 1);
                    this.rXb.j(rect);
                    return false;
                }
                break;
            case 3:
                bDk();
                bDh();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.fu) {
                    bDh();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean bDf() {
        int fa = fa(this.rWP);
        if (fa == -1) {
            return false;
        }
        this.rXb.ym(fa);
        if (this.rXh == null) {
            return false;
        }
        h bVar;
        int positionForView = getPositionForView(this.rXh);
        int childCount = getChildCount() - 1;
        new StringBuilder("switch ").append(positionForView).append(",").append(childCount);
        dM(positionForView, childCount);
        if (this.rXe) {
            this.rXg.dN(positionForView, childCount);
        }
        this.rWL = this.rWM;
        this.rWK = this.rWN;
        if (bDi() && bDj()) {
            bVar = new b(0, 0);
        } else if (bDj()) {
            bVar = new g(0, 0);
        } else {
            bVar = new c(0, 0);
        }
        eZ(this.rWP);
        bVar.dO(positionForView, childCount);
        return true;
    }

    private boolean yo(int i) {
        if (!((d) getAdapter()).yj(i)) {
            return false;
        }
        this.rWI = 0;
        this.rWJ = 0;
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt == null) {
            return false;
        }
        this.rWP = getAdapter().getItemId(i);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        int top = childAt.getTop();
        int left = childAt.getLeft();
        Bitmap createBitmap = Bitmap.createBitmap(childAt.getWidth(), childAt.getHeight(), Config.ARGB_8888);
        childAt.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
        this.rWG = new Rect(left, top, left + width, top + height);
        this.rWF = new Rect(this.rWG.left - ((int) (((float) width) * 0.05f)), this.rWG.top - ((int) (((float) height) * 0.05f)), ((int) (((float) width) * 0.05f)) + this.rWG.right, ((int) (((float) height) * 0.05f)) + this.rWG.bottom);
        this.rWH = new Rect(this.rWF);
        bitmapDrawable.setBounds(this.rWG);
        this.rWE = bitmapDrawable;
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rWE, "bounds", new TypeEvaluator<Rect>() {
            public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                return new Rect(AnonymousClass4.c(rect.left, rect2.left, f), AnonymousClass4.c(rect.top, rect2.top, f), AnonymousClass4.c(rect.right, rect2.right, f), AnonymousClass4.c(rect.bottom, rect2.bottom, f));
            }

            private static int c(int i, int i2, float f) {
                return (int) (((float) i) + (((float) (i2 - i)) * f));
            }
        }, new Object[]{this.rWF});
        ofObject.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DynamicGridView.this.invalidate();
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                DynamicGridView.this.rWV = true;
                DynamicGridView.b(DynamicGridView.this);
            }

            public final void onAnimationEnd(Animator animator) {
                DynamicGridView.this.rWV = false;
                DynamicGridView.b(DynamicGridView.this);
            }
        });
        ofObject.setDuration(10);
        ofObject.start();
        if (bDi()) {
            childAt.setVisibility(4);
        }
        eZ(this.rWP);
        if (this.rXb != null) {
            this.rXb.yl(i);
        }
        return true;
    }

    private void bDg() {
        boolean z = true;
        Rect rect = this.rWF;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.rWS, 0);
        } else if (height2 + i < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            z = false;
        } else {
            smoothScrollBy(this.rWS, 0);
        }
        this.rWR = z;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    private void bDh() {
        this.rXi.removeMessages(1);
        final View fb = fb(this.rWP);
        Rect rect;
        if (this.rWF != null) {
            rect = new Rect(this.rWF);
            rect.offset(0, this.rWF.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.rXb != null && this.rXb.k(rect) && bDf()) {
            this.rWE = null;
            bDk();
            if (this.rXa != null) {
                this.rXa.bDd();
            }
        } else if (fb == null || !(this.rWQ || this.rWT)) {
            bDk();
        } else {
            this.rWQ = false;
            this.rWT = false;
            this.rWR = false;
            this.fu = -1;
            this.rWF.set(fb.getLeft(), fb.getTop(), fb.getRight(), fb.getBottom());
            new StringBuilder("animating to  ").append(this.rWF);
            if (VERSION.SDK_INT > 11) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rWE, "bounds", new TypeEvaluator<Rect>() {
                    public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
                        Rect rect = (Rect) obj;
                        Rect rect2 = (Rect) obj2;
                        return new Rect(AnonymousClass7.c(rect.left, rect2.left, f), AnonymousClass7.c(rect.top, rect2.top, f), AnonymousClass7.c(rect.right, rect2.right, f), AnonymousClass7.c(rect.bottom, rect2.bottom, f));
                    }

                    private static int c(int i, int i2, float f) {
                        return (int) (((float) i) + (((float) (i2 - i)) * f));
                    }
                }, new Object[]{this.rWF});
                ofObject.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DynamicGridView.this.invalidate();
                    }
                });
                ofObject.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                        DynamicGridView.this.rWV = true;
                        DynamicGridView.b(DynamicGridView.this);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        DynamicGridView.this.rWV = false;
                        DynamicGridView.b(DynamicGridView.this);
                        if (!(DynamicGridView.this.rWE == null || DynamicGridView.this.rXa == null)) {
                            DynamicGridView.this.rXa.bDd();
                        }
                        DynamicGridView.this.cR(fb);
                    }
                });
                ofObject.setDuration(200);
                ofObject.start();
            } else {
                this.rWE.setBounds(this.rWF);
                invalidate();
                cR(fb);
            }
        }
        if (this.rXb != null) {
            this.rXb.bDc();
        }
    }

    private void cR(View view) {
        this.idList.clear();
        this.rWP = -1;
        view.setVisibility(0);
        this.rWE = null;
        if (bDi() && this.rWX) {
            if (this.maC) {
                iU(false);
                bDe();
            } else {
                iU(true);
            }
        }
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
    }

    static boolean bDi() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean bDj() {
        return VERSION.SDK_INT < 21;
    }

    private void bDk() {
        View fb = fb(this.rWP);
        if (fb != null) {
            if (this.rWQ) {
                cR(fb);
            }
            this.rWQ = false;
            this.rWR = false;
            this.fu = -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bDl() {
        /*
        r14 = this;
        r0 = r14.rWM;
        r1 = r14.rWL;
        r6 = r0 - r1;
        r0 = r14.rWN;
        r1 = r14.rWK;
        r7 = r0 - r1;
        r0 = r14.rWG;
        r0 = r0.centerY();
        r1 = r14.rWI;
        r0 = r0 + r1;
        r8 = r0 + r6;
        r0 = r14.rWG;
        r0 = r0.centerX();
        r1 = r14.rWJ;
        r0 = r0 + r1;
        r9 = r0 + r7;
        r0 = r14.rWP;
        r0 = r14.fb(r0);
        r14.rXh = r0;
        r0 = r14.rXh;
        if (r0 != 0) goto L_0x002f;
    L_0x002e:
        return;
    L_0x002f:
        r4 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r14.rXh;
        r10 = r14.cS(r0);
        r0 = r14.idList;
        r11 = r0.iterator();
    L_0x003e:
        r0 = r11.hasNext();
        if (r0 == 0) goto L_0x0166;
    L_0x0044:
        r0 = r11.next();
        r0 = (java.lang.Long) r0;
        r12 = r0.longValue();
        r5 = r14.fb(r12);
        if (r5 == 0) goto L_0x01e5;
    L_0x0054:
        r3 = r14.cS(r5);
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x0151;
    L_0x005e:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0151;
    L_0x0064:
        r0 = 1;
    L_0x0065:
        if (r0 == 0) goto L_0x0073;
    L_0x0067:
        r0 = r5.getBottom();
        if (r8 >= r0) goto L_0x0073;
    L_0x006d:
        r0 = r5.getLeft();
        if (r9 > r0) goto L_0x0124;
    L_0x0073:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x0154;
    L_0x0079:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 >= r12) goto L_0x0154;
    L_0x007f:
        r0 = 1;
    L_0x0080:
        if (r0 == 0) goto L_0x008e;
    L_0x0082:
        r0 = r5.getBottom();
        if (r8 >= r0) goto L_0x008e;
    L_0x0088:
        r0 = r5.getRight();
        if (r9 < r0) goto L_0x0124;
    L_0x008e:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x0157;
    L_0x0094:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0157;
    L_0x009a:
        r0 = 1;
    L_0x009b:
        if (r0 == 0) goto L_0x00a9;
    L_0x009d:
        r0 = r5.getTop();
        if (r8 <= r0) goto L_0x00a9;
    L_0x00a3:
        r0 = r5.getLeft();
        if (r9 > r0) goto L_0x0124;
    L_0x00a9:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x015a;
    L_0x00af:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 >= r12) goto L_0x015a;
    L_0x00b5:
        r0 = 1;
    L_0x00b6:
        if (r0 == 0) goto L_0x00c4;
    L_0x00b8:
        r0 = r5.getTop();
        if (r8 <= r0) goto L_0x00c4;
    L_0x00be:
        r0 = r5.getRight();
        if (r9 < r0) goto L_0x0124;
    L_0x00c4:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x015d;
    L_0x00ca:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 != r12) goto L_0x015d;
    L_0x00d0:
        r0 = 1;
    L_0x00d1:
        if (r0 == 0) goto L_0x00dc;
    L_0x00d3:
        r0 = r5.getBottom();
        r12 = r14.rWO;
        r0 = r0 - r12;
        if (r8 < r0) goto L_0x0124;
    L_0x00dc:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x0160;
    L_0x00e2:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 != r12) goto L_0x0160;
    L_0x00e8:
        r0 = 1;
    L_0x00e9:
        if (r0 == 0) goto L_0x00f4;
    L_0x00eb:
        r0 = r5.getTop();
        r12 = r14.rWO;
        r0 = r0 + r12;
        if (r8 > r0) goto L_0x0124;
    L_0x00f4:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 != r12) goto L_0x0162;
    L_0x00fa:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0162;
    L_0x0100:
        r0 = 1;
    L_0x0101:
        if (r0 == 0) goto L_0x010c;
    L_0x0103:
        r0 = r5.getLeft();
        r12 = r14.rWO;
        r0 = r0 + r12;
        if (r9 > r0) goto L_0x0124;
    L_0x010c:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 != r12) goto L_0x0164;
    L_0x0112:
        r0 = r3.x;
        r3 = r10.x;
        if (r0 >= r3) goto L_0x0164;
    L_0x0118:
        r0 = 1;
    L_0x0119:
        if (r0 == 0) goto L_0x01e5;
    L_0x011b:
        r0 = r5.getRight();
        r3 = r14.rWO;
        r0 = r0 - r3;
        if (r9 >= r0) goto L_0x01e5;
    L_0x0124:
        r0 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cM(r5);
        r3 = r14.rXh;
        r3 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cM(r3);
        r0 = r0 - r3;
        r3 = java.lang.Math.abs(r0);
        r0 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cN(r5);
        r12 = r14.rXh;
        r12 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cN(r12);
        r0 = r0 - r12;
        r0 = java.lang.Math.abs(r0);
        r12 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r12 < 0) goto L_0x01e5;
    L_0x0146:
        r12 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r12 < 0) goto L_0x01e5;
    L_0x014a:
        r1 = r3;
        r2 = r5;
    L_0x014c:
        r4 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x003e;
    L_0x0151:
        r0 = 0;
        goto L_0x0065;
    L_0x0154:
        r0 = 0;
        goto L_0x0080;
    L_0x0157:
        r0 = 0;
        goto L_0x009b;
    L_0x015a:
        r0 = 0;
        goto L_0x00b6;
    L_0x015d:
        r0 = 0;
        goto L_0x00d1;
    L_0x0160:
        r0 = 0;
        goto L_0x00e9;
    L_0x0162:
        r0 = 0;
        goto L_0x0101;
    L_0x0164:
        r0 = 0;
        goto L_0x0119;
    L_0x0166:
        if (r4 == 0) goto L_0x002e;
    L_0x0168:
        r0 = r14.rXh;
        r1 = r14.getPositionForView(r0);
        r2 = r14.getPositionForView(r4);
        r0 = new java.lang.StringBuilder;
        r3 = "switch ";
        r0.<init>(r3);
        r0 = r0.append(r1);
        r3 = ",";
        r0 = r0.append(r3);
        r0.append(r2);
        r0 = r14.getAdapter();
        r0 = (com.tencent.mm.plugin.sns.ui.previewimageview.d) r0;
        r3 = -1;
        if (r2 == r3) goto L_0x019d;
    L_0x0191:
        r3 = r0.yk(r1);
        if (r3 == 0) goto L_0x019d;
    L_0x0197:
        r0 = r0.yk(r2);
        if (r0 != 0) goto L_0x01a4;
    L_0x019d:
        r0 = r14.rWP;
        r14.eZ(r0);
        goto L_0x002e;
    L_0x01a4:
        r14.dM(r1, r2);
        r0 = r14.rXe;
        if (r0 == 0) goto L_0x01b0;
    L_0x01ab:
        r0 = r14.rXg;
        r0.dN(r1, r2);
    L_0x01b0:
        r0 = r14.rWM;
        r14.rWL = r0;
        r0 = r14.rWN;
        r14.rWK = r0;
        r0 = bDi();
        if (r0 == 0) goto L_0x01d3;
    L_0x01be:
        r0 = bDj();
        if (r0 == 0) goto L_0x01d3;
    L_0x01c4:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$b;
        r0.<init>(r7, r6);
    L_0x01c9:
        r4 = r14.rWP;
        r14.eZ(r4);
        r0.dO(r1, r2);
        goto L_0x002e;
    L_0x01d3:
        r0 = bDj();
        if (r0 == 0) goto L_0x01df;
    L_0x01d9:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$g;
        r0.<init>(r7, r6);
        goto L_0x01c9;
    L_0x01df:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$c;
        r0.<init>(r7, r6);
        goto L_0x01c9;
    L_0x01e5:
        r0 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.bDl():void");
    }

    private Point cS(View view) {
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        return new Point(positionForView % columnCount, positionForView / columnCount);
    }

    private long yp(int i) {
        return getAdapter().getItemId(i);
    }

    @TargetApi(11)
    private static AnimatorSet d(View view, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.rWE != null) {
            this.rWE.draw(canvas);
        }
    }
}
