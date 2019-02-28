package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.xwalk.core.R;

public final class c implements com.tencent.mm.plugin.clean.c.a.a.a, Runnable {
    private static final Long lkF = Long.valueOf(604800000);
    private static final Long lkG = Long.valueOf(7776000000L);
    private static final int lkS = (com.tencent.mm.y.c.FJ().length() - 1);
    private long endTime = 0;
    private ag hbP = new ag(Looper.getMainLooper());
    public boolean isStop;
    private long lkI;
    private long lkJ;
    private com.tencent.mm.plugin.clean.c.a.b lkT;
    private g lkU;
    private int lkV = 0;
    private int lkW = 0;
    private ConcurrentHashMap<String, b> lkX = new ConcurrentHashMap();
    private long lkY;
    private long lkZ;
    private HashSet<String> lla = new HashSet();
    private HashSet<String> llb = new HashSet();
    private boolean llc = true;
    private int[] lld = new int[10];
    private long startTime = 0;

    class b extends com.tencent.mm.plugin.clean.c.a.a {
        private String filePath;
        private long fileSize;
        int llg = 0;

        public b(String str) {
            super(c.this);
            this.filePath = str;
            this.fileSize = 0;
        }

        public final String TS() {
            return "filePath[" + this.filePath + "] scanCount[" + this.llg + "]" + super.TS();
        }

