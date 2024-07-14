def solution(survey, choices):
    answer = ''
    #성격유형점수 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격유형이라고 판단(동일하면 사전순)
    #4번지표로 (어피치형, 네오형) -> survey에 나온 지표(RT,CF, JM, AN)
    # choice-> 질문마다 선택한 선택지를담음
    # survey[i]의 첫번째 -> i+1의 비동의 관련 선택지를 선택하면 받는 성격유형 choice[i+1]의 비동의
    # A -> choice[1]:3약간 비동의
    # c -> choice[2]:2
    # m -> chioc[3]:7
    # a -> choice[4]:5: 약간동의
    #각 지표마다 배열을 만들어서 choice에 나오는 대로 지표에 맞게 수를 더해줌
    # choice지표 초기화
    # 성격 유형 별로 배열 초기화
    # kind_a = [(), ("R", "T"), ("C", "F"), ("J", "M"), ("A", "N")]
    kind_a = {"R":0, "T":0,"C":0,"F":0,"J":0,"M":0,"A":0,"N":0}
    score = {1:3, 2:2, 3:1, 4:0, 5:1, 6:2, 7:3}
    # print(kind_a)
    # score = [[0,0]] * (len(choices) + 1)
    # score = [] # 각 성격 지표 점수score[i][0] : i번째 0번(R) 성격 점수
    # for _ in range(len(choices)+1):
    #     score.append([0,0])
    choice = [0,1,2,3,4,5,6,7]

    for k, c in zip(survey, choices):
        idx = choice.index(c)
        # #idx가1~3이면 비동의 k[0]증가(score[0] 증가)
        if 1<= idx <= 3:
            score_idx = 0
        elif 5<=idx<=7:
            score_idx = 1
        else:
            continue
        #c가동의인지 아닌지 확인하고 c가 동의이면 k에서 [1]인 성격증가, 아ㅣㄴ면 c가 비동의이면 k에서 [0]성격 증가하고

            #c가 choice의 비동인인 동의인지
            #score_idx=0이면 비동의
            #k[0]비동의 성격 유형
        kind_a[k[score_idx]] += score[c]
            # if "R" in k:
            #     #RT이면 k.find("R") = 0 score[1][0]: 비동의
            #     score[1][k.find("R")] += c
            # elif "T" in k:
            #     score[1][k.find("T")] += c


 

    lst = [("R", "T"), ("C","F"), ("J", "M"), ("A", "N")]
    for i in lst:
        if kind_a[i[0]] < kind_a[i[1]]:
            answer += i[1]
        elif kind_a[i[0]] > kind_a[i[1]]:
            answer += i[0]
        else:
            answer += i[0]
        
    return answer