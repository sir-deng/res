package org.b.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.g.c;

public final class e {
    public final List<d> AHJ;

    public e() {
        this.AHJ = new ArrayList();
    }

    public e(List<d> list) {
        this.AHJ = new ArrayList(list);
    }

    public e(Map<String, String> map) {
        this();
        for (Entry entry : map.entrySet()) {
            this.AHJ.add(new d((String) entry.getKey(), (String) entry.getValue()));
        }
    }

    public final String cLd() {
        if (this.AHJ.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (d dVar : this.AHJ) {
            stringBuilder.append('&').append(c.encode(dVar.aAM).concat("=").concat(c.encode(dVar.value)));
        }
        return stringBuilder.toString().substring(1);
    }

    public final void a(e eVar) {
        this.AHJ.addAll(eVar.AHJ);
    }

    public final void adn(String str) {
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.AHJ.add(new d(c.decode(split2[0]), split2.length > 1 ? c.decode(split2[1]) : ""));
            }
        }
    }
}
