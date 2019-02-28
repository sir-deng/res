package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.q;

@a(3)
public class FavOpenApiEntry extends MMActivity {
    private String appId;
    private String bhd;
    private Intent fAb;
    private al fia = new al(new al.a() {
        public final boolean uG() {
            if (FavOpenApiEntry.this.getWindow() != null && FavOpenApiEntry.this.getWindow().getDecorView() != null && FavOpenApiEntry.this.getWindow().getDecorView().getWindowToken() != null) {
                FavOpenApiEntry.a(FavOpenApiEntry.this, FavOpenApiEntry.this.myn.message);
                return false;
            } else if (FavOpenApiEntry.this.myp >= 10) {
                return false;
            } else {
                FavOpenApiEntry.b(FavOpenApiEntry.this);
                return true;
            }
        }
    }, true);
    private Bundle mym;
    private Req myn;
    private String myo;
    private int myp = 0;

    static /* synthetic */ void a(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        boolean z = true;
        boolean z2 = false;
        if (wXMediaMessage == null) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        i b;
        switch (type) {
            case 1:
                if (!bi.oN(((WXTextObject) wXMediaMessage.mediaObject).text)) {
                    favOpenApiEntry.appId.equals("wx4310bbd51be7d979");
                    if (e.a(favOpenApiEntry.mController, wXMediaMessage.description, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage)) != null) {
                        z2 = true;
                        break;
                    }
                }
                x.e("MicroMsg.FavOpenApiEntry", "dealText null!");
                break;
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || com.tencent.mm.a.e.bO(wXImageObject.imagePath)) {
                    if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                        wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                        b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? e.b(favOpenApiEntry.mController, wXImageObject.imagePath, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXImageObject.imageData, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage));
                    } else {
                        b = e.a(favOpenApiEntry.mController, wXMediaMessage.thumbData, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage));
                    }
                    if (b != null) {
                        z2 = true;
                        break;
                    } else {
                        x.e("MicroMsg.FavOpenApiEntry", "showImgDialog fail, invalid argument");
                        break;
                    }
                }
                break;
            case 3:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? e.a(favOpenApiEntry.mController, R.k.dvy, wXMediaMessage.title, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 2, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 4:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? e.a(favOpenApiEntry.mController, R.k.dvL, wXMediaMessage.title, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 1, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 5:
                if (e.a(favOpenApiEntry.mController, wXMediaMessage.title, wXMediaMessage.description, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage)) == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 6:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? e.a(favOpenApiEntry.mController, R.k.dvu, wXMediaMessage.title, false, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 0, favOpenApiEntry.myo, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 7:
            case 8:
                break;
            default:
                x.e("MicroMsg.FavOpenApiEntry", "unknown type = " + type);
                break;
        }
        if (!z2) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, result is false finish()");
            favOpenApiEntry.finish();
        }
    }

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.myp + 1;
        favOpenApiEntry.myp = i;
        return i;
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        f fVar;
        uz uzVar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!bi.oN(wXTextObject.text)) {
                    fVar = new f();
                    fVar.field_type = 1;
                    a(wXMediaMessage, fVar);
                    fVar.field_favProto.UM(wXTextObject.text);
                    favOpenApiEntry.E(fVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || com.tencent.mm.a.e.bO(wXImageObject.imagePath)) {
                    fVar = new f();
                    fVar.field_type = 2;
                    a(wXMediaMessage, fVar);
                    favOpenApiEntry.E(fVar);
                    fVar.field_favProto.wlY.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, fVar.field_type));
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!bi.oN(wXMusicObject.musicDataUrl) || !bi.oN(wXMusicObject.musicUrl) || !bi.oN(wXMusicObject.musicLowBandUrl)) {
                    fVar = new f();
                    fVar.field_type = 7;
                    a(wXMediaMessage, fVar);
                    uzVar = new uz();
                    uzVar.Ub(wXMusicObject.musicUrl);
                    uzVar.Ud(wXMusicObject.musicLowBandUrl);
                    uzVar.Uc(wXMusicObject.musicDataUrl);
                    uzVar.TV(wXMediaMessage.title);
                    uzVar.TW(wXMediaMessage.description);
                    a(wXMediaMessage, uzVar, fVar.field_type);
                    uzVar.lz(true);
                    uzVar.Dc(fVar.field_type);
                    fVar.field_favProto.wlY.add(uzVar);
                    favOpenApiEntry.E(fVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!bi.oN(wXVideoObject.videoLowBandUrl) || !bi.oN(wXVideoObject.videoUrl)) {
                    fVar = new f();
                    fVar.field_type = 4;
                    a(wXMediaMessage, fVar);
                    uzVar = new uz();
                    uzVar.Ub(wXVideoObject.videoUrl);
                    uzVar.Ud(wXVideoObject.videoLowBandUrl);
                    uzVar.TV(wXMediaMessage.title);
                    uzVar.TW(wXMediaMessage.description);
                    a(wXMediaMessage, uzVar, fVar.field_type);
                    uzVar.lz(true);
                    uzVar.Dc(fVar.field_type);
                    fVar.field_favProto.wlY.add(uzVar);
                    favOpenApiEntry.E(fVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!bi.oN(wXWebpageObject.webpageUrl)) {
                    fVar = new f();
                    fVar.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    fVar.field_type = 5;
                    a(wXMediaMessage, fVar);
                    favOpenApiEntry.E(fVar);
                    fVar.field_favProto.wlW.UU(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        uz uzVar2 = new uz();
                        uzVar2.TV(wXMediaMessage.title);
                        uzVar2.TW(wXMediaMessage.description);
                        a(wXMediaMessage, uzVar2, fVar.field_type);
                        uzVar2.lz(true);
                        uzVar2.Dc(fVar.field_type);
                        fVar.field_favProto.wlY.add(uzVar2);
                    }
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !com.tencent.mm.a.e.bO(wXFileObject.filePath)) {
                    x.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                fVar = new f();
                fVar.field_type = 8;
                a(wXMediaMessage, fVar);
                favOpenApiEntry.E(fVar);
                fVar.field_favProto.wlY.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, fVar.field_type));
                com.tencent.mm.plugin.favorite.b.a.B(fVar);
                break;
                break;
            default:
                x.e("MicroMsg.FavOpenApiEntry", "unsupport type = " + type);
                break;
        }
        favOpenApiEntry.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fAb == null) {
            this.fAb = getIntent();
        }
        this.mym = this.fAb.getExtras();
        this.appId = this.mym.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.mym.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        }
        this.myn = new Req(this.mym);
        if (this.myn.scene != 2) {
            x.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            return;
        }
        this.myo = getString(R.l.eeR);
        String appName = d.getAppName(this, this.appId);
        this.bhd = getString(R.l.dUq, new Object[]{appName});
        this.fia.K(100, 100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.fAb = intent;
    }

    protected void onResume() {
        super.onResume();
    }

    private static void a(WXMediaMessage wXMediaMessage, f fVar) {
        fVar.field_sourceType = 4;
        fVar.field_favProto.UL(wXMediaMessage.title);
        fVar.field_favProto.UM(wXMediaMessage.description);
    }

    private void E(f fVar) {
        vt vtVar = new vt();
        vtVar.UT(this.appId);
        vtVar.Dl(4);
        vtVar.UN(q.FY());
        vtVar.UO(q.FY());
        fVar.field_fromUser = vtVar.fAJ;
        fVar.field_toUser = vtVar.toUser;
        fVar.field_favProto.a(vtVar);
    }

    private static uz a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        uz uzVar = new uz();
        uzVar.TV(wXMediaMessage.title);
        uzVar.TW(wXMediaMessage.description);
        uzVar.Dc(i);
        if (str != null) {
            uzVar.Uj(str);
            uzVar.Uf(com.tencent.mm.a.e.bQ(str));
        } else {
            String s = g.s(bArr);
            if (bArr.length >= 256) {
                uzVar.Uh(s);
            } else {
                Object obj = new byte[256];
                System.arraycopy(bArr, 0, obj, 0, 256);
                uzVar.Uh(g.s(obj));
            }
            uzVar.Ug(s);
            uzVar.fx((long) bArr.length);
            uzVar.Ui(j.bm(uzVar.toString(), i));
            com.tencent.mm.a.e.d(j.h(uzVar), bArr);
        }
        a(wXMediaMessage, uzVar, i);
        return uzVar;
    }

    private static void a(WXMediaMessage wXMediaMessage, uz uzVar, int i) {
        if (wXMediaMessage.thumbData != null) {
            String s = g.s(wXMediaMessage.thumbData);
            uzVar.Ul(s);
            if (wXMediaMessage.thumbData.length >= 256) {
                uzVar.Um(s);
            } else {
                Object obj = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, obj, 0, 256);
                uzVar.Um(g.s(obj));
            }
            if (bi.oN(uzVar.mBr)) {
                uzVar.Ui(j.bm(uzVar.toString(), i));
            }
            uzVar.fy((long) wXMediaMessage.thumbData.length);
            com.tencent.mm.a.e.d(j.i(uzVar), wXMediaMessage.thumbData);
            return;
        }
        uzVar.lA(true);
    }

    private o.a a(final WXMediaMessage wXMediaMessage) {
        return new o.a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    FavOpenApiEntry.b(FavOpenApiEntry.this, wXMediaMessage);
                    ReportUtil.a(FavOpenApiEntry.this, ReportUtil.b(FavOpenApiEntry.this.getIntent().getExtras(), 0));
                    return;
                }
                FavOpenApiEntry.this.finish();
                ReportUtil.a(FavOpenApiEntry.this, ReportUtil.b(FavOpenApiEntry.this.getIntent().getExtras(), -2));
            }
        };
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
