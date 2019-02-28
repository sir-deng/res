package com.tinkerboots.sdk.a.b;

public class a {
    public final com.tinkerboots.sdk.a.c.a ADA;

    static class a {
        com.tinkerboots.sdk.a.c.a ADA;

        a() {
        }
    }

    private a(com.tinkerboots.sdk.a.c.a aVar) {
        this.ADA = aVar;
    }

    public static a cKh() {
        a aVar = new a();
        aVar.ADA = new com.tinkerboots.sdk.a.c.a();
        if (aVar.ADA != null) {
            return new a(aVar.ADA);
        }
        throw new RuntimeException("You need init conditions property");
    }
}
