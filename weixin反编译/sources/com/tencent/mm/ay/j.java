package com.tencent.mm.ay;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.m;
import com.tencent.mm.f.a.mg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class j extends k implements m, com.tencent.mm.network.k {
    private int frj;
    private b gLB;
    private e gLE;
    public int hLs;
    private int offset = 0;

    public j(int i, int i2) {
        this.hLs = i;
        this.frj = i2;
        m be = r.QO().be(i, i2);
        if (be == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + i);
            return;
        }
        be.status = 3;
        be.fEo = 64;
        r.QO().b(be);
        if (i2 == 5) {
            com.tencent.mm.loader.stub.b.deleteFile(g.Dq().cachePath + "brand_i18n.apk");
            return;
        }
        com.tencent.mm.loader.stub.b.deleteFile(n.QL() + r.QO().bg(i, i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", Integer.valueOf(this.hLs), Integer.valueOf(this.frj));
        m be = r.QO().be(this.hLs, this.frj);
        if (be == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.hLs + " type:" + this.frj);
            return -1;
        } else if (be.status != 3) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.hLs + " stat:" + be.status);
            return -1;
        } else if (be.size <= 0) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.hLs + " size:" + be.size);
            return -1;
        } else {
            a aVar = new a();
            aVar.hnT = new rp();
            aVar.hnU = new rq();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.hnS = JsApiSetBackgroundAudioState.CTRL_INDEX;
            aVar.hnV = 0;
            aVar.hnW = 0;
            this.gLB = aVar.Kf();
            rp rpVar = (rp) this.gLB.hnQ.hnY;
            awj awj = new awj();
            awj.npU = be.id;
            awj.kzy = be.version;
            rpVar.wgq = awj;
            rpVar.vUN = this.offset;
            rpVar.wgr = 65536;
            rpVar.kzz = this.frj;
            return a(eVar, this.gLB, this);
        }
    }

    protected final int a(q qVar) {
        rp rpVar = (rp) ((b) qVar).hnQ.hnY;
        m be = r.QO().be(this.hLs, this.frj);
        if (be == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.hLs);
            return b.hoA;
        } else if (rpVar.wgq.npU == this.hLs && rpVar.vUN == this.offset && rpVar.vUN < be.size && rpVar.wgr == 65536 && be.size > 0 && be.status == 3) {
            return b.hoz;
        } else {
            x.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.hLs);
            return b.hoA;
        }
    }

    protected final int Bo() {
        return 50;
    }

    protected final void a(a aVar) {
        r.QO().bi(this.hLs, this.frj);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.hLs + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            rq rqVar = (rq) ((b) qVar).hnR.hnY;
            if (rqVar.kzz != this.frj) {
                x.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                r.QO().bi(this.hLs, this.frj);
                this.gLE.a(3, -1, "", this);
                return;
            }
            byte[] a = n.a(rqVar.wgs);
            if (a == null || a.length == 0) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.hLs);
                r.QO().bi(this.hLs, this.frj);
                this.gLE.a(3, -1, str, this);
                return;
            }
            m be = r.QO().be(this.hLs, this.frj);
            if (be == null) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.hLs);
                r.QO().bi(this.hLs, this.frj);
                this.gLE.a(3, -1, str, this);
                return;
            } else if (be.size != rqVar.wgt) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                r.QO().bi(this.hLs, this.frj);
                g.Dp().gRu.a(new k(this.frj), 0);
                this.gLE.a(3, -1, str, this);
                return;
            } else {
                String str2;
                String str3;
                if (this.frj == 5) {
                    str2 = g.Dq().cachePath;
                    str3 = "brand_i18n.apk";
                } else {
                    r.QO();
                    str2 = n.QL();
                    str3 = r.QO().bg(this.hLs, this.frj);
                }
                x.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + str2);
                x.d("MicroMsg.NetSceneDownloadPackage", "packageName " + str3);
                int a2 = com.tencent.mm.a.e.a(str2, str3, a);
                if (a2 != 0) {
                    r.QO().bi(this.hLs, this.frj);
                    x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + a2);
                    this.gLE.a(3, -1, str, this);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= be.size) {
                    String bh;
                    boolean z = false;
                    if (this.frj == 1) {
                        bh = r.QO().bh(this.hLs, this.frj);
                        a2 = bi.fz(str2 + str3, bh);
                        if (a2 < 0) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + bh);
                            r.QO().bi(this.hLs, this.frj);
                            this.gLE.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.frj == 8) {
                        z = ap(str2, str3);
                    }
                    if (this.frj == 23) {
                        if (bi.oN(str2) || bi.oN(str3)) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", str2, str3);
                            r.QO().bi(this.hLs, this.frj);
                            this.gLE.a(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.x(str2 + str3, com.tencent.mm.compatible.util.e.hbv + "permissioncfg.cfg")) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.QO().bi(this.hLs, this.frj);
                                this.gLE.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            x.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", str2, str3);
                            r.QO().bi(this.hLs, this.frj);
                            this.gLE.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.frj == 7) {
                        z = true;
                    }
                    if (this.frj == 9) {
                        z = true;
                    }
                    if (this.frj == 5) {
                        z = true;
                        x.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.frj == 12) {
                        com.tencent.mm.sdk.b.b mgVar = new mg();
                        mgVar.fEL.fEN = str2 + str3;
                        com.tencent.mm.sdk.b.a.xmy.m(mgVar);
                        z = true;
                    }
                    if (this.frj == 18) {
                        bh = r.QO().bh(this.hLs, this.frj);
                        a2 = bi.fz(str2 + str3, bh);
                        if (a2 < 0) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + a2 + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + bh);
                            r.QO().bi(this.hLs, this.frj);
                            this.gLE.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            x.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", bh);
                            z = true;
                        }
                    }
                    if (this.frj == 20) {
                        z = true;
                    }
                    if (this.frj == 21) {
                        z = true;
                    }
                    if (this.frj == 26) {
                        if (bi.oN(str2) || bi.oN(str3)) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", str2, str3);
                            this.gLE.a(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.x(str2 + str3, com.tencent.mm.compatible.util.e.hbv + "ipcallCountryCodeConfig.cfg")) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.QO().bi(this.hLs, this.frj);
                                this.gLE.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                x.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            x.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", str2, str3);
                            r.QO().bi(this.hLs, this.frj);
                            this.gLE.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.frj == 36) {
                        z = ao(str2, str3);
                    }
                    if (z) {
                        be.status = 2;
                        be.fEo = 64;
                        r.QO().b(be);
                        this.gLE.a(0, 0, "", this);
                        return;
                    }
                    return;
                } else if (a(this.hok, this.gLE) < 0) {
                    r.QO().bi(this.hLs, this.frj);
                    this.gLE.a(3, -1, str, this);
                    return;
                } else {
                    return;
                }
            }
        }
        x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        r.QO().bi(this.hLs, this.frj);
        this.gLE.a(i2, i3, str, this);
    }

    private static boolean ao(String str, String str2) {
        Throwable e;
        boolean z = true;
        if (bi.oN(str) || bi.oN(str2)) {
            return false;
        }
        try {
            String str3 = str + str2;
            Object bT = com.tencent.mm.a.e.bT(str3);
            if (bi.oN(bT)) {
                z = false;
            } else {
                g.Dq().Db().a(w.a.USERINFO_SENSE_WHERE_LOCATION_STRING, bT);
            }
            try {
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                x.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", Boolean.valueOf(z), str3, bi.Wz(bT));
                return z;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable e3) {
            e = e3;
            z = false;
            x.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
            return z;
        }
    }

    private boolean ap(String str, String str2) {
        Throwable e;
        Throwable th;
        InputStream inputStream = null;
        if (bi.oN(str) || bi.oN(str2)) {
            x.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, no file assigned, packagePath:" + str + " ,packageName:" + str2);
            r.QO().bi(this.hLs, this.frj);
            this.gLE.a(3, 0, "open regioncode file fail", this);
            return false;
        }
        File file = new File(str + str2);
        if (file.exists()) {
            Map hashMap = new HashMap();
            InputStream fileInputStream;
            BufferedWriter bufferedWriter;
            try {
                fileInputStream = new FileInputStream(file);
                Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    String Yk;
                    File file2;
                    if (readLine != null) {
                        String[] split = readLine.trim().split("\\|");
                        if (split.length < 2 || bi.oN(split[0]) || bi.oN(split[1])) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, error line = " + readLine);
                        } else {
                            bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                            if (bufferedWriter == null) {
                                RegionCodeDecoder.ckE();
                                Yk = RegionCodeDecoder.Yk(split[0]);
                                if (bi.oN(Yk)) {
                                    x.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, output language unsupported");
                                } else {
                                    try {
                                        file2 = new File(Yk);
                                        if (!file2.exists()) {
                                            file2.createNewFile();
                                        }
                                        bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                        hashMap.put(split[0], bufferedWriter);
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                }
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(split[1]);
                            stringBuffer.append('|');
                            stringBuffer.append(split[2]);
                            stringBuffer.append(10);
                            bufferedWriter.write(stringBuffer.toString());
                        }
                    } else {
                        for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                            if (bufferedWriter2 != null) {
                                bufferedWriter2.flush();
                            }
                        }
                        if (!bi.oN(Yk)) {
                            for (File file22 : new File(Yk).getParentFile().listFiles(new FileFilter() {
                                public final boolean accept(File file) {
                                    return file.getName().endsWith("txt");
                                }
                            })) {
                                RegionCodeDecoder.ckE();
                                RegionCodeDecoder.f(file22, file22.getParentFile());
                            }
                            RegionCodeDecoder.ckE().ciC();
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        file.delete();
                        try {
                            fileInputStream.close();
                            for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                                if (bufferedWriter22 != null) {
                                    bufferedWriter22.close();
                                }
                            }
                        } catch (Throwable e3) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bi.i(e3));
                        }
                        return true;
                    }
                }
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = null;
                try {
                    x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bi.i(e3));
                    r.QO().bi(this.hLs, this.frj);
                    this.gLE.a(3, 0, e3.getMessage(), this);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e32) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bi.i(e32));
                            return false;
                        }
                    }
                    for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                        if (bufferedWriter222 != null) {
                            bufferedWriter222.close();
                        }
                    }
                    return false;
                } catch (Throwable e322) {
                    inputStream = fileInputStream;
                    th = e322;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3222) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", bi.i(e3222));
                            throw th;
                        }
                    }
                    for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                        if (bufferedWriter2222 != null) {
                            bufferedWriter2222.close();
                        }
                    }
                    throw th;
                }
            } catch (Throwable e32222) {
                th = e32222;
                if (inputStream != null) {
                    inputStream.close();
                }
                for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    if (bufferedWriter22222 != null) {
                        bufferedWriter22222.close();
                    }
                }
                throw th;
            }
        }
        x.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, file not exist, packagePath:" + str + " ,packageName:" + str2);
        r.QO().bi(this.hLs, this.frj);
        this.gLE.a(3, 0, "no regioncode file found", this);
        return false;
    }

    public final int getType() {
        return JsApiSetBackgroundAudioState.CTRL_INDEX;
    }

    public final int Kr() {
        return this.frj;
    }
}
