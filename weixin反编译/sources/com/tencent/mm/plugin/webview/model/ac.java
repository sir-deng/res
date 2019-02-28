package com.tencent.mm.plugin.webview.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Vector;

public final class ac implements e {
    private a hDi = new a() {
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            x.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", str);
        }

        public final byte[] h(String str, byte[] bArr) {
            x.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", str);
            return null;
        }

        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            String str2;
            WebViewJSSDKFileItem webViewJSSDKFileItem;
            String str3 = "MicroMsg.WebviewFileChooserCdnService";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = keep_progressinfo == null ? "null" : keep_progressinfo.toString();
            if (keep_sceneresult == null) {
                str2 = "null";
            } else {
                str2 = keep_sceneresult.toString();
            }
            objArr[3] = str2;
            x.i(str3, str4, objArr);
            ad bSo = f.bSo();
            if (!bi.oN(str)) {
                for (WebViewJSSDKFileItem webViewJSSDKFileItem2 : bSo.tyU.values()) {
                    if (bi.oM(webViewJSSDKFileItem2.mediaId).equals(str)) {
                        webViewJSSDKFileItem = webViewJSSDKFileItem2;
                        break;
                    }
                }
            }
            x.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
            webViewJSSDKFileItem = null;
            if (webViewJSSDKFileItem == null) {
                x.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", str);
                return 0;
            } else if (i == -21005) {
                x.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", str);
                return 0;
            } else if (i != 0) {
                x.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                ac.this.b(false, webViewJSSDKFileItem.fvn, webViewJSSDKFileItem.mediaId, null);
                return 0;
            } else if (keep_progressinfo != null) {
                x.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", keep_progressinfo.toString());
                int i2 = 0;
                if (keep_progressinfo.field_toltalLength > 0) {
                    i2 = (keep_progressinfo.field_finishedLength * 100) / keep_progressinfo.field_toltalLength;
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                ac.this.b(webViewJSSDKFileItem.iOC, webViewJSSDKFileItem.fuz, i2, webViewJSSDKFileItem.fvn, webViewJSSDKFileItem.mediaId);
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult);
                        ac.this.b(false, webViewJSSDKFileItem.fvn, webViewJSSDKFileItem.mediaId, null);
                    } else {
                        x.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", str);
                        if (webViewJSSDKFileItem != null) {
                            webViewJSSDKFileItem.c(keep_sceneresult);
                            if (webViewJSSDKFileItem.iOC && webViewJSSDKFileItem.iOE) {
                                e eVar = ac.this;
                                if (webViewJSSDKFileItem == null) {
                                    x.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                                } else {
                                    apx apx = new apx();
                                    apx.wDE = webViewJSSDKFileItem.tyS.field_aesKey;
                                    apx.wbM = webViewJSSDKFileItem.tyS.field_fileLength;
                                    apx.wDD = webViewJSSDKFileItem.tyS.field_fileId;
                                    apx.type = webViewJSSDKFileItem.bRB();
                                    x.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", webViewJSSDKFileItem.appId, webViewJSSDKFileItem.fvn, apx.wDE, Integer.valueOf(apx.wbM), apx.wDD);
                                    apx.wDF = webViewJSSDKFileItem.bRA();
                                    as.CN().a(1034, eVar);
                                    as.CN().a(new w(webViewJSSDKFileItem.appId, webViewJSSDKFileItem.fvn, apx), 0);
                                }
                            } else {
                                ac.this.b(true, webViewJSSDKFileItem.fvn, webViewJSSDKFileItem.iOA, webViewJSSDKFileItem.tyS.field_fileUrl);
                            }
                        }
                    }
                }
                return 0;
            }
        }
    };
    private Vector<b> iOF = new Vector();
    private Vector<c.a> iOG = new Vector();

    public final void a(c.a aVar) {
        if (this.iOG != null && aVar != null && !this.iOG.contains(aVar)) {
            this.iOG.add(aVar);
        }
    }

    public final void a(b bVar) {
        if (this.iOF != null && bVar != null) {
            this.iOF.remove(bVar);
        }
    }

    public final void b(c.a aVar) {
        if (this.iOG != null && aVar != null) {
            this.iOG.remove(aVar);
        }
    }

    private void b(boolean z, String str, String str2, String str3) {
        if (this.iOF != null && this.iOF.size() > 0) {
            Iterator it = this.iOF.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(z, str, str2, str3);
            }
        }
    }

    final void b(boolean z, int i, int i2, String str, String str2) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        if (this.iOG != null && this.iOG.size() > 0) {
            Iterator it = this.iOG.iterator();
            while (it.hasNext()) {
                ((c.a) it.next()).a(z, i, i2, str, str2);
            }
        }
    }

    public final boolean a(String str, String str2, b bVar) {
        ad bSo = f.bSo();
        if (!bi.oN(str2)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem : bSo.tyU.values()) {
                if (bi.oM(webViewJSSDKFileItem.iOA).equals(str2)) {
                    break;
                }
            }
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        WebViewJSSDKFileItem webViewJSSDKFileItem2 = null;
        if (webViewJSSDKFileItem2 != null) {
            webViewJSSDKFileItem2.appId = str;
            x.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", str, str2, webViewJSSDKFileItem2.fvn);
            bVar.a(true, webViewJSSDKFileItem2.fvn, webViewJSSDKFileItem2.iOA, null);
        } else {
            as.CN().a(1035, (e) this);
            as.CN().a(new f(str, str2), 0);
            this.iOF.add(bVar);
        }
        return true;
    }

    private void a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        i iVar = new i();
        iVar.hve = this.hDi;
        iVar.fMC = false;
        iVar.field_mediaId = webViewJSSDKFileItem.mediaId;
        iVar.field_fullpath = webViewJSSDKFileItem.iOz;
        iVar.field_totalLen = webViewJSSDKFileItem.tyS.field_fileLength;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
        iVar.field_fileId = webViewJSSDKFileItem.tyS.field_fileId;
        iVar.field_aesKey = webViewJSSDKFileItem.tyS.field_aesKey;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        x.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", Boolean.valueOf(g.MP().b(iVar, -1)), webViewJSSDKFileItem.iOA);
        if (!g.MP().b(iVar, -1)) {
            b(false, null, null, null);
        }
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, b bVar) {
        WebViewJSSDKFileItem OS = f.bSo().OS(str2);
        if (OS == null) {
            x.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str2);
            return false;
        }
        OS.appId = str;
        if (bVar != null) {
            this.iOF.add(bVar);
        }
        if (i2 == 202) {
            OS.iOE = false;
        }
        OS.iOC = true;
        i iVar = new i();
        iVar.hve = this.hDi;
        iVar.fMC = true;
        iVar.field_mediaId = OS.mediaId;
        iVar.field_fullpath = OS.iOz;
        iVar.field_fileType = i;
        iVar.field_talker = "weixin";
        iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
        if (i == com.tencent.mm.modelcdntran.b.hty) {
            iVar.field_needStorage = true;
        } else {
            iVar.field_needStorage = false;
        }
        iVar.field_isStreamMedia = false;
        iVar.field_appType = i2;
        iVar.field_bzScene = i3;
        iVar.field_force_aeskeycdn = true;
        iVar.field_trysafecdn = false;
        x.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(g.MP().c(iVar)), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), str2);
        return g.MP().c(iVar);
    }

    public final boolean b(String str, String str2, b bVar) {
        return a(str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, bVar);
    }

    public static boolean qC(String str) {
        WebViewJSSDKFileItem OS = f.bSo().OS(str);
        if (OS != null) {
            return g.MP().kK(OS.mediaId);
        }
        x.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
        return false;
    }

    public static boolean OO(String str) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", str);
        return g.MP().kL(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()));
        String str2;
        String str3;
        String str4;
        String str5;
        switch (kVar.getType()) {
            case 1034:
                as.CN().b(1034, (e) this);
                w wVar = (w) kVar;
                str2 = ((aqd) wVar.gLB.hnR.hnY).wDG;
                str3 = wVar.appId;
                str4 = wVar.fvn;
                WebViewJSSDKFileItem OS = f.bSo().OS(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(OS == null);
                x.i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (OS != null) {
                        b(false, OS.fvn, OS.mediaId, null);
                        return;
                    }
                    return;
                } else if (!bi.oN(str3) && !bi.oN(str2) && OS != null) {
                    OS.iOA = str2;
                    b(true, OS.fuz, 100, OS.fvn, OS.iOA);
                    b(true, OS.fvn, OS.iOA, OS.tyS.field_fileUrl);
                    return;
                } else {
                    return;
                }
            case 1035:
                as.CN().b(1035, (e) this);
                if (i == 0 && i2 == 0) {
                    f fVar = (f) kVar;
                    str2 = fVar.appId;
                    str3 = fVar.iOA;
                    apx apx = ((apz) fVar.gLB.hnR.hnY).wDH;
                    str5 = "MicroMsg.WebviewFileChooserCdnService";
                    String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = str2;
                    objArr2[1] = str3;
                    objArr2[2] = Boolean.valueOf(apx == null);
                    x.i(str5, str7, objArr2);
                    if (!bi.oN(str2) && !bi.oN(str3) && apx != null) {
                        str4 = apx.type;
                        x.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", str4);
                        if (!bi.oN(str4)) {
                            WebViewJSSDKFileItem OQ;
                            if (str4.toLowerCase().equals("voice")) {
                                OQ = WebViewJSSDKFileItem.OQ(ai.OZ(str2));
                            } else if (str4.toLowerCase().equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                                OQ = WebViewJSSDKFileItem.OR(ai.OT(bi.Wy()));
                            } else {
                                OQ = WebViewJSSDKFileItem.OP(ai.OT(bi.Wy()));
                            }
                            OQ.iOC = false;
                            OQ.appId = str2;
                            OQ.iOA = str3;
                            if (OQ.tyS == null) {
                                OQ.tyS = new WebViewJSSDKFileItem.a();
                            }
                            if (apx == null) {
                                x.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                            } else {
                                OQ.tyS.field_aesKey = apx.wDE;
                                OQ.tyS.field_fileId = apx.wDD;
                                OQ.tyS.field_fileLength = apx.wbM;
                            }
                            f.bSo().b(OQ);
                            a(OQ);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                b(false, null, null, null);
                return;
            default:
                return;
        }
    }
}
