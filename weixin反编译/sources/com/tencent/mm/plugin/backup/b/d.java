package com.tencent.mm.plugin.backup.b;

import android.util.Pair;
import com.tencent.mm.f.a.bm;
import com.tencent.mm.f.a.pg;
import com.tencent.mm.f.a.z;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static int kpR = 0;
    private static int kpS = 1;
    private static int kpT = 2;
    private static boolean kpU = false;
    private boolean hpb;
    private final int kor;
    public boolean kpL = false;
    private final HashMap<String, String> kpM = as.Hm().FT().ciz();
    private HashSet<String> kpN = new HashSet();
    private final int kpO;
    private com.tencent.mm.plugin.backup.a.b.d kpP;
    private int kpQ = kpR;
    private HashMap<String, Pair<Long, Long>> kpV;
    private a kpW;
    private boolean kpX;
    private int kpY;
    private final com.tencent.mm.plugin.backup.a.d kpb;
    private Object lock = new Object();

    private class a {
        private long beginTime;
        private long kqa;
        boolean kqb;

        private a() {
            this.kqa = -1;
            this.kqb = false;
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void begin() {
            if (com.tencent.mm.plugin.backup.g.d.aqL().aqM().gRU != null) {
                this.kqa = com.tencent.mm.plugin.backup.g.d.aqL().aqM().gRU.dA(Thread.currentThread().getId());
                this.kqb = true;
                this.beginTime = bi.Wy();
            }
        }

        public final void end() {
            if (this.kqb && com.tencent.mm.plugin.backup.g.d.aqL().aqM().gRU != null) {
                com.tencent.mm.plugin.backup.g.d.aqL().aqM().gRU.fT(this.kqa);
                this.kqb = false;
            }
        }

        public final void apq() {
            if (bi.bA(this.beginTime) > 500) {
                end();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
                begin();
                this.beginTime = bi.Wy();
            }
        }
    }

    static /* synthetic */ void a(d dVar, boolean z, int i) {
        if (dVar.kpQ == kpS) {
            dVar.kpQ = kpT;
            apl();
            if (z) {
                if (dVar.kor == 1) {
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
                } else if (dVar.kor == 2) {
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(false));
                }
                as.Hm().FS().ciy();
                as.Hm().FT().ciy();
            }
            if (i != 0) {
                dVar.kpb.aoS().kov = i;
                dVar.mT(i);
            }
            dVar.kpQ = kpR;
            dVar.apk();
            dVar.kpb.aoU();
        } else if (dVar.kpQ == kpR) {
            dVar.kpQ = kpT;
            if (z) {
                if (dVar.kor == 1) {
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
                } else if (dVar.kor == 2) {
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(false));
                }
                as.Hm().FS().ciy();
                as.Hm().FT().ciy();
            }
            x.i("MicroMsg.BackupRecoverMerger", "cancel and restart sync");
            if (i != 0) {
                dVar.kpb.aoS().kov = i;
                dVar.mT(i);
            }
            dVar.kpQ = kpR;
            dVar.apk();
            dVar.kpb.aoU();
        }
    }

    private a api() {
        if (this.kpW == null) {
            this.kpW = new a();
        }
        return this.kpW;
    }

    public d(com.tencent.mm.plugin.backup.a.d dVar, int i, com.tencent.mm.plugin.backup.a.b.d dVar2, int i2, boolean z, LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        x.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalSession[%d], isQuickBackup[%b]", Integer.valueOf(this.kpM.size()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        this.kpb = dVar;
        this.kor = i;
        this.kpP = dVar2;
        this.kpO = i2;
        kpU = z;
        this.kpV = a((LinkedList) linkedList, (LinkedList) linkedList2);
        this.kpN.clear();
    }

    private static HashMap<String, Pair<Long, Long>> a(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        HashMap<String, Pair<Long, Long>> hashMap = new HashMap();
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (longValue == 0) {
                    longValue = Long.MIN_VALUE;
                }
                if (!it.hasNext()) {
                    break;
                }
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                hashMap.put(str, new Pair(Long.valueOf(longValue), Long.valueOf(longValue2)));
            }
        }
        return hashMap;
    }

    public final synchronized void apj() {
        if (this.kpL) {
            x.e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
        } else {
            this.kpL = true;
            x.i("MicroMsg.BackupRecoverMerger", "startMerge");
            this.kpb.aoT();
            com.tencent.mm.plugin.backup.g.d.aqL().aqO();
            x.i("MicroMsg.BackupRecoverMerger", "backupStartMerge");
            b.lG(true);
            apm();
            this.kpQ = kpS;
            if (this.kor == 1) {
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(true));
            } else if (this.kor == 2) {
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(true));
            }
            x.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, mergeState[%d], totalSession size[%d], msgListDataIdHashMap size[%d]", Integer.valueOf(this.kpQ), Integer.valueOf(this.kpO), Integer.valueOf(this.kpM.size()));
            e.d(new Runnable() {
                public final void run() {
                    e.reset();
                    e.aps();
                    d.this.api().begin();
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    for (String str : d.this.kpM.keySet()) {
                        d.apm();
                        String str2 = g.vR(str) + str;
                        if (b.cfx()) {
                            d.this.a(str2, hashMap, hashMap2);
                            if (d.this.hpb) {
                                x.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferSessions size[%d], recovering session num[%d]", str, Integer.valueOf(d.this.kpN.size()), Integer.valueOf(d.this.kpO));
                                d.apn();
                                d.this.api().end();
                                com.tencent.mm.plugin.backup.g.c.k(hashMap);
                                d.a(d.this, d.this.kpX, d.this.kpY);
                                return;
                            }
                        }
                        try {
                            d.this.a(str2, hashMap, hashMap2);
                            if (d.this.hpb) {
                                x.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferSessions size[%d], recovering session num[%d]", str, Integer.valueOf(d.this.kpN.size()), Integer.valueOf(d.this.kpO));
                                d.apn();
                                d.this.api().end();
                                com.tencent.mm.plugin.backup.g.c.k(hashMap);
                                d.a(d.this, d.this.kpX, d.this.kpY);
                                return;
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.BackupRecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
                        }
                        d.this.kpN.add(d.this.kpM.get(str));
                        d.this.kpb.aoS().F(26, d.this.kpN.size() > d.this.kpO ? d.this.kpO : d.this.kpN.size(), d.this.kpO);
                        d.this.mT(26);
                        d.this.api().apq();
                        d.apn();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e2) {
                        }
                        x.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferSessions size[%d]", str, Integer.valueOf(d.this.kpN.size()));
                    }
                    com.tencent.mm.plugin.backup.g.c.k(hashMap);
                    x.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferSession:%s totalSession:%d", Integer.valueOf(d.this.kpN.size()), Integer.valueOf(d.this.kpO));
                    d.this.api().end();
                    if (b.cfx()) {
                        d.this.kpb.aoS().kow = d.this.kpN.size() > d.this.kpO ? d.this.kpO : d.this.kpN.size();
                    } else {
                        d.this.kpb.aoS().kow = d.this.kpO;
                    }
                    d.this.kpb.aoS().kox = d.this.kpO;
                    x.cfX();
                    if (d.this.kpQ != d.kpT) {
                        d.this.kpQ = d.kpT;
                        d.apl();
                        x.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
                        if (d.this.kor == 1) {
                            as.Hm();
                            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
                        } else if (d.this.kor == 2) {
                            as.Hm();
                            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(false));
                        }
                        if (d.this.kpP != null) {
                            d.this.kpP.aoR();
                        }
                        as.Hm().FS().ciy();
                        as.Hm().FT().ciy();
                        d.this.kpb.aoS().F(27, d.this.kpN.size() > d.this.kpO ? d.this.kpO : d.this.kpN.size(), d.this.kpO);
                        d.this.mT(27);
                        d.this.kpQ = d.kpR;
                        d.this.apk();
                        d.this.kpb.aoU();
                    }
                }
            }, "BackupRecoverMerger_recoverFromSdcard", 1).start();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.lang.String r23, java.util.HashMap<java.lang.String, java.lang.Integer> r24, java.util.HashMap<java.lang.String, java.util.LinkedList<java.lang.Long>> r25) {
        /*
        r22 = this;
        r16 = com.tencent.mm.sdk.platformtools.bi.Wy();
        r4 = 0;
        r5 = -1;
        r0 = r23;
        r6 = com.tencent.mm.a.e.e(r0, r4, r5);
        r4 = new com.tencent.mm.protocal.c.ew;	 Catch:{ Exception -> 0x0041 }
        r4.<init>();	 Catch:{ Exception -> 0x0041 }
        r4 = r4.aH(r6);	 Catch:{ Exception -> 0x0041 }
        r4 = (com.tencent.mm.protocal.c.ew) r4;	 Catch:{ Exception -> 0x0041 }
        r5 = r4.kyB;
        r15 = r5.iterator();
    L_0x001d:
        r5 = r15.hasNext();
        if (r5 == 0) goto L_0x0340;
    L_0x0023:
        r5 = r15.next();
        r8 = r5;
        r8 = (com.tencent.mm.protocal.c.ev) r8;
        r0 = r22;
        r5 = r0.lock;
        monitor-enter(r5);
        r0 = r22;
        r6 = r0.hpb;	 Catch:{ all -> 0x0131 }
        if (r6 == 0) goto L_0x00c5;
    L_0x0035:
        r4 = "MicroMsg.BackupRecoverMerger";
        r6 = "backupImp canceled";
        com.tencent.mm.sdk.platformtools.x.i(r4, r6);	 Catch:{ all -> 0x0131 }
        r4 = -1;
        monitor-exit(r5);	 Catch:{ all -> 0x0131 }
    L_0x0040:
        return r4;
    L_0x0041:
        r4 = move-exception;
        r5 = r4;
        r4 = "";
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0362 }
        r0 = r23;
        r7.<init>(r0);	 Catch:{ Exception -> 0x0362 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0362 }
        r8.<init>();	 Catch:{ Exception -> 0x0362 }
        r8 = r8.append(r4);	 Catch:{ Exception -> 0x0362 }
        r9 = r7.exists();	 Catch:{ Exception -> 0x0362 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0362 }
        r9 = ",";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0362 }
        r4 = r8.toString();	 Catch:{ Exception -> 0x0362 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0362 }
        r8.<init>();	 Catch:{ Exception -> 0x0362 }
        r8 = r8.append(r4);	 Catch:{ Exception -> 0x0362 }
        r9 = r7.canRead();	 Catch:{ Exception -> 0x0362 }
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0362 }
        r9 = ",";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0362 }
        r4 = r8.toString();	 Catch:{ Exception -> 0x0362 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0362 }
        r8.<init>();	 Catch:{ Exception -> 0x0362 }
        r8 = r8.append(r4);	 Catch:{ Exception -> 0x0362 }
        r10 = r7.length();	 Catch:{ Exception -> 0x0362 }
        r7 = r8.append(r10);	 Catch:{ Exception -> 0x0362 }
        r8 = ".";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0362 }
        r4 = r7.toString();	 Catch:{ Exception -> 0x0362 }
    L_0x00a1:
        r7 = "MicroMsg.BackupRecoverMerger";
        r8 = "read mmPath errr %s [%s] buflen:%d %s,";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r9[r10] = r23;
        r10 = 1;
        r9[r10] = r4;
        r10 = 2;
        if (r6 != 0) goto L_0x00c3;
    L_0x00b3:
        r4 = -1;
    L_0x00b4:
        r4 = java.lang.Integer.valueOf(r4);
        r9[r10] = r4;
        r4 = 3;
        r9[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r7, r5, r8, r9);
        r4 = 0;
        goto L_0x0040;
    L_0x00c3:
        r4 = r6.length;
        goto L_0x00b4;
    L_0x00c5:
        monitor-exit(r5);	 Catch:{ all -> 0x0131 }
        r5 = kpU;
        if (r5 == 0) goto L_0x00cf;
    L_0x00ca:
        r5 = r8.kzz;
        r6 = 1;
        if (r5 != r6) goto L_0x001d;
    L_0x00cf:
        r0 = r22;
        r7 = r0.kpV;	 Catch:{ Exception -> 0x0161 }
        r5 = com.tencent.mm.plugin.backup.g.d.aqL();	 Catch:{ Exception -> 0x0161 }
        r5 = r5.aqM();	 Catch:{ Exception -> 0x0161 }
        r5 = r5.Db();	 Catch:{ Exception -> 0x0161 }
        r6 = 2;
        r9 = 0;
        r5 = r5.get(r6, r9);	 Catch:{ Exception -> 0x0161 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0161 }
        r6 = com.tencent.mm.plugin.backup.g.d.aqL();	 Catch:{ Exception -> 0x0161 }
        r6 = r6.aqM();	 Catch:{ Exception -> 0x0161 }
        r18 = r6.Fh();	 Catch:{ Exception -> 0x0161 }
        r6 = r8.vNM;	 Catch:{ Exception -> 0x0161 }
        r12 = r6.wRo;	 Catch:{ Exception -> 0x0161 }
        r6 = r8.vNN;	 Catch:{ Exception -> 0x0161 }
        r9 = r6.wRo;	 Catch:{ Exception -> 0x0161 }
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r12);	 Catch:{ Exception -> 0x0161 }
        if (r6 != 0) goto L_0x0107;
    L_0x0101:
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r9);	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x0134;
    L_0x0107:
        r5 = "MicroMsg.BackupMsgLogic";
        r6 = "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0161 }
        r10 = 0;
        if (r12 != 0) goto L_0x0116;
    L_0x0113:
        r12 = "null";
    L_0x0116:
        r7[r10] = r12;	 Catch:{ Exception -> 0x0161 }
        r10 = 1;
        if (r9 != 0) goto L_0x011e;
    L_0x011b:
        r9 = "null";
    L_0x011e:
        r7[r10] = r9;	 Catch:{ Exception -> 0x0161 }
        com.tencent.mm.sdk.platformtools.x.w(r5, r6, r7);	 Catch:{ Exception -> 0x0161 }
    L_0x0123:
        r5 = r8.kzz;
        com.tencent.mm.plugin.backup.b.e.mU(r5);
        r5 = r22.api();
        r5.apq();
        goto L_0x001d;
    L_0x0131:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0131 }
        throw r4;
    L_0x0134:
        r6 = "MicroMsg.BackupMsgLogic";
        r10 = "recoverMsg, type[%d], from[%s], to[%s]";
        r11 = 3;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x0161 }
        r13 = 0;
        r14 = r8.kzz;	 Catch:{ Exception -> 0x0161 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0161 }
        r11[r13] = r14;	 Catch:{ Exception -> 0x0161 }
        r13 = 1;
        r11[r13] = r12;	 Catch:{ Exception -> 0x0161 }
        r13 = 2;
        r11[r13] = r9;	 Catch:{ Exception -> 0x0161 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r10, r11);	 Catch:{ Exception -> 0x0161 }
        r6 = com.tencent.mm.plugin.backup.g.d.aqL();	 Catch:{ Exception -> 0x0161 }
        r6 = r6.aqM();	 Catch:{ Exception -> 0x0161 }
        r10 = r6.uin;	 Catch:{ Exception -> 0x0161 }
        if (r10 != 0) goto L_0x016f;
    L_0x015b:
        r5 = new com.tencent.mm.y.b;	 Catch:{ Exception -> 0x0161 }
        r5.<init>();	 Catch:{ Exception -> 0x0161 }
        throw r5;	 Catch:{ Exception -> 0x0161 }
    L_0x0161:
        r5 = move-exception;
        r6 = "MicroMsg.BackupRecoverMerger";
        r7 = "readFromSdcard recoverMsg err";
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r7, r9);
        goto L_0x0123;
    L_0x016f:
        r6 = r6.kvC;	 Catch:{ Exception -> 0x0161 }
        r10 = com.tencent.mm.plugin.backup.g.d.aqL();	 Catch:{ Exception -> 0x0161 }
        r10 = r10.aqM();	 Catch:{ Exception -> 0x0161 }
        r19 = r10.Ff();	 Catch:{ Exception -> 0x0161 }
        r6 = r6.has(r12);	 Catch:{ Exception -> 0x0161 }
        if (r6 != 0) goto L_0x0189;
    L_0x0183:
        r6 = r5.equals(r12);	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x01ed;
    L_0x0189:
        r6 = 1;
        r14 = r6;
    L_0x018b:
        if (r14 == 0) goto L_0x01f0;
    L_0x018d:
        r13 = r9;
    L_0x018e:
        r10 = r8.vRa;	 Catch:{ Exception -> 0x0161 }
        r20 = 0;
        r6 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1));
        if (r6 == 0) goto L_0x01f2;
    L_0x0196:
        r10 = r8.vRa;	 Catch:{ Exception -> 0x0161 }
    L_0x0198:
        if (r7 == 0) goto L_0x01ba;
    L_0x019a:
        r6 = r7.get(r13);	 Catch:{ Exception -> 0x0161 }
        r6 = (android.util.Pair) r6;	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x01ba;
    L_0x01a2:
        r7 = r6.first;	 Catch:{ Exception -> 0x0161 }
        r7 = (java.lang.Long) r7;	 Catch:{ Exception -> 0x0161 }
        r20 = r7.longValue();	 Catch:{ Exception -> 0x0161 }
        r7 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1));
        if (r7 < 0) goto L_0x0123;
    L_0x01ae:
        r6 = r6.second;	 Catch:{ Exception -> 0x0161 }
        r6 = (java.lang.Long) r6;	 Catch:{ Exception -> 0x0161 }
        r6 = r6.longValue();	 Catch:{ Exception -> 0x0161 }
        r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x0123;
    L_0x01ba:
        r6 = com.tencent.mm.plugin.backup.a.g.ape();	 Catch:{ Exception -> 0x0161 }
        r7 = r6.contains(r12);	 Catch:{ Exception -> 0x0161 }
        if (r7 != 0) goto L_0x01ca;
    L_0x01c4:
        r6 = r6.contains(r9);	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x01fa;
    L_0x01ca:
        r5 = "MicroMsg.BackupMsgLogic";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0161 }
        r7 = "recoverMsg hit the blockList: ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0161 }
        r6 = r6.append(r12);	 Catch:{ Exception -> 0x0161 }
        r7 = " ";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0161 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0161 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0161 }
        com.tencent.mm.sdk.platformtools.x.w(r5, r6);	 Catch:{ Exception -> 0x0161 }
        goto L_0x0123;
    L_0x01ed:
        r6 = 0;
        r14 = r6;
        goto L_0x018b;
    L_0x01f0:
        r13 = r12;
        goto L_0x018e;
    L_0x01f2:
        r6 = r8.vQS;	 Catch:{ Exception -> 0x0161 }
        r10 = (long) r6;	 Catch:{ Exception -> 0x0161 }
        r20 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 * r20;
        goto L_0x0198;
    L_0x01fa:
        r6 = r8.vNT;	 Catch:{ Exception -> 0x0161 }
        r20 = 0;
        r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1));
        if (r6 != 0) goto L_0x020b;
    L_0x0202:
        r6 = r8.vNL;	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x020b;
    L_0x0206:
        r6 = r8.vNL;	 Catch:{ Exception -> 0x0161 }
        r6 = (long) r6;	 Catch:{ Exception -> 0x0161 }
        r8.vNT = r6;	 Catch:{ Exception -> 0x0161 }
    L_0x020b:
        r6 = r8.vNT;	 Catch:{ Exception -> 0x0161 }
        r20 = 0;
        r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1));
        if (r6 == 0) goto L_0x023b;
    L_0x0213:
        r6 = r5.equals(r12);	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x0239;
    L_0x0219:
        r6 = r9;
    L_0x021a:
        r0 = r8.vNT;	 Catch:{ Exception -> 0x0161 }
        r20 = r0;
        r0 = r18;
        r1 = r20;
        r9 = r0.G(r6, r1);	 Catch:{ Exception -> 0x0161 }
        r6 = r9.field_msgId;	 Catch:{ Exception -> 0x0161 }
        r20 = 0;
        r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1));
        if (r6 == 0) goto L_0x0246;
    L_0x022e:
        r5 = "MicroMsg.BackupMsgLogic";
        r6 = "recoverMsg msg exist";
        com.tencent.mm.sdk.platformtools.x.i(r5, r6);	 Catch:{ Exception -> 0x0161 }
        goto L_0x0123;
    L_0x0239:
        r6 = r12;
        goto L_0x021a;
    L_0x023b:
        r5 = "MicroMsg.BackupMsgLogic";
        r6 = "recoverMsg drop the item server id < 0";
        com.tencent.mm.sdk.platformtools.x.w(r5, r6);	 Catch:{ Exception -> 0x0161 }
        goto L_0x0123;
    L_0x0246:
        r6 = r8.vNT;	 Catch:{ Exception -> 0x0161 }
        r20 = 0;
        r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1));
        if (r6 == 0) goto L_0x0253;
    L_0x024e:
        r6 = r8.vNT;	 Catch:{ Exception -> 0x0161 }
        r9.ap(r6);	 Catch:{ Exception -> 0x0161 }
    L_0x0253:
        r6 = r8.vQZ;	 Catch:{ Exception -> 0x0161 }
        r6 = (long) r6;	 Catch:{ Exception -> 0x0161 }
        r9.as(r6);	 Catch:{ Exception -> 0x0161 }
        r0 = r25;
        r6 = r0.get(r13);	 Catch:{ Exception -> 0x0161 }
        r6 = (java.util.LinkedList) r6;	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x02cc;
    L_0x0263:
        r7 = r6.size();	 Catch:{ Exception -> 0x0161 }
        if (r7 <= 0) goto L_0x02cc;
    L_0x0269:
        r7 = r6.getFirst();	 Catch:{ Exception -> 0x0161 }
        r7 = (java.lang.Long) r7;	 Catch:{ Exception -> 0x0161 }
        r20 = r7.longValue();	 Catch:{ Exception -> 0x0161 }
        r7 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1));
        if (r7 == 0) goto L_0x02bd;
    L_0x0277:
        r6.clear();	 Catch:{ Exception -> 0x0161 }
    L_0x027a:
        r7 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0161 }
        r6.add(r7);	 Catch:{ Exception -> 0x0161 }
        r6 = r10;
    L_0x0282:
        r9.aq(r6);	 Catch:{ Exception -> 0x0161 }
        r6 = r8.vRb;	 Catch:{ Exception -> 0x0161 }
        r9.fb(r6);	 Catch:{ Exception -> 0x0161 }
        r6 = r8.kzz;	 Catch:{ Exception -> 0x0161 }
        r9.setType(r6);	 Catch:{ Exception -> 0x0161 }
        r0 = r19;
        r6 = r0.Xv(r13);	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x02df;
    L_0x0297:
        r7 = r6.field_username;	 Catch:{ Exception -> 0x0161 }
        r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);	 Catch:{ Exception -> 0x0161 }
        if (r7 != 0) goto L_0x02df;
    L_0x029f:
        r6 = r6.ciN();	 Catch:{ Exception -> 0x0161 }
        if (r6 == 0) goto L_0x02df;
    L_0x02a5:
        r5 = "MicroMsg.BackupMsgLogic";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0161 }
        r7 = "recoverMsg hit the blockList: ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0161 }
        r6 = r6.append(r13);	 Catch:{ Exception -> 0x0161 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0161 }
        com.tencent.mm.sdk.platformtools.x.w(r5, r6);	 Catch:{ Exception -> 0x0161 }
        goto L_0x0123;
    L_0x02bd:
        r7 = r6.getLast();	 Catch:{ Exception -> 0x0161 }
        r7 = (java.lang.Long) r7;	 Catch:{ Exception -> 0x0161 }
        r10 = r7.longValue();	 Catch:{ Exception -> 0x0161 }
        r20 = 1;
        r10 = r10 + r20;
        goto L_0x027a;
    L_0x02cc:
        r6 = new java.util.LinkedList;	 Catch:{ Exception -> 0x0161 }
        r6.<init>();	 Catch:{ Exception -> 0x0161 }
        r7 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0161 }
        r6.add(r7);	 Catch:{ Exception -> 0x0161 }
        r0 = r25;
        r0.put(r13, r6);	 Catch:{ Exception -> 0x0161 }
        r6 = r10;
        goto L_0x0282;
    L_0x02df:
        if (r14 == 0) goto L_0x0337;
    L_0x02e1:
        r6 = 1;
    L_0x02e2:
        r9.eS(r6);	 Catch:{ Exception -> 0x0161 }
        r9.dU(r13);	 Catch:{ Exception -> 0x0161 }
        if (r14 == 0) goto L_0x0339;
    L_0x02ea:
        r6 = r8.vQR;	 Catch:{ Exception -> 0x0161 }
    L_0x02ec:
        r9.eR(r6);	 Catch:{ Exception -> 0x0161 }
        r0 = r24;
        r6 = r0.get(r13);	 Catch:{ Exception -> 0x0161 }
        if (r6 != 0) goto L_0x0301;
    L_0x02f7:
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0161 }
        r0 = r24;
        r0.put(r13, r6);	 Catch:{ Exception -> 0x0161 }
    L_0x0301:
        if (r14 != 0) goto L_0x0320;
    L_0x0303:
        r6 = r8.vQR;	 Catch:{ Exception -> 0x0161 }
        r7 = 3;
        if (r6 != r7) goto L_0x0320;
    L_0x0308:
        r0 = r24;
        r6 = r0.get(r13);	 Catch:{ Exception -> 0x0161 }
        r6 = (java.lang.Integer) r6;	 Catch:{ Exception -> 0x0161 }
        r7 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.a(r6, r7);	 Catch:{ Exception -> 0x0161 }
        r6 = r6 + 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0161 }
        r0 = r24;
        r0.put(r13, r6);	 Catch:{ Exception -> 0x0161 }
    L_0x0320:
        r6 = com.tencent.mm.plugin.backup.e.c.apX();	 Catch:{ Exception -> 0x0161 }
        r7 = r8.kzz;	 Catch:{ Exception -> 0x0161 }
        r6 = r6.mZ(r7);	 Catch:{ Exception -> 0x0161 }
        if (r6 != 0) goto L_0x033b;
    L_0x032c:
        r5 = "MicroMsg.BackupMsgLogic";
        r6 = "recoverMsg unknown type";
        com.tencent.mm.sdk.platformtools.x.i(r5, r6);	 Catch:{ Exception -> 0x0161 }
        goto L_0x0123;
    L_0x0337:
        r6 = 0;
        goto L_0x02e2;
    L_0x0339:
        r6 = 4;
        goto L_0x02ec;
    L_0x033b:
        r6.a(r5, r8, r9);	 Catch:{ Exception -> 0x0161 }
        goto L_0x0123;
    L_0x0340:
        com.tencent.mm.plugin.backup.b.e.apr();
        r5 = "MicroMsg.BackupRecoverMerger";
        r6 = "readFromSdcard merge item time[%d]";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r10 = com.tencent.mm.sdk.platformtools.bi.bA(r16);
        r9 = java.lang.Long.valueOf(r10);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r4 = r4.kyB;
        r4 = r4.size();
        goto L_0x0040;
    L_0x0362:
        r7 = move-exception;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.b.d.a(java.lang.String, java.util.HashMap, java.util.HashMap):int");
    }

    public final void h(boolean z, int i) {
        synchronized (this.lock) {
            x.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", Boolean.valueOf(z), Integer.valueOf(this.kpQ), Integer.valueOf(i));
            this.hpb = true;
        }
        this.kpX = z;
        this.kpY = i;
    }

    private void apk() {
        this.kpL = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void mT(int i) {
        if (this.kpP != null) {
            this.kpP.mR(i);
        }
    }

    public static void apl() {
        x.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
        com.tencent.mm.sdk.b.a.xmy.m(new bm());
        com.tencent.mm.sdk.b.a.xmy.m(new z());
        com.tencent.mm.a.e.g(new File(g.apc()));
        com.tencent.mm.plugin.backup.g.a aqN = com.tencent.mm.plugin.backup.g.d.aqL().aqN();
        aqN.handler.post(new Runnable() {
            public final void run() {
                Iterator it = a.this.kvt.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                        String str = (String) aVar.obj;
                        x.d("MicroMsg.BackupRecoverDelayData", "getContact:" + str);
                        com.tencent.mm.y.ak.a.hhv.Q(str, "");
                    } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                        an.biS().Si((String) aVar.obj);
                    }
                }
                a.this.kvt.clear();
            }
        });
        as.Hm();
        c.Fh().aZT();
        com.tencent.mm.sdk.b.a.xmy.m(new pg());
        b.lG(false);
    }

    public static void apm() {
        com.tencent.mm.plugin.backup.g.d.aqL().aqM().Fh().EZ("BACKUP_MERGE_LOCK");
    }

    public static void apn() {
        com.tencent.mm.plugin.backup.g.d.aqL().aqM().Fh().Fa("BACKUP_MERGE_LOCK");
    }
}
