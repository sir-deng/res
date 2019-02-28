package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.au.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class h extends a {
    private final int mDH;
    private Set<ImageView> mDN;
    private OnClickListener mDO = new OnClickListener() {
        public final void onClick(View view) {
            if (!f.zl()) {
                u.fJ(h.this.muM.context);
            } else if (view.getTag() instanceof com.tencent.mm.plugin.fav.a.f) {
                com.tencent.mm.plugin.fav.a.f fVar = (com.tencent.mm.plugin.fav.a.f) view.getTag();
                vt vtVar = fVar.field_favProto.wlW;
                uz p = j.p(fVar);
                if (p == null) {
                    x.w("MicroMsg.FavBaseListItem", "data item is null");
                } else if (e.l(p)) {
                    x.i("MicroMsg.FavBaseListItem", "same song, do release");
                    b.Qv();
                    h.a(h.this, null);
                } else {
                    String absolutePath;
                    File file = new File(j.i(p));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (p.fra == null) {
                        absolutePath = "";
                    } else {
                        file = new File(j.aJl() + g.s(p.fra.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(((com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class)).a(6, null, p.title, p.desc, p.wjU, p.wjY, p.wjW, p.mBr, j.aJn(), absolutePath, "", vtVar.appId));
                    h.a(h.this, (ImageView) view);
                }
            }
        }
    };

    public static class a extends a.b {
        TextView ikL;
        TextView ikM;
        ImageView jIs;
        TextView mDG;
        ImageView mDQ;
    }

    static /* synthetic */ void a(h hVar, ImageView imageView) {
        x.i("MicroMsg.FavBaseListItem", "mask iv set size is %d", Integer.valueOf(hVar.mDN.size()));
        for (ImageView imageView2 : hVar.mDN) {
            if (imageView2 == imageView) {
                imageView2.setImageResource(R.g.bDS);
            } else {
                imageView2.setImageResource(R.g.bDT);
            }
        }
    }

    public h(com.tencent.mm.plugin.favorite.b.h hVar) {
        super(hVar);
        this.mDH = com.tencent.mm.bu.a.aa(hVar.context, R.f.buZ);
        this.mDN = new HashSet();
    }

    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.fav.a.f fVar) {
        a.b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            a.b aVar = new a();
            view = a(View.inflate(context, R.i.dhD, null), aVar, fVar);
            aVar.jIs = (ImageView) view.findViewById(R.h.cgK);
            aVar.ikL = (TextView) view.findViewById(R.h.chq);
            aVar.ikM = (TextView) view.findViewById(R.h.cgw);
            aVar.mDQ = (ImageView) view.findViewById(R.h.cgO);
            aVar.mDG = (TextView) view.findViewById(R.h.chb);
            aVar.mDG.setVisibility(8);
            aVar.mDQ.setOnClickListener(this.mDO);
            aVar.mDQ.setVisibility(0);
            this.mDN.add(aVar.mDQ);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, fVar);
        vt vtVar = fVar.field_favProto.wlW;
        uz p = j.p(fVar);
        bVar.ikL.setText(p.title);
        bVar.ikM.setText(p.desc);
        this.muM.a(bVar.jIs, p, fVar, R.k.dvy, this.mDH, this.mDH);
        bVar.mDQ.setTag(fVar);
        if (e.l(p)) {
            bVar.mDQ.setImageResource(R.g.bDS);
        } else {
            bVar.mDQ.setImageResource(R.g.bDT);
        }
        return view;
    }

    public final void a(View view, vp vpVar) {
        e.a(view.getContext(), ((a) view.getTag()).mwn, vpVar);
    }
}
