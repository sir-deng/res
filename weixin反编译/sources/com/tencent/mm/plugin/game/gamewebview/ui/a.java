package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private String lang = w.eM(ad.getContext());
    boolean ndR;
    private String ndS;
    private String ndT;
    private String ndU;
    private String ndV;
    private String ndW;
    private String ndX;

    public a(Bundle bundle) {
        this.ndR = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.ndS = bundle.getString("close_window_confirm_dialog_title_cn");
        this.ndT = bundle.getString("close_window_confirm_dialog_title_eng");
        this.ndU = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.ndV = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.ndW = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.ndX = bundle.getString("close_window_confirm_dialog_cancel_eng");
    }

    public final String aPz() {
        if ("zh_CN".equals(this.lang)) {
            return this.ndS;
        }
        return this.ndT;
    }

    public final String aPA() {
        if ("zh_CN".equals(this.lang)) {
            return this.ndU;
        }
        return this.ndV;
    }

    public final String aPB() {
        if ("zh_CN".equals(this.lang)) {
            return this.ndW;
        }
        return this.ndX;
    }
}
