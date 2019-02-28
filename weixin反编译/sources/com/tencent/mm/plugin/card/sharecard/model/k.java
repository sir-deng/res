package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class k extends i<ShareCardInfo> {
    public static final String[] gLy = new String[]{i.a(ShareCardInfo.gKN, "ShareCardInfo")};
    public e gLA;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.model.k$1 */
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kQI = new int[a.avd().length];

        static {
            try {
                kQI[a.kRr - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kQI[a.kRs - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kQI[a.kRt - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static String od(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList oa = b.oa(i);
        if (oa == null || oa.size() <= 0) {
            return "";
        }
        stringBuilder.append(" (");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < oa.size()) {
                if (i3 != 0) {
                    stringBuilder.append(" OR ");
                }
                stringBuilder.append("card_id").append(" = '" + ((String) oa.get(i3)) + "' ");
                i2 = i3 + 1;
            } else {
                stringBuilder.append(") AND ");
                return stringBuilder.toString();
            }
        }
    }

    public k(e eVar) {
        super(eVar, ShareCardInfo.gKN, "ShareCardInfo", null);
        this.gLA = eVar;
    }

    public final ArrayList<String> wX(String str) {
        ArrayList<String> arrayList = null;
        x.i("MicroMsg.ShareCardInfoStorage", new StringBuilder("queryNameByCardtpId(), limit is 99").toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(new StringBuilder(" limit 99").toString());
        Cursor a = this.gLA.a("select ShareCardInfo.from_username from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), cursor == null");
        } else {
            int columnIndex = a.getColumnIndex("from_username");
            if (columnIndex == -1) {
                x.i("MicroMsg.ShareCardInfoStorage", "queryNameByCardtpId(), index is wrong");
                a.close();
            } else {
                arrayList = new ArrayList();
                while (a.moveToNext()) {
                    CharSequence string = a.getString(columnIndex);
                    if (TextUtils.isEmpty(string) || arrayList.contains(string)) {
                        x.e("MicroMsg.ShareCardInfoStorage", "the field_from_username is empty or username is added!, the card id is " + str);
                    } else {
                        arrayList.add(string);
                    }
                    if (arrayList.size() >= 99) {
                        break;
                    }
                }
                a.close();
            }
        }
        return arrayList;
    }

    public final int wY(String str) {
        int i = 0;
        x.i("MicroMsg.ShareCardInfoStorage", "getNormalCount()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        Cursor a = this.gLA.a("select count(*) from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "getNormalCount(), cursor == null");
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String wZ(String str) {
        x.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 1");
        Cursor a = this.gLA.a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryCardIdByCardtpId(), index is wrong");
            a.close();
            return "";
        }
        String str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(columnIndex);
        }
        a.close();
        return str2;
    }

    public final String ca(String str, String str2) {
        x.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId()");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str2 + "' )");
        stringBuilder.append(" order by share_time desc ");
        stringBuilder.append(" limit 2");
        Cursor a = this.gLA.a("select ShareCardInfo.card_id from ShareCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), cursor == null");
            return "";
        }
        int columnIndex = a.getColumnIndex("card_id");
        if (columnIndex == -1) {
            x.i("MicroMsg.ShareCardInfoStorage", "queryNewCardIdByCardtpId(), index is wrong");
            a.close();
            return "";
        }
        String str3 = "";
        while (a.moveToNext()) {
            str3 = a.getString(columnIndex);
            if (str != null && !str.equals(str3)) {
                break;
            }
        }
        a.close();
        return str3;
    }

    public final boolean oe(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (");
        stringBuilder.append("categoryType").append(" = '" + i + "'");
        stringBuilder.append(")");
        boolean fD = this.gLA.fD("ShareCardInfo", "update ShareCardInfo set categoryType = '0' , itemIndex = '0' " + stringBuilder.toString());
        x.i("MicroMsg.ShareCardInfoStorage", "resetCategoryInfo updateRet is " + (fD ? 1 : 0));
        return fD;
    }

    public final boolean E(String str, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where ( status=0) ");
        stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
        boolean fD = this.gLA.fD("ShareCardInfo", "update ShareCardInfo set categoryType = '" + i + "', itemIndex = '" + i2 + "' " + stringBuilder.toString());
        x.i("MicroMsg.ShareCardInfoStorage", "updateCategoryInfo updateRet is " + (fD ? 1 : 0));
        return fD;
    }

    public final void xa(String str) {
        this.gLA.fD("ShareCardInfo", "delete from ShareCardInfo where card_id = '" + str + "'");
    }

    public final ShareCardInfo xb(String str) {
        c shareCardInfo = new ShareCardInfo();
        shareCardInfo.field_card_id = str;
        return super.b(shareCardInfo, new String[0]) ? shareCardInfo : null;
    }
}
