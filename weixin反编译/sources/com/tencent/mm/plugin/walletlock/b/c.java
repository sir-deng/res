package com.tencent.mm.plugin.walletlock.b;

import android.content.Intent;
import com.tencent.mm.f.a.qw;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<qw> {
    public c() {
        this.xmG = qw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qw qwVar = (qw) bVar;
        if (qwVar != null) {
            Intent intent = qwVar.fJx.fJz;
            int intExtra = intent.getIntExtra("key_wallet_lock_type", -1);
            if (qwVar.fJx.fBA != null) {
                x.i("MicroMsg.StartWalletLockUIListener", "alvinluo startWalletLockUI type: %d", Integer.valueOf(intExtra));
                if (intExtra == 2) {
                    intent.setClass(qwVar.fJx.fBA, FingerprintWalletLockUI.class);
                } else if (intExtra == 1) {
                    intent.setClass(qwVar.fJx.fBA, GestureGuardLogicUI.class);
                }
                qwVar.fJx.fBA.startActivityForResult(intent, qwVar.fJx.fzQ);
                qwVar.fJy.ftC = true;
            } else {
                qwVar.fJy.ftC = false;
            }
            x.i("MicroMsg.StartWalletLockUIListener", "alvinluo isSuccess: %b", Boolean.valueOf(qwVar.fJy.ftC));
        }
        return false;
    }
}
