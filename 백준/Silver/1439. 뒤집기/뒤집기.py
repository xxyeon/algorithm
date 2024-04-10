import sys
s = sys.stdin.readline()

lst = [s[0]]
for i in range(len(s)-1):
  if s[i] != s[i+1]:
    lst.append(s[i+1])
print(lst.count("1")) if(lst.count("0") > lst.count("1")) else print(lst.count("0"))