package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.y;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;

public final class c extends o<com.tencent.mm.af.a.c> implements b {
    private final MMActivity fnF;
    protected f kHo;
    protected com.tencent.mm.ui.base.MMSlideDelView.c kHp;
    protected e kHq;
    protected d kHr = MMSlideDelView.cql();
    private final String kMt;
    private com.tencent.mm.ap.a.a.c liE = null;

    public static class a {
        public ImageView ikK;
        public TextView kHt;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.af.a.c cVar = (com.tencent.mm.af.a.c) obj;
        if (cVar == null) {
            cVar = new com.tencent.mm.af.a.c();
        }
        cVar.b(cursor);
        return cVar;
    }

    public c(Context context, com.tencent.mm.ui.o.a aVar, String str) {
        super(context, new com.tencent.mm.af.a.c());
        this.xQN = aVar;
        this.fnF = (MMActivity) context;
        this.kMt = str;
        com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
        aVar2.hFo = com.tencent.mm.af.a.e.bZ(this.kMt);
        aVar2.hFl = true;
        aVar2.hFI = true;
        aVar2.hFA = R.k.bBC;
        this.liE = aVar2.PQ();
    }

    public final void XH() {
        aUU();
        com.tencent.mm.af.a.d Mn = y.Mn();
        String str = this.kMt;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
        StringBuilder append = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(").append("BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        x.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", stringBuilder.toString());
        setCursor(Mn.gLA.rawQuery(stringBuilder.toString(), null));
        if (this.xQN != null) {
            this.xQN.XE();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.kHo = fVar;
    }

    public final void a(e eVar) {
        this.kHq = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.kHp = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.kHr != null) {
            this.kHr.aVf();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.af.a.c cVar = (com.tencent.mm.af.a.c) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.fnF, R.i.dgz, null);
            aVar2.ikK = (ImageView) view.findViewById(R.h.bLM);
            aVar2.kHt = (TextView) view.findViewById(R.h.cyG);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.ap.o.PG().a(cVar.field_headImageUrl, aVar.ikK, this.liE);
        aVar.kHt.setText(i.c(this.fnF, cVar.field_chatName, (int) aVar.kHt.getTextSize()));
        return view;
    }

    protected final void XI() {
        XH();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }
}
