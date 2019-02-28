package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.j.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.AddShortcutTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameKeepPageTopTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public class i {
    public static b nfQ = new b() {
        public final void aQv() {
            GWMainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            GameWebViewMainProcessService.a(favUrlTask);
        }
    };
    private boolean mEnable = false;
    protected GameWebViewUI nef;
    private a nfM;
    public HashSet<Integer> nfN = new HashSet();
    public Map<String, Integer> nfO = new HashMap();
    public HashSet<Integer> nfP = new HashSet();
    protected b nfy;

    /* renamed from: com.tencent.mm.plugin.game.gamewebview.ui.i$4 */
    class AnonymousClass4 implements c {
        final /* synthetic */ Boolean nfS;
        final /* synthetic */ ArrayList nfT = null;

        AnonymousClass4(Boolean bool, ArrayList arrayList) {
            this.nfS = bool;
        }

        public final void a(n nVar) {
            g.pWK.a(480, 0, 1, false);
            if (this.nfS.booleanValue()) {
                int size = this.nfT.size();
                for (int i = 0; i < size; i++) {
                    d.b bVar = (d.b) this.nfT.get(i);
                    o oVar = (o) nVar.f(bVar.id, bVar.title);
                    oVar.ykK = bVar;
                    oVar.setIcon(null);
                    oVar.setIcon(0);
                }
                return;
            }
            if (i.this.nfy.nco.go(21) && i.a(i.this, 1)) {
                nVar.a(1, i.this.nef.getString(R.l.eBX), R.k.dxb);
            }
            if (i.this.nfy.nco.go(23) && i.a(i.this, 2)) {
                nVar.a(2, i.this.nef.getString(R.l.eBY), R.k.dwQ);
            }
            boolean z = i.this.getBundle().getBoolean("is_favorite_item", false);
            if (!z && i.aQu() && i.a(i.this, 3)) {
                nVar.a(3, i.this.nef.getString(R.l.eAq), R.k.dwJ);
            }
            nVar.a(31, i.this.nef.getString(R.l.eYO), R.k.dwZ);
            if (i.this.nfy.nco.go(44) && i.a(i.this, 6)) {
                nVar.a(6, i.this.nef.getString(R.l.eYl), R.k.dwD);
            }
            boolean z2 = i.this.getBundle().getBoolean("key_detail_can_delete", true);
            if (z && z2 && i.aQu()) {
                if (i.a(i.this, 12)) {
                    nVar.a(12, i.this.nef.getString(R.l.eeS), R.k.dwy);
                }
                if (i.a(i.this, 9)) {
                    nVar.a(9, i.this.nef.getString(R.l.dEH), R.k.dwE);
                }
            }
            if (i.this.Vi()) {
                if (i.a(i.this, 32)) {
                    nVar.a(32, i.this.nef.getString(R.l.eBZ), R.k.dxc);
                }
            } else if (i.a(i.this, 30)) {
                nVar.a(30, i.this.nef.getString(R.l.eCe), R.k.dxd);
            }
            if (i.this.nfy.nco.go(45) && i.a(i.this, 7)) {
                nVar.a(7, i.this.nef.getString(R.l.eYq), R.k.dwB);
            }
            if (i.a(i.this, 28)) {
                nVar.a(28, i.this.nef.getString(R.l.eWK), R.k.dwX);
            }
            if (i.this.nfy.nco.jJy) {
                nVar.a(27, i.this.nef.getString(R.l.eCd), R.k.dwI);
            }
            String aPS = i.this.nfy.nco.aPS();
            String string = i.this.getBundle().getString("shortcut_user_name");
            if (!(i.this.getBundle().getBoolean("from_shortcut", false) || bi.oN(aPS) || bi.oN(string) || !i.this.nfy.nco.go(255) || !i.a(i.this, 29))) {
                nVar.a(29, i.this.nef.getString(R.l.eBV), R.k.dBS);
            }
            nVar.a(10, i.this.nef.getString(R.l.dMw), R.k.dwC);
        }
    }

    static /* synthetic */ void a(i iVar) {
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", iVar.getBundle().getLong("fav_local_id", -1));
        com.tencent.mm.bl.d.b(iVar.nef, "favorite", ".ui.FavTagEditUI", intent);
    }

    static /* synthetic */ boolean a(i iVar, int i) {
        return !iVar.nfN.contains(Integer.valueOf(i));
    }

    static /* synthetic */ boolean aQu() {
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        GameWebViewMainProcessService.b(favUrlTask);
        return favUrlTask.ndq;
    }

    static /* synthetic */ boolean h(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    public i(b bVar) {
        this.nfy = bVar;
        this.nef = (GameWebViewUI) bVar.getContext();
        this.nfO.clear();
        this.nfO.put("menuItem:share:brand", Integer.valueOf(0));
        this.nfO.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.nfO.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.nfO.put("menuItem:share:timeline", Integer.valueOf(2));
        this.nfO.put("menuItem:favorite", Integer.valueOf(3));
        this.nfO.put("menuItem:profile", Integer.valueOf(5));
        this.nfO.put("menuItem:addContact", Integer.valueOf(5));
        this.nfO.put("menuItem:copyUrl", Integer.valueOf(6));
        this.nfO.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.nfO.put("menuItem:share:email", Integer.valueOf(8));
        this.nfO.put("menuItem:delete", Integer.valueOf(9));
        this.nfO.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.nfO.put("menuItem:setFont", Integer.valueOf(11));
        this.nfO.put("menuItem:editTag", Integer.valueOf(12));
        this.nfO.put("menuItem:readMode", Integer.valueOf(14));
        this.nfO.put("menuItem:originPage", Integer.valueOf(14));
        this.nfO.put("menuItem:share:qq", Integer.valueOf(20));
        this.nfO.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.nfO.put("menuItem:share:QZone", Integer.valueOf(22));
        this.nfO.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.nfO.put("menuItem:refresh", Integer.valueOf(28));
        this.nfO.put("menuItem:share:wework", Integer.valueOf(25));
        this.nfO.put("menuItem:share:weread", Integer.valueOf(26));
        this.nfO.put("menuItem:keepTop", Integer.valueOf(30));
        this.nfO.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.nfO.put("menuItem:addShortcut", Integer.valueOf(29));
        this.nfO.put("menuItem:search", Integer.valueOf(31));
        this.nfP.clear();
        this.nfP.add(Integer.valueOf(28));
        this.nfP.add(Integer.valueOf(6));
        this.nfP.add(Integer.valueOf(27));
        this.nfP.add(Integer.valueOf(30));
        this.nfP.add(Integer.valueOf(32));
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.nfM == null || !a.b(this.nef, i, i2, intent)) {
            return false;
        }
        return true;
    }

    public void aQg() {
        com.tencent.mm.ui.widget.g gVar;
        Boolean valueOf = Boolean.valueOf(false);
        if (valueOf.booleanValue()) {
            gVar = new com.tencent.mm.ui.widget.g(this.nef, com.tencent.mm.ui.widget.g.zCt, false);
        } else {
            gVar = new com.tencent.mm.ui.widget.g(this.nef, com.tencent.mm.ui.widget.g.zCs, true);
        }
        gVar.zux = new p.a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                if (i.h(menuItem)) {
                    imageView.setVisibility(8);
                }
            }
        };
        gVar.zuy = new p.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                CharSequence charSequence = menuItem.getTitle();
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (!i.this.nef.isFinishing() && !i.this.nef.xQV) {
                    if (i.h(menuItem)) {
                        menuItem.getMenuInfo();
                        return;
                    }
                    switch (menuItem.getItemId()) {
                        case 1:
                            i.this.aQk();
                            return;
                        case 2:
                            i.this.aQl();
                            return;
                        case 3:
                            i.this.aQr();
                            return;
                        case 6:
                            i.this.aQm();
                            return;
                        case 7:
                            i.this.aQp();
                            return;
                        case 9:
                            i.this.aQs();
                            return;
                        case 10:
                            i.this.aQt();
                            return;
                        case 12:
                            i.a(i.this);
                            return;
                        case 27:
                            i.this.aQj();
                            return;
                        case 28:
                            i.this.refresh();
                            return;
                        case 29:
                            i.this.aQq();
                            return;
                        case 30:
                            i.this.aQn();
                            return;
                        case 31:
                            i.this.nfy.nco.fC(true);
                            return;
                        case 32:
                            i.this.aQo();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        gVar.rQF = new AnonymousClass4(valueOf, null);
        String aPR = this.nfy.nco.aPR();
        if (!bi.oN(aPR)) {
            if (!bi.oN(Uri.parse(aPR).getHost())) {
                gVar.e(this.nef.getString(R.l.eXn, new Object[]{aPR}), 1);
            }
        }
        if (this.nfy.isFullScreen()) {
            gVar.tMI = true;
            gVar.tMJ = true;
        } else {
            gVar.tMI = false;
            gVar.tMJ = false;
        }
        if (this.nfy.nco.ney.isShown()) {
            this.nfy.nco.fC(false);
            ah.h(new Runnable() {
                public final void run() {
                    gVar.bUX();
                }
            }, 100);
            return;
        }
        this.nef.aWY();
        ah.h(new Runnable() {
            public final void run() {
                gVar.bUX();
            }
        }, 100);
    }

    protected final void aQj() {
        if (!this.nfy.nco.aPV()) {
            this.nfy.aPG();
        }
    }

    protected final void aQk() {
        h.c(this.nfy.nco);
    }

    protected final void aQl() {
        d dVar = this.nfy.nco;
        if (dVar.bs("shareTimeline", 88)) {
            dVar.Cw("shareTimeline");
            dVar.cO("menu:share:timeline", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String RP = dVar.RP();
            jSONObject.put("link", RP);
            jSONObject.put("desc", RP);
            jSONObject.put("title", dVar.getTitle());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        dVar.cP("shareTimeline", jSONObject.toString());
    }

    protected final void aQm() {
        CharSequence RP = this.nfy.nco.RP();
        ClipboardManager clipboardManager = (ClipboardManager) this.nef.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(RP);
                Toast.makeText(this.nef, this.nef.getString(R.l.eYm), 0).show();
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OptionMenuBtnHelp", e, "clip.setText error", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.OptionMenuBtnHelp", "clipboard manager is null");
    }

    protected final void aQn() {
        x.i("MicroMsg.OptionMenuBtnHelp", "doKeepPageTopLogic");
        String string = getBundle().getString("custom_keep_top_url");
        String string2 = getBundle().getString("custom_keep_top_title");
        String string3 = getBundle().getString("shortcut_user_name");
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        if (bi.oN(string2) || bi.oN(string)) {
            gameKeepPageTopTask.url = bi.oM(this.nfy.nco.ndH);
            gameKeepPageTopTask.title = this.nfy.nco.getTitle();
            gameKeepPageTopTask.username = "";
        } else {
            gameKeepPageTopTask.url = string;
            gameKeepPageTopTask.title = string2;
            gameKeepPageTopTask.username = string3;
        }
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        b bVar = this.nfy;
        bVar.neb = true;
        bVar.mEnable = bVar.aPD();
        bVar.nea.b(bVar);
        com.tencent.mm.ui.snackbar.a.h(this.nef, this.nef.getString(R.l.eCf));
    }

    protected final void aQo() {
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        gameKeepPageTopTask.url = "";
        gameKeepPageTopTask.title = "";
        gameKeepPageTopTask.username = "";
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        SwipeBackLayout swipeBackLayout = this.nfy;
        swipeBackLayout.neb = false;
        swipeBackLayout.mEnable = swipeBackLayout.aPD();
        swipeBackLayout.nea.aPH();
        com.tencent.mm.ui.snackbar.a.h(this.nef, this.nef.getString(R.l.eCa));
    }

    protected final boolean Vi() {
        if (this.nfy.aPF() || this.nfy.neb) {
            return true;
        }
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 1;
        GameWebViewMainProcessService.b(gameKeepPageTopTask);
        if (bi.oM(this.nfy.nco.ndH).equals(bi.oM(gameKeepPageTopTask.url))) {
            return true;
        }
        return false;
    }

    protected final void aQp() {
        String RP = this.nfy.nco.RP();
        if (this.nfM == null) {
            this.nfM = new a();
        }
        a.d(this.nef, RP);
    }

    protected final void aQq() {
        String string = getBundle().getString("shortcut_user_name");
        String aPS = this.nfy.nco.aPS();
        if (bi.oN(string) || bi.oN(aPS)) {
            x.e("MicroMsg.OptionMenuBtnHelp", "addShortcut,appid or username is null");
            return;
        }
        final GWMainProcessTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = aPS;
        addShortcutTask.jfW = new Runnable() {
            public final void run() {
                addShortcutTask.afz();
                d dVar = i.this.nfy.nco;
                boolean z = addShortcutTask.success;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", z);
                    dVar.cO("onAddShortcutStatus", jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameWebviewJsLoader", "onGetAddShortcutStatus, e:" + e.getMessage());
                }
                if (addShortcutTask.success) {
                    com.tencent.mm.ui.base.h.a(i.this.nef, R.l.eYi, R.l.dGZ, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } else {
                    Toast.makeText(i.this.nef, i.this.nef.getString(R.l.eYh), 0).show();
                }
            }
        };
        addShortcutTask.afy();
        GameWebViewMainProcessService.a(addShortcutTask);
    }

    protected final void refresh() {
        if (this.nfy.nco.new != null) {
            this.nfy.nco.new.reload();
        }
    }

    protected final void aQr() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getBundle().getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getBundle().getString("sns_local_id"));
        bundle.putInt("news_svr_id", getBundle().getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getBundle().getString("news_svr_tweetid"));
        bundle.putInt("message_index", getBundle().getInt("message_index", 0));
        String oM = bi.oM(this.nfy.nco.ndH);
        bundle.putString("rawUrl", oM);
        String aPR = this.nfy.nco.aPR();
        if (!bi.oN(oM) && oM.endsWith("#rd")) {
            oM = oM.substring(0, oM.length() - 3);
            if (!(bi.oN(aPR) || aPR.startsWith(oM))) {
                bundle.putString("rawUrl", aPR);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bi.oN(aPR) || aPR.startsWith(oM))) {
            bundle.putString("rawUrl", aPR);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        if (getBundle() != null) {
            bundle.putString("preChatName", getBundle().getString("preChatName"));
            bundle.putInt("preMsgIndex", getBundle().getInt("preMsgIndex", 0));
            bundle.putString("prePublishId", getBundle().getString("prePublishId"));
            bundle.putString("preUsername", getBundle().getString("preUsername"));
        }
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.mym = bundle;
        GameWebViewMainProcessService.b(favUrlTask);
        if (favUrlTask.ndp) {
            d dVar = this.nfy.nco;
            GameJsApiSendAppMessage.fNs = 1;
            h.c(dVar);
            x.i("MicroMsg.OptionMenuBtnHelp", "on favorite simple url");
            return;
        }
        com.tencent.mm.pluginsdk.model.c.a(favUrlTask.ret, 35, this.nef, nfQ);
    }

    protected final void aQs() {
        com.tencent.mm.ui.base.h.a(this.nef, this.nef.getString(R.l.dEI), null, null, this.nef.getString(R.l.dEH), new com.tencent.mm.ui.base.h.d() {
            public final void cr(int i, int i2) {
                switch (i2) {
                    case -1:
                        Bundle bundle = new Bundle();
                        bundle.putLong("fav_local_id", i.this.getBundle().getLong("fav_local_id", -1));
                        GWMainProcessTask favUrlTask = new FavUrlTask();
                        favUrlTask.actionType = 4;
                        favUrlTask.mym = bundle;
                        GameWebViewMainProcessService.b(favUrlTask);
                        if (favUrlTask.foB) {
                            x.i("MicroMsg.OptionMenuBtnHelp", "del fav web url ok, finish webview ui");
                            i.this.nef.finish();
                            return;
                        }
                        return;
                    default:
                        x.i("MicroMsg.OptionMenuBtnHelp", "do del cancel");
                        return;
                }
            }
        });
    }

    protected final void aQt() {
        String str = null;
        String string = getBundle().getString("geta8key_username");
        String aPR = this.nfy.nco.aPR();
        Intent intent = new Intent(this.nef, GameWebViewUI.class);
        intent.putExtra("k_username", string);
        intent.putExtra("k_expose_url", aPR);
        intent.putExtra("showShare", false);
        if (bi.oN(aPR)) {
            string = null;
        } else {
            string = Uri.parse(aPR).getHost();
        }
        if (bi.oN(string) || !string.startsWith("mp.weixin.qq.com")) {
            intent.putExtra("k_expose_current_url", aPR);
        } else {
            try {
                string = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{com.tencent.mm.compatible.util.p.encode(aPR, ProtocolPackage.ServerEncoding)});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.OptionMenuBtnHelp", e.getMessage());
                string = null;
            }
            if (string != null) {
                str = string;
            }
        }
        if (bi.oN(str)) {
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
        }
        intent.putExtra("rawUrl", str);
        this.nef.startActivity(intent);
    }

    protected final Bundle getBundle() {
        return this.nfy != null ? this.nfy.vf : new Bundle();
    }
}
