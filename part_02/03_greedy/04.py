# N == 1
n, k = map(int, input().split())
# k가 자연수이므로 나누는게 수가 많이 줄어들으므로 최대한 나눗셈 활용
count = 0
while n != 1:
  if n % k == 0:
    n = int(n / k)
    count += 1
  else:
    n -= 1
    count += 1
print(count)

""" 
문제 해결 아이디어 활용 성공
k로 최대한 많이 나눌 수 있도록 하는것이 최적의 해를 보장
n이 커지면 빠르게 동작하기 어려움 -> 한번에 k의 배수가 되도록 빼버리자
"""