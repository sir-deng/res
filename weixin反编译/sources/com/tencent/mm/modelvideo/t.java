package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class t {
    public static boolean nB(String str) {
        if (str == null) {
            return false;
        }
        r nJ = nJ(str);
        if (nJ == null || nJ.hXx >= 2500) {
            return false;
        }
        nJ.hXx++;
        nJ.fEo = 16384;
        return e(nJ);
    }

    public static boolean nC(String str) {
        g.pWK.a(111, 218, 1, false);
        x.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", str, bi.chl());
        o.Ug().fmj.remove(str);
        if (str == null) {
            return false;
        }
        r nJ = nJ(str);
        if (nJ == null) {
            x.e("MicroMsg.VideoLogic", "Set error failed file:" + str);
            return false;
        }
        nJ.status = bc.CTRL_INDEX;
        nJ.hXt = System.currentTimeMillis() / 1000;
        nJ.fEo = BuildConfig.VERSION_CODE;
        aqp aqp = nJ.hXF;
        aqp.wEb = 0;
        nJ.hXF = aqp;
        boolean e = e(nJ);
        x.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + nJ.hXw + " old stat:" + nJ.status);
        if (nJ == null || nJ.hXw == 0) {
            return e;
        }
        au dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI((long) nJ.hXw);
        int type = dI.getType();
        x.i("MicroMsg.VideoLogic", "set error, msg type %d", Integer.valueOf(type));
        if (43 != type && 62 != type) {
            return e;
        }
        d.pVE.a(111, 32, 1, true);
        dI.dU(nJ.Uk());
        dI.setContent(p.b(nJ.Ul(), -1, true));
        x.d("MicroMsg.VideoLogic", "[oneliang][setError]");
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().a(dI.field_msgId, dI);
        return e;
    }

    public static boolean nD(String str) {
        r nJ = nJ(str);
        if (nJ == null || nJ.hXw == 0) {
            return false;
        }
        au dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI((long) nJ.hXw);
        int type = dI.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", Integer.valueOf(type));
        if (43 != type && 62 != type) {
            return false;
        }
        dI.setContent(p.b(nJ.Ul(), (long) nJ.hXv, false));
        dI.eR(2);
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().a((long) nJ.hXw, dI);
        nJ.status = 197;
        nJ.hXt = bi.Wx();
        nJ.fEo = BuildConfig.VERSION_CODE;
        x.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
        return e(nJ);
    }

    public static boolean b(String str, int i, String str2, String str3) {
        return a(str, i, str2, str3, 0, "", 43);
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        return a(str, i, str2, str3, i2, str4, i3, null, "");
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3, bnp bnp, String str5) {
        r rVar = new r();
        rVar.fileName = str;
        rVar.hXv = i;
        rVar.fEx = str2;
        rVar.hXn = (String) com.tencent.mm.kernel.g.Dq().Db().get(2, (Object) "");
        rVar.hXs = bi.Wx();
        rVar.hXt = bi.Wx();
        rVar.hXB = str4;
        rVar.hVd = str3;
        rVar.hXE = bnp;
        rVar.fHB = str5;
        if (!bi.oN(str3)) {
            rVar.hXz = 1;
        }
        if (i2 > 0) {
            rVar.hXz = 1;
        }
        if (62 == i3) {
            rVar.hXC = 3;
        } else if (i2 > 0) {
            rVar.hXC = 2;
        } else {
            rVar.hXC = 1;
        }
        o.Ub();
        int nz = s.nz(s.nx(str));
        if (nz <= 0) {
            x.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
            return false;
        }
        rVar.hmZ = nz;
        o.Ub();
        String ny = s.ny(str);
        int nz2 = s.nz(ny);
        if (nz2 <= 0) {
            x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + ny + " size:" + nz2);
            return false;
        }
        rVar.hXr = nz2;
        x.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + rVar.hXr + " videosize:" + rVar.hmZ + " msgType:" + i3);
        rVar.status = 102;
        au auVar = new au();
        auVar.dU(rVar.Uk());
        auVar.setType(i3);
        auVar.eS(1);
        auVar.dV(str);
        auVar.eR(1);
        auVar.aq(bb.hU(rVar.Uk()));
        rVar.hXw = (int) bb.i(auVar);
        return o.Ub().a(rVar);
    }

    public static long a(String str, int i, String str2, String str3, int i2) {
        if (bi.oN(str)) {
            x.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", Integer.valueOf(i2));
            return -1;
        } else if (bi.oN(str2)) {
            x.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", Integer.valueOf(i2));
            return -1;
        } else {
            int i3;
            r rVar;
            r rVar2 = new r();
            rVar2.fileName = str;
            rVar2.hXv = 1;
            rVar2.fEx = str2;
            rVar2.hXn = (String) com.tencent.mm.kernel.g.Dq().Db().get(2, (Object) "");
            rVar2.hXs = bi.Wx();
            rVar2.hXt = bi.Wx();
            rVar2.hXB = null;
            rVar2.hVd = str3;
            if (!bi.oN(str3)) {
                rVar2.hXz = 1;
            }
            if (62 == i2) {
                rVar2.hXz = 0;
                i3 = 3;
                rVar = rVar2;
            } else if (rVar2.hXz == 0) {
                i3 = 1;
                rVar = rVar2;
            } else {
                i3 = -1;
                rVar = rVar2;
            }
            rVar.hXC = i3;
            rVar2.hmZ = 0;
            rVar2.status = 106;
            au auVar = new au();
            auVar.dU(rVar2.Uk());
            auVar.setType(i2);
            auVar.eS(1);
            auVar.dV(str);
            auVar.eR(8);
            auVar.aq(bb.hU(rVar2.Uk()));
            long i4 = bb.i(auVar);
            rVar2.hXw = (int) i4;
            if (o.Ub().a(rVar2)) {
                return i4;
            }
            return -1;
        }
    }

    public static void j(String str, int i, int i2) {
        r nJ = nJ(str);
        if (nJ == null) {
            x.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", str, Integer.valueOf(i2));
            return;
        }
        o.Ub();
        x.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", Integer.valueOf(s.nz(s.nx(str))), Integer.valueOf(i2));
        nJ.hmZ = r0;
        nJ.hXv = i;
        aqp aqp = nJ.hXF;
        aqp.wDZ = false;
        nJ.hXF = aqp;
        nJ.status = 102;
        o.Ub();
        nJ.hXr = s.nz(s.ny(str));
        x.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + nJ.hXr);
        nJ.fEo = 4512;
        x.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", Boolean.valueOf(e(nJ)), Integer.valueOf(i2));
        au dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI((long) nJ.hXw);
        x.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(dI.field_msgId), Long.valueOf(dI.field_msgSvrId), dI.field_talker, Integer.valueOf(dI.getType()), Integer.valueOf(dI.field_isSend), dI.field_imgPath, Integer.valueOf(dI.field_status), Long.valueOf(dI.field_createTime));
        dI.dU(nJ.Uk());
        dI.setType(i2);
        dI.eS(1);
        dI.dV(str);
        dI.eR(1);
        x.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(dI.field_msgId), Long.valueOf(dI.field_msgSvrId), dI.field_talker, Integer.valueOf(dI.getType()), Integer.valueOf(dI.field_isSend), dI.field_imgPath, Integer.valueOf(dI.field_status), Long.valueOf(dI.field_createTime));
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().a((long) nJ.hXw, dI);
    }

    public static int nE(String str) {
        r nJ = nJ(str);
        if (nJ == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nJ.status == 102 || nJ.status == 105) {
            int i = nJ.status;
            if (nJ.status == 102 || nJ.hXr != nJ.hXq) {
                nJ.status = 103;
            } else {
                nJ.status = 104;
            }
            x.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.zo() + "startSend file:" + str + " status:[" + i + "->" + nJ.status + "]");
            nJ.hXu = bi.Wx();
            nJ.hXt = bi.Wx();
            nJ.fEo = 3328;
            if (e(nJ)) {
                o.Ug().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + nJ.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static int bv(long j) {
        for (r rVar : o.Ub().bu(j)) {
            int i = rVar.status;
            rVar.status = 200;
            x.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.zo() + "startSend file:" + rVar.getFileName() + " status:[" + i + "->" + rVar.status + "]");
            rVar.hXu = bi.Wx();
            rVar.hXt = bi.Wx();
            rVar.fEo = 3328;
            if (!e(rVar)) {
                x.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.zo() + " update failed: " + rVar.getFileName());
                return 0 - com.tencent.mm.compatible.util.g.getLine();
            }
        }
        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
            public final void run() {
                x.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + m.this.fmm + " sending:" + m.this.fml);
                if (!m.this.fmm) {
                    m.this.fmn = 5;
                    m.this.fmr.gJu = SystemClock.elapsedRealtime();
                    m.this.fml = false;
                }
                m.this.fmm = true;
                m.this.fms.K(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
        return 0;
    }

    public static void c(r rVar) {
        if (rVar == null) {
            x.e("MicroMsg.VideoLogic", "video info is null");
            return;
        }
        au dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI((long) rVar.hXw);
        int type = dI.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            dI.eS(1);
            dI.dU(rVar.Uk());
            dI.ap(rVar.fGj);
            dI.eR(2);
            dI.setContent(p.b(rVar.Ul(), (long) rVar.hXv, false));
            ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().a((long) rVar.hXw, dI);
            x.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", Long.valueOf(dI.field_msgId));
        }
    }

    static boolean d(r rVar) {
        au dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI((long) rVar.hXw);
        int type = dI.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", Integer.valueOf(type));
        if (43 != type && 62 != type) {
            return false;
        }
        dI.ap(rVar.fGj);
        dI.setContent(p.b(rVar.Ul(), (long) rVar.hXv, false));
        dI.dU(rVar.Uk());
        x.d("MicroMsg.VideoLogic", "set msg content :" + dI.field_content);
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().b(rVar.fGj, dI);
        x.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", Long.valueOf(dI.field_msgId));
        if (dI.cjX()) {
            x.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", Integer.valueOf(rVar.hmZ));
        }
        return true;
    }

    public static int nF(String str) {
        r nJ = nJ(str);
        if (nJ == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nJ.status == 111 || nJ.status == 113 || nJ.status == 121 || nJ.status == 122 || nJ.status == 123) {
            nJ.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            nJ.hXu = bi.Wx();
            nJ.hXt = bi.Wx();
            nJ.fEo = 3328;
            if (e(nJ)) {
                o.Ug().Uz();
                o.Ug().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + nJ.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static int nG(String str) {
        r nJ = nJ(str);
        if (nJ == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nJ.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || nJ.status == 120 || nJ.status == 122 || nJ.status == 123) {
            nJ.status = 113;
            nJ.hXt = bi.Wx();
            nJ.fEo = BuildConfig.VERSION_CODE;
            if (e(nJ)) {
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + nJ.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static boolean X(String str, int i) {
        int i2 = 0;
        r nJ = nJ(str);
        if (nJ == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
            return false;
        }
        if (i != nJ.hmZ) {
            x.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", Integer.valueOf(i), Integer.valueOf(nJ.hmZ));
            nJ.hmZ = i;
            i2 = 32;
        }
        nJ.hXp = i;
        nJ.hXt = bi.Wx();
        d(nJ);
        nJ.status = 199;
        nJ.fEo = i2 | 1296;
        boolean e = e(nJ);
        x.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + nJ.hmZ + " status:" + nJ.status + " netTimes:" + nJ.hXx + " update ret: " + e);
        return e;
    }

    public static boolean nH(String str) {
        x.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + str);
        r rVar = new r();
        rVar.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        rVar.hXt = bi.Wx();
        rVar.hXu = bi.Wx();
        rVar.fileName = str;
        rVar.fEo = 3328;
        if (!e(rVar)) {
            return false;
        }
        o.Ug().run();
        return true;
    }

    public static boolean nI(String str) {
        r nJ = nJ(str);
        if (nJ == null) {
            return false;
        }
        x.i("MicroMsg.VideoLogic", "rsetMsgSend %s", str);
        aqp aqp = nJ.hXF;
        if (aqp != null) {
            aqp.wEb = 0;
            nJ.hXF = aqp;
        }
        if (nJ.hXq < nJ.hXr) {
            nJ.status = 103;
        } else {
            nJ.status = 104;
        }
        nJ.hXs = bi.Wx();
        nJ.hXt = bi.Wx();
        nJ.hXu = bi.Wx();
        nJ.fEo = 536874752;
        if (!e(nJ)) {
            return false;
        }
        o.Ug().run();
        return true;
    }

    public static r nJ(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return o.Ub().nv(str);
    }

    public static boolean e(r rVar) {
        if (rVar == null) {
            return false;
        }
        if ((rVar.getFileName() == null || rVar.getFileName().length() <= 0) && rVar.fEo == -1) {
            return false;
        }
        return o.Ub().b(rVar);
    }

    public static String nK(String str) {
        String str2 = e.gJf + bi.Wy() + ".mp4";
        if (k.fv(str, str2)) {
            return str2;
        }
        return null;
    }

    public static int f(r rVar) {
        if (rVar.hmZ == 0) {
            return 0;
        }
        x.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + rVar.hXp + " " + rVar.hmZ);
        return (rVar.hXp * 100) / rVar.hmZ;
    }

    public static int g(r rVar) {
        if (rVar.hmZ == 0) {
            return 0;
        }
        x.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + rVar.hWd + " " + rVar.hmZ);
        return (rVar.hWd * 100) / rVar.hmZ;
    }

    public static boolean nL(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            return false;
        }
        x.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + str);
        r nJ = nJ(str);
        if (nJ == null || nJ.status != 199) {
            return false;
        }
        int i = nJ.hmZ;
        o.Ub();
        int bN = com.tencent.mm.a.e.bN(s.nx(str));
        x.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", Integer.valueOf(bN), Integer.valueOf(i));
        if (bN <= 0 || Math.abs(bN - i) <= 16) {
            return false;
        }
        x.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", Integer.valueOf(bN), Integer.valueOf(i));
        String fileName = nJ.getFileName();
        g.pWK.a(111, 217, 1, false);
        r nJ2 = nJ(fileName);
        if (nJ2 != null) {
            au dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI((long) nJ2.hXw);
            int type = dI.getType();
            x.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", Integer.valueOf(type));
            if (43 == type || 62 == type) {
                dI.setContent(p.b(nJ2.Ul(), (long) nJ2.hXv, false));
                dI.eR(2);
                ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().a((long) nJ2.hXw, dI);
                nJ2.status = 196;
                nJ2.hXt = bi.Wx();
                nJ2.fEo = BuildConfig.VERSION_CODE;
                x.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                e(nJ2);
            }
        }
        return true;
    }

    public static int y(int i, String str) {
        int i2;
        long Wz = bi.Wz();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!o.Ue().b(str, pInt, pInt2) || bi.bz((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        x.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(bi.bB(Wz)));
        return i2;
    }

    public static void d(String str, int i, boolean z) {
        if (bi.oN(str)) {
            x.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", str);
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long Wz = bi.Wz();
        long update;
        if (o.Ue().nP(str)) {
            w Ue = o.Ue();
            int Wy = (int) (bi.Wy() / 1000);
            if (!bi.oN(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(Wy));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) Ue.gLA.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                x.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            w Ue2 = o.Ue();
            int Wy2 = (int) (bi.Wy() / 1000);
            int i3 = z ? 1 : 0;
            if (!bi.oN(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, str);
                contentValues2.put("starttime", Integer.valueOf(Wy2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = Ue2.gLA.insert("VideoPlayHistory", FFmpegMetadataRetriever.METADATA_KEY_FILENAME, contentValues2);
                x.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        x.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(bi.bB(Wz)));
    }

    public static void nM(String str) {
        boolean z = true;
        if (!bi.oN(str)) {
            if (o.Ue().gLA.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
                z = false;
            }
            x.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        }
    }

    public static String d(long j, int i) {
        return j + "_" + i;
    }

    public static int f(long j, String str) {
        if (bi.oN(str)) {
            return -1;
        }
        try {
            String[] split = str.split("_");
            if (split != null && split.length == 2 && bi.getLong(split[0], 0) == j) {
                return bi.getInt(split[1], 0);
            }
            return -1;
        } catch (Exception e) {
            x.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            return -1;
        }
    }

    public static void Y(String str, int i) {
        r nJ = nJ(str);
        if (nJ != null) {
            nJ.status = 122;
            nJ.hXu = bi.Wx();
            nJ.hXt = bi.Wx();
            nJ.hvw = i;
            nJ.fEo = 268438784;
            x.i("MicroMsg.VideoLogic", "set online video Completion ret: " + o.Ub().b(nJ) + " status: " + nJ.status);
        }
    }

    public static int nN(String str) {
        r nJ = nJ(str);
        if (nJ == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nJ.status == 111 || nJ.status == 113 || nJ.status == 121 || nJ.status == 122 || nJ.status == 123) {
            int i = 256;
            com.tencent.mm.modelcontrol.d.Na();
            if (com.tencent.mm.modelcontrol.d.Nf()) {
                nJ.status = 122;
            } else {
                x.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                nJ.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                nJ.hXp = 0;
                i = com.tencent.mm.plugin.appbrand.jsapi.f.e.CTRL_INDEX;
            }
            nJ.hXu = bi.Wx();
            nJ.hXt = bi.Wx();
            nJ.fEo = (i | 2048) | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            if (e(nJ)) {
                o.Ug().Uz();
                o.Ug().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + nJ.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static boolean Z(String str, int i) {
        return b(nJ(str), i);
    }

    public static boolean b(r rVar, int i) {
        if (rVar == null) {
            return false;
        }
        rVar.hvw = i;
        rVar.fEo = SQLiteDatabase.CREATE_IF_NECESSARY;
        return e(rVar);
    }

    public static boolean a(String str, PInt pInt, PInt pInt2) {
        Throwable e;
        Throwable th;
        if (bi.oN(str)) {
            x.w("MicroMsg.VideoLogic", "get media info but path is null");
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = bi.fN((long) bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = bi.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            x.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
        return true;
    }
}
