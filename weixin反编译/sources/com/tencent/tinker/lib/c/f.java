package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;

public final class f extends a {
    public final boolean a(Context context, String str, a aVar) {
        com.tencent.tinker.lib.e.a ir = com.tencent.tinker.lib.e.a.ir(context);
        File file = new File(str);
        if (!ShareTinkerInternals.Jo(ir.tinkerFlags) || !ShareTinkerInternals.iG(context)) {
            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (SharePatchFileUtil.ae(file)) {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int a = ShareTinkerInternals.a(context, ir.tinkerFlags, file, shareSecurityCheck);
            if (a != 0) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                ir.ArO.d(file, a);
                return false;
            }
            String ah = SharePatchFileUtil.ah(file);
            if (ah == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            SharePatchInfo sharePatchInfo;
            aVar.ArG = ah;
            com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", ah);
            String absolutePath = ir.ArL.getAbsolutePath();
            File acs = SharePatchFileUtil.acs(absolutePath);
            File acr = SharePatchFileUtil.acr(absolutePath);
            SharePatchInfo o = SharePatchInfo.o(acr, acs);
            if (o == null) {
                sharePatchInfo = new SharePatchInfo("", ah, Build.FINGERPRINT, "odex");
            } else if (o.AuP == null || o.AuQ == null || o.ArY == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                ir.ArO.a(file, o.AuP, o.AuQ);
                return false;
            } else if (SharePatchFileUtil.acv(ah)) {
                sharePatchInfo = new SharePatchInfo(o.AuP, ah, Build.FINGERPRINT, o.ArY.equals("interpet") ? "changing" : o.ArY);
            } else {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", ah);
                ir.ArO.a(file, o, ah);
                return false;
            }
            absolutePath = absolutePath + "/" + SharePatchFileUtil.act(ah);
            com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", absolutePath);
            File file2 = new File(absolutePath + "/" + SharePatchFileUtil.acu(ah));
            try {
                if (!ah.equals(SharePatchFileUtil.ah(file2))) {
                    SharePatchFileUtil.m(file, file2);
                    com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length()));
                }
                if (d.a(ir, shareSecurityCheck, context, absolutePath, file2)) {
                    String str2;
                    boolean z;
                    if (ShareTinkerInternals.Jl(ir.tinkerFlags)) {
                        str2 = (String) shareSecurityCheck.Avd.get("assets/so_meta.txt");
                        if (str2 == null) {
                            com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                            z = true;
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            z = c.a(context, absolutePath + "/lib/", str2, file2);
                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.tencent.tinker.lib.f.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(elapsedRealtime));
                        }
                    } else {
                        com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                        z = true;
                    }
                    if (z) {
                        if (ShareTinkerInternals.Jm(ir.tinkerFlags)) {
                            str2 = (String) shareSecurityCheck.Avd.get("assets/res_meta.txt");
                            if (str2 == null || str2.length() == 0) {
                                com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                                z = true;
                            } else {
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (e.c(context, absolutePath + "/res/", str2, file2)) {
                                    z = true;
                                } else {
                                    com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                                    z = false;
                                }
                                elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                com.tencent.tinker.lib.f.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(elapsedRealtime2));
                            }
                        } else {
                            com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                            z = true;
                        }
                        if (!z) {
                            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                            return false;
                        } else if (!d.a(file, ir)) {
                            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                            return false;
                        } else if (SharePatchInfo.a(acr, sharePatchInfo, acs)) {
                            com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                            return true;
                        } else {
                            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                            ir.ArO.a(file, sharePatchInfo.AuP, sharePatchInfo.AuQ);
                            return false;
                        }
                    }
                    com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            } catch (IOException e) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", file.getPath(), file2.getPath());
                ir.ArO.a(file, file2, file.getName(), 1);
                return false;
            }
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
    }
}
