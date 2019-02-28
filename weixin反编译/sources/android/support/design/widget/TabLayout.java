package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.a.d;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.support.v4.widget.r;
import android.support.v7.widget.h;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class TabLayout extends HorizontalScrollView {
    private static final android.support.v4.e.i.a<b> ka = new android.support.v4.e.i.c();
    private final ArrayList<b> kb;
    private b kc;
    private final a kd;
    private int ke;
    private int kf;
    private int kg;
    private int kh;
    private int ki;
    private ColorStateList kj;
    private float kk;
    private float kl;
    private final int km;
    private int kn;
    private final int ko;
    private final int kp;
    private final int kq;
    private int kr;
    private int ks;
    private u kt;
    private final android.support.v4.e.i.a<c> ku;
    private int mMode;

    private class a extends LinearLayout {
        private int kA = -1;
        private int kB = -1;
        u kC;
        int kw;
        final Paint kx;
        int ky = -1;
        float kz;

        a(Context context) {
            super(context);
            setWillNotDraw(false);
            this.kx = new Paint();
        }

        protected final void onMeasure(int i, int i2) {
            Object obj = null;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && TabLayout.this.mMode == 1 && TabLayout.this.ks == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    int max;
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.I(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            Object obj2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                obj2 = obj;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                obj2 = 1;
                            }
                            i3++;
                            obj = obj2;
                        }
                    } else {
                        TabLayout.this.ks = 0;
                        TabLayout.this.l(false);
                        obj = 1;
                    }
                    if (obj != null) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.kC == null || !this.kC.ls.isRunning()) {
                at();
                return;
            }
            this.kC.ls.cancel();
            f(this.ky, Math.round(((float) this.kC.ls.getDuration()) * (1.0f - this.kC.ls.getAnimatedFraction())));
        }

        final void at() {
            int i;
            int i2;
            View childAt = getChildAt(this.ky);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.kz > 0.0f && this.ky < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.ky + 1);
                    i = (int) ((((float) i) * (1.0f - this.kz)) + (this.kz * ((float) childAt2.getLeft())));
                    i2 = (int) ((((float) i2) * (1.0f - this.kz)) + (((float) childAt2.getRight()) * this.kz));
                }
            }
            e(i, i2);
        }

        private void e(int i, int i2) {
            if (i != this.kA || i2 != this.kB) {
                this.kA = i;
                this.kB = i2;
                z.E(this);
            }
        }

        final void f(final int i, int i2) {
            if (this.kC != null && this.kC.ls.isRunning()) {
                this.kC.ls.cancel();
            }
            Object obj = z.I(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                at();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.ky) <= 1) {
                i3 = this.kA;
                i4 = this.kB;
            } else {
                int a = TabLayout.this.I(24);
                if (i < this.ky) {
                    if (obj == null) {
                        i4 = right + a;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + a;
                    i3 = i4;
                }
                i4 = left - a;
                i3 = i4;
            }
            if (i3 != left || i4 != right) {
                u az = aa.az();
                this.kC = az;
                az.setInterpolator(a.eB);
                az.setDuration(i2);
                az.e(0.0f, 1.0f);
                az.a(new c() {
                    public final void a(u uVar) {
                        float animatedFraction = uVar.ls.getAnimatedFraction();
                        a.this.e(a.a(i3, left, animatedFraction), a.a(i4, right, animatedFraction));
                    }
                });
                az.ls.a(new android.support.design.widget.u.AnonymousClass2(new b() {
                    public final void au() {
                        a.this.ky = i;
                        a.this.kz = 0.0f;
                    }
                }));
                az.ls.start();
            }
        }

        public final void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.kA >= 0 && this.kB > this.kA) {
                canvas.drawRect((float) this.kA, (float) (getHeight() - this.kw), (float) this.kB, (float) getHeight(), this.kx);
            }
        }
    }

    public static final class b {
        Drawable jY;
        CharSequence kJ;
        View kK;
        TabLayout kL;
        c kM;
        int mPosition;
        CharSequence mText;

        /* synthetic */ b(byte b) {
            this();
        }

        private b() {
            this.mPosition = -1;
        }

        public final void select() {
            if (this.kL == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.kL.a(this);
        }

        final void av() {
            if (this.kM != null) {
                this.kM.update();
            }
        }
    }

    class c extends LinearLayout implements OnLongClickListener {
        private View kK;
        private b kN;
        private TextView kO;
        private ImageView kP;
        private TextView kQ;
        private ImageView kR;
        private int kS = 2;

        static /* synthetic */ void a(c cVar, b bVar) {
            if (bVar != cVar.kN) {
                cVar.kN = bVar;
                cVar.update();
            }
        }

        public c(Context context) {
            super(context);
            if (TabLayout.this.km != 0) {
                setBackgroundDrawable(h.ez().a(context, TabLayout.this.km, false));
            }
            z.c(this, TabLayout.this.ke, TabLayout.this.kf, TabLayout.this.kg, TabLayout.this.kh);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.kN == null) {
                return performClick;
            }
            this.kN.select();
            return true;
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
                if (this.kO != null) {
                    this.kO.setSelected(z);
                }
                if (this.kP != null) {
                    this.kP.setSelected(z);
                }
            }
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int f = TabLayout.this.kn;
            if (f > 0 && (mode == 0 || size > f)) {
                i = MeasureSpec.makeMeasureSpec(TabLayout.this.kn, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.kO != null) {
                getResources();
                float h = TabLayout.this.kk;
                size = this.kS;
                if (this.kP != null && this.kP.getVisibility() == 0) {
                    size = 1;
                } else if (this.kO != null && this.kO.getLineCount() > 1) {
                    h = TabLayout.this.kl;
                }
                float textSize = this.kO.getTextSize();
                int lineCount = this.kO.getLineCount();
                int c = r.c(this.kO);
                if (h != textSize || (c >= 0 && size != c)) {
                    if (TabLayout.this.mMode == 1 && h > textSize && lineCount == 1) {
                        Layout layout = this.kO.getLayout();
                        if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.kO.setTextSize(0, h);
                        this.kO.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        final void update() {
            b bVar = this.kN;
            View view = bVar != null ? bVar.kK : null;
            if (view != null) {
                c parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(view);
                    }
                    addView(view);
                }
                this.kK = view;
                if (this.kO != null) {
                    this.kO.setVisibility(8);
                }
                if (this.kP != null) {
                    this.kP.setVisibility(8);
                    this.kP.setImageDrawable(null);
                }
                this.kQ = (TextView) view.findViewById(16908308);
                if (this.kQ != null) {
                    this.kS = r.c(this.kQ);
                }
                this.kR = (ImageView) view.findViewById(16908294);
            } else {
                if (this.kK != null) {
                    removeView(this.kK);
                    this.kK = null;
                }
                this.kQ = null;
                this.kR = null;
            }
            if (this.kK == null) {
                if (this.kP == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(f.bu, this, false);
                    addView(imageView, 0);
                    this.kP = imageView;
                }
                if (this.kO == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(f.bv, this, false);
                    addView(textView);
                    this.kO = textView;
                    this.kS = r.c(this.kO);
                }
                this.kO.setTextAppearance(getContext(), TabLayout.this.ki);
                if (TabLayout.this.kj != null) {
                    this.kO.setTextColor(TabLayout.this.kj);
                }
                a(this.kO, this.kP);
            } else if (this.kQ != null || this.kR != null) {
                a(this.kQ, this.kR);
            }
        }

        private void a(TextView textView, ImageView imageView) {
            CharSequence charSequence;
            CharSequence charSequence2;
            boolean z;
            Drawable drawable = this.kN != null ? this.kN.jY : null;
            if (this.kN != null) {
                charSequence = this.kN.mText;
            } else {
                charSequence = null;
            }
            if (this.kN != null) {
                charSequence2 = this.kN.kJ;
            } else {
                charSequence2 = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            if (TextUtils.isEmpty(charSequence)) {
                z = false;
            } else {
                z = true;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                int a;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    a = TabLayout.this.I(8);
                } else {
                    a = 0;
                }
                if (a != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(charSequence2)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public final boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.kN.kJ, 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kb = new ArrayList();
        this.kn = Integer.MAX_VALUE;
        this.ku = new android.support.v4.e.i.b(12);
        t.e(context);
        setHorizontalScrollBarEnabled(false);
        this.kd = new a(context);
        super.addView(this.kd, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.do, i, android.support.design.a.h.bM);
        View view = this.kd;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.dq, 0);
        if (view.kw != dimensionPixelSize) {
            view.kw = dimensionPixelSize;
            z.E(view);
        }
        view = this.kd;
        dimensionPixelSize = obtainStyledAttributes.getColor(i.dp, 0);
        if (view.kx.getColor() != dimensionPixelSize) {
            view.kx.setColor(dimensionPixelSize);
            z.E(view);
        }
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i.dE, 0);
        this.kh = dimensionPixelSize2;
        this.kg = dimensionPixelSize2;
        this.kf = dimensionPixelSize2;
        this.ke = dimensionPixelSize2;
        this.ke = obtainStyledAttributes.getDimensionPixelSize(i.dA, this.ke);
        this.kf = obtainStyledAttributes.getDimensionPixelSize(i.dB, this.kf);
        this.kg = obtainStyledAttributes.getDimensionPixelSize(i.dC, this.kg);
        this.kh = obtainStyledAttributes.getDimensionPixelSize(i.dD, this.kh);
        this.ki = obtainStyledAttributes.getResourceId(i.dx, android.support.design.a.h.bE);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.ki, i.TextAppearance);
        try {
            this.kk = (float) obtainStyledAttributes2.getDimensionPixelSize(i.TextAppearance_android_textSize, 0);
            this.kj = obtainStyledAttributes2.getColorStateList(i.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(i.dy)) {
                this.kj = obtainStyledAttributes.getColorStateList(i.dy);
            }
            if (obtainStyledAttributes.hasValue(i.dz)) {
                dimensionPixelSize2 = obtainStyledAttributes.getColor(i.dz, 0);
                dimensionPixelSize = this.kj.getDefaultColor();
                r4 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize2};
                r4[1] = EMPTY_STATE_SET;
                iArr[1] = dimensionPixelSize;
                this.kj = new ColorStateList(r4, iArr);
            }
            this.ko = obtainStyledAttributes.getDimensionPixelSize(i.dv, -1);
            this.kp = obtainStyledAttributes.getDimensionPixelSize(i.dw, -1);
            this.km = obtainStyledAttributes.getResourceId(i.ds, 0);
            this.kr = obtainStyledAttributes.getDimensionPixelSize(i.dr, 0);
            this.mMode = obtainStyledAttributes.getInt(i.dt, 1);
            this.ks = obtainStyledAttributes.getInt(i.du, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.kl = (float) resources.getDimensionPixelSize(d.bj);
            this.kq = resources.getDimensionPixelSize(d.bi);
            z.c(this.kd, this.mMode == 0 ? Math.max(0, this.kr - this.ke) : 0, 0, 0, 0);
            switch (this.mMode) {
                case 0:
                    this.kd.setGravity(8388611);
                    break;
                case 1:
                    this.kd.setGravity(1);
                    break;
            }
            l(true);
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private void H(int i) {
        int round = Math.round(((float) i) + 0.0f);
        if (round >= 0 && round < this.kd.getChildCount()) {
            a aVar = this.kd;
            if (aVar.kC != null && aVar.kC.ls.isRunning()) {
                aVar.kC.ls.cancel();
            }
            aVar.ky = i;
            aVar.kz = 0.0f;
            aVar.at();
            if (this.kt != null && this.kt.ls.isRunning()) {
                this.kt.ls.cancel();
            }
            scrollTo(b(i, 0.0f), 0);
            K(round);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return Math.max(0, ((this.kd.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) > 0;
    }

    private void a(b bVar, int i) {
        bVar.mPosition = i;
        this.kb.add(i, bVar);
        int size = this.kb.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((b) this.kb.get(i2)).mPosition = i2;
        }
    }

    public void addView(View view) {
        t(view);
    }

    public void addView(View view, int i) {
        t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    private void t(View view) {
        if (view instanceof TabItem) {
            b bVar;
            TabItem tabItem = (TabItem) view;
            b bVar2 = (b) ka.bH();
            if (bVar2 == null) {
                bVar = new b();
            } else {
                bVar = bVar2;
            }
            bVar.kL = this;
            c cVar = this.ku != null ? (c) this.ku.bH() : null;
            if (cVar == null) {
                cVar = new c(getContext());
            }
            c.a(cVar, bVar);
            cVar.setFocusable(true);
            cVar.setMinimumWidth(as());
            bVar.kM = cVar;
            if (tabItem.mText != null) {
                bVar.mText = tabItem.mText;
                bVar.av();
            }
            if (tabItem.jY != null) {
                bVar.jY = tabItem.jY;
                bVar.av();
            }
            if (tabItem.jZ != 0) {
                bVar.kK = LayoutInflater.from(bVar.kM.getContext()).inflate(tabItem.jZ, bVar.kM, false);
                bVar.av();
            }
            boolean isEmpty = this.kb.isEmpty();
            if (bVar.kL != this) {
                throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
            }
            View view2 = bVar.kM;
            a aVar = this.kd;
            LayoutParams layoutParams = new LayoutParams(-2, -1);
            a(layoutParams);
            aVar.addView(view2, layoutParams);
            if (isEmpty) {
                view2.setSelected(true);
            }
            a(bVar, this.kb.size());
            if (isEmpty) {
                bVar.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.ks == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int I(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 1;
        int size = this.kb.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.kb.get(i5);
            if (bVar != null && bVar.jY != null && !TextUtils.isEmpty(bVar.mText)) {
                i3 = 1;
                break;
            }
        }
        i3 = 0;
        i3 = (I(i3 != 0 ? 72 : 48) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(i3, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
                break;
        }
        i3 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.kp > 0) {
                i3 = this.kp;
            } else {
                i3 -= I(56);
            }
            this.kn = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        i3 = 0;
                        break;
                    } else {
                        i3 = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i4 = 0;
                    }
                    i3 = i4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void J(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && z.ai(this)) {
                int i2;
                a aVar = this.kd;
                int childCount = aVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (aVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = b(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.kt == null) {
                            this.kt = aa.az();
                            this.kt.setInterpolator(a.eB);
                            this.kt.setDuration(300);
                            this.kt.a(new c() {
                                public final void a(u uVar) {
                                    TabLayout.this.scrollTo(uVar.ls.aA(), 0);
                                }
                            });
                        }
                        this.kt.g(scrollX, i2);
                        this.kt.ls.start();
                    }
                    this.kd.f(i, 300);
                    return;
                }
            }
            H(i);
        }
    }

    private void K(int i) {
        int childCount = this.kd.getChildCount();
        if (i < childCount && !this.kd.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.kd.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    final void a(b bVar) {
        if (this.kc != bVar) {
            int i = bVar != null ? bVar.mPosition : -1;
            if (i != -1) {
                K(i);
            }
            if ((this.kc == null || this.kc.mPosition == -1) && i != -1) {
                H(i);
            } else {
                J(i);
            }
            this.kc = bVar;
        } else if (this.kc != null) {
            J(bVar.mPosition);
        }
    }

    private int b(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.kd.getChildAt(i);
        View childAt2 = i + 1 < this.kd.getChildCount() ? this.kd.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * 0.0f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void l(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kd.getChildCount()) {
                View childAt = this.kd.getChildAt(i2);
                childAt.setMinimumWidth(as());
                a((LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private int as() {
        if (this.ko != -1) {
            return this.ko;
        }
        return this.mMode == 0 ? this.kq : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }
}
