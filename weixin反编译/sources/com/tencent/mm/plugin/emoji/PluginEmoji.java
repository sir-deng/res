package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.o;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji extends f implements c {
    private d lyN;
    e lyO;

    public String name() {
        return "plugin-emoji";
    }

    public void installed() {
        alias(c.class);
    }

    public void dependency() {
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.pluginsdk.ui.d.d.a.a(com.tencent.mm.bw.g.chT());
        b.chK();
        n.bZK();
    }

    public void execute(g gVar) {
        if (gVar.DZ()) {
            pin(d.aAS());
            if (gVar.DZ()) {
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.d(new a()));
            }
        }
        com.tencent.mm.ui.e.b.c.a(new com.tencent.mm.ui.e.b.b() {
            public final com.tencent.mm.ui.e.b.a cm(String str, String str2) {
                try {
                    return com.tencent.mm.plugin.gif.b.aSR().cW(str, str2);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.PluginEmoji", e, "", new Object[0]);
                    return null;
                }
            }
        });
        com.tencent.mm.ui.e.c.b.a(new com.tencent.mm.ui.e.c.a() {
            public final CharSequence a(Context context, CharSequence charSequence, int i) {
                return com.tencent.mm.bw.g.chT().b(context, charSequence, i);
            }

            public final CharSequence c(Context context, CharSequence charSequence, float f) {
                return com.tencent.mm.bw.g.chT().a(context, charSequence, f);
            }

            public final int bd(String str, int i) {
                com.tencent.mm.bw.g.chT();
                com.tencent.mm.bw.f chQ = com.tencent.mm.bw.f.chQ();
                if (bi.oN(str)) {
                    return i;
                }
                int length = str.length();
                if (i == 0 || i == length) {
                    return i;
                }
                int i2;
                if (com.tencent.mm.bw.f.xtA == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int length2 = chQ.xtq.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(chQ.xtq[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = chQ.xtr.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(chQ.xtr[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = chQ.xts.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(chQ.xts[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = chQ.xtt.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(chQ.xtt[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = chQ.xtu.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(chQ.xtu[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    length2 = chQ.xtv.length;
                    for (i2 = 0; i2 < length2; i2++) {
                        stringBuilder.append(Pattern.quote(chQ.xtv[i2]));
                        if (i2 != length2 - 1) {
                            stringBuilder.append('|');
                        }
                    }
                    if (!(chQ.xtw == null || chQ.xtw.isEmpty())) {
                        Iterator it = chQ.xtw.iterator();
                        while (it.hasNext()) {
                            q qVar = (q) it.next();
                            stringBuilder.append(Pattern.quote(qVar.field_key)).append("|");
                            if (!bi.oN(qVar.field_cnValue)) {
                                stringBuilder.append(Pattern.quote(qVar.field_cnValue)).append("|");
                            }
                            if (!bi.oN(qVar.field_enValue)) {
                                stringBuilder.append(Pattern.quote(qVar.field_enValue)).append("|");
                            }
                            if (!bi.oN(qVar.field_qqValue)) {
                                stringBuilder.append(Pattern.quote(qVar.field_qqValue)).append("|");
                            }
                            if (!bi.oN(qVar.field_twValue)) {
                                stringBuilder.append(Pattern.quote(qVar.field_twValue)).append("|");
                            }
                            if (!bi.oN(qVar.field_thValue)) {
                                stringBuilder.append(Pattern.quote(qVar.field_thValue)).append("|");
                            }
                        }
                    }
                    com.tencent.mm.bw.f.xtA = Pattern.compile(stringBuilder.toString());
                }
                Matcher matcher = com.tencent.mm.bw.f.xtA.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
                while (matcher.find()) {
                    if (6 > matcher.start() && 6 < matcher.end()) {
                        i2 = matcher.start();
                        break;
                    }
                }
                i2 = 6;
                return i + (i2 + -6 > 0 ? i2 - 6 : 0);
            }
        });
        o.fed = new o.a() {
            public final SmileyPanel ak(Context context) {
                return new SmileyPanelImpl(context);
            }

            public final com.tencent.mm.api.n to() {
                return new k();
            }
        };
    }

    public void setEmojiMgr() {
        if (this.lyN == null) {
            this.lyN = com.tencent.mm.plugin.emoji.b.b.a.lAI.aBs();
        }
    }

    public void removeEmojiMgr() {
        this.lyN = null;
    }

    public d getEmojiMgr() {
        setEmojiMgr();
        return this.lyN;
    }

    public e getProvider() {
        if (this.lyO == null) {
            this.lyO = new com.tencent.mm.bt.a();
        }
        return this.lyO;
    }
}
