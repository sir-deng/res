package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i extends AlertDialog implements e {
    private TextView FN;
    private View kTo;
    private MMDotView kgN;
    private Context mContext;
    private b nSJ;
    private IPCallShareViewPager nSK;
    private OnClickListener nSL;
    private LinkedList<Integer> nSM;
    private CharSequence uU;

    public static class a extends BaseAdapter {
        private Context mContext;
        OnClickListener nSN;
        List<Integer> nua = null;

        public class a {
            int id;
            RelativeLayout nSP;
            TextView nSQ;
            ImageView nSR;
        }

        public a(Context context) {
            Assert.assertTrue(context != null);
            this.mContext = context;
        }

        public final int getCount() {
            return this.nua == null ? 0 : this.nua.size();
        }

        public final Object getItem(int i) {
            if (this.nua != null) {
                return this.nua.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.dmA, viewGroup, false);
                aVar = new a();
                aVar.nSP = (RelativeLayout) view.findViewById(R.h.layout);
                aVar.nSQ = (TextView) view.findViewById(R.h.crp);
                aVar.nSR = (ImageView) view.findViewById(R.h.cro);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            Object item = getItem(i);
            if (item != null) {
                aVar.id = ((Integer) item).intValue();
                IPCallShareCouponCardUI.a(this.mContext, aVar.id, aVar.nSQ, aVar.nSR);
                aVar.nSP.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.nSN != null) {
                            a.this.nSN.onClick(view);
                        }
                    }
                });
            }
            return view;
        }
    }

    public class b extends u {
        int mCount = 0;
        OnClickListener nSN;
        LinkedList<Integer> nSS;
        ArrayList<View> nST = new ArrayList();

        public final int getCount() {
            return this.mCount;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            x.v("MicroMsg.IPCallShareDialog", "destroy item: %d", Integer.valueOf(i));
            viewGroup.removeView((View) obj);
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view;
            if (this.nST.get(i) != null) {
                view = (View) this.nST.get(i);
            } else {
                view = null;
            }
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (viewGroup != null) {
                    viewGroup.addView(view, 0);
                }
            }
            return view;
        }

        public final int k(Object obj) {
            return super.k(obj);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.kTo);
    }

    public final void ae(int i) {
        if (this.nSJ.getCount() <= 1) {
            this.kgN.setVisibility(4);
            return;
        }
        this.kgN.setVisibility(0);
        this.kgN.Fa(this.nSJ.getCount());
        this.kgN.Fb(i);
    }

    public final void af(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uU = charSequence;
        } else {
            this.uU = null;
        }
    }

    public final void show() {
        int i = 0;
        if (this.nSM != null && this.nSM.size() != 0) {
            this.nSK.b((e) this);
            b bVar = new b();
            bVar.nSN = this.nSL;
            bVar.nSS = this.nSM;
            if (bVar.nSS.size() > 0) {
                bVar.mCount = ((bVar.nSS.size() - 1) / 9) + 1;
            } else {
                bVar.mCount = 0;
            }
            while (true) {
                int i2 = i;
                if (i2 < bVar.mCount) {
                    View inflate = ((LayoutInflater) bVar.nSU.mContext.getSystemService("layout_inflater")).inflate(R.i.dmz, null);
                    GridView gridView = (GridView) inflate.findViewById(R.h.crq);
                    List arrayList = new ArrayList();
                    int i3 = i2 * 9;
                    while (i3 < bVar.nSS.size() && i3 < (i2 * 9) + 9) {
                        arrayList.add(bVar.nSS.get(i3));
                        i3++;
                    }
                    ListAdapter aVar = new a(bVar.nSU.getContext());
                    aVar.nSN = bVar.nSN;
                    aVar.nua = arrayList;
                    gridView.setAdapter(aVar);
                    bVar.nST.add(inflate);
                    i = i2 + 1;
                } else {
                    this.nSJ = bVar;
                    this.nSK.a(this.nSJ);
                    this.FN.setText(this.uU);
                    super.show();
                    return;
                }
            }
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
