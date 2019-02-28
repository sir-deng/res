package com.tencent.d.b.f;

import android.content.Context;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;

public final class b {
    c Ami;
    public f Amj;
    com.tencent.d.b.c.b Amk;
    public int itU;
    Context mContext;
    com.tencent.d.b.c.a mFo;
    String tnS;

    public static class a {
        public b Aml = new b();

        public final a It(int i) {
            this.Aml.itU = i;
            return this;
        }

        public final a ack(String str) {
            this.Aml.tnS = str;
            return this;
        }

        public final a iq(Context context) {
            this.Aml.mContext = context;
            return this;
        }

        public final a a(com.tencent.d.b.c.a aVar) {
            this.Aml.mFo = aVar;
            return this;
        }

        public final a a(com.tencent.d.b.c.b bVar) {
            this.Aml.Amk = bVar;
            return this;
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public final String toString() {
        return "AuthenticationParam{mScene=" + this.itU + ", mChallenge='" + this.tnS + '\'' + ", mIWrapGetChallengeStr=" + this.Ami + ", mIWrapUploadSignature=" + this.Amj + ", mContext=" + this.mContext + ", mFingerprintCanceller=" + this.mFo + ", mSoterFingerprintStateCallback=" + this.Amk + '}';
    }
}
