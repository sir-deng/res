package com.tencent.mm.plugin.nfc.c.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements d {
    private IsoDep oXC;

    public b(Tag tag) {
        if (tag == null) {
            x.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            throw new IllegalStateException("tag is null");
        } else {
            this.oXC = IsoDep.get(tag);
        }
    }

    public final boolean connect() {
        if (!this.oXC.isConnected()) {
            this.oXC.connect();
        }
        return true;
    }

    public final void close() {
        if (this.oXC.isConnected()) {
            this.oXC.close();
        }
    }

    public final boolean isConnected() {
        return this.oXC.isConnected();
    }

    public final boolean bgc() {
        close();
        connect();
        return true;
    }

    public final c a(a aVar) {
        if (this.oXC == null) {
            x.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            throw new IllegalStateException("IsoDep is null");
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.oXC.transceive(aVar.getBytes()));
            if (cVar2.oXm.length == 0) {
                return cVar;
            }
            if (cVar2.oXm.length - 2 <= 0) {
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
                aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.oXu.clone());
            }
        }
    }
}
