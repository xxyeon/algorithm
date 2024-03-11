def solution(s):
    #aabbaccc 해서 5개 테스트 통과 근테 틀림
    #aaaaaaaaaaaaaaabbbbbbbbbbc 테스트 케이스 해보고 통과
    #하루 걸림;;;
    #접근 방식: 
    # 무슨 단위로 나눠야 가장 짧게 압축할 수 있는지 처음부터 알지 못하므로 1~최대(문자열 길이) 단위로 모두 나눠서 리스트에 저장.
    # lst[0] 1단위로 나눠진 문자열, lst[1] 2단위로 나눠진 문자열, .. lst[len(s)-1] len(s) 단위로 나눠진 문자열
    #lst에 각 단위로 나눠진 문자를 저장했으므로 문자열 압축할 차례
    # lst[0].pop해서 잘라진 문자와 같으면 cnt하나씩 늘려서 같은 문자 수 세기(pop이 뒤에서 부터 나오는데 어차피 자를때 앞에서 부터 잘라서 pop해도 상관없음)
    # count 리스트에 압축한 문자 저장 (count[0] 1단위로 압축한 문자 (aabbaccc인 경우 ['3c', 'a', 2b', '2a']이런식으로 저장됨.)) -> 비교 대상과 같으면 cnt 늘리고 pop.. 대상과 같으면 cnt 늘리고 pop... 반복, 다르면 cnt와 비교대상 count 에 저장)
    # count 리스트에 저장할 때 예외 케이스 잘 작성해야함. (while 시작 할 때 lst[단위] 의 첫번째 인덱스 값을 비교 대상으로 놓고 for 문에서 pop을 하면서 비교 대상을 계속 바꿈) -> 중간중간 print해서 예외 작성함.
        # 비교 대상과 다를때 예외
            # 1. cnt==1일 때 1a이런식으로 저장하지 않으므로 cnt 가 1인 경우 알파벳만 저장 (ex. lst['c','c','c','a','b','b','a','a] 에서 c, c검사하고 lst[2] (start = c)가 비교 대상이고 a (v = a)와 비교할 때  start 까지 cnt 증가하고 count 리스트에 저장하고 cnt = 1로 변경하고 start = a로 변경. start = a로 변경되고 pop해서 v = b와 비교하는데 cnt == 1인 상태 그럼 count에 1빼고 a만 저장..)
        # 공통 예외 (비교대상같을 때 다를 때)
            # 1. 리스트 마지막 요소남을 때 그것도 count 리스트에 포함 시켜야함. lst.pop하면서 lst 가 줄어드는데['c','c','c','a','b','b','a','a] 에서 pop해서 ['b','a','a'] 만 남은 상황start = b가 되고 v = a 하면 비교 대상이 다른 쪽으로 가서 start = a로 바뀌고 pop해서 v = a로 바뀜. 그럼 비교 대상이 같은 블록으로 가게 되고 cnt가 늘어남 근데 cnt만 들어남. 근데 여기서 다시 while로 돌아가면 반복문이 끝나서 a를 count에 넣지 못함. 그래서 v = lst.pop하고 lst의 길이가 0이면 count에append되도록
    answer = 0
    plus = 1
    lst = []
    count = [[] for i in range(len(s))]
    
    #각 단위로 나눈 문자 저장하는 과정
    while plus != len(s):
        chunk = [] #1, 2, 3, ... len(s) 단위로 자른거 저장하는 리스트
        for k in range(0, len(s), plus):
            chunk.append(s[k:k+plus])
        lst.append(chunk)
        plus += 1
    
    copyLst = [[] for i in range(len(lst))] #숫자와 알파벳 합친 문자열 저장하기 위한 리스트
    idx = 0
    for i in range(len(lst)):
        start = lst[i].pop()
        cnt = 1
        while lst[i]:
            v = lst[i].pop()
            if start == v: #비교대상 동일 할 때
                cnt += 1
                if len(lst[i]) < 1: # 테스트 실패 후 2에서 1로 변경 ['a', 'a'] 인 상황에서 이 예외가 있어야 2a가 들어감.
                    count[idx].append(str(cnt) + start)
            else: #비교대상 다를때
                if cnt == 1: # ['a','b','a'] 인 상황에서 1로 압축된거 알파벳만 넣어주고 비교대상 다음 꺼로 변경
                    count[idx].append(start)
                    start = v
                else: # cnt가 1이 아닐 때 압축한거 저장(3c) 하고 비교 대상 바꾸고 cnt = 1초기화
                    count[idx].append(str(cnt) + start)
                    start = v
                    cnt = 1
                if len(lst[i]) < 1: # 테스트 실패 후 2에서 1로 변경 ['a','b'] 일때 start = b, v = a인 상황 start는 if..else 문에서 저장이 되고 v는 여기서 저장이 된다.
                    count[idx].append(v)
        copyLst[i].append(''.join(count[idx]))
        idx += 1
    min = len(s)
    #여기는 압축된 문자 뭐가 제일 짧은지 비교해서 min 찾아내는 부분
    for i in range(len(copyLst)):
        string = ''.join(copyLst[i])
        if min > len(string):
            min = len(string)
    answer = min
    return answer