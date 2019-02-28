package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class a {
    private static final String hlB;
    private static ConcurrentMap<String, Boolean> joa = new ConcurrentHashMap();
    private static Map<String, List<a>> job = new HashMap();

    public interface a {
        void sL(String str);
    }

    static /* synthetic */ void bl(String str, String str2) {
        int i = 0;
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "doCallback url:%s localPath:%s", str, str2);
        List list = (List) job.get(str);
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "doCallback callbacks nil");
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ((a) list.get(i2)).sL(str2);
                i = i2 + 1;
            } else {
                job.remove(str);
                return;
            }
        }
    }

    static /* synthetic */ void z(String str, String str2, String str3) {
        Throwable e;
        File file = new File(str3);
        if (file.exists()) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download already exists: %s", str);
            if (bk(str2, str3)) {
                bj(str, str3);
                return;
            } else {
                x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download already exists, but md5 not valid. deleted:%b", Boolean.valueOf(file.delete()));
            }
        }
        if (joa.containsKey(str)) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download ing: %s", str);
            return;
        }
        joa.put(str, Boolean.valueOf(true));
        Closeable fileOutputStream;
        Closeable bufferedInputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    bi.d(fileOutputStream);
                    bi.d(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        file.delete();
                        x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", str);
                        bi.d(fileOutputStream);
                        bi.d(bufferedInputStream);
                        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
                        joa.remove(str);
                        if (bk(str2, str3)) {
                            x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                            bj(str, null);
                        }
                        bj(str, str3);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        bi.d(fileOutputStream);
                        bi.d(bufferedInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                file.delete();
                x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", str);
                bi.d(fileOutputStream);
                bi.d(bufferedInputStream);
                x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
                joa.remove(str);
                if (bk(str2, str3)) {
                    x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                    bj(str, null);
                }
                bj(str, str3);
                return;
            } catch (Throwable th2) {
                e = th2;
                bufferedInputStream = null;
                bi.d(fileOutputStream);
                bi.d(bufferedInputStream);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedInputStream = null;
            file.delete();
            x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", str);
            bi.d(fileOutputStream);
            bi.d(bufferedInputStream);
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
            joa.remove(str);
            if (bk(str2, str3)) {
                x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                bj(str, null);
            }
            bj(str, str3);
            return;
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            bufferedInputStream = null;
            bi.d(fileOutputStream);
            bi.d(bufferedInputStream);
            throw e;
        }
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
        joa.remove(str);
        if (bk(str2, str3)) {
            bj(str, str3);
            return;
        }
        x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
        bj(str, null);
    }

    static {
        String str = e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        hlB = str;
        i.QZ(str);
    }

    public static void a(final String str, final String str2, final a aVar) {
        if (!bi.oN(str)) {
            String str3 = null;
            if (!bi.oN(str)) {
                str3 = g.s(str.getBytes());
            }
            str3 = String.format("%s%s", new Object[]{hlB, str3});
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "downloadToLocal url:%s localPath:%s", str, str3);
            ah.y(new Runnable() {
                public final void run() {
                    if (!a.job.containsKey(str)) {
                        a.job.put(str, new ArrayList());
                    }
                    ((List) a.job.get(str)).add(aVar);
                }
            });
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    a.z(str, str2, str3);
                }
            }, "AppBrandSimpleImageLoaderDownloadThread");
        }
    }

    private static void bj(final String str, final String str2) {
        ah.y(new Runnable() {
            public final void run() {
                a.bl(str, str2);
            }
        });
    }

    private static boolean bk(String str, String str2) {
        if (bi.oN(str)) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "isMd5Valid target nil, no check");
            return true;
        }
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "isMd5Valid file:%s target:%s", g.bV(str2), str);
        return str.equals(g.bV(str2));
    }
}
