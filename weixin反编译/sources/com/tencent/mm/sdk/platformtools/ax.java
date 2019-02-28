package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ax {
    static String[] xqc = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] xqd = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] xqe = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] xqf = new String[]{"/dev/block/vold"};

    public static class a {
        public boolean bpI;
        public String xqg;
        public String xqh;
        public String xqi;
        public long xqj;
        public long xqk;
        public long xql;
        public long xqm;
        a xqn;

        public final String toString() {
            return "{DevName=" + this.xqg + ", MountDir=" + this.xqh + ", FileSystem=" + this.xqi + ", TotalBlocks=" + this.xqj + ", FreeBlocks=" + this.xqk + ", AvailableBlocks=" + this.xql + ", BlockSize=" + this.xqm + ", Shared=" + (this.xqn != null) + "}";
        }

        public final boolean equals(Object obj) {
            a aVar = (a) obj;
            if (this.xqm != aVar.xqm) {
                return false;
            }
            long j = this.xqj - aVar.xqj;
            long j2 = this.xqk - aVar.xqk;
            long j3 = this.xql - aVar.xql;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                return false;
            }
            return true;
        }
    }

    private static ArrayList<a> cgL() {
        Throwable e;
        Exception e2;
        ArrayList<a> arrayList = new ArrayList();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split == null || split.length < 3) {
                            x.e("MicroMsg.SdcardUtil", "splite failed for line: " + readLine);
                        } else {
                            a aVar = new a();
                            aVar.xqg = split[0];
                            aVar.xqh = split[1];
                            aVar.xqi = split[2];
                            arrayList.add(aVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            break;
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader = null;
            try {
                x.e("MicroMsg.SdcardUtil", "parseProcMounts", e2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                e32 = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e6) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e6, "", new Object[0]);
                    }
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e32;
        }
        return arrayList;
    }

    private static void a(a aVar) {
        try {
            StatFs statFs = new StatFs(aVar.xqh);
            aVar.xqm = (long) statFs.getBlockSize();
            aVar.xql = (long) statFs.getAvailableBlocks();
            aVar.xqj = (long) statFs.getBlockCount();
            aVar.xqk = (long) statFs.getFreeBlocks();
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
        }
    }

    private static boolean b(a aVar) {
        boolean delete;
        IOException e;
        Throwable e2;
        File file = new File(aVar.xqh, "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                delete = file.delete();
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            try {
                x.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.xqh);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        delete = false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                        delete = false;
                    }
                } else {
                    delete = false;
                }
                aVar.bpI = delete;
                return delete;
            } catch (Throwable th) {
                e22 = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
        aVar.bpI = delete;
        return delete;
    }

    private static a cgM() {
        a aVar;
        ArrayList cgL = cgL();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = cgL.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.xqh.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.xqh = absolutePath;
            aVar.xqg = "Unknown";
            aVar.xqi = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    private static a cgN() {
        a aVar;
        ArrayList cgL = cgL();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = cgL.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.xqh.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.xqh = absolutePath;
            aVar.xqg = "Unknown";
            aVar.xqi = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    public static ArrayList<a> cgO() {
        a aVar;
        int i;
        int size;
        a aVar2;
        ArrayList<a> cgL = cgL();
        int size2 = cgL.size();
        List asList = Arrays.asList(xqd);
        List<String> asList2 = Arrays.asList(xqe);
        List<String> asList3 = Arrays.asList(xqf);
        for (int i2 = size2 - 1; i2 >= 0; i2--) {
            aVar = (a) cgL.get(i2);
            if (asList.contains(aVar.xqi)) {
                i = 0;
                for (String startsWith : asList2) {
                    i = aVar.xqh.startsWith(startsWith) | i;
                }
                if (i != 0) {
                    cgL.remove(i2);
                    x.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + aVar.xqh);
                } else if (aVar.xqi.equals("fuse") || aVar.xqi.equals("sdcardfs")) {
                    if (aVar.xqg.startsWith("/data/")) {
                        cgL.remove(i2);
                        x.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + aVar.xqg);
                    }
                } else if (!(aVar.xqi.equals("fuse") || aVar.xqi.equals("sdcardfs"))) {
                    i = 0;
                    for (String startsWith2 : asList3) {
                        i = aVar.xqg.startsWith(startsWith2) | i;
                    }
                    if (i == 0) {
                        cgL.remove(i2);
                        x.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + aVar.xqg);
                    }
                }
            } else {
                cgL.remove(i2);
                x.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + aVar.xqi);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = cgL.size() - 1; size >= 0; size--) {
            aVar = (a) cgL.get(size);
            if (aVar.xqh.equals(path)) {
                cgL.remove(size);
                cgL.add(0, aVar);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            aVar = new a();
            aVar.xqh = path;
            aVar.xqi = "unknown";
            aVar.xqg = "unknown";
            cgL.add(0, aVar);
        }
        for (size = cgL.size() - 1; size >= 0; size--) {
            aVar = (a) cgL.get(size);
            File file = new File(aVar.xqh);
            if (!file.exists() || !file.isDirectory()) {
                x.d("MicroMsg.SdcardUtil", "Directory verify failed: " + aVar);
                cgL.remove(size);
            }
        }
        for (size = cgL.size() - 1; size >= 0; size--) {
            aVar = (a) cgL.get(size);
            if (!b(aVar)) {
                x.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + aVar);
                cgL.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!cgL.isEmpty()) {
            i = cgL.size() - 1;
            aVar2 = (a) cgL.remove(0);
            while (i >= 0) {
                aVar = (a) cgL.get(i);
                if (aVar2.xqg.equals(aVar.xqg)) {
                    cgL.remove(i);
                    x.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + aVar2.xqg);
                    if (!aVar2.bpI && aVar.bpI) {
                        x.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i--;
                        aVar2 = aVar;
                    }
                }
                aVar = aVar2;
                i--;
                aVar2 = aVar;
            }
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
        cgL.clear();
        while (!arrayList.isEmpty()) {
            aVar2 = (a) arrayList.remove(0);
            cgL.add(aVar2);
            for (i = arrayList.size() - 1; i >= 0; i--) {
                aVar = (a) arrayList.get(i);
                if (aVar2.equals(aVar)) {
                    x.d("MicroMsg.SdcardUtil", "Duplicate:" + aVar2.toString() + "---" + aVar.toString());
                    arrayList.remove(i);
                }
            }
        }
        return cgL;
    }

    public static long cgP() {
        a cgM = cgM();
        return cgM.xqm * cgM.xql;
    }

    public static long cgQ() {
        a cgN = cgN();
        return cgN.xqm * cgN.xql;
    }

    public static boolean cgR() {
        a aVar;
        boolean z;
        a aVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList cgL = cgL();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = cgL.iterator();
        a aVar3 = null;
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar3 == null && aVar.xqh.equals(absolutePath)) {
                if (aVar2 != null) {
                    aVar3 = aVar;
                    break;
                }
                aVar3 = aVar;
            } else {
                if (aVar2 == null && aVar.xqh.equals(absolutePath2)) {
                    if (aVar3 != null) {
                        aVar2 = aVar;
                        break;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
        }
        if (aVar3 != null && aVar2 == null && !bi.oN(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(bi.getInt(substring, -1)));
            if (bi.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!bi.oN(absolutePath)) {
                    Iterator it2 = cgL.iterator();
                    while (it2.hasNext()) {
                        aVar = (a) it2.next();
                        if (aVar.xqh.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        aVar = aVar2;
        if (!(aVar3 == null || aVar == null)) {
            a(aVar3);
            a(aVar);
            x.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", aVar3, aVar);
            if ((aVar.xqi.equals("fuse") || aVar.xqi.equals("sdcardfs") || aVar.xqi.equals("esdfs")) && aVar3.xqj >= aVar.xqj && aVar.xqj > 0 && aVar3.xqm >= aVar.xqm && aVar.xqm > 0 && aVar3.xql >= aVar.xql) {
                z = true;
                x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
        }
        z = false;
        x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    public static String VT(String str) {
        String str2 = "";
        if (bi.oN(str)) {
            return str2;
        }
        a aVar;
        ArrayList cgL = cgL();
        Iterator it = cgL.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (str.equals(aVar.xqh)) {
                str2 = aVar.xqi;
                break;
            }
        }
        x.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
        if (!bi.oN(str2) || !str.contains("emulated")) {
            return str2;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        x.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(bi.getInt(substring, -1)));
        if (bi.getInt(substring, -1) == -1) {
            return str2;
        }
        String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
        if (bi.oN(substring2)) {
            return str2;
        }
        Iterator it2 = cgL.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            if (substring2.equals(aVar.xqh)) {
                x.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, aVar.xqi);
                return aVar.xqi;
            }
        }
        return str2;
    }
}
