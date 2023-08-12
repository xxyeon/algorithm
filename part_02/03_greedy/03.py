rows, cols = map(int, input().split())
arr = [list(map(int, input().split()))for _ in range (rows)]

# 각 행에서 최소끼리 비교해서 큰 거 출력
for i in range(rows):
  arr[i].sort()
  
max = 0
for i in range(rows):
  if max < arr[i][0]:
    max = arr[i][0]
print(max)

""" 
문제 해결을 위한 아이디어 활용 성공

문제에 나오는 과정을 그대로 따라하려고 하지 말자. 
    카드 배열을 만들기 위해 굳이 arr에서 반복문을 사용하지 않아도 됨

min, max 함수 이용
    파이썬 내장함수 익히자
    내장함수 참고 https://docs.python.org/ko/3/library/functions.html 
"""