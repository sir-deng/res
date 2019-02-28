package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c extends b {
    private final String iYN;
    private AuthorizeItemListView iYO;
    private LinearLayout iYQ;
    private b kcb;
    private final String mAppName;
    private Context mContext;

    private static final class b extends BaseAdapter {
        private LinkedList<bfh> iYV;

        private static final class a {
            ImageView iYZ;
            TextView iZa;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kd(i);
        }

        b(LinkedList<bfh> linkedList) {
            this.iYV = linkedList;
        }

        public final int getCount() {
            return this.iYV == null ? 0 : this.iYV.size();
        }

        private bfh kd(int i) {
            return (bfh) this.iYV.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.iYV == null || this.iYV.size() <= 0) {
                return null;
            }
            a aVar;
            final bfh kd = kd(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), h.daM, null);
                aVar2.iYZ = (ImageView) view.findViewById(g.bKq);
                aVar2.iZa = (TextView) view.findViewById(g.bKp);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (kd.wRz == 1) {
                aVar.iYZ.setImageResource(i.dzg);
            } else if (kd.wRz == 3) {
                aVar.iYZ.setImageResource(i.dzf);
            } else {
                aVar.iYZ.setImageResource(i.dze);
            }
            aVar.iZa.setText(kd.nkL);
            final ImageView imageView = aVar.iYZ;
            aVar.iYZ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (kd.wRz == 2) {
                        imageView.setImageResource(i.dzg);
                        kd.wRz = 1;
                    } else if (kd.wRz == 1) {
                        imageView.setImageResource(i.dze);
                        kd.wRz = 2;
                    }
                }
            });
            return view;
        }
    }

    public interface a {
        void d(int i, Bundle bundle);
    }

    public c(Context context, final LinkedList<bfh> linkedList, String str, String str2, final a aVar) {
        super(context, (byte) 0);
        this.mContext = context;
        this.mAppName = bi.oM(str);
        this.iYN = str2;
        if (linkedList == null || linkedList.size() <= 0) {
            throw new IllegalArgumentException("scopeInfoList is empty or null");
        }
        View view = (ViewGroup) v.fw(this.mContext).inflate(h.izd, null);
        setContentView(view);
        com.tencent.mm.modelappbrand.a.b.Jp().a((ImageView) view.findViewById(g.bKA), this.iYN, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
        ((TextView) view.findViewById(g.bKF)).setText(this.mContext.getString(j.etD, new Object[]{this.mAppName}));
        this.iYO = (AuthorizeItemListView) view.findViewById(g.bLu);
        this.kcb = new b(linkedList);
        this.iYO.setAdapter(this.kcb);
        if (linkedList.size() > 5) {
            this.iYO.Pb = linkedList.size();
            this.iYQ = (LinearLayout) view.findViewById(g.bLx);
            LayoutParams layoutParams = (LayoutParams) this.iYQ.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.bxK);
            this.iYQ.setLayoutParams(layoutParams);
        }
        ((Button) view.findViewById(g.cul)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((bfh) linkedList.get(i2)).wRz == 2 || ((bfh) linkedList.get(i2)).wRz == 3) {
                            arrayList.add(((bfh) linkedList.get(i2)).vVc);
                        }
                        i = i2 + 1;
                    } else {
                        x.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        aVar.d(1, bundle);
                        this.dismiss();
                        return;
                    }
                }
            }
        });
        ((Button) view.findViewById(g.cux)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((bfh) linkedList.get(i2)).wRz == 2 || ((bfh) linkedList.get(i2)).wRz == 3) {
                            arrayList.add(((bfh) linkedList.get(i2)).vVc);
                        }
                        i = i2 + 1;
                    } else {
                        x.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        aVar.d(2, bundle);
                        this.dismiss();
                        return;
                    }
                }
            }
        });
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                x.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.d(3, null);
            }
        });
    }
}
