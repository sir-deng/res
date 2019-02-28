package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class l {
    public static boolean a(String str, VideoTransPara videoTransPara, aqp aqp, d dVar) {
        try {
            if (bi.oN(str) || videoTransPara == null) {
                return false;
            }
            if (aqp == null) {
                aqp = new aqp();
            }
            x.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", Boolean.valueOf(aqp.wEa), str, videoTransPara, Boolean.valueOf(aqp.wEe));
            if (aqp.wEe) {
                x.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", str);
                return false;
            } else if (!aqp.wEa || bi.oN(str)) {
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, d.Na().getWeixinMeta());
                if (!bi.oN(aqp.wEd)) {
                    SightVideoJNI.tagMp4RecordInfo(str, aqp.wEd);
                }
                long Wz = bi.Wz();
                SightVideoJNI.optimizeMP4(str);
                x.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", Long.valueOf(bi.bB(Wz)));
                dVar.aZH();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
                x.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                x.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height), Integer.valueOf(videoTransPara.videoBitrate));
                int min = Math.min(i, i2);
                x.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", Boolean.valueOf(q.gHM.gIe == 1), Boolean.valueOf(bi.getInt(((a) g.h(a.class)).Af().getValue("MMSightCheckSendVideoBitrate"), 0) == 1), Float.valueOf(bi.getFloat(((a) g.h(a.class)).Af().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f)));
                Object obj = ((q.gHM.gIe == 1) || (bi.getInt(((a) g.h(a.class)).Af().getValue("MMSightCheckSendVideoBitrate"), 0) == 1)) ? 1 : null;
                if (min > videoTransPara.width && ((min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16) && (obj == null || ((float) i3) < ((float) videoTransPara.videoBitrate) * r5))) {
                    return true;
                }
                if (aqp.wDZ) {
                    return true;
                }
                if (((double) i3) >= ((double) videoTransPara.videoBitrate) * 1.3d) {
                    return true;
                }
                aqp.wEe = true;
                return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", e.getMessage(), str);
            if (aqp != null) {
                aqp.wEe = true;
            }
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, aqp aqp, d dVar) {
        if (aqp == null || !aqp.wEa || !FileOp.bO(str)) {
            return -1;
        }
        if (aqp.wEe) {
            x.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", str);
        }
        try {
            String str2;
            String substring;
            String mk = FileOp.mk(str);
            if (mk.endsWith("/")) {
                str2 = mk;
            } else {
                str2 = mk + "/";
            }
            mk = new File(str).getName();
            int lastIndexOf = mk.lastIndexOf(46);
            if (lastIndexOf > 0) {
                substring = mk.substring(0, lastIndexOf);
            } else {
                substring = mk;
            }
            mk = str2 + substring + "_hd";
            if (str.endsWith(".mp4")) {
                mk = mk + ".mp4";
            }
            String str3 = str2 + substring + "tempRemuxing.mp4";
            FileOp.x(str, mk);
            x.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", str2, substring, mk, str3, Integer.valueOf(aqp.wEb));
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(mk);
            int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            if (Math.min(i, i2) < videoTransPara.width) {
                return 0;
            }
            int i3;
            int min = Math.min(i, i2);
            if (min <= videoTransPara.width || (min > videoTransPara.width && min % 16 == 0 && Math.abs(min - videoTransPara.width) < 16)) {
                i3 = i2;
                min = i;
            } else {
                if (i < i2) {
                    min = videoTransPara.width;
                    i3 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) min)));
                } else {
                    i3 = videoTransPara.width;
                    min = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i3)));
                }
                if (i3 % 2 != 0) {
                    i3++;
                }
                if (min % 2 != 0) {
                    min++;
                }
            }
            x.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(min), Integer.valueOf(i3), videoTransPara);
            long Wz = bi.Wz();
            x.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(min), Integer.valueOf(i3), Integer.valueOf(SightVideoJNI.remuxing(mk, str3, min, i3, videoTransPara.videoBitrate, videoTransPara.hvQ, 8, videoTransPara.hvP, 25.0f, 30.0f, null, 0, false)), Long.valueOf(bi.bB(Wz)));
            FileOp.at(str3, str);
            long Wz2 = bi.Wz();
            if (aqp.wEa) {
                SightVideoJNI.tagMP4Dscp(str, d.Na().getWeixinMeta());
                if (!bi.oN(aqp.wEd)) {
                    SightVideoJNI.tagMp4RecordInfo(str, aqp.wEd);
                }
                SightVideoJNI.optimizeMP4(str);
            }
            dVar.aZH();
            x.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", Long.valueOf(bi.bB(Wz2)));
            return r2;
        } catch (Exception e) {
            x.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", e.getMessage());
            return -1;
        }
    }
}
