package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.f.a.sa;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.xwalk.core.R;

public final class a extends com.tencent.mm.plugin.fts.a.b {
    private static Set<String> mSD = new HashSet();
    private com.tencent.mm.plugin.fts.a.l gKV;
    private com.tencent.mm.sdk.b.c mSA = new com.tencent.mm.sdk.b.c<sa>() {
        {
            this.xmG = sa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a.this.gKV.a(65556, new g(com.tencent.mm.plugin.fts.a.c.mPU));
            a.this.gKV.a(131093, new u(a.this, (byte) 0));
            return false;
        }
    };
    private al mSB = new al(com.tencent.mm.kernel.g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        private int mSF = 0;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean uG() {
            /*
            r6 = this;
            r2 = 1;
            r1 = 0;
            r0 = com.tencent.mm.plugin.fts.PluginFTS.class;
            r0 = com.tencent.mm.kernel.g.k(r0);
            r0 = (com.tencent.mm.plugin.fts.PluginFTS) r0;
            r3 = r0.isCharging();
            if (r3 != 0) goto L_0x0016;
        L_0x0010:
            r0 = r0.isInBackground();
            if (r0 != 0) goto L_0x0023;
        L_0x0016:
            r0 = r2;
        L_0x0017:
            if (r0 != 0) goto L_0x0025;
        L_0x0019:
            r0 = r6.mSF;
            r0 = r0 + 1;
            r6.mSF = r0;
            r3 = 6;
            if (r0 >= r3) goto L_0x0025;
        L_0x0022:
            return r2;
        L_0x0023:
            r0 = r1;
            goto L_0x0017;
        L_0x0025:
            r0 = com.tencent.mm.plugin.fts.b.a.this;
            r0 = r0.gKV;
            r3 = 131093; // 0x20015 float:1.837E-40 double:6.47685E-319;
            r4 = new com.tencent.mm.plugin.fts.b.a$u;
            r5 = com.tencent.mm.plugin.fts.b.a.this;
            r4.<init>(r5, r1);
            r0.a(r3, r4);
            r6.mSF = r1;
            goto L_0x0022;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.b.a.7.uG():boolean");
        }

        public final String toString() {
            return super.toString() + "|delayIndexTimer";
        }
    }, true);
    private al mSC = new al(com.tencent.mm.kernel.g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            a.this.gKV.a(131093, new u(a.this, (byte) 0));
            return false;
        }

        public final String toString() {
            return super.toString() + "|atOnceIndexTimer";
        }
    }, false);
    private com.tencent.mm.plugin.fts.c.a mSp;
    private HashSet<String> mSq;
    private HashMap<String, List<Long>> mSr;
    private HashMap<String, String[]> mSs;
    private HashMap<String, List<Long>> mSt;
    private Method mSu;
    private com.tencent.mm.sdk.e.m.b mSv = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            String str = (String) obj;
            if (a.BP(str)) {
                x Xq = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xq(str);
                if (Xq == null || (a.C(Xq) && !Xq.ciN())) {
                    switch (i) {
                        case 2:
                        case 5:
                            if (!a.this.mSr.containsKey(str)) {
                                a.this.gKV.a(65556, new h(str));
                                return;
                            }
                            return;
                        case 3:
                            if (!a.this.mSq.contains(str) && !a.this.mSr.containsKey(str)) {
                                a.this.gKV.a(65556, new i(str));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", str);
        }
    };
    private com.tencent.mm.sdk.e.m.b mSw = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            String str = (String) obj;
            if (a.BP(str)) {
                x Xq = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xq(str);
                if (Xq == null || a.C(Xq)) {
                    switch (i) {
                        case 2:
                            a.this.gKV.a(65556, new e(str));
                            return;
                        case 3:
                        case 4:
                            if (!a.this.mSr.containsKey(str)) {
                                a.this.gKV.a(65556, new h(str));
                                return;
                            }
                            return;
                        case 5:
                            a.this.gKV.a(65556, new d(str));
                            return;
                        default:
                            return;
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", str);
        }
    };
    private com.tencent.mm.sdk.e.j.a mSx = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (!str.equals("*") && !str.equals("chatroomname") && !a.this.mSr.containsKey(str)) {
                a.this.gKV.a(65556, new h(str));
            }
        }
    };
    private com.tencent.mm.sdk.e.j.a mSy = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            String[] split = str.split(" ");
            if (split != null && split.length != 0 && split[0].equals("update")) {
                for (int i = 1; i < split.length; i++) {
                    a.this.gKV.a(65554, new v(bi.getLong(split[i], 0)));
                }
                a.this.gKV.a(65556, new u(a.this, (byte) 0));
            }
        }
    };
    private com.tencent.mm.sdk.b.c mSz = new com.tencent.mm.sdk.b.c<se>() {
        {
            this.xmG = se.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            se seVar = (se) bVar;
            if (seVar.fKK.fqN <= 0) {
                a.this.gKV.a(131093, new u(a.this, (byte) 0));
            } else if (a.this.mSC.cgx()) {
                al h = a.this.mSC;
                long j = seVar.fKK.fqN;
                h.K(j, j);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
            }
            return false;
        }
    };
    private com.tencent.mm.plugin.fts.a.i mtW;

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String gBJ;
        private int mSS = 0;

        public d(String str) {
            this.gBJ = str;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", this.gBJ);
            a.this.mSp.a(com.tencent.mm.plugin.fts.a.c.mPT, this.gBJ);
            ((PluginFTS) com.tencent.mm.kernel.g.k(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.mPT, this.gBJ);
            Cursor BT = a.this.mSp.BT(this.gBJ);
            HashSet hashSet = new HashSet();
            while (BT.moveToNext()) {
                hashSet.add(BT.getString(0));
            }
            BT.close();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!a.this.mSr.containsKey(str)) {
                    a.this.mSr.put(str, a.this.mSp.b(com.tencent.mm.plugin.fts.a.c.mPT, str));
                    ((PluginFTS) com.tencent.mm.kernel.g.k(PluginFTS.class)).getTopHitsLogic().BR(str);
                    this.mSS++;
                }
            }
            return true;
        }

        public final String adF() {
            return String.format("{username: %s mDirtyCount: %d}", new Object[]{this.gBJ, Integer.valueOf(this.mSS)});
        }

        public final String getName() {
            return "DeleteContactTask";
        }
    }

    private class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int mST;
        private int mSU;

        private f() {
            this.mST = 0;
            this.mSU = 0;
        }

        /* synthetic */ f(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            Cursor rawQuery = a.this.mSp.mPC.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                long j = rawQuery.getLong(1);
                List list = (List) a.this.mSt.get(string);
                if (list == null) {
                    list = new ArrayList(16);
                    a.this.mSt.put(string, list);
                    this.mST++;
                }
                list.add(Long.valueOf(j));
                this.mSU++;
            }
            rawQuery.close();
            return true;
        }

        public final String adF() {
            return String.format("{users: %d labels: %d}", new Object[]{Integer.valueOf(this.mST), Integer.valueOf(this.mSU)});
        }

        public final String getName() {
            return "LoadLabelCacheTask";
        }
    }

