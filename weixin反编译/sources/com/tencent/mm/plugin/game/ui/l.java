package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l implements OnClickListener, OnItemClickListener {
    protected int niV = 0;

    public final void rg(int i) {
        this.niV = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = adapterView.getAdapter().getItem(i);
        if (item != null && (item instanceof d)) {
            d dVar = (d) item;
            if (!bi.oN(dVar.field_appId)) {
                a(view.getContext(), dVar);
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof d)) {
            a(view.getContext(), (d) view.getTag());
        }
    }

    private void a(Context context, d dVar) {
        int i = 0;
        if (dVar.type == 1) {
            i = c.ac(context, dVar.ngB);
        } else if (dVar.type == 0) {
            if (dVar.aQA() && !bi.oN(dVar.ngU.nkN) && !g.a(context, (f) dVar)) {
                i = c.ac(context, dVar.ngU.nkN);
            } else if (bi.oN(dVar.fRD) || dVar.fRG != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", dVar.field_appId);
                if (dVar.fGe == 1601) {
                    bundle.putInt("game_report_from_scene", this.niV);
                } else {
                    bundle.putInt("game_report_from_scene", dVar.fGe);
                }
                i = c.a(context, dVar.field_appId, dVar.ngB, bundle);
            } else {
                x.i("MicroMsg.GameItemClickListener", "Download via Google Play");
                q.aY(context, dVar.fRD);
                i = 25;
            }
        }
        ap.a(context, dVar.scene, dVar.fGe, dVar.position, i, dVar.field_appId, this.niV, dVar.fpi, dVar.ngQ);
    }
}
