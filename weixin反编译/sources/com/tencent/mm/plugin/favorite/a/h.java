package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h {

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
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void m(f fVar) {
        if (fVar.field_favProto.wlY != null && !fVar.field_favProto.wlY.isEmpty()) {
            uz uzVar = (uz) fVar.field_favProto.wlY.getFirst();
            vc vcVar = uzVar.wkN;
            if (vcVar != null) {
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20source_publishid", vcVar.hfg + ",");
                dVar.q("21uxinfo", vcVar.hff + ",");
                dVar.q("22clienttime", bi.Wy() + ",");
                dVar.q("23source_type", (fVar.field_type == 16 ? 1 : 2) + ",");
                dVar.q("24scene", "5,");
                dVar.q("25scene_chatname", ",");
                dVar.q("26scene_username", fVar.field_fromUser + ",");
                dVar.q("27curr_publishid", ",");
                dVar.q("28curr_msgid", "0,");
                dVar.q("29curr_favid", fVar.field_id + ",");
                dVar.q("30isdownload", "0,");
                dVar.q("31chatroom_membercount", "0,");
                ((i) g.h(i.class)).b(uzVar.fHB, dVar);
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + dVar.SG());
                com.tencent.mm.plugin.report.service.g.pWK.h(12989, dVar);
            }
        }
    }

    public static void a(a aVar, f fVar) {
        if (fVar.field_favProto.wlY != null && !fVar.field_favProto.wlY.isEmpty()) {
            vc vcVar = ((uz) fVar.field_favProto.wlY.getFirst()).wkN;
            if (vcVar != null) {
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20source_publishid", vcVar.hfg + ",");
                dVar.q("21uxinfo", vcVar.hff + ",");
                dVar.q("22clienttime", bi.Wy() + ",");
                dVar.q("23video_statu", ",");
                dVar.q("24source_type", (fVar.field_type == 16 ? 1 : 2) + ",");
                dVar.q("25scene", "5,");
                dVar.q("26action_type", aVar.value + ",");
                dVar.q("27scene_chatname", ",");
                dVar.q("28scene_username", fVar.field_fromUser + ",");
                dVar.q("29curr_publishid", ",");
                dVar.q("30curr_msgid", "0,");
                dVar.q("31curr_favid", fVar.field_id + ",");
                dVar.q("32elapsed_time", "0,");
                dVar.q("33load_time", "0,");
                dVar.q("34is_load_complete", "0,");
                dVar.q("35destination", "0,");
                dVar.q("36chatroom_membercount", "0,");
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + dVar.SG());
                ((com.tencent.mm.plugin.sns.b.c) g.h(com.tencent.mm.plugin.sns.b.c.class)).h(12990, dVar);
            }
        }
    }

    public static void a(c cVar, f fVar, d dVar, int i) {
        if (fVar.field_favProto.wlY != null && !fVar.field_favProto.wlY.isEmpty()) {
            vc vcVar = ((uz) fVar.field_favProto.wlY.getFirst()).wkN;
            if (vcVar != null) {
                com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
                dVar2.q("20source_publishid", vcVar.hfg + ",");
                dVar2.q("21uxinfo", vcVar.hff + ",");
                dVar2.q("22clienttime", bi.Wy() + ",");
                dVar2.q("23video_statu", dVar.value + ",");
                dVar2.q("24source_type", (fVar.field_type == 16 ? 1 : 2) + ",");
                dVar2.q("25scene", "5,");
                dVar2.q("26action_type", cVar.value + ",");
                dVar2.q("27scene_chatname", ",");
                dVar2.q("28scene_username", fVar.field_fromUser + ",");
                dVar2.q("29curr_publishid", ",");
                dVar2.q("30curr_msgid", "0,");
                dVar2.q("31curr_favid", fVar.field_id + ",");
                dVar2.q("32chatroom_membercount", "0,");
                dVar2.q("33chatroom_toMemberCount", i + ",");
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + dVar2.SG());
                com.tencent.mm.plugin.report.service.g.pWK.h(12991, dVar2);
            }
        }
    }
}
