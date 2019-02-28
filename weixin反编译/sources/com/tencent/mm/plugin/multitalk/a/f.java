package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.at.b;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private Map<String, Long> oMj = new ConcurrentHashMap();

    final void a(String str, a aVar) {
        String a = n.a(aVar.hoa.vNO);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            bb bbVar = (bb) e.a(new bb(), decode, decode.length);
            if (bbVar == null) {
                x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:" + a);
            } else if (this.oMj.get(bbVar.groupId) == null || ((Long) this.oMj.get(bbVar.groupId)).longValue() < bbVar.zZr) {
                this.oMj.put(bbVar.groupId, Long.valueOf(bbVar.zZr));
                bx bxVar = aVar.hoa;
                String a2 = n.a(bxVar.vNM);
                String a3 = n.a(bxVar.vNN);
                as.Hm();
                String str2 = (String) c.Db().get(2, null);
                if (str2 == null) {
                    x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = bbVar.zZp;
                Object obj;
                String str5;
                Object obj2;
                if (bbVar.zZo == 1) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = bbVar.zZq;
                    obj = null;
                    str5 = "";
                    for (av avVar : bbVar.zXq) {
                        str5 = str5 + avVar.zXO + ",";
                        if (avVar.zXO != null && avVar.zXO.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        o.bdD().Gh(str3);
                        o.bdD().bdm().remove(str3);
                    } else if (!(o.bdD().bdm().contains(str3) || obj2 == null)) {
                        o.bdD().bdm().add(str3);
                    }
                    if (str2.equals(str4)) {
                        o.bdB().b(str3, str4, false, false);
                    } else if (obj != null && obj2 == null) {
                        o.bdB().b(str3, str4, false, false);
                    } else if (obj == null || obj2 == null) {
                        o.bdB().b(str3, str4, true, false);
                    } else {
                        o.bdB().b(str3, str4, true, true);
                    }
                    o.bdD().a(str3, bbVar);
                    o.bdA().oLv.bg(bi.e((Integer) as.Hk().get(1)), q.FY());
                } else if (bbVar.zZo == 2) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + bbVar.zXq.length);
                    String[] strArr2 = bbVar.zZq;
                    obj = null;
                    str5 = "";
                    for (av avVar2 : bbVar.zXq) {
                        str5 = str5 + avVar2.zXO + ",";
                        if (avVar2.zXO != null && avVar2.zXO.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!o.bdD().Gi(str3) && o.bdD().bdm().contains(str3) && o.bdD().dw(str3, str2)) {
                            o.bdB();
                            e.FV(str3);
                        }
                        o.bdD().Gh(str3);
                        o.bdD().bdm().remove(str3);
                    } else if (!(o.bdD().bdm().contains(str3) || r5 == null)) {
                        o.bdD().bdm().add(str3);
                    }
                    o.bdA().oLv.bg(bi.e((Integer) as.Hk().get(1)), q.FY());
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                    g bdD = o.bdD();
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", str3);
                    b Gk = o.bdx().Gk(str3);
                    if (Gk == null) {
                        x.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        bdD.a(str3, bbVar);
                    } else if (Gk.field_roomId != bbVar.srH) {
                        x.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + Gk.field_roomId + "bannerinfo.roomid:" + bbVar.srH);
                    } else if (g.c(str3, bbVar)) {
                        bdD.Gj(str3);
                    } else {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                    }
                } else if (bbVar.zZo == 0) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!o.bdD().Gi(str3) && o.bdD().bdm().contains(str3) && o.bdD().dw(str3, str2)) {
                        o.bdB();
                        e.FV(str3);
                    }
                    e bdB = o.bdB();
                    cg auVar = new au();
                    auVar.setType(64);
                    auVar.aq(System.currentTimeMillis());
                    auVar.eR(6);
                    auVar.setContent(ad.getContext().getString(R.l.ewT));
                    if (m.gf(str3)) {
                        auVar.dU(str3);
                        auVar.setContent(auVar.field_content);
                        as.Hm();
                        c.Fh().Q(auVar);
                    }
                    if (!(bdB.oLY == null || !str3.equals(bdB.oLY.zZE) || bdB.oMa.cgx())) {
                        x.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                        bdB.oLY = null;
                        bdB.oLZ = 0;
                        bdB.oMa.TN();
                    }
                    o.bdD().Gg(str3);
                    o.bdD().Gh(str3);
                    o.bdD().bdm().remove(str3);
                } else if (bbVar.zZo == 3) {
                    for (av avVar3 : bbVar.zXq) {
                        if (avVar3.zXO != null && avVar3.zXO.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                } else {
                    x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + bbVar.zZo);
                }
            } else {
                x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + bbVar.groupId + " is early than last msg, so we do not process,now return.");
            }
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:" + a, e.getMessage());
        }
    }
}
