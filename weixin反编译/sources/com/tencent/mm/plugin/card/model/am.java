package com.tencent.mm.plugin.card.model;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.ha;
import com.tencent.mm.f.a.ny;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.plugin.card.a.m;
import com.tencent.mm.plugin.card.a.n;
import com.tencent.mm.plugin.card.a.p;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class am implements ap {
    private static HashMap<Integer, d> gyG;
    private b kRZ;
    private c kSa;
    private al kSb;
    private h kSc;
    private n kSd;
    private a kSe;
    private k kSf;
    private o kSg;
    private c kSh;
    private l kSi = null;
    private e kSj = null;
    private m kSk = null;
    private com.tencent.mm.plugin.card.a.d kSl = null;
    private j kSm = null;
    private com.tencent.mm.plugin.card.a.c kSn;
    private g kSo;
    private l kSp;
    private j kSq;
    private com.tencent.mm.sdk.b.c kSr = new com.tencent.mm.plugin.card.a.o();
    private com.tencent.mm.sdk.b.c kSs = new p();
    private com.tencent.mm.sdk.b.c kSt = new com.tencent.mm.plugin.card.a.a();
    private com.tencent.mm.plugin.card.ui.b kSu = new com.tencent.mm.plugin.card.ui.b();
    private com.tencent.mm.sdk.b.c kSv = new com.tencent.mm.sdk.b.c<ha>() {
        {
            this.xmG = ha.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final ha haVar = (ha) bVar;
            x.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
            if (haVar instanceof ha) {
                am.this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        if (as.Hp()) {
                            boolean z = haVar.fyc.fyd;
                            x.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is " + z);
                            boolean axM = com.tencent.mm.plugin.card.b.l.axM();
                            boolean axO = com.tencent.mm.plugin.card.b.l.axO();
                            if (axM && axO) {
                                x.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                                return;
                            }
                            if (z) {
                                as.CN().a(new y(), 0);
                            } else {
                                int intValue;
                                as.Hm();
                                Integer num = (Integer) com.tencent.mm.y.c.Db().get(282882, null);
                                if (num != null) {
                                    intValue = num.intValue();
                                } else {
                                    intValue = 0;
                                }
                                if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                    as.CN().a(new y(), 0);
                                }
                            }
                            if (axO) {
                                as.Hm();
                                Long l = (Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0));
                                if (l != null && l.longValue() == 0) {
                                    am.avo().avy();
                                }
                            }
                            if (axM) {
                                as.Hm();
                                if (TextUtils.isEmpty((String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null))) {
                                    am.avg();
                                    b.nX(1);
                                }
                            }
                        }
                    }
                }, 10000);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c kSw = new com.tencent.mm.sdk.b.c<ny>() {
        {
            this.xmG = ny.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            al avi = am.avi();
            x.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            avi.gLA.fD("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            return false;
        }
    };
    private bt.a kSx = new bt.a() {
        public final void a(final com.tencent.mm.ad.d.a aVar) {
            final String a = com.tencent.mm.platformtools.n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
            } else {
                am.this.mHandler.post(new Runnable() {
                    public final void run() {
                        l avl = am.avl();
                        Object obj = a;
                        String str = aVar.hoa.vNT;
                        x.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is " + str);
                        if (!TextUtils.isEmpty(obj)) {
                            g gVar;
                            String str2;
                            Map y = bj.y(obj, "sysmsg");
                            if (y == null) {
                                gVar = null;
                            } else {
                                g gVar2 = new g();
                                str2 = (String) y.get(".sysmsg.carditemmsg.card_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.field_card_type = 0;
                                } else {
                                    gVar2.field_card_type = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_title = (String) y.get(".sysmsg.carditemmsg.title");
                                gVar2.field_description = (String) y.get(".sysmsg.carditemmsg.description");
                                gVar2.field_logo_url = (String) y.get(".sysmsg.carditemmsg.logo_url");
                                gVar2.field_logo_color = (String) y.get(".sysmsg.carditemmsg.logo_color");
                                str2 = (String) y.get(".sysmsg.carditemmsg.time");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.field_time = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                    gVar2.field_time = Integer.MAX_VALUE;
                                } else {
                                    gVar2.field_time = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_card_id = (String) y.get(".sysmsg.carditemmsg.card_id");
                                gVar2.field_card_tp_id = (String) y.get(".sysmsg.carditemmsg.card_tp_id");
                                gVar2.field_msg_id = (String) y.get(".sysmsg.carditemmsg.msg_id");
                                str2 = (String) y.get(".sysmsg.carditemmsg.msg_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.field_msg_type = 0;
                                } else {
                                    gVar2.field_msg_type = Integer.valueOf(str2).intValue();
                                }
                                str2 = (String) y.get(".sysmsg.carditemmsg.jump_type");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.field_jump_type = 1;
                                } else {
                                    gVar2.field_jump_type = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_url = (String) y.get(".sysmsg.carditemmsg.url");
                                str2 = (String) y.get(".sysmsg.carditemmsg.button.text");
                                if (!TextUtils.isEmpty(str2)) {
                                    km kmVar = new km();
                                    kmVar.text = str2;
                                    kmVar.url = (String) y.get(".sysmsg.carditemmsg.button.url");
                                    str2 = (String) y.get(".sysmsg.carditemmsg.button.action_type");
                                    if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                        kmVar.kRj = 0;
                                    } else {
                                        kmVar.kRj = Integer.valueOf(str2).intValue();
                                    }
                                    gVar2.kQY = kmVar;
                                    try {
                                        gVar2.field_buttonData = gVar2.kQY.toByteArray();
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", e.getMessage());
                                        x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                    }
                                }
                                str2 = (String) y.get(".sysmsg.carditemmsg.opt_region.text");
                                if (!TextUtils.isEmpty(str2)) {
                                    kq kqVar = new kq();
                                    kqVar.text = str2;
                                    kqVar.url = (String) y.get(".sysmsg.carditemmsg.opt_region.url");
                                    str2 = (String) y.get(".sysmsg.carditemmsg.opt_region.type");
                                    if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                        kqVar.type = 0;
                                    } else {
                                        kqVar.type = Integer.valueOf(str2).intValue();
                                    }
                                    str2 = (String) y.get(".sysmsg.carditemmsg.opt_region.endtime");
                                    if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                        kqVar.quA = (int) (System.currentTimeMillis() / 1000);
                                    } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                        kqVar.quA = Integer.MAX_VALUE;
                                    } else {
                                        kqVar.quA = Integer.valueOf(str2).intValue();
                                    }
                                    gVar2.kQZ = kqVar;
                                    try {
                                        gVar2.field_operData = gVar2.kQZ.toByteArray();
                                    } catch (Throwable e2) {
                                        x.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", e2.getMessage());
                                        x.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                    }
                                }
                                str2 = (String) y.get(".sysmsg.carditemmsg.report_scene");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.field_report_scene = 2;
                                } else {
                                    gVar2.field_report_scene = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_read_state = 1;
                                gVar2.field_accept_buttons = l.i(y, ".sysmsg.carditemmsg");
                                gVar2.field_jump_buttons = l.h(y, ".sysmsg.carditemmsg");
                                str2 = (String) y.get(".sysmsg.carditemmsg.get_layout_scene");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.kRc = 0;
                                } else {
                                    gVar2.kRc = Integer.valueOf(str2).intValue();
                                }
                                gVar2.field_consumed_box_id = (String) y.get(".sysmsg.carditemmsg.consumed_box_id");
                                gVar2.kQS = (String) y.get(".sysmsg.carditemmsg.reddot_wording");
                                gVar2.kQT = (String) y.get(".sysmsg.carditemmsg.reddot_buff");
                                gVar2.kQU = (String) y.get(".sysmsg.carditemmsg.reddot_icon_url");
                                gVar2.kQV = (String) y.get(".sysmsg.carditemmsg.msg_tips.title");
                                gVar2.kQW = (String) y.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                                str2 = (String) y.get(".sysmsg.carditemmsg.msg_scene");
                                if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.b.l.xv(str2)) {
                                    gVar2.kRd = 0;
                                } else {
                                    gVar2.kRd = Integer.valueOf(str2).intValue();
                                    x.i("MicroMsg.CardMsgManager", "msg_scene is " + str2);
                                }
                                str2 = (String) y.get(".sysmsg.carditemmsg.need_check");
                                x.i("MicroMsg.CardMsgManager", "need_check:" + str2);
                                if (TextUtils.isEmpty(str2)) {
                                    gVar2.kQX = false;
                                } else {
                                    gVar2.kQX = str2.equals("true");
                                }
                                String str3 = (String) y.get(".sysmsg.carditemmsg.all_unavailable");
                                x.i("MicroMsg.CardMsgManager", "all_Unavailable:" + str2);
                                if (TextUtils.isEmpty(str3)) {
                                    gVar2.kRe = false;
                                } else {
                                    gVar2.kRe = str3.equals("true");
                                }
                                gVar2.field_unavailable_qr_code_list = l.j(y, ".sysmsg.carditemmsg");
                                gVar = gVar2;
                            }
                            if (gVar == null) {
                                x.e("MicroMsg.CardMsgManager", "card msg == null");
                                return;
                            }
                            if (TextUtils.isEmpty(gVar.field_card_id)) {
                                x.e("MicroMsg.CardMsgManager", "card id == null");
                            }
                            str2 = gVar.field_msg_id;
                            gVar.field_msg_id = str;
                            if (TextUtils.isEmpty(gVar.field_msg_id)) {
                                gVar.field_msg_id = str2;
                            }
                            if (TextUtils.isEmpty(gVar.field_msg_id)) {
                                gVar.field_msg_id = System.currentTimeMillis();
                            }
                            x.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + gVar.field_msg_id);
                            x.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + gVar.field_msg_type);
                            if (gVar.kRc != 0) {
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(gVar.kRc));
                            }
                            x.i("MicroMsg.CardMsgManager", "reddot_buff is " + gVar.kQT);
                            if (TextUtils.isEmpty(gVar.kQT)) {
                                x.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                            } else {
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, gVar.kQT);
                            }
                            if ((gVar.field_msg_type & 1) != 0) {
                                x.i("MicroMsg.CardMsgManager", "msg_tips_title is " + gVar.kQV);
                                x.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + gVar.kQW);
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, gVar.kQV);
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, gVar.kQW);
                            }
                            boolean aQ = com.tencent.mm.r.c.Bx().aQ(262152, 266256);
                            if (!(aQ || (gVar.field_msg_type & 64) == 0)) {
                                com.tencent.mm.r.c.Bx().o(262152, true);
                                aQ = true;
                            }
                            if (aQ) {
                                x.i("MicroMsg.CardMsgManager", "has card new msg, return");
                            } else {
                                x.i("MicroMsg.CardMsgManager", "not has new!");
                                obj = null;
                                if ((gVar.field_msg_type & 32) != 0) {
                                    com.tencent.mm.r.c.Bx().p(262152, true);
                                    x.i("MicroMsg.CardMsgManager", "has reddot");
                                    obj = 1;
                                } else {
                                    x.e("MicroMsg.CardMsgManager", "not has reddot!");
                                }
                                Object obj2 = null;
                                if (TextUtils.isEmpty(gVar.kQS)) {
                                    x.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                                } else {
                                    x.i("MicroMsg.CardMsgManager", "reddot_wording is " + gVar.kQS);
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, gVar.kQS);
                                    com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, true);
                                    obj2 = 1;
                                }
                                Object obj3 = null;
                                x.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + gVar.kQU);
                                if (TextUtils.isEmpty(gVar.kQU)) {
                                    x.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                                } else {
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, gVar.kQU);
                                    com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, true);
                                    obj3 = 1;
                                }
                                if (obj == null || obj2 == null || obj3 == null) {
                                    if (obj != null && obj2 != null && obj3 == null) {
                                        com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                    } else if (obj != null && obj2 == null && obj3 != null) {
                                        com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                    } else if (obj == null && obj2 != null && obj3 != null) {
                                        com.tencent.mm.r.c.Bx().p(262152, false);
                                    } else if (obj != null && obj2 == null && obj3 == null) {
                                        com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                        com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                    } else if (obj == null && obj2 != null && obj3 == null) {
                                        com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                        com.tencent.mm.r.c.Bx().p(262152, false);
                                    } else if (obj == null && obj2 == null && obj3 != null) {
                                        com.tencent.mm.r.c.Bx().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                        com.tencent.mm.r.c.Bx().p(262152, false);
                                    }
                                }
                                if (!(obj == null && obj2 == null && obj3 == null)) {
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, gVar.field_card_id);
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.valueOf(gVar.kQX));
                                    x.i("MicroMsg.CardMsgManager", "card_id:" + gVar.field_card_id + "  need_check:" + gVar.kQX);
                                }
                            }
                            if ((gVar.field_msg_type & 1) != 0) {
                                if (avl.wH(gVar.field_msg_id)) {
                                    x.e("MicroMsg.CardMsgManager", "msg for id " + gVar.field_msg_id + " is exist!!");
                                    avl.wI(gVar.field_msg_id);
                                    avl.kPq.add(gVar);
                                    l.c(gVar);
                                } else {
                                    avl.kPq.add(gVar);
                                    l.c(gVar);
                                    if ((gVar.field_msg_type & FileUtils.S_IWUSR) != 0) {
                                        avl.kPr++;
                                    }
                                }
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(139268, Integer.valueOf(avl.kPr));
                                avl.a(gVar);
                            }
                            if ((gVar.field_msg_type & 2) != 0) {
                                am.avg();
                                b.nX(gVar.kRc);
                            }
                            if ((gVar.field_msg_type & 4) != 0) {
                                avl.asP();
                            }
                            if ((gVar.field_msg_type & 8) != 0) {
                                am.avn().o(gVar.field_card_id, gVar.field_card_tp_id, gVar.field_report_scene);
                            }
                            if ((gVar.field_msg_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                                gVar.avb();
                                am.avx().b(gVar);
                            }
                            com.tencent.mm.plugin.card.b.l.axL();
                        }
                    }
                });
            }
        }
    };
    private bt.a kSy = new bt.a() {
        public final void a(final com.tencent.mm.ad.d.a aVar) {
            final String a = com.tencent.mm.platformtools.n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
            } else {
                am.this.mHandler.post(new Runnable() {
                    public final void run() {
                        c avr = am.avr();
                        Object obj = a;
                        x.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is " + (aVar.hoa.vNT));
                        if (!TextUtils.isEmpty(obj)) {
                            c.a aVar;
                            Map y = bj.y(obj, "sysmsg");
                            if (y == null) {
                                aVar = null;
                            } else {
                                c.a aVar2 = new c.a();
                                String str = (String) y.get(".sysmsg.notifysharecard.state_flag");
                                if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.b.l.xv(str)) {
                                    aVar2.kSO = 0;
                                } else {
                                    aVar2.kSO = Integer.valueOf(str).intValue();
                                }
                                aVar2.username = (String) y.get(".sysmsg.notifysharecard.username");
                                aVar2.fHP = (String) y.get(".sysmsg.notifysharecard.card_id");
                                aVar = aVar2;
                            }
                            if (aVar == null) {
                                x.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                                return;
                            }
                            if (TextUtils.isEmpty(aVar.fHP)) {
                                x.e("MicroMsg.ShareCardMsgMgr", "card id == null");
                            }
                            x.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.fHP);
                            am.avo().avy();
                            com.tencent.mm.plugin.card.b.l.axN();
                        }
                    }
                });
            }
        }
    };
    private ag mHandler = new ag(Looper.getMainLooper());

    public am() {
        File file = new File(m.kRo);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(m.kRp);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private static am avf() {
        as.Hg();
        am amVar = (am) bq.ib("plugin.card");
        if (amVar != null) {
            return amVar;
        }
        Object amVar2 = new am();
        as.Hg().a("plugin.card", amVar2);
        return amVar2;
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return c.gLy;
            }
        });
        gyG.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return al.gLy;
            }
        });
        gyG.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return h.gLy;
            }
        });
        gyG.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return k.gLy;
            }
        });
        gyG.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return o.gLy;
            }
        });
        gyG.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return j.gLy;
            }
        });
        gyG.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return l.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.e eVar;
        x.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", Boolean.valueOf(z));
        com.tencent.mm.sdk.b.a.xmy.b(this.kSv);
        com.tencent.mm.sdk.b.a.xmy.b(this.kSw);
        com.tencent.mm.sdk.b.a.xmy.b(this.kSr);
        com.tencent.mm.sdk.b.a.xmy.b(this.kSs);
        com.tencent.mm.sdk.b.a.xmy.b(this.kSt);
        as.getSysCmdMsgExtension().a("carditemmsg", this.kSx, true);
        as.getSysCmdMsgExtension().a("notifysharecard", this.kSy, true);
        this.kSi = null;
        if (this.kSj != null) {
            this.kSj.kOy.clear();
            this.kSj = null;
        }
        if (this.kSd != null) {
            eVar = this.kSd;
            synchronized (eVar.kPs) {
                eVar.kPs.clear();
            }
            synchronized (eVar.kPt) {
                eVar.kPt.clear();
            }
            as.CN().b(563, eVar);
            com.tencent.mm.modelgeo.a OV = com.tencent.mm.modelgeo.c.OV();
            if (OV != null) {
                OV.c(eVar);
            }
            if (eVar.kPv != null) {
                as.CN().c(eVar.kPv);
            }
            this.kSd = null;
        }
        if (this.kRZ != null) {
            this.kRZ.detach();
            this.kRZ = null;
        }
        if (this.kSe != null) {
            eVar = this.kSe;
            synchronized (eVar.gUq) {
                eVar.kOd.clear();
                eVar.kOe.clear();
            }
            if (eVar.kSE != null) {
                as.CN().c(eVar.kSE);
            }
            as.CN().b(903, eVar);
            this.kSe = null;
        }
        if (this.kSl != null) {
            this.kSl.release();
            com.tencent.mm.plugin.card.a.d dVar = this.kSl;
            dVar.kOg.clear();
            dVar.kOs.clear();
            dVar.kOt.clear();
            dVar.kOu.clear();
            dVar.kOw = false;
            this.kSl = null;
        }
        if (this.kSm != null) {
            com.tencent.mm.ad.e eVar2 = this.kSm;
            as.CN().b(907, eVar2);
            Iterator it = eVar2.kPe.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) eVar2.kPg.get(str);
                eVar2.kPg.remove(str);
                eVar2.kPf.removeCallbacks(runnable);
            }
            eVar2.kPd.clear();
            eVar2.kPe.clear();
            eVar2.kPg.clear();
            this.kSm = null;
        }
        if (this.kSn != null) {
            this.kSn.release();
            this.kSn = null;
        }
        if (this.kSo != null) {
            this.kSo.release();
            this.kSo = null;
        }
        this.kSk = null;
        q.a.vjb = new com.tencent.mm.plugin.card.a.k();
        com.tencent.mm.plugin.card.ui.b.ali().registerActivityLifecycleCallbacks(this.kSu);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        if (avf().kRZ != null) {
            avf().kRZ.detach();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.kSv);
        com.tencent.mm.sdk.b.a.xmy.c(this.kSw);
        com.tencent.mm.sdk.b.a.xmy.c(this.kSr);
        com.tencent.mm.sdk.b.a.xmy.c(this.kSs);
        com.tencent.mm.sdk.b.a.xmy.c(this.kSt);
        as.getSysCmdMsgExtension().b("carditemmsg", this.kSx, true);
        as.getSysCmdMsgExtension().b("notifysharecard", this.kSy, true);
        q.a.vjb = null;
        com.tencent.mm.plugin.card.ui.b.ali().unregisterActivityLifecycleCallbacks(this.kSu);
    }

    public static b avg() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kRZ == null) {
            avf().kRZ = new b();
        }
        return avf().kRZ;
    }

    public static c avh() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSa == null) {
            am avf = avf();
            as.Hm();
            avf.kSa = new c(com.tencent.mm.y.c.Fc());
        }
        return avf().kSa;
    }

    public static al avi() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSb == null) {
            am avf = avf();
            as.Hm();
            avf.kSb = new al(com.tencent.mm.y.c.Fc());
        }
        return avf().kSb;
    }

    public static h avj() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSc == null) {
            am avf = avf();
            as.Hm();
            avf.kSc = new h(com.tencent.mm.y.c.Fc());
        }
        return avf().kSc;
    }

    public static n avk() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSd == null) {
            avf().kSd = new n();
        }
        return avf().kSd;
    }

    public static l avl() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSi == null) {
            avf().kSi = new l();
        }
        return avf().kSi;
    }

    public static e avm() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSj == null) {
            avf().kSj = new e();
        }
        return avf().kSj;
    }

    public static m avn() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSk == null) {
            avf().kSk = new m();
        }
        return avf().kSk;
    }

    public static a avo() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSe == null) {
            avf().kSe = new a();
        }
        return avf().kSe;
    }

    public static k avp() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSf == null) {
            am avf = avf();
            as.Hm();
            avf.kSf = new k(com.tencent.mm.y.c.Fc());
        }
        return avf().kSf;
    }

    public static o avq() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSg == null) {
            am avf = avf();
            as.Hm();
            avf.kSg = new o(com.tencent.mm.y.c.Fc());
        }
        return avf().kSg;
    }

    public static c avr() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSh == null) {
            avf().kSh = new c();
        }
        return avf().kSh;
    }

    public static com.tencent.mm.plugin.card.a.d avs() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSl == null) {
            avf().kSl = new com.tencent.mm.plugin.card.a.d();
        }
        return avf().kSl;
    }

    public static j avt() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSm == null) {
            avf().kSm = new j();
        }
        return avf().kSm;
    }

    public static com.tencent.mm.plugin.card.a.c avu() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSn == null) {
            avf().kSn = new com.tencent.mm.plugin.card.a.c();
        }
        return avf().kSn;
    }

    public static l avv() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSp == null) {
            am avf = avf();
            as.Hm();
            avf.kSp = new l(com.tencent.mm.y.c.Fc());
        }
        return avf().kSp;
    }

    public static j avw() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSq == null) {
            am avf = avf();
            as.Hm();
            avf.kSq = new j(com.tencent.mm.y.c.Fc());
        }
        return avf().kSq;
    }

    public static g avx() {
        com.tencent.mm.kernel.g.Do().CA();
        if (avf().kSo == null) {
            avf().kSo = new g();
        }
        return avf().kSo;
    }
}
