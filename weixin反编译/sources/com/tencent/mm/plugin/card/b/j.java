package com.tencent.mm.plugin.card.b;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.protocal.c.lp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    public static void a(LinkedList<ln> linkedList, int i) {
        if (linkedList != null) {
            int size = linkedList.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < linkedList.size()) {
                    ln lnVar = (ln) linkedList.get(i3);
                    c avh = am.avh();
                    String str = lnVar.fHP;
                    int i4 = ((size - i3) * 10) + i;
                    String str2 = lnVar.kTf;
                    i2 = lnVar.ceA;
                    if (bi.oN(str)) {
                        x.w("MicroMsg.CardInfoStorage", "cardId null");
                    } else {
                        avh.gLA.fD("UserCardInfo", "update UserCardInfo set stickyIndex=" + i4 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i2 + " where card_id='" + str + "'");
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void b(LinkedList<ln> linkedList, int i) {
        if (linkedList != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < linkedList.size()) {
                    ln lnVar = (ln) linkedList.get(i3);
                    am.avh().gLA.fD("UserCardInfo", "update UserCardInfo set stickyIndex=" + i + ", label_wording='" + (lnVar.wbh != null ? lnVar.wbh : "") + "' where card_id='" + lnVar.fHP + "'");
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static aay xt(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.CardStickyHelper", "jsonRet null");
            return null;
        }
        aay aay = new aay();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aay.wqC = jSONObject.optString("layout_buff");
            JSONObject jSONObject2 = jSONObject.getJSONObject("list");
            if (jSONObject2 != null) {
                aay.wqF = new lp();
                aay.wqF.wbj = F(jSONObject2.optJSONObject("expiring_list"));
                aay.wqF.wbk = F(jSONObject2.optJSONObject("member_card_list"));
                aay.wqF.wbl = F(jSONObject2.optJSONObject("nearby_list"));
                aay.wqF.wbm = F(jSONObject2.optJSONObject("label_list"));
                aay.wqF.wbn = F(jSONObject2.optJSONObject("first_list"));
                if (!(aay.wqF.wbn == null || aay.wqF.wbn.wbi == null)) {
                    for (int size = aay.wqF.wbn.wbi.size() - 1; size >= 0; size--) {
                        ln lnVar = (ln) aay.wqF.wbn.wbi.get(size);
                        if (!bi.oN(lnVar.fHP)) {
                            CardInfo wL = am.avh().wL(lnVar.fHP);
                            if (!(wL == null || wL.atP())) {
                                aay.wqF.wbn.wbi.remove(size);
                            }
                        }
                    }
                }
                aay.wqG = jSONObject2.optString("red_dot_wording");
                aay.wqH = jSONObject2.optInt("show_red_dot", 0) == 1;
                Object optString = jSONObject2.optString("title");
                if (optString == null) {
                    optString = "";
                }
                am.avm().putValue("key_card_entrance_tips", optString);
                aay.wqI = jSONObject2.optInt("top_scene", 100);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return aay;
    }

    private static lo F(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            return null;
        }
        lo loVar = new lo();
        loVar.wbi = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("item_list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ln lnVar;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    lnVar = null;
                } else {
                    lnVar = new ln();
                    lnVar.kTf = jSONObject2.optString("announcement");
                    lnVar.fHP = jSONObject2.optString("card_id");
                    lnVar.ceA = jSONObject2.optInt("end_time", 0);
                    lnVar.wbg = jSONObject2.optInt("update_time", 0);
                    lnVar.wbh = jSONObject2.optString("label_wording");
                }
                if (lnVar == null || (((long) lnVar.ceA) <= bi.Wx() && lnVar.ceA != 0)) {
                    x.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    loVar.wbi.add(lnVar);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return loVar;
    }

    public static String a(Context context, int i, CardInfo cardInfo) {
        switch (i % 10) {
            case 0:
                return context.getString(R.l.dPT);
            case 1:
                return context.getString(R.l.dPS);
            case 2:
                return context.getString(R.l.dPR);
            case 3:
                return context.getString(R.l.dPQ);
            case 4:
                return cardInfo.field_label_wording;
            default:
                return null;
        }
    }
}
