def pad_start(s, num, ch):
    result = s
    if num > len(s):
        result = (ch * (num - len(s))) + s
    return result

def a(s):
    i = int(s[:2])
    i2 = int(s[2:4])
    i3 = int(s[4:6])
    i4 = int(s[6:8])
    i5 = int(s[8:])

    i6 = i4 ^ i3
    i7 = i5 ^ i3
    i8 = i3 ^ (i6 + i7)
    i9 = i ^ i7
    i10 = i2 ^ i7
    return pad_start(str(i9), 2, '0') + pad_start(str(i10), 2, '0') + pad_start(str(i6), 2, '0') + pad_start(str(i7), 2, '0') + pad_start(str(i8), 2, '0')

def b(s):
    i = int(s[:2])
    i2 = int(s[2:4])
    i3 = int(s[4:6])
    i4 = int(s[6:8])
    i5 = int(s[8:])

    i6 = i5 ^ (i3 + i4)
    i7 = i4 ^ i6
    i8 = i3 ^ i6
    i9 = i ^ i6
    i10 = i2 ^ i6
    return pad_start(str(i9), 2, '0') + pad_start(str(i10), 2, '0') + pad_start(str(i8), 2, '0') + pad_start(str(i7), 2, '0') + pad_start(str(i6), 2, '0')

def c(s):
    i = int(s[:2])
    i2 = int(s[2:4])
    i3 = int(s[4:])

    i5 = i3 ^ (i + i2)
    i6 = i ^ i5
    i4 = i2 ^ i5

    return pad_start(str(i6), 2, '0') + pad_start(str(i4), 2, '0') + pad_start(str(i5), 2, '0')

def d(s):
    i = int(s[:2])
    i2 = int(s[2:4])
    i3 = int(s[4:])

    i5 = i2 ^ i
    i6 = i3 ^ i
    i4 = i ^ (i5 + i6)

    return pad_start(str(i5), 2, '0') + pad_start(str(i6), 2, '0') + pad_start(str(i4), 2, '0')

def middle(s, fill):
    import shutil
    terminal_width = shutil.get_terminal_size().columns
    len_s = len(s)
    x = (terminal_width - len_s) // 2
    print(fill * x + s + fill * (x + len_s - terminal_width))

if __name__ == "__main__":
    middle("ENCODE", '=')
    middle("Dev. by cmc", ' ')
    mode = int(input("Input Mode: "))
    if mode == 1:
        middle("ADB", '=')
        s = input("Input code: ")
        middle("RESULT", ' ')
        middle(a(b(s)), ' ')
    else:
        middle("SELFTEST", '=')
        s = input("Input code: ")
        R1 = c(s)
        middle("RESULT", ' ')
        middle(d(R1), ' ')
    input("Press Enter to exit...")
