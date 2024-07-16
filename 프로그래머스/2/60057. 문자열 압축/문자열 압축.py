def solution(s):
    #문자열에서 같은 값이 연속해서 나타나는것을 압축
    #s는 1이상 1000이하 1~len(s)//2 까지 압축해보기 -> 그중 압축률이 가장 높은거 찾기
    #연속해서 나온 값찾기
    answer = 0
    length = len(s)
    result_lst = []
    def zip(string, unit):
        #unit 으로 string 자르기 -> 압축시작
        split_s = []
        for i in range(0, length, unit):
            split_s.append(string[i:i+unit])
        cnt = [split_s[0]]
        result = ''
        n_cnt = 1
        for i in range(len(split_s)-1):

            if split_s[i] == split_s[i+1]:
                n_cnt += 1
                if i+1 == len(split_s)-1:
                    result += split_s[i] + str(n_cnt)
            
            else:
                if i+1 == len(split_s)-1:
                    result += split_s[i+1]
                if n_cnt == 1:
                    result += split_s[i]
                else:
                    result += split_s[i] + str(n_cnt)
                n_cnt = 1
            
        result_lst.append(len(result))

            
#         for i in range(1, len(split_s)):
#             if cnt[0] == split_s[i]:
#                 cnt.append(split_s[i])
#                 if i == len(split_s)-1:
#                     result += str(len(cnt)) + cnt[0]
#             elif cnt[0] != split_s[i]:

#                 if len(cnt) == 1:
#                     result += cnt[0]
#                     if i == len(split_s)-1:
#                         result += split_s[i]
#                 else:
#                     result += str(len(cnt)) + cnt[0]
#                 cnt = [split_s[i]]
                
            

#         result_lst.append(len(result))


    if length == 1:
        answer = 1
    else:
        for i in range(1,length//2+1):
            zip(s, i)
        answer = min(result_lst)      
                
    return answer