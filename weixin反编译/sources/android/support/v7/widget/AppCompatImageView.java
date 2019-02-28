package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements x {
    private f Pd;
    private i ib;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(am.r(context), attributeSet, i);
        h ez = h.ez();
        this.Pd = new f(this, ez);
        this.Pd.b(attributeSet, i);
        this.ib = new i(this, ez);
        this.ib.b(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.ib.setImageResource(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Pd != null) {
            this.Pd.aR(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Pd != null) {
            this.Pd.f(null);
        }
    }

    public final void d(ColorStateList colorStateList) {
        if (this.Pd != null) {
            this.Pd.d(colorStateList);
        }
    }

    public final ColorStateList bN() {
        return this.Pd != null ? this.Pd.bN() : null;
    }

    public final void a(Mode mode) {
        if (this.Pd != null) {
            this.Pd.a(mode);
        }
    }

    public final Mode bO() {
        return this.Pd != null ? this.Pd.bO() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Pd != null) {
            this.Pd.ew();
        }
    }
}
