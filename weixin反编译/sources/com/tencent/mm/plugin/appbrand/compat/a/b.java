package com.tencent.mm.plugin.appbrand.compat.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import java.util.List;

public interface b {

    public interface n {
        boolean c(h hVar);
    }

    public interface q {
        double a(f fVar, f fVar2);

        r abV();
    }

    public interface r {
        g abW();
    }

    public interface e {
        View a(h hVar);
    }

    public interface g {
        f abQ();

        f abR();
    }

    public interface h extends d {
        f abU();

        void b(f fVar);

        float getRotation();

        String getSnippet();

        String getTitle();

        void hideInfoWindow();

        boolean isInfoWindowShown();

        void qR(String str);

        void remove();

        void setRotation(float f);

        void showInfoWindow();
    }

    public interface j {
        void b(h hVar);
    }

    public interface o extends d {
    }

    public interface p {
        void a(Iterable<f> iterable);

        void jQ(int i);

        void jR(int i);

        void jS(int i);

        void jT(int i);

        void q(Bitmap bitmap);

        void setDottedLine(boolean z);
    }

    public interface c {
        void d(double d, double d2);

        void jL(int i);

        void jM(int i);

        void jN(int i);

        void jO(int i);
    }

    public interface l {
        void abZ();
    }

    public interface a {
    }

    public interface i {
        void T(float f);

        void U(float f);

        void bD(View view);

        void e(Animation animation);

        void f(double d, double d2);

        void f(Animation animation);

        void p(float f, float f2);

        void p(Bitmap bitmap);

        void qS(String str);

        void qT(String str);
    }

    public interface d {
        String getId();

        void remove();
    }

    public interface f {
        double abS();

        double abT();
    }

    public interface k {
        void abX();

        void abY();
    }

    public interface m {
        void abP();
    }

    public interface b extends d {
    }

    b a(c cVar);

    h a(i iVar);

    o a(p pVar);

    void a(double d, double d2, int i);

    void a(e eVar);

    void a(j jVar);

    void a(k kVar);

    void a(l lVar);

    void a(m mVar);

    void a(n nVar);

    boolean a(View view, double d, double d2);

    f abK();

    q abL();

    i abM();

    c abN();

    p abO();

    void animateTo(double d, double d2);

    boolean b(View view, double d, double d2);

    void c(List<f> list, int i);

    void clean();

    f e(double d, double d2);

    View getView();

    int getZoomLevel();

    void jP(int i);

    void setCenter(double d, double d2);
}
