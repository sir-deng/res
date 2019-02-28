package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j implements e {
    private static int fmp = 0;
    Queue<String> fmh = new LinkedList();
    Queue<String> fmi = new LinkedList();
    Map<String, a> fmj = new HashMap();
    private boolean fmk = false;
    private boolean fml = false;
    private boolean fmm = false;
    int fmn = 0;
    private long fmo = 0;
    a fmr = new a();
    private al fms = new al(as.Dt().oFY.getLooper(), new al.a() {
        public final boolean uG() {
            x.d("MicroMsg.VoiceRemindService", "onTimerExpired");
            try {
                j.h(j.this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceRemindService", e, "", new Object[0]);
            }
            return false;
        }
    }, false);

    static /* synthetic */ void h(j jVar) {
        jVar.fmo = System.currentTimeMillis();
        if ((!jVar.fmk && jVar.fmi.size() == 0) || (!jVar.fml && jVar.fmh.size() == 0)) {
            Cursor a = d.bEL().gLA.a(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            List list = null;
            int i = 0;
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.b(a);
                    list.add(gVar);
                    i++;
                } while (a.moveToNext());
            }
            a.close();
            x.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:" + i);
            if (list == null) {
                x.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                x.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + list.size());
            }
            if (!(list == null || list.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String fK = bi.fK(currentTimeMillis);
                for (g gVar2 : list) {
                    if (jVar.fmj.containsKey(gVar2.field_filename)) {
                        x.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        x.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + bi.fK(gVar2.field_createtime) + " last:" + bi.fK(gVar2.field_lastmodifytime) + " now:" + bi.fK(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        Object obj = (gVar2.field_status == 5 || gVar2.field_status == 6) ? 1 : null;
                        if (obj != null) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.fK(gVar2.field_lastmodifytime) + " now:" + fK);
                                h.nC(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.fK(gVar2.field_lastmodifytime) + " now:" + fK);
                                h.nC(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                x.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                jVar.fmi.offer(gVar2.field_filename);
                                jVar.fmj.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.UO()) {
                            x.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.fK(gVar2.field_lastmodifytime) + " now:" + fK);
                                h.nC(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bi.fK(gVar2.field_lastmodifytime) + " now:" + fK);
                                h.nC(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                x.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                jVar.fmh.offer(gVar2.field_filename);
                                jVar.fmj.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                x.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + jVar.fmj.size() + " [recv:" + jVar.fmi.size() + ",send:" + jVar.fmh.size() + "]");
                jVar.fmi.size();
                jVar.fmh.size();
            }
        }
        if (jVar.fmk || jVar.fmi.size() != 0 || jVar.fml || jVar.fmh.size() != 0) {
            String str;
            if (!jVar.fmk && jVar.fmi.size() > 0) {
                str = (String) jVar.fmi.poll();
                x.d("MicroMsg.VoiceRemindService", "Start Recv :" + str);
                if (str != null) {
                    jVar.fmj.put(str, new a());
                    jVar.fmk = true;
                    x.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!jVar.fml && jVar.fmh.size() > 0) {
                str = (String) jVar.fmh.poll();
                x.d("MicroMsg.VoiceRemindService", "Start Send :" + str);
                if (str != null) {
                    jVar.fmj.put(str, new a());
                    jVar.fml = true;
                    as.CN().a(new b(str), 0);
                    return;
                }
                return;
            }
            return;
        }
        jVar.vC();
        x.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
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

    public j() {
        as.CN().a(329, (e) this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        as.Dt().F(new Runnable() {
            public final void run() {
                int i;
                String str;
                j.vD();
                String str2;
                if (kVar.getType() == FileUtils.S_IWUSR) {
                    j.this.fmk = false;
                    str2 = ((com.tencent.mm.modelvoice.e) kVar).fileName;
                    i = ((com.tencent.mm.modelvoice.e) kVar).retCode;
                    str = str2;
                } else if (kVar.getType() == 329) {
                    j.this.fml = false;
                    str2 = ((b) kVar).fileName;
                    i = ((b) kVar).retCode;
                    str = str2;
                } else {
                    x.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + kVar.getType());
                    j.vE();
                    return;
                }
                long j = 0;
                if (!(str == null || j.this.fmj.get(str) == null)) {
                    j = ((a) j.this.fmj.get(str)).zp();
                    j.this.fmj.remove(str);
                }
                x.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                if (i == 3 && i != 0) {
                    j.this.fmn = j.this.fmn - 1;
                } else if (i != 0) {
                    j.this.fmn = 0;
                }
                x.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.fmp + " stop:" + j.this.fmn + " running:" + j.this.fmm + " recving:" + j.this.fmk + " sending:" + j.this.fml);
                if (j.this.fmn > 0) {
                    j.h(j.this);
                } else if (!(j.this.fml || j.this.fmk)) {
                    j.this.vC();
                }
                j.vE();
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
        x.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.fmr.zp());
    }

    public final void run() {
        as.Dt().F(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - j.this.fmo;
                x.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.this.fmm + " timeWait:" + currentTimeMillis + " sending:" + j.this.fml + " recving:" + j.this.fmk);
                if (j.this.fmm) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + j.this.fml + " recving:" + j.this.fmk);
                    } else {
                        return;
                    }
                }
                j.this.fmm = true;
                j.this.fml = false;
                j.this.fmn = 3;
                j.this.fmk = false;
                j.this.fmr.gJu = SystemClock.elapsedRealtime();
                j.this.fms.K(10, 10);
            }
        });
    }
}
