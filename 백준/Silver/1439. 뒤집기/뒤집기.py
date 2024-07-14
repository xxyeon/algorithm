#최소 횟수 -> 그리디
# 0과 1의 연속된 문자열의 수를 세서 적은 수가 답
#0001100101 이라면 010101이라고 생각할 수 있음.
s = input()
zero = s.split('1')
one = s.split('0')
cnt_one = 0
cnt_zero = 0
for i in zero:
  if i != '':
    cnt_zero += 1

for i in one:
  if i != '':
    cnt_one += 1
print(min(cnt_one, cnt_zero))