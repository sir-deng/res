package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class f extends com.tencent.mm.plugin.fts.a.b {
    l gKV;
    private com.tencent.mm.ad.e hpx = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof c) {
                c cVar = (c) kVar;
                if (i == 0 && i2 == 0) {
                    x.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", cVar.vkg.toString());
                    return;
                }
                x.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                List list = cVar.vkg;
                if (i2 == -44) {
                    List linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(1));
                    Map hashMap = new HashMap();
                    hashMap.put(list.get(0), Integer.valueOf(0));
                    g.CN().a(new c(list, linkedList, "你好，我是珍惜", cVar.mTU, hashMap, cVar.mTU), 0);
                }
                if (i == 4 && i2 == -24 && !bi.oN(str)) {
                    Toast.makeText(ad.getContext(), str, 1).show();
                }
            }
        }
    };
    com.tencent.mm.sdk.b.c mTP = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.e>() {
        {
            this.xmG = com.tencent.mm.f.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((com.tencent.mm.f.a.e) bVar).fnJ.fnK) {
                ah.h(new Runnable() {
                    public final void run() {
                        if (!f.this.mPA) {
                            f.this.gKV.a(Integer.MAX_VALUE, new b(f.this, (byte) 0));
                        }
                    }
                }, 10000);
                f.this.mTP.dead();
            }
            return false;
        }
    };
    String[] mTQ;
    List<String> mTR;

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        private b() {
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        public final boolean execute() {
            StringBuffer stringBuffer = new StringBuffer();
            long length = com.tencent.mm.plugin.fts.c.aNw().length();
            com.tencent.mm.plugin.fts.a.e.mQu.mQv = length / 1048576;
            stringBuffer.append("[DBSize]=" + bi.fL(length));
            stringBuffer.append("\n");
            com.tencent.mm.plugin.fts.a.e.mQu.mQw = aNP();
            com.tencent.mm.plugin.fts.a.e.mQu.mQx = aNQ();
            com.tencent.mm.plugin.fts.a.e.mQu.mQz = aNN();
            com.tencent.mm.plugin.fts.a.e.mQu.mQy = aNO();
            ((m) g.k(m.class)).getFTSIndexDB().v(-301, com.tencent.mm.plugin.fts.a.e.mQu.mQw);
            ((m) g.k(m.class)).getFTSIndexDB().v(-302, com.tencent.mm.plugin.fts.a.e.mQu.mQx);
            ((m) g.k(m.class)).getFTSIndexDB().v(-303, com.tencent.mm.plugin.fts.a.e.mQu.mQz);
            ((m) g.k(m.class)).getFTSIndexDB().v(-304, com.tencent.mm.plugin.fts.a.e.mQu.mQy);
            stringBuffer.append("[WXContact]=" + com.tencent.mm.plugin.fts.a.e.mQu.mQw);
            stringBuffer.append("\n");
            stringBuffer.append("[WXChatroom]=" + com.tencent.mm.plugin.fts.a.e.mQu.mQx);
            stringBuffer.append("\n");
            stringBuffer.append("[Favorite]=" + com.tencent.mm.plugin.fts.a.e.mQu.mQz);
            stringBuffer.append("\n");
            stringBuffer.append("[Message]=" + com.tencent.mm.plugin.fts.a.e.mQu.mQy);
            String stringBuffer2 = stringBuffer.toString();
            x.i("MicroMsg.FTS.FTSSearchTestLogic", stringBuffer2);
            File file = new File(com.tencent.mm.plugin.fts.a.c.mQg, "FTS5IndexMicroMsgInfo.txt");
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            int j = FileOp.j(file.getAbsolutePath(), stringBuffer2.getBytes());
            x.i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", Integer.valueOf(j), file.getAbsolutePath());
            return true;
        }

        private static long aNN() {
            Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[]{"FTS5MetaFavorite", Integer.valueOf(9)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                return 0;
            } finally {
                rawQuery.close();
            }
        }

        private static long aNO() {
            Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s", new Object[]{"FTS5MetaMessage"}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                return 0;
            } finally {
                rawQuery.close();
            }
        }

        private static long aNP() {
            Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), Integer.valueOf(1)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                return 0;
            } finally {
                rawQuery.close();
            }
        }

        private static long aNQ() {
            Cursor rawQuery = ((m) g.k(m.class)).getFTSIndexDB().rawQuery(String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[]{"FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38)}), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    return j;
                }
                rawQuery.close();
                return 0;
            } finally {
                rawQuery.close();
            }
        }

        public final String getName() {
            return "FTS5DBInfoTask";
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        private d() {
        }

        /* synthetic */ d(f fVar, byte b) {
            this();
        }

        public final boolean execute() {
            g.Dq().gRU.fD(null, "UPDATE rconversation SET unReadCount = 0;");
            return true;
        }

        public final String getName() {
            return "FTSClearUnReadCountTask";
        }
    }

    private class e extends com.tencent.mm.plugin.fts.a.a.a {
        com.tencent.mm.plugin.fts.a.a.g mRy;

        public e(com.tencent.mm.plugin.fts.a.a.g gVar) {
            this.mRy = gVar;
        }

        public final boolean execute() {
            return true;
        }

        public final String getName() {
            return "FTSTestAddChatroomContactTask";
        }
    }

    private class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int count;

        public f(int i) {
            this.count = i;
        }

        public final boolean execute() {
            Throwable th;
            if (f.this.mTQ == null) {
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream("/sdcard/test_insert_msg_words.txt");
                    try {
                        String str = new String(com.tencent.mm.loader.stub.b.d(fileInputStream));
                        f.this.mTQ = str.split(",");
                        com.tencent.mm.a.e.c(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.mm.a.e.c(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    throw th;
                }
            }
            if (f.this.mTR == null) {
                f.this.mTR = new ArrayList();
                Cursor cja = ((h) g.h(h.class)).Ff().cja();
                while (cja.moveToNext()) {
                    f.this.mTR.add(cja.getString(0));
                }
                cja.close();
            }
            if (f.this.mTQ != null) {
                for (int i = 0; i < this.count; i++) {
                    String w = w(f.this.mTQ);
                    cg auVar = new au();
                    auVar.setType(1);
                    auVar.eS(1);
                    auVar.eR(4);
                    auVar.setContent(w);
                    List list = f.this.mTR;
                    auVar.dU((String) list.get(new Random().nextInt(list.size() - 1)));
                    auVar.aq(System.currentTimeMillis() - 250327040);
                    ((h) g.h(h.class)).aZO().Q(auVar);
                    x.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(w.length()), Long.valueOf(auVar.field_msgId));
                }
            }
            return true;
        }

        private static String w(String[] strArr) {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 300; i++) {
                stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
            }
            return stringBuffer.toString();
        }
    }

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final boolean execute() {
            throw new SQLiteDatabaseCorruptException("For Test");
        }
    }

    private class c extends o {
        public String mTU = "";

        public c(int i, List<Integer> list, String str, String str2, Map<String, Integer> map, String str3) {
            super(2, i, list, str, str2, map, str3);
        }
    }

    public final String getName() {
        return "SearchTestLogic";
    }

    protected final boolean onCreate() {
        if (((m) g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
            this.gKV = ((m) g.k(m.class)).getFTSTaskDaemon();
            this.mTP.cfB();
            return true;
        }
        x.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
        return false;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        com.tencent.mm.plugin.fts.a.a.a fVar;
        switch (gVar.mRC) {
            case 65521:
                fVar = new f(gVar.mRH);
                break;
            case 65523:
                fVar = new e(gVar);
                break;
            case 65524:
                fVar = new d();
                break;
            default:
                fVar = new a();
                break;
        }
        return this.gKV.a(-65536, fVar);
    }

    protected final boolean Bg() {
        g.CN().b(30, this.hpx);
        return false;
    }
}
