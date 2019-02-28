package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.sa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gKV;
    private com.tencent.mm.sdk.b.c mSA = new com.tencent.mm.sdk.b.c<sa>() {
        {
            this.xmG = sa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            b.this.gKV.a(65596, new d(b.aNI().getAbsolutePath()));
            return true;
        }
    };
    com.tencent.mm.plugin.fts.c.b mTf;
    private com.tencent.mm.sdk.b.c<bc> mTg = new com.tencent.mm.sdk.b.c<bc>() {
        {
            this.xmG = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bc bcVar = (bc) bVar;
            if (bcVar.fqf.fqg == 35 && bcVar.fqf.fqh == 1) {
                x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", bcVar.fqf.filePath);
                b bVar2 = b.this;
                String str = bcVar.fqf.filePath;
                File file = new File(b.aNH(), "temp");
                if (file.exists()) {
                    FileOp.G(file.getAbsolutePath(), false);
                }
                file.mkdirs();
                x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", str, Integer.valueOf(bi.fz(str, file.getAbsolutePath())));
                if (bi.fz(str, file.getAbsolutePath()) >= 0) {
                    File aNI = b.aNI();
                    File file2 = new File(file, "fts_feature");
                    x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", Integer.valueOf(b.D(file2)), Integer.valueOf(b.D(aNI)));
                    if (b.D(file2) > b.D(aNI)) {
                        FileOp.G(aNI.getAbsolutePath(), false);
                        file2.renameTo(aNI);
                        bVar2.gKV.a(65596, new d(aNI.getAbsolutePath()));
                    }
                }
            }
            return true;
        }
    };

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int mTi;
        private int mTj;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final boolean execute() {
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
            com.tencent.mm.plugin.fts.a.a aVar = b.this.mTf;
            List arrayList = new ArrayList();
            Cursor rawQuery = aVar.mPC.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.c cVar = new com.tencent.mm.plugin.fts.a.a.c();
                cVar.b(rawQuery);
                arrayList.add(cVar);
            }
            rawQuery.close();
            if (arrayList.size() == 0) {
                try {
                    arrayList = b.a(b.this, b.aNI().getAbsolutePath());
                    b.this.mTf.aV(arrayList);
                } catch (Exception e) {
                }
            }
            List<com.tencent.mm.plugin.fts.c.b.a> aNR = b.this.mTf.aNR();
            HashMap hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.c cVar2 : arrayList) {
                hashMap.put(Integer.valueOf(cVar2.field_featureId), cVar2);
            }
            if (b.this.mTf.mPC.inTransaction()) {
                b.this.mTf.commit();
            }
            b.this.mTf.beginTransaction();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (com.tencent.mm.plugin.fts.c.b.a aVar2 : aNR) {
                com.tencent.mm.plugin.fts.a.a.c cVar3 = (com.tencent.mm.plugin.fts.a.a.c) hashMap.remove(Integer.valueOf(aVar2.mUd));
                if (cVar3 == null) {
                    hashSet.add(Integer.valueOf(aVar2.mUd));
                } else if (aVar2.timestamp != cVar3.field_timestamp) {
                    hashSet2.add(cVar3);
                    b.this.mTf.b(com.tencent.mm.plugin.fts.a.c.mPN, Long.valueOf((long) cVar3.field_featureId).longValue());
                    ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.mPN, String.valueOf(cVar3.field_featureId));
                }
            }
            hashSet2.addAll(hashMap.values());
            b.this.mTf.commit();
            b.this.mTf.beginTransaction();
            this.mTi = hashSet.size();
            this.mTj = hashSet2.size();
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.fts.a.a.c cVar4 = (com.tencent.mm.plugin.fts.a.a.c) it.next();
                b bVar = b.this;
                bVar.mTf.a(262144, 1, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_title);
                String am = com.tencent.mm.plugin.fts.a.d.am(cVar4.field_title, false);
                if (!bi.oN(am)) {
                    bVar.mTf.a(262144, 2, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, am);
                }
                am = com.tencent.mm.plugin.fts.a.d.am(cVar4.field_title, true);
                if (!bi.oN(am)) {
                    bVar.mTf.a(262144, 3, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, am);
                }
                bVar.mTf.a(262144, 4, (long) cVar4.field_featureId, String.valueOf(cVar4.field_featureId), cVar4.field_timestamp, cVar4.field_tag);
                ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().BR(String.valueOf(cVar4.field_featureId));
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                b.this.mTf.b(com.tencent.mm.plugin.fts.a.c.mPN, Long.valueOf((long) ((Integer) it2.next()).intValue()).longValue());
            }
            b.this.mTf.commit();
            return true;
        }

        public final String adF() {
            return String.format("{remove: %d add: %d}", new Object[]{Integer.valueOf(this.mTi), Integer.valueOf(this.mTj)});
        }

        public final String getName() {
            return "BuildFeatureIndexTask";
        }

        public final int getId() {
            return 5;
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final boolean execute() {
            Throwable e;
            InputStream inputStream;
            com.tencent.mm.sdk.b.b bcVar;
            OutputStream outputStream = null;
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d", Integer.valueOf(b.D(b.aNI())));
            if (b.D(b.aNI()) < 0) {
                File file = new File(ad.getContext().getCacheDir(), "fts_feature.zip");
                InputStream open;
                try {
                    open = ad.getContext().getAssets().open("fts_feature.zip");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        OutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            e.c(open);
                            e.a(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            outputStream = fileOutputStream;
                            inputStream = open;
                            try {
                                x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                                e.c(inputStream);
                                e.a(outputStream);
                                if (file.exists()) {
                                    bcVar = new bc();
                                    bcVar.fqf.fqg = 35;
                                    bcVar.fqf.fqh = 1;
                                    bcVar.fqf.filePath = file.getAbsolutePath();
                                    com.tencent.mm.sdk.b.a.xmy.a(bcVar, Looper.getMainLooper());
                                }
                                return true;
                            } catch (Throwable th) {
                                e = th;
                                open = inputStream;
                                e.c(open);
                                e.a(outputStream);
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            outputStream = fileOutputStream;
                            e.c(open);
                            e.a(outputStream);
                            throw e;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = open;
                        x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                        e.c(inputStream);
                        e.a(outputStream);
                        if (file.exists()) {
                            bcVar = new bc();
                            bcVar.fqf.fqg = 35;
                            bcVar.fqf.fqh = 1;
                            bcVar.fqf.filePath = file.getAbsolutePath();
                            com.tencent.mm.sdk.b.a.xmy.a(bcVar, Looper.getMainLooper());
                        }
                        return true;
                    } catch (Throwable th3) {
                        e = th3;
                        e.c(open);
                        e.a(outputStream);
                        throw e;
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                } catch (Throwable th4) {
                    e = th4;
                    open = null;
                    e.c(open);
                    e.a(outputStream);
                    throw e;
                }
                if (file.exists()) {
                    bcVar = new bc();
                    bcVar.fqf.fqg = 35;
                    bcVar.fqf.fqh = 1;
                    bcVar.fqf.filePath = file.getAbsolutePath();
                    com.tencent.mm.sdk.b.a.xmy.a(bcVar, Looper.getMainLooper());
                }
            }
            return true;
        }

        public final String getName() {
            return "CheckFeatureResourceTask";
        }
    }

    private class c extends f {
        /* synthetic */ c(b bVar, com.tencent.mm.plugin.fts.a.a.g gVar, byte b) {
            this(gVar);
        }

        private c(com.tencent.mm.plugin.fts.a.a.g gVar) {
            super(gVar);
        }

        protected final void a(h hVar) {
            hVar.mRM = com.tencent.mm.plugin.fts.a.a.e.an(this.mRy.fEe, true);
            hVar.mRN = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a = b.this.mTf.a(hVar.mRM, com.tencent.mm.plugin.fts.a.c.mPN, this.mRy.mRG, true, true);
            while (a.moveToNext()) {
                k kVar = new k();
                kVar.h(a);
                if (!(hashSet.contains(Long.valueOf(kVar.mRQ)) || this.mRy.mRI.contains(kVar.mRd))) {
                    kVar.aNF();
                    hVar.mRN.add(kVar);
                    hashSet.add(Long.valueOf(kVar.mRQ));
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.mRy.mRJ != null) {
                Collections.sort(hVar.mRN, this.mRy.mRJ);
            }
            for (j jVar : hVar.mRN) {
                jVar.userData = b.this.mTf.qv((int) jVar.mRQ);
            }
        }

        public final String getName() {
            return "SearchFeatureTask";
        }

        public final int getId() {
            return 12;
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String path;

        public d(String str) {
            this.path = str;
        }

        public final String getName() {
            return "UpdateFeatureIndexTask";
        }

        public final boolean execute() {
            List a = b.a(b.this, this.path);
            b.this.mTf.beginTransaction();
            b.this.mTf.aV(a);
            b.this.mTf.commit();
            b.this.mTf.h(com.tencent.mm.plugin.fts.a.c.mPN);
            b.this.gKV.a(131132, new a(b.this, (byte) 0));
            e topHitsLogic = ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mTJ.e(com.tencent.mm.plugin.fts.a.c.mPN, 1);
            return true;
        }
    }

    static /* synthetic */ List a(b bVar, String str) {
        String str2 = "%s/feature_%s.conf";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String eM = w.eM(ad.getContext());
        eM = eM.equalsIgnoreCase("zh_CN") ? "zh_CN".toLowerCase() : (eM.equalsIgnoreCase("zh_TW") || eM.equalsIgnoreCase("zh_HK")) ? "zh_TW".toLowerCase() : "en".toLowerCase();
        objArr[1] = eM;
        eM = String.format(str2, objArr);
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "decodeToFeatureList %s", eM);
        long lastModified = new File(eM).lastModified();
        int bN = e.bN(eM);
        List arrayList = new ArrayList();
        if (bN == 0) {
            throw new com.tencent.mm.plugin.fts.a.a.l("data file no exist error");
        }
        String[] split = new String(e.e(eM, 0, bN)).split("\n");
        com.tencent.mm.plugin.fts.a.a.c cVar = null;
        for (String str3 : split) {
            String str32;
            if (str32 != null) {
                str32 = str32.trim();
                if (str32.length() != 0) {
                    int indexOf = str32.indexOf("=");
                    if (indexOf >= 0) {
                        String substring = str32.substring(0, indexOf);
                        str32 = str32.substring(indexOf + 1);
                        if (substring.equals("FeatureID")) {
                            if (cVar != null) {
                                cVar.field_iconPath = str + "/icon/" + cVar.field_featureId + ".png";
                                arrayList.add(cVar);
                            }
                            cVar = new com.tencent.mm.plugin.fts.a.a.c();
                            cVar.field_featureId = Integer.valueOf(str32).intValue();
                            cVar.field_timestamp = lastModified;
                        }
                        if (cVar != null) {
                            if (substring.equals("Title")) {
                                cVar.field_title = str32;
                            } else if (substring.equals("TitlePY")) {
                                cVar.field_titlePY = str32;
                            } else if (substring.equals("TitleShortPY")) {
                                cVar.field_titleShortPY = str32;
                            } else if (substring.equals("Tag")) {
                                cVar.field_tag = str32;
                            } else if (substring.equals("ActionType")) {
                                if (str32.equals("H5")) {
                                    cVar.field_actionType = 2;
                                } else if (str32.equals("Native")) {
                                    cVar.field_actionType = 1;
                                }
                            } else if (substring.equals("Url")) {
                                cVar.field_url = str32;
                            } else if (substring.equals("HelpUrl")) {
                                cVar.field_helpUrl = str32;
                            } else if (substring.equals("UpdateUrl")) {
                                cVar.field_updateUrl = str32;
                            } else if (substring.equals("AndroidUrl")) {
                                cVar.field_androidUrl = str32;
                            }
                        }
                    }
                }
            }
        }
        if (cVar != null) {
            cVar.field_iconPath = str + "/icon/" + cVar.field_featureId + ".png";
            cVar.field_timestamp = lastModified;
            arrayList.add(cVar);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw new com.tencent.mm.plugin.fts.a.a.l("no data error");
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        return this.gKV.a(-65536, new c(this, gVar, (byte) 0));
    }

    protected final boolean onCreate() {
        if (((m) g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
            this.gKV = ((m) g.k(m.class)).getFTSTaskDaemon();
            this.mTf = (com.tencent.mm.plugin.fts.c.b) ((m) g.k(m.class)).getFTSIndexStorage(17);
            this.mSA.cfB();
            this.mTg.cfB();
            this.gKV.a(131132, new b());
            this.gKV.a(131133, new a());
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
        return false;
    }

    protected final boolean Bg() {
        this.mSA.dead();
        this.mTg.dead();
        this.mTf = null;
        this.gKV = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchFeatureLogic";
    }

    public static File aNH() {
        File file = new File(new File(com.tencent.mm.compatible.util.e.hbw, "fts"), "feature");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File aNI() {
        File file = new File(aNH(), "fts_feature");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static int D(File file) {
        File file2 = new File(file, "version.info");
        try {
            if (file2.exists()) {
                return Integer.parseInt(FileOp.bT(file2.getAbsolutePath()), 10);
            }
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", file2.getAbsolutePath());
            return -1;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "getFeatureVersion", new Object[0]);
            return -1;
        }
    }
}
