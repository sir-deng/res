package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.util.regex.Pattern;

public class d {
    public static d lBn;
    public boolean lBo = false;
    private Pattern lBp = Pattern.compile("_\\d");

    /* renamed from: com.tencent.mm.plugin.emoji.e.d$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ieY;

        AnonymousClass1(String str) {
            this.ieY = str;
        }

        public final void run() {
            d.this.yG(this.ieY);
            if (d.this.lBo) {
                as.Hm();
                c.Db().a(a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static d aBx() {
        if (lBn == null) {
            synchronized (d.class) {
                lBn = new d();
            }
        }
        return lBn;
    }

    public final void yG(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (this.lBo) {
                        if (file2.isDirectory()) {
                            yG(file2.getPath());
                        } else {
                            Object name = file2.getName();
                            if (this.lBp.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        return;
                    }
                }
            }
        }
    }

    public final void yH(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        yH(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
    }
}
