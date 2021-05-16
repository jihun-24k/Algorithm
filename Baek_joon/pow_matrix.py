# 백준 10830번 행렬 제곱
import sys
input = sys.stdin.readline

N, B = map(int,input().split())

matrix = []
for _ in range(N):
    row = list(map(int,input().split()))
    matrix.append(row)

def pow_matrix(b):    
    # 정복: 제곱일 때 행렬의 곱
    if b == 1:
        for i in range(N):
            for j in range(N):
                matrix[i][j] = matrix[i][j]%1000
        return matrix
    else:
        # B승이 짝수일 때 분할
        if b % 2 == 0:
            result = [[0 for _ in range(N)] for _ in range(N)]
            temp = pow_matrix(b//2)
            for i in range(N):
                for j in range(N):
                    value = 0
                    for k in range(N):
                        value += temp[i][k]*temp[k][j]
                    result[i][j] = value%1000
            return result
        
        # B승이 홀수일 때 분할
        if b % 2 == 1:
            result = [[0 for _ in range(N)] for _ in range(N)]
            # 짝수승 행렬을 재귀
            temp = pow_matrix(b - 1)
            for i in range(N):
                for j in range(N):
                    value = 0
                    for k in range(N):
                        value += temp[i][k]*matrix[k][j]
                    result[i][j] = value%1000
            return result

result = pow_matrix(B)

for i in result:
    for j in i:
        print(j,end = " ")
    print()    