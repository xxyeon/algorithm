#큰 수의 법칙

# M의 크기가 100억 이상처럼 커진다면 시간 초과 판정
n, m, k = map(int, input().split())
lst = list(map(int, input().split()))

lst.sort()
first_max = lst[n-1]
secound_max = lst[n-2]

count = 0
sum = 0

while m != False:
  if count == k:
    sum += secound_max
    count = 0
    m -= 1
  else:
    sum += first_max
    count += 1
    m -= 1
  
  
print(sum)

""" 
풀이는 했지만 M의 크기가 100억 이상 커진다면 시간 초과 판정

연속으로 더할 수 있는 횟수는 최대 k번이므로 가장 큰수를 k번 더하고 두 번째로 큰 수를 한 번 더하는 연산을 반복하면 된다.
수열 이용
 """