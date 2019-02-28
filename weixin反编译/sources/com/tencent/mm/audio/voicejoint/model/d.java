package com.tencent.mm.audio.voicejoint.model;

public final class d {

    public interface b<T> {
        void vI();

        void vJ();
    }

    /* renamed from: com.tencent.mm.audio.voicejoint.model.d$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ a fmQ;
        final /* synthetic */ b fmR;

        public AnonymousClass1(a aVar, b bVar) {
            this.fmQ = aVar;
            this.fmR = bVar;
        }

        public final void run() {
            this.fmQ.a(this.fmR);
        }
    }

    public interface a<T> {
        void a(b<T> bVar);
    }
}
