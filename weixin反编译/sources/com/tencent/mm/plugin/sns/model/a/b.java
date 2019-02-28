package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.c;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class b extends c {
    private static HashSet<String> rfb = new HashSet();
    private long dnsCostTime = -1;
    protected are fIx = null;
    private String host = "";
    private int ibm = -1;
    protected a reH;
    protected n reI = null;
    protected a reJ = null;
    private String reK = "";
    private String reL = "";
    private String reM = "";
    private int reN = 0;
    protected int reO = 0;
    private long reP = -1;
    protected long reQ = -1;
    protected long reR = -1;
    protected long reS = -1;
    protected String reT = "";
    protected PString reU = new PString();
    protected int reV;
    protected long reW;
    protected long reX;
    protected long reY;
    private int reZ = 0;
    private int retCode = -1;
    protected int rfa = 0;
    private Map<String, List<String>> rfc;
    int rfd = 0;

    public abstract boolean bwR();

    protected abstract int bwS();

    public abstract boolean p(InputStream inputStream);

    public final /* synthetic */ Object bvz() {
        return bwT();
    }

    public b(a aVar, a aVar2) {
        super(aVar, aVar2);
        this.reH = aVar;
        this.reJ = aVar2;
        if (aVar2 != null) {
            this.fIx = aVar2.qZY;
            rfb.add(aVar2.qZX);
            aVar2.init();
        }
    }

    public boolean bwQ() {
        return true;
    }

    public String Lp(String str) {
        return str;
    }

    public u b(u uVar) {
        return uVar;
    }

    protected static boolean a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    public final boolean a(an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.time == 0 || bi.bz((long) anVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    public final Integer bwT() {
        g.Dr();
        if (!g.Dq().isSDCardAvailable() || this.reJ == null) {
            ip(false);
            return Integer.valueOf(2);
        }
        if (bwQ()) {
            x.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.reJ.qZT + this.reJ.bwP());
            FileOp.deleteFile(r0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.reS = System.currentTimeMillis();
        x.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.reJ.mediaId + " " + this.reJ.reD + " type " + this.reJ.reF);
        FileOp.ml(this.reJ.getPath());
        an anVar = this.reJ.reG;
        String str = "";
        if (anVar == null) {
            str = "";
        } else if (anVar.equals(an.xHq)) {
            str = "album_friend";
        } else if (anVar.equals(an.xHr)) {
            str = "album_self";
        } else if (anVar.equals(an.xHs)) {
            str = "album_stranger";
        } else if (anVar.equals(an.xHt)) {
            str = "profile_friend";
        } else if (anVar.equals(an.xHu)) {
            str = "profile_stranger";
        } else if (anVar.equals(an.xHv)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (anVar.equals(an.xHp)) {
            str = "timeline";
        }
        if (!bi.oN(str)) {
            str = "&scene=" + str;
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(d.vHl), o.getString(ae.bvM()), Integer.valueOf(ao.getNetTypeForStat(ad.getContext())), Integer.valueOf(ao.getStrength(ad.getContext())), str});
        this.reJ.url = Lp(this.reJ.url);
        this.dnsCostTime = bi.Wy();
        long j = (long) com.tencent.mm.j.g.Af().getInt(this.reJ.reE ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        x.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.reJ.reE), Boolean.valueOf(this.reJ.reD), com.tencent.mm.j.g.Af().getValue(this.reJ.reE ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(this.reJ.url, a(anVar, this.reJ.url, j, r6));
        this.dnsCostTime = bi.bA(this.dnsCostTime);
        try {
            str = bi.oN(bVar.ip) ? InetAddress.getByName(bVar.host).getHostAddress() : bVar.ip;
        } catch (Exception e) {
            str = "-";
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", format, this.reJ.url, this.reJ.mediaId, Integer.valueOf(bVar.ibm), str, this.reJ.url, Integer.valueOf(this.reJ.reF), Boolean.valueOf(r1), anVar.toString());
        this.reO = 1;
        u a = a(bVar, format);
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s";
        Object[] objArr = new Object[5];
        objArr[0] = bVar.ip;
        objArr[1] = Boolean.valueOf(a != null);
        objArr[2] = Integer.valueOf(this.reO);
        objArr[3] = Boolean.valueOf(bVar.ibp);
        objArr[4] = bVar.ibo;
        x.i(str2, str3, objArr);
        int i = 2;
        if (a != null) {
            i = c(a);
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", Long.valueOf(bi.bA(currentTimeMillis)), Long.valueOf(this.reP), this.reJ.mediaId, this.reJ.url, Integer.valueOf(this.rfd));
        return Integer.valueOf(i);
    }

    private u a(com.tencent.mm.network.b.b bVar, String str) {
        String message;
        try {
            this.reM = bVar.ip;
            this.ibm = bVar.ibm;
            this.reQ = bi.Wy();
            u a = com.tencent.mm.network.b.a(this.reJ.url, bVar);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str);
            if (bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                x.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a.setRequestProperty("Connection", "close");
            }
            a.setConnectTimeout(25000);
            a.setReadTimeout(25000);
            u b = b(a);
            this.rfc = b.getHeaderFields();
            List list = (List) this.rfc.get("X-ClientIp");
            if (list != null && list.size() > 0) {
                this.reL = (String) list.get(0);
            }
            list = (List) this.rfc.get("X-ServerIp");
            if (list != null && list.size() > 0) {
                this.reK = (String) list.get(0);
            }
            list = (List) this.rfc.get("X-ErrNo");
            if (list != null && list.size() > 0) {
                this.reN = bi.Wo((String) list.get(0));
            }
            list = (List) this.rfc.get("X-RtFlag");
            if (list != null && list.size() > 0) {
                this.reO = bi.Wo((String) list.get(0));
            }
            try {
                this.retCode = b.getResponseCode();
                this.host = b.url.getHost();
                if (this.retCode == 200 || this.retCode == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
                    P(b.getHeaderFields());
                    if (d(b)) {
                        this.reQ = bi.bA(this.reQ);
                        list = (List) this.rfc.get("Content-Length");
                        if (list != null && list.size() > 0) {
                            this.rfa = bi.Wo((String) list.get(0));
                        }
                        x.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", this.reJ.url, this.reL, this.reK, Integer.valueOf(this.rfa), Integer.valueOf(this.reN));
                        return b;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.a(22, 62, 1, true);
                    x.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.reJ.mediaId);
                    ip(false);
                    return null;
                }
                P(b.getHeaderFields());
                if (this.reJ.reE) {
                    if (this.retCode >= 400 && this.retCode < 500) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(22, 78, 1, true);
                    } else if (this.retCode >= 500 && this.retCode < 600) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(22, 79, 1, true);
                    }
                } else if (this.retCode >= 400 && this.retCode < 500) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(22, 56, 1, true);
                } else if (this.retCode >= 500 && this.retCode < 600) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(22, 57, 1, true);
                }
                if (this.reJ.reD) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.reJ.mediaId + " " + this.reJ.url + " " + this.retCode);
                ip(false);
                return null;
            } catch (SocketTimeoutException e) {
                this.retCode = 1;
                ip(false);
                message = e.getMessage();
                if (this.reJ.reE) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(22, 77, 1, true);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(22, 55, 1, true);
                }
                if (this.reJ.reD) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.reJ.mediaId + " " + this.reJ.url + " msg:" + message);
                return null;
            } catch (Exception e2) {
                ip(false);
                message = e2.getMessage();
                if (this.reJ.reD) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.reJ.mediaId + " " + this.reJ.url + " msg:" + message);
                return null;
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "connect fail : " + e3.getMessage(), new Object[0]);
            this.retCode = 2;
            ip(false);
            return null;
        }
    }

    private int c(u uVar) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            this.reY = bi.Wy();
            InputStream inputStream3 = uVar.getInputStream();
            try {
                this.reR = bi.Wy();
                boolean p = p(inputStream3);
                inputStream3.close();
                x.i("MicroMsg.SnsCdnDownloadBase", "reportResult ret : " + p);
                if (p) {
                    this.reR = bi.bA(this.reR);
                    this.reP = bi.bA(this.reS);
                    boolean bwR = bwR();
                    x.i("MicroMsg.SnsCdnDownloadBase", "processData ret : " + bwR);
                    if (bwR) {
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        ip(true);
                        if (this.reJ.reD) {
                            return 3;
                        }
                        return 1;
                    }
                    this.retCode = 3;
                    ip(false);
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.aBw.disconnect();
                    return 2;
                }
                ip(false);
                if (uVar == null) {
                    return 2;
                }
                uVar.aBw.disconnect();
                return 2;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream3;
                try {
                    x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "snscdndownload fail : " + e.getMessage(), new Object[0]);
                    this.retCode = 4;
                    ip(false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "", new Object[0]);
                        }
                    }
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.aBw.disconnect();
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "", new Object[0]);
                        }
                    }
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream3;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e32 = e4;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            throw th;
        }
    }

    private static void P(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = (List) map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + ":");
                        for (String str2 : list) {
                            stringBuffer.append(str2 + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                x.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", stringBuffer.toString());
            } catch (Exception e) {
            }
        }
    }

    private static boolean d(u uVar) {
        try {
            List list = (List) uVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (bi.oN(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    private static long Lq(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return bi.getLong(split[3], 0) + (((16777216 * bi.getLong(split[0], 0)) + (HardCoderJNI.ACTION_ALLOC_MEMORY * bi.getLong(split[1], 0))) + (256 * bi.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    private void ip(boolean z) {
        long j;
        String str;
        if (this.reJ == null || !this.reJ.reE) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.pWK.a(22, 53, this.reP, true);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(22, 52, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(22, 51, 1, true);
        } else {
            if (z) {
                com.tencent.mm.plugin.report.service.g.pWK.a(22, 75, this.reP, true);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(22, 74, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(22, 73, 1, true);
        }
        if (!(this.reJ == null || !this.reJ.reD || z || i.b(this.reI))) {
            com.tencent.mm.plugin.report.service.g.pWK.a(150, 66, 1, true);
        }
        this.reZ = this.rfd;
        int i = ao.isWifi(ad.getContext()) ? 1 : 0;
        int strength = ao.getStrength(ad.getContext());
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]";
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.ibm);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.reQ);
        objArr[5] = Long.valueOf(this.reR);
        objArr[6] = Long.valueOf(this.reP);
        objArr[7] = this.reK;
        objArr[8] = this.reM;
        objArr[9] = this.reL;
        objArr[10] = this.reJ == null ? "" : this.reJ.url;
        x.v(str2, str3, objArr);
        int netType = ao.getNetType(ad.getContext());
        int i2 = 0;
        if (this.reJ != null) {
            i2 = this.reJ.reF == 4 ? 1 : 0;
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", Integer.valueOf(this.retCode), Integer.valueOf(this.reZ), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.reN));
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr2 = new Object[19];
        if (this.reJ == null) {
            str2 = "";
        } else {
            str2 = this.reJ.url;
        }
        objArr2[0] = str2;
        objArr2[1] = Long.valueOf(Lq(this.reM));
        if (z) {
            j = this.reP;
        } else {
            j = 0;
        }
        objArr2[2] = Long.valueOf(j);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.reQ);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.reR);
        objArr2[10] = Long.valueOf(Lq(this.reL));
        objArr2[11] = Long.valueOf(Lq(this.reK));
        objArr2[12] = Integer.valueOf(this.ibm);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.retCode);
        objArr2[15] = Integer.valueOf(this.reZ);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.reN);
        gVar.h(10736, objArr2);
        boolean isConnected = ao.isConnected(ad.getContext());
        x.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.reT);
        if (!(z || bi.oN(this.reT) || !isConnected)) {
            com.tencent.mm.network.b.reportFailIp(this.reT);
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", this.reU.value);
        int bwS = bwS();
        str2 = "";
        switch (bwS) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        c fp = com.tencent.mm.y.c.c.IL().fp(str);
        i = 0;
        if (fp.isValid()) {
            i = bi.getInt((String) fp.civ().get("needUploadData"), 1);
            str2 = fp.field_expId;
        }
        if (i != 0) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.q("20ImgSize", this.rfd + ",");
            dVar.q("21NetType", (ao.isWifi(ad.getContext()) ? 1 : 0) + ",");
            dVar.q("22DelayTime", (this.reP - this.reQ) + ",");
            dVar.q("23RetCode", this.retCode + ",");
            dVar.q("24DnsCostTime", this.dnsCostTime + ",");
            dVar.q("25ConnectCostTime", this.reQ + ",");
            dVar.q("26SendCostTime", ",");
            dVar.q("27WaitResponseCostTime", this.reX + ",");
            dVar.q("28ReceiveCostTime", this.reR + ",");
            dVar.q("29ClientAddrIP", this.reL + ",");
            dVar.q("30ServerAddrIP", this.reM + ",");
            dVar.q("31dnstype", this.ibm + ",");
            dVar.q("32signal", ao.getStrength(ad.getContext()) + ",");
            dVar.q("33host", this.host + ",");
            dVar.q("34MediaType", bwS + ",");
            dVar.q("35X_Errno", this.reN + ",");
            dVar.q("36MaxPackageSize", this.reV + ",");
            dVar.q("37MaxPackageTimeStamp", this.reW + ",");
            dVar.q("38PackageRecordList", this.reU.value + ",");
            dVar.q("39ExpLayerId", str + ",");
            dVar.q("40ExpId", str2 + ",");
            dVar.q("41FeedId", ",");
            x.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.SG());
            com.tencent.mm.plugin.report.service.g.pWK.h(13480, dVar);
            if (this.retCode != 200) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14071, dVar);
            }
        }
    }

    public final void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.reJ != null) {
            x.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", num, this.reJ.url, this.reJ.mediaId, Integer.valueOf(this.reZ), Integer.valueOf(rfb.size()));
            rfb.remove(this.reJ.qZX);
            if (this.reJ.reD && num.intValue() != 2) {
                au.Lb(this.reJ.mediaId);
                bwU();
            } else if (!this.reJ.reD && this.reJ.reF == 4) {
                ae.bwc().eg(this.reJ.mediaId, this.reJ.getPath() + i.j(this.fIx));
            }
            this.reH.a(num.intValue(), this.fIx, this.reJ.reF, this.reJ.reD, this.reJ.qZX, this.reZ);
        }
    }

    public final void bwU() {
        int i = 0;
        if (!ae.bvO()) {
            System.currentTimeMillis();
            if (this.reJ.qWO.qWU == 4) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.reI = com.tencent.mm.plugin.sns.lucky.a.a.ee(this.reJ.getPath() + i.e(this.fIx), this.reJ.getPath() + i.g(this.fIx));
                ae.bwc().a(this.reJ.mediaId, this.reI, this.reJ.qWO.qWU);
            } else if (this.reJ.qWO.qWU == 5) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.reI = com.tencent.mm.plugin.sns.lucky.a.a.ee(this.reJ.getPath() + i.e(this.fIx), this.reJ.getPath() + i.h(this.fIx));
                ae.bwc().a(this.reJ.mediaId, this.reI, this.reJ.qWO.qWU);
            } else if (this.reJ.qWO.list.size() <= 1) {
                ae.bwc().a(this.reJ.mediaId, this.reI, this.reJ.qWO.qWU);
            } else {
                ae.bwc().a(this.reJ.mediaId, this.reI, 0);
                List linkedList = new LinkedList();
                while (true) {
                    int i2 = i;
                    if (i2 >= this.reJ.qWO.list.size() || i2 >= 4) {
                        this.reI = n.i(i.h(linkedList, ae.bwn()));
                        x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.reJ.qWO.hMN + " " + this.reI);
                        ae.bwc().a(this.reJ.qWO.hMN, this.reI, this.reJ.qWO.qWU);
                    } else {
                        are are = (are) this.reJ.qWO.list.get(i2);
                        n KG = ae.bwc().KG(are.nMq);
                        if (i.b(KG)) {
                            linkedList.add(KG);
                            x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + KG + " " + are.nMq);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
                this.reI = n.i(i.h(linkedList, ae.bwn()));
                x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.reJ.qWO.hMN + " " + this.reI);
                ae.bwc().a(this.reJ.qWO.hMN, this.reI, this.reJ.qWO.qWU);
            }
            String str = null;
            if (this.reJ.qWO.qWU == 0) {
                str = "0-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 1) {
                str = "1-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 4) {
                str = "4-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 5) {
                str = "5-" + this.reJ.qWO.hMN;
            }
            ae.bwc().KF(str);
        }
    }

    public final ag bvy() {
        return ae.bvQ();
    }
}
