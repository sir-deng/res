package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public final class GameJsApiSendAppMessage extends a {
    public static final int CTRL_BYTE = 6;
    public static final String NAME = "sendAppMessage";
    public static int fNs;

    private static class SendAppMessageTask extends GameProcessActivityTask {
        public static final Creator<SendAppMessageTask> CREATOR = new Creator<SendAppMessageTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendAppMessageTask(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendAppMessageTask[i];
            }
        };
        String appId;
        String description;
        String extInfo;
        String fHu;
        String fJB;
        String jOH;
        String jum;
        String ncN;
        String ncO;
        String ncP;
        Bundle ncQ;
        int scene;
        String thumbUrl;
        String title;
        String toUser;
        String verifyAppId;

        /* synthetic */ SendAppMessageTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void a(Context context, final GameProcessActivityTask.a aVar) {
            b cgVar;
            switch (this.scene) {
                case 1:
                    x.i("MicroMsg.GameJsApiSendAppMessage", "favoriteUrl");
                    cgVar = new cg();
                    com.tencent.mm.plugin.webview.model.b.a aVar2 = new com.tencent.mm.plugin.webview.model.b.a();
                    aVar2.url = this.ncO;
                    aVar2.thumbUrl = this.thumbUrl;
                    aVar2.title = this.title;
                    aVar2.desc = this.description;
                    aVar2.fGh = this.appId;
                    if (this.ncQ != null) {
                        String hC = u.hC(bi.oM(this.ncQ.getString("KPublisherId")));
                        u.b t = u.GQ().t(hC, true);
                        t.o("sendAppMsgScene", Integer.valueOf(2));
                        t.o("preChatName", this.ncQ.getString("preChatName"));
                        t.o("preMsgIndex", Integer.valueOf(this.ncQ.getInt("preMsgIndex")));
                        t.o("prePublishId", this.ncQ.getString("prePublishId"));
                        t.o("preUsername", this.ncQ.getString("preUsername"));
                        t.o("getA8KeyScene", Integer.valueOf(this.ncQ.getInt("getA8KeyScene")));
                        t.o("referUrl", this.ncQ.getString("referUrl"));
                        if (!bi.oN(null)) {
                            t.o("adExtStr", null);
                        }
                        cgVar.frk.frp = hC;
                    }
                    if (context != null && (context instanceof MMActivity)) {
                        cgVar.frk.activity = (Activity) context;
                        cgVar.frk.frr = 36;
                    }
                    cgVar.frk.frt = new c() {
                        public final void onShow() {
                        }

                        public final void onHide() {
                            x.d("MicroMsg.GameJsApiSendAppMessage", "onHide");
                            aVar.afx();
                        }

                        public final void aPu() {
                        }
                    };
                    com.tencent.mm.plugin.webview.model.b.a(cgVar, aVar2);
                    com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                    return;
                default:
                    x.i("MicroMsg.GameJsApiSendAppMessage", "sendToFriend");
                    if (bi.oN(this.toUser)) {
                        x.e("MicroMsg.GameJsApiSendAppMessage", "toUser is null");
                        return;
                    }
                    o.PB();
                    Bitmap iJ = com.tencent.mm.ap.c.iJ(this.thumbUrl);
                    IMediaObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = this.ncO;
                    wXWebpageObject.extInfo = this.extInfo;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXWebpageObject;
                    wXMediaMessage.title = this.title;
                    wXMediaMessage.description = this.description;
                    if (!(iJ == null || iJ.isRecycled())) {
                        x.i("MicroMsg.GameJsApiSendAppMessage", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        iJ.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    f aZ = g.aZ(this.appId, true);
                    b orVar = new or();
                    orVar.fHs.fzX = wXMediaMessage;
                    orVar.fHs.appId = this.appId;
                    orVar.fHs.appName = aZ == null ? "" : aZ.field_appName;
                    orVar.fHs.toUser = this.toUser;
                    orVar.fHs.fHt = 2;
                    if (bi.oN(this.fHu)) {
                        orVar.fHs.fHw = null;
                    } else {
                        orVar.fHs.fHu = this.fHu;
                        orVar.fHs.fHv = this.ncN;
                    }
                    orVar.fHs.fHx = this.fJB;
                    orVar.fHs.fHA = this.ncP;
                    orVar.fHs.frp = u.hC(this.ncP);
                    orVar.fHs.fHy = this.jOH;
                    orVar.fHs.fHz = this.verifyAppId;
                    com.tencent.mm.sdk.b.a.xmy.m(orVar);
                    if (!bi.oN(this.jum)) {
                        cgVar = new ot();
                        cgVar.fHD.fHE = this.toUser;
                        cgVar.fHD.content = this.jum;
                        cgVar.fHD.type = s.hs(this.toUser);
                        cgVar.fHD.flags = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                    }
                    aVar.afx();
                    return;
            }
        }

        public final void f(Parcel parcel) {
            this.scene = parcel.readInt();
            this.appId = parcel.readString();
            this.fHu = parcel.readString();
            this.ncN = parcel.readString();
            this.jum = parcel.readString();
            this.toUser = parcel.readString();
            this.thumbUrl = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
            this.ncO = parcel.readString();
            this.extInfo = parcel.readString();
            this.fJB = parcel.readString();
            this.jOH = parcel.readString();
            this.verifyAppId = parcel.readString();
            this.ncP = parcel.readString();
            this.ncQ = parcel.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scene);
            parcel.writeString(this.appId);
            parcel.writeString(this.fHu);
            parcel.writeString(this.ncN);
            parcel.writeString(this.jum);
            parcel.writeString(this.toUser);
            parcel.writeString(this.thumbUrl);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.ncO);
            parcel.writeString(this.fJB);
            parcel.writeString(this.jOH);
            parcel.writeString(this.verifyAppId);
            parcel.writeString(this.ncP);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.ncQ);
        }

        public SendAppMessageTask(Context context) {
            super(context);
        }

        private SendAppMessageTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(final d dVar, final JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.E(i, a.e("send_app_msg:fail_null_params", null));
        } else if (bi.oN(jSONObject.optString("link"))) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.E(i, a.e("send_app_msg:fail_invalid_params", null));
        } else {
            switch (fNs) {
                case 1:
                    SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(dVar.aPO());
                    sendAppMessageTask.scene = fNs;
                    sendAppMessageTask.appId = jSONObject.optString("appid");
                    sendAppMessageTask.thumbUrl = jSONObject.optString("img_url");
                    sendAppMessageTask.fHu = jSONObject.optString("src_username");
                    sendAppMessageTask.ncN = jSONObject.optString("src_displayname");
                    sendAppMessageTask.title = jSONObject.optString("title");
                    sendAppMessageTask.description = jSONObject.optString("desc");
                    sendAppMessageTask.ncO = dVar.Cu(jSONObject.optString("link"));
                    sendAppMessageTask.fJB = bi.oM(dVar.ndH);
                    sendAppMessageTask.jOH = dVar.aPR();
                    sendAppMessageTask.verifyAppId = dVar.aPS();
                    sendAppMessageTask.extInfo = jSONObject.optString("review_data");
                    Bundle bundle = new Bundle();
                    bundle.putString("KPublisherId", bi.oM(dVar.vf.getString("KPublisherId")));
                    int aq = com.tencent.mm.plugin.game.gamewebview.a.d.aq(dVar.scene, dVar.vf.getString("geta8key_username"));
                    bundle.putString("preChatName", dVar.vf.getString("preChatName"));
                    bundle.putInt("preMsgIndex", dVar.vf.getInt("preMsgIndex", 0));
                    bundle.putString("prePublishId", dVar.vf.getString("prePublishId"));
                    bundle.putString("preUsername", dVar.vf.getString("preUsername"));
                    bundle.putInt("getA8KeyScene", aq);
                    bundle.putString("referUrl", dVar.neM);
                    sendAppMessageTask.ncQ = bundle;
                    sendAppMessageTask.aLl();
                    dVar.E(i, "send_app_msg:ok");
                    break;
                default:
                    h.a(dVar, jSONObject);
                    Serializable hashMap = new HashMap();
                    hashMap.put("img_url", jSONObject.optString("img_url"));
                    hashMap.put("desc", jSONObject.optString("desc"));
                    hashMap.put("title", jSONObject.optString("title"));
                    hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL));
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 2);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("webview_params", hashMap);
                    intent.putExtra("Retr_Msg_Type", 2);
                    com.tencent.mm.bl.d.a(dVar.aPO(), ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
                        public final void b(int i, int i2, Intent intent) {
                            if (i == 1) {
                                String str;
                                String optString = jSONObject.optString("appid");
                                if (GameJsApiSendAppMessage.this.nbJ == null || !bi.oN(optString)) {
                                    str = optString;
                                } else {
                                    str = GameJsApiSendAppMessage.this.nbJ.getString("jsapi_args_appid");
                                }
                                switch (i2) {
                                    case -1:
                                        if (intent == null) {
                                            optString = null;
                                        } else {
                                            optString = intent.getStringExtra("Select_Conv_User");
                                        }
                                        d dVar;
                                        int i3;
                                        GameJsApiSendAppMessage gameJsApiSendAppMessage;
                                        if (optString == null || optString.length() == 0) {
                                            x.e("MicroMsg.GameJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                                            dVar = dVar;
                                            i3 = i;
                                            gameJsApiSendAppMessage = GameJsApiSendAppMessage.this;
                                            dVar.E(i3, a.e("send_app_msg:fail", null));
                                            return;
                                        }
                                        SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(dVar.aPO());
                                        sendAppMessageTask.scene = GameJsApiSendAppMessage.fNs;
                                        sendAppMessageTask.appId = str;
                                        sendAppMessageTask.toUser = optString;
                                        sendAppMessageTask.thumbUrl = (String) jSONObject.opt("img_url");
                                        sendAppMessageTask.fHu = (String) jSONObject.opt("src_username");
                                        sendAppMessageTask.ncN = (String) jSONObject.opt("src_displayname");
                                        sendAppMessageTask.jum = intent.getStringExtra("custom_send_text");
                                        sendAppMessageTask.title = jSONObject.optString("title");
                                        sendAppMessageTask.description = jSONObject.optString("desc");
                                        sendAppMessageTask.ncO = dVar.Cu(jSONObject.optString("link"));
                                        sendAppMessageTask.fJB = bi.oM(dVar.ndH);
                                        sendAppMessageTask.jOH = dVar.aPR();
                                        sendAppMessageTask.verifyAppId = dVar.aPS();
                                        sendAppMessageTask.extInfo = jSONObject.optString("review_data");
                                        sendAppMessageTask.aLl();
                                        com.tencent.mm.ui.base.h.bu(dVar.aPO(), dVar.getResources().getString(R.l.dGR));
                                        dVar = dVar;
                                        i3 = i;
                                        gameJsApiSendAppMessage = GameJsApiSendAppMessage.this;
                                        dVar.E(i3, a.e("send_app_msg:ok", null));
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    });
                    break;
            }
            fNs = 0;
        }
    }
}
