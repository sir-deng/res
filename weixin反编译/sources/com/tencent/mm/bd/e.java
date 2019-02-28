package com.tencent.mm.bd;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ad.k;
import com.tencent.mm.bd.d.a;
import com.tencent.mm.bd.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class e {
    private static e hRe = null;
    private byte[] gPR = new byte[0];
    private String hRf;
    private com.tencent.mm.ad.e hRg = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (e.this.hRf != null) {
                x.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) kVar).filename + " filepath " + e.this.hRf + " errCode " + i2);
                if (((a) kVar).filename.equals(e.this.hRf)) {
                    g.CN().b(240, e.this.hRg);
                    if (i2 == 0) {
                        d.SK();
                        d.SM();
                    }
                    try {
                        x.d("MicroMsg.SpeexUploadCore", "delete " + e.this.hRf + " delete " + new File(e.this.hRf).delete() + " errCode " + i2);
                    } catch (Throwable e) {
                        x.e("MicroMsg.SpeexUploadCore", "exception:%s", bi.i(e));
                    } finally {
                        e.SS().start();
                        e.this.hRf = null;
                    }
                }
            }
        }
    };
    public at hzw = new at(1, "speex_worker");

    static /* synthetic */ void b(e eVar) {
        x.d("MicroMsg.SpeexUploadCore", "uploadOneFile");
        synchronized (eVar.gPR) {
            if (eVar.hRf != null) {
                x.d("MicroMsg.SpeexUploadCore", "uploading...");
                return;
            }
            a SR = a.SR();
            if (SR != null) {
                Object obj;
                File bm;
                File file;
                String name;
                b bVar;
                String[] split;
                if (1 != com.tencent.mm.audio.b.g.t("EnableSpeexVoiceUpload", 0)) {
                    if (SR.SP() == 0) {
                        obj = null;
                    } else if (ao.isWifi(ad.getContext())) {
                        g.Dr();
                        boolean z = SR.fXa == 0 ? true : SR.fXa == bi.a((Integer) g.Dq().Db().get(12290, null), 0);
                        x.d("upload", "fitSex " + SR.fXa + " " + z + " " + SR.fXa);
                        if (!z) {
                            obj = null;
                        } else if (!SR.SO()) {
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        bm = bm(SR.hQX, SR.hQY);
                        if (bm != null) {
                            x.d("MicroMsg.SpeexUploadCore", "no target to upload");
                            return;
                        }
                        try {
                            file = new File(bm.getPath().replace(".spx", ".uploading"));
                            if (bm.renameTo(file)) {
                                x.d("MicroMsg.SpeexUploadCore", "delete " + bm.getPath());
                                bm.delete();
                                return;
                            }
                            eVar.hRf = file.getPath();
                            name = file.getName();
                            x.d("MicroMsg.SpeexUploadCore", "upload file " + eVar.hRf);
                            bVar = new b();
                            split = name.substring(0, name.indexOf(46)).split("_");
                            if (split.length == 5) {
                                try {
                                    bVar.hNW = split[0];
                                    bVar.sampleRate = bi.getInt(split[1], 0);
                                    bVar.hQJ = bi.getInt(split[2], 0);
                                    bVar.hQK = bi.getInt(split[3], 0);
                                } catch (NumberFormatException e) {
                                    x.e("upload", "wrong format", e);
                                }
                            }
                            g.CN().a(240, eVar.hRg);
                            g.CN().a(new a(eVar.hRf, d.mM(name), bVar.sampleRate, bVar.hQJ, bVar.hQK), 0);
                            return;
                        } catch (Throwable e2) {
                            x.e("MicroMsg.SpeexUploadCore", "exception:%s", bi.i(e2));
                        }
                    }
                }
                int obj2 = 1;
                if (obj2 != null) {
                    bm = bm(SR.hQX, SR.hQY);
                    if (bm != null) {
                        file = new File(bm.getPath().replace(".spx", ".uploading"));
                        if (bm.renameTo(file)) {
                            x.d("MicroMsg.SpeexUploadCore", "delete " + bm.getPath());
                            bm.delete();
                            return;
                        }
                        eVar.hRf = file.getPath();
                        name = file.getName();
                        x.d("MicroMsg.SpeexUploadCore", "upload file " + eVar.hRf);
                        bVar = new b();
                        split = name.substring(0, name.indexOf(46)).split("_");
                        if (split.length == 5) {
                            bVar.hNW = split[0];
                            bVar.sampleRate = bi.getInt(split[1], 0);
                            bVar.hQJ = bi.getInt(split[2], 0);
                            bVar.hQK = bi.getInt(split[3], 0);
                        }
                        g.CN().a(240, eVar.hRg);
                        g.CN().a(new a(eVar.hRf, d.mM(name), bVar.sampleRate, bVar.hQJ, bVar.hQK), 0);
                        return;
                    }
                    x.d("MicroMsg.SpeexUploadCore", "no target to upload");
                    return;
                }
            }
            x.d("MicroMsg.SpeexUploadCore", "SpeexConfig not allow");
            return;
        }
    }

    public static e SS() {
        if (hRe == null) {
            hRe = new e();
        }
        return hRe;
    }

    public final void b(at.a aVar) {
        x.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.hzw.c(aVar);
    }

    public final void start() {
        if (ao.isWifi(ad.getContext())) {
            new ag(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            e.this.b(new at.a() {
                                public final boolean JH() {
                                    return true;
                                }

                                public final boolean JI() {
                                    e.b(e.this);
                                    return false;
                                }
                            });
                            return false;
                        }
                    });
                }
            }, 100);
        }
    }

    private static File bm(int i, int i2) {
        File file = new File(b.SJ());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        int i3 = 0;
        file = null;
        while (listFiles != null && i3 < listFiles.length) {
            file = listFiles[i3];
            if (file != null && file.isFile()) {
                x.d("MicroMsg.SpeexUploadCore", "file " + file.getPath());
                String path = file.getPath();
                long length = file.length();
                if (!file.getName().endsWith(".spx")) {
                    file = null;
                } else if (length >= ((long) i) && length <= ((long) i2)) {
                    return file;
                } else {
                    x.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", path, Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.mm.loader.stub.b.deleteFile(path);
                    file = null;
                }
            }
            i3++;
        }
        return file;
    }
}
