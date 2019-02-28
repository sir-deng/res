package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class d extends b {
    private static HashMap<ShareDexDiffPatchInfo, File> ArA = new HashMap();
    private static boolean ArB = ShareTinkerInternals.cHZ();
    private static ArrayList<File> Ary = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> Arz = new ArrayList();

    protected static boolean a(a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (ShareTinkerInternals.Jk(aVar.tinkerFlags)) {
            String str2 = (String) shareSecurityCheck.Avd.get("assets/dex_meta.txt");
            if (str2 == null) {
                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                return true;
            }
            boolean a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = str + "/dex/";
            if (b(context, str3, str2, file)) {
                File[] listFiles = new File(str3).listFiles();
                List arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            arrayList.add(file2);
                        }
                    }
                }
                a = a(context, arrayList, str + "/odex/", file);
            } else {
                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                a = false;
            }
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", Boolean.valueOf(a), Long.valueOf(elapsedRealtime));
            return a;
        }
        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
        return true;
    }

    protected static boolean a(File file, a aVar) {
        Object shareElfFile;
        Object obj = null;
        if (Ary.isEmpty()) {
            return true;
        }
        File file2;
        int size = Arz.size() * 8;
        if (size > 30) {
            size = 30;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", Integer.valueOf(Arz.size()), Integer.valueOf(Ary.size()), Integer.valueOf(size));
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = Ary.iterator();
            while (it.hasNext()) {
                if (!SharePatchFileUtil.ae((File) it.next())) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", ((File) it.next()).getName(), Integer.valueOf(i3));
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:" + e, new Object[0]);
                }
            }
        }
        List arrayList = new ArrayList();
        Iterator it2 = Ary.iterator();
        while (it2.hasNext()) {
            file2 = (File) it2.next();
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", file2.getPath(), Long.valueOf(file2.length()));
            if (!SharePatchFileUtil.ae(file2)) {
                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", file2.getName());
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            if (VERSION.SDK_INT >= 21) {
                Iterator it3 = Ary.iterator();
                Throwable th = null;
                while (it3.hasNext()) {
                    file2 = (File) it3.next();
                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", file2.getName(), Long.valueOf(file2.length()));
                    try {
                        if (ShareElfFile.ac(file2) == 1) {
                            try {
                                shareElfFile = new ShareElfFile(file2);
                            } catch (Throwable th2) {
                                th = th2;
                                shareElfFile = "Tinker.DexDiffPatchInternal";
                                com.tencent.tinker.lib.f.a.e(shareElfFile, "final parallel dex optimizer file %s is not elf format, return false", file2.getName());
                                arrayList.add(file2);
                            } finally {
                                obj = 
/*
Method generation error in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r2_3 'obj' java.lang.Object) = (r2_2 'obj' java.lang.Object), (r7_19 'shareElfFile' java.lang.Object) in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:298)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:278)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:218)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:186)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 52 more

*/

                                private static boolean acm(String str) {
                                    File file = null;
                                    if (Arz.isEmpty() || !ArB) {
                                        return false;
                                    }
                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo;
                                    File file2;
                                    boolean z;
                                    Iterator it = Arz.iterator();
                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = null;
                                    while (it.hasNext()) {
                                        ShareDexDiffPatchInfo shareDexDiffPatchInfo3;
                                        shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                                        File file3 = new File(str + shareDexDiffPatchInfo.gKZ);
                                        if (ShareConstants.AtI.matcher(file3.getName()).matches()) {
                                            ArA.put(shareDexDiffPatchInfo, file3);
                                        }
                                        if (shareDexDiffPatchInfo.AtJ.startsWith("test.dex")) {
                                            File file4 = file3;
                                            shareDexDiffPatchInfo3 = shareDexDiffPatchInfo;
                                            file2 = file4;
                                        } else {
                                            file2 = file;
                                            shareDexDiffPatchInfo3 = shareDexDiffPatchInfo2;
                                        }
                                        file = file2;
                                        shareDexDiffPatchInfo2 = shareDexDiffPatchInfo3;
                                    }
                                    if (shareDexDiffPatchInfo2 != null) {
                                        ArA.put(ShareTinkerInternals.a(shareDexDiffPatchInfo2, ArA.size() + 1), file);
                                    }
                                    file = new File(str, "tinker_classN.apk");
                                    if (file.exists()) {
                                        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo4 : ArA.keySet()) {
                                            if (!SharePatchFileUtil.b(file, shareDexDiffPatchInfo4.AtJ, shareDexDiffPatchInfo4.AtL)) {
                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo4.AtJ, Long.valueOf(file.length()));
                                                z = false;
                                                break;
                                            }
                                        }
                                        z = true;
                                        if (!z) {
                                            SharePatchFileUtil.ag(file);
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        for (File file22 : ArA.values()) {
                                            SharePatchFileUtil.ag(file22);
                                        }
                                    }
                                    return z;
                                }

                                private static boolean a(Context context, File file, String str) {
                                    Object obj;
                                    Throwable th;
                                    g gVar;
                                    Object gVar2;
                                    boolean z;
                                    if (Arz.isEmpty() || !ArB) {
                                        return true;
                                    }
                                    File file2 = new File(str, "tinker_classN.apk");
                                    if (ArA.isEmpty()) {
                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "classNDexInfo size: %d, no need to merge classN dex files", Integer.valueOf(ArA.size()));
                                        return true;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    obj = null;
                                    Object hVar;
                                    try {
                                        hVar = new h(new BufferedOutputStream(new FileOutputStream(file2)));
                                        try {
                                            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : ArA.keySet()) {
                                                File file3 = (File) ArA.get(shareDexDiffPatchInfo);
                                                if (shareDexDiffPatchInfo.AtQ) {
                                                    try {
                                                        g gVar3 = new g(file3);
                                                        try {
                                                            f acz = gVar3.acz("classes.dex");
                                                            f fVar = new f(acz, shareDexDiffPatchInfo.AtJ);
                                                            obj = gVar3.a(acz);
                                                            try {
                                                                i.a(fVar, (InputStream) obj, (h) hVar);
                                                                com.tencent.tinker.c.b.a.cA(obj);
                                                                com.tencent.tinker.c.b.a.cA(gVar3);
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                gVar2 = gVar3;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            obj = null;
                                                            gVar2 = gVar3;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        obj = null;
                                                        gVar2 = null;
                                                    }
                                                } else {
                                                    i.a(new f(shareDexDiffPatchInfo.AtJ), file3, Long.parseLong(shareDexDiffPatchInfo.AtN), hVar);
                                                }
                                            }
                                            com.tencent.tinker.c.b.a.cA(hVar);
                                            z = true;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        hVar = null;
                                        com.tencent.tinker.c.b.a.cA(hVar);
                                        throw th;
                                    }
                                    if (z) {
                                        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : ArA.keySet()) {
                                            if (SharePatchFileUtil.b(file2, shareDexDiffPatchInfo2.AtJ, shareDexDiffPatchInfo2.AtL)) {
                                                z = false;
                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo2.AtJ, Long.valueOf(file2.length()));
                                                break;
                                            }
                                        }
                                    }
                                    if (z) {
                                        while (r4.hasNext()) {
                                            SharePatchFileUtil.ag(r2);
                                        }
                                    } else {
                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "merge classN dex error, try delete temp file", new Object[0]);
                                        SharePatchFileUtil.ag(file2);
                                        a.ir(context).ArO.a(file, file2, file2.getName(), 7);
                                    }
                                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "merge classN dex file %s, result: %b, size: %d, use: %dms", file2.getPath(), Boolean.valueOf(z), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    return z;
                                    com.tencent.tinker.c.b.a.cA(obj);
                                    com.tencent.tinker.c.b.a.cA(gVar2);
                                    throw th;
                                }

                                private static boolean a(Context context, List<File> list, String str, File file) {
                                    a ir = a.ir(context);
                                    Ary.clear();
                                    File file2 = new File(str);
                                    if (file2.exists() || file2.mkdirs()) {
                                        for (File n : list) {
                                            Ary.add(new File(SharePatchFileUtil.n(n, file2)));
                                        }
                                        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
                                        final List vector = new Vector();
                                        final Throwable[] thArr = new Throwable[1];
                                        TinkerDexOptimizer.a(list, file2, new ResultCallback() {
                                            long startTime;

                                            public final void X(File file) {
                                                this.startTime = System.currentTimeMillis();
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", file.getPath(), Long.valueOf(file.length()));
                                            }

                                            public final void l(File file, File file2) {
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", file.getPath(), file2.getPath(), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - this.startTime));
                                            }

                                            public final void b(File file, Throwable th) {
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime));
                                                vector.add(file);
                                                thArr[0] = th;
                                            }
                                        });
                                        if (vector.isEmpty()) {
                                            return true;
                                        }
                                        ir.ArO.a(file, vector, thArr[0]);
                                        return false;
                                    }
                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
                                    return false;
                                }

                                private static boolean b(Context context, String str, String str2, File file) {
                                    Throwable th;
                                    ZipFile zipFile;
                                    Throwable th2;
                                    Arz.clear();
                                    ShareDexDiffPatchInfo.m(str2, Arz);
                                    if (Arz.isEmpty()) {
                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", ShareTinkerInternals.Jn(3));
                                        return true;
                                    }
                                    File file2 = new File(str);
                                    if (!file2.exists()) {
                                        file2.mkdirs();
                                    }
                                    a ir = a.ir(context);
                                    ZipFile zipFile2;
                                    try {
                                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                                        if (applicationInfo == null) {
                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                                            SharePatchFileUtil.a(null);
                                            SharePatchFileUtil.a(null);
                                            return false;
                                        }
                                        ZipFile zipFile3 = new ZipFile(applicationInfo.sourceDir);
                                        try {
                                            zipFile2 = new ZipFile(file);
                                            try {
                                                if (acm(str)) {
                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", "tinker_classN.apk");
                                                    SharePatchFileUtil.a(zipFile3);
                                                    SharePatchFileUtil.a(zipFile2);
                                                    return true;
                                                }
                                                Iterator it = Arz.iterator();
                                                while (it.hasNext()) {
                                                    String str3;
                                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    if (shareDexDiffPatchInfo.path.equals("")) {
                                                        str3 = shareDexDiffPatchInfo.AtJ;
                                                    } else {
                                                        str3 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.AtJ;
                                                    }
                                                    String str4 = shareDexDiffPatchInfo.AtO;
                                                    String str5 = shareDexDiffPatchInfo.AtM;
                                                    if (ArB || !shareDexDiffPatchInfo.AtK.equals("0")) {
                                                        String str6 = ArB ? shareDexDiffPatchInfo.AtL : shareDexDiffPatchInfo.AtK;
                                                        if (SharePatchFileUtil.acv(str6)) {
                                                            File file3 = new File(str + shareDexDiffPatchInfo.gKZ);
                                                            if (!file3.exists()) {
                                                                file3.getParentFile().mkdirs();
                                                            } else if (SharePatchFileUtil.g(file3, str6)) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", file3.getPath());
                                                            } else {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                                                file3.delete();
                                                            }
                                                            ZipEntry entry = zipFile2.getEntry(str3);
                                                            ZipEntry entry2 = zipFile3.getEntry(str3);
                                                            if (str5.equals("0")) {
                                                                if (entry == null) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                                                    ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    SharePatchFileUtil.a(zipFile2);
                                                                    return false;
                                                                } else if (!a(zipFile2, entry, file3, shareDexDiffPatchInfo)) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                                                    ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    SharePatchFileUtil.a(zipFile2);
                                                                    return false;
                                                                }
                                                            } else if (str4.equals("0")) {
                                                                if (!ArB) {
                                                                    continue;
                                                                } else if (entry2 == null) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                                                    ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    SharePatchFileUtil.a(zipFile2);
                                                                    return false;
                                                                } else {
                                                                    if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                                                        a(zipFile3, entry2, file3, shareDexDiffPatchInfo);
                                                                        if (!SharePatchFileUtil.g(file3, str6)) {
                                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                                            ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                            SharePatchFileUtil.ag(file3);
                                                                            SharePatchFileUtil.a(zipFile3);
                                                                            SharePatchFileUtil.a(zipFile2);
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                                                                        ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                        SharePatchFileUtil.a(zipFile3);
                                                                        SharePatchFileUtil.a(zipFile2);
                                                                        return false;
                                                                    }
                                                                }
                                                            } else if (entry == null) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                                                ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile2);
                                                                return false;
                                                            } else if (!SharePatchFileUtil.acv(str4)) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.Jn(3), shareDexDiffPatchInfo.AtJ, str4);
                                                                ir.ArO.d(file, b.Jj(3));
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile2);
                                                                return false;
                                                            } else if (entry2 == null) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                                                ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile2);
                                                                return false;
                                                            } else {
                                                                if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                                                    a(zipFile3, zipFile2, entry2, entry, shareDexDiffPatchInfo, file3);
                                                                    if (SharePatchFileUtil.g(file3, str6)) {
                                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                                                    } else {
                                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                                        ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                        SharePatchFileUtil.ag(file3);
                                                                        SharePatchFileUtil.a(zipFile3);
                                                                        SharePatchFileUtil.a(zipFile2);
                                                                        return false;
                                                                    }
                                                                }
                                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, String.valueOf(entry2.getCrc()));
                                                                ir.ArO.a(file, file3, shareDexDiffPatchInfo.AtJ, 3);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                SharePatchFileUtil.a(zipFile2);
                                                                return false;
                                                            }
                                                        }
                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.Jn(3), shareDexDiffPatchInfo.AtJ, str6);
                                                        ir.ArO.d(file, b.Jj(3));
                                                        SharePatchFileUtil.a(zipFile3);
                                                        SharePatchFileUtil.a(zipFile2);
                                                        return false;
                                                    }
                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", str3);
                                                }
                                                if (a(context, file, str)) {
                                                    SharePatchFileUtil.a(zipFile3);
                                                    SharePatchFileUtil.a(zipFile2);
                                                    return true;
                                                }
                                                SharePatchFileUtil.a(zipFile3);
                                                SharePatchFileUtil.a(zipFile2);
                                                return false;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                zipFile = zipFile3;
                                                th2 = th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            zipFile2 = null;
                                            zipFile = zipFile3;
                                            th2 = th;
                                            SharePatchFileUtil.a(zipFile);
                                            SharePatchFileUtil.a(zipFile2);
                                            throw th2;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        zipFile = null;
                                        zipFile2 = null;
                                        SharePatchFileUtil.a(zipFile);
                                        SharePatchFileUtil.a(zipFile2);
                                        throw th2;
                                    }
                                }

                                private static boolean b(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
                                    Object bufferedInputStream;
                                    Throwable th;
                                    ZipOutputStream zipOutputStream;
                                    Object zipOutputStream2 = null;
                                    boolean z = false;
                                    int i = 0;
                                    while (i < 2 && !z) {
                                        int i2 = i + 1;
                                        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
                                        try {
                                            ZipOutputStream zipOutputStream3 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                                            try {
                                                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                                try {
                                                    byte[] bArr = new byte[16384];
                                                    zipOutputStream3.putNextEntry(new ZipEntry("classes.dex"));
                                                    for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                                                        zipOutputStream3.write(bArr, 0, read);
                                                    }
                                                    zipOutputStream3.closeEntry();
                                                    com.tencent.tinker.c.b.a.cA(bufferedInputStream);
                                                    com.tencent.tinker.c.b.a.cA(zipOutputStream3);
                                                    z = SharePatchFileUtil.g(file, str);
                                                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z));
                                                    if (!z && (!file.delete() || file.exists())) {
                                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                                                    }
                                                    i = i2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    zipOutputStream2 = zipOutputStream3;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                bufferedInputStream = null;
                                                zipOutputStream2 = zipOutputStream3;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bufferedInputStream = null;
                                        }
                                    }
                                    return z;
                                    com.tencent.tinker.c.b.a.cA(bufferedInputStream);
                                    com.tencent.tinker.c.b.a.cA(zipOutputStream2);
                                    throw th;
                                }

                                private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
                                    String str = ArB ? shareDexDiffPatchInfo.AtL : shareDexDiffPatchInfo.AtK;
                                    String str2 = shareDexDiffPatchInfo.AtJ;
                                    boolean z = shareDexDiffPatchInfo.AtQ;
                                    if (SharePatchFileUtil.acw(str2) && z) {
                                        return b(zipFile, zipEntry, file, str);
                                    }
                                    return b.a(zipFile, zipEntry, file, str, true);
                                }

                                private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
                                    Throwable th;
                                    Object obj;
                                    Object obj2 = null;
                                    try {
                                        InputStream bufferedInputStream;
                                        InputStream obj3;
                                        InputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                        if (zipEntry2 != null) {
                                            try {
                                                bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                                            } catch (Throwable th2) {
                                                th = th2;
                                                obj3 = bufferedInputStream2;
                                                com.tencent.tinker.c.b.a.cA(obj3);
                                                com.tencent.tinker.c.b.a.cA(obj2);
                                                throw th;
                                            }
                                        }
                                        bufferedInputStream = null;
                                        try {
                                            boolean acw = SharePatchFileUtil.acw(shareDexDiffPatchInfo.AtJ);
                                            if (!acw || shareDexDiffPatchInfo.AtQ) {
                                                try {
                                                    OutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                                                    try {
                                                        zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                                                        if (acw) {
                                                            new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream).b(zipOutputStream);
                                                        } else {
                                                            try {
                                                                ZipEntry nextEntry;
                                                                obj3 = new ZipInputStream(bufferedInputStream2);
                                                                do {
                                                                    try {
                                                                        nextEntry = obj3.getNextEntry();
                                                                        if (nextEntry == null) {
                                                                            break;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                    }
                                                                } while (!"classes.dex".equals(nextEntry.getName()));
                                                                if (nextEntry == null) {
                                                                    throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                                                }
                                                                new com.tencent.tinker.c.a.a(obj3, bufferedInputStream).b(zipOutputStream);
                                                                com.tencent.tinker.c.b.a.cA(obj3);
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                obj3 = null;
                                                                com.tencent.tinker.c.b.a.cA(obj3);
                                                                throw th;
                                                            }
                                                        }
                                                        zipOutputStream.closeEntry();
                                                        com.tencent.tinker.c.b.a.cA(zipOutputStream);
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        obj2 = zipOutputStream;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    com.tencent.tinker.c.b.a.cA(obj2);
                                                    throw th;
                                                }
                                            }
                                            com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream);
                                            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                            try {
                                                aVar.b(bufferedOutputStream);
                                                com.tencent.tinker.c.b.a.cA(bufferedOutputStream);
                                            } catch (Throwable th7) {
                                                th = th7;
                                                OutputStream obj22 = bufferedOutputStream;
                                                com.tencent.tinker.c.b.a.cA(obj22);
                                                throw th;
                                            }
                                            com.tencent.tinker.c.b.a.cA(bufferedInputStream2);
                                            com.tencent.tinker.c.b.a.cA(bufferedInputStream);
                                        } catch (Throwable th8) {
                                            th = th8;
                                            obj22 = bufferedInputStream;
                                            obj3 = bufferedInputStream2;
                                            com.tencent.tinker.c.b.a.cA(obj3);
                                            com.tencent.tinker.c.b.a.cA(obj22);
                                            throw th;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        obj3 = null;
                                        com.tencent.tinker.c.b.a.cA(obj3);
                                        com.tencent.tinker.c.b.a.cA(obj22);
                                        throw th;
                                    }
                                }
                            }
