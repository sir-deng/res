package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.c.g;
import java.util.ArrayList;

public class h {
    public static h Ayc = new h();
    static final String TAG = h.class.getCanonicalName();
    public int Ayd = 0;
    int Aye = 0;
    long Ayf = 0;
    long Ayg = 0;
    int Ayh = 0;
    public int Ayi = 0;
    int Ayj = 0;
    long Ayk = 0;
    int Ayl;
    int Aym = -1;
    String Ayn;
    int Ayo;
    StringBuffer Ayp = new StringBuffer();
    long Ayq = 0;
    long Ayr = 0;
    long Ays = 0;
    String deviceModel;
    public String groupId = "";
    public int nJK = -1;
    public int nJe = 0;
    public long nJf = 0;
    long nKA = 0;
    int nKB = 0;
    public int netType = -1;
    int sCA = 0;
    long sCB = 0;
    int sCG = 0;
    public int sCH = 0;
    String sCM = "";
    int sCt = 0;
    int sCw = 0;
    public int suB = 0;
    public int suI = -1;
    public int suu = 1;
    public int sux = 0;
    public int suy = 0;
    public String zVY = "";

    public final String cIS() {
        int i;
        c.d(TAG, "collectInfo");
        this.Ayn = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.Ayo = VERSION.SDK_INT;
        this.sCM = VERSION.RELEASE;
        this.netType = k.iO(d.syL);
        this.Ayl = -1;
        this.Aym = -1;
        Iterable arrayList = new ArrayList();
        arrayList.add(this.groupId);
        arrayList.add(this.zVY);
        arrayList.add(Integer.valueOf(this.suu));
        arrayList.add(Integer.valueOf(this.nJe));
        arrayList.add(Long.valueOf(this.nJf));
        arrayList.add(Integer.valueOf(this.nJK));
        arrayList.add(Integer.valueOf(this.sCt));
        arrayList.add(Integer.valueOf(this.sCA));
        arrayList.add(Integer.valueOf(this.sCw));
        arrayList.add(Integer.valueOf(this.nKB));
        arrayList.add(Integer.valueOf(this.Ayd));
        arrayList.add(Integer.valueOf(this.Aye));
        arrayList.add(Long.valueOf(this.Ayf));
        arrayList.add(Long.valueOf(this.Ayg));
        arrayList.add(Integer.valueOf(this.Ayh));
        arrayList.add(Integer.valueOf(this.Ayi));
        arrayList.add(Integer.valueOf(this.Ayj));
        arrayList.add(Long.valueOf(this.Ayk));
        arrayList.add(Long.valueOf(this.sCB));
        arrayList.add(Long.valueOf(this.nKA));
        arrayList.add(Integer.valueOf(this.sCG));
        arrayList.add(Integer.valueOf(this.sCH));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.Ayl));
        arrayList.add(Integer.valueOf(this.Aym));
        arrayList.add(this.Ayn);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.Ayo));
        arrayList.add(this.sCM);
        TalkRoom acE = c.cIA().acE(this.groupId);
        if (acE == null) {
            i = 0;
        } else {
            i = acE.Awj.size();
            c.d("TalkRoomManager", "getGroupMemberSize groupid: ", r3, " size: ", Integer.valueOf(i));
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(this.Ayp.toString());
        arrayList.add(Integer.valueOf(this.suI));
        arrayList.add(Integer.valueOf(this.suB));
        arrayList.add(Integer.valueOf(this.sux));
        arrayList.add(Integer.valueOf(this.suy));
        String a = g.a(arrayList, ",", "_");
        c.d(TAG, "logBuf: ", this.Ayp.toString());
        c.d(TAG, "statresult", a);
        return a;
    }

    public static void a(String str, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            c.m(TAG, "uploadTempReport groupId is null");
            return;
        }
        c.m(TAG, "uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.nJe = i;
        hVar.nJf = j;
        hVar.Q(strArr);
        acM(hVar.cIS());
    }

    public static void a(String str, String str2, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            c.m(TAG, "uploadTempReport groupId and clientGroupId is null");
            return;
        }
        c.m(TAG, "uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.nJe = i;
        hVar.nJf = j;
        if (str2 == null) {
            str2 = "";
        }
        hVar.zVY = str2;
        hVar.Q(strArr);
        acM(hVar.cIS());
        f.cDN();
    }

    public static void a(int i, long j, String... strArr) {
        h hVar = new h();
        hVar.groupId = "";
        hVar.nJe = i;
        hVar.nJf = j;
        hVar.zVY = "";
        hVar.Q(strArr);
        acM(hVar.cIS());
        f.cDN();
    }

    public final void Q(String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            if (this.Ayp.length() > 900) {
                this.Ayp.setLength(0);
                this.Ayp.append("overmaxsize");
            }
            if (this.Ayp.length() != 0) {
                this.Ayp.append("-");
            }
            int length = strArr.length;
            while (i < length) {
                this.Ayp.append(strArr[i]);
                this.Ayp.append("|");
                i++;
            }
        }
    }

    public final void cIT() {
        this.Ayq = System.currentTimeMillis();
        c.d(TAG, "beginCreateOrEnter", Long.valueOf(this.Ayq));
    }

    public final void cIU() {
        c.m(TAG, "beginCreateOrNotify");
        this.Ayr = System.currentTimeMillis();
    }

    public static void Jv(int i) {
        c.d(TAG, "sendNetSceneStat", Integer.valueOf(i));
        f.w(527, 3, String.valueOf(i));
    }

    public static void Jw(int i) {
        c.d(TAG, "sendDeviceStat", Integer.valueOf(i));
        f.w(528, 3, String.valueOf(i));
    }

    public static void Jx(int i) {
        c.d(TAG, "sendtalkRoomDialStat", Integer.valueOf(i));
        f.w(530, 3, String.valueOf(i));
    }

    public static void cIV() {
        c.d(TAG, "sendTalkRoomOnDialStat", Integer.valueOf(-5001));
        f.w(531, 3, "-5001");
    }

    public static void Jy(int i) {
        c.d(TAG, "sendEngineStat", Integer.valueOf(i));
        f.w(529, 3, String.valueOf(i));
    }

    public static void acM(String str) {
        c.d(TAG, "sendSummaryNetScene", str);
        f.w(532, 3, str);
    }

    public static void acN(String str) {
        c.d(TAG, "sendEngineRecv", str);
        f.w(533, 3, str);
    }

    public static void acO(String str) {
        c.d(TAG, "sendEngineSend", str);
        f.w(534, 3, str);
    }

    public static void acP(String str) {
        c.d(TAG, "sendChannelStat", str);
        f.w(535, 3, str);
    }

    public final void Jz(int i) {
        c.d(TAG, "stopStatus", Integer.valueOf(i));
        this.sCt = i;
    }
}
