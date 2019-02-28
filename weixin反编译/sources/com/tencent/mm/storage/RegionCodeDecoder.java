package com.tencent.mm.storage;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder xIt = null;
    public static final String xIu = (e.hbu + "MicroMsg/regioncode/");
    public String xIv = "";
    private String xIw = "";

    private static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    public static class Region {
        private String code;
        private String countryCode;
        private boolean hasChildren = false;
        private boolean isCity = false;
        private boolean isCountry = false;
        private boolean isProvince = false;
        private String name;
        private Region parent = null;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }

        public void setParent(Region region) {
            this.parent = region;
        }

        public Region getParent() {
            return this.parent;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public boolean isCountry() {
            return this.isCountry;
        }

        public void setCountry(boolean z) {
            this.isCountry = z;
        }

        public boolean isProvince() {
            return this.isProvince;
        }

        public void setProvince(boolean z) {
            this.isProvince = z;
        }

        public boolean isCity() {
            return this.isCity;
        }

        public void setCity(boolean z) {
            this.isCity = z;
        }
    }

    public static RegionCodeDecoder ckE() {
        if (xIt == null) {
            xIt = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = xIt;
        if (!w.cfV().equals(regionCodeDecoder.xIv)) {
            regionCodeDecoder.ciC();
        }
        return xIt;
    }

    public final void ciC() {
        File file = new File(xIu);
        if (!file.exists()) {
            file.mkdir();
            I(file);
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            I(file);
        }
        this.xIv = w.cfV();
        String ckF = ckF();
        if (bi.oN(ckF)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.xIv);
            return;
        }
        String str = xIu + ckF;
        File file2 = new File(str);
        ckF = G(file2);
        if (bi.oN(ckF) ? false : ckF.equals(H(file2))) {
            ckF = str;
        } else {
            File file3;
            if (k.A(ad.getContext(), "regioncode/" + file2.getName(), str)) {
                ckF = str;
            } else {
                file3 = new File(file2.getParentFile(), "mmregioncode_en.txt");
                ckF = file3.getAbsolutePath();
                if (!k.A(ad.getContext(), "regioncode/mmregioncode_en.txt", file3.getAbsolutePath())) {
                    ckF = null;
                }
            }
            file3 = new File(ckF);
            f(file3, file3.getParentFile());
            x.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", file2.getName(), file3.getName());
        }
        if (bi.oN(ckF)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.xIv);
        } else if (bi.oN(this.xIw) || !this.xIw.equals(str) || !str.equals(ckF)) {
            x.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new File(ckF).getName(), this.xIv);
            this.xIw = ckF;
            DecoderJni.buildFromFile(this.xIw);
        }
    }

    private static String G(File file) {
        Throwable th;
        Throwable th2;
        String str = null;
        File file2 = new File(file.getAbsolutePath() + ".hash");
        if (file2.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                try {
                    str = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                bufferedReader = str;
                th2 = th5;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        }
        return str;
    }

    public static void f(File file, File file2) {
        Throwable th;
        x.i("MicroMsg.RegionCodeDecoder", "Generating hash file for: %s", file.getName());
        File file3 = new File(file2, file.getName() + ".hash");
        String H = H(file);
        if (!bi.oN(H)) {
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
            }
            PrintWriter printWriter;
            try {
                printWriter = new PrintWriter(file3);
                try {
                    printWriter.print(H);
                    try {
                        printWriter.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        x.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to save hash file of %s", file.getName());
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th4) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th6) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        }
    }

    private static String H(File file) {
        String i = g.i(file);
        if (!bi.oN(i)) {
            return ac.VF(i + "#" + file.lastModified() + "#" + q.yL());
        }
        x.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", file.getName());
        return null;
    }

    private synchronized void I(File file) {
        synchronized (this) {
            String[] strArr = null;
            if (file.exists()) {
                strArr = file.list();
            }
            if (!file.exists() || strArr == null || strArr.length == 0) {
                try {
                    for (String str : ad.getContext().getAssets().list("regioncode")) {
                        x.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/" + str, file.getPath() + "/" + str);
                        String str2 = file.getPath() + "/" + str;
                        k.A(ad.getContext(), "regioncode/" + str, str2);
                        f(new File(str2), file);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RegionCodeDecoder", e, "", new Object[0]);
                }
            }
        }
        return;
    }

    public final String ckF() {
        String str = "mmregioncode_" + (this.xIv.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.xIv) + ".txt";
        String str2 = "mmregioncode_en.txt";
        File file = new File(xIu);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            return obj != null ? str2 : null;
        } else {
            file.mkdir();
            return null;
        }
    }

    public static final String ai(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bi.oN(str)) {
            stringBuffer.append(str);
            if (!bi.oN(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!bi.oN(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String Yk(String str) {
        if (bi.oN(str) || !w.VB(str)) {
            x.e("MicroMsg.RegionCodeDecoder", "unsupported language:" + str);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        return xIu + "mmregioncode_" + str + ".txt";
    }

    public static final boolean Yl(String str) {
        if (bi.oN(str)) {
            return false;
        }
        return str.equalsIgnoreCase("cn");
    }

    public static String getLocName(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return DecoderJni.getLocName(str);
    }

    public final String Ym(String str) {
        String locName = getLocName(str);
        return bi.oN(locName) ? bi.oM(str) : locName;
    }

    public final String fK(String str, String str2) {
        String str3 = null;
        if (!(bi.oN(str) || bi.oN(str2))) {
            str3 = getLocName(ai(str, str2, null));
        }
        return bi.oN(str3) ? bi.oM(str2) : str3;
    }

    public final String aj(String str, String str2, String str3) {
        String locName = (bi.oN(str) || bi.oN(str2) || bi.oN(str3)) ? null : getLocName(ai(str, str2, str3));
        return bi.oN(locName) ? bi.oM(str3) : locName;
    }

    public final Region[] ckG() {
        if (bi.oN(this.xIw)) {
            return null;
        }
        return DecoderJni.getCountries(this.xIw);
    }

    public final Region[] Yn(String str) {
        if (bi.oN(this.xIw) || bi.oN(str)) {
            return null;
        }
        return DecoderJni.getProvinces(this.xIw, str);
    }

    public final Region[] fL(String str, String str2) {
        if (bi.oN(this.xIw) || bi.oN(str) || bi.oN(str2)) {
            return null;
        }
        return DecoderJni.getCities(this.xIw, str, str2);
    }
}
