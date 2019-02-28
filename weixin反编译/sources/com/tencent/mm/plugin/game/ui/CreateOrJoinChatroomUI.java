package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.plugin.game.c.ac;
import com.tencent.mm.plugin.game.c.ad;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private ProgressDialog laU = null;
    private String mAppId;
    private String mPackageName;
    private String nqT;
    private String nqU;
    private String nqV;
    private String nqW;
    private String nqX;
    private int nqY = 1;
    private String vz;

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI, String str) {
        Intent intent = new Intent();
        String l = g.l(createOrJoinChatroomUI, createOrJoinChatroomUI.mAppId);
        intent.putExtra("action", createOrJoinChatroomUI.vz);
        intent.putExtra("app_name", l);
        intent.putExtra("rawUrl", str);
        d.b(createOrJoinChatroomUI, "webview", ".ui.tools.game.GameChattingRoomWebViewUI", intent, 5);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        x.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.vz = intent.getStringExtra("action");
        this.mPackageName = intent.getStringExtra("package_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        this.nqT = intent.getStringExtra("key_transaction");
        this.nqU = intent.getStringExtra("group_id");
        this.nqV = intent.getStringExtra("chatroom_name");
        this.nqW = intent.getStringExtra("chatroom_nickname");
        this.nqX = intent.getStringExtra("ext_msg");
        if (bi.oN(this.vz) || bi.oN(this.mAppId) || bi.oN(this.nqU)) {
            x.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            return;
        }
        this.laU = h.a((Context) this, getBaseContext().getString(R.l.eSY), true, null);
        b.a aVar;
        b Kf;
        if (this.vz.equals("action_create")) {
            x.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", this.mAppId, this.nqU, this.nqV);
            aVar = new b.a();
            aVar.hnT = new ac();
            aVar.hnU = new ad();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.hnS = 1205;
            Kf = aVar.Kf();
            ac acVar = (ac) Kf.hnQ.hnY;
            acVar.nkU = this.mAppId;
            acVar.nme = this.nqU;
            acVar.nmf = new com.tencent.mm.bp.b(this.nqV == null ? new byte[0] : this.nqV.getBytes());
            acVar.nmg = new com.tencent.mm.bp.b(this.nqW == null ? new byte[0] : this.nqW.getBytes());
            u.a(Kf, new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    ad adVar = (ad) bVar.hnR.hnY;
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", adVar.nmh);
                        CreateOrJoinChatroomUI.this.aRW();
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, r0);
                    } else {
                        x.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 4) {
                            CreateOrJoinChatroomUI.this.rh(adVar.lUc);
                        } else {
                            CreateOrJoinChatroomUI.this.rh(-1);
                        }
                        CreateOrJoinChatroomUI.this.aRW();
                        CreateOrJoinChatroomUI.this.finish();
                    }
                    return 0;
                }
            });
        } else if (this.vz.equals("action_join")) {
            aVar = new b.a();
            aVar.hnT = new at();
            aVar.hnU = new au();
            aVar.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar.hnS = 1206;
            Kf = aVar.Kf();
            at atVar = (at) Kf.hnQ.hnY;
            atVar.nkU = this.mAppId;
            atVar.nme = this.nqU;
            atVar.nmg = new com.tencent.mm.bp.b(this.nqW == null ? new byte[0] : this.nqW.getBytes());
            u.a(Kf, new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    au auVar = (au) bVar.hnR.hnY;
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", auVar.nmX);
                        CreateOrJoinChatroomUI.this.aRW();
                        CreateOrJoinChatroomUI.a(CreateOrJoinChatroomUI.this, r0);
                    } else {
                        x.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 4) {
                            CreateOrJoinChatroomUI.this.rh(auVar.lUc);
                        } else {
                            CreateOrJoinChatroomUI.this.rh(-1);
                        }
                        CreateOrJoinChatroomUI.this.aRW();
                        CreateOrJoinChatroomUI.this.finish();
                    }
                    return 0;
                }
            });
        }
    }

    protected void onDestroy() {
        aRW();
        super.onDestroy();
    }

    private void aRW() {
        if (this.laU != null && this.laU.isShowing()) {
            this.laU.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5) {
            if (i2 == 4) {
                rh(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    q.a.vjg.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                rh(-2);
            }
        }
        finish();
    }

    private void rh(int i) {
        f aZ = g.aZ(this.mAppId, true);
        Bundle bundle = new Bundle();
        if (this.vz.equals("action_create")) {
            Resp resp = new Resp();
            if (aZ != null) {
                resp.openId = aZ.field_openId;
            }
            resp.transaction = this.nqT;
            resp.extMsg = this.nqX;
            resp.errCode = i;
            resp.toBundle(bundle);
        } else if (this.vz.equals("action_join")) {
            JoinChatroom.Resp resp2 = new JoinChatroom.Resp();
            if (aZ != null) {
                resp2.openId = aZ.field_openId;
            }
            resp2.transaction = this.nqT;
            resp2.extMsg = this.nqX;
            resp2.errCode = i;
            resp2.toBundle(bundle);
        }
        Args args = new Args();
        args.targetPkgName = this.mPackageName;
        args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(com.tencent.mm.sdk.platformtools.ad.getContext(), args);
    }
}
