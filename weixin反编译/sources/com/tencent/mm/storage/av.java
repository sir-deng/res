package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class av extends j implements c {
    public static final String[] gLy;
    private final h hiZ;
    private ar kvx;
    private as kvz;
    private final long xGW = 86400;
    private boolean xIb = false;
    private final List<e> xIc = new CopyOnWriteArrayList();
    private List<b> xId;
    private final f<Integer, au.c> xIe = new f(100);
    private final f<Integer, d> xIf = new f(100);
    private final f<Integer, a> xIg = new f(100);
    private final f<Integer, au.b> xIh = new f(100);
    private final f<Integer, Object> xIi = new f(100);
    private final f<String, Long> xIj = new f(100);
    private ah xIk = new ah();
    private final k<c.a, c.c> xIl = new k<c.a, c.c>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((c.a) obj).a(av.this, (c.c) obj2);
        }

        public final void cD(List<c.c> list) {
            if (!isLocked() && av.this.kvz != null) {
                for (c.c cVar : list) {
                    if (cVar != null) {
                        av.this.kvz.b(av.this, cVar);
                    }
                }
            }
        }
    };
    private Map<String, c.c> xIm = new HashMap();
    private boolean xIn = false;
    private String xIo = "";
    private long xIp = 0;

    public final int FB(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r8 = this;
        r7 = 2;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r8.Fw(r9);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r8.Yc(r9);
        r0 = r0.append(r2);
        r2 = "AND isSend=1";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.hiZ;
        r3 = 0;
        r3 = r0.a(r2, r3, r7);
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        if (r0 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x0039:
        r0 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x003e:
        r3.close();
    L_0x0041:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r5[r1] = r9;
        r1 = 1;
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r5[r7] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r5);
        return r0;
    L_0x0059:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r5 = "";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r3.close();
        r0 = r1;
        goto L_0x0041;
    L_0x006b:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x0070:
        r0 = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.av.FB(java.lang.String):int");
    }

    public final int dt(java.lang.String r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r8 = this;
        r7 = 2;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r8.Fw(r9);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r8.Yc(r9);
        r0 = r0.append(r2);
        r2 = "AND content LIKE '";
        r0 = r0.append(r2);
        r0 = r0.append(r10);
        r2 = "%' ";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.hiZ;
        r3 = 0;
        r3 = r0.a(r2, r3, r7);
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        if (r0 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0044:
        r0 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0049:
        r3.close();
    L_0x004c:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r5[r1] = r9;
        r1 = 1;
        r5[r1] = r10;
        r1 = java.lang.Integer.valueOf(r0);
        r5[r7] = r1;
        r1 = 3;
        r5[r1] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r5);
        return r0;
    L_0x0067:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r5 = "";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r3.close();
        r0 = r1;
        goto L_0x004c;
    L_0x0079:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x007e:
        r0 = r1;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.av.dt(java.lang.String, java.lang.String):int");
    }

    public final void a(e eVar) {
        if (!this.xIc.contains(eVar)) {
            x.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", eVar);
            this.xIc.add(eVar);
        }
    }

    public final h aZR() {
        return this.hiZ;
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId" + " INTEGER , type INT, status" + " INT, isSend INT, isShowTimer" + " INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath" + " TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording" + " TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId" + " TEXT, msgSeq INTEGER, flag" + " INT) ";
        gLy = strArr;
    }

    public final void a(c.c cVar) {
        if (this.xIl.cb(cVar)) {
            this.xIl.doNotify();
        }
    }

    public final void a(c.a aVar, Looper looper) {
        this.xIl.a(aVar, looper);
    }

    public final void a(c.a aVar) {
        this.xIl.remove(aVar);
    }

    public final void lock() {
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    }

    public final void unlock() {
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    }

    public final void EZ(String str) {
        x.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xIn), Integer.valueOf(this.xrX.xsa), Integer.valueOf(this.xIl.xsa), Integer.valueOf(this.xIm.size()), this.xIo, Long.valueOf(bi.bA(this.xIp)));
        if (bi.oN(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.xIn) {
            x.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.xIo, Long.valueOf(bi.bA(this.xIp)));
            return;
        }
        this.xIo = str;
        this.xIp = bi.Wy();
        this.xIn = true;
        super.lock();
        this.xIl.lock();
    }

    public final void Fa(String str) {
        x.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xIn), Integer.valueOf(this.xrX.xsa), Integer.valueOf(this.xIl.xsa), Integer.valueOf(this.xIm.size()), this.xIo, Long.valueOf(bi.bA(this.xIp)));
        if (bi.oN(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.xIn) {
            x.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, bi.chl());
        } else if (str.equals(this.xIo)) {
            this.xIn = false;
            this.xIp = 0;
            this.xIo = "";
            for (String str2 : this.xIm.keySet()) {
                a((c.c) this.xIm.get(str2));
            }
            this.xIm.clear();
            super.unlock();
            this.xIl.unlock();
            doNotify();
        } else {
            x.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.xIo, Long.valueOf(bi.bA(this.xIp)), str);
        }
    }

    public final void a(h hVar, String str) {
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Cursor a = hVar.a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    obj = 1;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    obj3 = 1;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    obj4 = 1;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    obj5 = 1;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    obj6 = 1;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    obj7 = 1;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    obj8 = 1;
                } else if ("flag".equalsIgnoreCase(string)) {
                    obj9 = 1;
                }
            }
        }
        a.close();
        long dA = hVar.dA(Thread.currentThread().getId());
        if (obj == null) {
            hVar.fD(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj2 == null) {
            hVar.fD(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj3 == null) {
            hVar.fD(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj4 == null) {
            hVar.fD(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            hVar.fD(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj6 == null) {
            hVar.fD(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj7 == null) {
            hVar.fD(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj8 == null) {
            hVar.fD(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj9 == null) {
            hVar.fD(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        hVar.fT(dA);
    }

    public final void F(String str, long j) {
        b Yi = Yi(str);
        long j2 = Yi.hBI;
        Random random = new Random();
        this.hiZ.fD("message", "BEGIN;");
        cg auVar = new au(str);
        for (int i = 0; ((long) i) < j; i++) {
            auVar.aq(System.currentTimeMillis());
            auVar.setType(1);
            auVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bi.chm());
            auVar.ao(j2);
            auVar.eR(random.nextInt(4));
            auVar.eS(random.nextInt(1));
            j2++;
            Yi.hBI++;
            auVar.ap(System.currentTimeMillis() + ((long) bi.chm()));
            this.hiZ.fD("message", "INSERT INTO " + Fw(auVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + auVar.field_msgId + "," + auVar.field_msgSvrId + "," + auVar.getType() + "," + auVar.field_status + "," + auVar.field_createTime + ",'" + auVar.field_talker + "','" + auVar.field_content + "'," + Yd(str) + ");");
            if (i % 10000 == 0) {
                this.hiZ.fD("message", "COMMIT;");
                this.hiZ.fD("message", "BEGIN;");
            }
        }
        this.hiZ.fD("message", "COMMIT;");
        this.kvz.XG(str);
        auVar.ao(1 + j2);
        Q(auVar);
    }

    private void ckC() {
        long currentTimeMillis = System.currentTimeMillis();
        long dA = this.hiZ.dA(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        String str = "message";
        String[] strArr = new String[]{"CREATE INDEX IF NOT EXISTS " + str + "IdIndex ON message ( msgId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SvrIdIndex ON message ( msgSvrId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SendCreateTimeIndex ON message ( status" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "CreateTimeIndex ON message ( createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TaklerIdTypeCreateTimeIndex ON message ( talkerId" + ",type,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdStatusIndex ON message ( talkerId" + ",status )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIndex ON message ( talkerId" + ",createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdSvrIdIndex ON message ( talkerId" + ",msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdTypeIndex ON message ( talkerId" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerTypeIndex ON message ( talker" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerMsgSeqIndex ON message ( talker" + ",msgSeq )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerFlagMsgSeqIndex ON message ( talker" + ",flag,msgSeq" + " )"};
        if (!this.xIb) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                this.hiZ.fD("message", (String) arrayList.get(i2));
                i = i2 + 1;
            } else {
                x.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                this.hiZ.fT(dA);
                x.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
        }
    }

    public final void aZS() {
        g.Dr();
        g.Dq().Db().set(348167, Integer.valueOf(1));
    }

    public av(h hVar, ar arVar, as asVar) {
        this.hiZ = hVar;
        this.kvx = arVar;
        this.kvz = asVar;
        g.Dr();
        if (((Integer) g.Dq().Db().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.hiZ.delete("message", "msgId> ? ", new String[]{"80000000"});
            x.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            g.Dr();
            g.Dq().Db().set(348169, Integer.valueOf(1));
        }
        a(hVar, "message");
        ckC();
        if (this.xId == null) {
            this.xId = new LinkedList();
        }
        this.xId.clear();
        a(new b(1, "message", b.a(1, 1000000, 10000000, 90000000)));
    }

    public final void a(b bVar) {
        synchronized (this.xId) {
            this.xId.add(bVar);
        }
        b(bVar);
    }

    public final void aZT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.xId.size()) {
                b((b) this.xId.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void b(b bVar) {
        Cursor a = this.hiZ.a("select max(msgid) from " + bVar.name, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            x.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", Integer.valueOf(i), Long.valueOf(bVar.hBI));
            if (((long) i) >= bVar.hBI) {
                x.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(bVar.hBI), Integer.valueOf(i), Long.valueOf(bVar.ouw[0].ouz), Long.valueOf(bVar.ouw[1].ouy), bi.chl());
                if (((long) i) <= bVar.ouw[0].ouz || ((long) i) >= bVar.ouw[1].ouy) {
                    bVar.hBI = (long) i;
                } else {
                    x.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(bVar.ouw[1].ouy));
                    bVar.hBI = bVar.ouw[1].ouy;
                    com.tencent.mm.plugin.report.d.pVE.a(111, 169, 1, false);
                }
            }
        }
        a.close();
        x.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.hBI);
    }

    public final void aZU() {
        if (this.xIb) {
            String str = "message";
            Cursor a = this.hiZ.a("select count(*) from " + str + " where talkerId ISNULL ", null, 2);
            if (a != null) {
                int i = a.moveToFirst() ? a.getInt(0) : 0;
                a.close();
                if (i > 0) {
                    x.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    x.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.hiZ.fD(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.hiZ.fD(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)") && this.xIb) {
                        this.hiZ.fD("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.hiZ.fD("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.hiZ.fD("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.hiZ.fD("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.hiZ.fD("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        x.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
        }
    }

    public final au dI(long j) {
        au auVar = new au();
        Cursor a = this.hiZ.a(fS(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au G(String str, long j) {
        au auVar = new au();
        Cursor a = this.hiZ.a(Fw(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au H(String str, long j) {
        au auVar = new au();
        Cursor a = this.hiZ.a(Fw(str), null, Yc(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au I(String str, long j) {
        au auVar = new au();
        Cursor a = this.hiZ.a(Fw(str), null, "createTime=? AND" + Yc(str), new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final Cursor Fb(String str) {
        return this.hiZ.query(Fw(str), new String[]{"createTime", "msgId"}, Yc(str), null, "createTime", null, "createTime ASC");
    }

    public final List<au> J(String str, long j) {
        List<au> arrayList = new ArrayList();
        String str2 = "Select * From " + Fw(str) + " Where " + Yc(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11";
        Cursor a = this.hiZ.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final List<au> K(String str, long j) {
        List<au> arrayList = new ArrayList();
        String str2 = "Select * From " + Fw(str) + " Where " + Yc(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11" + ";";
        Cursor a = this.hiZ.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final au L(String str, long j) {
        au auVar = new au();
        String str2 = "Select * From " + Fw(str) + " Where " + Yc(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 1;";
        Cursor a = this.hiZ.a(str2, new String[]{String.valueOf(j)}, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au M(String str, long j) {
        au auVar = new au();
        String str2 = "Select * From " + Fw(str) + " Where " + Yc(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime ASC Limit 1;";
        Cursor a = this.hiZ.a(str2, new String[]{String.valueOf(j)}, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    private String Yc(String str) {
        String Fw = Fw(str);
        if (this.xIb && Fw.equals("message")) {
            return " talkerId=" + Yd(str) + " ";
        }
        return " talker= '" + bi.oL(str) + "' ";
    }

    private long Yd(String str) {
        long Xw = this.kvx.Xw(str);
        if (Xw < 0) {
            x xVar = new x(str);
            xVar.setType(2);
            this.kvx.S(xVar);
            Xw = this.kvx.Xw(str);
        }
        if (!com.tencent.mm.sdk.a.b.cfz()) {
            x.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(Xw), Boolean.valueOf(r2), bi.chl());
        }
        return Xw;
    }

    public final ArrayList<au> aZV() {
        ArrayList<au> arrayList = new ArrayList();
        Cursor a = this.hiZ.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            cg auVar = new au();
            auVar.b(a);
            if (!(((!auVar.ckk() ? 1 : 0) & 1) == 0 || x.Xd(auVar.field_talker) || x.Xf(auVar.field_talker) || x.gB(auVar.field_talker))) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final void G(ArrayList<Long> arrayList) {
        long dA = this.hiZ.dA(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                au dI = dI(longValue);
                dI.fc(dI.gkC | 32);
                x.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                a(longValue, dI);
            }
        } finally {
            this.hiZ.fT(dA);
        }
    }

    public final boolean N(String str, long j) {
        return I(str, j).field_msgId > 0;
    }

    public final int c(String str, long j, int i) {
        String str2 = "SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor a = this.hiZ.a(str2, null, 0);
        int count = a.getCount();
        a.close();
        x.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        return count;
    }

    public final au Fc(String str) {
        au auVar = new au();
        Cursor a = this.hiZ.a(Fw(str), null, Yc(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au Fd(String str) {
        if (bi.oN(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + "order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final au dr(String str, String str2) {
        if (bi.oN(str)) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            return null;
        }
        cg auVar = new au();
        Cursor a = this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        x.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(auVar.field_msgId));
        return auVar;
    }

    public final au Fe(String str) {
        if (bi.oN(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + "and isSend = 0" + "  order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final List<au> by(String str, int i) {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.xId != null);
        Cursor a = this.hiZ.a("SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND status = 3" + " AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        a.close();
        return arrayList;
    }

    public final au sM(int i) {
        if (this.xId == null) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        au auVar = new au();
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.xId.size()) {
                return auVar;
            }
            if ((((b) this.xId.get(i3)).oux & i) != 0) {
                Cursor a = this.hiZ.a("select * from " + ((b) this.xId.get(i3)).name + "  order by createTime DESC limit 1", null, 2);
                if (a.moveToFirst()) {
                    long j2 = a.getLong(a.getColumnIndex("createTime"));
                    if (j < j2) {
                        auVar.b(a);
                        j = j2;
                    }
                }
                a.close();
            }
            i2 = i3 + 1;
        }
    }

    public final au Ff(String str) {
        if (this.xId == null) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        String str2;
        au auVar = new au();
        if (bi.oN(str)) {
            str2 = "";
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        int i = 0;
        long j = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.xId.size()) {
                return auVar;
            }
            if ((((b) this.xId.get(i2)).oux & 8) != 0) {
                Cursor a = this.hiZ.a("select * from " + ((b) this.xId.get(i2)).name + str2 + "  order by createTime DESC limit 1", null, 2);
                if (a.moveToFirst()) {
                    long j2 = a.getLong(a.getColumnIndex("createTime"));
                    if (j < j2) {
                        auVar.b(a);
                        j = j2;
                    }
                }
                a.close();
            }
            i = i2 + 1;
        }
    }

    public final List<au> aZW() {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.xId != null);
        List<au> arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.xId.size()) {
                break;
            }
            Cursor a = this.hiZ.a(((b) this.xId.get(i2)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
            while (a.moveToNext()) {
                cg auVar = new au();
                auVar.b(a);
                if (auVar.cjV() || auVar.cjU() || auVar.aNL() || auVar.ckf()) {
                    if (bb.HC() - auVar.field_createTime > 600000) {
                        arrayList2.add(auVar);
                    } else {
                        arrayList.add(auVar);
                    }
                }
            }
            a.close();
            i = i2 + 1;
        }
        if (arrayList2.size() > 0) {
            long dA = this.hiZ.dA(-1);
            for (au auVar2 : arrayList2) {
                x.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(auVar2.field_msgId), Long.valueOf(auVar2.field_createTime), auVar2.field_talker, bi.Wz(auVar2.field_content));
                auVar2.eR(5);
                a(auVar2.field_msgId, auVar2);
            }
            this.hiZ.fT(dA);
        }
        return arrayList;
    }

    public final List<au> bz(String str, int i) {
        List<au> arrayList = new ArrayList();
        Assert.assertTrue(this.xId != null);
        Cursor a = this.hiZ.a("SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            if (auVar.cjV()) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final List<au> N(String str, int i, int i2) {
        List<au> arrayList = new ArrayList();
        x.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + Fw(str) + " WHERE type = 49 ORDER BY createTime" + " DESC LIMIT " + i + " , " + i2);
        Cursor a = this.hiZ.a(r1, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            if (auVar.aNJ()) {
                arrayList.add(auVar);
            }
        }
        a.close();
        return arrayList;
    }

    public final int P(au auVar) {
        int i = 0;
        if (!(auVar == null || bi.oN(auVar.field_talker))) {
            Cursor a = this.hiZ.a("SELECT count(msgId) FROM " + Fw(auVar.field_talker) + " WHERE" + Yc(auVar.field_talker) + "AND isSend = 0" + " AND msgId >= " + auVar.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    private static String Ye(String str) {
        if (bi.oN(str)) {
            return null;
        }
        try {
            Map y = bj.y(str, "msgsource");
            if (y == null || y.isEmpty()) {
                return null;
            }
            return (String) y.get(".msgsource.bizmsg.msgcluster");
        } catch (Throwable e) {
            x.e("MicroMsg.MsgInfoStorage", "exception:%s", bi.i(e));
            x.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            return null;
        }
    }

    private static void af(au auVar) {
        if (auVar != null && auVar.aNJ()) {
            try {
                String str = auVar.field_content;
                int indexOf = str.indexOf("<msg>");
                if (indexOf > 0 && indexOf < str.length()) {
                    str = str.substring(indexOf).trim();
                }
                Map y = bj.y(str, "msg");
                if (y != null && y.size() > 0) {
                    auVar.dW(ay.at(y));
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgInfoStorage", e.getMessage());
            }
        }
    }

    public final long Q(au auVar) {
        return b(auVar, false);
    }

    public final long b(au auVar, boolean z) {
        String str;
        if (auVar == null || bi.oN(auVar.field_talker)) {
            com.tencent.mm.plugin.report.d.pVE.a(111, 250, 1, false);
            str = "MicroMsg.MsgInfoStorage";
            String str2 = "Error insert message msg:%s talker:%s";
            Object[] objArr = new Object[2];
            objArr[0] = auVar;
            objArr[1] = auVar == null ? "-1" : auVar.field_talker;
            x.e(str, str2, objArr);
            return -1;
        }
        x.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.xIn), Long.valueOf(auVar.field_msgSeq));
        String str3 = null;
        bb.b hW = bb.hW(auVar.gkD);
        if (hW != null) {
            str3 = hW.hip;
        }
        if (s.hm(str3)) {
            x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str3);
            if (auVar.getType() == 436207665) {
                x.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                return -1;
            }
            auVar.dU("notifymessage");
        }
        b Yi = Yi(auVar.field_talker);
        if (Yi == null) {
            com.tencent.mm.plugin.report.d.pVE.a(111, 249, 1, false);
            x.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", auVar.field_talker);
            return -1;
        }
        Yi.bac();
        auVar.ao(Yi.hBI);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[]{Long.valueOf(auVar.field_msgId), Yi, fS(auVar.field_msgId)}), Yi.name.equals(fS(auVar.field_msgId)));
        if (auVar.field_msgSvrId != 0) {
            auVar.gkH = 1;
            auVar.ggu = true;
        }
        for (e a : this.xIc) {
            if (!a.a(auVar, hW)) {
                x.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", auVar.field_talker, auVar.gkD);
                return -1;
            }
        }
        af(auVar);
        if (Yi.name.equals("message")) {
            auVar.field_talkerId = (int) Yd(auVar.field_talker);
            auVar.gkn = true;
        }
        x.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(this.hiZ.a(Yi.name, "msgId", auVar.vP(), z)), auVar.field_talker, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.getType()), Integer.valueOf(auVar.field_status), Long.valueOf(auVar.field_msgSvrId), Long.valueOf(auVar.field_msgSeq), Integer.valueOf(auVar.field_flag), Long.valueOf(auVar.field_createTime), Integer.valueOf(auVar.field_isSend), this.xIo, Long.valueOf(bi.bA(this.xIp)));
        if (this.hiZ.a(Yi.name, "msgId", auVar.vP(), z) == -1) {
            com.tencent.mm.plugin.report.d.pVE.a(111, 248, 1, false);
            x.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(auVar.field_msgSvrId), Long.valueOf(r10));
            return -1;
        }
        if (this.xIn && bi.bA(this.xIp) > 2000 && auVar.field_isSend == 1 && auVar.field_status == 1) {
            x.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.xIo, Long.valueOf(bi.bA(this.xIp)));
            Fa(this.xIo);
        }
        c.c cVar;
        if (this.xIn) {
            Object obj;
            str3 = null;
            if (e.xuM != null) {
                str3 = e.xuM.F(auVar);
            }
            if (bi.oN(str3)) {
                obj = auVar.field_talker;
            } else {
                str = str3;
            }
            cVar = null;
            if (this.xIm.containsKey(obj)) {
                cVar = (c.c) this.xIm.get(obj);
            }
            if (cVar == null) {
                cVar = new c.c(auVar.field_talker, "insert", auVar);
            } else {
                cVar.ouB.add(auVar);
            }
            if (c.c.T(auVar)) {
                cVar.ouC++;
            }
            cVar.ouD++;
            this.xIm.put(obj, cVar);
        } else {
            cVar = new c.c(auVar.field_talker, "insert", auVar);
            if (c.c.T(auVar)) {
                cVar.ouC = 1;
            }
            cVar.ouD = 1;
            doNotify();
            a(cVar);
        }
        return auVar.field_msgId;
    }

    public final int dJ(long j) {
        cg dI = dI(j);
        String str = dI.field_talker;
        this.xIk.j((int) (bi.Wx() / 86400), dI.field_msgSvrId, dI.field_createTime / 1000);
        int delete = this.hiZ.delete(fS(j), "msgId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            WI("delete_id " + j);
            c.c cVar = new c.c(str, "delete", dI, 1, (byte) 0);
            cVar.ouF = j;
            cVar.kMn = dI.field_bizChatId;
            a(cVar);
        } else {
            com.tencent.mm.plugin.report.d.pVE.a(111, 245, 1, false);
        }
        return delete;
    }

    public final List<au> Fg(String str) {
        List<au> list = null;
        Cursor a = this.hiZ.a("select * from " + str, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    au auVar = new au();
                    auVar.b(a);
                    list.add(auVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final long O(String str, long j) {
        String str2 = "select createTime from " + Fw(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor a = this.hiZ.a(str2, null, 2);
        if (a.moveToFirst()) {
            j2 = a.getLong(0);
        }
        a.close();
        return j2;
    }

    public final List<au> c(String str, long j, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long O = O(str, j);
        if (O == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<au> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + Fw(str) + " where" + Yc(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime > " + O + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + Fw(str) + " where" + Yc(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + O + "  order by createTime DESC limit 10";
        }
        Cursor a = this.hiZ.a(str2, null, 2);
        while (a.moveToNext()) {
            au auVar = new au();
            auVar.b(a);
            arrayList.add(auVar);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        a.close();
        return arrayList;
    }

    public final Cursor O(String str, int i, int i2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hiZ.a("select * from ( select * from " + Fw(str) + " where" + Yc(str) + " AND type IN (3,39,13,43,62,44,268435505)  order by " + "createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 2);
    }

    public final Cursor l(String str, long j, long j2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
    }

    public final Cursor Fh(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        String Fw = Fw(str);
        Cursor a = this.hiZ.a("select * from " + Fw + " " + Yf(Fw) + " where" + Yc(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by " + "createTime", null, 0);
        x.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Fw);
        return a;
    }

    public final Cursor bA(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + " AND type = 49  order by createTime" + " DESC limit " + i + " OFFSET 0", null, 0);
    }

    public final Cursor bB(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        StringBuilder append = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend from ").append(Fw(str)).append(" where").append(Yc(str)).append(" AND ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" (type = 49");
        stringBuilder.append(" or type = 553648177").append(") ");
        return this.hiZ.a(append.append(stringBuilder.toString()).append("  order by createTime DESC limit 100").append(" OFFSET ").append(i).toString(), null, 0);
    }

    public final void b(String str, String str2, String[] strArr) {
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((bi.Wx() - 172800) * 1000);
        if (!bi.oN(str2)) {
            str3 = str3 + " AND " + str2;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Cursor a = this.hiZ.a(str3, strArr, 2);
        if (a.moveToFirst()) {
            do {
                long j = a.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(a.getInt(0)));
                arrayList2.add(Long.valueOf(j));
            } while (a.moveToNext());
            this.xIk.i(arrayList, arrayList2);
        }
        a.close();
    }

    public final boolean dK(long j) {
        return this.xIk.fQ(j);
    }

    public final void Fi(String str) {
        b(str, "", null);
        if (this.hiZ.fD(str, "delete from " + str)) {
            WI("delete_all " + str);
        } else {
            com.tencent.mm.plugin.report.d.pVE.a(111, 247, 1, false);
        }
    }

    public final int P(String str, long j) {
        cg G = G(str, j);
        this.xIk.j((int) (bi.Wx() / 86400), G.field_msgSvrId, G.field_createTime / 1000);
        int delete = this.hiZ.delete(Fw(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            doNotify();
            a(new c.c(str, "delete", null, 1, (byte) 0));
        } else {
            com.tencent.mm.plugin.report.d.pVE.a(111, 246, 1, false);
        }
        return delete;
    }

    public final int Fj(String str) {
        x.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, aj.cgv());
        b(Fw(str), Yc(str), null);
        int delete = this.hiZ.delete(Fw(str), Yc(str), null);
        if (delete != 0) {
            WI("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", null, delete, (byte) 0);
            cVar.ouF = -1;
            a(cVar);
        }
        return delete;
    }

    public final int Q(String str, long j) {
        String str2 = Yc(str) + " and createTime <= " + j;
        b(Fw(str), str2, null);
        int delete = this.hiZ.delete(Fw(str), str2, null);
        if (delete != 0) {
            WI("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", null, delete, (byte) 0);
            cVar.ouF = -1;
            a(cVar);
        }
        return delete;
    }

    public final int bC(String str, int i) {
        x.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), aj.cgv());
        Assert.assertTrue(str.equals(G(str, (long) i).field_talker));
        b(Fw(str), "createTime<=? AND" + Yc(str), new String[]{r0.field_createTime});
        int delete = this.hiZ.delete(Fw(str), "createTime<=? AND" + Yc(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            doNotify();
            a(new c.c(str, "delete", null, delete, (byte) 0));
        }
        return delete;
    }

    public final boolean Fk(String str) {
        x.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, aj.cgv());
        b(Fw(str), " talker like '%" + str + "'", null);
        boolean fD = this.hiZ.fD(Fw(str), "delete from " + Fw(str) + " where talker like '%" + str + "'");
        if (fD) {
            doNotify();
        }
        return fD;
    }

    public final Cursor bD(String str, int i) {
        Assert.assertTrue(str.equals(G(str, (long) i).field_talker));
        return this.hiZ.query(Fw(str), null, "createTime<=? AND" + Yc(str), new String[]{r5.field_createTime}, null, null, null);
    }

    public final void a(long j, au auVar) {
        if (auVar.cjR()) {
            if (s.hm(Ye(auVar.gkD))) {
                x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", Ye(auVar.gkD));
                auVar.dU("notifymessage");
            }
        }
        af(auVar);
        if (this.hiZ.update(fS(j), auVar.vP(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c.c(auVar.field_talker, "update", auVar));
            return;
        }
        com.tencent.mm.plugin.report.d.pVE.a(111, 244, 1, false);
    }

    public final void R(au auVar) {
        if (auVar != null && auVar.field_status != 4) {
            auVar.eR(4);
            String fS = fS(auVar.field_msgId);
            if (fS != null && fS.length() > 0) {
                if (this.hiZ.update(fS, auVar.vP(), "msgId=?", new String[]{auVar.field_msgId}) != 0) {
                    doNotify();
                    a(new c.c(auVar.field_talker, "update", auVar, -1));
                }
            }
        }
    }

    public final void b(long j, au auVar) {
        Assert.assertTrue("no talker set when update by svrid", bi.oM(auVar.field_talker).length() > 0);
        if (auVar.cjR()) {
            if (s.hm(Ye(auVar.gkD))) {
                x.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", Ye(auVar.gkD));
                auVar.dU("notifymessage");
            }
        }
        af(auVar);
        if (this.hiZ.update(Fw(auVar.field_talker), auVar.vP(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c.c(auVar.field_talker, "update", auVar));
            return;
        }
        com.tencent.mm.plugin.report.d.pVE.a(111, 243, 1, false);
    }

    public final int Fl(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        int update = this.hiZ.update(Fw(str), contentValues, Yc(str) + "AND isSend=? AND status" + "!=? ", new String[]{str, "0", "4"});
        if (update != 0) {
            doNotify();
            a(new c.c(str, "update", null));
        }
        return update;
    }

    public final int S(au auVar) {
        int i = 0;
        if (auVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", auVar.field_content);
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(auVar.field_status));
            i = this.hiZ.update(fS(auVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(auVar.field_msgId)});
            if (i != 0) {
                doNotify();
                a(new c.c(auVar.field_talker, "update", auVar));
            }
        }
        return i;
    }

    public final Cursor Fm(String str) {
        return this.hiZ.query(Fw(str), null, Yc(str), null, null, null, "createTime ASC ");
    }

    public final Cursor e(String str, int i, long j) {
        return this.hiZ.a("SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null, 0);
    }

    public final Cursor ds(String str, String str2) {
        return this.hiZ.a(("SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null, 0);
    }

    public final Cursor f(String str, int i, long j) {
        x.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + (j > 0 ? " AND createTime > " + j : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return this.hiZ.a("SELECT * FROM ( SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + (j > 0 ? " AND createTime > " + j : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final Cursor g(String str, int i, long j) {
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor2 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + j);
        return this.hiZ.a("SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + j, null, 0);
    }

    public final Cursor Fn(String str) {
        return this.hiZ.query(Fw(str), null, "isSend=? AND" + Yc(str) + "AND status!=?", new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor bE(String str, int i) {
        return this.hiZ.query(Fw(str), null, "isSend=? AND" + Yc(str) + "AND status!=?  order by msgId" + " DESC limit " + i, new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor aZX() {
        return this.hiZ.query("message", new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{"0", "4"}, "talker", null, null);
    }

    public final au.c Fo(String str) {
        au.c cVar = (au.c) this.xIe.get(Integer.valueOf(str.hashCode()));
        if (cVar != null) {
            return cVar;
        }
        cVar = au.c.Ya(str);
        this.xIe.l(Integer.valueOf(str.hashCode()), cVar);
        return cVar;
    }

    public final d Fp(String str) {
        d dVar = (d) this.xIf.get(Integer.valueOf(str.hashCode()));
        if (dVar != null) {
            return dVar;
        }
        dVar = d.Yb(str);
        this.xIf.l(Integer.valueOf(str.hashCode()), dVar);
        return dVar;
    }

    public final a Fq(String str) {
        a aVar = null;
        if (bi.oN(str) || this.xIg == null) {
            x.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(bi.oN(str)));
            x.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = (a) this.xIg.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = a.XY(str);
            if (this.xIg != null) {
                this.xIg.l(Integer.valueOf(bi.aD(str, "").hashCode()), aVar);
            }
        }
        return aVar;
    }

    public final au.b Fr(String str) {
        au.b bVar = (au.b) this.xIh.get(Integer.valueOf(str.hashCode()));
        if (bVar != null) {
            return bVar;
        }
        bVar = au.b.XZ(str);
        this.xIh.l(Integer.valueOf(str.hashCode()), bVar);
        return bVar;
    }

    public final Cursor aZY() {
        boolean z;
        if (this.xId.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        return this.hiZ.query(((b) this.xId.get(0)).name, null, "msgId=?", new String[]{"-1"}, null, null, null);
    }

    public final int Fs(String str) {
        int i = 0;
        if (Ft(str)) {
            int XV = this.kvz.XV(str);
            if (XV > 0) {
                x.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(XV));
                return XV;
            }
            x.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            if ("appbrandmessage".equals(Fw(str))) {
                Cursor a = this.hiZ.a("SELECT COUNT(*) FROM " + Fw(str) + " WHERE" + Yc(str), null, 0);
                if (a.moveToLast()) {
                    i = a.getInt(0);
                }
                a.close();
                return i;
            }
        }
        return Fu(str);
    }

    public final boolean Ft(String str) {
        return "message".equals(Fw(str));
    }

    public final int Fu(String str) {
        int i;
        Cursor a = this.hiZ.a("SELECT COUNT(*) FROM " + Fw(str) + " " + (this.xIb ? "INDEXED BY messageTalkerIdStatusIndex" : "INDEXED BY messageTalkerStatusIndex") + " WHERE" + Yc(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        a.close();
        return i;
    }

    private String Yf(String str) {
        if (str == null || !str.equals("message")) {
            return "";
        }
        if (this.xIb) {
            return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
        }
        return "INDEXED BY messageCreateTaklerTypeTimeIndex";
    }

    public final int bF(String str, int i) {
        int i2 = 0;
        Cursor a = this.hiZ.a("SELECT COUNT(*) FROM " + Fw(str) + " WHERE" + Yc(str) + "AND type = " + i, null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        return i2;
    }

    public final int m(String str, long j, long j2) {
        int i = 0;
        Cursor a = this.hiZ.a("SELECT COUNT(*) FROM " + Fw(str) + " WHERE" + Yc(str) + "AND type = 50" + " AND createTime >= " + j + " AND createTime <= " + j2 + " LIMIT 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int Fv(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = Yi(str).name;
        Cursor a = this.hiZ.a(stringBuilder.append(str3 + "  indexed by  " + str3 + "TalkerTypeIndex ").append(" WHERE talker= '").append(bi.oL(str)).append("' AND type IN (3,39,13,43,62,44,268435505)").toString(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int R(String str, long j) {
        int i = 0;
        cg dI = dI(j);
        if (dI.field_msgId == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String Fw = Fw(str);
            Cursor a = this.hiZ.a("SELECT COUNT(*) FROM " + Fw + " " + Yf(Fw) + " WHERE " + Yc(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + dI.field_createTime, null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final String S(String str, long j) {
        String str2 = null;
        int i = 0;
        cg dI = dI(j);
        if (dI.field_msgId == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String Fw = Fw(str);
            Cursor a = this.hiZ.a("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + Fw + " " + Yf(Fw) + " WHERE" + Yc(str) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + dI.field_createTime, null, 0);
            str2 = "";
            if (a.moveToFirst()) {
                while (i < a.getColumnCount()) {
                    str2 = str2 + a.getString(i) + " ";
                    i++;
                }
            }
            a.close();
        }
        return str2;
    }

    public final String aZZ() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    public final String baa() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    public final String Fw(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return Yi(str).name;
    }

    private b Yg(String str) {
        String str2 = "tableName == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        for (int i = 0; i < this.xId.size(); i++) {
            if (str.equals(((b) this.xId.get(i)).name)) {
                return (b) this.xId.get(i);
            }
        }
        Assert.assertTrue("no table match", false);
        return null;
    }

    private String Yh(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        for (e WW : this.xIc) {
            String WW2 = WW.WW(str);
            if (!bi.oN(WW2)) {
                return WW2;
            }
        }
        return "message";
    }

    private b Yi(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return Yg(Yh(str));
    }

    public final boolean dL(long j) {
        for (int i = 0; i < this.xId.size(); i++) {
            if (((b) this.xId.get(i)).dN(j)) {
                return true;
            }
        }
        return false;
    }

    private String fS(long j) {
        if (j == 0 || j == -1) {
            return null;
        }
        au.fR(j);
        for (int i = 0; i < this.xId.size(); i++) {
            if (((b) this.xId.get(i)).dN(j)) {
                return ((b) this.xId.get(i)).name;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        return null;
    }

    public final long Fx(String str) {
        String str2 = "select createTime from message where" + Yc(str) + "order by createTime LIMIT 1 OFFSET 0";
        x.d("MicroMsg.MsgInfoStorage", "get first message create time: " + str2);
        Cursor a = this.hiZ.a(str2, null, 2);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return -1;
        }
    }

    public final long Fy(String str) {
        String str2 = "select createTime from message where" + Yc(str) + "order by createTime DESC LIMIT 1 ";
        x.d("MicroMsg.MsgInfoStorage", "get last message create time: " + str2);
        Cursor a = this.hiZ.a(str2, null, 2);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return -1;
        }
    }

    public final long Fz(String str) {
        if (bi.oN(str)) {
            return 0;
        }
        String str2 = "select msgSeq from message where" + Yc(str) + "order by msgSeq DESC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + str2);
        Cursor a = this.hiZ.a(str2, null, 2);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + str);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            return j;
        } else {
            a.close();
            return 0;
        }
    }

    public final au T(String str, long j) {
        if (bi.oN(str)) {
            return null;
        }
        String str2 = "select * from message where" + Yc(str) + " and msgSeq > " + j + " order by msgSeq ASC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq: " + str2);
        Cursor a = this.hiZ.a(str2, null, 0);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + str);
            return null;
        } else if (a.moveToFirst()) {
            au auVar = new au();
            auVar.b(a);
            a.close();
            return auVar;
        } else {
            a.close();
            return null;
        }
    }

    public final au U(String str, long j) {
        if (bi.oN(str)) {
            return null;
        }
        String str2 = "select * from message where" + Yc(str) + " and msgSeq < " + j + " order by msgSeq DESC LIMIT 1 ";
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: " + str2);
        Cursor a = this.hiZ.a(str2, null, 0);
        if (a == null) {
            x.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + str);
            return null;
        } else if (a.moveToFirst()) {
            au auVar = new au();
            auVar.b(a);
            a.close();
            return auVar;
        } else {
            a.close();
            return null;
        }
    }

    public final au FA(String str) {
        if (bi.oN(str)) {
            return null;
        }
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.valueOf(false));
        Long l = (Long) this.xIj.get(str);
        au auVar;
        if (l == null || l.longValue() <= 0) {
            x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            auVar = new au();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = this.hiZ.a("SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND flag %2 = 1  ORDER BY msgSeq" + " DESC LIMIT 1 ", null, 2);
            x.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (a == null) {
                x.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + str);
                return auVar;
            }
            if (a.moveToFirst()) {
                auVar.b(a);
            }
            a.close();
            this.xIj.l(str, Long.valueOf(auVar.field_msgId));
            return auVar;
        }
        x.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        auVar = dI(l.longValue());
        if ((auVar.field_flag & 1) != 0) {
            return auVar;
        }
        this.xIj.remove(str);
        return null;
    }

    public final int n(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        x.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j2), Long.valueOf(j));
        String str2 = "SELECT COUNT(msgId) FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        x.d("MicroMsg.MsgInfoStorage", "get count sql: " + str2);
        Cursor a = this.hiZ.a(str2, null, 2);
        if (a == null) {
            x.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            return 0;
        } else if (a.moveToFirst()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            return a.getInt(0);
        } else {
            a.close();
            return 0;
        }
    }

    public final Cursor a(String str, long j, long j2, boolean z) {
        int i;
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        StringBuilder append = new StringBuilder("SELECT * FROM ").append(Fw(str)).append(" WHERE").append(Yc(str)).append("AND createTime >= ").append(j2).append(" AND createTime <= ").append(j).append(" AND isSend=");
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        String stringBuilder = append.append(i).append(" LIMIT 1").toString();
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + stringBuilder);
        return this.hiZ.a(stringBuilder, null, 0);
    }

    public final Cursor o(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime >= " + j2 + " AND createTime <= " + j + " ORDER BY createTime ASC ";
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hiZ.a(str2, null, 0);
    }

    public final Cursor b(String str, long j, long j2, int i) {
        String str2;
        if (j2 == 0) {
            str2 = "SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + i;
            x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
            return this.hiZ.a(str2, null, 0);
        }
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        str2 = "SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime > " + j2 + " AND createTime < " + j + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + i;
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hiZ.a(str2, null, 0);
    }

    public final int p(String str, long j, long j2) {
        int i = 0;
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        Cursor a = this.hiZ.a("SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime > " + j2 + " AND createTime < " + j, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final Cursor q(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        x.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.hiZ.a(str2, null, 0);
    }

    public final Cursor D(String str, String str2, int i) {
        x.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        return this.hiZ.a(" SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final Cursor bG(String str, int i) {
        x.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i);
        return this.hiZ.a(" SELECT * FROM " + Fw(str) + " WHERE" + Yc(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i, null, 0);
    }

    public final long V(String str, long j) {
        x.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        x.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT 18");
        Cursor a = this.hiZ.a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            return j;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final boolean a(long j, String str, String str2, String str3) {
        return this.hiZ.fD(null, "UPDATE " + Yh(str) + " SET transContent = '" + bi.oL(str2) + "', transBrandWording = '" + bi.oL(bi.oM(str3)) + "' WHERE msgId = " + j);
    }

    public final long W(String str, long j) {
        x.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        x.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + Fw(str) + " WHERE" + Yc(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 18");
        Cursor a = this.hiZ.a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            return j;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final au[] bH(String str, int i) {
        if (str == null || str.length() == 0 || i <= 0) {
            x.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
            return null;
        }
        Cursor a = this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + "order by createTime DESC limit " + i, null, 2);
        if (a.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                au auVar = new au();
                auVar.b(a);
                arrayList.add(auVar);
            } while (a.moveToNext());
            a.close();
            x.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            return (au[]) arrayList.toArray(new au[arrayList.size()]);
        }
        x.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        a.close();
        return null;
    }

    public final LinkedList<au> du(String str, String str2) {
        LinkedList<au> linkedList = null;
        Cursor a = this.hiZ.a("message", null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null || !a.moveToFirst()) {
            x.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        } else {
            linkedList = new LinkedList();
            do {
                au auVar = new au();
                auVar.b(a);
                linkedList.add(auVar);
            } while (a.moveToNext());
            a.close();
        }
        return linkedList;
    }

    public final void dM(long j) {
        this.xIk.a(0, j, 0, false);
    }

    public final List<au> FC(String str) {
        Cursor a;
        Throwable e;
        Cursor cursor = null;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.hiZ.a("message", null, "talker=? AND createTime>=? AND type IN (436207665,419430449)", new String[]{bi.oL(str), String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    au auVar = new au();
                    auVar.b(a);
                    arrayList.add(auVar);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th) {
            e = th;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        try {
            x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            cursor = a;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
    }

    public final List<au> bab() {
        Cursor a;
        Throwable e;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.hiZ.a("message", null, "createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    au auVar = new au();
                    auVar.b(a);
                    arrayList.add(auVar);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th) {
            e = th;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        try {
            x.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }

    public final long FD(String str) {
        if (bi.oN(str)) {
            return 0;
        }
        b Yg = Yg(str);
        if (Yg != null) {
            return Yg.hBI;
        }
        return 0;
    }

    public final Cursor d(String str, long j, int i) {
        Cursor cursor = null;
        try {
            return this.hiZ.a("select * from " + str + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + j + "  order by msgId ASC  limit " + i, null, 0);
        } catch (Exception e) {
            return cursor;
        }
    }

    public final Cursor bI(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return this.hiZ.a("select * from " + Fw(str) + " where" + Yc(str) + " AND type IN (436207665" + ",419430449)  order by createTime" + " DESC limit " + i + " OFFSET 0", null, 0);
    }
}
