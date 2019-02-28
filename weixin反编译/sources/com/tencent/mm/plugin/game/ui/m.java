package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends n {
    public final /* bridge */ /* synthetic */ void CJ(String str) {
        super.CJ(str);
    }

    public final /* bridge */ /* synthetic */ void CK(String str) {
        super.CK(str);
    }

    public final /* bridge */ /* synthetic */ void CL(String str) {
        super.CL(str);
    }

    public final /* bridge */ /* synthetic */ void P(LinkedList linkedList) {
        super.P(linkedList);
    }

    public final /* bridge */ /* synthetic */ void Q(LinkedList linkedList) {
        super.Q(linkedList);
    }

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        super.a(aVar);
    }

    public final /* bridge */ /* synthetic */ void b(SparseArray sparseArray) {
        super.b(sparseArray);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return super.getView(i, view, viewGroup);
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public final /* bridge */ /* synthetic */ void rg(int i) {
        super.rg(i);
    }

    public final /* bridge */ /* synthetic */ void rj(int i) {
        super.rj(i);
    }

    public final /* bridge */ /* synthetic */ void x(View view, int i) {
        super.x(view, i);
    }

    public m(Context context) {
        super(context);
        this.nyh = R.i.dkP;
    }

    protected final void a(d dVar, b bVar, int i) {
        bVar.nyr.setText(dVar.position);
        bVar.nyr.setVisibility(this.nyj ? 0 : 8);
        Bitmap CI = CI(dVar.field_appId);
        if (CI == null || CI.isRecycled()) {
            bVar.nqo.setImageResource(R.g.bCD);
        } else {
            bVar.nqo.setImageBitmap(CI);
        }
        bVar.nqp.setText(dVar.field_appName);
        if (bi.oN(dVar.ngy)) {
            bVar.nyt.setVisibility(8);
        } else {
            bVar.nyt.setVisibility(0);
            bVar.nyt.setText(dVar.ngy);
        }
        if (bi.oN(dVar.ngz)) {
            bVar.nyu.setVisibility(8);
        } else {
            bVar.nyu.setVisibility(0);
            bVar.nyu.setText(dVar.ngz);
        }
        if (bi.cC(dVar.ngJ)) {
            if (!bi.oN(dVar.ngM)) {
                bVar.nys.setVisibility(0);
                bVar.nys.setText(dVar.ngM);
                try {
                    bVar.nys.setBackgroundDrawable(g.cm(Color.parseColor(dVar.ngN), com.tencent.mm.bu.a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.GameLibraryListAdapter", e.getMessage());
                } catch (Exception e2) {
                    x.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
                }
            }
            bVar.nys.setVisibility(8);
        } else {
            bVar.nys.setVisibility(0);
            bVar.nys.setText((CharSequence) dVar.ngJ.get(0));
        }
        bVar.nyw.rv(this.nuk);
        bVar.nyv.setOnClickListener(this.nva);
        bVar.nyw.setOnClickListener(this.nva);
        bVar.nyv.setTag(dVar);
        bVar.nyw.setTag(dVar);
        this.nup.a(bVar.nyw, bVar.nyv, dVar, (o) this.nyl.get(dVar.field_appId));
        bVar.nyx.I(dVar.ngH);
        bVar.nyy.removeAllViews();
        View view = (View) this.nym.get(i);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.nyy.addView(view);
        }
    }

    protected final void a(d dVar, b bVar) {
        bVar.nyz.removeAllViews();
        if (!bi.oN(dVar.ngC)) {
            View inflate = View.inflate(this.mContext, R.i.dkC, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.cmm);
            com.tencent.mm.ap.a.a PG = com.tencent.mm.ap.o.PG();
            String str = dVar.ngC;
            c.a aVar = new c.a();
            aVar.hFk = true;
            PG.a(str, imageView, aVar.PQ());
            bVar.nyz.addView(inflate, new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(this.mContext, 100)));
        }
    }
}
