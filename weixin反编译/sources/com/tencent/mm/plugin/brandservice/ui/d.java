package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d extends com.tencent.mm.ui.base.sortview.a {
    private static b kKR;
    String kKS;

    public static class a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView kKK;
    }

    public d(Object obj) {
        super(1, obj);
    }

    public final b asT() {
        if (kKR == null) {
            kKR = new b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.drD, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        x.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        x.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
                    } else if (aVar2 instanceof d) {
                        com.tencent.mm.plugin.brandservice.a.a.b(((a) aVar).kKK, ((d) aVar2).kKS);
                    } else {
                        x.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).kKK = (TextView) view.findViewById(R.h.bSx);
                    }
                }
            };
        }
        return kKR;
    }

    public final com.tencent.mm.ui.base.sortview.a.a asU() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        if (this.data instanceof String) {
            this.kKS = (String) this.data;
        }
    }
}
