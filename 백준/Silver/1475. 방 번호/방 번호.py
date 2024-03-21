from collections import Counter

#필요한 세트의 개수의 최소. 9,6뒤집어서 사용가능
n = list(input())

#같은 수 n개나오면 n세트 필요(9,6예외)
#9999 -> 2개 6969 -> 2개 6666 -> 2 
#1. 동일한 수의 개수가 가장 큰걸 찾아냄 ex) 2222221 이면 2의 개수, 12234444이면 4의 개수 -> 최빈값 찾기
# 999222이면 3세트 필요 999 -> 2개 (3//2=1+1)9999 -> 2개 (4//2 = 2 + 0)99999-> 3개 (5//2 = 2 + 1)
#보편화하면 (6or9개수) // 2 + (6or9개수) %2

new_n = [value for value in n if value not in {'6', '9'}]

#statistics.mode() 안되는 이유?
cnt = Counter(new_n)
cnt = cnt.most_common(1)

six = n.count('6')
nine = n.count('9')
sixOrNine = (six + nine) // 2 + (six + nine) % 2
if cnt:
  cnt = cnt[0][1]
  if cnt > sixOrNine:
    print(cnt)
  else:
    print(sixOrNine)
else:
  print(sixOrNine)