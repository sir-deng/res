package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.g.b;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;

public final class i {
    private com.tencent.mm.ad.g.a fuR = new com.tencent.mm.ad.g.a() {
        public final void vi() {
            i.this.tpe.mvW.a(null);
            i.this.tpe.mvW.a(null);
            i.this.b(i.this.tpe);
        }
    };
    private b fuS = new b() {
        public final void onError() {
            i.this.tpe.mvW.a(null);
            i.this.tpe.mvW.a(null);
            i.this.b(i.this.tpe);
        }
    };
    AudioManager gDM = ((AudioManager) ad.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    a tpe;
    BroadcastReceiver tpf = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                i.this.bPo();
            }
        }
    };

    private class a {
        g mvW;
        LinkedList<au> tph;
    }

    public i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        ad.getContext().registerReceiver(this.tpf, intentFilter);
    }

    public final void bPo() {
        a(this.tpe);
    }

    private static a a(a aVar) {
        if (aVar != null) {
            aVar.mvW.stop();
            aVar.mvW.a(null);
            aVar.mvW.a(null);
            aVar.tph.clear();
        }
        return null;
    }

    final void b(a aVar) {
        while (aVar != null) {
            if (aVar.tph.size() > 0) {
                au auVar = (au) aVar.tph.getLast();
                aVar.tph.removeLast();
                q.E(auVar);
                x.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", Long.valueOf(auVar.field_msgId), q.getFullPath(auVar.field_imgPath));
                if (aVar.mvW.a(q.getFullPath(auVar.field_imgPath), true, true, -1)) {
                    aVar.mvW.a(this.fuR);
                    aVar.mvW.a(this.fuS);
                    return;
                }
            }
            a(aVar);
            return;
        }
    }
}
