def solution(food_times, k):
    answer = 0
    k -= len(food_times)
    while k != 0:
        for i in range(len(food_times)):
            if food_times[i] == 1:
                continue
            food_times[i] -= 1
            answer = i
            k -= 1
            
            if answer == len(food_times)-1:
                answer = 1
            elif sum(food_times) == 0:
                answer = -1
            else:
                answer += 1
    return answer

'''
정확성: 4.0
효율성: 0
합계: 4.0 / 100.0
'''