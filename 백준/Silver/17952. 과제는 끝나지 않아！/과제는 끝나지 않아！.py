#최근에 나온 순서대로..스택
#스택에 과제를 넣고, pop해서 해결, 해결하다가 새로운 과제가 나온다? 해결 못하면 다시 스택에 넣고 새로운 과제 해결
#t는 학기 반복문이 돌아가면서 줄어들게
n = int(input())
a = []
def isProblem(p): #과제가 주어지는지 아닌지 확인
  if p == 1:
    return True
  else:
    return False


#초기 과제 추가
p = list(map(int, input().split()))

score, t = 0, 0
if isProblem(p[0]):
  #과제가 있다면
  score, t = p[1], p[2]-1 #과제를 받자마자 시작
  

#과제 정보 저장하는 과정
total_score = 0
for i in range(n-1):
  p = list(map(int, input().split()))
  if isProblem(p[0]):
    #과제가 있다면 기존 과제 a에 넣고 score와 t 변경
    a.append((score, t))
    score, t = p[1], p[2]-1
  else:
    t -= 1
  if t == 0:
    total_score += score #기존 과제 다 끝냈으면

    if len(a) >= 1:
      score, t = a.pop() #다음 과제 시작
  

print(total_score)