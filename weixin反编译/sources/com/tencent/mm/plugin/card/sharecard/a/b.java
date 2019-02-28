package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean hlc = false;
    public static boolean kSJ = false;
    public a kSI = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        kSJ = false;
    }

    public final void init() {
        if (((l) am.avm().getValue("key_share_card_layout_data")) == null) {
            x.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            Object axP = com.tencent.mm.plugin.card.b.l.axP();
            if (TextUtils.isEmpty(axP)) {
                x.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                return;
            }
            l xE = s.xE(axP);
            if (xE != null) {
                x.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                am.avm().putValue("key_share_card_layout_data", xE);
                a(xE, true);
                return;
            }
            x.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            return;
        }
        x.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    }

    public static int avz() {
        int i = 0;
        c avh = am.avh();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) AND ").append("card_type=10");
        Cursor a = avh.gLA.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final void aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l xE = s.xE(str);
        l lVar = (l) am.avm().getValue("key_share_card_layout_data");
        if (xE == null) {
            x.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(xE, lVar, z);
            am.avm().putValue("key_share_card_layout_data", xE);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.card.b.l.xw(str);
        }
        a(xE, z);
        a(xE, lVar, z);
        am.avm().putValue("key_share_card_layout_data", xE);
        int i = 0;
        if (xE.kSX != null && xE.kSX.size() > 0) {
            i = xE.kSX.size();
        }
        if (xE.kSY != null && xE.kSY.size() > 0) {
            i += xE.kSY.size();
        }
        if (i > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(11);
            iDKey2.SetValue((long) currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(281);
            iDKey3.SetKey(12);
            iDKey3.SetValue((long) i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(281);
            iDKey4.SetKey(14);
            iDKey4.SetValue((long) (currentTimeMillis2 / i));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            g.pWK.a(arrayList, true);
        }
    }

    private void a(l lVar, boolean z) {
        int i = 0;
        if (lVar == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            return;
        }
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        m mVar;
        x.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) am.avm().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.avm().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) am.avm().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) am.avm().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) am.avm().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) am.avm().getValue("key_share_card_other_city_top_info_list");
        if (arrayList4 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList4;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList5 = new ArrayList();
        if (lVar.kSX != null && lVar.kSX.size() > 0) {
            for (int i2 = 0; i2 < lVar.kSX.size(); i2++) {
                mVar = (m) lVar.kSX.get(i2);
                if (!TextUtils.isEmpty(mVar.kTf)) {
                    hashMap.put(mVar.kPy, mVar.kTf);
                }
                hashMap2.put(mVar.kPy, Integer.valueOf(am.avp().wY(mVar.kPy)));
                hashMap3.put(mVar.kPy, l(am.avp().wX(mVar.kPy)));
                if (!arrayList5.contains(mVar.kPy)) {
                    CharSequence wZ = am.avp().wZ(mVar.kPy);
                    if (!TextUtils.isEmpty(wZ) && !arrayList.contains(wZ)) {
                        arrayList.add(wZ);
                    } else if (!arrayList.contains(mVar.fHP)) {
                        arrayList.add(mVar.fHP);
                    }
                    arrayList5.add(mVar.kPy);
                    p pVar = new p();
                    pVar.kPy = mVar.kPy;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
            }
        }
        arrayList5.clear();
        if (lVar.kSY != null && lVar.kSY.size() > 0) {
            while (i < lVar.kSY.size()) {
                mVar = (m) lVar.kSY.get(i);
                if (!TextUtils.isEmpty(mVar.kTf)) {
                    hashMap.put(mVar.kPy, mVar.kTf);
                }
                hashMap2.put(mVar.kPy, Integer.valueOf(am.avp().wY(mVar.kPy)));
                hashMap3.put(mVar.kPy, l(am.avp().wX(mVar.kPy)));
                if (!arrayList5.contains(mVar.kPy)) {
                    CharSequence wZ2 = am.avp().wZ(mVar.kPy);
                    if (!TextUtils.isEmpty(wZ2) && !arrayList2.contains(wZ2)) {
                        arrayList2.add(wZ2);
                    } else if (!arrayList2.contains(mVar.fHP)) {
                        arrayList2.add(mVar.fHP);
                    }
                    arrayList5.add(mVar.kPy);
                    p pVar2 = new p();
                    pVar2.kPy = mVar.kPy;
                    pVar2.top = mVar.top;
                    arrayList3.add(pVar2);
                }
                i++;
            }
        }
        am.avm().putValue("key_share_card_annoucement_map", hashMap);
        am.avm().putValue("key_share_card_count_map", hashMap2);
        am.avm().putValue("key_share_card_username_map", hashMap3);
        am.avm().putValue("key_share_card_local_city", lVar.kSZ);
        am.avm().putValue("key_share_card_local_city_ids", arrayList);
        am.avm().putValue("key_share_card_other_city_ids", arrayList2);
        am.avm().putValue("key_share_card_other_city_top_info_list", arrayList3);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        if (lVar == null && lVar2 == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
        } else if (lVar != null && lVar.kSY == null && lVar.kSX == null && lVar2 != null && lVar2.kSY == null && lVar2.kSX == null) {
            x.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            int i2;
            m mVar;
            x.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) am.avm().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) am.avm().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i3 = 0;
            if (z) {
                am.avp().oe(10);
                arrayList.clear();
                am.avp().oe(0);
                arrayList2.clear();
                i = 0;
                i3 = 0;
            } else {
                if (!(lVar2 == null || lVar2.kSX == null || lVar2.kSX.size() < 0)) {
                    i3 = lVar2.kSX.size();
                }
                if (lVar2 == null || lVar2.kSY == null || lVar2.kSY.size() < 0) {
                    i = i3;
                    i3 = 0;
                } else {
                    i = i3;
                    i3 = lVar2.kSY.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            as.Hm();
            long dA = com.tencent.mm.y.c.Fc().dA(Thread.currentThread().getId());
            if (lVar != null && lVar.kSX != null && lVar.kSX.size() > 0) {
                i2 = 0;
                while (true) {
                    int i4 = i2;
                    if (i4 >= lVar.kSX.size()) {
                        break;
                    }
                    mVar = (m) lVar.kSX.get(i4);
                    am.avp().E(mVar.kPy, 10, i4 + i);
                    i iVar = new i();
                    iVar.kPy = mVar.kPy;
                    iVar.kSS = i4 + i;
                    arrayList.add(iVar);
                    i2 = i4 + 1;
                }
                if (!(z || lVar2 == null || lVar2.kSX == null)) {
                    lVar.kSX.addAll(lVar2.kSX);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.kSX == null)) {
                lVar.kSX = lVar2.kSX;
            }
            am.avm().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.kSY != null && lVar.kSY.size() > 0) {
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= lVar.kSY.size()) {
                        break;
                    }
                    mVar = (m) lVar.kSY.get(i5);
                    am.avp().E(mVar.kPy, 0, i5 + i3);
                    i iVar2 = new i();
                    iVar2.kPy = mVar.kPy;
                    iVar2.kSS = i5 + i3;
                    arrayList2.add(iVar2);
                    i2 = i5 + 1;
                }
                if (!(z || lVar2 == null || lVar2.kSY == null)) {
                    lVar.kSY.addAll(lVar2.kSY);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.kSY == null)) {
                lVar.kSY = lVar2.kSY;
            }
            am.avm().putValue("key_share_card_other_city_category_info_list", arrayList2);
            as.Hm();
            com.tencent.mm.y.c.Fc().fT(dA);
            x.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static void avA() {
        ArrayList arrayList;
        ArrayList arrayList2;
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        long dA = com.tencent.mm.y.c.Fc().dA(Thread.currentThread().getId());
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) am.avm().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) am.avm().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            iVar = (i) arrayList.get(i);
            am.avp().E(iVar.kPy, 10, iVar.kSS);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            iVar = (i) arrayList2.get(i2);
            am.avp().E(iVar.kPy, 0, iVar.kSS);
        }
        as.Hm();
        com.tencent.mm.y.c.Fc().fT(dA);
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private String l(ArrayList<String> arrayList) {
        return a(this.mContext, (ArrayList) arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            Object gx = r.gx((String) arrayList.get(i));
            String gw = r.gw((String) arrayList.get(i));
            if (TextUtils.isEmpty(gx)) {
                stringBuilder.append(gw);
            } else {
                stringBuilder.append(gx);
            }
            i++;
        }
        if (context == null) {
            x.e("MicroMsg.ShareCardDataMgr", "context == null");
            return "";
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            return context.getString(R.l.dPB, new Object[]{stringBuilder.toString()});
        } else {
            return context.getString(R.l.dPn, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
        }
    }

    public static void wR(final String str) {
        x.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
            return;
        }
        final ag agVar = new ag(Looper.getMainLooper());
        e.post(new Runnable() {
            public final void run() {
                ArrayList arrayList = null;
                x.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
                k avp = am.avp();
                String str = str;
                x.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where ( status=0) ");
                stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
                stringBuilder.append(" order by share_time desc ");
                Cursor a = avp.gLA.a("select * from ShareCardInfo" + stringBuilder.toString(), null, 2);
                if (a == null) {
                    x.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        ShareCardInfo shareCardInfo = new ShareCardInfo();
                        shareCardInfo.b(a);
                        com.tencent.mm.plugin.card.sharecard.model.r rVar;
                        if (arrayList3.contains(shareCardInfo.field_from_username)) {
                            int i = 0;
                            rVar = null;
                            while (i < arrayList2.size()) {
                                rVar = (com.tencent.mm.plugin.card.sharecard.model.r) arrayList2.get(i);
                                if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar.kTk)) {
                                    break;
                                }
                                i++;
                            }
                            i = 0;
                            if (rVar != null) {
                                rVar.kTl.add(0, shareCardInfo.field_card_id);
                                rVar.cNO++;
                                arrayList2.set(i, rVar);
                            }
                        } else {
                            rVar = new com.tencent.mm.plugin.card.sharecard.model.r();
                            rVar.kPy = shareCardInfo.field_card_tp_id;
                            rVar.kTk = shareCardInfo.field_from_username;
                            rVar.kTl = new ArrayList();
                            rVar.kTl.add(shareCardInfo.field_card_id);
                            rVar.cNO = 1;
                            arrayList2.add(rVar);
                            arrayList3.add(shareCardInfo.field_from_username);
                        }
                    }
                    a.close();
                    arrayList = arrayList2;
                }
                x.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
                if (arrayList == null || arrayList.size() == 0) {
                    x.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
                    return;
                }
                if (arrayList.get(0) != null) {
                    ((com.tencent.mm.plugin.card.sharecard.model.r) arrayList.get(0)).kTm = true;
                }
                x.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
                agVar.post(new Runnable() {
                    public final void run() {
                        Map map = (Map) am.avm().getValue("key_share_user_info_map");
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(str, arrayList);
                        am.avm().putValue("key_share_user_info_map", map);
                    }
                });
            }
        }, "updateShareUserInfo_thread");
    }

    public static ArrayList<String> oa(int i) {
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) am.avm().getValue("key_share_card_local_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            x.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return ob(i);
        } else if (i != 2) {
            return null;
        } else {
            arrayList = (ArrayList) am.avm().getValue("key_share_card_other_city_ids");
            if (arrayList != null && arrayList.size() != 0) {
                return arrayList;
            }
            x.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + i);
            return ob(i);
        }
    }

    private static ArrayList<String> ob(int i) {
        int i2 = 0;
        l lVar = (l) am.avm().getValue("key_share_card_layout_data");
        if (lVar == null) {
            x.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = " + i);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3;
        m mVar;
        CharSequence wZ;
        if (i == 1) {
            if (lVar.kSX != null && lVar.kSX.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= lVar.kSX.size()) {
                        break;
                    }
                    mVar = (m) lVar.kSX.get(i3);
                    if (!arrayList2.contains(mVar.kPy)) {
                        wZ = am.avp().wZ(mVar.kPy);
                        if (!TextUtils.isEmpty(wZ) && !arrayList.contains(wZ)) {
                            arrayList.add(wZ);
                        } else if (!arrayList.contains(mVar.fHP)) {
                            arrayList.add(mVar.fHP);
                        }
                        arrayList2.add(mVar.kPy);
                    }
                    i2 = i3 + 1;
                }
                am.avm().putValue("key_share_card_local_city_ids", arrayList);
            }
            return arrayList;
        } else if (i != 2) {
            return null;
        } else {
            if (lVar.kSY != null && lVar.kSY.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= lVar.kSY.size()) {
                        break;
                    }
                    mVar = (m) lVar.kSY.get(i3);
                    if (!arrayList2.contains(mVar.kPy)) {
                        wZ = am.avp().wZ(mVar.kPy);
                        if (!TextUtils.isEmpty(wZ) && !arrayList.contains(wZ)) {
                            arrayList.add(wZ);
                        } else if (!arrayList.contains(mVar.fHP)) {
                            arrayList.add(mVar.fHP);
                        }
                        arrayList2.add(mVar.kPy);
                    }
                    i2 = i3 + 1;
                }
                am.avm().putValue("key_share_card_other_city_ids", arrayList);
            }
            return arrayList;
        }
    }

    public static void bX(String str, String str2) {
        if (hlc) {
            x.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            return;
        }
        CharSequence ca;
        x.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        hlc = true;
        ArrayList oa = oa(1);
        if (oa != null && oa.contains(str)) {
            oa.remove(str);
            ca = am.avp().ca(str, str2);
            if (!TextUtils.isEmpty(ca)) {
                oa.add(ca);
            }
            am.avm().putValue("key_share_card_local_city_ids", oa);
        }
        oa = oa(2);
        if (oa != null && oa.contains(str)) {
            oa.remove(str);
            ca = am.avp().ca(str, str2);
            if (!TextUtils.isEmpty(ca)) {
                oa.add(ca);
            }
            am.avm().putValue("key_share_card_other_city_ids", oa);
        }
        hlc = false;
    }

    public static void bY(String str, String str2) {
        x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList oa = oa(1);
        if (oa == null || !oa.contains(str)) {
            ArrayList oa2 = oa(2);
            if (oa2 == null || !oa2.contains(str)) {
                l lVar = (l) am.avm().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    x.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    return;
                }
                int wY = am.avp().wY(str2);
                int wT = wT(str2);
                x.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + wY + " cacheCount:" + wT);
                if (lVar.kSX != null && lVar.kSX.size() > 0 && (wT <= 0 || wY == 1)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= lVar.kSX.size()) {
                            break;
                        }
                        m mVar = (m) lVar.kSX.get(i2);
                        if (str2 == null || !str2.contains(mVar.kPy)) {
                            i = i2 + 1;
                        } else {
                            oa.add(str);
                            am.avm().putValue("key_share_card_local_city_ids", oa);
                            x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is " + str);
                            return;
                        }
                    }
                }
                x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                if (oa2 == null || (wT > 0 && wY != 1)) {
                    x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    return;
                }
                oa2.add(str);
                am.avm().putValue("key_share_card_other_city_ids", oa2);
                x.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is " + str);
            }
        }
    }

    public static int avB() {
        if (avD()) {
            return 1;
        }
        if (!avC()) {
            return 0;
        }
        if (kSJ) {
            return 3;
        }
        return 4;
    }

    public static boolean avC() {
        ArrayList arrayList = (ArrayList) am.avm().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean avD() {
        ArrayList arrayList = (ArrayList) am.avm().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public static String wS(String str) {
        Map map = (Map) am.avm().getValue("key_share_card_annoucement_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static int wT(String str) {
        Map map = (Map) am.avm().getValue("key_share_card_count_map");
        if (map == null) {
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String kr(String str) {
        Map map = (Map) am.avm().getValue("key_share_card_username_map");
        if (map == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public static ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> wU(String str) {
        Map map = (Map) am.avm().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private static void F(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        Map map = (Map) am.avm().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.tencent.mm.plugin.card.sharecard.model.r rVar = (com.tencent.mm.plugin.card.sharecard.model.r) arrayList.get(i);
            if (str3 != null && str3.equals(rVar.kTk)) {
                rVar.kTm = false;
                rVar.cNO--;
                rVar.kTl.remove(str);
                arrayList.set(i, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        am.avm().putValue("key_share_user_info_map", hashMap);
    }

    public static void avE() {
        x.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
                k avp = am.avp();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where (status=1 OR ").append("status=2 OR status").append("=3 OR status=4").append(" OR status=6)");
                x.i("MicroMsg.ShareCardInfoStorage", "delelteAllIllegalStatusCard updateRet is " + (avp.gLA.fD("ShareCardInfo", new StringBuilder("delete from ShareCardInfo").append(stringBuilder.toString()).toString()) ? 1 : 0));
                x.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
            }
        }, "delelteAllIllegalStatusCard");
    }

    public static void R(Context context, String str) {
        Map hashMap;
        x.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:" + str);
        Map map = (Map) am.avm().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.avm().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(am.avp().wY(str)));
        map.put(str, a(context, am.avp().wX(str)));
        am.avm().putValue("key_share_card_count_map", hashMap);
        am.avm().putValue("key_share_card_username_map", map);
    }

    public static boolean oc(int i) {
        Integer num = (Integer) am.avm().getValue("key_share_card_show_type");
        if (num == null) {
            return false;
        }
        if (num.intValue() == 0) {
            return false;
        }
        ArrayList arrayList;
        if (i == 0) {
            arrayList = (ArrayList) am.avm().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        } else if (i != 10) {
            return false;
        } else {
            arrayList = (ArrayList) am.avm().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean wV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) am.avm().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar != null && str.equals(pVar.kPy) && pVar.top == 1) {
                return true;
            }
        }
        return false;
    }

    public static void wW(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) am.avm().getValue("key_share_card_other_city_top_info_list");
            if (arrayList2 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList2;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    p pVar = (p) arrayList.get(i2);
                    if (pVar != null && str.equals(pVar.kPy) && pVar.top == 1) {
                        pVar.kTj = true;
                        arrayList.set(i2, pVar);
                        am.avm().putValue("key_share_card_other_city_top_info_list", arrayList);
                        return;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static String bZ(String str, String str2) {
        x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList wU = wU(str2);
            if (wU == null || wU.size() <= 0) {
                x.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
                return str;
            }
            com.tencent.mm.plugin.card.sharecard.model.r rVar = (com.tencent.mm.plugin.card.sharecard.model.r) wU.get(0);
            if (rVar == null || rVar.kTl == null || rVar.kTl.size() <= 0 || str.equals(rVar.kTl.get(0))) {
                x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                return str;
            }
            String str3 = (String) rVar.kTl.get(0);
            x.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
            return str3;
        }
        x.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        return str;
    }

    public static boolean avF() {
        l lVar = (l) am.avm().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.kTa;
    }

    public static boolean avG() {
        l lVar = (l) am.avm().getValue("key_share_card_layout_data");
        if (lVar == null) {
            return true;
        }
        return lVar.kTb;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        x.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        x.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.aum() + " cardtpid:" + bVar.aun());
        bX(bVar.aum(), bVar.aun());
        if (context != null) {
            R(context, bVar.aun());
        }
        F(bVar.aum(), bVar.aun(), bVar.auo());
        wR(bVar.aun());
    }
}
