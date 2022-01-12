
def leng (num: int) -> int:
    if num == 1: return 1
    ret: int
    if num % 2 == 0:
        ret = leng(num/2) + 1
    else:
        ret = leng(3*num + 1) + 1
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

def main():
    print(run(100)) 
if __name__  == '__main__':
    main()