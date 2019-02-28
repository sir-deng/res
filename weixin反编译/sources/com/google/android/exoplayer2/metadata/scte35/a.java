package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {
    private q alA;
    private final j aoI = new j();
    private final i aqX = new i();

    public final Metadata a(d dVar) {
        Entry entry;
        if (this.alA == null || dVar.aej != this.alA.lR()) {
            this.alA = new q(dVar.aig);
            this.alA.R(dVar.aig - dVar.aej);
        }
        ByteBuffer byteBuffer = dVar.aif;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.aoI.l(array, limit);
        this.aqX.l(array, limit);
        this.aqX.cS(39);
        long cT = ((long) this.aqX.cT(32)) | (((long) this.aqX.cT(1)) << 32);
        this.aqX.cS(20);
        int cT2 = this.aqX.cT(12);
        int cT3 = this.aqX.cT(8);
        this.aoI.cV(14);
        Object entry2;
        switch (cT3) {
            case 0:
                entry2 = new SpliceNullCommand();
                break;
            case 4:
                entry2 = SpliceScheduleCommand.c(this.aoI);
                break;
            case 5:
                entry2 = SpliceInsertCommand.a(this.aoI, cT, this.alA);
                break;
            case 6:
                entry2 = TimeSignalCommand.b(this.aoI, cT, this.alA);
                break;
            case 255:
                entry2 = PrivateCommand.a(this.aoI, cT2, cT);
                break;
            default:
                entry2 = null;
                break;
        }
        if (entry2 == null) {
            return new Metadata(new Entry[0]);
        }
        return new Metadata(entry2);
    }
}
