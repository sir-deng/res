package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.b;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import org.json.JSONObject;

public final class bd extends a {
    public static final int CTRL_BYTE = 237;
    public static final String NAME = "uploadMediaFile";
    UploadMediaFileHelp ncU = new UploadMediaFileHelp();
    private GameWebViewUI ncn;

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiUploadMediaFile", "invoke");
        if (jSONObject == null) {
            dVar.E(i, a.e("chooseVideo:fail_invalid_data", null));
            return;
        }
        boolean z;
        this.ncn = dVar.aPO();
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("localId");
        if (jSONObject.optInt("isShowProgressTips", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.GameJsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", optString, optString2, Boolean.valueOf(z));
        if (bi.oN(optString) || bi.oN(optString2)) {
            x.e("MicroMsg.GameJsApiUploadMediaFile", "appId or localid is null or nil.");
            dVar.E(i, a.e("uploadMediaFile:fail_missing arguments", null));
            return;
        }
        UploadMediaFileHelp uploadMediaFileHelp = this.ncU;
        MMActivity mMActivity = this.ncn;
        b anonymousClass1 = new b() {
            public final void a(boolean z, HashMap<String, Object> hashMap) {
                x.i("MicroMsg.GameJsApiUploadMediaFile", "sucess = %b", Boolean.valueOf(z));
                if (z) {
                    dVar.E(i, a.e("uploadMediaFile:ok", hashMap));
                } else {
                    d dVar = dVar;
                    int i = i;
                    bd bdVar = bd.this;
                    dVar.E(i, a.e("uploadMediaFile:fail", null));
                }
                UploadMediaFileHelp uploadMediaFileHelp = bd.this.ncU;
                uploadMediaFileHelp.isO = null;
                uploadMediaFileHelp.nco = null;
                uploadMediaFileHelp.mAppId = null;
                uploadMediaFileHelp.ncX = null;
                uploadMediaFileHelp.ncZ = null;
            }
        };
        uploadMediaFileHelp.isO = mMActivity;
        uploadMediaFileHelp.nco = dVar;
        uploadMediaFileHelp.mAppId = optString;
        uploadMediaFileHelp.ncX = optString2;
        uploadMediaFileHelp.ncY = z;
        uploadMediaFileHelp.ncZ = anonymousClass1;
        UploadMediaFileHelp uploadMediaFileHelp2 = this.ncU;
        WebViewJSSDKFileItem Cg = com.tencent.mm.plugin.game.gamewebview.a.d.Cg(uploadMediaFileHelp2.ncX);
        if (Cg == null) {
            x.e("MicroMsg.UploadMediaFileHelp", "item is null");
            uploadMediaFileHelp2.ncZ.a(false, null);
        } else if (Cg.fuz == 1) {
            uploadMediaFileHelp2.aPw();
        } else if (bi.oN(Cg.iOz) || !e.bO(Cg.iOz)) {
            x.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            uploadMediaFileHelp2.ncZ.a(false, null);
        } else if (ab.bC(uploadMediaFileHelp2.isO)) {
            uploadMediaFileHelp2.aPv();
        } else {
            optString = bi.fL((long) e.bN(Cg.iOz));
            h.a(uploadMediaFileHelp2.isO, uploadMediaFileHelp2.isO.getString(R.l.eXl, new Object[]{optString}), uploadMediaFileHelp2.isO.getString(R.l.dGZ), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UploadMediaFileHelp.this.aPv();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UploadMediaFileHelp.this.ncZ.a(false, null);
                }
            });
        }
    }
}
