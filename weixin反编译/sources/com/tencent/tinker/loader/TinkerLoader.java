package com.tencent.tinker.loader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.a(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.Jo(tinkerFlags)) {
            ShareIntentUtil.a(intent, -1);
        } else if (ShareTinkerInternals.iI(tinkerApplication)) {
            ShareIntentUtil.a(intent, -1);
        } else {
            File iA = SharePatchFileUtil.iA(tinkerApplication);
            if (iA == null) {
                ShareIntentUtil.a(intent, -2);
                return;
            }
            String absolutePath = iA.getAbsolutePath();
            if (iA.exists()) {
                File acr = SharePatchFileUtil.acr(absolutePath);
                if (acr.exists()) {
                    File acs = SharePatchFileUtil.acs(absolutePath);
                    this.patchInfo = SharePatchInfo.o(acr, acs);
                    if (this.patchInfo == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    String str = this.patchInfo.AuP;
                    String str2 = this.patchInfo.AuQ;
                    String str3 = this.patchInfo.ArY;
                    if (str == null || str2 == null || str3 == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    intent.putExtra("intent_patch_old_version", str);
                    intent.putExtra("intent_patch_new_version", str2);
                    boolean iH = ShareTinkerInternals.iH(tinkerApplication);
                    Object obj = !str.equals(str2) ? 1 : null;
                    Object obj2 = (str3.equals("changing") && iH) ? 1 : null;
                    str3 = ShareTinkerInternals.bW(tinkerApplication, str3);
                    intent.putExtra("intent_patch_oat_dir", str3);
                    if (obj == null || !iH) {
                        str2 = str;
                    }
                    if (ShareTinkerInternals.oN(str2)) {
                        ShareIntentUtil.a(intent, -5);
                        return;
                    }
                    str = SharePatchFileUtil.act(str2);
                    if (str == null) {
                        ShareIntentUtil.a(intent, -6);
                        return;
                    }
                    absolutePath = absolutePath + "/" + str;
                    File file = new File(absolutePath);
                    if (file.exists()) {
                        String acu = SharePatchFileUtil.acu(str2);
                        File file2 = acu != null ? new File(file.getAbsolutePath(), acu) : null;
                        if (SharePatchFileUtil.ae(file2)) {
                            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
                            int a = ShareTinkerInternals.a(tinkerApplication, tinkerFlags, file2, shareSecurityCheck);
                            if (a != 0) {
                                intent.putExtra("intent_patch_package_patch_check", a);
                                ShareIntentUtil.a(intent, -8);
                                return;
                            }
                            intent.putExtra("intent_patch_package_config", shareSecurityCheck.cHY());
                            boolean Jk = ShareTinkerInternals.Jk(tinkerFlags);
                            if (Jk && !TinkerDexLoader.a(absolutePath, shareSecurityCheck, str3, intent)) {
                                return;
                            }
                            if (!ShareTinkerInternals.Jl(tinkerFlags) || TinkerSoLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                boolean Jm = ShareTinkerInternals.Jm(tinkerFlags);
                                if (!Jm || TinkerResourceLoader.a(tinkerApplication, absolutePath, shareSecurityCheck, intent)) {
                                    boolean z = ShareTinkerInternals.cHZ() && ShareTinkerInternals.acx(this.patchInfo.AuR) && VERSION.SDK_INT >= 21 && !ShareTinkerInternals.cIb();
                                    intent.putExtra("intent_patch_system_ota", z);
                                    if ((iH && obj != null) || obj2 != null) {
                                        this.patchInfo.AuP = str2;
                                        this.patchInfo.ArY = str3;
                                        if (!SharePatchInfo.a(acr, this.patchInfo, acs)) {
                                            ShareIntentUtil.a(intent, -19);
                                            return;
                                        } else if (obj2 != null) {
                                            SharePatchFileUtil.bP(absolutePath + "/interpet");
                                        }
                                    }
                                    if (checkSafeModeCount(tinkerApplication)) {
                                        if (Jk) {
                                            boolean a2 = TinkerDexLoader.a(tinkerApplication, absolutePath, str3, intent, z);
                                            if (z) {
                                                this.patchInfo.AuR = Build.FINGERPRINT;
                                                this.patchInfo.ArY = a2 ? "interpet" : "odex";
                                                obj2 = null;
                                                if (SharePatchInfo.a(acr, this.patchInfo, acs)) {
                                                    intent.putExtra("intent_patch_oat_dir", this.patchInfo.ArY);
                                                } else {
                                                    ShareIntentUtil.a(intent, -19);
                                                    return;
                                                }
                                            }
                                            if (!a2) {
                                                return;
                                            }
                                        }
                                        if (!Jm || TinkerResourceLoader.a(tinkerApplication, absolutePath, intent)) {
                                            if (Jk && Jm) {
                                                ComponentHotplug.a(tinkerApplication, shareSecurityCheck);
                                            }
                                            if (obj2 != null) {
                                                ShareTinkerInternals.iJ(tinkerApplication);
                                            }
                                            ShareIntentUtil.a(intent, 0);
                                            return;
                                        }
                                        return;
                                    }
                                    intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                                    ShareIntentUtil.a(intent, -25);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ShareIntentUtil.a(intent, -7);
                        return;
                    }
                    ShareIntentUtil.a(intent, -6);
                    return;
                }
                new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(acr.getAbsolutePath());
                ShareIntentUtil.a(intent, -3);
                return;
            }
            ShareIntentUtil.a(intent, -2);
        }
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        String str = "tinker_own_config_" + ShareTinkerInternals.iK(tinkerApplication);
        SharedPreferences sharedPreferences = tinkerApplication.getSharedPreferences(str, 0);
        int i = sharedPreferences.getInt("safe_mode_count", 0) + 1;
        new StringBuilder("tinker safe mode preferName:").append(str).append(" count:").append(i);
        if (i >= 3) {
            sharedPreferences.edit().putInt("safe_mode_count", 0).commit();
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        sharedPreferences.edit().putInt("safe_mode_count", i).commit();
        return true;
    }
}