    private class g extends com.tencent.mm.plugin.fts.a.a.a {
        private int[] mSV;
        private int mSW = 0;
        private int mSX = 0;

        public g(int[] iArr) {
            this.mSV = iArr;
        }

        public final boolean execute() {
            List<com.tencent.mm.plugin.fts.a.a.b> e = a.this.mSp.e(this.mSV, 1);
            this.mSW = e.size();
            Object hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.b bVar : e) {
                String str = bVar.mRd;
                if (!a.this.mSr.containsKey(str)) {
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList(16);
                        hashMap.put(str, list);
                    }
                    list.add(Long.valueOf(bVar.mRb));
                }
            }
            a.this.mSr.putAll(hashMap);
            this.mSX = hashMap.size();
            return true;
        }

        public final String adF() {
            return String.format("{touched: %d users: %d}", new Object[]{Integer.valueOf(this.mSW), Integer.valueOf(this.mSX)});
        }

        public final String getName() {
            return "MarkAllContactDirtyTask";
        }
    }

    private class i extends com.tencent.mm.plugin.fts.a.a.a {
        private boolean mSZ;
        private String username;

        public i(String str) {
            this.username = str;
        }

        public final boolean execute() {
            if (a.this.mSr.containsKey(this.username)) {
                this.mSZ = true;
            } else if (a.this.mSq.add(this.username)) {
                x BB = a.this.mtW.BB(this.username);
                if (BB == null || a.this.D(BB)) {
                    com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
                    String str = this.username;
                    a.mPI.bindLong(1, 2);
                    a.mPI.bindString(2, str);
                    a.mPI.bindLong(3, 0);
                    a.mPI.execute();
                } else {
                    this.mSZ = true;
                }
            } else {
                this.mSZ = true;
            }
            return true;
        }

        public final String adF() {
            return String.format("{username: %s isSkipped: %b}", new Object[]{this.username, Boolean.valueOf(this.mSZ)});
        }

        public final String getName() {
            return "MarkContactTimestampTask";
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        private HashSet<String> mSG;
        private HashMap<String, x> mSH;
        private long mSI;
        private long mSJ;
        private int mSK;
        private int mSL;
        private int mSM;
        private int mSN;
        private int mSO;
        private int mSP;
        private int mSQ;

        private b() {
            this.mSH = new HashMap();
            this.mSI = -1;
            this.mSJ = -1;
            this.mSK = 0;
            this.mSL = 0;
            this.mSM = 0;
            this.mSN = 0;
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            int i;
            long j;
            List list;
            Throwable e;
            Throwable th;
            Throwable e2;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
            BL("start");
            if (this.mSG == null) {
                this.mSG = new HashSet();
                Cursor a = a.this.mSp.a(com.tencent.mm.plugin.fts.a.c.mPT, true, false, true, false, true);
                while (a.moveToNext()) {
                    String string = a.getString(1);
                    i = a.getInt(2);
                    j = a.getLong(0);
                    if (i == 1) {
                        list = (List) a.this.mSr.get(string);
                        if (list == null) {
                            list = new ArrayList(16);
                            a.this.mSr.put(string, list);
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.mSG.add(string);
                        if (i == 2) {
                            a.this.mSq.add(string);
                        }
                    }
                }
                a.close();
                this.mSO = a.this.mSr.size();
                this.mSP = a.this.mSq.size();
                this.mSQ = this.mSG.size();
                if (this.mSQ < 5) {
                    this.mQW |= 1;
                }
            }
            BL("getBuildContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (a.this.mSr.size() > 0) {
                List arrayList = new ArrayList();
                for (List list2 : a.this.mSr.values()) {
                    arrayList.addAll(list2);
                }
                a.this.mSr.clear();
                a.this.mSp.aT(arrayList);
            }
            BL("deleteDirtyContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            String str;
            if (a.this.mSq.size() > 0) {
                Iterator it = a.this.mSq.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    a.this.mSp.C(str, a.this.mtW.BD(str));
                }
                a.this.mSq.clear();
            }
            BL("updateTimestampContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i2;
            Cursor i3 = a.this.mtW.i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.mSI)});
            i = 50;
            while (i3.moveToNext()) {
                if (Thread.interrupted()) {
                    i3.close();
                    a.this.mSp.commit();
                    throw new InterruptedException();
                }
                j = i3.getLong(0);
                this.mSI = j;
                ag xVar = new x();
                xVar.gKO = j;
                xVar.setUsername(i3.getString(1));
                xVar.cZ(i3.getString(2));
                xVar.da(i3.getString(3));
                xVar.dc(i3.getString(4));
                xVar.ez(i3.getInt(5));
                xVar.setType(i3.getInt(6));
                xVar.z(i3.getBlob(7));
                xVar.dj(i3.getString(8));
                xVar.eB(0);
                this.mSH.put(xVar.field_username, xVar);
                if (!(com.tencent.mm.y.s.eX(xVar.field_username) || !a.this.D(xVar) || this.mSG.remove(xVar.field_username))) {
                    if (i >= 50) {
                        a.this.mSp.commit();
                        a.this.mSp.beginTransaction();
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    try {
                        if (!xVar.field_username.endsWith("@chatroom") && (xVar.field_verifyFlag & x.ciP()) == 0) {
                            a.this.B(xVar);
                            xVar.ciS();
                        }
                        i = a.this.F(xVar) + i2;
                        try {
                            this.mSL++;
                        } catch (Exception e3) {
                            e = e3;
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                            this.mSN++;
                        }
                    } catch (Throwable e22) {
                        th = e22;
                        i = i2;
                        e = th;
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                        this.mSN++;
                    }
                }
            }
            i3.close();
            a.this.mSp.commit();
            BL("buildWXContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Cursor i4 = a.this.mtW.i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[]{Long.toString(this.mSJ)});
            i = 50;
            while (i4.moveToNext()) {
                if (Thread.interrupted()) {
                    i4.close();
                    a.this.mSp.commit();
                    throw new InterruptedException();
                }
                this.mSJ = i4.getLong(0);
                String string2 = i4.getString(1);
                if (!this.mSG.remove(string2)) {
                    CharSequence string3 = i4.getString(2);
                    byte[] blob = i4.getBlob(3);
                    try {
                        String[] split = com.tencent.mm.plugin.fts.a.c.a.mQh.split(string3);
                        Arrays.sort(split, new Comparator<String>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                            }
                        });
                        i2 = a.this.j(string2, split) + i;
                        try {
                            i2 += a.this.a(string2, (x) this.mSH.get(string2), split, blob, this.mSH);
                            this.mSK++;
                            i = i2;
                        } catch (Exception e4) {
                            e22 = e4;
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e22, "Build contact index failed with exception.\n", new Object[0]);
                            this.mSN++;
                            i = i2;
                            if (i < 50) {
                                a.this.mSp.commit();
                                a.this.mSp.beginTransaction();
                                i = 0;
                            }
                        }
                    } catch (Throwable e5) {
                        th = e5;
                        i2 = i;
                        e22 = th;
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e22, "Build contact index failed with exception.\n", new Object[0]);
                        this.mSN++;
                        i = i2;
                        if (i < 50) {
                            a.this.mSp.commit();
                            a.this.mSp.beginTransaction();
                            i = 0;
                        }
                    }
                    if (i < 50) {
                        a.this.mSp.commit();
                        a.this.mSp.beginTransaction();
                        i = 0;
                    }
                }
            }
            i4.close();
            a.this.mSp.commit();
            BL("buildChatroomContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            this.mSM = this.mSG.size();
            Iterator it2 = this.mSG.iterator();
            while (it2.hasNext()) {
                str = (String) it2.next();
                a.this.mSp.a(com.tencent.mm.plugin.fts.a.c.mPT, str);
                ((PluginFTS) com.tencent.mm.kernel.g.k(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.mPT, str);
            }
            this.mSG.clear();
            this.mSH.clear();
            BL("deleteUnusedContact");
            ((PluginFTS) com.tencent.mm.kernel.g.k(PluginFTS.class)).setFTSIndexReady(true);
            return true;
        }

        public final String adF() {
            return String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, fail: %d}", new Object[]{Integer.valueOf(this.mSQ), Integer.valueOf(this.mSL), Integer.valueOf(this.mSK), Integer.valueOf(this.mSM), Integer.valueOf(this.mSO), Integer.valueOf(this.mSP), Integer.valueOf(this.mSN)});
        }

        public final String getName() {
            return "BuildContactIndexTask";
        }

        public final int getId() {
            return 1;
        }
    }

    private class k extends com.tencent.mm.plugin.fts.a.a.f {
        public k(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            super.a(hVar);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            String str = this.mRy.fEe;
            String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[]{a.aNy()});
            Cursor rawQuery = a.mPC.rawQuery(format, new String[]{str});
            hVar.mRN = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.mRd = rawQuery.getString(0);
                hVar.mRN.add(jVar);
            }
            rawQuery.close();
            hVar.bjW = 0;
        }

        public final String getName() {
            return "SearchChatroomByMemberTask";
        }
    }

    public class p extends com.tencent.mm.plugin.fts.a.a.f {
        public p(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            long longValue = Long.valueOf(this.mRy.fEe).longValue();
            Cursor rawQuery = r2.mPC.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[]{a.this.mSp.aNy(), Long.valueOf(longValue), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)}), null);
            hVar.mRN = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.mRd = rawQuery.getString(0);
                hVar.mRN.add(jVar);
            }
            rawQuery.close();
        }

        public final String getName() {
            return "SearchContactSmallerTimestampTask";
        }
    }

    private class q extends com.tencent.mm.plugin.fts.a.a.f {
        public q(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            com.tencent.mm.plugin.fts.a.a.e eVar = hVar.mRM;
            int[] iArr = this.mRy.mRF;
            String aNE = eVar.aNE();
            String str = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + com.tencent.mm.plugin.fts.a.d.i(iArr);
            long size = (long) eVar.mRp.size();
            Cursor rawQuery = a.mPC.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + " AND status >= 0 ORDER BY subtype;", new Object[]{a.aNy(), a.aNz(), Long.valueOf(size), a.aNy(), a.aNz(), a.aNy(), a.aNz(), a.aNz(), aNE}), null);
            List<com.tencent.mm.plugin.fts.a.a.k> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mRy.mRI);
            int i = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(3))) {
                    com.tencent.mm.plugin.fts.a.a.k h = new com.tencent.mm.plugin.fts.a.a.k().h(rawQuery);
                    if (i < h.mRc) {
                        if (arrayList.size() > this.mRy.mRH) {
                            break;
                        }
                        i = h.mRc;
                        arrayList.add(h);
                    } else {
                        arrayList.add(h);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.mRy.fEe);
                    }
                }
            }
            rawQuery.close();
            hVar.mRN = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.k kVar : arrayList) {
                kVar.aNF();
                kVar.a(hVar.mRM);
                hVar.mRN.add(kVar);
            }
            if (this.mRy.mRJ != null) {
                Collections.sort(hVar.mRN, this.mRy.mRJ);
            }
        }

        public final String getName() {
            return "SearchContactTask";
        }

        public final int getId() {
            return 20;
        }
    }

    private class r extends com.tencent.mm.plugin.fts.a.a.f {
        public r(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            BL("start");
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            com.tencent.mm.plugin.fts.a.a.e eVar = hVar.mRM;
            String aNE = eVar.aNE();
            long currentTimeMillis = System.currentTimeMillis() - 1209600000;
            long size = (long) eVar.mRp.size();
            aNE = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[]{a.aNy(), a.aNz(), Long.valueOf(size), a.aNz(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.aNy(), a.aNz(), a.aNy(), a.aNz(), a.aNz(), aNE});
            Cursor rawQuery = a.mPC.rawQuery(aNE, new String[]{eVar.mRm});
            List<com.tencent.mm.plugin.fts.a.a.k> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mRy.mRI);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.k g = new com.tencent.mm.plugin.fts.a.a.k().g(rawQuery);
                if (hashSet.add(g.mRd)) {
                    if (arrayList.size() > this.mRy.mRH) {
                        break;
                    }
                    arrayList.add(g);
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.mRy.fEe);
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            BL("orm");
            hVar.mRN = new ArrayList(arrayList.size());
            for (com.tencent.mm.plugin.fts.a.a.k kVar : arrayList) {
                kVar.aNF();
                kVar.a(hVar.mRM);
                hVar.mRN.add(kVar);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.mRy.mRJ != null) {
                Collections.sort(hVar.mRN, this.mRy.mRJ);
            }
            BL("calOffsets");
            if (hVar.mRM.mRp.size() > 1 && a.this.mSp.b(hVar.mRM)) {
                com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.mRd = "create_chatroom​";
                if (hVar.mRN.size() > 3) {
                    hVar.mRN.add(3, jVar);
                } else {
                    hVar.mRN.add(jVar);
                }
            }
            BL("checkChatroom");
        }

        public final String getName() {
            return "SearchTopChatroomInnerRankTask";
        }

        public final int getId() {
            return 25;
        }
    }

    private class m extends com.tencent.mm.plugin.fts.a.a.f {
        public m(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            super.a(hVar);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            String str = this.mRy.mRD;
            String u = com.tencent.mm.plugin.fts.a.d.u(hVar.mRM.mRn);
            Cursor rawQuery = a.mPC.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[]{a.aNz(), a.aNy(), a.aNz(), a.aNz(), u}), new String[]{str, u});
            HashSet hashSet = new HashSet();
            hVar.mRN = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.mRd = rawQuery.getString(0);
                if (hashSet.add(jVar.mRd)) {
                    hVar.mRN.add(jVar);
                }
            }
            rawQuery.close();
            hVar.bjW = 0;
        }

        public final String getName() {
            return "SearchChatroomInMemberTask";
        }
    }

    private class n extends com.tencent.mm.plugin.fts.a.a.f {
        public n(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            com.tencent.mm.plugin.fts.a.a.j jVar;
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            Cursor a = a.this.mSp.a(hVar.mRM, new int[]{131075}, null, true, true);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.k h = new com.tencent.mm.plugin.fts.a.a.k().h(a);
                if (!this.mRy.mRI.contains(h.mRd)) {
                    jVar = (com.tencent.mm.plugin.fts.a.a.j) hashMap.get(h.mRd);
                    if (jVar == null || com.tencent.mm.plugin.fts.a.d.c(com.tencent.mm.plugin.fts.a.c.mQe, h.mRc, jVar.mRc) < 0) {
                        hashMap.put(h.mRd, h);
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.k kVar : hashMap.values()) {
                kVar.aNF();
                kVar.a(hVar.mRM);
                arrayList.add(kVar);
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
            if (this.mRy.mRJ != null) {
                Collections.sort(arrayList, this.mRy.mRJ);
            }
            hVar.mRN = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                jVar = (com.tencent.mm.plugin.fts.a.a.j) arrayList.get(i);
                stringBuffer.append(jVar.mRi);
                stringBuffer.append("|");
                stringBuffer.append(jVar.timestamp);
                stringBuffer.append(" ");
                hVar.mRN.add(jVar);
                if (i >= this.mRy.mRH) {
                    break;
                }
            }
            if (hVar.mRM.mRp.size() > 1 && a.this.mSp.b(hVar.mRM)) {
                jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.mRd = "create_chatroom​";
                hVar.mRN.add(0, jVar);
                stringBuffer.append(" needCreateChatroom");
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", stringBuffer.toString());
        }

        public final String getName() {
            return "SearchChatroomTask";
        }

        public final int getId() {
            return 19;
        }
    }

    public class o extends com.tencent.mm.plugin.fts.a.a.f {
        public o(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            List F = bi.F(this.mRy.fEe.split(","));
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("member IN (");
            for (int i = 0; i < F.size(); i++) {
                stringBuffer.append("'");
                stringBuffer.append((String) F.get(i));
                stringBuffer.append("'");
                if (i != F.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")");
            Cursor rawQuery = a.mPC.rawQuery(String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[]{a.aNy(), stringBuffer.toString()}), null);
            HashMap hashMap = new HashMap();
            while (rawQuery.moveToNext()) {
                List list;
                String string = rawQuery.getString(0);
                if (hashMap.containsKey(string)) {
                    list = (List) hashMap.get(string);
                } else {
                    list = new ArrayList();
                }
                com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                jVar.mRd = rawQuery.getString(1);
                jVar.mRQ = rawQuery.getLong(2);
                list.add(jVar);
                hashMap.put(string, list);
            }
            rawQuery.close();
            hVar.mRN = new ArrayList();
            com.tencent.mm.plugin.fts.a.a.j jVar2 = new com.tencent.mm.plugin.fts.a.a.j();
            jVar2.userData = hashMap;
            hVar.mRN.add(jVar2);
        }

        public final String getName() {
            return "SearchCommonChatroomTask";
        }
    }

    private class t extends com.tencent.mm.plugin.fts.a.a.f {
        public t(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            int i = 0;
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            com.tencent.mm.plugin.fts.a.a.e eVar = hVar.mRM;
            String aNE = eVar.aNE();
            long size = (long) eVar.mRp.size();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            Cursor rawQuery = a.mPC.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[]{a.aNy(), a.aNz(), Long.valueOf(size), Long.valueOf(currentTimeMillis), a.aNy(), a.aNz(), a.aNy(), a.aNz(), a.aNz(), aNE}), null);
            List<com.tencent.mm.plugin.fts.a.a.k> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mRy.mRI);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.k h = new com.tencent.mm.plugin.fts.a.a.k().h(rawQuery);
                if (hashSet.add(h.mRd)) {
                    if (i < h.mRc) {
                        if (arrayList.size() > this.mRy.mRH) {
                            break;
                        }
                        i = h.mRc;
                        arrayList.add(h);
                    } else {
                        arrayList.add(h);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.mRy.fEe);
                    }
                }
            }
            rawQuery.close();
            hVar.mRN = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.k kVar : arrayList) {
                kVar.aNF();
                kVar.a(hVar.mRM);
                hVar.mRN.add(kVar);
            }
            if (this.mRy.mRJ != null) {
                Collections.sort(hVar.mRN, this.mRy.mRJ);
            }
        }

        public final String getName() {
            return "SearchTopContactTask";
        }

        public final int getId() {
            return 22;
        }
    }

    private class h extends com.tencent.mm.plugin.fts.a.a.a {
        private String gBJ;
        private boolean gLn = false;
        private boolean mSY = false;

        public h(String str) {
            this.gBJ = str;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", this.gBJ);
            if (a.this.mSr.containsKey(this.gBJ)) {
                this.mSY = true;
            } else {
                a.this.mSp.BF(this.gBJ);
                List b = a.this.mSp.b(com.tencent.mm.plugin.fts.a.c.mPT, this.gBJ);
                a.this.mSr.put(this.gBJ, b);
                if (b.isEmpty()) {
                    this.gLn = true;
                    a.this.gKV.a(65556, new e(this.gBJ));
                } else {
                    Cursor BT = a.this.mSp.BT(this.gBJ);
                    HashSet hashSet = new HashSet();
                    while (BT.moveToNext()) {
                        hashSet.add(BT.getString(0));
                    }
                    BT.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        a.this.mSp.BF(str);
                        if (!a.this.mSr.containsKey(str)) {
                            a.this.mSr.put(str, a.this.mSp.b(com.tencent.mm.plugin.fts.a.c.mPT, str));
                        }
                    }
                    a.this.mSq.remove(this.gBJ);
                    ((PluginFTS) com.tencent.mm.kernel.g.k(PluginFTS.class)).getTopHitsLogic().BR(this.gBJ);
                }
            }
            return true;
        }

        public final String adF() {
            return String.format("{username: %s cached: %b isSkipped: %b}", new Object[]{this.gBJ, Boolean.valueOf(this.mSY), Boolean.valueOf(this.gLn)});
        }

        public final String getName() {
            return "MarkContactDirtyTask";
        }

        public final int getId() {
            return 17;
        }
    }

    private class u extends com.tencent.mm.plugin.fts.a.a.a {
        private int mTa;
        private int mTb;
        private int mTc;

        private u() {
            this.mTa = 0;
            this.mTb = 0;
            this.mTc = 0;
        }

        /* synthetic */ u(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            String str;
            int i;
            BL("start");
            Iterator it = a.this.mSr.entrySet().iterator();
            int i2 = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    a.this.mSp.commit();
                    throw new InterruptedException();
                }
                int i3;
                if (i2 >= 50) {
                    a.this.mSp.commit();
                    a.this.mSp.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Entry entry = (Entry) it.next();
                for (Long longValue : (List) entry.getValue()) {
                    a.this.mSp.g(Long.valueOf(longValue.longValue()));
                    i3++;
                }
                str = (String) entry.getKey();
                ag BB = a.this.mtW.BB(str);
                if (BB != null && BB.field_username.length() > 0 && a.this.D(BB)) {
                    i3 += a.this.E(BB);
                }
                i = i3;
                it.remove();
                a.this.mSq.remove(str);
                this.mTa++;
                i2 = i;
            }
            BL("dirtyContact");
            Iterator it2 = a.this.mSq.iterator();
            while (it2.hasNext()) {
                if (Thread.interrupted()) {
                    a.this.mSp.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    a.this.mSp.commit();
                    a.this.mSp.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                str = (String) it2.next();
                long BD = a.this.mtW.BD(str);
                ag BB2 = a.this.mtW.BB(str);
                if (BB2 == null || BB2.field_username.length() <= 0 || !a.this.D(BB2)) {
                    i2 = i;
                } else {
                    a.this.mSp.C(str, BD);
                    i2 = i + 1;
                }
                it2.remove();
                this.mTb++;
            }
            a.this.mSp.commit();
            BL("timestampContact");
            e topHitsLogic = ((PluginFTS) com.tencent.mm.kernel.g.k(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mTK.clear();
            this.mTc = topHitsLogic.mTJ.aNS();
            BL("topHits");
            return true;
        }

        public final String adF() {
            return String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[]{Integer.valueOf(this.mTa), Integer.valueOf(this.mTb), Integer.valueOf(this.mTc)});
        }

        public final String getName() {
            return "UpdateDirtyAndTimestampContactTask";
        }

        public final int getId() {
            return 16;
        }
    }

    private class v extends com.tencent.mm.plugin.fts.a.a.a {
        private long mTd;
        private int mTe = 0;

        public v(long j) {
            this.mTd = j;
        }

        public final boolean execute() {
            ArrayList arrayList = new ArrayList(32);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            long j = this.mTd;
            Cursor rawQuery = a.mPC.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!a.this.mSr.containsKey(str)) {
                    a.this.mSr.put(str, a.this.mSp.b(com.tencent.mm.plugin.fts.a.c.mPU, str));
                }
            }
            return true;
        }

        public final String adF() {
            return String.format("{mLabelId: %d mContactCount: %d}", new Object[]{Long.valueOf(this.mTd), Integer.valueOf(this.mTe)});
        }

        public final String getName() {
            return "UpdateLabelTask";
        }
    }

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int mud;
        private int mue;

        private a() {
            this.mud = 0;
            this.mue = 0;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = a.this.mSp.mPC.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor i = a.this.mtW.i("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i2 = 5;
            while (i.moveToNext()) {
                if (Thread.interrupted()) {
                    i.close();
                    a.this.mSp.commit();
                    throw new InterruptedException();
                }
                String string = i.getString(0);
                Object split = com.tencent.mm.plugin.fts.a.c.a.mQh.split(i.getString(1));
                a.this.mSs.put(string, split);
                if (!hashSet.remove(string)) {
                    if (i2 >= 5) {
                        a.this.mSp.commit();
                        a.this.mSp.beginTransaction();
                        i2 = 0;
                    }
                    a.this.mSp.k(string, split);
                    i2++;
                    this.mud++;
                }
            }
            i.close();
            a.this.mSp.commit();
            Iterator it = hashSet.iterator();
            int i3 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i3 >= 5) {
                    a.this.mSp.commit();
                    a.this.mSp.beginTransaction();
                    i3 = 0;
                }
                a.this.mSp.BU(str);
                i2 = i3 + 1;
                this.mue++;
                i3 = i2;
            }
            a.this.mSp.commit();
            return true;
        }

        public final String getName() {
            return "BuildChatroomIndexTask";
        }

        public final String adF() {
            return String.format("{new: %d removed: %d}", new Object[]{Integer.valueOf(this.mud), Integer.valueOf(this.mue)});
        }

        public final int getId() {
            return 3;
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            a.this.mSp.h(com.tencent.mm.plugin.fts.a.c.mPR);
            return true;
        }

        public final String getName() {
            return "DeleteAllFriendTask";
        }
    }

    private class e extends com.tencent.mm.plugin.fts.a.a.a {
        private String gBJ;
        private boolean gLn = false;

        public e(String str) {
            this.gBJ = str;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", this.gBJ);
            ag BB = a.this.mtW.BB(this.gBJ);
            if (BB == null || BB.field_username.length() <= 0 || !a.this.D(BB)) {
                this.gLn = true;
            } else {
                a.this.E(BB);
            }
            a.this.mSr.remove(this.gBJ);
            a.this.mSq.remove(this.gBJ);
            return true;
        }

        public final String adF() {
            return String.format("{username: %s isSkipped: %b}", new Object[]{this.gBJ, Boolean.valueOf(this.gLn)});
        }

        public final String getName() {
            return "InsertContactTask";
        }
    }

    private class j extends com.tencent.mm.plugin.fts.a.a.f {
        public j(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            Cursor a = a.this.mSp.a(hVar.mRM, this.mRy.mRF, this.mRy.mRG, true, true);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.k h = new com.tencent.mm.plugin.fts.a.a.k().h(a);
                if (!this.mRy.mRI.contains(h.mRd)) {
                    com.tencent.mm.plugin.fts.a.a.j jVar;
                    if (com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mPT, h.type)) {
                        jVar = (com.tencent.mm.plugin.fts.a.a.j) hashMap.get(h.mRd);
                        if (jVar == null || com.tencent.mm.plugin.fts.a.d.c(com.tencent.mm.plugin.fts.a.c.mQe, h.mRc, jVar.mRc) < 0) {
                            hashMap.put(h.mRd, h);
                        }
                    } else if (com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mPV, h.type)) {
                        jVar = (com.tencent.mm.plugin.fts.a.a.j) hashMap2.get(Long.valueOf(h.mRQ));
                        if (jVar == null || com.tencent.mm.plugin.fts.a.d.c(com.tencent.mm.plugin.fts.a.c.mQe, h.mRc, jVar.mRc) < 0) {
                            hashMap2.put(Long.valueOf(h.mRQ), h);
                        }
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            hVar.mRN = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.k kVar : hashMap.values()) {
                kVar.aNF();
                kVar.a(hVar.mRM);
                hVar.mRN.add(kVar);
            }
            hVar.mRN.addAll(hashMap2.values());
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.mRy.mRJ != null) {
                Collections.sort(hVar.mRN, this.mRy.mRJ);
            }
        }

        public final String getName() {
            return "SearchContactLogic.SearchTask";
        }

        public final int getId() {
            return 11;
        }
    }

    private class l extends com.tencent.mm.plugin.fts.a.a.f {
        public l(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            int i = 0;
            super.a(hVar);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            String str = this.mRy.fEe;
            Cursor rawQuery = a.mPC.rawQuery("SELECT count(*) FROM FTS5ChatRoomMembers WHERE member=?", new String[]{str});
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
            jVar.userData = Integer.valueOf(i);
            hVar.mRN = new ArrayList();
            hVar.mRN.add(jVar);
        }

        public final String getName() {
            return "SearchChatroomCountTask";
        }
    }

    private class s extends com.tencent.mm.plugin.fts.a.a.f {
        public s(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar) {
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            com.tencent.mm.plugin.fts.a.a a = a.this.mSp;
            com.tencent.mm.plugin.fts.a.a.e eVar = hVar.mRM;
            int[] iArr = this.mRy.mRF;
            String aNE = eVar.aNE();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            long size = (long) eVar.mRp.size();
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + com.tencent.mm.plugin.fts.a.d.i(iArr) + " ORDER BY Rank ;", new Object[]{a.aNy(), a.aNz(), Long.valueOf(size), a.aNz(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.aNy(), a.aNz(), a.aNy(), a.aNz(), a.aNz(), aNE});
            Cursor rawQuery = a.mPC.rawQuery(format, new String[]{eVar.mRm});
            List<com.tencent.mm.plugin.fts.a.a.k> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mRy.mRI);
            long j = 0;
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.k g = new com.tencent.mm.plugin.fts.a.a.k().g(rawQuery);
                if (hashSet.add(g.mRd)) {
                    if (j < g.mRY) {
                        if (arrayList.size() > this.mRy.mRH) {
                            break;
                        }
                        j = g.mRY;
                        arrayList.add(g);
                    } else {
                        arrayList.add(g);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.mRy.fEe);
                    }
                }
            }
            rawQuery.close();
            hVar.mRN = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.k kVar : arrayList) {
                kVar.aNF();
                kVar.a(hVar.mRM);
                hVar.mRN.add(kVar);
            }
            if (this.mRy.mRJ != null) {
                Collections.sort(hVar.mRN, this.mRy.mRJ);
            }
        }

        public final String getName() {
            return "SearchTopContactInnerRankTask";
        }

        public final int getId() {
            return 26;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        com.tencent.mm.plugin.fts.a.a.a lVar;
        switch (gVar.mRC) {
            case 5:
                lVar = new l(gVar);
                break;
            case 6:
                lVar = new k(gVar);
                break;
            case 7:
                lVar = new m(gVar);
                break;
            case 8:
                lVar = new o(gVar);
                break;
            case 9:
                lVar = new p(gVar);
                break;
            case 16:
                lVar = new q(gVar);
                break;
            case 32:
                lVar = new n(gVar);
                break;
            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                lVar = new t(gVar);
                break;
            case 64:
                lVar = new s(gVar);
                break;
            case 96:
                lVar = new r(gVar);
                break;
            default:
                lVar = new j(gVar);
                break;
        }
        return this.gKV.a(-65536, lVar);
    }

    protected final boolean onCreate() {
        if (((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).isFTSContextReady()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
            this.mSp = (com.tencent.mm.plugin.fts.c.a) ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSIndexStorage(3);
            this.gKV = ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon();
            this.mtW = ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSMainDB();
            this.mSq = new HashSet();
            this.mSr = new HashMap();
            this.mSs = new HashMap();
            this.mSt = new HashMap();
            try {
                this.mSu = ag.class.getDeclaredMethod("wa", new Class[0]);
                this.mSu.setAccessible(true);
                this.gKV.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new f());
                this.gKV.a(131082, new a());
                this.gKV.a(131092, new b());
                this.gKV.a(Integer.MAX_VALUE, new c());
                ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo().c(this.mSx);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().a(this.mSw);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().a(this.mSv);
                com.tencent.mm.sdk.e.j.a aVar = this.mSy;
                if (com.tencent.mm.ar.b.hGj != null) {
                    com.tencent.mm.ar.b.hGj.a(aVar);
                }
                this.mSB.K(600000, 600000);
                this.mSz.cfB();
                this.mSA.cfB();
                return true;
            } catch (Throwable e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                throw assertionFailedError;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
        return false;
    }

    protected final boolean Bg() {
        this.mSz.dead();
        this.mSA.dead();
        this.mSC.TN();
        this.mSB.TN();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().b(this.mSw);
        ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo().j(this.mSx);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().b(this.mSv);
        com.tencent.mm.sdk.e.j.a aVar = this.mSy;
        if (com.tencent.mm.ar.b.hGj != null) {
            com.tencent.mm.ar.b.hGj.b(aVar);
        }
        if (this.mSr != null) {
            this.mSr.clear();
        }
        if (this.mSq != null) {
            this.mSq.clear();
        }
        this.mSp = null;
        this.gKV = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    final int a(String str, x xVar, String[] strArr, byte[] bArr, HashMap<String, x> hashMap) {
        int i = 0;
        String str2 = xVar.field_nickname;
        String am = com.tencent.mm.plugin.fts.a.d.am(str2, false);
        String am2 = com.tencent.mm.plugin.fts.a.d.am(str2, true);
        long j = 0;
        long BD = this.mtW.BD(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            com.tencent.mm.h.a.a.a aVar = new com.tencent.mm.h.a.a.a();
            try {
                aVar.aH(bArr);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "parse chatroom data", new Object[0]);
            }
            Iterator it = aVar.gDp.iterator();
            while (it.hasNext()) {
                com.tencent.mm.h.a.a.b bVar = (com.tencent.mm.h.a.a.b) it.next();
                if (!bi.oN(bVar.gDt)) {
                    hashMap2.put(bVar.userName, bVar.gDt);
                }
            }
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                String str3 = strArr[i3];
                x xVar2 = (x) hashMap.get(str3);
                if (xVar2 != null) {
                    String str4 = xVar2.field_conRemark;
                    String str5 = xVar2.field_nickname;
                    String am3 = com.tencent.mm.plugin.fts.a.d.am(str4, false);
                    String am4 = com.tencent.mm.plugin.fts.a.d.am(str4, true);
                    stringBuffer.append(bi.aD(str4, " ")).append("‌");
                    stringBuffer.append(bi.aD(am3, " ")).append("‌");
                    stringBuffer.append(bi.aD(am4, " ")).append("‌");
                    str4 = com.tencent.mm.plugin.fts.a.d.am(str5, false);
                    am3 = com.tencent.mm.plugin.fts.a.d.am(str5, true);
                    stringBuffer.append(bi.aD(str5, " ")).append("‌");
                    stringBuffer.append(bi.aD(str4, " ")).append("‌");
                    stringBuffer.append(bi.aD(am3, " ")).append("‌");
                    stringBuffer.append(bi.aD((String) hashMap2.get(str3), " ")).append("‌");
                    B(xVar2);
                    stringBuffer.append(bi.aD(xVar2.fXt, " ")).append("‌");
                    stringBuffer.append(bi.aD(com.tencent.mm.plugin.fts.a.d.cL(str3, xVar2.vU()), " ")).append("‌");
                    stringBuffer.append("​");
                }
                i2 = i3 + 1;
            }
        }
        if (!bi.oN(str2)) {
            this.mSp.a(131075, 5, j, str, BD, str2);
            if (bi.oN(am)) {
                i = 1;
            } else {
                this.mSp.a(131075, 6, j, str, BD, am);
                i = 2;
            }
            if (!bi.oN(am2)) {
                this.mSp.a(131075, 7, j, str, BD, am2);
                i++;
            }
        }
        if (stringBuffer.length() <= 0) {
            return i;
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        this.mSp.a(131075, 38, j, str, BD, stringBuffer.toString());
        return i + 1;
    }

    public final int j(String str, String[] strArr) {
        int i = 0;
        String[] strArr2 = (String[]) this.mSs.get(str);
        this.mSp.beginTransaction();
        if (strArr2 == null) {
            this.mSp.BU(str);
            i = ((int) this.mSp.mUb.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.mSp.k(str, strArr);
                this.mSs.put(str, strArr);
                i += strArr.length;
            }
        } else if (strArr == null) {
            this.mSp.BU(str);
            i = ((int) this.mSp.mUb.simpleQueryForLong()) + 0;
            this.mSs.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int length = strArr.length;
            int i2 = 0;
            while (i < length) {
                String str2 = strArr[i];
                if (!hashSet.remove(str2)) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.mSp;
                    aVar.mTV.bindString(1, str);
                    aVar.mTV.bindString(2, str2);
                    aVar.mTV.execute();
                    i2++;
                }
                i++;
            }
            Iterator it = hashSet.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                String str3 = (String) it.next();
                com.tencent.mm.plugin.fts.c.a aVar2 = this.mSp;
                aVar2.mTW.bindString(1, str);
                aVar2.mTW.bindString(2, str3);
                aVar2.mTW.execute();
                i2 = i + 1;
            }
            this.mSs.put(str, strArr);
        }
        this.mSp.commit();
        return i;
    }

    final void B(x xVar) {
        try {
            this.mSu.invoke(xVar, new Object[0]);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
        }
    }

    static boolean BP(String str) {
        if (bi.oN(str) || str.endsWith("@stranger") || str.endsWith("@qqim") || str.endsWith("@app") || str.startsWith("fake_")) {
            return false;
        }
        return true;
    }

    static boolean C(x xVar) {
        if ((xVar.isHidden() && !"notifymessage".equals(xVar.field_username)) || xVar.AM() || xVar.field_deleteFlag != 0) {
            return false;
        }
        if (com.tencent.mm.k.a.ga(xVar.field_type) || (!xVar.AL() && !xVar.ciN())) {
            return true;
        }
        return false;
    }

    final boolean D(x xVar) {
        String str = xVar.field_username;
        if (!C(xVar) || !BP(str)) {
            return false;
        }
        if (com.tencent.mm.k.a.ga(xVar.field_type)) {
            return true;
        }
        if (xVar.AL() || xVar.ciN() || !this.mtW.BC(str)) {
            return false;
        }
        return true;
    }

    final int E(x xVar) {
        if (!com.tencent.mm.y.s.eX(xVar.field_username)) {
            return F(xVar);
        }
        String format = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[]{"chatroom"});
        Cursor i = this.mtW.i(format, new String[]{xVar.field_username});
        try {
            CharSequence string;
            byte[] blob;
            if (i.moveToNext()) {
                string = i.getString(0);
                blob = i.getBlob(1);
            } else {
                blob = null;
                string = null;
            }
            if (i != null) {
                i.close();
            }
            if (bi.oN(string) || blob == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", xVar.field_username);
                if (j(xVar.field_username, null) <= 0) {
                    return 0;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", xVar.field_username, Integer.valueOf(j(xVar.field_username, null)));
                return 0;
            }
            String[] split = com.tencent.mm.plugin.fts.a.c.a.mQh.split(string);
            Arrays.sort(split, new Comparator<String>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                }
            });
            if (j(xVar.field_username, split) > 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", xVar.field_username, Integer.valueOf(j(xVar.field_username, split)));
            }
            HashMap hashMap = new HashMap();
            Cursor i2 = this.mtW.i("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + com.tencent.mm.plugin.fts.a.d.v(split) + ";", null);
            while (i2.moveToNext()) {
                try {
                    ag xVar2 = new x();
                    xVar2.gKO = i2.getLong(0);
                    xVar2.setUsername(i2.getString(1));
                    xVar2.cZ(i2.getString(2));
                    xVar2.da(i2.getString(3));
                    xVar2.dc(i2.getString(4));
                    xVar2.z(i2.getBlob(5));
                    hashMap.put(xVar2.field_username, xVar2);
                } finally {
                    if (i2 != null) {
                        i2.close();
                    }
                }
            }
            return a(xVar.field_username, xVar, split, blob, hashMap);
        } catch (Throwable th) {
            if (i != null) {
                i.close();
            }
        }
    }

    final int F(x xVar) {
        int i;
        String d;
        int i2;
        int i3;
        int i4;
        String str;
        long j = xVar.gKO;
        String str2 = xVar.field_username;
        String vU = xVar.vU();
        String str3 = xVar.field_nickname;
        String am = com.tencent.mm.plugin.fts.a.d.am(str3, false);
        String am2 = com.tencent.mm.plugin.fts.a.d.am(str3, true);
        String str4 = xVar.field_conRemark;
        String am3 = com.tencent.mm.plugin.fts.a.d.am(str4, false);
        String am4 = com.tencent.mm.plugin.fts.a.d.am(str4, true);
        String str5 = xVar.fXt;
        String str6 = xVar.field_contactLabelIds;
        String str7 = xVar.fXz;
        int i5 = xVar.field_verifyFlag;
        String str8 = "";
        long currentTimeMillis = System.currentTimeMillis();
        if ((i5 & x.ciP()) != 0) {
            i = 0;
            d = bi.d(((com.tencent.mm.api.h) com.tencent.mm.kernel.g.h(com.tencent.mm.api.h.class)).cd(str2), "​");
            i2 = 131076;
        } else if (x.Xg(str2)) {
            d = str8;
            i = 0;
            i2 = 131081;
        } else {
            currentTimeMillis = this.mtW.BD(str2);
            if (str6 == null || str6.length() <= 0) {
                i2 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                d = str8;
                i = 0;
            } else {
                if (str6 != null) {
                    Object substring;
                    if (str6.endsWith("\u0000")) {
                        substring = str6.substring(0, str6.length() - 1);
                    } else {
                        String substring2 = str6;
                    }
                    if (substring2.length() == 0) {
                        i3 = 0;
                    } else {
                        List arrayList;
                        String[] split = com.tencent.mm.plugin.fts.a.c.a.mQo.split(substring2);
                        List list;
                        if (split.length != 0) {
                            arrayList = new ArrayList(split.length);
                            for (String str9 : split) {
                                arrayList.add(Long.valueOf(bi.getLong(str9, 0)));
                            }
                            list = arrayList;
                        } else {
                            list = null;
                        }
                        arrayList = (List) this.mSt.get(str2);
                        if (arrayList == null) {
                            this.mSp.BS(str2);
                            if (!(list == null || list.isEmpty())) {
                                this.mSp.g(str2, list);
                                this.mSt.put(str2, list);
                            }
                        } else if (list == null || list.isEmpty()) {
                            this.mSp.BS(str2);
                            this.mSt.remove(str2);
                        } else {
                            com.tencent.mm.plugin.fts.c.a aVar;
                            HashSet hashSet = new HashSet(arrayList);
                            for (Long longValue : list) {
                                long longValue2 = longValue.longValue();
                                if (!hashSet.remove(Long.valueOf(longValue2))) {
                                    aVar = this.mSp;
                                    aVar.mTY.bindString(1, str2);
                                    aVar.mTY.bindLong(2, longValue2);
                                    aVar.mTY.execute();
                                }
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                long longValue3 = ((Long) it.next()).longValue();
                                aVar = this.mSp;
                                aVar.mTZ.bindString(1, str2);
                                aVar.mTZ.bindLong(2, longValue3);
                                aVar.mTZ.execute();
                            }
                            this.mSt.put(str2, list);
                        }
                        arrayList = this.mtW.BE(substring2);
                        if (arrayList.size() == 0) {
                            i3 = 0;
                        } else {
                            this.mSp.a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 11, j, str2, currentTimeMillis, bi.d(arrayList, "​"));
                            i3 = 1;
                        }
                    }
                } else {
                    i3 = 0;
                }
                i2 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                d = str8;
                i = i3 + 0;
            }
        }
        String cL = com.tencent.mm.plugin.fts.a.d.cL(str2, vU);
        if (cL == null || cL.length() == 0) {
            i4 = i;
        } else {
            this.mSp.a(i2, 15, j, str2, currentTimeMillis, cL);
            i4 = i + 1;
        }
        if (str4 == null || str4.length() == 0) {
            am4 = null;
            cL = str3;
            str3 = null;
            str = am;
            str6 = am2;
            am2 = null;
        } else {
            str6 = am4;
            str = am3;
            cL = str4;
            am4 = am2;
            am2 = am;
        }
        if (!(cL == null || cL.length() == 0)) {
            if (cL.equalsIgnoreCase(str)) {
                am3 = null;
            } else {
                am3 = str;
            }
            if (am3 == null || am3.length() == 0 || am3.equalsIgnoreCase(str6)) {
                str8 = null;
            } else {
                str8 = str6;
            }
            this.mSp.a(i2, 1, j, str2, currentTimeMillis, cL);
            if (!(am3 == null || am3.length() == 0)) {
                this.mSp.a(i2, 2, j, str2, currentTimeMillis, am3);
            }
            if (!(str8 == null || str8.length() == 0)) {
                this.mSp.a(i2, 3, j, str2, currentTimeMillis, str8);
            }
            i4 += 3;
        }
        if (str3 == null || str3.length() == 0) {
            i = i4;
        } else {
            if (str3.equalsIgnoreCase(am2)) {
                am2 = null;
            }
            if (am2 == null || am2.length() == 0 || am2.equalsIgnoreCase(am4)) {
                str8 = null;
            } else {
                str8 = am4;
            }
            this.mSp.a(i2, 5, j, str2, currentTimeMillis, str3);
            if (!(am2 == null || am2.length() == 0)) {
                this.mSp.a(i2, 6, j, str2, currentTimeMillis, am2);
            }
            if (!(str8 == null || str8.length() == 0)) {
                this.mSp.a(i2, 7, j, str2, currentTimeMillis, str8);
            }
            i = i4 + 3;
        }
        if (str5 != null && str5.length() > 0) {
            this.mSp.a(i2, 4, j, str2, currentTimeMillis, str5);
            i++;
        }
        if (i2 == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (bi.oN(str7)) {
                Cursor i6 = this.mtW.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str2});
                if (i6.moveToFirst()) {
                    this.mSp.a(i2, 16, j, str2, currentTimeMillis, i6.getString(0));
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i6.close();
                i = i3;
            } else {
                this.mSp.a(i2, 16, j, str2, currentTimeMillis, str7.replace(",", "​"));
                i++;
            }
            cL = xVar.getProvince();
            if (mSD.contains(cL)) {
                cL = "";
            }
            if (!(cL == null || cL.length() == 0)) {
                this.mSp.a(i2, 18, j, str2, currentTimeMillis, cL);
                i++;
            }
            cL = xVar.getCity();
            if (!(cL == null || cL.length() == 0)) {
                this.mSp.a(i2, 17, j, str2, currentTimeMillis, cL);
                i++;
            }
        }
        if (i2 == 131076 && !bi.oN(d)) {
            this.mSp.a(i2, 19, j, str2, currentTimeMillis, d);
            i++;
            cL = com.tencent.mm.plugin.fts.a.d.am(d, false);
            if (!bi.oN(cL)) {
                this.mSp.a(i2, 20, j, str2, currentTimeMillis, cL);
                i++;
            }
            cL = com.tencent.mm.plugin.fts.a.d.am(d, true);
            if (!bi.oN(cL)) {
                this.mSp.a(i2, 21, j, str2, currentTimeMillis, cL);
                i3 = i + 1;
                if (i2 != 131081) {
                    return i3 + a(xVar, currentTimeMillis);
                }
                return i3;
            }
        }
        i3 = i;
        if (i2 != 131081) {
            return i3;
        }
        return i3 + a(xVar, currentTimeMillis);
    }

    private int a(x xVar, long j) {
        String str = xVar.fXE;
        if (bi.oN(str)) {
            return 0;
        }
        com.tencent.mm.openim.a.c cVar = new com.tencent.mm.openim.a.c();
        cVar.oz(str);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < cVar.idy.size(); i++) {
            for (com.tencent.mm.openim.a.c.b oA : ((com.tencent.mm.openim.a.c.a) cVar.idy.get(i)).idz) {
                str = oA.oA(xVar.field_openImAppid);
                if (!bi.oN(str)) {
                    stringBuffer.append(str);
                    stringBuffer.append("‌");
                }
            }
            stringBuffer.append("​");
        }
        if (bi.oN(stringBuffer.toString())) {
            return 0;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "buildOpenIMContact %s", stringBuffer.toString());
        this.mSp.a(131081, 51, xVar.gKO, xVar.field_username, j, stringBuffer.toString());
        return 1;
    }

    static {
        String[] split = ad.getContext().getString(com.tencent.mm.plugin.fts.g.a.dXW).split(";");
        if (split != null) {
            for (Object add : split) {
                mSD.add(add);
            }
        }
    }
}
