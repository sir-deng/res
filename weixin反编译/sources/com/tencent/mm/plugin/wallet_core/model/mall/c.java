package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static c sWT = null;
    public Map<String, MallNews> sWU = new HashMap();

    public static c bMQ() {
        if (sWT == null) {
            sWT = new c();
        }
        return sWT;
    }

    private c() {
        Xc();
    }

    public final void Xc() {
        this.sWU.clear();
        g.Dr();
        String str = (String) g.Dq().Db().get(270339, (Object) "");
        x.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bi.F(str2.split(";"))) {
            MallNews NH = NH(str2);
            if (NH != null) {
                this.sWU.put(NH.sWK, NH);
            }
        }
    }

    public final List<String> bMR() {
        List<String> arrayList = new ArrayList();
        for (MallNews mallNews : this.sWU.values()) {
            if (!bi.oN(mallNews.fsK)) {
                arrayList.add(mallNews.fsK);
            }
        }
        x.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        return arrayList;
    }

    public static boolean a(MallNews mallNews) {
        g.Dr();
        List F = bi.F(((String) g.Dq().Db().get(a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, (Object) "")).split(","));
        x.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", r0);
        if (mallNews == null) {
            return false;
        }
        if (bi.oN(mallNews.sbN)) {
            return false;
        }
        if (F.contains(mallNews.sbN)) {
            return true;
        }
        return false;
    }

    public static void c(MallFunction mallFunction) {
        try {
            if (!bi.oN(mallFunction.sWC.sbN)) {
                g.Dr();
                List F = bi.F(((String) g.Dq().Db().get(a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, (Object) "")).split(","));
                while (F.size() > 20) {
                    F.remove(0);
                }
                if (!F.contains(mallFunction.sWC.sbN)) {
                    F.add(mallFunction.sWC.sbN);
                    x.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", mallFunction.sWC.sbN, bi.d(F, ","));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, r0);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallNewsManager", e, "error in markedFunction", new Object[0]);
        }
    }

    public static void NE(String str) {
        if (!bi.oN(str)) {
            Map y = bj.y(str, "sysmsg");
            if (y != null) {
                int i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                Object obj;
                int i2;
                if (i == 31) {
                    obj = (String) y.get(".sysmsg.paymsg.WalletRedDotWording");
                    i2 = bi.getInt((String) y.get(".sysmsg.paymsg.WalletRedDot"), -1);
                    x.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", obj, Integer.valueOf(bi.getInt((String) y.get(".sysmsg.paymsg.BalanceRedDot"), -1)), Integer.valueOf(bi.getInt((String) y.get(".sysmsg.paymsg.LQTRedDot"), -1)));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, obj);
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i2));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQT_BALANCE_RED_DOT_INT, Integer.valueOf(r4));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(r1));
                    bMT();
                } else if (i == 34) {
                    Set<String> keySet = y.keySet();
                    x.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet.toString());
                    if (keySet.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (String str2 : keySet) {
                            String str22;
                            if (str22.startsWith(".sysmsg.paymsg.reddot.item")) {
                                str22 = (String) y.get(str22);
                                if (!bi.oN(str22)) {
                                    x.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot", str22);
                                    if ("mainentry_me".equals(str22)) {
                                        com.tencent.mm.r.c.Bx().p(262156, true);
                                    } else if ("entry_wxpay_wallet".equals(str22)) {
                                        com.tencent.mm.r.c.Bx().p(262156, true);
                                    } else if ("entry_wxpay_paycenter".equals(str22)) {
                                        g.Dr();
                                        g.Dq().Db().a(a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(true));
                                    } else {
                                        try {
                                            jSONObject.put(str22, 1);
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.MallNewsManager", e, "put redDotConfig json failed: %s", e.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                        x.i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject.toString());
                        if (jSONObject.length() > 0) {
                            g.Dr();
                            g.Dq().Db().a(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                            g.Dr();
                            g.Dq().Db().a(a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(true));
                        }
                    }
                } else if (i == 36) {
                    x.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", (String) y.get(".sysmsg.paymsg.WalletRedDotWording"), Integer.valueOf(bi.getInt((String) y.get(".sysmsg.paymsg.WalletRedDot"), -1)), Integer.valueOf(bi.getInt((String) y.get(".sysmsg.paymsg.LQBRedDot"), -1)));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, obj);
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i2));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LQB_MALL_ENTRY_RED_DOT_INT, Integer.valueOf(r1));
                    bMT();
                }
            }
        }
    }

    public static void bMS() {
        g.Dr();
        g.Dq().Db().a(a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
        g.Dr();
        g.Dq().Db().a(a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1));
    }

    public static void bMT() {
        x.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.r.c.Bx().aS(262156, 266248);
    }

    public final boolean bjN() {
        x.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.sWU.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.sWU.keySet()) {
            if (!bi.oN(str)) {
                MallNews mallNews = (MallNews) this.sWU.get(str);
                stringBuffer.append(mallNews.sWR.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.sWI + "</showflag><newsTipFlag>" + mallNews.sWJ + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        x.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.Dr();
        g.Dq().Db().set(270339, stringBuffer.toString());
        return true;
    }

    public final String NF(String str) {
        MallNews mallNews = (MallNews) this.sWU.get(str);
        if (mallNews == null || bi.oN(mallNews.fsK)) {
            return null;
        }
        return mallNews.fsK;
    }

    public final MallNews NG(String str) {
        x.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
        if (bi.oN(str) || !this.sWU.containsKey(str)) {
            return null;
        }
        MallNews mallNews = (MallNews) this.sWU.get(str);
        if (!"0".equals(mallNews.sWI)) {
            return mallNews;
        }
        mallNews.sWI = "1";
        bjN();
        return mallNews;
    }

    public static MallNews NH(String str) {
        if (bi.oN(str)) {
            return null;
        }
        Map y = bj.y(str, "sysmsg");
        if (y == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) y.get(".sysmsg.mallactivity.functionid"));
            mallNews.sbN = (String) y.get(".sysmsg.mallactivity.activityid");
            mallNews.fsK = (String) y.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) y.get(".sysmsg.mallactivity.type");
            mallNews.showType = bi.getInt((String) y.get(".sysmsg.mallactivity.showtype"), 0);
            if (y.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.sWI = (String) y.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.sWI = "0";
            }
            if (y.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.sWJ = (String) y.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.sWJ = "0";
            }
            mallNews.sWR = str;
            if (bi.oN(mallNews.sWK)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            x.e("MicroMsg.MallNewsManager", "cmdid error");
            return null;
        }
    }

    public final void S(ArrayList<MallFunction> arrayList) {
        if (arrayList != null) {
            Set<String> hashSet = new HashSet(this.sWU.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(((MallFunction) it.next()).pHt);
            }
            for (String remove : hashSet) {
                this.sWU.remove(remove);
            }
            bjN();
        }
    }
}
