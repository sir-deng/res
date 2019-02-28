package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;

public abstract class d implements OnClickListener {
    protected long jfS = -1;
    protected Context mContext;
    protected int mStatus = -1;
    protected com.tencent.mm.plugin.game.model.d nhC = null;
    protected int niV;
    protected String nqK;
    protected FileDownloadTaskInfo nqL;
    protected a nqM;
    protected String nqN;
    protected String nqO;
    protected String nqP;
    private String nqQ = "xiaomi";

    public d(Context context) {
        this.mContext = context;
    }

    public final void rg(int i) {
        this.niV = i;
    }

    protected final void aRT() {
        q.e(this.mContext, Uri.fromFile(new File(this.nqL.path)));
    }

    protected final void aRU() {
        g.Y(this.mContext, this.nhC.field_appId);
    }

    protected final void fH(final boolean z) {
        if (ao.isNetworkConnected(this.mContext)) {
            as.Hm();
            if (!c.isSDCardAvailable()) {
                Toast.makeText(this.mContext, this.mContext.getString(R.l.emw), 0).show();
                n.aQN();
                n.a(this.nhC.field_appId, com.tencent.mm.plugin.downloader.model.d.lxN, false, null);
                return;
            } else if (f.aD(this.nhC.ngT)) {
                if (com.tencent.mm.protocal.d.vHe.toLowerCase().contains(this.nqQ)) {
                    try {
                        if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !this.mContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false)) {
                            h.a(this.mContext, R.l.enq, R.l.enr, R.l.eny, R.l.dEy, false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    d.this.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
                                    dialogInterface.cancel();
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            this.mContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
                        }
                    } catch (SettingNotFoundException e) {
                        x.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", e.getMessage());
                    }
                }
                if (bi.oN(this.nhC.fRx) || bi.oN(this.nhC.fRC)) {
                    x.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                    if (bi.oN(this.nhC.fRD)) {
                        x.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                    } else {
                        boolean aY = q.aY(this.mContext, this.nhC.fRD);
                        x.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", Boolean.valueOf(aY));
                    }
                    if (bi.oN(this.nhC.fRx)) {
                        n.aQN();
                        n.a(this.nhC.field_appId, com.tencent.mm.plugin.downloader.model.d.DOWNLOAD_ERR_URL_INVALID, false, null);
                    }
                    if (bi.oN(this.nhC.fRC)) {
                        n.aQN();
                        n.a(this.nhC.field_appId, com.tencent.mm.plugin.downloader.model.d.lxK, false, null);
                        return;
                    }
                    return;
                }
                ap.a(this.mContext, this.nhC.scene, this.nhC.fGe, this.nhC.position, 4, this.nhC.field_appId, this.niV, this.nhC.fpi, this.nqO);
                if (ao.isWifi(this.mContext)) {
                    fI(z);
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(14217, this.nhC.field_appId, Integer.valueOf(4), "", this.nhC.fRx, Integer.valueOf(2));
                h.a(this.mContext, this.mContext.getString(R.l.eWR), this.mContext.getString(R.l.eWS), this.mContext.getString(R.l.eWM), this.mContext.getString(R.l.dEy), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(14217, d.this.nhC.field_appId, Integer.valueOf(5), "", d.this.nhC.fRx, Integer.valueOf(2));
                        d.this.fI(z);
                        dialogInterface.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(14217, d.this.nhC.field_appId, Integer.valueOf(6), "", d.this.nhC.fRx, Integer.valueOf(2));
                        dialogInterface.dismiss();
                        x.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
                    }
                }, R.e.buj);
                return;
            } else {
                Toast.makeText(this.mContext, this.mContext.getString(R.l.emv), 0).show();
                n.aQN();
                n.a(this.nhC.field_appId, com.tencent.mm.plugin.downloader.model.d.lxN, false, null);
                return;
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(R.l.emu), 0).show();
        n.aQN();
        n.a(this.nhC.field_appId, com.tencent.mm.plugin.downloader.model.d.lxM, false, null);
    }

    private void fI(boolean z) {
        long a;
        if (z) {
            n.a(this.nhC.fRx, this.nhC.fRC, this.nhC.fGe, this.nhC.field_appId, this.nqN, "app_update");
        } else {
            n.a(this.nhC.fRx, this.nhC.fRC, this.nhC.fGe, this.nhC.field_appId, this.nqN, this.nqP);
        }
        com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar.yr(this.nhC.fRx);
        aVar.ys(this.nhC.ngS);
        aVar.cj(this.nhC.ngT);
        aVar.yt(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, this.nhC, null));
        aVar.setAppId(this.nhC.field_appId);
        aVar.yu(this.nhC.fRC);
        aVar.et(true);
        aVar.oP(1);
        aVar.cu(this.nhC.field_packageName);
        aVar.lO(this.nhC.fGe);
        if (this.nhC.fxC == 1) {
            com.tencent.mm.plugin.downloader.model.f aAK = com.tencent.mm.plugin.downloader.model.f.aAK();
            com.tencent.mm.plugin.downloader.model.g gVar = aVar.lyp;
            x.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", gVar.mAppId);
            if (com.tencent.mm.kernel.g.Do().CF()) {
                com.tencent.mm.kernel.g.Do();
                if (!com.tencent.mm.kernel.a.Cz()) {
                    a = aAK.aAO().a(gVar);
                }
            }
            a = aAK.aAM().a(gVar);
            if (a >= 0) {
                com.tencent.mm.plugin.downloader.model.f.lxS.put(Long.valueOf(a), Long.valueOf(0));
                ad.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
                x.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            } else {
                x.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
                aAK.aAN().a(gVar);
            }
        } else {
            a = com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp);
        }
        x.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(a), this.nhC.field_appId, Integer.valueOf(this.nhC.fxC));
        g.Z(this.mContext, this.nhC.field_appId);
    }

    protected final void aRV() {
        this.nqM = e.yk(this.nhC.field_appId);
        this.nqL = com.tencent.mm.plugin.downloader.model.f.aAK().yo(this.nhC.field_appId);
        this.jfS = this.nqL.id;
        this.mStatus = this.nqL.status;
        this.nqK = this.nqL.path;
    }
}
