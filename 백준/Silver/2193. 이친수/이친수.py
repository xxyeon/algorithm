n = int(input())
pinary_cnt = [0] * (n+1) # i 자리 이친수의 개수 저장하는 리스트

if n < 3:
    print(1)
else:
    pinary_cnt[1] = 1
    pinary_cnt[2] = 1
    for i in range(3, n+1):
        pinary_cnt[i] = pinary_cnt[i-1] + pinary_cnt[i-2]
    print(pinary_cnt[n])