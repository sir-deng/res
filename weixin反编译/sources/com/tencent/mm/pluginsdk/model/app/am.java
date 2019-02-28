package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class am {

    public static class a implements e {
        private static int fmp = 0;
        Queue<Long> fmh = new LinkedList();
        Queue<Long> fmi = new LinkedList();
        Map<Long, com.tencent.mm.compatible.util.g.a> fmj = new HashMap();
        private boolean fmk = false;
        private boolean fml = false;
        private boolean fmm = false;
        int fmn = 0;
        private long fmo = 0;
        com.tencent.mm.compatible.util.g.a fmr = new com.tencent.mm.compatible.util.g.a();
        private al fms = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                a.i(a.this);
                return false;
            }

            public final String toString() {
                return super.toString() + "|scenePusher";
            }
        }, false);
        private HashMap<Long, String> vlP = new HashMap();

        static /* synthetic */ void i(a aVar) {
            x.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", Boolean.valueOf(aVar.fmk), Integer.valueOf(aVar.fmi.size()), Boolean.valueOf(aVar.fml), Integer.valueOf(aVar.fmh.size()));
            aVar.fmo = System.currentTimeMillis();
            if ((!aVar.fmk && aVar.fmi.size() == 0) || (!aVar.fml && aVar.fmh.size() == 0)) {
                aVar.bZC();
            }
            if (!aVar.fmk && aVar.fmi.size() == 0 && !aVar.fml && aVar.fmh.size() == 0) {
                aVar.vC();
                x.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
            } else if (!aVar.fml && aVar.fmh.size() > 0) {
                final long a = bi.a((Long) aVar.fmh.poll(), -1);
                x.i("MicroMsg.SceneAppMsg", "summerbig Start Send :" + a);
                if (a != -1) {
                    aVar.fmj.put(Long.valueOf(a), new com.tencent.mm.compatible.util.g.a());
                    aVar.fml = true;
                    final c bVar = new b();
                    au dI;
                    if (an.aqK().b(a, bVar)) {
                        String str;
                        if (bVar.field_type == 8) {
                            as.Hm();
                            cg dI2 = com.tencent.mm.y.c.Fh().dI(bVar.field_msgInfoId);
                            if (dI2.field_msgId == 0) {
                                x.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + bVar.field_msgInfoId);
                                str = null;
                            } else {
                                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dI2.field_content);
                                str = fV != null ? fV.hcO : aj.XW(dI2.field_content).frM;
                            }
                            if (str == null) {
                                x.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                                as.Hm();
                                dI = com.tencent.mm.y.c.Fh().dI(bVar.field_msgInfoId);
                                dI.eR(5);
                                as.Hm();
                                com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
                                aVar.fml = false;
                                return;
                            }
                        }
                        str = null;
                        final String str2 = (String) aVar.vlP.get(Long.valueOf(bVar.field_msgInfoId));
                        if (bVar.field_totalLen > 26214400) {
                            as.Hm();
                            final cg dI3 = com.tencent.mm.y.c.Fh().dI(bVar.field_msgInfoId);
                            as.CN().a(new z(null, bVar.field_fileFullPath, dI3.field_talker, new com.tencent.mm.pluginsdk.model.app.z.a() {
                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    bVar.field_signature = str3;
                                    bVar.field_fakeAeskey = str4;
                                    bVar.field_fakeSignature = str5;
                                    bVar.field_lastModifyTime = bi.Wy();
                                    String str6 = dI3.field_content;
                                    if (s.eX(dI3.field_talker)) {
                                        int hR = bb.hR(dI3.field_content);
                                        if (hR != -1) {
                                            str6 = (dI3.field_content + " ").substring(hR + 2).trim();
                                        }
                                    }
                                    com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(bi.Wn(str6));
                                    if (fV != null) {
                                        fV.filemd5 = str;
                                        fV.hda = str2;
                                        fV.hcM = (int) j;
                                        as.Hm();
                                        au dI = com.tencent.mm.y.c.Fh().dI(bVar.field_msgInfoId);
                                        dI.setContent(com.tencent.mm.x.g.a.a(fV, null, null));
                                        as.Hm();
                                        com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
                                    }
                                    an.aqK().c(bVar, new String[0]);
                                    as.CN().a(new ak(a, null, str2), 0);
                                }
                            }), 0);
                            return;
                        }
                        as.CN().a(new ak(a, str, str2), 0);
                        return;
                    }
                    x.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = " + a);
                    as.Hm();
                    dI = com.tencent.mm.y.c.Fh().dI(bVar.field_msgInfoId);
                    dI.eR(5);
                    as.Hm();
                    com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
                    aVar.fml = false;
                }
            }
        }

        static /* synthetic */ int vD() {
            int i = fmp;
            fmp = i + 1;
            return i;
        }

        static /* synthetic */ int vE() {
            int i = fmp;
            fmp = i - 1;
            return i;
        }

        public a() {
            as.CN().a(220, (e) this);
            as.CN().a(221, (e) this);
            as.CN().a(222, (e) this);
        }

        protected final void finalize() {
            as.CN().b(220, (e) this);
            as.CN().b(221, (e) this);
            as.CN().b(222, (e) this);
            this.vlP.clear();
            super.finalize();
        }

        public final void t(long j, String str) {
            this.vlP.put(Long.valueOf(j), str);
        }

        public static void fu(long j) {
            as.CN().a(new ah(j, null, null), 0);
        }

        public static void u(long j, String str) {
            as.CN().a(new ah(j, str, null), 0);
        }

        public static void d(long j, String str, String str2) {
            as.CN().a(new ah(j, str, str2), 0);
        }

        private boolean bZC() {
            List list;
            try {
                Cursor rawQuery = an.aqK().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
                if (rawQuery == null) {
                    list = null;
                } else {
                    int count = rawQuery.getCount();
                    x.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + count);
                    if (count == 0) {
                        rawQuery.close();
                        list = null;
                    } else {
                        list = new ArrayList();
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            b bVar = new b();
                            bVar.b(rawQuery);
                            list.add(bVar);
                        }
                        rawQuery.close();
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SceneAppMsg", e, "", new Object[0]);
                c aqK = an.aqK();
                aqK.gLA.fD("appattach", " update appattach set status = 198 , lastModifyTime = " + bi.Wx() + " where status = 101");
                aqK.doNotify();
                list = null;
            }
            if (list == null || list.size() == 0) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String fK = bi.fK(currentTimeMillis);
            for (b bVar2 : list) {
                if (this.fmj.containsKey(Long.valueOf(bVar2.xrR))) {
                    x.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + bVar2.xrR);
                } else {
                    x.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + bVar2.field_fileFullPath + " status:" + bVar2.field_status + " create:(" + bi.fK(bVar2.field_createTime) + "," + bi.fK(bVar2.field_createTime / 1000) + ", last:" + bi.fK(bVar2.field_lastModifyTime) + " now:" + bi.fK(currentTimeMillis) + " " + (currentTimeMillis - bVar2.field_lastModifyTime));
                    if (bVar2.field_isUpload) {
                        if (currentTimeMillis - bVar2.field_lastModifyTime <= 600 || bVar2.field_status != 101) {
                            this.fmh.offer(Long.valueOf(bVar2.xrR));
                            this.fmj.put(Long.valueOf(bVar2.xrR), null);
                        } else {
                            x.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + bVar2.field_fileFullPath + " last:" + bi.fK(bVar2.field_lastModifyTime) + " now:" + fK);
                            l.fs(bVar2.xrR);
                        }
                    }
                }
            }
            x.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.fmj.size() + " [recv:" + this.fmi.size() + ",send:" + this.fmh.size() + "]");
            if (this.fmi.size() + this.fmh.size() == 0) {
                return false;
            }
            return true;
        }

        public final void a(final int i, final int i2, String str, final k kVar) {
            x.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            as.Dt().F(new Runnable() {
                public final void run() {
                    int i;
                    long j;
                    long j2 = 0;
                    Object obj = null;
                    a.vD();
                    if (kVar.getType() == 222) {
                        x.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + i + " errCode:" + i2);
                        i = 0;
                        j = -1;
                    } else if (kVar.getType() == 221) {
                        a.this.fmk = false;
                        j = ((ab) kVar).vlp;
                        i = ((ab) kVar).retCode;
                    } else if (kVar.getType() == 220) {
                        long j3;
                        a.this.fml = false;
                        long j4 = ((ak) kVar).vlp;
                        int i2 = ((ak) kVar).retCode;
                        ak akVar = (ak) kVar;
                        String str = akVar.vlm == null ? null : akVar.vlm.field_mediaSvrId;
                        akVar = (ak) kVar;
                        if (akVar.vlm == null) {
                            j3 = 0;
                        } else {
                            j3 = akVar.vlm.field_msgInfoId;
                        }
                        String str2 = (String) a.this.vlP.remove(Long.valueOf(j3));
                        if (!bi.oN(((ak) kVar).hCY)) {
                            obj = 1;
                        }
                        if (obj == null && !bi.oN(str)) {
                            c bVar = new b();
                            an.aqK().b(j4, bVar);
                            if (bVar.xrR == j4) {
                                l.a(bVar.field_msgInfoId, str, null);
                                x.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                                a.u(bVar.field_msgInfoId, str2);
                            }
                        }
                        i = i2;
                        j = j4;
                    } else {
                        x.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + kVar.getType());
                        a.vE();
                        return;
                    }
                    if (!(j == -1 || a.this.fmj.get(Long.valueOf(j)) == null)) {
                        j2 = ((com.tencent.mm.compatible.util.g.a) a.this.fmj.get(Long.valueOf(j))).zp();
                        a.this.fmj.remove(Long.valueOf(j));
                    }
                    x.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " rowid:" + j + " time:" + j2);
                    if (i != 0) {
                        a.this.fmn = a.this.fmn - 1;
                    }
                    x.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.fmp + " stop:" + a.this.fmn + " running:" + a.this.fmm + " recving:" + a.this.fmk + " sending:" + a.this.fml);
                    if (a.this.fmn > 0) {
                        a.i(a.this);
                    } else if (!(a.this.fml || a.this.fmk)) {
                        a.this.vC();
                    }
                    a.vE();
                }

                public final String toString() {
                    return super.toString() + "|onSceneEnd";
                }
            });
        }

        private void vC() {
            this.fmj.clear();
            this.fmh.clear();
            this.fmi.clear();
            this.fml = false;
            this.fmk = false;
            this.fmm = false;
            x.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.fmr.zp());
        }

        public final void run() {
            as.Dt().F(new Runnable() {
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis() - a.this.fmo;
                    x.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + a.this.fmm + " timeWait:" + currentTimeMillis + " sending:" + a.this.fml + " recving:" + a.this.fmk);
                    if (a.this.fmm) {
                        if (currentTimeMillis >= 180000) {
                            x.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + a.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.fml + " recving:" + a.this.fmk);
                        } else {
                            return;
                        }
                    }
                    a.this.fmm = true;
                    a.this.fml = false;
                    a.this.fmn = 4;
                    a.this.fmk = false;
                    a.this.fmr.gJu = SystemClock.elapsedRealtime();
                    a.this.fms.K(10, 10);
                }

                public final String toString() {
                    return super.toString() + "|run";
                }
            });
        }
    }
}
