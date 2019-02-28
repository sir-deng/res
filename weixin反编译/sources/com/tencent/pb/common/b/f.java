package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.pb.common.b.a.a.u;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f zVB = null;
    private int zVC;
    private LinkedList<a> zVD;
    public e zVE;
    private boolean zVF;
    private boolean zVG;

    private class a {
        int mTaskId;
        public String zVH;
        a zVI;
        c zVJ;

        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }
    }

    private f() {
        this.zVC = 0;
        this.zVD = null;
        this.zVE = null;
        this.zVF = false;
        this.zVG = true;
        this.zVD = new LinkedList();
        this.zVG = true;
    }

    private static v bF(byte[] bArr) {
        try {
            return (v) com.google.a.a.e.a(new v(), bArr, bArr.length);
        } catch (Exception e) {
            c.m("NETCMD", "Exception genReadPackageData" + e.getMessage());
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i, byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2;
        int cDz = cDz();
        byte[] bArr3 = null;
        try {
            u uVar;
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
                uVar = new u();
                uVar.pK = i;
                uVar.zXk = cDz;
                uVar.userName = com.tencent.pb.a.a.a.cDO();
                uVar.zWd = i4;
            } else {
                uVar = new u();
                uVar.pK = i;
                uVar.zXk = cDz;
                uVar.userName = com.tencent.pb.a.a.a.cDO();
                uVar.zWd = i4;
            }
            if (bArr == null) {
                c.m("NETCMD", "body null");
                bArr3 = null;
            } else {
                com.google.a.a.e vVar = new v();
                vVar.zXm = uVar;
                vVar.body = bArr;
                bArr3 = com.google.a.a.e.b(vVar);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            c.m("NetError", "newTaskHelper addTask body null");
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            c.m("NETCMD", "cmd:" + i + "|body is null");
            return -1;
        } else if (bArr2.length > 61440) {
            c.m("NETCMD", "cmd:" + i + "|body too large");
            return -1;
        } else {
            a aVar2 = new a();
            aVar2.mTaskId = cDz;
            aVar2.zVI = aVar;
            aVar2.zVJ = cVar;
            aVar2.zVH = str;
            synchronized (this.zVD) {
                this.zVD.add(aVar2);
            }
            int i5 = 1933;
            switch (i) {
                case com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX /*139*/:
                    i5 = 1918;
                    break;
                case j.CTRL_INDEX /*141*/:
                    i5 = 1919;
                    break;
                case 143:
                    i5 = 1927;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                    i5 = 1931;
                    break;
                case 147:
                    i5 = 1932;
                    break;
                case 181:
                    i5 = 1929;
                    break;
                case 183:
                    i5 = 1928;
                    break;
                case k.CTRL_BYTE /*189*/:
                    i5 = 1935;
                    break;
                case h.CTRL_INDEX /*211*/:
                    i5 = 1937;
                    break;
                case 221:
                    i5 = 1938;
                    break;
                case 223:
                    i5 = 1939;
                    break;
            }
            c.d("NETCMD", "CLTSEND|", Integer.valueOf(cDz), Integer.valueOf(i5), str, com.tencent.pb.a.a.a.cDO());
            if (this.zVE != null) {
                this.zVE.b(cDz, i5, bArr2);
            }
            return cDz;
        }
    }

    private int cDz() {
        int i;
        synchronized (this.zVD) {
            this.zVC++;
            i = this.zVC;
        }
        return i;
    }

    public final a Ib(int i) {
        a aVar;
        synchronized (this.zVD) {
            Iterator it = this.zVD.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.mTaskId == i) {
                    break;
                }
            }
            aVar = null;
        }
        return aVar;
    }

    public static f cDA() {
        if (zVB == null) {
            synchronized (f.class) {
                if (zVB == null) {
                    zVB = new f();
                }
            }
        }
        return zVB;
    }

    final int a(a aVar, c cVar, int i, String str, byte[] bArr, int i2) {
        if (!this.zVG) {
            c.m("NETCMD", "doSendTask mIsInitSucc is false");
            return -1;
        } else if (this.zVF) {
            c.m("NETCMD", "doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str);
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i, bArr, 0, 0, i2);
            } catch (Throwable th) {
                c.m("NETCMD", "Exception doSendTask", th);
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e) {
            c.m("NETCMD", "doSendTask exception:", e);
            return -1;
        }
    }

    public static int bG(byte[] bArr) {
        if (bArr == null) {
            c.m("NETCMD", "CLTNOT onNotify1 data == null ", Integer.valueOf(0));
            com.tencent.wecall.talkroom.model.h.Jv(-1601);
            if (TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cIo().nqU) && TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cIo().AwI)) {
                com.tencent.wecall.talkroom.model.h.a(com.tencent.wecall.talkroom.model.a.cIo().nPD, com.tencent.wecall.talkroom.model.a.cIo().AwJ, "notify", "datanull");
            } else {
                com.tencent.wecall.talkroom.model.a.cIo().AwR.Q("notify", "datanull");
            }
            return -1;
        }
        c.d("NETCMD", "CLTNOT onNotify data len=", Integer.valueOf(bArr.length));
        return com.tencent.wecall.talkroom.model.a.cIo().bU(bArr);
    }

    public final void a(a aVar, int i, byte[] bArr) {
        try {
            if (aVar.zVJ != null) {
                aVar.zVJ.p(i, bArr);
            }
            if (aVar.zVI != null) {
                aVar.zVI.dG(aVar.zVH, i);
            }
        } catch (Exception e) {
            c.m("NETCMD", "postRespData", e.getMessage());
        }
        synchronized (this.zVD) {
            this.zVD.remove(aVar);
        }
    }

    public final int q(int i, byte[] bArr) {
        a Ib = Ib(i);
        if (Ib != null || DownloadResult.CODE_UNDEFINED == i) {
            v bF = bF(bArr);
            if (bF == null || bF.zXm == null) {
                String str;
                String str2 = "NETCMD";
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (bF == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + bF.zXm;
                }
                objArr[1] = str;
                c.m(str2, objArr);
                a(Ib, -3, null);
                return -1;
            }
            int i2 = bF.zXm.ret;
            int i3 = bF.zXm.zXl;
            String str3 = bF.zXm.userName;
            if (com.tencent.pb.common.a.a.zUS) {
                Toast.makeText(d.syL, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && Ib != null) {
                c.m("NETCMD", "CLTRCV", Integer.valueOf(i), Ib.zVH, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            } else if (Ib != null) {
                c.d("NETCMD", "CLTRCV", Integer.valueOf(i), Ib.zVH, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            }
            byte[] bArr2 = bF.body;
            if (bArr2 != null) {
                a(Ib, i2, bArr2);
                return 0;
            }
            a(Ib, i2, null);
            return 0;
        }
        c.m("NETCMD", "buf2Resp fail: taskId:" + i + " not found");
        com.tencent.pb.common.c.f.w(20007, 3, "-1202");
        return 1;
    }
}
