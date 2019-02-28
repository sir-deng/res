package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.brv;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class v implements com.tencent.mm.ad.e {
    String fAJ;
    String ptS;
    String[] puv;
    String[] puw;
    String[] pux;
    int pvA = 0;
    com.tencent.mm.ad.f pvB = new com.tencent.mm.ad.f() {
        public final void a(int i, int i2, k kVar) {
            x.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", v.this.pvv, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(v.this.pvu.size()));
            if (i >= i2) {
                v.this.pvx.put(v.this.pvw, ((o) kVar).bkT().wfk);
                brv bkT = ((o) kVar).bkT();
                if (v.this.pvz != null) {
                    v.this.pvz.c(v.this.pvA - v.this.pvu.size(), v.this.pvA, v.this.pvw, bkT.wfk);
                }
                if (v.this.pvu.isEmpty()) {
                    x.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                    if (v.this.pvy != null) {
                        v.this.pvy.bkW();
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
                g gVar = (g) v.this.pvu.remove(0);
                v.this.pvv = gVar.fAM;
                v.this.pvw = gVar.fileName;
                as.CN().a(new o(v.this.pvw, v.this.pvv, this), 0);
            }
        }
    };
    e pvg = null;
    String pvi;
    Map<String, String> pvj = new HashMap();
    Map<String, String> pvk = new LinkedHashMap();
    Map<String, String> pvl = new LinkedHashMap();
    private b pvm;
    public t pvn;
    Map<String, String> pvo = new HashMap();
    f pvp = null;
    HashMap<Long, Integer> pvq = new HashMap();
    HashMap<Long, String> pvr = new HashMap();
    HashMap<String, Integer> pvs = new HashMap();
    int pvt = 0;
    ArrayList<g> pvu = new ArrayList();
    String pvv = null;
    String pvw = null;
    HashMap<String, String> pvx = new HashMap();
    c pvy;
    d pvz;

    interface a {
        void bkX();
    }

    public interface f {
        void R(String str, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.v$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hDl = 100;
        final /* synthetic */ int jsW;

        AnonymousClass1(int i, int i2) {
            this.jsW = i;
        }

        public final void run() {
            v.this.pvp.R(v.this.ptS, this.jsW, this.hDl);
        }
    }

    public interface b {
        void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap);
    }

    public interface c {
        void bkW();
    }

    public interface d {
        void c(int i, int i2, String str, String str2);
    }

    public interface e {
        void It(String str);
    }

    public static class g {
        public String fAM;
        public String fileName;

        public g(String str, String str2) {
            this.fAM = str;
            this.fileName = str2;
        }
    }

    static /* synthetic */ void a(v vVar, HashMap hashMap) {
        if (vVar.pvo == null) {
            vVar.pvo = new HashMap();
        }
        for (Long l : hashMap.keySet()) {
            String str = (String) hashMap.get(l);
            String str2 = (String) vVar.pvj.get(String.valueOf(l));
            x.i("MicroMsg.ShareModeMailAppService", "appendDownloadImgToAttachIdMap, filePath: %s, attachId: %s", str2, str);
            if (!bi.oN(str2)) {
                vVar.pvo.put(str2, str);
            }
        }
    }

    public v() {
        as.CN().a(483, (com.tencent.mm.ad.e) this);
        as.CN().a(484, (com.tencent.mm.ad.e) this);
        as.CN().a(485, (com.tencent.mm.ad.e) this);
    }

    public final void vs(int i) {
        if (this.pvp != null) {
            ah.y(new AnonymousClass1(i, 100));
        }
    }

    public final void a(f fVar, e eVar) {
        this.pvp = fVar;
        this.pvg = eVar;
        if (this.pvj.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.pvj.keySet()) {
                x.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", str);
                arrayList.add(Long.valueOf(bi.getLong(str, 0)));
            }
            b anonymousClass2 = new b() {
                public final void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
                    v vVar;
                    x.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()));
                    if (arrayList.size() > 0) {
                        vVar = v.this;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) vVar.pvj.get(String.valueOf((Long) it.next()));
                            x.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", str);
                            if (!bi.oN(str)) {
                                if (vVar.pvu == null) {
                                    vVar.pvu = new ArrayList();
                                }
                                vVar.pvu.add(new g(str, str));
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        v.a(v.this, (HashMap) hashMap);
                    }
                    v.this.vs(10);
                    vVar = v.this;
                    x.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", Integer.valueOf(vVar.pvu.size()));
                    if (vVar.pvu == null) {
                        vVar.pvu = new ArrayList();
                    }
                    if (vVar.pvu.size() > 0) {
                        c anonymousClass3 = new c() {
                            public final void bkW() {
                                x.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
                                v.this.vs(90);
                                v vVar = v.this;
                                if (vVar.pvu != null && vVar.pvu.size() > 0) {
                                    vVar.pvu.clear();
                                }
                                v.this.bkV();
                            }
                        };
                        d anonymousClass4 = new d() {
                            public final void c(int i, int i2, String str, String str2) {
                                x.d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", Integer.valueOf(i), Integer.valueOf(i2));
                                v.this.pvo.put(str, str2);
                                v.this.vs((int) (10.0f + (80.0f * (((float) i) / ((float) i2)))));
                            }
                        };
                        x.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", Integer.valueOf(vVar.pvu.size()));
                        vVar.pvy = anonymousClass3;
                        vVar.pvz = anonymousClass4;
                        vVar.pvA = vVar.pvu.size();
                        if (vVar.pvu != null && vVar.pvu.size() > 0) {
                            g gVar = (g) vVar.pvu.remove(0);
                            vVar.pvv = gVar.fAM;
                            vVar.pvw = gVar.fileName;
                            vVar.pvx = new HashMap();
                            as.CN().a(new o(vVar.pvw, vVar.pvv, vVar.pvB), 0);
                            return;
                        }
                        return;
                    }
                    vVar.vs(90);
                    vVar.bkV();
                }
            };
            x.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
            this.pvt = 0;
            L(arrayList);
            if (this.pvr != null) {
                this.pvr.clear();
                this.pvr = null;
            }
            this.pvr = new HashMap();
            this.pvm = anonymousClass2;
            as.CN().a(new l(arrayList), 0);
            return;
        }
        vs(90);
        bkV();
    }

    final void bkV() {
        int i;
        String str;
        int i2;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr;
        int i3;
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i4 = 0;
        int i5 = 0;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr2 = null;
        if (this.pvk != null && this.pvk.size() > 0) {
            int i6;
            com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr3 = new com.tencent.mm.plugin.qqmail.b.k.a[this.pvk.size()];
            Iterator it = this.pvk.keySet().iterator();
            while (true) {
                i6 = i5;
                i = i4;
                if (!it.hasNext()) {
                    break;
                }
                str = (String) it.next();
                com.tencent.mm.plugin.qqmail.b.k.a aVar = new com.tencent.mm.plugin.qqmail.b.k.a();
                aVar.puB = (String) this.pvk.get(str);
                aVar.fileName = str;
                aVar.name = (String) this.pvl.get(str);
                aVar.fileSize = com.tencent.mm.a.e.bN(str);
                aVarArr3[i] = aVar;
                x.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", Integer.valueOf(i), aVar.puB, aVar.fileName, aVar.name, Integer.valueOf(aVar.fileSize));
                i4 = i + 1;
                i5 = aVar.fileSize + i6;
            }
            i5 = i6;
            aVarArr2 = aVarArr3;
        }
        i4 = 0;
        if (this.pvo == null || this.pvo.size() <= 0) {
            i2 = i5;
            aVarArr = null;
        } else {
            com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr4 = new com.tencent.mm.plugin.qqmail.b.k.a[this.pvo.size()];
            Iterator it2 = this.pvo.keySet().iterator();
            while (true) {
                i = i5;
                i3 = i4;
                if (!it2.hasNext()) {
                    break;
                }
                str = (String) it2.next();
                com.tencent.mm.plugin.qqmail.b.k.a aVar2 = new com.tencent.mm.plugin.qqmail.b.k.a();
                aVar2.puB = (String) this.pvo.get(str);
                aVar2.fileName = str;
                aVar2.fileSize = bi.a((Integer) this.pvs.get(aVar2.puB), 0);
                if (aVar2.fileSize == 0) {
                    aVar2.fileSize = com.tencent.mm.a.e.bN(str);
                }
                aVarArr4[i3] = aVar2;
                x.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", Integer.valueOf(i3), aVar2.puB, aVar2.fileName, Integer.valueOf(aVar2.fileSize));
                i4 = i3 + 1;
                i5 = aVar2.fileSize + i;
            }
            aVarArr = aVarArr4;
            i2 = i;
        }
        x.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", Integer.valueOf(i2));
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr5 = (aVarArr == null || aVarArr.length == 0) ? null : aVarArr;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr6 = (aVarArr2 == null || aVarArr2.length == 0) ? null : aVarArr2;
        final a anonymousClass5 = new a() {
            public final void bkX() {
                v.this.vs(100);
            }
        };
        k kVar = new k(this.fAJ, this.puv, this.puw, this.pux, this.ptS);
        kVar.puy = this.pvi;
        if (aVarArr6 == null || aVarArr6.length <= 0) {
            kVar.puA = null;
        } else {
            kVar.puA = new com.tencent.mm.plugin.qqmail.b.k.a[aVarArr6.length];
            for (i4 = 0; i4 < kVar.puA.length; i4++) {
                kVar.puA[i4] = aVarArr6[i4];
            }
            x.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", Integer.valueOf(kVar.puA.length));
        }
        if (aVarArr5 == null || aVarArr5.length <= 0) {
            kVar.puz = null;
        } else {
            kVar.puz = aVarArr5;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (kVar.fAJ != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(kVar.fAJ.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(kVar.fAJ);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bkQ();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bkR();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.bkS();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder4.append("Subject: ");
        if (kVar.ptS != null) {
            stringBuilder4.append(kVar.ptS);
        }
        stringBuilder4.append("\n");
        stringBuilder4.append("Mime-Version: 1.0");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Transfer-Encoding: 8Bit");
        stringBuilder4.append("\n");
        stringBuilder4.append("Date: " + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()));
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-MIME: TCMime 1.0 by Tencent");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3.append("This is a multi-part message in MIME format.");
        stringBuilder3.append("\n");
        stringBuilder3.append("\r\n");
        stringBuilder = new StringBuilder("");
        stringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Type:text/html;charset=\"utf-8\"");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Transfer-Encoding:base64");
        stringBuilder.append("\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(Base64.encodeToString(kVar.puy.getBytes(), 0));
        stringBuilder.append("\n");
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        if (kVar.puz != null && kVar.puz.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.k.a aVar3 : kVar.puz) {
                String str2 = aVar3.puB;
                String str3 = aVar3.fileName;
                int i7 = aVar3.fileSize;
                StringBuilder stringBuilder5 = new StringBuilder("");
                stringBuilder5.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append("Content-Transfer-Encoding:base64");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-ID:<%s>", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append("\r\n");
                stringBuilder5.append(String.format("QQMail-LinkID:%s", new Object[]{str2}));
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i7)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LineLen:72");
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-BreakType:1");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{k.Iq(str2)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append("\n");
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("\r\n");
        if (kVar.puA != null && kVar.puA.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.k.a aVar4 : kVar.puA) {
                String str4 = aVar4.puB;
                int i8 = aVar4.fileSize;
                String str5 = aVar4.name;
                StringBuilder stringBuilder6 = new StringBuilder("");
                stringBuilder6.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str5.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str5.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("Content-Transfer-Encoding:base64");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-ID:<%s>", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                stringBuilder6.append("\n");
                stringBuilder6.append("\r\n");
                stringBuilder6.append(String.format("QQMail-LinkID:%s", new Object[]{str4}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i8)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LineLen:72");
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-BreakType:1");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{k.Iq(str4)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append("\n");
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        as.CN().a(new m(stringBuilder3.toString(), this.fAJ, this.puv, i2, new com.tencent.mm.ad.f() {
            public final void a(int i, int i2, k kVar) {
                x.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i >= i2) {
                    x.i("MicroMsg.ShareModeMailAppService", "finish send");
                    if (anonymousClass5 != null) {
                        anonymousClass5.bkX();
                    }
                }
            }
        }), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (kVar.getType() == 483) {
                a((l) kVar);
            } else if (this.pvg != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        v.this.pvg.It(v.this.ptS);
                    }
                });
            }
        } else if (kVar.getType() == 483) {
            a((l) kVar);
        } else if (kVar.getType() != 484) {
            kVar.getType();
        }
    }

    private void L(ArrayList<Long> arrayList) {
        if (this.pvq != null) {
            this.pvq.clear();
            this.pvq = null;
        }
        this.pvq = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.pvq.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
    }

    private static ArrayList<Long> m(HashMap<Long, Integer> hashMap) {
        ArrayList<Long> arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void a(l lVar) {
        this.pvt++;
        x.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", Integer.valueOf(this.pvt));
        Iterator it = ((nc) lVar.gLB.hnR.hnY).wcB.iterator();
        while (it.hasNext()) {
            pk pkVar = (pk) it.next();
            long j = (long) pkVar.vNL;
            int i = pkVar.kyY;
            if (this.pvq.containsKey(Long.valueOf(j))) {
                x.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", Long.valueOf(j), Integer.valueOf(i));
                if (i == 0) {
                    this.pvq.remove(Long.valueOf(j));
                    if (pkVar.wfk != null) {
                        x.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", Long.valueOf(j), pkVar.wfk);
                        this.pvr.put(Long.valueOf(j), pkVar.wfk);
                        this.pvs.put(pkVar.wfk, Integer.valueOf(pkVar.wfl));
                    }
                } else {
                    this.pvq.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.pvq.isEmpty()) {
            x.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.pvm != null) {
                this.pvm.a(new ArrayList(), this.pvr);
            }
        } else if (this.pvt < 3) {
            x.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            as.CN().a(new l(m(this.pvq)), 0);
        } else {
            this.pvm.a(m(this.pvq), this.pvr);
        }
    }
}
