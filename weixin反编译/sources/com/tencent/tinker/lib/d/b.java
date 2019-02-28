package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

public class b implements d {
    private static boolean ArE = false;
    protected final Context context;

    public b(Context context) {
        this.context = context;
    }

    public void M(Intent intent) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        ArE = false;
        c iw = c.iw(this.context);
        if (!iw.Asq) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String ao = TinkerPatchService.ao(intent);
            if (ao == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(ao);
            String ah = SharePatchFileUtil.ah(file);
            if (ah == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            a ab;
            if (iw.Asr.exists()) {
                ab = a.ab(iw.Asr);
                if (ab.frM == null || ab.Asu == null || !ah.equals(ab.frM)) {
                    iw.aa(file);
                    ab.frM = ah;
                    ab.Asu = "1";
                } else {
                    int parseInt = Integer.parseInt(ab.Asu);
                    if (parseInt >= iw.Ast) {
                        SharePatchFileUtil.ag(iw.Ass);
                        a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    ab.Asu = String.valueOf(parseInt + 1);
                }
            } else {
                iw.aa(file);
                ab = new a(ah, "1");
            }
            a.a(iw.Asr, ab);
        }
    }

    public void d(File file, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
        if (i == -3 || i == -4 || i == -8) {
            com.tencent.tinker.lib.e.a.ir(this.context).Z(file);
        }
    }

    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", file.getAbsolutePath(), str);
    }

    public void a(File file, File file2, String str, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", ShareTinkerInternals.Jn(i), file.getPath(), file2.getPath(), str);
        com.tencent.tinker.lib.e.a.ir(this.context).Z(file);
    }

    public void a(File file, List<File> list, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", file.getAbsolutePath(), Integer.valueOf(list.size()));
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains("checkDexOptExist failed") || th.getMessage().contains("checkDexOptFormat failed")) {
            ArE = true;
            for (File ag : list) {
                SharePatchFileUtil.ag(ag);
            }
            return;
        }
        com.tencent.tinker.lib.e.a.ir(this.context).Z(file);
    }

    public void a(File file, boolean z, long j) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j));
        if (!ArE) {
            c iw = c.iw(this.context);
            if (!iw.Asq) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (iw.Ass.exists()) {
                SharePatchFileUtil.ag(iw.Ass);
            }
        }
    }

    public void a(File file, String str, String str2) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", str, str2);
        com.tencent.tinker.lib.e.a.ir(this.context).aTl();
    }

    public void a(File file, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", file.getAbsolutePath(), th.getMessage());
        a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        com.tencent.tinker.lib.e.a.ir(this.context).tinkerFlags = 0;
        com.tencent.tinker.lib.e.a.ir(this.context).Z(file);
    }
}
