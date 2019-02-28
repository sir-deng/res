package com.tencent.mm.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.DragSortListView.h;
import com.tencent.smtt.sdk.WebView;

public class k implements h {
    private ListView Fv;
    private ImageView lNZ;
    private Bitmap zFp;
    int zFq = WebView.NIGHT_MODE_COLOR;

    public k(ListView listView) {
        this.Fv = listView;
    }

    public final View Ho(int i) {
        View childAt = this.Fv.getChildAt((this.Fv.getHeaderViewsCount() + i) - this.Fv.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.zFp = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.lNZ == null) {
            this.lNZ = new ImageView(this.Fv.getContext());
        }
        this.lNZ.setBackgroundColor(this.zFq);
        this.lNZ.setPadding(0, 0, 0, 0);
        this.lNZ.setImageBitmap(this.zFp);
        this.lNZ.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.lNZ;
    }

    public void g(Point point) {
    }

    public final void dN(View view) {
        ((ImageView) view).setImageDrawable(null);
        x.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.zFp.toString());
        this.zFp.recycle();
        this.zFp = null;
    }
}
