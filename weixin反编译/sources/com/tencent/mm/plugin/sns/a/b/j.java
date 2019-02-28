package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class j {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7),
        DetailTimeline(8);
        
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
        
        public int value;

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        private d(int i) {
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

    public enum e {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        private e(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(m mVar, boolean z, boolean z2) {
        int i = 2;
        bpb byF = mVar.byF();
        List list = byF.wYj.wfh;
        if (list != null && !list.isEmpty()) {
            if ((byF.wYj.wfg == 15 && mVar.xD(32)) || byF.wYj.wfg == 18) {
                int i2;
                list.get(0);
                if (mVar.xD(32) && byF.wYj.wfg == 15) {
                    byF.wYo.hff = mVar.byD().rfQ;
                    byF.wYo.hfg = byF.nMq;
                }
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20source_publishid", byF.wYo.hfg + ",");
                dVar.q("21uxinfo", byF.wYo.hff + ",");
                dVar.q("22clienttime", bi.Wy() + ",");
                dVar.q("23souce_type", (byF.wYj.wfg == 15 ? 1 : 2) + ",");
                String str = "24scene";
                StringBuilder stringBuilder = new StringBuilder();
                if (z) {
                    i = 6;
                } else if (byF.wYj.wfg == 15) {
                    i = 1;
                }
                dVar.q(str, stringBuilder.append(i).append(",").toString());
                dVar.q("25scene_chatname", ",");
                dVar.q("26scene_username", byF.kyG + ",");
                dVar.q("27curr_publishid", byF.nMq + ",");
                dVar.q("28curr_msgid", ",");
                dVar.q("29curr_favid", "0,");
                String str2 = "30isdownload";
                stringBuilder = new StringBuilder();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                dVar.q(str2, stringBuilder.append(i2).append(",").toString());
                dVar.q("31chatroom_membercount", "0,");
                p.a(byF.rzD, dVar);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + dVar.SG());
                g.pWK.h(12989, dVar);
            }
        }
    }

    public static void a(b bVar, a aVar, m mVar) {
        bpb byF = mVar.byF();
        List list = byF.wYj.wfh;
        if (list != null && !list.isEmpty()) {
            if ((byF.wYj.wfg == 15 && mVar.xD(32)) || byF.wYj.wfg == 18) {
                list.get(0);
                if (mVar.xD(32) && byF.wYj.wfg == 15) {
                    byF.wYo.hff = mVar.byD().rfQ;
                    byF.wYo.hfg = byF.nMq;
                }
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20source_publishid", byF.wYo.hfg + ",");
                dVar.q("21uxinfo", byF.wYo.hff + ",");
                dVar.q("22clienttime", bi.Wy() + ",");
                dVar.q("23video_statu", ",");
                dVar.q("24source_type", (byF.wYj.wfg == 15 ? 1 : 2) + ",");
                dVar.q("25scene", bVar.value + ",");
                dVar.q("26action_type", aVar.value + ",");
                dVar.q("27scene_chatname", ",");
                dVar.q("28scene_username", byF.kyG + ",");
                dVar.q("29curr_publishid", byF.nMq + ",");
                dVar.q("30curr_msgid", "0,");
                dVar.q("31curr_favid", "0,");
                dVar.q("32elapsed_time", "0,");
                dVar.q("33load_time", "0,");
                dVar.q("34is_load_complete", "0,");
                dVar.q("35destination", "0,");
                dVar.q("36chatroom_membercount", "0,");
                p.a(byF.rzD, dVar);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.SG());
                ((com.tencent.mm.plugin.sns.b.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.c.class)).h(12990, dVar);
            }
        }
    }

    public static void a(a aVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20source_publishid", str + ",");
        dVar.q("21uxinfo", str2 + ",");
        dVar.q("22clienttime", bi.Wy() + ",");
        dVar.q("23video_statu", ",");
        dVar.q("24source_type", i + ",");
        dVar.q("25scene", i2 + ",");
        dVar.q("26action_type", aVar.value + ",");
        dVar.q("27scene_chatname", str4 + ",");
        dVar.q("28scene_username", str3 + ",");
        dVar.q("29curr_publishid", str5 + ",");
        dVar.q("30curr_msgid", j + ",");
        dVar.q("31curr_favid", i3 + ",");
        dVar.q("32elapsed_time", "0,");
        dVar.q("33load_time", "0,");
        dVar.q("34is_load_complete", "0,");
        dVar.q("35destination", "0,");
        dVar.q("36chatroom_membercount", i4 + ",");
        f.a(str5, dVar);
        x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.SG());
        g.pWK.h(12990, dVar);
    }

    public static void a(d dVar, c cVar, e eVar, int i, m mVar) {
        bpb byF = mVar.byF();
        List list = byF.wYj.wfh;
        if (list != null && !list.isEmpty()) {
            if ((byF.wYj.wfg == 15 && mVar.xD(32)) || byF.wYj.wfg == 18) {
                list.get(0);
                if (mVar.xD(32) && byF.wYj.wfg == 15) {
                    byF.wYo.hff = mVar.byD().rfQ;
                    byF.wYo.hfg = byF.nMq;
                }
                com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
                dVar2.q("20source_publishid", byF.wYo.hfg + ",");
                dVar2.q("21uxinfo", byF.wYo.hff + ",");
                dVar2.q("22clienttime", bi.Wy() + ",");
                dVar2.q("23video_statu", eVar.value + ",");
                dVar2.q("24source_type", (byF.wYj.wfg == 15 ? 1 : 2) + ",");
                dVar2.q("25scene", dVar.value + ",");
                dVar2.q("26action_type", cVar.value + ",");
                dVar2.q("27scene_chatname", ",");
                dVar2.q("28scene_username", byF.kyG + ",");
                dVar2.q("29curr_publishid", byF.nMq + ",");
                dVar2.q("30curr_msgid", "0,");
                dVar2.q("31curr_favid", "0,");
                dVar2.q("32chatroom_membercount", "0,");
                dVar2.q("33chatroom_toMemberCount", i + ",");
                p.a(byF.rzD, dVar2);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar2.SG());
                g.pWK.h(12991, dVar2);
            }
        }
    }

    public static void a(c cVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20source_publishid", str + ",");
        dVar.q("21uxinfo", str2 + ",");
        dVar.q("22clienttime", bi.Wy() + ",");
        dVar.q("23video_statu", "3,");
        dVar.q("24source_type", i + ",");
        dVar.q("25scene", i2 + ",");
        dVar.q("26action_type", cVar.value + ",");
        dVar.q("27scene_chatname", str4 + ",");
        dVar.q("28scene_username", str3 + ",");
        dVar.q("29curr_publishid", str5 + ",");
        dVar.q("30curr_msgid", j + ",");
        dVar.q("31curr_favid", i3 + ",");
        dVar.q("32chatroom_membercount", i4 + ",");
        dVar.q("33chatroom_toMemberCount", i5 + ",");
        x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar.SG());
        f.a(str5, dVar);
        g.pWK.h(12991, dVar);
    }
}
