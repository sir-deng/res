package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> pLq = new HashMap();
    public i pLr = new i() {
        public final void a(final c cVar) {
            if (cVar.field_favLocalId != ((b) d.this.pLJ).pLp.field_localId) {
                x.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", Long.valueOf(cVar.field_favLocalId), Long.valueOf(((b) d.this.pLJ).pLp.field_localId));
                return;
            }
            x.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", Long.valueOf(cVar.field_favLocalId), cVar.field_dataId, Integer.valueOf(cVar.field_status));
            if (4 == cVar.field_status) {
                d.pLq.put(bi.aD(cVar.field_dataId, "null"), Boolean.valueOf(true));
            }
            if (cVar.isFinished()) {
                d.this.pLF.post(new Runnable() {
                    public final void run() {
                        View view = (View) com.tencent.mm.plugin.record.ui.b.c.pMz.get(cVar.field_dataId);
                        String str = "MicroMsg.FavRecordAdapter";
                        String str2 = "view is null %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(view == null);
                        x.d(str, str2, objArr);
                        if (view != null) {
                            b bVar = (b) view.getTag();
                            str2 = com.tencent.mm.plugin.record.b.b.a(bVar);
                            x.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", bVar.fvZ.mBr);
                            if (bVar.fvZ.mBr.equals(cVar.field_dataId)) {
                                x.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", Integer.valueOf(cVar.field_status), cVar.field_dataId, Float.valueOf(cVar.getProgress()), Boolean.valueOf(cVar.isFinished()));
                                ImageView imageView = (ImageView) view.findViewById(R.h.cPs);
                                MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
                                a aVar = (a) view.findViewById(R.h.image);
                                imageView.setVisibility(8);
                                mMPinProgressBtn.setVisibility(8);
                                x.i("MicroMsg.FavRecordAdapter", "setVideoPath " + str2);
                                aVar.id(true);
                                aVar.aA(str2, false);
                            }
                        }
                    }
                });
            }
            d.this.bnK();
        }
    };

    public d(Context context, h.a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        x.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", Long.valueOf(((b) aVar).pLp.field_localId), Integer.valueOf(((b) aVar).pLp.field_itemStatus));
        this.pLJ = aVar;
        this.pLo.clear();
        this.pLo.addAll(aVar.pLo);
        notifyDataSetChanged();
    }

    public final void d(b bVar) {
        x.d("MicroMsg.FavRecordAdapter", "setupRecord %s", Long.valueOf(((b) this.pLJ).pLp.field_localId));
        bVar.bjS = 1;
        bVar.pLp = ((b) this.pLJ).pLp;
    }
}
