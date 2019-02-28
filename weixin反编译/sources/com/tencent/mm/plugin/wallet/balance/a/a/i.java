package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i {
    public static final i sEu = new i();
    private static final String sEv = (a.bnF + "wallet/lqt");
    private static final String sEw = (sEv + "/save/");
    private static final String sEx = (sEv + "/fetch/");
    public apr sEo;
    public apr sEp;
    private long sEq;
    private long sEr;
    private List<Bankcard> sEs;
    private List<Bankcard> sEt;

    public final void a(apr apr, final boolean z) {
        if (apr != null) {
            if (z) {
                this.sEo = apr;
                this.sEs = null;
                this.sEq = System.currentTimeMillis();
            } else {
                this.sEp = apr;
                this.sEt = null;
                this.sEr = System.currentTimeMillis();
            }
            x.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", apr, Boolean.valueOf(z));
            try {
                final byte[] toByteArray = apr.toByteArray();
                e.post(new Runnable() {
                    public final void run() {
                        if (toByteArray != null) {
                            if (z) {
                                if (FileOp.bO(i.sEw)) {
                                    FileOp.G(i.sEw, true);
                                }
                                FileOp.ml(i.sEw);
                                i.this.sEs = null;
                            } else {
                                if (FileOp.bO(i.sEx)) {
                                    FileOp.G(i.sEx, true);
                                }
                                FileOp.ml(i.sEx);
                                i.this.sEt = null;
                            }
                            try {
                                String str = System.currentTimeMillis();
                                String str2 = "MicroMsg.LqtBindQueryInfoCache";
                                String str3 = "saveCacheToDisk, dir: %s, name: %s, save: %s";
                                Object[] objArr = new Object[3];
                                objArr[0] = z ? i.sEw : i.sEx;
                                objArr[1] = str;
                                objArr[2] = Boolean.valueOf(z);
                                x.i(str2, str3, objArr);
                                long Wz = bi.Wz();
                                FileOp.j((z ? i.sEw : i.sEx) + str, toByteArray);
                                x.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", Long.valueOf(bi.bB(Wz)));
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", e.getMessage());
                            }
                        }
                    }
                }, "LqtBindQueryInfoCache_saveCacheToDiski");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "saveCacheToDisk error: %s", e.getMessage());
            }
        }
    }

    public final Bankcard jx(boolean z) {
        jB(z);
        apr apr = z ? this.sEo : this.sEp;
        if (!(apr == null || bi.oN(apr.wDc))) {
            List<Bankcard> jA = jA(z);
            if (jA != null && jA.size() > 0) {
                String str = apr.wDc;
                if (!bi.oN(str)) {
                    for (Bankcard bankcard : jA) {
                        if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                            return bankcard;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final List<Bankcard> jy(boolean z) {
        jB(z);
        if ((z ? this.sEo : this.sEp) != null) {
            return jA(z);
        }
        return null;
    }

    public final String jz(boolean z) {
        jB(z);
        apr apr = z ? this.sEo : this.sEp;
        if (apr != null) {
            return apr.wDf;
        }
        return null;
    }

    private List<Bankcard> jA(boolean z) {
        if ((z ? this.sEo : this.sEp) != null) {
            if (z) {
                if (this.sEs != null && this.sEs.size() > 0) {
                    return this.sEs;
                }
            } else if (this.sEt != null && this.sEt.size() > 0) {
                return this.sEt;
            }
            Bankcard a;
            Iterator it;
            if (z) {
                this.sEs = new ArrayList();
                if (this.sEo.wDe != null) {
                    a = ab.a(this.sEo.wDe);
                    if (a != null) {
                        this.sEs.add(a);
                    }
                }
                if (this.sEo.wpO != null && this.sEo.wpO.size() > 0) {
                    it = this.sEo.wpO.iterator();
                    while (it.hasNext()) {
                        a = d.a((lc) it.next());
                        if (a != null) {
                            this.sEs.add(a);
                        }
                    }
                }
                return this.sEs;
            }
            this.sEt = new ArrayList();
            if (this.sEp.wDe != null) {
                a = ab.a(this.sEp.wDe);
                if (a != null) {
                    this.sEt.add(a);
                }
            }
            if (this.sEp.wpO != null && this.sEp.wpO.size() > 0) {
                it = this.sEp.wpO.iterator();
                while (it.hasNext()) {
                    a = d.a((lc) it.next());
                    if (a != null) {
                        this.sEt.add(a);
                    }
                }
            }
            return this.sEt;
        } else if (z) {
            this.sEs = null;
            return null;
        } else {
            this.sEt = null;
            return null;
        }
    }

    public final void jB(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        apr apr = z ? this.sEo : this.sEp;
        long j = z ? this.sEq : this.sEr;
        if (apr != null) {
            if (currentTimeMillis - j > 3600000) {
                x.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
                this.sEo = null;
                if (z) {
                    this.sEq = 0;
                } else {
                    this.sEr = 0;
                }
            } else {
                return;
            }
        }
        String str = z ? sEw : sEx;
        List<FileEntry> F = FileOp.F(str, false);
        if (F != null && F.size() != 0) {
            x.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", F, Boolean.valueOf(z));
            long currentTimeMillis2 = System.currentTimeMillis();
            for (FileEntry fileEntry : F) {
                String name = new File(fileEntry.name).getName();
                String str2 = str + name;
                long j2 = bi.getLong(name, 0);
                x.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", Long.valueOf(j2));
                if (j2 <= 0) {
                    FileOp.deleteFile(str2);
                } else if (currentTimeMillis2 - j2 < 3600000) {
                    byte[] d = FileOp.d(str2, 0, (int) FileOp.mi(str2));
                    apr apr2 = new apr();
                    try {
                        apr2.aH(d);
                    } catch (Throwable e) {
                        apr2 = null;
                        x.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e, "parse bindquery from cache error: %s", e.getMessage());
                    }
                    if (apr2 != null) {
                        if (z) {
                            this.sEo = apr2;
                            this.sEs = null;
                            this.sEq = j2;
                        } else {
                            this.sEp = apr2;
                            this.sEt = null;
                            this.sEr = j2;
                        }
                        x.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", apr2, Long.valueOf(j2));
                        return;
                    }
                } else {
                    FileOp.deleteFile(str2);
                }
            }
        }
    }
}
