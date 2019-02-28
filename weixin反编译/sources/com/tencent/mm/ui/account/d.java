package com.tencent.mm.ui.account;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

@Deprecated
final class d extends o<h> {
    private int[] hxD;
    private String inS;
    a xWy;

    public interface a {
        void Ey(int i);
    }

    static class b {
        TextView hxK;
        TextView hxL;
        ImageView ikl;
        TextView xWA;
        ImageView xWB;
        TextView xWz;

        b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        h hVar = (h) obj;
        if (hVar == null) {
            hVar = new h();
        }
        hVar.b(cursor);
        return hVar;
    }

    public d(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new h());
        this.xQN = aVar;
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        i OK = af.OK();
        String str = this.inS;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(OK.hiZ.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
        this.hxD = new int[getCount()];
        if (!(this.xWy == null || this.inS == null)) {
            this.xWy.Ey(getCursor().getCount());
        }
        super.notifyDataSetChanged();
    }

    public final void Ds(String str) {
        this.inS = bi.oL(str.trim());
        aUU();
        XH();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        h hVar = (h) getItem(i);
        if (view == null) {
            b bVar2 = new b();
            view = View.inflate(this.context, R.i.dhs, null);
            bVar2.ikl = (ImageView) view.findViewById(R.h.bYA);
            bVar2.hxK = (TextView) view.findViewById(R.h.cEA);
            bVar2.hxL = (TextView) view.findViewById(R.h.cEv);
            bVar2.xWz = (TextView) view.findViewById(R.h.cEw);
            bVar2.xWA = (TextView) view.findViewById(R.h.cEy);
            bVar2.xWB = (ImageView) view.findViewById(R.h.cED);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.hxK.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.context, hVar.NL(), bVar.hxK.getTextSize()));
        bVar.xWA.setVisibility(8);
        bVar.xWB.setVisibility(0);
        switch (this.hxD[i]) {
            case 0:
                if (hVar.status != 102) {
                    as.Hm();
                    if (!c.Ff().Xr(hVar.getUsername())) {
                        bVar.hxL.setVisibility(8);
                        bVar.xWz.setVisibility(0);
                        break;
                    }
                }
                if (hVar.status != 102) {
                    bVar.hxL.setVisibility(0);
                    bVar.hxL.setText(R.l.ekt);
                    bVar.hxL.setTextColor(this.context.getResources().getColor(R.e.bri));
                    bVar.xWz.setVisibility(8);
                    break;
                }
                bVar.hxL.setVisibility(8);
                bVar.xWz.setVisibility(8);
                bVar.xWB.setVisibility(8);
                break;
            case 2:
                bVar.xWz.setVisibility(8);
                bVar.hxL.setVisibility(0);
                bVar.hxL.setText(R.l.ekw);
                bVar.hxL.setTextColor(this.context.getResources().getColor(R.e.brj));
                break;
        }
        Bitmap iU = com.tencent.mm.ac.b.iU(hVar.fXc);
        if (iU == null) {
            bVar.ikl.setImageDrawable(com.tencent.mm.bu.a.b(this.context, R.k.bBC));
        } else {
            bVar.ikl.setImageBitmap(iU);
        }
        return view;
    }
}
