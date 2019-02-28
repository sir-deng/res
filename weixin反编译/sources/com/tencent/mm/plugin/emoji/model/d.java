package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.c.c;
import com.tencent.mm.f.a.rb;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.y.am;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class d implements e {
    private c lDa = new c() {
        public final void a(boolean z, Object... objArr) {
            int intValue;
            al alVar;
            EmojiInfo emojiInfo;
            String clq;
            String str;
            long currentTimeMillis;
            boolean f;
            String str2;
            Object[] objArr2;
            Throwable e;
            File file;
            String Nx;
            String str3;
            String str4;
            Object[] objArr3;
            if (objArr == null || objArr.length < 4) {
                x.w("MicroMsg.emoji.EmojiService", "extra obj error");
                return;
            }
            intValue = ((Integer) objArr[2]).intValue();
            if (objArr[0] instanceof al) {
                alVar = (al) objArr[0];
            } else {
                alVar = null;
            }
            if (objArr[1] instanceof EmojiInfo) {
                emojiInfo = (EmojiInfo) objArr[1];
            } else {
                emojiInfo = null;
            }
            if (objArr[3] instanceof Long) {
                ((Long) objArr[3]).longValue();
            }
            if (alVar == null || emojiInfo == null) {
                x.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
                return;
            }
            d.this.lDi.remove(alVar.frM);
            if (emojiInfo.field_state == EmojiInfo.xIX) {
                x.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
                emojiInfo.field_state = EmojiInfo.xIV;
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(emojiInfo);
            }
            if (z) {
                clq = emojiInfo.clq();
                if (intValue == 102 || intValue == 101) {
                    if (intValue == 101) {
                        str = clq + "_extern";
                    } else {
                        str = clq + "_encrypt";
                    }
                    if (com.tencent.mm.a.e.bN(str) > 0) {
                        currentTimeMillis = System.currentTimeMillis();
                        try {
                            f = com.tencent.mm.a.a.f(Base64.encodeToString(bi.Wj(alVar.aeskey), 0), str, clq);
                            if (!f) {
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.cn(12);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.cn(8);
                                }
                                x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), clq);
                                if (f) {
                                    str2 = "MicroMsg.emoji.EmojiService";
                                    clq = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr2 = new Object[6];
                                    if (emojiInfo != null) {
                                    }
                                    objArr2[0] = emojiInfo != null ? "" : emojiInfo.Nx();
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
                                    if (com.tencent.mm.a.g.bV(str) != null) {
                                    }
                                    objArr2[2] = com.tencent.mm.a.g.bV(str) != null ? "" : com.tencent.mm.a.g.bV(str);
                                    if (emojiInfo != null) {
                                    }
                                    objArr2[3] = emojiInfo != null ? "" : emojiInfo.field_aeskey;
                                    if (emojiInfo != null) {
                                    }
                                    objArr2[4] = emojiInfo != null ? "" : emojiInfo.field_encrypturl;
                                    if (alVar != null) {
                                    }
                                    objArr2[5] = alVar != null ? "" : alVar.xHj;
                                    x.i(str2, clq, objArr2);
                                    if (intValue != 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 1, alVar.frQ, 1, alVar.xHk);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 1, alVar.frQ, 1, alVar.xHk);
                                    }
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                    d.a(alVar);
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(str);
                            } else if (intValue == 101) {
                                try {
                                    com.tencent.mm.plugin.emoji.c.cn(11);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                                x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), clq);
                                if (f) {
                                    str2 = "MicroMsg.emoji.EmojiService";
                                    clq = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr2 = new Object[6];
                                    objArr2[0] = emojiInfo != null ? "" : emojiInfo.Nx();
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
                                    objArr2[2] = com.tencent.mm.a.g.bV(str) != null ? "" : com.tencent.mm.a.g.bV(str);
                                    objArr2[3] = emojiInfo != null ? "" : emojiInfo.field_aeskey;
                                    objArr2[4] = emojiInfo != null ? "" : emojiInfo.field_encrypturl;
                                    objArr2[5] = alVar != null ? "" : alVar.xHj;
                                    x.i(str2, clq, objArr2);
                                    if (intValue != 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 1, alVar.frQ, 1, alVar.xHk);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 1, alVar.frQ, 1, alVar.xHk);
                                    }
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                    d.a(alVar);
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(str);
                            } else {
                                com.tencent.mm.plugin.emoji.c.cn(7);
                                x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), clq);
                                if (f) {
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                } else {
                                    str2 = "MicroMsg.emoji.EmojiService";
                                    clq = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr2 = new Object[6];
                                    if (emojiInfo != null) {
                                    }
                                    objArr2[0] = emojiInfo != null ? "" : emojiInfo.Nx();
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
                                    if (com.tencent.mm.a.g.bV(str) != null) {
                                    }
                                    objArr2[2] = com.tencent.mm.a.g.bV(str) != null ? "" : com.tencent.mm.a.g.bV(str);
                                    if (emojiInfo != null) {
                                    }
                                    objArr2[3] = emojiInfo != null ? "" : emojiInfo.field_aeskey;
                                    if (emojiInfo != null) {
                                    }
                                    objArr2[4] = emojiInfo != null ? "" : emojiInfo.field_encrypturl;
                                    if (alVar != null) {
                                    }
                                    objArr2[5] = alVar != null ? "" : alVar.xHj;
                                    x.i(str2, clq, objArr2);
                                    if (intValue != 101) {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 1, alVar.frQ, 1, alVar.xHk);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 1, alVar.frQ, 1, alVar.xHk);
                                    }
                                    com.tencent.mm.loader.stub.b.deleteFile(str);
                                    d.a(alVar);
                                }
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            f = false;
                            e = th;
                        }
                    } else {
                        x.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", emojiInfo.Nx());
                        if (intValue == 101) {
                            com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 1, 1, alVar.frQ, 1, alVar.xHk);
                        } else {
                            com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 1, 1, alVar.frQ, 1, alVar.xHk);
                        }
                        d.a(alVar);
                        return;
                    }
                }
                file = new File(clq);
                if (com.tencent.mm.a.e.bN(clq) <= 0) {
                    clq = com.tencent.mm.a.g.i(file);
                    Nx = emojiInfo.Nx();
                    if (intValue == 101) {
                        Nx = emojiInfo.field_externMd5;
                    }
                    if (bi.oN(clq) && clq.equalsIgnoreCase(Nx)) {
                        if (intValue == 101) {
                            com.tencent.mm.plugin.emoji.c.cn(13);
                            com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 0, alVar.frQ, 0, alVar.xHk);
                        } else if (intValue == 102) {
                            com.tencent.mm.plugin.emoji.c.cn(4);
                            com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 0, alVar.frQ, 0, alVar.xHk);
                        } else {
                            com.tencent.mm.plugin.emoji.c.cn(4);
                            com.tencent.mm.plugin.emoji.c.a(alVar.frM, 2, 0, 0, alVar.frQ, 1, alVar.xHk);
                        }
                        com.tencent.mm.plugin.emoji.e.e.aBy().c(emojiInfo, true);
                        if (d.this.lDh != null) {
                            d.this.lDh.h(emojiInfo);
                        }
                        d.a(alVar);
                        return;
                    }
                    str3 = "MicroMsg.emoji.EmojiService";
                    str4 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                    objArr3 = new Object[3];
                    objArr3[0] = clq;
                    objArr3[1] = emojiInfo != null ? "" : emojiInfo.Nx();
                    objArr3[2] = emojiInfo != null ? "" : emojiInfo.field_cdnUrl;
                    x.i(str3, str4, objArr3);
                    file.delete();
                    d.a(alVar);
                    if (intValue == 101) {
                        com.tencent.mm.plugin.emoji.c.cn(14);
                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 1, alVar.frQ, 0, alVar.xHk);
                        return;
                    } else if (intValue != 102) {
                        com.tencent.mm.plugin.emoji.c.cn(5);
                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 1, alVar.frQ, 1, alVar.xHk);
                        return;
                    } else {
                        com.tencent.mm.plugin.emoji.c.cn(5);
                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 2, 0, 1, alVar.frQ, 1, alVar.xHk);
                        return;
                    }
                }
                str2 = "MicroMsg.emoji.EmojiService";
                clq = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                objArr2 = new Object[2];
                objArr2[0] = emojiInfo != null ? "" : emojiInfo.Nx();
                objArr2[1] = emojiInfo != null ? "" : emojiInfo.field_cdnUrl;
                x.i(str2, clq, objArr2);
                if (intValue != 101) {
                    com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 1, 1, alVar.frQ, 1, alVar.xHk);
                    com.tencent.mm.plugin.emoji.c.cn(3);
                } else {
                    com.tencent.mm.plugin.emoji.c.a(alVar.frM, 2, 1, 1, alVar.frQ, 1, alVar.xHk);
                    com.tencent.mm.plugin.emoji.c.cn(3);
                }
                d.a(alVar);
                return;
            }
            x.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", emojiInfo.Nx());
            if (intValue == 101) {
                com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 1, 1, alVar.frQ, 1, alVar.xHk);
                com.tencent.mm.plugin.emoji.c.cn(3);
            } else {
                com.tencent.mm.plugin.emoji.c.a(alVar.frM, 2, 1, 1, alVar.frQ, 1, alVar.xHk);
                com.tencent.mm.plugin.emoji.c.cn(3);
            }
            d.a(alVar);
            return;
            x.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", bi.i(e));
            if (intValue == 101) {
                com.tencent.mm.plugin.emoji.c.cn(12);
            } else {
                com.tencent.mm.plugin.emoji.c.cn(8);
            }
            x.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), clq);
            if (f) {
                com.tencent.mm.loader.stub.b.deleteFile(str);
                file = new File(clq);
                if (com.tencent.mm.a.e.bN(clq) <= 0) {
                    str2 = "MicroMsg.emoji.EmojiService";
                    clq = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                    objArr2 = new Object[2];
                    if (emojiInfo != null) {
                    }
                    objArr2[0] = emojiInfo != null ? "" : emojiInfo.Nx();
                    if (emojiInfo != null) {
                    }
                    objArr2[1] = emojiInfo != null ? "" : emojiInfo.field_cdnUrl;
                    x.i(str2, clq, objArr2);
                    if (intValue != 101) {
                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 2, 1, 1, alVar.frQ, 1, alVar.xHk);
                        com.tencent.mm.plugin.emoji.c.cn(3);
                    } else {
                        com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 1, 1, alVar.frQ, 1, alVar.xHk);
                        com.tencent.mm.plugin.emoji.c.cn(3);
                    }
                    d.a(alVar);
                    return;
                }
                clq = com.tencent.mm.a.g.i(file);
                Nx = emojiInfo.Nx();
                if (intValue == 101) {
                    Nx = emojiInfo.field_externMd5;
                }
                if (bi.oN(clq)) {
                }
                str3 = "MicroMsg.emoji.EmojiService";
                str4 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                objArr3 = new Object[3];
                objArr3[0] = clq;
                if (emojiInfo != null) {
                }
                objArr3[1] = emojiInfo != null ? "" : emojiInfo.Nx();
                if (emojiInfo != null) {
                }
                objArr3[2] = emojiInfo != null ? "" : emojiInfo.field_cdnUrl;
                x.i(str3, str4, objArr3);
                file.delete();
                d.a(alVar);
                if (intValue == 101) {
                    com.tencent.mm.plugin.emoji.c.cn(14);
                    com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 1, alVar.frQ, 0, alVar.xHk);
                    return;
                } else if (intValue != 102) {
                    com.tencent.mm.plugin.emoji.c.cn(5);
                    com.tencent.mm.plugin.emoji.c.a(alVar.frM, 2, 0, 1, alVar.frQ, 1, alVar.xHk);
                    return;
                } else {
                    com.tencent.mm.plugin.emoji.c.cn(5);
                    com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 1, alVar.frQ, 1, alVar.xHk);
                    return;
                }
            }
            str2 = "MicroMsg.emoji.EmojiService";
            clq = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
            objArr2 = new Object[6];
            if (emojiInfo != null) {
            }
            objArr2[0] = emojiInfo != null ? "" : emojiInfo.Nx();
            objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
            if (com.tencent.mm.a.g.bV(str) != null) {
            }
            objArr2[2] = com.tencent.mm.a.g.bV(str) != null ? "" : com.tencent.mm.a.g.bV(str);
            if (emojiInfo != null) {
            }
            objArr2[3] = emojiInfo != null ? "" : emojiInfo.field_aeskey;
            if (emojiInfo != null) {
            }
            objArr2[4] = emojiInfo != null ? "" : emojiInfo.field_encrypturl;
            if (alVar != null) {
            }
            objArr2[5] = alVar != null ? "" : alVar.xHj;
            x.i(str2, clq, objArr2);
            if (intValue != 101) {
                com.tencent.mm.plugin.emoji.c.a(alVar.frM, 3, 0, 1, alVar.frQ, 1, alVar.xHk);
            } else {
                com.tencent.mm.plugin.emoji.c.a(alVar.frM, 4, 0, 1, alVar.frQ, 1, alVar.xHk);
            }
            com.tencent.mm.loader.stub.b.deleteFile(str);
            d.a(alVar);
        }
    };
    public HashMap<Long, String> lDd = new HashMap();
    private boolean lDe = false;
    List<b> lDf = new LinkedList();
    private rb lDg;
    public a lDh = this.lDu;
    List lDi = Collections.synchronizedList(new ArrayList());

    private class b {
        EmojiInfo fpO;
        long frh;
        String fvn;
        String toUserName;

        public b(long j, String str, EmojiInfo emojiInfo, String str2) {
            this.frh = j;
            this.toUserName = str;
            this.fpO = emojiInfo;
            this.fvn = str2;
        }
    }

    public interface a {
        void h(EmojiInfo emojiInfo);
    }

    public d() {
        as.CN().a((int) ac.CTRL_BYTE, (e) this);
    }

    public final void a(String str, EmojiInfo emojiInfo, au auVar) {
        if (!bi.oN(str) && emojiInfo != null) {
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (emojiInfo == null || bi.oN(emojiInfo.field_groupId)) {
                i.aCm().aBP();
            } else {
                boolean z2;
                j aCm = i.aCm();
                String str2 = emojiInfo.field_groupId;
                if (bi.oN(str2)) {
                    x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
                    z2 = false;
                } else if (aCm.lCb || q.Gh()) {
                    m mVar;
                    if (aCm.lCf == null || !aCm.lCf.containsKey(str2)) {
                        mVar = new m();
                        mVar.field_prodcutID = str2;
                    } else {
                        mVar = (m) aCm.lCf.get(str2);
                    }
                    if (System.currentTimeMillis() - mVar.field_showTipsTime < aCm.lCc) {
                        x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                        aCm.aBP();
                        z2 = false;
                    } else {
                        String str3;
                        String str4;
                        Object[] objArr;
                        String str5;
                        Object[] objArr2;
                        int i;
                        String str6;
                        int i2;
                        Object[] objArr3;
                        if (mVar == null || System.currentTimeMillis() - mVar.field_setFlagTime <= 86400000) {
                            str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str4 = "no need to get reward today. continue count:%d total count:%d";
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(aCm.lCe == null ? 0 : aCm.lCe.field_continuCount);
                            objArr[1] = Integer.valueOf(aCm.lCe == null ? 0 : aCm.lCe.field_totalCount);
                            x.d(str3, str4, objArr);
                        } else if (aCm.lCe != null && str2.equalsIgnoreCase(aCm.lCe.field_prodcutID) && aCm.lCe.field_continuCount >= aCm.lCd - 1 && aCm.lCe.field_continuCount <= (aCm.lCd + 5) - 1) {
                            as.CN().a(new o(str2, o.lEQ), 0);
                        } else if (mVar.field_totalCount >= aCm.kLd - 1 && mVar.field_totalCount <= (aCm.kLd + 5) - 1) {
                            as.CN().a(new o(str2, o.lEQ), 0);
                        }
                        if (aCm.lCe == null || !str2.equalsIgnoreCase(aCm.lCe.field_prodcutID) || aCm.lCe.field_continuCount < aCm.lCd) {
                            if (mVar != null && mVar.field_totalCount >= aCm.kLd) {
                                if ((mVar.field_flag & o.lER) != o.lER || (mVar.field_flag & o.lES) == o.lES) {
                                    str5 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                                    objArr2 = new Object[4];
                                    objArr2[0] = Boolean.valueOf(false);
                                    objArr2[1] = str2;
                                    objArr2[2] = Integer.valueOf(aCm.lCe == null ? 0 : aCm.lCe.field_totalCount);
                                    i = 3;
                                    if (aCm.lCe == null) {
                                        str6 = str5;
                                        objArr = objArr2;
                                        Object[] objArr4 = objArr2;
                                        i2 = 3;
                                        i = 0;
                                        str2 = str4;
                                        objArr3 = objArr4;
                                        objArr3[i2] = Integer.valueOf(i);
                                        x.i(str6, str2, objArr);
                                    } else {
                                        str2 = str5;
                                        str5 = str4;
                                        objArr3 = objArr2;
                                    }
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d";
                                    objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(true);
                                    objArr[1] = str2;
                                    objArr[2] = Integer.valueOf(aCm.lCe == null ? 0 : aCm.lCe.field_totalCount);
                                    x.i(str3, str4, objArr);
                                    aCm.a(mVar, true);
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr3 = new Object[2];
                                    objArr3[0] = Integer.valueOf(0);
                                    objArr3[1] = aCm.lCe == null ? "" : aCm.lCe.field_prodcutID;
                                    gVar.h(12953, objArr3);
                                    z2 = true;
                                }
                            }
                            aCm.a(mVar, false);
                            z2 = false;
                        } else if ((aCm.lCe.field_flag & o.lER) != o.lER || (aCm.lCe.field_flag & o.lES) == o.lES) {
                            objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(false);
                            objArr2[1] = str2;
                            objArr2[2] = Integer.valueOf(aCm.lCe.field_continuCount);
                            i = 3;
                            str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str5 = "isNeedShowTip:%b productid:%s  continue count:%d flag:%d";
                            objArr3 = objArr2;
                        } else {
                            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", Boolean.valueOf(true), str2, Integer.valueOf(aCm.lCe.field_continuCount));
                            aCm.a(mVar, true);
                            com.tencent.mm.plugin.report.service.g.pWK.h(12953, Integer.valueOf(0), aCm.lCe.field_prodcutID);
                            z2 = true;
                        }
                        str6 = str2;
                        str2 = str5;
                        objArr = objArr3;
                        objArr3 = objArr2;
                        i2 = i;
                        i = aCm.lCe.field_flag;
                        objArr3[i2] = Integer.valueOf(i);
                        x.i(str6, str2, objArr);
                        aCm.a(mVar, false);
                        z2 = false;
                    }
                } else {
                    x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", Boolean.valueOf(aCm.lCb), Boolean.valueOf(q.Gh()));
                    z2 = false;
                }
                x.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", Boolean.valueOf(z2));
                z = z2;
            }
            if (auVar == null) {
                cg auVar2 = new au();
                if (emojiInfo.field_type == EmojiInfo.xIR || emojiInfo.field_type == EmojiInfo.xIS) {
                    auVar2.setType(1048625);
                } else {
                    auVar2.setType(47);
                }
                auVar2.dU(str);
                auVar2.eS(1);
                String FY = q.FY();
                boolean z3 = (emojiInfo.YI() || emojiInfo.isGif()) ? false : true;
                auVar2.setContent(aj.a(FY, currentTimeMillis, z3, emojiInfo.Nx(), z, ""));
                auVar2.dV(emojiInfo.Nx());
                auVar2.aq(bb.hU(auVar2.field_talker));
                as.Hm();
                j = currentTimeMillis;
                currentTimeMillis = com.tencent.mm.y.c.Fh().Q(auVar2);
            } else {
                long j2 = auVar.field_msgId;
                aj XW = aj.XW(auVar.field_content);
                if (XW.time != 0) {
                    j = XW.time;
                    currentTimeMillis = j2;
                } else {
                    return;
                }
            }
            x.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = " + currentTimeMillis);
            this.lDf.add(new b(currentTimeMillis, str, emojiInfo, String.valueOf(j)));
            if (!this.lDe || this.lDf.size() == 1) {
                this.lDe = true;
                as.CN().a(new r(String.valueOf(j), str, emojiInfo, currentTimeMillis), 0);
            }
            String str7 = emojiInfo.field_md5;
            zd(emojiInfo.field_groupId);
        }
    }

    public final void zd(final String str) {
        ah.y(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r12 = this;
                r0 = 1;
                r1 = 0;
                r2 = com.tencent.mm.plugin.emoji.model.i.aCl();
                r2 = r2.lCy;
                r3 = r2;
                r4 = android.text.TextUtils.isEmpty(r3);
                if (r4 != 0) goto L_0x0070;
            L_0x0010:
                r4 = new java.lang.StringBuilder;
                r4.<init>();
                r5 = com.tencent.mm.storage.emotion.EmojiGroupInfo.xIE;
                r4 = r4.append(r5);
                r4 = r4.toString();
                r4 = r3.equals(r4);
                if (r4 != 0) goto L_0x0070;
            L_0x0025:
                r4 = r2.xJd;
                r5 = new java.lang.StringBuilder;
                r6 = "274544";
                r5.<init>(r6);
                r5 = r5.append(r3);
                r5 = r5.toString();
                r6 = 0;
                r4 = r4.getLong(r5, r6);
                r6 = java.lang.System.currentTimeMillis();
                r8 = r6 - r4;
                r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
                r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
                if (r8 < 0) goto L_0x0061;
            L_0x004a:
                if (r0 == 0) goto L_0x0060;
            L_0x004c:
                com.tencent.mm.plugin.emoji.model.i.aCh();
                r0 = r2;
                r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                if (r2 == 0) goto L_0x0072;
            L_0x0057:
                r0 = "MicroMsg.emoji.EmojiMgrImpl";
                r1 = "doSceneGetEmotionDesc get emotion desc faild.";
                com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            L_0x0060:
                return;
            L_0x0061:
                r2 = r2.YA(r3);
                if (r2 != 0) goto L_0x0070;
            L_0x0067:
                r2 = r6 - r4;
                r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
                r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                if (r2 >= 0) goto L_0x004a;
            L_0x0070:
                r0 = r1;
                goto L_0x004a;
            L_0x0072:
                r2 = new com.tencent.mm.plugin.emoji.f.k;
                r2.<init>(r0);
                r0 = com.tencent.mm.y.as.CN();
                r0.a(r2, r1);
                goto L_0x0060;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.model.d.1.run():void");
            }
        });
    }

    public final boolean g(EmojiInfo emojiInfo) {
        al alVar;
        String str = null;
        if (emojiInfo == null) {
            x.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            alVar = null;
        } else {
            alVar = new al();
            alVar.frM = emojiInfo.field_md5;
            alVar.xHf = emojiInfo.field_type;
            alVar.xHg = emojiInfo.field_size;
            alVar.frQ = emojiInfo.field_groupId;
            alVar.xHk = emojiInfo.field_designerID;
            alVar.thumbUrl = emojiInfo.field_thumbUrl;
            alVar.fvT = emojiInfo.field_encrypturl;
            alVar.aeskey = emojiInfo.field_aeskey;
            alVar.width = emojiInfo.field_width;
            alVar.height = emojiInfo.field_height;
            alVar.nGV = emojiInfo.field_cdnUrl;
            alVar.xHl = emojiInfo.field_externUrl;
            alVar.xHm = emojiInfo.field_externMd5;
            alVar.xHo = emojiInfo.field_activityid;
        }
        alVar.talker = emojiInfo.talker;
        if (alVar == null) {
            x.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            alVar.xHn = false;
            a(alVar, null, true);
            if (emojiInfo != null) {
                str = emojiInfo.field_groupId;
            }
            zd(str);
        }
        return true;
    }

    public final void a(al alVar, com.tencent.mm.ad.d.a aVar, boolean z) {
        if (alVar == null) {
            x.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
            return;
        }
        EmojiInfo emojiInfo;
        if (!(aVar == null || aVar.hoa == null || aVar.hoa.vNT != alVar.fGj)) {
            alVar.gkC = bb.c(aVar);
            alVar.hGx = aVar.hoa.vNU;
            alVar.hXs = (long) aVar.hoa.pgR;
        }
        EmojiInfo YB = i.aCl().lCw.YB(alVar.frM);
        if (YB != null) {
            Object obj = null;
            if (!(bi.oN(alVar.frQ) || alVar.frQ.equals(YB.field_groupId))) {
                YB.field_groupId = alVar.frQ;
                obj = 1;
            }
            if (!(bi.oN(alVar.xHk) || alVar.xHk.equals(YB.field_designerID))) {
                YB.field_designerID = alVar.xHk;
                obj = 1;
            }
            if (!(bi.oN(alVar.thumbUrl) || alVar.thumbUrl.equals(YB.field_thumbUrl))) {
                YB.field_thumbUrl = alVar.thumbUrl;
                obj = 1;
            }
            if (!(bi.oN(alVar.fvT) || alVar.fvT.equals(YB.field_encrypturl))) {
                YB.field_encrypturl = alVar.fvT;
                obj = 1;
            }
            if (!(bi.oN(alVar.aeskey) || alVar.aeskey.equals(YB.field_aeskey))) {
                YB.field_aeskey = alVar.aeskey;
                obj = 1;
            }
            if (!(bi.oN(alVar.nGV) || alVar.nGV.equals(YB.field_cdnUrl))) {
                YB.field_cdnUrl = alVar.nGV;
                obj = 1;
            }
            if (alVar.width > 0 && alVar.width != YB.field_width) {
                YB.field_width = alVar.width;
                obj = 1;
            }
            if (alVar.height > 0 && alVar.height != YB.field_height) {
                YB.field_height = alVar.height;
                obj = 1;
            }
            if (!(bi.oN(alVar.xHl) || alVar.xHl.equals(YB.field_externUrl))) {
                YB.field_externUrl = alVar.xHl;
                obj = 1;
            }
            if (!(bi.oN(alVar.xHm) || alVar.xHm.equals(YB.field_externMd5))) {
                YB.field_externMd5 = alVar.xHm;
                obj = 1;
            }
            if (!(bi.oN(alVar.xHo) || alVar.xHo.equalsIgnoreCase(YB.field_activityid))) {
                YB.field_activityid = alVar.xHo;
                obj = 1;
            }
            if (obj != null) {
                i.aCl().lCw.p(YB);
                x.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", YB.field_designerID, YB.field_thumbUrl);
            }
            emojiInfo = YB;
        } else {
            x.d("MicroMsg.emoji.EmojiService", "jacks prepare Emoji check groupId&md5 handle remote server old emoji version");
            EmojiInfo emojiInfo2 = new EmojiInfo();
            emojiInfo2.field_md5 = alVar.frM;
            emojiInfo2.field_svrid = alVar.id;
            emojiInfo2.field_catalog = EmojiInfo.xIH;
            emojiInfo2.field_type = alVar.xHf;
            emojiInfo2.field_size = alVar.xHg;
            emojiInfo2.field_groupId = alVar.frQ;
            emojiInfo2.field_designerID = alVar.xHk;
            emojiInfo2.field_thumbUrl = alVar.thumbUrl;
            emojiInfo2.field_cdnUrl = alVar.nGV;
            emojiInfo2.field_temp = 1;
            emojiInfo2.field_encrypturl = alVar.fvT;
            emojiInfo2.field_aeskey = alVar.aeskey;
            emojiInfo2.field_designerID = alVar.xHk;
            emojiInfo2.field_thumbUrl = alVar.thumbUrl;
            emojiInfo2.field_state = EmojiInfo.xIX;
            emojiInfo2.field_width = alVar.width;
            emojiInfo2.field_height = alVar.height;
            emojiInfo2.field_externUrl = alVar.xHl;
            emojiInfo2.field_externMd5 = alVar.xHm;
            emojiInfo2.field_activityid = alVar.xHo;
            i.aCl().lCw.n(emojiInfo2);
            emojiInfo = emojiInfo2;
        }
        long j = 0;
        if (alVar.xHn) {
            emojiInfo.clh();
            if (alVar.fGj != 0) {
                as.Hm();
                cg G = com.tencent.mm.y.c.Fh().G(alVar.talker, alVar.fGj);
                if (G.field_msgSvrId == alVar.fGj) {
                    j = G.field_msgId;
                }
            }
            as.Hm();
            com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(alVar.talker);
            if (Xv == null || ((int) Xv.gKO) == 0) {
                com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x(alVar.talker);
                xVar.setType(2);
                as.Hm();
                com.tencent.mm.y.c.Ff().S(xVar);
            }
            au auVar = new au();
            auVar.setType(47);
            auVar.dU(alVar.talker);
            auVar.eS(q.gt(alVar.hXn) ? 1 : 0);
            auVar.dV(emojiInfo.Nx());
            auVar.ap(alVar.fGj);
            String str = alVar.hXn;
            boolean z2 = (emojiInfo.YI() || emojiInfo.isGif()) ? false : true;
            auVar.setContent(aj.a(str, 0, z2, emojiInfo.Nx(), false, alVar.xHj));
            auVar.aq(bb.n(auVar.field_talker, alVar.hXs));
            auVar.eR(3);
            if (!bi.oN(alVar.gkD)) {
                auVar.ea(alVar.gkD);
            }
            if (aVar == null) {
                int i = alVar.gkC;
                if (i != 0) {
                    auVar.fb(i);
                    if (auVar.field_msgId == 0 && auVar.field_isSend == 0 && (i & 2) != 0) {
                        auVar.aq(bb.f(auVar.field_talker, alVar.hXs, auVar.field_msgSeq));
                    }
                }
                if (alVar.hGx != 0) {
                    auVar.as((long) alVar.hGx);
                }
                x.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i), Integer.valueOf(alVar.hGx));
            } else {
                bb.a(auVar, aVar);
            }
            if (this.lDd != null && this.lDd.containsKey(Long.valueOf(auVar.field_msgSvrId))) {
                x.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
                auVar.setContent((String) this.lDd.get(Long.valueOf(auVar.field_msgSvrId)));
                auVar.setType(10000);
                this.lDd.remove(Long.valueOf(auVar.field_msgSvrId));
            }
            long i2 = bb.i(auVar);
            if (!q.gt(alVar.hXn)) {
                as.Hm();
                ((am) as.getNotification()).a(com.tencent.mm.y.c.Fh().dI(i2));
            }
            j = i2;
        }
        if (!emojiInfo.clh()) {
            if (!z) {
                x.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", Boolean.valueOf(z));
                this.lDi.remove(alVar.frM);
                a(alVar);
            } else if (this.lDi == null || !this.lDi.contains(alVar.frM)) {
                this.lDi.add(alVar.frM);
                String clq = emojiInfo.clq();
                if (n.aBX() && n.aBY() && !bi.oN(emojiInfo.field_externUrl) && !bi.oN(emojiInfo.field_externMd5)) {
                    i.aBL().a(alVar.xHl, f.i(clq + "_extern", alVar, emojiInfo, Integer.valueOf(101), Long.valueOf(j)), this.lDa);
                    com.tencent.mm.plugin.emoji.c.cn(10);
                } else if (!bi.oN(alVar.fvT) && !bi.oN(alVar.aeskey)) {
                    i.aBL().a(alVar.fvT, f.i(clq + "_encrypt", alVar, emojiInfo, Integer.valueOf(102), Long.valueOf(j)), this.lDa);
                    com.tencent.mm.plugin.emoji.c.cn(6);
                } else if (bi.oN(alVar.nGV)) {
                    this.lDi.remove(alVar.frM);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(alVar.frM);
                    as.CN().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
                    x.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", alVar.frM);
                    com.tencent.mm.plugin.emoji.c.cn(9);
                } else {
                    i.aBL().a(alVar.nGV, f.h(clq, alVar, emojiInfo, Integer.valueOf(100), Long.valueOf(j)), this.lDa);
                    com.tencent.mm.plugin.emoji.c.cn(1);
                }
            } else {
                x.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", alVar.frM);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 2;
        x.d("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(kVar instanceof r)) {
            return;
        }
        if (this.lDf.size() <= 0) {
            this.lDe = false;
            return;
        }
        b bVar;
        b bVar2 = (b) this.lDf.remove(0);
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.d.pVE.a(111, 35, 1, true);
            i3 = 5;
        }
        as.Hm();
        au dI = com.tencent.mm.y.c.Fh().dI(bVar2.frh);
        dI.eR(i3);
        as.Hm();
        com.tencent.mm.y.c.Fh().a(bVar2.frh, dI);
        if (this.lDf.size() > 0) {
            bVar = (b) this.lDf.get(0);
            as.CN().a(new r(bVar.fvn, bVar.toUserName, bVar.fpO, bVar.frh), 0);
        } else {
            this.lDe = false;
            bVar = bVar2;
        }
        if (this.lDg == null) {
            this.lDg = new rb();
        }
        this.lDg.fJI.frQ = bVar.fpO.field_groupId;
        com.tencent.mm.sdk.b.a.xmy.m(this.lDg);
    }

    static void a(al alVar) {
        if (alVar != null) {
            as.Hm();
            com.tencent.mm.y.c.Fh().a(new com.tencent.mm.plugin.messenger.foundation.a.a.c.c(alVar.talker, "update", null));
        }
    }
}
