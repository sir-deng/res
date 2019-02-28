package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class d {

    public static class c implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String stringExtra = intent.getStringExtra("tools_process_action_code_key");
                x.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = " + stringExtra);
                if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                    x.cfY();
                    x.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", Boolean.valueOf(com.tencent.mm.app.ToolsProfile.a.isLocked()));
                    if (!com.tencent.mm.app.ToolsProfile.a.isLocked()) {
                        Process.killProcess(Process.myPid());
                    }
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                    try {
                        com.tencent.xweb.x5.sdk.d.clearAllWebViewCache(context.getApplicationContext(), true);
                    } catch (Exception e) {
                        x.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e.getMessage());
                    }
                } else if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                    if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                        x.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", Boolean.valueOf(intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)));
                        if (intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)) {
                            com.tencent.xweb.x5.sdk.d.clearAllWebViewCache(context.getApplicationContext(), true);
                        } else {
                            com.tencent.xweb.x5.sdk.d.clearAllWebViewCache(context.getApplicationContext(), false);
                        }
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                        x.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                        x.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                        com.tencent.mm.pluginsdk.model.x.ac(intent);
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_DISCOVERY_RECOMMEND")) {
                        com.tencent.mm.plugin.aj.d.bPz().cx(intent.getStringExtra("tools_param_preload_url"), 2);
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_DISCOVERY_SEARCH")) {
                        com.tencent.mm.plugin.aj.d.bPz().cx(intent.getStringExtra("tools_param_preload_url"), 1);
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SET_SWITCH")) {
                        com.tencent.mm.plugin.aj.d.bPz().kl(intent.getBooleanExtra("tools_param_preload_switch", false));
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")) {
                        com.tencent.mm.plugin.aj.d.bPz().cx(intent.getStringExtra("tools_param_preload_url"), intent.getIntExtra("tools_param_preload_search_biz", -1));
                    }
                }
            }
        }
    }

    public static class a implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String stringExtra = intent.getStringExtra("exdevice_process_action_code_key");
                x.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, action %s", stringExtra);
                if (!bi.oN(stringExtra) && stringExtra.equals("action_reload_resources")) {
                    String stringExtra2 = intent.getStringExtra("exdevice_language");
                    x.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, language %s", stringExtra2);
                    Locale VC = w.VC(stringExtra2);
                    if ("language_default".equalsIgnoreCase(stringExtra2)) {
                        if (VERSION.SDK_INT >= 24) {
                            VC = w.xnv;
                            Locale.setDefault(VC);
                        } else {
                            VC = Locale.getDefault();
                        }
                    }
                    w.a(context.getApplicationContext(), VC);
                    ad.a(com.tencent.mm.bv.a.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
                }
            }
        }
    }

    public static class b implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                x.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
                com.tencent.xweb.x5.sdk.d.reset(context);
                ah.h(new Runnable() {
                    public final void run() {
                        Process.killProcess(Process.myPid());
                    }
                }, 5000);
            }
        }
    }
}
