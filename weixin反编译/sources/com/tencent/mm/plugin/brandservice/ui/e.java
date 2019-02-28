package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e extends com.tencent.mm.ui.base.sortview.a {
    private static b kKR;
    long kKW;
    String kKX;
    String kMu;
    int wn;

    public static class a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView jIt;
    }

    public e(Object obj, long j, int i, String str) {
        super(2, null);
        this.kKW = j;
        this.kKX = str;
        this.wn = i;
    }

    public final b asT() {
        if (kKR == null) {
            kKR = new b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    if (!(context == null || aVar == null)) {
                        int i = 0;
                        if (objArr != null && objArr.length >= 2 && (objArr[1] instanceof Integer)) {
                            i = ((Integer) objArr[1]).intValue();
                        }
                        e eVar = (e) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", eVar.kKX);
                        intent.putExtra("businessType", eVar.kKW);
                        intent.putExtra("offset", eVar.wn);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i);
                        context.startActivity(intent);
                    }
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.drE, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    if (context == null || aVar == null || aVar2 == null) {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                    } else if (aVar2 instanceof e) {
                        ((a) aVar).jIt.setText(((e) aVar2).kMu);
                    } else {
                        x.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        ((a) aVar).jIt = (TextView) view.findViewById(R.h.cSg);
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
        this.kMu = "";
    }
}
