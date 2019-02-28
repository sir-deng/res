package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.aif;
        j jVar = new j(byteBuffer.array(), byteBuffer.limit());
        String lL = jVar.lL();
        String lL2 = jVar.lL();
        long aL = jVar.aL();
        jVar.cV(4);
        return new Metadata(new EventMessage(lL, lL2, (jVar.aL() * 1000) / aL, jVar.aL(), Arrays.copyOfRange(r1, jVar.position, r0)));
    }
}
