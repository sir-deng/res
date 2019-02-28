package com.tencent.mm.lan_cs;

public final class Client {
    public static a gVY;

    public static class C2Java {
        public static void onRecv(String str, int i, byte[] bArr) {
            if (Client.gVY != null) {
                Client.gVY.onRecv(str, i, bArr);
            }
        }

        public static void onDisconnect(String str, int i) {
            if (Client.gVY != null) {
                Client.gVY.Eu();
            }
        }
    }

    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i, byte[] bArr);
    }

    public interface a {
        void Eu();

        void onRecv(String str, int i, byte[] bArr);
    }
}
