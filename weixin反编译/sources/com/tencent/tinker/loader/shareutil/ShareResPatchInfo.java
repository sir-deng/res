package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ShareResPatchInfo {
    public String AuS = null;
    public String AuT = null;
    public ArrayList<String> AuU = new ArrayList();
    public ArrayList<String> AuV = new ArrayList();
    public ArrayList<String> AuW = new ArrayList();
    public HashMap<String, File> AuX = new HashMap();
    public ArrayList<String> AuY = new ArrayList();
    public HashMap<String, LargeModeInfo> AuZ = new HashMap();
    public HashSet<Pattern> Ava = new HashSet();

    public static class LargeModeInfo {
        public long Avb;
        public File file = null;
        public String frM = null;
    }

    public static void a(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String[] split = str.split("\n");
            int i = 0;
            while (i < split.length) {
                String str2 = split[i];
                if (str2 != null && str2.length() > 0) {
                    int i2;
                    if (str2.startsWith("resources_out.zip")) {
                        String[] split2 = str2.split(",", 3);
                        shareResPatchInfo.AuS = split2[1];
                        shareResPatchInfo.AuT = split2[2];
                    } else if (str2.startsWith("pattern:")) {
                        i2 = i;
                        for (int parseInt = Integer.parseInt(str2.split(":", 2)[1]); parseInt > 0; parseInt--) {
                            HashSet hashSet = shareResPatchInfo.Ava;
                            String str3 = split[i2 + 1];
                            if (str3.contains(".")) {
                                str3 = str3.replaceAll("\\.", "\\\\.");
                            }
                            if (str3.contains("?")) {
                                str3 = str3.replaceAll("\\?", "\\.");
                            }
                            if (str3.contains("*")) {
                                str3 = str3.replace("*", ".*");
                            }
                            hashSet.add(Pattern.compile(str3));
                            i2++;
                        }
                        i = i2;
                    } else if (str2.startsWith("add:")) {
                        i2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (i2 > 0) {
                            shareResPatchInfo.AuU.add(split[i + 1]);
                            i2--;
                            i++;
                        }
                    } else if (str2.startsWith("modify:")) {
                        i2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (i2 > 0) {
                            shareResPatchInfo.AuW.add(split[i + 1]);
                            i2--;
                            i++;
                        }
                    } else if (str2.startsWith("large modify:")) {
                        i2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (i2 > 0) {
                            String[] split3 = split[i + 1].split(",", 3);
                            Object obj = split3[0];
                            LargeModeInfo largeModeInfo = new LargeModeInfo();
                            largeModeInfo.frM = split3[1];
                            largeModeInfo.Avb = Long.parseLong(split3[2]);
                            shareResPatchInfo.AuY.add(obj);
                            shareResPatchInfo.AuZ.put(obj, largeModeInfo);
                            i2--;
                            i++;
                        }
                    } else if (str2.startsWith("delete:")) {
                        i2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (i2 > 0) {
                            shareResPatchInfo.AuV.add(split[i + 1]);
                            i2--;
                            i++;
                        }
                    } else if (str2.startsWith("store:")) {
                        i2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (i2 > 0) {
                            shareResPatchInfo.AuX.put(split[i + 1], null);
                            i2--;
                            i++;
                        }
                    }
                }
                i++;
            }
        }
    }

    public static boolean a(HashSet<Pattern> hashSet, String str) {
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((Pattern) it.next()).matcher(str).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(ShareResPatchInfo shareResPatchInfo) {
        if (shareResPatchInfo == null) {
            return false;
        }
        String str = shareResPatchInfo.AuT;
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static void b(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String str2 = str.split("\n")[0];
            if (str2 == null || str2.length() <= 0) {
                throw new TinkerRuntimeException("res meta Corrupted:" + str);
            }
            String[] split = str2.split(",", 3);
            shareResPatchInfo.AuS = split[1];
            shareResPatchInfo.AuT = split[2];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resArscMd5:" + this.AuT + "\n");
        stringBuffer.append("arscBaseCrc:" + this.AuS + "\n");
        Iterator it = this.Ava.iterator();
        while (it.hasNext()) {
            stringBuffer.append("pattern:" + ((Pattern) it.next()) + "\n");
        }
        it = this.AuU.iterator();
        while (it.hasNext()) {
            stringBuffer.append("addedSet:" + ((String) it.next()) + "\n");
        }
        it = this.AuW.iterator();
        while (it.hasNext()) {
            stringBuffer.append("modifiedSet:" + ((String) it.next()) + "\n");
        }
        it = this.AuY.iterator();
        while (it.hasNext()) {
            stringBuffer.append("largeModifiedSet:" + ((String) it.next()) + "\n");
        }
        it = this.AuV.iterator();
        while (it.hasNext()) {
            stringBuffer.append("deletedSet:" + ((String) it.next()) + "\n");
        }
        for (String str : this.AuX.keySet()) {
            stringBuffer.append("storeSet:" + str + "\n");
        }
        return stringBuffer.toString();
    }
}
