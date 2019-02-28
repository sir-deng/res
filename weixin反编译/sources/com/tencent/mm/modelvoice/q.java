package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.f.a.iu;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.b;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public final class q {
    private static HashMap<String, WeakReference<h>> hZt = new HashMap();
    public static volatile HashMap<String, Integer> hZu = new HashMap();
    public static volatile HashMap<String, Integer> hZv = new HashMap();
    public static volatile HashMap<String, Integer> hZw = new HashMap();

    public static boolean nW(String str) {
        if (str == null) {
            return false;
        }
        p oj = m.UK().oj(str);
        if (oj == null || oj.hXx >= 250) {
            return false;
        }
        oj.hXx++;
        oj.fEo = 8192;
        return a(oj);
    }

    public static int iN(int i) {
        return ((i - 6) / 32) * 20;
    }

    public static b ay(String str, String str2) {
        u UK = m.UK();
        String fullPath = getFullPath(str2);
        switch (bi.getInt(str, -1)) {
            case 1:
                if (UK.hZG.get(fullPath) == null) {
                    UK.hZG.put(fullPath, new l(fullPath));
                }
                return (b) UK.hZG.get(fullPath);
            case 4:
                if (UK.hZH.get(fullPath) == null) {
                    UK.hZH.put(fullPath, new h(fullPath));
                }
                return (b) UK.hZH.get(fullPath);
            default:
                if (UK.hZF.get(fullPath) == null) {
                    UK.hZF.put(fullPath, new a(fullPath));
                }
                return (b) UK.hZF.get(fullPath);
        }
    }

    public static b nX(String str) {
        u UK = m.UK();
        String fullPath = getFullPath(str);
        switch (o.nU(str)) {
            case 0:
                if (UK.hZF.get(fullPath) == null) {
                    UK.hZF.put(fullPath, new a(fullPath));
                }
                return (b) UK.hZF.get(fullPath);
            case 1:
                if (UK.hZG.get(fullPath) == null) {
                    UK.hZG.put(fullPath, new l(fullPath));
                }
                return (b) UK.hZG.get(fullPath);
            case 2:
                if (UK.hZH.get(fullPath) == null) {
                    UK.hZH.put(fullPath, new h(fullPath));
                }
                return (b) UK.hZH.get(fullPath);
            default:
                if (UK.hZF.get(fullPath) == null) {
                    UK.hZF.put(fullPath, new a(fullPath));
                }
                return (b) UK.hZF.get(fullPath);
        }
    }

    public static void nY(String str) {
        u UK = m.UK();
        String fullPath = getFullPath(str);
        a aVar;
        switch (o.nU(str)) {
            case 0:
                aVar = (a) UK.hZF.get(fullPath);
                if (aVar != null) {
                    aVar.UB();
                    UK.hZF.remove(fullPath);
                    return;
                }
                return;
            case 1:
                l lVar = (l) UK.hZG.get(fullPath);
                if (lVar != null) {
                    lVar.UB();
                    UK.hZG.remove(fullPath);
                    return;
                }
                return;
            case 2:
                h hVar = (h) UK.hZH.get(fullPath);
                if (hVar != null) {
                    hVar.UB();
                    UK.hZH.remove(fullPath);
                    return;
                }
                return;
            default:
                aVar = (a) UK.hZF.get(fullPath);
                if (aVar != null) {
                    aVar.UB();
                    UK.hZF.remove(fullPath);
                    return;
                }
                return;
        }
    }

    public static String getFullPath(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return M(str, false);
    }

    public static String M(String str, boolean z) {
        a aVar = new a();
        String a = i.a(Ft(), "msg_", str, ".amr", 2);
        x.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.zp() + " " + a);
        if (bi.oN(a)) {
            return null;
        }
        if (z || new File(a).exists()) {
            return a;
        }
        String str2 = Fs() + str;
        if (new File(str2 + ".amr").exists()) {
            k.r(str2 + ".amr", a, true);
            return a;
        } else if (!new File(str2).exists()) {
            return a;
        } else {
            k.r(str2, a, true);
            return a;
        }
    }

    public static String nZ(String str) {
        String oi = u.oi(com.tencent.mm.y.q.FY());
        p pVar = new p();
        pVar.fileName = oi;
        pVar.fEx = str;
        pVar.hXs = System.currentTimeMillis() / 1000;
        pVar.clientId = oi;
        pVar.hXt = System.currentTimeMillis() / 1000;
        pVar.status = 1;
        pVar.hXn = com.tencent.mm.y.q.FY();
        pVar.fEo = -1;
        if (!m.UK().b(pVar)) {
            return null;
        }
        x.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
        return oi;
    }

    public static boolean a(String str, h hVar) {
        if (str == null) {
            return false;
        }
        p oj = m.UK().oj(str);
        if (oj == null) {
            x.d("MicroMsg.VoiceLogic", "startSend null record : " + str);
            return false;
        } else if (oj.status != 1) {
            return false;
        } else {
            oj.status = 2;
            oj.fEo = 64;
            hZt.put(str, new WeakReference(hVar));
            return a(oj);
        }
    }

    public static boolean oa(String str) {
        if (str == null) {
            return false;
        }
        x.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        p oj = m.UK().oj(str);
        if (oj == null) {
            return false;
        }
        oj.status = 8;
        oj.hmZ = o.nz(str);
        oj.fEo = 96;
        return a(oj);
    }

    public static boolean ob(String str) {
        if (str == null) {
            return false;
        }
        p oj = m.UK().oj(str);
        if (oj == null) {
            x.d("MicroMsg.VoiceLogic", "cancel null download : " + str);
            return true;
        }
        x.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + oj.fGj);
        if (oj.fGj != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().P(oj.fEx, oj.fGj);
        }
        return od(str);
    }

    public static boolean oc(String str) {
        if (str == null) {
            return false;
        }
        p oj = m.UK().oj(str);
        if (oj == null) {
            x.i("MicroMsg.VoiceLogic", "cancel null record : " + str);
            return true;
        }
        x.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + oj.hXw);
        if (oj.hXw != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dJ((long) oj.hXw);
        }
        return od(str);
    }

    public static boolean od(String str) {
        if (bi.oN(str)) {
            return false;
        }
        m.UK().iI(str);
        nY(str);
        return new File(getFullPath(str)).delete();
    }

    public static boolean aa(String str, int i) {
        return k(str, i, 0);
    }

    private static boolean k(String str, int i, int i2) {
        if (str == null) {
            return false;
        }
        x.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + getFullPath(str) + "]");
        p oj = m.UK().oj(str);
        if (oj == null) {
            return false;
        }
        if (!(oj.status == 97 || oj.status == 98)) {
            oj.status = 3;
        }
        oj.hmZ = o.nz(str);
        if (oj.hmZ <= 0) {
            nC(str);
            return false;
        }
        oj.hXt = System.currentTimeMillis() / 1000;
        oj.hZq = i;
        oj.fEo = 3424;
        au auVar = new au();
        auVar.dU(oj.fEx);
        auVar.setType(34);
        auVar.eS(1);
        auVar.dV(str);
        if (oj.status == 97) {
            auVar.eR(2);
            auVar.setContent(n.b(oj.hXn, (long) oj.hZq, false));
        } else if (oj.status == 98) {
            auVar.eR(5);
            auVar.setContent(n.b(oj.hXn, -1, true));
        } else {
            auVar.eR(1);
            auVar.setContent(n.b(oj.hXn, (long) oj.hZq, false));
        }
        auVar.aq(bb.hU(oj.fEx));
        auVar.DJ(i2);
        com.tencent.mm.i.a.a.xK().b(auVar);
        oj.hXw = (int) bb.i(auVar);
        boolean a = a(oj);
        hZt.remove(str);
        return a;
    }

    public static int a(String str, int i, long j, String str2, int i2, int i3) {
        if (str == null) {
            return -1;
        }
        x.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i + " SvrID:" + j + " clientID:" + str2 + " hasSendEndFlag " + i2);
        p oj = m.UK().oj(str);
        if (oj == null) {
            return -1;
        }
        oj.hWd = i;
        oj.hXt = System.currentTimeMillis() / 1000;
        oj.fEo = 264;
        if (bi.oN(oj.clientId) && str2 != null) {
            oj.clientId = str2;
            oj.fEo |= WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        if (oj.fGj == 0 && j != 0) {
            oj.fGj = j;
            oj.fEo |= 4;
        }
        int i4 = 0;
        if (oj.hmZ <= i && oj.status == 3 && i2 == 1) {
            oj.status = 99;
            oj.fEo |= 64;
            au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) oj.hXw);
            dI.dU(oj.fEx);
            dI.ap(oj.fGj);
            dI.eR(2);
            dI.setContent(n.b(oj.hXn, (long) oj.hZq, false));
            dI.DJ(i3);
            Integer num = (Integer) hZu.get(getFullPath(str));
            if (num != null) {
                oj.hZs = num.intValue();
                oj.fEo |= SQLiteGlobal.journalSizeLimit;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a((long) oj.hXw, dI);
            x.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + oj.hmZ + " status:" + oj.status + " netTimes:" + oj.hXx + " msgId:" + dI.field_msgId);
            i4 = 1;
            nY(str);
        }
        if (a(oj)) {
            return i4;
        }
        return -4;
    }

    public static synchronized int a(int i, byte[] bArr, int i2) {
        int i3 = 0;
        synchronized (q.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    int i4 = 0;
                    i3 = i;
                    while (i4 < i2) {
                        i = i3 + bArr[i4 + 0];
                        i4++;
                        i3 = i;
                    }
                }
            }
        }
        return i3;
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        if (!(bArr == null || bArr.length == 0)) {
            int hashCode;
            if (i == 0) {
                hashCode = bArr.hashCode() & 255;
                i = hashCode;
            } else {
                hashCode = i & 255;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                i += (bArr[i4 + 0] & hashCode) * 256;
            }
        }
        return i;
    }

    public static int c(String str, byte[] bArr, int i) {
        p oj = m.UK().oj(str);
        if (oj == null) {
            return -1;
        }
        oj.hZs = a(oj.hZs, bArr, 0, i);
        oj.fEo |= SQLiteGlobal.journalSizeLimit;
        if (a(oj)) {
            return oj.hZs;
        }
        return 0;
    }

    public static boolean oe(String str) {
        p oj = m.UK().oj(str);
        if (oj == null) {
            return true;
        }
        File file = new File(getFullPath(str));
        b nX = nX(str);
        if (nX != null && (nX instanceof a) && Math.abs(file.length() - ((long) oj.hmZ)) == 6) {
            x.i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", Long.valueOf(file.length()), Integer.valueOf(oj.hmZ));
            return true;
        } else if (file.length() != ((long) oj.hmZ)) {
            x.e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", Long.valueOf(file.length()), Integer.valueOf(oj.hmZ));
            return false;
        } else {
            g bp = nX.bp(0, oj.hmZ);
            if (bp.ret != 0 || oj.hZs == 0 || oj.hZs == a(oj.hZs & 255, bp.buf, 0, bp.flJ)) {
                return true;
            }
            x.e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", Integer.valueOf(oj.hZs));
            return false;
        }
    }

    public static int a(p pVar, byte[] bArr, int i, String str, String str2, d.a aVar) {
        a aVar2 = new a();
        p bx = m.UK().bx(pVar.fGj);
        if (bx != null && bx.status == 99) {
            return 0;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().G(pVar.fEx, pVar.fGj).field_msgSvrId == pVar.fGj && bx == null) {
            return 0;
        }
        if (bx != null) {
            pVar.fileName = bx.fileName;
        } else {
            pVar.fileName = u.oi(pVar.hXn);
        }
        pVar.fEo |= 1;
        x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zo() + "checktime :" + aVar2.zp());
        boolean z = false;
        if (bArr != null && bArr.length > 1) {
            boolean z2;
            if (bx != null) {
                x.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
            }
            String str3 = pVar.hYj;
            String str4 = pVar.fileName;
            int write = ay(str3, str4).write(bArr, bArr.length, 0);
            if (write < 0) {
                x.e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                z2 = false;
            } else if (bArr.length != write) {
                x.e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                z2 = false;
            } else {
                x.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                nY(str4);
                z2 = true;
            }
            pVar.hZs = a(pVar.hZs, bArr, 0, bArr.length);
            pVar.fEo |= SQLiteGlobal.journalSizeLimit;
            z = z2;
        }
        x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zo() + "checktime :" + aVar2.zp());
        pVar.hXt = System.currentTimeMillis() / 1000;
        pVar.fEo |= 256;
        if (z) {
            pVar.status = 99;
        } else if (pVar.hmZ == 0) {
            pVar.status = 5;
        } else {
            pVar.status = 6;
        }
        pVar.fEo |= 64;
        if (bx == null) {
            if (z) {
                pVar.hXw = (int) a(pVar, z, i, str, str2, aVar);
            }
            if (aVar != null) {
                pVar.gkC = bb.c(aVar);
                if (aVar.hoa != null) {
                    pVar.hGx = aVar.hoa.vNU;
                }
            }
            x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zo() + "checktime :" + aVar2.zp());
            pVar.fEo = -1;
            x.d("MicroMsg.VoiceLogic", "Insert fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.hWd + " total:" + pVar.hmZ);
            if (m.UK().b(pVar)) {
                x.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.zo() + "checktime :" + aVar2.zp());
                if (z) {
                    return 1;
                }
            }
            x.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.hWd + " total:" + pVar.hmZ);
            return -2;
        }
        x.d("MicroMsg.VoiceLogic", "Sync Update file:" + pVar.fileName + " stat:" + pVar.status);
        if (!a(pVar)) {
            return -44;
        }
        if (z) {
            a(pVar, aVar);
            return 1;
        }
        if (bx != null && bx.hXp == pVar.hmZ) {
            a(bx.fileName, bx.hXp, aVar);
            x.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + bx.fileName);
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", aVar, Boolean.valueOf(z), bi.chl());
        m.UM().run();
        return 0;
    }

    private static boolean a(p pVar, d.a aVar) {
        try {
            pVar.hXw = (int) a(pVar, true, 3, "", pVar.gkD, aVar);
            pVar.fEo |= 2048;
            return a(pVar);
        } catch (Throwable e) {
            x.e("MicroMsg.VoiceLogic", "exception:%s", bi.i(e));
            return false;
        }
    }

    private static long a(p pVar, boolean z, int i, String str, String str2, d.a aVar) {
        if (((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dK(pVar.fGj)) {
            x.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar.fGj));
            if (bi.oM(pVar.fileName).length() > 0) {
                m.UK().iI(pVar.fileName);
            } else {
                x.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            return -1;
        }
        au auVar = new au();
        auVar.ap(pVar.fGj);
        auVar.dV(pVar.fileName);
        auVar.aq(bb.n(pVar.fEx, pVar.hXs));
        auVar.dU(pVar.fEx);
        auVar.eS(com.tencent.mm.y.q.gt(pVar.hXn) ? 1 : 0);
        auVar.setType(34);
        auVar.dZ(str);
        auVar.DJ(pVar.hYq);
        auVar.eR(i);
        if (aVar == null) {
            int i2 = pVar.gkC;
            if (i2 != 0) {
                x.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i2));
                auVar.fb(i2);
                if (auVar.field_msgId == 0 && auVar.field_isSend == 0 && (i2 & 2) != 0) {
                    auVar.aq(bb.f(auVar.field_talker, pVar.hXs, auVar.field_msgSeq));
                }
            }
            if (pVar.hGx != 0) {
                auVar.as((long) pVar.hGx);
            }
            x.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(pVar.hGx));
        } else {
            bb.a(auVar, aVar);
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!bi.oN(str2)) {
            auVar.ea(str2);
            auVar.eb(bb.hX(str2));
        }
        if (z) {
            auVar.setContent(n.b(pVar.hXn, (long) pVar.hZq, false));
        } else {
            auVar.setContent(n.b(pVar.hXn, 0, false));
        }
        if (!bi.oN(str2)) {
            auVar.ea(str2);
            auVar.eb(bb.hX(str2));
            b hW = bb.hW(str2);
            if (hW != null) {
                auVar.eb(hW.hir);
                auVar.dY(hW.hiq);
                x.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", hW.hiq);
                if (hW.his != null) {
                    com.tencent.mm.sdk.b.b iuVar = new iu();
                    iuVar.fAe.fou = auVar;
                    iuVar.fAe.fAf = hW;
                    com.tencent.mm.sdk.b.a.xmy.m(iuVar);
                }
            }
        }
        x.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq));
        return bb.i(auVar);
    }

    public static int a(String str, int i, d.a aVar) {
        if (str == null) {
            return -1;
        }
        p oj = m.UK().oj(str);
        if (oj == null) {
            return -1;
        }
        oj.hXp = i;
        oj.hXt = System.currentTimeMillis() / 1000;
        oj.fEo = e.CTRL_INDEX;
        int i2 = 0;
        if (oj.hmZ > 0 && i >= oj.hmZ) {
            a(oj, aVar);
            oj.status = 99;
            oj.fEo |= 64;
            x.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + oj.hmZ + " status:" + oj.status + " netTimes:" + oj.hXx);
            i2 = 1;
            nY(str);
        }
        x.d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + oj.hmZ + " status:" + oj.status);
        if (a(oj)) {
            return i2;
        }
        return -3;
    }

    public static boolean nD(String str) {
        p oj = m.UK().oj(str);
        if (oj == null) {
            return false;
        }
        if (oj.status == 3) {
            au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) oj.hXw);
            dI.setContent(n.b(oj.hXn, (long) oj.hZq, false));
            dI.eR(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a((long) oj.hXw, dI);
        }
        oj.status = 97;
        oj.hXt = System.currentTimeMillis() / 1000;
        oj.fEo = 320;
        return a(oj);
    }

    public static boolean iO(int i) {
        au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) i);
        if (dI.field_msgId == 0 || dI.field_imgPath == null) {
            return false;
        }
        if (bi.oN(dI.field_imgPath)) {
            return false;
        }
        p oj = m.UK().oj(dI.field_imgPath);
        if (oj == null || bi.oN(oj.fileName)) {
            return false;
        }
        oj.status = 3;
        oj.hWd = 0;
        oj.hXs = System.currentTimeMillis() / 1000;
        oj.hXt = System.currentTimeMillis() / 1000;
        oj.fEo = 8648;
        boolean a = a(oj);
        x.d("MicroMsg.VoiceLogic", " file:" + oj.fileName + " msgid:" + oj.hXw + "  stat:" + oj.status);
        if (oj.hXw == 0 || bi.oN(oj.fEx)) {
            x.e("MicroMsg.VoiceLogic", " failed msg id:" + oj.hXw + " user:" + oj.fEx);
            return a;
        }
        dI.eR(1);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(dI.field_msgId, dI);
        m.UM().run();
        return true;
    }

    public static String e(String str, String str2, int i) {
        if (bi.oN(str)) {
            return null;
        }
        if (!(bi.oN(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String nZ = nZ(str);
        if (bi.oN(nZ) || !k.r(getFullPath(str2), getFullPath(nZ), false)) {
            return null;
        }
        k(nZ, i, 1);
        return nZ;
    }

    public static boolean nC(String str) {
        com.tencent.mm.plugin.report.service.g.pWK.a(111, 234, 1, false);
        if (str == null) {
            return false;
        }
        p oj = m.UK().oj(str);
        if (oj == null) {
            x.e("MicroMsg.VoiceLogic", "Set error failed file:" + str);
            return false;
        }
        oj.status = 98;
        oj.hXt = System.currentTimeMillis() / 1000;
        oj.fEo = 320;
        boolean a = a(oj);
        x.d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + oj.hXw + " old stat:" + oj.status);
        if (oj.hXw == 0 || bi.oN(oj.fEx)) {
            x.e("MicroMsg.VoiceLogic", "setError failed msg id:" + oj.hXw + " user:" + oj.fEx);
            return a;
        }
        au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) oj.hXw);
        com.tencent.mm.plugin.report.d.pVE.a(111, 33, 1, true);
        dI.ao((long) oj.hXw);
        dI.eR(5);
        dI.dU(oj.fEx);
        dI.setContent(n.b(oj.hXn, -1, true));
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(dI.field_msgId, dI);
        return a;
    }

    public static au of(String str) {
        if (str == null) {
            return null;
        }
        p oj = m.UK().oj(str);
        if (oj != null) {
            return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) oj.hXw);
        }
        return null;
    }

    public static p og(String str) {
        return m.UK().oj(str);
    }

    public static List<p> UP() {
        int i;
        List<p> list;
        u UK = m.UK();
        Cursor a = UK.hiZ.a(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i2 = 0;
        if (a.moveToFirst()) {
            List<p> arrayList = new ArrayList();
            do {
                p pVar = new p();
                pVar.b(a);
                arrayList.add(pVar);
                i2++;
            } while (a.moveToNext());
            List<p> list2 = arrayList;
            i = i2;
            list = list2;
        } else {
            i = 0;
            list = null;
        }
        x.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + i);
        a.close();
        return list;
    }

    private static boolean a(p pVar) {
        if (pVar == null || pVar.fEo == -1) {
            return false;
        }
        return m.UK().a(pVar.fileName, pVar);
    }

    public static float B(au auVar) {
        boolean z = auVar != null && auVar.cjL();
        Assert.assertTrue(z);
        float f = ((float) new n(auVar.field_content).time) / 1000.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static float bw(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static boolean C(au auVar) {
        if (auVar == null || !auVar.cjL()) {
            return false;
        }
        return new n(auVar.field_content).hXo;
    }

    public static boolean D(au auVar) {
        if (auVar == null || !auVar.cjL() || auVar.field_isSend == 1) {
            return false;
        }
        if (new n(auVar.field_content).time != 0) {
            return false;
        }
        return true;
    }

    public static void E(au auVar) {
        if (auVar != null && auVar.cjL()) {
            cg dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(auVar.field_msgId);
            if (dI.field_msgId == auVar.field_msgId) {
                n nVar = new n(dI.field_content);
                if (!nVar.hXo) {
                    nVar.hXo = true;
                    auVar.setContent(nVar.hXn + ":" + nVar.time + ":" + (nVar.hXo ? 1 : 0) + "\n");
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(auVar.field_msgId, auVar);
                }
            }
        }
    }

    public static int oh(String str) {
        if (hZt.get(str) != null) {
            h hVar = (h) ((WeakReference) hZt.get(str)).get();
            if (hVar != null) {
                return (int) hVar.vz();
            }
        }
        return -1;
    }

    public static String Fs() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("voice/").toString();
    }

    public static String Ft() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("voice2/").toString();
    }
}
