# so this works in python but not java
# I'm so confused

# it was because java ints are tiny
# this is much slower than java now but I'm not debugging it you can't make me 
#   (13.23s vs 0.33s)

from time import time

def main():
    start_time = time()
    
    print(run(1000000)) 
    # print(leng(837799))

    print(str(round(time() - start_time, 2)) + 's')

def leng (num: int) -> int:
    if num == 1: return 1
    temp = num
    ret = 1
    while (temp > 1):
        if temp % 2 == 0:
            temp = temp/2
        else:
            temp = 3*temp + 1
        ret += 1
    return ret

def run (max: int) -> str:
    current_max = 1
    current_max_len = 0

    for i in range(max):
        length = leng(i)
        if length > current_max_len:
            current_max = i
            current_max_len = length
    return str(current_max) + ' with a length of ' + str(current_max_len)

if __name__  == '__main__':
    main()