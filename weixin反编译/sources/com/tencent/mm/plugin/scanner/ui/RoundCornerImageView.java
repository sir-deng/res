package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;

public class RoundCornerImageView extends ImageView {
    private int qcx = 8;
    private int qcy = 8;

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fbi);
            this.qcx = obtainStyledAttributes.getDimensionPixelSize(R.n.fbj, this.qcx);
            this.qcy = obtainStyledAttributes.getDimensionPixelSize(R.n.fbk, this.qcy);
            obtainStyledAttributes.recycle();
            return;
        }
        float f = context.getResources().getDisplayMetrics().density;
        this.qcx = (int) (((float) this.qcx) * f);
        this.qcy = (int) (f * ((float) this.qcy));
    }

    public void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        if (createBitmap.isRecycled()) {
            createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
            canvas2 = new Canvas(createBitmap);
        }
        super.draw(canvas2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.qcx, (float) this.qcy, Direction.CW);
        path.setFillType(FillType.INVERSE_WINDING);
        canvas2.drawPath(path, paint);
        Paint paint2 = new Paint();
        paint2.setXfermode(null);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
        createBitmap.recycle();
    }
}
