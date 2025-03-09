#모든 명함 수납 가능 하지만 지갑크기 가장 작게
#모든 명함 가로, 세로 구분안하고 정렬(가로, 세로 하나의 요소로 보고 리스트에 정렬) / 하나의 요소는 긴 길이 순으로 정렬
#긴 길이 순으로 리스트에서 제외

def solution(sizes):
    answer = 0
    for i in range(len(sizes)):
        sizes[i].sort(reverse=True)
    sizes.sort(reverse=True, key=lambda x:[x[0], -x[1]])
    
    
    if len(sizes) > 1: 
        #작은것들 중에서 큰것
        num1 = sizes.pop(0)
        for i in range(len(sizes)):
            sizes[i].sort()
        sizes.sort(reverse=True)

        num2 = sizes.pop(0) 

        answer = num1[0] * num2[0]
    else:
        answer = sizes[0][0] * sizes[0][1]
            
    
    return answer