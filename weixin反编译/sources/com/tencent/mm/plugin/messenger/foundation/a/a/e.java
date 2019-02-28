package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public interface e {

    public static class b {
        public byte[] buffer;
        public int cmdId;
        public int fEo = -1;
        public long hAf;
        public int id;
        public int ouG;
        public long ouH;
        public String ouI;
        public String ouJ;
        public com.tencent.mm.bp.a ouK;

        public b(int i) {
            this.cmdId = i;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final byte[] getBuffer() {
            if (this.buffer == null && this.ouK != null) {
                try {
                    this.buffer = this.ouK.toByteArray();
                } catch (IOException e) {
                    x.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            return this.buffer;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i, com.tencent.mm.bp.a aVar) {
            super(i);
            this.cmdId = i;
            this.ouK = aVar;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }
}
