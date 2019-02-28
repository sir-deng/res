package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.k;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a<t> {
    private static LayoutParams klF = new LayoutParams(-1, -2);
    android.support.v7.widget.RecyclerView.a TU;
    private ViewGroup klG;
    private ViewGroup klH;
    List<View> klI = new LinkedList();
    private List<View> klJ = new LinkedList();
    b klK;
    private c klL;
    c klM = new c() {
        public final void onChanged() {
            a.this.UR.notifyChanged();
        }

        public final void Y(int i, int i2) {
            a.this.U((a.this.klI.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void c(int i, int i2, Object obj) {
            a.this.b((a.this.klI.isEmpty() ? 0 : 1) + i, i2, obj);
        }

        public final void Z(int i, int i2) {
            a.this.W((a.this.klI.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void aa(int i, int i2) {
            a.this.X((a.this.klI.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void ab(int i, int i2) {
            int i3;
            int i4 = 0;
            a aVar = a.this;
            if (a.this.klI.isEmpty()) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            i3 += i;
            if (!a.this.klI.isEmpty()) {
                i4 = 1;
            }
            aVar.V(i3, i4 + i2);
        }
    };

    private static class a extends t {
        a(View view) {
            super(view);
        }
    }

    a() {
    }

    public final int getItemViewType(int i) {
        if (!this.klI.isEmpty() && i == 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.klJ.isEmpty() && i == getItemCount() - 1) {
            return 2147483646;
        }
        return this.TU.getItemViewType(i - (this.klI.isEmpty() ? 0 : 1));
    }

    public final long getItemId(int i) {
        if (getItemViewType(i) == Integer.MAX_VALUE) {
            return (long) "MRecyclerHeaderView".hashCode();
        }
        if (getItemViewType(i) == 2147483646) {
            return (long) "MRecyclerFooterView".hashCode();
        }
        if (!this.TU.US) {
            return (long) i;
        }
        return this.TU.getItemId(i - (this.klI.isEmpty() ? 0 : 1));
    }

    public final int getItemCount() {
        int itemCount = this.TU.getItemCount();
        if (!this.klI.isEmpty()) {
            itemCount++;
        }
        if (this.klJ.isEmpty()) {
            return itemCount;
        }
        return itemCount + 1;
    }

    public final void a(final t tVar, int i) {
        if (!this.klI.isEmpty() && i == 0) {
            return;
        }
        if (this.klJ.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.klI.isEmpty() ? 0 : 1);
            this.TU.a(tVar, i2);
            if (this.klK != null) {
                tVar.VU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.klK != null) {
                            b b = a.this.klK;
                            View view2 = tVar.VU;
                            int i = i2;
                            long j = tVar.VW;
                            b.mN(i);
                        }
                    }
                });
            }
            if (this.klL != null) {
                tVar.VU.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        if (a.this.klL == null) {
                            return false;
                        }
                        c c = a.this.klL;
                        View view2 = tVar.VU;
                        long j = tVar.VW;
                        return c.aoI();
                    }
                });
            }
        }
    }

    public final void a(final t tVar, int i, List<Object> list) {
        if (!this.klI.isEmpty() && i == 0) {
            return;
        }
        if (this.klJ.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.klI.isEmpty() ? 0 : 1);
            this.TU.a(tVar, i2, list);
            if (this.klK != null) {
                tVar.VU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.klK != null) {
                            b b = a.this.klK;
                            View view2 = tVar.VU;
                            int i = i2;
                            long j = tVar.VW;
                            b.mN(i);
                        }
                    }
                });
            }
            if (this.klL != null) {
                tVar.VU.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        if (a.this.klL == null) {
                            return false;
                        }
                        c c = a.this.klL;
                        View view2 = tVar.VU;
                        long j = tVar.VW;
                        return c.aoI();
                    }
                });
            }
        }
    }

    public final t a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        if (i == 2147483646) {
            if (this.klG != null) {
                this.klG.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(k.c.kaU, viewGroup, false);
            this.klG = viewGroup2;
            for (View addView : this.klJ) {
                viewGroup2.addView(addView, klF);
            }
            return new a(viewGroup2);
        } else if (i != Integer.MAX_VALUE) {
            return this.TU.a(viewGroup, i);
        } else {
            if (this.klH != null) {
                this.klH.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(k.c.kaU, viewGroup, false);
            this.klH = viewGroup2;
            for (View addView2 : this.klI) {
                viewGroup2.addView(addView2, klF);
            }
            return new a(viewGroup2);
        }
    }

    public final int aoG() {
        return this.klJ.size();
    }

    public final void addFooterView(View view) {
        this.klJ.add(view);
        U(getItemCount() - 1, 1);
    }

    public final void c(int i, View view) {
        this.klJ.add(i, view);
        U(getItemCount() - 1, 1);
    }

    public final void cf(View view) {
        this.klJ.remove(view);
        U(getItemCount() - 1, 1);
    }
}
