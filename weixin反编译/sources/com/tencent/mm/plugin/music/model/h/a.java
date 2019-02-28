package com.tencent.mm.plugin.music.model.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends i<com.tencent.mm.au.a> {
    public e gLA;
    public f<String, com.tencent.mm.au.a> oSw = new f(20);
    public f<String, com.tencent.mm.plugin.music.model.a> oSx = new f(10);

    public a(e eVar) {
        super(eVar, com.tencent.mm.au.a.gKN, "Music", null);
        this.gLA = eVar;
    }

    public final com.tencent.mm.au.a Hc(String str) {
        if (this.oSw.get(str) != null) {
            return (com.tencent.mm.au.a) this.oSw.get(str);
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor a = this.gLA.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            return null;
        }
        com.tencent.mm.au.a aVar = new com.tencent.mm.au.a();
        aVar.b(a);
        a.close();
        this.oSw.put(str, aVar);
        return aVar;
    }

    public final com.tencent.mm.plugin.music.model.a g(com.tencent.mm.au.a aVar, boolean z) {
        com.tencent.mm.plugin.music.model.a.a aVar2;
        String str = aVar.field_songLyric;
        String string = ad.getContext().getString(R.l.exe);
        String str2 = aVar.field_songSnsShareUser;
        boolean d = g.d(aVar);
        String str3 = aVar.field_songSinger;
        com.tencent.mm.plugin.music.model.a aVar3 = new com.tencent.mm.plugin.music.model.a();
        long Wz = bi.Wz();
        if (bi.oN(str)) {
            com.tencent.mm.plugin.music.model.a.a aVar4 = new com.tencent.mm.plugin.music.model.a.a();
            aVar4.timestamp = 0;
            if (z) {
                aVar4.content = str3;
            } else if (d) {
                aVar4.content = ad.getContext().getString(R.l.eyp);
            } else {
                aVar4.content = ad.getContext().getString(R.l.eyo);
            }
            if (aVar4.content != null) {
                aVar3.oOQ.add(aVar4);
            }
        } else {
            if (str != null) {
                int i;
                int i2;
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll("\n", " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    CharSequence group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        x.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        aVar3.title = com.tencent.mm.plugin.music.model.a.dA(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        aVar3.jhQ = com.tencent.mm.plugin.music.model.a.dA(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        aVar3.album = com.tencent.mm.plugin.music.model.a.dA(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        aVar3.oOS = com.tencent.mm.plugin.music.model.a.dA(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        aVar3.oJ = bi.getLong(com.tencent.mm.plugin.music.model.a.dA(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        aVar3.oOT = com.tencent.mm.plugin.music.model.a.dA(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        aVar3.oOU = com.tencent.mm.plugin.music.model.a.dA(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        com.tencent.mm.plugin.music.model.a.a aVar5 = new com.tencent.mm.plugin.music.model.a.a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                aVar5.timestamp = com.tencent.mm.plugin.music.model.a.Gp(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                aVar3.oOR.add(Long.valueOf(aVar5.timestamp));
                                break;
                            }
                            String str4 = split[split.length - 1];
                            if (str4 != null) {
                                str4 = str4.trim();
                            }
                            if (bi.oN(str4)) {
                                str4 = " ";
                            }
                            aVar5.content = str4;
                            i = 0;
                            while (true) {
                                i2 = i;
                                if (i2 >= aVar3.oOR.size()) {
                                    break;
                                }
                                com.tencent.mm.plugin.music.model.a.a aVar6 = new com.tencent.mm.plugin.music.model.a.a();
                                aVar6.timestamp = ((Long) aVar3.oOR.get(i2)).longValue();
                                aVar6.content = aVar5.content;
                                aVar6.oOW = true;
                                i = i2 + 1;
                            }
                            aVar3.oOR.clear();
                            i2 = aVar3.oOQ.size() - 1;
                            while (i2 >= 0 && ((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(i2)).timestamp != aVar5.timestamp) {
                                if (((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(i2)).timestamp < aVar5.timestamp) {
                                    aVar3.oOQ.add(i2 + 1, aVar5);
                                    break;
                                }
                                i2--;
                            }
                            if (i2 < 0) {
                                aVar3.oOQ.add(0, aVar5);
                            }
                        }
                    }
                }
                x.d("MicroMsg.Music.LyricObj", "handle offset %d", Long.valueOf(aVar3.oJ));
                if (aVar3.oJ != 0) {
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= aVar3.oOQ.size()) {
                            break;
                        }
                        aVar2 = (com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(i2);
                        aVar2.timestamp += aVar3.oJ;
                        i = i2 + 1;
                    }
                    aVar3.oJ = 0;
                }
                i = 0;
                while (true) {
                    int i3 = i;
                    if (i3 >= aVar3.oOQ.size() - 1) {
                        break;
                    }
                    aVar2 = (com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(i3);
                    if (aVar2.oOW && aVar2.content.equals(((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(i3 + 1)).content)) {
                        aVar2.content = " ";
                    }
                    i = i3 + 1;
                }
            } else {
                x.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            }
            x.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", str);
            x.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", Integer.valueOf(aVar3.oOQ.size()));
        }
        if (bi.oN(str2)) {
            x.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            aVar2 = new com.tencent.mm.plugin.music.model.a.a();
            aVar2.timestamp = 0;
            aVar2.content = ad.getContext().getString(R.l.eSE, new Object[]{r.gw(str2)});
            if (aVar3.oOQ.isEmpty()) {
                aVar3.oOQ.add(aVar2);
            } else if (aVar3.oOQ.size() == 1) {
                aVar3.oOQ.add(0, aVar2);
                ((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(1)).timestamp = 5000;
            } else {
                aVar3.oOQ.add(0, aVar2);
                ((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(2)).timestamp >> 2);
            }
        }
        if (!bi.oN(str)) {
            if (bi.oN(string)) {
                x.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                aVar2 = new com.tencent.mm.plugin.music.model.a.a();
                aVar2.timestamp = 0;
                aVar2.content = string;
                if (aVar3.oOQ.isEmpty()) {
                    aVar3.oOQ.add(aVar2);
                } else if (aVar3.oOQ.size() == 1) {
                    aVar3.oOQ.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(1)).timestamp = 5000;
                } else {
                    aVar3.oOQ.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.model.a.a) aVar3.oOQ.get(2)).timestamp >> 2);
                }
            }
        }
        x.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", Long.valueOf(bi.bB(Wz)));
        this.oSx.put(aVar.field_musicId, aVar3);
        return aVar3;
    }

    public final com.tencent.mm.au.a P(String str, int i, int i2) {
        x.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        com.tencent.mm.au.a Hc = Hc(str);
        if (Hc == null) {
            x.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", str);
            return null;
        }
        Hc.field_songBgColor = i;
        Hc.field_songLyricColor = i2;
        c(Hc, "songBgColor", "songLyricColor");
        this.oSw.put(str, Hc);
        return Hc;
    }

    public final com.tencent.mm.au.a x(ati ati) {
        c aVar;
        int i;
        String i2 = g.i(ati);
        c Hc = Hc(i2);
        if (Hc == null) {
            aVar = new com.tencent.mm.au.a();
            i = 0;
        } else {
            aVar = Hc;
            i = 1;
        }
        aVar.field_musicId = i2;
        aVar.field_originMusicId = ati.wdd;
        aVar.field_musicType = ati.wHt;
        aVar.field_appId = ati.nlV;
        if (bi.oN(aVar.field_appId)) {
            aVar.field_appId = g.k(ati);
        }
        aVar.field_songAlbum = ati.wHx;
        aVar.field_songAlbumType = ati.wHF;
        aVar.field_songWifiUrl = ati.wHz;
        aVar.field_songName = ati.wHv;
        aVar.field_songSinger = ati.wHw;
        aVar.field_songWapLinkUrl = ati.wHA;
        aVar.field_songWebUrl = ati.wHB;
        aVar.field_songAlbumLocalPath = ati.wHD;
        aVar.field_songMediaId = ati.wgu;
        aVar.field_songSnsAlbumUser = ati.wHJ;
        aVar.field_songAlbumUrl = ati.wHy;
        aVar.field_songSnsShareUser = ati.wHK;
        if (!bi.oN(ati.wHG)) {
            aVar.field_songHAlbumUrl = ati.wHG;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        if (aVar.field_songId == 0) {
            g.h(ati);
            aVar.field_songId = ati.wub;
        }
        if ((bi.oN(aVar.field_songWapLinkUrl) || aVar.field_songWapLinkUrl.equals(aVar.field_songWebUrl)) && !bi.oN(aVar.field_songWifiUrl)) {
            aVar.field_songWapLinkUrl = aVar.field_songWifiUrl;
        }
        if (aVar.field_songId == 0 && ati.wHt == 4) {
            try {
                aVar.field_songId = Integer.valueOf(ati.wdd).intValue();
            } catch (Exception e) {
            }
        }
        aVar.field_hideBanner = ati.wHM;
        aVar.field_jsWebUrlDomain = ati.wHN;
        aVar.field_startTime = ati.hmd;
        aVar.hJD = ati.hJD;
        aVar.field_protocol = ati.protocol;
        aVar.field_barBackToWebView = ati.wHO;
        aVar.field_musicbar_url = ati.wHP;
        if (i != 0) {
            x.i("MicroMsg.Music.MusicStorage", "update music %s", i2);
            c(aVar, new String[0]);
        } else {
            x.i("MicroMsg.Music.MusicStorage", "insert music %s", i2);
            b(aVar);
        }
        this.oSw.put(i2, aVar);
        return aVar;
    }

    public final void Y(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = this.gLA.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", Integer.valueOf(update), str, Long.valueOf(j));
        com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) this.oSw.get(str);
        if (aVar != null) {
            aVar.field_wifiDownloadedLength = j;
        }
    }

    public final void Z(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        int update = this.gLA.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", Integer.valueOf(update), str, Long.valueOf(j));
        com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) this.oSw.get(str);
        if (aVar != null) {
            aVar.field_songWifiFileLength = j;
        }
    }

    public final void bN(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiEndFlag", Integer.valueOf(i));
        int update = this.gLA.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", Integer.valueOf(update), str, Integer.valueOf(i));
        com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) this.oSw.get(str);
        if (aVar != null) {
            aVar.field_wifiEndFlag = i;
        }
    }

    public final void aa(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        int update = this.gLA.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", Integer.valueOf(update), str, Long.valueOf(j));
        com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) this.oSw.get(str);
        if (aVar != null) {
            aVar.field_downloadedLength = j;
        }
    }

    public final void bO(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("endFlag", Integer.valueOf(i));
        int update = this.gLA.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", Integer.valueOf(update), str, Integer.valueOf(i));
        com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) this.oSw.get(str);
        if (aVar != null) {
            aVar.field_endFlag = i;
        }
    }

    public final void ab(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        int update = this.gLA.update("Music", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", Integer.valueOf(update), str, Long.valueOf(j));
        com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) this.oSw.get(str);
        if (aVar != null) {
            aVar.field_songFileLength = j;
        }
    }
}
