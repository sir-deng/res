package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;

public final class a {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(a aVar, au auVar) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(auVar, pString, pString2)) {
            a(aVar, auVar, pString.value, pString2.value);
        }
    }

    public static void a(a aVar, au auVar, String str, String str2) {
        String str3 = auVar.field_talker;
        boolean endsWith = str3.endsWith("@chatroom");
        String FY = auVar.field_isSend == 1 ? q.FY() : endsWith ? bb.hS(auVar.field_content) : str3;
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20source_publishid", str + ",");
        dVar.q("21uxinfo", str2 + ",");
        dVar.q("22clienttime", bi.Wy() + ",");
        dVar.q("23video_statu", ",");
        dVar.q("24source_type", (auVar.getType() == 62 ? 1 : 2) + ",");
        dVar.q("25scene", (endsWith ? 4 : 3) + ",");
        dVar.q("26action_type", aVar.value + ",");
        dVar.q("27scene_chatname", str3 + ",");
        dVar.q("28scene_username", FY + ",");
        dVar.q("29curr_publishid", ",");
        dVar.q("30curr_msgid", auVar.field_msgSvrId + ",");
        dVar.q("31curr_favid", "0,");
        dVar.q("32elapsed_time", "0,");
        dVar.q("33load_time", "0,");
        dVar.q("34is_load_complete", "0,");
        dVar.q("35destination", "0,");
        dVar.q("36chatroom_membercount", (endsWith ? m.gn(str3) : 0) + ",");
        x.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + dVar.SG());
        ((com.tencent.mm.plugin.sns.b.c) g.h(com.tencent.mm.plugin.sns.b.c.class)).h(12990, dVar);
    }

    public static void a(c cVar, d dVar, au auVar, int i) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(auVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = auVar.field_talker;
            boolean endsWith = str3.endsWith("@chatroom");
            String FY = auVar.field_isSend == 1 ? q.FY() : endsWith ? bb.hS(auVar.field_content) : str3;
            com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
            dVar2.q("20source_publishid", str + ",");
            dVar2.q("21uxinfo", str2 + ",");
            dVar2.q("22clienttime", bi.Wy() + ",");
            dVar2.q("23video_statu", dVar.value + ",");
            dVar2.q("24source_type", (auVar.getType() == 62 ? 1 : 2) + ",");
            dVar2.q("25scene", (endsWith ? 4 : 3) + ",");
            dVar2.q("26action_type", cVar.value + ",");
            dVar2.q("27scene_chatname", str3 + ",");
            dVar2.q("28scene_username", FY + ",");
            dVar2.q("29curr_publishid", ",");
            dVar2.q("30curr_msgid", auVar.field_msgSvrId + ",");
            dVar2.q("31curr_favid", "0,");
            dVar2.q("32chatroom_membercount", (endsWith ? m.gn(str3) : 0) + ",");
            dVar2.q("33chatroom_toMemberCount", i + ",");
            x.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + dVar2.SG());
            com.tencent.mm.plugin.report.service.g.pWK.h(12991, dVar2);
        }
    }

    public static boolean a(au auVar, PString pString, PString pString2) {
        if (auVar.getType() == 62) {
            r nJ = t.nJ(auVar.field_imgPath);
            if (nJ == null) {
                return false;
            }
            bnp bnp = nJ.hXE;
            if (bnp == null || bi.oN(bnp.hff)) {
                return false;
            }
            pString.value = bnp.hfg;
            pString2.value = bnp.hff;
            return true;
        } else if (auVar.getType() != 49) {
            return false;
        } else {
            boolean eX = s.eX(auVar.field_talker);
            String str = auVar.field_content;
            if (eX && auVar.field_content != null && auVar.field_isSend == 0) {
                str = bb.hT(auVar.field_content);
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
            if (fV == null || fV.type != 4 || bi.oN(fV.heZ)) {
                return false;
            }
            pString.value = fV.hfg;
            pString2.value = fV.hff;
            return true;
        }
    }
}
