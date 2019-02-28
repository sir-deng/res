package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements android.support.v7.view.menu.m.a, android.support.v7.widget.ActionMenuView.a, OnClickListener, OnLongClickListener {
    public b KA;
    private boolean KB;
    private boolean KC;
    private int KD;
    private int KE;
    private int KF;
    public android.support.v7.view.menu.f.b Ky;
    private android.support.v7.widget.ListPopupWindow.b Kz;
    private h eb;
    private Drawable jY;
    private CharSequence uU;

    public static abstract class b {
        public abstract ListPopupWindow dq();
    }

    private class a extends android.support.v7.widget.ListPopupWindow.b {
        public a() {
            super(ActionMenuItemView.this);
        }

        public final ListPopupWindow dq() {
            if (ActionMenuItemView.this.KA != null) {
                return ActionMenuItemView.this.KA.dq();
            }
            return null;
        }

        protected final boolean dr() {
            if (ActionMenuItemView.this.Ky == null || !ActionMenuItemView.this.Ky.f(ActionMenuItemView.this.eb)) {
                return false;
            }
            ListPopupWindow dq = dq();
            if (dq == null || !dq.SK.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.KB = resources.getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionMenuItemView, i, 0);
        this.KD = obtainStyledAttributes.getDimensionPixelSize(k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.KF = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.KE = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.KB = getContext().getResources().getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        dn();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.KE = i;
        super.setPadding(i, i2, i3, i4);
    }

    public final h C() {
        return this.eb;
    }

    public final void a(h hVar) {
        this.eb = hVar;
        Drawable icon = hVar.getIcon();
        this.jY = icon;
        if (icon != null) {
            float f;
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            if (intrinsicWidth > this.KF) {
                f = ((float) this.KF) / ((float) intrinsicWidth);
                intrinsicWidth = this.KF;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.KF) {
                f = ((float) this.KF) / ((float) intrinsicHeight);
                intrinsicHeight = this.KF;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            icon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(icon, null, null, null);
        dn();
        this.uU = hVar.a((android.support.v7.view.menu.m.a) this);
        setContentDescription(this.uU);
        dn();
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.Kz == null) {
            this.Kz = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eb.hasSubMenu() && this.Kz != null && this.Kz.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.Ky != null) {
            this.Ky.f(this.eb);
        }
    }

    public final boolean D() {
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dn() {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r0 = r5.uU;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r5.jY;
        if (r3 == 0) goto L_0x0023;
    L_0x000f:
        r3 = r5.eb;
        r3 = r3.LF;
        r3 = r3 & 4;
        r4 = 4;
        if (r3 != r4) goto L_0x002f;
    L_0x0018:
        r3 = r1;
    L_0x0019:
        if (r3 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r5.KB;
        if (r3 != 0) goto L_0x0023;
    L_0x001f:
        r3 = r5.KC;
        if (r3 == 0) goto L_0x0024;
    L_0x0023:
        r2 = r1;
    L_0x0024:
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x0031;
    L_0x0027:
        r0 = r5.uU;
    L_0x0029:
        r5.setText(r0);
        return;
    L_0x002d:
        r0 = r2;
        goto L_0x000b;
    L_0x002f:
        r3 = r2;
        goto L_0x0019;
    L_0x0031:
        r0 = 0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.ActionMenuItemView.dn():void");
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean do() {
        return hasText() && this.eb.getIcon() == null;
    }

    public final boolean dp() {
        return hasText();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (z.I(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.eb.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.KE >= 0) {
            super.setPadding(this.KE, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.KD) : this.KD;
        if (mode != 1073741824 && this.KD > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!hasText && this.jY != null) {
            super.setPadding((getMeasuredWidth() - this.jY.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
