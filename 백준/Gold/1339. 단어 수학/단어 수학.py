n = int(input())
#먼저 각각 알바펫의 자릴수를 알아내야한다.
lst = [0 for _ in range(10)] #최대 10개의 알파벳
dict = {}
for _ in range(n):
  a = input()
  length = len(a)
  for i in range(length):
    if a[i] not in dict:
      dict[a[i]] = 10 ** (length-1)
    else:
      dict[a[i]] += 10 ** (length-1)
    length -= 1

dict = sorted(dict.items(), key=lambda x:x[1], reverse=True)
result = 0

num = 9
for a, n in dict:
  result += n * num
  num -= 1
print(result)