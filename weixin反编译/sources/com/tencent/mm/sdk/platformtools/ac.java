package com.tencent.mm.sdk.platformtools;

import java.security.MessageDigest;

public final class ac {
    protected static char[] xnH = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> xnI = new ThreadLocal<MessageDigest>() {
        protected final /* synthetic */ Object initialValue() {
            return AnonymousClass1.cgb();
        }

        private static MessageDigest cgb() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (Throwable e) {
                throw new RuntimeException("Initialize MD5 failed.", e);
            }
        }
    };

    public static String VF(String str) {
        return bv(str.getBytes());
    }

    public static String bv(byte[] bArr) {
        byte[] digest = ((MessageDigest) xnI.get()).digest(bArr);
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = xnH[(b & 240) >> 4];
            char c2 = xnH[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
