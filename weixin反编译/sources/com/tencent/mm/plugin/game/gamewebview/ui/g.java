package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g extends i {
    private Map<Integer, arl> nfE = new HashMap();

    public g(b bVar) {
        super(bVar);
    }

    public final void aQg() {
        if (bi.oN(getBundle().getString("game_hv_menu_appid"))) {
            super.aQg();
            return;
        }
        final d dVar = new d(this.nef);
        dVar.a(new c() {
            public final void g(MenuItem menuItem) {
                arl arl = (arl) g.this.nfE.get(Integer.valueOf(menuItem.getItemId()));
                if (arl != null) {
                    switch (a.Bq(arl.wnV)) {
                        case HVGAME_MENU_ACTION_JUMP_H5:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", arl.wnW);
                            if (com.tencent.xweb.x5.sdk.d.getTbsVersion(g.this.nef) >= 43114) {
                                com.tencent.mm.bl.d.b(g.this.nef, "game", ".gamewebview.ui.GameWebViewUI", intent);
                                return;
                            } else {
                                com.tencent.mm.bl.d.b(g.this.nef, "webview", ".ui.tools.game.GameWebViewUI", intent);
                                return;
                            }
                        case HVGAME_MENU_ACTION_EXIT:
                            g.this.aQj();
                            return;
                        case HVGAME_MENU_ACTION_SHARE_TO_FRIEND:
                            g.this.aQk();
                            return;
                        case HVGAME_MENU_ACTION_COLLECT:
                            g.this.aQr();
                            return;
                        case HVGAME_MENU_ACTION_STICK_ON:
                            g.this.aQn();
                            return;
                        case HVGAME_MENU_ACTION_STICK_OFF:
                            g.this.aQo();
                            return;
                        case HVGAME_MENU_ACTION_REFRESH:
                            g.this.refresh();
                            return;
                        case HVGAME_MENU_ACTION_ADD_TO_DESKTOP:
                            g.this.aQq();
                            return;
                        case HVGAME_MENU_ACTION_COMPLAINT:
                            g.this.aQt();
                            return;
                        case HVGAME_MENU_ACTION_CUSTOM:
                            Bundle bundle = new Bundle();
                            bundle.putInt("mm_to_client_notify_type", 1);
                            bundle.putString("js_event_name", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                            bundle.putInt("itemId", arl.wFZ);
                            com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        dVar.tMD = new b() {
            public final void a(n nVar) {
                com.tencent.mm.plugin.report.service.g.pWK.a(480, 0, 1, false);
                n b = g.this.aQh();
                if (b != null) {
                    nVar.ykH.addAll(b.ykH);
                }
            }
        };
        if (this.nfy.isFullScreen()) {
            dVar.tMI = true;
            dVar.tMJ = true;
        } else {
            dVar.tMI = false;
            dVar.tMJ = false;
        }
        if (this.nfy.nco.ney.isShown()) {
            this.nfy.nco.fC(false);
            ah.h(new Runnable() {
                public final void run() {
                    if (g.this.nef.isFinishing()) {
                        x.i("MicroMsg.GameWebViewMenuHelp", "tryShow sheet failed, the activity has been destroyed.");
                    } else {
                        dVar.bUX();
                    }
                }
            }, 100);
            return;
        }
        this.nef.aWY();
        ah.h(new Runnable() {
            public final void run() {
                if (g.this.nef.isFinishing()) {
                    x.i("MicroMsg.GameWebViewMenuHelp", "tryShow sheet failed, the activity has been destroyed.");
                } else {
                    dVar.bUX();
                }
            }
        }, 100);
    }

    private n aQh() {
        try {
            List list;
            List list2 = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.tMj;
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.mym.putString("game_hv_menu_appid", getBundle().getString("game_hv_menu_appid"));
            GameWebViewMainProcessService.b(commonLogicTask);
            String string = commonLogicTask.mym.getString("game_hv_menu_pbcache");
            if (!bi.oN(string)) {
                byte[] bytes = string.getBytes("ISO-8859-1");
                akd akd = new akd();
                akd.aH(bytes);
                if (!bi.cC(akd.wxT)) {
                    LinkedList linkedList = akd.wxT;
                    x.i("MicroMsg.GameWebViewMenuHelp", "use net menu data");
                    list = linkedList;
                    this.nfE.clear();
                    for (arl arl : list) {
                        this.nfE.put(Integer.valueOf(arl.wFZ), arl);
                    }
                    return com.tencent.mm.plugin.webview.ui.tools.game.menu.c.bUW().i(list, Vi());
                }
            }
            list = list2;
            this.nfE.clear();
            for (arl arl2 : list) {
                this.nfE.put(Integer.valueOf(arl2.wFZ), arl2);
            }
            return com.tencent.mm.plugin.webview.ui.tools.game.menu.c.bUW().i(list, Vi());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMenuHelp", "get cache hv game menu fail! exception:%s", e.getMessage());
            return null;
        }
    }
}
