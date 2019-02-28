package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.bp.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements com.tencent.mm.y.bt.a {
    public final void a(com.tencent.mm.ad.d.a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar.nlX == 10002) {
            String a = n.a(bxVar.vNO);
            if (bi.oN(a)) {
                x.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y != null && y.size() > 0) {
                String str = (String) y.get(".sysmsg.$type");
                String bA = bi.bA(b.be(q.yM().getBytes()).CW(16).oz);
                int intValue;
                if (!bi.oN(str) && str.equalsIgnoreCase("EmojiBackup")) {
                    intValue = Integer.valueOf((String) y.get(".sysmsg.EmojiBackup.OpCode")).intValue();
                    str = (String) y.get(".sysmsg.EmojiBackup.DeviceID");
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", bA, str);
                    if (bi.oN(str) || !str.equalsIgnoreCase(bA)) {
                        ArrayList zf = b.zf(a);
                        if (intValue == 1) {
                            if (zf == null || zf.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", Integer.valueOf(zf.size()));
                            ArrayList arrayList = new ArrayList();
                            int size = zf.size();
                            for (int i = 0; i < size; i++) {
                                sf sfVar = (sf) zf.get(i);
                                if (sfVar != null) {
                                    EmojiInfo YB = i.aCl().lCw.YB(sfVar.wgP);
                                    if (YB != null && YB.clh() && YB.field_catalog == EmojiInfo.xIN) {
                                        x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "md5:%s not need to download", sfVar.wgP);
                                    } else {
                                        arrayList.add(new com.tencent.mm.plugin.emoji.sync.a.a(sfVar.wgP, sfVar.nlE, sfVar.phv, sfVar.wgQ, sfVar.wgR, sfVar.wgS, sfVar.vPI, sfVar.wgV));
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                i.aCi().s(arrayList);
                                i.aCi().lFb.aCG();
                            }
                        } else if (intValue == 2) {
                            if (zf == null || zf.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            List arrayList2 = new ArrayList();
                            if (zf != null && zf.size() > 0) {
                                Iterator it = zf.iterator();
                                while (it.hasNext()) {
                                    sf sfVar2 = (sf) it.next();
                                    if (sfVar2 != null) {
                                        arrayList2.add(sfVar2.wgP);
                                    }
                                }
                            }
                            i.aCl().lCw.cY(arrayList2);
                            as.Hm();
                            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.valueOf(false));
                        } else if (intValue == 3) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                            as.Hm();
                            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_LAST_BATCH_EMOJI_DOWNLOAD_TIME_2_LONG, Long.valueOf(0));
                        }
                        as.Hm();
                        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.valueOf(true));
                        return;
                    }
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                } else if (bi.oN(str) || !str.equalsIgnoreCase("EmotionBackup")) {
                    x.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                } else {
                    intValue = Integer.valueOf((String) y.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) y.get(".sysmsg.EmotionBackup.DeviceID");
                    if (bi.oN(str) || !str.equalsIgnoreCase(bA)) {
                        ArrayList zg = b.zg(a);
                        if (zg == null || zg.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            return;
                        } else if (intValue == 1) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", Integer.valueOf(zg.size()));
                            ArrayList arrayList3 = new ArrayList();
                            intValue = zg.size();
                            for (int i2 = 0; i2 < intValue; i2++) {
                                arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.b((String) zg.get(i2)));
                            }
                            i.aCi().t(arrayList3);
                            i.aCi().lFb.aCG();
                            return;
                        } else if (intValue == 2) {
                            x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", Integer.valueOf(zg.size()));
                            i.aCl().lCx.af(zg);
                            return;
                        } else {
                            return;
                        }
                    }
                    x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(bxVar.nlX));
    }
}
