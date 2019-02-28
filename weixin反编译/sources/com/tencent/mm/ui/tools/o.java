package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements Runnable {
    public int mMode;
    public ListView phN;
    public long zvk = System.currentTimeMillis();
    public int zvl;
    public int zvm;
    public int zvn;
    private final int zvo;
    public int zvp;

    public o(ListView listView) {
        this.phN = listView;
        this.zvo = ViewConfiguration.get(this.phN.getContext()).getScaledFadingEdgeLength();
        x.d("ScrollerRunnable", "mExtraScroll: %d", Integer.valueOf(this.zvo));
    }

    public final void run() {
        if (System.currentTimeMillis() - this.zvk <= 10000) {
            int height = this.phN.getHeight();
            int firstVisiblePosition = this.phN.getFirstVisiblePosition();
            int childCount;
            switch (this.mMode) {
                case 1:
                    childCount = this.phN.getChildCount() - 1;
                    firstVisiblePosition += childCount;
                    if (childCount >= 0) {
                        if (firstVisiblePosition == this.zvm) {
                            if (this.zvp > 20) {
                                this.phN.setSelection(this.zvl);
                                x.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                            } else {
                                this.phN.post(this);
                                this.zvp++;
                                x.d("ScrollerRunnable", "dz:try scroll lastpos = %d", Integer.valueOf(firstVisiblePosition));
                                return;
                            }
                        }
                        this.zvp = 0;
                        View childAt = this.phN.getChildAt(childCount);
                        int height2 = childAt.getHeight();
                        childCount = height - childAt.getTop();
                        if (firstVisiblePosition < this.phN.getCount() - 1) {
                            height = this.zvo;
                        } else {
                            height = this.phN.getPaddingBottom();
                        }
                        this.phN.smoothScrollBy(height + (height2 - childCount), this.zvn);
                        this.zvm = firstVisiblePosition;
                        if (firstVisiblePosition < this.zvl) {
                            this.phN.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (firstVisiblePosition == this.zvm) {
                        if (this.zvp > 20) {
                            this.phN.setSelection(this.zvl);
                            x.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                        } else {
                            this.phN.post(this);
                            this.zvp++;
                            x.d("ScrollerRunnable", "dz:try scroll firstPos = %d", Integer.valueOf(firstVisiblePosition));
                            return;
                        }
                    }
                    this.zvp = 0;
                    View childAt2 = this.phN.getChildAt(0);
                    if (childAt2 != null) {
                        childCount = childAt2.getTop();
                        if (firstVisiblePosition > 0) {
                            height = this.zvo;
                        } else {
                            height = this.phN.getPaddingTop();
                        }
                        this.phN.smoothScrollBy(childCount - height, this.zvn);
                        this.zvm = firstVisiblePosition;
                        if (firstVisiblePosition > this.zvl) {
                            this.phN.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
