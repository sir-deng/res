package com.tencent.mm.g;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ah;
import com.tencent.mm.f.a.ru;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    public a gCH;
    public Map<Integer, Long> gCI = new HashMap();
    public Map<Long, a> gCJ = new HashMap();
    public c gCK = new c<ah>() {
        {
            this.xmG = ah.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ah ahVar = (ah) bVar;
            com.tencent.mm.f.a.ah.a aVar = ahVar.fpb;
            b bVar2;
            long j;
            a aVar2;
            ru ruVar;
            switch (aVar.type) {
                case 1:
                    bVar2 = b.this;
                    String str = aVar.fpd;
                    j = bi.getLong(str, 0);
                    int i = aVar.position;
                    x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", str, Integer.valueOf(i), bVar2.gCH, Integer.valueOf(bVar2.gCJ.size()));
                    if (bVar2.gCJ.size() > 0 && j > 0) {
                        aVar2 = (a) bVar2.gCJ.get(Long.valueOf(j));
                        if (aVar2 != null) {
                            x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", aVar2);
                            if (i <= 0) {
                                Collection values = aVar2.gCR.values();
                                if (values != null) {
                                    Iterator it = values.iterator();
                                    if (it != null) {
                                        while (it.hasNext()) {
                                            ruVar = (ru) it.next();
                                            if (ruVar != null && ruVar.fKs.visible) {
                                                x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Long.valueOf(j), Boolean.valueOf(ruVar.fKs.visible));
                                                ruVar.fKs.visible = false;
                                                com.tencent.mm.sdk.b.a.xmy.m(ruVar);
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            ruVar = (ru) aVar2.gCR.get(Integer.valueOf(i));
                            if (ruVar != null) {
                                x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Integer.valueOf(i), Boolean.valueOf(ruVar.fKs.visible));
                                if (ruVar.fKs.visible) {
                                    ruVar.fKs.visible = false;
                                    com.tencent.mm.sdk.b.a.xmy.m(ruVar);
                                    g.pWK.h(13939, Integer.valueOf(2));
                                    break;
                                }
                            }
                            x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", Integer.valueOf(i));
                        } else {
                            x.i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                        }
                    }
                    if (bVar2.gCH != null) {
                        if (!bi.oN(str) && !str.equals(bVar2.gCH.gCO)) {
                            x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", bVar2.gCH.gCO, str);
                            break;
                        }
                        ruVar = (ru) bVar2.gCH.gCR.get(Integer.valueOf(0));
                        if (ruVar != null && ruVar.fKs.visible) {
                            g.pWK.h(13939, Integer.valueOf(2));
                            ruVar.fKs.visible = false;
                            com.tencent.mm.sdk.b.a.xmy.m(ruVar);
                            break;
                        }
                    }
                    break;
                case 2:
                    bVar2 = b.this;
                    int i2 = ahVar.fpb.position;
                    x.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", Integer.valueOf(i2), bVar2.gCH, Integer.valueOf(bVar2.gCI.size()));
                    if (i2 <= 0 || bVar2.gCI.size() <= 0) {
                        if (bVar2.gCH != null) {
                            ruVar = (ru) bVar2.gCH.gCR.get(Integer.valueOf(0));
                            if (ruVar != null) {
                                ahVar.fpc.desc = ruVar.fKs.desc;
                                ahVar.fpc.fpe = ruVar.fKs.fpe;
                                ahVar.fpc.showType = ruVar.fKs.showType;
                                ahVar.fpc.url = ruVar.fKs.url;
                                ahVar.fpc.visible = ruVar.fKs.visible;
                                ahVar.fpc.fph = ruVar.fKs.fph;
                                ahVar.fpc.fpf = ruVar.fKs.fpf;
                                ahVar.fpc.fpg = ruVar.fKs.fpg;
                                ahVar.fpc.fpi = ruVar.fKs.fpi;
                                ahVar.fpc.position = ruVar.fKs.position;
                                if (ruVar.fKs.visible) {
                                    g.pWK.h(13936, Integer.valueOf(i2));
                                }
                                bVar2.xA();
                                break;
                            }
                        }
                    }
                    j = bi.a((Long) bVar2.gCI.get(Integer.valueOf(i2)), 0);
                    x.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", Integer.valueOf(i2), Long.valueOf(j));
                    if (j > 0) {
                        aVar2 = (a) bVar2.gCJ.get(Long.valueOf(j));
                        if (aVar2 != null) {
                            ruVar = (ru) aVar2.gCR.get(Integer.valueOf(i2));
                            if (ruVar != null) {
                                ahVar.fpc.desc = ruVar.fKs.desc;
                                ahVar.fpc.fpe = ruVar.fKs.fpe;
                                ahVar.fpc.showType = ruVar.fKs.showType;
                                ahVar.fpc.url = ruVar.fKs.url;
                                ahVar.fpc.visible = ruVar.fKs.visible;
                                ahVar.fpc.fph = ruVar.fKs.fph;
                                ahVar.fpc.fpf = ruVar.fKs.fpf;
                                ahVar.fpc.fpg = ruVar.fKs.fpg;
                                ahVar.fpc.fpi = ruVar.fKs.fpi;
                                ahVar.fpc.position = ruVar.fKs.position;
                                if (ruVar.fKs.visible) {
                                    g.pWK.h(13936, Integer.valueOf(i2));
                                    break;
                                }
                            }
                        }
                        bVar2.gCI.remove(Integer.valueOf(i2));
                        break;
                    }
                    break;
                case 4:
                    b.this.eD(aVar.fpd);
                    break;
                case 5:
                    b.this.a(ahVar);
                    break;
            }
            return false;
        }
    };

    static class a {
        String gCO = null;
        long gCP = 0;
        String gCQ = null;
        Map<Integer, ru> gCR = new HashMap();

        a() {
        }

        public final String toString() {
            String str;
            String str2 = "";
            Iterator it = this.gCR.keySet().iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str + ((Integer) it.next()) + ",";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            return String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[]{Integer.valueOf(hashCode()), this.gCO, Long.valueOf(this.gCP), this.gCQ, str});
        }
    }

    final boolean a(ah ahVar) {
        String str = ahVar.fpb.fpd;
        String str2 = "MicroMsg.BroadcastController";
        String str3 = "summerdiz handleNewDisaster xml len[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        x.i(str2, str3, objArr);
        Map y = bj.y(str, "e");
        if (y == null) {
            x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
            return false;
        }
        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", y);
        long j = bi.getLong((String) y.get(".e.NoticeId"), 0);
        if (j <= 0) {
            x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
        }
        if (!r.igO) {
            try {
                if (bi.bz(bi.getLong((String) y.get(".e.ExpiredTime"), 0)) > 0) {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", Long.valueOf(bi.getLong((String) y.get(".e.ExpiredTime"), 0)));
                    return false;
                }
            } catch (Exception e) {
                x.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
            }
        }
        a aVar = new a();
        aVar.gCO = String.valueOf(j);
        String string = ad.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
        if (r.igP || !string.contains(aVar.gCO)) {
            a aVar2;
            if (this.gCJ.size() > 0) {
                a aVar3 = (a) this.gCJ.get(Long.valueOf(j));
                if (aVar3 != null) {
                    x.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", aVar3);
                    aVar2 = aVar3;
                } else {
                    this.gCJ.put(Long.valueOf(j), aVar);
                    aVar2 = aVar;
                }
            } else {
                this.gCJ.put(Long.valueOf(j), aVar);
                aVar2 = aVar;
            }
            string = (String) y.get(".e.Position");
            if (bi.oN(string)) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
                return false;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = string.split(",");
            if (split == null || split.length <= 0) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
                return false;
            }
            Object obj = null;
            int length = split.length;
            int i = 0;
            while (i < length) {
                Object obj2;
                int i2 = bi.getInt(split[i], 0);
                if (i2 > 0) {
                    if (i2 == 1) {
                        obj2 = 1;
                        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", Integer.valueOf(i2));
                        i++;
                        obj = obj2;
                    } else {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
            if (obj == null && arrayList.size() == 0) {
                x.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
                return false;
            }
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", w.eM(ad.getContext()));
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i3 = 0;
            while (true) {
                str2 = ".e.Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                string = (String) y.get(str2 + ".Language");
                if (string == null && i3 > 3) {
                    str = null;
                    string = null;
                    str2 = null;
                    break;
                } else if (r18.equalsIgnoreCase(string)) {
                    string = (String) y.get(str2 + ".Content");
                    str = (String) y.get(str2 + ".Url");
                    str2 = (String) y.get(str2 + ".Tips");
                    break;
                } else {
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) y.get(str2 + ".Content");
                        str = (String) y.get(str2 + ".Url");
                        str2 = (String) y.get(str2 + ".Tips");
                    } else {
                        str2 = str6;
                        str = str5;
                        string = str4;
                    }
                    str5 = str;
                    str4 = string;
                    i3++;
                    str6 = str2;
                }
            }
            x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", string, str2);
            if (bi.oN(string)) {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
            } else {
                str5 = str;
                str4 = string;
                str6 = str2;
            }
            if (bi.oN(str5)) {
                str5 = ad.getContext().getString(R.l.dZd);
            }
            if (obj != null) {
                if (bi.oN(str4)) {
                    str4 = ad.getContext().getString(R.l.dYY);
                }
                if (bi.oN(str6)) {
                    str6 = ad.getContext().getString(R.l.dZb);
                }
                ahVar.fpc.desc = str4;
                ahVar.fpc.fpe = 30;
                ahVar.fpc.showType = 0;
                ahVar.fpc.url = str5;
                ahVar.fpc.visible = true;
                ahVar.fpc.fph = 0;
                ahVar.fpc.fpf = 6;
                ahVar.fpc.fpg = "";
                ahVar.fpc.fpi = String.valueOf(j);
                ahVar.fpc.position = 1;
            }
            if (arrayList.size() == 0) {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
                return false;
            } else if (aVar2.gCP == 0 || bi.bB(aVar2.gCP) >= 1800000) {
                aVar2.gCP = bi.Wz();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Long valueOf = Long.valueOf(bi.a((Long) this.gCI.get(num), 0));
                    if (valueOf.longValue() <= 0 || valueOf.longValue() < j) {
                        ru ruVar;
                        ru ruVar2 = (ru) aVar2.gCR.get(num);
                        if (ruVar2 == null) {
                            ruVar2 = new ru();
                            ruVar2.fKs.showType = 0;
                            ruVar2.fKs.fpe = 30;
                            ruVar2.fKs.fpg = "";
                            ruVar2.fKs.fph = R.i.dop;
                            ruVar2.fKs.position = num.intValue();
                            aVar2.gCR.put(num, ruVar2);
                            ruVar = ruVar2;
                        } else {
                            ruVar = ruVar2;
                        }
                        if (bi.oN(str6)) {
                            str = str4;
                        } else {
                            str = str6;
                        }
                        if (bi.oN(str)) {
                            i = R.l.dZa;
                            switch (num.intValue()) {
                                case 2:
                                    i = R.l.dZc;
                                    break;
                                case 3:
                                case 4:
                                    i = R.l.dYZ;
                                    break;
                            }
                            str = ad.getContext().getString(i);
                        }
                        ruVar.fKs.desc = str;
                        ruVar.fKs.url = str5;
                        ruVar.fKs.visible = true;
                        ruVar.fKs.fpf = 2;
                        ruVar.fKs.fpi = aVar2.gCO;
                        this.gCI.put(num, Long.valueOf(j));
                        if (obj == null) {
                            ahVar.fpc.desc = str;
                            ahVar.fpc.fpe = 30;
                            ahVar.fpc.showType = 0;
                            ahVar.fpc.url = str5;
                            ahVar.fpc.visible = true;
                            ahVar.fpc.fph = R.i.dop;
                            ahVar.fpc.fpf = 2;
                            ahVar.fpc.fpg = "";
                            ahVar.fpc.fpi = String.valueOf(j);
                            ahVar.fpc.position = num.intValue();
                        }
                        com.tencent.mm.sdk.platformtools.ah.y(new Runnable() {
                            public final void run() {
                                com.tencent.mm.sdk.b.a.xmy.m(ruVar);
                            }
                        });
                        str6 = str;
                    } else {
                        x.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", num, valueOf, Long.valueOf(j));
                    }
                }
                return true;
            } else {
                x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
                return false;
            }
        }
        x.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", string, aVar.gCO);
        return false;
    }

    final boolean eD(String str) {
        String str2 = null;
        x.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", this.gCH, str);
        if (bi.oN(str) || str.indexOf("<") < 0) {
            return false;
        }
        Map y = bj.y(str, "e");
        if (y == null) {
            x.e("MicroMsg.BroadcastController", "this is not errmsg");
            return false;
        }
        ru ruVar;
        if (this.gCH == null) {
            this.gCH = new a();
            ruVar = new ru();
            this.gCH.gCR.put(Integer.valueOf(0), ruVar);
            ruVar.fKs.desc = "";
            ruVar.fKs.url = "";
            ruVar.fKs.showType = 0;
            ruVar.fKs.fpe = 30;
            ruVar.fKs.visible = false;
            ruVar.fKs.fpg = "";
            ruVar.fKs.fpf = 0;
            ruVar.fKs.fph = R.i.dop;
            ruVar.fKs.fpi = "";
            ruVar.fKs.position = 0;
        }
        if (!r.igN) {
            if (this.gCH.gCP == 0 || bi.bB(this.gCH.gCP) >= 1800000) {
                this.gCH.gCP = bi.Wz();
            } else {
                x.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                return false;
            }
        }
        if (!r.igO) {
            try {
                if (bi.bz(bi.getLong((String) y.get(".e.ExpiredTime"), 0)) > 0) {
                    x.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", Long.valueOf(bi.getLong((String) y.get(".e.ExpiredTime"), 0)));
                    return false;
                }
            } catch (Exception e) {
                x.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
            }
        }
        this.gCH.gCO = (String) y.get(".e.NoticeId");
        String string = ad.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
        if (r.igP || !string.contains(this.gCH.gCO)) {
            String str3;
            String eM = w.eM(ad.getContext());
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i = 0;
            while (true) {
                str3 = ".e.Item" + (i == 0 ? "" : Integer.valueOf(i));
                string = (String) y.get(str3 + ".Language");
                String str7;
                if (string == null && i > 3) {
                    string = null;
                    str3 = null;
                    break;
                } else if (eM.equalsIgnoreCase(string)) {
                    string = (String) y.get(str3 + ".Content");
                    str7 = (String) y.get(str3 + ".Url");
                    str3 = (String) y.get(str3 + ".Tips");
                    str2 = str7;
                    break;
                } else {
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) y.get(str3 + ".Content");
                        str7 = (String) y.get(str3 + ".Url");
                        str3 = (String) y.get(str3 + ".Tips");
                    } else {
                        str3 = str4;
                        str7 = str5;
                        string = str6;
                    }
                    str5 = str7;
                    str6 = string;
                    i++;
                    str4 = str3;
                }
            }
            if (bi.oN(string)) {
                x.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
            } else {
                str5 = str2;
                str6 = string;
                str4 = str3;
            }
            if (bi.oN(str5)) {
                str5 = ad.getContext().getString(R.l.dZd);
            }
            if (bi.oN(str6)) {
                x.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                str6 = ad.getContext().getString(R.l.dYX);
            }
            if (bi.oN(str4)) {
                if (bi.oN(str6)) {
                    str4 = ad.getContext().getString(R.l.dZa);
                } else {
                    str4 = str6;
                }
            }
            ruVar = (ru) this.gCH.gCR.get(Integer.valueOf(0));
            ruVar.fKs.desc = str4;
            ruVar.fKs.url = str5;
            ruVar.fKs.visible = true;
            ruVar.fKs.fpf = 2;
            ruVar.fKs.fpi = this.gCH.gCO;
            com.tencent.mm.sdk.platformtools.ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
                    com.tencent.mm.sdk.b.a.xmy.m(ruVar);
                }
            });
            this.gCH.gCQ = str6;
            if (as.CN().foreground) {
                xA();
            }
            return true;
        }
        x.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", string, this.gCH.gCO);
        return false;
    }

    final void xA() {
        if (this.gCH != null && this.gCH.gCR.get(Integer.valueOf(0)) != null && !bi.oN(this.gCH.gCQ)) {
            x.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", this.gCH.gCQ);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", this.gCH.gCQ);
            intent.putExtra("key_disaster_url", ((ru) this.gCH.gCR.get(Integer.valueOf(0))).fKs.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
            this.gCH.gCQ = null;
        }
    }
}
