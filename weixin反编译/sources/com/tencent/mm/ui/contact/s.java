package com.tencent.mm.ui.contact;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;

public final class s {
    public static final int zcA = p(16, 1, 2, 4, 64, Downloads.RECV_BUFFER_SIZE);
    public static final int zcB = p(zcy, 64, 16384, Downloads.RECV_BUFFER_SIZE);
    public static final int zcC = p(16, 2, 16384, 4);
    public static final int zcD = p(zcy, 16384, 64, Downloads.RECV_BUFFER_SIZE);
    public static final int zcE = p(zcy, 16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 8192);
    public static final int zcF = p(16, 32, 1, 4, 2, 64);
    public static final int zcG = p(zcz, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
    public static final int zcy = p(256, 16, 1, 2, 4);
    public static final int zcz = p(16, 1, 2, 4, 64, 16384);

    public static HashSet<String> cwZ() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("weixin");
        return hashSet;
    }

    public static void g(HashSet<String> hashSet) {
        hashSet.remove("filehelper");
    }

    public static HashSet<String> cxa() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (Object add : com.tencent.mm.y.s.hhb) {
            hashSet.add(add);
        }
        hashSet.add("weibo");
        hashSet.add("qqmail");
        hashSet.add("fmessage");
        hashSet.add("tmessage");
        hashSet.add("floatbottle");
        hashSet.add("lbsapp");
        hashSet.add("shakeapp");
        hashSet.add("medianote");
        hashSet.add("qqfriend");
        hashSet.add("readerapp");
        hashSet.add("newsapp");
        hashSet.add("blogapp");
        hashSet.add("facebookapp");
        hashSet.add("masssendapp");
        hashSet.add("meishiapp");
        hashSet.add("feedsapp");
        hashSet.add("voipapp");
        hashSet.add("filehelper");
        hashSet.add("officialaccounts");
        hashSet.add("helper_entry");
        hashSet.add("pc_share");
        hashSet.add("cardpackage");
        hashSet.add("voicevoipapp");
        hashSet.add("voiceinputapp");
        hashSet.add("linkedinplugin");
        hashSet.add("appbrandcustomerservicemsg");
        return hashSet;
    }

    public static boolean fd(int i, int i2) {
        return (i & i2) > 0;
    }

    public static int fe(int i, int i2) {
        return (i2 ^ -1) & i;
    }

    public static int p(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 |= iArr[i];
            i++;
        }
        return i2;
    }
}
