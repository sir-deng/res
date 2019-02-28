package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class g {
    public static final g aNA = new g() {
        public final boolean e(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final g aNB = new g() {
        public final boolean e(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final g aNC = new g() {
        public final boolean e(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final g aND = a(0, 31).a(a(127, 159));
    public static final g aNE = a(0, ' ').a(a(127, 160)).a(d(173)).a(a(1536, 1539)).a(k("۝܏ ឴឵᠎")).a(a(8192, 8207)).a(a(8232, 8239)).a(a(8287, 8292)).a(a(8298, 8303)).a(d(12288)).a(a(55296, 63743)).a(k("﻿￹￺￻"));
    public static final g aNF = a(0, 1273).a(d(1470)).a(a(1488, 1514)).a(d(1523)).a(d(1524)).a(a(1536, 1791)).a(a(1872, 1919)).a(a(3584, 3711)).a(a(7680, 8367)).a(a(8448, 8506)).a(a(64336, 65023)).a(a(65136, 65279)).a(a(65377, 65500));
    public static final g aNG = new g() {
        public final g a(g gVar) {
            w.ag(gVar);
            return this;
        }

        public final boolean e(char c) {
            return true;
        }

        public final boolean l(CharSequence charSequence) {
            w.ag(charSequence);
            return true;
        }
    };
    public static final g aNH = new g() {
        public final g a(g gVar) {
            return (g) w.ag(gVar);
        }

        public final boolean e(char c) {
            return false;
        }

        public final boolean l(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    };
    public static final g aNt = k("\t\n\u000b\f\r     　 ᠎ ").a(a(8192, 8202));
    public static final g aNu = k("\t\n\u000b\f\r     　").a(a(8192, 8198)).a(a(8200, 8202));
    public static final g aNv = a(0, 127);
    public static final g aNw;
    public static final g aNx = a(9, 13).a(a(28, ' ')).a(d(5760)).a(d(6158)).a(a(8192, 8198)).a(a(8200, 8203)).a(a(8232, 8233)).a(d(8287)).a(d(12288));
    public static final g aNy = new g() {
        public final boolean e(char c) {
            return Character.isDigit(c);
        }
    };
    public static final g aNz = new g() {
        public final boolean e(char c) {
            return Character.isLetter(c);
        }
    };

    private static class a extends g {
        List<g> aNO;

        a(List<g> list) {
            this.aNO = list;
        }

        public final g a(g gVar) {
            List arrayList = new ArrayList(this.aNO);
            arrayList.add(w.ag(gVar));
            return new a(arrayList);
        }

        public final boolean e(char c) {
            for (g e : this.aNO) {
                if (e.e(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        g a = a('0', '9');
        g gVar = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            gVar = gVar.a(a(c, (char) (c + 9)));
        }
        aNw = gVar;
    }

    private static g a(final char c, final char c2) {
        w.au(c2 >= c);
        return new g() {
            public final boolean e(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    private static g d(final char c) {
        return new g() {
            public final g a(g gVar) {
                return gVar.e(c) ? gVar : super.a(gVar);
            }

            public final boolean e(char c) {
                return c == c;
            }
        };
    }

    private static g k(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return aNH;
            case 1:
                return d(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new g() {
                    public final boolean e(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new g() {
                    public final boolean e(char c) {
                        return Arrays.binarySearch(toCharArray, c) >= 0;
                    }
                };
        }
    }

    public g a(g gVar) {
        return new a(Arrays.asList(new g[]{this, (g) w.ag(gVar)}));
    }

    public abstract boolean e(char c);

    public boolean l(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!e(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
