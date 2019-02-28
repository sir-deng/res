package com.tencent.mm.ui.widget;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public final class b extends k implements OnGestureListener, OnTouchListener {
    private int iN;
    private int jxd;
    private int jxe;
    private int lKg;
    private GestureDetector xj;
    private int zAa = -1;
    private int zAb = -1;
    private int[] zAc = new int[2];
    private int zAd;
    private int zAe;
    private boolean zAf = false;
    private float zAg = 500.0f;
    private int zAh;
    private int zAi;
    private int zAj;
    private boolean zAk;
    private DragSortListView zAl;
    private int zAm;
    private OnGestureListener zAn = new SimpleOnGestureListener() {
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (b.this.zzW && b.this.zzX) {
                int width = b.this.zAl.getWidth() / 5;
                if (f > b.this.zAg) {
                    if (b.this.zAm > (-width)) {
                        b.this.zAl.aF(f);
                    }
                } else if (f < (-b.this.zAg) && b.this.zAm < width) {
                    b.this.zAl.aF(f);
                }
                b.this.zzX = false;
            }
            return false;
        }
    };
    private int zzU = 0;
    boolean zzV = true;
    boolean zzW = false;
    private boolean zzX = false;
    private GestureDetector zzY;
    private int zzZ = -1;

    public b(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.zAl = dragSortListView;
        this.xj = new GestureDetector(dragSortListView.getContext(), this);
        this.zzY = new GestureDetector(dragSortListView.getContext(), this.zAn);
        this.zzY.setIsLongpressEnabled(false);
        this.iN = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.zAh = i;
        this.zAi = i4;
        this.zAj = i5;
        this.lKg = i3;
        this.zzU = i2;
    }

    private boolean al(int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z = false;
        if (!this.zzV || this.zzX) {
            i4 = 0;
        } else {
            i4 = 12;
        }
        if (this.zzW && this.zzX) {
            i5 = (i4 | 1) | 2;
        } else {
            i5 = i4;
        }
        DragSortListView dragSortListView = this.zAl;
        int headerViewsCount = i - this.zAl.getHeaderViewsCount();
        if (dragSortListView.zBb && dragSortListView.zBc != null) {
            View Ho = dragSortListView.zBc.Ho(headerViewsCount);
            if (Ho != null) {
                z = dragSortListView.a(headerViewsCount, Ho, i5, i2, i3);
            }
        }
        this.zAf = z;
        return this.zAf;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zAl.zAH && !this.zAl.zBs) {
            this.xj.onTouchEvent(motionEvent);
            if (this.zzW && this.zAf && this.lKg == 1) {
                this.zzY.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.jxd = (int) motionEvent.getX();
                    this.jxe = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.zzW && this.zzX) {
                        int i;
                        if (this.zAm >= 0) {
                            i = this.zAm;
                        } else {
                            i = -this.zAm;
                        }
                        if (i > this.zAl.getWidth() / 2) {
                            this.zAl.aF(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
            }
            this.zzX = false;
            this.zAf = false;
        }
        return false;
    }

    public final void g(Point point) {
        if (this.zzW && this.zzX) {
            this.zAm = point.x;
        }
    }

    private int k(MotionEvent motionEvent, int i) {
        int pointToPosition = this.zAl.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.zAl.getHeaderViewsCount();
        int footerViewsCount = this.zAl.getFooterViewsCount();
        int count = this.zAl.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.zAl.getChildAt(pointToPosition - this.zAl.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.zAc);
                if (count > this.zAc[0] && rawY > this.zAc[1] && count < this.zAc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.zAc[1]) {
                        this.zAd = childAt.getLeft();
                        this.zAe = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i = -1;
        if (this.zzW && this.lKg == 0) {
            this.zAb = k(motionEvent, this.zAi);
        }
        this.zzZ = k(motionEvent, this.zAh);
        if (this.zzZ != -1 && this.zzU == 0) {
            al(this.zzZ, ((int) motionEvent.getX()) - this.zAd, ((int) motionEvent.getY()) - this.zAe);
        }
        this.zzX = false;
        this.zAk = true;
        this.zAm = 0;
        if (this.lKg == 1) {
            i = k(motionEvent, this.zAj);
        }
        this.zAa = i;
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.zAd;
        int i2 = y2 - this.zAe;
        if (!(!this.zAk || this.zAf || (this.zzZ == -1 && this.zAa == -1))) {
            if (this.zzZ != -1) {
                if (this.zzU == 1 && Math.abs(y2 - y) > this.iN && this.zzV) {
                    al(this.zzZ, i, i2);
                } else if (this.zzU != 0 && Math.abs(x2 - x) > this.iN && this.zzW) {
                    this.zzX = true;
                    al(this.zAa, i, i2);
                }
            } else if (this.zAa != -1) {
                if (Math.abs(x2 - x) > this.iN && this.zzW) {
                    this.zzX = true;
                    al(this.zAa, i, i2);
                } else if (Math.abs(y2 - y) > this.iN) {
                    this.zAk = false;
                }
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.zzZ != -1 && this.zzU == 2) {
            this.zAl.performHapticFeedback(0);
            al(this.zzZ, this.jxd - this.zAd, this.jxe - this.zAe);
        }
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.zzW && this.lKg == 0 && this.zAb != -1) {
            DragSortListView dragSortListView = this.zAl;
            int headerViewsCount = this.zAb - this.zAl.getHeaderViewsCount();
            dragSortListView.zBq = false;
            dragSortListView.k(headerViewsCount, 0.0f);
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
