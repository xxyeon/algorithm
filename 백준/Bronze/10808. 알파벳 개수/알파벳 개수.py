s = input()
#알파벳 소문자 97 ~122
lst = [0] * 26
for i in s:
  lst[ord(i)-97] += 1
print(*lst)