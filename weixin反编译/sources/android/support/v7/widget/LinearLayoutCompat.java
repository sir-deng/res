package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.sdk.WebView;

public class LinearLayoutCompat extends ViewGroup {
    boolean RQ;
    private int RR;
    private int RS;
    private int RT;
    private int RU;
    private float RV;
    private boolean RW;
    private int[] RX;
    private int[] RY;
    private Drawable RZ;
    int Sa;
    private int Sb;
    private int Sc;
    private int Sd;
    private int ug;

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return ef();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return c(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return d(layoutParams);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.RQ = true;
        this.RR = -1;
        this.RS = 0;
        this.ug = 8388659;
        ap a = ap.a(context, attributeSet, k.LinearLayoutCompat, i);
        int i2 = a.getInt(k.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        i2 = a.getInt(k.LinearLayoutCompat_android_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z2 = a.getBoolean(k.LinearLayoutCompat_android_baselineAligned, true);
        if (!z2) {
            this.RQ = z2;
        }
        this.RV = a.Zu.getFloat(k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.RR = a.getInt(k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.RW = a.getBoolean(k.LinearLayoutCompat_measureWithLargestChild, false);
        Drawable drawable = a.getDrawable(k.LinearLayoutCompat_divider);
        if (drawable != this.RZ) {
            this.RZ = drawable;
            if (drawable != null) {
                this.Sa = drawable.getIntrinsicWidth();
                this.Sb = drawable.getIntrinsicHeight();
            } else {
                this.Sa = 0;
                this.Sb = 0;
            }
            if (drawable != null) {
                z = false;
            }
            setWillNotDraw(z);
            requestLayout();
        }
        this.Sc = a.getInt(k.LinearLayoutCompat_showDividers, 0);
        this.Sd = a.getDimensionPixelSize(k.LinearLayoutCompat_dividerPadding, 0);
        a.Zu.recycle();
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected void onDraw(Canvas canvas) {
        if (this.RZ != null) {
            int childCount;
            int i;
            View childAt;
            if (this.RT == 1) {
                childCount = getChildCount();
                i = 0;
                while (i < childCount) {
                    View childAt2 = getChildAt(i);
                    if (!(childAt2 == null || childAt2.getVisibility() == 8 || !bb(i))) {
                        a(canvas, (childAt2.getTop() - ((LayoutParams) childAt2.getLayoutParams()).topMargin) - this.Sb);
                    }
                    i++;
                }
                if (bb(childCount)) {
                    childAt = getChildAt(childCount - 1);
                    a(canvas, childAt == null ? (getHeight() - getPaddingBottom()) - this.Sb : ((LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom());
                    return;
                }
                return;
            }
            LayoutParams layoutParams;
            childCount = getChildCount();
            boolean bv = at.bv(this);
            i = 0;
            while (i < childCount) {
                View childAt3 = getChildAt(i);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !bb(i))) {
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    b(canvas, bv ? layoutParams.rightMargin + childAt3.getRight() : (childAt3.getLeft() - layoutParams.leftMargin) - this.Sa);
                }
                i++;
            }
            if (bb(childCount)) {
                int paddingLeft;
                childAt = getChildAt(childCount - 1);
                if (childAt == null) {
                    paddingLeft = bv ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.Sa;
                } else {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    paddingLeft = bv ? (childAt.getLeft() - layoutParams.leftMargin) - this.Sa : layoutParams.rightMargin + childAt.getRight();
                }
                b(canvas, paddingLeft);
            }
        }
    }

    private void a(Canvas canvas, int i) {
        this.RZ.setBounds(getPaddingLeft() + this.Sd, i, (getWidth() - getPaddingRight()) - this.Sd, this.Sb + i);
        this.RZ.draw(canvas);
    }

    private void b(Canvas canvas, int i) {
        this.RZ.setBounds(i, getPaddingTop() + this.Sd, this.Sa + i, (getHeight() - getPaddingBottom()) - this.Sd);
        this.RZ.draw(canvas);
    }

    public int getBaseline() {
        if (this.RR < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.RR) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.RR);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.RS;
            if (this.RT == 1) {
                i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.RU) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.RU;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.RR == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.RT == 1) {
            int i3;
            int i4;
            int i5;
            int i6;
            int measuredWidth;
            int max;
            int i7;
            int i8;
            LayoutParams layoutParams;
            this.RU = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Object obj = 1;
            float f = 0.0f;
            int childCount = getChildCount();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            Object obj2 = null;
            Object obj3 = null;
            int i13 = this.RR;
            boolean z = this.RW;
            int i14 = Integer.MIN_VALUE;
            int i15 = 0;
            while (i15 < childCount) {
                View childAt = getChildAt(i15);
                if (childAt == null) {
                    this.RU += 0;
                    i3 = i15;
                } else {
                    Object obj4;
                    int combineMeasuredStates;
                    Object obj5;
                    float f2;
                    Object obj6;
                    if (childAt.getVisibility() != 8) {
                        Object obj7;
                        if (bb(i15)) {
                            this.RU += this.Sb;
                        }
                        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                        float f3 = f + layoutParams2.weight;
                        if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                            i3 = this.RU;
                            this.RU = Math.max(i3, (layoutParams2.topMargin + i3) + layoutParams2.bottomMargin);
                            i4 = i14;
                            obj7 = 1;
                        } else {
                            i3 = Integer.MIN_VALUE;
                            if (layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                                i3 = 0;
                                layoutParams2.height = -2;
                            }
                            int i16 = i3;
                            e(childAt, i, 0, i2, f3 == 0.0f ? this.RU : 0);
                            if (i16 != Integer.MIN_VALUE) {
                                layoutParams2.height = i16;
                            }
                            i3 = childAt.getMeasuredHeight();
                            i5 = this.RU;
                            this.RU = Math.max(i5, (((i5 + i3) + layoutParams2.topMargin) + layoutParams2.bottomMargin) + 0);
                            if (z) {
                                i4 = Math.max(i3, i14);
                                obj7 = obj3;
                            } else {
                                i4 = i14;
                                obj7 = obj3;
                            }
                        }
                        if (i13 >= 0 && i13 == i15 + 1) {
                            this.RS = this.RU;
                        }
                        if (i15 >= i13 || layoutParams2.weight <= 0.0f) {
                            Object obj8 = null;
                            if (mode == 1073741824 || layoutParams2.width != -1) {
                                obj4 = obj2;
                            } else {
                                obj4 = 1;
                                obj8 = 1;
                            }
                            i6 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            measuredWidth = childAt.getMeasuredWidth() + i6;
                            max = Math.max(i9, measuredWidth);
                            combineMeasuredStates = at.combineMeasuredStates(i10, z.M(childAt));
                            obj5 = (obj == null || layoutParams2.width != -1) ? null : 1;
                            if (layoutParams2.weight > 0.0f) {
                                i3 = obj8 != null ? i6 : measuredWidth;
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i11;
                                obj5 = obj7;
                                i14 = max;
                                int i17 = i4;
                                i4 = Math.max(i12, i3);
                                i3 = i17;
                            } else {
                                if (obj8 == null) {
                                    i6 = measuredWidth;
                                }
                                i3 = Math.max(i11, i6);
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i3;
                                obj5 = obj7;
                                i3 = i4;
                                i4 = i12;
                                i14 = max;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    i3 = i14;
                    obj5 = obj3;
                    f2 = f;
                    obj6 = obj;
                    i4 = i12;
                    i7 = i11;
                    obj4 = obj2;
                    i14 = i9;
                    combineMeasuredStates = i10;
                    obj = obj6;
                    i12 = i4;
                    i11 = i7;
                    i10 = combineMeasuredStates;
                    i9 = i14;
                    i14 = i3;
                    obj2 = obj4;
                    i3 = i15 + 0;
                    f = f2;
                    obj3 = obj5;
                }
                i15 = i3 + 1;
            }
            if (this.RU > 0 && bb(childCount)) {
                this.RU += this.Sb;
            }
            if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.RU = 0;
                i8 = 0;
                while (i8 < childCount) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2 == null) {
                        this.RU += 0;
                        i3 = i8;
                    } else if (childAt2.getVisibility() == 8) {
                        i3 = i8 + 0;
                    } else {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        i6 = this.RU;
                        this.RU = Math.max(i6, (layoutParams.bottomMargin + ((i6 + i14) + layoutParams.topMargin)) + 0);
                        i3 = i8;
                    }
                    i8 = i3 + 1;
                }
            }
            this.RU += getPaddingTop() + getPaddingBottom();
            i15 = z.resolveSizeAndState(Math.max(this.RU, getSuggestedMinimumHeight()), i2, 0);
            i6 = (16777215 & i15) - this.RU;
            int i18;
            if (obj3 != null || (i6 != 0 && f > 0.0f)) {
                if (this.RV > 0.0f) {
                    f = this.RV;
                }
                this.RU = 0;
                i12 = 0;
                obj3 = obj;
                i18 = i11;
                i14 = i10;
                int i19 = i9;
                while (i12 < childCount) {
                    float f4;
                    Object obj9;
                    View childAt3 = getChildAt(i12);
                    if (childAt3.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        float f5 = layoutParams.weight;
                        if (f5 > 0.0f) {
                            View view;
                            i8 = (int) ((((float) i6) * f5) / f);
                            f5 = f - f5;
                            i7 = i6 - i8;
                            i5 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width);
                            if (layoutParams.height != 0 || mode2 != 1073741824) {
                                i8 += childAt3.getMeasuredHeight();
                                if (i8 < 0) {
                                    i8 = 0;
                                }
                                view = childAt3;
                            } else if (i8 > 0) {
                                view = childAt3;
                            } else {
                                i8 = 0;
                                view = childAt3;
                            }
                            view.measure(i5, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                            i5 = i7;
                            i6 = at.combineMeasuredStates(i14, z.M(childAt3) & -256);
                            f4 = f5;
                        } else {
                            f4 = f;
                            i5 = i6;
                            i6 = i14;
                        }
                        i4 = layoutParams.leftMargin + layoutParams.rightMargin;
                        i7 = childAt3.getMeasuredWidth() + i4;
                        i14 = Math.max(i19, i7);
                        obj = (mode == 1073741824 || layoutParams.width != -1) ? null : 1;
                        if (obj == null) {
                            i4 = i7;
                        }
                        i7 = Math.max(i18, i4);
                        obj9 = (obj3 == null || layoutParams.width != -1) ? null : 1;
                        max = this.RU;
                        this.RU = Math.max(max, (layoutParams.bottomMargin + ((childAt3.getMeasuredHeight() + max) + layoutParams.topMargin)) + 0);
                        i3 = i7;
                    } else {
                        f4 = f;
                        obj9 = obj3;
                        i3 = i18;
                        measuredWidth = i19;
                        i5 = i6;
                    }
                    measuredWidth = i14;
                    i12++;
                    obj3 = obj9;
                    i18 = i3;
                    i14 = i6;
                    i19 = measuredWidth;
                    i6 = i5;
                    f = f4;
                }
                this.RU += getPaddingTop() + getPaddingBottom();
                i3 = i18;
                i10 = i14;
                i8 = i19;
                obj = obj3;
            } else {
                i18 = Math.max(i11, i12);
                if (z && mode2 != 1073741824) {
                    i3 = 0;
                    while (true) {
                        i8 = i3;
                        if (i8 >= childCount) {
                            break;
                        }
                        View childAt4 = getChildAt(i8);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= 0.0f)) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i14, 1073741824));
                        }
                        i3 = i8 + 1;
                    }
                }
                i3 = i18;
                i8 = i9;
            }
            if (obj != null || mode == 1073741824) {
                i3 = i8;
            }
            setMeasuredDimension(z.resolveSizeAndState(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), i15);
            if (obj2 != null) {
                J(childCount, i2);
                return;
            }
            return;
        }
        K(i, i2);
    }

    private boolean bb(int i) {
        if (i == 0) {
            if ((this.Sc & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.Sc & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.Sc & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    private void J(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void K(int i, int i2) {
        Object obj;
        View childAt;
        int i3;
        LayoutParams layoutParams;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        int measuredHeight;
        int combineMeasuredStates;
        int baseline;
        int i7;
        Object obj4;
        int i8;
        LayoutParams layoutParams2;
        this.RU = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Object obj5 = 1;
        float f = 0.0f;
        int childCount = getChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj6 = null;
        Object obj7 = null;
        if (this.RX == null || this.RY == null) {
            this.RX = new int[4];
            this.RY = new int[4];
        }
        int[] iArr = this.RX;
        int[] iArr2 = this.RY;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.RQ;
        boolean z2 = this.RW;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i13 = Integer.MIN_VALUE;
        int i14 = 0;
        while (i14 < childCount) {
            childAt = getChildAt(i14);
            if (childAt == null) {
                this.RU += 0;
                i3 = i14;
            } else {
                float f2;
                Object obj8;
                if (childAt.getVisibility() != 8) {
                    if (bb(i14)) {
                        this.RU += this.Sa;
                    }
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    float f3 = f + layoutParams.weight;
                    if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        if (obj != null) {
                            this.RU += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            i3 = this.RU;
                            this.RU = Math.max(i3, (layoutParams.leftMargin + i3) + layoutParams.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(i3, i3);
                            i4 = i13;
                            obj2 = obj7;
                        } else {
                            i4 = i13;
                            i13 = 1;
                        }
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                            i3 = 0;
                            layoutParams.width = -2;
                        }
                        int i15 = i3;
                        e(childAt, i, f3 == 0.0f ? this.RU : 0, i2, 0);
                        if (i15 != Integer.MIN_VALUE) {
                            layoutParams.width = i15;
                        }
                        i3 = childAt.getMeasuredWidth();
                        if (obj != null) {
                            this.RU += ((layoutParams.leftMargin + i3) + layoutParams.rightMargin) + 0;
                        } else {
                            i5 = this.RU;
                            this.RU = Math.max(i5, (((i5 + i3) + layoutParams.leftMargin) + layoutParams.rightMargin) + 0);
                        }
                        if (z2) {
                            i4 = Math.max(i3, i13);
                            obj2 = obj7;
                        } else {
                            i4 = i13;
                            obj2 = obj7;
                        }
                    }
                    Object obj9 = null;
                    if (mode2 == 1073741824 || layoutParams.height != -1) {
                        obj3 = obj6;
                    } else {
                        obj3 = 1;
                        obj9 = 1;
                    }
                    i6 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = childAt.getMeasuredHeight() + i6;
                    combineMeasuredStates = at.combineMeasuredStates(i10, z.M(childAt));
                    if (z) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            i7 = ((((layoutParams.gravity < 0 ? this.ug : layoutParams.gravity) & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) >> 4) & -2) >> 1;
                            iArr[i7] = Math.max(iArr[i7], baseline);
                            iArr2[i7] = Math.max(iArr2[i7], measuredHeight - baseline);
                        }
                    }
                    baseline = Math.max(i9, measuredHeight);
                    obj4 = (obj5 == null || layoutParams.height != -1) ? null : 1;
                    if (layoutParams.weight > 0.0f) {
                        if (obj9 != null) {
                            i3 = i6;
                        } else {
                            i3 = measuredHeight;
                        }
                        f2 = f3;
                        obj8 = obj4;
                        i8 = i11;
                        obj4 = obj2;
                        i13 = baseline;
                        int i16 = i4;
                        i4 = Math.max(i12, i3);
                        i3 = i16;
                    } else {
                        if (obj9 == null) {
                            i6 = measuredHeight;
                        }
                        i3 = Math.max(i11, i6);
                        f2 = f3;
                        obj8 = obj4;
                        i8 = i3;
                        obj4 = obj2;
                        i3 = i4;
                        i4 = i12;
                        i13 = baseline;
                    }
                } else {
                    i3 = i13;
                    obj4 = obj7;
                    f2 = f;
                    obj8 = obj5;
                    i4 = i12;
                    i8 = i11;
                    obj3 = obj6;
                    i13 = i9;
                    combineMeasuredStates = i10;
                }
                obj5 = obj8;
                i12 = i4;
                i11 = i8;
                i10 = combineMeasuredStates;
                i9 = i13;
                i13 = i3;
                obj6 = obj3;
                i3 = i14 + 0;
                f = f2;
                obj7 = obj4;
            }
            i14 = i3 + 1;
        }
        if (this.RU > 0 && bb(childCount)) {
            this.RU += this.Sa;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i6 = i9;
        } else {
            i6 = Math.max(i9, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.RU = 0;
            i7 = 0;
            while (i7 < childCount) {
                View childAt2 = getChildAt(i7);
                if (childAt2 == null) {
                    this.RU += 0;
                    i3 = i7;
                } else if (childAt2.getVisibility() == 8) {
                    i3 = i7 + 0;
                } else {
                    layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (obj != null) {
                        this.RU = ((layoutParams2.rightMargin + (layoutParams2.leftMargin + i13)) + 0) + this.RU;
                        i3 = i7;
                    } else {
                        measuredHeight = this.RU;
                        this.RU = Math.max(measuredHeight, (layoutParams2.rightMargin + ((measuredHeight + i13) + layoutParams2.leftMargin)) + 0);
                        i3 = i7;
                    }
                }
                i7 = i3 + 1;
            }
        }
        this.RU += getPaddingLeft() + getPaddingRight();
        i9 = z.resolveSizeAndState(Math.max(this.RU, getSuggestedMinimumWidth()), i, 0);
        measuredHeight = (16777215 & i9) - this.RU;
        View view;
        if (obj7 != null || (measuredHeight != 0 && f > 0.0f)) {
            if (this.RV > 0.0f) {
                f = this.RV;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.RU = 0;
            i12 = 0;
            obj2 = obj5;
            baseline = i11;
            int i17 = -1;
            i4 = i10;
            while (i12 < childCount) {
                float f4;
                View childAt3 = getChildAt(i12);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f4 = f;
                    i7 = measuredHeight;
                    i6 = baseline;
                    obj3 = obj2;
                    measuredHeight = i4;
                    i4 = i17;
                } else {
                    int childMeasureSpec;
                    float f5;
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    float f6 = layoutParams2.weight;
                    if (f6 > 0.0f) {
                        i7 = (int) ((((float) measuredHeight) * f6) / f);
                        f6 = f - f6;
                        measuredHeight -= i7;
                        childMeasureSpec = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin, layoutParams2.height);
                        if (layoutParams2.width != 0 || mode != 1073741824) {
                            i7 += childAt3.getMeasuredWidth();
                            if (i7 < 0) {
                                i7 = 0;
                            }
                            view = childAt3;
                        } else if (i7 > 0) {
                            view = childAt3;
                        } else {
                            i7 = 0;
                            view = childAt3;
                        }
                        view.measure(MeasureSpec.makeMeasureSpec(i7, 1073741824), childMeasureSpec);
                        childMeasureSpec = at.combineMeasuredStates(i4, z.M(childAt3) & WebView.NIGHT_MODE_COLOR);
                        f5 = f6;
                        i8 = measuredHeight;
                    } else {
                        i8 = measuredHeight;
                        childMeasureSpec = i4;
                        f5 = f;
                    }
                    if (obj != null) {
                        this.RU += ((childAt3.getMeasuredWidth() + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0;
                    } else {
                        i7 = this.RU;
                        this.RU = Math.max(i7, (((childAt3.getMeasuredWidth() + i7) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0);
                    }
                    obj4 = (mode2 == 1073741824 || layoutParams2.height != -1) ? null : 1;
                    i5 = layoutParams2.topMargin + layoutParams2.bottomMargin;
                    measuredHeight = childAt3.getMeasuredHeight() + i5;
                    i17 = Math.max(i17, measuredHeight);
                    if (obj4 != null) {
                        i7 = i5;
                    } else {
                        i7 = measuredHeight;
                    }
                    i5 = Math.max(baseline, i7);
                    obj4 = (obj2 == null || layoutParams2.height != -1) ? null : 1;
                    if (z) {
                        i6 = childAt3.getBaseline();
                        if (i6 != -1) {
                            i3 = ((((layoutParams2.gravity < 0 ? this.ug : layoutParams2.gravity) & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i6);
                            iArr2[i3] = Math.max(iArr2[i3], measuredHeight - i6);
                        }
                    }
                    f4 = f5;
                    i6 = i5;
                    measuredHeight = childMeasureSpec;
                    obj3 = obj4;
                    i4 = i17;
                    i7 = i8;
                }
                i12++;
                obj2 = obj3;
                baseline = i6;
                i17 = i4;
                i4 = measuredHeight;
                f = f4;
                measuredHeight = i7;
            }
            this.RU += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i17 = Math.max(i17, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            i3 = baseline;
            i10 = i4;
            i7 = i17;
            obj5 = obj2;
        } else {
            baseline = Math.max(i11, i12);
            if (z2 && mode != 1073741824) {
                i3 = 0;
                while (true) {
                    i7 = i3;
                    if (i7 >= childCount) {
                        break;
                    }
                    view = getChildAt(i7);
                    if (!(view == null || view.getVisibility() == 8 || ((LayoutParams) view.getLayoutParams()).weight <= 0.0f)) {
                        view.measure(MeasureSpec.makeMeasureSpec(i13, 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
                    }
                    i3 = i7 + 1;
                }
            }
            i3 = baseline;
            i7 = i6;
        }
        if (obj5 != null || mode2 == 1073741824) {
            i3 = i7;
        }
        setMeasuredDimension((WebView.NIGHT_MODE_COLOR & i10) | i9, z.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i10 << 16));
        if (obj6 != null) {
            measuredHeight = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            i3 = 0;
            while (true) {
                int i18 = i3;
                if (i18 < childCount) {
                    childAt = getChildAt(i18);
                    if (childAt.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                        if (layoutParams.height == -1) {
                            combineMeasuredStates = layoutParams.width;
                            layoutParams.width = childAt.getMeasuredWidth();
                            measureChildWithMargins(childAt, i, 0, measuredHeight, 0);
                            layoutParams.width = combineMeasuredStates;
                        }
                    }
                    i3 = i18 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void e(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
        r23 = this;
        r0 = r23;
        r3 = r0.RT;
        r4 = 1;
        if (r3 != r4) goto L_0x00bd;
    L_0x0007:
        r8 = r23.getPaddingLeft();
        r3 = r27 - r25;
        r4 = r23.getPaddingRight();
        r9 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingRight();
        r10 = r3 - r4;
        r11 = r23.getChildCount();
        r0 = r23;
        r3 = r0.ug;
        r3 = r3 & 112;
        r0 = r23;
        r4 = r0.ug;
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r5 = r5 & r4;
        switch(r3) {
            case 16: goto L_0x0053;
            case 80: goto L_0x0045;
            default: goto L_0x002f;
        };
    L_0x002f:
        r3 = r23.getPaddingTop();
    L_0x0033:
        r7 = 0;
        r6 = r3;
    L_0x0035:
        if (r7 >= r11) goto L_0x01d6;
    L_0x0037:
        r0 = r23;
        r12 = r0.getChildAt(r7);
        if (r12 != 0) goto L_0x0062;
    L_0x003f:
        r6 = r6 + 0;
        r3 = r7;
    L_0x0042:
        r7 = r3 + 1;
        goto L_0x0035;
    L_0x0045:
        r3 = r23.getPaddingTop();
        r3 = r3 + r28;
        r3 = r3 - r26;
        r0 = r23;
        r4 = r0.RU;
        r3 = r3 - r4;
        goto L_0x0033;
    L_0x0053:
        r3 = r23.getPaddingTop();
        r4 = r28 - r26;
        r0 = r23;
        r6 = r0.RU;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r3 = r3 + r4;
        goto L_0x0033;
    L_0x0062:
        r3 = r12.getVisibility();
        r4 = 8;
        if (r3 == r4) goto L_0x01e2;
    L_0x006a:
        r13 = r12.getMeasuredWidth();
        r14 = r12.getMeasuredHeight();
        r3 = r12.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        r4 = r3.gravity;
        if (r4 >= 0) goto L_0x007d;
    L_0x007c:
        r4 = r5;
    L_0x007d:
        r15 = android.support.v4.view.z.I(r23);
        r4 = android.support.v4.view.f.getAbsoluteGravity(r4, r15);
        r4 = r4 & 7;
        switch(r4) {
            case 1: goto L_0x00ab;
            case 5: goto L_0x00b7;
            default: goto L_0x008a;
        };
    L_0x008a:
        r4 = r3.leftMargin;
        r4 = r4 + r8;
    L_0x008d:
        r0 = r23;
        r15 = r0.bb(r7);
        if (r15 == 0) goto L_0x009a;
    L_0x0095:
        r0 = r23;
        r15 = r0.Sb;
        r6 = r6 + r15;
    L_0x009a:
        r15 = r3.topMargin;
        r6 = r6 + r15;
        r15 = r6 + 0;
        f(r12, r4, r15, r13, r14);
        r3 = r3.bottomMargin;
        r3 = r3 + r14;
        r3 = r3 + 0;
        r6 = r6 + r3;
        r3 = r7 + 0;
        goto L_0x0042;
    L_0x00ab:
        r4 = r10 - r13;
        r4 = r4 / 2;
        r4 = r4 + r8;
        r15 = r3.leftMargin;
        r4 = r4 + r15;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00b7:
        r4 = r9 - r13;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00bd:
        r5 = android.support.v7.widget.at.bv(r23);
        r8 = r23.getPaddingTop();
        r3 = r28 - r26;
        r4 = r23.getPaddingBottom();
        r12 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingBottom();
        r13 = r3 - r4;
        r14 = r23.getChildCount();
        r0 = r23;
        r3 = r0.ug;
        r4 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r3 = r3 & r4;
        r0 = r23;
        r4 = r0.ug;
        r11 = r4 & 112;
        r0 = r23;
        r15 = r0.RQ;
        r0 = r23;
        r0 = r0.RX;
        r16 = r0;
        r0 = r23;
        r0 = r0.RY;
        r17 = r0;
        r4 = android.support.v4.view.z.I(r23);
        r3 = android.support.v4.view.f.getAbsoluteGravity(r3, r4);
        switch(r3) {
            case 1: goto L_0x0134;
            case 5: goto L_0x0125;
            default: goto L_0x0101;
        };
    L_0x0101:
        r9 = r23.getPaddingLeft();
    L_0x0105:
        r4 = 0;
        r3 = 1;
        if (r5 == 0) goto L_0x01de;
    L_0x0109:
        r4 = r14 + -1;
        r3 = -1;
        r5 = r4;
        r4 = r3;
    L_0x010e:
        r10 = 0;
    L_0x010f:
        if (r10 >= r14) goto L_0x01d6;
    L_0x0111:
        r3 = r4 * r10;
        r18 = r5 + r3;
        r0 = r23;
        r1 = r18;
        r19 = r0.getChildAt(r1);
        if (r19 != 0) goto L_0x0144;
    L_0x011f:
        r9 = r9 + 0;
        r3 = r10;
    L_0x0122:
        r10 = r3 + 1;
        goto L_0x010f;
    L_0x0125:
        r3 = r23.getPaddingLeft();
        r3 = r3 + r27;
        r3 = r3 - r25;
        r0 = r23;
        r4 = r0.RU;
        r9 = r3 - r4;
        goto L_0x0105;
    L_0x0134:
        r3 = r23.getPaddingLeft();
        r4 = r27 - r25;
        r0 = r23;
        r6 = r0.RU;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r9 = r3 + r4;
        goto L_0x0105;
    L_0x0144:
        r3 = r19.getVisibility();
        r6 = 8;
        if (r3 == r6) goto L_0x01db;
    L_0x014c:
        r20 = r19.getMeasuredWidth();
        r21 = r19.getMeasuredHeight();
        r6 = -1;
        r3 = r19.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        if (r15 == 0) goto L_0x0169;
    L_0x015d:
        r7 = r3.height;
        r22 = -1;
        r0 = r22;
        if (r7 == r0) goto L_0x0169;
    L_0x0165:
        r6 = r19.getBaseline();
    L_0x0169:
        r7 = r3.gravity;
        if (r7 >= 0) goto L_0x016e;
    L_0x016d:
        r7 = r11;
    L_0x016e:
        r7 = r7 & 112;
        switch(r7) {
            case 16: goto L_0x01ad;
            case 48: goto L_0x019c;
            case 80: goto L_0x01b9;
            default: goto L_0x0173;
        };
    L_0x0173:
        r6 = r8;
    L_0x0174:
        r0 = r23;
        r1 = r18;
        r7 = r0.bb(r1);
        if (r7 == 0) goto L_0x01d7;
    L_0x017e:
        r0 = r23;
        r7 = r0.Sa;
        r7 = r7 + r9;
    L_0x0183:
        r9 = r3.leftMargin;
        r7 = r7 + r9;
        r9 = r7 + 0;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        f(r0, r9, r6, r1, r2);
        r3 = r3.rightMargin;
        r3 = r3 + r20;
        r3 = r3 + 0;
        r9 = r7 + r3;
        r3 = r10 + 0;
        goto L_0x0122;
    L_0x019c:
        r7 = r3.topMargin;
        r7 = r7 + r8;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d9;
    L_0x01a5:
        r22 = 1;
        r22 = r16[r22];
        r6 = r22 - r6;
        r6 = r6 + r7;
        goto L_0x0174;
    L_0x01ad:
        r6 = r13 - r21;
        r6 = r6 / 2;
        r6 = r6 + r8;
        r7 = r3.topMargin;
        r6 = r6 + r7;
        r7 = r3.bottomMargin;
        r6 = r6 - r7;
        goto L_0x0174;
    L_0x01b9:
        r7 = r12 - r21;
        r0 = r3.bottomMargin;
        r22 = r0;
        r7 = r7 - r22;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d9;
    L_0x01c7:
        r22 = r19.getMeasuredHeight();
        r6 = r22 - r6;
        r22 = 2;
        r22 = r17[r22];
        r6 = r22 - r6;
        r6 = r7 - r6;
        goto L_0x0174;
    L_0x01d6:
        return;
    L_0x01d7:
        r7 = r9;
        goto L_0x0183;
    L_0x01d9:
        r6 = r7;
        goto L_0x0174;
    L_0x01db:
        r3 = r10;
        goto L_0x0122;
    L_0x01de:
        r5 = r4;
        r4 = r3;
        goto L_0x010e;
    L_0x01e2:
        r3 = r7;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    private static void f(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public final void setOrientation(int i) {
        if (this.RT != i) {
            this.RT = i;
            requestLayout();
        }
    }

    public final void setGravity(int i) {
        if (this.ug != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                i2 |= 48;
            }
            this.ug = i2;
            requestLayout();
        }
    }

    public LayoutParams c(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams ef() {
        if (this.RT == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.RT == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    protected LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
