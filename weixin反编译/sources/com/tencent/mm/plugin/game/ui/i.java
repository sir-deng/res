package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

public final class i extends d {
    public i(Context context) {
        super(context);
    }

    public final void cU(String str, String str2) {
        this.nqO = str;
        this.nqP = str2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            boolean z;
            this.nhC = (d) view.getTag();
            x.i("MicsoMsg.GameClickListener", "Clicked appid = " + this.nhC.field_appId);
            aRV();
            if (this.nqL == null || !this.nqL.lyv) {
                z = false;
            } else {
                this.nqL.lyv = false;
                if (this.nqM != null) {
                    this.nqM.field_autoInstall = true;
                    this.nqM.field_showNotification = true;
                    this.nqM.field_autoDownload = false;
                    e.c(this.nqM);
                }
                z = true;
            }
            if (g.m(this.mContext, this.nhC.field_appId)) {
                int i;
                int i2;
                if (this.nhC instanceof d) {
                    int CQ = c.CQ(this.nhC.field_packageName);
                    i = this.nhC.versionCode;
                    i2 = CQ;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    x.i("MicsoMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", this.nhC.field_appId, Integer.valueOf(i2), Integer.valueOf(i));
                    n.a(this.nhC.fRx, this.nhC.fRC, this.nhC.fGe, this.nhC.field_appId, this.nqN, "app_update");
                    if (this.nqL.status == 1) {
                        if (!z) {
                            x.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + f.aAK().ca(this.nqL.id));
                            return;
                        }
                        return;
                    } else if (this.nqL.status == 2) {
                        if (f.aAK().cb(this.nqL.id)) {
                            com.tencent.mm.plugin.game.model.g.Z(this.mContext, this.nhC.field_appId);
                            ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 4, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
                            return;
                        }
                        x.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
                        fH(true);
                        return;
                    } else if (this.nqL.status != 3) {
                        fH(true);
                        return;
                    } else if (!com.tencent.mm.a.e.bO(this.nqL.path) || c.CR(this.nqL.path) <= i2) {
                        fH(true);
                        return;
                    } else {
                        q.e(this.mContext, Uri.fromFile(new File(this.nqL.path)));
                        ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 8, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
                        return;
                    }
                }
                x.i("MicsoMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", this.nhC.field_appId, this.nhC.field_packageName, this.nhC.field_openId);
                ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 3, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
                aRU();
                return;
            } else if (this.nhC.aQA()) {
                c.p(this.mContext, this.nhC.ngU.noF, "game_center_hv_game");
                ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 29, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
                return;
            } else {
                n.a(this.nhC.fRx, this.nhC.fRC, this.nhC.fGe, this.nhC.field_appId, this.nqN, this.nqP);
                switch (this.mStatus) {
                    case 1:
                        if (!z) {
                            x.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + f.aAK().ca(this.nqL.id));
                            return;
                        }
                        return;
                    case 2:
                        if (!ao.isNetworkConnected(this.mContext)) {
                            Toast.makeText(this.mContext, this.mContext.getString(R.l.emu), 0).show();
                            return;
                        } else if (ao.isWifi(this.mContext)) {
                            aSe();
                            return;
                        } else {
                            h.a(this.mContext, this.mContext.getString(R.l.eWR), this.mContext.getString(R.l.eWS), this.mContext.getString(R.l.eWM), this.mContext.getString(R.l.dEy), false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    i.this.aSe();
                                    dialogInterface.dismiss();
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    x.i("MicsoMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
                                }
                            }, R.e.buj);
                            return;
                        }
                    case 3:
                        if (!bi.oN(this.nqK) && com.tencent.mm.a.e.bO(this.nqK) && c.cV(this.nqK, this.nqM.field_md5)) {
                            aRT();
                            ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 8, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
                            return;
                        }
                        fH(false);
                        return;
                    default:
                        fH(false);
                        return;
                }
            }
        }
        x.e("MicsoMsg.GameClickListener", "No AppInfo");
    }

    private void aSe() {
        if (f.aAK().cb(this.nqM.field_downloadId)) {
            com.tencent.mm.plugin.game.model.g.Z(this.mContext, this.nhC.field_appId);
            ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 4, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
            return;
        }
        x.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
        f.aAK().bY(this.nqM.field_downloadId);
        fH(false);
    }
}
