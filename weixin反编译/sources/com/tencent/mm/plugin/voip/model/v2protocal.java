package com.tencent.mm.plugin.voip.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bwf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v2protocal {
    public static final int oLp;
    public static int sgX;
    public static final int sud;
    public static boolean sue = false;
    public int channelStrategy = 0;
    public int defaultHeight = 240;
    public int defaultWidth = 320;
    public int[] field_ChannelReportDial = null;
    public int[] field_EngineAudioReportStat = null;
    public int[] field_SpeedTestSvrParaArray = null;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelReportLength = 0;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndReportLength = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int[] field_jbmBitratRsSvrParamArray = null;
    public double[] field_jbmBitratRsSvrParamDoubleArray = null;
    public int field_jbmParamArraySize = 0;
    public int field_jbmParamDoubleArraySize = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineReportLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int[] field_punchSvrArray = null;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int[] field_relaySvrArray = null;
    public int[] field_relayTcpSvrArray = null;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    public int field_voipcsChannelInfoLength = 0;
    public int field_voipcsEngineInfoLength = 0;
    public long hBI = 0;
    private ag handler = null;
    public int nJe = 0;
    public long nJf = 0;
    public int nJh = 0;
    public int nJm = 0;
    public String nYY = "";
    public int netType = 0;
    public boolean oCT = false;
    public int suA = 0;
    public int suB = 0;
    public int suC = 7;
    public int suD = 3;
    public int suE = 3;
    public int suF = 0;
    public int suG = 0;
    public int suH = -1;
    public int suI = -1;
    public int suJ = 0;
    public int suK = 0;
    public int suL = 0;
    public int suM = 0;
    public int suN = 100;
    public int suO = 300;
    public int suP = 1;
    public int suQ = 1;
    public int suR = 0;
    public int suS = 1;
    public int suT = 0;
    public int suU = 0;
    public int suV = 0;
    public int suW = 0;
    public int suX = 0;
    public int suY = 0;
    public int suZ = 0;
    public int suf = 0;
    public int sug = 0;
    public int suh = 0;
    public int sui = 0;
    public long suj = 0;
    public byte[] suk = null;
    public byte[] sul = null;
    public byte[] sum = null;
    public int sun = 0;
    public byte[] suo = null;
    public int sup = 500;
    public int suq = 30;
    public int sur = 999;
    public int sus = 0;
    public int sut = 20;
    public int suu = 0;
    public int suv = 0;
    public int suw = 0;
    public int sux = 0;
    public int suy = 0;
    public int suz = 65536;
    byte[] svA = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] svB = new byte[2048];
    byte[] svC = new byte[2048];
    byte[] svD = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] svE = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] svF = new byte[2048];
    byte[] svG = new byte[Downloads.RECV_BUFFER_SIZE];
    public byte[] svH = new byte[2048];
    public byte[] svI = new byte[2048];
    public byte[] svJ = new byte[2048];
    public byte[] svK = new byte[2048];
    public int[] svL = new int[30];
    int svM = 0;
    public h svN = new h();
    public int sva = 0;
    public int svb = 0;
    public int[] svc = null;
    public int svd = 0;
    public int sve = 0;
    public int svf = 0;
    public int svg = 0;
    public byte[] svh = null;
    public int svi = 0;
    public int svj = 0;
    public int svk = 0;
    public int svl = 0;
    public byte[] svm = new byte[1500];
    public int svn = 0;
    public byte[] svo = null;
    public byte[] svp = null;
    public int svq = 0;
    public int svr = 0;
    public int svs = 0;
    public long svt = 0;
    public byte[] svu = new byte[8];
    public int svv = 0;
    public int svw = 0;
    public int svx = 0;
    public int svy = 0;
    public int svz = 0;

    private native int forceredirect(int i, int i2);

    private native int setsvraddr(int i, int i2, int i3, String str, String str2);

    private native int uninit(int i, long j, int i2);

    public native int SendDTMF(int i);

    public native int SendRUDP(byte[] bArr, int i);

    public native int SetDTMFPayload(int i);

    public native int StartSpeedTest(long j, int i);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i, int i2, byte[] bArr, int i3, int i4);

    public native int app2EngineLinkQualityEx(int i, byte[] bArr);

    public native int connectToPeer();

    public native int connectToPeerDirect();

    public native int connectToPeerRelay();

    public native int doubleLinkSwitch(int i);

    public native int exchangeCabInfo(byte[] bArr, int i);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i);

    public native int getChannelInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int getChannelReport(byte[] bArr, int i);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i);

    public native int getEngine2ndInfoReport(byte[] bArr, int i);

    public native int getEngineQosInfo(byte[] bArr, int i);

    public native int getEngineVersionInfo(byte[] bArr, int i);

    public native int getNewEngineExtInfo(byte[] bArr, int i);

    public native int getNewEngineInfo(byte[] bArr, int i);

    public native int getNewEngineInfoReport(byte[] bArr, int i);

    public native int getPstnChannelInfo(byte[] bArr, int i, int i2, int i3);

    public native int getPstnEngineInfo(byte[] bArr, int i);

    public native int getStatInfo(byte[] bArr, int i, int[] iArr, int i2);

    public native int getVoipcsChannelInfo(byte[] bArr, int i, int i2);

    public native int getVoipcsEngineInfo(byte[] bArr, int i);

    public native int getcurstrategy();

    public native int handleCommand(byte[] bArr, int i);

    public native int init(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setActive();

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setConfigInfo(int i, long j, int i2, long j2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int i8, int i9, int i10, int i11, byte[] bArr3, int i12, int i13);

    public native int setInactive();

    public native int setJNIAppCmd(int i, byte[] bArr, int i2);

    public native int setNetSignalValue(int i, int i2);

    public native int setSvrConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int setjbmbitraterssvrparam();

    public native int startEngine();

    public native int videoDecode(int[] iArr);

    public native int videoEncodeToLocal(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    public native int videoRorate90D(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7, int i8);

    static {
        int yw = m.yw();
        if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.t(ad.getContext(), "libvoipCodec_v7a.so");
        } else if ((yw & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.t(ad.getContext(), "libvoipCodec.so");
        } else {
            d.t(ad.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", v2protocal.class.getClassLoader());
        yw = m.yw();
        sgX = yw;
        yw = (yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 16000 : 8000;
        oLp = yw;
        sud = ((yw / 1000) * 20) * 2;
    }

    public final int tv(int i) {
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            a.eA("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        return appCmd;
    }

    public static String bIz() {
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        return "," + str + "," + str2 + "," + str3 + "," + str4;
    }

    public static long aR(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getLong();
    }

    private String bIA() {
        return "," + this.channelStrategy;
    }

    public final String bIB() {
        if (this.field_videoDuration == 0) {
            a.eB("MicroMsg.Voip", "captureFrames:" + this.svv + ", videoduration: 0");
            return ",0";
        }
        a.eB("MicroMsg.Voip", "capturefps:" + (this.svv / this.field_videoDuration) + " framecount:" + this.svv + " videoDuration:" + this.field_videoDuration);
        return "," + (this.svv / this.field_videoDuration);
    }

    private String bIC() {
        a.eB("MicroMsg.Voip", "usePreConnect:" + this.suL);
        return "," + this.suL;
    }

    private String bID() {
        a.eB("MicroMsg.Voip", "preConnectSuccess:" + this.suM);
        return "," + this.suM;
    }

    public final String bIE() {
        if (VERSION.SDK_INT < 11) {
            this.suD = 0;
            this.suE = 2;
        } else {
            this.suD = 3;
            this.suE = 3;
        }
        if (q.gHG.gER >= 0) {
            this.suD = q.gHG.gER;
        }
        if (VERSION.SDK_INT >= 11 && l.xn() && 2 == q.gHP.gGA) {
            this.suE = 2;
        }
        if (q.gHG.gES >= 0) {
            this.suE = q.gHG.gES;
        }
        if (VERSION.SDK_INT < 11) {
            this.suC = 1;
        } else {
            this.suC = 7;
        }
        if (q.gHG.gEr) {
            this.suC = 1;
        }
        if (q.gHG.gEQ >= 0) {
            this.suC = q.gHG.gEQ;
        }
        if (q.gHG.gEs > 0) {
            this.suF = 3;
            this.suG = 0;
        } else if (q.gHG.gET >= 0) {
            this.suF = q.gHG.gET;
            this.suG = q.gHG.gET;
        }
        if (q.gHG.gEU >= 0) {
            this.suF = q.gHG.gEU;
        }
        if (q.gHG.gEV >= 0) {
            this.suG = q.gHG.gEV;
        }
        return "," + this.suD + "," + this.suE + "," + this.suC + "," + this.suF + "," + this.suG;
    }

    public v2protocal(ag agVar) {
        this.handler = agVar;
    }

    public int keep_onNotifyFromJni(int i, int i2, byte[] bArr) {
        if (i == 100) {
            a.b(bArr, "MicroMsg.Voip", i2);
        } else if (i == 101) {
            a.b(bArr, "MicroMsg.v2Core", i2);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = bArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public int keep_onNotifyFromJniInt(int i, int i2, int[] iArr) {
        if (iArr != null) {
            a.eB("MicroMsg.VoipService", "callByJni : arg1:" + i + " arg2:" + i2);
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = iArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public final int a(buw buw, buw buw2, buw buw3, int i, int i2) {
        if (buw == null || buw.xct <= 0) {
            a.eA("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
        } else {
            a.eA("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
            this.field_relaySvrArray = a.a(buw);
        }
        if (buw2 == null || buw2.xct <= 0) {
            a.eA("MicroMsg.Voip", "forceRedirect: No punch svr ip");
        } else {
            a.eA("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
            this.field_punchSvrArray = a.a(buw2);
        }
        if (buw3 == null || buw3.xct <= 0) {
            a.eA("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
        } else {
            a.eA("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
            this.field_relayTcpSvrArray = a.a(buw3);
        }
        int forceredirect = forceredirect(i, i2);
        a.eA("MicroMsg.Voip", "v2protocal forceRedirect ret :" + forceredirect);
        return forceredirect;
    }

    public final int a(buw buw, buw buw2, buw buw3, bwf bwf) {
        if (buw.xct > 0) {
            a.eA("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
            this.field_relaySvrArray = a.a(buw);
        } else {
            a.eA("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
        }
        if (buw2.xct > 0) {
            a.eA("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
            this.field_punchSvrArray = a.a(buw2);
        } else {
            a.eA("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
        }
        if (buw3.xct > 0) {
            a.eA("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
            this.field_relayTcpSvrArray = a.a(buw3);
        } else {
            a.eA("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
        }
        int i = setsvraddr(bwf.xdY, bwf.xdZ, bwf.xea, bwf.userName, bwf.mHK);
        a.eA("MicroMsg.Voip", "v2protocal setsvraddr ret :" + i);
        return i;
    }

    public final int bFf() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        this.netType = a.getNetType(ad.getContext());
        this.suh = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z5 = this.suh >= 4 && (sgX & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (sgX & 255) >= 26;
        if (!z5 || (sgX & 255) < 30) {
            z = false;
        } else {
            z = true;
        }
        if (q.gHF.gGe <= 0 || q.gHF.gFG.width < 480 || q.gHF.gFG.height < 360 || q.gHF.gFI.width < 480 || q.gHF.gFI.height < 360) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (q.gHF.gGe < 2 || q.gHF.gFG.width < 640 || q.gHF.gFG.height < 480 || q.gHF.gFI.width < 640 || q.gHF.gFI.height < 480) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (q.gHF.gGe == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        c cVar = q.gHF;
        if ((z5 || z2) && !z4) {
            if (z3) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = 360;
            }
            sue = true;
            a.eA("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        a.eA("MicroMsg.Voip", "steve: Android CPUFlag:" + (sgX & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z5 + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z4 + ", bEnable640FromLocal:" + z + ", bEnable640FromSvr:" + z3);
        this.svc = new int[(this.defaultWidth * this.defaultHeight)];
        as.Hm();
        this.sug = com.tencent.mm.y.c.Cn();
        if ((sgX & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.t(ad.getContext(), "libvoipCodec_v7a.so");
            a.eB("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
        } else if ((sgX & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.t(ad.getContext(), "libvoipCodec.so");
            a.eB("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        } else {
            d.t(ad.getContext(), "libvoipCodec_v5.so");
            a.eB("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
        }
        int i3 = VERSION.SDK_INT;
        int bJn = OpenGlRender.bJn();
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if ((q.gHF.gGf & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((q.gHF.gGf & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((q.gHF.gGf & 15) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        if (z) {
            i2 = i | 2;
        } else {
            i2 = i;
        }
        if (z2) {
            i2 |= 4;
        }
        i2 = init(this.netType | (i2 << 8), 2, this.defaultHeight | (this.defaultWidth << 16), (width << 16) | height, this.sug, sgX | ((bJn << 24) | (i3 << 16)), e.hbu + "app_lib/", 0);
        a.eA("MicroMsg.Voip", "protocal init ret :" + i2 + ",uin= " + this.sug + ", gl_vs:" + bJn + ", cpuFlag0=" + sgX);
        this.oCT = true;
        if (i2 < 0) {
            reset();
        }
        return i2;
    }

    public final String jq(boolean z) {
        if (this.oCT) {
            a.eA("MicroMsg.Voip", "call protocalUninit now...needStatInfo=" + z);
            this.field_ChannelReportDial = new int[6];
            this.field_ChannelReportDial[0] = this.svN.srh;
            this.field_ChannelReportDial[1] = this.svN.srn;
            this.field_ChannelReportDial[2] = this.svd;
            this.field_ChannelReportDial[3] = this.sve;
            this.field_ChannelReportDial[4] = this.svf;
            this.field_ChannelReportDial[5] = this.svg;
            this.field_EngineAudioReportStat = new int[8];
            bIE();
            this.field_EngineAudioReportStat[0] = this.sux;
            this.field_EngineAudioReportStat[1] = this.suy;
            this.field_EngineAudioReportStat[2] = this.suD;
            this.field_EngineAudioReportStat[3] = this.suE;
            this.field_EngineAudioReportStat[4] = this.suC;
            this.field_EngineAudioReportStat[5] = this.suF;
            this.field_EngineAudioReportStat[6] = this.suG;
            this.field_EngineAudioReportStat[7] = -1;
            this.oCT = false;
            uninit(this.nJe, this.nJf, this.nJm);
            sue = false;
            a.eA("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.svA, this.svA.length, this.svL, 30);
                getEngineVersionInfo(this.svB, this.svB.length);
                getEngineQosInfo(this.svC, this.svC.length);
                StringBuilder stringBuilder = new StringBuilder();
                long j = (long) this.sug;
                if (this.sug < 0) {
                    j = ((long) this.sug) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j).append(",").append(this.nJf).append(",").append(this.nJe).append(",").append(this.nJm).append(",");
                h hVar = this.svN;
                String stringBuilder2 = append.append(hVar.sqW + "," + hVar.sqX + "," + hVar.sqY + "," + hVar.sqZ + "," + hVar.sra + "," + hVar.srb + "," + hVar.srd + "," + hVar.sre + "," + hVar.srf + "," + hVar.srg + "," + hVar.srh).toString();
                a.eA("MicroMsg.Voip", "voipreport:DailStatString:" + stringBuilder2);
                append = stringBuilder.append(stringBuilder2).append(new String(this.svA, 0, this.field_statInfoLength)).append(bIz()).append(bIA()).append("," + this.svN.sri).append(new String(this.svB, 0, this.field_engineVersionStatLength)).append(bIB());
                a.eB("MicroMsg.Voip", "cpuCapacity:" + sgX);
                stringBuilder2 = append.append("," + sgX).append(bIC()).append(bID()).append(new String(this.svC, 0, this.field_engineQosStatLength)).toString();
                a.eA("MicroMsg.Voip", "statInfoBuffer = " + new String(this.svA, 0, this.field_statInfoLength));
                a.eA("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.svB, 0, this.field_engineVersionStatLength));
                a.eA("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.svC, 0, this.field_engineQosStatLength));
                a.eA("MicroMsg.Voip", "voipreport:StatString = " + stringBuilder2);
                ak.a.hhw.aV(this.field_netFlowRecv, this.field_netFlowSent);
                a.eB("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                return stringBuilder2;
            }
        }
        return "";
    }

    public static String bIF() {
        return "\u0000";
    }

    public final String bIG() {
        long j = 0;
        if (this.suv == 0 && this.suw == 0) {
            this.svN.sro = 0;
        } else if (this.suw != 0 && this.suv != 0) {
            this.svN.sro = 3;
        } else if (this.suw != 0) {
            this.svN.sro = 1;
        } else if (this.suv != 0) {
            this.svN.sro = 2;
        }
        this.svN.srw = a.getNetType(ad.getContext());
        this.svN.srv = this.field_videoDuration;
        this.svN.sru = this.field_audioDuration;
        this.suA = as.Hn().yd();
        long j2 = (this.svN.srE <= 0 || this.svN.sry <= this.svN.srE) ? 0 : this.svN.sry - this.svN.srE;
        a.eB("MicroMsg.Voip", "voipreport:acceptcalltime:" + j2);
        setJNIAppCmd(1, this.svu, this.svu.length);
        long aR = aR(this.svu);
        h hVar = this.svN;
        long j3 = (aR <= this.svN.srC || this.svN.srC <= 0) ? 0 : aR - this.svN.srC;
        hVar.srF = j3;
        h hVar2 = this.svN;
        if (aR > this.svN.srE && this.svN.srE > 0) {
            j = aR - this.svN.srE;
        }
        hVar2.srG = j;
        a.eB("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.svN.srF + " lCalledWaitTime:" + this.svN.srG);
        StringBuilder append = new StringBuilder().append(this.suu).append(",").append(this.nJe).append(",").append(this.nJf).append(",").append(this.nJm).append(",").append(this.svN.sqW).append(",").append(this.svN.srj).append(",").append(this.svN.srk).append(",").append(this.svN.srl).append(",").append(this.svN.srm).append(",").append(this.svN.srn).append(",").append(this.svN.sro).append(",").append(this.svN.srh).append(",").append(this.svN.srp).append(",").append(this.svN.srq).append(",").append(this.svN.srr).append(",").append(this.svN.srs).append(",").append(this.svN.srt).append(",").append(this.svN.sru).append(",").append(this.svN.srv).append(",").append(this.svN.srw).append(bIC()).append(bID()).append(bIz()).append(",").append(this.svN.srx).append(",").append(this.suz).append(",").append(this.suA).append(",").append(j2).append(",").append(this.svN.srF).append(",").append(this.svN.srG).append(",").append(this.suB).append(",").append(this.suh).append(bIA()).append(",").append(sgX & 255).append(",").append(this.suH).append(",").append(this.suI);
        String str = VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        str = append.append("," + str + "," + str2).append(",").append(this.svN.srz).append(",").append(this.svN.srB).append(",").append(this.svN.srA).toString();
        a.eA("MicroMsg.Voip", "voipreport:initNetType:" + this.suh);
        a.eA("MicroMsg.Voip", "voipreport:NewDialStatString:" + str);
        a.eA("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + bIA());
        return str;
    }

    public final String bIH() {
        getChannelInfo(this.svD, this.svD.length, this.svd, this.sve, this.svf, this.svg);
        a.eA("MicroMsg.Voip", "voipreport:oldChannelString: " + (this.nJf + "," + this.nJe + "," + this.nJm + this.svN.bHr() + ("," + this.svN.srn) + new String(this.svD, 0, this.field_channelStatLength)));
        getChannelReport(this.svD, this.svD.length);
        String str = new String(this.svD, 0, this.field_channelReportLength);
        a.eA("MicroMsg.Voip", "voipreport:newChannelString: " + str);
        return str;
    }

    public final String bII() {
        getNewEngineInfo(this.svE, this.svE.length);
        getNewEngineExtInfo(this.svF, this.svF.length);
        a.eA("MicroMsg.Voip", "voipreport:oldNewEngineString:" + (this.nJm + "," + this.nJf + this.svN.bHr() + "," + this.suv + "," + this.suw + bIB() + new String(this.svE, 0, this.field_newEngineStatLength) + "," + this.sux + "," + this.suy + bIE() + new String(this.svF, 0, this.field_newEngineExtStatLength)));
        getNewEngineInfoReport(this.svE, this.svE.length);
        String str = this.nJm + "," + this.nJf + this.svN.bHr() + "," + this.suv + "," + this.suw + bIB() + new String(this.svE, 0, this.field_newEngineReportLength);
        a.eA("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:" + str);
        return str;
    }

    public final String bIJ() {
        getEngine2ndInfo(this.svG, this.svG.length);
        a.eA("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:" + (this.nJf + "," + this.nJe + "," + this.nJm + new String(this.svG, 0, this.field_engine2ndStatLength)));
        getEngine2ndInfoReport(this.svG, this.svG.length);
        String str = this.nJf + "," + this.nJe + "," + this.nJm + new String(this.svG, 0, this.field_engine2ndReportLength);
        a.eA("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:" + str);
        return str;
    }

    public final void reset() {
        a.eA("MicroMsg.Voip", "v2protocal reset!");
        this.field_punchSvrArray = null;
        this.field_relaySvrArray = null;
        this.field_relayTcpSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.nJe = 0;
        this.suj = 0;
        this.sui = 0;
        this.nJm = 0;
        this.nJf = 0;
        this.channelStrategy = 0;
        this.nJh = 0;
        this.hBI = 0;
        this.suk = null;
        this.sul = null;
        this.sum = null;
        this.sun = 0;
        this.suo = null;
        this.svg = 0;
        this.svh = null;
        this.svi = 0;
        this.svj = 0;
        this.svo = null;
        this.svp = null;
        this.svv = 0;
        this.svw = 0;
        this.svx = 0;
        this.svy = 0;
        this.svz = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.svM = 0;
        this.suM = 0;
        this.suL = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.sux = 0;
        this.suy = 0;
        this.suz = 65536;
        this.suA = 0;
        this.suB = 0;
        this.suI = -1;
        this.suJ = 0;
        this.svs = 0;
        this.suf = 0;
        this.nYY = "";
        this.svq = 0;
        this.svr = 0;
        this.svN.reset();
        this.svN.bHq();
        sue = false;
        this.field_jbmBitratRsSvrParamArray = null;
        this.field_jbmParamArraySize = 0;
        this.field_jbmBitratRsSvrParamDoubleArray = null;
        this.field_jbmParamDoubleArraySize = 0;
        a.eA("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
    }
}
