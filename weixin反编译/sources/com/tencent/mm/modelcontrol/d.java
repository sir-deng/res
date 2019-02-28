package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements ap {
    private static final int hvD = c.ak("dscp");
    private a hvE = new a();
    private byte[] hvF = null;
    private b hvG;
    private e[] hvH;
    private e[] hvI;
    private e[] hvJ;
    private e[] hvK;
    private e[] hvL;

    public static d Na() {
        return (d) p.s(d.class);
    }

    private e[] kO(String str) {
        int i = 0;
        String value = ((a) g.h(a.class)).Af().getValue(str);
        if (bi.oN(value)) {
            x.i("MicroMsg.SubCoreVideoControl", "key %s config is null", str);
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[" + value;
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        x.i("MicroMsg.SubCoreVideoControl", "%s=%s ", str, value);
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            x.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", Integer.valueOf(length));
            e[] eVarArr = new e[length];
            while (i < length) {
                eVarArr[i] = c(jSONArray.getJSONObject(i));
                i++;
            }
            return eVarArr;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            return null;
        }
    }

    private static e c(JSONObject jSONObject) {
        e eVar = new e();
        try {
            String str;
            String string = jSONObject.isNull("time") ? "" : jSONObject.getString("time");
            String string2 = jSONObject.getString("abr");
            String string3 = jSONObject.getString("intval");
            String string4 = jSONObject.getString("prof");
            String string5 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                str = "0";
            } else {
                str = jSONObject.getString("stepbr");
            }
            x.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", string, string2, string3, string4, string5, str);
            eVar.a(string, string2, string3, string4, string5, str);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            List arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
                i = i2 + 1;
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !eVar.hvR) {
                i = 1;
                int i3 = ((f) arrayList.get(0)).hvZ;
                while (true) {
                    int i4 = i;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    f fVar = (f) arrayList.get(i4);
                    fVar.hvY = i3;
                    i3 = fVar.hvZ;
                    i = i4 + 1;
                }
            }
            eVar.hvS = new f[arrayList.size()];
            arrayList.toArray(eVar.hvS);
            x.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", eVar);
            return eVar;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        if (bi.oN(str2) || bi.oN(str3) || bi.oN(str4)) {
            return false;
        }
        try {
            String[] split;
            if (bi.oN(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = bi.getInt(split[0], -1);
                pInt2.value = bi.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    return false;
                }
            }
            split = str2.split("x");
            pInt3.value = bi.getInt(split[0], -1);
            pInt4.value = bi.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                return false;
            }
            pInt5.value = bi.getInt(str3, -1);
            pInt6.value = bi.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                return false;
            }
            pInt6.value *= 1000;
            x.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value));
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    public final byte[] getWeixinMeta() {
        if (bi.by(this.hvF)) {
            try {
                this.hvF = ("{\"WXVer\":" + com.tencent.mm.protocal.d.vHl + "}").getBytes("UTF-8");
                x.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", r0);
            } catch (Exception e) {
                x.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", e.toString());
            }
        }
        return this.hvF;
    }

    public final boolean kP(String str) {
        Exception e;
        Throwable th;
        if (this.hvG == null) {
            this.hvG = new b();
        }
        b bVar = this.hvG;
        bVar.igX = -1;
        bVar.igZ = -1;
        bVar.iha = null;
        long Wz = bi.Wz();
        long oP = this.hvG.oP(str);
        if (oP <= 0) {
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(oP);
                byte[] bArr = new byte[8];
                com.tencent.mm.plugin.a.a aVar = null;
                for (com.tencent.mm.plugin.a.a a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.akN); a != null; a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.akN)) {
                    aVar = c.a(randomAccessFile, bArr, hvD);
                    if (aVar != null) {
                        break;
                    }
                    randomAccessFile.seek(a.WE());
                }
                if (aVar != null) {
                    byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                    randomAccessFile.seek(aVar.igW + 8);
                    if (randomAccessFile.read(bArr2) > 0) {
                        str2 = new String(bArr2, "UTF-8");
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(oP), Long.valueOf(bi.bB(Wz)), str);
                    if (bi.oN(str2)) {
                        return str2.contains("WXVer");
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(oP), Long.valueOf(bi.bB(Wz)), str);
            if (bi.oN(str2)) {
                return str2.contains("WXVer");
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(oP), Long.valueOf(bi.bB(Wz)), str);
        if (bi.oN(str2)) {
            return str2.contains("WXVer");
        }
        return false;
    }

    public final VideoTransPara Nb() {
        VideoTransPara Nk;
        boolean z;
        VideoTransPara videoTransPara;
        long Wz = bi.Wz();
        if (this.hvH == null) {
            this.hvH = kO("C2CRecordVideoConfig");
        }
        if (this.hvH != null) {
            for (e eVar : this.hvH) {
                if (eVar != null && eVar.Nj()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    Nk = eVar.Nk();
                    z = eVar.hvR;
                    break;
                }
            }
        }
        Nk = null;
        z = true;
        if (Nk == null) {
            Nk = new VideoTransPara();
            Nk.isDefault = true;
            Nk.width = 540;
            Nk.height = 960;
            Nk.fps = 30;
            Nk.videoBitrate = 1200000;
            Nk.hvO = 1;
            Nk.hvN = 64000;
            Nk.hvP = 2;
            Nk.hvQ = 1;
            videoTransPara = Nk;
        } else {
            videoTransPara = Nk;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.hvO = 1;
        videoTransPara.duration = 10;
        if (z) {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 12, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 11, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(422, (long) bi.e((Integer) com.tencent.mm.plugin.report.service.g.a(videoTransPara.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 13, 18)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", Long.valueOf(bi.bB(Wz)), videoTransPara, Integer.valueOf(r0));
        return videoTransPara;
    }

    public final VideoTransPara Nc() {
        VideoTransPara Nk;
        boolean z;
        VideoTransPara Ne;
        long Wz = bi.Wz();
        if (this.hvI == null) {
            this.hvI = kO("SnsRecordVideoConfig");
        }
        if (this.hvI != null) {
            for (e eVar : this.hvI) {
                if (eVar != null && eVar.Nj()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    Nk = eVar.Nk();
                    z = eVar.hvR;
                    break;
                }
            }
        }
        Nk = null;
        z = true;
        if (Nk == null) {
            Ne = Ne();
        } else {
            Ne = Nk;
        }
        Ne.audioSampleRate = 44100;
        Ne.hvO = 1;
        Ne.duration = 10;
        Ne.hwa = 200;
        if (z) {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 32, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 31, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(422, (long) bi.e((Integer) com.tencent.mm.plugin.report.service.g.a(Ne.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", Long.valueOf(bi.bB(Wz)), Ne, Integer.valueOf(r0));
        return Ne;
    }

    public final VideoTransPara Nd() {
        VideoTransPara Nk;
        boolean z;
        VideoTransPara Ne;
        long Wz = bi.Wz();
        if (this.hvJ == null) {
            this.hvJ = kO("SnsAlbumVideoConfig");
        }
        if (this.hvJ != null) {
            for (e eVar : this.hvJ) {
                if (eVar != null && eVar.Nj()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    Nk = eVar.Nk();
                    z = eVar.hvR;
                    break;
                }
            }
        }
        Nk = null;
        z = true;
        if (Nk == null) {
            Ne = Ne();
        } else {
            Ne = Nk;
        }
        Ne.audioSampleRate = 44100;
        Ne.hvO = 1;
        Ne.hwa = 200;
        if (z) {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 22, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 21, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(422, (long) bi.e((Integer) com.tencent.mm.plugin.report.service.g.a(Ne.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 23, 28)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", Long.valueOf(bi.bB(Wz)), Ne, Integer.valueOf(r0));
        return Ne;
    }

    public final VideoTransPara a(VideoTransPara videoTransPara) {
        if (videoTransPara.duration >= 300) {
            x.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", Integer.valueOf(300));
            return null;
        }
        e[] eVarArr;
        boolean z;
        int i;
        long Wz = bi.Wz();
        VideoTransPara hz = hz(videoTransPara.duration);
        int i2 = 1;
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100157");
        if (fp.isValid()) {
            i2 = bi.getInt((String) fp.civ().get("VideoEncodeStep"), 1);
        }
        x.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", Integer.valueOf(i2));
        if ((i2 > 0 ? 1 : null) != null) {
            if (this.hvL == null) {
                this.hvL = kO("C2CAlbumVideoStepConfig");
            }
            eVarArr = this.hvL;
        } else {
            if (this.hvK == null) {
                this.hvK = kO("C2CAlbumVideoConfig");
            }
            eVarArr = this.hvK;
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null && eVar.Nj()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                    int a = a.a(eVar.hvS, videoTransPara, hz);
                    z = eVar.hvR;
                    i = a;
                    break;
                }
            }
            z = true;
            i = 0;
        } else {
            x.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
            i = a.a(null, videoTransPara, hz);
            z = true;
        }
        if (i <= 0) {
            hz = hz(videoTransPara.duration);
        } else {
            hz.isDefault = false;
        }
        if (z) {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 2, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(422, 1, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(422, (long) bi.e((Integer) com.tencent.mm.plugin.report.service.g.a(hz.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 3, 8)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", Long.valueOf(bi.bB(Wz)), Integer.valueOf(i2), Integer.valueOf(i), hz, videoTransPara);
        return hz;
    }

    private static VideoTransPara Ne() {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 540;
        videoTransPara.height = 960;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 1600000;
        videoTransPara.hvO = 1;
        videoTransPara.hvN = 64000;
        videoTransPara.hvP = 2;
        videoTransPara.hvQ = 1;
        return videoTransPara;
    }

    private static VideoTransPara hz(int i) {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.hvO = 1;
        videoTransPara.hvN = 48000;
        videoTransPara.hvP = 2;
        videoTransPara.hvQ = 1;
        if (i <= 120) {
            videoTransPara.fps = 30;
            videoTransPara.width = 540;
            videoTransPara.height = 960;
            videoTransPara.videoBitrate = 1200000;
        } else {
            videoTransPara.fps = 24;
            videoTransPara.width = 360;
            videoTransPara.height = 640;
            videoTransPara.videoBitrate = 544000;
        }
        return videoTransPara;
    }

    public static boolean Nf() {
        int i;
        int intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100136");
        if (fp.isValid()) {
            i = bi.getInt((String) fp.civ().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !Nh()) ? false : intValue > 0 ? true : i > 0;
        x.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        return z;
    }

    public static boolean Ng() {
        int i;
        int intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100153");
        if (fp.isValid()) {
            i = bi.getInt((String) fp.civ().get("snsStreamDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !Nh()) ? false : intValue > 0 ? true : i > 0;
        x.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        return z;
    }

    public static boolean Nh() {
        int i;
        String str;
        boolean z;
        String str2 = null;
        long Wz = bi.Wz();
        int intValue = ((Integer) g.Dq().Db().get(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100190");
        if (fp.isValid()) {
            Map civ = fp.civ();
            i = bi.getInt((String) civ.get("player"), 1);
            str = (String) civ.get("apilevel");
            str2 = (String) civ.get("devices");
        } else {
            str = null;
            i = 1;
        }
        int i2 = VERSION.SDK_INT;
        String str3 = Build.BRAND + Build.MODEL;
        if (!bi.oN(str)) {
            for (String str4 : str.split(";")) {
                if (bi.getInt(str4, 0) == i2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!bi.oN(str2)) {
            for (String equalsIgnoreCase : str2.split(";")) {
                if (equalsIgnoreCase.equalsIgnoreCase(str3)) {
                    z = false;
                    break;
                }
            }
        }
        if (com.tencent.mm.compatible.util.d.fO(18)) {
            z = false;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            g.Dq().Db().a(w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.valueOf(true));
        }
        if (intValue == 0) {
            z = false;
        }
        if (i <= 0) {
            z = false;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", Boolean.valueOf(z), Integer.valueOf(i2), str, str3, str2, Integer.valueOf(i), Long.valueOf(bi.bB(Wz)));
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r13, com.tencent.mm.modelvideo.r r14) {
        /*
        r1 = 0;
        r6 = -1;
        r5 = 2;
        r2 = 1;
        r8 = 0;
        switch(r13) {
            case 0: goto L_0x0028;
            case 1: goto L_0x002a;
            case 2: goto L_0x002a;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = r2;
    L_0x0009:
        r1 = "MicroMsg.SubCoreVideoControl";
        r3 = "check c2c video format[%d]";
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r0);
        r2[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r2);
        if (r0 != r5) goto L_0x013d;
    L_0x001c:
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = r2;
        goto L_0x0009;
    L_0x002a:
        r0 = com.tencent.mm.kernel.g.Dq();
        r0 = r0.Db();
        r3 = com.tencent.mm.storage.w.a.USERINFO_SUPPORT_HEVC_VIDEO_INT;
        r4 = java.lang.Integer.valueOf(r6);
        r0 = r0.get(r3, r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r6) goto L_0x005c;
    L_0x0044:
        r0 = com.tencent.mm.plugin.s.e.bah();
        if (r0 == 0) goto L_0x0085;
    L_0x004a:
        r0 = r2;
    L_0x004b:
        r3 = com.tencent.mm.kernel.g.Dq();
        r3 = r3.Db();
        r4 = com.tencent.mm.storage.w.a.USERINFO_SUPPORT_HEVC_VIDEO_INT;
        r6 = java.lang.Integer.valueOf(r6);
        r3.a(r4, r6);
    L_0x005c:
        r3 = "MicroMsg.SubCoreVideoControl";
        r4 = "check device support hevc[%d]";
        r6 = new java.lang.Object[r2];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r8] = r7;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r6);
        if (r0 > 0) goto L_0x0087;
    L_0x006f:
        r4 = r8;
    L_0x0070:
        if (r4 == 0) goto L_0x0008;
    L_0x0072:
        com.tencent.mm.modelvideo.o.Ub();
        r0 = r14.getFileName();
        r0 = com.tencent.mm.modelvideo.s.nx(r0);
        r1 = com.tencent.mm.a.e.bO(r0);
        if (r1 != 0) goto L_0x0134;
    L_0x0083:
        r0 = r5;
        goto L_0x0009;
    L_0x0085:
        r0 = r8;
        goto L_0x004b;
    L_0x0087:
        r0 = com.tencent.mm.y.c.c.IL();
        r3 = "100253";
        r0 = r0.fp(r3);
        r3 = r0.isValid();
        if (r3 == 0) goto L_0x014c;
    L_0x0098:
        r1 = r0.civ();
        r0 = "openHevc";
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r8);
        r0 = "brands";
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r4 = "devices";
        r1 = r1.get(r4);
        r1 = (java.lang.String) r1;
    L_0x00bb:
        r7 = android.os.Build.BRAND;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r4 != 0) goto L_0x014a;
    L_0x00c3:
        r4 = ";";
        r6 = r0.split(r4);
        r9 = r6.length;
        r4 = r8;
    L_0x00cc:
        if (r4 >= r9) goto L_0x014a;
    L_0x00ce:
        r10 = r6[r4];
        r10 = r10.equalsIgnoreCase(r7);
        if (r10 == 0) goto L_0x012e;
    L_0x00d6:
        r4 = r8;
    L_0x00d7:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r9 = android.os.Build.BRAND;
        r6 = r6.append(r9);
        r9 = android.os.Build.MODEL;
        r6 = r6.append(r9);
        r9 = r6.toString();
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r6 != 0) goto L_0x0106;
    L_0x00f2:
        r6 = ";";
        r10 = r1.split(r6);
        r11 = r10.length;
        r6 = r8;
    L_0x00fb:
        if (r6 >= r11) goto L_0x0106;
    L_0x00fd:
        r12 = r10[r6];
        r12 = r12.equalsIgnoreCase(r9);
        if (r12 == 0) goto L_0x0131;
    L_0x0105:
        r4 = r8;
    L_0x0106:
        if (r3 > 0) goto L_0x0109;
    L_0x0108:
        r4 = r8;
    L_0x0109:
        r6 = "MicroMsg.SubCoreVideoControl";
        r10 = "check support hevc [%b] abtestFlag[%d] brands[%s, %s] device[%s, %s]";
        r11 = 6;
        r11 = new java.lang.Object[r11];
        r12 = java.lang.Boolean.valueOf(r4);
        r11[r8] = r12;
        r3 = java.lang.Integer.valueOf(r3);
        r11[r2] = r3;
        r11[r5] = r7;
        r3 = 3;
        r11[r3] = r0;
        r0 = 4;
        r11[r0] = r9;
        r0 = 5;
        r11[r0] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r6, r10, r11);
        goto L_0x0070;
    L_0x012e:
        r4 = r4 + 1;
        goto L_0x00cc;
    L_0x0131:
        r6 = r6 + 1;
        goto L_0x00fb;
    L_0x0134:
        r0 = com.tencent.mm.modelvideo.q.ns(r0);
        if (r0 == 0) goto L_0x0008;
    L_0x013a:
        r0 = r5;
        goto L_0x0009;
    L_0x013d:
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        goto L_0x0027;
    L_0x014a:
        r4 = r2;
        goto L_0x00d7;
    L_0x014c:
        r0 = r1;
        r3 = r8;
        goto L_0x00bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.d.a(int, com.tencent.mm.modelvideo.r):int");
    }

    public static boolean Ni() {
        String str = null;
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100253");
        if (fp.isValid()) {
            str = (String) fp.civ().get("noCompleteRange");
        }
        if (bi.oN(str)) {
            str = "20:00-23:30";
        }
        g.Do();
        x.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", Boolean.valueOf(b.L(str, h.aJ(com.tencent.mm.kernel.a.Cn(), 30))), str, Integer.valueOf(r3));
        return !b.L(str, h.aJ(com.tencent.mm.kernel.a.Cn(), 30));
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        this.hvH = null;
        this.hvL = null;
        this.hvK = null;
        this.hvI = null;
        this.hvJ = null;
    }
}
