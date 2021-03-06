CC=gcc

TARGET=libvtd.a
INCLUDE = -I.
CFLAGS= -c -ggdb -O3 -Wall -Winline -fgnu89-inline -fomit-frame-pointer -fforce-addr -frerun-cse-after-loop -fexpensive-optimizations -fregmove -frerun-loop-opt -fmerge-all-constants -fno-branch-count-reg -funroll-loops -fpeephole -falign-functions -falign-loops -falign-jumps -freorder-blocks -freorder-functions -fprefetch-loop-arrays -funswitch-loops -fbranch-target-load-optimize2 -fvpt --param inline-unit-growth=300 --param max-inline-recursive-depth=2 --param large-function-growth=600 #-Wno-unused-variable -Wno-pointer-to-int-cast -Wno-unused-function -Wno-unused-but-set-variable -Wno-unused-but-set-variable -Wno-strict-overflow -Wno-parentheses -Wno-int-to-pointer-cast -Wno-pointer-sign -Wno-maybe-uninitialized -Wno-switch -Wno-char-subscripts -Wno-inline -Wno-sequence-point -Wno-implicit-int -Wno-incompatible-pointer-types -Wno-return-type -fPIC

LDFLAGS = -O3 -ggdb -fomit-frame-pointer -fforce-addr -frerun-cse-after-loop -fexpensive-optimizations -fregmove -frerun-loop-opt -lm -fPIC

.SUFFIXES: .o .c

.c.o:
	$(CC) $(CFLAGS) $(INCLUDE) -o $*.o $<

ALL.O = arrayList.o autoPilot.o binaryExpr.o bookMark.o cachedExpr.o contextBuffer.o decoder.o elementFragmentNs.o fastIntBuffer.o fastLongBuffer.o filterExpr.o funcExpr.o helper.o indexHandler.o intHash.o l8.tab.o lex.yy.o literalExpr.o locationPathExpr.o nodeRecorder.o numberExpr.o pathExpr.o textIter.o transcoder.o unaryExpr.o unionExpr.o variableExpr.o vtdGen.o vtdNav.o XMLChar.o XMLModifier.o


# Have to redefine bind since it is used in socket.h (curl, etc.)
$(TARGET): $(ALL.O)
	ar rcs $@ $^
	ctags *.c *.h

clean:
	rm -f $(ALL.O) $(TARGET) tags
