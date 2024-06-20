#선택정렬
def selection_sort(array):
  for i in range(len(array)-1):
    min_idx = i
    for j in range(i+1, len(array)):
      if array[min_idx] > array[j]:
        min_idx = j
    array[min_idx], array[i] = array[i], array[min_idx]
