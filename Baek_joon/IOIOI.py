# 백준 5525번 IOIOI
N = int(input())
M = int(input())
S = input()

P = 'I' + 'OI' * N
result = 0

for i in range(M - (N * 2 + 1)):    
    cnt = 0
    if S[i] == 'I' and S[i + N * 2] == 'I':
        for j in range(N * 2 + 1):
            if S[i + j] != P[j]:
                cnt = 1
                break

        if cnt == 0:
            result += 1

print(result)