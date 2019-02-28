package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h extends Preference {
    private Context mContext = null;
    private View mView = null;
    List<com.tencent.mm.plugin.scanner.a.a.a> pkQ = null;

    private static final class a implements i {
        private String mPicUrl = null;

        public a(String str) {
            this.mPicUrl = str;
        }

        public final String Wo() {
            return c.bpi().dZ(this.mPicUrl, "@S");
        }

        public final String Wp() {
            return this.mPicUrl;
        }

        public final String Wq() {
            return this.mPicUrl;
        }

        public final String Wr() {
            return this.mPicUrl;
        }

        public final boolean Ws() {
            return false;
        }

        public final boolean Wt() {
            return false;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
            if (com.tencent.mm.platformtools.i.a.NET == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, Wo(), false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ProductGridPreference", e, "", new Object[0]);
                }
            }
            return bitmap;
        }

        public final void Wv() {
        }

        public final void N(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final Bitmap Wu() {
            if (ad.getContext() == null) {
                return null;
            }
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }

        public final com.tencent.mm.platformtools.i.b Wn() {
            return null;
        }
    }

    final class b extends BaseAdapter implements com.tencent.mm.platformtools.j.a {
        private LayoutInflater DF = null;
        Map<String, WeakReference<ImageView>> qbB = new HashMap();
        private int qbE;
        List<com.tencent.mm.plugin.scanner.a.a.a> qbF = new ArrayList();

        class a {
            TextView lpZ;
            ImageView pZK;

            a() {
            }
        }

        public b() {
            this.DF = LayoutInflater.from(h.this.mContext);
            j.a((com.tencent.mm.platformtools.j.a) this);
            this.qbE = h.this.mContext.getResources().getColor(R.e.bsJ);
        }

        public final int getCount() {
            return this.qbF.size();
        }

        public final Object getItem(int i) {
            return this.qbF.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.DF.inflate(R.i.dpK, viewGroup, false);
                aVar = new a();
                aVar.pZK = (ImageView) view.findViewById(R.h.cnW);
                aVar.lpZ = (TextView) view.findViewById(R.h.cnV);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            final com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) this.qbF.get(i);
            Bitmap a = j.a(new a(aVar2.iconUrl));
            if (a == null || a.isRecycled()) {
                aVar.pZK.setBackgroundColor(this.qbE);
                aVar.pZK.setImageBitmap(null);
            } else {
                aVar.pZK.setImageBitmap(a);
                aVar.pZK.setBackgroundColor(0);
            }
            final String str = aVar2.pYv;
            aVar.pZK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    as.CN().a(new com.tencent.mm.plugin.scanner.a.h(str, aVar2.pYu, aVar2.type, str, b.this.getCount(), aVar2.showType), 0);
                    if (!bi.oN(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_Product_ID", str);
                        com.tencent.mm.bl.d.b(h.this.mContext, "scanner", ".ui.ProductUI", intent);
                    }
                }
            });
            aVar.pZK.setTag(aVar2.iconUrl);
            this.qbB.put(aVar2.iconUrl, new WeakReference(aVar.pZK));
            aVar.lpZ.setText(aVar2.name);
            return view;
        }

        public final void l(String str, final Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled() && !bi.oN(str)) {
                x.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=" + str);
                if (((WeakReference) this.qbB.get(str)) != null) {
                    final ImageView imageView = (ImageView) ((WeakReference) this.qbB.get(str)).get();
                    if (imageView != null && str.equals((String) imageView.getTag())) {
                        ah.y(new Runnable() {
                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                                imageView.setBackgroundColor(0);
                            }
                        });
                    }
                }
            }
        }
    }

    public h(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(R.i.dpJ);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        GridView gridView = (GridView) this.mView.findViewById(R.h.cuS);
        b bVar = new b();
        gridView.setAdapter(bVar);
        if (this.pkQ != null) {
            List list = this.pkQ;
            bVar.qbB.clear();
            bVar.qbF.clear();
            bVar.qbF = list;
            bVar.notifyDataSetChanged();
        }
    }
}
