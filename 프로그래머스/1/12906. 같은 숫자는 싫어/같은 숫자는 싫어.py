def solution(arr):
    answer = []
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    #스택에 넣고 이미 있는 수는 다시 빼기
    for i in arr:
        if not answer:
            answer.append(i)
        else:
            if i != answer[-1]:
                answer.append(i)
    return answer