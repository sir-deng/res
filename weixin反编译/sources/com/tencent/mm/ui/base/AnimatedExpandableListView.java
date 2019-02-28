package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;

public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = a.class.getSimpleName();
    private a yfY;

    private static class b extends View {
        int dividerHeight;
        Drawable xVR;
        List<View> ygf = new ArrayList();
        int ygg;

        public b(Context context) {
            super(context);
        }

        public final void di(View view) {
            view.layout(0, 0, getWidth(), getHeight());
            this.ygf.add(view);
        }

        protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int size = this.ygf.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.ygf.get(i5)).layout(i, i2, i3, i4);
            }
        }

        public final void dispatchDraw(Canvas canvas) {
            canvas.save();
            if (this.xVR != null) {
                this.xVR.setBounds(0, 0, this.ygg, this.dividerHeight);
            }
            int size = this.ygf.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.ygf.get(i);
                view.draw(canvas);
                canvas.translate(0.0f, (float) view.getMeasuredHeight());
                if (this.xVR != null) {
                    this.xVR.draw(canvas);
                    canvas.translate(0.0f, (float) this.dividerHeight);
                }
            }
            canvas.restore();
        }
    }

    private static class d {
        boolean naH;
        boolean ygk;
        int ygl;
        int ygm;

        private d() {
            this.naH = false;
            this.ygk = false;
            this.ygm = -1;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public static abstract class a extends BaseExpandableListAdapter {
        private SparseArray<d> yfZ = new SparseArray();
        private AnimatedExpandableListView yga;

        public abstract View d(int i, int i2, View view);

        public abstract int ya(int i);

        static /* synthetic */ void a(a aVar, int i) {
            d EG = aVar.EG(i);
            EG.naH = true;
            EG.ygl = 0;
            EG.ygk = true;
        }

        static /* synthetic */ void a(a aVar, int i, int i2) {
            d EG = aVar.EG(i);
            EG.naH = true;
            EG.ygl = i2;
            EG.ygk = false;
        }

        final d EG(int i) {
            d dVar = (d) this.yfZ.get(i);
            if (dVar != null) {
                return dVar;
            }
            dVar = new d();
            this.yfZ.put(i, dVar);
            return dVar;
        }

        public final int getChildType(int i, int i2) {
            if (EG(i).naH) {
                return 0;
            }
            return 1;
        }

        public final int getChildTypeCount() {
            return 2;
        }

        public final View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            d EG = EG(i);
            if (!EG.naH) {
                return d(i, i2, view);
            }
            View view2;
            if (view instanceof b) {
                view2 = view;
            } else {
                view2 = new b(viewGroup.getContext());
                view2.setLayoutParams(new LayoutParams(-1, 0));
            }
            if (i2 < EG.ygl) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            int i3;
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final b bVar = (b) view2;
            bVar.ygf.clear();
            Drawable divider = expandableListView.getDivider();
            int measuredWidth = viewGroup.getMeasuredWidth();
            int dividerHeight = expandableListView.getDividerHeight();
            if (divider != null) {
                bVar.xVR = divider;
                bVar.ygg = measuredWidth;
                bVar.dividerHeight = dividerHeight;
                divider.setBounds(0, 0, measuredWidth, dividerHeight);
            }
            measuredWidth = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            dividerHeight = 0;
            int height = viewGroup.getHeight();
            int ya = ya(i);
            for (i3 = EG.ygl; i3 < ya; i3++) {
                View d = d(i, i3, null);
                d.measure(measuredWidth, makeMeasureSpec);
                dividerHeight += d.getMeasuredHeight();
                if (dividerHeight >= height) {
                    bVar.di(d);
                    dividerHeight += ((ya - i3) - 1) * (dividerHeight / (i3 + 1));
                    break;
                }
                bVar.di(d);
            }
            Object tag = bVar.getTag();
            if (tag == null) {
                i3 = 0;
            } else {
                i3 = ((Integer) tag).intValue();
            }
            Animation cVar;
            if (EG.ygk && r2 != 1) {
                cVar = new c(bVar, 0, dividerHeight, EG, (byte) 0);
                150;
                cVar.setDuration(150);
                cVar.setAnimationListener(new AnimationListener() {
                    public final void onAnimationEnd(Animation animation) {
                        a.this.EG(i).naH = false;
                        a.this.notifyDataSetChanged();
                        bVar.setTag(Integer.valueOf(0));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(1));
                return view2;
            } else if (EG.ygk || r2 == 2) {
                return view2;
            } else {
                if (EG.ygm == -1) {
                    EG.ygm = dividerHeight;
                }
                cVar = new c(bVar, EG.ygm, 0, EG, (byte) 0);
                150;
                cVar.setDuration(150);
                ya = i;
                final d dVar = EG;
                final b bVar2 = bVar;
                cVar.setAnimationListener(new AnimationListener() {
                    public final void onAnimationEnd(Animation animation) {
                        a.this.EG(ya).naH = false;
                        expandableListView.collapseGroup(ya);
                        a.this.notifyDataSetChanged();
                        dVar.ygm = -1;
                        bVar2.setTag(Integer.valueOf(0));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(2));
                return view2;
            }
        }

        public final int getChildrenCount(int i) {
            d EG = EG(i);
            if (EG.naH) {
                return EG.ygl + 1;
            }
            return ya(i);
        }
    }

    private static class c extends Animation {
        private View view;
        private int ygh;
        private int ygi;
        private d ygj;

        /* synthetic */ c(View view, int i, int i2, d dVar, byte b) {
            this(view, i, i2, dVar);
        }

        private c(View view, int i, int i2, d dVar) {
            this.ygh = i;
            this.ygi = i2 - i;
            this.view = view;
            this.ygj = dVar;
            this.view.getLayoutParams().height = i;
            this.view.requestLayout();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            int i;
            if (f < 1.0f) {
                i = this.ygh + ((int) (((float) this.ygi) * f));
                this.view.getLayoutParams().height = i;
                this.ygj.ygm = i;
                this.view.requestLayout();
                return;
            }
            i = this.ygh + this.ygi;
            this.view.getLayoutParams().height = i;
            this.ygj.ygm = i;
            this.view.requestLayout();
        }
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof a) {
            this.yfY = (a) expandableListAdapter;
            this.yfY.yga = this;
            return;
        }
        throw new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
    }

    @SuppressLint({"NewApi"})
    public final boolean EE(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < getChildCount() && getChildAt(flatListPosition).getBottom() >= getBottom()) {
                this.yfY.EG(i).ygm = -1;
                return expandGroup(i);
            }
        }
        a.a(this.yfY, i);
        return expandGroup(i);
    }

    public final boolean EF(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < 0 || flatListPosition >= getChildCount()) {
                return collapseGroup(i);
            }
            if (getChildAt(flatListPosition).getBottom() >= getBottom()) {
                return collapseGroup(i);
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        flatListPosition = getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = getPackedPositionGroup(expandableListPosition);
        if (flatListPosition == -1 || packedPositionGroup != i) {
            flatListPosition = 0;
        }
        a.a(this.yfY, i, flatListPosition);
        this.yfY.notifyDataSetChanged();
        return isGroupExpanded(i);
    }
}
