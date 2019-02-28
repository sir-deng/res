package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f {
    public static final Pattern azF = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern azG = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder ayB = new StringBuilder();

    private static final class b implements Comparable<b> {
        public final d azK;
        public final int score;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.score - ((b) obj).score;
        }

        public b(int i, d dVar) {
            this.score = i;
            this.azK = dVar;
        }
    }

    private static final class a {
        private static final String[] azH = new String[0];
        public final String azI;
        public final String[] azJ;
        public final String name;
        public final int position;

        private a(String str, int i, String str2, String[] strArr) {
            this.position = i;
            this.name = str;
            this.azI = str2;
            this.azJ = strArr;
        }

        public static a j(String str, int i) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            String str2;
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = trim;
                trim = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                str2 = trim.substring(0, indexOf);
                trim = trim2;
            }
            String[] split = str2.split("\\.");
            String str3 = split[0];
            if (split.length > 1) {
                split = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                split = azH;
            }
            return new a(str3, i, trim, split);
        }

        public static a lg() {
            return new a("", 0, "", new String[0]);
        }
    }

    final boolean a(j jVar, com.google.android.exoplayer2.f.g.e.a aVar, List<d> list) {
        Object readLine = jVar.readLine();
        if (readLine == null) {
            return false;
        }
        Matcher matcher = azF.matcher(readLine);
        if (matcher.matches()) {
            return a(null, matcher, jVar, aVar, this.ayB, list);
        }
        CharSequence readLine2 = jVar.readLine();
        if (readLine2 == null) {
            return false;
        }
        matcher = azF.matcher(readLine2);
        if (!matcher.matches()) {
            return false;
        }
        return a(readLine.trim(), matcher, jVar, aVar, this.ayB, list);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.lang.String r9, com.google.android.exoplayer2.f.g.e.a r10) {
        /*
        r4 = 2;
        r3 = 1;
        r2 = -1;
        r1 = 0;
        r0 = azG;
        r5 = r0.matcher(r9);
    L_0x000a:
        r0 = r5.find();
        if (r0 == 0) goto L_0x012d;
    L_0x0010:
        r6 = r5.group(r3);
        r0 = r5.group(r4);
        r7 = "line";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r7 == 0) goto L_0x0072;
    L_0x0021:
        r6 = 44;
        r6 = r0.indexOf(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r6 == r2) goto L_0x005e;
    L_0x0029:
        r7 = r6 + 1;
        r7 = r0.substring(r7);	 Catch:{ NumberFormatException -> 0x004d }
        r7 = U(r7);	 Catch:{ NumberFormatException -> 0x004d }
        r10.avW = r7;	 Catch:{ NumberFormatException -> 0x004d }
        r7 = 0;
        r0 = r0.substring(r7, r6);	 Catch:{ NumberFormatException -> 0x004d }
    L_0x003a:
        r6 = "%";
        r6 = r0.endsWith(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r6 == 0) goto L_0x0063;
    L_0x0043:
        r0 = com.google.android.exoplayer2.f.g.h.W(r0);	 Catch:{ NumberFormatException -> 0x004d }
        r10.avU = r0;	 Catch:{ NumberFormatException -> 0x004d }
        r0 = 0;
        r10.avV = r0;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x000a;
    L_0x004d:
        r0 = move-exception;
        r0 = new java.lang.StringBuilder;
        r6 = "Skipping bad cue setting: ";
        r0.<init>(r6);
        r6 = r5.group();
        r0.append(r6);
        goto L_0x000a;
    L_0x005e:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10.avW = r6;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x003a;
    L_0x0063:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 >= 0) goto L_0x006b;
    L_0x0069:
        r0 = r0 + -1;
    L_0x006b:
        r0 = (float) r0;	 Catch:{ NumberFormatException -> 0x004d }
        r10.avU = r0;	 Catch:{ NumberFormatException -> 0x004d }
        r0 = 1;
        r10.avV = r0;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x000a;
    L_0x0072:
        r7 = "align";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r7 == 0) goto L_0x00d5;
    L_0x007b:
        r6 = r0.hashCode();	 Catch:{ NumberFormatException -> 0x004d }
        switch(r6) {
            case -1364013995: goto L_0x00a0;
            case -1074341483: goto L_0x00ab;
            case 100571: goto L_0x00b6;
            case 3317767: goto L_0x0095;
            case 108511772: goto L_0x00c1;
            case 109757538: goto L_0x008a;
            default: goto L_0x0082;
        };	 Catch:{ NumberFormatException -> 0x004d }
    L_0x0082:
        r0 = r2;
    L_0x0083:
        switch(r0) {
            case 0: goto L_0x00cc;
            case 1: goto L_0x00cc;
            case 2: goto L_0x00cf;
            case 3: goto L_0x00cf;
            case 4: goto L_0x00d2;
            case 5: goto L_0x00d2;
            default: goto L_0x0086;
        };	 Catch:{ NumberFormatException -> 0x004d }
    L_0x0086:
        r0 = 0;
    L_0x0087:
        r10.avT = r0;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x000a;
    L_0x008a:
        r6 = "start";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 == 0) goto L_0x0082;
    L_0x0093:
        r0 = r1;
        goto L_0x0083;
    L_0x0095:
        r6 = "left";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 == 0) goto L_0x0082;
    L_0x009e:
        r0 = r3;
        goto L_0x0083;
    L_0x00a0:
        r6 = "center";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 == 0) goto L_0x0082;
    L_0x00a9:
        r0 = r4;
        goto L_0x0083;
    L_0x00ab:
        r6 = "middle";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 == 0) goto L_0x0082;
    L_0x00b4:
        r0 = 3;
        goto L_0x0083;
    L_0x00b6:
        r6 = "end";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 == 0) goto L_0x0082;
    L_0x00bf:
        r0 = 4;
        goto L_0x0083;
    L_0x00c1:
        r6 = "right";
        r0 = r0.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r0 == 0) goto L_0x0082;
    L_0x00ca:
        r0 = 5;
        goto L_0x0083;
    L_0x00cc:
        r0 = android.text.Layout.Alignment.ALIGN_NORMAL;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x0087;
    L_0x00cf:
        r0 = android.text.Layout.Alignment.ALIGN_CENTER;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x0087;
    L_0x00d2:
        r0 = android.text.Layout.Alignment.ALIGN_OPPOSITE;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x0087;
    L_0x00d5:
        r7 = "position";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r7 == 0) goto L_0x0104;
    L_0x00de:
        r6 = 44;
        r6 = r0.indexOf(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r6 == r2) goto L_0x00ff;
    L_0x00e6:
        r7 = r6 + 1;
        r7 = r0.substring(r7);	 Catch:{ NumberFormatException -> 0x004d }
        r7 = U(r7);	 Catch:{ NumberFormatException -> 0x004d }
        r10.avY = r7;	 Catch:{ NumberFormatException -> 0x004d }
        r7 = 0;
        r0 = r0.substring(r7, r6);	 Catch:{ NumberFormatException -> 0x004d }
    L_0x00f7:
        r0 = com.google.android.exoplayer2.f.g.h.W(r0);	 Catch:{ NumberFormatException -> 0x004d }
        r10.avX = r0;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x000a;
    L_0x00ff:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10.avY = r6;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x00f7;
    L_0x0104:
        r7 = "size";
        r7 = r7.equals(r6);	 Catch:{ NumberFormatException -> 0x004d }
        if (r7 == 0) goto L_0x0115;
    L_0x010d:
        r0 = com.google.android.exoplayer2.f.g.h.W(r0);	 Catch:{ NumberFormatException -> 0x004d }
        r10.width = r0;	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x000a;
    L_0x0115:
        r7 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x004d }
        r8 = "Unknown cue setting ";
        r7.<init>(r8);	 Catch:{ NumberFormatException -> 0x004d }
        r6 = r7.append(r6);	 Catch:{ NumberFormatException -> 0x004d }
        r7 = ":";
        r6 = r6.append(r7);	 Catch:{ NumberFormatException -> 0x004d }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x004d }
        goto L_0x000a;
    L_0x012d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.g.f.a(java.lang.String, com.google.android.exoplayer2.f.g.e$a):void");
    }

    static void a(String str, String str2, com.google.android.exoplayer2.f.g.e.a aVar, List<d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        List arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int indexOf;
            String substring;
            Object obj;
            switch (charAt) {
                case '&':
                    indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                    substring = str2.substring(i + 1, indexOf);
                    obj = -1;
                    switch (substring.hashCode()) {
                        case 3309:
                            if (substring.equals("gt")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 3464:
                            if (substring.equals("lt")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 96708:
                            if (substring.equals("amp")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 3374865:
                            if (substring.equals("nbsp")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            spannableStringBuilder.append('<');
                            break;
                        case 1:
                            spannableStringBuilder.append('>');
                            break;
                        case 2:
                            spannableStringBuilder.append(' ');
                            break;
                        case 3:
                            spannableStringBuilder.append('&');
                            break;
                        default:
                            new StringBuilder("ignoring unsupported entity: '&").append(substring).append(";'");
                            break;
                    }
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                    break;
                case '<':
                    if (i + 1 < str2.length()) {
                        Object obj2 = str2.charAt(i + 1) == '/' ? 1 : null;
                        indexOf = str2.indexOf(62, i + 1);
                        indexOf = indexOf == -1 ? str2.length() : indexOf + 1;
                        Object obj3 = str2.charAt(indexOf + -2) == '/' ? 1 : null;
                        String substring2 = str2.substring((obj2 != null ? 2 : 1) + i, obj3 != null ? indexOf - 2 : indexOf - 1);
                        String trim = substring2.trim();
                        substring = trim.isEmpty() ? null : trim.split("[ \\.]")[0];
                        if (substring != null) {
                            obj = -1;
                            switch (substring.hashCode()) {
                                case 98:
                                    if (substring.equals("b")) {
                                        obj = null;
                                        break;
                                    }
                                    break;
                                case 99:
                                    if (substring.equals("c")) {
                                        obj = 1;
                                        break;
                                    }
                                    break;
                                case 105:
                                    if (substring.equals("i")) {
                                        obj = 2;
                                        break;
                                    }
                                    break;
                                case 117:
                                    if (substring.equals("u")) {
                                        obj = 4;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (substring.equals("v")) {
                                        obj = 5;
                                        break;
                                    }
                                    break;
                                case 3314158:
                                    if (substring.equals("lang")) {
                                        obj = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (obj) {
                                case null:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj != null) {
                                if (obj2 == null) {
                                    if (obj3 == null) {
                                        stack.push(a.j(substring2, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    a aVar2 = (a) stack.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.name.equals(substring)) {
                                        i = indexOf;
                                        break;
                                    }
                                }
                                i = indexOf;
                            }
                        }
                        i = indexOf;
                        break;
                    }
                    i++;
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.lg(), spannableStringBuilder, list, arrayList);
        aVar.azE = spannableStringBuilder;
    }

    private static boolean a(String str, Matcher matcher, j jVar, com.google.android.exoplayer2.f.g.e.a aVar, StringBuilder stringBuilder, List<d> list) {
        try {
            aVar.startTime = h.V(matcher.group(1));
            aVar.endTime = h.V(matcher.group(2));
            a(matcher.group(3), aVar);
            stringBuilder.setLength(0);
            while (true) {
                Object readLine = jVar.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    a(str, stringBuilder.toString(), aVar, (List) list);
                    return true;
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(readLine.trim());
            }
        } catch (NumberFormatException e) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            return false;
        }
    }

    private static int U(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r11, com.google.android.exoplayer2.f.g.f.a r12, android.text.SpannableStringBuilder r13, java.util.List<com.google.android.exoplayer2.f.g.d> r14, java.util.List<com.google.android.exoplayer2.f.g.f.b> r15) {
        /*
        r1 = 2;
        r4 = -1;
        r2 = 0;
        r3 = 1;
        r10 = 33;
        r5 = r12.position;
        r6 = r13.length();
        r0 = r12.name;
        r7 = r0.hashCode();
        switch(r7) {
            case 0: goto L_0x005c;
            case 98: goto L_0x001a;
            case 99: goto L_0x003b;
            case 105: goto L_0x0025;
            case 117: goto L_0x0030;
            case 118: goto L_0x0051;
            case 3314158: goto L_0x0046;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r4;
    L_0x0016:
        switch(r0) {
            case 0: goto L_0x0067;
            case 1: goto L_0x00c9;
            case 2: goto L_0x00d2;
            case 3: goto L_0x006f;
            case 4: goto L_0x006f;
            case 5: goto L_0x006f;
            case 6: goto L_0x006f;
            default: goto L_0x0019;
        };
    L_0x0019:
        return;
    L_0x001a:
        r7 = "b";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x0023:
        r0 = r2;
        goto L_0x0016;
    L_0x0025:
        r7 = "i";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x002e:
        r0 = r3;
        goto L_0x0016;
    L_0x0030:
        r7 = "u";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x0039:
        r0 = r1;
        goto L_0x0016;
    L_0x003b:
        r7 = "c";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x0044:
        r0 = 3;
        goto L_0x0016;
    L_0x0046:
        r7 = "lang";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x004f:
        r0 = 4;
        goto L_0x0016;
    L_0x0051:
        r7 = "v";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x005a:
        r0 = 5;
        goto L_0x0016;
    L_0x005c:
        r7 = "";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0015;
    L_0x0065:
        r0 = 6;
        goto L_0x0016;
    L_0x0067:
        r0 = new android.text.style.StyleSpan;
        r0.<init>(r3);
        r13.setSpan(r0, r5, r6, r10);
    L_0x006f:
        r15.clear();
        a(r14, r11, r12, r15);
        r7 = r15.size();
        r1 = r2;
    L_0x007a:
        if (r1 >= r7) goto L_0x0019;
    L_0x007c:
        r0 = r15.get(r1);
        r0 = (com.google.android.exoplayer2.f.g.f.b) r0;
        r8 = r0.azK;
        if (r8 == 0) goto L_0x0123;
    L_0x0086:
        r0 = r8.getStyle();
        if (r0 == r4) goto L_0x0098;
    L_0x008c:
        r0 = new android.text.style.StyleSpan;
        r9 = r8.getStyle();
        r0.<init>(r9);
        r13.setSpan(r0, r5, r6, r10);
    L_0x0098:
        r0 = r8.ayW;
        if (r0 != r3) goto L_0x00db;
    L_0x009c:
        r0 = r3;
    L_0x009d:
        if (r0 == 0) goto L_0x00a7;
    L_0x009f:
        r0 = new android.text.style.StrikethroughSpan;
        r0.<init>();
        r13.setSpan(r0, r5, r6, r10);
    L_0x00a7:
        r0 = r8.ayX;
        if (r0 != r3) goto L_0x00dd;
    L_0x00ab:
        r0 = r3;
    L_0x00ac:
        if (r0 == 0) goto L_0x00b6;
    L_0x00ae:
        r0 = new android.text.style.UnderlineSpan;
        r0.<init>();
        r13.setSpan(r0, r5, r6, r10);
    L_0x00b6:
        r0 = r8.ayU;
        if (r0 == 0) goto L_0x00e7;
    L_0x00ba:
        r0 = new android.text.style.ForegroundColorSpan;
        r9 = r8.ayU;
        if (r9 != 0) goto L_0x00df;
    L_0x00c0:
        r0 = new java.lang.IllegalStateException;
        r1 = "Font color not defined";
        r0.<init>(r1);
        throw r0;
    L_0x00c9:
        r0 = new android.text.style.StyleSpan;
        r0.<init>(r1);
        r13.setSpan(r0, r5, r6, r10);
        goto L_0x006f;
    L_0x00d2:
        r0 = new android.text.style.UnderlineSpan;
        r0.<init>();
        r13.setSpan(r0, r5, r6, r10);
        goto L_0x006f;
    L_0x00db:
        r0 = r2;
        goto L_0x009d;
    L_0x00dd:
        r0 = r2;
        goto L_0x00ac;
    L_0x00df:
        r9 = r8.ayT;
        r0.<init>(r9);
        r13.setSpan(r0, r5, r6, r10);
    L_0x00e7:
        r0 = r8.ayV;
        if (r0 == 0) goto L_0x0102;
    L_0x00eb:
        r0 = new android.text.style.BackgroundColorSpan;
        r9 = r8.ayV;
        if (r9 != 0) goto L_0x00fa;
    L_0x00f1:
        r0 = new java.lang.IllegalStateException;
        r1 = "Background color not defined.";
        r0.<init>(r1);
        throw r0;
    L_0x00fa:
        r9 = r8.backgroundColor;
        r0.<init>(r9);
        r13.setSpan(r0, r5, r6, r10);
    L_0x0102:
        r0 = r8.ayS;
        if (r0 == 0) goto L_0x0110;
    L_0x0106:
        r0 = new android.text.style.TypefaceSpan;
        r9 = r8.ayS;
        r0.<init>(r9);
        r13.setSpan(r0, r5, r6, r10);
    L_0x0110:
        r0 = r8.azd;
        if (r0 == 0) goto L_0x011e;
    L_0x0114:
        r0 = new android.text.style.AlignmentSpan$Standard;
        r9 = r8.azd;
        r0.<init>(r9);
        r13.setSpan(r0, r5, r6, r10);
    L_0x011e:
        r0 = r8.aza;
        switch(r0) {
            case 1: goto L_0x0128;
            case 2: goto L_0x0134;
            case 3: goto L_0x013f;
            default: goto L_0x0123;
        };
    L_0x0123:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x007a;
    L_0x0128:
        r0 = new android.text.style.AbsoluteSizeSpan;
        r8 = r8.azb;
        r8 = (int) r8;
        r0.<init>(r8, r3);
        r13.setSpan(r0, r5, r6, r10);
        goto L_0x0123;
    L_0x0134:
        r0 = new android.text.style.RelativeSizeSpan;
        r8 = r8.azb;
        r0.<init>(r8);
        r13.setSpan(r0, r5, r6, r10);
        goto L_0x0123;
    L_0x013f:
        r0 = new android.text.style.RelativeSizeSpan;
        r8 = r8.azb;
        r9 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r8 = r8 / r9;
        r0.<init>(r8);
        r13.setSpan(r0, r5, r6, r10);
        goto L_0x0123;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.g.f.a(java.lang.String, com.google.android.exoplayer2.f.g.f$a, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    private static void a(List<d> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int i2;
            d dVar = (d) list.get(i);
            String str2 = aVar.name;
            String[] strArr = aVar.azJ;
            String str3 = aVar.azI;
            if (dVar.azz.isEmpty() && dVar.azA.isEmpty() && dVar.azB.isEmpty() && dVar.azC.isEmpty()) {
                i2 = str2.isEmpty() ? 1 : 0;
            } else {
                i2 = d.a(d.a(d.a(0, dVar.azz, str, 1073741824), dVar.azA, str2, 2), dVar.azC, str3, 4);
                i2 = (i2 == -1 || !Arrays.asList(strArr).containsAll(dVar.azB)) ? 0 : i2 + (dVar.azB.size() * 4);
            }
            if (i2 > 0) {
                list2.add(new b(i2, dVar));
            }
        }
        Collections.sort(list2);
    }
}
