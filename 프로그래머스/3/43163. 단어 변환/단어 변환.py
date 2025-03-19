from collections import deque
def solution(begin, target, words):
    answer = 0
    #최소 몇단계에 거쳐서 target이 만들어지나?
    #한번에 한개의 알파벳만 바꿀 수 있다. 모든 단어 길이가 같고(3~10), 중복되는 단어는 없다.
    #모든 단어를 거쳐보면서..? 정렬하면 될듯
    word_dict = {}
    words.append(begin)
    for w in words:
        word_dict[w] = []
        for word in words:
            diff = 0
            for alpha1, alpha2 in zip(w, word):
                if alpha1 != alpha2:
                    diff += 1
            if diff == 1:
                word_dict[w].append(word)
    if target not in words:
        return 0
    answer = bfs(begin, target, word_dict, words)
    return answer
def bfs(begin, target, word_dict, words):
    
    visited = [False for _ in range(len(words))]
    q = deque([])
    q.append((begin, 0))
    while q:    
        word, cnt = q.popleft()
        visited[words.index(word)] = True
        if word == target:
            return cnt
        for nw in word_dict[word]:
        #     if target == nw:
        #         return cnt
            if not visited[words.index(nw)]:
                q.append((nw, cnt + 1))
            
        
        
        
        