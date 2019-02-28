package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.k.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;

public final class c extends o<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    long endTime = 0;
    private int kUl = 0;
    com.tencent.mm.plugin.card.base.c kUm;
    int kUn = -1;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ShareCardInfo shareCardInfo = (ShareCardInfo) obj;
        if (shareCardInfo == null) {
            shareCardInfo = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            x.e("MicroMsg.ShareCardAdatper", "cursor is closed!");
        } else {
            shareCardInfo.b(cursor);
        }
        return shareCardInfo;
    }

    public c(Context context) {
        super(context, new ShareCardInfo());
        mb(true);
        this.kUm = new j(context, this);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kUm.a(i, view, (ShareCardInfo) getItem(i));
    }

    public final void XH() {
        Cursor rawQuery;
        this.beginTime = System.currentTimeMillis();
        if (this.kUn == -1) {
            k avp = am.avp();
            int i = a.kRr;
            StringBuilder stringBuilder = new StringBuilder();
            switch (AnonymousClass1.kQI[i - 1]) {
                case 1:
                    stringBuilder.append(" where (status=0 OR ").append("status=5)");
                    break;
                case 2:
                    stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                    break;
                case 3:
                    stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
                    break;
            }
            rawQuery = avp.gLA.rawQuery("select * from ShareCardInfo" + stringBuilder.toString() + " order by status asc , share_time" + " desc", null);
        } else {
            k avp2 = am.avp();
            int i2 = this.kUn;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" where ( status=0) ");
            String str = "";
            switch (i2) {
                case 1:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.od(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    stringBuilder2.append(" AND (");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.od(1));
                    stringBuilder2.append(" categoryType= '10' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" OR (");
                    stringBuilder2.append(k.od(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    stringBuilder2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    stringBuilder2.append(" AND ");
                    stringBuilder2.append(" (");
                    stringBuilder2.append(k.od(2));
                    stringBuilder2.append(" categoryType= '0' ");
                    stringBuilder2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 4:
                    stringBuilder2.append(" AND 1 != 1 ");
                    break;
            }
            rawQuery = avp2.gLA.rawQuery("select * from ShareCardInfo" + stringBuilder2.toString() + str, null);
        }
        if (rawQuery != null) {
            this.kUl = rawQuery.getCount();
            x.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", Integer.valueOf(this.kUn), Integer.valueOf(this.kUl));
        } else {
            x.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", Integer.valueOf(this.kUn));
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
    }

    protected final void XI() {
        aUU();
        XH();
    }
}
