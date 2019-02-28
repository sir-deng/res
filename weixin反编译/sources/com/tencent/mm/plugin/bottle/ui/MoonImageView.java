package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;

public class MoonImageView extends ImageView {
    ImageView kHa;
    private final int[] kIr = new int[]{0, R.g.bzI, R.g.bzJ, R.g.bzK, R.g.bzL, R.g.bzM, R.g.bzN, R.g.bzO};
    private final double[] kIs = new double[]{0.0d, 20.0d, 35.0d, 50.0d, 60.0d, 50.0d, 35.0d, 20.0d};

    public MoonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MoonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVisibility(int i) {
        int i2 = 2;
        int i3 = 0;
        f fVar = new f();
        if (fVar.kIo <= 2) {
            i2 = 0;
        } else if (fVar.kIo <= 6) {
            i2 = 1;
        } else if (fVar.kIo > 10) {
            i2 = fVar.kIo <= 14 ? 3 : fVar.kIo <= 17 ? 4 : fVar.kIo <= 21 ? 5 : fVar.kIo <= 26 ? 6 : 7;
        }
        setBackgroundResource(this.kIr[i2]);
        ImageView imageView = this.kHa;
        switch (i2) {
            case 0:
                i3 = 255;
                break;
            case 1:
                i3 = 170;
                break;
            case 2:
                i3 = 127;
                break;
            case 3:
                i3 = 85;
                break;
            case 4:
                break;
            case 5:
                i3 = 85;
                break;
            case 6:
                i3 = 127;
                break;
            default:
                i3 = 170;
                break;
        }
        imageView.setAlpha(i3);
        if (i2 > 0) {
            i3 = getContext().getResources().getDisplayMetrics().heightPixels / 8;
            double d = (this.kIs[i2] * 3.141592653589793d) / 180.0d;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
            marginLayoutParams.setMargins(i3 + ((int) ((1.0d - Math.cos(d)) * ((double) i3))), i3 + ((int) ((1.0d - Math.sin(d)) * ((double) i3))), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            setLayoutParams(marginLayoutParams);
        }
        this.kHa.setVisibility(i);
        super.setVisibility(i);
    }
}
