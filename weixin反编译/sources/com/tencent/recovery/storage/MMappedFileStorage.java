package com.tencent.recovery.storage;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class MMappedFileStorage {
    private int AaW;
    private File AaX;
    private File AaY;
    private MappedByteBuffer AaZ;
    private RandomAccessFile Aba;
    private int currentIndex;

    public final synchronized void f(byte[] bArr, boolean z) {
        try {
            if (this.Aba == null) {
                if (!this.AaY.exists()) {
                    this.AaY.createNewFile();
                }
                this.Aba = new RandomAccessFile(this.AaY, "rw");
            }
            if (this.AaZ == null) {
                this.AaZ = this.Aba.getChannel().map(MapMode.READ_WRITE, 0, (long) this.AaW);
            }
            if (!(this.AaY == null || this.AaZ == null)) {
                if (this.currentIndex + bArr.length > this.AaW || z) {
                    this.AaZ.force();
                    try {
                        this.Aba.close();
                    } catch (IOException e) {
                    }
                    h(this.AaY, this.AaX);
                    this.currentIndex = 4;
                    this.AaY.delete();
                    this.AaY.createNewFile();
                    this.Aba = new RandomAccessFile(this.AaY, "rw");
                    this.AaZ = this.Aba.getChannel().map(MapMode.READ_WRITE, 0, (long) this.AaW);
                    this.AaZ.putInt(this.currentIndex - 4);
                }
                if (bArr.length >= 0) {
                    this.AaZ.position(this.currentIndex);
                    this.AaZ.put(bArr);
                    this.AaZ.position(0);
                    this.currentIndex += bArr.length;
                    this.AaZ.putInt(this.currentIndex - 4);
                }
            }
        } catch (Throwable e2) {
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e2, "appendToBuffer", new Object[0]);
        }
        return;
    }

    private static void h(File file, File file2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        DataInputStream dataInputStream = null;
        int i = 0;
        try {
            int readInt;
            DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
            try {
                readInt = dataInputStream2.readInt();
                fileOutputStream = new FileOutputStream(file2, true);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                dataInputStream = dataInputStream2;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int i2 = i;
                    i = i2 + WXMediaMessage.DESCRIPTION_LENGTH_LIMIT > readInt ? readInt - i2 : WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    if (i > 0) {
                        i = dataInputStream2.read(bArr, 0, i);
                        if (i > 0) {
                            fileOutputStream.write(bArr, 0, i);
                            i += i2;
                        }
                    }
                    try {
                        dataInputStream2.close();
                    } catch (IOException e7) {
                    }
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException e8) {
                        return;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                dataInputStream = dataInputStream2;
                RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }
}
