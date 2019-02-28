package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class l {
    final String filePath;
    private final int fqg;
    private final int fqh;
    private final int fqi;
    private final boolean fqj;
    private final boolean fqn;
    volatile int state = -1;
    private final String url;
    final String vmK;
    private final String vmN;
    private final int vmO;
    private final byte[] vmP;
    private final String vmQ;
    private final long vmS;
    private final String vmT;
    private final int vmU;
    private final int vmV;
    volatile String vnV = null;
    volatile String vnW = null;
    final boolean vnt;
    final boolean vnu;

    l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        this.vmK = i.eB(i, i2);
        this.fqg = i;
        this.fqh = i2;
        this.filePath = str;
        this.vnu = z;
        this.vnt = z2;
        this.vmN = str2;
        this.vmO = i3;
        this.vmP = bArr;
        this.vmQ = str3;
        this.fqn = z3;
        this.fqj = z4;
        this.vmT = str4;
        this.vmS = j;
        this.url = str5;
        this.vmU = i4;
        this.vmV = i5;
        this.fqi = i6;
    }

    final l cae() {
        Throwable e;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", this.vmK, cah(), this.vnV, this.vnW, Boolean.valueOf(bi.oN(this.vmN)));
        if (1 == this.state) {
            if (bi.oN(this.vmN)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", this.vmK);
                this.vnV = null;
                this.state = 8;
                j.o(this.vmS, 54);
                j.o(this.vmS, 45);
            } else {
                boolean z;
                try {
                    String str = this.vnV;
                    String str2 = this.vnW;
                    String str3 = this.vmN;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file = new File(str2);
                        file.getParentFile().mkdirs();
                        file.delete();
                        byte[] SE = a.SE(str);
                        if (bi.by(SE)) {
                            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                            j.o(this.vmS, 56);
                            j.o(this.vmS, 45);
                            j.o(this.vmS, 18);
                            z = false;
                        } else {
                            SE = MMProtocalJni.aesDecrypt(SE, str3.getBytes());
                            if (bi.by(SE)) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                                j.o(this.vmS, 55);
                                j.o(this.vmS, 45);
                                j.o(this.vmS, 18);
                                z = false;
                            } else {
                                z = a.u(str2, SE);
                                if (!z) {
                                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                    j.o(this.vmS, 57);
                                    j.o(this.vmS, 45);
                                    j.o(this.vmS, 18);
                                }
                            }
                        }
                    } else {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                        z = false;
                    }
                    try {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", this.vmK, Boolean.valueOf(z));
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.vmK, e);
                        j.o(this.vmS, 45);
                        j.o(this.vmS, 18);
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vmK, Boolean.valueOf(z));
                        if (z) {
                            j.o(this.vmS, 17);
                            this.vnV = this.vnW;
                            if (this.vnt) {
                                this.vnW = this.filePath + ".decompressed";
                                this.state = 2;
                            } else {
                                this.state = 4;
                            }
                        } else {
                            this.vnV = null;
                            this.state = 8;
                        }
                        return this;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    z = false;
                    x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.vmK, e);
                    j.o(this.vmS, 45);
                    j.o(this.vmS, 18);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vmK, Boolean.valueOf(z));
                    if (z) {
                        j.o(this.vmS, 17);
                        this.vnV = this.vnW;
                        if (this.vnt) {
                            this.state = 4;
                        } else {
                            this.vnW = this.filePath + ".decompressed";
                            this.state = 2;
                        }
                    } else {
                        this.vnV = null;
                        this.state = 8;
                    }
                    return this;
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vmK, Boolean.valueOf(z));
                if (z) {
                    this.vnV = null;
                    this.state = 8;
                } else {
                    j.o(this.vmS, 17);
                    this.vnV = this.vnW;
                    if (this.vnt) {
                        this.vnW = this.filePath + ".decompressed";
                        this.state = 2;
                    } else {
                        this.state = 4;
                    }
                }
            }
        }
        return this;
    }

    final l caf() {
        Throwable e;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", this.vmK, cah(), this.vnV, this.vnW);
        if (2 == this.state) {
            boolean z;
            try {
                String str = this.vnV;
                String str2 = this.vnW;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] v = q.v(a.SE(str));
                    if (bi.by(v)) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = a.u(str2, v);
                    }
                } else {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", this.vmK, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.vmK, e);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vmK, Boolean.valueOf(z));
                    if (z) {
                        this.vnV = this.vnW;
                        this.state = 4;
                        j.o(this.vmS, 19);
                    } else {
                        this.vnV = null;
                        this.state = 8;
                        j.o(this.vmS, 20);
                        j.o(this.vmS, 46);
                        if (this.vnu) {
                            j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, false, false, this.vmT);
                        } else {
                            j.a(this.fqg, this.fqh, this.url, this.fqi, this.vmU > this.vmV ? j.a.vnN : j.a.vnL, false, this.fqn, false, this.vmT);
                        }
                    }
                    return this;
                }
            } catch (Throwable e3) {
                e = e3;
                z = false;
                x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.vmK, e);
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vmK, Boolean.valueOf(z));
                if (z) {
                    this.vnV = null;
                    this.state = 8;
                    j.o(this.vmS, 20);
                    j.o(this.vmS, 46);
                    if (this.vnu) {
                        if (this.vmU > this.vmV) {
                        }
                        j.a(this.fqg, this.fqh, this.url, this.fqi, this.vmU > this.vmV ? j.a.vnN : j.a.vnL, false, this.fqn, false, this.vmT);
                    } else {
                        j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, false, false, this.vmT);
                    }
                } else {
                    this.vnV = this.vnW;
                    this.state = 4;
                    j.o(this.vmS, 19);
                }
                return this;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vmK, Boolean.valueOf(z));
            if (z) {
                this.vnV = this.vnW;
                this.state = 4;
                j.o(this.vmS, 19);
            } else {
                this.vnV = null;
                this.state = 8;
                j.o(this.vmS, 20);
                j.o(this.vmS, 46);
                if (this.vnu) {
                    j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, false, false, this.vmT);
                } else if (this.vnt && this.fqj) {
                    if (this.vmU > this.vmV) {
                    }
                    j.a(this.fqg, this.fqh, this.url, this.fqi, this.vmU > this.vmV ? j.a.vnN : j.a.vnL, false, this.fqn, false, this.vmT);
                }
            }
        } else if (8 == this.state && this.vnu) {
            j.a(this.fqg, this.fqh, this.vmO, this.fqn, false, false, false, this.vmT);
        }
        return this;
    }

    final String cag() {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + cah(), this.vmK);
        if (16 == this.state) {
            return this.vnV;
        }
        if (4 != this.state && 32 != this.state) {
            return null;
        }
        String str;
        if (!bi.oN(this.vnV)) {
            String str2;
            String str3 = "MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer";
            String str4 = "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s";
            Object[] objArr = new Object[4];
            objArr[0] = this.vmK;
            objArr[1] = cah();
            objArr[2] = this.vmQ;
            if (this.vmP == null) {
                str2 = "null";
            } else {
                str2 = String.valueOf(this.vmP.length);
            }
            objArr[3] = str2;
            x.i(str3, str4, objArr);
            if (bi.oN(this.vmQ) || !bi.oM(g.bV(this.vnV)).equals(this.vmQ)) {
                if (this.state == 4) {
                    j.o(this.vmS, 24);
                }
                if (!bi.by(this.vmP) && UtilsJni.doEcdsaSHAVerify(i.vnw, a.SE(this.vnV), this.vmP) > 0) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", this.vmK, cah());
                    if (this.state == 4) {
                        j.o(this.vmS, 25);
                    }
                    str = this.vnV;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.vmK, str);
                    if (this.state == 4) {
                        return str;
                    }
                    if (bi.oN(str) && !this.vnt) {
                        j.o(this.vmS, 58);
                        j.o(this.vmS, 45);
                    }
                    if (bi.oN(str)) {
                        if (this.vnu) {
                            j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, true, false, this.vmT);
                            return str;
                        } else if (this.vnt && this.fqj) {
                            j.a(this.fqg, this.fqh, this.url, this.fqi, this.vmU > this.vmV ? j.a.vnN : j.a.vnL, false, this.fqn, true, this.vmT);
                            return str;
                        }
                    } else if (this.vnu) {
                        j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, true, true, this.vmT);
                        return str;
                    } else if (this.vnt && this.fqj) {
                        j.a(this.fqg, this.fqh, this.url, this.fqi, this.vmU > this.vmV ? j.a.vnN : j.a.vnL, true, this.fqn, true, this.vmT);
                        return str;
                    }
                } else if (this.state == 4) {
                    j.o(this.vmS, 26);
                }
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", this.vmK, cah());
                if (this.state == 4) {
                    j.o(this.vmS, 23);
                }
                str = this.vnV;
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.vmK, str);
                if (this.state == 4) {
                    return str;
                }
                j.o(this.vmS, 58);
                j.o(this.vmS, 45);
                if (bi.oN(str)) {
                    if (this.vnu) {
                        return this.vnt ? str : str;
                    } else {
                        j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, true, true, this.vmT);
                        return str;
                    }
                } else if (this.vnu) {
                    return this.vnt ? str : str;
                } else {
                    j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, true, false, this.vmT);
                    return str;
                }
            }
        }
        str = null;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.vmK, str);
        if (this.state == 4) {
            return str;
        }
        j.o(this.vmS, 58);
        j.o(this.vmS, 45);
        if (bi.oN(str)) {
            if (this.vnu) {
                j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, true, false, this.vmT);
                return str;
            } else if (this.vnt) {
            }
        } else if (this.vnu) {
            j.a(this.fqg, this.fqh, this.vmO, this.fqn, true, true, true, this.vmT);
            return str;
        } else if (this.vnt) {
        }
    }

    final String cah() {
        switch (this.state) {
            case 1:
                return "state_decrypt";
            case 2:
                return "state_decompress";
            case 4:
                return "state_check_sum";
            case 8:
                return "state_file_invalid";
            case 16:
                return "state_file_valid";
            case 32:
                return "state_pre_verify_check_sum";
            default:
                return this.state;
        }
    }
}
