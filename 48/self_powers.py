def main():
    mod = 10**10
    ans = sum(i**i % mod for i in range(1, 1001)) % mod
    print(ans)

if __name__  == '__main__':
    main()