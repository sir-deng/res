package org.b.a;

import java.io.OutputStream;
import org.b.b.b;
import org.b.d.h;
import org.b.g.d;

public final class a {
    public String AHA;
    public String AHB = "oob";
    public org.b.a.a.a AHC;
    public h AHD = h.Header;
    public OutputStream AHE = null;
    public String AHz;
    public String scope;

    public static org.b.a.a.a S(Class<? extends org.b.a.a.a> cls) {
        d.j(cls, "Api class cannot be null");
        try {
            return (org.b.a.a.a) cls.newInstance();
        } catch (Exception e) {
            throw new b("Error while creating the Api object", e);
        }
    }
}
