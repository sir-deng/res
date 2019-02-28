package com.tencent.mm.y;

import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.c;
import com.tencent.mm.f.a.cc;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.List;
import java.util.Map;

public final class bb {

    /* renamed from: com.tencent.mm.y.bb$1 */
    static class AnonymousClass1 implements Runnable {
        final int hij = 200;
        final int hik = 30;
        final int hil = 5;
        int him = 100;
        final /* synthetic */ List hin;

        public AnonymousClass1(List list) {
            this.hin = list;
        }

        public final void run() {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.hin.size()));
            for (String str : this.hin) {
                long EY = ((h) g.h(h.class)).FQ().EY(str);
                if (EY > 0) {
                    long Wy = bi.Wy();
                    int i = 0;
                    long j = 0;
                    while (true) {
                        long j2;
                        int i2 = i;
                        if (this.him < 200 && this.him > 30) {
                            if (j > 500) {
                                i = this.him - 5;
                            } else {
                                i = this.him + 5;
                            }
                            this.him = i;
                        }
                        long Wy2 = bi.Wy();
                        Cursor e = ((h) g.h(h.class)).aZO().e(str, this.him, EY);
                        j = 0;
                        long j3 = 0;
                        while (true) {
                            j2 = j;
                            if (!e.moveToNext()) {
                                break;
                            }
                            cg auVar = new au();
                            auVar.b(e);
                            if (j3 < auVar.field_createTime) {
                                j3 = auVar.field_createTime;
                            }
                            j = 1 + j2;
                            bb.j(auVar);
                        }
                        e.close();
                        long Wy3 = bi.Wy();
                        if (j3 > 0 && j2 > 0) {
                            ((h) g.h(h.class)).aZO().Q(str, j3);
                        }
                        i = (int) (((long) i2) + j2);
                        j = bi.Wy() - Wy2;
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bi.Wz(str), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(EY - j3), Long.valueOf(EY), Long.valueOf(r20 - Wy3), Long.valueOf(r20 - Wy2), Long.valueOf(bi.Wy() - Wy), Integer.valueOf(this.him));
                        if (j2 <= 0) {
                            break;
                        }
                    }
                    ((h) g.h(h.class)).FQ().E(str, 0);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.y.bb$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ List hin;

        public AnonymousClass5(List list) {
            this.hin = list;
        }

        public final void run() {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.hin.size()));
            for (String str : this.hin) {
                cg Fd = ((h) g.h(h.class)).aZO().Fd(str);
                long j = Fd == null ? Long.MAX_VALUE : Fd.field_createTime;
                if (Fd != null && Fd.field_createTime > 0) {
                    ((h) g.h(h.class)).FQ().E(str, j);
                }
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", str, Fd, Long.valueOf(j));
                Cursor Fm = ((h) g.h(h.class)).aZO().Fm(str);
                if (Fm != null) {
                    if (Fm.moveToFirst()) {
                        while (!Fm.isAfterLast()) {
                            au auVar = new au();
                            auVar.b(Fm);
                            bb.j(auVar);
                            Fm.moveToNext();
                        }
                    }
                    Fm.close();
                    int Fj = ((h) g.h(h.class)).aZO().Fj(str);
                    x.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(Fj));
                    ((h) g.h(h.class)).FQ().E(str, 0);
                }
            }
        }
    }

    public interface a {
        void HG();

        boolean HH();
    }

    public static class b {
        public int hiA;
        public int hiB;
        public int hiC;
        public String hiD;
        public String hip;
        public String hiq;
        public String hir;
        public String his;
        public String hit;
        public String hiu;
        public String hiv;
        public String hiw;
        public String hix;
        public String hiy;
        public int hiz;
        public int scene = 0;
        public String userId;
    }

    public static String T(String str, String str2) {
        if (bi.oN(str)) {
            return null;
        }
        return !bi.oN(str2) ? str2 + ": " + str : str;
    }

    public static int hR(String str) {
        if (str == null) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            return -1;
        } else if (str.length() <= 0) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                return indexOf;
            }
            x.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            return -1;
        }
    }

    public static String hS(String str) {
        int hR = hR(str);
        if (hR == -1) {
            return null;
        }
        return str.substring(0, hR);
    }

    public static String hT(String str) {
        int hR = hR(str);
        return (hR != -1 && hR + 2 < str.length()) ? str.substring(hR + 2) : str;
    }

    public static long i(au auVar) {
        com.tencent.mm.k.a Xv = ((h) g.h(h.class)).Ff().Xv(auVar.field_talker);
        if (Xv == null || ((int) Xv.gKO) == 0) {
            com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x(auVar.field_talker);
            xVar.setType(2);
            com.tencent.mm.sdk.b.b joVar = new jo();
            joVar.fBb.fBc = xVar;
            com.tencent.mm.sdk.b.a.xmy.m(joVar);
            ((h) g.h(h.class)).Ff().S(xVar);
        }
        return ((h) g.h(h.class)).aZO().Q(auVar);
    }

    public static boolean gV(int i) {
        switch (i) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                return true;
            default:
                return false;
        }
    }

    public static long HC() {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before fix, now is :%s", Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("client_server_diff_time_enable", 0);
        int i2 = sharedPreferences.getInt("client_server_diff_time_interval", 0);
        if (i <= 0 || i2 <= 0) {
            return currentTimeMillis;
        }
        g.Dr();
        Object obj = g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, null);
        if (obj == null) {
            return currentTimeMillis;
        }
        long j = bi.getLong(obj.toString(), 0);
        if (Math.abs(j / 1000) > ((long) i2)) {
            return currentTimeMillis - j;
        }
        return currentTimeMillis;
    }

    public static long hU(String str) {
        long HC = HC();
        x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(HC));
        if (str != null) {
            cg Fd = ((h) g.h(h.class)).aZO().Fd(str);
            if (Fd != null) {
                x.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(Fd.field_msgId), Long.valueOf(HC));
                if (Fd.field_createTime + 1 > HC) {
                    return Fd.field_createTime + 1;
                }
            }
        }
        return HC;
    }

    public static long n(String str, long j) {
        long j2;
        if (str != null) {
            cg Fd = ((h) g.h(h.class)).aZO().Fd(str);
            if (Fd != null) {
                j2 = Fd.field_createTime + 1;
                return j2 <= j * 1000 ? j2 : j * 1000;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    public static void j(au auVar) {
        if (auVar != null) {
            int type = auVar.getType();
            switch (type) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    type = 49;
                    break;
            }
            d aU = c.aU(Integer.valueOf(type));
            if (aU != null) {
                aU.h(auVar);
            }
            com.tencent.mm.sdk.b.b ccVar = new cc();
            ccVar.frg.frh = auVar.field_msgId;
            ccVar.frg.talker = auVar.field_talker;
            ccVar.frg.msgType = auVar.getType();
            com.tencent.mm.sdk.b.a.xmy.m(ccVar);
        }
    }

    public static void E(List<Long> list) {
        if (list.size() != 0) {
            for (Long longValue : list) {
                aL(longValue.longValue());
            }
        }
    }

    public static int aL(long j) {
        cg dI = ((h) g.h(h.class)).aZO().dI(j);
        if (dI.field_msgId != j) {
            return 0;
        }
        j(dI);
        return ((h) g.h(h.class)).aZO().dJ(j);
    }

    public static int o(String str, long j) {
        cg G = ((h) g.h(h.class)).aZO().G(str, j);
        if (G.field_msgSvrId != j) {
            return 0;
        }
        j(G);
        return ((h) g.h(h.class)).aZO().P(str, j);
    }

    public static int hV(String str) {
        return ((h) g.h(h.class)).aZO().Fj(str);
    }

    public static int a(final String str, final a aVar) {
        x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", str, bi.chl());
        e.post(new Runnable() {
            final int hij = 200;
            final int hik = 30;
            final int hil = 5;
            int him = 100;

            public final void run() {
                cg Fd = ((h) g.h(h.class)).aZO().Fd(str);
                long j = Fd == null ? Long.MAX_VALUE : Fd.field_createTime;
                if (Fd != null && Fd.field_createTime > 0) {
                    ((h) g.h(h.class)).FQ().E(str, j);
                }
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Fd, Long.valueOf(j));
                long Wy = bi.Wy();
                int i = 0;
                long j2 = 0;
                long j3;
                do {
                    if (this.him < 200 && this.him > 30) {
                        int i2;
                        if (j2 > 500) {
                            i2 = this.him - 5;
                        } else {
                            i2 = this.him + 5;
                        }
                        this.him = i2;
                    }
                    long Wy2 = bi.Wy();
                    Cursor e = ((h) g.h(h.class)).aZO().e(str, this.him, j);
                    j2 = 0;
                    long j4 = 0;
                    while (true) {
                        j3 = j2;
                        if (!e.moveToNext()) {
                            break;
                        }
                        cg auVar = new au();
                        auVar.b(e);
                        if (j4 < auVar.field_createTime) {
                            j4 = auVar.field_createTime;
                        }
                        j2 = 1 + j3;
                        bb.j(auVar);
                    }
                    e.close();
                    long Wy3 = bi.Wy();
                    if (j4 > 0 && j3 > 0) {
                        ((h) g.h(h.class)).aZO().Q(str, j4);
                    }
                    i = (int) (((long) i) + j3);
                    j2 = bi.Wy() - Wy2;
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bi.Wz(str), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j - j4), Long.valueOf(j), Long.valueOf(bi.Wy() - Wy3), Long.valueOf(bi.Wy() - Wy2), Long.valueOf(bi.Wy() - Wy), Integer.valueOf(this.him));
                } while (j3 > 0);
                ((h) g.h(h.class)).FQ().E(str, 0);
            }
        }, "deleteMsgByTalker");
        ah.y(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.HG();
                }
            }
        });
        return 0;
    }

    public static void a(final a aVar) {
        g.Dr();
        g.Dt().F(new Runnable() {
            public final void run() {
                if (aVar == null || !aVar.HH()) {
                    ((h) g.h(h.class)).Fk().cjo();
                    if (aVar == null || !aVar.HH()) {
                        bb.HE();
                        if (aVar == null || !aVar.HH()) {
                            bb.HF();
                            if (aVar == null || !aVar.HH()) {
                                bb.HD();
                                if (aVar == null || !aVar.HH()) {
                                    List Fg = ((h) g.h(h.class)).aZO().Fg("message");
                                    if (Fg != null) {
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 >= Fg.size()) {
                                                break;
                                            }
                                            bb.j((au) Fg.get(i2));
                                            i = i2 + 1;
                                        }
                                    }
                                    ((h) g.h(h.class)).aZO().Fi("message");
                                }
                            }
                        }
                    }
                }
                if (aVar != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            aVar.HG();
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|deleteAllMsg";
            }
        });
    }

    public static void HD() {
        List Fg = ((h) g.h(h.class)).aZO().Fg("bottlemessage");
        if (Fg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Fg.size()) {
                    break;
                }
                j((au) Fg.get(i2));
                i = i2 + 1;
            }
        }
        ((h) g.h(h.class)).aZO().Fi("bottlemessage");
    }

    public static void HE() {
        List Fg = ((h) g.h(h.class)).aZO().Fg("qmessage");
        if (Fg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Fg.size()) {
                    break;
                }
                j((au) Fg.get(i2));
                i = i2 + 1;
            }
        }
        ((h) g.h(h.class)).aZO().Fi("qmessage");
    }

    public static void HF() {
        List Fg = ((h) g.h(h.class)).aZO().Fg("tmessage");
        if (Fg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Fg.size()) {
                    break;
                }
                j((au) Fg.get(i2));
                i = i2 + 1;
            }
        }
        ((h) g.h(h.class)).aZO().Fi("tmessage");
    }

    public static b hW(String str) {
        if (bi.oN(str)) {
            return null;
        }
        try {
            Map y = bj.y(str, "msgsource");
            if (y == null || y.isEmpty()) {
                return null;
            }
            b bVar = new b();
            bVar.hip = (String) y.get(".msgsource.bizmsg.msgcluster");
            bVar.hir = (String) y.get(".msgsource.kf.kf_worker");
            bVar.hiq = bi.oM((String) y.get(".msgsource.bizmsg.bizclientmsgid"));
            bVar.hit = bi.oM((String) y.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.hiu = bi.oM((String) y.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.hiv = bi.oM((String) y.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = bi.oM((String) y.get(".msgsource.enterprise_info.user_id"));
            bVar.hiw = bi.oM((String) y.get(".msgsource.enterprise_info.user_nickname"));
            bVar.hix = bi.oM((String) y.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.his = (String) y.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = bi.getInt((String) y.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.hiy = (String) y.get(".msgsource.NotAutoDownloadRange");
            bVar.hiz = bi.getInt((String) y.get(".msgsource.DownloadLimitKbps"), 0);
            bVar.hiA = bi.getInt((String) y.get(".msgsource.videopreloadlen"), 0);
            bVar.hiB = bi.getInt((String) y.get(".msgsource.PreDownload"), 0);
            bVar.hiC = bi.getInt((String) y.get(".msgsource.PreDownloadNetType"), 0);
            bVar.hiD = (String) y.get(".msgsource.NoPreDownloadRange");
            return bVar;
        } catch (Throwable e) {
            x.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", bi.i(e));
            x.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            return null;
        }
    }

    public static String hX(String str) {
        b hW = hW(str);
        if (hW == null) {
            return null;
        }
        return hW.hir;
    }

    public static void a(au auVar, com.tencent.mm.ad.d.a aVar) {
        if (auVar == null || aVar == null || aVar.hoa == null) {
            x.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", bi.chl());
        } else if (auVar.field_msgSvrId == aVar.hoa.vNT) {
            bx bxVar = aVar.hoa;
            if (auVar.field_isSend == 0 || bxVar.vNU != 0) {
                if (auVar.field_msgSeq == 0 && bxVar.vNU != 0) {
                    auVar.as((long) bxVar.vNU);
                }
                int i = auVar.field_flag;
                if (aVar.hob) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (aVar.hoc) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (aVar.hod) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                auVar.fb(i);
                if (auVar.field_msgId == 0 && aVar.hob) {
                    auVar.aq(f(auVar.field_talker, (long) aVar.hoa.pgR, (long) aVar.hoa.vNU));
                }
            }
        }
    }

    public static int c(com.tencent.mm.ad.d.a aVar) {
        int i = 0;
        if (aVar.hob) {
            i = 2;
        }
        if (aVar.hoc) {
            i |= 1;
        }
        if (aVar.hod) {
            return i | 4;
        }
        return i;
    }

    public static long f(String str, long j, long j2) {
        cg Fd;
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        if (str != null) {
            Fd = ((h) g.h(h.class)).aZO().Fd(str);
            if (Fd != null) {
                j4 = Fd.field_createTime;
            }
            j5 = ((h) g.h(h.class)).aZO().Fx(str);
        }
        if (j5 == j4) {
            return j3 == j4 ? j3 + 1 : j3;
        } else {
            if (j5 >= j4) {
                x.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
                return j3;
            } else if (j3 == j5) {
                return j3 - 1;
            } else {
                if (j3 == j4) {
                    return j3 + 1;
                }
                if (j2 == 0 || j3 > j4) {
                    return j3;
                }
                cg I = ((h) g.h(h.class)).aZO().I(str, j3);
                if (!(I.field_msgSeq == 0 || I.field_msgSeq == j2)) {
                    x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", Long.valueOf(I.field_msgSeq), Long.valueOf(j2), Long.valueOf(I.field_createTime), Long.valueOf(j3));
                    if (j2 < I.field_msgSeq) {
                        Fd = ((h) g.h(h.class)).aZO().M(str, j3 - 1000);
                    } else {
                        Fd = ((h) g.h(h.class)).aZO().L(str, 1000 + j3);
                    }
                    if (Fd.field_msgSeq == 0 || Fd.field_msgSeq == j2) {
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", Long.valueOf(I.field_msgSeq), Long.valueOf(j2), Long.valueOf(I.field_createTime), Long.valueOf(j3));
                    } else {
                        j4 = Fd.field_msgSeq < j2 ? Fd.field_createTime + 1 : Fd.field_createTime - 1;
                        x.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", Long.valueOf(I.field_msgSeq), Long.valueOf(Fd.field_msgSeq), Long.valueOf(j2), Long.valueOf(I.field_createTime), Long.valueOf(Fd.field_createTime), Long.valueOf(j4));
                        return j4;
                    }
                }
                j4 = j3;
                return j4;
            }
        }
    }
}
