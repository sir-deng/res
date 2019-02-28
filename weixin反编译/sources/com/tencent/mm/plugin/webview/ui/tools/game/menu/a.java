package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.mm.R;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final List<arl> tMj = new LinkedList();

    static {
        arl arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emS);
        arl.phv = "game_menu_icon_share_to_friend";
        arl.wGa = 1;
        arl.wFZ = 1;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_SHARE_TO_FRIEND.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emQ);
        arl.phv = "game_menu_icon_exit";
        arl.wGa = 2;
        arl.wFZ = 2;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_EXIT.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emU);
        arl.phv = "game_menu_icon_stick_on";
        arl.wGa = 3;
        arl.wFZ = 3;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_STICK_ON.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emT);
        arl.phv = "game_menu_icon_stick_off";
        arl.wGa = 3;
        arl.wFZ = 4;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_STICK_OFF.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emR);
        arl.phv = "game_menu_icon_refresh";
        arl.wGa = 4;
        arl.wFZ = 5;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_REFRESH.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emO);
        arl.phv = "game_menu_icon_collect";
        arl.wGa = 5;
        arl.wFZ = 6;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_COLLECT.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emP);
        arl.phv = "game_menu_icon_complaint";
        arl.wGa = 6;
        arl.wFZ = 7;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_COMPLAINT.code;
        tMj.add(arl);
        arl = new arl();
        arl.fpg = ad.getResources().getString(R.l.emN);
        arl.phv = "game_menu_icon_add_to_desktop";
        arl.wGa = 7;
        arl.wFZ = 8;
        arl.wnV = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_ADD_TO_DESKTOP.code;
        tMj.add(arl);
    }
}
