package com.tencent.mm.ui.f.a;

import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a {
    c zkL;

    /* renamed from: com.tencent.mm.ui.f.a.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String zkM;
        final /* synthetic */ Bundle zkN;
        final /* synthetic */ String zkO;
        final /* synthetic */ a zkP;
        final /* synthetic */ Object zkQ = null;

        public AnonymousClass1(String str, Bundle bundle, String str2, a aVar, Object obj) {
            this.zkM = str;
            this.zkN = bundle;
            this.zkO = str2;
            this.zkP = aVar;
        }

        public final void run() {
            try {
                this.zkP.Zc(a.this.zkL.a(this.zkM, this.zkN, this.zkO));
            } catch (FileNotFoundException e) {
                this.zkP.a(e);
            } catch (MalformedURLException e2) {
                this.zkP.a(e2);
            } catch (IOException e3) {
                this.zkP.b(e3);
            }
        }
    }

    public interface a {
        void Zc(String str);

        void a(FileNotFoundException fileNotFoundException);

        void a(MalformedURLException malformedURLException);

        void b(IOException iOException);
    }

    public a(c cVar) {
        this.zkL = cVar;
    }
}
