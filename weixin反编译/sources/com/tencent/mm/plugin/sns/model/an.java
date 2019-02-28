package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.f.a.ar;
import com.tencent.mm.f.a.f;
import com.tencent.mm.f.a.qc;
import com.tencent.mm.j.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.Date;

public final class an {
    boolean hWt = false;
    boolean hWu = false;
    long rdq = 0;
    private boolean rdr = false;
    int rds = 0;
    int rdt = 1440;
    c<qc> rdu = new c<qc>() {
        {
            this.xmG = qc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return bwH();
        }

        private boolean bwH() {
            int minutes;
            int i = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
            an anVar = an.this;
            try {
                if (anVar.bwG()) {
                    Date date = new Date();
                    minutes = date.getMinutes() + (date.getHours() * 60);
                    if (minutes >= anVar.rds && minutes <= anVar.rdt) {
                        x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", Integer.valueOf(minutes), Integer.valueOf(anVar.rds), Integer.valueOf(anVar.rdt));
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            int i2 = g.Af().getInt("SnsImgPreLoadingSmallImage", 1);
            int i3 = g.Af().getInt("SnsImgPreLoadingBigImage", 1);
            int i4 = g.Af().getInt("SnsPreLoadingVideo", 1);
            minutes = g.Af().getInt("SnsImgPreLoadingInterval", TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            x.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minutes));
            if (i2 > 0 || i3 > 0 || i4 > 0) {
                if (minutes > 0) {
                    i = minutes;
                }
                if (anVar.hWt || anVar.hWu || bi.bz(anVar.rdq) < ((long) i)) {
                    x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", Boolean.valueOf(anVar.hWt), Boolean.valueOf(anVar.hWu));
                } else if (x.KH("@__weixintimtline")) {
                    com.tencent.mm.kernel.g.Dr();
                    if (!com.tencent.mm.kernel.g.Dp().gRu.a(new s(), 0)) {
                        x.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                        x.KI("@__weixintimtline");
                    }
                    anVar.rdq = bi.Wx();
                } else {
                    x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
                }
            }
            return false;
        }
    };
    c rdv = new c<f>() {
        {
            this.xmG = f.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f fVar = (f) bVar;
            if (fVar.fnL.className.equals("SnsTimeLineUI")) {
                an.this.hWu = fVar.fnL.ahf;
                x.i("MicroMsg.SnsPreTimelineService", "set isInSnsTimeline:%b", Boolean.valueOf(an.this.hWu));
            }
            return false;
        }
    };
    c rdw = new c<ar>() {
        {
            this.xmG = ar.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ar arVar = (ar) bVar;
            an.this.hWt = arVar.fpJ.fpK;
            x.i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", Boolean.valueOf(an.this.hWt));
            return false;
        }
    };

    an() {
    }

    final boolean bwG() {
        String value = g.Af().getValue("SnsImgPreLoadingTimeLimit");
        x.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", value);
        if (bi.oN(value)) {
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(":");
            this.rds = bi.Wo(split2[1]) + (bi.Wo(split2[0]) * 60);
            split = split[1].split(":");
            this.rdt = bi.Wo(split[1]) + (bi.Wo(split[0]) * 60);
            x.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", Integer.valueOf(this.rds), Integer.valueOf(this.rdt));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
