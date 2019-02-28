package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public abstract class BasePanelKeybordLayout extends KeyboardLinearLayout {
    private int vxW = -1;
    private a xMr = null;

    public interface a {
    }

    public abstract List<View> aYz();

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        x.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", Integer.valueOf(size), Integer.valueOf(size2));
        if (size2 >= 0) {
            if (this.vxW < 0) {
                this.vxW = size2;
            } else {
                int i3 = this.vxW - size2;
                this.vxW = size2;
                if (i3 != 0) {
                    for (View view : aYz()) {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        if (layoutParams == null) {
                            break;
                        }
                        int i4 = layoutParams.height < 0 ? 0 : layoutParams.height - i3;
                        if (i4 < 0) {
                            i4 = 0;
                        }
                        int c = j.c(ad.getContext(), true);
                        int aQ = j.aQ(getContext());
                        if (j.zs() > 0 && size2 >= j.zs()) {
                            i4 = aQ;
                        }
                        if (i4 > 0 && i4 < c && view.getVisibility() != 0) {
                            i4 = 0;
                        }
                        if (i4 > aQ) {
                            i4 = aQ;
                        }
                        if (i4 > 0 && i4 < aQ) {
                            i4 = aQ;
                        }
                        x.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", Integer.valueOf(layoutParams.height), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(aQ));
                        layoutParams.height = i4;
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
