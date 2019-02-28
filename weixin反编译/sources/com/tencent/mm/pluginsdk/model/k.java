package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.e;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class k extends Thread {
    private static int hGs;
    private static HashMap<String, b> tZu = new HashMap();
    private static Object tZv = new byte[0];
    private static at tZw;
    private Context context;
    private Intent intent;
    private boolean isStop;
    private List<String> tZk;
    private List<Integer> tZl = new ArrayList();
    private List<String> tZm = new ArrayList();
    private List<String> tZn = new ArrayList();
    private List<Integer> tZo = new ArrayList();
    private String talker;
    private int vka;
    private a vkb;

    public interface a {
        void bZe();
    }

    private static final class b implements com.tencent.mm.sdk.platformtools.at.a {
        String fileName;
        String hVd;
        private int oBZ;
        private int oCa;
        int tZA;
        VideoTransPara tZB;
        private boolean tZC;
        private int tZD;
        String tZz;
        String toUser;
        int vka;

        private b() {
            this.tZD = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final boolean JH() {
            Object obj;
            synchronized (k.tZv) {
                obj = !k.tZu.containsKey(this.fileName) ? 1 : null;
            }
            if (obj == null) {
                obj = t.nJ(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                x.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", this.fileName);
                return true;
            }
            k.hGs = HardCoderJNI.startPerformance(HardCoderJNI.hcEncodeVideoEnable, HardCoderJNI.hcEncodeVideoDelay, HardCoderJNI.hcEncodeVideoCPU, HardCoderJNI.hcEncodeVideoIO, HardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, HardCoderJNI.hcEncodeVideoTimeout, 603, HardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo");
            x.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(k.hGs));
            if (this.tZB == null || this.tZB.isDefault) {
                int[] iArr = new int[2];
                k.d(this.hVd, iArr);
                this.oBZ = iArr[0];
                this.oCa = iArr[1];
            } else {
                this.oBZ = this.tZB.width;
                this.oCa = this.tZB.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().a(this.hVd, pString, pInt) && com.tencent.mm.sdk.platformtools.k.fv(pString.value, this.tZz)) {
                x.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
                this.tZA = pInt.value;
                this.tZC = true;
                return true;
            }
            long Wz = bi.Wz();
            if (this.tZB != null) {
                x.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", this.tZB);
                if (com.tencent.mm.plugin.sight.base.b.qyZ) {
                    this.tZB.videoBitrate = (int) (((double) this.tZB.videoBitrate) * 0.915d);
                }
                this.tZA = SightVideoJNI.remuxing(this.hVd, this.tZz, this.oBZ, this.oCa, this.tZB.videoBitrate, this.tZB.hvQ, 8, this.tZB.hvP, 25.0f, (float) this.tZB.fps, null, 0, com.tencent.mm.plugin.sight.base.b.qyZ);
            } else {
                x.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", this.fileName);
                if (com.tencent.mm.plugin.sight.base.b.qyZ) {
                    com.tencent.mm.plugin.sight.base.b.qzb = (int) (((double) com.tencent.mm.plugin.sight.base.b.qzb) * 0.915d);
                }
                this.tZA = SightVideoJNI.remuxing(this.hVd, this.tZz, this.oBZ, this.oCa, com.tencent.mm.plugin.sight.base.b.qzb, com.tencent.mm.plugin.sight.base.b.qza, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qzc, null, 0, com.tencent.mm.plugin.sight.base.b.qyZ);
            }
            this.tZD = (int) bi.bB(Wz);
            x.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.hVd, this.tZz, Integer.valueOf(this.tZA), Integer.valueOf(this.oBZ), Integer.valueOf(this.oCa));
            this.tZC = this.tZA >= 0;
            PInt pInt2 = new PInt();
            if (t.a(this.tZz, pInt2, new PInt())) {
                this.tZA = pInt2.value;
            }
            if (this.tZC) {
                x.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                try {
                    String name = new File(this.tZz).getName();
                    String str = this.tZz + ".tmp";
                    PInt pInt3 = new PInt(0);
                    if (d.b(this.tZz, str, pInt3)) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.tZz);
                        File file = new File(str);
                        boolean g = e.g(file.getParent() + File.separator, file.getName(), name);
                        x.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(g), file.getAbsolutePath(), this.tZz);
                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 30, 1, false);
                    } else {
                        if (pInt3.value != 1) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 31, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 32, 1, false);
                            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(600), Long.valueOf(bi.Wx()), this.tZz);
                        }
                        x.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt3.value), this.hVd, this.tZz);
                    }
                    ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().I(this.hVd, this.tZz, this.tZA);
                } catch (Exception e) {
                    x.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", e.toString());
                }
            } else {
                x.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                com.tencent.mm.loader.stub.b.deleteFile(this.tZz);
                com.tencent.mm.sdk.platformtools.k.r(this.hVd, this.tZz, false);
            }
            if (k.hGs != 0) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcEncodeVideoEnable, k.hGs);
                x.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformace %s", Integer.valueOf(k.hGs));
                k.hGs = 0;
            }
            return true;
        }

        public final boolean JI() {
            int i;
            int i2;
            synchronized (k.tZv) {
                k.tZu.remove(this.fileName);
            }
            if (this.tZC) {
                k.cQ(this.tZz, this.vka);
            } else {
                k.cP(this.tZz, this.vka);
            }
            k.d(this.tZC, this.hVd, this.tZz);
            if (com.tencent.mm.plugin.sight.base.b.qyZ) {
                i = 1;
            } else {
                i = 0;
            }
            k.a(i, this.tZD, this.hVd, this.tZz, this.tZA);
            if (this.vka == 1) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            n.TZ().a(this.hVd, this.tZz, this.toUser, "", "", i2, this.tZC ? 1 : 3);
            t.j(this.fileName, this.tZA, 43);
            t.nE(this.fileName);
            return false;
        }
    }

    static /* synthetic */ void a(int i, int i2, String str, String str2, int i3) {
        long bN = (long) e.bN(str);
        if (bN > 0) {
            int bN2 = (int) ((100 * ((long) e.bN(str2))) / bN);
            x.i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", Integer.valueOf(i), Long.valueOf(bN), Long.valueOf((long) e.bN(str2)), Integer.valueOf(bN2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            com.tencent.mm.plugin.report.service.g.pWK.h(13432, Integer.valueOf(i), Long.valueOf(bN), Long.valueOf(r2), Integer.valueOf(bN2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            return;
        }
        x.e("MicroMsg.ImportMultiVideo", "file canot be empty");
    }

    static /* synthetic */ void cQ(String str, int i) {
        if (i == 2) {
            long bN = (long) e.bN(str);
            int e = bi.e((Integer) com.tencent.mm.plugin.report.service.g.a((int) (bN / 1024), new int[]{WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, (int) an.CTRL_INDEX, 255));
            com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) e, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.a(106, 246, 1, false);
            x.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + e + " file len : " + (bN / 1024) + "K");
        }
    }

    public k(Context context, List<String> list, Intent intent, String str, int i, a aVar) {
        this.context = context;
        this.tZk = list;
        this.intent = intent;
        this.vkb = aVar;
        this.talker = str;
        this.vka = i;
    }

    public final void run() {
        if (this.tZk == null || this.tZk.size() <= 0) {
            v(this.context, this.intent);
        } else {
            for (int i = 0; i < this.tZk.size() && !this.isStop; i++) {
                x.i("MicroMsg.ImportMultiVideo", "start to import %s", this.tZk.get(i));
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.tZk.get(i))));
                v(this.context, intent);
            }
        }
        if (this.vkb != null && !this.isStop) {
            ah.y(new Runnable() {
                public final void run() {
                    a e = k.this.vkb;
                    k.this.tZl;
                    k.this.tZm;
                    k.this.tZn;
                    k.this.tZo;
                    e.bZe();
                }
            });
        }
    }

    private void v(Context context, Intent intent) {
        String nw = s.nw((String) g.Dq().Db().get(2, (Object) ""));
        o.Ub();
        String ny = s.ny(nw);
        o.Ub();
        String nx = s.nx(nw);
        boolean is2G = ao.is2G(ad.getContext());
        String i = com.tencent.mm.compatible.j.a.i(context, intent);
        if (bi.oN(i)) {
            x.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, nw, i, 0, null, intent);
            return;
        }
        VideoTransPara videoTransPara;
        int i2;
        Object obj;
        int i3;
        com.tencent.mm.compatible.j.a.a j;
        boolean oQ = c.oQ(i);
        int bN = e.bN(i);
        if (oQ) {
            VideoTransPara videoTransPara2;
            PInt pInt = new PInt();
            if (com.tencent.mm.modelcontrol.d.Na().kP(i)) {
                x.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", i);
                pInt.value = 1;
                com.tencent.mm.plugin.report.service.g.pWK.a(422, 51, 1, false);
                videoTransPara2 = null;
            } else {
                VideoTransPara videoTransPara3 = new VideoTransPara();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                PInt pInt6 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(i, pInt2, pInt3, pInt4, pInt5, pInt6);
                videoTransPara3.duration = pInt2.value / 1000;
                videoTransPara3.width = pInt3.value;
                videoTransPara3.height = pInt4.value;
                videoTransPara3.fps = pInt5.value;
                videoTransPara3.videoBitrate = pInt6.value;
                x.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", videoTransPara3);
                videoTransPara2 = com.tencent.mm.modelcontrol.d.Na().a(videoTransPara3);
                if (videoTransPara2 == null) {
                    x.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", videoTransPara3);
                    pInt.value = -5;
                    videoTransPara2 = null;
                } else {
                    x.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", videoTransPara2);
                    if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                        x.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", videoTransPara2, videoTransPara3);
                        pInt.value = 1;
                        videoTransPara2 = null;
                    } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * 1000 < 180000) {
                        boolean is2G2 = ao.is2G(ad.getContext());
                        pInt.value = SightVideoJNI.shouldRemuxing(i, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, Constants.MAX_BUFFER_SIZE);
                    } else {
                        pInt.value = -6;
                        videoTransPara2 = null;
                    }
                }
            }
            videoTransPara = videoTransPara2;
            i2 = pInt.value;
        } else {
            if (bN > (is2G ? 10485760 : 26214400)) {
                i2 = -5;
                videoTransPara = null;
            } else {
                i2 = 1;
                videoTransPara = null;
            }
        }
        x.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i2), Boolean.valueOf(oQ), Integer.valueOf(bN));
        switch (i2) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, nw, i, 0, null, intent);
                return;
            case -5:
                a(-50008, nw, i, 0, null, intent);
                return;
            case -1:
                a(-50007, nw, i, 0, null, intent);
                return;
            case 0:
                obj = 1;
                i3 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (bN <= 26214400) {
                    obj = null;
                    i3 = 0;
                    break;
                }
                a(-50002, nw, i, 0, null, intent);
                obj = null;
                i3 = -50002;
                break;
            default:
                x.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, nw, i, 0, null, intent);
                return;
        }
        com.tencent.mm.compatible.j.a.a aVar = null;
        try {
            j = com.tencent.mm.compatible.j.a.j(context, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            x.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, nw, i, 0, null, intent);
            return;
        }
        if (obj == null) {
            com.tencent.mm.sdk.platformtools.k.r(i, nx, false);
            cP(nx, this.vka);
            d(false, i, nx);
        } else {
            i3 = -50006;
        }
        int fN = bi.fN((long) j.duration);
        Object obj2 = 1;
        if (j.bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, ny, true);
                obj2 = null;
                kW(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                kW(false);
                com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ny, true);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e22, "", new Object[0]);
            }
        }
        if (obj == null && !e.bO(nx)) {
            i3 = -50003;
        }
        if (!e.bO(ny)) {
            i3 = -50004;
        }
        a(i3, nw, i, fN, videoTransPara, intent);
    }

    public final void bZc() {
        this.isStop = true;
        interrupt();
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Intent intent) {
        x.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        e(i, str, str2, i2);
        int i3;
        if (i == -50002) {
            i3 = this.vka == 1 ? bs.CTRL_INDEX : 245;
            x.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i3 + " importType : " + this.vka);
            com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) i3, 1, false);
            a(this.talker, str, str2, intent, i2, (int) j.CTRL_INDEX);
        } else if (i == -50008) {
            com.tencent.mm.plugin.report.service.g.pWK.a(106, 210, 1, false);
            a(this.talker, str, str2, intent, i2, (int) com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
        } else if (i == -50006) {
            if (t.a(str, 1, this.talker, str2, 43) < 0) {
                a(this.talker, str, str2, intent, i2, 142);
                x.e("MicroMsg.ImportMultiVideo", "prepare");
                return;
            }
            if (tZw == null) {
                tZw = new at(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            com.tencent.mm.sdk.platformtools.at.a bVar = new b();
            synchronized (tZv) {
                tZu.put(str, bVar);
            }
            bVar.fileName = str;
            bVar.hVd = str2;
            o.Ub();
            bVar.tZz = s.nx(str);
            bVar.vka = this.vka;
            bVar.toUser = this.talker;
            bVar.tZB = videoTransPara;
            tZw.c(bVar);
        } else if (i < 0) {
            i3 = this.vka == 1 ? be.CTRL_INDEX : com.tencent.mm.plugin.appbrand.jsapi.f.c.a.CTRL_INDEX;
            x.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i3 + " importType : " + this.vka);
            com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) i3, 1, false);
            a(this.talker, str, str2, intent, i2, 142);
        } else {
            t.b(str, i2, this.talker, str2);
            t.nE(str);
            int i4 = this.vka == 1 ? 8 : 1;
            o.Ub();
            n.TZ().a(str2, s.nx(str), this.talker, "", "", i4, 2);
        }
    }

    private void a(String str, String str2, String str3, Intent intent, int i, int i2) {
        cg auVar = new au();
        auVar.eR(5);
        auVar.dU(str);
        auVar.aq(bb.hU(str));
        auVar.eS(1);
        auVar.dV(str2);
        auVar.setType(43);
        long Q = ((h) g.h(h.class)).aZO().Q(auVar);
        x.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_talker, Integer.valueOf(auVar.getType()), Integer.valueOf(auVar.field_isSend), auVar.field_imgPath, Integer.valueOf(auVar.field_status), Long.valueOf(auVar.field_createTime));
        if (-1 == Q) {
            x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", str);
        } else if (t.nJ(str2) == null) {
            o.Ub();
            String ny = s.ny(str2);
            try {
                com.tencent.mm.compatible.j.a.a j = com.tencent.mm.compatible.j.a.j(this.context, intent);
                int nz;
                int nz2;
                r rVar;
                if (j == null || j.bitmap == null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ah(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ny, true);
                    nz = s.nz(ny);
                    o.Ub();
                    nz2 = s.nz(s.nx(str2));
                    rVar = new r();
                    rVar.fileName = str2;
                    if (nz2 <= 0) {
                        nz2 = 0;
                    }
                    rVar.hmZ = nz2;
                    rVar.hXr = nz;
                    rVar.hXv = i;
                    rVar.fEx = str;
                    rVar.hXn = (String) g.Dq().Db().get(2, (Object) "");
                    rVar.hXs = bi.Wx();
                    rVar.hXt = bi.Wx();
                    rVar.hXB = null;
                    rVar.hVd = str3;
                    if (!bi.oN(str3)) {
                        rVar.hXz = 1;
                    }
                    rVar.hXC = -1;
                    rVar.status = i2;
                    rVar.hXw = (int) Q;
                    if (!o.Ub().a(rVar)) {
                        x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(Q));
                    }
                }
                i = bi.fN((long) j.duration);
                com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, ny, true);
                nz = s.nz(ny);
                o.Ub();
                nz2 = s.nz(s.nx(str2));
                rVar = new r();
                rVar.fileName = str2;
                if (nz2 <= 0) {
                    nz2 = 0;
                }
                rVar.hmZ = nz2;
                rVar.hXr = nz;
                rVar.hXv = i;
                rVar.fEx = str;
                rVar.hXn = (String) g.Dq().Db().get(2, (Object) "");
                rVar.hXs = bi.Wx();
                rVar.hXt = bi.Wx();
                rVar.hXB = null;
                rVar.hVd = str3;
                if (bi.oN(str3)) {
                    rVar.hXz = 1;
                }
                rVar.hXC = -1;
                rVar.status = i2;
                rVar.hXw = (int) Q;
                if (!o.Ub().a(rVar)) {
                    x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(Q));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            }
        }
    }

    public static void d(String str, int[] iArr) {
        Throwable th;
        int i = 0;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                iArr[0] = i2;
                iArr[1] = i3;
                while (i < 3) {
                    if (i2 % 2 == 0 && i3 % 2 == 0) {
                        if ((i2 >= i3 && (i2 <= 640 || i3 <= 480)) || (i2 <= i3 && (i2 <= 480 || i3 <= 640))) {
                            break;
                        }
                        i2 /= 2;
                        i3 /= 2;
                        i++;
                    } else {
                        mediaMetadataRetriever.release();
                        return;
                    }
                }
                iArr[0] = i2;
                iArr[1] = i3;
                mediaMetadataRetriever.release();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        this.tZl.add(Integer.valueOf(i));
        this.tZm.add(str);
        this.tZn.add(str2);
        this.tZo.add(Integer.valueOf(i2));
    }

    public static void bZd() {
        int size;
        synchronized (tZv) {
            size = tZu.size();
            tZu.clear();
        }
        if (tZw == null) {
            x.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", Integer.valueOf(size));
            return;
        }
        x.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", Integer.valueOf(size), Integer.valueOf(tZw.xpI.size()));
        tZw.xpI.clear();
        tZw = null;
    }

    public static boolean Sa(String str) {
        boolean containsKey;
        synchronized (tZv) {
            containsKey = tZu.containsKey(str);
        }
        x.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", str, Boolean.valueOf(containsKey));
        return containsKey;
    }

    public static void Sb(String str) {
        boolean z = true;
        synchronized (tZv) {
            if (tZu.remove(str) == null) {
                z = false;
            }
            x.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", str, Boolean.valueOf(z));
        }
    }

    private void kW(boolean z) {
        int i;
        if (this.vka == 1) {
            if (z) {
                i = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
            } else {
                i = 218;
            }
        } else if (z) {
            i = 231;
        } else {
            i = 232;
        }
        x.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.vka);
        com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) i, 1, false);
    }

    private static void cP(String str, int i) {
        int i2;
        int i3;
        int i4;
        if (i == 1) {
            i2 = 219;
            i3 = JsApiOpenWeRunSetting.CTRL_INDEX;
            i4 = 220;
        } else {
            i2 = 233;
            i3 = 242;
            i4 = 234;
        }
        long bN = (long) e.bN(str);
        i3 = bi.e((Integer) com.tencent.mm.plugin.report.service.g.a((int) (bN / 1024), new int[]{WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, i4, i3));
        com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) i3, 1, false);
        com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) i2, 1, false);
        x.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i3 + " file len : " + (bN / 1024) + "K");
    }

    private static void d(boolean z, String str, String str2) {
        int i = 1;
        if (!z) {
            i = 0;
        }
        if (bi.oN(str) || bi.oN(str2)) {
            x.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            return;
        }
        try {
            long bN = (long) e.bN(str);
            long bN2 = (long) e.bN(str2);
            int i2 = (int) ((100 * bN2) / bN);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(bN).append(";");
            stringBuilder.append(bN2).append(";").append(i2);
            x.d("MicroMsg.AtomStatUtil", "report video remuxing : " + stringBuilder.toString());
            com.tencent.mm.plugin.report.service.g.pWK.h(11098, Integer.valueOf(8001), r0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AtomStatUtil", e, "", new Object[0]);
            x.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
        }
    }
}
