package org.b.d;

import java.io.OutputStream;

public final class a {
    public final String AHA;
    public final String AHB;
    public final h AHD;
    private final OutputStream AHE;
    public final String AHz;
    public final String scope;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.AHz = str;
        this.AHA = str2;
        this.AHB = str3;
        this.AHD = hVar;
        this.scope = str4;
        this.AHE = outputStream;
    }

    public final void sa(String str) {
        if (this.AHE != null) {
            try {
                this.AHE.write(new StringBuilder(String.valueOf(str)).append("\n").toString().getBytes("UTF8"));
            } catch (Throwable e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
