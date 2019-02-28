package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.af.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class PickedBottleImageView extends ImageView {
    float density;
    private ag handler = new ag();
    String iconUrl;
    private Paint jbA = new Paint();
    String kGC;
    private int kGr;
    String kID;
    Bitmap kIW;
    private Rect kIX = new Rect();
    private RectF kIY = new RectF();
    private View kIZ;
    private Runnable kJa = new Runnable() {
        public final void run() {
            FrameLayout frameLayout = (FrameLayout) PickedBottleImageView.this.getParent();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) PickedBottleImageView.this.kIZ.getLayoutParams();
            if (frameLayout != null) {
                marginLayoutParams.setMargins(frameLayout.getWidth() / 2, (frameLayout.getHeight() * 530) / 800, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            PickedBottleImageView.this.kIZ.setLayoutParams(marginLayoutParams);
            PickedBottleImageView.this.kIZ.setVisibility(0);
            PickedBottleImageView.this.clearAnimation();
        }
    };

    public PickedBottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PickedBottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void show(int i) {
        this.kGr = i;
        if (i == 1) {
            setImageResource(R.g.bzT);
            setContentDescription(getContext().getString(R.l.dMZ));
            this.kIW = null;
        } else if (i == 3) {
            setImageResource(R.g.bzU);
            setContentDescription(getContext().getString(R.l.dMZ));
            this.kIW = null;
        } else if (i == 19990) {
            setImageResource(R.g.bzF);
            this.kIW = m.d(this.kGC, this.iconUrl, R.g.bEl);
            setContentDescription(getContext().getString(R.l.dMZ));
            this.jbA.setAntiAlias(true);
            update();
        } else {
            setImageResource(R.g.bzS);
            this.kIW = null;
            setContentDescription(getContext().getString(R.l.dNa));
        }
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (this.kIZ == null) {
            this.kIZ = ((View) getParent()).findViewById(R.h.bOw);
        }
        this.kIZ.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (frameLayout.getHeight() * 270) / 800);
        setLayoutParams(marginLayoutParams);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bpS));
        this.handler.postDelayed(this.kJa, 3000);
        setVisibility(0);
    }

    public void setVisibility(int i) {
        if (i == 8) {
            super.clearAnimation();
        }
        if (i == 8 && this.kIZ != null) {
            this.handler.removeCallbacks(this.kJa);
            this.kIZ.setVisibility(i);
        }
        super.setVisibility(i);
    }

    final void update() {
        boolean z = true;
        if (this.kIW == null || this.kIW.isRecycled()) {
            this.kIW = BitmapFactory.decodeResource(getResources(), R.g.bAa);
        }
        Bitmap bitmap = this.kIW;
        Matrix matrix = new Matrix();
        matrix.setRotate(-60.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        String str = "MicroMsg.PickedBottleImageView";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        x.d(str, stringBuilder.append(z).append("  degree:-60.0").toString());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        this.kIW = createBitmap;
        Rect rect = this.kIX;
        this.kIX.top = 0;
        rect.left = 0;
        this.kIX.right = this.kIW.getWidth();
        this.kIX.bottom = this.kIW.getHeight();
        this.kIY.left = 40.0f * this.density;
        this.kIY.top = 30.0f * this.density;
        this.kIY.right = 72.0f * this.density;
        this.kIY.bottom = 62.0f * this.density;
    }

    protected void onDraw(Canvas canvas) {
        if (!(19990 != this.kGr || this.kIW == null || this.kIW.isRecycled())) {
            canvas.drawBitmap(this.kIW, this.kIX, this.kIY, this.jbA);
        }
        super.onDraw(canvas);
    }
}
