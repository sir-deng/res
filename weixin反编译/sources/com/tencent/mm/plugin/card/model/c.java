package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<CardInfo> {
    public static final String[] gLy = new String[]{i.a(CardInfo.gKN, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) "};
    public e gLA;

    /* renamed from: com.tencent.mm.plugin.card.model.c$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] kQI = new int[a.avd().length];

        static {
            try {
                kQI[a.kRr - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kQI[a.kRv - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kQI[a.kRw - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kQI[a.kRu - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                kQI[a.kRs - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                kQI[a.kRt - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public c(e eVar) {
        super(eVar, CardInfo.gKN, "UserCardInfo", null);
        this.gLA = eVar;
    }

    public final Cursor nZ(int i) {
        this.gLA.fD("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + bi.Wx() + ">stickyEndTime and stickyEndTime" + "<>0)");
        StringBuilder stringBuilder = new StringBuilder("select * from UserCardInfo");
        switch (AnonymousClass1.kQI[i - 1]) {
            case 1:
                stringBuilder.append(" where (status=0 OR ").append("status=5)");
                break;
            case 2:
            case 3:
                stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
                break;
            case 4:
                stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type!=10");
                break;
            case 5:
                stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                break;
            case 6:
                stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
                break;
        }
        stringBuilder.append(" order by stickyIndex desc, status asc , updateTime desc");
        if (i == a.kRw) {
            stringBuilder.append(" LIMIT 3");
        }
        return this.gLA.rawQuery(stringBuilder.toString(), null);
    }

    public final CardInfo wL(String str) {
        com.tencent.mm.sdk.e.c cardInfo = new CardInfo();
        cardInfo.field_card_id = str;
        return super.b(cardInfo, new String[0]) ? cardInfo : null;
    }

    public final List<CardInfo> auW() {
        Cursor rawQuery = this.gLA.rawQuery("select * from UserCardInfo where is_dynamic=?", new String[]{"1"});
        if (rawQuery == null) {
            x.e("MicroMsg.CardInfoStorage", "getCardInfoList by is_dynamic is failure! cu is null!");
            return null;
        }
        List<CardInfo> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                CardInfo cardInfo = new CardInfo();
                cardInfo.b(rawQuery);
                arrayList.add(cardInfo);
            } catch (Exception e) {
                x.e("MicroMsg.CardInfoStorage", new StringBuilder("getCardInfoList by is_dynamic is failure! is_dynamic = true").toString(), e.getMessage());
                return arrayList;
            } finally {
                rawQuery.close();
            }
        }
        return arrayList;
    }
}
