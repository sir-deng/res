package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String AtJ;
    public final String AtK;
    public final String AtL;
    public final String AtM;
    public final String AtN;
    public final String AtO;
    public final String AtP;
    public final boolean AtQ;
    public final String gKZ;
    public final String path;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.AtJ = str;
        this.path = str2;
        this.AtK = str3;
        this.AtL = str4;
        this.AtO = str5;
        this.AtM = str6;
        this.AtN = str7;
        this.AtP = str8;
        if (str8.equals("jar")) {
            this.AtQ = true;
            if (SharePatchFileUtil.acw(str)) {
                this.gKZ = str + ".jar";
            } else {
                this.gKZ = str;
            }
        } else if (str8.equals("raw")) {
            this.AtQ = false;
            this.gKZ = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:" + str8);
        }
    }

    public static void m(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 8);
                    if (split != null && split.length >= 8) {
                        arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                    }
                }
            }
        }
    }

    public static boolean c(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.AtJ;
        String str2 = ShareTinkerInternals.cHZ() ? shareDexDiffPatchInfo.AtL : shareDexDiffPatchInfo.AtK;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.AtJ);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.AtK);
        stringBuffer.append(",");
        stringBuffer.append(this.AtL);
        stringBuffer.append(",");
        stringBuffer.append(this.AtM);
        stringBuffer.append(",");
        stringBuffer.append(this.AtN);
        stringBuffer.append(",");
        stringBuffer.append(this.AtO);
        stringBuffer.append(",");
        stringBuffer.append(this.AtP);
        return stringBuffer.toString();
    }
}
