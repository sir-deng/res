package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class f extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    private int hBE;
    a hGM;
    int hXx;
    boolean hpb;
    private a osB;
    int retCode;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i) {
        int i2 = 1;
        this.osB = null;
        this.hGM = null;
        this.retCode = 0;
        this.hXx = 0;
        this.hpb = false;
        this.osB = aVar;
        this.hBE = i;
        aVar.hXs = bi.Wy();
        if (aVar.msgType == 43) {
            aVar.status = 104;
            o.Ub();
            aVar.osw = s.nz(s.ny(aVar.aZc()));
            o.Ub();
            aVar.feh = s.nz(s.nx(aVar.aZc()));
            this.hXx = 2500;
            if (aVar.osx == 2) {
                this.hXx = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.hXx = 40;
            aVar.status = 104;
            aVar.feh = com.tencent.mm.modelvoice.o.nz(aVar.aZc());
            aVar.osw = 0;
        } else if (aVar.msgType == 3) {
            int i3;
            this.hXx = 40;
            if (i == 1) {
                this.hXx = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.osy = i3;
            aVar.status = 104;
            aVar.osw = 0;
            StringBuilder stringBuilder = new StringBuilder();
            as.Hm();
            aVar.feh = com.tencent.mm.a.e.bN(stringBuilder.append(c.Fp()).append(aVar.aZc()).toString());
        } else if (aVar.msgType == 1) {
            this.hXx = 1;
            aVar.status = 104;
            aVar.feh = aVar.aZc().getBytes().length;
            aVar.osw = 0;
        } else {
            x.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        b.a aVar2 = new b.a();
        aVar2.hnT = new aqz();
        aVar2.hnU = new ara();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.hnS = JsApiChooseMedia.CTRL_INDEX;
        aVar2.hnV = 84;
        aVar2.hnW = 1000000084;
        this.gLB = aVar2.Kf();
        aqz aqz = (aqz) this.gLB.hnQ.hnY;
        aqz.wEu = g.s(aVar.aZe().getBytes());
        aqz.wEF = aVar.ost;
        aqz.wEt = aVar.aZe();
        aVar.hQI = bi.Wy();
        aqz.wEv = aVar.aZb();
        aqz.nlX = aVar.msgType;
        aqz.wEw = aVar.osu;
        if (!z) {
            i2 = 0;
        }
        aqz.wEG = i2;
        aqz.wto = i;
        this.hGM = new a();
    }

    public final void cancel() {
        this.hpb = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 2;
        int i2 = 0;
        this.gLE = eVar2;
        if (this.hpb) {
            x.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        this.hXx--;
        if (this.hXx < 0) {
            x.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.osB == null) {
            x.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (bi.oN(this.osB.aZe())) {
            x.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.osB.ost == 0) {
            x.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.osB.feh <= 0) {
            x.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.osB.status == 103 && this.osB.osw <= 0) {
            x.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.osB.status == 103 || this.osB.status == 104) {
            aqz aqz = (aqz) this.gLB.hnQ.hnY;
            String aZc;
            if (this.osB.msgType == 43) {
                int i3;
                aZc = this.osB.aZc();
                if (bi.oN(aZc)) {
                    x.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    i3 = -1;
                } else {
                    aqz.wEx = new bes();
                    aqz.wEy = 0;
                    aqz.wEC = new bes();
                    aqz.wEB = 0;
                    aqz.wED = 2;
                    aqz.wEw = this.osB.osu;
                    if (this.osB.osx <= 0) {
                        i = 0;
                    }
                    aqz.wEE = i;
                    aqz.wEA = this.osB.osw;
                    aqz.wEz = this.osB.feh;
                    s.b i4;
                    Object obj;
                    bes bes;
                    if (this.osB.status == 103) {
                        o.Ub();
                        i4 = s.i(s.ny(aZc), this.osB.hXq, 8000);
                        if (i4.ret < 0 || i4.flJ == 0) {
                            x.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + aZc + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                            i3 = -1;
                        } else {
                            x.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + aZc + "] read ret:" + i4.ret + " readlen:" + i4.flJ + " newOff:" + i4.hXV + " netOff:" + this.osB.hXq);
                            if (i4.hXV < this.osB.hXq) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + aZc + "] newOff:" + i4.hXV + " OldtOff:" + this.osB.hXq);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[i4.flJ];
                                System.arraycopy(i4.buf, 0, obj, 0, i4.flJ);
                                aqz.wEB = this.osB.hXq;
                                bes = new bes();
                                bes.bl(obj);
                                aqz.wEC = bes;
                            }
                        }
                    } else {
                        o.Ub();
                        i4 = s.i(s.nx(aZc), this.osB.osv, 8000);
                        if (i4.ret < 0 || i4.flJ == 0) {
                            x.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + aZc + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                            i3 = -1;
                        } else {
                            x.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + aZc + "] read ret:" + i4.ret + " readlen:" + i4.flJ + " newOff:" + i4.hXV + " netOff:" + this.osB.osv);
                            if (i4.hXV < this.osB.osv) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + aZc + "] newOff:" + i4.hXV + " OldtOff:" + this.osB.osv);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else if (i4.hXV >= com.tencent.mm.modelvideo.c.hVb) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + aZc + "] maxsize:" + com.tencent.mm.modelvideo.c.hVb);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[i4.flJ];
                                System.arraycopy(i4.buf, 0, obj, 0, i4.flJ);
                                aqz.wEy = this.osB.osv;
                                aqz.wEB = this.osB.hXq;
                                bes = new bes();
                                bes.bl(obj);
                                aqz.wEx = bes;
                            }
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    return i3;
                }
            } else if (this.osB.msgType == 34) {
                aqz.wED = 0;
                aqz.wEE = 0;
                aqz.wEx = new bes().bl(new byte[0]);
                aqz.wEy = 0;
                aqz.wEC = new bes().bl(new byte[0]);
                aqz.wEB = 0;
                aqz.wEA = 0;
                aqz.wEz = this.osB.feh;
                com.tencent.mm.modelvoice.b nX = q.nX(this.osB.aZc());
                if (nX == null) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    x.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i2 = -1;
                } else {
                    com.tencent.mm.modelvoice.g bp = nX.bp(this.osB.osv, 8000);
                    if (bp.ret < 0) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.osB.aZc() + "] read ret:" + bp.ret + " readlen:" + bp.flJ + " newOff:" + bp.hXV + " netOff:" + this.osB.osv);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else if (bp.hXV < this.osB.osv || bp.hXV >= 469000) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.osB.aZc() + "] read ret:" + bp.ret + " readlen:" + bp.flJ + " newOff:" + bp.hXV + " netOff:" + this.osB.osv);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else if (this.osB.feh <= 0) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.osB.aZc() + "] read totalLen:" + this.osB.feh);
                        this.retCode = com.tencent.mm.compatible.util.g.getLine() + 10000;
                        i2 = -1;
                    } else {
                        Object obj2 = new byte[bp.flJ];
                        System.arraycopy(bp.buf, 0, obj2, 0, bp.flJ);
                        aqz.wEx = new bes().bl(obj2);
                        aqz.wEw = this.osB.osu;
                        aqz.wEy = this.osB.osv;
                        aqz.wEH = nX.getFormat();
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.osB.msgType == 3) {
                if (bi.oN(this.osB.aZc())) {
                    x.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    i2 = -1;
                } else {
                    aqz.wED = 0;
                    aqz.wEE = 0;
                    aqz.wEx = new bes().bl(new byte[0]);
                    aqz.wEy = 0;
                    aqz.wEC = new bes().bl(new byte[0]);
                    aqz.wEB = 0;
                    aqz.wEA = 0;
                    aqz.wEw = 0;
                    aqz.wEA = this.osB.osw;
                    aqz.wEz = this.osB.feh;
                    aqz.wto = this.hBE;
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    aZc = stringBuilder.append(c.Fp()).append(this.osB.aZc()).toString();
                    i = this.osB.feh - this.osB.osv;
                    if (i > 8000) {
                        i = 8000;
                    }
                    byte[] d = com.tencent.mm.a.e.d(aZc, this.osB.osv, i);
                    if (bi.by(d)) {
                        x.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.osB.aZc() + "]  Error ");
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else {
                        aqz.wEy = this.osB.osv;
                        aqz.wEB = this.osB.hXq;
                        bes bes2 = new bes();
                        bes2.bl(d);
                        aqz.wEx = bes2;
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.osB.msgType == 1) {
                aqz.wEx = new bes().bl(this.osB.aZc().getBytes());
                aqz.wEz = this.osB.feh;
                aqz.wEw = 0;
                aqz.wEy = 0;
                aqz.wEC = new bes().bl(new byte[0]);
                aqz.wEB = 0;
                aqz.wEA = 0;
                aqz.wED = 0;
                aqz.wEE = 0;
            } else {
                x.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.osB.msgType);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            return a(eVar, this.gLB, this);
        } else {
            x.d("MicroMsg.NetSceneMasSend", "msg type :" + this.osB.msgType);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 2500;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.gLE.a(i2, i3, str, this);
        } else if (this.osB == null) {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.gLE.a(i2, i3, str, this);
        } else if (this.osB.status == 104 || this.osB.status == 103) {
            ara ara = (ara) this.gLB.hnR.hnY;
            aqz aqz = (aqz) this.gLB.hnQ.hnY;
            if (aqz.wEA > 0 && aqz.wEC != null && aqz.wEC.wRm != null && !bi.by(aqz.wEC.wRm.toByteArray()) && aqz.wEB != ara.wEB - aqz.wEC.wRk) {
                x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gLE.a(3, -1, "doScene failed", this);
            } else if (aqz.wEz <= 0 || aqz.wEx == null || aqz.wEx.wRm == null || bi.by(aqz.wEx.wRm.toByteArray()) || aqz.wEy == ara.wEy - aqz.wEx.wRk) {
                this.osB.hXt = bi.Wx();
                int i4 = this.osB.status;
                if (i4 == 103) {
                    this.osB.hXq = aqz.wEC.wRk + aqz.wEB;
                    if (this.osB.hXq >= this.osB.osw) {
                        this.osB.status = 199;
                    }
                } else if (i4 == 104) {
                    this.osB.osv = aqz.wEx.wRk + aqz.wEy;
                    if (this.osB.osv >= this.osB.feh) {
                        if (this.osB.osw > 0) {
                            this.osB.status = 103;
                        } else {
                            this.osB.status = 199;
                        }
                    }
                } else {
                    x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:" + i4);
                    this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                    this.gLE.a(3, -1, "doScene failed", this);
                    return;
                }
                if (this.osB.status == 199) {
                    b aZj = h.aZj();
                    a aVar = this.osB;
                    if (aVar != null) {
                        aVar.fEo = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.fEo & 1) != 0) {
                            contentValues.put("clientid", aVar.aZb());
                        }
                        if ((aVar.fEo & 2) != 0) {
                            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(aVar.status));
                        }
                        if ((aVar.fEo & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.hXs));
                        }
                        if ((aVar.fEo & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.hXt));
                        }
                        if ((aVar.fEo & 16) != 0) {
                            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, aVar.aZc());
                        }
                        if ((aVar.fEo & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.aZd());
                        }
                        if ((aVar.fEo & 64) != 0) {
                            contentValues.put("tolist", aVar.aZe());
                        }
                        if ((aVar.fEo & FileUtils.S_IWUSR) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.ost));
                        }
                        if ((aVar.fEo & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.osu));
                        }
                        if ((aVar.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.osv));
                        }
                        if ((aVar.fEo & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.feh));
                        }
                        if ((aVar.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.hXq));
                        }
                        if ((aVar.fEo & 8192) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.osw));
                        }
                        if ((aVar.fEo & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.osx));
                        }
                        if ((aVar.fEo & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.osy));
                        }
                        if ((aVar.fEo & 65536) != 0) {
                            contentValues.put("reserved3", aVar.hiX == null ? "" : aVar.hiX);
                        }
                        if ((aVar.fEo & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            contentValues.put("reserved4", aVar.hiY == null ? "" : aVar.hiY);
                        }
                        if (((int) aZj.hiZ.insert("massendinfo", "clientid", contentValues)) != -1) {
                            as.Hm();
                            Object obj = c.Fk().XF("masssendapp") == null ? 1 : null;
                            ae aeVar = new ae();
                            aeVar.setUsername("masssendapp");
                            aeVar.setContent(b.a(aVar));
                            aeVar.aj(aVar.hXs);
                            aeVar.eS(0);
                            aeVar.eP(0);
                            if (obj != null) {
                                as.Hm();
                                c.Fk().d(aeVar);
                            } else {
                                as.Hm();
                                c.Fk().a(aeVar, "masssendapp");
                            }
                            aZj.doNotify();
                        }
                    }
                    x.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:" + (this.hGM != null ? this.hGM.zp() : 0));
                    this.gLE.a(i2, i3, str, this);
                } else if (a(this.hok, this.gLE) == -1) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    this.gLE.a(3, -1, "doScene failed", this);
                }
            } else {
                x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gLE.a(3, -1, "doScene failed", this);
            }
        } else {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.osB.status);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return JsApiChooseMedia.CTRL_INDEX;
    }
}
