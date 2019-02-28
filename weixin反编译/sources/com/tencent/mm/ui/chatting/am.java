package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class am implements aa {
    public static k<aa, Bundle> yGI = new k<aa, Bundle>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((aa) obj).ag((Bundle) obj2);
        }
    };
    private p fhH;
    public u yGG;
    public final Set<String> yGH = new HashSet();

    public am(p pVar) {
        this.yGG = pVar.cte();
        this.fhH = pVar;
    }

    public static void ah(Bundle bundle) {
        yGI.cb(bundle);
        yGI.doNotify();
    }

    public final void ag(Bundle bundle) {
        int i = 1;
        boolean z = false;
        if (this.fhH.ctD()) {
            x.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
            return;
        }
        String string;
        int type;
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        Resp resp = new Resp(bundle);
        WXMediaMessage wXMediaMessage = resp.message;
        if (this.yGH.size() == 0) {
            Context context = this.yGG.getContext();
            Collection hashSet = new HashSet();
            string = context.getSharedPreferences(ad.cgi(), 0).getString("transactions_array_key", null);
            if (string != null && string.length() > 0) {
                for (Object add : string.split(";")) {
                    hashSet.add(add);
                }
            }
            this.yGH.addAll(hashSet);
        }
        if (this.yGH.contains(resp.transaction)) {
            this.yGH.remove(resp.transaction);
            a(this.yGG.getContext(), this.yGH);
            f fVar = new f();
            fVar.field_appId = queryParameter;
            x.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + queryParameter);
            if (an.biT().b((c) fVar, new String[0])) {
                type = wXMediaMessage.getType();
                com.tencent.mm.ui.p controller;
                boolean i2;
                i b;
                byte[] bArr;
                int i3;
                String str;
                switch (type) {
                    case 1:
                        controller = this.yGG.getController();
                        queryParameter = wXMediaMessage.description;
                        m(fVar);
                        if (e.a(controller, queryParameter, false, a(wXMediaMessage, fVar)) != null) {
                            z = true;
                        }
                        i2 = z;
                        break;
                    case 2:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                            com.tencent.mm.ui.p controller2;
                            if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                controller2 = this.yGG.getController();
                                string = wXImageObject.imagePath;
                                m(fVar);
                                b = e.b(controller2, string, false, a(wXMediaMessage, fVar));
                            } else {
                                controller2 = this.yGG.getController();
                                byte[] bArr2 = wXImageObject.imageData;
                                m(fVar);
                                b = e.a(controller2, bArr2, false, a(wXMediaMessage, fVar));
                            }
                        } else {
                            controller = this.yGG.getController();
                            bArr = wXMediaMessage.thumbData;
                            m(fVar);
                            b = e.a(controller, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            x.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                        } else {
                            z = true;
                        }
                        i2 = z;
                        break;
                    case 3:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yGG.getController();
                            i3 = R.k.dvy;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i3, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yGG.getController();
                            queryParameter = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, queryParameter, false, 2, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i2 = 0;
                            break;
                        }
                        break;
                    case 4:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yGG.getController();
                            i3 = R.k.dvL;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i3, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yGG.getController();
                            queryParameter = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, queryParameter, false, 1, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i2 = 0;
                            break;
                        }
                        break;
                    case 5:
                        controller = this.yGG.getController();
                        queryParameter = wXMediaMessage.title;
                        str = wXMediaMessage.description;
                        m(fVar);
                        if (e.a(controller, queryParameter, str, false, "", a(wXMediaMessage, fVar)) == null) {
                            i2 = 0;
                            break;
                        }
                        break;
                    case 7:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yGG.getController();
                            i3 = R.k.dvO;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i3, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yGG.getController();
                            queryParameter = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, queryParameter, false, 0, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i2 = 0;
                            break;
                        }
                        break;
                    case 8:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            controller = this.yGG.getController();
                            i3 = R.k.dvO;
                            str = wXMediaMessage.title;
                            m(fVar);
                            b = e.a(controller, i3, str, false, a(wXMediaMessage, fVar));
                        } else {
                            controller = this.yGG.getController();
                            bArr = wXMediaMessage.thumbData;
                            m(fVar);
                            b = e.a(controller, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i2 = 0;
                            break;
                        }
                        break;
                    default:
                        x.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + type);
                        i2 = 0;
                        break;
                }
                if (i2 == 0) {
                    x.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                    return;
                }
                return;
            }
            x.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + queryParameter);
            return;
        }
        x.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
    }

    public final boolean fS(String str, String str2) {
        x.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        Req req = new Req();
        req.username = this.fhH.csn();
        req.transaction = g.s((t.Wy()).getBytes());
        req.openId = str2;
        SharedPreferences sharedPreferences = this.yGG.getSharedPreferences(ad.cgf(), 0);
        this.yGG.getContext();
        req.lang = w.d(sharedPreferences);
        as.Hm();
        req.country = (String) com.tencent.mm.y.c.Db().get(274436, null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        com.tencent.mm.pluginsdk.model.app.p.ae(bundle);
        com.tencent.mm.pluginsdk.model.app.p.af(bundle);
        Args args = new Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.yGG.getContext(), args);
        this.yGH.add(req.transaction);
        a(this.yGG.getContext(), this.yGH);
        return send;
    }

    private String m(f fVar) {
        return this.yGG.getString(R.l.dUq, com.tencent.mm.pluginsdk.model.app.g.a(this.yGG.getContext(), fVar, null));
    }

    private a a(final WXMediaMessage wXMediaMessage, final f fVar) {
        return new a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            x.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            return;
                        }
                        str2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(am.this.yGG.getContext(), wXMediaMessage, fVar.field_appId);
                        if (str2 == null) {
                            x.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            return;
                        }
                    }
                    bp.HY().c(27, Integer.valueOf(1));
                    x.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", wXMediaMessage.messageAction, wXMediaMessage.messageExt);
                    l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, am.this.fhH.csn(), 1, str2);
                }
            }
        };
    }

    @TargetApi(9)
    public static void a(Context context, Set<String> set) {
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(ad.cgi(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
