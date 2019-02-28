package com.tencent.mm.plugin.appbrand.m;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.f.a.ix;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c {
    b jOK;
    public com.tencent.mm.sdk.b.c jOL;
    public com.tencent.mm.sdk.b.c jOM;
    public com.tencent.mm.sdk.b.c jON;

    private static class a {
        public static c jOP = new c();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.jON = new com.tencent.mm.sdk.b.c<ix>() {
            {
                this.xmG = ix.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ix ixVar = (ix) bVar;
                if (ixVar.fAr.fqg == 40 && ixVar.fAr.fqh == 1) {
                    File file = new File(ixVar.fAr.filePath);
                    f fVar = (f) g.h(f.class);
                    if (file.exists()) {
                        x.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                        File file2 = new File(fVar.Ro(), "temp");
                        File file3 = new File(file2, "wxa_fts_template.zip");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                        int intValue = bi.fz(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0 ? Integer.valueOf(fVar.o(new File(file2, "config.conf")).getProperty("version", "0")).intValue() : 65900180;
                        e.g(file2);
                        x.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", Integer.valueOf(c.this.jOK.aIt), Integer.valueOf(intValue));
                        if (c.d(file, new File(c.this.jOK.iKP))) {
                            c.this.refresh();
                        } else {
                            x.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                        }
                    } else {
                        x.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                    }
                }
                return false;
            }
        };
        this.jOK = new b();
        this.jOL = new com.tencent.mm.sdk.b.c<bc>() {
            {
                this.xmG = bc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                bc bcVar = (bc) bVar;
                if (bcVar.fqf.fqg == 40 && bcVar.fqf.fqh == 1) {
                    File file = new File(bcVar.fqf.filePath);
                    if (file.exists()) {
                        x.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                        File file2 = new File(((f) g.h(f.class)).Ro(), "temp");
                        File file3 = new File(file2, "wxa_fts_template.zip");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                        int fz = bi.fz(file3.getAbsolutePath(), file2.getAbsolutePath());
                        int i = 65900180;
                        if (fz >= 0) {
                            i = Integer.valueOf(((f) g.h(f.class)).o(new File(file2, "config.conf")).getProperty("version", "0")).intValue();
                        }
                        e.g(file2);
                        if (i > c.this.jOK.aIt) {
                            x.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", Integer.valueOf(c.this.jOK.aIt), Integer.valueOf(i));
                            if (c.d(file, new File(c.this.jOK.iKP))) {
                                c.this.refresh();
                            } else {
                                x.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                            }
                        } else {
                            x.i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", Integer.valueOf(c.this.jOK.aIt), Integer.valueOf(i));
                        }
                    } else {
                        x.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                    }
                }
                return false;
            }
        };
        this.jOM = new com.tencent.mm.sdk.b.c<hx>() {
            {
                this.xmG = hx.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(b bVar) {
                ((hx) bVar).fzj.fzk = c.this.jOK.aIt;
                return true;
            }
        };
    }

    public final void prepare() {
        com.tencent.mm.sdk.b.a.xmy.b(this.jOL);
        com.tencent.mm.sdk.b.a.xmy.b(this.jOM);
        this.jON.cfB();
        refresh();
        File file = new File(this.jOK.iKP);
        x.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", Integer.valueOf(this.jOK.aIt), Integer.valueOf(65900180));
        if (this.jOK.aIt < 65900180 && c(file, "wxa_fts_template.zip")) {
            refresh();
        }
    }

    void refresh() {
        this.jOK.aIt = ((f) g.h(f.class)).Rp();
        this.jOK.iKP = ((f) g.h(f.class)).Ro();
    }

    private static boolean c(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        boolean aX = ((f) g.h(f.class)).aX(absolutePath, str);
        if (aX) {
            if (bi.fz(absolutePath, file3.getParent()) < 0) {
                x.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", Integer.valueOf(bi.fz(absolutePath, file3.getParent())), absolutePath, file3.getParent());
                return false;
            }
            x.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", file3.getAbsolutePath());
            return aX;
        }
        x.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", file3.getAbsolutePath());
        return aX;
    }

    static boolean d(File file, File file2) {
        e.g(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (bi.fz(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            x.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", Integer.valueOf(bi.fz(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath());
            return false;
        }
        x.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", file2.getAbsolutePath());
        return true;
    }
}
