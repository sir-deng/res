package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class AppBrandSmileyViewPager extends CustomViewPager {
    private int kgV = 0;
    private int kgW = 0;
    b kgX;
    c kgy;

    public interface b {
        void aod();
    }

    static class a extends u {
        SparseArray<SoftReference<View>> kgY = new SparseArray();
        private boolean kgZ = false;
        c kgy;

        a() {
        }

        public final int k(Object obj) {
            if (this.kgZ) {
                return -2;
            }
            return super.k(obj);
        }

        public final void notifyDataSetChanged() {
            this.kgZ = true;
            super.notifyDataSetChanged();
            this.kgZ = false;
        }

        public final int getCount() {
            return this.kgy.aog().getPageCount();
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = null;
            if (this.kgY.get(i) != null) {
                view = (View) ((SoftReference) this.kgY.get(i)).get();
            }
            if (view == null) {
                Object mB = this.kgy.aog().mB(i);
                if (mB != null) {
                    viewGroup.addView(mB, 0);
                    this.kgY.put(i, new SoftReference(mB));
                    return mB;
                }
                x.e("MicroMsg.AppBrandSmileyViewPagerAdapter", "contentView == null!");
                return mB;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            return view;
        }
    }

    public AppBrandSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.kgy != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kgV) || (i > 0 && i != this.kgW)))) {
            this.kgy.kgS = i2;
            this.kgy.kgT = i;
            if (this.kgX != null) {
                this.kgX.aod();
            }
        }
        if (i2 > 0) {
            this.kgV = i2;
        }
        if (i > 0) {
            this.kgW = i;
        }
    }
}
