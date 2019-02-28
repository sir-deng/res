package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.f.a.mx;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery extends f implements c {
    private com.tencent.mm.sdk.b.c<mx> hLL = new com.tencent.mm.sdk.b.c<mx>() {
        {
            this.xmG = mx.class.getName().hashCode();
        }

        private static boolean a(mx mxVar) {
            Context context;
            Builder builder;
            switch (mxVar.fFO.action) {
                case 1:
                    context = ad.getContext();
                    builder = new Builder();
                    builder.AaP = WXRecoveryHandleService.class.getName();
                    builder.AaQ = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = "0x26060532";
                    builder.AaL = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
                    builder.njL = WXUtil.gq(context);
                    RecoveryLogic.a(context, builder.cEf(), new RecoveryContext());
                    break;
                case 2:
                    a.QQ();
                    break;
                case 3:
                    context = ad.getContext();
                    builder = new Builder();
                    builder.AaP = WXRecoveryHandleService.class.getName();
                    builder.AaQ = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = "0x26060532";
                    builder.AaL = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
                    builder.njL = WXUtil.gq(context);
                    RecoveryLogic.a(context, builder.cEf(), new RecoveryContext());
                    break;
            }
            return false;
        }
    };
    private RecoveryLogImpl hLM = new RecoveryLogImpl() {
        public final void d(String str, String str2, Object... objArr) {
            x.d(str, str2, objArr);
        }

        public final void v(String str, String str2, Object... objArr) {
            x.v(str, str2, objArr);
        }

        public final void i(String str, String str2, Object... objArr) {
            x.i(str, str2, objArr);
        }

        public final void w(String str, String str2, Object... objArr) {
            x.w(str, str2, objArr);
        }

        public final void e(String str, String str2, Object... objArr) {
            x.e(str, str2, objArr);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            x.printErrStackTrace(str, th, str2, objArr);
        }
    };
    private BroadcastReceiver tP = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if ("com.tecent.recovery.intent.action.LOG".equals(intent.getAction())) {
                PluginRecovery.this.postLog();
            } else if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(intent.getAction())) {
                PluginRecovery.this.postReport();
            }
        }
    };

    public void configure(g gVar) {
        RecoveryLog.a(this.hLM);
        if (gVar.fT(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tecent.recovery.intent.action.LOG");
            intentFilter.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
            ad.getContext().registerReceiver(this.tP, intentFilter);
            File file = new File(WXConstantsRecovery.Abb);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "version.info");
            if (file2.exists()) {
                file2.delete();
            }
            try {
                FileOp.j(file2.getAbsolutePath(), Integer.toHexString(d.vHl).getBytes());
            } catch (Exception e) {
            }
            x.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        this.hLL.cfB();
    }

    public void onAccountRelease() {
        this.hLL.dead();
    }

    private void postLog() {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Recovery.PluginRecovery", "postLog");
                a.QQ();
            }
        }, "RecoveryWriteLogThread");
    }

    private void postReport() {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Recovery.PluginRecovery", "postReport");
                b.QR();
            }
        }, "RecoveryReportStatusThread");
    }
}
