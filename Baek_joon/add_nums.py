# 백준 11720번 숫자의 합
N = int(input())
string = input()
result = 0

for i in range(N):
    result += int(string[i])
print(result)