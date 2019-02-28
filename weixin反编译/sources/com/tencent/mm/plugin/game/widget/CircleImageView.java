package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class CircleImageView extends ImageView {
    private static final Config hbK = Config.ARGB_8888;
    private static final ScaleType nDq = ScaleType.CENTER_CROP;
    private int hV;
    private boolean jcJ;
    private float jmu;
    private int jmv;
    private final Paint jmx;
    private Bitmap mBitmap;
    private ColorFilter mr;
    private final RectF nDr;
    private final RectF nDs;
    private final Paint nDt;
    private float nDu;
    private boolean nDv;
    private boolean nDw;
    private BitmapShader uh;
    private final Matrix uj;
    private int uo;
    private int uq;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDr = new RectF();
        this.nDs = new RectF();
        this.uj = new Matrix();
        this.nDt = new Paint();
        this.jmx = new Paint();
        this.jmv = WebView.NIGHT_MODE_COLOR;
        this.hV = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZQ, i, 0);
        this.hV = obtainStyledAttributes.getDimensionPixelSize(R.n.eZR, 0);
        this.jmv = obtainStyledAttributes.getColor(R.n.eZS, WebView.NIGHT_MODE_COLOR);
        this.nDw = obtainStyledAttributes.getBoolean(R.n.eZT, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(nDq);
        this.jcJ = true;
        if (this.nDv) {
            setup();
            this.nDv = false;
        }
    }

    public ScaleType getScaleType() {
        return nDq;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != nDq) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.nDu, this.nDt);
            if (this.hV != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.jmu, this.jmx);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = q(drawable);
        setup();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = q(getDrawable());
        setup();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.mBitmap = q(getDrawable());
        setup();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mr) {
            this.mr = colorFilter;
            this.nDt.setColorFilter(this.mr);
            invalidate();
        }
    }

    private static Bitmap q(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, hbK);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), hbK);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void setup() {
        float f = 0.0f;
        if (!this.jcJ) {
            this.nDv = true;
        } else if (this.mBitmap != null) {
            float height;
            float width;
            this.uh = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.nDt.setAntiAlias(true);
            this.nDt.setShader(this.uh);
            this.jmx.setStyle(Style.STROKE);
            this.jmx.setAntiAlias(true);
            this.jmx.setColor(this.jmv);
            this.jmx.setStrokeWidth((float) this.hV);
            this.uq = this.mBitmap.getHeight();
            this.uo = this.mBitmap.getWidth();
            this.nDs.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.jmu = Math.min((this.nDs.height() - ((float) this.hV)) / 2.0f, (this.nDs.width() - ((float) this.hV)) / 2.0f);
            this.nDr.set(this.nDs);
            if (!this.nDw) {
                this.nDr.inset((float) this.hV, (float) this.hV);
            }
            this.nDu = Math.min(this.nDr.height() / 2.0f, this.nDr.width() / 2.0f);
            this.uj.set(null);
            if (((float) this.uo) * this.nDr.height() > this.nDr.width() * ((float) this.uq)) {
                height = this.nDr.height() / ((float) this.uq);
                width = (this.nDr.width() - (((float) this.uo) * height)) * 0.5f;
            } else {
                height = this.nDr.width() / ((float) this.uo);
                width = 0.0f;
                f = (this.nDr.height() - (((float) this.uq) * height)) * 0.5f;
            }
            this.uj.setScale(height, height);
            this.uj.postTranslate(((float) ((int) (width + 0.5f))) + this.nDr.left, ((float) ((int) (f + 0.5f))) + this.nDr.top);
            this.uh.setLocalMatrix(this.uj);
            invalidate();
        }
    }
}
