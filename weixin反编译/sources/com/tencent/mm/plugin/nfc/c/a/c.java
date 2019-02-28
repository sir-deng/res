package com.tencent.mm.plugin.nfc.c.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements d {
    private NfcA oXD;

    public c(Tag tag) {
        this.oXD = NfcA.get(tag);
    }

    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        if (this.oXD == null) {
            x.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            throw new IllegalStateException("NfcA is null");
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.oXD.transceive(aVar.getBytes()));
            if (cVar2.oXm.length == 0) {
                return cVar;
            }
            if (cVar2.oXm.length - 2 < 0) {
                return cVar2;
            }
            if (cVar2.bfZ() == (short) 108) {
                aVar.un(cVar2.bga());
            } else {
                if (cVar == null) {
                    cVar = cVar2;
                } else {
                    cVar.a(cVar2);
                }
                if (cVar2.bfZ() != (short) 97) {
                    return cVar;
                }
                if (cVar2.bga() != (short) 0) {
                    aVar = new a((byte[]) b.oXu.clone());
                } else {
                    cVar.oXm[cVar.oXm.length - 1] = (byte) -112;
                    return cVar;
                }
            }
        }
    }

    public final boolean connect() {
        if (!this.oXD.isConnected()) {
            this.oXD.connect();
        }
        return true;
    }

    public final void close() {
        if (this.oXD.isConnected()) {
            this.oXD.close();
        }
    }

    public final boolean isConnected() {
        return this.oXD.isConnected();
    }

    public final boolean bgc() {
        close();
        connect();
        return true;
    }
}
