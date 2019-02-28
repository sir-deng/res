package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Random;

public final class e implements o {
    final b nGs;
    private long nGt;

    public e(b bVar) {
        this.nGs = bVar;
        f.aAK();
        c.a(this);
    }

    public final boolean fR(boolean z) {
        boolean z2;
        a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", this.nGs.toString());
        b bVar = this.nGs;
        if (bVar.nGR.intValue() > 4 || bVar.nGR.intValue() <= 0) {
            x.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", bVar.nGR, Integer.valueOf(1), Integer.valueOf(4));
            g.pWK.a(614, 24, 1, false);
            z2 = false;
        } else {
            if (bVar.aTp()) {
                if (TextUtils.isEmpty(bVar.nGX)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                    g.pWK.a(614, 25, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.nGV)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                    g.pWK.a(614, 26, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.nGW)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                    g.pWK.a(614, 27, 1, false);
                    z2 = false;
                }
            }
            z2 = true;
        }
        if (z2) {
            int i;
            if (this.nGs.nGR.intValue() == 3) {
                i = 1;
            } else {
                z2 = false;
            }
            if (i != 0) {
                final Context context = ad.getContext();
                final com.tencent.tinker.lib.e.a ir = com.tencent.tinker.lib.e.a.ir(context);
                if (ir.ArT) {
                    a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
                    n nVar = new n(ad.getContext(), new n.a() {
                        public final void bQ(boolean z) {
                            if (!z) {
                                a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
                                ShareTinkerInternals.iJ(context);
                                ir.aTl();
                                Process.killProcess(Process.myPid());
                            }
                        }
                    });
                    SharePatchInfo.a(ir.ArP, new SharePatchInfo(ir.ArS.ArX, "00000000000000000000000000000000", Build.FINGERPRINT, "odex"), ir.ArQ);
                } else {
                    a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
                }
                return true;
            } else if (!this.nGs.aTp()) {
                return true;
            } else {
                a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", this.nGs.nGU, this.nGs.aTr());
                final Context context2 = ad.getContext();
                if (this.nGs.nGU.intValue() == 2 && ao.isMobile(ad.getContext()) && this.nGs.aTq()) {
                    if (com.tencent.mm.plugin.hp.tinker.g.ag(context2, this.nGs.nGX)) {
                        g.pWK.a(614, 44, 1, false);
                        x.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", this.nGs.nGX);
                    } else {
                        if (this.nGs.nGT.intValue() == 2) {
                            i.a(ad.getContext().getString(R.l.ejC), ad.getContext().getString(R.l.ejE, new Object[]{this.nGs.aTr(), ad.getContext().getString(R.l.eSo), bi.by((long) this.nGs.fileSize)}), ad.getContext().getString(R.l.eSs), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (e.this.nGs.aTo()) {
                                        e.this.fS(true);
                                    }
                                }
                            }, ad.getContext().getString(R.l.eSg), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.plugin.hp.tinker.g.ah(context2, e.this.nGs.nGX);
                                }
                            });
                        } else if (this.nGs.nGT.intValue() == 3) {
                            String string;
                            x.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                            if (bi.oN(this.nGs.aTr())) {
                                string = context2.getString(R.l.eSu);
                            } else {
                                string = this.nGs.aTr();
                            }
                            bpe bpe = new bpe();
                            bpe.nGX = this.nGs.nGX;
                            bpe.title = context2.getString(R.l.ejC);
                            bpe.wYw = context2.getString(R.l.eSs);
                            bpe.nBJ = context2.getString(R.l.eSg);
                            bpe.nGY = this.nGs.nGY;
                            bpe.nGZ = this.nGs.nGZ;
                            bpe.jOx = this.nGs.fileSize;
                            bpe.nGV = this.nGs.nGV;
                            bpe.feB = this.nGs.nGW;
                            bpe.versionCode = this.nGs.versionCode;
                            bpe.wYv = p.Su(this.nGs.nGY);
                            bpe.fpV = string;
                            p.a(bpe);
                        }
                        a.ry(4);
                    }
                } else if (this.nGs.aTo() && !com.tencent.mm.plugin.hp.tinker.g.ag(context2, this.nGs.nGX)) {
                    fS(z);
                }
                return true;
            }
        }
        a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
        return false;
    }

    final void fS(boolean z) {
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("Tinker.SyncResponseProcessor", "no sdcard.");
            g.pWK.a(614, 50, 1, false);
        } else if (!com.tencent.mm.compatible.util.f.aD((long) this.nGs.fileSize)) {
            x.e("Tinker.SyncResponseProcessor", "sdcard is full.");
            g.pWK.a(614, 51, 1, false);
            if (this.nGs.nGT.intValue() == 3) {
                g.pWK.a(614, 55, 1, false);
            }
        } else if (this.nGs.nGT.intValue() == 3 && !bi.oN(this.nGs.nGY) && com.tencent.mm.a.e.bO(p.Su(this.nGs.nGY)) && com.tencent.mm.c.a.ch(p.Su(this.nGs.nGY))) {
            String string;
            Context context = ad.getContext();
            if (bi.oN(this.nGs.aTr())) {
                string = context.getString(R.l.eSu);
            } else {
                string = this.nGs.aTr();
            }
            bpe bpe = new bpe();
            bpe.nGX = this.nGs.nGX;
            bpe.title = context.getString(R.l.ejC);
            bpe.wYw = context.getString(R.l.epL);
            bpe.nBJ = context.getString(R.l.eSg);
            bpe.nGY = this.nGs.nGY;
            bpe.nGZ = this.nGs.nGZ;
            bpe.jOx = this.nGs.fileSize;
            bpe.nGV = this.nGs.nGV;
            bpe.feB = this.nGs.nGW;
            bpe.versionCode = this.nGs.versionCode;
            bpe.wYv = p.Su(this.nGs.nGY);
            bpe.fpV = string;
            p.a(bpe);
            x.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", this.nGs.nGY);
        } else if (this.nGs.nGT.intValue() == 2) {
            aTh();
        } else if (z) {
            aTh();
            com.tencent.mm.plugin.hp.tinker.g.g(ad.getContext(), 0);
            g.pWK.a(76, 1, 1, false);
        } else {
            int i = this.nGs.fileSize / this.nGs.nHb;
            int nextInt = new Random().nextInt(this.nGs.nHd);
            x.i("Tinker.SyncResponseProcessor", "delay download time:%s time count:%s randonStart:%s", Integer.valueOf(i), Integer.valueOf(r1), Integer.valueOf(nextInt));
            g.pWK.a(794, (long) nextInt, 1, false);
            if (nextInt == 0) {
                aTh();
                g.pWK.a(76, 1, 1, false);
            }
            com.tencent.mm.plugin.hp.tinker.g.g(ad.getContext(), System.currentTimeMillis() + ((long) ((i * nextInt) * 1000)));
        }
    }

    private void aTh() {
        p.bZS();
        p.bZT();
        com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar.yr(this.nGs.nGV);
        aVar.yt(this.nGs.nGX);
        aVar.yu(this.nGs.nGW);
        aVar.et(false);
        aVar.ev(true);
        aVar.oP(2);
        aVar.eu(false);
        this.nGt = f.aAK().a(aVar.lyp);
        x.i("Tinker.SyncResponseProcessor", "Download task id is :%d", Long.valueOf(this.nGt));
        g.pWK.a(614, 2, 1, false);
        if (ao.isWifi(ad.getContext())) {
            g.pWK.a(614, 7, 1, false);
        } else {
            g.pWK.a(614, 8, 1, false);
        }
        if (this.nGs.nGT.intValue() == 3) {
            g.pWK.a(614, 56, 1, false);
            x.d("Tinker.SyncResponseProcessor", "boots download start silent.");
        }
    }

    public final void onTaskStarted(long j, String str) {
        x.d("Tinker.SyncResponseProcessor", "onTaskStarted");
    }

    public final void c(long j, String str, boolean z) {
        x.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", Long.valueOf(j), str, Boolean.valueOf(z));
        if (this.nGt != j) {
            x.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.nGt), Long.valueOf(j));
            return;
        }
        b.rA(2);
        Context context = ad.getContext();
        File file = new File(str);
        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
        if (this.nGs.nGT.intValue() != 2 || shareSecurityCheck.ak(file)) {
            File file2;
            String absolutePath;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                file2 = null;
            } else {
                file2 = new File(applicationInfo.dataDir, "tinker_server");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    String name = file.getName();
                    for (File file3 : listFiles) {
                        if (!file3.getName().equals(name)) {
                            SharePatchFileUtil.ag(file3);
                        }
                    }
                }
            }
            switch (this.nGs.nGT.intValue()) {
                case 1:
                    x.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                    com.tencent.tinker.lib.e.c.bU(context, file.getAbsolutePath());
                    break;
                case 3:
                    absolutePath = file.getAbsolutePath();
                    b bVar = this.nGs;
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", absolutePath, bVar.nGY);
                    as.Dt().F(new com.tencent.mm.plugin.hp.a.a.AnonymousClass1(p.Su(bVar.nGY), context, absolutePath, bVar));
                    break;
            }
            b bVar2 = this.nGs;
            if (bVar2.aTq()) {
                absolutePath = b.a(bVar2.nGS, 2);
            } else {
                absolutePath = "";
            }
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", absolutePath).apply();
        } else {
            a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
            b.rB(2);
            g.pWK.a(614, 31, 1, false);
            if (this.nGs.nGT.intValue() == 3) {
                g.pWK.a(614, 54, 1, false);
                x.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
            }
        }
        f.aAK();
        c.b(this);
    }

    public final void c(long j, int i, boolean z) {
        x.w("Tinker.SyncResponseProcessor", "onTaskFailed");
        if (this.nGt != j) {
            x.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.nGt), Long.valueOf(j));
            return;
        }
        b.rB(2);
        if (this.nGs.nGT.intValue() == 3) {
            g.pWK.a(614, 51, 1, false);
        }
        f.aAK();
        c.b(this);
    }

    public final void onTaskRemoved(long j) {
        x.i("Tinker.SyncResponseProcessor", "onTaskRemoved");
        f.aAK();
        c.b(this);
    }

    public final void onTaskPaused(long j) {
        x.d("Tinker.SyncResponseProcessor", "onTaskPaused");
    }

    public final void cl(long j) {
        x.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged");
    }

    public final void k(long j, String str) {
        x.d("Tinker.SyncResponseProcessor", "onTaskResumed");
    }
}
