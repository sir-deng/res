package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.f;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a<com.tencent.mm.plugin.wenote.ui.nativenote.b.a> {
    private final String TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    private k ucQ;
    private f uep;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        x.i("MicroMsg.Note.NoteRecyclerViewAdapter", "onCreateViewHolder viewType = " + i);
        return f.a(i, LayoutInflater.from(viewGroup.getContext()).inflate(((Integer) this.uep.uex.get(i)).intValue(), viewGroup, false), this.ucQ);
    }

    public c(k kVar) {
        this.ucQ = kVar;
        this.uep = new f();
    }

    private synchronized void a(com.tencent.mm.plugin.wenote.ui.nativenote.b.a aVar, int i) {
        boolean z = true;
        synchronized (this) {
            b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(i);
            if (BL == null || BL.getType() != aVar.bYB()) {
                String str = "MicroMsg.Note.NoteRecyclerViewAdapter";
                String str2 = "onBindViewHolder, item is null %b, position is %d";
                Object[] objArr = new Object[2];
                if (BL != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(i);
                x.e(str, str2, objArr);
            } else {
                aVar.a(BL, i, BL.getType());
            }
        }
    }

    public final int getItemViewType(int i) {
        b BL = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().BL(i);
        if (BL != null) {
            return BL.getType();
        }
        x.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", Integer.valueOf(i));
        return 0;
    }

    public final int getItemCount() {
        return com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().size();
    }
}
