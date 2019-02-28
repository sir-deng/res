package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.d.a;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class c extends a {
    public c(Context context) {
        super(context);
    }

    public final void a(Throwable th, int i) {
        super.a(th, i);
        b.a(th, i);
    }

    public final void a(File file, int i) {
        super.a(file, i);
        b.rG(i);
    }

    public final void a(File file, int i, boolean z) {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            aTj();
        } else {
            cHP();
        }
        if (i == 1) {
            d dVar = com.tencent.tinker.lib.e.a.ir(this.context).ArS;
            if (dVar.ArX != null && "00000000000000000000000000000000".equals(dVar.ArX)) {
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.iJ(this.context);
            }
        }
        b.rF(i);
    }

    public final void b(int i, Throwable th) {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        switch (i) {
            case 0:
                com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        aTj();
        b.a(i, th);
    }

    public final void b(File file, int i) {
        super.b(file, i);
        b.k(ad.xnM, i);
    }

    public final void a(String str, String str2, File file) {
        super.a(str, str2, file);
        b.aTf();
    }

    public final void a(String str, String str2, File file, String str3) {
        super.a(str, str2, file, str3);
        b.aTg();
    }

    public final void a(File file, int i, long j) {
        super.a(file, i, j);
        switch (i) {
            case 0:
                b.k(j, com.tencent.tinker.lib.e.a.ir(this.context).rYd);
                break;
        }
        if (com.tencent.tinker.lib.e.a.ir(this.context).rYd) {
            String absolutePath = new File(SharePatchFileUtil.iB(this.context), "temp.apk").getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
            } else {
                a aVar = new a(this.context, new a.a() {
                    public final void aTi() {
                        if (com.tencent.tinker.lib.f.c.iw(c.this.context).cHS()) {
                            b.aTc();
                        }
                    }
                });
            }
        } else {
            com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        }
        x.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", Integer.valueOf(i), Long.valueOf(j));
        if (i == 0) {
            d dVar = com.tencent.tinker.lib.e.a.ir(this.context).ArS;
            x.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", dVar.ArX);
            if (!TextUtils.isEmpty(dVar.ArX)) {
                Context context = this.context;
                context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", dVar.ArX).apply();
            }
        }
    }

    public final void c(File file, int i) {
        super.c(file, i);
        if (i == -26 || i == -5) {
            ShareTinkerInternals.iF(this.context);
            com.tencent.tinker.lib.e.a.ir(this.context).tinkerFlags = 0;
        }
        b.rC(i);
    }

    private void aTj() {
        a aVar = new a(this.context, new a.a() {
            public final void aTi() {
                if (c.this.cHQ()) {
                    b.aTc();
                }
            }
        });
    }
}
