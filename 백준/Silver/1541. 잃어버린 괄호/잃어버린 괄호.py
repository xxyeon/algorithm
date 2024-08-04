#잃어버린 괄호
#값의 최소...
#-가 가장 크도록 해야함.
#모두 같은 연산이면 상관없음 
#-시작부터 -끝가지.. -1+2+3+4-5+4-3-5이면
lst = input().split('-')


sum_num = 0
minus = 0
num = ''
data = []

for string in lst: 
  # if len(lst) == 1: #모두 +만 있다면
  #   n = list(map(int, lst[0].split('+')))
  #   minus = sum(n)
  #   break
  if '+' not in string:
    data.append(int(string))
    continue
  for j in range(len(string)):
    if string[j].isnumeric():
      num += string[j]
    if j == len(string)-1 or string[j].isnumeric() == False:
      sum_num += int(num)
      num = ''
  data.append(sum_num)
  sum_num = 0

minus = data[0]

for i in range(1, len(data)):
  minus -= data[i]
print(minus)
