package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.x;

public interface b {

    public static class a {
        public String foE;
        public int mng;
        public int mnh;

        a(String str) {
            this.mnh = 7;
            this.foE = str;
        }

        a() {
            this.mng = 1;
        }
    }

    public static class b {
        public int errCode;
        public String foE;

        public b(int i, String str) {
            this.errCode = i;
            this.foE = str;
        }
    }

    public static class c {
        private static String TAG = "MicroMsg.IFaceMotion.Factory";

        public static b a(com.tencent.mm.plugin.facedetect.model.h.a aVar) {
            if (aVar == null) {
                return null;
            }
            if (aVar.type == 4) {
                x.i(TAG, "hy: is read number");
                return new d(aVar.mme);
            }
            x.i(TAG, "hy: is normal");
            return new c(aVar.ipn, aVar.mmb);
        }
    }

    void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    boolean a(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean aHB();

    boolean aHC();

    void aHD();

    b aHE();

    a aHF();

    boolean b(FaceCharacteristicsResult faceCharacteristicsResult);
}
