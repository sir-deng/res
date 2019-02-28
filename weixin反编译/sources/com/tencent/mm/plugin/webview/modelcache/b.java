package com.tencent.mm.plugin.webview.modelcache;

public final class b {

    public enum a {
        HTTP(1),
        HTTPS(2);
        
        final int fEo;

        private a(int i) {
            this.fEo = i;
        }

        public static boolean AB(int i) {
            return (HTTP.fEo & i) > 0;
        }

        public static boolean AC(int i) {
            return (HTTPS.fEo & i) > 0;
        }

        public static int AD(int i) {
            return HTTP.fEo | 0;
        }

        public static int AE(int i) {
            return HTTPS.fEo | i;
        }

        public static String toString(int i) {
            String str = "[ %s | %s ]";
            Object[] objArr = new Object[2];
            objArr[0] = AB(i) ? "http" : "-";
            objArr[1] = AC(i) ? "https" : "-";
            return String.format(str, objArr);
        }
    }
}