        public final void execute() {
            String str;
            int[] l;
            if (xT(this.filePath) && c.this.llc) {
                x.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", Boolean.valueOf(c.this.llc), this.filePath);
                deleteFile(this.filePath);
                File parentFile = new File(this.filePath).getParentFile();
                if (parentFile.list() == null || parentFile.list().length == 0) {
                    parentFile.delete();
                }
            } else {
                xU(this.filePath);
            }
            if (c.a(c.this, this.filePath)) {
                c.this.lkJ = c.this.lkJ + this.fileSize;
            } else {
                str = this.filePath;
                as.Hm();
                if (str.startsWith(com.tencent.mm.y.c.FJ())) {
                    c.this.lkI = c.this.lkI + this.fileSize;
                }
            }
            if (xT(this.filePath)) {
                l = c.this.lld;
                l[1] = (int) (((long) l[1]) + this.fileSize);
            } else {
                str = this.filePath;
                as.Hm();
                if (str.startsWith(com.tencent.mm.y.c.FJ())) {
                    l = c.this.lld;
                    l[0] = (int) (((long) l[0]) + this.fileSize);
                } else {
                    l = c.this.lld;
                    l[2] = (int) (((long) l[2]) + this.fileSize);
                }
            }
            if (this.filePath.endsWith(File.separator + "image2")) {
                l = c.this.lld;
                l[3] = (int) (((long) l[3]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                l = c.this.lld;
                l[4] = (int) (((long) l[4]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                l = c.this.lld;
                l[5] = (int) (((long) l[5]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "voice2")) {
                l = c.this.lld;
                l[6] = (int) (((long) l[6]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "WeiXin")) {
                l = c.this.lld;
                l[7] = (int) (((long) l[7]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "WeChat")) {
                l = c.this.lld;
                l[8] = (int) (((long) l[8]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "xlog")) {
                l = c.this.lld;
                l[9] = (int) (((long) l[9]) + this.fileSize);
            }
        }

        private void deleteFile(String str) {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    for (String str2 : list) {
                        deleteFile(str + File.separator + str2);
                    }
                }
                x.v("MicroMsg.CleanController", "delete file rootFile: %s", str);
                file.delete();
                return;
            }
            x.v("MicroMsg.CleanController", "delete file rootFile: %s", str);
            c.this.lkY = c.this.lkY + file.length();
            file.delete();
        }

        private static boolean xT(String str) {
            if (str.length() <= c.lkS || str.substring(c.lkS).indexOf("temp") != 0) {
                return false;
            }
            return true;
        }

        private void xU(String str) {
            int i = 0;
            this.llg++;
            if (str.endsWith(File.separator + "sns")) {
                x.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", str);
                xV(str);
            } else if (str.endsWith(File.separator + "music")) {
                x.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", str);
                xW(str);
            } else {
                File file = new File(str);
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list != null) {
                        int length = list.length;
                        while (i < length) {
                            xU(str + "/" + list[i]);
                            i++;
                        }
                        return;
                    }
                    return;
                }
                i = e.bN(str);
                c.this.bR((long) i);
                this.fileSize = ((long) i) + this.fileSize;
            }
        }

        private void xV(String str) {
            int i = 0;
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        xV(str + "/" + list[i]);
                        i++;
                    }
                }
            } else if (System.currentTimeMillis() - file.lastModified() <= c.lkF.longValue() || !c.this.llc) {
                i = e.bN(str);
                c.this.bR((long) i);
                this.fileSize = ((long) i) + this.fileSize;
            } else {
                x.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", str);
                file.delete();
            }
        }

        private void xW(String str) {
            int i = 0;
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        xW(str + "/" + list[i]);
                        i++;
                    }
                }
            } else if (System.currentTimeMillis() - file.lastModified() <= c.lkG.longValue() || !c.this.llc) {
                i = e.bN(str);
                c.this.bR((long) i);
                this.fileSize = ((long) i) + this.fileSize;
            } else {
                x.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", str);
                file.delete();
            }
        }
    }

    public class a extends com.tencent.mm.plugin.clean.c.a.a {
        private String username;

        public a(String str) {
            super(c.this);
            this.username = str;
        }

        public final String TS() {
            return "username[" + this.username + "]" + super.TS();
        }

        public final void execute() {
            Cursor cursor;
            Throwable e;
            Cursor cursor2;
            as.Hm();
            int Fv = com.tencent.mm.y.c.Fh().Fv(this.username);
            if (Fv <= 0) {
                x.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", this.username, Integer.valueOf(Fv));
                return;
            }
            int a;
            b bVar = new b();
            bVar.username = this.username;
            bVar.lkR = new ArrayList();
            bVar.fxb = 0;
            cursor = null;
            int i = 0;
            while (i < Fv) {
                try {
                    as.Hm();
                    cursor = com.tencent.mm.y.c.Fh().O(this.username, i, 50);
                    if (cursor == null) {
                        break;
                    }
                    a = a(cursor, bVar);
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    if (a <= 0) {
                        break;
                    }
                    i += a;
                    if (c.this.isStop) {
                        break;
                    }
                } catch (Throwable e2) {
                    Throwable th = e2;
                    a = i;
                    cursor2 = cursor;
                    x.printErrStackTrace("MicroMsg.CleanController", th, "execute analyse Task error.", new Object[0]);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    e2 = th2;
                    cursor = cursor2;
                }
            }
            a = i;
            if (cursor != null) {
                cursor.close();
            }
            if (bVar.lkR.size() > 0) {
                c.this.lkX.put(this.username, bVar);
            }
            x.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", this.username, Integer.valueOf(Fv), Integer.valueOf(a), Boolean.valueOf(c.this.isStop));
            return;
            if (cursor != null) {
                cursor.close();
            }
            throw e2;
        }

        private int a(Cursor cursor, b bVar) {
            if (cursor.moveToFirst()) {
                int i = 0;
                a aVar = null;
                while (!cursor.isAfterLast()) {
                    i++;
                    au auVar = new au();
                    auVar.b(cursor);
                    switch (l.BY(auVar.getType())) {
                        case 3:
                            aVar = c.a(c.this, auVar, this.username);
                            break;
                        case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                        case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                        case 62:
                            aVar = c.b(auVar, this.username);
                            break;
                        case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                            aVar = c.a(auVar, this.username);
                            break;
                    }
                    if (aVar != null) {
                        bVar.lkR.add(aVar);
                        bVar.fxb += aVar.size;
                        aVar = null;
                    }
                    if (cursor.moveToNext()) {
                        if (c.this.isStop) {
                        }
                    }
                    cursor.close();
                    return i;
                }
                cursor.close();
                return i;
            }
            x.d("MicroMsg.CleanController", "Message count of user:%s is empty", this.username);
            cursor.close();
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.tencent.mm.plugin.clean.c.a a(com.tencent.mm.plugin.clean.c.c r11, com.tencent.mm.storage.au r12, java.lang.String r13) {
        /*
        r4 = 1;
        r0 = com.tencent.mm.ap.o.PC();
        r1 = r12.field_imgPath;
        r2 = r0.B(r1, r4);
        r0 = r12.field_isSend;
        if (r0 != r4) goto L_0x0023;
    L_0x000f:
        r0 = com.tencent.mm.ap.o.PC();
        r6 = r12.field_msgId;
        r1 = (int) r6;
        r6 = (long) r1;
        r0 = r0.bj(r6);
        r6 = r0.hBA;
        r8 = 0;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x002d;
    L_0x0023:
        r0 = com.tencent.mm.ap.o.PC();
        r6 = r12.field_msgSvrId;
        r0 = r0.bi(r6);
    L_0x002d:
        r1 = 0;
        r3 = r12.field_isSend;
        if (r3 != r4) goto L_0x007e;
    L_0x0032:
        r3 = com.tencent.mm.ap.o.PC();
        r0 = r0.hBB;
        r5 = "";
        r6 = "";
        r3 = r3.m(r0, r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r0 != 0) goto L_0x007d;
    L_0x0048:
        r0 = com.tencent.mm.a.e.bO(r3);
        if (r0 == 0) goto L_0x007d;
    L_0x004e:
        r0 = "MicroMsg.CleanController";
        r1 = new java.lang.StringBuilder;
        r5 = "bigImgPath ";
        r1.<init>(r5);
        r1 = r1.append(r3);
        r5 = " ";
        r1 = r1.append(r5);
        r5 = com.tencent.mm.a.e.bN(r3);
        r1 = r1.append(r5);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.v(r0, r1);
        r1 = new com.tencent.mm.plugin.clean.c.a;
        r6 = r12.field_msgId;
        r8 = r12.field_createTime;
        r5 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8);
    L_0x007d:
        return r1;
    L_0x007e:
        r3 = r0.Pj();
        if (r3 == 0) goto L_0x007d;
    L_0x0084:
        r3 = com.tencent.mm.ap.o.PC();
        r5 = r0.hBB;
        r6 = "";
        r7 = "";
        r10 = r3.m(r5, r6, r7);
        r3 = "";
        r5 = r0.Pk();
        if (r5 == 0) goto L_0x00fc;
    L_0x009d:
        r5 = r0.Pk();
        if (r5 == 0) goto L_0x011b;
    L_0x00a3:
        r5 = com.tencent.mm.ap.o.PC();
        r6 = r0.hBK;
        r5 = r5.hT(r6);
        if (r5 == 0) goto L_0x011b;
    L_0x00af:
        if (r5 == 0) goto L_0x00fc;
    L_0x00b1:
        r0 = r5.equals(r0);
        if (r0 != 0) goto L_0x00fc;
    L_0x00b7:
        r0 = com.tencent.mm.ap.o.PC();
        r3 = r5.hBB;
        r5 = "";
        r6 = "";
        r3 = r0.m(r3, r5, r6);
        r0 = "MicroMsg.CleanController";
        r5 = new java.lang.StringBuilder;
        r6 = "hdPath ";
        r5.<init>(r6);
        r5 = r5.append(r3);
        r6 = " ";
        r5 = r5.append(r6);
        r6 = com.tencent.mm.a.e.bN(r3);
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.v(r0, r5);
        r0 = com.tencent.mm.a.e.bO(r3);
        if (r0 == 0) goto L_0x00fc;
    L_0x00f2:
        r1 = new com.tencent.mm.plugin.clean.c.a;
        r6 = r12.field_msgId;
        r8 = r12.field_createTime;
        r5 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8);
    L_0x00fc:
        r0 = com.tencent.mm.a.e.bO(r10);
        if (r0 == 0) goto L_0x007d;
    L_0x0102:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 != 0) goto L_0x007d;
    L_0x0108:
        r0 = r10.equals(r3);
        if (r0 != 0) goto L_0x007d;
    L_0x010e:
        r1 = new com.tencent.mm.plugin.clean.c.a;
        r6 = r12.field_msgId;
        r8 = r12.field_createTime;
        r3 = r10;
        r5 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8);
        goto L_0x007d;
    L_0x011b:
        r5 = r0;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.clean.c.c.a(com.tencent.mm.plugin.clean.c.c, com.tencent.mm.storage.au, java.lang.String):com.tencent.mm.plugin.clean.c.a");
    }

    static /* synthetic */ a a(au auVar, String str) {
        String Wn = bi.Wn(auVar.field_content);
        com.tencent.mm.x.g.a fV = Wn != null ? com.tencent.mm.x.g.a.fV(Wn) : null;
        if (fV == null) {
            x.e("MicroMsg.CleanController", "content is null");
            return null;
        }
        String B = o.PC().B(auVar.field_imgPath, true);
        com.tencent.mm.pluginsdk.model.app.b Se;
        switch (fV.type) {
            case 2:
                Se = an.aqK().Se(fV.for);
                if ((Se == null || !Se.aPj()) && (auVar.field_isSend != 1 || Se == null || !Se.field_isUpload)) {
                    return null;
                }
                String str2 = Se.field_fileFullPath;
                if (!e.bO(str2)) {
                    return null;
                }
                x.v("MicroMsg.CleanController", "image " + str2);
                return new a(B, str2, 1, str, auVar.field_msgId, auVar.field_createTime);
            case 6:
                Se = an.aqK().Se(fV.for);
                if ((Se == null || !Se.aPj()) && (auVar.field_isSend != 1 || Se == null || !Se.field_isUpload)) {
                    return null;
                }
                x.v("MicroMsg.CleanController", "full path " + Se.field_fileFullPath);
                if (!e.bO(Se.field_fileFullPath)) {
                    return null;
                }
                return new a(B, Se.field_fileFullPath, 4, str, auVar.field_msgId, auVar.field_createTime);
            case 7:
                Se = an.aqK().Se(fV.for);
                if ((Se == null || !Se.aPj()) && (auVar.field_isSend != 1 || Se == null || !Se.field_isUpload)) {
                    return null;
                }
                x.v("MicroMsg.CleanController", "full path " + Se.field_fileFullPath);
                if (!e.bO(Se.field_fileFullPath)) {
                    return null;
                }
                return new a(B, Se.field_fileFullPath, 4, str, auVar.field_msgId, auVar.field_createTime);
            default:
                return null;
        }
    }

    static /* synthetic */ boolean a(c cVar, String str) {
        if (!bi.oN(str)) {
            as.Hm();
            if (!str.startsWith(com.tencent.mm.y.c.FJ())) {
                Iterator it = cVar.lla.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (str.startsWith(g.Dq().gRS) && str.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static /* synthetic */ a b(au auVar, String str) {
        com.tencent.mm.modelvideo.o.Ub();
        String nx = s.nx(auVar.field_imgPath);
        String str2 = auVar.field_imgPath;
        if (!bi.oN(str2)) {
            com.tencent.mm.modelvideo.o.Ub().nv(str2);
        }
        com.tencent.mm.modelvideo.o.Ub();
        String ny = s.ny(auVar.field_imgPath);
        if (!new File(nx).exists()) {
            return null;
        }
        return new a(ny, nx, 3, str, auVar.field_msgId, auVar.field_createTime);
    }

    static {
        as.Hm();
    }

    public c(com.tencent.mm.plugin.clean.c.a.b bVar, g gVar) {
        this.lkU = gVar;
        this.lkT = bVar;
    }

    public final void run() {
        int i;
        String str;
        x.i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        long Wz = bi.Wz();
        String str2 = com.tencent.mm.compatible.util.e.bnF;
        x.v("MicroMsg.CleanController", "root path: %s", str2);
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Dr();
        g.Do();
        String s = com.tencent.mm.a.g.s(stringBuilder.append(com.tencent.mm.kernel.a.Cn()).toString().getBytes());
        ArrayList arrayList = new ArrayList();
        File file = new File(str2);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str3 : list) {
                    String str4 = str2 + str3;
                    if (str3.length() >= 32) {
                        x.v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", str3, s);
                        Collection xS = xS(str4);
                        if (arrayList.size() > 0) {
                            if (!s.equals(str3)) {
                                x.i("MicroMsg.CleanController", "add other acc tmp path %s", str3);
                                this.lla.add(str3);
                            }
                            arrayList.addAll(0, xS);
                        } else {
                            arrayList.addAll(xS);
                        }
                    } else {
                        x.v("MicroMsg.CleanController", "subfile: %s", str3);
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str4);
                        } else {
                            arrayList.add(str4);
                        }
                    }
                }
            }
        } else {
            bR((long) e.bN(str2));
        }
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            i = i2;
            if (i >= arrayList.size()) {
                break;
            }
            str = (String) arrayList.get(i);
            if (str.contains("image2")) {
                i3 = i;
            }
            if (str.contains("voice2")) {
                i4 = i;
            }
            i2 = i + 1;
        }
        if (i4 != -1) {
            arrayList.add(0, (String) arrayList.remove(i4));
        }
        if (i3 != -1) {
            arrayList.add(0, (String) arrayList.remove(i3));
        }
        x.d("MicroMsg.CleanController", "scan is finish [%s]", Long.valueOf(bi.bB(Wz)));
        long Wz2 = bi.Wz();
        ArrayList ayL = ayL();
        x.d("MicroMsg.CleanController", "user is finish [%s]", Long.valueOf(bi.bB(Wz2)));
        this.lkV = arrayList.size() + ayL.size();
        if (this.lkV == 0) {
            x.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            ayI();
            return;
        }
        com.tencent.mm.plugin.clean.c.a.a bVar;
        x.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", Integer.valueOf(this.lkV));
        i2 = 0;
        while (true) {
            i = i2;
            if (this.isStop || i >= arrayList.size()) {
                i2 = 0;
            } else {
                x.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", Integer.valueOf(i), (String) arrayList.get(i));
                bVar = new b(str);
                while (!this.lkT.b(bVar)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e) {
                    }
                }
                x.d("MicroMsg.CleanController", "Start task： filePath＝%s", str);
                i2 = i + 1;
            }
        }
        i2 = 0;
        while (true) {
            i = i2;
            if (!this.isStop && i < ayL.size()) {
                x.d("MicroMsg.CleanController", "while loop index=%d | username=%s", Integer.valueOf(i), (String) ayL.get(i));
                bVar = new a(str);
                while (!this.lkT.b(bVar)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e2) {
                    }
                }
                x.d("MicroMsg.CleanController", "Start task： user＝%s", str);
                i2 = i + 1;
            } else {
                return;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        if (aVar instanceof a) {
            x.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", Integer.valueOf(aVar.hashCode()), aVar.TS());
        } else {
            x.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", Integer.valueOf(aVar.hashCode()), aVar.TS());
        }
        com.tencent.mm.sdk.f.e.Q(this);
        this.lkW++;
        if (!(this.lkU == null || this.isStop)) {
            this.hbP.post(new Runnable() {
                public final void run() {
                    c.this.lkU.co(c.this.lkW, c.this.lkV);
                }
            });
        }
        if (this.lkW == this.lkV) {
            ayI();
        }
    }

    private void ayI() {
        this.endTime = System.currentTimeMillis();
        x.i("MicroMsg.CleanController", "totalUserTime:%d", Long.valueOf(this.endTime - this.startTime));
        if (this.lkU != null && !this.isStop) {
            final Object arrayList = new ArrayList();
            for (b add : this.lkX.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.hbP.post(new Runnable() {
                public final void run() {
                    c.this.lkU.a(c.this.lkY, c.this.lkZ, c.this.lkI, arrayList, c.this.lkJ, c.this.lla);
                }
            });
        }
    }

    public static long ayJ() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long ayK() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    private static ArrayList<String> ayL() {
        ArrayList<String> arrayList = new ArrayList();
        List linkedList = new LinkedList();
        for (Object add : com.tencent.mm.y.s.hhb) {
            linkedList.add(add);
        }
        as.Hm();
        Cursor c = com.tencent.mm.y.c.Fk().c(com.tencent.mm.y.s.hgU, linkedList, "*");
        if (c.moveToFirst()) {
            do {
                ak aeVar = new ae();
                aeVar.b(c);
                if (!bi.oN(aeVar.field_username)) {
                    as.Hm();
                    if (!com.tencent.mm.storage.x.DG(com.tencent.mm.y.c.Ff().Xv(aeVar.field_username).field_verifyFlag)) {
                        arrayList.add(aeVar.field_username);
                    }
                }
                if (!c.moveToNext()) {
                    break;
                }
            } while (!c.isAfterLast());
        }
        c.close();
        return arrayList;
    }

    private static ArrayList<String> xS(String str) {
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                arrayList.add(str);
            } else {
                for (String str2 : list) {
                    arrayList.add(str + File.separator + str2);
                }
            }
        } else {
            arrayList.add(str);
        }
        return arrayList;
    }

    private synchronized void bR(long j) {
        if (j < 0) {
            x.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", Long.valueOf(j));
            this.lkZ += 60;
        } else {
            this.lkZ += j;
        }
    }
}
