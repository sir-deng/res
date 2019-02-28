package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingImageBGView extends ImageView {
    private Bitmap mZu;
    private int yBe = 0;

    public ChattingImageBGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ScaleType.CENTER_CROP);
    }

    public ChattingImageBGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ScaleType.CENTER_CROP);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.yBe != i3 - i) {
            this.yBe = i3 - i;
            x.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            csv();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mZu = bitmap;
        super.setImageBitmap(bitmap);
        csv();
    }

    private void csv() {
        post(new Runnable() {
            public final void run() {
                if (ChattingImageBGView.this.mZu == null) {
                    x.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
                    return;
                }
                if (ChattingImageBGView.this.mZu.getWidth() == 0) {
                    x.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
                }
                Matrix matrix = new Matrix();
                float measuredWidth = ((float) ChattingImageBGView.this.getMeasuredWidth()) / ((float) ChattingImageBGView.this.mZu.getWidth());
                float measuredHeight = ((float) ChattingImageBGView.this.getMeasuredHeight()) / ((float) ChattingImageBGView.this.mZu.getHeight());
                x.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(ChattingImageBGView.this.getMeasuredWidth()), Integer.valueOf(ChattingImageBGView.this.getMeasuredHeight()));
                if (measuredWidth > measuredHeight) {
                    matrix.setScale(measuredWidth, measuredWidth);
                } else {
                    matrix.setScale(measuredHeight, measuredHeight);
                    matrix.postTranslate((((float) ChattingImageBGView.this.getMeasuredWidth()) - (((float) ChattingImageBGView.this.mZu.getWidth()) * measuredHeight)) / 2.0f, 0.0f);
                }
                ChattingImageBGView.this.setImageMatrix(matrix);
            }
        });
    }
}
