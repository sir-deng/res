package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final PasswordSpecification aIT = new a().nP().aH("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").aI("abcdefghijkmnopqrstxyz").aI("ABCDEFGHJKLMNPQRSTXY").aI("3456789").nQ();
    public static final PasswordSpecification aIU = new a().nP().aH("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").aI("abcdefghijklmnopqrstuvwxyz").aI("ABCDEFGHIJKLMNOPQRSTUVWXYZ").aI("1234567890").nQ();
    final String aIV;
    final List<String> aIW;
    final List<Integer> aIX;
    final int aIY;
    final int aIZ;
    private final int[] aJa = nO();
    private final Random aJb = new SecureRandom();
    final int mVersionCode;

    public static class b extends Error {
        public b(String str) {
            super(str);
        }
    }

    public static class a {
        private final List<String> aIW = new ArrayList();
        private final List<Integer> aIX = new ArrayList();
        private int aIY = 12;
        private int aIZ = 16;
        private final TreeSet<Character> aJc = new TreeSet();

        private static TreeSet<Character> m(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new b(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.dc(c)) {
                    throw new b(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final a aH(String str) {
            this.aJc.addAll(m(str, "allowedChars"));
            return this;
        }

        public final a aI(String str) {
            this.aIW.add(PasswordSpecification.b(m(str, "requiredChars")));
            this.aIX.add(Integer.valueOf(1));
            return this;
        }

        public final a nP() {
            this.aIY = 12;
            this.aIZ = 16;
            return this;
        }

        public final PasswordSpecification nQ() {
            if (this.aJc.isEmpty()) {
                throw new b("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.aIX) {
                i = intValue.intValue() + i;
            }
            if (i > this.aIZ) {
                throw new b("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.aIW) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        throw new b("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - 32] = true;
                }
            }
            return new PasswordSpecification(1, PasswordSpecification.b(this.aJc), this.aIW, this.aIX, this.aIY, this.aIZ);
        }
    }

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.aIV = str;
        this.aIW = Collections.unmodifiableList(list);
        this.aIX = Collections.unmodifiableList(list2);
        this.aIY = i2;
        this.aIZ = i3;
    }

    static /* synthetic */ String b(Collection collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = ((Character) it.next()).charValue();
        }
    }

    static /* synthetic */ boolean dc(int i) {
        return i < 32 || i > 126;
    }

    private int[] nO() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.aIW) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        return iArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
