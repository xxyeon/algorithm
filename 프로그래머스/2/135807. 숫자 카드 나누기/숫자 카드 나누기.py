import math

def solution(arrayA, arrayB):
    answer = []
    #가장큰 양의 정수 a
    #1. arrayA에서 작은거 기준으로 a, b 나눠보고 조건확인
    #2. arrayAB에서 작은거 기준으로 a, b나눠보고 조건확인
 
    #먼저 arrayA를 다 나눌수 있는 수 찾기
    num_a, num_b = arrayA[0], arrayB[0]
    for a, b in zip(arrayA[1:], arrayB[1:]):
        num_a, num_b = math.gcd(a, num_a), math.gcd(b, num_b)


    
    result = True

    #a_num으로는 B, b_num으로는 A 나눌 수 없는지검사
#     for i, j in zip(arrayA, arrayB):

#         if i % num_b == 0 and j % num_a == 0:#조건 불만족
#             result = False
#             break
    result = True
    for i in arrayA:
        if i % num_b == 0:
            result = False
            break
    if result != False:
        answer.append(num_b)
    
    result = True
    for i in arrayB:
        if i % num_a == 0:
            result = False

    
    if result != False:
        answer.append(num_a)

    if len(answer) == 0:
        answer = 0
    else:
        answer = max(answer)
   


    return answer