package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import com.tinkerboots.sdk.a.a.b;
import java.io.File;

public final class a {
    public static a ADp;
    public final com.tencent.tinker.lib.e.a ADq;
    public final com.tinkerboots.sdk.a.a ADr;
    private final ApplicationLike applicationLike;

    public static class a {
        public com.tencent.tinker.lib.c.a ADu;
        public Class<? extends AbstractResultService> ADv;
        public b ADw;
        public com.tencent.tinker.lib.b.b ArM;
        public c ArN;
        public d ArO;
        public final ApplicationLike applicationLike;
        public final Context context;

        public a(ApplicationLike applicationLike) {
            if (applicationLike == null) {
                throw new TinkerRuntimeException("applicationLike must not be null.");
            }
            this.context = applicationLike.getApplication();
            this.applicationLike = applicationLike;
        }
    }

    public a(Context context, ApplicationLike applicationLike, c cVar, d dVar, com.tencent.tinker.lib.b.b bVar, com.tencent.tinker.lib.c.a aVar, Class<? extends AbstractResultService> cls, b bVar2) {
        com.tinkerboots.sdk.b.b.context = context;
        this.applicationLike = applicationLike;
        this.ADr = com.tinkerboots.sdk.a.a.a(bVar2);
        com.tencent.tinker.lib.e.a.a aVar2 = new com.tencent.tinker.lib.e.a.a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        if (aVar2.status != -1) {
            throw new TinkerRuntimeException("tinkerFlag is already set.");
        }
        aVar2.status = tinkerFlags;
        if (cVar == null) {
            throw new TinkerRuntimeException("loadReporter must not be null.");
        } else if (aVar2.ArN != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        } else {
            aVar2.ArN = cVar;
            if (bVar == null) {
                throw new TinkerRuntimeException("listener must not be null.");
            } else if (aVar2.ArM != null) {
                throw new TinkerRuntimeException("listener is already set.");
            } else {
                aVar2.ArM = bVar;
                if (dVar == null) {
                    throw new TinkerRuntimeException("patchReporter must not be null.");
                } else if (aVar2.ArO != null) {
                    throw new TinkerRuntimeException("patchReporter is already set.");
                } else {
                    aVar2.ArO = dVar;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                    } else if (aVar2.ArW != null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                    } else {
                        aVar2.ArW = valueOf;
                        com.tencent.tinker.lib.e.a cHR = aVar2.cHR();
                        com.tencent.tinker.lib.e.a.a(cHR);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        com.tencent.tinker.lib.e.a.ArK = true;
                        TinkerPatchService.a(aVar, cls);
                        com.tencent.tinker.lib.f.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", Boolean.valueOf(ShareTinkerInternals.Jo(cHR.tinkerFlags)), "1.9.4");
                        if (!ShareTinkerInternals.Jo(cHR.tinkerFlags)) {
                            com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            throw new TinkerRuntimeException("intentResult must not be null.");
                        } else {
                            String act;
                            cHR.ArS = new com.tencent.tinker.lib.e.d();
                            com.tencent.tinker.lib.e.d dVar2 = cHR.ArS;
                            com.tencent.tinker.lib.e.a ir = com.tencent.tinker.lib.e.a.ir(cHR.context);
                            dVar2.Asl = ShareIntentUtil.ar(tinkerResultIntent);
                            dVar2.jNF = ShareIntentUtil.as(tinkerResultIntent);
                            dVar2.Asb = ShareIntentUtil.q(tinkerResultIntent, "intent_patch_system_ota");
                            dVar2.ArY = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_oat_dir");
                            dVar2.Asa = "interpet".equals(dVar2.ArY);
                            boolean z = ir.rYd;
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", Integer.valueOf(dVar2.Asl), ShareTinkerInternals.iK(r2), Boolean.valueOf(z), Boolean.valueOf(dVar2.Asb), Build.FINGERPRINT, dVar2.ArY, Boolean.valueOf(dVar2.Asa));
                            String j = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_old_version");
                            String j2 = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_new_version");
                            File file = ir.ArL;
                            File file2 = ir.ArP;
                            if (!(j == null || j2 == null)) {
                                if (z) {
                                    dVar2.ArX = j2;
                                } else {
                                    dVar2.ArX = j;
                                }
                                com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", j, j2, dVar2.ArX);
                                act = SharePatchFileUtil.act(dVar2.ArX);
                                if (!ShareTinkerInternals.oN(act)) {
                                    dVar2.Asc = new File(file.getAbsolutePath() + "/" + act);
                                    dVar2.Asd = new File(dVar2.Asc.getAbsolutePath(), SharePatchFileUtil.acu(dVar2.ArX));
                                    dVar2.Ase = new File(dVar2.Asc, "dex");
                                    dVar2.Asf = new File(dVar2.Asc, "lib");
                                    dVar2.Asg = new File(dVar2.Asc, "res");
                                    dVar2.Ash = new File(dVar2.Asg, "resources.apk");
                                }
                                dVar2.patchInfo = new SharePatchInfo(j, j2, Build.FINGERPRINT, dVar2.ArY);
                                dVar2.ArZ = !j.equals(j2);
                            }
                            Throwable at = ShareIntentUtil.at(tinkerResultIntent);
                            if (at == null) {
                                switch (dVar2.Asl) {
                                    case -10000:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        throw new TinkerRuntimeException("can't get the right intent return code");
                                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                                        if (dVar2.Ash != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", dVar2.Ash.getAbsolutePath());
                                            ir.ArN.a(dVar2.Ash, 6);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                        throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                                        if (dVar2.Asc != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", dVar2.Ash.getAbsolutePath());
                                            ir.ArN.a(dVar2.Ash, 6, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                                        if (dVar2.Asc != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", dVar2.Asg.getAbsolutePath());
                                            ir.ArN.a(dVar2.Asg, 6, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                    case -19:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        ir.ArN.a(j, j2, file2);
                                        break;
                                    case -18:
                                        act = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_lib_path");
                                        if (act != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", act);
                                            ir.ArN.a(new File(act), 5, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                    case -17:
                                        if (dVar2.Asc != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", dVar2.Asf.getAbsolutePath());
                                            ir.ArN.a(dVar2.Asf, 5, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                    case -16:
                                        ir.ArN.b(2, ShareIntentUtil.au(tinkerResultIntent));
                                        break;
                                    case -15:
                                        ir.ArN.b(1, ShareIntentUtil.au(tinkerResultIntent));
                                        break;
                                    case -13:
                                        act = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_mismatch_dex_path");
                                        if (act != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", act);
                                            ir.ArN.a(new File(act), 3);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                    case -12:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        act = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (act != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", act);
                                            ir.ArN.a(new File(act), 4, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                    case -10:
                                        act = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (act != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", act);
                                            ir.ArN.a(new File(act), 3, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                    case -9:
                                        if (dVar2.Ase != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", dVar2.Ase.getAbsolutePath());
                                            ir.ArN.a(dVar2.Ase, 3, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                    case -8:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (dVar2.Asd != null) {
                                            ir.ArN.b(dVar2.Asd, tinkerResultIntent.getIntExtra("intent_patch_package_patch_check", -10000));
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error patch package check fail , but file is null");
                                    case -7:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", dVar2.ArX);
                                        if (dVar2.Asd != null) {
                                            ir.ArN.a(dVar2.Asd, 1, false);
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                    case -6:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", dVar2.ArX);
                                        ir.ArN.a(dVar2.Asc, 1, true);
                                        break;
                                    case -5:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        ir.ArN.a(j, j2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        ir.ArT = true;
                                        dVar2.Asi = ShareIntentUtil.av(tinkerResultIntent);
                                        dVar2.Asj = ShareIntentUtil.aw(tinkerResultIntent);
                                        dVar2.Ask = ShareIntentUtil.ax(tinkerResultIntent);
                                        if (dVar2.Asa) {
                                            ir.ArN.b(0, null);
                                        }
                                        if (z && dVar2.ArZ) {
                                            ir.ArN.a(j, j2, file, dVar2.Asc.getName());
                                            break;
                                        }
                                }
                            }
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", Integer.valueOf(dVar2.Asl));
                            int i = -1;
                            switch (dVar2.Asl) {
                                case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                                    i = -4;
                                    break;
                                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                                    i = -3;
                                    break;
                                case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                                    i = -1;
                                    break;
                                case -14:
                                    i = -2;
                                    break;
                            }
                            ir.ArN.a(at, i);
                            cHR.ArN.a(cHR.ArL, cHR.ArS.Asl, cHR.ArS.jNF);
                            if (!cHR.ArT) {
                                com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.ADq = cHR;
                    }
                }
            }
        }
    }

    public static a cKg() {
        if (ADp != null) {
            return ADp;
        }
        throw new TinkerRuntimeException("you must init TinkerClient sdk first");
    }

    public final a om(final boolean z) {
        int i = 1;
        if (this.ADr == null || this.ADq == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            return ADp;
        }
        Context context = com.tinkerboots.sdk.b.b.getContext();
        if (VERSION.SDK_INT >= 23) {
            int i2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
            int i3 = context.checkSelfPermission("android.permission.INTERNET") == 0 ? 1 : 0;
            if (i2 == 0 || i3 == 0) {
                i = 0;
            }
        }
        if (i == 0) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            return ADp;
        } else if (ShareTinkerInternals.Jo(this.ADq.tinkerFlags) && ShareTinkerInternals.iG(context)) {
            if (this.ADq.rYd) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        com.tinkerboots.sdk.a.a aVar = a.this.ADr;
                        boolean z = z;
                        SharedPreferences sharedPreferences = com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0);
                        long j = sharedPreferences.getLong("fetch_patch_last_check", 0);
                        if (j == -1) {
                            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
                        } else {
                            j = System.currentTimeMillis() - j;
                            if (z || aVar.jyS || j >= aVar.ADy) {
                                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                                com.tinkerboots.sdk.a.b.a aVar2 = aVar.ADz;
                                b bVar = aVar.ADw;
                                if (bVar == null) {
                                    throw new RuntimeException("callback can't be null");
                                } else if (bVar.aTm()) {
                                    bVar.aTn();
                                    bVar.C(aVar2.ADA.ADB);
                                }
                            } else {
                                com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", Long.valueOf((aVar.ADy - j) / 1000));
                            }
                        }
                        return false;
                    }
                });
            }
            return ADp;
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            return ADp;
        }
    }

    public final a go(String str, String str2) {
        if (this.ADr == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            return ADp;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", str, str2);
        this.ADr.ADz.ADA.ADB.put(str, str2);
        return ADp;
    }

    public final a JB(int i) {
        if (this.ADr == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            return ADp;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", Integer.valueOf(i));
        com.tinkerboots.sdk.a.a aVar = this.ADr;
        if (((long) i) == -1) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
            com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        } else if (i < 0 || i > 24) {
            throw new TinkerRuntimeException("hours must be between 0 and 24");
        } else {
            aVar.ADy = (((long) i) * 3600) * 1000;
        }
        return ADp;
    }
}
