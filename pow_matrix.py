# 백준 10830번 행렬 제곱
import sys
input = sys.stdin.readline

N, B = map(int,input().split())

matrix = []
result = []
for _ in range(N):
    row = list(map(int,input().split()))
    matrix.append(row)
    result.append(row)

for _ in range(B):
    # 행렬 곱
    for i in range(N):
        for j in range(N):
            for k in range(N):
                matrix[i][j] += (matrix[i][k]* result[k][j])%1000

print(matrix)