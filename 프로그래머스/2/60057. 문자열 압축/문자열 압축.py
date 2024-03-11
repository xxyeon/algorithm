def solution(s):
    answer = 0
    plus = 1
    lst = []
    count = [[] for i in range(len(s))]
    
    while plus != len(s):
        chunk = []
        for k in range(0, len(s), plus):
            chunk.append(s[k:k+plus])
        lst.append(chunk)
        plus += 1
    copyLst = [[] for i in range(len(lst))]
    idx = 0
    for i in range(len(lst)):
        start = lst[i].pop()
        cnt = 1
        while lst[i]:
            v = lst[i].pop()
            if start == v:
                cnt += 1
                if len(lst[i]) < 1:
                    count[idx].append(str(cnt) + start)
            else:
                if cnt == 1:
                    count[idx].append(start)
                    start = v
                else:
                    count[idx].append(str(cnt) + start)
                    start = v
                    cnt = 1
                if len(lst[i]) < 1:
                    count[idx].append(v)
        copyLst[i].append(''.join(count[idx]))
        idx += 1
    min = len(s)
    for i in range(len(copyLst)):
        string = ''.join(copyLst[i])
        if min > len(string):
            min = len(string)
    answer = min
    return answer