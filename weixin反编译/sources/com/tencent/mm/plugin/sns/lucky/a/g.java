package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.f.a.pn;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private static int[] qXY = new int[]{50, 66, 68, 88, 99, 121, 123, JsApiLaunchMiniProgram.CTRL_INDEX, JsApiSetClipboardData.CTRL_INDEX, n.CTRL_BYTE, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
    private static String qXs = "";
    private static g qXt = null;
    private StringBuffer ksI = new StringBuffer();
    public long kzL = 0;
    public long qXA = 0;
    public long qXB = 0;
    public String qXC = "";
    public String qXD = "";
    public String qXE = "";
    public String qXF = "";
    public String qXG = "";
    public String qXH = "";
    public String qXI = "";
    public String qXJ = "";
    public String qXK = "";
    public String qXL = "";
    public String qXM = "";
    public String qXN = "";
    public String qXO = "";
    public String qXP = "";
    public String qXQ = "";
    public String qXR = "";
    public String qXS = "";
    public String qXT = "";
    public int qXU = -1;
    public String qXV = "";
    private List<List<Integer>> qXW = new LinkedList();
    private List<Integer> qXX = new LinkedList();
    private LinkedList<c> qXZ = new LinkedList();
    public String qXp = "";
    public long qXq = 0;
    public String qXu = "";
    public int qXv = 0;
    public int qXw = 0;
    public long qXx = 0;
    public long qXy = 0;
    public String qXz = "";

    public static g buY() {
        com.tencent.mm.kernel.g.Dr();
        if (!com.tencent.mm.kernel.g.Do().CF()) {
            return new g();
        }
        c fp = com.tencent.mm.y.c.c.IL().fp("100068");
        String str = fp.field_rawXML;
        if (bi.oN(str)) {
            str = "";
        }
        String s = com.tencent.mm.a.g.s(str.getBytes());
        if (qXt == null || !s.equals(qXs)) {
            x.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
            qXt = new g();
            try {
                Map civ = fp.civ();
                str = "";
                if (civ != null) {
                    str = (String) civ.get("SnsHBConfig");
                }
                if (bi.oN(str)) {
                    str = "";
                }
                str = URLDecoder.decode(str, "UTF-8");
                g gVar = qXt;
                gVar.ksI = new StringBuffer();
                gVar.qXZ.clear();
                Map y = bj.y(str, "sysmsg");
                if (y == null) {
                    x.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", str);
                } else {
                    gVar.qXq = bi.Wp((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                    gVar.ksI.append("BeginTime:" + gVar.qXq + ";");
                    gVar.kzL = bi.Wp((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                    gVar.ksI.append("EndTime:" + gVar.kzL + ";\n");
                    gVar.qXv = bi.Wo((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                    gVar.qXw = bi.Wo((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                    gVar.ksI.append("SvrDownReqLimitLevelMin:" + gVar.qXv + " SvrDownReqLimitLevelMax: " + gVar.qXw + ";\n");
                    gVar.qXA = bi.Wp((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                    gVar.qXB = bi.Wp((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                    gVar.qXC = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                    gVar.qXD = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                    gVar.qXE = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                    gVar.qXF = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                    gVar.qXG = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                    gVar.qXH = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                    gVar.qXJ = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                    gVar.qXK = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                    gVar.qXI = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                    gVar.qXL = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                    gVar.qXM = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                    gVar.qXT = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                    gVar.qXU = bi.Wo((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                    gVar.qXV = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                    if (gVar.qXU <= 0) {
                        x.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + gVar.qXU);
                        gVar.qXU = 1;
                    }
                    gVar.ksI.append("FullScreenID:" + gVar.qXV + " BrowseBeginTime:" + gVar.qXA + " BrowseEndTime:" + gVar.qXB + " FullScreenTitle:" + gVar.qXC + " FullScreenDescription:" + gVar.qXD + " FullScreenQueryTips:" + gVar.qXE + " FullScreenAcceptButtonText: " + gVar.qXF);
                    gVar.ksI.append("FullScreenRejectButtonText:" + gVar.qXG + " ActionSheetOpenTips:" + gVar.qXH + " ActionSheetOpenSuccTips:" + gVar.qXJ + " ActionSheetOpenFailTips:" + gVar.qXK + " ActionSheetCloseTips:" + gVar.qXI + " ActionSheetCloseSuccTips: " + gVar.qXL + " ActionSheetCloseFailTips: " + gVar.qXM + "MaxPostFeedID: " + gVar.qXT + " MaxPostFeedCount:" + gVar.qXU);
                    gVar.qXN = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                    gVar.qXO = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                    gVar.qXP = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                    gVar.qXQ = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                    gVar.qXR = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                    gVar.qXS = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                    gVar.ksI.append("AlertTipForHasUsed:" + gVar.qXN + " AlertTipForObtainUsedRight:" + gVar.qXO + " AlertTipForClosedBrowseSwitch:" + gVar.qXP + " AlertButtonText:" + gVar.qXQ + " GoldenCameraTip:" + gVar.qXR + " GoldenCameraTipID:" + gVar.qXS);
                    int i = 0;
                    while (true) {
                        String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "RedPointID";
                        gVar.qXp = bi.aD((String) y.get(String.format(str2, objArr)), "");
                        gVar.ksI.append("RedPointID:" + gVar.qXp + ";");
                        if (bi.oN(gVar.qXp)) {
                            break;
                        }
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "BeginTime";
                        gVar.qXx = bi.Wp((String) y.get(String.format(str2, objArr)));
                        gVar.ksI.append("RedPointID_BeginTime:" + gVar.qXx + ";");
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "EndTime";
                        gVar.qXy = bi.Wp((String) y.get(String.format(str2, objArr)));
                        gVar.ksI.append("RedPointID_EndTime:" + gVar.qXy + ";\n");
                        c cVar = new c();
                        cVar.qXp = gVar.qXp;
                        cVar.qXq = gVar.qXx;
                        cVar.kzL = gVar.qXy;
                        gVar.qXZ.add(cVar);
                        i++;
                    }
                    gVar.qXz = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                    gVar.ksI.append("PostTips:" + gVar.qXz + ";");
                    gVar.qXu = bi.aD((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                    gVar.ksI.append("EntranceTips:" + gVar.qXu + ";");
                    gVar.qXW.clear();
                    int i2 = 0;
                    while (true) {
                        int Wo = bi.Wo((String) y.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                        gVar.ksI.append("count: " + i2 + " | " + Wo + ";\n");
                        if (Wo == 0) {
                            break;
                        }
                        List linkedList = new LinkedList();
                        i = 0;
                        while (i < Wo) {
                            int Wo2 = bi.Wo((String) y.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                            linkedList.add(Integer.valueOf(Wo2));
                            gVar.ksI.append("AmountLevel : " + i2 + " index " + i + " val: " + Wo2 + ";");
                            i++;
                        }
                        gVar.qXW.add(linkedList);
                        i2++;
                    }
                    x.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + gVar.ksI.toString());
                }
                qXs = s;
            } catch (Exception e) {
                x.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
            }
        }
        return qXt;
    }

    public static boolean buZ() {
        com.tencent.mm.kernel.g.Dr();
        return ((Boolean) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.valueOf(true))).booleanValue();
    }

    public final void bva() {
        i h = k.h(a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC);
        if (h.rha == null || bi.oN(h.rha.rgX)) {
            h.rha = new com.tencent.mm.plugin.sns.g.g();
            h.rha.rgX = this.qXT;
            h.rha.rgY = 0;
        }
        if (bi.oN(h.rha.rgX) || !h.rha.rgX.equals(this.qXT)) {
            h.rha = new com.tencent.mm.plugin.sns.g.g();
            h.rha.rgX = this.qXT;
            h.rha.rgY = 0;
        } else {
            com.tencent.mm.plugin.sns.g.g gVar = h.rha;
            gVar.rgY--;
            if (h.rha.rgY < 0) {
                h.rha.rgY = 0;
            }
        }
        x.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + h.rha.rgY + " postId: " + this.qXT + " " + bi.chl().toString());
        try {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().Db().a(a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC, new String(h.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            x.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.b.a.xmy.m(new pn());
    }
}
