n = int(input())

array = []
for i in range(n):
  name, score = input().split()
  array.append([name, int(score)])

def setting(data):
  return data[1]

result = sorted(array, key=setting)
for i in range(n):
  print(result[i][0], end =' ')

#학생 이름과 성적을 튜플로 
'''
input_data = input().split() #학생 이름, 성적 입력
array.append((input_data[0], input_data[1]))
'''

#lambda 매개변수 : 표현식
'''
def hap(x, y):
   return x + y

(lambda x,y: x + y)(10, 20)
'''