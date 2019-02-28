package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class e {
    private static e tut;
    public static AtomicLong tuu = new AtomicLong(0);
    public static AtomicBoolean tux = new AtomicBoolean(false);
    private List<String> tuv = Collections.synchronizedList(new ArrayList());
    public String tuw = "";
    private com.tencent.mm.modelvideo.b.a tuy;
    public com.tencent.mm.modelvideo.b tuz = new com.tencent.mm.modelvideo.b() {
        public final void o(String str, String str2, String str3) {
            String b;
            for (String b2 : e.this.tuv) {
                e.this.cancelTask(b2);
            }
            e.this.tuv.clear();
            if (!bi.oN(e.this.tuw)) {
                b2 = e.this.tuw;
                e.this.tuw = null;
                e.this.cancelTask(b2);
            }
            e.this.tuw = str3;
            o.Uc().a(e.this.u(e.this.tuw, 1, str2), false);
            if (e.tuu.get() == 9223372036854775806L) {
                e.tuu.set(0);
                g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_FTS_RECOMMEND_LOCAL_FILE_INDEX_LONG_SYNC, Long.valueOf(e.tuu.get()));
                new a(Long.MAX_VALUE).run();
            } else if (!e.tux.get()) {
                com.tencent.mm.sdk.f.e.post(new a(e.tuu.get()), "FtsRecommendVideoPreloadMgr.DeleteUnusedTask");
            }
            long incrementAndGet = e.tuu.incrementAndGet();
            x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "startHttpStream mediaId: %s\n path: %s \n url:%s \n Thread.currentThread().getId(): %d index: %d", str, str2, str3, Long.valueOf(Thread.currentThread().getId()), Long.valueOf(incrementAndGet));
            b2 = b.OE(e.this.tuw);
            if (!bi.oN(b2)) {
                e.this.Ow(b2);
            }
        }

        public final void nk(String str) {
            o.Uc().b(str, null);
        }

        public final void h(String str, int i, int i2) {
            o.Uc();
            f.f(str, i, i2);
        }

        public final boolean isVideoDataAvailable(String str, int i, int i2) {
            return o.Uc().isVideoDataAvailable(str, i, i2);
        }

        public final void a(com.tencent.mm.modelvideo.b.a aVar) {
            e.this.tuy = aVar;
        }
    };

    private class a implements Runnable {
        long tuB;

        public a(long j) {
            this.tuB = j;
        }

        public final void run() {
            e.tux.set(true);
            List<FileEntry> F = FileOp.F(e.bQh(), false);
            if (F != null) {
                x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "DeleteUnusedTask.maxDeleteIndex %d", Long.valueOf(this.tuB));
                for (FileEntry fileEntry : F) {
                    try {
                        if (Long.valueOf(new File(fileEntry.name).getName().split("@")[0]).longValue() < this.tuB) {
                            FileOp.deleteFile(fileEntry.name);
                            x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "deleteUnusedRunnable delete file %s", fileEntry.name);
                        }
                    } catch (Exception e) {
                        FileOp.deleteFile(fileEntry.name);
                        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "deleteUnusedRunnable exception delete file %s", fileEntry.name);
                    }
                }
                e.tux.set(false);
            }
        }
    }

    private class b implements com.tencent.mm.modelcdntran.j.a {
        private b() {
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        public final void onMoovReady(final String str, final int i, final int i2) {
            ah.y(new Runnable() {
                public final void run() {
                    if (e.this.tuy != null && e.this.OJ(str)) {
                        e.this.tuy.iJ(i);
                    }
                }
            });
        }

        public final void onDataAvailable(final String str, final int i, final int i2) {
            ah.y(new Runnable() {
                public final void run() {
                    if (e.this.tuy != null && e.this.OJ(str)) {
                        e.this.tuy.onDataAvailable(str, i, i2);
                    }
                }
            });
        }

        public final void g(final String str, final int i, final int i2) {
            ah.y(new Runnable() {
                public final void run() {
                    if (e.this.tuy != null && e.this.OJ(str)) {
                        e.this.tuy.g(str, i, i2);
                    }
                }
            });
        }

        public final void K(final String str, final int i) {
            x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "onFinish %s %d", str, Integer.valueOf(i));
            ah.y(new Runnable() {
                public final void run() {
                    if (e.this.tuy != null && e.this.OJ(str)) {
                        e.this.tuy.K(str, i);
                    }
                }
            });
            if (i != 0) {
                com.tencent.mm.plugin.aj.a.a.a.qq(9);
            }
        }
    }

    e() {
        String bQh = bQh();
        if (!FileOp.bO(bQh)) {
            FileOp.ml(bQh);
        }
        bQh = bQh + ".nomedia";
        if (!FileOp.bO(bQh)) {
            FileOp.ml(bQh);
        }
    }

    public static e bQg() {
        if (tut == null) {
            tut = new e();
        }
        return tut;
    }

    private void cancelTask(String str) {
        if (!OJ(str)) {
            o.Uc().b(OI(str), null);
        }
    }

    public static void onPause() {
    }

    public static void onResume() {
    }

    public final void Ow(String str) {
        if (b.bQc()) {
            String OI = OI(str);
            if (this.tuv.contains(OI)) {
                x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "preload exit %s", str);
                return;
            }
            if (this.tuv.size() > 0) {
                cancelTask((String) this.tuv.remove(0));
                x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "cancel preload url %s", r0);
            }
            this.tuv.add(OI);
            x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "add preload url %s\n mediaId: %s\n preloadPath: %s", str, OI, OK(str));
            o.Uc().a(u(str, 2, r0), false);
            return;
        }
        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "no need to preload video");
    }

    private static String OI(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return "MMVideo_" + str.hashCode();
    }

    private j u(String str, int i, String str2) {
        j jVar = new j();
        jVar.field_mediaId = OI(str);
        jVar.url = str;
        jVar.hvu = i;
        jVar.hvp = 3;
        jVar.hvz = 10;
        jVar.concurrentCount = 2;
        jVar.field_fullpath = str2;
        if (i == 1) {
            jVar.hvB = new b();
        } else {
            jVar.hvB = new com.tencent.mm.modelcdntran.j.a() {
                public final void onMoovReady(String str, int i, int i2) {
                }

                public final void onDataAvailable(String str, int i, int i2) {
                }

                public final void g(String str, int i, int i2) {
                }

                public final void K(String str, int i) {
                }
            };
        }
        return jVar;
    }

    private boolean OJ(String str) {
        return !bi.oN(this.tuw) && str.equals(OI(this.tuw));
    }

    public static String bQh() {
        return com.tencent.mm.compatible.util.e.bnF + "ftsrecommendVideo/";
    }

    public static String OK(String str) {
        return bQh() + tuu.get() + "@" + OI(str) + ".mp4";
    }
}
