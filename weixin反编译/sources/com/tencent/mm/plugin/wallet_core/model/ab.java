package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ab {
    public static void a(JSONObject jSONObject, int i) {
        x.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard()");
        try {
            af afVar;
            JSONObject optJSONObject;
            Object obj;
            Bankcard bankcard;
            JSONObject optJSONObject2;
            Bankcard bankcard2;
            Object aD;
            k kVar;
            Bankcard bankcard3;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                n.setTimeStamp(String.valueOf(optLong));
            } else {
                x.w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            x.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
            af afVar2 = new af();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
                afVar = null;
            } else {
                afVar2.field_is_reg = jSONObject2.getInt("is_reg");
                afVar2.field_true_name = jSONObject2.optString("true_name");
                afVar2.field_cre_type = jSONObject2.optInt("cre_type", -1);
                afVar2.field_main_card_bind_serialno = jSONObject2.optString("last_card_bind_serialno");
                afVar2.field_cre_name = jSONObject2.optString("cre_name");
                afVar2.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                afVar2.field_reset_passwd_flag = jSONObject2.optString("reset_passwd_flag");
                afVar2.field_find_passwd_url = jSONObject2.optString("reset_passwd_url");
                o.bMc();
                ag.ND(afVar2.field_main_card_bind_serialno);
                afVar2.field_isDomesticUser = "2".equals(jSONObject2.optString("icard_user_flag", "2"));
                optJSONObject = jSONObject2.optJSONObject("touch_info");
                if (optJSONObject != null) {
                    afVar2.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
                    x.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is " + afVar2.field_is_open_touch);
                } else {
                    x.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
                    afVar2.field_is_open_touch = o.bMc().bMA() ? 1 : 0;
                    x.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + afVar2.field_is_open_touch);
                }
                afVar2.field_lct_wording = jSONObject2.optString("lct_wording");
                afVar2.field_lct_url = jSONObject2.optString("lct_url");
                x.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + afVar2.field_lct_wording + ", field_lct_url:" + afVar2.field_lct_url);
                afVar2.field_lqt_state = jSONObject2.optInt("lqt_state", -1);
                optJSONObject = jSONObject2.optJSONObject("lqb_show_info");
                x.i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s, lqb_show_info: %s", Integer.valueOf(afVar2.field_lqt_state), optJSONObject);
                if (optJSONObject != null) {
                    afVar2.field_is_show_lqb = optJSONObject.optInt("is_show_lqb");
                    afVar2.field_is_open_lqb = optJSONObject.optInt("is_open_lqb");
                    afVar2.field_lqb_open_url = optJSONObject.optString("lqb_open_url");
                }
                if (zB(i) || i == 3 || i == 4) {
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(afVar2.field_lqt_state));
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, afVar2.field_lct_wording);
                }
                afVar = afVar2;
            }
            afVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            afVar.field_paymenu_use_new = jSONObject.optInt("paymenu_use_new");
            x.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard, paymenu_use_new: %s", Integer.valueOf(afVar.field_paymenu_use_new));
            String optString = jSONObject.optString("support_bank_word");
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, bi.oM(optString));
            ArrayList t = t(jSONObject.optJSONArray("Array"));
            ArrayList u = u(jSONObject.optJSONArray("virtual_card_array"));
            JSONObject optJSONObject3 = jSONObject.optJSONObject("balance_info");
            String str = "MicroMsg.WalletQueryBankcardParser";
            String str2 = "Bankcard getBalance %s";
            Object[] objArr = new Object[1];
            if (optJSONObject3 == null) {
                optString = "";
            } else {
                obj = optJSONObject3;
            }
            objArr[0] = optString;
            x.i(str, str2, objArr);
            if (optJSONObject3 == null || optJSONObject3.length() <= 0) {
                x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
                bankcard = null;
            } else {
                boolean z;
                Bankcard bankcard4 = new Bankcard((byte) 0);
                a(bankcard4, optJSONObject3.optLong("balance_version", -1), optJSONObject3.optLong("time_out", 7200), optJSONObject3.optInt("avail_balance"));
                bankcard4.sRo = ((double) optJSONObject3.optInt("avail_balance")) / 100.0d;
                bankcard4.sRp = optJSONObject3.optString("balance_show_wording");
                bankcard4.sRs = optJSONObject3.optString("max_fetch_wording");
                bankcard4.sRt = optJSONObject3.optString("avail_fetch_wording");
                bankcard4.sRq = ((double) optJSONObject3.optInt("fetch_balance")) / 100.0d;
                bankcard4.field_cardType |= Bankcard.sRe;
                bankcard4.field_bankcardType = optJSONObject3.optString("balance_bank_type");
                bankcard4.field_bindSerial = optJSONObject3.optString("balance_bind_serial");
                bankcard4.field_forbidWord = optJSONObject3.optString("balance_forbid_word");
                if (bi.oN(bankcard4.field_forbidWord)) {
                    bankcard4.field_bankcardState = 0;
                } else {
                    bankcard4.field_bankcardState = 8;
                }
                bankcard4.field_fetchArriveTime = optJSONObject3.optLong("fetch_arrive_time");
                bankcard4.field_mobile = optJSONObject3.optString("mobile");
                if (optJSONObject3.optInt("support_micropay", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bankcard4.field_support_micropay = z;
                x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + optJSONObject3.optInt("support_micropay", 0));
                bankcard4.sRr = optJSONObject3.optString("balance_list_url");
                optString = ad.getContext().getString(i.uVu);
                bankcard4.field_desc = optString;
                bankcard4.field_bankName = optString;
                bankcard4.field_bankcardTail = "10000";
                bankcard4.field_forbid_title = optJSONObject3.optString("forbid_title");
                bankcard4.field_forbid_url = optJSONObject3.optString("forbid_url");
                optJSONObject2 = optJSONObject3.optJSONObject("balance_menu_info");
                if (optJSONObject2 != null) {
                    x.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", optJSONObject2.toString());
                    g.Dq().Db().a(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, obj);
                } else {
                    g.Dq().Db().a(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
                }
                bankcard = bankcard4;
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", Integer.valueOf(jSONObject.optInt("query_cache_time")));
            optJSONObject2 = jSONObject.optJSONObject("complex_switch_info");
            if (optJSONObject2 != null) {
                optJSONObject = optJSONObject2.optJSONObject("bind_newcard_switch");
                optJSONObject.optInt("forbid_bind_card");
                optJSONObject.optString("forbid_word");
            }
            g bLJ = g.bLJ();
            bLJ.sSg = optJSONObject2;
            try {
                if (bLJ.sSg != null) {
                    optJSONObject2 = bLJ.sSg.optJSONObject("bind_newcard_switch");
                    bLJ.sSf = optJSONObject2.optInt("forbid_bind_card");
                    bLJ.pfh = optJSONObject2.optString("forbid_word");
                } else {
                    bLJ.sSf = 0;
                    bLJ.pfh = "";
                }
            } catch (Throwable e) {
                bLJ.sSf = 0;
                bLJ.pfh = "";
                x.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", e, "", new Object[0]);
            }
            x.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", bLJ.sSg, Integer.valueOf(bLJ.sSf), bLJ.pfh);
            JSONArray optJSONArray = jSONObject.optJSONArray("history_card_array");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
                bankcard2 = null;
            } else {
                bankcard2 = d.bLG().W(optJSONArray.getJSONObject(0));
                bankcard2.field_cardType |= Bankcard.sRf;
            }
            optJSONArray = jSONObject.optJSONArray("balance_notice");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
            if (optJSONArray != null) {
                aD = bi.aD(optJSONArray.toString(), "");
            } else {
                str = "";
            }
            if (optJSONArray2 != null) {
                obj = bi.aD(optJSONArray2.toString(), "");
            } else {
                obj = "";
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", aD, obj);
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_BALANCE_NOTICE_STRING, aD);
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_FETCH_NOTICE_STRING, obj);
            g.Dr();
            g.Dq().Db().lO(true);
            optJSONObject2 = jSONObject.optJSONObject("bank_priority");
            List linkedList = new LinkedList();
            if (optJSONObject2 != null) {
                try {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("bankinfo_array");
                    if (optJSONArray3 != null) {
                        int length = optJSONArray3.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            c cVar = new c();
                            JSONObject jSONObject3 = optJSONArray3.getJSONObject(i2);
                            cVar.pfg = jSONObject3.optString("bind_serial");
                            cVar.sRa = jSONObject3.optString("polling_forbid_word");
                            linkedList.add(cVar);
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "", new Object[0]);
                }
            }
            jSONObject.optString("query_order_time");
            optJSONObject2 = jSONObject.optJSONObject("loan_entry_info");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
                kVar = null;
            } else {
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
                kVar = new k();
                kVar.field_title = optJSONObject2.optString("title");
                kVar.field_loan_jump_url = optJSONObject2.optString("loan_jump_url");
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + kVar.field_loan_jump_url);
                kVar.field_is_show_entry = optJSONObject2.optInt("is_show_entry", 0);
                kVar.field_tips = optJSONObject2.optString("tips");
                kVar.field_is_overdue = optJSONObject2.optInt("is_overdue", 0);
                if (optJSONObject2.has("available_otb")) {
                    kVar.field_available_otb = e.d(optJSONObject2.optDouble("available_otb") / 100.0d, "CNY");
                }
                if (optJSONObject2.has("index")) {
                    kVar.field_red_dot_index = optJSONObject2.optInt("index");
                }
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + kVar.field_red_dot_index + "  field_is_overdue:" + kVar.field_is_overdue + "  field_is_show_entry:" + kVar.field_is_show_entry);
            }
            optJSONObject2 = jSONObject.optJSONObject("fetch_info");
            b bVar = o.bMc().sWm;
            x.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", bVar);
            if (optJSONObject2 != null) {
                bVar = a(optJSONObject2, true);
            } else {
                x.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            optJSONObject2 = jSONObject.optJSONObject("lqt_info");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
                bankcard3 = null;
            } else {
                x.i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", optJSONObject2.toString());
                bankcard3 = new Bankcard((byte) 0);
                bankcard3.field_bankcardType = optJSONObject2.optString("lqt_bank_type");
                bankcard3.field_bindSerial = optJSONObject2.optString("lqt_bind_serial");
                bankcard3.field_bankName = optJSONObject2.optString("lqt_bank_name");
                bankcard3.sRo = ((double) optJSONObject2.optLong("total_balance")) / 100.0d;
                bankcard3.sRq = ((double) optJSONObject2.optLong("avail_balance")) / 100.0d;
                bankcard3.sRw = new e();
                bankcard3.sRw.oVl = optJSONObject2.optString("lqt_logo_url");
                bankcard3.field_forbidWord = optJSONObject2.optString("lqt_forbid_word");
                bankcard3.field_forbid_title = optJSONObject2.optString("forbid_title");
                bankcard3.field_forbid_url = optJSONObject2.optString("forbid_url");
                bankcard3.sRp = optJSONObject2.optString("lqt_show_wording");
                bankcard3.field_mobile = optJSONObject2.optString("mobile");
                bankcard3.field_support_micropay = optJSONObject2.optInt("support_micropay", 0) == 1;
                bankcard3.field_cardType |= Bankcard.sRh;
                if (bi.oN(bankcard3.field_bankName)) {
                    bankcard3.field_bankName = ad.getContext().getString(i.uZD);
                }
                bankcard3.field_desc = bankcard3.field_bankName;
                if (bi.oN(bankcard3.field_forbidWord)) {
                    bankcard3.field_bankcardState = 0;
                } else {
                    bankcard3.field_bankcardState = 8;
                }
            }
            o.bMc().a(afVar, t, u, bankcard, bankcard2, kVar, bVar, bankcard3, r11, i, linkedList);
        } catch (Throwable e22) {
            x.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e22.getMessage());
            x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e22, "", new Object[0]);
        }
    }

    public static boolean zB(int i) {
        if (i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }

    public static Bankcard a(ex exVar) {
        x.i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance from balance info %s", exVar);
        Bankcard bankcard = null;
        if (exVar != null) {
            boolean z;
            bankcard = new Bankcard((byte) 0);
            a(bankcard, exVar.vRl, (long) exVar.vRm, bi.getInt(exVar.vRh, 0));
            bankcard.sRo = ((double) bi.getInt(exVar.vRh, 0)) / 100.0d;
            bankcard.sRp = exVar.sRp;
            bankcard.sRs = exVar.sRs;
            bankcard.sRt = exVar.sRt;
            bankcard.sRq = ((double) bi.getInt(exVar.vRj, 0)) / 100.0d;
            bankcard.field_cardType |= Bankcard.sRe;
            bankcard.field_bankcardType = exVar.vRd;
            bankcard.field_bindSerial = exVar.vRe;
            bankcard.field_forbidWord = exVar.vRf;
            if (bi.oN(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 0;
            } else {
                bankcard.field_bankcardState = 8;
            }
            bankcard.field_mobile = exVar.fBa;
            if (bi.getInt(exVar.vRk, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bankcard.field_support_micropay = z;
            x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + exVar.vRk);
            bankcard.sRr = exVar.sRr;
            String string = ad.getContext().getString(i.uVu);
            bankcard.field_desc = string;
            bankcard.field_bankName = string;
            bankcard.field_bankcardTail = "10000";
            bankcard.field_forbid_title = exVar.vRo;
            bankcard.field_forbid_url = exVar.vRp;
            ey eyVar = exVar.vRr;
            if (eyVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_show_menu", eyVar.vRs);
                    List<ez> list = eyVar.vRt;
                    JSONArray jSONArray = new JSONArray();
                    for (ez ezVar : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("title", ezVar.title);
                        jSONObject2.put("jump_type", ezVar.sGd);
                        jSONObject2.put("jump_h5_url", ezVar.sGe);
                        jSONObject2.put("tinyapp_username", ezVar.sGf);
                        jSONObject2.put("tinyapp_path", ezVar.sGg);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("balance_menu_item", jSONArray);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "Bankcard getBalance from balance, assemble menuInfoJson error: %s", e.getMessage());
                }
                x.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", jSONObject.toString());
                g.Dq().Db().a(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, jSONObject.toString());
            } else {
                g.Dq().Db().a(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
            }
        }
        return bankcard;
    }

    public static b a(JSONObject jSONObject, boolean z) {
        int i = 0;
        if (jSONObject == null) {
            x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            return null;
        }
        x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.sQT = jSONObject.optString("fetch_charge_title");
        x.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.sQT);
        if (z) {
            x.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.sFA = jSONObject.optInt("is_cal_charge", 0);
            bVar.sFz = jSONObject.optInt("is_show_charge", 0);
            bVar.sFB = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.sFC = jSONObject.optDouble("min_charge_fee", 0.0d) / 100.0d;
            bVar.pQB = jSONObject.optDouble("remain_fee", 0.0d) / 100.0d;
            bVar.sQV = jSONObject.optString("card_list_wording_title", "");
            bVar.sQW = jSONObject.optString("card_list_wording_content", "");
            if (jSONObject.has("withdraw_sector")) {
                bVar.sQX = b.V(jSONObject.optJSONObject("withdraw_sector"));
            }
            x.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.sFA + " is_show_charge:" + bVar.sFz + " min_charge_fee:" + bVar.sFC + " remain_fee:" + bVar.pQB + " is_full_fetch_direct:" + bVar.sFB);
        } else {
            x.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.sQU = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b bVar2 = new b();
                    bVar2.aAM = optJSONObject.optString("key");
                    bVar2.value = optJSONObject.optString(Columns.VALUE);
                    x.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + bVar2.aAM + " , feeItem.value is " + bVar2.value);
                    if (!(TextUtils.isEmpty(bVar2.aAM) || TextUtils.isEmpty(bVar2.value))) {
                        bVar.sQU.add(bVar2);
                    }
                } else {
                    x.e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.sQU.size());
        }
        return bVar;
    }

    private static void a(Bankcard bankcard, long j, long j2, int i) {
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        final Bankcard bankcard2 = bankcard;
        e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new e.a() {
            public final void T(Map<String, Object> map) {
                if (map != null) {
                    long a = bi.a((Long) map.get("wallet_balance_version"), -1);
                    long a2 = bi.a((Long) map.get("wallet_balance_last_update_time"), -1);
                    if (a2 < 0 || a < 0 || a2 + j3 > bi.Wz() || j4 >= a) {
                        e.a(new c("wallet_balance_version", Long.valueOf(j4)), new c("wallet_balance_last_update_time", Long.valueOf(bi.Wz())), new c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                        bankcard2.sRo = ((double) i2) / 100.0d;
                        return;
                    }
                    x.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                }
            }
        });
    }

    private static ArrayList<Bankcard> t(JSONArray jSONArray) {
        x.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard W = d.bLG().W(jSONArray.getJSONObject(i));
                if (W != null) {
                    d.d(W);
                    arrayList.add(W);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<Bankcard> u(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.sRd;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.sRk = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = ad.getContext().getString(i.veB, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.sRw = new e();
                bankcard.sRw.oVl = jSONObject.getString("logo_url");
                bankcard.sRw.sRD = jSONObject.getString("background_logo_url");
                bankcard.sRw.sRE = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }
}
