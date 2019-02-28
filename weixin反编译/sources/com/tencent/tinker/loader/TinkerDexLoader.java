package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TinkerDexLoader {
    private static boolean ArB = ShareTinkerInternals.cHZ();
    private static HashSet<ShareDexDiffPatchInfo> AsA = new HashSet();
    private static final ArrayList<ShareDexDiffPatchInfo> Asz = new ArrayList();

    private TinkerDexLoader() {
    }

    @TargetApi(14)
    public static boolean a(TinkerApplication tinkerApplication, String str, String str2, Intent intent, boolean z) {
        if (Asz.isEmpty() && AsA.isEmpty()) {
            return true;
        }
        PathClassLoader pathClassLoader = (PathClassLoader) TinkerDexLoader.class.getClassLoader();
        if (pathClassLoader != null) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo;
            new StringBuilder("classloader: ").append(pathClassLoader.toString());
            String str3 = str + "/dex/";
            Object arrayList = new ArrayList();
            Iterator it = Asz.iterator();
            while (it.hasNext()) {
                shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                if (!b(shareDexDiffPatchInfo)) {
                    File file = new File(str3 + shareDexDiffPatchInfo.gKZ);
                    if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SharePatchFileUtil.g(file, a(shareDexDiffPatchInfo))) {
                            new StringBuilder("verify dex file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
                        } else {
                            ShareIntentUtil.a(intent, -13);
                            intent.putExtra("intent_patch_mismatch_dex_path", file.getAbsolutePath());
                            return false;
                        }
                    }
                    arrayList.add(file);
                }
            }
            if (ArB && !AsA.isEmpty()) {
                File file2 = new File(str3 + "tinker_classN.apk");
                long currentTimeMillis2 = System.currentTimeMillis();
                if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                    Iterator it2 = AsA.iterator();
                    while (it2.hasNext()) {
                        shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it2.next();
                        if (!SharePatchFileUtil.b(file2, shareDexDiffPatchInfo.AtJ, shareDexDiffPatchInfo.AtL)) {
                            ShareIntentUtil.a(intent, -13);
                            intent.putExtra("intent_patch_mismatch_dex_path", file2.getAbsolutePath());
                            return false;
                        }
                    }
                }
                new StringBuilder("verify dex file:").append(file2.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis2);
                arrayList.add(file2);
            }
            File file3 = new File(str + "/" + str2);
            if (z) {
                final boolean[] zArr = new boolean[]{true};
                final Throwable[] thArr = new Throwable[1];
                try {
                    String cIc = ShareTinkerInternals.cIc();
                    aco(str);
                    file3 = new File(str + "/interpet");
                    TinkerDexOptimizer.a(arrayList, file3, true, cIc, new ResultCallback() {
                        long start;

                        public final void X(File file) {
                            this.start = System.currentTimeMillis();
                            new StringBuilder("start to optimize dex:").append(file.getPath());
                        }

                        public final void l(File file, File file2) {
                            new StringBuilder("success to optimize dex ").append(file.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
                        }

                        public final void b(File file, Throwable th) {
                            zArr[0] = false;
                            thArr[0] = th;
                            new StringBuilder("fail to optimize dex ").append(file.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
                        }
                    });
                    if (!zArr[0]) {
                        intent.putExtra("intent_patch_interpret_exception", thArr[0]);
                        ShareIntentUtil.a(intent, -16);
                        return false;
                    }
                } catch (Serializable th) {
                    new StringBuilder("getCurrentInstructionSet fail:").append(th);
                    aco(str);
                    intent.putExtra("intent_patch_interpret_exception", th);
                    ShareIntentUtil.a(intent, -15);
                    return false;
                }
            }
            try {
                SystemClassLoaderAdder.a(tinkerApplication, pathClassLoader, file3, arrayList);
                return true;
            } catch (Serializable th2) {
                intent.putExtra("intent_patch_exception", th2);
                ShareIntentUtil.a(intent, -14);
                return false;
            }
        }
        ShareIntentUtil.a(intent, -12);
        return false;
    }

    public static boolean a(String str, ShareSecurityCheck shareSecurityCheck, String str2, Intent intent) {
        String str3 = (String) shareSecurityCheck.Avd.get("assets/dex_meta.txt");
        if (str3 == null) {
            return true;
        }
        Asz.clear();
        AsA.clear();
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.m(str3, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        Serializable hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
            if (!b(shareDexDiffPatchInfo2)) {
                if (!ShareDexDiffPatchInfo.c(shareDexDiffPatchInfo2)) {
                    intent.putExtra("intent_patch_package_patch_check", -3);
                    ShareIntentUtil.a(intent, -8);
                    return false;
                } else if (ArB && shareDexDiffPatchInfo2.AtJ.startsWith("test.dex")) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                } else if (ArB && ShareConstants.AtI.matcher(shareDexDiffPatchInfo2.gKZ).matches()) {
                    AsA.add(shareDexDiffPatchInfo2);
                } else {
                    hashMap.put(shareDexDiffPatchInfo2.gKZ, a(shareDexDiffPatchInfo2));
                    Asz.add(shareDexDiffPatchInfo2);
                }
            }
        }
        if (ArB && !(shareDexDiffPatchInfo == null && AsA.isEmpty())) {
            if (shareDexDiffPatchInfo != null) {
                AsA.add(ShareTinkerInternals.a(shareDexDiffPatchInfo, AsA.size() + 1));
            }
            hashMap.put("tinker_classN.apk", "");
        }
        String str4 = str + "/dex/";
        File file = new File(str4);
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(str + "/" + str2 + "/");
            for (String str32 : hashMap.keySet()) {
                File file3 = new File(str4 + str32);
                if (SharePatchFileUtil.ae(file3)) {
                    file = new File(SharePatchFileUtil.n(file3, file2));
                    if (!SharePatchFileUtil.ae(file)) {
                        intent.putExtra("intent_patch_missing_dex_path", file.getAbsolutePath());
                        ShareIntentUtil.a(intent, -11);
                        return false;
                    }
                }
                intent.putExtra("intent_patch_missing_dex_path", file3.getAbsolutePath());
                ShareIntentUtil.a(intent, -10);
                return false;
            }
            intent.putExtra("intent_patch_dexes_path", hashMap);
            return true;
        }
        ShareIntentUtil.a(intent, -9);
        return false;
    }

    private static String a(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return ArB ? shareDexDiffPatchInfo.AtL : shareDexDiffPatchInfo.AtK;
    }

    private static void aco(String str) {
        SharePatchFileUtil.bP(str + "/odex/");
        if (ShareTinkerInternals.cIb()) {
            SharePatchFileUtil.bP(str + "/dex/oat" + "/");
        }
    }

    private static boolean b(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (!ArB && shareDexDiffPatchInfo.AtK.equals("0")) {
            return true;
        }
        return false;
    }
}
