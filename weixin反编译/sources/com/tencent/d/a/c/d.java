package com.tencent.d.a.c;

public class d {
    private static volatile d Alx = null;
    public String Aly = a.Alv;

    public static d cGL() {
        if (Alx != null) {
            return Alx;
        }
        d dVar;
        synchronized (d.class) {
            if (Alx == null) {
                Alx = new d();
            }
            dVar = Alx;
        }
        return dVar;
    }
}
