#두 문자에 같은 문자 빼고 다 제거
#완전 탐색 가능n=1000 자를 넘지 않음
import sys
s1 = sys.stdin.readline().rstrip()
s2 = sys.stdin.readline().rstrip()
s1_set = s1
s1_set = set(s1_set)

#s1을 기준으로 검사
cnt = 0
s1_cnt = 0
s2_cnt = 0
for i in s1_set:
  if i in s2: #s1과 s2에 같은게 있으면 cnt증가 -> 같은 문자수가 몇개인지 확인하는 작업
    if s1.count(i) > s2.count(i):
      s1_cnt +=  s2.count(i)
      s2_cnt += s2.count(i)
    elif s1.count(i) < s2.count(i):
      s2_cnt += s1.count(i)
      s1_cnt += s1.count(i)
    else:
      cnt += s1.count(i)

print(len(s1) - (cnt+s1_cnt) + len(s2) - (cnt+s2_cnt))
