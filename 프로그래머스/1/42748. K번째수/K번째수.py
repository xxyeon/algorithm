def solution(array, commands):
    answer = []
    for i, j, k in commands:
        slice_arr = array[i-1:j]
        slice_arr.sort()
        answer.append(slice_arr[k-1])
    return answer