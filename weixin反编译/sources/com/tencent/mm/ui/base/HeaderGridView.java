package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView {
    public ArrayList<a> ygu = new ArrayList();

    private static class a {
        public Object data;
        public boolean isSelectable;
        public View view;
        public ViewGroup ygv;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), 1073741824), i2);
        }
    }

    private static class c implements Filterable, WrapperListAdapter {
        private final ListAdapter FP;
        public final DataSetObservable mDataSetObservable = new DataSetObservable();
        int mNumColumns = 1;
        ArrayList<a> ygu;
        boolean ygx;
        private final boolean ygy;

        public c(ArrayList<a> arrayList, ListAdapter listAdapter) {
            this.FP = listAdapter;
            this.ygy = listAdapter instanceof Filterable;
            if (arrayList == null) {
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            }
            this.ygu = arrayList;
            this.ygx = ai(this.ygu);
        }

        public final boolean isEmpty() {
            return (this.FP == null || this.FP.isEmpty()) && this.ygu.size() == 0;
        }

        private static boolean ai(ArrayList<a> arrayList) {
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((a) it.next()).isSelectable) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final int getCount() {
            if (this.FP != null) {
                return (this.ygu.size() * this.mNumColumns) + this.FP.getCount();
            }
            return this.ygu.size() * this.mNumColumns;
        }

        public final boolean areAllItemsEnabled() {
            if (this.FP == null) {
                return true;
            }
            if (this.ygx && this.FP.areAllItemsEnabled()) {
                return true;
            }
            return false;
        }

        public final boolean isEnabled(int i) {
            int size = this.ygu.size() * this.mNumColumns;
            if (i >= size) {
                size = i - size;
                return (this.FP == null || size >= this.FP.getCount()) ? false : this.FP.isEnabled(size);
            } else if (i % this.mNumColumns == 0 && ((a) this.ygu.get(i / this.mNumColumns)).isSelectable) {
                return true;
            } else {
                return false;
            }
        }

        public final Object getItem(int i) {
            int size = this.ygu.size() * this.mNumColumns;
            if (i >= size) {
                size = i - size;
                if (this.FP == null || size >= this.FP.getCount()) {
                    return null;
                }
                return this.FP.getItem(size);
            } else if (i % this.mNumColumns == 0) {
                return ((a) this.ygu.get(i / this.mNumColumns)).data;
            } else {
                return null;
            }
        }

        public final long getItemId(int i) {
            int size = this.ygu.size() * this.mNumColumns;
            if (this.FP != null && i >= size) {
                size = i - size;
                if (size < this.FP.getCount()) {
                    return this.FP.getItemId(size);
                }
            }
            return -1;
        }

        public final boolean hasStableIds() {
            if (this.FP != null) {
                return this.FP.hasStableIds();
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int size = this.ygu.size() * this.mNumColumns;
            if (i < size) {
                View view2 = ((a) this.ygu.get(i / this.mNumColumns)).ygv;
                if (i % this.mNumColumns == 0) {
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                return view;
            }
            size = i - size;
            if (this.FP != null && size < this.FP.getCount()) {
                return this.FP.getView(size, view, viewGroup);
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            return view;
        }

        public final int getItemViewType(int i) {
            int size = this.ygu.size() * this.mNumColumns;
            if (i < size && i % this.mNumColumns != 0) {
                return this.FP != null ? this.FP.getViewTypeCount() : 1;
            } else {
                if (this.FP != null && i >= size) {
                    size = i - size;
                    if (size < this.FP.getCount()) {
                        return this.FP.getItemViewType(size);
                    }
                }
                return -2;
            }
        }

        public final int getViewTypeCount() {
            if (this.FP != null) {
                return this.FP.getViewTypeCount() + 1;
            }
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.registerObserver(dataSetObserver);
            if (this.FP != null) {
                this.FP.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            if (this.FP != null) {
                this.FP.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final Filter getFilter() {
            if (this.ygy) {
                return ((Filterable) this.FP).getFilter();
            }
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.FP;
        }
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public final void a(ListAdapter listAdapter) {
        if (this.ygu.size() > 0) {
            ListAdapter cVar = new c(this.ygu, listAdapter);
            if (cVar.mNumColumns != 5) {
                cVar.mNumColumns = 5;
                cVar.mDataSetObservable.notifyChanged();
            }
            super.setAdapter(cVar);
            return;
        }
        super.setAdapter(listAdapter);
    }
}
