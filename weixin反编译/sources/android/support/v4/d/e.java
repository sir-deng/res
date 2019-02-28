package android.support.v4.d;

import java.util.Locale;

public final class e {
    public static final d vL = new e(null, false, (byte) 0);
    public static final d vM = new e(null, true, (byte) 0);
    public static final d vN = new e(b.vU, false, (byte) 0);
    public static final d vO = new e(b.vU, true, (byte) 0);
    public static final d vP = new e(a.vS, false, (byte) 0);
    public static final d vQ = f.vX;

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static class a implements c {
        public static final a vS = new a(true);
        public static final a vT = new a(false);
        private final boolean vR;

        public final int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                switch (e.W(Character.getDirectionality(charSequence.charAt(i5)))) {
                    case 0:
                        if (!this.vR) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.vR) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.vR) {
                return 1;
            }
            return 0;
        }

        private a(boolean z) {
            this.vR = z;
        }
    }

    private static class b implements c {
        public static final b vU = new b();

        public final int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 2;
            for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
                i4 = e.V(Character.getDirectionality(charSequence.charAt(i5)));
            }
            return i4;
        }

        private b() {
        }
    }

    private static abstract class d implements d {
        private final c vV;

        protected abstract boolean by();

        public d(c cVar) {
            this.vV = cVar;
        }

        public final boolean a(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            } else if (this.vV == null) {
                return by();
            } else {
                switch (this.vV.a(charSequence, 0, i)) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        return by();
                }
            }
        }
    }

    private static class e extends d {
        private final boolean vW;

        /* synthetic */ e(c cVar, boolean z, byte b) {
            this(cVar, z);
        }

        private e(c cVar, boolean z) {
            super(cVar);
            this.vW = z;
        }

        protected final boolean by() {
            return this.vW;
        }
    }

    private static class f extends d {
        public static final f vX = new f();

        public f() {
            super(null);
        }

        protected final boolean by() {
            if (f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static /* synthetic */ int V(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    static /* synthetic */ int W(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }
}
