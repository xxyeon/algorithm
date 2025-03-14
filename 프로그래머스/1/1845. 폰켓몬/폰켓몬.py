def solution(nums):
    answer = 0
    kind = len(set(nums))
    porketmon = len(nums)
    
    if kind >= porketmon//2:
        answer = porketmon//2
    else:
        answer = kind
    return answer