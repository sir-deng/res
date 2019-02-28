package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j implements Serializable {
    private static final Pattern uaw = Pattern.compile("\\r\\n|\\r|\\n");
    int uax = 0;
    public final ArrayList<n> uay = new ArrayList();

    public j(Spanned spanned) {
        boolean z = false;
        if (spanned != null) {
            Object obj = spanned.toString();
            this.uax = 1;
            Matcher matcher = uaw.matcher(obj);
            int i = 0;
            while (matcher.find()) {
                boolean z2;
                int end = matcher.end();
                if (this.uax == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.uay.add(new n(i, end, z2, false));
                i = matcher.end();
                this.uax++;
            }
            if (this.uay.size() < this.uax) {
                int length = obj.length();
                if (this.uax == 1) {
                    z = true;
                }
                this.uay.add(new n(i, length, z, true));
            }
        }
    }

    public final int getLineForOffset(int i) {
        int i2 = 0;
        while (i2 < this.uax && i >= ((n) this.uay.get(i2)).wq) {
            i2++;
        }
        return Math.min(Math.max(0, i2), this.uay.size() - 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.uay.iterator();
        int i = 1;
        while (it.hasNext()) {
            n nVar = (n) it.next();
            int i2 = i + 1;
            stringBuilder.append(i).append(": ").append(nVar.Ww).append("-").append(nVar.wq).append(nVar.ucf ? "" : ", ");
            i = i2;
        }
        return stringBuilder.toString();
    }
}
