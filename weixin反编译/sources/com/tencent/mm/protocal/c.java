package com.tencent.mm.protocal;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateRecorder;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private static Map<String, g> vGZ = null;

    public static class ac extends g {
        public ac() {
            super("chooseVideo", "chooseVideo", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j.CTRL_BYTE, true);
        }
    }

    public static class ad extends g {
        public ad() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE, false);
        }
    }

    private static final class ae extends g {
        ae() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l.NAME, 300, false);
        }
    }

    public static class ag extends g {
        public ag() {
            super("clearWebviewCache", "clearWebviewCache", com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, false);
        }
    }

    public static class bh extends g {
        public bh() {
            super("openEmotionPage", "", 10000, false);
        }
    }

    private static final class bi extends g {
        bi() {
            super("recordHistory", "recordHistory", 219, false);
        }
    }

    public static class bl extends g {
        public bl() {
            super("getBrandWCPayBindCardRequest", "get_brand_WCPay_bind_card_request", 58, true);
        }
    }

    public static class bm extends g {
        public bm() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o.NAME, "get_brand_wcpay_request", 28, true);
        }
    }

    public static class bn extends g {
        public bn() {
            super("getCurrentSSID", "getCurrentSSID", 176, true);
        }
    }

    public static class bq extends g {
        public bq() {
            super("getEnterpriseChat", "getEnterpriseChat", com.tencent.mm.plugin.appbrand.jsapi.f.c.a.CTRL_INDEX, false);
        }
    }

    public static class cq extends g {
        public cq() {
            super("getSendC2CMessageRequest", "get_send_c2c_message_request", 83, true);
        }
    }

    private static final class cr extends g {
        cr() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ad.NAME, com.tencent.mm.plugin.appbrand.jsapi.ad.NAME, 311, false);
        }
    }

    public static class cu extends g {
        public cu() {
            super("getWCPayRealnameVerify", "getWCPayRealnameVerify", JsApiUploadEncryptedFileToCDN.CTRL_INDEX, true);
        }
    }

    public static class cv extends g {
        public cv() {
            super("getWechatVerifyTicket", "getWechatVerifyTicket", MMGIFException.D_GIF_ERR_IMAGE_DEFECT, false);
        }
    }

    private static final class cw extends g {
        cw() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t.NAME, -3, false);
        }
    }

    private static final class cz extends g {
        cz() {
            super("handleWCPayWalletBuffer", "handleWCPayWalletBuffer", 294, false);
        }
    }

    public static class dz extends g {
        public dz() {
            super(com.tencent.mm.plugin.appbrand.jsapi.lbs.e.NAME, "open_location", 63, true);
        }
    }

    public static class ea extends g {
        public ea() {
            super("openTimelineCheckInList", "open_timeline_checkin_list", 62, false);
        }
    }

    public static class eb extends g {
        public eb() {
            super("nfcBatchTransceive", "nfcBatchTransceive", 142, false);
        }
    }

    public static class ff extends g {
        public ff() {
            super("openProductView", "open_product_view", 59, true);
        }
    }

    private static final class fi extends g {
        fi() {
            super("openSearchWAWidgetLogView", "openSearchWAWidgetLogView", 10000, true);
        }
    }

    private static final class fj extends g {
        fj() {
            super("openSearchWebView", "openSearchWebView", 10000, true);
        }
    }

    public static class fk extends g {
        public fk() {
            super("openSecurityView", "openSecurityView", com.tencent.mm.plugin.appbrand.jsapi.be.CTRL_INDEX, false);
        }
    }

    public static class fn extends g {
        public fn() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.CTRL_BYTE, false);
        }
    }

    public static class gn extends g {
        public gn() {
            super("reportActionInfo", "reportActionInfo", 234, false);
        }
    }

    private static final class go extends g {
        go() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, 301, false);
        }
    }

    public static class gp extends g {
        public gp() {
            super("reportIDKey", "reportIDKey", 163, false);
        }
    }

    public static class gr extends g {
        public gr() {
            super("reportSearchRealTimeStatistics", "", 10000, false);
        }
    }

    public static class gs extends g {
        public gs() {
            super("reportSearchStatistics", "", 10000, false);
        }
    }

    private static final class gt extends g {
        gt() {
            super("requestWxFaceRegisterInternal", "requestWxFaceRegisterInternal", com.tencent.mm.plugin.appbrand.jsapi.f.e.CTRL_INDEX, true);
        }
    }

    public static class hw extends g {
        public hw() {
            super("setLocalData", "setLocalData", 180, false);
        }
    }

    public static class hy extends g {
        public hy() {
            super("setNavigationBarColor", "setNavigationBarColor", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au.CTRL_BYTE, false);
        }
    }

    private static final class ib extends g {
        ib() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.NAME, 270, false);
        }
    }

    public static class jb extends g {
        public jb() {
            super("startVoipCall", "startVoipCall", com.tencent.mm.plugin.appbrand.jsapi.bs.CTRL_INDEX, false);
        }
    }

    public static class jc extends g {
        public jc() {
            super("stopMonitoringBeacons", "stopMonitoringBeacons", com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX, false);
        }
    }

    public static class jd extends g {
        public jd() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bl.NAME, com.tencent.mm.plugin.appbrand.jsapi.bl.NAME, 200, false);
        }
    }

    public static class jf extends g {
        public jf() {
            super("stopScanWXDevice", "stopScanWXDevice", 122, true);
        }
    }

    public static class jg extends g {
        public jg() {
            super(JsApiStopPlayVoice.NAME, JsApiStopPlayVoice.NAME, 101, false);
        }
    }

    public static class jh extends g {
        public jh() {
            super("streamingVideoPlay", "playStreamingVideo", com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, false);
        }
    }

    public static class jk extends g {
        public jk() {
            super("shareTimeline", "share_timeline", 4, true);
        }
    }

    public static class kj extends g {
        public kj() {
            super("WNNativeCallbackInitData", "WNNativeCallbackInitData", 10006, false);
        }
    }

    public static class kk extends g {
        public kk() {
            super("WNNativeCallbackOnCaretChange", "WNNativeCallbackOnCaretChange", 10006, false);
        }
    }

    public static class kl extends g {
        public kl() {
            super("WNNativeCallbackOnClick", "WNNativeCallbackOnClick", 10006, false);
        }
    }

    public static class km extends g {
        public km() {
            super("WNNativeCallbackOnLongClick", "WNNativeCallbackOnLongClick", 10006, false);
        }
    }

    private static final class ko extends g {
        ko() {
            super(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.wifi.d.CTRL_INDEX, true);
        }
    }

    public static class kp extends g {
        public kp() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    public static class kq extends g {
        public kq() {
            super("WNNativeCallbackOnBecomeEdited", "WNNativeCallbackOnBecomeEdited", 10006, false);
        }
    }

    public static class o extends g {
        public o() {
            super("batchAddCard", "batch_add_card", 82, true);
        }
    }

    public static class r extends g {
        public r() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME, "cancel_download_task", 39, false);
        }
    }

    public static class s extends g {
        public s() {
            super("cancelSearchActionSheet", "cancelSearchActionSheet", 10000, false);
        }
    }

    public static class t extends g {
        public t() {
            super("changePayActivityView", "change_pay_activity_view", 207, true);
        }
    }

    public static class v extends g {
        public v() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME, 84, false);
        }
    }

    public static class w extends g {
        public w() {
            super("chooseCard", "choose_card", 70, true);
        }
    }

    public static class x extends g {
        public x() {
            super("chooseIdCard", "chooseIdCard", com.tencent.mm.plugin.appbrand.jsapi.an.CTRL_INDEX, true);
        }
    }

    public static class af extends g {
        public af() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static class al extends g {
        public al() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class ao extends g {
        public ao() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    public static class bb extends g {
        public bb() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("enterEnterpriseChat", "enterEnterpriseChat", 223, false);
        }
    }

    private static final class bf extends g {
        bf() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", 264, true);
        }
    }

    private static final class bg extends g {
        bg() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", 257, false);
        }
    }

    private static final class bo extends g {
        bo() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, 299, false);
        }
    }

    public static class bp extends g {
        public bp() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    public static class bv extends g {
        public bv() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class bw extends g {
        public bw() {
            super("getInstallState", "get_install_state", 25, false);
        }
    }

    private static final class by extends g {
        by() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.NAME, -2, false);
        }
    }

    public static class cj extends g {
        public cj() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", 10000, false);
        }
    }

    public static class cl extends g {
        public cl() {
            super("getSearchGuideData", "", 10000, false);
        }
    }

    public static class cn extends g {
        public cn() {
            super("getSearchImageList", "", 10000, false);
        }
    }

    public static class cp extends g {
        public cp() {
            super("getSearchSuggestionData", "", 10000, false);
        }
    }

    public static class cx extends g {
        public cx() {
            super("getWXDeviceInfos", "getWXDeviceInfos", 119, true);
        }
    }

    public static class cy extends g {
        public cy() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    public static class da extends g {
        public da() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class db extends g {
        public db() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u.NAME, 85, false);
        }
    }

    public static class dd extends g {
        public dd() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.NAME, "", 14, false);
        }
    }

    public static class dt extends g {
        public dt() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", JsApiOperateBackgroundAudio.CTRL_INDEX, true);
        }
    }

    private static final class dv extends g {
        dv() {
            super("login", "login", 231, true);
        }
    }

    public static class dx extends g {
        public dx() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    public static class dy extends g {
        public dy() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    public static class ec extends g {
        public ec() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    public static class ed extends g {
        public ed() {
            super("nfcConnect", "nfcConnect", com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX, false);
        }
    }

    private static final class ei extends g {
        ei() {
            super("openWCPayCardList", "openWCPayCardList", 310, true);
        }
    }

    private static final class el extends g {
        el() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.NAME, 256, false);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX, true);
        }
    }

    private static final class fa extends g {
        fa() {
            super("openLuckyMoneyHistory", "openLuckyMoneyHistory", 258, true);
        }
    }

    public static class fc extends g {
        public fc() {
            super("openMyDeviceProfile", "openMyDeviceProfile", com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, false);
        }
    }

    public static class fd extends g {
        public fd() {
            super("openNewPage", "openNewPage", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    private static final class fe extends g {
        fe() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ap.NAME, com.tencent.mm.plugin.appbrand.jsapi.ap.NAME, 305, true);
        }
    }

    public static class fl extends g {
        public fl() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    public static class fm extends g {
        public fm() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    public static class fs extends g {
        public fs() {
            super("openWXDeviceLib", "openWXDeviceLib", 117, false);
        }
    }

    public static class fv extends g {
        public fv() {
            super(GameJsApiOperateGameCenterMsg.NAME, GameJsApiOperateGameCenterMsg.NAME, GameJsApiOperateGameCenterMsg.CTRL_BYTE, false);
        }
    }

    public static class gg extends g {
        public gg() {
            super("queryDownloadTask", "query_download_task", 40, false);
        }
    }

    public static class gi extends g {
        public gi() {
            super("realtimeReport", "realtimeReport", 171, false);
        }
    }

    public static class gk extends g {
        public gk() {
            super("reloadSearchWAWidgetData", "", 10000, false);
        }
    }

    public static class gm extends g {
        public gm() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME, "", 10000, false);
        }
    }

    private static final class gu extends g {
        gu() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", com.tencent.mm.plugin.appbrand.jsapi.f.i.CTRL_INDEX, true);
        }
    }

    private static final class gv extends g {
        gv() {
            super("requestWxVoicePrintVerifyInternal", "requestWxVoicePrintVerifyInternal", JsApiSetAudioState.CTRL_INDEX, true);
        }
    }

    public static class gw extends g {
        public gw() {
            super("resendRemittanceMsg", "resendRemittanceMsg", 246, true);
        }
    }

    public static class h extends g {
        public h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    public static class ha extends g {
        public ha() {
            super("searchDataHasResult", "", 10000, false);
        }
    }

    public static class hq extends g {
        public hq() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ar.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ar.NAME, 218, false);
        }
    }

    public static class hu extends g {
        public hu() {
            super("setFreeWifiOwner", "setFreeWifiOwner", com.tencent.mm.plugin.appbrand.jsapi.y.CTRL_INDEX, false);
        }
    }

    public static class hv extends g {
        public hv() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    public static class hx extends g {
        public hx() {
            super("setNavigationBarButtons", "setNavigationBarButtons", JsApiChooseWeChatContact.CTRL_INDEX, false);
        }
    }

    public static class i extends g {
        public i() {
            super("addCustomMenuItems", "addCustomMenuItems", 164, false);
        }
    }

    public static class ia extends g {
        public ia() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.NAME, 113, false);
        }
    }

    public static class ii extends g {
        public ii() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    public static class ja extends g {
        public ja() {
            super("startTempSession", "startTempSession", FileUtils.S_IWUSR, true);
        }
    }

    public static class ji extends g {
        public ji() {
            super("selectWalletCurrency", "selectWalletCurrency", 201, true);
        }
    }

    private static final class jj extends g {
        jj() {
            super("tapSearchWAWidgetView", "tapSearchWAWidgetView", 10000, true);
        }
    }

    public static class jp extends g {
        public jp() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.d.NAME, "", 10000, false);
        }
    }

    public static class js extends g {
        public js() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.CTRL_BYTE, true);
        }
    }

    public static class k extends g {
        public k() {
            super("addDownloadTaskStraight", "add_download_task_straight", 269, true);
        }
    }

    public static class kd extends g {
        public kd() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    public static class kf extends g {
        public kf() {
            super("videoProxyPreload", "videoProxyPreload", 172, false);
        }
    }

    public static class kh extends g {
        public kh() {
            super("reportWeAppSearchRealtime", "", 10000, false);
        }
    }

    public static class kr extends g {
        public kr() {
            super("jumpWSRecVideoList", "", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, true);
        }
    }

    public static class ks extends g {
        public ks() {
            super("menu:setfont", "", 129, false);
        }
    }

    public static class kt extends g {
        public kt() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    public static class kx extends g {
        public kx() {
            super("menu:share:weiboApp", "", 109, false);
        }
    }

    public static final class kz {
        public static Set<String> vHd;
    }

    public static class p extends g {
        public p() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME, 111, true);
        }
    }

    private static final class q extends g {
        q() {
            super("bindEmail", "bindEmail", 306, true);
        }
    }

    public static class y extends g {
        public y() {
            super("chooseImage", "chooseImage", 104, true);
        }
    }

    public static class aa extends g {
        public aa() {
            super(com.tencent.mm.plugin.appbrand.jsapi.u.NAME, com.tencent.mm.plugin.appbrand.jsapi.u.NAME, 288, true);
        }
    }

    public static class ah extends g {
        public ah() {
            super("clickSnsMusicPlayButton", "", 10000, false);
        }
    }

    private static final class aj extends g {
        aj() {
            super("closeWindowAndGoNext", "closeWindowAndGoNext", JsApiGetAudioState.CTRL_INDEX, true);
        }
    }

    public static class aq extends g {
        public aq() {
            super("deleteAccountSuccess", "deleteAccountSuccess", com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, false);
        }
    }

    public static class as extends g {
        public as() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n.CTRL_BYTE, false);
        }
    }

    public static class aw extends g {
        public aw() {
            super("downloadVoice", "downloadVoice", 103, true);
        }
    }

    public static class ax extends g {
        public ax() {
            super("doExposePreparation", "doExposePreparation", 225, false);
        }
    }

    public static class ay extends g {
        public ay() {
            super("doSearchOperation", "", 10000, false);
        }
    }

    public static class az extends g {
        public az() {
            super("editAddress", "edit_address", 29, true);
        }
    }

    private static final class bk extends g {
        bk() {
            super(JsApiGetBackgroundAudioState.NAME, JsApiGetBackgroundAudioState.NAME, 263, false);
        }
    }

    public static class br extends g {
        public br() {
            super(GameJsApiGetGameCommInfo.NAME, GameJsApiGetGameCommInfo.NAME, GameJsApiGetGameCommInfo.CTRL_BYTE, false);
        }
    }

    public static class bt extends g {
        public bt() {
            super("getHeadingAndPitch", "get_heading_and_pitch", 33, false);
        }
    }

    public static class ca extends g {
        public ca() {
            super("getMsgProofItems", "getMsgProofItems", com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, true);
        }
    }

    public static class cb extends g {
        public cb() {
            super("getNetworkType", "network_type", 16, false);
        }
    }

    public static class cc extends g {
        public cc() {
            super(GameJsApiGetOpenDeviceId.NAME, GameJsApiGetOpenDeviceId.NAME, GameJsApiGetOpenDeviceId.CTRL_BYTE, false);
        }
    }

    public static class ce extends g {
        public ce() {
            super("getLatestAddress", "get_recently_used_address", 46, true);
        }
    }

    public static class cs extends g {
        public cs() {
            super("getTeachSearchData", "", 10000, false);
        }
    }

    public static class d extends g {
        public d() {
            super("openEmotionDetailViewLocal", "openEmotionDetailViewLocal", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class df extends g {
        public df() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w.NAME, "", 1, true);
        }
    }

    public static class dk extends g {
        public dk() {
            super("jumpToInstallUrl", "", 26, false);
        }
    }

    public static class dl extends g {
        public dl() {
            super("jumpToBizProfile", "jump_to_biz_profile", 61, true);
        }
    }

    public static class dm extends g {
        public dm() {
            super("jumpWCMall", "jump_wcmall", 51, true);
        }
    }

    public static class ee extends g {
        public ee() {
            super("nfcGetId", "nfcGetId", 143, false);
        }
    }

    public static class eg extends g {
        public eg() {
            super("nfcIsConnect", "nfcIsConnect", com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, true);
        }
    }

    public static class en extends g {
        public en() {
            super("openDesignerEmojiViewLocal", "openDesignerEmojiViewLocal", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class ep extends g {
        public ep() {
            super("openDesignerProfileLocal", "openDesignerProfileLocal", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class et extends g {
        public et() {
            super("openEnterpriseContact", "openEnterpriseContact", 183, true);
        }
    }

    public static class ev extends g {
        public ev() {
            super("openGameDetail", "openGameDetail", 131, true);
        }
    }

    public static class ew extends g {
        public ew() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad.NAME, 242, true);
        }
    }

    private static final class fh extends g {
        fh() {
            super("openSearchCanvas", "openSearchCanvas", bo.CTRL_INDEX, true);
        }
    }

    public static class fo extends g {
        public fo() {
            super("openWCPaySpecificView", "open_wcpay_specific_view", 76, true);
        }
    }

    public static class fq extends g {
        public fq() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah.NAME, "", 10000, false);
        }
    }

    private static final class fx extends g {
        fx() {
            super("opVoteAdData", "", -2, false);
        }
    }

    private static final class gb extends g {
        public gb() {
            super("preloadMiniProgramContacts", "preloadMiniProgramContacts", 303, false);
        }
    }

    public static class gy extends g {
        public gy() {
            super("scanLicence", "scanLicence", 203, false);
        }
    }

    public static class hc extends g {
        public hc() {
            super("selectEnterpriseContact", "selectEnterpriseContact", com.tencent.mm.plugin.appbrand.jsapi.u.CTRL_INDEX, true);
        }
    }

    public static class hh extends g {
        public hh() {
            super("sendDataToWXDevice", "sendDataToWXDevice", 120, true);
        }
    }

    public static class hi extends g {
        public hi() {
            super("sendEnterpriseChat", "sendEnterpriseChat", 222, true);
        }
    }

    private static final class hj extends g {
        hj() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, 255, false);
        }
    }

    public static class hl extends g {
        public hl() {
            super("sendServiceAppMessage", "send_service_app_msg", 67, true);
        }
    }

    private static final class hs extends g {
        hs() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at.NAME, 298, false);
        }
    }

    public static class hz extends g {
        public hz() {
            super("setPageOwner", "setPageOwner", 114, false);
        }
    }

    public static class id extends g {
        public id() {
            super("setSendDataDirection", "setSendDataDirection", 127, false);
        }
    }

    public static class if extends g {
        public if() {
            super("setStatusBarStyle", "setStatusBarStyle", com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, false);
        }
    }

    public static class ik extends g {
        public ik() {
            super("showAllNonBaseMenuItem", "showAllNonBaseMenuItem", 92, false);
        }
    }

    public static class im extends g {
        public im() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az.CTRL_BYTE, false);
        }
    }

    public static class io extends g {
        public io() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bi.NAME, com.tencent.mm.plugin.appbrand.jsapi.bi.NAME, 197, false);
        }
    }

    public static class iq extends g {
        public iq() {
            super("showSearchActionSheet", "showSearchActionSheet", 10000, false);
        }
    }

    public static class is extends g {
        public is() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc.CTRL_BYTE, false);
        }
    }

    public static class it extends g {
        public it() {
            super("requireSoterBiometricAuthentication", "soter_biometric_authentication", JsApiCheckIsSupportFaceDetect.CTRL_INDEX, true);
        }
    }

    public static class je extends g {
        public je() {
            super(JsApiStopRecordVoice.NAME, JsApiStopRecordVoice.NAME, 98, false);
        }
    }

    public static class jl extends g {
        public jl() {
            super("translateVoice", "translateVoice", 97, true);
        }
    }

    public static class jn extends g {
        public jn() {
            super("updateReddotTimeStamps", "", 10000, false);
        }
    }

    public static class ju extends g {
        public ju() {
            super("uploadVoice", "uploadVoice", 102, true);
        }
    }

    public static class jz extends g {
        public jz() {
            super("videoProxyInit", "videoProxyInit", 156, false);
        }
    }

    public static class kv extends g {
        public kv() {
            super("menu:share:QZone", "", com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, false);
        }
    }

    public static class m extends g {
        public m() {
            super(JsApiAdDataReport.NAME, "ad_data_report", 221, false);
        }
    }

    public static class a extends g {
        public a() {
            super(JsApiGetMusicPlayerState.NAME, JsApiGetMusicPlayerState.NAME, com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX, false);
        }
    }

    public static class am extends g {
        public am() {
            super("connectToFreeWifi", "connectToFreeWifi", 95, false);
        }
    }

    public static class an extends g {
        public an() {
            super("connectToWiFi", "connecttowifi", 71, false);
        }
    }

    public static class at extends g {
        public at() {
            super("disablePullDownRefresh", "disablePullDownRefresh", com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, false);
        }
    }

    public static class au extends g {
        public au() {
            super("disconnectWXDevice", "disconnectWXDevice", 124, true);
        }
    }

    public static class av extends g {
        public av() {
            super("downloadImage", "downloadImage", 106, true);
        }
    }

    public static class b extends g {
        public b() {
            super(JsApiOperateMusicPlayer.NAME, JsApiOperateMusicPlayer.NAME, com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, false);
        }
    }

    public static class bc extends g {
        public bc() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    private static final class cf extends g {
        cf() {
            super("doGoToRecVideoList", "doGoToRecVideoList", 10000, false);
        }
    }

    public static class cg extends g {
        public cg() {
            super("getRouteUrl", "getRouteUrl", 235, false);
        }
    }

    public static class ch extends g {
        public ch() {
            super("getSearchAvatarList", "", 10000, false);
        }
    }

    public static class ci extends g {
        public ci() {
            super("getSearchData", "", 10000, false);
        }
    }

    public static class ck extends g {
        public ck() {
            super("getSearchEmotionData", "getSearchEmotionData", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class cm extends g {
        public cm() {
            super("getSearchHistory", "", 10000, false);
        }
    }

    public static class dh extends g {
        public dh() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.a.NAME, "", 10000, false);
        }
    }

    public static class di extends g {
        public di() {
            super("installDownloadTask", "install_download_task", 41, false);
        }
    }

    private static final class dj extends g {
        dj() {
            super("invokeMiniProgramAPI", "invokeMiniProgramAPI", JsApiOperateRecorder.CTRL_INDEX, false);
        }
    }

    public static class do extends g {
        public do() {
            super("kvReport", "kvReport", 170, false);
        }
    }

    public static class dp extends g {
        public dp() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y.NAME, "launch_3rdApp", 52, true);
        }
    }

    public static class dq extends g {
        public dq() {
            super("launchApp", "", 27, false);
        }
    }

    private static final class dr extends g {
        dr() {
            super(GameJsApiLaunchApplication.NAME, GameJsApiLaunchApplication.NAME, GameJsApiLaunchApplication.CTRL_BYTE, true);
        }
    }

    public static class du extends g {
        public du() {
            super("log", "", 0, false);
        }
    }

    private static final class dw extends g {
        dw() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ai.NAME, com.tencent.mm.plugin.appbrand.jsapi.ai.NAME, 10000, true);
        }
    }

    private static final class ej extends g {
        ej() {
            super("openBizChat", "openBizChat", 296, true);
        }
    }

    private static final class ek extends g {
        ek() {
            super("openADCanvas", "openADCanvas", bo.CTRL_INDEX, true);
        }
    }

    private static final class eq extends g {
        eq() {
            super("openECard", "openECard", 268, true);
        }
    }

    public static class er extends g {
        public er() {
            super("openEmoticonTopicList", "openEmoticonTopicList", com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, true);
        }
    }

    public static class es extends g {
        public es() {
            super("openEnterpriseChat", "openEnterpriseChat", 165, false);
        }
    }

    public static class eu extends g {
        public eu() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE, true);
        }
    }

    private static final class ey extends g {
        ey() {
            super("openGameWebView", "openGameWebView", 287, false);
        }
    }

    public static class ez extends g {
        public ez() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", 245, false);
        }
    }

    private static final class ft extends g {
        ft() {
            super("openWXSearchPage", "openWXSearchPage", 309, true);
        }
    }

    private static final class fu extends g {
        fu() {
            super(JsApiOperateBackgroundAudio.NAME, JsApiOperateBackgroundAudio.NAME, 261, false);
        }
    }

    public static class fz extends g {
        public fz() {
            super(JsApiPausePlayVoice.NAME, JsApiPausePlayVoice.NAME, 100, false);
        }
    }

    private static final class gc extends g {
        gc() {
            super("preloadMiniProgramEnv", "preloadMiniProgramEnv", HardCoderJNI.SCENE_QUIT_CHATTING, false);
        }
    }

    private static final class gd extends g {
        gd() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, 252, true);
        }
    }

    public static class ge extends g {
        public ge() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak.NAME, "pre_verify_jsapi", -3, false);
        }
    }

    public static class gf extends g {
        public gf() {
            super("profile", "profile", 2, true);
        }
    }

    public static class gh extends g {
        public gh() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", JsApiLaunchMiniProgram.CTRL_INDEX, true);
        }
    }

    private static final class gj extends g {
        gj() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an.NAME, 251, true);
        }
    }

    public static class he extends g {
        public he() {
            super("selectSingleContact", "selectSingleContact", 167, true);
        }
    }

    public static class hf extends g {
        public hf() {
            super("sendAppMessageToSpecifiedContact", "sendAppMessageToSpecifiedContact", JsApiSetClipboardData.CTRL_INDEX, true);
        }
    }

    public static class hg extends g {
        public hg() {
            super(GameJsApiSendAppMessage.NAME, "send_app_msg", 6, true);
        }
    }

    private static final class hm extends g {
        hm() {
            super("sendSingleAppMessage", "sendSingleAppMessage", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.CTRL_INDEX, true);
        }
    }

    private static final class hn extends g {
        hn() {
            super("serviceClick", "serviceClick", 304, false);
        }
    }

    private static final class ho extends g {
        ho() {
            super("setWCPayPassword", "setWCPayPassword", 289, true);
        }
    }

    public static class hr extends g {
        public hr() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.NAME, 77, false);
        }
    }

    public static class ht extends g {
        public ht() {
            super("setFontSizeCallback", "", -2, false);
        }
    }

    public static class ih extends g {
        public ih() {
            super("shareQQ", "shareQQ", 90, true);
        }
    }

    public static class in extends g {
        public in() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ba.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ba.NAME, 86, false);
        }
    }

    public static class ip extends g {
        public ip() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bb.NAME, "", 14, false);
        }
    }

    private static final class ir extends g {
        ir() {
            super("showSearchOfBizHistory", "showSearchOfBizHistory", 266, false);
        }
    }

    public static class iv extends g {
        public iv() {
            super("startMonitoringBeacons", "startMonitoringBeacons", 151, true);
        }
    }

    public static class iw extends g {
        public iw() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bk.NAME, com.tencent.mm.plugin.appbrand.jsapi.bk.NAME, com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, false);
        }
    }

    public static class ix extends g {
        public ix() {
            super(JsApiStartRecordVoice.NAME, JsApiStartRecordVoice.NAME, 96, false);
        }
    }

    public static class iy extends g {
        public iy() {
            super("startScanWXDevice", "startScanWXDevice", 121, true);
        }
    }

    private static final class jq extends g {
        jq() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", 253, false);
        }
    }

    public static class jr extends g {
        public jr() {
            super("uploadImage", "uploadImage", 105, true);
        }
    }

    public static class jw extends g {
        public jw() {
            super("verifyWCPayPassword", "verifyWCPayPassword", 115, true);
        }
    }

    private static final class jx extends g {
        jx() {
            super("viewTypeChange", "", 10000, false);
        }
    }

    public static class jy extends g {
        public jy() {
            super("cache", "cache", 150, false);
        }
    }

    public static class ka extends g {
        public ka() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiGetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    public static class kb extends g {
        public kb() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiSetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    public static class kc extends g {
        public kc() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    public static class ke extends g {
        public ke() {
            super("publicCache", "publicCache", com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, false);
        }
    }

    public static class kg extends g {
        public kg() {
            super("shareWeibo", "share_weibo", 3, true);
        }
    }

    public static abstract class g {
        protected String NAME = "noName";
        protected String vHa = "";
        protected int vHb = -1;
        protected boolean vHc = false;

        public g(String str, String str2, int i, boolean z) {
            this.NAME = str;
            this.vHa = str2;
            this.vHb = i;
            this.vHc = z;
        }

        public final String getName() {
            return this.NAME;
        }

        public final String cee() {
            return this.vHa;
        }

        public final int cef() {
            return this.vHb;
        }

        public final boolean ceg() {
            return this.vHc;
        }
    }

    private static final class ab extends g {
        ab() {
            super("chooseMedia", "chooseMedia", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, true);
        }
    }

    public static class ai extends g {
        public ai() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.NAME, "close_window", 17, false);
        }
    }

    public static class ak extends g {
        public ak() {
            super("closeWXDeviceLib", "closeWXDeviceLib", 118, false);
        }
    }

    public static class ap extends g {
        public ap() {
            super("consumedShareCard", "consumedShareCard", 177, true);
        }
    }

    public static class ar extends g {
        public ar() {
            super("deleteSearchHistory", "", 10000, false);
        }
    }

    public static class ba extends g {
        public ba() {
            super("openEmotionUrl", "openEmotionUrl", HardCoderJNI.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    private static final class be extends g {
        be() {
            super("requestWxFacePictureVerify", "requestWxFacePictureVerify", 259, true);
        }
    }

    public static class bj extends g {
        public bj() {
            super("geoLocation", "geo_location", 57, false);
        }
    }

    public static class bs extends g {
        public bs() {
            super("getPoiInfo", "", 10000, false);
        }
    }

    public static class bu extends g {
        public bu() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    public static class bx extends g {
        public bx() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    private static final class bz extends g {
        bz() {
            super("getMatchContactList", "getMatchContactList", 10000, false);
        }
    }

    public static class c extends g {
        public c() {
            super("getLocalImgData", "getLocalImgData", com.tencent.mm.plugin.appbrand.jsapi.az.CTRL_INDEX, false);
        }
    }

    public static class cd extends g {
        public cd() {
            super("getPaymentOrderRequest", "getPaymentOrderRequest", 116, true);
        }
    }

    public static class co extends g {
        public co() {
            super("getSearchSnsImageList", "", 10000, false);
        }
    }

    public static class ct extends g {
        public ct() {
            super("getTransferMoneyRequest", "get_transfer_money_request", 74, true);
        }
    }

    public static class dc extends g {
        public dc() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ae.NAME, com.tencent.mm.plugin.appbrand.jsapi.ae.NAME, com.tencent.mm.plugin.appbrand.jsapi.bc.CTRL_INDEX, false);
        }
    }

    public static class de extends g {
        public de() {
            super("idCardRealnameVerify", "idCardRealnameVerify", 235, true);
        }
    }

    public static class dg extends g {
        public dg() {
            super("insertSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class dn extends g {
        public dn() {
            super("jumpToWXWallet", "jumpToWXWallet", 147, true);
        }
    }

    private static final class ds extends g {
        ds() {
            super("launchMiniProgram", "launchMiniProgram", 277, true);
        }
    }

    public static class e extends g {
        public e() {
            super("getRecevieBizHongBaoRequest", "getRecevieBizHongBaoRequest", com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX, true);
        }
    }

    public static class ef extends g {
        public ef() {
            super("nfcGetInfo", "nfcGetInfo", JsApiScanCode.CTRL_INDEX, false);
        }
    }

    public static class eh extends g {
        public eh() {
            super("nfcTransceive", "nfcTransceive", com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX, false);
        }
    }

    public static class em extends g {
        public em() {
            super("openDesignerEmojiView", "openDesignerEmojiView", 185, true);
        }
    }

    public static class eo extends g {
        public eo() {
            super("openDesignerProfile", "openDesignerProfile", JsApiChooseMedia.CTRL_INDEX, true);
        }
    }

    private static final class ex extends g {
        ex() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae.NAME, JsApiOperateAudio.CTRL_INDEX, false);
        }
    }

    public static class fb extends g {
        public fb() {
            super("openMapNavigateMenu", "openMapNavigateMenu", 184, true);
        }
    }

    public static class fg extends g {
        public fg() {
            super("openProductViewWithPid", "open_product_view", 60, true);
        }
    }

    private static final class fp extends g {
        fp() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag.NAME, 250, false);
        }
    }

    public static class fr extends g {
        public fr() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    public static class fw extends g {
        public fw() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.b.NAME, "", 10000, false);
        }
    }

    public static class fy extends g {
        public fy() {
            super("pauseDownloadTask", "cancel_download_task", com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai.CTRL_BYTE, false);
        }
    }

    public static class ga extends g {
        public ga() {
            super(JsApiStartPlayVoice.NAME, JsApiStartPlayVoice.NAME, 99, false);
        }
    }

    public static class gl extends g {
        public gl() {
            super("removeSearchWAWidgetView", "", 10000, false);
        }
    }

    private static final class gq extends g {
        gq() {
            super("reportMiniProgramPageData", "reportMiniProgramPageData", com.tencent.mm.plugin.appbrand.jsapi.bk.CTRL_INDEX, false);
        }
    }

    public static class gx extends g {
        public gx() {
            super("resumeDownloadTask", "resume_download_task", 240, true);
        }
    }

    public static class gz extends g {
        public gz() {
            super("scanQRCode", "scanQRCode", 7, true);
        }
    }

    private static final class hb extends g {
        hb() {
            super("selectContact", "selectContact", 10000, true);
        }
    }

    public static class hd extends g {
        public hd() {
            super("selectPedometerSource", "selectPedometerSource", com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, true);
        }
    }

    public static class hk extends g {
        public hk() {
            super("sendEmail", "send_email", 35, false);
        }
    }

    private static final class hp extends g {
        hp() {
            super(JsApiSetBackgroundAudioState.NAME, JsApiSetBackgroundAudioState.NAME, 262, false);
        }
    }

    public static class ic extends g {
        public ic() {
            super("setSearchInputWord", "", 10000, false);
        }
    }

    public static class ie extends g {
        public ie() {
            super("setSnsObjectXmlDescList", "", 10000, false);
        }
    }

    private static final class ig extends g {
        ig() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax.CTRL_BYTE, true);
        }
    }

    public static class ij extends g {
        public ij() {
            super("shareWeiboApp", "shareWeiboApp", 107, false);
        }
    }

    public static class il extends g {
        public il() {
            super(com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, 248, true);
        }
    }

    public static class iu extends g {
        public iu() {
            super("getSupportSoter", "getSupportSoter", com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, true);
        }
    }

    public static class iz extends g {
        public iz() {
            super("startSearchItemDetailPage", "", 10000, false);
        }
    }

    public static class j extends g {
        public j() {
            super("addDownloadTask", "add_download_task", 38, false);
        }
    }

    public static class jm extends g {
        public jm() {
            super("unbindBankCard", "unbindBankCard", com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX, true);
        }
    }

    public static class jo extends g {
        public jo() {
            super("updateSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class jt extends g {
        public jt() {
            super("uploadVideo", "uploadVideo", com.tencent.mm.plugin.appbrand.jsapi.ar.CTRL_INDEX, true);
        }
    }

    public static class jv extends g {
        public jv() {
            super("uxSearchOpLog", "uxSearchOpLog", 10000, false);
        }
    }

    public static class ki extends g {
        public ki() {
            super("WNNativeAsyncCallback", "WNNativeAsyncCallback", 10006, false);
        }
    }

    public static class kn extends g {
        public kn() {
            super(JsApiWriteCommData.NAME, "write_comm_data", 53, false);
        }
    }

    public static class ku extends g {
        public ku() {
            super("menu:share:qq", "", 94, false);
        }
    }

    public static class kw extends g {
        public kw() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    public static class ky extends g {
        public ky() {
            super("uploadIdCardSuccess", "uploadIdCardSuccess", 233, false);
        }
    }

    private static final class l extends g {
        l() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, 274, true);
        }
    }

    private static final class n extends g {
        n() {
            super(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, 232, true);
        }
    }

    private static final class u extends g {
        u() {
            super("checkIsSupportFaceDetect", "checkIsSupportFaceDetect", 265, false);
        }
    }

    public static class z extends g {
        public z() {
            super("chooseInvoice", "chooseInvoice", 202, true);
        }
    }

    public static g TR(String str) {
        if (vGZ == null || vGZ.size() <= 0) {
            Map hashMap = new HashMap(FileUtils.S_IWUSR);
            vGZ = hashMap;
            hashMap.put("log", new du());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w.NAME, new df());
            vGZ.put("profile", new gf());
            vGZ.put("shareWeibo", new kg());
            vGZ.put("shareTimeline", new jk());
            vGZ.put(JsApiAdDataReport.NAME, new m());
            vGZ.put("streamingVideoPlay", new jh());
            vGZ.put("addContact", new h());
            vGZ.put(GameJsApiSendAppMessage.NAME, new hg());
            vGZ.put("scanQRCode", new gz());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.NAME, new dd());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bb.NAME, new ip());
            vGZ.put("getNetworkType", new cb());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.NAME, new ai());
            vGZ.put("getInstallState", new bw());
            vGZ.put("setFontSizeCallback", new ht());
            vGZ.put("jumpToInstallUrl", new dk());
            vGZ.put("launchApp", new dq());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o.NAME, new bm());
            vGZ.put("editAddress", new az());
            vGZ.put("getHeadingAndPitch", new bt());
            vGZ.put("sendEmail", new hk());
            vGZ.put("addDownloadTask", new j());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME, new r());
            vGZ.put("pauseDownloadTask", new fy());
            vGZ.put("resumeDownloadTask", new gx());
            vGZ.put("queryDownloadTask", new gg());
            vGZ.put("installDownloadTask", new di());
            vGZ.put("getLatestAddress", new ce());
            vGZ.put("openSpecificView", new fl());
            vGZ.put("jumpWCMall", new dm());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y.NAME, new dp());
            vGZ.put(JsApiWriteCommData.NAME, new kn());
            vGZ.put("openUrlByExtBrowser", new fm());
            vGZ.put("geoLocation", new bj());
            vGZ.put("getBrandWCPayBindCardRequest", new bl());
            vGZ.put("openProductView", new ff());
            vGZ.put("openProductViewWithPid", new fg());
            vGZ.put("jumpToBizProfile", new dl());
            vGZ.put("openTimelineCheckInList", new ea());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.lbs.e.NAME, new dz());
            vGZ.put("timelineCheckIn", new dy());
            vGZ.put("getBrandWCPayCreateCreditCardRequest", new fr());
            vGZ.put("chooseCard", new w());
            vGZ.put("chooseInvoice", new z());
            vGZ.put("sendServiceAppMessage", new hl());
            vGZ.put("musicPlay", new dx());
            vGZ.put("mmsf0001", new bp());
            vGZ.put("connectToWiFi", new an());
            vGZ.put("getTransferMoneyRequest", new ct());
            vGZ.put("openWCPaySpecificView", new fo());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as.NAME, new hr());
            vGZ.put("batchAddCard", new o());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak.NAME, new ge());
            vGZ.put(JsApiStartRecordVoice.NAME, new ix());
            vGZ.put(JsApiStopRecordVoice.NAME, new je());
            vGZ.put(JsApiStartPlayVoice.NAME, new ga());
            vGZ.put(JsApiPausePlayVoice.NAME, new fz());
            vGZ.put(JsApiStopPlayVoice.NAME, new jg());
            vGZ.put("uploadVoice", new ju());
            vGZ.put("downloadVoice", new aw());
            vGZ.put("chooseImage", new y());
            vGZ.put("uploadImage", new jr());
            vGZ.put("downloadImage", new av());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd.NAME, new js());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u.NAME, new db());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ba.NAME, new in());
            vGZ.put("hideAllNonBaseMenuItem", new da());
            vGZ.put("showAllNonBaseMenuItem", new ik());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g.NAME, new v());
            vGZ.put("translateVoice", new jl());
            vGZ.put("shareQQ", new ih());
            vGZ.put("shareWeiboApp", new ij());
            vGZ.put("shareQZone", new ii());
            vGZ.put("connectToFreeWifi", new am());
            vGZ.put("getSendC2CMessageRequest", new cq());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e.NAME, new p());
            vGZ.put("configWXDeviceWiFi", new al());
            vGZ.put("getCurrentSSID", new bn());
            vGZ.put("setPageOwner", new hz());
            vGZ.put("getWechatVerifyTicket", new cv());
            vGZ.put("openWXDeviceLib", new fs());
            vGZ.put("startScanWXDevice", new iy());
            vGZ.put("stopScanWXDevice", new jf());
            vGZ.put("connectWXDevice", new ao());
            vGZ.put("disconnectWXDevice", new au());
            vGZ.put("getWXDeviceTicket", new cy());
            vGZ.put("getWXDeviceInfos", new cx());
            vGZ.put("sendDataToWXDevice", new hh());
            vGZ.put("closeWXDeviceLib", new ak());
            vGZ.put("setSendDataDirection", new id());
            vGZ.put("verifyWCPayPassword", new jw());
            vGZ.put("getPaymentOrderRequest", new cd());
            vGZ.put("openGameDetail", new ev());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.NAME, new eu());
            vGZ.put("setGameDebugConfig", new hv());
            vGZ.put("startTempSession", new ja());
            vGZ.put("getH5PrepayRequest", new bu());
            vGZ.put("getH5TransactionRequest", new bv());
            vGZ.put("menu:share:timeline", new kw());
            vGZ.put("menu:share:appmessage", new kt());
            vGZ.put("menu:share:qq", new ku());
            vGZ.put("menu:share:weiboApp", new kx());
            vGZ.put("menu:setfont", new ks());
            vGZ.put("menu:share:weibo", new kx());
            vGZ.put("menu:share:QZone", new kv());
            vGZ.put("getRecevieBizHongBaoRequest", new e());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.video.a.NAME, new dh());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.video.d.NAME, new jp());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME, new gm());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.video.b.NAME, new fw());
            vGZ.put("deleteSearchHistory", new ar());
            vGZ.put("getSearchHistory", new cm());
            vGZ.put("getSearchData", new ci());
            vGZ.put("getPoiInfo", new bs());
            vGZ.put("updateReddotTimeStamps", new jn());
            vGZ.put("getTeachSearchData", new cs());
            vGZ.put("getSearchGuideData", new cl());
            vGZ.put("getSearchAvatarList", new ch());
            vGZ.put("getSearchSnsImageList", new co());
            vGZ.put("getSearchImageList", new cn());
            vGZ.put("getSearchDisplayNameList", new cj());
            vGZ.put("startSearchItemDetailPage", new iz());
            vGZ.put("reportSearchStatistics", new gs());
            vGZ.put("reportSearchRealTimeStatistics", new gr());
            vGZ.put("searchDataHasResult", new ha());
            vGZ.put("openEmotionPage", new bh());
            vGZ.put("getSearchSuggestionData", new cp());
            vGZ.put("setSearchInputWord", new ic());
            vGZ.put("setSnsObjectXmlDescList", new ie());
            vGZ.put("clickSnsMusicPlayButton", new ah());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah.NAME, new fq());
            vGZ.put("reportWeAppSearchRealtime", new kh());
            vGZ.put("doSearchOperation", new ay());
            vGZ.put("insertSearchWAWidgetView", new dg());
            vGZ.put("removeSearchWAWidgetView", new gl());
            vGZ.put("updateSearchWAWidgetView", new jo());
            vGZ.put("showSearchActionSheet", new iq());
            vGZ.put("cancelSearchActionSheet", new s());
            vGZ.put("uxSearchOpLog", new jv());
            vGZ.put("jumpToWXWallet", new dn());
            vGZ.put("scanCover", new f());
            vGZ.put("reportActionInfo", new gn());
            vGZ.put("openMyDeviceProfile", new fc());
            vGZ.put("selectPedometerSource", new hd());
            vGZ.put("nfcIsConnect", new eg());
            vGZ.put("nfcConnect", new ed());
            vGZ.put("nfcTransceive", new eh());
            vGZ.put("nfcBatchTransceive", new eb());
            vGZ.put("nfcGetId", new ee());
            vGZ.put("nfcGetInfo", new ef());
            vGZ.put("startMonitoringBeacons", new iv());
            vGZ.put("stopMonitoringBeacons", new jc());
            vGZ.put("nfcCheckState", new ec());
            vGZ.put("videoProxyInit", new jz());
            vGZ.put("videoProxyStartPlay", new kc());
            vGZ.put("videoProxyStopPlay", new kd());
            vGZ.put("videoProxySetPlayerState", new ka());
            vGZ.put("videoProxySetRemainTime", new kb());
            vGZ.put("videoProxyPreload", new kf());
            vGZ.put("getWebPayCheckoutCounterRequst", new dt());
            vGZ.put("addCustomMenuItems", new i());
            vGZ.put(GameJsApiOperateGameCenterMsg.NAME, new fv());
            vGZ.put("openEnterpriseChat", new es());
            vGZ.put("enterEnterpriseChat", new bd());
            vGZ.put("openEnterpriseContact", new et());
            vGZ.put("selectEnterpriseContact", new hc());
            vGZ.put("getEnterpriseChat", new bq());
            vGZ.put("reportIDKey", new gp());
            vGZ.put("quicklyAddBrandContact", new gh());
            vGZ.put("consumedShareCard", new ap());
            vGZ.put("cache", new jy());
            vGZ.put("publicCache", new ke());
            vGZ.put("kvReport", new do());
            vGZ.put("realtimeReport", new gi());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af.NAME, new fn());
            vGZ.put("setFreeWifiOwner", new hu());
            vGZ.put("selectSingleContact", new he());
            vGZ.put("sendAppMessageToSpecifiedContact", new hf());
            vGZ.put("setLocalData", new hw());
            vGZ.put("getLocalData", new bx());
            vGZ.put("clearLocalData", new af());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az.NAME, new im());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc.NAME, new is());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n.NAME, new as());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.NAME, new ad());
            vGZ.put("setNavigationBarButtons", new hx());
            vGZ.put("enableFullScreen", new bb());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.bi.NAME, new io());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.ae.NAME, new dc());
            vGZ.put("enablePullDownRefresh", new bc());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.bk.NAME, new iw());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.bl.NAME, new jd());
            vGZ.put("disablePullDownRefresh", new at());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av.NAME, new ia());
            vGZ.put("setStatusBarStyle", new if());
            vGZ.put("deleteAccountSuccess", new aq());
            vGZ.put("chooseVideo", new ac());
            vGZ.put("uploadVideo", new jt());
            vGZ.put("openMapNavigateMenu", new fb());
            vGZ.put("setNavigationBarColor", new hy());
            vGZ.put("getWCPayRealnameVerify", new cu());
            vGZ.put("openDesignerEmojiView", new em());
            vGZ.put("openDesignerProfile", new eo());
            vGZ.put("openEmoticonTopicList", new er());
            vGZ.put("openDesignerEmojiViewLocal", new en());
            vGZ.put("openDesignerProfileLocal", new ep());
            vGZ.put("openEmotionDetailViewLocal", new d());
            vGZ.put("openNewPage", new fd());
            vGZ.put("getSearchEmotionData", new ck());
            vGZ.put("openEmotionUrl", new ba());
            vGZ.put("WNNativeCallbackOnClick", new kl());
            vGZ.put("WNNativeCallbackOnLongClick", new km());
            vGZ.put("WNNativeCallbackOnCaretChange", new kk());
            vGZ.put("WNNativeCallbackInitData", new kj());
            vGZ.put("WNNativeAsyncCallback", new ki());
            vGZ.put("WNNativeCallbackOnBecomeEditing", new kp());
            vGZ.put("WNNativeCallbackOnBecomeEdited", new kq());
            vGZ.put("changePayActivityView", new t());
            vGZ.put("selectWalletCurrency", new ji());
            vGZ.put("scanLicence", new gy());
            vGZ.put(JsApiOperateMusicPlayer.NAME, new b());
            vGZ.put(JsApiGetMusicPlayerState.NAME, new a());
            vGZ.put("clearWebviewCache", new ag());
            vGZ.put("requireSoterBiometricAuthentication", new it());
            vGZ.put("getSupportSoter", new iu());
            vGZ.put("unbindBankCard", new jm());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ar.NAME, new hq());
            vGZ.put("sendEnterpriseChat", new hi());
            vGZ.put("doExposePreparation", new ax());
            vGZ.put("getMsgProofItems", new ca());
            vGZ.put("openSecurityView", new fk());
            vGZ.put("startVoipCall", new jb());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.u.NAME, new aa());
            vGZ.put(GameJsApiGetOpenDeviceId.NAME, new cc());
            vGZ.put("getRouteUrl", new cg());
            vGZ.put("idCardRealnameVerify", new de());
            vGZ.put("uploadIdCardSuccess", new ky());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.h.d.NAME, new il());
            vGZ.put("openLuckyMoneyDetailView", new ez());
            vGZ.put("resendRemittanceMsg", new gw());
            vGZ.put(GameJsApiGetGameCommInfo.NAME, new br());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad.NAME, new ew());
            vGZ.put("chooseIdCard", new x());
            vGZ.put("getLocalImgData", new c());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag.NAME, new fp());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an.NAME, new gj());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al.NAME, new gd());
            vGZ.put("uploadEncryptMediaFile", new jq());
            vGZ.put("chooseMedia", new ab());
            vGZ.put("requestWxFacePictureVerify", new be());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab.NAME, new el());
            vGZ.put("forceUpdateWxaAttr", new bg());
            vGZ.put("openLuckyMoneyHistory", new fa());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.NAME, new hj());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t.NAME, new cw());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.NAME, new by());
            vGZ.put("openGameWebView", new ey());
            vGZ.put(GameJsApiLaunchApplication.NAME, new dr());
            vGZ.put("showSearchOfBizHistory", new ir());
            vGZ.put("login", new dv());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME, new n());
            vGZ.put("requestWxFacePictureVerifyUnionVideo", new bf());
            vGZ.put("checkIsSupportFaceDetect", new u());
            vGZ.put(JsApiOperateBackgroundAudio.NAME, new fu());
            vGZ.put(JsApiSetBackgroundAudioState.NAME, new hp());
            vGZ.put(JsApiGetBackgroundAudioState.NAME, new bk());
            vGZ.put("addDownloadTaskStraight", new k());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw.NAME, new ib());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME, new l());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax.NAME, new ig());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.ai.NAME, new dw());
            vGZ.put("openADCanvas", new ek());
            vGZ.put("openSearchCanvas", new fh());
            vGZ.put("opVoteAdData", new fx());
            vGZ.put("requestWxFaceRegisterInternal", new gt());
            vGZ.put("requestWxFaceVerifyInternal", new gu());
            vGZ.put("launchMiniProgram", new ds());
            vGZ.put("reportMiniProgramPageData", new gq());
            vGZ.put("selectContact", new hb());
            vGZ.put("openSearchWAWidgetLogView", new fi());
            vGZ.put("reloadSearchWAWidgetData", new gk());
            vGZ.put("closeWindowAndGoNext", new aj());
            vGZ.put("requestWxVoicePrintVerifyInternal", new gv());
            vGZ.put("openBizChat", new ej());
            vGZ.put("handleWCPayWalletBuffer", new cz());
            vGZ.put("tapSearchWAWidgetView", new jj());
            vGZ.put("getMatchContactList", new bz());
            vGZ.put("openSearchWebView", new fj());
            vGZ.put("openWXSearchPage", new ft());
            vGZ.put("viewTypeChange", new jx());
            vGZ.put("invokeMiniProgramAPI", new dj());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae.NAME, new ex());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at.NAME, new hs());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p.NAME, new bo());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l.NAME, new ae());
            vGZ.put("openECard", new eq());
            vGZ.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao.NAME, new go());
            vGZ.put("setWCPayPassword", new ho());
            vGZ.put("openWCPayCardList", new ei());
            vGZ.put("bindEmail", new q());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.ap.NAME, new fe());
            vGZ.put("bindEmail", new q());
            vGZ.put("doGoToRecVideoList", new cf());
            vGZ.put("jumpWSRecVideoList", new kr());
            vGZ.put("recordHistory", new bi());
            List<g> linkedList = new LinkedList();
            linkedList.add(new gc());
            linkedList.add(new gb());
            for (g gVar : linkedList) {
                vGZ.put(gVar.getName(), gVar);
            }
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.ad.NAME, new cr());
            vGZ.put("serviceClick", new hn());
            vGZ.put(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME, new ko());
            vGZ.put("sendSingleAppMessage", new hm());
        }
        return (g) vGZ.get(str);
    }
}
