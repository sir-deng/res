package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.regex.Pattern;

public final class f {
    public b ndu;
    c ndv;

    public static class b {
        private static final Pattern ndA = Pattern.compile(".*#.*wechat_redirect");
        private String ndB = null;

        public b(String str) {
            this.ndB = str;
        }

        public final int Cn(String str) {
            if (bi.oN(str)) {
                x.e("MicroMsg.GameWebViewGetA8KeyHelp", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.ndB)) {
                return 0;
            } else {
                if (ndA.matcher(str).find()) {
                    return 2;
                }
                return 1;
            }
        }
    }

    private static final class a implements e, h<Bundle, IPCRunCgiRespWrapper> {
        private i<IPCRunCgiRespWrapper> ndz;

        private a() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            Bundle bundle = (Bundle) obj;
            as.CN().a(233, (e) this);
            this.ndz = iVar;
            String string = bundle.getString("geta8key_data_req_url");
            if (!bi.oN(bundle.getString("k_share_url"))) {
                ak.eS(string, bundle.getString("k_share_url"));
            }
            as.CN().a(!bi.oN(string) ? new l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), "", bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), new byte[0]) : new l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0)), 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.d("MicroMsg.GameWebViewGetA8KeyHelp", "onSceneEnd");
            as.CN().b(233, (e) this);
            if (this.ndz != null) {
                IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                iPCRunCgiRespWrapper.errType = i;
                iPCRunCgiRespWrapper.errCode = i2;
                iPCRunCgiRespWrapper.foE = str;
                iPCRunCgiRespWrapper.gLB = (com.tencent.mm.ad.b) kVar.hoq;
                this.ndz.as(iPCRunCgiRespWrapper);
            }
            this.ndz = null;
        }
    }

    public interface c {
        void a(int i, int i2, String str, com.tencent.mm.ad.b bVar);
    }

    public f(String str, c cVar) {
        this.ndv = cVar;
        this.ndu = new b(str);
    }
}
