package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public ConcurrentHashMap<Long, WeakReference<a>> rlB;
    public ConcurrentHashMap<String, b> rlC;

    public static class b implements Serializable {
        public String iYb;
        public String rkf;

        public b(String str, String str2) {
            this.rkf = str;
            this.iYb = str2;
        }
    }

    public interface a {
        void bvc();

        void bvd();

        void bve();

        void bvf();

        void bvg();

        void start();

        void wQ(int i);
    }

    private static final class c {
        public static final a rlE = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.rlB = new ConcurrentHashMap();
        this.rlC = new ConcurrentHashMap();
        f.aAK();
        com.tencent.mm.plugin.downloader.model.c.a(new o() {
            public final void onTaskStarted(long j, String str) {
                a.this.H(1, j);
            }

            public final void c(long j, String str, boolean z) {
                WeakReference weakReference = (WeakReference) a.this.rlB.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bve();
                        a.this.rlB.remove(Long.valueOf(j));
                    }
                    a.this.H(3, j);
                }
            }

            public final void c(long j, int i, boolean z) {
                WeakReference weakReference = (WeakReference) a.this.rlB.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bvf();
                        a.this.rlB.remove(Long.valueOf(j));
                    }
                    a.this.H(8, j);
                }
            }

            public final void onTaskRemoved(long j) {
                WeakReference weakReference = (WeakReference) a.this.rlB.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bvd();
                        a.this.rlB.remove(Long.valueOf(j));
                    }
                    a.this.H(2, j);
                }
            }

            public final void onTaskPaused(long j) {
                WeakReference weakReference = (WeakReference) a.this.rlB.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bvc();
                    }
                    a.this.H(6, j);
                }
            }

            public final void cl(long j) {
                WeakReference weakReference = (WeakReference) a.this.rlB.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        FileDownloadTaskInfo bZ = f.aAK().bZ(j);
                        if (bZ.fxa >= 0 && bZ.fxb > 0) {
                            aVar.wQ((int) ((bZ.fxa * 100) / bZ.fxb));
                        }
                    }
                }
            }

            public final void k(long j, String str) {
                WeakReference weakReference = (WeakReference) a.this.rlB.get(Long.valueOf(j));
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bvg();
                    }
                    a.this.H(7, j);
                }
            }
        });
    }

    public static void stopTask(long j) {
        f.aAK().bY(j);
    }

    public static long queryIdByAppid(String str) {
        FileDownloadTaskInfo yo = f.aAK().yo(str);
        return yo != null ? yo.id : Long.MAX_VALUE;
    }

    public final void H(int i, long j) {
        com.tencent.mm.plugin.downloader.e.a cm = ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fl().cm(j);
        if (cm != null) {
            String str = cm.field_appId;
            cm = ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fl().yk(str);
            if (cm == null) {
                x.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
                return;
            }
            String str2 = cm.field_packageName;
            String str3 = cm.field_md5;
            d(i, str, str2, cm.field_downloadUrl);
        }
    }

    private static String o(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[3]));
        return stringBuilder.toString();
    }

    public final void d(int i, String str, String str2, String str3) {
        System.currentTimeMillis();
        b bVar = (b) this.rlC.get(str);
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        x.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", Integer.valueOf(14542), o(str, Integer.valueOf(i), str3, bVar == null ? "" : bVar.rkf + "." + bVar.iYb + "." + str2 + ".0.20.0"));
        x.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : " + r0);
        com.tencent.mm.plugin.report.service.g.pWK.k(14542, r1);
    }
}
