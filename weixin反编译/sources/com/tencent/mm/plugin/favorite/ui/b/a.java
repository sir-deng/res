package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.Map;

public abstract class a {
    public final a mDy = new a();
    protected h muM = null;

    public interface c {
        void dr(long j);
    }

    public static class a {
        public boolean kLF;
        public long lastUpdateTime;
        public String liS;
        public boolean mAa;
        public Map<Long, f> mAb;
        public boolean mAi;
        public c mDA;

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append(10);
            stringBuilder.append("isSearching:").append(this.kLF).append(10);
            stringBuilder.append("search str:").append(this.liS).append(10);
            return stringBuilder.toString();
        }
    }

    public static class b {
        public CheckBox ikN;
        public TextView ljv;
        public TextView lmk;
        public View mDC;
        public ImageView mDD;
        public LinearLayout mDE;
        public TextView mDF;
        public f mwn;
    }

    public abstract View a(View view, ViewGroup viewGroup, f fVar);

    public abstract void a(View view, vp vpVar);

    public a(h hVar) {
        this.muM = hVar;
    }

    protected final View a(View view, b bVar, f fVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.mDC = view.findViewById(R.h.cht);
        if (bVar.mDC == null) {
            throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
        }
        bVar.lmk = (TextView) view.findViewById(R.h.cgT);
        if (bVar.lmk == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.ljv = (TextView) view.findViewById(R.h.chp);
        if (bVar.ljv == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.ikN = (CheckBox) view.findViewById(R.h.cgq);
        if (bVar.ikN == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.mDD = (ImageView) view.findViewById(R.h.chm);
        if (bVar.mDD == null) {
            throw new IllegalArgumentException("base item view do not contain id named tagIV");
        }
        bVar.ikN.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (compoundButton.getTag() != null) {
                    f fVar = (f) compoundButton.getTag();
                    if (z) {
                        a.this.mDy.mAb.put(Long.valueOf(fVar.field_localId), com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().dc(fVar.field_localId));
                    } else {
                        a.this.mDy.mAb.remove(Long.valueOf(fVar.field_localId));
                    }
                    if (a.this.mDy.mDA != null) {
                        a.this.mDy.mDA.dr(fVar.field_localId);
                    }
                }
            }
        });
        bVar.mwn = fVar;
        view.setTag(bVar);
        bVar.mDE = (LinearLayout) view.findViewById(R.h.chj);
        bVar.mDF = (TextView) view.findViewById(R.h.chi);
        bVar.mDF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.FavBaseListItem", "manual restart upload");
                if (view.getTag() instanceof f) {
                    j.n((f) view.getTag());
                }
            }
        });
        return view;
    }

    protected final void a(b bVar, f fVar) {
        bVar.mwn = fVar;
        if (bVar.mwn.field_type == 18) {
            bVar.mDC.setVisibility(0);
        } else {
            bVar.mDC.setVisibility(8);
        }
        if (this.mDy.mAi) {
            bVar.ljv.setText(d.dh(bVar.mwn.field_datatotalsize));
        } else {
            bVar.ljv.setText(g.e(bVar.ljv.getContext(), bVar.mwn.field_updateTime));
        }
        Context context = bVar.lmk.getContext();
        as.Hm();
        ag Xu = com.tencent.mm.y.c.Ff().Xu(bVar.mwn.field_fromUser);
        if (Xu == null || !Xu.field_username.equals(bVar.mwn.field_fromUser)) {
            x.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", bVar.mwn.field_fromUser);
            bVar.lmk.setText("");
            com.tencent.mm.y.ak.a.hhv.a(bVar.mwn.field_fromUser, "", null);
        } else {
            CharSequence gw;
            if (s.eX(bVar.mwn.field_fromUser)) {
                vt vtVar = bVar.mwn.field_favProto.wlW;
                gw = q.FY().equals(vtVar.fAJ) ? r.gw(vtVar.toUser) : r.gw(vtVar.fAJ);
            } else {
                gw = r.a(Xu, Xu.field_username);
            }
            bVar.lmk.setText(i.b(context, gw, bVar.lmk.getTextSize()));
        }
        if (bVar.mwn.aIt()) {
            bVar.mDE.setVisibility(0);
        } else {
            bVar.mDE.setVisibility(8);
        }
        bVar.ikN.setTag(fVar);
        if (this.mDy.mAa || this.mDy.mAi) {
            boolean z;
            bVar.ikN.setVisibility(0);
            CheckBox checkBox = bVar.ikN;
            if (this.mDy.mAb.get(Long.valueOf(fVar.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            bVar.ikN.setVisibility(8);
        }
        bVar.mDF.setTag(fVar);
        if (fVar.field_tagProto.wmn == null || fVar.field_tagProto.wmn.isEmpty()) {
            bVar.mDD.setVisibility(8);
        } else {
            bVar.mDD.setVisibility(0);
        }
    }
}
