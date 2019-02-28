package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

public final class i {
    static final short[] Aoe = new short[0];
    public final t Aof = new t();
    private final f Aog = new f();
    private final g Aoh = new g();
    private final h Aoi = new h();
    private final d Aoj = new d();
    private final b Aok = new b();
    private final c Aol = new c();
    private final a Aom = new a();
    private int Aon = 0;
    private byte[] Aoo = null;
    public ByteBuffer aif;

    private final class b extends AbstractList<n> implements RandomAccess {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            i.fJ(i, i.this.Aof.AoE.size);
            return i.this.Iv(i.this.Aof.AoE.dzH + (i * 8)).cHl();
        }

        public final int size() {
            return i.this.Aof.AoE.size;
        }
    }

    private final class d extends AbstractList<r> implements RandomAccess {
        private d() {
        }

        /* synthetic */ d(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            i.fJ(i, i.this.Aof.AoD.size);
            return i.this.Iv(i.this.Aof.AoD.dzH + (i * 12)).cHn();
        }

        public final int size() {
            return i.this.Aof.AoD.size;
        }
    }

    public final class e extends com.tencent.tinker.a.a.a.a {
        private final String name;

        /* synthetic */ e(i iVar, String str, ByteBuffer byteBuffer, byte b) {
            this(str, byteBuffer);
        }

        private e(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.name = str;
        }

        public final s cHj() {
            a(i.this.Aof.AoN, false);
            return super.cHj();
        }

        public final u cHk() {
            a(i.this.Aof.AoI, false);
            return super.cHk();
        }

        public final n cHl() {
            a(i.this.Aof.AoE, false);
            return super.cHl();
        }

        public final p cHm() {
            a(i.this.Aof.AoF, false);
            return super.cHm();
        }

        public final r cHn() {
            a(i.this.Aof.AoD, false);
            return super.cHn();
        }

        public final f cHo() {
            a(i.this.Aof.AoG, false);
            return super.cHo();
        }

        public final g cHp() {
            a(i.this.Aof.AoM, false);
            return super.cHp();
        }

        public final h cHq() {
            a(i.this.Aof.AoO, false);
            return super.cHq();
        }

        public final e cHr() {
            a(i.this.Aof.AoL, false);
            return super.cHr();
        }

        public final a cHs() {
            a(i.this.Aof.AoP, false);
            return super.cHs();
        }

        public final b cHt() {
            a(i.this.Aof.AoK, false);
            return super.cHt();
        }

        public final c cHu() {
            a(i.this.Aof.AoJ, false);
            return super.cHu();
        }

        public final d cHv() {
            a(i.this.Aof.AoR, false);
            return super.cHv();
        }

        public final k cHw() {
            a(i.this.Aof.AoQ, false);
            return super.cHw();
        }

        private void a(com.tencent.tinker.a.a.t.a aVar, boolean z) {
            if (!aVar.AoY) {
                return;
            }
            if (z) {
                super.Iz((((this.aif.position() + 3) & -4) - this.aif.position()) * 1);
                while ((this.aif.position() & 3) != 0) {
                    this.aif.put((byte) 0);
                }
                if (this.aif.position() > this.Ape) {
                    this.Ape = this.aif.position();
                    return;
                }
                return;
            }
            this.aif.position((this.aif.position() + 3) & -4);
        }

        public final int a(s sVar) {
            a(i.this.Aof.AoN, true);
            return super.a(sVar);
        }

        public final int a(u uVar) {
            a(i.this.Aof.AoI, true);
            return super.a(uVar);
        }

        public final int a(n nVar) {
            a(i.this.Aof.AoE, true);
            return super.a(nVar);
        }

        public final int a(p pVar) {
            a(i.this.Aof.AoF, true);
            return super.a(pVar);
        }

        public final int a(r rVar) {
            a(i.this.Aof.AoD, true);
            return super.a(rVar);
        }

        public final int a(f fVar) {
            a(i.this.Aof.AoG, true);
            return super.a(fVar);
        }

        public final int a(g gVar) {
            a(i.this.Aof.AoM, true);
            return super.a(gVar);
        }

        public final int a(h hVar) {
            a(i.this.Aof.AoO, true);
            return super.a(hVar);
        }

        public final int a(e eVar) {
            a(i.this.Aof.AoL, true);
            return super.a(eVar);
        }

        public final int a(a aVar) {
            a(i.this.Aof.AoP, true);
            return super.a(aVar);
        }

        public final int a(b bVar) {
            a(i.this.Aof.AoK, true);
            return super.a(bVar);
        }

        public final int a(c cVar) {
            a(i.this.Aof.AoJ, true);
            return super.a(cVar);
        }

        public final int a(d dVar) {
            a(i.this.Aof.AoR, true);
            return super.a(dVar);
        }

        public final int a(k kVar) {
            a(i.this.Aof.AoQ, true);
            return super.a(kVar);
        }
    }

    private final class a extends AbstractList<f> implements RandomAccess {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            i.fJ(i, i.this.Aof.AoG.size);
            return i.this.Iv(i.this.Aof.AoG.dzH + (i * 32)).cHo();
        }

        public final int size() {
            return i.this.Aof.AoG.size;
        }
    }

    private final class c extends AbstractList<p> implements RandomAccess {
        private c() {
        }

        /* synthetic */ c(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            i.fJ(i, i.this.Aof.AoF.size);
            return i.this.Iv(i.this.Aof.AoF.dzH + (i * 8)).cHm();
        }

        public final int size() {
            return i.this.Aof.AoF.size;
        }
    }

    private final class g extends AbstractList<Integer> implements RandomAccess {
        private g() {
        }

        /* synthetic */ g(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            return Integer.valueOf(i.this.Iw(i));
        }

        public final int size() {
            return i.this.Aof.AoC.size;
        }
    }

    private final class h extends AbstractList<String> implements RandomAccess {
        private h() {
        }

        /* synthetic */ h(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            return i.this.Aog.tu(i.this.Iw(i));
        }

        public final int size() {
            return i.this.Aof.AoC.size;
        }
    }

    private final class f extends AbstractList<String> implements RandomAccess {
        private f() {
        }

        /* synthetic */ f(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object get(int i) {
            return tu(i);
        }

        public final String tu(int i) {
            i.fJ(i, i.this.Aof.AoB.size);
            return i.this.Iv(i.this.Iv(i.this.Aof.AoB.dzH + (i * 4)).aif.getInt()).cHj().value;
        }

        public final int size() {
            return i.this.Aof.AoB.size;
        }
    }

    public i(int i) {
        this.aif = ByteBuffer.wrap(new byte[i]);
        this.aif.order(ByteOrder.LITTLE_ENDIAN);
        this.Aof.fileSize = i;
    }

    public i(InputStream inputStream) {
        int i;
        Object i2 = -1;
        this.aif = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.b(inputStream, 0));
        this.aif.order(ByteOrder.LITTLE_ENDIAN);
        t tVar = this.Aof;
        com.tencent.tinker.a.a.a.a a = a(tVar.AoA);
        byte[] IA = a.IA(8);
        if (IA.length == 8 && IA[0] == (byte) 100 && IA[1] == (byte) 101 && IA[2] == (byte) 120 && IA[3] == (byte) 10 && IA[7] == (byte) 0) {
            String str = ((char) IA[4]) + ((char) IA[5]) + ((char) IA[6]);
            if (str.equals("036")) {
                i2 = 14;
            } else if (str.equals("035")) {
                i2 = 13;
            }
        }
        if (i2 != 13) {
            throw new j("Unexpected magic: " + Arrays.toString(IA));
        }
        tVar.hZs = a.aif.getInt();
        tVar.Aoo = a.IA(20);
        tVar.fileSize = a.aif.getInt();
        i2 = a.aif.getInt();
        if (i2 != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i2));
        }
        i2 = a.aif.getInt();
        if (i2 != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i2));
        }
        tVar.AoT = a.aif.getInt();
        tVar.AoU = a.aif.getInt();
        tVar.AoH.dzH = a.aif.getInt();
        if (tVar.AoH.dzH == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        tVar.AoB.size = a.aif.getInt();
        tVar.AoB.dzH = a.aif.getInt();
        tVar.AoC.size = a.aif.getInt();
        tVar.AoC.dzH = a.aif.getInt();
        tVar.AoD.size = a.aif.getInt();
        tVar.AoD.dzH = a.aif.getInt();
        tVar.AoE.size = a.aif.getInt();
        tVar.AoE.dzH = a.aif.getInt();
        tVar.AoF.size = a.aif.getInt();
        tVar.AoF.dzH = a.aif.getInt();
        tVar.AoG.size = a.aif.getInt();
        tVar.AoG.dzH = a.aif.getInt();
        tVar.AoV = a.aif.getInt();
        tVar.AoW = a.aif.getInt();
        tVar.a(Iv(tVar.AoH.dzH));
        tVar.cHH();
    }

    private static void fJ(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final e Iv(int i) {
        if (i < 0 || i >= this.aif.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aif.capacity());
        }
        ByteBuffer duplicate = this.aif.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.aif.capacity());
        return new e(this, "temp-section", duplicate, (byte) 0);
    }

    public final e a(com.tencent.tinker.a.a.t.a aVar) {
        int i = aVar.dzH;
        if (i < 0 || i >= this.aif.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.aif.capacity());
        }
        ByteBuffer duplicate = this.aif.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + aVar.AoZ);
        return new e(this, "section", duplicate, (byte) 0);
    }

    public final byte[] of(boolean z) {
        if (this.Aoo != null && !z) {
            return this.Aoo;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.aif.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.Aoo = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final void cHi() {
        Iv(12).write(of(true));
        e Iv = Iv(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.aif.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        Iv.writeInt((int) adler32.getValue());
    }

    public final int Iw(int i) {
        fJ(i, this.Aof.AoC.size);
        return this.aif.getInt(this.Aof.AoC.dzH + (i * 4));
    }
}
