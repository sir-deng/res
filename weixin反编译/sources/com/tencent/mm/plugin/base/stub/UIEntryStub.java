package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.bl.d;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import java.util.Map;

@a(7)
public class UIEntryStub extends Activity {
    private Intent fAb;
    private int kAB;
    private boolean kAC;
    private String uC;

    static /* synthetic */ void a(UIEntryStub uIEntryStub, final Bundle bundle) {
        boolean z = false;
        uIEntryStub.uC = bundle.getString(ConstantsAPI.APP_PACKAGE);
        uIEntryStub.kAB = bundle.getInt(ConstantsAPI.SDK_VERSION);
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        x.d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = " + queryParameter);
        if (g.cA(queryParameter)) {
            j jVar = q.a.vjc;
            if (jVar != null) {
                jVar.o(uIEntryStub, queryParameter, uIEntryStub.uC);
            }
        }
        int i = bundle.getInt("_wxapi_command_type");
        x.i("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.uC + ", sdkver=" + uIEntryStub.kAB + ", cmd=" + i);
        switch (i) {
            case 1:
                if (as.Hp() && !as.Cz()) {
                    c fp = com.tencent.mm.y.c.c.IL().fp("100273");
                    if (fp.isValid()) {
                        Map civ = fp.civ();
                        if (civ == null) {
                            x.i("MicroMsg.UIEntryStub", "isSDKOauthNative args == null");
                        } else if (civ.containsKey("isUseNative") && "1".equals(civ.get("isUseNative"))) {
                            z = true;
                        } else {
                            x.i("MicroMsg.UIEntryStub", "isSDKOauthNative not contain the isUseNative key or the value is not 1");
                        }
                    } else {
                        x.i("MicroMsg.UIEntryStub", "isSDKOauthNative item.isValid is false");
                    }
                    if (!z) {
                        Intent putExtras = new Intent().putExtras(bundle);
                        putExtras.putExtra("mode", 1);
                        putExtras.putExtra("forceHideShare", true);
                        putExtras.putExtra("neverGetA8Key", true);
                        putExtras.putExtra("geta8key_scene", 6);
                        putExtras.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                        putExtras.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                        d.b(uIEntryStub, "webview", ".ui.tools.OAuthUI", putExtras);
                        break;
                    }
                    d.b(uIEntryStub, "webview", ".ui.tools.SDKOAuthUI", new Intent().putExtras(bundle));
                    break;
                }
                x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                break;
                break;
            case 2:
                final Req req = new Req(bundle);
                if (req.message != null && req.message.getType() == 2) {
                    WXImageObject wXImageObject = (WXImageObject) req.message.mediaObject;
                    if (!(wXImageObject == null || wXImageObject.checkArgs())) {
                        x.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                        ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                        uIEntryStub.finish();
                        return;
                    }
                }
                if (req.message.getType() != 38 || req.scene == 1) {
                    if (req.scene == 1) {
                        x.i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                        if (req.message.getType() == 8) {
                            x.e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                            ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                        } else {
                            new d(uIEntryStub, queryParameter, req.openId, new d.a() {
                                public final void dT(boolean z) {
                                    boolean isFinishing = UIEntryStub.this.isFinishing();
                                    x.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                                    if (z && !isFinishing) {
                                        Intent intent = new Intent(UIEntryStub.this, SendAppMessageWrapperUI.class);
                                        intent.putExtras(bundle);
                                        intent.putExtra("Select_Conv_User", "weixinfile");
                                        intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                        UIEntryStub.this.startActivity(intent);
                                    }
                                    UIEntryStub.this.finish();
                                }
                            }).arC();
                            return;
                        }
                    }
                    Parcelable b = ReportUtil.b(bundle, -2);
                    Intent intent = new Intent(uIEntryStub, SelectConversationUI.class);
                    intent.putExtra("Select_Report_Args", b);
                    intent.putExtra("Select_Conv_NextStep", new Intent(uIEntryStub, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", req.scene).putExtra("animation_pop_in", true));
                    intent.putExtra("Select_App_Id", queryParameter);
                    intent.putExtra("Select_Open_Id", req.openId);
                    intent.putExtra("Select_Conv_Type", 3);
                    if (req.message.getType() == 36) {
                        intent.putExtra("mutil_select_is_ret", !((WXMiniProgramObject) req.message.mediaObject).withShareTicket);
                    } else {
                        intent.putExtra("mutil_select_is_ret", true);
                    }
                    if (!as.Hp() || as.Cz()) {
                        x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    } else {
                        uIEntryStub.startActivity(intent);
                    }
                    uIEntryStub.finish();
                    return;
                }
                x.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, video file object only supported share to timeline");
                ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                uIEntryStub.finish();
                return;
            case 3:
                if (as.Hp() && !as.Cz()) {
                    am.ah(bundle);
                    break;
                } else {
                    x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
            case 4:
                if (as.Hp() && !as.Cz()) {
                    an.ah(bundle);
                    break;
                } else {
                    x.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
        }
        uIEntryStub.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotifyReceiver.wN();
        this.kAC = false;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.fAb = intent;
        x.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", Boolean.valueOf(this.kAC));
        this.kAC = false;
    }

    public void onResume() {
        super.onResume();
        if (this.fAb == null) {
            this.fAb = getIntent();
        }
        as.CN().a(new be(new be.a() {
            public final void a(e eVar) {
                if (eVar == null) {
                    UIEntryStub.this.finish();
                    return;
                }
                x.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", Boolean.valueOf(UIEntryStub.this.kAC));
                if (!UIEntryStub.this.kAC) {
                    UIEntryStub.this.kAC = true;
                    UIEntryStub.a(UIEntryStub.this, UIEntryStub.this.fAb.getExtras());
                }
            }
        }), 0);
    }
}
