package com.tencent.mm.ui.widget.celltextview.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.List;

public final class a {

    public interface a extends b<b> {
        void Hu(int i);

        void Hv(int i);

        void Hw(int i);

        void Hx(int i);

        void a(com.tencent.mm.ui.widget.celltextview.c.b bVar);

        void a(ArrayList<d> arrayList, CharSequence charSequence);

        List<com.tencent.mm.ui.widget.celltextview.c.b> cAb();

        String cAc();

        int getMaxLines();

        int getMeasuredHeight();

        int getMeasuredWidth();

        int getPaddingBottom();

        int getPaddingLeft();

        int getPaddingRight();

        int getPaddingTop();

        Paint getPaint();

        String getText();

        float getTextSize();

        void onDraw(Canvas canvas);

        void onMeasure(int i, int i2);

        void requestLayout();

        void setBackgroundDrawable(Drawable drawable);

        void setMaxHeight(int i);

        void setMaxWidth(int i);

        void setMinHeight(int i);

        void setMinWidth(int i);

        void setPadding(int i, int i2, int i3, int i4);

        void setTextColor(int i);

        void setTextSize(float f);
    }

    public interface b extends c<a> {
        View getView();
    }
}
